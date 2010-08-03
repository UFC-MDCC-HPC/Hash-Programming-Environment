﻿using System;
using System.IO;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using System.Collections.Generic;
using System.Reflection;
using HPE_DGAC_LoadDB;
using hpe.basic;
using DGAC.utils;
using DGAC.database;
using System.Data;
using System.Collections;
using System.Reflection.Emit;


namespace DGAC
{


    public interface IBackEnd
    {
        void registerConcreteComponent(ComponentType ct, string userName, string password, string curDir);
        void registerAbstractComponent(ComponentType ct, string userName, string password, string curDir);
        void deleteComponent(String ID);
        String[] runApplication(int id_concrete, String[] eIds, int[] eVls, string userName, string password, string curDir);
        EnvironmentType readEnvironment();

    }//IDGAC 

    /*
    * Essa classe é chamada pelo WS. Nela, as referencias aos workers são inicializadas. Para isto, os workers
    * já devem ter sido inicializados manualmente e identificados dentro do arquivo properties.xml, na pasta config
    */

   


    public class BackEnd : IBackEnd
    {
        IpcClientChannel ch;

        public BackEnd()
        {
             Console.WriteLine("DGAC is up and running.");
        }

        public ServerObject connectToWorker() {
            IDictionary prop = new Hashtable();
            prop["portName"] = "WorkerHostClient";
            //prop["authorizedGroup"] = "Everyone";
            ch = new IpcClientChannel(prop,null);
             ChannelServices.RegisterChannel(ch, false);
             if (RemotingConfiguration.IsWellKnownClientType(typeof(ServerObject)) == null) {
                RemotingConfiguration.RegisterWellKnownClientType(typeof(ServerObject), "ipc://WorkerHost/WorkerHost.rem");
             }
             return new ServerObject();
        }

        public void releaseWorker() {
             //ch.StopListening(null);
             ChannelServices.UnregisterChannel(ch);
        }

        //TODO: este metodo ainda deve ser trabalhado para dinamicidade
        //Este método deve receber o xml rerente a uma configuração e formar as referencias necessárias a sua compilação
        //o qual será enviado aos workers		
        public void registerAbstractComponent(ComponentType ct, string userName, string password, string curDir)
        {
            try
            {
                Connector.openConnection();
                Connector.beginTransaction();
                ServerObject worker = connectToWorker();

                bool exists = false;
                LoaderAbstractComponent abstractloader = new LoaderAbstractComponent();
                AbstractComponentFunctor cAbs = null;
                HashComponent cAbs_ = null;

                abstractloader.componentExists(ct.header.hash_component_UID, out cAbs_);
                if (cAbs_ == null)
                {
                    cAbs = (AbstractComponentFunctor)abstractloader.loadComponent(ct);
                }
                else
                {
                
                   cAbs = (AbstractComponentFunctor)cAbs_;
                  // ComponentDAO cdao = new ComponentDAO();
				   IList<Component> cList = cdao.retrieveThatImplements(cAbs.Id_abstract);
				   if (true/*cList.Count == 0*/) {	                        					
                      Console.Error.WriteLine("Abstract component " + ct.header.packagePath + "." + ct.header.name + " is already deployed. Updating sources ...");
                      abstractloader.updateSources(ct, cAbs);
                      exists = true;
				   } else {
					  throw new Exception("DEPLOY ERROR: One or more concrete components already implement this abstract component.\n Updates are not allowed for keeping consistency.");	
				   }
                }

                ICollection<LoaderApp.InfoCompile> infoCompile = LoaderApp.getReferences_Abstract(cAbs.Id_abstract);

               // InterfaceDAO idao = new InterfaceDAO();
                    
                foreach (LoaderApp.InfoCompile interfaceToCompile in infoCompile)
                {
                    int id_abstract = interfaceToCompile.id;
                    string moduleName = interfaceToCompile.moduleName;
                    string interfaceName = interfaceToCompile.unitId;
                    string sourceCode = interfaceToCompile.sourceCode;
                    string cuid = interfaceToCompile.cuid;
                    string library_path = interfaceToCompile.library_path;
                    int outputType = interfaceToCompile.output_type;

                    string publicKey = this.sendCompileCommandToWorker(library_path,
                                                                       worker,
                                                                       sourceCode,
                                                                       moduleName,
                                                                      interfaceToCompile.references,
                                                                       outputType,
                                                                       userName,
                                                                       password,
                                                                       curDir);

                    if (!exists)
                        idao.setPublicKey(id_abstract, interfaceName, publicKey);
                }

                Connector.commitTransaction(); // if it is ok, commit ...

            }
            catch (Exception e)
            {
                Connector.rollBackTransaction();
                throw e;
            }
            finally
            {
                releaseWorker();
                Connector.closeConnection();
            }
        }

        //TODO: este metodo ainda deve ser trabalhado para dinamicidade
        //Este método deve receber o xml rerente a uma configuração e formar as referencias necessárias a sua compilação
        //o qual será enviado aos workers		
        public void registerConcreteComponent(ComponentType ct, string userName, string password, string curDir)
        {
            try
            {
                Connector.openConnection();
                Connector.beginTransaction();

                ServerObject worker = connectToWorker();

                bool exists = false;
                LoaderConcreteComponent concreteloader = new LoaderConcreteComponent();
                Component cConc = null;
                HashComponent cConc_ = null;

                concreteloader.componentExists(ct.header.hash_component_UID, out cConc_);
                if (cConc_ == null)
                {
                    cConc = (Component)concreteloader.loadComponent(ct);
                }
                else
                {
                    Console.Error.WriteLine("Concrete component " + ct.header.packagePath + "." + ct.header.name + " is already deployed. Updating ...");
                    cConc = (Component)cConc_;
                    concreteloader.updateSources(ct, cConc);
                    exists = true;
                }


                ICollection<LoaderApp.InfoCompile> infoCompile = LoaderApp.getReferences_Concrete(cConc.Id_concrete);

           //     UnitDAO udao = new UnitDAO();

                foreach (LoaderApp.InfoCompile unitToCompile in infoCompile)
                {
                    int id_concrete = unitToCompile.id;
                    string cuid = unitToCompile.cuid;
                    string library_path = unitToCompile.library_path;
                    string moduleName = unitToCompile.moduleName;
                    string unitName = unitToCompile.unitId;
                    string sourceCode = unitToCompile.sourceCode;
                    int outputType = unitToCompile.output_type;

                    string publicKey = this.sendCompileCommandToWorker(library_path,
                                                                       worker,
                                                                       sourceCode,
                                                                       moduleName,
                                                                       unitToCompile.references,
                                                                       outputType,
                                                                       userName,
                                                                       password,
                                                                       curDir);
                    if (!exists)
                        udao.setPublicKey(id_concrete, unitName, publicKey);
                }

                Connector.commitTransaction(); // if it is ok, commit ...

            }
            catch (Exception e)
            {
                Connector.rollBackTransaction();
                throw e;
            }
            finally
            {
                Connector.closeConnection();
                releaseWorker();
            } 
        }

        public void deleteComponent(String ID)
        {

        }


        private string sendCompileCommandToWorker(string library_path, ServerObject worker, string contents, string moduleName, string[] refs, int outFile, string userName, string password, String curDir)
        {
            return worker.compileClass(library_path, contents, moduleName, refs, outFile, userName, password, curDir);
        }

        private void sendRunCommandToWorker(ServerObject worker, IDictionary<string, int> files, IDictionary<string, int> enums, int session_id, string userName, string password, String curDir)
        {
            worker.runClass(files, enums, session_id, userName, password, curDir);
        }

        public static int session_id = -1;

        public static void DGACInit(string hash_component_uid, string my_id_unit, hpe.basic.IUnit pmain, string[] args)
        {
            slices = new List<hpe.basic.IUnit>();

            session_id = getSessionID(args);

            if (session_id >= 0)
                RedirectOutput(session_id);
            else
                open_log_out = false;

            //openConnection(); 
            Connector.openConnection();

          //  ComponentDAO cdao = new ComponentDAO();
            Component c = cdao.retrieve_uid(hash_component_uid);

            int id_abstract = c.Id_abstract;
            int id_concrete = c.Id_concrete;

            pmain.Id_concrete = id_concrete;
            pmain.Id_interface = my_id_unit;

            // AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();

            IDictionary<string, int> eInf = new Dictionary<string, int>();
            IDictionary<string, int> eSup = new Dictionary<string, int>();

           // if (firstPass) { System.Threading.Thread.Sleep(20000); firstPass = false; }

            pmain.EnumeratorCardinality = new Dictionary<string, int>();

          //  EnumeratorDAO edao = new EnumeratorDAO();
            IList<Enumerator> eList = edao.list(id_abstract);
            foreach (Enumerator e in eList)
            {
                int rangeInf_ = 0;
                int rangeSup_ = enumeratorCardinality(args, e.Variable);

                eInf.Add(e.Id_enumerator, rangeInf_);
                eSup.Add(e.Id_enumerator, rangeSup_);
                if (rangeSup_ > 0)
                    pmain.EnumeratorCardinality.Add(e.Id_enumerator, rangeSup_);
            }

          //  EnumerationInterfaceDAO eidao = new EnumerationInterfaceDAO();

            int rangeInf, rangeSup;

            int num_procs = 0;
            int rank = 0;

            pmain.Units = new Dictionary<string, int[]>();
            IList<IDictionary<string, int>> pmain_EnumRanks = new List<IDictionary<string, int>>();
            IList<int> pmain_Ranks = new List<int>();

            IList<string> id_units_ordered = acfdao.getIdUnitsOrdered(id_abstract);

            foreach (string id_unit in id_units_ordered)
            {
                if (id_unit.Equals(my_id_unit) && pmain.GlobalRank < 0)
                    pmain.GlobalRank = rank;

                IList<EnumerationInterface> eiList = exitdao.listByInterface(id_abstract, id_unit);

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

        private static int getSessionID(string[] args)
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

        public static void DGACFinalize()
        {
            foreach (hpe.basic.IUnit slice in slices)
            {
                slice.destroySlice();
            }

            Connector.closeConnection();
            if (open_log_out)
                log_out.Close();

        }

        private static StreamWriter log_out = null;
        private static string output_log_filename = "output";
        private static bool open_log_out = true;

        private static readonly DateTime Jan1st1970 = new DateTime
            (1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);

        public static long currentTimeMillis()
        {
            return (long)(DateTime.UtcNow - Jan1st1970).TotalMilliseconds;
        }

        private static void RedirectOutput(int session_id)
        {
            try
            {
                string filename = Constants.PATH_BIN + output_log_filename + "." + session_id + "." + currentTimeMillis();
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

        private static int globalRank(string[] args)
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



        private static int enumeratorCardinality(string[] args, string var)
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

        public static void openConnection()
        {
            Connector.openConnection();
            Connector.beginTransaction();
        }

        public static void closeConnection(bool commit)
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

        private static void dictReplaceKey(IDictionary<string, int> dict, string key, int value)
        {
            if (dict.ContainsKey(key))
            {
                dict.Remove(key);
            }
            dict.Add(key, value);
        }

        private static bool findReplicator(hpe.basic.IUnit unit, KeyValuePair<string, int> re,
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
                lse = sedao.listContainers(s.Id_inner, s.Id_interface_slice, s.Id_abstract, s.Id_split_replica);

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
                InnerComponentExposed ice = icedao.retrieve(id_abstract, id_inner_container, id_inner);

              //  InnerComponentDAO icdao = new InnerComponentDAO();
                InnerComponent ic_owner = icdao.retrieve(ic.Id_abstract_owner, ice.Id_inner_owner);
                InnerComponent ic_prime = icdao.retrieve(ic_owner.Id_abstract_inner, ice.Id_inner);

              //  SliceDAO sdao = new SliceDAO();
                Slice s_prime = null;

                foreach (SliceExposed se in seMap)
                {
                    s_prime = sdao.retrieve2(ic_prime.Id_abstract_owner, ice.Id_inner, se.Id_interface_slice, se.Id_interface_slice_owner);
                    if (s_prime != null)
                        break;
                   // else
                   //     Console.WriteLine("Fetched in seMap : " + se.Id_interface_slice_owner);
                }

                IList<EnumeratorMapping> emList = exmdao.list(ic_prime.Id_abstract_owner, ke_prime.Key);

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

                IList<EnumeratorMapping> emList = exmdao.list(ic.Id_abstract_inner, ke_prime.Key);

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

        private static IDictionary<string, Type> instanceCache;

        // CREATE AN INSTANCE OF A SEQUENCIAL #-COMPONENT (Only one unit is assumed)
        public static Object createInstance(Type T)
        {
            string library_path = T.FullName;

            return createInstance(library_path);
        }


        public static Object createInstance(string library_path)
        {
            return createInstance(library_path, new Type[] { });
        }

        public static Object createInstance(string library_path, Type[] typeParams)
        {
            Type closedT = null;

            if (instanceCache == null || !instanceCache.ContainsKey(library_path))
            {
                //          Connector.openConnection();

       //         InterfaceDAO idao = new InterfaceDAO();
                Interface i = idao.retrieve_libraryPath(library_path);

                int id_abstract = i.Id_abstract;

            //    ComponentDAO cdao = new ComponentDAO();
                Component c = cdao.retrieveThatImplements(id_abstract)[0];

       //         UnitDAO udao = new UnitDAO();
                database.Unit u = udao.retrieve(c.Id_concrete, i.Id_interface, 1);

                //              Connector.closeConnection();

                string assembly_string = u.Assembly_string;      // where to found the DLL (retrieve from the component).
                string class_name = u.Class_name;  // the name of the class inside the DLL.
                int class_nargs = u.Class_nargs;

                //IPImpl, Version=1.0.0.0, Culture=neutral, PublicKey=0024000004800000940000000602000000240000525341310004000001000100CD27D3A31B4F32440C52F63365D89A2D9527864AAEDC551F83D6345719CCD2937126770A203F67551BD45EA1D835E71AE79AEB8E46AC23829AF52F70D364268574D94DC912CB9A1458B90AABE649B0A6966BA5ECFE1599FEA3969F2B49A5E630821CE6BC8A65B9FB65FFDEF61AB4D07C32B242CEEEFCBDC5151D2B7ABB6D87B0, processorArchitecture=MSIL

                Assembly a = Assembly.Load(assembly_string);

                string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");
                Type t = a.GetType(strType);
                closedT = typeParams.Length > 0 ? t.MakeGenericType(typeParams) : t;

                if (instanceCache == null) instanceCache = new Dictionary<string, Type>();
                instanceCache.Add(library_path, closedT);
            }
            else
            {
                instanceCache.TryGetValue(library_path, out closedT);
            }

            hpe.basic.IUnit o = (hpe.basic.IUnit)Activator.CreateInstance(closedT);

            return o;

        }

        public static hpe.basic.IUnit loadImpl(hpe.basic.IUnit unit,
                                       Component c,
                                       string id_inner,
                                       string id_interface,
                                       string propertyName, IDictionary<string,int> actualParameters_new)
        {
            //        Connector.openConnection();


            // Console.WriteLine(unit.GlobalRank + ": CREATE SLICE BEGIN !!! " + c.Library_path + " : " + id_inner + " : " + id_interface);

            int id_abstract = c.Id_abstract;
            database.Unit u = LoaderApp.resolveImpl(unit, c.Id_concrete, id_inner, id_interface);

           // InnerComponent ic = icdao.retrieve(id_abstract, id_inner);
            Component cu = cdao.retrieve(u.Id_concrete);

        /*    IDictionary<string, Interface> theParameters = null;
            fetchParameters(actualParameters_new, 
                            cu.Id_functor_app, 
                            u.Id_interface_abstract, 
                            idao.retrieve(u.Id_interface_abstract,
                                          u.Id_interface_interface), 
                            out theParameters); */
            Type[] actualParams;



            if (u == null)
            {
                throw new ConcreteComponentNotFoundException(id_abstract, id_inner, c.Id_functor_app);
            }

            string assembly_string = u.Assembly_string;      // where to found the DLL (retrieve from the component).
            string class_name = u.Class_name;  // the name of the class inside the DLL.
            int class_nargs = u.Class_nargs;

            Assembly a = Assembly.Load(assembly_string);

            string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");
            Type t = a.GetType(strType);

            buildParamTable(propertyName, unit.GetType(), out actualParams);

            Type closedT = actualParams.Length > 0 ? t.MakeGenericType(actualParams) : t;

            hpe.basic.IUnit o = (hpe.basic.IUnit)Activator.CreateInstance(closedT);

            o.Id_concrete = u.Id_concrete;
            o.Id_interface = u.Id_interface_interface;
            o.ContainerSlice = unit;
            o.GlobalRank = unit.GlobalRank;

            return o;
        }

        private static IDictionary<int, Type> paramTable = new Dictionary<int, Type>();

        private static void buildParamTable(String propertyName, Type myType, out Type[] actualParams)
        {
            
            Type o = myType.BaseType.GetProperty(propertyName, BindingFlags.NonPublic | BindingFlags.Instance).PropertyType;

            actualParams = o.GetGenericArguments();
        }

        /* REMARK: The type params MUST be provided externally, because the actual type information is not in the DGAC's database.
         */

        private static bool firstPass = true;

        public static hpe.basic.IUnit createSlice(hpe.basic.IUnit unit,
                                                  string hash_component_uid,
                                                  string id_inner,
                                                  string id_interface,
                                                  Type[] typeParams /* obsolete - calculated at run-time by buildParamsTable */
                                                 )
        {
            Component c = cdao.retrieve_uid(hash_component_uid);
            int id_abstract = c.Id_abstract;

        //    Console.Write("BEGIN createSlice !!!! " + id_abstract + "," + id_inner + "," + id_interface + "..... ");

            InnerComponent ic = icdao.retrieve(id_abstract, id_inner);

            IDictionary<string, int> actualParameters_new = null;
            // hpe.basic.Unit.determineActualParameters(unit.ActualParameters, ic.Id_functor_app, out actualParameters_new);
            hpe.basic.Unit.determineActualParameters2(unit, ic, out actualParameters_new);
           
            Slice slice = sdao.retrieve2(id_abstract,id_inner,id_interface,unit.Id_interface);

            hpe.basic.IUnit o = loadImpl(unit, c, id_inner, id_interface, slice.PropertyName, actualParameters_new); // (hpe.basic.IUnit)Activator.CreateInstance(closedT);
            
            // Configure the knowledge of the slices about the topology.

            IDictionary<string, int> eix_inner = new Dictionary<string, int>();

            // Console.WriteLine(" ------ unit.EnumRank has " + unit.EnumRank.Count + " elements");

            IDictionary<string, IList<KeyValuePair<string, int>>> enumsByVars = new Dictionary<string, IList<KeyValuePair<string, int>>>();

            // Console.WriteLine("unit.EnumRank.Count = " + unit.EnumRank.Count);
            
            foreach (KeyValuePair<string, int> index in unit.EnumRank)
            {
                Enumerator e = edao.retrieve(id_abstract, index.Key);
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
                    EnumerationSlice es = exsdao.retrieve(id_abstract, id_inner, id_interface, eix);
                    if (es == null)      // If not, the inner component must be. Otherwise, this is stuck configuration.
                    // REMARK: With enumerators, this is possible now.
                    {
                        EnumerationInner ei = exindao.retrieve(id_abstract, id_inner, eix);
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

       //     SliceDAO sdao = new SliceDAO();

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
           //     AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
                AbstractComponentFunctorApplication acfa = acfadao.retrieve(id_functor_app_inner_actual);
                id_abstract_inner_actual = acfa.Id_abstract;
                ic.Id_abstract_inner = id_abstract_inner_actual;
            }

            o.Id_functor_app = ic.Id_functor_app;
            o.Id_abstract = ic.Id_abstract_inner;

            //IList<Slice> ss = sdao.listByInnerInInterface(id_abstract, id_inner, unit.Id_interface);
            IList<Slice> ss = sdao.listByInner(id_abstract, id_inner);
            IDictionary<string, IList<int>> ranksAll = new Dictionary<string, IList<int>>();
            Dictionary<string, int> countUnits = new Dictionary<string, int>();
            IDictionary<string, IList<IDictionary<string, int>>> enumRanksL = new Dictionary<string, IList<IDictionary<string, int>>>();

            IDictionary<string, string> unitsMapping = new Dictionary<string, string>();

          //  AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
            IList<string> id_units_ordered = acfdao.getIdUnitsOrdered(id_abstract_inner_original);
            IList<string> id_units_ordered_actual = acfdao.getIdUnitsOrdered(id_abstract_inner_actual);
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
                            Enumerator e = edao.retrieve(id_abstract, index.Key);
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
                            Enumerator enumerator = edao.retrieve(id_abstract, e.Key);
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

            o.ActualParametersTop = unit.ActualParametersTop;

//            Console.WriteLine("END");

            o.setActualParameters(actualParameters_new);
            o.createSlices();

            slices.Add(o);

            return o;
        }

        private static IDictionary<string, Type> checked_types = new Dictionary<string, Type>();
      
        private static void fetchParameters(IDictionary<string, int> actualParameters,
                                            int id_functor_app_owner,
                                            int id_abstract, 
                                            Interface the_interface, 
                                            out IDictionary<string, Interface> parameters)
        {
            parameters = new Dictionary<string, Interface>();

            foreach (Slice i in sdao.listByInterface(id_abstract, the_interface.Id_interface))
            {
                InnerComponent ic = icdao.retrieve(i.Id_abstract, i.Id_inner);

                int id_abstract_inner = ic.Id_abstract_inner;

                int id_functor_app_inner = ic.Id_functor_app;
                string parameter_top = ic.Parameter_top;
                string id_interface_slice = i.Id_interface_slice;

                Interface iSlice = idao.retrieve(id_abstract_inner, id_interface_slice);

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

                        AbstractComponentFunctorApplication acfa = acfadao.retrieve(id_functor_app_inner);
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

                    SupplyParameter sp = spdao.retrieve(parid, /*id_functor_app_inner*/ ic.Id_functor_app );
                    
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

        private static Interface fetchActualInterface(IDictionary<string, int> actualParameters, 
                                                      int id_functor_app_actual, 
                                                      string parid, 
                                                      string id_interface)
        {
                IDictionary<string, Interface> mybot = new Dictionary<string, Interface>();
                IDictionary<string, Interface> mysup = new Dictionary<string, Interface>();
                IDictionary<string, int> myacf = new Dictionary<string, int>();
                Stack<string> inames = new Stack<string>();
                AbstractComponentFunctorApplication acfa = acfadao.retrieve(id_functor_app_actual);
                AbstractComponentFunctor acf = acfdao.retrieve(acfa.Id_abstract);
                foreach (Interface i in idao.list(acfa.Id_abstract))
                {
                    Interface iSuper = null;
                    if (acf.Id_functor_app_supertype > 0)
                    {
                        AbstractComponentFunctorApplication acfa2 = acfadao.retrieve(acf.Id_functor_app_supertype);
                        iSuper = idao.retrieve(acfa2.Id_abstract, i.Id_interface_super);
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
                        AbstractComponentFunctor acf2 = acfdao.retrieve(id_abstract); 
                        if (acf2.Id_functor_app_supertype > 0)
                        {
                            Interface iSuper = null;
                            if (mysup.TryGetValue(id_interface_, out iSuper))
                            {
                                if (iSuper != null)
                                {
                                    Interface iSuperSuper = null;
                                    AbstractComponentFunctorApplication acfa3 = acfadao.retrieve(acf2.Id_functor_app_supertype);
                                    AbstractComponentFunctor acf3 = acfdao.retrieve(acfa3.Id_abstract);
                                    if (acf3.Id_functor_app_supertype > 0)
                                    {
                                        AbstractComponentFunctorApplication acfa4 = acfadao.retrieve(acf3.Id_functor_app_supertype);
                                        iSuperSuper = idao.retrieve(acfa4.Id_abstract, iSuper.Id_interface_super);
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

        private static IList<hpe.basic.IUnit> slices = null;

        private static void insertEnumeratorFusions(IUnit o, string id_unit_slice, IList<IDictionary<string, int>> enumRanks)
        {
            int id_abstract = o.Id_abstract;
            IDictionary<string, IList<string>> mapping = new Dictionary<string, IList<string>>();

        //    EnumeratorMappingDAO emdao = new EnumeratorMappingDAO();
            IDictionary<string, int> d0 = enumRanks[0];
            foreach (KeyValuePair<string, int> k in d0)
            {
                IList<EnumeratorMapping> emList = exmdao.list(id_abstract, k.Key);
                if (emList.Count > 0)
                {
                    IList<string> l = new List<string>();
                    foreach (EnumeratorMapping em in emList)
                    {
                        if (!k.Key.Equals(em.Id_enumerator_inner))
                        {
                            l.Add(em.Id_enumerator_inner);
                            /*  int cardinality;
                              if (o.EnumeratorCardinality.TryGetValue(k.Key, out cardinality))
                              {
                                  Console.WriteLine(":-) &&&&& CARDINALITY FOUND : " + k.Key + ", " + em.Id_enumerator_inner + ", " + o.Id_abstract + ", " + o.Id_interface);
                                  o.EnumeratorCardinality.Add(em.Id_enumerator_inner, cardinality);
                              }
                              else
                              {
                                  Console.WriteLine(":-( &&&&& CARDINALITY NOT FOUND : " + k.Key + ", " + em.Id_enumerator_inner + ", " + o.Id_abstract + ", " + o.Id_interface);
                                  foreach (KeyValuePair<string, int> rrrr in o.EnumeratorCardinality)
                                  {
                                      Console.WriteLine(":-( &&&&& " + rrrr.Key + " , " + rrrr.Value);
                                  }
                              } */

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

        private static IDictionary<string, int> removePrefixes(string id_inner, IDictionary<string, int> d)
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


        public EnvironmentType readEnvironment()
        {
            Connector.openConnection();

            EnvironmentType env = new EnvironmentType();

            IList<DeployedComponentInfoType> eabs = readEnvironmentAbstract();
            IList<DeployedComponentInfoType> econ = readEnvironmentConcrete();

            Connector.closeConnection();

            env.deployed = new DeployedComponentInfoType[eabs.Count + econ.Count];

            eabs.CopyTo(env.deployed, 0);
            econ.CopyTo(env.deployed, eabs.Count);

            return env;
        }

        private IList<DeployedComponentInfoType> readEnvironmentConcrete()
        {
            IList<DeployedComponentInfoType> l = new List<DeployedComponentInfoType>();

         //   ComponentDAO cdao = new ComponentDAO();
            IList<Component> cList = cdao.list();

            foreach (Component c in cList)
            {
                DeployedComponentInfoType deployed = new DeployedComponentInfoType();

                string[] packagePath = c.Library_path.Split('.');

                int id_abstract = c.Id_abstract;

                deployed.abstractSpecified = false;
                deployed.@abstract = false;
                deployed.package = new string[packagePath.Length - 1];
                Array.Copy(packagePath, 0, deployed.package, 0, packagePath.Length - 1);
                deployed.name = packagePath[packagePath.Length - 1];
                deployed.cidSpecified = true;
                deployed.cid = c.Id_concrete;
                deployed.cidBaseSpecified = true;
                deployed.cidBase = id_abstract;
                deployed.kind = c.Kind;
                // deployed.locationURI;
                deployed.enumerator = readEnvironmentEnumerators(id_abstract);
                deployed.parameter = readEnvironmentConcreteParameters(c.Id_functor_app);

                l.Add(deployed);
            }

            return l;
        }

        private DeployedParameterType[] readEnvironmentConcreteParameters(int id_functor_app)
        {
         //   AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
          //  AbstractComponentFunctorParameterDAO acfpdao = new AbstractComponentFunctorParameterDAO();

         //   SupplyParameterDAO spdao = new SupplyParameterDAO();
            IList<SupplyParameter> spList = spdao.list(id_functor_app);

            DeployedParameterType[] r = new DeployedParameterType[spList.Count];

            int i = 0;
            foreach (SupplyParameterComponent sp in spList)
            {
                r[i] = new DeployedParameterType();
                r[i].parameter_id = sp.Id_parameter;
                // AbstractComponentFunctorParameter acfp = acfpdao.retrieve(sp.Id_abstract, sp.Id_parameter);
                // r[i].bound = acfp.Bounds_of;
                AbstractComponentFunctorApplication acfa = acfadao.retrieve(sp.Id_functor_app_actual);
                r[i].actualSpecified = true;
                r[i].actual = acfa.Id_abstract;
                r[i].parameter = readEnvironmentConcreteParameters(sp.Id_functor_app_actual);
                i++;
            }

            return r;
        }

        private IList<DeployedComponentInfoType> readEnvironmentAbstract()
        {
            IList<DeployedComponentInfoType> l = new List<DeployedComponentInfoType>();

      //      AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
            IList<AbstractComponentFunctor> acfList = acfdao.list();

            foreach (AbstractComponentFunctor acf in acfList)
            {
                DeployedComponentInfoType deployed = new DeployedComponentInfoType();

                string[] packagePath = acf.Library_path.Split('.');

                deployed.abstractSpecified = true;
                deployed.@abstract = true;
                deployed.package = new string[packagePath.Length - 1];
                Array.Copy(packagePath, 0, deployed.package, 0, packagePath.Length - 1);
                deployed.name = packagePath[packagePath.Length - 1];
                deployed.cidSpecified = true;
                deployed.cid = acf.Id_abstract;
                deployed.cidBaseSpecified = false;
                deployed.kind = acf.Kind;
                // deployed.locationURI; 
                deployed.enumerator = readEnvironmentEnumerators(acf.Id_abstract);
                deployed.parameter = readEnvironmentAbstractParameters(acf.Id_abstract);

                l.Add(deployed);
            }

            return l;
        }

        private string[] readEnvironmentEnumerators(int id_abstract)
        {
       //     EnumeratorDAO edao = new EnumeratorDAO();
         //   EnumerationInterfaceDAO eidao = new EnumerationInterfaceDAO();
        //    InterfaceDAO idao = new InterfaceDAO();

            IList<string> rList = new List<string>();
            IList<DGAC.database.Interface> iList = idao.list(id_abstract);

            foreach (DGAC.database.Interface i in iList)
            {
                IList<EnumerationInterface> eiList = exitdao.listByInterface(id_abstract, i.Id_interface);
                foreach (EnumerationInterface ei in eiList)
                {
                    Enumerator e = edao.retrieve(ei.Id_abstract, ei.Id_enumerator);
                    if (e.Valuation == -1 && !rList.Contains(e.Variable))
                    {   
                        rList.Add(e.Variable);
                    }
                }
            }

            string[] r = new string[rList.Count];
            rList.CopyTo(r, 0);

            return r;
        }

        private DeployedParameterType[] readEnvironmentAbstractParameters(int id_abstract)
        {
       //     AbstractComponentFunctorParameterDAO acfpdao = new AbstractComponentFunctorParameterDAO();
       //     AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();

            IList<AbstractComponentFunctorParameter> acfpList = acfpdao.list(id_abstract);
            DeployedParameterType[] r = new DeployedParameterType[acfpList.Count];
            int i = 0;
            foreach (AbstractComponentFunctorParameter acfp in acfpList)
            {
                r[i] = new DeployedParameterType();
                r[i].parameter_id = acfp.Id_parameter;
                r[i].actualSpecified = true;
                AbstractComponentFunctorApplication acfa = acfadao.retrieve(acfp.Bounds_of);
                r[i].actual = acfa.Id_abstract;
                r[i].parameter = readEnvironmentAbstractParameters(acfa.Id_abstract);
                i++;
            }
            return r;
        }


        // private string session_id = -1;

        public String[] runApplication(int id_concrete, String[] eIds, int[] eVls, string userName, string password, string curDir)
        {     
            ServerObject worker = connectToWorker();
            worker.createInstance();
            return new string[] { };
        }

        public String[] runApplication2(int id_concrete, String[] eIds, int[] eVls, string userName, string password, string curDir)
        {
            String[] str_output = null;
            // assert: eIds.Length = eVls.Length
            try
            {
                ServerObject server = connectToWorker();
                Connector.openConnection();

                session_id = getSessionID(id_concrete);

                IDictionary<string, int> files = new Dictionary<string, int>();
                IDictionary<string, int> enums = new Dictionary<string, int>();

                int nprocs = 0;

                try
                {
                    for (int i = 0; i < eIds.Length; i++)
                        enums.Add(eIds[i], eVls[i]);
                }
                catch (ArgumentException)
                {
                    throw new Exception("Argument Exception there 2 !!!!");
                }


                Component c = cdao.retrieve(id_concrete);

                // IList<DGAC.database.Unit> uList = udao.list(id_concrete);
                IList<DGAC.database.Interface> iList = BackEnd.idao.list(c.Id_abstract); 

                foreach (DGAC.database.Interface i in iList)
                {
                    DGAC.database.Unit u = BackEnd.udao.retrieve(c.Id_concrete, i.Id_interface, -1);
                    IList<EnumerationInterface> eiList = exitdao.listByInterface(c.Id_abstract, i.Id_interface);
                    int count = 1;
                    IDictionary<string, int> m = new Dictionary<string, int>();
                    foreach (EnumerationInterface ei in eiList)
                    {
                        Enumerator e = edao.retrieve(ei.Id_abstract, ei.Id_enumerator);
                        int v;
                        if (!m.TryGetValue(e.Variable, out v))
                        {
                            v = 1;
                            enums.TryGetValue(e.Variable, out v);
                            count *= v > 0 ? v : 1;
                            m.Add(e.Variable, v);
                        }
                    }
                    char[] char_sep = new char[] { '.' };
                    String[] class_name_arr = u.Class_name.Split(char_sep);
                    try
                    {
                        files.Add(class_name_arr[class_name_arr.Length - 1], count);
                    }
                    catch (ArgumentException)
                    {
                        throw new Exception("Argument Exception there !");
                    }
                    nprocs += count;
                }

                sendRunCommandToWorker(server, files, enums, session_id, userName, password, curDir);

                str_output = new String[nprocs];

                int count_procs = 0;
                DirectoryInfo di = new DirectoryInfo(Constants.PATH_BIN);
                FileInfo[] rgFiles = di.GetFiles("output." + session_id + "*");
                foreach (FileInfo fi in rgFiles)
                {
                    TextReader tr = new StreamReader(fi.DirectoryName + Path.DirectorySeparatorChar + fi.Name);
                    str_output[count_procs++] = tr.ReadToEnd();
                    tr.Close();
                }
            }
            catch (Exception e)
            {
                throw e;
            }
            finally
            {
                Connector.closeConnection();
                releaseWorker();
            }

            return str_output == null ? new String[] { } : str_output;
        }

        private int getSessionID(int id_concrete)
        {
            int session_id = -1;
            String sql =
                "INSERT INTO sessions (id_concrete)" +
                " VALUES (" + id_concrete + ")";

            Connector.performSQLUpdate(sql);

            IDbCommand dbcmd = Connector.DBcon.CreateCommand();
            dbcmd.CommandText = "SELECT MAX(session_id) AS NEW_SESSION_ID FROM sessions ";
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                session_id = (int)reader["NEW_SESSION_ID"];
            }//if
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return session_id;
        }

        private static AbstractComponentFunctorDAO acfdao_ = null;
        private static AbstractComponentFunctorApplicationDAO acfadao_ = null;
        private static AbstractComponentFunctorParameterDAO acfpdao_ = null;
        private static InterfaceDAO idao_ = null;
        private static UnitDAO udao_ = null;
        private static InterfaceParameterDAO ipdao_ = null;
        private static SupplyParameterDAO spdao_ = null;
        private static SupplyParameterComponentDAO spcdao_ = null;
        private static SupplyParameterParameterDAO sppdao_ = null;
        private static ComponentDAO cdao_ = null;
        private static InnerComponentDAO icdao_ = null;
        private static InnerConcreteComponentDAO iccdao_ = null;
        private static InnerComponentExposedDAO icedao_ = null;
        private static SliceDAO sdao_ = null;
        private static UnitSliceDAO usdao_ = null;
        private static SourceCodeDAO scdao_ = null;
        private static SourceCodeReferenceDAO scrdao_ = null;
        private static SliceExposedDAO sedao_ = null;
        private static EnumeratorDAO exdao_ = null;
        private static EnumerationInnerDAO exindao_ = null;
        private static EnumerationSliceDAO exsdao_ = null;
        private static EnumerationInterfaceDAO exitdao_ = null;
        private static EnumeratorMappingDAO exmdao_ = null;
        private static EnumeratorSplitDAO exldao_ = null;
       
        public static AbstractComponentFunctorDAO acfdao { get { if (acfdao_ == null) acfdao_ = new AbstractComponentFunctorDAO(); return acfdao_; } }
        public static AbstractComponentFunctorApplicationDAO acfadao { get { if (acfadao_ == null) acfadao_ = new AbstractComponentFunctorApplicationDAO(); return acfadao_; } }
        public static AbstractComponentFunctorParameterDAO acfpdao { get { if (acfpdao_ == null) acfpdao_ = new AbstractComponentFunctorParameterDAO(); return acfpdao_; } }
        public static InterfaceDAO idao { get { if (idao_ == null) idao_ = new InterfaceDAO(); return idao_; } }
        public static InterfaceParameterDAO ipdao { get { if (ipdao_ == null) ipdao_ = new InterfaceParameterDAO(); return ipdao_; } }
        public static UnitDAO udao { get { if (udao_ == null) udao_ = new UnitDAO(); return udao_; } }
        public static SupplyParameterDAO spdao { get { if (spdao_ == null) spdao_ = new SupplyParameterDAO(); return spdao_; } }
        public static SupplyParameterComponentDAO spcdao { get { if (spcdao_ == null) spcdao_ = new SupplyParameterComponentDAO(); return spcdao_; } }
        public static SupplyParameterParameterDAO sppdao { get { if (sppdao_ == null) sppdao_ = new SupplyParameterParameterDAO(); return sppdao_; } }
        public static ComponentDAO cdao { get { if (cdao_ == null) cdao_ = new ComponentDAO(); return cdao_; } }
        public static InnerComponentDAO icdao { get { if (icdao_ == null) icdao_ = new InnerComponentDAO(); return icdao_; } }
        public static InnerConcreteComponentDAO iccdao { get { if (iccdao_ == null) iccdao_ = new InnerConcreteComponentDAO(); return iccdao_; } }
        public static InnerComponentExposedDAO icedao { get { if (icedao_ == null) icedao_ = new InnerComponentExposedDAO(); return icedao_; } }
        public static SliceDAO sdao { get { if (sdao_ == null) sdao_ = new SliceDAO(); return sdao_; } }
        public static UnitSliceDAO usdao { get { if (usdao_ == null) usdao_ = new UnitSliceDAO(); return usdao_; } }
        public static SourceCodeDAO scdao { get { if (scdao_ == null) scdao_ = new SourceCodeDAO(); return scdao_; } }
        public static SourceCodeReferenceDAO scrdao { get { if (scrdao_ == null) scrdao_ = new SourceCodeReferenceDAO(); return scrdao_; } }
        public static SliceExposedDAO sedao { get { if (sedao_ == null) sedao_ = new SliceExposedDAO(); return sedao_; } }
        public static EnumeratorDAO edao { get { if (exdao_ == null) exdao_ = new EnumeratorDAO(); return exdao_; } }
        public static EnumerationInnerDAO exindao { get { if (exindao_ == null) exindao_ = new EnumerationInnerDAO(); return exindao_; } }
        public static EnumerationSliceDAO exsdao { get { if (exsdao_ == null) exsdao_ = new EnumerationSliceDAO(); return exsdao_; } }
        public static EnumerationInterfaceDAO exitdao { get { if (exitdao_ == null) exitdao_ = new EnumerationInterfaceDAO(); return exitdao_; } }
        public static EnumeratorMappingDAO exmdao { get { if (exmdao_ == null) exmdao_ = new EnumeratorMappingDAO(); return exmdao_; } }
        public static EnumeratorSplitDAO exldao { get { if (exldao_ == null) exldao_ = new EnumeratorSplitDAO(); return exldao_; } }

    }//DGAC

    public class ConcreteComponentNotFoundException : Exception
    {
        private int id_abstract;
        private string id_inner;
        private int id_functor_app_implements;

        IDictionary<string, SupplyParameter> parsSuper = new Dictionary<string, SupplyParameter>();

        public ConcreteComponentNotFoundException(int id_abstract, string id_inner, int id_functor_app_implements)
            : base()
        {
            this.id_abstract = id_abstract;
            this.id_inner = id_inner;
            this.id_functor_app_implements = id_functor_app_implements;

         //   AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
         //   SupplyParameterDAO spdao = new SupplyParameterDAO();

            AbstractComponentFunctorApplication acfa = DGAC.BackEnd.acfadao.retrieve(id_functor_app_implements);

            // It is a parameter in the subtype. Check if it is supplied in the type.
            IList<SupplyParameter> spList = DGAC.BackEnd.spdao.list(acfa.Id_functor_app);
            foreach (SupplyParameter sp in spList)
                parsSuper.Add(sp.Id_parameter, sp);


        }

        public override string Message
        {
            get
            {
                return setupMessage(id_abstract, id_inner);
            }
        }

        private String setupMessage(int id_abstract, string id_inner)
        {
         //   InnerComponentDAO icdao = new InnerComponentDAO();

            InnerComponent ic = DGAC.BackEnd.icdao.retrieve(id_abstract, id_inner);

            string cname = buildName(ic.Id_functor_app);

            return "No implementation for " + cname + " was found !";
        }

        private string buildName(int id_functor_app)
        {
            string cname = "";

          //  AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
          //  SupplyParameterDAO spdao = new SupplyParameterDAO();
          //  AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();

            AbstractComponentFunctorApplication acfa = DGAC.BackEnd.acfadao.retrieve(id_functor_app);
            AbstractComponentFunctor acf = DGAC.BackEnd.acfdao.retrieve(acfa.Id_abstract);

            cname += acf.Library_path + "[";

            IList<SupplyParameter> spList = DGAC.BackEnd.spdao.list(id_functor_app);
            foreach (SupplyParameter sp in spList)
            {
                if (sp is SupplyParameterComponent)
                {
                    SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                    cname += spc.Id_parameter + "=" + buildName(spc.Id_functor_app_actual) + ",";
                }
                else if (sp is SupplyParameterParameter)
                {
                    SupplyParameterParameter spp = (SupplyParameterParameter)sp;
                    SupplyParameter sp_actual = null;
                    parsSuper.TryGetValue(spp.Id_parameter_actual, out sp_actual);
                    SupplyParameterComponent spc_actual = (SupplyParameterComponent)sp_actual;

                    cname += spp.Id_parameter_actual + "=" + buildName(spc_actual.Id_functor_app_actual) + ",";
                }
            }


            cname += "]";

            return cname;
        }
    

    }

    class XXXIData
    {
    }

    class XXXIList<T> 
        where T : XXXIData
    {
    }


    class XXXIFunction : XXXIData { }

    class XXXITestingFunction : XXXIFunction
    {
    }

    class XXXIntegralCase<T> : XXXIData 
        where T : XXXIData
    {
    }

    class Teste
    {
        XXXIList<XXXIntegralCase<XXXITestingFunction>> ll = new XXXIList<XXXIntegralCase<XXXITestingFunction>>();


    }



}//namespace

