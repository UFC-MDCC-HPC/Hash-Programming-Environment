using System;

namespace br.ufc.pargo.hpe.kinds 
{
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

		public SWLWorkflowInvoke(string port_name, string action_name)
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
        public /*string[]*/ SAFeSWL.SAFeSWL_OperationPrimitiveInvokeActionType[] exit_clause;
		public /*string[]*/ SAFeSWL.SAFeSWL_OperationPrimitiveInvokeActionType[] enter_clause;

		public SWLWorkflowIterate(SWLWorkflow<T> iterate_action, SAFeSWL.SAFeSWL_OperationPrimitiveInvokeActionType[] exit_clause, SAFeSWL.SAFeSWL_OperationPrimitiveInvokeActionType[] enter_clause)
		{
			this.iterate_action = iterate_action;
            this.exit_clause = exit_clause;
			this.enter_clause = enter_clause;
		}
		public T accept (SWLVisitor<T> visitor)
		{
			return visitor.visit (this);
		}
	}
}
