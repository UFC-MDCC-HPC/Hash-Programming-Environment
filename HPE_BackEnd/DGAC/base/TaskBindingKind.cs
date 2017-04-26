// /home/jefferson/projetos/appexample/appexample/kinds/SynchronizerKind.cs created with MonoDevelop
// User: jefferson at 13:20 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;
using gov.cca.ports;
using System.Threading;
using MPI;
using System.Collections.Generic;

namespace br.ufc.pargo.hpe.kinds
{

    public interface ITaskBindingKind : IActivateKind, GoPort
	{
		// (1) invokes and waits for action completion.
		void invoke(object action_id);

		// (2) invokes and returns a future object for further testing or waiting of action completion.
		void invoke(object action_id, out IActionFuture future);

		// (3) As (2), but it only completes after executing a procedure.
		void invoke(object action_id, Action reaction, out IActionFuture future);
	}
	
	public abstract class TaskBinding : Activate, ITaskBindingKind 
	{
		public abstract void invoke(object action_id);

		public abstract void invoke(object action_id, out IActionFuture future);

		// (3) As (2), but it only completes after executing a procedure.
		public abstract void invoke(object action_id, Action reaction, out IActionFuture future);

		internal class ActionFuture : IActionFuture
		{
			private RequestList request_list = null;
			private ManualResetEvent sync = null;
			private bool completed = false;

			public ActionFuture (RequestList request_list)
			{
				this.request_list = request_list;
			}

			public ActionFuture (RequestList request_list, ManualResetEvent sync)
			{
				this.request_list = request_list;
				this.sync = sync;
			}

			#region ActionFuture implementation
			public void wait ()
			{
				if (!completed)
					sync.WaitOne ();
			}
			public bool test ()
			{
				return completed;
			}

			public IActionFutureSet createSet()
			{
				IActionFutureSet afs = new ActionFutureSet ();
				afs.addAction (this);
				return afs;
			}

			#endregion

			public object waiting_lock = new object ();

			public void setCompleted()
			{
				lock (waiting_lock) 
				{
					completed = true;
					foreach (AutoResetEvent waiting_set in waiting_sets)
						waiting_set.Set ();
				}
			}

			private IList<AutoResetEvent> waiting_sets = new List<AutoResetEvent> ();

			public RequestList RequestList { get { return request_list; } } 

			public void registerWaitingSet(AutoResetEvent waiting_set)
			{
				lock (waiting_lock) 
				{
					if (completed)
						waiting_set.Set ();
					waiting_sets.Add (waiting_set);
				}
			}

			public void unregisterWaitingSet(AutoResetEvent waiting_set)
			{
				waiting_sets.Remove (waiting_set);
			}
		}

		internal class ActionFutureSet : IActionFutureSet
		{
			IList<IActionFuture> pending_list = new List<IActionFuture>();

			#region ActionFutureSet implementation
			public void addAction (IActionFuture new_future)
			{								
				lock (sync_oper)
					pending_list.Add (new_future);

				if (sync_future != null)
					new_future.registerWaitingSet (sync_future);
			}

			public void waitAll ()
			{
				foreach (IActionFuture action_future in pending_list) 
					lock(sync_oper)	action_future.wait ();			

				pending_list.Clear ();
			}

			AutoResetEvent sync_future = null;

			public IActionFuture waitAny ()
			{
				sync_future = new AutoResetEvent(false);

				lock (sync_oper)
					foreach (IActionFuture action_future in pending_list) 
						action_future.registerWaitingSet (sync_future);	

				sync_future.WaitOne ();
				sync_future = null;

				IActionFuture f = this.testAny ();

				lock (sync_oper)
					foreach (IActionFuture action_future in pending_list) 
						action_future.unregisterWaitingSet (sync_future);	


				/*	while (true)
			{
				Thread.Sleep (200);
				f = testAny();
				if (f != null)
					return f;
			}*/


				return f;
			} 

			private object sync_oper = new object (); 

			public bool testAll ()
			{
				lock (sync_oper) 
				{
					bool completed = true;
					IList<IActionFuture> tobeRemoved = new List<IActionFuture> ();

					foreach (IActionFuture action_future in pending_list) 
					{
						bool one_completed = action_future.test ();
						if (one_completed)
							tobeRemoved.Add (action_future);
						completed = completed && one_completed;
					}

					foreach (IActionFuture f in tobeRemoved) 
						pending_list.Remove (f);

					return completed;
				}
			}

			public IActionFuture testAny ()
			{
				IActionFuture completed_action_future = null;

				lock (sync_oper) 
				{				
					foreach (IActionFuture action_future in pending_list) 
					{
						if (action_future.test ()) 
						{
							completed_action_future = action_future;
							break;
						}
					}
					pending_list.Remove (completed_action_future);
				}

				return completed_action_future;
			}

			public IActionFuture[] Pending 
			{
				get 
				{
					lock (sync_oper) 
					{				
						IActionFuture[] f = new IActionFuture[pending_list.Count];
						pending_list.CopyTo (f, 0);
						return f;
					}
				}
			}
			#endregion
		}

	}

	public interface IActionFuture
	{
		void wait();
		bool test();
		IActionFutureSet createSet();
		void registerWaitingSet (AutoResetEvent waiting_set);
		void unregisterWaitingSet (AutoResetEvent waiting_set);
	}

	public interface IActionFutureSet 
	{
		void addAction(IActionFuture new_future);

		void waitAll();
		IActionFuture waitAny();

		bool testAll();
		IActionFuture testAny();

		IActionFuture[] Pending { get; }
	}

}
