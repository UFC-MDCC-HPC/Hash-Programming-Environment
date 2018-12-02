using System.Collections.Generic;
using System.Threading;
using System;
using System.Diagnostics;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.mdcc.hpcshelf.core;

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
		private IWorkflowServices core_services;

		public SWLVisitorOrchestrate(gov.cca.Services services, int workflow_handle, IWorkflowServices core_services)
		{
			this.services = services;
			this.workflow_handle = workflow_handle;
			this.core_services = core_services;
		}

		public bool visit(SWLWorkflowSkip<bool> node)
		{
			// DO NOTHING;
			return true;
		}

		public bool visit(SWLWorkflowBreak<bool> node)
		{
			throw new SWLBreakException ();
		}

		public bool visit(SWLWorkflowContinue<bool> node)
		{
			throw new SWLContinueException ();
		}

		private IDictionary<string, Semaphore> dict_semaphore = new Dictionary<string, Semaphore>();

		public bool visit(SWLWorkflowNewSemaphore<bool> node)
		{
			Semaphore s = new Semaphore (node.init, int.MaxValue);
			dict_semaphore [node.sem_id] = s;
			return true;
		}

		public bool visit(SWLWorkflowPSemaphore<bool> node)
		{
			Semaphore s = dict_semaphore [node.sem_id];
			s.WaitOne ();
			return true;
		}

		public bool visit(SWLWorkflowVSemaphore<bool> node)
		{
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

			ITaskBindingKind action_port = port (port_name);

			IActionFuture future_handle;
			action_port.invoke (action_name, out future_handle);

            if (handle != null)
			    dict_async_invocations [handle] = future_handle;

			return true;
		}

		public bool visit(SWLWorkflowWait<bool> node)
		{
			dict_async_invocations [node.handle].wait();
			return true;
		}

		public bool visit(SWLWorkflowCancel<bool> node)
		{
			//dict_async_invocations [node.handle].cancel();
			return true;
		}

		public bool visit(SWLWorkflowInvoke<bool> node)
		{
			string port_name = node.port_name;
			string action_name = node.action_name;

			Console.WriteLine ("BEGIN INVOKE {0} {1}",port_name, action_name);

			ITaskBindingKind action_port = port (port_name);

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
			default:
				action_port.invoke (action_name);
				break;
			}

			Console.WriteLine ("END INVOKE {0} {1}",port_name, action_name);

			return true;
		}

		private void perform_resolve(string instance_name)
		{
			core_services.resolve (this.workflow_handle, instance_name);	
		}

		private void try_certify(string instance_name)
		{
			// CERTIFICATION PROTOCOL: TODO !!!
		}

		private void perform_deploy(string instance_name)
		{
			core_services.deploy (this.workflow_handle, instance_name);	
		}

		private void perform_instantiate(string instance_name)
		{
			core_services.instantiate (this.workflow_handle, instance_name);	
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
			Console.WriteLine ("ITERATE");
			Debug.Assert(node!=null); Console.WriteLine(node!=null);
			Debug.Assert(node.iterate_action!=null); Console.WriteLine(node.iterate_action!=null);

			bool breaking_flag = false;

			while (!breaking_flag) 
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
					throw e;
				}
			}

			return true;
		}

		private IDictionary<string, ITaskBindingKind> dict_ports = new Dictionary<string, ITaskBindingKind>(); 

		private ITaskBindingKind port(string port_name)
		{
			ITaskBindingKind port_return;

			 Console.WriteLine("***** port 1 ---- {0}", port_name);

            if (!dict_ports.TryGetValue (port_name, out port_return)) 
				dict_ports [port_name] = port_return = (ITaskBindingKind) services.getPort (port_name);

			Console.WriteLine ("***** port 2 ---- {0} {1}", port_name, port_return != null);

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
