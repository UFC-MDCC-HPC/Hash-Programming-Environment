using SAFeSWL;
using System;
using System.Collections.Generic;


namespace br.ufc.pargo.hpe.kinds
{
	public class WorkflowParser
	{
		public static SWLWorkflow<bool> convertoToSWLAbstractTree(SAFeSWL_OperationAnyType workflow)
		{
			return traverse (workflow);
		}
			
		private static SWLWorkflow<bool> traverse(SAFeSWL_OperationAnyType workflow)
		{
			if (workflow.Item is SAFeSWL_OperationPrimitiveType) 
			{
				return traverse (workflow.ItemElementName, (SAFeSWL_OperationPrimitiveType) workflow.Item);
			} 
			else if (workflow.Item is SAFeSWL_OperationPrimitiveInvokeActionAsyncType) 
			{
				return traverse (workflow.ItemElementName, (SAFeSWL_OperationPrimitiveInvokeActionAsyncType) workflow.Item);
			} 
			else if (workflow.Item is SAFeSWL_OperationPrimitiveInvokeActionType) 
			{
				return traverse (workflow.ItemElementName, (SAFeSWL_OperationPrimitiveInvokeActionType) workflow.Item);
			}
			else if (workflow.Item is SAFeSWL_OperationManyType) 
			{
				return traverse (workflow.ItemElementName, (SAFeSWL_OperationManyType) workflow.Item);
			} 
			else if (workflow.Item is SAFeSWL_OperationChoiceType) 
			{
				return traverse (workflow.ItemElementName, (SAFeSWL_OperationChoiceType) workflow.Item);
			} 
			else if (workflow.Item is SAFeSWL_OperationAnyType) 
			{
				return traverse (workflow.ItemElementName, (SAFeSWL_OperationAnyType) workflow.Item);
			} 
			else
				throw new Exception ("convert_to_abstract_syntax/traverse: UNRECOGNIZED SAFeSWL constructor.");

		}

		private static SWLWorkflow<bool> traverse(SAFeSWL.ItemChoiceType element_name, SAFeSWL_OperationPrimitiveType workflow)
		{
			if (element_name == SAFeSWL.ItemChoiceType.skip) 
			{
				return new SWLWorkflowSkip<bool>();
			}
			else if (element_name == SAFeSWL.ItemChoiceType.@break) 
			{
				return new SWLWorkflowBreak<bool> ();
			}
			else if (element_name == SAFeSWL.ItemChoiceType.@continue) 
			{
				return new SWLWorkflowBreak<bool> ();
			}
			else
				throw new Exception("convert_to_abstract_syntax/traverse: wait/break/continue expected !");
		}

		private static SWLWorkflow<bool> traverse(SAFeSWL.ItemChoiceType element_name, SAFeSWL_OperationPrimitiveInvokeActionAsyncType workflow)
		{
			SAFeSWL_OperationPrimitiveInvokeActionAsyncType action = (SAFeSWL_OperationPrimitiveInvokeActionAsyncType)workflow;

			if (element_name == SAFeSWL.ItemChoiceType.start) 
			{
				string handle = action.handle_id;
				string port_name = action.id_port;
				string action_name = action.action;
				return new SWLWorkflowStart<bool> (handle, port_name, action_name);
			}
			else if (element_name == SAFeSWL.ItemChoiceType.wait) 
			{
				string handle = action.handle_id;
				return new SWLWorkflowWait<bool> (handle);
			}
			else if (element_name == SAFeSWL.ItemChoiceType.cancel) 
			{
				string handle = action.handle_id;
				return new SWLWorkflowCancel<bool> (handle);
			}
			else
				throw new Exception("convert_to_abstract_syntax/traverse: start/wait/cancel expected !");
		} 

		private static SWLWorkflow<bool> traverse(SAFeSWL.ItemChoiceType element_name, SAFeSWL_OperationPrimitiveInvokeActionType workflow)
		{
			SAFeSWL_OperationPrimitiveInvokeActionType action = (SAFeSWL_OperationPrimitiveInvokeActionType)workflow;
			if (element_name == SAFeSWL.ItemChoiceType.invoke) 
			{
				string port_name = action.id_port;
				string action_name = action.action;
				return new SWLWorkflowInvoke<bool> (port_name, action_name);
			}
			else
				throw new Exception("convert_to_abstract_syntax/traverse: invoke expected !");
		}

		private static SWLWorkflow<bool> traverse(SAFeSWL.ItemChoiceType element_name, SAFeSWL_OperationManyType workflow)
		{
			SWLWorkflow<bool>[] actions = traverse ((SAFeSWL_OperationManyType)workflow); 

			if (element_name == SAFeSWL.ItemChoiceType.sequence) 
			{
				return new SWLWorkflowSequence<bool> (actions);
			}
			else if (element_name == SAFeSWL.ItemChoiceType.parallel) 
			{
				return new SWLWorkflowParallel<bool> (actions);
			}
			else
				throw new Exception("convert_to_abstract_syntax/traverse: sequence/parallel expected !");
		}
		

		private static SWLWorkflow<bool> traverse(SAFeSWL.ItemChoiceType element_name, SAFeSWL_OperationChoiceType workflow)
		{
			if (element_name == SAFeSWL.ItemChoiceType.choice) 
			{
				IList<SWLWorkflow<bool>> action_list;
				IList<Tuple<string,string>> guard_list;

				traverse (workflow.select, out action_list, out guard_list);

				SWLWorkflow<bool>[] actions = new SWLWorkflow<bool>[action_list.Count];
				action_list.CopyTo (actions, 0);

				Tuple<string,string>[] guards = new Tuple<string, string>[guard_list.Count];
				guard_list.CopyTo (guards, 0);

				return new SWLWorkflowChoice<bool> (actions, guards);
			}
			else
				throw new Exception("convert_to_abstract_syntax/traverse: choice expected !");
			
		}

		private static void traverse (SAFeSWL_SelectionGuardType[] select_guard_list, out IList<SWLWorkflow<bool>> action_list, out IList<Tuple<string,string>> guard_list)
		{
			action_list = new List<SWLWorkflow<bool>> ();
			guard_list = new List<Tuple<string, string>> ();

			foreach (SAFeSWL_SelectionGuardType select_guard in select_guard_list) 
			{
				guard_list.Add(new Tuple<string, string>( select_guard.id_port,	select_guard.action));
				action_list.Add(traverse (select_guard.branch));
			}
		}

		private static SWLWorkflow<bool> traverse(SAFeSWL.ItemChoiceType element_name, SAFeSWL_OperationAnyType workflow)
		{
			SWLWorkflow<bool> action = traverse ((SAFeSWL_OperationAnyType)workflow); 
			
			if (element_name == SAFeSWL.ItemChoiceType.iterate) 
			{
				return new SWLWorkflowIterate<bool> (action);
			}
			else
				throw new Exception("convert_to_abstract_syntax/traverse: iterate expected !");
		}

		private static SWLWorkflow<bool>[] traverse(SAFeSWL_OperationManyType workflow)
		{
			IList<SWLWorkflow<bool>> action_list = new List<SWLWorkflow<bool>> ();

			SAFeSWL_OperationManyType action = (SAFeSWL_OperationManyType)workflow;

			for (int i = 0; i < action.ItemsElementName.Length; i++) 
			{
				switch (action.ItemsElementName [i]) 
				{
				case SAFeSWL.ItemsChoiceType.skip:
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.skip, (SAFeSWL_OperationPrimitiveType) workflow.Items[i]));
				 	break;
				case SAFeSWL.ItemsChoiceType.@break:
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.@break, (SAFeSWL_OperationPrimitiveType) workflow.Items[i]));
					break;
				case SAFeSWL.ItemsChoiceType.@continue:
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.@continue, (SAFeSWL_OperationPrimitiveType) workflow.Items[i]));
					break;
				case SAFeSWL.ItemsChoiceType.start: 
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.start, (SAFeSWL_OperationPrimitiveInvokeActionAsyncType) workflow.Items[i]));
					break;
				case SAFeSWL.ItemsChoiceType.wait:
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.wait, (SAFeSWL_OperationPrimitiveInvokeActionAsyncType) workflow.Items[i]));
					break;
				case SAFeSWL.ItemsChoiceType.cancel:
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.cancel, (SAFeSWL_OperationPrimitiveInvokeActionAsyncType) workflow.Items[i]));
					break;
				case SAFeSWL.ItemsChoiceType.sequence: 
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.sequence, (SAFeSWL_OperationManyType) workflow.Items[i]));
					break;
				case SAFeSWL.ItemsChoiceType.parallel:
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.parallel, (SAFeSWL_OperationManyType) workflow.Items[i]));
					break;
				case SAFeSWL.ItemsChoiceType.choice:
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.choice, (SAFeSWL_OperationChoiceType) workflow.Items[i]));
					break;
				case SAFeSWL.ItemsChoiceType.iterate:
					action_list.Add (traverse(SAFeSWL.ItemChoiceType.iterate, (SAFeSWL_OperationAnyType) workflow.Items[i]));
					break;
				}
			}
				
			SWLWorkflow<bool>[] actions = new SWLWorkflow<bool>[action_list.Count];
			action_list.CopyTo (actions, 0);

			return actions;
		}

	}
}

