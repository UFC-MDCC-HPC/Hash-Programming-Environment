//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections.Generic;
using DGAC.utils;
using MPI;
// using cca;

namespace DGAC
{ 
		//WORKER
        public class WorkerObject: MarshalByRefObject{

            private int my_rank = -1;

            private MPI.Intracommunicator global_communicator = null;
 
    	    /**
	     * 	Creates an instance of a CCA component of the type defined by the 
	     * 	string className.  The string classname uniquely defines the
	     * 	"type" of the component, e.g.
	     * 	    doe.cca.Library.GaussianElmination. 
	     * 	It has an instance name given by the string instanceName.
	     * 	The instanceName may be empty (zero length) in which case
	     * 	the instanceName will be assigned to the component automatically.
	     * 	@throws CCAException If the Component className is unknown, or if the
	     * 		instanceName has already been used, a CCAException is thrown.
	     * 	@return A ComponentID corresponding to the created component. Destroying
	     * 		the returned ID does not destroy the component; 
	     * 		see destroyInstance instead.
	     */
            [MethodImpl(MethodImplOptions.Synchronized)]
            public void createInstance(string instanceName, string className /*, cca.TypeMap properties */)
            {
             try {
                int[] nodes = new int[] {1,2,3,4};
                Console.WriteLine("CREATE INSTANCE" + nodes.Length);

                this.global_communicator = MPI.Communicator.world; 
                my_rank = this.global_communicator.Rank;

                foreach (int i in nodes) {
                    Console.WriteLine(my_rank + ": SENDING TO " + i); Console.Out.Flush();
                    global_communicator.Send<int>(MPIWorkerMessagingConstants.CREATE_INSTANCE, i, MPIWorkerMessagingConstants.DEFAULT_TAG);
                }
             } 
             catch (Exception e) 
             {
                Console.WriteLine(e.Message);
             }
            }

			//just for test
			[MethodImpl(MethodImplOptions.Synchronized)]
			public void sayHi(){
				Console.WriteLine("Hi!");
			}

        }

        
}
