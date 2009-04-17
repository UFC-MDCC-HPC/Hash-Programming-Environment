﻿using System;
using System.IO;
using System.Net;
using System.Runtime.Remoting;
using System.Threading;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Tcp;
using System.Collections.Generic;
using System.Reflection;
using HPE_DGAC_LoadDB;
using hpe.basic;
using DGAC.utils;
using DGAC.database;
using System.Data;

namespace DGAC
{


    public interface IBackEnd
    {

        void registerConcreteComponent(ComponentType ct);
        void registerAbstractComponent(ComponentType ct);
        void deleteComponent(String ID);
        String runApplication(int id_concrete, String[] eIds, int[] eVls);
        EnvironmentType readEnvironment();

    }//IDGAC

    /*
    * Essa classe é chamada pelo WS. Nela, as referencias aos workers são inicializadas. Para isto, os workers
    * já devem ter sido inicializados manualmente e identificados dentro do arquivo properties.xml, na pasta config
    */
    public class BackEnd : IBackEnd
    {

        private string[] hosts;
        private int channel = 0;
        private object[] remObjects;
        private int portTurn = 0;

        public BackEnd()
        {
            this.hosts = FileUtil.readProperty("host");

            //creating the channel
            TcpChannel ch;
            try
            {
                ch = new TcpChannel(this.channel);
                ChannelServices.RegisterChannel(ch, true);
                
            }
            catch (System.Runtime.Remoting.RemotingException re)
            {

                Console.WriteLine("Channel already exists." + re);

            }
            finally
            {
                //creating the objects to connect to workers
                remObjects = new object[hosts.Length];

                for (int i = 0; i < hosts.Length; i++)
                {
                    remObjects[i] = Activator.GetObject(typeof(ServerObject), "tcp://" + hosts[i] + "/" + Constants.SERVICE_NAME);
                    Console.WriteLine("DGAC conected to " + hosts[i] + " worker.");
                }
            }

            Console.WriteLine("DGAC is up and running.");
        }

        //TODO: este metodo ainda deve ser trabalhado para dinamicidade
        //Este método deve receber o xml rerente a uma configuração e formar as referencias necessárias a sua compilação
        //o qual será enviado aos workers		
        public void registerAbstractComponent(ComponentType ct)
        {
            Connector.openConnection();
            Connector.beginTransaction();
            try
            {
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
                    Console.Error.WriteLine("Abstract component " + ct.header.packagePath + "." + ct.header.name + " is already deployed. Updating ...");
                    cAbs = (AbstractComponentFunctor) cAbs_;
                    abstractloader.updateSources(ct, cAbs);
                    exists = true;
                }

                ICollection<LoaderApp.InfoCompile> infoCompile = LoaderApp.getReferences_Abstract(cAbs.Id_abstract);

                InterfaceDAO idao = new InterfaceDAO();

                foreach (LoaderApp.InfoCompile interfaceToCompile in infoCompile)
                {
                    int id_abstract = interfaceToCompile.id;
                    string moduleName = interfaceToCompile.moduleName;
                    string interfaceName = interfaceToCompile.unitId;
                    string sourceCode = interfaceToCompile.sourceCode;
                    string cuid = interfaceToCompile.cuid;
                    string library_path = interfaceToCompile.library_path;
                    int outputType = interfaceToCompile.output_type;

                    portTurn %= remObjects.Length;
                    Object remWorker = remObjects[portTurn];

                    string publicKey = this.sendCompileCommandToWorker(library_path,
                                                                       remWorker,
                                                                       sourceCode,
                                                                       moduleName,
                                                                       interfaceToCompile.references,
                                                                       outputType);

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
                Connector.closeConnection();
            }
        }






        //TODO: este metodo ainda deve ser trabalhado para dinamicidade
        //Este método deve receber o xml rerente a uma configuração e formar as referencias necessárias a sua compilação
        //o qual será enviado aos workers		
        public void registerConcreteComponent(ComponentType ct)
        {

            Connector.openConnection();
            Connector.beginTransaction();
            try
            {
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

                UnitDAO udao = new UnitDAO();

                foreach (LoaderApp.InfoCompile unitToCompile in infoCompile)
                {
                    int id_concrete = unitToCompile.id;
                    string cuid = unitToCompile.cuid;
                    string library_path = unitToCompile.library_path;
                    string moduleName = unitToCompile.moduleName;
                    string unitName = unitToCompile.unitId;
                    string sourceCode = unitToCompile.sourceCode;
                    int outputType = unitToCompile.output_type;

                    portTurn %= remObjects.Length;
                    Object remWorker = remObjects[portTurn];

                    string publicKey = this.sendCompileCommandToWorker(library_path,
                                                                       remWorker,
                                                                       sourceCode,
                                                                       moduleName,
                                                                       unitToCompile.references,
                                                                       outputType);
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
            }
        }

        public void deleteComponent(String ID)
        {

        }


        private string sendCompileCommandToWorker(string library_path, object remoteObject, string contents, string moduleName, string[] refs, int outFile)
        {
            ServerObject worker = (ServerObject)remoteObject;
            return worker.compileClass(library_path, contents, moduleName, refs, outFile);
        }

        private void sendRunCommandToWorker(object remoteObject, IDictionary<string, int> files, IDictionary<string, int> enums, int session_id)
        {
            ServerObject worker = (ServerObject)remoteObject;
            worker.runClass(files, enums, session_id);
        }

        public static int session_id = -1;

        public static void DGACInit(string hash_component_uid, string my_id_unit, hpe.basic.IUnit pmain, string[] args)
        {

            session_id = getSessionID(args);

            if (session_id >= 0)
                RedirectOutput(session_id);
            else
                open_log_out = false;

            openConnection();

            ComponentDAO cdao = new ComponentDAO();
            Component c = cdao.retrieve_uid(hash_component_uid);

            int id_abstract = c.Id_abstract;
            int id_concrete = c.Id_concrete;

            pmain.Id_concrete = id_concrete;

            AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
            IList<string> id_units_ordered = acfdao.getIdUnitsOrdered(id_abstract);

            IDictionary<string, int> eInf = new Dictionary<string, int>();
            IDictionary<string, int> eSup = new Dictionary<string, int>();

            pmain.EnumeratorCardinality = new Dictionary<string, int>();

            EnumeratorDAO edao = new EnumeratorDAO();
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

            EnumerationInterfaceDAO eidao = new EnumerationInterfaceDAO();

            int rangeInf, rangeSup;

            int num_procs = 0;
            int rank = 0;

            pmain.Units = new Dictionary<string, IList<int>>();
            IList<IDictionary<string, int>> pmain_EnumRanks = new List<IDictionary<string, int>>();
            IList<int> pmain_Ranks = new List<int>();

            foreach (string id_unit in id_units_ordered)
            {
                if (id_unit.Equals(my_id_unit) && pmain.GlobalRank < 0)                
                    pmain.GlobalRank = rank;
                
                IList<EnumerationInterface> eiList = eidao.listByInterface(id_abstract, id_unit);

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
                pmain.Units.Add(id_unit, ranks);

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

            closeConnection(true);
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

        public void DGACFinalize()
        {
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
            return -1;
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

        private static KeyValuePair<string, int> findReplicator(KeyValuePair<string, int> re,
                                                                Slice s,
                                                                InnerComponent ic,
                                                                IDictionary<string, int> enumeratorCardinality,
                                                                out IDictionary<string, int> enumeratorCardinality_return)
        {
            int id_abstract = ic.Id_abstract_owner;
            string id_inner = ic.Id_inner;
            string id_unit = s.Id_interface_slice;
            IDictionary<string, int> enumeratorCardinality_prime = new Dictionary<string, int>();


            // LOOK FOR THE ORIGINAL REPLICATOR FROM THE INNER COMPONENT THAT HAS BEEN SPLITTED...
            string re_Key;
            int re_Value;

            EnumeratorSplitDAO esplitdao = new EnumeratorSplitDAO();
            EnumeratorSplit es = esplitdao.retrieve1(id_abstract, re.Key);
            if (es != null && s.Id_split_replica > 0)
            {
                re_Key = es.Id_enumerator;
                re_Value = es.mapSplitEnumerationValue(re.Value, enumeratorCardinality, enumeratorCardinality_prime);
            }
            else
            {
                re_Key = re.Key;
                re_Value = re.Value;
                foreach (KeyValuePair<string, int> ke in enumeratorCardinality)
                    enumeratorCardinality_prime.Add(ke);
            }

            // FIND THE ORIGINAL REPLICATOR OF THE INNER COMPONENT THAT HAS BEEN FUSED.
            EnumeratorMappingDAO emdao = new EnumeratorMappingDAO();
            EnumeratorMapping em = null;

            IList<SliceExposed> lse = null;
            SliceExposed se = null;
            string id_inner_container = id_inner;
            IList<string> id_inner_container_list = new List<string>();
            int count = 0;
            if (ic.Transitive)
            {
                SliceExposedDAO sedao = new SliceExposedDAO();
                lse = sedao.listContainers(s.Id_inner, s.Id_interface_slice, s.Id_abstract, s.Id_split_replica);

                foreach (SliceExposed se_ in lse)
                {
                    id_inner_container = se_.Id_inner_owner;
                    id_inner_container_list.Add(id_inner_container);

                    se = se_;
                    EnumeratorMapping em_ = emdao.retrieve(id_abstract, id_inner_container, re_Key);
                    if (em_ != null)
                    {
                        em = em_;
                        //   break;
                    }
                }
            }
            else
            {
                em = emdao.retrieve(id_abstract, id_inner_container, re_Key);
            }

            if (id_inner_container_list.Count == 0)
            {
                id_inner_container_list.Add(id_inner_container);
            }


            string re_Key_before = re_Key;

            if (em != null)
                re_Key = em.Id_enumerator_inner;

            int cc = -1;
            foreach (string id_inner_container_ in id_inner_container_list)
            {
                cc = re_Key.IndexOf(id_inner_container_ + ".");
                if (cc >= 0)
                {
                    id_inner_container = id_inner_container_;
                    re_Key = re_Key.Substring(cc + (id_inner_container + ".").Length);
                    break;
                }
            }
            if (cc < 0)
            {
                throw new Exception("prefix not found: ");
            }


            IDictionary<string, int> enumeratorCardinalityTemp = new Dictionary<string, int>();

            // UPDATE CARDINALITY
            foreach (KeyValuePair<string, int> ke in enumeratorCardinality_prime)
            {
                if (ke.Key.Equals(re_Key_before))
                {
                    enumeratorCardinalityTemp.Add(re_Key, ke.Value);
                }
                else
                {
                    string re_Key_ = ke.Key;
                    int re_Value_ = ke.Value;
                    EnumeratorMapping em_ = emdao.retrieve(id_abstract, id_inner_container, re_Key_);

                    if (em_ != null)
                        re_Key_ = em_.Id_enumerator_inner;

                    int cc_ = re_Key_.IndexOf(id_inner_container + ".");
                    if (cc_ >= 0)
                    {
                        re_Key_ = re_Key_.Substring(cc_ + (id_inner_container + ".").Length);
                        re_Value_ = ke.Value;
                        enumeratorCardinalityTemp.Add(re_Key_, re_Value_);
                    }

                }
            }

            enumeratorCardinality_prime = enumeratorCardinalityTemp;

            KeyValuePair<string, int> ke_prime = new KeyValuePair<string, int>(re_Key, re_Value);

            if (ic.Transitive && se != null)     // in fact, ic.Transitive <=> se != null
            {
                InnerComponentExposedDAO icedao = new InnerComponentExposedDAO();
                InnerComponentExposed ice = icedao.retrieve(id_abstract, id_inner_container, id_inner);

                InnerComponentDAO icdao = new InnerComponentDAO();
                InnerComponent ic_owner = icdao.retrieve(ic.Id_abstract_owner, ice.Id_inner_owner);
                InnerComponent ic_prime = icdao.retrieve(ic_owner.Id_abstract_inner, ice.Id_inner);

                SliceDAO sdao = new SliceDAO();
                Slice s_prime = sdao.retrieve2(ic_prime.Id_abstract_owner, ice.Id_inner, se.Id_interface_slice, se.Id_interface_slice_owner);

                return findReplicator(ke_prime, s_prime, ic_prime, enumeratorCardinality_prime, out enumeratorCardinality_return);
            }
            else
            {
                enumeratorCardinality_return = enumeratorCardinality_prime;
                return ke_prime;
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

                InterfaceDAO idao = new InterfaceDAO();
                Interface i = idao.retrieve_libraryPath(library_path);

                int id_abstract = i.Id_abstract;

                ComponentDAO cdao = new ComponentDAO();
                Component c = cdao.retrieveThatImplements(id_abstract);

                UnitDAO udao = new UnitDAO();
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

        

        /* REMARK: The type params MUST be provided externally, because the actual type information is not in the DGAC's database.
         */

        public static hpe.basic.IUnit createSlice(hpe.basic.IUnit unit,
                                                  string hash_component_uid,
                                                  string id_inner,
                                                  string id_interface,
                                                  Type[] typeParams
                                                 )
        {

    //        Connector.openConnection();
            ComponentDAO cdao = new ComponentDAO();
            Component c = cdao.retrieve_uid(hash_component_uid);


           // Console.WriteLine(unit.GlobalRank + ": CREATE SLICE BEGIN !!! " + c.Library_path + " : " + id_inner + " : " + id_interface);

            int id_abstract = c.Id_abstract;

            database.Unit u = LoaderApp.resolveImpl(unit, c.Id_concrete, id_inner, id_interface);

            if (u == null)
            {
                throw new ConcreteComponentNotFoundException(id_abstract, id_inner, c.Id_functor_app);
            }


            string assembly_string = u.Assembly_string;      // where to found the DLL (retrieve from the component).
            string class_name = u.Class_name;  // the name of the class inside the DLL.
            int class_nargs = u.Class_nargs;

            Assembly a = Assembly.Load(assembly_string);

            // Type[] tt = a.GetTypes();

            string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");
            Type t = a.GetType(strType);

            Type closedT = typeParams.Length > 0 ? t.MakeGenericType(typeParams) : t;

            hpe.basic.IUnit o = (hpe.basic.IUnit)Activator.CreateInstance(closedT);

            o.Id_concrete = u.Id_concrete;

            o.ContainerSlice = unit;

            o.GlobalRank = unit.GlobalRank;

            // Configure the knowledge of the slices about the topology.

            EnumerationSliceDAO esdao = new EnumerationSliceDAO();
            EnumerationInnerDAO eidao = new EnumerationInnerDAO();

            IDictionary<string, int> eix_inner = new Dictionary<string, int>();

            foreach (KeyValuePair<string, int> index in unit.EnumRank)
            {
                //string eix = index.Key.Substring(index.Key.IndexOf(".") + 1);
                string eix = index.Key;
                int val = index.Value;

                // Check if the slice is enumerated by eix.
                EnumerationSlice es = esdao.retrieve(id_abstract, id_inner, id_interface, eix);
                if (es == null)      // If not, the inner component must be. Otherwise, this is stuck configuration.
                {
                    EnumerationInner ei = eidao.retrieve(id_abstract, id_inner, eix);
                    if (ei != null)
                        eix_inner.Add(eix, val);
                    else
                        throw new Exception("UNEXPECTED CONDITION: Stuck Configuration ...");
                }
            }

            SliceDAO sdao = new SliceDAO();

            // Now, list all units of the inner component.

            InnerComponentDAO icdao = new InnerComponentDAO();
            InnerComponent ic = icdao.retrieve(id_abstract, id_inner);

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

/*                if (!achei)
                {
                    Console.WriteLine(ic.Parameter_top + " not found in unit.ActualParameters - " + unit.Id_functor_app);
                    foreach (KeyValuePair<string, int> kkkk in unit.ActualParameters)
                    {
                        Console.Write("(" + kkkk.Key + "," + kkkk.Value + ") ,");
                    }
                }
                */
                int id_functor_app_old = ic.Id_functor_app;
                ic.Id_functor_app = id_functor_app_inner_actual;
                AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
                AbstractComponentFunctorApplication acfa = acfadao.retrieve(id_functor_app_inner_actual);
                id_abstract_inner_actual = acfa.Id_abstract;
                ic.Id_abstract_inner = id_abstract_inner_actual;                
            }

            o.Id_functor_app = ic.Id_functor_app;

            IList<Slice> ss = sdao.list2(id_abstract, id_inner);
            IDictionary<string, IList<int>> ranksAll = new Dictionary<string, IList<int>>();
            Dictionary<string, int> countUnits = new Dictionary<string, int>();
            IDictionary<string, IList<IDictionary<string, int>>> enumRanksL = new Dictionary<string, IList<IDictionary<string, int>>>();
            
            IDictionary<string,string> unitsMapping = new Dictionary<string, string>();

            AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
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
                IList<int> ranks;

                // Ache todas as unidades que são id_interface.
                unit.Units.TryGetValue(id_interface_of_slice, out ranks);

           /*     if (ranks == null)
                {
                    Console.WriteLine("UNEXPECTED ERROR ! - ranks is null - id_interface_of_slice = " + id_interface_of_slice + " - In: (createSlice - DGAC.cs)");
                    Console.WriteLine("id_abstract=" + id_abstract + " - id_inner=" + id_inner);
                    foreach (KeyValuePair<string, IList<int>> rrr in unit.Units)
                    {
                        Console.Write(rrr.Key + ",");
                    }
                } */

                // Percorra todas estas unidades e adicione somente aquelas cujos índice para algum enumerador em
                // eix_inner seja o mesmo.
                foreach (int r in ranks)
                {
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
                            countUnits.Add(id_interface_slice, count + 1);

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

                        foreach (KeyValuePair<string, int> e in eix_inner)
                            rE.Remove(e.Key);

                        // point to the replicator identifiers of the inner component ....
                        IDictionary<string, int> rE_ = new Dictionary<string, int>();
                        EnumeratorMappingDAO emdao = new EnumeratorMappingDAO();
                        foreach (KeyValuePair<string, int> re in rE)
                        {
                            IDictionary<string, int> enumeratorCardinalityNew;
                            rE_.Add(findReplicator(re, s, ic, unit.EnumeratorCardinality, out enumeratorCardinalityNew));
                            o.EnumeratorCardinality = enumeratorCardinalityNew;
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

            IDictionary<string, IList<int>> unitsRanks = new Dictionary<string, IList<int>>();

            //ranksAll.CopyTo(ranksAllArr, 0);

            int pos1 = 0;
            int pos2 = 0;
            int i = 0;
            foreach (string id_unit_slice_ in id_units_ordered_actual)
            {
                IList<int> ranks;

                string id_unit_slice;
                bool achei = unitsMapping.TryGetValue(id_unit_slice_, out id_unit_slice);
                if (!achei)
                {
                    Console.WriteLine("UNEXPECTED ERROR : id_unit_slice_ not found in unitsMapping (In: createSlices - DGAC.cs)");
                }

                achei = ranksAll.TryGetValue(id_unit_slice, out ranks);
                if (!achei)
                {
                    Console.WriteLine("UNEXPECTED ERROR : id_unit_slice not found in ranksAll (In: createSlices - DGAC.cs)");
                }

                foreach (int r in ranks) ranksAllList.Insert(pos2++, r);

                IList<IDictionary<string, int>> enumRanks;
                enumRanksL.TryGetValue(id_unit_slice, out enumRanks);
                foreach (IDictionary<string, int> d in enumRanks)
                    enumRanksList.Insert(pos1++, /* removePrefixes( id_inner ,*/ d /* ) */);

                // Calculate o.Units ...
                int count;
                countUnits.TryGetValue(id_unit_slice, out count);
                IList<int> _ranks = new List<int>();
                for (int k = 0; k < count; k++)
                    _ranks.Add(i++);
                unitsRanks.Add(id_unit_slice_, _ranks);
            }

            int[] ranksAllArr = new int[ranksAllList.Count];
            IDictionary<string, int>[] enumRanksArr = new IDictionary<string, int>[enumRanksList.Count];

            ranksAllList.CopyTo(ranksAllArr, 0);
            enumRanksList.CopyTo(enumRanksArr, 0);

            o.Ranks = ranksAllArr;
            o.EnumRanks = enumRanksArr;
            o.Units = unitsRanks;

            o.setActualParameters(unit.ActualParameters, ic.Id_functor_app);
            o.ActualParametersTop = unit.ActualParametersTop;

    //        Connector.closeConnection();

            o.createSlices();

            if (id_inner.Equals("e"))
            {
                Console.WriteLine(unit.GlobalRank + ": CREATE SLICE COMPLETE !!! " + c.Library_path + " : " + id_inner + " : " + id_interface);
            }


            return o;
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

            eabs.CopyTo(env.deployed,0);
            econ.CopyTo(env.deployed, eabs.Count);

            return env;
        }

        private IList<DeployedComponentInfoType> readEnvironmentConcrete()
        {
            IList<DeployedComponentInfoType> l = new List<DeployedComponentInfoType>();

            ComponentDAO cdao = new ComponentDAO();
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
            AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
            AbstractComponentFunctorParameterDAO acfpdao = new AbstractComponentFunctorParameterDAO();
            
            SupplyParameterDAO spdao = new SupplyParameterDAO();
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

            AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
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
            EnumeratorDAO edao = new EnumeratorDAO();
            EnumeratorSplitDAO esdao = new EnumeratorSplitDAO();

            IList<Enumerator> eList = edao.list(id_abstract);
            IList<string> rList = new List<string>();
            foreach (Enumerator e in eList)
            {
                IList<EnumeratorSplit> esList = esdao.listSplits(e.Id_abstract, e.Id_enumerator);
                if (esList.Count == 0)
                {
                    rList.Add(e.Variable);
                }
            }
            string[] r = new string[rList.Count];
            rList.CopyTo(r, 0);

            return r;
        }

        private DeployedParameterType[] readEnvironmentAbstractParameters(int id_abstract)
        {
            AbstractComponentFunctorParameterDAO acfpdao = new AbstractComponentFunctorParameterDAO();
            AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();

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

        public String runApplication(int id_concrete, String[] eIds, int[] eVls)
        {
            // assert: eIds.Length = eVls.Length
            try
            {
                Connector.openConnection();

                session_id = getSessionID(id_concrete);

                Object server = remObjects[0];
                IDictionary<string, int> files = new Dictionary<string, int>();
                IDictionary<string, int> enums = new Dictionary<string, int>();

                for (int i = 0; i < eIds.Length; i++)
                    enums.Add(eIds[i], eVls[i]);

                ComponentDAO cdao = new ComponentDAO();
                UnitDAO udao = new UnitDAO();
                EnumerationInterfaceDAO eidao = new EnumerationInterfaceDAO();
                EnumeratorDAO edao = new EnumeratorDAO();

                Component c = cdao.retrieve(id_concrete);

                IList<DGAC.database.Unit> uList = udao.list(id_concrete);

                foreach (DGAC.database.Unit u in uList)
                {
                    IList<EnumerationInterface> eiList = eidao.listByInterface(c.Id_abstract,u.Id_unit);
                    int count = 1;
                    foreach (EnumerationInterface ei in eiList)
                    {
                        Enumerator e = edao.retrieve(ei.Id_abstract, ei.Id_enumerator);

                        int v;
                        enums.TryGetValue(e.Variable, out v);
                        count *= v;
                    }
                    char[] char_sep = new char[] { '.' };
                    String[] class_name_arr = u.Class_name.Split(char_sep);
                    files.Add(class_name_arr[class_name_arr.Length - 1], count);
                }

                sendRunCommandToWorker(server, files, enums, session_id);
            }
            catch (Exception e)
            {
                throw e;
            }
            finally
            {
                Connector.closeConnection();
            }

            return "finished execution !";
        }

        private int getSessionID(int id_concrete)
        {
            int session_id = -1;
            String sql =
                "INSERT INTO hashmodel.sessions (id_concrete)" +
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

    }//DGAC

    public class ConcreteComponentNotFoundException : Exception
    {
        private int id_abstract;
        private string id_inner;
        private int id_functor_app_implements;

        IDictionary<string, SupplyParameter> parsSuper = new Dictionary<string, SupplyParameter>();

        public ConcreteComponentNotFoundException(int id_abstract, string id_inner, int id_functor_app_implements) : base()
        {
            this.id_abstract = id_abstract;
            this.id_inner = id_inner;
            this.id_functor_app_implements = id_functor_app_implements;

            AbstractComponentFunctorApplicationDAO acfadao= new AbstractComponentFunctorApplicationDAO();
            SupplyParameterDAO spdao = new SupplyParameterDAO();

            AbstractComponentFunctorApplication acfa = acfadao.retrieve(id_functor_app_implements);

            // It is a parameter in the subtype. Check if it is supplied in the type.
            IList<SupplyParameter> spList = spdao.list(acfa.Id_functor_app);
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
            InnerComponentDAO icdao = new InnerComponentDAO();

            InnerComponent ic = icdao.retrieve(id_abstract, id_inner);

            string cname = buildName(ic.Id_functor_app);

            return "No implementation for " + cname + " was found !";
        } 

        private string buildName(int id_functor_app)
        {
            string cname = "";

            AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
            SupplyParameterDAO spdao = new SupplyParameterDAO();
            AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();

            AbstractComponentFunctorApplication acfa = acfadao.retrieve(id_functor_app);
            AbstractComponentFunctor acf = acfdao.retrieve(acfa.Id_abstract);

            cname += acf.Library_path + "[";
            
            IList<SupplyParameter> spList = spdao.list(id_functor_app);
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

}//namespace

