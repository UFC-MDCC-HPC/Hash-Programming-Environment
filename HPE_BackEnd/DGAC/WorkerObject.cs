//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections.Generic;
using DGAC.utils;
using MPI;
using hpe.basic;
using System.Reflection;
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
            public void createInstanceNull()
            {
                this.global_communicator = MPI.Communicator.world;
                my_rank = this.global_communicator.Rank;

                Console.WriteLine(my_rank + "CREATE COMMUNICATOR NULL - START");

                this.global_communicator.Split(0, my_rank);

                Console.WriteLine(my_rank + "CREATE COMMUNICATOR NULL - FINISH");
                
            }

            [MethodImpl(MethodImplOptions.Synchronized)]
            public void createInstance(string instanceName, DGAC.database.Unit unit, IDictionary<int, Object> properties)
            {
                try
                {
                    this.global_communicator = MPI.Communicator.world;
                    my_rank = this.global_communicator.Rank;

                    // --- READING ENUMERATORS AND COPYING TO args OBJECT PASSED TO DGACInit
                    IList<string> eStrL = new List<string>();
                    Object enumsObj = null;
                    if (properties.TryGetValue(Constants.ENUMS_KEY, out enumsObj))
                    {
                        IDictionary<string, int> enums = (IDictionary<string, int>) enumsObj;
                        foreach (KeyValuePair<string, int> k in enums)
                        {
                            eStrL.Add(" --enumerator ");
                            eStrL.Add(k.Key);
                            eStrL.Add(k.Value.ToString());
                        }
                    }
                    // ---------------------------------------------------------------------

                    string[] args = new string[eStrL.Count];

                    eStrL.CopyTo(args, 0);

                    int key = my_rank;
                    object keyObj = null;
                    if (properties.TryGetValue(Constants.KEY_KEY, out keyObj))
                    {
                        key = (int)keyObj;
                    }

                    string hash_component_uid = null;
                    object hash_component_uid_obj = null;
                    if (properties.TryGetValue(Constants.UID_KEY, out hash_component_uid_obj)) {
                       hash_component_uid = (string) hash_component_uid_obj;
                    }
                    Console.WriteLine("UID = " + (hash_component_uid != null ? hash_component_uid : "null") + "Count : " + properties.Count);
 

                    string my_id_unit = unit.Id_unit;
                    hpe.kinds.IApplicationKind pmain = null;

                    string assembly_string = unit.Assembly_string;      // where to found the DLL (retrieve from the component).
                    string class_name = unit.Class_name;  // the name of the class inside the DLL.
                    int class_nargs = unit.Class_nargs;

                    Console.WriteLine("STARTING " + class_name);

                    Assembly a = Assembly.Load(assembly_string);

//                    string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");

                    int pos = class_name.LastIndexOf('.');
                    string package_name = class_name.Substring(0,pos);

                    Type t = a.GetType(/*strType*/  package_name + ".Instantiator");

                    // t = t.MakeGenericType(t.GetGenericArguments());

                    // hpe.kinds.IApplicationKind o = (hpe.kinds.IApplicationKind) Activator.CreateInstance(t);

                    pmain = (hpe.kinds.IApplicationKind) t.InvokeMember("getInstance", BindingFlags.Default | BindingFlags.InvokeMethod, null, null, new object[] { });

                    Console.WriteLine(my_rank + ": CREATE COMMUNICATOR - START");
                    pmain.LocalCommunicator = (MPI.Intracommunicator) this.global_communicator.Split(1,key);
                    Console.WriteLine(my_rank + ": CREATE COMMUNICATOR - FINISH");

                    Console.WriteLine(my_rank + ": PREPARING TO CALL INIT");

                    BackEnd.DGACInit(hash_component_uid, my_id_unit, pmain, args); Console.WriteLine(my_rank + ": PREPARING TO CALL CREATE SLICES");
                    pmain.createSlices(); Console.WriteLine(my_rank + ": PREPARING TO CALL COMPUTE");
                    pmain.compute(); Console.WriteLine(my_rank + ": PREPARING TO CALL FINALZE");
                    BackEnd.DGACFinalize(); Console.WriteLine(my_rank + ": FINISH");

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
