// /home/jefferson/projetos/appexample/appexample/kinds/SynchronizerKind.cs created with MonoDevelop
// User: jefferson at 13:20 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;
using gov.cca.ports;
using System.Collections.Generic;
using System.Threading;
using SAFeSWL;
using System.Xml.Serialization;
using System.Xml;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.utils;

namespace br.ufc.pargo.hpe.kinds
{

    public interface IWorkflowKind : IActivateKind, GoPort
	{
		string SWLOrchestration { set; }

	}

	public abstract class Workflow : Activate, IWorkflowKind 
	{
	 
		SWLWorkflow<bool> w_tree = null;

		public string SWLOrchestration 
		{ 
			set {
					SAFeSWL_OperationAnyType w = FileUtil.readXML<SAFeSWL_OperationAnyType>(value);
					w_tree = convert_to_abstract_syntax (w);
				} 
		} 

		public override void main()
		{
			w_tree.accept (new SWLVisitorOrchestrate (this.Services));
		}

		private SWLWorkflow<bool> convert_to_abstract_syntax(SAFeSWL_OperationAnyType workflow)
		{
			return traverse (workflow);
		}

		public const string SWL_TAG_SPLIT = "skip";
		public const string SWL_TAG_BREAK = "break";
		public const string SWL_TAG_CONTINUE = "continue";
		public const string SWL_TAG_START = "start";
		public const string SWL_TAG_WAIT = "wait";
		public const string SWL_TAG_CANCEL = "cancel";
		public const string SWL_TAG_INVOKE = "invoke";
		public const string SWL_TAG_SEQUENCE = "sequence";
		public const string SWL_TAG_PARALLEL = "parallel";
		public const string SWL_TAG_CHOICE = "choice";
		public const string SWL_TAG_ITERATE = "iterate";

		private SWLWorkflow<bool> traverse(SAFeSWL_OperationAnyType workflow)
		{
			if (workflow.Item is SAFeSWL_OperationPrimitiveType) 
			{
				if (workflow.ItemElementName.Equals (SWL_TAG_SPLIT)) 
				{
					return new SWLWorkflowSkip<bool>();
				}
				else if (workflow.ItemElementName.Equals (SWL_TAG_BREAK)) 
				{
					return new SWLWorkflowBreak<bool> ();
				}
				else if (workflow.ItemElementName.Equals (SWL_TAG_CONTINUE)) 
				{
					return new SWLWorkflowBreak<bool> ();
				}
				else
					throw new Exception("convert_to_abstract_syntax/traverse: wait/break/continue expected !");
			} 
			else if (workflow.Item is SAFeSWL_OperationPrimitiveInvokeActionAsyncType) 
			{
				if (workflow.ItemElementName.Equals (SWL_TAG_START)) 
				{
					string handle;
					string port_name;
					string action_name;

					new SWLWorkflowStart<bool> (handle, port_name, action_name);
				}
				else if (workflow.ItemElementName.Equals (SWL_TAG_WAIT)) 
				{
				}
				else if (workflow.ItemElementName.Equals (SWL_TAG_CANCEL)) 
				{
				}
				else
					throw new Exception("convert_to_abstract_syntax/traverse: start/wait/cancel expected !");
			} 
			else if (workflow.Item is SAFeSWL_OperationPrimitiveInvokeActionType) 
			{
				if (workflow.ItemElementName.Equals (SWL_TAG_INVOKE)) 
				{
				}
				else
					throw new Exception("convert_to_abstract_syntax/traverse: invoke expected !");
			} 
			else if (workflow.Item is SAFeSWL_OperationManyType) 
			{
				if (workflow.ItemElementName.Equals (SWL_TAG_SEQUENCE)) 
				{
				}
				else if (workflow.ItemElementName.Equals (SWL_TAG_PARALLEL)) 
				{
				}
				else
					throw new Exception("convert_to_abstract_syntax/traverse: sequence/parallel expected !");
			} 
			else if (workflow.Item is SAFeSWL_OperationChoiceType) 
			{
				if (workflow.ItemElementName.Equals (SWL_TAG_CHOICE)) 
				{
				}
				else
					throw new Exception("convert_to_abstract_syntax/traverse: choice expected !");
			} 
			else if (workflow.Item is SAFeSWL_OperationAnyType) 
			{
				if (workflow.ItemElementName.Equals (SWL_TAG_ITERATE)) 
				{
				}
				else
					throw new Exception("convert_to_abstract_syntax/traverse: iterate expected !");
			} 
			else
				throw new Exception ("convert_to_abstract_syntax/traverse: UNRECOGNIZED SAFeSWL constructor.");

		}

	}

	#region WORKFLOW_ABSTRACT_TREE

	public interface SWLWorkflow<T>
	{
		T accept (SWLVisitor<T> visitor);
	}

	public class SWLWorkflowSkip<T> : SWLWorkflow<T>
	{
		public T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit(this);
		}
	}
		
	public class SWLWorkflowBreak<T> : SWLWorkflow<T>
	{
		public T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	public class SWLWorkflowContinue<T> : SWLWorkflow<T>
	{
		public T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	public abstract class SWLWorkflowSemaphore<T> : SWLWorkflow<T>
	{
		public string sem_id;

		public SWLWorkflowSemaphore(string sem_id)
		{
			this.sem_id = sem_id;	
		}

		public abstract T accept (SWLVisitor<T> visitor);
	}

	public class SWLWorkflowNewSemaphore<T> : SWLWorkflowSemaphore<T>
	{
		public int init;

		public SWLWorkflowNewSemaphore(string sem_id, int init) : base(sem_id) 
		{
			this.init = init;
		}

		public override T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	public class SWLWorkflowPSemaphore<T> : SWLWorkflowSemaphore<T>
	{
		public SWLWorkflowPSemaphore(string sem_id) : base(sem_id) { }

		public override T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	public class SWLWorkflowVSemaphore<T> : SWLWorkflowSemaphore<T>
	{

		public SWLWorkflowVSemaphore(string sem_id) : base(sem_id) { }

		public override T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}


	public abstract class SWLWorkflowInvokeAsync<T> : SWLWorkflow<T>
	{
		public string handle;

		public SWLWorkflowInvokeAsync(string handle)
		{
			this.handle = handle;	
		}

		public abstract T accept (SWLVisitor<T> visitor);
	}

	public class SWLWorkflowStart<T> : SWLWorkflowInvokeAsync<T>
	{
		public string action_name;
		public string port_name;

		public SWLWorkflowStart(string handle, string port_name, string action_name) : base(handle)
		{
			this.port_name = port_name;
			this.action_name = action_name;
		}

		public override T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}


	public class SWLWorkflowWait<T> : SWLWorkflowInvokeAsync<T>
	{
		public SWLWorkflowWait (string handle) : base (handle) {}

		public override T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	public class SWLWorkflowCancel<T> : SWLWorkflowInvokeAsync<T>
	{
		public SWLWorkflowCancel (string handle) : base (handle) {}

		public override T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}


	public class SWLWorkflowInvoke<T> : SWLWorkflow<T>
	{
		public string port_name;
		public string action_name;

		public SWLWorkflowInvoke(string action_name, string port_name)
		{
			this.action_name = action_name;	
			this.port_name = port_name;
		}

		public T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	public abstract class SWLWorkflowCombinator<T> : SWLWorkflow<T>
	{
		public SWLWorkflow<T>[] action_list;

		public SWLWorkflowCombinator(SWLWorkflow<T>[] action_list)
		{
			this.action_list = action_list;
		}

		public abstract T accept (SWLVisitor<T> visitor);
	}

	public class SWLWorkflowSequence<T> : SWLWorkflowCombinator<T>
	{
		public SWLWorkflowSequence(SWLWorkflow<T>[] action_list) : base(action_list) {}

		public override T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	public class SWLWorkflowParallel<T> : SWLWorkflowCombinator<T>
	{
		public SWLWorkflowParallel(SWLWorkflow<T>[] action_list) : base(action_list) {}

		public override T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	public class SWLWorkflowChoice<T> : SWLWorkflowCombinator<T>
	{
		public Tuple<string, string>[] guard_list;

		public SWLWorkflowChoice(SWLWorkflow<T>[] action_list, Tuple<string, string>[] guard_list) : base(action_list)
		{
			this.guard_list = guard_list;
		}

		public override T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	public class SWLWorkflowIterate<T> : SWLWorkflow<T>
	{
		public SWLWorkflow<T> iterate_action;
		 
		public SWLWorkflowIterate(SWLWorkflow<T> iterate_action)
		{
			this.iterate_action = iterate_action;
		}

		public T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}

	#endregion WORKFLOW_ABSTRACT_TREE

	#region WORKFLOW_VISITOR


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

		public SWLVisitorOrchestrate(gov.cca.Services services)
		{
			this.services = services;
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

			ITaskBindingKind action_port = port (port_name);

			action_port.invoke (action_name);

			return true;
		}

		public bool visit(SWLWorkflowSequence<bool> node)
		{
			bool result = true;

			foreach (SWLWorkflow<bool> action in node.action_list)
				result = result && action.accept (this);

			return true;
		}

		public bool visit(SWLWorkflowParallel<bool> node)
		{
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

			if (!dict_ports.TryGetValue (port_name, out port_return)) 
				dict_ports [port_name] = (ITaskBindingKind) services.getPort (port_name);

			return port_return;
		}

	}

	public class SWLBreakException : Exception
	{		
	}

	public class SWLContinueException : Exception
	{
	}

	#endregion WORKFLOW_VISITOR



}
