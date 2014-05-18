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
using System.Runtime.Remoting.Activation;
using System.Runtime.Remoting.Channels.Tcp;
using System.Threading;
using System.Runtime.CompilerServices;

namespace br.ufc.pargo.hpe.backend
{

    namespace DGAC
    {

        public class BackEnd 
        {

            public static WorkerObject worker_framework = null;

            private IpcClientChannel ch = null;

            public BackEnd()
            {
                Console.WriteLine("DGAC is up and running.");
            }

			#region FRAMEWORK_INSTANTIATION
			
            public static gov.cca.AbstractFramework getFrameworkInstance()
            {
				//TcpChannel channel = new TcpChannel(Constants.MANAGER_PORT/*prop, client_provider*/);
        		//ChannelServices.RegisterChannel(channel);
				
				//RemotingConfiguration.ApplicationName = Constants.MANAGER_SERVICE_NAME;
				ManagerObject obj = new ManagerObject();
                return (gov.cca.AbstractFramework) obj;
            }

            public static gov.cca.AbstractFramework getFrameworkInstance(out IpcClientChannel ch)
            {
                IDictionary prop = new Hashtable();
                prop["portName"] = Constants.MANAGER_PORT_NAME;

                System.Runtime.Remoting.Channels.BinaryClientFormatterSinkProvider client_provider = new System.Runtime.Remoting.Channels.BinaryClientFormatterSinkProvider();
				
				ch = new IpcClientChannel(prop, client_provider);
                ChannelServices.RegisterChannel(ch, false);
                object[] activateAttribute = {new UrlAttribute("ipc://ManagerHost")};
				ManagerObject obj = (ManagerObject) Activator.CreateInstance(typeof(ManagerObject), null, activateAttribute);
                return (gov.cca.AbstractFramework) obj;
            }
						 
            public static gov.cca.AbstractFramework getFrameworkWorkerInstance(string node, int port, int rank)
            {
                WorkerObject wo = null;
		
				string service_name = Constants.WORKER_SERVICE_NAME + "-" + rank;
				string uri_str = "tcp://" + node + ":" + port + "/" + service_name;
				
// Register the TCP channel.
//        ChannelServices.RegisterChannel(new TcpChannel(), false);

        // Create a url attribute object.
        UrlAttribute attribute = new UrlAttribute(uri_str);
        object[] activationAttributes = new object[] { attribute };

        // Register the client for the remote object.
        //RemotingConfiguration.RegisterActivatedClientType(typeof(WorkerObject),  uri_str);

			wo = (WorkerObject) Activator.CreateInstance(typeof(WorkerObject), null, activationAttributes); 			
			wo.sayHi();
		
                return wo;
            }
			
            public static void releaseManager(IpcClientChannel ch)
            {
                ChannelServices.UnregisterChannel(ch);
            }
			
			#endregion FRAMEWORK_INSTANTIATION
			
			#region DEPLOY
			
            public int registerAbstractComponent(ComponentType ct, string userName, string password, string curDir)
            {
                AbstractComponentFunctor cAbs = null;
                try
                {
                    Connector.openConnection();
                    Connector.beginTransaction();
                    //ManagerObject worker = (ManagerObject) getFrameworkInstance(out ch);

                    int exists = 1;
                    LoaderAbstractComponent abstractloader = new LoaderAbstractComponent();
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
                        Console.Error.WriteLine("Abstract component " + ct.header.packagePath + "." + ct.header.name + " is already deployed. Updating sources ...");
                        abstractloader.updateSources(ct, cAbs);
                        exists = 0;
                    }

                    Console.Error.Write("Compiling sources ...");

                    ICollection<LoaderApp.InfoCompile> infoCompile = LoaderApp.getReferences_Abstract(cAbs.Id_abstract);
					sendToCompile(infoCompile, userName, password, curDir, exists);
                    Console.Error.Write("ok ");

                    Connector.commitTransaction(); // if it is ok, commit ...

		    Console.Error.WriteLine("commited !");

                }
                catch (Exception e)
                {
                    Console.Error.Write("Rolling back transaction... " +  e.Message + " ----- stack:"+  e.StackTrace);
                    Connector.rollBackTransaction();
                    Console.Error.WriteLine("ok");
                    throw e;
                }
                finally
                {
                    releaseManager(ch);
                    Connector.closeConnection();
                }
				
				return cAbs != null ? cAbs.Id_abstract : -1;
            }
			
			public void sendToCompile (ICollection<LoaderApp.InfoCompile> infoCompile, string userName, string password, string curDir, int set_public_key)
			{
                    ManagerObject worker = (ManagerObject) getFrameworkInstance(out ch);                     

                    foreach (LoaderApp.InfoCompile unitToCompile in infoCompile)
                    {
                        int id = unitToCompile.id;
                        string cuid = unitToCompile.cuid;
                        string library_path = unitToCompile.library_path;
                        string moduleName = unitToCompile.moduleName;
                        string unitName = unitToCompile.unitId;
						int partition_index = unitToCompile.partition_index;
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
						switch(set_public_key)
						{
							case 1: idao.setPublicKey(id, unitName, partition_index, publicKey); break;
							case 2: udao.setPublicKey(cuid, unitName, publicKey); break;
						}
						
                    }
			}
			
			public void updateConfiguration(int id_abstract, byte[] hcl_data)
                        {
                try
                {
                    Connector.openConnection();
                    Connector.beginTransaction();
                                       
                                        AbstractComponentFunctor acf = acfdao.retrieve(id_abstract);
                                       
                                        string filename = acf.Library_path;
                                       
                                string path = Constants.PATH_TEMP_WORKER + filename + ".hcl";
                                                                               
                                FileUtil.saveByteArrayIntoFile(hcl_data, path);
                                       
                                }                              
                catch (Exception e)
                {
                                        Console.Error.WriteLine("Rolling back transaction ! Exception: " + e.Message);
                                        Console.Error.WriteLine(e.StackTrace);
                    Connector.rollBackTransaction();
                    throw e;
                }
                finally
                {
                    Connector.closeConnection();
                }
                        }
			
            public int registerConcreteComponent(ComponentType ct, string userName, string password, string curDir)
            {
                DGAC.database.Component cConc = null;
                try
                {
                    Connector.openConnection();
                    Connector.beginTransaction();

                    int exists = 2;
                    LoaderConcreteComponent concreteloader = new LoaderConcreteComponent();
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
                        exists = 0;
                    }

                    Console.Error.Write("Compiling sources ...");
					
					ICollection<LoaderApp.InfoCompile> infoCompile = LoaderApp.getReferences_Concrete(cConc.Id_concrete);
					sendToCompile(infoCompile, userName, password, curDir, exists);

                    Console.Error.Write("ok ");

                    Connector.commitTransaction(); // if it is ok, commit ...

                    Console.Error.WriteLine("commited !");


                }
                catch (Exception e)
                {
					Console.Error.WriteLine("Rolling back transaction ! Exception: " + e.Message);
					Console.Error.WriteLine(e.StackTrace);
                    Connector.rollBackTransaction();
                    throw e;
                }
                finally
                {
                    Connector.closeConnection();
                    releaseManager(ch);
                }
				
				return cConc != null ? cConc.Id_concrete : -1;
            }

            private string sendCompileCommandToWorker(string library_path, ManagerObject worker, string contents, string moduleName, string[] refs, int outFile, string userName, string password, String curDir)
            {
                return worker.compileClass(library_path, contents, moduleName, refs, outFile, userName, password, curDir);
            }

			#endregion DEPLOY
			
			#region ENVIRONMENT
			
            public static EnvironmentType readEnvironment()
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

            private static IList<DeployedComponentInfoType> readEnvironmentConcrete()
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
                    // deployed.enumerator = readEnvironmentEnumerators(id_abstract);
                    deployed.parameter = readEnvironmentConcreteParameters(c.Id_functor_app);

                    l.Add(deployed);
                }

                return l;
            }

            private static DeployedParameterType[] readEnvironmentConcreteParameters(int id_functor_app)
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
					//r[i].bound = ??
                    r[i].parameter = readEnvironmentConcreteParameters(sp.Id_functor_app_actual);
                    i++;
                }

                return r;
            }

            public static IList<DeployedComponentInfoType> readEnvironmentAbstract()
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
                    
                    //deployed.enumerator = readEnvironmentEnumerators(acf.Id_abstract);
                    deployed.parameter = readEnvironmentAbstractParameters(acf.Id_abstract);

                    l.Add(deployed);
                }

                return l;
            }
           
			private static DeployedParameterType[] readEnvironmentAbstractParameters(int id_abstract)
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
                    r[i].bound = acfa.Id_abstract;
                    r[i].parameter = readEnvironmentAbstractParameters(acfa.Id_abstract);
                    i++;
                }
                return r;
            }
			
			#endregion ENVIRONMENT
			
			#region RUN
			
            public String[] runApplication(string instantiatior_string, string userName, string password, string curDir)
            {
		    	int id_concrete = 0;
                session_id = getSessionID(id_concrete);
				string session_id_string = "session_" + session_id.ToString();
				
				return runApplicationNTimes(instantiatior_string, userName, password, curDir, 1, session_id_string);
			}
			
            public String[] runApplicationNTimes(string instantiatior_string, string userName, string password, string curDir, int rounds, string session_id_string)
            {	
                string[] str_output = null;
                try
                {
                    TypeMapImpl properties = new TypeMapImpl();					
					
                    gov.cca.AbstractFramework frw = getFrameworkInstance();
					
					gov.cca.Services frwServices = frw.getServices(session_id_string, "ApplicationLauncher", properties);
				    gov.cca.ComponentID host_cid = frwServices.getComponentID();
					
					Console.WriteLine("Connecting to the builder service port");
					frwServices.registerUsesPort(Constants.BUILDER_SERVICE_PORT_NAME, Constants.BUILDER_SERVICE_PORT_TYPE, properties);
					gov.cca.ports.BuilderService bsPort = (gov.cca.ports.BuilderService) frwServices.getPort (Constants.BUILDER_SERVICE_PORT_NAME);
					
					Console.WriteLine("Creating an instance of the application");
                    //ComponentID app_cid = bsPort.createInstance("app", instantiatior_string, properties);
					ManagerComponentID app_cid = (ManagerComponentID) createApplicationInstance (instantiatior_string, session_id_string, bsPort, frwServices, (ManagerObject) frw);
					
					Console.WriteLine("Connecting to the GoPort of the application");
					frwServices.registerUsesPort(Constants.GO_PORT_NAME, Constants.GO_PORT_TYPE, new TypeMapImpl());
					ConnectionID conn_go = bsPort.connect(host_cid, Constants.GO_PORT_NAME, app_cid, Constants.GO_PORT_NAME);
					gov.cca.ports.GoPort go_port = (gov.cca.ports.GoPort) frwServices.getPort (Constants.GO_PORT_NAME);
					
					Console.WriteLine ("Doing " + rounds + " executions of the application.");
					for (int round=0; round < rounds; round++) 
					{
						Console.WriteLine("ROUND #" + round);	
						go_port.go(); 
					}
					
					// RECURSIVELY, DISCONNECT ALL COMPONENT CONNECTIONS ...
				//	create_slices_port.destroy_slices();
					
					//frwServices.releasePort(Constants.CREATE_SLICES_PORT_NAME);
					//bsPort.disconnect(conn_cs, 0);
					//frwServices.unregisterUsesPort(Constants.CREATE_SLICES_PORT_NAME);
					
					frwServices.releasePort(Constants.GO_PORT_NAME);
					bsPort.disconnect(conn_go, 0);
					Console.WriteLine("Test e1");
					frwServices.unregisterUsesPort(Constants.GO_PORT_NAME);
					Console.WriteLine("Test e2");
					
					bsPort.destroyInstance(app_cid, 0);
					Console.WriteLine("Test e3");
					
					frwServices.releasePort(Constants.BUILDER_SERVICE_PORT_NAME);
					Console.WriteLine("Test e4");
					frwServices.unregisterUsesPort(Constants.BUILDER_SERVICE_PORT_NAME);
					
					Console.WriteLine ("Finishing");
					
                }
                catch (Exception e)
                {
					Console.WriteLine("## Exception: " + e.Message);
					Console.WriteLine("## Inner Exception: " + (e.InnerException == null ? "NULL" : e.InnerException.Message));
					Console.WriteLine("## Trace: " + e.StackTrace);
                    throw e;
                }

                return str_output == null ? new String[] { } : str_output;

            }

            public void testReconfiguration(string instantiatior_string_1,  string instantiatior_string_2, string session_id_string)
            {	
                try
                {
                    TypeMapImpl properties = new TypeMapImpl();					
					
                    gov.cca.AbstractFramework frw = getFrameworkInstance();
					
					gov.cca.Services frwServices = frw.getServices(session_id_string, "ApplicationLauncher", properties);
				    gov.cca.ComponentID host_cid = frwServices.getComponentID();
					
					Console.WriteLine("Connecting to the builder service port");
					frwServices.registerUsesPort(Constants.BUILDER_SERVICE_PORT_NAME, Constants.BUILDER_SERVICE_PORT_TYPE, properties);
					gov.cca.ports.BuilderService bsPort = (gov.cca.ports.BuilderService) frwServices.getPort (Constants.BUILDER_SERVICE_PORT_NAME);
					
					ManagerComponentID app_cid_1 = (ManagerComponentID) createApplicationInstance (instantiatior_string_1, session_id_string, bsPort, frwServices, (ManagerObject) frw);
					
					frwServices.registerUsesPort(Constants.GO_PORT_NAME, Constants.GO_PORT_TYPE, new TypeMapImpl());
					ConnectionID conn_go = bsPort.connect(host_cid, Constants.GO_PORT_NAME, app_cid_1, Constants.GO_PORT_NAME);
					gov.cca.ports.GoPort go_port = (gov.cca.ports.GoPort) frwServices.getPort (Constants.GO_PORT_NAME);
					go_port.go(); 
															
					ComponentID[] cids = bsPort.getComponentIDs();
					
					ManagerComponentID cid_to_reconfigure = (ManagerComponentID) cids[68];
					
					reconfigureComponentContext(cid_to_reconfigure,"axis",instantiatior_string_2, bsPort, frwServices, (ManagerObject) frw);
					
					go_port.go(); 
					
			//		ManagerComponentID app_cid_2 = (ManagerComponentID) createApplicationInstance (app_cid_1, instantiatior_string_2, session_id_string, bsPort, frwServices, (ManagerObject) frw);
			//		
			//		frwServices.registerUsesPort(Constants.GO_PORT_NAME, Constants.GO_PORT_TYPE, new TypeMapImpl());
			//		conn_go = bsPort.connect(host_cid, Constants.GO_PORT_NAME, app_cid_2, Constants.GO_PORT_NAME);
			//		go_port = (gov.cca.ports.GoPort) frwServices.getPort (Constants.GO_PORT_NAME);
			//		go_port.go(); 
					
					frwServices.releasePort(Constants.GO_PORT_NAME);
					bsPort.disconnect(conn_go, 0);
					frwServices.unregisterUsesPort(Constants.GO_PORT_NAME);
					
					destroyApplicationInstance(app_cid_1, bsPort, frwServices, (ManagerObject) frw);
					
					bsPort.destroyInstance(app_cid_1, 0);
			//		bsPort.destroyInstance(app_cid_2, 0);
					Console.WriteLine("Test e3");
					
					frwServices.releasePort(Constants.BUILDER_SERVICE_PORT_NAME);
					Console.WriteLine("Test e4");
					frwServices.unregisterUsesPort(Constants.BUILDER_SERVICE_PORT_NAME);
					
					Console.WriteLine ("Finishing");
					
                }
                catch (Exception e)
                {
					Console.WriteLine("## Exception: " + e.Message);
					Console.WriteLine("## Inner Exception: " + (e.InnerException == null ? "NULL" : e.InnerException.Message));
					Console.WriteLine("## Trace: " + e.StackTrace);
                    throw e;
                }

                

            }
			
			private class GoThread
			{
				private GoPort go_port = null;
				
				public GoThread(GoPort go_port)
				{
					this.go_port = go_port;
				}
				
				public void go()
				{
					go_port.go();
				}
				             
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
			
			#endregion RUN
			
			#region DATABASE

            private static AbstractComponentFunctorDAO acfdao_ = null;
            private static AbstractComponentFunctorApplicationDAO acfadao_ = null;
            private static AbstractComponentFunctorParameterDAO acfpdao_ = null;
            private static InterfaceDAO idao_ = null;
            private static UnitDAO udao_ = null;
            private static InterfaceParameterDAO ipdao_ = null;
            private static InterfaceActionDAO iadao_ = null;
            private static SupplyParameterDAO spdao_ = null;
            private static SupplyParameterComponentDAO spcdao_ = null;
            private static SupplyParameterParameterDAO sppdao_ = null;
            private static ComponentDAO cdao_ = null;
            private static InnerComponentDAO icdao_ = null;
            private static InnerComponentExposedDAO icedao_ = null;
            private static SliceDAO sdao_ = null;
            private static SourceCodeDAO scdao_ = null;
            private static SourceCodeReferenceDAO scrdao_ = null;
            private static SliceExposedDAO sedao_ = null;

            public static AbstractComponentFunctorDAO acfdao { get { if (acfdao_ == null) acfdao_ = new AbstractComponentFunctorDAO(); return acfdao_; } }
            public static AbstractComponentFunctorApplicationDAO acfadao { get { if (acfadao_ == null) acfadao_ = new AbstractComponentFunctorApplicationDAO(); return acfadao_; } }
            public static AbstractComponentFunctorParameterDAO acfpdao { get { if (acfpdao_ == null) acfpdao_ = new AbstractComponentFunctorParameterDAO(); return acfpdao_; } }
            public static InterfaceDAO idao { get { if (idao_ == null) idao_ = new InterfaceDAO(); return idao_; } }
            public static InterfaceParameterDAO ipdao { get { if (ipdao_ == null) ipdao_ = new InterfaceParameterDAO(); return ipdao_; } }
            public static InterfaceActionDAO iadao { get { if (iadao_ == null) iadao_ = new InterfaceActionDAO(); return iadao_; } }
            public static UnitDAO udao { get { if (udao_ == null) udao_ = new UnitDAO(); return udao_; } }
            public static SupplyParameterDAO spdao { get { if (spdao_ == null) spdao_ = new SupplyParameterDAO(); return spdao_; } }
            public static SupplyParameterComponentDAO spcdao { get { if (spcdao_ == null) spcdao_ = new SupplyParameterComponentDAO(); return spcdao_; } }
            public static SupplyParameterParameterDAO sppdao { get { if (sppdao_ == null) sppdao_ = new SupplyParameterParameterDAO(); return sppdao_; } }
            public static ComponentDAO cdao { get { if (cdao_ == null) cdao_ = new ComponentDAO(); return cdao_; } }
            public static InnerComponentDAO icdao { get { if (icdao_ == null) icdao_ = new InnerComponentDAO(); return icdao_; } }
            public static InnerComponentExposedDAO icedao { get { if (icedao_ == null) icedao_ = new InnerComponentExposedDAO(); return icedao_; } }
            public static SliceDAO sdao { get { if (sdao_ == null) sdao_ = new SliceDAO(); return sdao_; } }
            public static SourceCodeDAO scdao { get { if (scdao_ == null) scdao_ = new SourceCodeDAO(); return scdao_; } }
            public static SourceCodeReferenceDAO scrdao { get { if (scrdao_ == null) scrdao_ = new SourceCodeReferenceDAO(); return scrdao_; } }
            public static SliceExposedDAO sedao { get { if (sedao_ == null) sedao_ = new SliceExposedDAO(); return sedao_; } }
			
			#endregion DATABASE
			
			#region RESOLUTION
			
            public static DGAC.database.Component resolveUnit(
                            AbstractComponentFunctorApplication acfaRef,
                            IDictionary<string, int> arguments,
                            IDictionary<string, int> argumentsTop
                        )
            {                
                return LoaderApp.resolveImpl(acfaRef, arguments, argumentsTop);
            }

            public static DGAC.database.Component resolveUnit(
                            AbstractComponentFunctorApplication acfaRef
                        )
            {
                return resolveUnit(acfaRef, new Dictionary<string, int>(), new Dictionary<string, int>());
            }

            public static br.ufc.pargo.hpe.backend.DGAC.database.Unit takeUnit(
                DGAC.database.Component c,
                string id_interface, int partition_index)
            {
                string id_unit = null;
                Interface i2 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveSuper(c.Id_abstract, id_interface, partition_index);
                foreach (Interface i in br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.list(c.Id_abstract))
                {
                    if (i.Id_interface_super_top.Equals(i2.Id_interface_super_top))
                    {
                        id_unit = i.Id_interface;
                    }
                }

                return br.ufc.pargo.hpe.backend.DGAC.BackEnd.udao.retrieve(c.Id_concrete, id_unit, 1);
            }
            
			#endregion RESOLUTION
			
			#region CALCULATE_CLASS_PARAMETERS
			
            public static System.Type[] calculateActualClassParameteres(Interface i, int id_functor_app, IDictionary<string, int> arguments)
            {
                IList<InterfaceParameter> ipars = BackEnd.ipdao.list(i.Id_abstract,i.Id_interface);
                System.Type[] result = new System.Type[ipars.Count];
				
				Console.WriteLine ("IPARS.LENGTH = " + ipars.Count);
                foreach (InterfaceParameter ipar in ipars)
                {
					Console.WriteLine("parameter ----- " + ipar.ParId + "#" + id_functor_app);
					foreach (KeyValuePair<string,int> uuuu in arguments)
						Console.WriteLine("KEY=" + uuuu.Key + "; VALUE=" + uuuu.Value); 
					
                    int id_functor_app_parameter;
                    string parid = ipar.ParId;
                    if (arguments.TryGetValue(parid, out id_functor_app_parameter) || 
                        arguments.TryGetValue(parid + "#" + id_functor_app, out id_functor_app_parameter))
                    {
						Console.WriteLine("parameter (dentro do if) ----- " + id_functor_app_parameter);
                        AbstractComponentFunctorApplication acfa_parameter = BackEnd.acfadao.retrieve(id_functor_app_parameter);
                        AbstractComponentFunctor acf_parameter = BackEnd.acfdao.retrieve(acfa_parameter.Id_abstract);
                        Interface iPar = BackEnd.idao.retrieveSuper(acf_parameter.Id_abstract, ipar.Id_unit_parameter,0);

                        IDictionary<string, int> arguments_new;
                        determineArguments(arguments, id_functor_app_parameter, out arguments_new);
                        
                        System.Type[] parameters = calculateActualClassParameteres(iPar, id_functor_app_parameter, arguments_new);
                        
                        // Build a type from iPar applied to parType.

                        string assembly_string = iPar.Assembly_string;      // where to found the DLL (retrieve from the component).
                        string class_name = iPar.Class_name;  // the name of the class inside the DLL.
                        int class_nargs = iPar.Class_nargs;
                        string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");

				Console.WriteLine("PAR class_name = "  + class_name);
				Console.WriteLine("PAR class_nargs = " + class_nargs);
				Console.WriteLine ("PAR strType = " + strType);
				Console.WriteLine ("PAR parameters.Length = " + parameters.Length);
						
                        Assembly a = Assembly.Load(assembly_string);
                        System.Type t = a.GetType(strType);

                        System.Type closedT = parameters.Length > 0 ? t.MakeGenericType(parameters) : t;

                        result[ipar.ParOrder] = closedT;

                    }
                }
                return result;
            }

           
            private static void calculateActualParams_(
                IDictionary<string,int> arguments,
                AbstractComponentFunctorApplication acfaRef,
                string id_interface, int partition_index,
                out System.Type[] actualParams)
            {
                IDictionary<string, int> arguments_new;
                determineArguments(arguments, acfaRef.Id_functor_app, out arguments_new);

                Interface i = BackEnd.idao.retrieveSuper(acfaRef.Id_abstract, id_interface, partition_index);
                actualParams = calculateActualClassParameteres(i, acfaRef.Id_functor_app, arguments_new);
            }

            public static void calculateActualParams(
				IDictionary<string, int> arguments,
                AbstractComponentFunctorApplication acfaRef,
                string id_interface, int partition_index,
                out System.Type[] actualParams)
            {
                calculateActualParams_(arguments, acfaRef, id_interface, partition_index, out actualParams);
            }
			
            public static void calculateActualParams(
                AbstractComponentFunctorApplication acfaRef,
                string id_interface, int partition_index,
                out System.Type[] actualParams)
            {
                calculateActualParams_(new Dictionary<string, int>(), acfaRef, id_interface, partition_index, out actualParams);
            }
            
     /*       public static void calculateActualParams(
                IUnit enclosing_unit, 
                AbstractComponentFunctorApplication acfaRef,
                string id_interface, int partition_index, 
                out System.Type[] actualParams)
            {
                calculateActualParams_(enclosing_unit.arguments, acfaRef, id_interface, partition_index, out actualParams);
            }*/

            public static void calculateGenericClassName(
                br.ufc.pargo.hpe.backend.DGAC.database.Unit u,
                System.Type[] actualParams,
                out string type)
            {
                string assembly_string = u.Assembly_string;      // where to found the DLL (retrieve from the component).
                string class_name = u.Class_name;  // the name of the class inside the DLL.
                int class_nargs = u.Class_nargs;
                string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");
				
				Console.WriteLine("assembly_string = "  + assembly_string);
				Console.WriteLine("class_name = "  + class_name);
				Console.WriteLine("class_nargs = " + class_nargs);
				Console.WriteLine ("strType = " + strType);
				Console.WriteLine ("actualParams.Length = " + actualParams.Length);
				
                Assembly a = Assembly.Load(assembly_string);
                System.Type t = a.GetType(strType);
				
				for (int i=0; i < actualParams.Length; i++)
				{
					System.Type ttt = actualParams[i];
					if (ttt == null) 
					{
					   Console.WriteLine("PARAM (actualParams): NULL ---" + t);
					   actualParams[i] = fetchTypeConstraint(u,i);					
					}
					else 
					{
					   Console.WriteLine("PARAM (actualParams): " + ttt.AssemblyQualifiedName);
					}
				}
				
				Console.WriteLine("END CALCULATE GENERIC CLASS NAME ...1");
				System.Type closedT = t;
				if (actualParams.Length > 0)
				{
					Console.WriteLine("END CALCULATE GENERIC CLASS NAME ...1.5 " + t==null);
					closedT = t.MakeGenericType(actualParams);
				}
				Console.WriteLine("END CALCULATE GENERIC CLASS NAME ...2");
                type = closedT.FullName;
				Console.WriteLine("END CALCULATE GENERIC CLASS NAME ...3");
            }
			
			public static System.Type fetchTypeConstraint(br.ufc.pargo.hpe.backend.DGAC.database.Unit u, int i) 
			{
			    br.ufc.pargo.hpe.backend.DGAC.database.Component c = br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieve(u.Id_concrete);	
				AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(c.Id_abstract);

				InterfaceParameter ip = br.ufc.pargo.hpe.backend.DGAC.BackEnd.ipdao.retrieveByOrder(acf.Id_abstract, u.Id_interface, i);
				
               // AbstractComponentFunctorParameter acfp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(acf.Id_abstract,ip.ParId);
				
			   //	AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acfp.Bounds_of);
				
				SupplyParameterComponent spc = (SupplyParameterComponent) br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.retrieve(ip.ParId, c.Id_functor_app);
				AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(spc.Id_functor_app_actual);
				
				Interface iPar = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveSuper(acfa.Id_abstract, ip.Id_unit_parameter, 0);
			    	
                string assembly_string = iPar.Assembly_string;      // where to found the DLL (retrieve from the component).
                string class_name = iPar.Class_name;  // the name of the class inside the DLL.
                int class_nargs = iPar.Class_nargs;
                string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");

			//	Console.WriteLine("PAR class_name = "  + class_name);
			//	Console.WriteLine("PAR class_nargs = " + class_nargs);
			//	Console.WriteLine ("PAR strType = " + strType);
						
                Assembly a = Assembly.Load(assembly_string);
                System.Type t = a.GetType(strType);

                //System.Type closedT = parameters.Length > 0 ? t.MakeGenericType(parameters) : t;

                //result[ipar.ParOrder] = closedT;
				
				
				return t;
	   }
			
            public static void determineArguments(IDictionary<string, int> arguments, int id_functor_app, out IDictionary<string, int> arguments_new)
            {
				Console.WriteLine ("START determineArguments " + id_functor_app);
				
                arguments_new = new Dictionary<string, int>(); ;

                foreach (KeyValuePair<string, int> parameter in arguments)
                {
					Console.WriteLine("traversing arguments : " + parameter.Key);
                    if (parameter.Key.Contains("#"))
                    {
                        arguments_new.Add(parameter);
						Console.WriteLine("adding parameter key=" + parameter.Key + ", value="+  parameter.Value);
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
                        bool achou = arguments.TryGetValue(spp.Id_argument, out id_functor_app_actual);
						Console.WriteLine("TESTING " + spp.Id_argument + " : " + achou + " , " + id_functor_app_actual);
                        if (achou)
                        {
                            arguments_new.Add(spp.Id_parameter, id_functor_app_actual);
						    Console.WriteLine("adding parameter (determineArguments) 1 key=" + spp.Id_parameter + "; value=" + id_functor_app_actual);
                        } 
						
                    }
                    else if (sp is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                        arguments_new.Add(spc.Id_parameter, spc.Id_functor_app_actual);
						Console.WriteLine("adding parameter (determineArguments) 2 key=" + spc.Id_parameter + "; value="+ spc.Id_functor_app_actual);
						traverseArguments(spc.Id_functor_app_actual, spc.Id_functor_app_actual, arguments, arguments_new);
                    }
                }
				Console.WriteLine ("END determineArguments " + id_functor_app);
                foreach (KeyValuePair<string, int> parameter in arguments_new)
                {
					Console.WriteLine("END determineArguments arguments_new: key=" + parameter.Key + "; value=" + parameter.Value);
				}

            }

            private static void traverseArguments(int id_functor_app_top,
                                            	  int id_functor_app,
                                            	  IDictionary<string, int> argumentsTop,
                                            	  IDictionary<string, int> arguments)
            {

                SupplyParameterDAO spdao = new SupplyParameterDAO();
                IList<SupplyParameter> spcList = spdao.list(id_functor_app);

//                foreach (KeyValuePair<string, int> parameter in argumentsTop)
//                {
//					Console.WriteLine("traversing top arguments : key=" + parameter.Key + "; value=" + parameter.Value);
//				}

                foreach (SupplyParameter sp in spcList)
                {
                    if (sp is SupplyParameterParameter)
                    {
                        SupplyParameterParameter spp = (SupplyParameterParameter) sp;
                        int id_functor_app_actual;

                        bool achou = argumentsTop.TryGetValue(spp.Id_argument, out id_functor_app_actual);
                        string key = spp.Id_parameter + "#" + id_functor_app_top;
                        if (!arguments.ContainsKey(key)) {
                            arguments.Add(key, id_functor_app_actual);
							Console.WriteLine("adding parameter (traverseParameters) 3 key=" + key + "; value="+ id_functor_app_actual + " -- " + achou + " --- " + spp.Id_argument);
						}
                    }
                    else if (sp is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spc = (SupplyParameterComponent)sp;
						Console.WriteLine("traverseArguments - recursive - " + spc.Id_parameter + "," + spc.Id_functor_app + "," + spc.Id_functor_app_actual);
                        traverseArguments(spc.Id_functor_app_actual, spc.Id_functor_app_actual, argumentsTop, arguments);
                    } 
                }


            }

	  #endregion CALCULATE_CLASS_PARAMETERS
			
		#region CREATE_ACFA
		
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
					Console.Error.WriteLine(e.Message);
                }
                finally
                {
                    Connector.closeConnection();
                }

                return aAppNew;
            }
				
			public static AbstractComponentFunctorApplication createACFAByChangingContext (int id_functor_app, string parameter_id, AbstractComponentFunctorApplication acfaRef_par)
			{
                AbstractComponentFunctorApplication aAppNew = null;

                try
                {
                    Connector.openConnection();
										
					
					
                    AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(id_functor_app);

                    aAppNew = new AbstractComponentFunctorApplication();
                    aAppNew.Id_functor_app = Connector.nextKey("id_functor_app", "abstractcomponentfunctorapplication");
                    aAppNew.Id_abstract = acfa.Id_abstract;
                    DGAC.BackEnd.acfadao.insert(aAppNew);
					
					IList<SupplyParameter> spList = spdao.list(id_functor_app);
					foreach (SupplyParameter par0 in spList) 
					{
						if (par0 is SupplyParameterComponent) 
						{
							SupplyParameterComponent par2 = new SupplyParameterComponent();
							SupplyParameterComponent par1 = (SupplyParameterComponent) par0;
                            par2.Id_functor_app = aAppNew.Id_functor_app;
                            par2.Id_abstract = par1.Id_abstract;
							par2.Id_parameter = par1.Id_parameter;
							if (par1.Id_parameter.Equals(parameter_id))
                            	par2.Id_functor_app_actual = acfaRef_par.Id_functor_app;
							else
								par2.Id_functor_app_actual = par1.Id_functor_app_actual;
                        	DGAC.BackEnd.spdao.insert(par2);
						}
						else
						{
							/*SupplyParameterParameter par1 = (SupplyParameterParameter) par0;
							if (par1.Id_parameter.Equals(parameter_id))
							{
						    	// CLOSE FREE PARAMETER
								SupplyParameterComponent par2 = new SupplyParameterComponent();
	                            par2.Id_functor_app = aAppNew.Id_functor_app;
	                            par2.Id_abstract = par1.Id_abstract;
								par2.Id_parameter = par1.Id_parameter;
								par2.Id_functor_app_actual = acfaRef_par.Id_functor_app;
                        		DGAC.BackEnd.spdao.insert(par2);
							}
							else
							{
								// FREE PARAMETER
								SupplyParameterParameter par2 = new SupplyParameterParameter();
								par2.Id_abstract = par1.Id_abstract;
								par2.Id_functor_app = par1.Id_functor_app;
								par2.Id_parameter = par1.Id_parameter;
								par2.Id_parameter_actual = par1.Id_parameter_actual;
                        		DGAC.BackEnd.spdao.insert(par2);
							}*/
						}
					}
					

                 }
                catch (Exception e)
                {
					Console.Error.WriteLine(e.Message);
                }
                finally
                {
                    Connector.closeConnection();
                }

                return aAppNew;
			}
			
			public static int generateACFAforContext (int id_abstract,
				                                      int id_functor_app, 
				                                      IDictionary<string, int> arguments, 
				                                      IDictionary<string, int> argumentsTop)
			{
			   /* TODO: ESSA FUNÇÃO PRECISA SER MELHORADA PARA CASAR NUMEROS DE ARGUMENTOS DIFERENTES ENTRE  O TIPO DO 
				        COMPONENTE retornado pela resolução e o tipo do componente aninhado, conforme as regras do HTS.
				        DO jeito que está, ambos tem que ter os mesmos argumentos */
					
				AbstractComponentFunctorApplication acfa = new AbstractComponentFunctorApplication(); 
					
				acfa.Id_functor_app = Connector.nextKey("id_functor_app", "abstractcomponentfunctorapplication");				
				acfa.Id_abstract = id_abstract;
				//acfa.Id_functor_app_next;
				acfadao.insert(acfa);
				
				IList<SupplyParameter> spList = spdao.list(id_functor_app);
					
				foreach (SupplyParameter sp in spList) 
				{
				    SupplyParameterComponent spc_new = new SupplyParameterComponent();		
					spc_new.Id_functor_app = acfa.Id_functor_app;
					spc_new.Id_abstract = sp.Id_abstract;
					spc_new.Id_parameter = sp.Id_parameter;
					if (sp is SupplyParameterComponent)	
					{
						SupplyParameterComponent spc = (SupplyParameterComponent) sp;	
						spc_new.Id_functor_app_actual = spc.Id_functor_app_actual;
					}	
					else // SupplyParameterParameter
					{
						SupplyParameterParameter spp = (SupplyParameterParameter) sp;	
						int id_functor_app_actual;
						if (arguments.TryGetValue(spp.Id_argument, out id_functor_app_actual) 
							|| arguments.TryGetValue(spp.Id_parameter + "#" + spp.Id_functor_app, out id_functor_app_actual))
						{
							spc_new.Id_functor_app_actual = id_functor_app_actual;
						}
						else
						{
							Console.WriteLine("generateACFAforContext (DGAC.cs): Free parameter ? " + spp.Id_argument + "#" + spp.Id_functor_app);		
						}	
					}
					spdao.insert(spc_new);
				}
					
					
					
				return acfa.Id_functor_app;	
			}
			
			#endregion CREATE_ACFA
				
			#region INITIALIZE_APPLICATION
				
			private static IDictionary<ComponentID, bool> initialized = new Dictionary<ComponentID, bool>();
			private static IDictionary<ComponentID, bool> after_initialized = new Dictionary<ComponentID, bool>();
					
			private static void initializeApplication(ManagerComponentID cid, 
				                                     gov.cca.ports.BuilderService bsPort, 
				                                     gov.cca.Services frwServices)
			{
				onInitializeApplication(cid, bsPort, frwServices);
				afterInitializeApplication(cid, bsPort, frwServices);
			}
				
			private static void onInitializeApplication(ManagerComponentID cid, 
				                                     gov.cca.ports.BuilderService bsPort, 
				                                     gov.cca.Services frwServices)
			{
				Dictionary<string,ConnectionID> inner_conn_list = new Dictionary<string, ConnectionID>();		
				fetchConnectionsAsUser(cid, inner_conn_list, bsPort, frwServices);
								
				foreach (KeyValuePair<string, ConnectionID> inner in inner_conn_list /*InnerComponent ic in icList*/)				
				{					
					ComponentID inner_cid = inner.Value.getProvider();	
					if (!initialized.ContainsKey(inner_cid))
					{
						initializeApplication((ManagerComponentID)inner_cid, bsPort, frwServices);	
						initialized.Add(inner_cid,true);
					}
				}
					
				Console.WriteLine("Connecting to the AutomaticSlices port of the application");
				frwServices.registerUsesPort(Constants.INITIALIZE_PORT_NAME, Constants.INITIALIZE_PORT_TYPE, new TypeMapImpl());
				ConnectionID conn_cs = bsPort.connect(frwServices.getComponentID(), Constants.INITIALIZE_PORT_NAME, cid, Constants.INITIALIZE_PORT_NAME);            
				InitializePort initialize_port = (InitializePort) frwServices.getPort (Constants.INITIALIZE_PORT_NAME);
					
				Console.WriteLine("INITIALIZING " + cid);
				
				initialize_port.initialize(); 
				
				//initialized.Add(cid,true);
					
				frwServices.releasePort(Constants.INITIALIZE_PORT_NAME);
				bsPort.disconnect(conn_cs,0);	
				frwServices.unregisterUsesPort(Constants.INITIALIZE_PORT_NAME);
					
			}
				
			private static void afterInitializeApplication(ManagerComponentID cid, 
				                                     gov.cca.ports.BuilderService bsPort, 
				                                     gov.cca.Services frwServices)
			{
									
			    Console.WriteLine("Connecting to the AutomaticSlices port of the application");
				frwServices.registerUsesPort(Constants.INITIALIZE_PORT_NAME, Constants.INITIALIZE_PORT_TYPE, new TypeMapImpl());
				ConnectionID conn_cs = bsPort.connect(frwServices.getComponentID(), Constants.INITIALIZE_PORT_NAME, cid, Constants.INITIALIZE_PORT_NAME);            
				InitializePort initialize_port = (InitializePort) frwServices.getPort (Constants.INITIALIZE_PORT_NAME);
					
				Console.WriteLine("AFTER INITIALIZING " + cid);
				//after_initialized.Add(cid,true);
				initialize_port.post_initialize();
				
				frwServices.releasePort(Constants.INITIALIZE_PORT_NAME);
				bsPort.disconnect(conn_cs,0);	
				frwServices.unregisterUsesPort(Constants.INITIALIZE_PORT_NAME);
					
				Dictionary<string,ConnectionID> inner_conn_list = new Dictionary<string, ConnectionID>();		
				fetchConnectionsAsUser(cid, inner_conn_list, bsPort, frwServices);
				
				foreach (KeyValuePair<string, ConnectionID> inner in inner_conn_list /*InnerComponent ic in icList*/)				
				{					
					ComponentID inner_cid = inner.Value.getProvider();	
						
					if (!after_initialized.ContainsKey(inner_cid))
					{
						after_initialized.Add(inner_cid,true);
						afterInitializeApplication((ManagerComponentID)inner_cid, bsPort, frwServices);	
					}
										
				}
					
			}
				
			#endregion INITIALIZE_APPLICATION			
								
			#region RESOLUTION_AT_MANAGER
			
			public static ComponentID reconfigureComponentContext
													   (ManagerComponentID cid,
				 										string parameter_id,
														string actual_parameter, 
				                                        gov.cca.ports.BuilderService bsPort, 
				                                        gov.cca.Services frwServices,
			                                            ManagerObject frw
				 										/*xml*/)
			{
	            try
	            {
	                Connector.openConnection();
					
					string session_id_string = cid.getInstanceName() + "-" + parameter_id;
	                FileInfo file = FileUtil.writeToFile(session_id_string + ".xml", actual_parameter);
	                ComponentFunctorApplicationType instantiator = LoaderApp.DeserializeInstantiator(file.FullName);
	                DGAC.database.AbstractComponentFunctorApplication acfaRef_par = DGAC.BackEnd.loadACFAFromInstantiator(instantiator);
								
					// Fetching the enclosing component, if it exists.
					#region TRY_FETCH_ENCLOSING_COMPONENT
					IList<ConnectionID> inner_conn_list = new List<ConnectionID>();					
					fetchConnectionsAsProvider(cid, inner_conn_list, bsPort, frwServices);
					ConnectionID owner_connid = null;
					foreach (ConnectionID conn in inner_conn_list)
						if (conn.getProviderPortName().Equals(Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS))
						{
							owner_connid = conn;
							break;
						}
					//inner_conn_list.TryGetValue(Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS, out owner_connid);
					ManagerComponentID owner_cid = owner_connid != null ? (ManagerComponentID) owner_connid.getUser(): null;
					
					InnerComponent ic = null;
					if (owner_cid != null)
					{
					   AbstractComponentFunctorApplication acfa = acfadao.retrieve(owner_cid.Id_functor_app);
					   ic = icdao.retrieve(acfa.Id_abstract, cid.PortName);
					}
					#endregion				
					
					// Check whether the parameter is properly defined by the inner component.
					bool is_free_parameter;
					checkParameterInReconfiguration(ic, parameter_id, out is_free_parameter);			
					
					/* It is assumed that parameter_id is a free parameter (so, it will be closed) 
					 * or properly defined by the inner component (so, it will be changed) */				
					DGAC.database.AbstractComponentFunctorApplication acfaRef = createACFAByChangingContext(cid.Id_functor_app, parameter_id, acfaRef_par);
					
					// Fetch the #-component for the new contexy.
					DGAC.database.Component c = resolveUnit(acfaRef);	
					
					IDictionary<string,int> arguments = new Dictionary<string,int>();
					IDictionary<string,int> argumentsTop = new Dictionary<string,int>();
					
					/* Check if the #-component was changed. 
					 * if so, nothing to do. Otherwise, create the new inner component instance. */
					ManagerComponentID new_cid;
					if (!c.Library_path.Equals(cid.ClassName))
					{					
		                TypeMapImpl properties = new TypeMapImpl();					
						properties[Constants.ID_FUNCTOR_APP] = acfaRef.Id_functor_app;
						properties[Constants.NODES_KEY] = cid.WorkerNodes;
						properties[Constants.PORT_NAME] = cid.PortName;
						
					 	UnitMappingType[] unit_mapping_inner;
					    new_cid = createInnerComponent(owner_cid, ic, cid, bsPort, frwServices, arguments, argumentsTop, null, out unit_mapping_inner);
	
						string uses_port_name = owner_connid.getUserPortName();
						disconnectInnerComponent(owner_connid, bsPort, frw);
						connectInnerComponent(owner_cid, uses_port_name, new_cid, bsPort);
					}
					else
						new_cid = cid;
					
					setUpParameters(acfaRef.Id_functor_app, arguments);	
					argumentsTop = new Dictionary<string,int>(arguments);
						
					// APPLY THE CONTEXT CHANGE TO THE INNER COMPONENTS !
					createInnerComponentsOf(new List<ManagerComponentID>(), 
					                        (ManagerComponentID) cid,
						                    (ManagerComponentID) new_cid,
						                    bsPort, 
						                    frwServices, 
					                        frw,
						                    arguments, 
						                    argumentsTop, null);
//	
					return new_cid;
	            }
	            catch (Exception e)
	            {
					Console.WriteLine("## Exception: " + e.Message);
					Console.WriteLine("## Inner Exception: " + (e.InnerException == null ? "NULL" : e.InnerException.Message));
					Console.WriteLine("## Trace: " + e.StackTrace);
	                throw e;
	            }
	            finally
	            {
	                Connector.closeConnection();
	            }
			}

			public static void checkParameterInReconfiguration (InnerComponent ic, string parameter_id, out bool is_free_parameter)
			{
				is_free_parameter = false;
				
				IList<SupplyParameter> spList = spdao.list(ic.Id_functor_app);
				foreach (SupplyParameter par0_inner in spList) 
				{
					if (par0_inner is SupplyParameterParameter && par0_inner.Id_parameter.Equals(parameter_id))
					{
						SupplyParameterParameter par0_inner_p = (SupplyParameterParameter) par0_inner;
						if (par0_inner_p.FreeVariable)
							throw new Exception("It is not possible to reconfigure parameter " + parameter_id + " in " + ic);
						else 
							is_free_parameter = true;
					}
				}
			}

			
	        public static void destroyApplicationInstance
				                                       (ManagerComponentID app_cid, 
				                                        gov.cca.ports.BuilderService bsPort, 
				                                        gov.cca.Services frwServices,
			                                            ManagerObject frw)
			{
				Services services = frw.getComponentServices(app_cid);
				IList<ComponentID> cidInnerList = new List<ComponentID>();
				
				Dictionary<string, ConnectionID> inner_conn_list = null;
								
				inner_conn_list = new Dictionary<string, ConnectionID>();					
				fetchConnectionsAsUser(app_cid, inner_conn_list, bsPort, frwServices);
				
				foreach (KeyValuePair<string,ConnectionID> conn_pair in inner_conn_list)
				{
					string usesPortName = conn_pair.Key;
					ConnectionID conn = conn_pair.Value;
					cidInnerList.Add(conn.getProvider());
					
					services.releasePort(usesPortName);
					bsPort.disconnect(conn, 0);
					services.unregisterUsesPort(usesPortName);					
				}
				
				foreach (ComponentID cid_inner in cidInnerList) 
				{
					destroyApplicationInstance((ManagerComponentID) cid_inner, 
					                          bsPort, 
					                          frwServices, 
					                          frw);
				}
				
				IList<ConnectionID> provides_conn_list = new List<ConnectionID>();					
				fetchConnectionsAsProvider(app_cid, provides_conn_list, bsPort, frwServices);
				
				if (provides_conn_list.Count == 0)
				{
					services.removeProvidesPort(Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS);
					services.removeProvidesPort(Constants.INITIALIZE_PORT_NAME);
					services.removeProvidesPort(Constants.RECONFIGURE_PORT_NAME);
					if (app_cid.Kind == Constants.KIND_APPLICATION)
						services.removeProvidesPort(Constants.GO_PORT_NAME);
				}
								
				
			}
			
			
			
	        public static ComponentID createApplicationInstance
													   (string instantiator_string, 
				                                        string session_id_string, 
				                                        gov.cca.ports.BuilderService bsPort, 
				                                        gov.cca.Services frwServices,
			                                            ManagerObject frw)
			{
				return createApplicationInstance(null, instantiator_string, session_id_string,bsPort,frwServices, frw);
			}
			
	        public static ComponentID createApplicationInstance
				                                       (ManagerComponentID curr_app_cid,
														string instantiator_string, 
				                                        string session_id_string, 
				                                        gov.cca.ports.BuilderService bsPort, 
				                                        gov.cca.Services frwServices,
			                                            ManagerObject frw)
	        {	
	            try
	            {
	                Connector.openConnection();
					
					Console.WriteLine("Creating an instance of the application");
						
	                FileInfo file = FileUtil.writeToFile(session_id_string + ".xml", instantiator_string);
	                ComponentFunctorApplicationType instantiator = LoaderApp.DeserializeInstantiator(file.FullName);
	                DGAC.database.AbstractComponentFunctorApplication acfaRef = DGAC.BackEnd.loadACFAFromInstantiator(instantiator);

					DGAC.database.Component c = resolveUnit(acfaRef);	

	                TypeMapImpl properties = new TypeMapImpl();					
					properties[Constants.ID_FUNCTOR_APP] = acfaRef.Id_functor_app;
					properties[Constants.PORT_NAME] = null;

					// CONFIGURE HOW UNITS ARE MAPPED ACCROSS NODES ...
					if (instantiator.node != null && instantiator.node.Length > 0) 
						properties[Constants.NODES_KEY] = instantiator.node; //obsolete
					else if (instantiator.unit_mapping != null && instantiator.unit_mapping.Length > 0) 
						properties[Constants.NODES_KEY] = instantiator.unit_mapping;
					else {
						throw new Exception("DGAC.createApplicationInstance - UNEXPECTED ERROR ...");
					}

					IDictionary<string, int> arguments = new Dictionary<string,int>();
					setUpParameters(acfaRef.Id_functor_app, arguments);	
						
					IDictionary<string, int> argumentsTop = new Dictionary<string,int>(arguments);
										
					properties[Constants.ENCLOSING_ARGUMENTS] = argumentsTop;

					// Check whether the application is changed
					ManagerComponentID app_cid;
					if (curr_app_cid == null || !c.Library_path.Equals(curr_app_cid.ClassName))
	                	app_cid = (ManagerComponentID) bsPort.createInstance("app", c.Library_path, properties);
					else
						app_cid = curr_app_cid;
						
					
					createInnerComponentsOf(new List<ManagerComponentID>(), 
					                        (ManagerComponentID) curr_app_cid,
						                    (ManagerComponentID) app_cid,
						                    bsPort, 
						                    frwServices, 
					                        frw,
						                    arguments, 
											argumentsTop,
											instantiator.unit_mapping);
					
					initializeApplication((ManagerComponentID)app_cid, bsPort, frwServices);					

					return app_cid;
					
	            }
	            catch (Exception e)
	            {
					Console.WriteLine("## Exception: " + e.Message);
					Console.WriteLine("## Inner Exception: " + (e.InnerException == null ? "NULL" : e.InnerException.Message));
					Console.WriteLine("## Trace: " + e.StackTrace);
	                throw e;
	            }
	            finally
	            {
	                Connector.closeConnection();
	            }
	
	        }
				
	        public static void setUpParameters(int id_functor_app, IDictionary<string, int> arguments)
	        {
					
	            SupplyParameterDAO spdao = new SupplyParameterDAO();
	            IList<SupplyParameter> spcList = spdao.list(id_functor_app);
	            foreach (SupplyParameterComponent spc in spcList)
	            {
	                arguments.Add(spc.Id_parameter, spc.Id_functor_app_actual);
	            }
	        }
				
	        public static void createInnerComponentsOf(IList<ManagerComponentID> cid_chain, 
			                                           ManagerComponentID curr_cid, 
				                                       ManagerComponentID cid, 
				                                       gov.cca.ports.BuilderService bsPort, 
				                                       gov.cca.Services frwServices, 
			                                           ManagerObject frw,
				                                       IDictionary<string, int> arguments,
	                            					   IDictionary<string, int> argumentsTop,
													   UnitMappingType[] unit_mapping_enclosing)
			{
				createInnerComponentsOf(cid_chain, curr_cid, cid, new List<int>(), new List<string>(), bsPort, frwServices, frw, arguments, argumentsTop, unit_mapping_enclosing);
			}

			
	        public static void createInnerComponentsOf(IList<ManagerComponentID> cid_chain, 
			                                           ManagerComponentID curr_cid, 
													   ManagerComponentID cid, 
				                                       IList<int> id_abstract_owner,
				                                       IList<string> id_inner_at_owner, 
				                                       gov.cca.ports.BuilderService bsPort, 
				                                       gov.cca.Services frwServices, 
			                                           ManagerObject frw,
				                                       IDictionary<string, int> arguments,
	                            					   IDictionary<string, int> argumentsTop,
													   UnitMappingType[] unit_mapping_enclosing)
			{	
				Console.WriteLine("**********************************");
				Console.WriteLine("BEGIN CREATING INNER COMPONENTS OF " + cid.getInstanceName() + "-" + cid.Id_functor_app);

				frwServices.registerUsesPort(Constants.RECONFIGURE_PORT_NAME, Constants.RECONFIGURE_PORT_TYPE, new TypeMapImpl());
				ConnectionID conn_cs = bsPort.connect(frwServices.getComponentID(), Constants.RECONFIGURE_PORT_NAME, cid, Constants.RECONFIGURE_PORT_NAME);  
				ReconfigurationAdvicePort reconfiguration_advice = (ReconfigurationAdvicePort) frwServices.getPort (Constants.RECONFIGURE_PORT_NAME);

				AbstractComponentFunctorApplication acfa = acfadao.retrieve(cid.Id_functor_app);	
				int id_abstract = acfa.Id_abstract;
					
				IDictionary<string,ManagerComponentID> inner_cids = new Dictionary<string,ManagerComponentID>();
				
				IDictionary<InnerComponent, UnitMappingType[]> icList2 = new Dictionary<InnerComponent,UnitMappingType[]>();
			
				IDictionary<string, ConnectionID> inner_conn_list = new Dictionary<string, ConnectionID>();					
				if  (curr_cid != null)
					fetchConnectionsAsUser(curr_cid, inner_conn_list, bsPort, frwServices);

				IList<InnerComponent> icList = BackEnd.icdao.list(id_abstract);
									
				IDictionary<InnerComponent, bool> ggg = new Dictionary<InnerComponent,bool>();

				foreach (InnerComponent ic in icList) if (!frw.isConnected(cid, ic.Id_inner))
				{
					string portName = ic.Id_inner;

					Console.WriteLine("createInnerComponentsOf: LOOP inner " + portName);
					
					AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(ic.Id_abstract_inner);
					int slice_kind = Constants.kindMapping[acf.Kind];
	                if (slice_kind != Constants.KIND_QUALIFIER)
	                {						
						if (!inner_cids.ContainsKey(portName)) 
						{
							ManagerComponentID inner_cid = null;
							
							// Take the inner component currently bound to the inner component
							ConnectionID curr_inner_connid;
							ManagerComponentID curr_inner_cid;								
							inner_conn_list.TryGetValue(portName, out curr_inner_connid);
							curr_inner_cid = curr_inner_connid != null ? (ManagerComponentID) curr_inner_connid.getProvider() : null;
							
		                    if (ic.IsPublic)
							{
								/* Look for the inner component in the transitively enclosing 
								 * component where it is private.
								 */
								int i = 0;
								foreach (ManagerComponentID cid_owner in cid_chain) 
								{
									UnitMappingType[] unit_mapping_inner;
									// find the inner componetn in the current parent 
									inner_cid = findInnerComponent(cid_owner, cid, ic, id_abstract_owner[i], id_inner_at_owner[i], bsPort, out unit_mapping_inner);
										
									/* if not found, look at the the next parent in
									 * the next iteration. Otherwise, finish the loop.
									 */
									if (inner_cid != null)
									{
										icList2.Add (ic, unit_mapping_inner);
										ggg.Add(ic,true);
										break;
									}
										
									i++;
								}
																		
							} 
							else  /* If the inner component private, create it. */
							{	
								UnitMappingType[] unit_mapping_inner;
								inner_cid = createInnerComponent(cid, ic, curr_inner_cid, bsPort, frwServices, arguments, argumentsTop, unit_mapping_enclosing, out unit_mapping_inner);
								if (inner_cid == null)
									continue;
								icList2.Add (ic, unit_mapping_inner);
							}
							
							if (inner_cid == null) 
							{
								Console.WriteLine("createInnerComponetsOf: public inner component not found ! " + cid.getInstanceName() + "." + portName);
								continue;
							}

							if (inner_cid != curr_inner_cid || curr_cid != cid)
							{
								
								// disconnect the old #-component, if it exists
								if (curr_inner_cid != null)
								{
									disconnectInnerComponent(curr_inner_connid, bsPort, frw);
									if (curr_cid != cid)
									{
										string usesPortName = curr_inner_connid.getUserPortName();
										Services services = frw.getComponentServices(curr_cid);				
										services.unregisterUsesPort(usesPortName);										
									}
								}
								
								// connect to the new #-component
								Console.WriteLine("BEGIN CONNECT " + cid.getInstanceName() + "." + portName + " to " + inner_cid.getInstanceName());
								connectInnerComponent(cid, portName, inner_cid, bsPort);	
								Console.WriteLine("END CONNECT " + cid.getInstanceName() + "." + portName + " to " + inner_cid.getInstanceName());
								
								if (curr_inner_cid != null && curr_cid == cid)
								{
									/* Advice the unchanged container component that the
									 * inner component <usesPortName> has changed */
									string usesPortName = curr_inner_connid.getUserPortName();
									reconfiguration_advice.changePort(usesPortName);
								}
							}
							
							inner_cids.Add(portName, inner_cid);
						}
					}
						
				} 
				else
				{
					Console.WriteLine("createInnerComponentsOf: ALREADY CONNECTED " + cid.getInstanceName() + " / " + ic.Id_inner);
				}

				Console.WriteLine("createInnerComponentsOf: END TRAVERSING INNER COMPONENTS ");
				
				frwServices.releasePort(Constants.RECONFIGURE_PORT_NAME);
				bsPort.disconnect(conn_cs,0);	
				frwServices.unregisterUsesPort(Constants.RECONFIGURE_PORT_NAME);
				
				foreach (KeyValuePair<InnerComponent,UnitMappingType[]> ic_ in icList2)
				{
					Console.WriteLine("createInnerComponentsOf: LOOP " + ic_.Key.Id_inner  + "," + ic_.Value.Length);
					InnerComponent ic = ic_.Key;
					UnitMappingType[] unit_mapping_inner = ic_.Value;

					if (ggg.ContainsKey(ic))
					{
						Console.WriteLine("createInnerComponentsOf: STEP 0 " + ic.Id_inner);
					}
					
					Console.WriteLine("createInnerComponentsOf: STEP 1 " + ic.Parameter_top + "#" + ic.Id_functor_app + "," + cid.Id_functor_app);
					string portName = ic.Id_inner;

					ManagerComponentID inner_cid;
					if (inner_cids.TryGetValue(portName, out inner_cid)) 
					{
						int id_functor_app_inner_actual = inner_cid.Id_functor_app; // ic.Id_functor_app;
						
						IDictionary<string, int> arguments_new;
		                determineArguments(arguments, id_functor_app_inner_actual, out arguments_new);
	
						IList<ManagerComponentID> cid_chain_inner = new List<ManagerComponentID>(cid_chain);					
						cid_chain_inner.Insert(0, cid);

						List<int> id_abstract_owner_inner = new List<int>(id_abstract_owner);
						id_abstract_owner_inner.Insert(0, id_abstract);

						List<string> id_inner_at_owner_inner = new List<string>(id_inner_at_owner);
						id_inner_at_owner_inner.Insert(0, portName);

						ConnectionID curr_inner_connid;
						ManagerComponentID curr_inner_cid;
						inner_conn_list.TryGetValue(portName, out curr_inner_connid);
						curr_inner_cid =  curr_inner_connid != null ? (ManagerComponentID) curr_inner_connid.getProvider() : null;
						
						createInnerComponentsOf(cid_chain_inner,
												curr_inner_cid,
						                        inner_cid,
							                    id_abstract_owner_inner,
							                    id_inner_at_owner_inner,
							                    bsPort,
							                    frwServices,
						                        frw,
							                    arguments_new,
							                    argumentsTop, 
												unit_mapping_inner);
					}
				}
				
				if (curr_cid != null && curr_cid != cid)
				{
					Services services = frw.getComponentServices(curr_cid);
					services.removeProvidesPort(Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS);
					services.removeProvidesPort(Constants.INITIALIZE_PORT_NAME);
					services.removeProvidesPort(Constants.RECONFIGURE_PORT_NAME);
					if (curr_cid.Kind == Constants.KIND_APPLICATION)
						services.removeProvidesPort(Constants.GO_PORT_NAME);
					Console.WriteLine("DESTROY INSTANCE " + curr_cid);
					bsPort.destroyInstance(curr_cid, 0);
				}
									
				Console.WriteLine("END CREATING INNER COMPONENTS OF " + cid.getInstanceName());
				Console.WriteLine("********************************");
			}
	
			public static void connectInnerComponent (ManagerComponentID cid, 
				                                        string uses_port_name,
				                                        ManagerComponentID inner_cid, 
							                            gov.cca.ports.BuilderService bsPort)
			{
				Console.WriteLine("BEGIN CONNECT");
				bsPort.connect(cid, uses_port_name, inner_cid, Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS);
				Console.WriteLine("END CONNECT");
			}

			public static void disconnectInnerComponent (ConnectionID conn_id, 
							                             gov.cca.ports.BuilderService bsPort,
			                                             ManagerObject frw)
			{
				ManagerComponentID cid = (ManagerComponentID) conn_id.getUser();
				string usesPortName = conn_id.getUserPortName();
				
				Services services = frw.getComponentServices(cid);
				services.releasePort(usesPortName);
				
				bsPort.disconnect(conn_id, 0);				
			}

			public static void copy_unit_mapping_to_dictionary (UnitMappingType[] unit_mapping, out IDictionary<string, int[]> unit_mapping_dict, out int count_nodes)
			{
					count_nodes = 0;
					unit_mapping_dict = new Dictionary<string, int[]>();
					foreach (UnitMappingType unit_node in unit_mapping)
					{
						Console.WriteLine("copy_unit_mapping_to_dictionary - adding " + unit_node.unit_id + unit_node.unit_index);
						count_nodes += unit_node.node.Length;
						unit_mapping_dict.Add(unit_node.unit_id + unit_node.unit_index, unit_node.node);
					}
			}

			private static void build_unit_mapping_of_inner (InnerComponent ic, 
															 UnitMappingType[] unit_mapping_enclosing, 
														 out UnitMappingType[] unit_mapping_inner)
			{
				int count_nodes;
				IDictionary<string,int[]> unit_mapping_dict;
				BackEnd.copy_unit_mapping_to_dictionary(unit_mapping_enclosing, out unit_mapping_dict, out count_nodes);

				Console.WriteLine("build_unit_mapping_of_inner -1 - " + ic.Id_abstract_owner + "," + ic.Id_inner);
				IList<Slice> slice_list = BackEnd.sdao.listByInner(ic.Id_abstract_owner, ic.Id_inner);
				

				IDictionary<string,UnitMappingType> unit_mapping_save = new Dictionary<string,UnitMappingType>();

				
				foreach (Slice slice in slice_list)
				{
					int[] nodes;
					Interface i_host = BackEnd.idao.retrieve(ic.Id_abstract_owner, slice.Id_interface, slice.Unit_replica_host);
					Console.WriteLine("build_unit_mapping_of_inner 0 - " + i_host.Id_interface_super_top + i_host.Unit_replica_super_top + "," + ic.Id_abstract_owner + ","+ ic.Id_inner);
					unit_mapping_dict.TryGetValue(i_host.Id_interface_super_top + i_host.Unit_replica_super_top, out nodes);

					UnitMappingType unit_mapping_slice;
					Interface i = BackEnd.idao.retrieve(ic.Id_abstract_inner, slice.Id_interface_slice,slice.Unit_replica);
					Console.WriteLine("build_unit_mapping_of_inner: " + ic.Id_abstract_inner + "," + slice.Id_interface_slice);

					if (unit_mapping_save.TryGetValue(i.Id_interface_super_top + i.Unit_replica_super_top, out unit_mapping_slice))
					{
						int[] nodes_ = new int[unit_mapping_slice.node.Length + nodes.Length];
						unit_mapping_slice.node.CopyTo(nodes_, 0);
						nodes.CopyTo(nodes_, unit_mapping_slice.node.Length);
						unit_mapping_slice.node = nodes_;
						Console.WriteLine("build_unit_mapping_of_inner 1: add unit_id=" + unit_mapping_slice.unit_id + ", unit_index=" + unit_mapping_slice.unit_index + ", total nodes" + nodes_.Length);
					} 
					else 
					{
						unit_mapping_slice = new UnitMappingType();
						unit_mapping_slice.unit_id = i.Id_interface_super_top; //slice.Id_interface_slice;
						unit_mapping_slice.unit_index = i.Unit_replica_super_top; ///slice.Unit_replica;
						unit_mapping_slice.node = nodes;									

						unit_mapping_save.Add(unit_mapping_slice.unit_id + unit_mapping_slice.unit_index, unit_mapping_slice);
						Console.WriteLine("build_unit_mapping_of_inner 2: add unit_id=" + unit_mapping_slice.unit_id + 
										", unit_index=" + unit_mapping_slice.unit_index + 
										", total nodes" + nodes.Length);
					}
				}

				unit_mapping_inner = new UnitMappingType[unit_mapping_save.Count];
				unit_mapping_save.Values.CopyTo(unit_mapping_inner,0);
			}
	
			public static ManagerComponentID createInnerComponent (ManagerComponentID cid, 
				                                                   InnerComponent ic, 
			                                                       ManagerComponentID current_inner_cid, 
							                                       gov.cca.ports.BuilderService bsPort, 
							                                       gov.cca.Services frwServices,
				                                       			   IDictionary<string, int> arguments,
	                            					   			   IDictionary<string, int> argumentsTop,
													   			   UnitMappingType[] unit_mapping_enclosing,
																   out UnitMappingType[] unit_mapping_inner)
			{
				unit_mapping_inner = null;
				build_unit_mapping_of_inner(ic, unit_mapping_enclosing, out unit_mapping_inner);
				Console.WriteLine("createInnerComponent - AFTER CALLING build_unit_mapping_to_inner id_abstract=" + ic.Id_abstract_owner + " inner = " + ic.Id_inner + " -- " + unit_mapping_enclosing.Length + "," + unit_mapping_inner.Length);

				if (unit_mapping_inner.Length == 0)
				{
					Console.WriteLine("createInnerComponent: This inner component does not have slices in the units of the enclosing component.");
					return null;
				}
				 
				int id_functor_app_inner = ic.Id_functor_app;
				if (!ic.Parameter_top.Equals(""))
					arguments.TryGetValue(ic.Parameter_top, out id_functor_app_inner);

				AbstractComponentFunctorApplication acfa_inner = acfadao.retrieve(/*ic.Id_functor_app*/ id_functor_app_inner);	//??? parameter_top ???

				int id_functor_app = generateACFAforContext(acfa_inner.Id_abstract, id_functor_app_inner, arguments, argumentsTop);

				AbstractComponentFunctorApplication acfa = acfadao.retrieve(/*ic.Id_functor_app*/ id_functor_app);	//??? parameter_top ???
					
				DGAC.database.Component c = resolveUnit(acfa, arguments, argumentsTop);	
					
				if (current_inner_cid != null && current_inner_cid.ClassName.Equals(c.Library_path))
				{
					// The chosen #-component is the same.
					return current_inner_cid;
				}
				
				/* generate instantiatior string or modify createInstance ? the instantiator
				 * string passes the abstract component + context, requiring a call to resolveUnit
				 * in the worker.
				 * Suggestion: 
				 * 		1. class_name is the name of the component (c.Library_path);
				 * 		2. context parameters are passed in properties argument through an id_functor_app 
				 *         generated from c, arguments and argumentsTop;
				 * 		3. Pass an array of int property for nodes Constants.NODES_KEY 
				 */			
					
				Console.WriteLine("BEFORE generateACFAForContext " + ic.Id_functor_app);
					foreach (KeyValuePair<string,int> uuuu in arguments)
						Console.WriteLine("createInnerComponent (arguments) KEY=" + uuuu.Key + "; VALUE=" + uuuu.Value); 
					foreach (KeyValuePair<string,int> uuuu in argumentsTop)
						Console.WriteLine("createInnerComponent (arguments TOP) KEY=" + uuuu.Key + "; VALUE=" + uuuu.Value); 
				

				//int[] nodes	= cid.WorkerNodes; // SPMD topology !!! Does not work for MPMD ...
				
				Console.WriteLine("createInnerComponent - id_functor_app="+id_functor_app + ",id_functor_app_inner="+id_functor_app_inner);

				int version = current_inner_cid == null ? 0 : current_inner_cid.Version + 1;
				
				//UnitMappingType[] unit_mapping_inner;

				string inner_instance_name = cid.getInstanceName() + "-" + ic.Id_inner + "#" + version;
				Console.WriteLine("BEFORE START CREATING INNER COMPONENT name=" + inner_instance_name + " !");


				// Instantiate the inner component.
	            TypeMapImpl properties = new TypeMapImpl();					
				properties[Constants.ID_FUNCTOR_APP] = id_functor_app;
				properties[Constants.NODES_KEY] = unit_mapping_inner;
				properties[Constants.PORT_NAME] = ic.Id_inner;
				properties[Constants.ENCLOSING_ARGUMENTS] = arguments;

				Console.WriteLine();
				Console.WriteLine("START CREATING INNER COMPONENT name=" + inner_instance_name + "...");
				foreach (UnitMappingType uuu in unit_mapping_inner)
					foreach (int nnn in uuu.node)
						Console.WriteLine("unit " +  uuu.unit_id + uuu.unit_index  + " at node " + nnn);

				ManagerComponentID inner_cid = (ManagerComponentID) bsPort.createInstance(inner_instance_name, c.Library_path, properties);				
				
				Console.WriteLine("FINISH CREATING INNER COMPONENT name=" + inner_instance_name + "...");
				Console.WriteLine();
			    inner_cid.Version = version;
					
				return inner_cid;
			}
	
	
			public static ManagerComponentID findInnerComponent (ManagerComponentID cid_owner, 
				                                                 ManagerComponentID cid, 
				                                                 InnerComponent ic, 
				                                                 int id_abstract_owner,
				                                                 string id_inner_at_owner, 
				                                       			 gov.cca.ports.BuilderService bsPort,
																 out UnitMappingType[] unit_mapping_inner)
			{
			 unit_mapping_inner = null;

			 InnerComponentExposed ice = icedao.retrieveContainer(id_abstract_owner, id_inner_at_owner, ic.Id_inner);
			 if (ice == null)
			 {
				Console.WriteLine("findInnerComponent (DGAC.cs): " +  ic.Id_inner + " not found in " + id_abstract_owner + "." + id_inner_at_owner);
				return null;
			 }
			 
			 ManagerComponentID cid_inner = null;
			
			 // Get all connections where cid_owner participates, as user and provider.
			 ConnectionID[] conn_list = bsPort.getConnectionIDs(new ComponentID[] {cid_owner});
				
			 // Among them, find the connection wherer it is user and the provider port is ice.Id_inner.
			 foreach (ConnectionID conn_id in conn_list)
			 {
				if (conn_id.getUser() == cid_owner && conn_id.getUserPortName().Equals(ice.Id_inner_rename) ) 
				{
					    cid_inner = (ManagerComponentID) conn_id.getProvider();
						break;
				}
			 }
									
			 if (cid_inner == null)
			 {
				Console.WriteLine("findInnerComponent (DGAC.cs): connection for " +  ice.Id_inner_rename + " not found in " + cid_owner);
				return null;
			 }
			 		
			 TypeMapImpl properties = (TypeMapImpl) bsPort.getComponentProperties(cid_inner);
			 unit_mapping_inner = (UnitMappingType[]) properties[Constants.NODES_KEY];

					
			 return cid_inner;
			}
				
			public static void fetchConnectionsAsUser (ManagerComponentID cid, 
					                                   IDictionary<string, ConnectionID> inner_conn_list, 
						                               gov.cca.ports.BuilderService bsPort, 
						                               gov.cca.Services frwServices)
			{
				ConnectionID[] conn_id_list = bsPort.getConnectionIDs(new ComponentID[] {cid});	
				foreach (ConnectionID conn_id in conn_id_list)
					if (conn_id.getUser().getInstanceName().Equals(cid.getInstanceName()))
						inner_conn_list.Add(conn_id.getUserPortName(), conn_id);
			}
				
			public static void fetchConnectionsAsProvider (ManagerComponentID cid, 
						                                   IList<ConnectionID> provides_conn_list, 
							                               gov.cca.ports.BuilderService bsPort, 
							                               gov.cca.Services frwServices)
			{
				ConnectionID[] conn_id_list = bsPort.getConnectionIDs(new ComponentID[] {cid});	
				foreach (ConnectionID conn_id in conn_id_list)
				{
					if (conn_id.getProvider().getInstanceName().Equals(cid.getInstanceName()))
					{
						string providesPortName = conn_id.getProviderPortName();
						provides_conn_list.Add(conn_id);
					}
				}
			}
			
			#endregion RESOLUTION_AT_MANAGER	
			
    } //BackEnd
		
	public class PortUsageManager 
	{
		private IDictionary<string,int> portFetches = new Dictionary<string, int>();
		private IDictionary<string,int> portReleases = new Dictionary<string,int>();
		
		public bool isFetched(string portname)
		{
			int count = 0;
			return portFetches.TryGetValue(portname, out count) && count > 0;
		}
		
		public bool isReleased(string portname)
		{
			int count = 0;
			return portReleases.TryGetValue(portname, out count) && count > 0;
		}
		
		public void addPortFetch(string portName)
		{				
			int count_fetch = 0;
			if (portFetches.TryGetValue(portName, out count_fetch))
				portFetches.Remove(portName);
			
			int count_release = 0;
			if (portReleases.TryGetValue(portName, out count_release))
				portReleases.Remove(portName);

			if (count_release > 0)
			{
				Console.Error.WriteLine("Port " + portName + " was released (release count=" + count_release + ")");
				throw new CCAExceptionImpl(CCAExceptionType.PortNotInUse);					
			}
							
			portFetches.Add (portName, count_fetch+1);
			
		}
								
		public void addPortRelease(string portName)
		{
			int count_release = 0;
			if (portReleases.TryGetValue(portName, out count_release))
				portReleases.Remove(portName);
			
			if (count_release > 0)
			{
				Console.Error.WriteLine("Port " + portName + " still in use (release count=" + count_release + ")");
				throw new CCAExceptionImpl(CCAExceptionType.UsesPortNotReleased);
			}
			
			portReleases.Add (portName, count_release+1);				
		}
		
		public void resetPort(string portName)
		{
			portReleases.Remove(portName);
			portFetches.Remove(portName);
		}
		
	}


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
                    parsSuper.TryGetValue(spp.Id_argument, out sp_actual);
                    SupplyParameterComponent spc_actual = (SupplyParameterComponent)sp_actual;

                    cname += spp.Id_argument + "=" + buildName(spc_actual.Id_functor_app_actual) + ",";
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
