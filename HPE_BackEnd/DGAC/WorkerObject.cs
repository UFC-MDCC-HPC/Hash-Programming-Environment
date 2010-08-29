//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections.Generic;
using br.ufc.hpe.backend.DGAC.utils;
using MPI;
using br.ufc.hpe.basic;
using System.Reflection;
using System.Threading;
using gov.cca;
using System.IO;
using br.ufc.hpe.backend.DGAC.database;


delegate void GoMethod();

namespace br.ufc.hpe.backend.DGAC
{ 
		//WORKER
    public class WorkerObject : MarshalByRefObject, gov.cca.AbstractFramework, 
	                                                gov.cca.ports.BuilderService, 
	                                                gov.cca.ports.ComponentRepository,
		                                            gov.cca.Services
    {
		// ==========================================================================================================
        // BEGIN - CCA INTERFACES (Abstract Framework, Builder Services, Services) ==================================
		// ==========================================================================================================
		
        // ABSTRACT FRAMEWORK =======================================================================================

        public TypeMap createTypeMap()
        {
            return null;
        }

        public gov.cca.Services getServices(string selfInstanceName, string selfClassName, TypeMap selfProperties)
        {
            return null;
        }

        public void releaseServices(gov.cca.Services services)
        {
        }


        public void shutdownFramework()
        {

        }

        public AbstractFramework createEmptyFramework()
        {
            return null;
        }

        // BUILDER SERVICE ==============================================================================================


        [MethodImpl(MethodImplOptions.Synchronized)]
        public ComponentID createInstance(string instanceName, string className, TypeMap properties)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ComponentID[] getComponentIDs()
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public TypeMap getComponentProperties(ComponentID cid)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void setComponentProperties(ComponentID cid, TypeMap map)
        {
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ComponentID getDeserialization(string s)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ComponentID getComponentID(string componentInstanceName)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void destroyInstance(ComponentID toDie, float timeout)
        {
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public string[] getProvidedPortNames(ComponentID cid)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public string[] getUsedPortNames(ComponentID cid)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public TypeMap getPortProperties(ComponentID cid, string portName)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void setPortProperties(ComponentID cid, string portName, TypeMap map)
        {
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ConnectionID connect(ComponentID user, string usingPortName, ComponentID provider, string providingPortName)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ConnectionID[] getConnectionIDs(ComponentID[] componentList)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public TypeMap getConnectionProperties(ConnectionID connID)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void setConnectionProperties(ConnectionID connID, TypeMap map)
        {
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void disconnect(ConnectionID connID, float timeout)
        {
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void disconnectAll(ComponentID id1, ComponentID id2, float timeout)
        {
        }
		
		
        // COMPONENT REPOSITORY =============================================================================================

        [MethodImpl(MethodImplOptions.Synchronized)]
        public ComponentClassDescription[] getAvailableComponentClasses()
        {
            return null;
        }
        
        
        // SERVICES  ========================================================================================================

        [MethodImpl(MethodImplOptions.Synchronized)]
        public Port getPort(string portName)
        {
            return null;
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public Port getPortNonblocking(string portName)
        {
            return null;
        }

		[MethodImpl(MethodImplOptions.Synchronized)]
        public void releasePort(string portName)
        {
        }


		[MethodImpl(MethodImplOptions.Synchronized)]
        public void registerUsesPort(string portName, string type, TypeMap properties)
        {
        }

		[MethodImpl(MethodImplOptions.Synchronized)]
        public void unregisterUsesPort(string portName)
        {
        }


		[MethodImpl(MethodImplOptions.Synchronized)]
        public void addProvidesPort(Port inPort, string portName, string type, TypeMap properties)
        {
        }

 		[MethodImpl(MethodImplOptions.Synchronized)]
        public TypeMap getPortProperties(string name)
        {
            return null;
        }

 		[MethodImpl(MethodImplOptions.Synchronized)]
        public void removeProvidesPort(string portName)
        {
        }

  		[MethodImpl(MethodImplOptions.Synchronized)]
        public ComponentID getComponentID()
        {
            return null;
        }

  		[MethodImpl(MethodImplOptions.Synchronized)]
        public void registerForRelease(ComponentRelease callBack)
        {
        }
	
        
		// ==========================================================================================================
        // END - CCA INTERFACES (Abstract Framework, Builder Services, Services) ====================================
		// ==========================================================================================================
		
		
		
        
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
            this.global_communicator.Split(0, my_rank);
        }

        [MethodImpl(MethodImplOptions.Synchronized)]
        public void createInstance(string instanceName, br.ufc.hpe.backend.DGAC.database.Unit unit, IDictionary<int, Object> properties)
        {
            try
            {
                this.global_communicator = MPI.Communicator.world;
                my_rank = this.global_communicator.Rank;

                IList<string> eStrL = new List<string>();

                // READING SESSION ID
                object sessionObj = null;
                int session_id = -1;
                if (properties.TryGetValue(Constants.SESSION_KEY, out sessionObj)) 
                {
                   session_id = (int) sessionObj;
                   eStrL.Add("--session");
                   eStrL.Add(session_id.ToString());
                }


                // --- READING ENUMERATORS AND COPYING TO args OBJECT PASSED TO DGACInit
                Object enumsObj = null;
                if (properties.TryGetValue(Constants.ENUMS_KEY, out enumsObj))
                {
                    IDictionary<string, int> enums = (IDictionary<string, int>) enumsObj;
                    foreach (KeyValuePair<string, int> k in enums)
                    {
                        eStrL.Add("--enumerator");
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


                string my_id_unit = unit.Id_unit;
                hpe.kinds.IApplicationKind pmain = null;

                string assembly_string = unit.Assembly_string;      // where to found the DLL (retrieve from the component).
                string class_name = unit.Class_name;  // the name of the class inside the DLL.
                int class_nargs = unit.Class_nargs;

                Assembly a = Assembly.Load(assembly_string);

                int pos = class_name.LastIndexOf('.');
                string package_name = class_name.Substring(0,pos);

                System.Type t = a.GetType(package_name + ".Instantiator");

                pmain = (hpe.kinds.IApplicationKind) t.InvokeMember("getInstance", BindingFlags.Default | BindingFlags.InvokeMethod, null, null, new object[] { });

                pmain.LocalCommunicator = (MPI.Intracommunicator) this.global_communicator.Split(1,key);
                pmain.setServices(new br.ufc.hpe.backend.DGAC.ServicesImpl(hash_component_uid, my_id_unit, pmain, args));

                pmain.createSlices(); 

                Go go = new Go(my_rank, pmain);
                Thread thread_go = new Thread(go.go); 
                thread_go.Start();

            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            } 
        }


        private class Go {

            private hpe.kinds.IApplicationKind pmain = null;
           private int my_rank;

           public Go(int r, hpe.kinds.IApplicationKind pmain_) 
           {
             this.pmain = pmain_;
             this.my_rank = r;
           }

           public void go () 
           {
             try 
             {
               pmain.compute(); 
               Console.WriteLine(my_rank + ": FINISH");
             } 
             catch (Exception e) 
             {
                Console.WriteLine(my_rank + ": ABORTED THREAD");
             }
           }

        }

		//just for test
		[MethodImpl(MethodImplOptions.Synchronized)]
		public void sayHi(){
			Console.WriteLine("Hi!");
		}
	
	
	    private int session_id;

	
	
        private void Init(string hash_component_uid, string my_id_unit, IUnit pmain, string[] args)
        {
            slices = new List<hpe.basic.IUnit>();

            session_id = getSessionID(args);

            //                if (session_id >= 0)
            //                    RedirectOutput(session_id);
            //                else
            //                    open_log_out = false;

            Connector.openConnection();

            DGAC.database.Component c = BackEnd.cdao.retrieve_uid(hash_component_uid);

            int id_abstract = c.Id_abstract;
            int id_concrete = c.Id_concrete;

            pmain.Id_concrete = id_concrete;
            pmain.Id_interface = my_id_unit;

            IDictionary<string, int> eInf = new Dictionary<string, int>();
            IDictionary<string, int> eSup = new Dictionary<string, int>();

            pmain.EnumeratorCardinality = new Dictionary<string, int>();

            IList<Enumerator> eList = BackEnd.edao.list(id_abstract);
            foreach (Enumerator e in eList)
            {
                int rangeInf_ = 0;
                int rangeSup_ = enumeratorCardinality(args, e.Variable);

                eInf.Add(e.Id_enumerator, rangeInf_);
                eSup.Add(e.Id_enumerator, rangeSup_);
                if (rangeSup_ > 0)
                    pmain.EnumeratorCardinality.Add(e.Id_enumerator, rangeSup_);
            }

            int rangeInf, rangeSup;

            int num_procs = 0;
            int rank = 0;

            pmain.Units = new Dictionary<string, int[]>();
            IList<IDictionary<string, int>> pmain_EnumRanks = new List<IDictionary<string, int>>();
            IList<int> pmain_Ranks = new List<int>();

            IList<string> id_units_ordered = BackEnd.acfdao.getIdUnitsOrdered(id_abstract);

            foreach (string id_unit in id_units_ordered)
            {
                if (id_unit.Equals(my_id_unit) && pmain.GlobalRank < 0)
                    pmain.GlobalRank = rank;

                IList<EnumerationInterface> eiList = BackEnd.exitdao.listByInterface(id_abstract, id_unit);

                if (eiList.Count > 0)
                {
                    IList<IList<int>> x = new List<IList<int>>();
                    x.Add(new List<int>());
                    int j = 0;
                    string[] enumerator = new string[eiList.Count];
                    foreach (EnumerationInterface ei in eiList)
                    {
                        enumerator[j++] = ei.Id_enumerator;
                        eInf.TryGetValue(ei.Id_enumerator, out rangeInf);
                        eSup.TryGetValue(ei.Id_enumerator, out rangeSup);
                        IList<IList<int>> y = new List<IList<int>>();
                        foreach (IList<int> xx in x)
                        {
                            for (int yyy = rangeInf; yyy < rangeSup; yyy++)
                            {
                                IList<int> yy = new List<int>();
                                foreach (int xxx in xx)
                                {
                                    yy.Add(xxx);
                                }
                                yy.Add(yyy);
                                y.Add(yy);
                            }
                        }
                        x = y;
                    }

                    num_procs += x.Count;

                    IList<int> ranks = new List<int>();

                    foreach (IList<int> eIXs in x)
                    {
                        j = 0;
                        pmain_EnumRanks.Add(new Dictionary<string, int>());
                        foreach (int eVal in eIXs)
                        {
                            pmain_EnumRanks[rank].Add(enumerator[j++], eVal);
                        }
                        pmain_Ranks.Add(rank);
                        ranks.Add(rank);
                        rank++;
                    }
                    int[] ranksArr = new int[ranks.Count];
                    ranks.CopyTo(ranksArr, 0);
                    pmain.Units.Add(id_unit, ranksArr);
                }
                else // Unitary unit ...
                {
                    num_procs++;
                    pmain_Ranks.Add(rank);
                    pmain_EnumRanks.Add(new Dictionary<string, int>());
                    int[] ranksArr = new int[1];
                    ranksArr[0] = rank++;
                    pmain.Units.Add(id_unit, ranksArr);
                }
            }

            pmain.EnumRanks = new IDictionary<string, int>[num_procs];
            pmain.Ranks = new int[num_procs];

            for (int i = 0; i < num_procs; i++)
            {
                pmain.EnumRanks[i] = pmain_EnumRanks[i];
                pmain.Ranks[i] = pmain_Ranks[i];
            }

            pmain.setUpParameters(c);
            pmain.ActualParametersTop = pmain.ActualParameters;

            // closeConnection(true);
        }

        private int getSessionID(string[] args)
        {
            int step = 0;
            foreach (string a in args)
            {
                if (step == 0 && a.Equals("--session"))
                    step++;
                else if (step == 1)
                    return Int32.Parse(a);
            }
            return -1;
        }


        private StreamWriter log_out = null;
        private string output_log_filename = "output";
        private bool open_log_out = true;

        private static readonly DateTime Jan1st1970 = new DateTime
            (1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);

        public long currentTimeMillis()
        {
            return (long)(DateTime.UtcNow - Jan1st1970).TotalMilliseconds;
        }

        private void RedirectOutput(int session_id)
        {
            try
            {
                string filename = Constants.PATH_BIN + output_log_filename + "." + session_id + "." + currentTimeMillis();
                Console.WriteLine("REDIRECTING OUTPUT TO " + filename);
                if (!File.Exists(filename))
                {
                    FileStream f = File.Create(filename);
                    f.Close();
                }
                log_out = new StreamWriter(filename);
                log_out.AutoFlush = true;
            }
            catch (IOException exc)
            {
                Console.WriteLine(exc.Message + "Cannot open output file.");
                open_log_out = false;
                return;
            }

            // Direct standard output to the log file. 
            if (open_log_out)
                Console.SetOut(log_out);

        }

        private int globalRank(string[] args)
        {
            int step = 0;
            foreach (string a in args)
            {
                if (step == 0 && a.Equals("--myrank"))
                    step++;
                else if (step == 1)
                    return Int32.Parse(a);
            }
            return -1;
        }



        private int enumeratorCardinality(string[] args, string var)
        {
            int step = 0;
            foreach (string a in args)
            {
                if (step == 0 && a.Equals("--enumerator")) step++;
                else if (step == 1 && (var.Equals(a))) step++;
                else if (step == 2) return Int32.Parse(a);
                else step = 0;
            }
            return 1;
        }

        public void openConnection()
        {
            Connector.openConnection();
            Connector.beginTransaction();
        }

        public void closeConnection(bool commit)
        {
            if (commit)
            {
                Connector.commitTransaction(); // if it is ok, commit ...
            }
            else
            {
                Connector.rollBackTransaction(); // if it is ok, commit ...
            }
        }

        private void dictReplaceKey(IDictionary<string, int> dict, string key, int value)
        {
            if (dict.ContainsKey(key))
            {
                dict.Remove(key);
            }
            dict.Add(key, value);
        }

        private bool findReplicator(IUnit unit, KeyValuePair<string, int> re,
                                           Slice s,
                                           InnerComponent ic,
                                           IDictionary<string, int> enumeratorCardinality,
                                           out IDictionary<string, int> enumeratorCardinality_return,
                                           out KeyValuePair<string, int> replicator)
        {
            int id_abstract = ic.Id_abstract_owner;
            string id_inner = ic.Id_inner;
            string id_unit = s.Id_interface_slice;
            IDictionary<string, int> enumeratorCardinality_prime = new Dictionary<string, int>();

            // LOOK FOR THE ORIGINAL REPLICATOR FROM THE INNER COMPONENT THAT HAS BEEN SPLITTED...
            string re_Key;
            int re_Value;

            //   Console.WriteLine("findReplicator:" + id_abstract + "," + id_inner + "," + id_unit + ", " + re.Key);

            EnumeratorSplitDAO esplitdao = new EnumeratorSplitDAO();
            EnumeratorSplit es = esplitdao.retrieve1(id_abstract, re.Key);
            if (es != null && s.Id_split_replica > 0)
            {
                re_Key = es.Id_enumerator;
                re_Value = es.mapSplitEnumerationValue(unit, re_Key, re, s, enumeratorCardinality, enumeratorCardinality_prime);
            }
            else
            {
                re_Key = re.Key;
                re_Value = re.Value;
            }


            foreach (KeyValuePair<string, int> ke in enumeratorCardinality)
                dictReplaceKey(enumeratorCardinality_prime, ke.Key, ke.Value);

            // if (!enumeratorCardinality_prime.ContainsKey(ke.Key))
            //    {
            //        enumeratorCardinality_prime.Add(ke);
            //    }

            string id_inner_container = id_inner;
            IList<string> id_inner_container_list = new List<string>();
            IList<SliceExposed> seMap = new List<SliceExposed>();

            // FIND THE ORIGINAL REPLICATOR OF THE INNER COMPONENT THAT HAS BEEN FUSED.
            //    EnumeratorMappingDAO emdao = new EnumeratorMappingDAO();
            //            EnumeratorMapping em = null;

            IList<SliceExposed> lse = null;
            if (ic.Transitive)
            {
                //  SliceExposedDAO sedao = new SliceExposedDAO();
                lse = BackEnd.sedao.listContainers(s.Id_inner, s.Id_interface_slice, s.Id_abstract, s.Id_split_replica);

                foreach (SliceExposed se_ in lse)
                {
                    id_inner_container = se_.Id_inner_owner;
                    id_inner_container_list.Add(id_inner_container);
                    //             Console.WriteLine("SLICE EXPOSED: " + id_inner_container);
                    seMap.Add(se_);
                }
            }

            if (id_inner_container_list.Count == 0)
            {
                id_inner_container_list.Add(id_inner_container);
            }


            string re_Key_before = re_Key;

            int cc = -1;
            foreach (string id_inner_container_ in id_inner_container_list)
            {
                cc = re_Key.IndexOf(id_inner_container_ + ".");
                //      Console.WriteLine(" >>>> " + re_Key + " , " +  id_inner_container_);
                if (cc >= 0)
                {
                    id_inner_container = id_inner_container_;
                    re_Key = re_Key.Substring(cc + (id_inner_container + ".").Length);
                    //         Console.WriteLine(" *>>>> " + re_Key + " , " + id_inner_container_);
                    break;
                }
            }
            if (cc < 0)
            {
                replicator = new KeyValuePair<string, int>();
                enumeratorCardinality_return = enumeratorCardinality;
                return false;
            }

            IDictionary<string, int> enumeratorCardinalityTemp = new Dictionary<string, int>();

            // UPDATE CARDINALITY
            foreach (KeyValuePair<string, int> ke in enumeratorCardinality_prime)
            {
                if (ke.Key.Equals(re_Key_before))
                {
                    dictReplaceKey(enumeratorCardinalityTemp, re_Key, ke.Value);

                    //                    if (!enumeratorCardinalityTemp.ContainsKey(re_Key))
                    //                    {
                    //                        enumeratorCardinalityTemp.Add(re_Key, ke.Value);                        
                    //                    }
                }
                else
                {
                    string re_Key_ = ke.Key;
                    int re_Value_ = ke.Value;

                    int cc_ = re_Key_.IndexOf(id_inner_container + ".");
                    if (cc_ >= 0)
                    {
                        re_Key_ = re_Key_.Substring(cc_ + (id_inner_container + ".").Length);
                        re_Value_ = ke.Value;
                        dictReplaceKey(enumeratorCardinalityTemp, re_Key_, re_Value_);
                        // if (!enumeratorCardinalityTemp.ContainsKey(re_Key_))
                        // {
                        //     enumeratorCardinalityTemp.Add(re_Key_, re_Value_);
                        // }
                    }
                    else
                    {
                        dictReplaceKey(enumeratorCardinalityTemp, re_Key_, re_Value_);
                        //if (!enumeratorCardinalityTemp.ContainsKey(re_Key_))
                        //{
                        //     enumeratorCardinalityTemp.Add(re_Key_, re_Value_);
                        // }
                    }
                }
            }

            enumeratorCardinality_prime = enumeratorCardinalityTemp;

            KeyValuePair<string, int> ke_prime = new KeyValuePair<string, int>(re_Key, re_Value);

            if (ic.Transitive && seMap.Count > 0)     // in fact, ic.Transitive <=> se != null
            {
                //   InnerComponentExposedDAO icedao = new InnerComponentExposedDAO();
                InnerComponentExposed ice = BackEnd.icedao.retrieve(id_abstract, id_inner_container, id_inner);

                //  InnerComponentDAO icdao = new InnerComponentDAO();
                InnerComponent ic_owner = BackEnd.icdao.retrieve(ic.Id_abstract_owner, ice.Id_inner_owner);
                InnerComponent ic_prime = BackEnd.icdao.retrieve(ic_owner.Id_abstract_inner, ice.Id_inner);

                //  SliceDAO sdao = new SliceDAO();
                Slice s_prime = null;

                foreach (SliceExposed se in seMap)
                {
                    s_prime = BackEnd.sdao.retrieve2(ic_prime.Id_abstract_owner, ice.Id_inner, se.Id_interface_slice, se.Id_interface_slice_owner);
                    if (s_prime != null)
                        break;
                    // else
                    //     Console.WriteLine("Fetched in seMap : " + se.Id_interface_slice_owner);
                }

                IList<EnumeratorMapping> emList = BackEnd.exmdao.list(ic_prime.Id_abstract_owner, ke_prime.Key);

                int kkk;
                enumeratorCardinality_prime.TryGetValue(ke_prime.Key, out kkk);


                foreach (EnumeratorMapping em in emList)
                {
                    dictReplaceKey(enumeratorCardinality_prime, em.Id_enumerator_inner, kkk);
                    //                    if (!enumeratorCardinality_prime.ContainsKey(em.Id_enumerator_inner))
                    //                    {
                    //                        enumeratorCardinality_prime.Add(em.Id_enumerator_inner, kkk /* ke_prime.Value*/);
                    //                    }
                }

                //     Console.WriteLine("emList.Count = " + emList.Count + " => " + ic_prime.Id_abstract_owner + " - " + ke_prime.Key + "," + ic_owner.Id_abstract_inner + "," + ice.Id_inner);
                if (emList.Count > 0)
                {
                    foreach (EnumeratorMapping em in emList)
                    {
                        KeyValuePair<string, int> ke_prime_ = new KeyValuePair<string, int>(em.Id_enumerator_inner, ke_prime.Value);
                        if (findReplicator(unit, ke_prime_, s_prime, ic_prime, enumeratorCardinality_prime, out enumeratorCardinality_return, out replicator))
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    if (findReplicator(unit, ke_prime, s_prime, ic_prime, enumeratorCardinality_prime, out enumeratorCardinality_return, out replicator))
                    {
                        return true;
                    }
                }


                replicator = new KeyValuePair<string, int>(); ;

                enumeratorCardinality_return = new Dictionary<string, int>();

                return false;
            }
            else
            {
                replicator = ke_prime;

                IList<EnumeratorMapping> emList = BackEnd.exmdao.list(ic.Id_abstract_inner, ke_prime.Key);

                int kkk;
                enumeratorCardinality_prime.TryGetValue(ke_prime.Key, out kkk);

                foreach (EnumeratorMapping em in emList)
                {
                    dictReplaceKey(enumeratorCardinality_prime, em.Id_enumerator_inner, kkk);

                    //                    if (!enumeratorCardinality_prime.ContainsKey(em.Id_enumerator_inner))
                    //                    {
                    //                        enumeratorCardinality_prime.Add(em.Id_enumerator_inner, kkk /* ke_prime.Value*/);
                    //                    }
                }

                enumeratorCardinality_return = enumeratorCardinality_prime;

                return true;
            }

        }

        private IDictionary<string, System.Type> instanceCache;

        // CREATE AN INSTANCE OF A SEQUENCIAL #-COMPONENT (Only one unit is assumed)
        public Object createInstance(System.Type T)
        {
            string library_path = T.FullName;

            return createInstance(library_path);
        }


        public Object createInstance(string library_path)
        {
            return createInstance(library_path, new System.Type[] { });
        }

        public Object createInstance(string library_path, System.Type[] typeParams)
        {
            System.Type closedT = null;

            if (instanceCache == null || !instanceCache.ContainsKey(library_path))
            {
                Interface i = BackEnd.idao.retrieve_libraryPath(library_path);

                int id_abstract = i.Id_abstract;

                DGAC.database.Component c = BackEnd.cdao.retrieveThatImplements(id_abstract)[0];

                database.Unit u = BackEnd.udao.retrieve(c.Id_concrete, i.Id_interface, 1);

                string assembly_string = u.Assembly_string;      // where to found the DLL (retrieve from the component).
                string class_name = u.Class_name;  // the name of the class inside the DLL.
                int class_nargs = u.Class_nargs;

                //IPImpl, Version=1.0.0.0, Culture=neutral, PublicKey=0024000004800000940000000602000000240000525341310004000001000100CD27D3A31B4F32440C52F63365D89A2D9527864AAEDC551F83D6345719CCD2937126770A203F67551BD45EA1D835E71AE79AEB8E46AC23829AF52F70D364268574D94DC912CB9A1458B90AABE649B0A6966BA5ECFE1599FEA3969F2B49A5E630821CE6BC8A65B9FB65FFDEF61AB4D07C32B242CEEEFCBDC5151D2B7ABB6D87B0, processorArchitecture=MSIL

                Assembly a = Assembly.Load(assembly_string);

                string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");
                System.Type t = a.GetType(strType);
                closedT = typeParams.Length > 0 ? t.MakeGenericType(typeParams) : t;

                if (instanceCache == null) instanceCache = new Dictionary<string, System.Type>();
                instanceCache.Add(library_path, closedT);
            }
            else
            {
                instanceCache.TryGetValue(library_path, out closedT);
            }

            hpe.basic.IUnit o = (hpe.basic.IUnit)Activator.CreateInstance(closedT);

            return o;

        }

        public IUnit loadImpl(IUnit unit,
                                       DGAC.database.Component c,
                                       string id_inner,
                                       string id_interface,
                                       string propertyName, IDictionary<string, int> actualParameters_new)
        {
            int id_abstract = c.Id_abstract;
            database.Unit u = LoaderApp.resolveImpl(unit, c.Id_concrete, id_inner, id_interface);

            DGAC.database.Component cu = BackEnd.cdao.retrieve(u.Id_concrete);

            if (u == null)
                throw new ConcreteComponentNotFoundException(id_abstract, id_inner, c.Id_functor_app);

            string assembly_string = u.Assembly_string;      // where to found the DLL (retrieve from the component).
            string class_name = u.Class_name;  // the name of the class inside the DLL.
            int class_nargs = u.Class_nargs;

            System.Type[] actualParams;

            Assembly a = Assembly.Load(assembly_string);

            string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");
            System.Type t = a.GetType(strType);

            buildParamTable(propertyName, unit.GetType(), out actualParams);

            System.Type closedT = actualParams.Length > 0 ? t.MakeGenericType(actualParams) : t;

            hpe.basic.IUnit o = (hpe.basic.IUnit)Activator.CreateInstance(closedT);

            o.Id_concrete = u.Id_concrete;
            o.Id_interface = u.Id_interface_interface;
            o.ContainerSlice = unit;
            o.GlobalRank = unit.GlobalRank;

            return o;
        }

        private IDictionary<int, System.Type> paramTable = new Dictionary<int, System.Type>();

        private void buildParamTable(String propertyName, System.Type myType, out System.Type[] actualParams)
        {
            System.Type o = myType.BaseType.GetProperty(propertyName, BindingFlags.NonPublic | BindingFlags.Instance).PropertyType;
            actualParams = o.GetGenericArguments();
        }

        /* REMARK: The type params MUST be provided externally, because the actual type information is not in the DGAC's database.
         */

        private bool firstPass = true;

        public IUnit registerUsesPort(IUnit unit,
                                                  string hash_component_uid,
                                                  string id_inner,
                                                  string id_interface
                                                 )
        {
            try
            {
                DGAC.database.Component c = BackEnd.cdao.retrieve_uid(hash_component_uid);
                int id_abstract = c.Id_abstract;

                MPI.Intracommunicator global_communicator = MPI.Communicator.world;
                int my_rank = global_communicator.Rank;

                if (my_rank == 0) Console.Write(my_rank + ": BEGIN createSlice !!!! " + id_abstract + "," + id_inner + "," + id_interface + "..... ");

                InnerComponent ic = BackEnd.icdao.retrieve(id_abstract, id_inner);

                IDictionary<string, int> actualParameters_new = null;
                // hpe.basic.Unit.determineActualParameters(unit.ActualParameters, ic.Id_functor_app, out actualParameters_new);
                hpe.basic.Unit.determineActualParameters2(unit, ic, out actualParameters_new);

                Slice slice = BackEnd.sdao.retrieve2(id_abstract, id_inner, id_interface, unit.Id_interface);

                hpe.basic.IUnit o = loadImpl(unit, c, id_inner, id_interface, slice.PropertyName, actualParameters_new); // (hpe.basic.IUnit)Activator.CreateInstance(closedT);

                // Configure the knowledge of the slices about the topology.

                IDictionary<string, int> eix_inner = new Dictionary<string, int>();

                // Console.WriteLine(" ------ unit.EnumRank has " + unit.EnumRank.Count + " elements");

                IDictionary<string, IList<KeyValuePair<string, int>>> enumsByVars = new Dictionary<string, IList<KeyValuePair<string, int>>>();

                // Console.WriteLine("unit.EnumRank.Count = " + unit.EnumRank.Count);

                foreach (KeyValuePair<string, int> index in unit.EnumRank)
                {
                    Enumerator e = BackEnd.edao.retrieve(id_abstract, index.Key);
                    if (enumsByVars.ContainsKey(e.Variable))
                    {
                        IList<KeyValuePair<string, int>> l;
                        enumsByVars.TryGetValue(e.Variable, out l);
                        l.Add(index);
                    }
                    else
                    {
                        IList<KeyValuePair<string, int>> l = new List<KeyValuePair<string, int>>();
                        l.Add(index);
                        enumsByVars.Add(e.Variable, l);
                    }
                }

                //  Console.WriteLine(" ------ enumByVars has " + enumsByVars.Count + " elements");

                foreach (KeyValuePair<string, IList<KeyValuePair<string, int>>> k in enumsByVars)
                {
                    int found = 0;
                    foreach (KeyValuePair<string, int> index in k.Value)
                    {
                        string eix = index.Key;
                        int val = index.Value;

                        // Check if the slice is enumerated by eix.
                        EnumerationSlice es = BackEnd.exsdao.retrieve(id_abstract, id_inner, id_interface, eix);
                        if (es == null)      // If not, the inner component must be. Otherwise, this is stuck configuration.
                        // REMARK: With enumerators, this is possible now.
                        {
                            EnumerationInner ei = BackEnd.exindao.retrieve(id_abstract, id_inner, eix);
                            if (ei != null)
                            {
                                //                            Console.WriteLine("REPLICATE INNER : " + id_abstract + "," + id_inner + "," + id_interface + "," + eix);
                                eix_inner.Add(eix, val);
                                found++;
                            }
                            else
                            {
                                //                            Console.WriteLine("NON REPLICATE INNER : " + id_abstract + "," + id_inner + "," + id_interface +  ", "+ eix);
                            }
                        }
                        else
                        {
                            //                        Console.WriteLine(" ES NON REPLICATE INNER : " + id_abstract + "," + id_inner + "," + eix);
                            found++;
                        }
                    }
                    if (found == 0)
                    {
                        Console.WriteLine("k.Key = " + k.Key);

                        foreach (KeyValuePair<string, int> xxx in k.Value)
                        {
                            Console.WriteLine("k.Value = (" + xxx.Key + "," + xxx.Value + ")");
                        }
                        Console.WriteLine("UNEXPECTED CONDITION: Stuck Configuration (" + found + ") ...(id_abstract=" + id_abstract + ", id_inner=" + id_inner + ", id_interface=" + id_interface + ")");
                        throw new Exception("UNEXPECTED CONDITION: Stuck Configuration (" + found + ") ...(id_abstract=" + id_abstract + ", id_inner=" + id_inner + ", id_interface=" + id_interface + ")");
                    }


                }

                // Now, list all units of the inner component.

                int id_functor_app_inner_actual = ic.Id_functor_app;
                int id_abstract_inner_original = ic.Id_abstract_inner;
                int id_abstract_inner_actual = ic.Id_abstract_inner;
                if (!ic.Parameter_top.Equals("") && !(ic.Parameter_top == null))
                {
                    bool achei = unit.ActualParameters.TryGetValue(ic.Parameter_top, out id_functor_app_inner_actual);
                    if (!achei)
                    {
                        achei = unit.ActualParameters.TryGetValue(ic.Parameter_top + "#" + unit.Id_functor_app, out id_functor_app_inner_actual);
                    }

                    int id_functor_app_old = ic.Id_functor_app;
                    ic.Id_functor_app = id_functor_app_inner_actual;
                    AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app_inner_actual);
                    id_abstract_inner_actual = acfa.Id_abstract;
                    ic.Id_abstract_inner = id_abstract_inner_actual;
                }

                o.Id_functor_app = ic.Id_functor_app;
                o.Id_abstract = ic.Id_abstract_inner;

                IList<Slice> ss = BackEnd.sdao.listByInner(id_abstract, id_inner);
                IDictionary<string, IList<int>> ranksAll = new Dictionary<string, IList<int>>();
                Dictionary<string, int> countUnits = new Dictionary<string, int>();
                IDictionary<string, IList<IDictionary<string, int>>> enumRanksL = new Dictionary<string, IList<IDictionary<string, int>>>();

                IDictionary<string, string> unitsMapping = new Dictionary<string, string>();

                IList<string> id_units_ordered = BackEnd.acfdao.getIdUnitsOrdered(id_abstract_inner_original);
                IList<string> id_units_ordered_actual = BackEnd.acfdao.getIdUnitsOrdered(id_abstract_inner_actual);
                for (int k = 0; k < id_units_ordered.Count; k++)
                {
                    unitsMapping.Add(id_units_ordered_actual[k], id_units_ordered[k]);
                }

                foreach (Slice s in ss)  // for different split_replica's. 
                {
                    string id_interface_slice = s.Id_interface_slice;

                    String id_interface_of_slice = s.Id_interface;

                    // Ache todas as unidades que são id_interface.
                    int[] ranks;
                    unit.Units.TryGetValue(id_interface_of_slice, out ranks);

                    // Percorra todas estas unidades e adicione somente aquelas cujos índice para algum enumerador em
                    // eix_inner seja o mesmo.
                    foreach (int r_ in ranks)
                    {
                        int r = unit.RanksInv[r_]; // r is the local rank... r_ is the global rank.
                        IDictionary<string, int> rE = new Dictionary<string, int>();
                        foreach (KeyValuePair<string, int> re in unit.EnumRanks[r])
                            rE.Add(re);

                        bool flag = true;
                        foreach (KeyValuePair<string, int> e in eix_inner)
                        {
                            int index = e.Value;
                            int index_;
                            rE.TryGetValue(e.Key, out index_);
                            flag = flag && index == index_;
                        }

                        if (flag)
                        {
                            int count = 0;
                            if (countUnits.ContainsKey(id_interface_slice))
                            {
                                countUnits.TryGetValue(id_interface_slice, out count);
                                countUnits.Remove(id_interface_slice);
                                countUnits.Add(id_interface_slice, ++count);
                            }
                            else
                                countUnits.Add(id_interface_slice, ++count);

                            IList<int> _ranks;
                            if (ranksAll.ContainsKey(id_interface_slice))
                            {
                                ranksAll.TryGetValue(id_interface_slice, out _ranks);
                            }
                            else
                            {
                                _ranks = new List<int>();
                                ranksAll.Add(id_interface_slice, _ranks);
                            }
                            _ranks.Add(unit.Ranks[r]);

                            enumsByVars.Clear();
                            // Group by variable
                            foreach (KeyValuePair<string, int> index in rE)
                            {
                                Enumerator e = BackEnd.edao.retrieve(id_abstract, index.Key);
                                if (enumsByVars.ContainsKey(e.Variable))
                                {
                                    IList<KeyValuePair<string, int>> list;
                                    enumsByVars.TryGetValue(e.Variable, out list);
                                    list.Add(index);
                                }
                                else
                                {
                                    IList<KeyValuePair<string, int>> list = new List<KeyValuePair<string, int>>();
                                    list.Add(index);
                                    enumsByVars.Add(e.Variable, list);
                                }
                            }

                            foreach (KeyValuePair<string, int> e in eix_inner)
                            {
                                Enumerator enumerator = BackEnd.edao.retrieve(id_abstract, e.Key);
                                enumsByVars.Remove(enumerator.Variable);
                            }


                            // point to the replicator identifiers of the inner component ....
                            IDictionary<string, int> rE_ = new Dictionary<string, int>();

                            foreach (KeyValuePair<string, IList<KeyValuePair<string, int>>> k in enumsByVars)
                            {
                                // Console.WriteLine(unit.Id_interface + "." + unit.LocalRank + "##################################### " + s.Id_inner);
                                IList<KeyValuePair<string, int>> rElist = k.Value;

                                int occurrences = 0;
                                foreach (KeyValuePair<string, int> re in rElist)
                                {
                                    IDictionary<string, int> enumeratorCardinalityNew;
                                    KeyValuePair<string, int> replicator;
                                    bool found = findReplicator(unit, re, s, ic, unit.EnumeratorCardinality, out enumeratorCardinalityNew, out replicator);
                                    if (found)
                                    {
                                        if (!rE_.Contains(replicator))
                                        {
                                            rE_.Add(replicator);
                                            o.EnumeratorCardinality = enumeratorCardinalityNew;
                                            occurrences++;

                                        }
                                    }
                                }
                                if (occurrences != 1)
                                {
                                    Console.WriteLine("k.Key = " + k.Key);

                                    foreach (KeyValuePair<string, int> xxx in k.Value)
                                    {
                                        Console.WriteLine("k.Value = (" + xxx.Key + "," + xxx.Value + ")");
                                    }
                                    Console.WriteLine("ERROR find replicator : " + occurrences + " - " + rElist.Count + " --- " + id_abstract);
                                    throw new Exception("ERROR find replicator : " + occurrences + " - " + rElist.Count + " --- " + id_abstract);
                                }
                                //   Console.WriteLine(unit.Id_interface + "." + unit.LocalRank + ": END LOOP !!!!!!!!");
                            }


                            IList<IDictionary<string, int>> l;
                            if (enumRanksL.ContainsKey(id_interface_slice))
                            {
                                enumRanksL.TryGetValue(id_interface_slice, out l);
                            }
                            else
                            {
                                l = new List<IDictionary<string, int>>();
                                enumRanksL.Add(id_interface_slice, l);
                            }
                            l.Add(rE_);
                        }
                    }
                }

                // The slice units of id_inner are contained in the processes of ranks in ranksAll.
                IList<int> ranksAllList = new List<int>();
                IList<IDictionary<string, int>> enumRanksList = new List<IDictionary<string, int>>();

                IDictionary<string, int[]> unitsRanks = new Dictionary<string, int[]>();

                //ranksAll.CopyTo(ranksAllArr, 0);

                int pos1 = 0;
                int pos2 = 0;
                foreach (string id_unit_slice_ in id_units_ordered_actual)
                {
                    IList<int> ranks;

                    string id_unit_slice;
                    bool achei = unitsMapping.TryGetValue(id_unit_slice_, out id_unit_slice);

                    achei = ranksAll.TryGetValue(id_unit_slice, out ranks);


                    if (ranks == null)
                    {
                        ranks = new List<int>();
                    }


                    foreach (int r in ranks)
                        ranksAllList.Insert(pos2++, r);

                    IList<IDictionary<string, int>> enumRanks;
                    enumRanksL.TryGetValue(id_unit_slice, out enumRanks);


                    if (enumRanks == null)
                    {
                        enumRanks = new List<IDictionary<string, int>>();
                    }
                    else
                    {
                        insertEnumeratorFusions(o, id_unit_slice, enumRanks);
                    }

                    foreach (IDictionary<string, int> d in enumRanks)
                        enumRanksList.Insert(pos1++, /* removePrefixes( id_inner ,*/ d /* ) */);

                    // Calculate o.Units ...
                    int count;
                    countUnits.TryGetValue(id_unit_slice, out count);

                    int[] _ranks = new int[count];
                    for (int k = 0; k < count; k++)
                        //_ranks[k] = ranksAllList[i++];
                        _ranks[k] = ranks[k];

                    unitsRanks.Add(id_unit_slice_, _ranks);
                }

                int[] ranksAllArr = new int[ranksAllList.Count];
                IDictionary<string, int>[] enumRanksArr = new IDictionary<string, int>[enumRanksList.Count];


                ranksAllList.CopyTo(ranksAllArr, 0);
                enumRanksList.CopyTo(enumRanksArr, 0);

                o.Ranks = ranksAllArr;
                o.EnumRanks = enumRanksArr;
                o.Units = unitsRanks;
                o.setServices(unit.Services);

                o.ActualParametersTop = unit.ActualParametersTop;

                if (my_rank == 0) Console.WriteLine("END");

                o.setActualParameters(actualParameters_new);
                o.createSlices();

                slices.Add(o);

                return o;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine(e.StackTrace);
                throw e;
            }
        }

        private IDictionary<string, System.Type> checked_types = new Dictionary<string, System.Type>();

        private void fetchParameters(IDictionary<string, int> actualParameters,
                                            int id_functor_app_owner,
                                            int id_abstract,
                                            Interface the_interface,
                                            out IDictionary<string, Interface> parameters)
        {
            parameters = new Dictionary<string, Interface>();

            foreach (Slice i in BackEnd.sdao.listByInterface(id_abstract, the_interface.Id_interface))
            {
                InnerComponent ic = BackEnd.icdao.retrieve(i.Id_abstract, i.Id_inner);

                int id_abstract_inner = ic.Id_abstract_inner;

                int id_functor_app_inner = ic.Id_functor_app;
                string parameter_top = ic.Parameter_top;
                string id_interface_slice = i.Id_interface_slice;

                Interface iSlice = BackEnd.idao.retrieve(id_abstract_inner, id_interface_slice);

                if (parameter_top != null && !parameter_top.Equals(""))
                {
                    bool achei = true;
                    if (!actualParameters.TryGetValue(parameter_top, out id_functor_app_inner))
                        if (!actualParameters.TryGetValue(parameter_top + "#" + id_functor_app_owner, out id_functor_app_inner))
                        {
                            achei = false;
                        }

                    if (achei)
                    {
                        iSlice = fetchActualInterface(actualParameters, id_functor_app_inner, parameter_top, i.Id_interface_slice);
                        id_interface_slice = iSlice.Id_interface;

                        if (!parameters.ContainsKey(parameter_top))
                        {
                            parameters.Add(parameter_top, iSlice);
                        }

                        AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app_inner);
                        id_abstract_inner = acfa.Id_abstract;
                    }
                }

                IDictionary<string, Interface> sliceParameters = null;
                IDictionary<string, int> actualParameters_new = null;
                hpe.basic.Unit.determineActualParameters(actualParameters, ic.Id_functor_app, out actualParameters_new);
                fetchParameters(actualParameters_new, id_functor_app_inner, id_abstract_inner, iSlice, out sliceParameters);

                foreach (KeyValuePair<string, Interface> kvp in sliceParameters)
                {
                    string parid = kvp.Key;
                    string id_interface_bound = kvp.Value.Id_interface;

                    SupplyParameter sp = BackEnd.spdao.retrieve(parid, /*id_functor_app_inner*/ ic.Id_functor_app);

                    if (sp is SupplyParameterParameter)
                    {
                        SupplyParameterParameter spp = (SupplyParameterParameter)sp;
                        int id_functor_app_inner_;
                        if (!actualParameters.TryGetValue(spp.Id_parameter_actual, out id_functor_app_inner_))
                            if (!actualParameters.TryGetValue(spp.Id_parameter_actual + "#" + id_functor_app_inner, out id_functor_app_inner_))
                            {
                            }
                        if (id_functor_app_inner_ > 0 && !parameters.ContainsKey(spp.Id_parameter_actual))
                            parameters.Add(spp.Id_parameter_actual, fetchActualInterface(actualParameters, id_functor_app_inner_, spp.Id_parameter_actual, id_interface_bound));
                    }
                }
            }
        }

        private Interface fetchActualInterface(IDictionary<string, int> actualParameters,
                                                      int id_functor_app_actual,
                                                      string parid,
                                                      string id_interface)
        {
            IDictionary<string, Interface> mybot = new Dictionary<string, Interface>();
            IDictionary<string, Interface> mysup = new Dictionary<string, Interface>();
            IDictionary<string, int> myacf = new Dictionary<string, int>();
            Stack<string> inames = new Stack<string>();
            AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app_actual);
            AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(acfa.Id_abstract);
            foreach (Interface i in BackEnd.idao.list(acfa.Id_abstract))
            {
                Interface iSuper = null;
                if (acf.Id_functor_app_supertype > 0)
                {
                    AbstractComponentFunctorApplication acfa2 = BackEnd.acfadao.retrieve(acf.Id_functor_app_supertype);
                    iSuper = BackEnd.idao.retrieve(acfa2.Id_abstract, i.Id_interface_super);
                }
                inames.Push(i.Id_interface);
                mybot.Add(i.Id_interface, i);
                mysup.Add(i.Id_interface, iSuper);
                myacf.Add(i.Id_interface, i.Id_abstract);
            }

            while (inames.Count > 0)
            {
                string id_interface_ = inames.Pop();
                Interface interface_top = null;
                int id_abstract;

                mybot.TryGetValue(id_interface_, out interface_top);
                myacf.TryGetValue(id_interface_, out id_abstract);

                if (id_interface_.Equals(id_interface))
                {
                    return interface_top;
                }
                else
                {
                    AbstractComponentFunctor acf2 = BackEnd.acfdao.retrieve(id_abstract);
                    if (acf2.Id_functor_app_supertype > 0)
                    {
                        Interface iSuper = null;
                        if (mysup.TryGetValue(id_interface_, out iSuper))
                        {
                            if (iSuper != null)
                            {
                                Interface iSuperSuper = null;
                                AbstractComponentFunctorApplication acfa3 = BackEnd.acfadao.retrieve(acf2.Id_functor_app_supertype);
                                AbstractComponentFunctor acf3 = BackEnd.acfdao.retrieve(acfa3.Id_abstract);
                                if (acf3.Id_functor_app_supertype > 0)
                                {
                                    AbstractComponentFunctorApplication acfa4 = BackEnd.acfadao.retrieve(acf3.Id_functor_app_supertype);
                                    iSuperSuper = BackEnd.idao.retrieve(acfa4.Id_abstract, iSuper.Id_interface_super);
                                }

                                inames.Push(iSuper.Id_interface);
                                mybot.Add(iSuper.Id_interface, interface_top);
                                mysup.Add(iSuper.Id_interface, iSuperSuper);
                                myacf.Add(iSuper.Id_interface, iSuper.Id_abstract);
                            }
                            else
                            {
                                // top of the interface reached ... 
                            }
                        }
                        else
                        {
                            Console.Error.WriteLine("(fetchActualInterface) id_functor_app_actual " + id_functor_app_actual + " not found in acfadao.");
                            throw new Exception("(fetchActualInterface) id_functor_app_actual " + id_functor_app_actual + " not found in acfadao.");
                        }
                    }
                }
            }



            return null;
        }

        private IList<IUnit> slices = null;

        private void insertEnumeratorFusions(IUnit o, string id_unit_slice, IList<IDictionary<string, int>> enumRanks)
        {
            int id_abstract = o.Id_abstract;
            IDictionary<string, IList<string>> mapping = new Dictionary<string, IList<string>>();

            IDictionary<string, int> d0 = enumRanks[0];
            foreach (KeyValuePair<string, int> k in d0)
            {
                IList<EnumeratorMapping> emList = BackEnd.exmdao.list(id_abstract, k.Key);
                if (emList.Count > 0)
                {
                    IList<string> l = new List<string>();
                    foreach (EnumeratorMapping em in emList)
                    {
                        if (!k.Key.Equals(em.Id_enumerator_inner))
                        {
                            l.Add(em.Id_enumerator_inner);

                            hpe.kinds.IEnumeratorKind ec;
                            if (o.getPermutation(k.Key, out ec))
                            {
                                o.addPermutation(em.Id_enumerator_inner, ec);
                            }
                        }
                    }
                    mapping.Add(k.Key, l);
                }
            }

            IDictionary<IDictionary<string, int>,
                        IDictionary<string, int>> ttt = new Dictionary<IDictionary<string, int>,
                                                                       IDictionary<string, int>>();

            foreach (IDictionary<string, int> d in enumRanks)
            {
                IDictionary<string, int> aux = new Dictionary<string, int>();
                foreach (KeyValuePair<string, int> k in d)
                {
                    IList<string> l;
                    if (mapping.TryGetValue(k.Key, out l))
                    {
                        foreach (string ee in l)
                        {
                            aux.Add(ee, k.Value);
                        }
                    }
                }
                ttt.Add(d, aux);
            }

            foreach (KeyValuePair<IDictionary<string, int>, IDictionary<string, int>> aux in ttt)
            {
                IDictionary<string, int> d = aux.Key;
                foreach (KeyValuePair<string, int> a in aux.Value)
                {
                    d.Add(a);

                }
            }

        }

        private IDictionary<string, int> removePrefixes(string id_inner, IDictionary<string, int> d)
        {
            IDictionary<string, int> d2 = new Dictionary<string, int>();
            foreach (KeyValuePair<string, int> kvp in d)
            {
                int c = kvp.Key.IndexOf(id_inner + ".");
                if (c >= 0)
                {
                    d2.Add(kvp.Key.Substring(c + (id_inner + ".").Length), kvp.Value);
                }
                else
                {
                    d2.Add(kvp.Key, kvp.Value);
                }
            }
            return d2;
        }
	

    }

       

        
}
