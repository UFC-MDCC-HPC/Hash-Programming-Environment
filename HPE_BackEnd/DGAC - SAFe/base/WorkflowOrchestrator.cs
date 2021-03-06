using System.Collections.Generic;
using System.Threading;
using System;
using System.Diagnostics;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.mdcc.hpcshelf.core;
using static br.ufc.pargo.hpe.kinds.TaskBinding;

namespace br.ufc.pargo.hpe.kinds
{
	public interface SWLVisitor<T>
	{
		T visit(SWLWorkflowSkip<T>         node);
		T visit(SWLWorkflowBreak<T>        node);
		T visit(SWLWorkflowContinue<T>     node);
		T visit(SWLWorkflowNewSemaphore<T> node);
		T visit(SWLWorkflowPSemaphore<T>   node);
		T visit(SWLWorkflowVSemaphore<T>   node);
		T visit(SWLWorkflowStart<T>        node);
		T visit(SWLWorkflowWait<T>         node);
		T visit(SWLWorkflowCancel<T>       node);
		T visit(SWLWorkflowInvoke<T>       node);
		T visit(SWLWorkflowSequence<T>     node);
		T visit(SWLWorkflowParallel<T>     node);
		T visit(SWLWorkflowChoice<T>       node);
		T visit(SWLWorkflowIterate<T>      node);
	}
		
	public class SWLVisitorOrchestrate : SWLVisitor<bool>
	{
		private gov.cca.Services services;
		int workflow_handle;
		private ICoreServices core_services;

		public SWLVisitorOrchestrate(gov.cca.Services services, int workflow_handle, ICoreServices core_services)
		{
			this.services = services;
			this.workflow_handle = workflow_handle;
			this.core_services = core_services;
		}

		public bool visit(SWLWorkflowSkip<bool> node)
		{
            Console.WriteLine("SKIP");

			// DO NOTHING;
			return true;
		}

		public bool visit(SWLWorkflowBreak<bool> node)
		{
			Console.WriteLine("BREAK");
			throw new SWLBreakException ();
		}

		public bool visit(SWLWorkflowContinue<bool> node)
		{
			Console.WriteLine("CONTINUE");
			throw new SWLContinueException ();
		}

		private IDictionary<string, Semaphore> dict_semaphore = new Dictionary<string, Semaphore>();

		public bool visit(SWLWorkflowNewSemaphore<bool> node)
		{
			Console.WriteLine("NEW SEMAPHORE");
			Semaphore s = new Semaphore (node.init, int.MaxValue);
			dict_semaphore [node.sem_id] = s;
			return true;
		}

		public bool visit(SWLWorkflowPSemaphore<bool> node)
		{
			Console.WriteLine("SEMAPHORE P");
			Semaphore s = dict_semaphore [node.sem_id];
			s.WaitOne ();
			return true;
		}

		public bool visit(SWLWorkflowVSemaphore<bool> node)
		{
			Console.WriteLine("SEMAPHORE V");
			Semaphore s = dict_semaphore [node.sem_id];
			s.Release ();
			return true;
		}

		private IDictionary<string, IActionFuture> dict_async_invocations = new Dictionary<string, IActionFuture> ();

		public bool visit(SWLWorkflowStart<bool> node)
		{
			string port_name = node.port_name;
			string action_name = node.action_name;
			string handle = node.handle;

            Console.WriteLine("START port_name={0} action_name={1} handle={2}", port_name, action_name, handle);

			ITaskBindingKind action_port = port (port_name);

			IActionFuture future_handle;
			action_port.invoke (action_name, out future_handle);

			if (handle != null)
				dict_async_invocations[handle] = future_handle;

			return true;
		}

		public bool visit(SWLWorkflowWait<bool> node)
		{
            Console.WriteLine("WAIT handle={0}", node.handle);

			dict_async_invocations [node.handle].wait();

			return true;
		}

		public bool visit(SWLWorkflowCancel<bool> node)
		{
			Console.WriteLine("CANCEL handle={0}", node.handle);
			//dict_async_invocations [node.handle].cancel();
			return true;
		}

		public bool visit(SWLWorkflowInvoke<bool> node)
		{
			string port_name = node.port_name;
			string action_name = node.action_name;

			Console.WriteLine("BEGIN INVOKE port_name={0} action_name={1}", port_name, action_name);


			switch (action_name) 
			{
				case Constants.LIFECYCLE_RESOLVE:
					perform_resolve (port_name);
					break;
				case Constants.LIFECYCLE_CERTIFY:
					try_certify (port_name);
					break;
				case Constants.LIFECYCLE_DEPLOY:
					perform_deploy (port_name);
					break;
				case Constants.LIFECYCLE_INSTANTIATE:
					perform_instantiate (port_name);
					break;
				case Constants.LIFECYCLE_RUN:
					perform_run(port_name);
					break;
				default:
					ITaskBindingKind action_port = port(port_name);
					action_port.invoke (action_name);
				    break;
			}

			Console.WriteLine("END INVOKE port_name={0} action_name={1}", port_name, action_name);

			return true;
		}

		private void perform_resolve(string instance_name)
		{
            Console.WriteLine("resolve " + (core_services ==null));
			core_services.resolve (this.workflow_handle, instance_name);	
		}

		private void try_certify(string instance_name)
		{
			// CERTIFICATION PROTOCOL: TODO !!!
		}

		private void perform_deploy(string instance_name)
		{
			Console.WriteLine("deploy");
			core_services.deploy (this.workflow_handle, instance_name);	
		}

		private void perform_instantiate(string instance_name)
		{
			Console.WriteLine("instantiate");
			core_services.instantiate (this.workflow_handle, instance_name);
   		}

        private void perform_run(string instance_name)
        {
            Thread t = new Thread(new ThreadStart(delegate
		    {
		        Console.WriteLine("run !!!");
		        core_services.run(this.workflow_handle, instance_name);
		    }));
			t.Start();
		}


		public bool visit(SWLWorkflowSequence<bool> node)
		{
			Console.WriteLine ("SEQUENCE {0}", node.action_list.Length);

			bool result = true;

			foreach (SWLWorkflow<bool> action in node.action_list)
				result = result && action.accept (this);

			return true;
		}

		public bool visit(SWLWorkflowParallel<bool> node)
		{
			Console.WriteLine ("PARALLEL {0}", node.action_list.Length);

			IList<Thread> t_list = new List<Thread> ();

			foreach (SWLWorkflow<bool> action in node.action_list)
				t_list.Add (new Thread( new ThreadStart( delegate() { action.accept (this); })));  

			foreach (Thread t in t_list)
				t.Start ();

			foreach (Thread t in t_list)
				t.Join ();		

			return true;
		}

		public bool visit(SWLWorkflowChoice<bool> node)
		{
			IActionFutureSet future_list = null;
			IDictionary<IActionFuture, SWLWorkflow<bool>> dict_action_alt = new Dictionary<IActionFuture, SWLWorkflow<bool>> ();

            Console.WriteLine("CHOICE {0}", dict_action_alt.Count);

            for (int i = 0; i < node.action_list.Length; i++) 
			{
				string port_name = node.guard_list [i].Item1;
				string action_name = node.guard_list [i].Item2;

				ITaskBindingKind action_port = port (port_name);
				IActionFuture future_handle;
				action_port.invoke (action_name, out future_handle);	
				if (future_list == null)
					future_list = future_handle.createSet ();
				else
					future_list.addAction (future_handle);

				dict_action_alt [future_handle] = node.action_list [i];
			}

			IActionFuture ready_action = future_list.waitAny ();

			dict_action_alt [ready_action].accept (this);

			return true;
		}

		public bool visit(SWLWorkflowIterate<bool> node)
		{
            // TODO: Take "node.until_clause" into consideration

			Console.WriteLine ("ITERATE");

			Debug.Assert(node!=null); Console.WriteLine(node!=null);
			Debug.Assert(node.iterate_action!=null); Console.WriteLine(node.iterate_action!=null);

			bool breaking_flag = false;

            while (!Terminate(node) && !breaking_flag) 
			{
				try 
				{
				   node.iterate_action.accept (this);
				}
				catch (SWLContinueException e) 
				{
					// DO NOTHING ! Proceed to the next iteration.
				}
				catch (SWLBreakException e) 
				{
					breaking_flag = true;
				}
				catch (Exception e) 
				{
                    Console.WriteLine(e.Message);
                    Console.WriteLine(e.StackTrace);
                    if (e.InnerException != null)
                    {
                        Console.WriteLine(e.InnerException.Message);
                        Console.WriteLine(e.InnerException.StackTrace);
                    }
					throw e;
				}
			}

			return true;
		}

        private bool Terminate (SWLWorkflowIterate<bool> node)
        {
            if (node.exit_clause == null && node.enter_clause == null)
                return false;

            Console.WriteLine("TERMINATE 1");

			IActionFutureSet fs = new ActionFutureSet();
			IActionFuture[] future_list = new IActionFuture[node.exit_clause.Length];
			string[] enter_action_list = new string[node.exit_clause.Length];
			string[] exit_action_list = new string[node.exit_clause.Length];

			for (int i = 0; i < node.exit_clause.Length; i++)
			{
                Console.WriteLine("TERMINATE 2 {0}", i);

                string exit_action = node.exit_clause[i].action;
				string exit_port = node.exit_clause[i].id_port;

				string enter_action = node.enter_clause[i].action;
				string enter_port = node.enter_clause[i].id_port;

                Console.WriteLine("TERMINATE 3 {0} / {1}.{2} -- {3}.{4}", i, exit_port, exit_action, enter_port, enter_action);

                // It is supposed that both exit and enter action ports are the same;
				ITaskBindingKind action_port_exit = port(exit_port);
				ITaskBindingKind action_port_enter = port(enter_port);

				Debug.Assert(action_port_exit == action_port_enter, "ITERATION: EXIT and ENTER action ports are distinct ! Check !");

                Console.WriteLine("TERMINATE 4 {0} {1}", action_port_exit == null, action_port_enter == null);

                IActionFuture f;
				action_port_enter.invoke(new string[2] { exit_action, enter_action }, out f);
				fs.addAction(f);

                Console.WriteLine("TERMINATE 5 {0}", i);

				future_list[i] = f;
				enter_action_list[i] = enter_action;
				exit_action_list[i] = exit_action;
			}

			Console.WriteLine("TERMINATE 6 -- BEFORE WAIT ALL");
			fs.waitAll();
			Console.WriteLine("TERMINATE 7 -- AFTER WAIT ALL");

			int end_iteration = 0; //unknown=0; enter=1; exit=2

            for (int i = 0; i < future_list.Length; i++)
            {
                string action_result = (string)future_list[i].Action;

                Console.WriteLine("TERMINATE 8 i={0} -- result={1}", i, action_result);
				
                if (action_result.Equals(enter_action_list[i]) && end_iteration == 0)
                    end_iteration = 1;

                else if (action_result.Equals(exit_action_list[i]) && end_iteration == 0)
                    end_iteration = 2;

                else if (action_result.Equals(enter_action_list[i]) && end_iteration == 2)
                    throw new Exception("ITERATE: Conflict in termination clause !");

                else if (action_result.Equals(exit_action_list[i]) && end_iteration == 1)
                    throw new Exception("ITERATE: Conflict in termination clause !");

                Console.WriteLine("TERMINATE 9 i={0} -- end_iteration={1}", i, end_iteration);
			}

            return end_iteration == 2;
        }

		private IDictionary<string, ITaskBindingKind> dict_ports = new Dictionary<string, ITaskBindingKind>(); 

		private ITaskBindingKind port(string port_name)
		{
			ITaskBindingKind port_return;

			if (!dict_ports.TryGetValue (port_name, out port_return)) 
				dict_ports [port_name] = port_return = (ITaskBindingKind) services.getPort (port_name);

			Console.WriteLine ("***** port ---- {0} {1}", port_name, port_return != null);

            port_return.TraceFlag = true; 

			return port_return;
		}

	}

	public class SWLBreakException : Exception
	{		
	}

	public class SWLContinueException : Exception
	{
	}


}
