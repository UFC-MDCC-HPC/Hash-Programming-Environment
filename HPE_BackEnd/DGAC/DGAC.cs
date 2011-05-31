using System;
using System.IO;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using System.Collections.Generic;
using System.Reflection;
using HPE_DGAC_LoadDB;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.Data;
using System.Collections;
using System.Reflection.Emit;
using MPI;

using gov.cca;
using br.ufc.pargo.hpe.ports;
using gov.cca.ports;
//using br.ufc.lia.hpe.backend.ports;

namespace br.ufc.pargo.hpe.backend
{

    namespace DGAC
    {
        /*
        * Essa classe é chamada pelo WS. Nela, as referencias aos workers são inicializadas. Para isto, os workers
        * já devem ter sido inicializados manualmente e identificados dentro do arquivo properties.xml, na pasta config
        */

        namespace ports
        {
            public interface CreateSlicePort : Port
            {
                void createSlices();
                IList<IUnit> Slices { get; }
                IUnit ContainerSlice { get; set; }
                void addSlice(IUnit slice);
                void destroySlice();

            }
        }

        public class BackEnd 
        {

            public static WorkerObject framework = null;

            private IpcClientChannel ch = null;

            public BackEnd()
            {
                Console.WriteLine("DGAC is up and running.");
            }


            public static ManagerObject connectToManager(out IpcClientChannel ch)
            {
                IDictionary prop = new Hashtable();
                prop["portName"] = "ManagerHostClient";
                ch = new IpcClientChannel(prop, null);
                ChannelServices.RegisterChannel(ch, false);
                System.Type requiredType = typeof(ManagerObject);
                ManagerObject obj = (ManagerObject)Activator.GetObject(requiredType, "ipc://ManagerHost/ManagerHost.rem");
                return obj;
            }

            public void deleteComponent(String ID) { }

            public static void releaseManager(IpcClientChannel ch)
            {
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
                    ManagerObject worker = connectToManager(out ch);

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
                        IList<DGAC.database.Component> cList = cdao.retrieveThatImplements(cAbs.Id_abstract);
                        if (true/*cList.Count == 0*/)
                        {
                            Console.Error.WriteLine("Abstract component " + ct.header.packagePath + "." + ct.header.name + " is already deployed. Updating sources ...");
                            abstractloader.updateSources(ct, cAbs);
                            exists = true;
                        }
                        else
                        {
                            throw new Exception("DEPLOY ERROR: One or more concrete components already implement this abstract component.\n Updates are not allowed for keeping consistency.");
                        }
                    }

                    Console.Error.Write("Compiling sources ...");

                    ICollection<LoaderApp.InfoCompile> infoCompile = LoaderApp.getReferences_Abstract(cAbs.Id_abstract);

                    foreach (LoaderApp.InfoCompile interfaceToCompile in infoCompile)
                    {
                        int id_abstract = interfaceToCompile.id;
                        string moduleName = interfaceToCompile.moduleName;
                        string interfaceName = interfaceToCompile.unitId;
                        string sourceCode = interfaceToCompile.sourceCode;
                        string cuid = interfaceToCompile.cuid;
                        string library_path = interfaceToCompile.library_path;
                        int outputType = interfaceToCompile.output_type;

                        Console.Error.Write(moduleName + ", ");

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

                    Console.Error.Write("ok ");

                    Connector.commitTransaction(); // if it is ok, commit ...

		    Console.Error.WriteLine("commited !");

                }
                catch (Exception e)
                {
                    Console.Error.Write("Rolling back transaction...");
                    Connector.rollBackTransaction();
                    Console.Error.WriteLine("ok");
                    throw e;
                }
                finally
                {
                    releaseManager(ch);
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

                    ManagerObject worker = connectToManager(out ch);

                    bool exists = false;
                    LoaderConcreteComponent concreteloader = new LoaderConcreteComponent();
                    DGAC.database.Component cConc = null;
                    HashComponent cConc_ = null;

                    concreteloader.componentExists(ct.header.hash_component_UID, out cConc_);
                    if (cConc_ == null)
                    {
                        cConc = (DGAC.database.Component)concreteloader.loadComponent(ct);
                    }
                    else
                    {
                        Console.Error.WriteLine("Concrete component " + ct.header.packagePath + "." + ct.header.name + " is already deployed. Updating ...");
                        cConc = (DGAC.database.Component)cConc_;
                        concreteloader.updateSources(ct, cConc);
                        exists = true;
                    }

                    Console.Error.Write("Compiling sources ...");

                    ICollection<LoaderApp.InfoCompile> infoCompile = LoaderApp.getReferences_Concrete(cConc.Id_concrete);

                    foreach (LoaderApp.InfoCompile unitToCompile in infoCompile)
                    {
                        int id_concrete = unitToCompile.id;
                        string cuid = unitToCompile.cuid;
                        string library_path = unitToCompile.library_path;
                        string moduleName = unitToCompile.moduleName;
                        string unitName = unitToCompile.unitId;
                        string sourceCode = unitToCompile.sourceCode;
                        int outputType = unitToCompile.output_type;

                        Console.Error.Write(moduleName + ", ");

                        string publicKey = this.sendCompileCommandToWorker(library_path,
                                                                           worker,
                                                                           sourceCode,
                                                                           moduleName,
                                                                           unitToCompile.references,
                                                                           outputType,
                                                                           userName,
                                                                           password,
                                                                           curDir);
                        if (!exists && outputType != Constants.EXE_OUT)
                            udao.setPublicKey(id_concrete, unitName, publicKey);
                    }

                    Console.Error.Write("ok ");

                    Connector.commitTransaction(); // if it is ok, commit ...

                    Console.Error.WriteLine("commited !");


                }
                catch (Exception e)
                {
                    Console.Error.WriteLine("Rolling back transaction !");
                    Connector.rollBackTransaction();
                    throw e;
                }
                finally
                {
                    Connector.closeConnection();
                    releaseManager(ch);
                }
            }

            private string sendCompileCommandToWorker(string library_path, ManagerObject worker, string contents, string moduleName, string[] refs, int outFile, string userName, string password, String curDir)
            {
                return worker.compileClass(library_path, contents, moduleName, refs, outFile, userName, password, curDir);
            }

            private void sendRunCommandToWorker(ManagerObject worker, IDictionary<string, int> files, IDictionary<string, int> enums, int session_id, string userName, string password, String curDir)
            {
                worker.runClass(files, enums, session_id, userName, password, curDir);
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

                IList<DGAC.database.Component> cList = cdao.list();

                foreach (DGAC.database.Component c in cList)
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
                IList<SupplyParameter> spList = spdao.list(id_functor_app);

                DeployedParameterType[] r = new DeployedParameterType[spList.Count];

                int i = 0;
                foreach (SupplyParameterComponent sp in spList)
                {
                    r[i] = new DeployedParameterType();
                    r[i].parameter_id = sp.Id_parameter;
                    AbstractComponentFunctorApplication acfa = acfadao.retrieve(sp.Id_functor_app_actual);
                    if (acfa==null) Console.Error.WriteLine("Id_functor_app_actual = " + sp.Id_functor_app_actual);
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
                        if (e==null) Console.Error.WriteLine("id_abstract=" + ei.Id_abstract + ", id_enumerator=" + ei.Id_enumerator + ", id_interface=" + i.Id_interface);
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
                String[] str_output = null;
                // assert: eIds.Length = eVls.Length
                try
                {
                    ManagerObject manager = connectToManager(out ch);
                    Connector.openConnection();

                    session_id = getSessionID(id_concrete);

                    IList<string> enumList = new List<string>();
                    for (int i = 0; i < eIds.Length; i++)
                    {
                        enumList.Add(eIds[i]);
                        enumList.Add(eVls[i].ToString());
                    }
                    string[] enums = new string[enumList.Count];
                    enumList.CopyTo(enums, 0);

                  //  DGAC.database.Component c = cdao.retrieve(id_concrete);

//                    int[] nodes = new int[] { 0, 1, 2, 3/*, 4, 5, 6, 7 ,8, 9, 10, 11, 12, 13, 14, 15*/};

                    /* BEGIN UNDER CONSTRUCTION */
                    TypeMapImpl properties = new TypeMapImpl();
                    properties.putStringArray(Constants.ENUMS_KEY, enums);
//                    properties.putIntArray(Constants.NODES_KEY, nodes);
                    properties.putInt(Constants.SESSION_KEY, session_id);

                    Console.WriteLine("before manager.createInstance");

                    String session_id_string = "session_" + session_id.ToString();

                    string instantiatior_string = File.ReadAllText("/home/hpe.backend/hash-programming-environment/teste.xml");

                    ComponentID cid = manager.createInstance(session_id_string + ".application", /*c.Library_path*/ instantiatior_string, properties);

                    str_output = manager.runApplication(session_id_string, (ManagerComponentID)cid);
                    
                }
                catch (Exception e)
                {
                    throw e;
                }
                finally
                {
                    Connector.closeConnection();
                    releaseManager(ch);
                }

                return str_output == null ? new String[] { } : str_output;

            }

            public String[] runApplicationNew(string instantiatior_string, string[] eIds, int[] eVls, string userName, string password, string curDir)
            {
				return runApplicationNew(instantiatior_string, eIds, eVls, userName, password, curDir, 1);
			}
			
            public String[] runApplicationNew(string instantiatior_string, string[] eIds, int[] eVls, string userName, string password, string curDir, int rounds)
            {
                string[] str_output = null;
                // assert: eIds.Length = eVls.Length
                try
                {
                    ManagerObject manager = connectToManager(out ch);
                    Connector.openConnection();
					
		    int id_concrete = 0;
                    session_id = getSessionID(id_concrete);

                    IList<string> enumList = new List<string>();
                    for (int i = 0; i < eIds.Length; i++)
                    {
                        enumList.Add(eIds[i]);
                        enumList.Add(eVls[i].ToString());
                    }
                    string[] enums = new string[enumList.Count];
                    enumList.CopyTo(enums, 0);


                    /* BEGIN UNDER CONSTRUCTION */
                    TypeMapImpl properties = new TypeMapImpl();
                    properties.putStringArray(Constants.ENUMS_KEY, enums);
                    properties.putInt(Constants.SESSION_KEY, session_id);

                    Console.WriteLine("before manager.createInstance");

                    String session_id_string = "session_" + session_id.ToString();

                    ComponentID cid = manager.createInstance(session_id_string + ".application", instantiatior_string, properties);

                    str_output = manager.runApplication(session_id_string, (ManagerComponentID)cid, rounds);
                    
                }
                catch (Exception e)
                {
                    throw e;
                }
                finally
                {
                    Connector.closeConnection();
                    releaseManager(ch);
                }

                return str_output == null ? new String[] { } : str_output;

            }

            public String[] runApplication2(int id_concrete, String[] eIds, int[] eVls, string userName, string password, string curDir)
            {
                String[] str_output = null;
                // assert: eIds.Length = eVls.Length
                try
                {
                    ManagerObject server = connectToManager(out ch);
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


                    DGAC.database.Component c = cdao.retrieve(id_concrete);

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
                    releaseManager(ch);
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

            public static int session_id = -1;

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

            public static DGAC.database.Component resolveUnit(
                            AbstractComponentFunctorApplication acfaRef,
                            IDictionary<string, int> actualParameters,
                            IDictionary<string, int> actualParametersTop
                        )
            {                
                return LoaderApp.resolveImpl(acfaRef, actualParameters, actualParametersTop);
            }

            public static DGAC.database.Component resolveUnit(
                            AbstractComponentFunctorApplication acfaRef
                        )
            {
                return resolveUnit(acfaRef, new Dictionary<string, int>(), new Dictionary<string, int>());
            }

            public static br.ufc.pargo.hpe.backend.DGAC.database.Unit takeUnit(
                DGAC.database.Component c,
                string id_interface)
            {
                string id_unit = null;
                Interface i2 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveSuper(c.Id_abstract, id_interface);
                foreach (Interface i in br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.list(c.Id_abstract))
                {
                    if (i.Id_interface_super_top.Equals(i2.Id_interface_super_top))
                    {
                        id_unit = i.Id_interface;
                    }
                }

                return br.ufc.pargo.hpe.backend.DGAC.BackEnd.udao.retrieve(c.Id_concrete, id_unit, 1);
            }
            
            private static System.Type[] calculateActualClassParameteres(Interface i, int id_functor_app, IDictionary<string, int> actualParameters)
            {
                IList<InterfaceParameter> ipars = BackEnd.ipdao.list(i.Id_abstract,i.Id_interface);
                System.Type[] result = new System.Type[ipars.Count];
                foreach (InterfaceParameter ipar in ipars)
                {
                    int id_functor_app_parameter;
                    string parid = ipar.ParId;
                    if (actualParameters.TryGetValue(parid, out id_functor_app_parameter) || 
                        actualParameters.TryGetValue(parid + "#" + id_functor_app, out id_functor_app_parameter))
                    {
                        AbstractComponentFunctorApplication acfa_parameter = BackEnd.acfadao.retrieve(id_functor_app_parameter);
                        AbstractComponentFunctor acf_parameter = BackEnd.acfdao.retrieve(acfa_parameter.Id_abstract);
                        Interface iPar = BackEnd.idao.retrieveSuper(acf_parameter.Id_abstract, ipar.Id_unit_parameter);

                        IDictionary<string, int> actualParameters_new;
                        determineActualParameters(actualParameters, id_functor_app_parameter, out actualParameters_new);
                        
                        System.Type[] parameters = calculateActualClassParameteres(iPar, id_functor_app_parameter, actualParameters_new);
                        
                        // Build a type from iPar applied to parType.

                        string assembly_string = iPar.Assembly_string;      // where to found the DLL (retrieve from the component).
                        string class_name = iPar.Class_name;  // the name of the class inside the DLL.
                        int class_nargs = iPar.Class_nargs;
                        string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");

                        Assembly a = Assembly.Load(assembly_string);
                        System.Type t = a.GetType(strType);

                        System.Type closedT = parameters.Length > 0 ? t.MakeGenericType(parameters) : t;

                        result[ipar.ParOrder] = closedT;

                    }
                }
                return result;
            }

            private static System.Type setupParameters2(Interface i, int id_functor_app, IDictionary<string, int> actualParameters)
            {
                IList<InterfaceParameter> ipars = BackEnd.ipdao.list(i.Id_abstract, i.Id_interface);
                System.Type[] parameters = new System.Type[ipars.Count];
                foreach (InterfaceParameter ipar in ipars)
                {
                    int id_functor_app_parameter;
                    string parid = ipar.ParId;
                    if (actualParameters.TryGetValue(parid, out id_functor_app_parameter) ||
                        actualParameters.TryGetValue(parid + "#" + id_functor_app, out id_functor_app_parameter))
                    {
                        AbstractComponentFunctorApplication acfa_parameter = BackEnd.acfadao.retrieve(id_functor_app_parameter);
                        AbstractComponentFunctor acf_parameter = BackEnd.acfdao.retrieve(acfa_parameter.Id_abstract);
                        Interface iPar = BackEnd.idao.retrieveSuper(acf_parameter.Id_abstract, ipar.Id_unit_parameter);

                        IDictionary<string, int> actualParameters_new;
                        determineActualParameters(actualParameters, id_functor_app_parameter, out actualParameters_new);

                        System.Type parameter = setupParameters2(iPar, id_functor_app_parameter, actualParameters_new);
                        parameters[ipar.ParOrder] = parameter;
                    }
                }

                // Build a type from iPar applied to parType.

                string assembly_string = i.Assembly_string;      // where to found the DLL (retrieve from the component).
                string class_name = i.Class_name;  // the name of the class inside the DLL.
                int class_nargs = i.Class_nargs;
                string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");

                Assembly a = Assembly.Load(assembly_string);
                System.Type t = a.GetType(strType);

                System.Type closedT = parameters.Length > 0 ? t.MakeGenericType(parameters) : t;


                return closedT;
            }

            private static void buildParamTable(String propertyName, System.Type myType, out System.Type[] actualParams)
            {
                System.Type o = myType.BaseType.GetProperty(propertyName, BindingFlags.NonPublic | BindingFlags.Instance).PropertyType;
                actualParams = o.GetGenericArguments();
            }


           
            private static void calculateActualParams_(
                IDictionary<string,int> actualParameters,
                AbstractComponentFunctorApplication acfaRef,
                string id_interface,
                out System.Type[] actualParams)
            {
                IDictionary<string, int> actualParameters_new;
                determineActualParameters(actualParameters, acfaRef.Id_functor_app, out actualParameters_new);

                Interface i = BackEnd.idao.retrieveSuper(acfaRef.Id_abstract, id_interface);
                actualParams = calculateActualClassParameteres(i, acfaRef.Id_functor_app, actualParameters_new);
            }

            public static void calculateActualParams(
                AbstractComponentFunctorApplication acfaRef,
                string id_interface,
                out System.Type[] actualParams)
            {
                calculateActualParams_(new Dictionary<string, int>(), acfaRef, id_interface, out actualParams);
            }
            
            public static void calculateActualParams(
                IUnit enclosing_unit, 
                AbstractComponentFunctorApplication acfaRef,
                string id_interface, 
                out System.Type[] actualParams)
            {
                calculateActualParams_(enclosing_unit.ActualParameters, acfaRef, id_interface, out actualParams);
            }

            private static void updateInnerComponentType(IUnit enclosing_unit, InnerComponent ic)
            {
                int id_functor_app_inner_actual;
                if (ic.Parameter_top.Length > 0
                     && (enclosing_unit.ActualParameters.TryGetValue(ic.Parameter_top, out id_functor_app_inner_actual)
                          || enclosing_unit.ActualParameters.TryGetValue(ic.Parameter_top + "#" + enclosing_unit.Id_functor_app, out id_functor_app_inner_actual)))
                {
                    ic.Id_functor_app = id_functor_app_inner_actual;
                    AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app_inner_actual);
                    ic.Id_abstract_inner = acfa.Id_abstract;
                }
            }

            public static void calculateGenericClassName(
                br.ufc.pargo.hpe.backend.DGAC.database.Unit u,
                System.Type[] actualParams,
                out string type)
            {
                string assembly_string = u.Assembly_string;      // where to found the DLL (retrieve from the component).
                string class_name = u.Class_name;  // the name of the class inside the DLL.
                int class_nargs = u.Class_nargs;
                string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");

                Assembly a = Assembly.Load(assembly_string);
                System.Type t = a.GetType(strType);

                System.Type closedT = actualParams.Length > 0 ? t.MakeGenericType(actualParams) : t;
                type = closedT.FullName;
            }

            public static AbstractComponentFunctorApplication loadACFAFromInstantiator(ComponentFunctorApplicationType instantiator)
            {
                AbstractComponentFunctorApplication aAppNew = null;

                try
                {
                    Connector.openConnection();

                    AbstractComponentFunctor acf = BackEnd.acfdao.retrieve_libraryPath(instantiator.library_path);

                    aAppNew = new AbstractComponentFunctorApplication();
                    aAppNew.Id_functor_app = Connector.nextKey("id_functor_app", "abstractcomponentfunctorapplication");
                    aAppNew.Id_abstract = acf.Id_abstract;
                    DGAC.BackEnd.acfadao.insert(aAppNew);

                    if (instantiator.context_parameter != null)
                        foreach (ContextParameterType ctx in instantiator.context_parameter)
                        {
                            AbstractComponentFunctorApplication acfa_par = loadACFAFromInstantiator(ctx.actual_parameter);

                            SupplyParameterComponent par = new SupplyParameterComponent();
                            par.Id_abstract = acfa_par.Id_abstract;
                            par.Id_functor_app = aAppNew.Id_functor_app;
                            par.Id_parameter = ctx.formal_parameter_id;
                            par.Id_functor_app_actual = acfa_par.Id_functor_app;

                            DGAC.BackEnd.spdao.insert(par);
                        }

                 }
                catch (Exception e)
                {
                }
                finally
                {
                    Connector.closeConnection();
                }

                return aAppNew;
            }

            public static ComponentFunctorApplicationType buildInstantiator(int id_functor_app_service)
            {
                Connector.openConnection();
                AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app_service);
                AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(acfa.Id_abstract);
                IList<SupplyParameter> spList = BackEnd.spdao.list(id_functor_app_service);

                ComponentFunctorApplicationType c = new ComponentFunctorApplicationType();
                c.library_path = acf.Library_path;
                c.context_parameter = new ContextParameterType[spList.Count];
                int i = 0;
                foreach (SupplyParameter sp in spList)
                {
                    SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                    c.context_parameter[i] = new ContextParameterType();
                    c.context_parameter[i].formal_parameter_id = sp.Id_parameter;
                    c.context_parameter[i].actual_parameter = buildInstantiator(spc.Id_functor_app_actual);
                    i++;
                }
                Connector.closeConnection();

                return c;
            }



            /* TODO !!!!
             * It is still necessary to defined the meaning of the type parameter of registerUsesPort and addProvidesPort.
             *  The type will be the component type (instantiation). When connecting two ports, the compatibility of the 
             *  types will be checked !
             * 
             */
            public static IUnit createSlice(IUnit ownerUnit, Slice slice)                                            
            {
                string id_inner = slice.Id_inner;
                string id_interface = slice.Id_interface_slice;
                string portName = id_inner; /*slice.PortName;*/

                ComponentID user_cid = ownerUnit.CID;
                Services services = ownerUnit.Services;
                string instanceName = user_cid.getInstanceName();

                IUnit the_unit = (IUnit)services.getPortNonblocking(portName);

                if (the_unit == null)
                {
                    // APPLY THE RESOLUTION ALGORITHM
                    string className;
                    br.ufc.pargo.hpe.backend.DGAC.database.Unit u;
                    br.ufc.pargo.hpe.backend.DGAC.database.Component c;
                    InnerComponent ic = BackEnd.icdao.retrieve(ownerUnit.Id_abstract, id_inner);
                    updateInnerComponentType(ownerUnit, ic);
                    AbstractComponentFunctorApplication acfaRef = BackEnd.acfadao.retrieve(ic.Id_functor_app);
                    c = resolveUnit(acfaRef, ownerUnit.ActualParameters, ownerUnit.ActualParametersTop);
                    u = takeUnit(c, id_interface);
                    if (u == null)
                        throw new ConcreteComponentNotFoundException(acfaRef.Id_functor_app);
                    System.Type[] actualParams;
                    calculateActualParams(ownerUnit, acfaRef, id_interface, out actualParams);
                    calculateGenericClassName(u, actualParams, out className);

                    // INSTANTIATE THE PROVIDER COMPONENT (TODO: retirar do createInstance a tarefa de instanciar - IS_COMPONENT_INSTANCE_KEY)
                    HPETypeMap properties2 = new TypeMapImpl();
                    properties2[Constants.COMPONENT_KEY] = c.Library_path; // u.Id_concrete;
                    properties2[Constants.UNIT_KEY] = u.Id_unit;
                    ComponentID provider_cid = framework.createInstance(instanceName + "-" + id_inner, className, properties2);

                    // CONNECT THE USER (enclosing component) AND THE PROVIDER (inner component) -- setupSlices is called in the connection ...
                    framework.connect(user_cid, portName, provider_cid, Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS);

                    // GET THE UNIT SLICE AND RETURNS IT
                    the_unit = (IUnit)services.getPort(portName);
                   // the_unit.ContainerSlice = ownerUnit;
                    the_unit.GlobalRank = ownerUnit.GlobalRank;
                    the_unit.WorldComm = ownerUnit.WorldComm;
                    the_unit.Id_inner = slice.Id_inner;
                }
                
                return the_unit;
            }

            public static void setupSlice(br.ufc.pargo.hpe.basic.IUnit unit, br.ufc.pargo.hpe.basic.IUnit unit_slice, string id_inner)
            {
                int id_abstract = unit.Id_abstract;
                //string id_inner = unit_slice.Id_inner;
                string id_interface = unit_slice.Id_unit;
                InnerComponent ic = BackEnd.icdao.retrieve(id_abstract, id_inner);

                int id_functor_app_inner_actual = ic.Id_functor_app;
                if (ic.Parameter_top.Length > 0)
                {
                    bool achei = unit.ActualParameters.TryGetValue(ic.Parameter_top, out id_functor_app_inner_actual);
                    if (!achei)
                    {
                        achei = unit.ActualParameters.TryGetValue(ic.Parameter_top + "#" + unit.Id_functor_app, out id_functor_app_inner_actual);
                    }
                    ic.Id_functor_app = id_functor_app_inner_actual;
                    AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app_inner_actual);
                    ic.Id_abstract_inner = acfa.Id_abstract;
                }

                IDictionary<string, int> actualParameters_new;
                determineActualParameters(unit.ActualParameters, id_functor_app_inner_actual, out actualParameters_new);

                unit_slice.Id_functor_app = ic.Id_functor_app;
                // unit_slice.Id_abstract = ic.Id_abstract_inner;
                unit_slice.setActualParameters(actualParameters_new);
                unit_slice.ActualParametersTop = unit.ActualParametersTop;
                unit_slice.ContainerSlice = unit;
                unit_slice.GlobalRank = unit.GlobalRank;
                unit_slice.WorldComm = unit.WorldComm;

                calculateTopology(unit, unit_slice, id_inner);

            }

            public static void calculateInitialTopology(ComponentID cid, string library_path, string my_id_unit, int id_functor_app_startup, IUnit pmain)
            {
                Connector.openConnection();

                TypeMap properties = framework.getComponentProperties(cid);

                DGAC.database.Component c = BackEnd.cdao.retrieve_libraryPath(library_path);

                int id_abstract = c.Id_abstract;
                int id_concrete = c.Id_concrete;

                pmain.Id_functor_app = c.Id_functor_app;
                pmain.Id_concrete = id_concrete;
                pmain.Id_unit = my_id_unit;

                IDictionary<string, int> eInf = new Dictionary<string, int>();
                IDictionary<string, int> eSup = new Dictionary<string, int>();

                pmain.EnumeratorCardinality = new Dictionary<string, int>();

                IList<Enumerator> eList = BackEnd.edao.list(id_abstract);
                foreach (Enumerator e in eList)
                {
                    int rangeInf_ = 0;
                    int rangeSup_ = enumeratorCardinality(properties.getStringArray(Constants.ENUMS_KEY, new string[0]), e.Variable);

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

                    IList<EnumerationInterface> eiList = BackEnd.exitdao.listByInterfaceWithFusions(id_abstract, id_unit);

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

                pmain.setUpParameters(id_functor_app_startup);
                pmain.ActualParametersTop = pmain.ActualParameters;

                Connector.closeConnection();
            }

            private static void calculateTopology(IUnit unit, IUnit unit_slice, string id_inner)
            {
                int id_abstract = unit.Id_abstract;
                // string id_inner = unit_slice.Id_inner;
                string id_interface = unit_slice.Id_unit;

                // Configure the knowledge of the slices about the topology.
                IDictionary<string, int> eix_inner = new Dictionary<string, int>();
                IDictionary<string, IDictionary<string, int>> enumsByVars = new Dictionary<string, IDictionary<string, int>>();

                foreach (KeyValuePair<string, int> index in unit.EnumRank)
                {
                    Enumerator e = BackEnd.edao.retrieve(id_abstract, index.Key);
                    if (enumsByVars.ContainsKey(e.Variable))
                    {
                        IDictionary<string, int> l;
                        enumsByVars.TryGetValue(e.Variable, out l);
                        l.Add(index);
                    }
                    else
                    {
                        IDictionary<string, int> l = new Dictionary<string, int>();
                        l.Add(index);
                        enumsByVars.Add(e.Variable, l);
                    }
                }

                // THIS LOOP CALCULATES WHICH ENUMERATORS OF THE Unit ENUMERATES THE INNER COMPONENT OF THE SLICE (eix_inner), and not the slice itself  -------------------------------
                foreach (KeyValuePair<string, IDictionary<string, int>> k in enumsByVars)
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
                                eix_inner.Add(eix, val);
                                found++;
                            }
                        }
                        else
                        {
                            found++;
                        }
                    }
                }

                InnerComponent ic = BackEnd.icdao.retrieve(id_abstract, id_inner);

                int id_abstract_inner_original = ic.Id_abstract_inner; 
                int id_functor_app_inner_actual = unit_slice.Id_functor_app;
                int id_abstract_inner_actual = unit_slice.Id_abstract;

                // Map id_unit's of the original inner component type to the id_unit's of the actual inner component type 

                IDictionary<string, string> unitsMapping = new Dictionary<string, string>();
                IList<string> id_units_ordered = BackEnd.acfdao.getIdUnitsOrdered(id_abstract_inner_original);
                IList<string> id_units_ordered_actual = BackEnd.acfdao.getIdUnitsOrdered(id_abstract_inner_actual);
                for (int k = 0; k < id_units_ordered.Count; k++)
                {
                    unitsMapping.Add(id_units_ordered_actual[k], id_units_ordered[k]);
                }

                // ?????  -------------------------------

                IDictionary<string, IList<int>> ranksAll = new Dictionary<string, IList<int>>();
                Dictionary<string, int> countUnits = new Dictionary<string, int>();
                IDictionary<string, IList<IDictionary<string, int>>> enumRanksL = new Dictionary<string, IList<IDictionary<string, int>>>();

                IList<Slice> slices_of_the_inner = BackEnd.sdao.listByInner(id_abstract, id_inner);

                foreach (Slice s in slices_of_the_inner)  // for different split_replica's. 
                {
                    string id_interface_slice = s.Id_interface_slice;
                    string id_interface_of_slice = s.Id_interface;

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
                                    IDictionary<string, int> list;
                                    enumsByVars.TryGetValue(e.Variable, out list);
                                    list.Add(index);
                                }
                                else
                                {
                                    IDictionary<string, int> list = new Dictionary<string, int>();
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

                            foreach (KeyValuePair<string, IDictionary<string, int>> k in enumsByVars)
                            {
                                // Console.WriteLine(unit.Id_interface + "." + unit.LocalRank + "##################################### " + s.Id_inner);
                                IDictionary<string, int> rElist = k.Value;

                                int occurrences = 0;
                                foreach (KeyValuePair<string, int> re in rElist)
                                {
                                    IDictionary<string, int> enumeratorCardinalityNew;
                                    KeyValuePair<string, int> replicator;
                                    bool found = findReplicator(unit, re, s, ic, unit.EnumeratorCardinality, out enumeratorCardinalityNew, out replicator);
                                    if (found)
                                    {
                                        if (!rE_.ContainsKey(replicator.Key))
                                        {
                                            rE_.Add(replicator);
                                            unit_slice.EnumeratorCardinality = enumeratorCardinalityNew;
                                            occurrences++;
                                        }
                                    }
                                }
                            }


                            IList<IDictionary<string, int>> l;
                            if (!enumRanksL.TryGetValue(id_interface_slice, out l))
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
                    string id_unit_slice;
                    unitsMapping.TryGetValue(id_unit_slice_, out id_unit_slice);

                    IList<int> ranks;
                    if (!ranksAll.TryGetValue(id_unit_slice, out ranks))
                        ranks = new List<int>();

                    foreach (int r in ranks)
                        ranksAllList.Insert(pos2++, r);

                    IList<IDictionary<string, int>> enumRanks;
                    if (!enumRanksL.TryGetValue(id_unit_slice, out enumRanks))
                        enumRanks = new List<IDictionary<string, int>>();
                    else
                        insertEnumeratorFusions(unit_slice, id_unit_slice, enumRanks);

                    foreach (IDictionary<string, int> d in enumRanks)
                        enumRanksList.Insert(pos1++, /* removePrefixes( id_inner ,*/ d /* ) */);

                    // Calculate o.Units ...
                    int count;
                    countUnits.TryGetValue(id_unit_slice, out count);

                    int[] _ranks = new int[count]; 
                    ranks.CopyTo(_ranks, 0);
                    unitsRanks.Add(id_unit_slice_, _ranks);
                }

                int[] ranksAllArr = new int[ranksAllList.Count];
                IDictionary<string, int>[] enumRanksArr = new IDictionary<string, int>[enumRanksList.Count];

                ranksAllList.CopyTo(ranksAllArr, 0);
                enumRanksList.CopyTo(enumRanksArr, 0);

                unit_slice.Ranks = ranksAllArr;
                unit_slice.EnumRanks = enumRanksArr;
                unit_slice.Units = unitsRanks;
            }

            private static int enumeratorCardinality(string[] enums, string var)
            {
                int step = 0;
                foreach (string a in enums)
                {
                    if (step == 0 && a.Equals(var))
                    {
                        step = 1;
                    }
                    else if (step == 1)
                    {
                        return int.Parse(a);
                    }
                }

                return 0;
            }

            private static bool findReplicator(IUnit unit, KeyValuePair<string, int> re,
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
                    lse = BackEnd.sedao.listContainers(s.Id_abstract, s.Id_inner, s.Id_interface_slice, s.Id_split_replica);

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
                    }

                    enumeratorCardinality_return = enumeratorCardinality_prime;

                    return true;
                }

            }

            public static void determineActualParameters(IDictionary<string, int> actualParameters, int id_functor_app, out IDictionary<string, int> actualParameters_new)
            {
                actualParameters_new = new Dictionary<string, int>(); ;

                foreach (KeyValuePair<string, int> parameter in actualParameters)
                {
                    if (parameter.Key.Contains("#"))
                    {
                        actualParameters_new.Add(parameter);
                    }
                }

                SupplyParameterDAO spdao = new SupplyParameterDAO();
                IList<SupplyParameter> spcList = spdao.list(id_functor_app);

                foreach (SupplyParameter sp in spcList)
                {
                    if (sp is SupplyParameterParameter)
                    {
                        SupplyParameterParameter spp = (SupplyParameterParameter)sp;
                        int id_functor_app_actual;
                        bool achou = actualParameters.TryGetValue(spp.Id_parameter_actual, out id_functor_app_actual);
                        if (achou)
                        {
                            actualParameters_new.Add(spp.Id_parameter, id_functor_app_actual);
                        }
                    }
                    else if (sp is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                        actualParameters_new.Add(spc.Id_parameter, spc.Id_functor_app_actual);
                        traverseParameters(spc.Id_functor_app_actual, spc.Id_functor_app_actual, actualParameters, actualParameters_new);
                    }
                }
            }

            private static void traverseParameters(int id_functor_app_top,
                                            int id_functor_app,
                                            IDictionary<string, int> actualParametersTop,
                                            IDictionary<string, int> actualParameters)
            {

                SupplyParameterDAO spdao = new SupplyParameterDAO();
                IList<SupplyParameter> spcList = spdao.list(id_functor_app);
                foreach (SupplyParameter sp in spcList)
                {
                    if (sp is SupplyParameterParameter)
                    {
                        SupplyParameterParameter spp = (SupplyParameterParameter)sp;
                        int id_functor_app_actual;
                        bool achou = actualParametersTop.TryGetValue(spp.Id_parameter_actual, out id_functor_app_actual);
                        string key = spp.Id_parameter + "#" + id_functor_app_top;
                        if (!actualParameters.ContainsKey(key))
                            actualParameters.Add(key, id_functor_app_actual);
                    }
                    else if (sp is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                        traverseParameters(spc.Id_functor_app_actual, spc.Id_functor_app_actual, actualParametersTop, actualParameters);
                    }
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


            private static void insertEnumeratorFusions(IUnit o, string id_unit_slice, IList<IDictionary<string, int>> enumRanks)
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

            internal static void redirectSlice(ComponentID user_id, string portName, ComponentID container_id, string container_portName)
            {
                framework.redirectSlice(user_id, portName, container_id, container_portName);                
            }
        }//DGAC



		public class ConcreteComponentNotFoundException : Exception
        {
            private int id_abstract;
            private string id_inner;
            private int id_functor_app_implements;

            IDictionary<string, SupplyParameter> parsSuper = new Dictionary<string, SupplyParameter>();

            public ConcreteComponentNotFoundException(int id_functor_app_implements)
                : base()
            {
                this.id_functor_app_implements = id_functor_app_implements;

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

            private static readonly DateTime Jan1st1970 = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);

            public static long currentTimeMillis()
            {
                return (long)(DateTime.UtcNow - Jan1st1970).TotalMilliseconds;
            }


        }



    }//namespace

}
