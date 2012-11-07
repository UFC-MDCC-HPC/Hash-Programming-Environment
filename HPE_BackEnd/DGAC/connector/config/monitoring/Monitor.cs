/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/

using System;
using System.Collections.Generic;

using br.ufc.pargo.hpe.connector;

namespace br.ufc.pargo.hpe.connector.monitoring {
   
   
   public class Monitor : IMonitor {
      
      protected List<IMonitorEvent> events;
      public List<IMonitorEvent> Events {
         get {return events;}
      }

      protected Dictionary<int, int> running;
      public Dictionary<int, int> Running {
         get {return running;}
      }

      protected List<IObserver> observers;
      
      protected Object thisLock = new Object();
      
      public Monitor() {
         this.events = new List<IMonitorEvent>();
         this.running = new Dictionary<int, int>();
      }
      
      public void Started(int state, int transation, int actionId) {
         //System.Console.WriteLine("[Monitor.Started] state:{0} | transation:{1} | actionId:{2}", state, transation, actionId);
         lock(thisLock) {
            if(!running.ContainsKey(actionId)) {
               running.Add(actionId, 1);
            } else {
               running[actionId]++;
            }
            
			//System.Console.WriteLine(actionId == 91 ? ("TOTAL " + running[actionId]) : "");
            //System.Console.WriteLine("Started: state " + state + " | transation " + transation);
         }
      }
      
      public void Finalized(int state, int transation, int actionId) {
         //System.Console.WriteLine("[Monitor.Finalized] state:{0} | transation:{1} | actionId:{2}", state, transation, actionId);
         lock(thisLock) {
            if(running[actionId] > 1) {
               running[actionId]--;
            } else {
               running.Remove(actionId);
            }
            
            events.Add(new MonitorEvent(state, transation));
         }
         
         Notify();
      }
      
      public bool isRunning(List<int> actions) {
         
         lock(thisLock) {
            foreach(int action in actions) {
               if(running.ContainsKey(action)) {
                  return true;
               }
            }
            
            return false;
         }
      }
      
      public bool isRunning(int initialState, int finalState) {
         
         lock(thisLock) {
            for(int i = events.Count-1; i > 0; i--) {
               if(events[i].state == finalState) {
                  return false;
               }
               
               if(events[i].state == initialState) {
                  return true;
               }
            }
            return false;
         }
      }
      
      protected void Notify() {
         if(observers != null) {
            foreach(IObserver ob in observers) {
               ob.Notify();
            }
         }
      }
      
      public void Add(IObserver ob) {
         if(observers == null) {
            observers = new List<IObserver>();
         }
         
         observers.Add(ob);
      }
      
      public void Remove(IObserver ob) {
         if(observers != null) {
            observers.Remove(ob);
         }
      }
   }
}
