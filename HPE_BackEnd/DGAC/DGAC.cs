using System;
using System.IO;
using System.Runtime.Remoting;
using System.Runtime.Remoting.Channels;
using System.Runtime.Remoting.Channels.Ipc;
using System.Collections.Generic;
using System.Reflection;
using HPE_DGAC_LoadDB;
using br.ufc.hpe.basic;
using br.ufc.hpe.backend.DGAC.utils;
using br.ufc.hpe.backend.DGAC.database;
using System.Data;
using System.Collections;
using System.Reflection.Emit;
using MPI;

using gov.cca;
using br.ufc.hpe.backend.ports;

namespace br.ufc.hpe.backend
{

    namespace ports
    {

        interface ComponentRepository 
        {
            EnvironmentType readEnvironment();
            void registerConcreteComponent(ComponentType ct, string userName, string password, string curDir);
            void registerAbstractComponent(ComponentType ct, string userName, string password, string curDir);
            void deleteComponent(String ID);
        }

        interface BuilderService 
        {
            // createInstance
            String[] runApplication(int id_concrete, String[] eIds, int[] eVls, string userName, string password, string curDir);

            // connect ??

            // ...

        }


    }

    namespace DGAC
    {
        /*
        * Essa classe é chamada pelo WS. Nela, as referencias aos workers são inicializadas. Para isto, os workers
        * já devem ter sido inicializados manualmente e identificados dentro do arquivo properties.xml, na pasta config
        */

        public class BackEnd 
        {

            private IpcClientChannel ch = null;

            public BackEnd()
            {
                Console.WriteLine("DGAC is up and running.");
            }


            public ManagerObject connectToManager()
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

            public void releaseWorker()
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
                    ManagerObject worker = connectToManager();

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

                    ManagerObject worker = connectToManager();

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
                    ManagerObject manager = connectToManager();
                    Connector.openConnection();

                    session_id = getSessionID(id_concrete);

                    IDictionary<string, int> enums = new Dictionary<string, int>();

                    for (int i = 0; i < eIds.Length; i++)
                    {
                        enums.Add(eIds[i], eVls[i]);
                    }

                    DGAC.database.Component c = cdao.retrieve(id_concrete);

                    int[] nodes = new int[] { 0, 1, 2, 3, 4 };

                    /* BEGIN UNDER CONSTRUCTION */
                    TypeMapImpl properties = new TypeMapImpl();
                    properties[Constants.ENUMS_KEY] = enums;
                    properties[Constants.NODES_KEY] = nodes;
                    properties[Constants.SESSION_KEY] = session_id;

                    Console.WriteLine("before manager.createInstance");

                    manager.createInstance(session_id.ToString(), c.Library_path, properties);

                    /* END UNDER CONSTRUCTION */
                    releaseWorker();

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

            public String[] runApplication2(int id_concrete, String[] eIds, int[] eVls, string userName, string password, string curDir)
            {
                String[] str_output = null;
                // assert: eIds.Length = eVls.Length
                try
                {
                    ManagerObject server = connectToManager();
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

            public static hpe.basic.IUnit createSlice(hpe.basic.IUnit ownerUnit,
                                                          string hash_component_uid,
                                                          string id_inner,
                                                          string id_interface,
                                                          System.Type[] typeParams /* obsolete - calculated at run-time by buildParamsTable */
                                                         )
            {
                return ((ServicesImpl)ownerUnit.Services).registerUsesPort(ownerUnit, hash_component_uid, id_inner, id_interface);
            }



            /* RUN TIME ROUTINES */


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


        }



    }//namespace

}