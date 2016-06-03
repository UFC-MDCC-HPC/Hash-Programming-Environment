

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
using Catalog;
using System.Diagnostics;
using Instantiator;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.Runtime.Serialization;


namespace br.ufc.pargo.hpe.backend
{

    namespace DGAC
    {

        public class BackEnd 
        {
            public static WorkerObject worker_framework = null;            

            public BackEnd()
            {
				Trace.WriteLine("DGAC is up and running.");
            }

			private static string output_str;

			private static IDictionary<string, System.Diagnostics.Process> proc_managers = new Dictionary<string, System.Diagnostics.Process>();

			public static void stopManager()
			{
				stopManager (null);
			}

			public static void stopManager(string session_id)
			{
				System.Diagnostics.Process proc = proc_managers [session_id != null ? session_id : "default"];
				proc.StandardInput.WriteLine ("\x3");
				proc.StandardInput.Flush ();
				proc.WaitForExit();
				Trace.WriteLine("STOP MANAGER");
			}

			public static void startManager()
			{
				startManager (null);
			}

			public static void startManager(string session_id)
			{
				string cmd = "sudo";
				string args = "/usr/bin/mono-service bin/ManagerService.exe " + (session_id != null ? "--session " + session_id : "");

				string userName = "heron";
				string password_ = "narf@jchf9200"; 
				string curDir = "hash-programming-environment";

				System.Security.SecureString password = null;

				if (password_ != null)
				{
					password = new System.Security.SecureString();
					foreach (char c in password_)
						password.AppendChar(c);
					password.MakeReadOnly();
				}

				output_str = "";

				System.Diagnostics.Process proc = new System.Diagnostics.Process();
				proc_managers [session_id != null ? session_id : "default"] = proc;
				proc.EnableRaisingEvents = false;
				proc.StartInfo.CreateNoWindow = true;
				proc.StartInfo.UseShellExecute = false;
				proc.StartInfo.FileName = cmd;
				proc.StartInfo.Arguments = args;
				proc.StartInfo.RedirectStandardError = true;
				proc.StartInfo.RedirectStandardOutput = true;
				proc.StartInfo.RedirectStandardInput = true;
				proc.ErrorDataReceived += new DataReceivedEventHandler(OutputHandler);
				proc.OutputDataReceived += new DataReceivedEventHandler(OutputHandler);
				if (userName != null) proc.StartInfo.UserName = userName;
				if (password != null) proc.StartInfo.Password = password;
				if (curDir != null)
				{
					string homeDir = System.Environment.GetEnvironmentVariable("HOME");
					if (homeDir != null)
					{
						proc.StartInfo.WorkingDirectory = Path.Combine(homeDir, curDir);
					}
					else
					{
						proc.StartInfo.WorkingDirectory = curDir;
					}
				}

				try
				{
					proc.Start();

					proc.BeginErrorReadLine();
					proc.BeginOutputReadLine();

					Trace.WriteLine(userName + " runs " + cmd + args + " on " + curDir);

				}
				catch (System.ComponentModel.Win32Exception w)
				{
					Trace.WriteLine("Message: " + w.Message);
					Trace.WriteLine("ErrorCode: " + w.ErrorCode.ToString());
					Trace.WriteLine("NativeErrorCode: " + w.NativeErrorCode.ToString());
					Trace.WriteLine("StackTrace: " + w.StackTrace);
					Trace.WriteLine("Source: " + w.Source);
					Exception e = w.GetBaseException();
					Trace.WriteLine("Base Exception Message: " + e.Message);

					throw w;
				}
				finally
				{
				}
			}

			private static IDictionary<string, System.Diagnostics.Process> proc_workers = new Dictionary<string, System.Diagnostics.Process>();

			private static void OutputHandler(object sendingProcess,
			                                  DataReceivedEventArgs outLine)
			{
				//This event handler is not called until process is finished.
				//When process is finished it gets called once for each line
				if (!String.IsNullOrEmpty(outLine.Data))
				{
					Trace.WriteLine (outLine.Data);
					output_str += (System.Environment.NewLine + outLine.Data);     
				}
			}

			public static System.Diagnostics.Process startWorkers(string session_id, string userName, string password_, string curDir)
			{
				string cmd = "mpirun";
				string args = "--configfile worker.launch.config.9";

				System.Security.SecureString password = null;

				if (password_ != null)
				{
					password = new System.Security.SecureString();
					foreach (char c in password_)
						password.AppendChar(c);
					password.MakeReadOnly();
				}

				output_str = ""; 

				System.Diagnostics.Process proc = new System.Diagnostics.Process();
				proc_workers [session_id != null ? session_id : "default"] = proc;
				proc.EnableRaisingEvents = false;
				proc.StartInfo.CreateNoWindow = true;
				proc.StartInfo.UseShellExecute = false;
				proc.StartInfo.FileName = cmd;
				proc.StartInfo.Arguments = args;
				proc.StartInfo.RedirectStandardError = true;
				proc.StartInfo.RedirectStandardOutput = true;
				proc.StartInfo.RedirectStandardInput = true;
				proc.ErrorDataReceived += new DataReceivedEventHandler(OutputHandler);
				proc.OutputDataReceived += new DataReceivedEventHandler(OutputHandler);
				if (userName != null) proc.StartInfo.UserName = userName;
				if (password != null) proc.StartInfo.Password = password;
				if (curDir != null)
				{
					string homeDir = System.Environment.GetEnvironmentVariable("HOME");
					if (homeDir != null)
					{
						proc.StartInfo.WorkingDirectory = Path.Combine(homeDir, curDir);
					}
					else
					{
						proc.StartInfo.WorkingDirectory = curDir;
					}
				}

				try
				{
					proc.Start();

					proc.BeginErrorReadLine();
					proc.BeginOutputReadLine();


					Trace.WriteLine(userName + " runs " + cmd + " " + args + " on " + curDir);

				}
				catch (System.ComponentModel.Win32Exception w)
				{
					Trace.WriteLine("Message: " + w.Message);
					Trace.WriteLine("ErrorCode: " + w.ErrorCode.ToString());
					Trace.WriteLine("NativeErrorCode: " + w.NativeErrorCode.ToString());
					Trace.WriteLine("StackTrace: " + w.StackTrace);
					Trace.WriteLine("Source: " + w.Source);
					Exception e = w.GetBaseException();
					Trace.WriteLine("Base Exception Message: " + e.Message);

					throw w;
				}
				finally
				{
				}
				return proc;
			}


			public static void stopWorkers(string session_id)
			{
				System.Diagnostics.Process proc = proc_workers [session_id != null ? session_id : "default"];
				proc.StandardInput.WriteLine ("\x3");
				proc.StandardInput.Flush ();
			    proc.WaitForExit();
				Trace.WriteLine("STOP WORKERS");
			}

			#region FRAMEWORK_INSTANTIATION
			
            public static gov.cca.AbstractFramework getFrameworkInstance()
            {
				Trace.WriteLine ("getFrameworkInstance 1 !!!");
				//TcpChannel channel = new TcpChannel(Constants.MANAGER_PORT/*prop, client_provider*/);
        		//ChannelServices.RegisterChannel(channel);
				
				//RemotingConfiguration.ApplicationName = Constants.MANAGER_SERVICE_NAME;
				ManagerObject obj = new ManagerObject();
                return (gov.cca.AbstractFramework) obj;
            }

			private static gov.cca.AbstractFramework framework_instance = null;
			private static IpcClientChannel ch_save = null;

            public static gov.cca.AbstractFramework getFrameworkInstance(out IpcClientChannel ch)
            {
				Trace.WriteLine ("getFrameworkInstance 2 !!!");

				if (framework_instance == null) {

					IDictionary prop = new Hashtable ();
					prop ["portName"] = Constants.MANAGER_PORT_NAME;

					System.Runtime.Remoting.Channels.BinaryClientFormatterSinkProvider client_provider = new System.Runtime.Remoting.Channels.BinaryClientFormatterSinkProvider ();
				
					ch_save = ch = new IpcClientChannel (prop, client_provider);
					ChannelServices.RegisterChannel (ch, false);
					object[] activateAttribute = { new UrlAttribute ("ipc://" + Constants.MANAGER_PORT_NAME) };
					ManagerObject obj = (ManagerObject)Activator.CreateInstance (typeof(ManagerObject), null, activateAttribute);
					framework_instance = (gov.cca.AbstractFramework)obj;
				}

				ch = ch_save;

				return framework_instance;
            }
						 

            public static gov.cca.AbstractFramework getFrameworkWorkerInstance(string node, int port, int rank)
            {
                WorkerObject wo = null;
		
				string service_name = Constants.WORKER_SERVICE_NAME + "-" + rank + "-";
				string uri_str = "tcp://" + node + ":" + port + "/" + service_name;

				Trace.WriteLine ("URI = " + uri_str + ",  SERVICE NAME = " + service_name);

				// Register the TCP channel.
				//        ChannelServices.RegisterChannel(new TcpChannel(), false);

		        // Create a url attribute object.
		        UrlAttribute attribute = new UrlAttribute(uri_str);
		        object[] activationAttributes = new object[] { attribute };

		        // Register the client for the remote object.
		        //RemotingConfiguration.RegisterActivatedClientType	(typeof(WorkerObject),  uri_str);

				wo = (WorkerObject) Activator.CreateInstance(typeof(WorkerObject), new object[] {}, activationAttributes); 
				//wo = new WorkerObject();
				Trace.WriteLine ("wo is null ? " + wo==null);
				wo.sayHi();

                return wo;
            }

			public static gov.cca.AbstractFramework getFrameworkWorkerInstanceWCF(string node, int port, int rank)
			{
				string service_name = Constants.WORKER_SERVICE_NAME + "-" + rank;
				string uri_str = "http://" + node + ":" + port + "/" + service_name;

				Console.WriteLine ("getFrameworkWorkerInstanceWCF - uri_str = " + uri_str);

				var binding = new BasicHttpBinding ();
				var address = new EndpointAddress (uri_str);
				RemoteWorkerObject wo = new RemoteWorkerObject (binding, address);

				//MyWorkerObjectFactory wo = new MyWorkerObjectFactory (binding, address);

				return wo /*.createWorkerObject()*/;
			}

			//[DataContract]
			//[KnownType(typeof(InitializePortWrapper))]



            public static void releaseManager(IpcClientChannel ch)
            {
                ChannelServices.UnregisterChannel(ch);
            }
			
			#endregion FRAMEWORK_INSTANTIATION

			public static string getSiteName()
			{
				return Constants.SITE_NAME;
			}

			#region DEPLOY

			static IList<LoaderApp.InfoCompile> fetchSharedLibraryCompile (IList<ExternalLibraryType> externalLibrary)
			{

				IList<LoaderApp.InfoCompile> referencesSet = new List<LoaderApp.InfoCompile>();
				if (externalLibrary == null)
					return referencesSet;

				Trace.WriteLine ("fetchSharedLibraryCompile #1");

				foreach (ExternalLibraryType elt in externalLibrary) 
				{
					LoaderApp.InfoCompile info = new LoaderApp.InfoCompile();

					Trace.WriteLine ("fetchSharedLibraryCompile #2");

					IList<string> returnExternalReferences = new List<string>();
					IDictionary<string, ReferenceType> refList = FileUtil.loadExternalReferences();

					Trace.WriteLine ("fetchSharedLibraryCompile #3");

					if (elt.externalDependency != null) 
					{
						foreach (string extRef in elt.externalDependency) 
						{
							ReferenceType pathRef;
							string path;
							if (refList.TryGetValue (extRef, out pathRef))
								path = pathRef.path;
							else 
							{
								path = Constants.UNIT_PACKAGE_PATH + Path.DirectorySeparatorChar + extRef;
								Console.Error.WriteLine ("External reference " + extRef + " not found. Using default " + path + ".");
							}
							returnExternalReferences.Add (path + Path.DirectorySeparatorChar + extRef + ".dll");
						}

					}
					Trace.WriteLine ("fetchSharedLibraryCompile #4");

					info.id = -1;
					info.references = new string[returnExternalReferences.Count];
					returnExternalReferences.CopyTo(info.references,0);
					info.sourceContents = new Tuple<string,string>[1];
					info.moduleName = elt.name.Split('.')[0];
					info.sourceContents[0] = new Tuple<string,string>(info.moduleName, elt.contents);
					info.library_path = info.moduleName;

					Trace.WriteLine ("fetchSharedLibraryCompile #5");
					referencesSet.Add (info);
				}

				Trace.WriteLine ("fetchSharedLibraryCompile #6");

				return referencesSet;
			}
			public static int registerAbstractComponent(ComponentType ct)
			{
				return registerAbstractComponent (ct, null, null, null);
			}

			public static int registerAbstractComponent(ComponentType ct, string userName, string password, string curDir)
			{
				AbstractComponentFunctor cAbs = null;

				int exists = 1;
				LoaderAbstractComponent abstractloader = new LoaderAbstractComponent();
				HashComponent cAbs_ = null;

				IList<ExternalLibraryType> externalLibrary = null;

				string library_path = ct.header.packagePath + "." + ct.header.name;

				abstractloader.componentExists(library_path, out cAbs_);
				if (cAbs_ == null)
				{
					cAbs = (AbstractComponentFunctor)abstractloader.loadComponent(ct, ref externalLibrary);
				}
				else
				{
					cAbs = (AbstractComponentFunctor)cAbs_;
					IList<DGAC.database.Component> cList = cdao.retrieveThatImplements(cAbs.Id_abstract);
					Console.Error.WriteLine("Abstract component " + ct.header.packagePath + "." + ct.header.name + " is already deployed. Updating sources ...");
					abstractloader.updateSources(ct, cAbs);
					exists = 0;

					externalLibrary = new List<ExternalLibraryType>();
					foreach (Object o in ct.componentInfo)
					{
						if (o is ExternalLibraryType)
						{
							if (externalLibrary == null) externalLibrary = new List<ExternalLibraryType>();
							externalLibrary.Add((ExternalLibraryType)o);
						}
					}
				}

				Console.Error.Write("Compiling sources ...");

				IpcClientChannel ch = null;
				ManagerObject manager = (ManagerObject) getFrameworkInstance(out ch);                     

				ICollection<LoaderApp.InfoCompile> sharedLibraryCompile = fetchSharedLibraryCompile(externalLibrary);
				sendToCompile(manager, sharedLibraryCompile, userName, password, curDir, exists);

				ICollection<LoaderApp.InfoCompile> infoCompile = LoaderApp.getReferences_Abstract(cAbs.Id_abstract);
				sendToCompile(manager, infoCompile, userName, password, curDir, exists);
	
				//releaseManager (ch);

				return cAbs != null ? cAbs.Id_abstract : -1;
			}

            public static int registerAbstractComponentTransaction(ComponentType ct, string userName, string password, string curDir)
			{   
				int res = -1;

                try
                {
                    Connector.openConnection();
                    Connector.beginTransaction();
                    
					res = registerAbstractComponent(ct,userName,password,curDir);
                    
	                Connector.commitTransaction(); // if it is ok, commit ...

		    		Console.Error.WriteLine("commited !");
                }
                catch (Exception e)
                {
					File.WriteAllText ("error.txt", e.Message + " --- " + e.StackTrace);
					if (e.InnerException != null)
						File.AppendAllText ("error.txt", e.InnerException.Message + " --- " + e.InnerException.StackTrace );
                    Console.Error.Write("Rolling back transaction... " +  e.Message + " ----- stack:"+  e.StackTrace);
                    Connector.rollBackTransaction();
                    Console.Error.WriteLine("ok");
                    throw e;
                }
                finally
                {
                   // releaseManager(ch);
                    Connector.closeConnection();
                }
				
				return res;
            }
			
			public static void sendToCompile (ManagerObject manager, ICollection<LoaderApp.InfoCompile> infoCompile, string userName, string password, string curDir, int set_public_key)
			{

				    Trace.WriteLine ("sendToCompile " + infoCompile);


                    foreach (LoaderApp.InfoCompile unitToCompile in infoCompile)
                    {
                        int id = unitToCompile.id;
                        string cuid = unitToCompile.cuid;
                        string library_path = unitToCompile.library_path;
					    string moduleName = unitToCompile.moduleName;
						Tuple<string,string>[] sourceContents = unitToCompile.sourceContents;
                        string unitName = unitToCompile.unitId;
						int partition_index = unitToCompile.partition_index;
                        int outputType = unitToCompile.output_type;

                        Console.Error.Write(moduleName + ", ");

                        string publicKey = sendCompileCommandToWorker(library_path,
					                                              	  moduleName,
                                                                      manager,
                                                                      sourceContents,
                                                                      unitToCompile.references,
                                                                      outputType,
                                                                      userName,
                                                                      password,
                                                                      curDir);
					    
					if (id > 0) {
						switch (set_public_key) {
						case 1:
							idao.setPublicKey (id, unitName, publicKey);
							break;
						case 2:
							udao.setPublicKey (cuid, unitName, publicKey);
							break;
						}
					}
						
                    }

			}
			
			public static void updateConfiguration(int id_abstract, byte[] hcl_data)
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

			static public int registerConcreteComponent (ComponentType ct, string userName, string password, string curDir)
			{
				DGAC.database.Component cConc = null;

				int exists = 2;
				LoaderConcreteComponent concreteloader = new LoaderConcreteComponent();
				HashComponent cConc_ = null;

				IList<ExternalLibraryType> externalLibrary = null;

				string library_path = ct.header.packagePath + "." + ct.header.name;

				concreteloader.componentExists(library_path, out cConc_);
				if (cConc_ == null)
				{
					cConc = (DGAC.database.Component)concreteloader.loadComponent(ct, ref externalLibrary);
				}
				else
				{
					Console.Error.WriteLine("Concrete component " + ct.header.packagePath + "." + ct.header.name + " is already deployed. Updating ...");
					cConc = (DGAC.database.Component)cConc_;
					concreteloader.updateSources(ct, cConc);
					exists = 0;

					externalLibrary = new List<ExternalLibraryType>();
					foreach (Object o in ct.componentInfo)
					{
						if (o is ExternalLibraryType)
						{
							if (externalLibrary == null) externalLibrary = new List<ExternalLibraryType>();
							externalLibrary.Add((ExternalLibraryType)o);
						}
					}
				}

				Console.Error.Write("Compiling sources ...");

				IpcClientChannel ch = null;
				ManagerObject manager = (ManagerObject) getFrameworkInstance(out ch);                     

				ICollection<LoaderApp.InfoCompile> sharedLibraryCompile = fetchSharedLibraryCompile(externalLibrary);
				sendToCompile(manager, sharedLibraryCompile, userName, password, curDir, exists);

				ICollection<LoaderApp.InfoCompile> infoCompile = LoaderApp.getReferences_Concrete(cConc.Id_concrete);
				sendToCompile(manager, infoCompile, userName, password, curDir, exists);

			//	releaseManager (ch);

				return cConc != null ? cConc.Id_concrete : -1;
			}
			
			public static int registerConcreteComponent(ComponentType ct)
			{
				return registerConcreteComponent (ct, null, null, null);
			}

			public static int registerConcreteComponentTransaction(ComponentType ct, string userName, string password, string curDir)
			{   
				int res = -1;

                try
                {
                    Connector.openConnection();
                    Connector.beginTransaction();

					res = registerConcreteComponent(ct,userName,password,curDir);

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
                    //releaseManager(ch);
                }

				return res;
            }

            private static string sendCompileCommandToWorker(string library_path, string moduleName, ManagerObject worker, Tuple<string,string>[] sourceContents, string[] refs, int outFile, string userName, string password, String curDir)
            {
                return worker.compileClass(library_path, moduleName, sourceContents, refs, outFile, userName, password, curDir);
            }

			#endregion DEPLOY
			
			#region CATALOG

            public static Catalog.CatalogType readCatalog()
            {
                Connector.openConnection();

                Catalog.CatalogType env = new Catalog.CatalogType();

				env.backend_url = Constants.SITE_URL;
				env.site_name = Constants.SITE_NAME;
				env.component = readAbstractComponentsInCatalog();

                Connector.closeConnection();

                return env;
            }

			static Catalog.ComponentType[] readAbstractComponentsInCatalog ()
			{

                IList<AbstractComponentFunctor> acfList = acfdao.list();

				Catalog.ComponentType[] cs =  new Catalog.ComponentType[acfList.Count];

				int i= 0;
                foreach (AbstractComponentFunctor acf in acfList)
                {
                    Catalog.ComponentType deployed = new Catalog.ComponentType();

					deployed.component_ref = acf.Library_path;
					deployed.kind = acf.Kind;
					deployed.unit = readUnits_catalog(acf);
					deployed.uses_port = readUsesPorts_catalog(acf);
				 	deployed.provides_port = readProvidesPorts_catalog(acf);
					deployed.parameter = readParameters_catalog(acf);
			
					if (acf.Id_functor_app_supertype > 0)
					{
						AbstractComponentFunctorApplication acfaSuper = acfadao.retrieve(acf.Id_functor_app_supertype);
						AbstractComponentFunctor acfSuper = acfdao.retrieve(acfaSuper.Id_abstract);
						deployed.component_ref_super = acfSuper.Library_path;
					}

					cs[i++] = deployed;
                }

				return cs;
			}

			static Catalog.UnitType[] readUnits_catalog (AbstractComponentFunctor acf)
			{				
				IList<Interface> unit_list = BackEnd.idao.list(acf.Id_abstract);
				Catalog.UnitType[] result = new Catalog.UnitType[unit_list.Count];
				int i = 0;
				foreach (Interface unit in unit_list)
				{
					Catalog.UnitType unit_info = new Catalog.UnitType();
					unit_info.unit_ref = unit.Id_interface;
					unit_info.is_parallel = unit.Is_parallel;
					result[i++] = unit_info;
				}
				return result;
			}

			static SliceType[] readSliceType (InnerComponent ic)
			{
				IList<Slice> s_list = BackEnd.sdao.listByInner (ic.Id_abstract_owner, ic.Id_inner);
				Catalog.SliceType[] result = new Catalog.SliceType[s_list.Count];
				int i = 0;
				foreach (Slice s in s_list)
				{
					Catalog.SliceType slice_info = new Catalog.SliceType ();
					slice_info.host_unit = s.Id_interface;
					slice_info.slice_unit = s.Id_interface_slice;
					result [i++] = slice_info;
				}
				return result;
			}

			static Catalog.UsesPortType[] readUsesPorts_catalog (AbstractComponentFunctor acf)
			{
				IList<InnerComponent> ic_list = BackEnd.icdao.list(acf.Id_abstract);
				Catalog.UsesPortType[] result = new Catalog.UsesPortType[ic_list.Count];
				int i = 0;
				foreach (InnerComponent ic in ic_list)
				{
					//if (ic.IsPublic)
					{
						Catalog.UsesPortType inner_info = new Catalog.UsesPortType();
						inner_info.port_ref = ic.Id_inner;
						inner_info.type = readInstantiationType(ic.Id_functor_app);
						inner_info.slice = readSliceType (ic);
						result[i++] = inner_info;
					}
				}
				return result;
			}	
			static Catalog.ProvidesPortType[] readProvidesPorts_catalog (AbstractComponentFunctor acf)
			{
				Catalog.ProvidesPortType[] result = new Catalog.ProvidesPortType[1];
				result[0] = new Catalog.ProvidesPortType();
				result[0].port_ref = "implements";
				return result;
			}

			static Catalog.ParameterType[] readParameters_catalog (AbstractComponentFunctor acf)
			{
				IList<AbstractComponentFunctorParameter> par_list = BackEnd.acfpdao.list(acf.Id_abstract);
				Catalog.ParameterType[] result = new Catalog.ParameterType[par_list.Count];
				int i = 0;
				foreach (AbstractComponentFunctorParameter par in par_list)
				{
					Catalog.ParameterType parameter_info = new Catalog.ParameterType();
					parameter_info.parameter_id = par.Id_parameter;
					parameter_info.variable_id  = par.Id_parameter; //TODO: ...
					parameter_info.bounds_type = readInstantiationType(par.Bounds_of);
					result[i++] = parameter_info;
				}
				return result;
			}

			static Catalog.ComponentFunctorApplicationType readInstantiationType (int bounds_of)
			{
				AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve(bounds_of);				
				return readInstantationType(acfa);
			}	

			static Catalog.ComponentFunctorApplicationType readInstantationType (AbstractComponentFunctorApplication acfa)
			{
				Catalog.ComponentFunctorApplicationType result = new Catalog.ComponentFunctorApplicationType();
				AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(acfa.Id_abstract);
				result.component_ref = acf.Library_path;
				result.argument = readInstantiationTypeParameters(acfa);
				return result;
			}

			static Catalog.ContextArgumentType[] readInstantiationTypeParameters (AbstractComponentFunctorApplication acfa)
			{
				IList<SupplyParameter> sp_list = BackEnd.spdao.list(acfa.Id_functor_app);
				IList<Catalog.ContextArgumentType> result = new List<Catalog.ContextArgumentType>();				
				foreach (SupplyParameter sp in sp_list) 
				{
					Catalog.ContextArgumentType arg = new Catalog.ContextArgumentType();
					arg.parameter_id = sp.Id_parameter;
					if (sp is SupplyParameterComponent)
					{
						SupplyParameterComponent spc = (SupplyParameterComponent) sp;
						arg.Item = (Catalog.ComponentFunctorApplicationType) readInstantiationType(spc.Id_functor_app_actual);
						result.Add(arg);
					}		
					else if (sp is SupplyParameterParameter)
					{
						SupplyParameterParameter spp = (SupplyParameterParameter) sp;						
						if (!spp.FreeVariable)
						{							
							arg.Item = spp.Id_argument;
							result.Add(arg);
						}
					}
				}

				Catalog.ContextArgumentType[] result_array = new Catalog.ContextArgumentType[result.Count];
				result.CopyTo(result_array, 0);
				
				return result_array;
			}
	

			#endregion CATALOG

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
			
            public static String[] runApplication(string instantiatior_string, string session_id_string)
            {			
				return runApplicationNTimes(instantiatior_string, 1, session_id_string);
			}

			private static IDictionary<string, ISession> open_sessions = new Dictionary<string, ISession>();

			public interface ISession 
			{
				string SessionID { get; }
				gov.cca.AbstractFramework Framework { get; }
				gov.cca.Services Services { get; }
			}

			private class Session : ISession
			{
				private string session_id;
				private gov.cca.AbstractFramework framework;
				private gov.cca.Services services;
				public Session(string session_id, gov.cca.AbstractFramework framework, gov.cca.Services services) 
				{
					this.session_id = session_id;
					this.framework = framework;
					this.services = services;
				}
				public string SessionID { get {return session_id; } }
				public gov.cca.AbstractFramework Framework { get {return framework;} }
				public gov.cca.Services Services { get {return services; }}
			}

			public static ISession startSession(string session_id)
			{
				try
				{
					TypeMapImpl properties = new TypeMapImpl();					

					gov.cca.AbstractFramework frw = getFrameworkInstance();
					gov.cca.Services frwServices = frw.getServices(session_id, "Session", properties);

					// Builder Service Port
					frwServices.registerUsesPort(Constants.BUILDER_SERVICE_PORT_NAME, Constants.BUILDER_SERVICE_PORT_TYPE, properties);

					// Go Port
					frwServices.registerUsesPort(Constants.GO_PORT_NAME, Constants.GO_PORT_TYPE, new TypeMapImpl());

					open_sessions.Add(session_id, new Session(session_id, (ManagerObject)frw, frwServices));

					return open_sessions[session_id];
				}
				catch (Exception e)
				{
					Trace.WriteLine("## Exception: " + e.Message);
					Trace.WriteLine("## Inner Exception: " + (e.InnerException == null ? "NULL" : e.InnerException.Message));
					Trace.WriteLine("## Trace: " + e.StackTrace);
					throw e;
				}
			}



			public static string[] getPorts(string session_id, string instance_id)
			{
				gov.cca.Services frwServices = open_sessions[session_id].Services;

				gov.cca.ports.BuilderService bsPort = (gov.cca.ports.BuilderService) frwServices.getPort (Constants.BUILDER_SERVICE_PORT_NAME);
				ComponentID sid = frwServices.getComponentID ();

				string[] uses_ports = bsPort.getUsedPortNames (sid);

				return uses_ports;
			}


			public static void finishSession(string session_id)
			{
				try
				{
					gov.cca.Services frwServices = open_sessions[session_id].Services;
		
					frwServices.unregisterUsesPort(Constants.GO_PORT_NAME);
					frwServices.unregisterUsesPort(Constants.BUILDER_SERVICE_PORT_NAME);

					open_sessions.Remove(session_id);

					Trace.WriteLine ("Finishing");
				}
				catch (Exception e)
				{
					Trace.WriteLine("## Exception: " + e.Message);
					Trace.WriteLine("## Inner Exception: " + (e.InnerException == null ? "NULL" : e.InnerException.Message));
					Trace.WriteLine("## Trace: " + e.StackTrace);
					throw e;
				}
			}

			public static ICollection<string> getSessions()
			{
				return open_sessions.Keys;
			}



			public static String[] runApplicationNTimes(string instantiatior_string, int rounds, string session_id_string)
            {	
                string[] str_output = null;
                try
                {
					// START A NEW SESSION
					Trace.WriteLine("Starting session " + session_id_string);
					ISession session = startSession(session_id_string);
					gov.cca.Services frwServices = session.Services;

					// INSTANTIATE THE APPLICATION
					Trace.WriteLine("Creating an instance of the application");
 					ManagerComponentID app_cid = (ManagerComponentID) createSystemComponentInstance (null, "app", instantiatior_string, session_id_string);

					// CONNECT THE GO PORT OF THE APPLICATION TO THE SESSION DRIVER.
					Trace.WriteLine("Connecting to the GoPort of the application");
					gov.cca.ComponentID host_cid = frwServices.getComponentID();
					gov.cca.ports.BuilderService bsPort = (gov.cca.ports.BuilderService) frwServices.getPort (Constants.BUILDER_SERVICE_PORT_NAME);
					ConnectionID conn_go = bsPort.connect(host_cid, Constants.GO_PORT_NAME, app_cid, Constants.GO_PORT_NAME);
					gov.cca.ports.GoPort go_port = (gov.cca.ports.GoPort) frwServices.getPort (Constants.GO_PORT_NAME);

					// DRIVE THE APPLICATION (call GO !)
					Trace.WriteLine ("Doing " + rounds + " executions of the application.");
					for (int round=0; round < rounds; round++) 
					{
						Trace.WriteLine("ROUND #" + round);	
						go_port.go(); 					
					}

					// DESTROY APPLICATION INSTANCE.
					destroyApplicationInstance(app_cid, bsPort, session_id_string);

					// RELEASE PORTS USED BY THE SESSION.
					frwServices.releasePort(Constants.GO_PORT_NAME);
					frwServices.releasePort(Constants.BUILDER_SERVICE_PORT_NAME);

					// DISCONNECT THE GO PORT
					bsPort.disconnect(conn_go, 0);

					// FINISH THE SESSION.
					finishSession(session_id_string);

					Trace.WriteLine ("Finishing");
					
                }
                catch (Exception e)
                {
					Trace.WriteLine("## Exception: " + e.Message);
					Trace.WriteLine("## Inner Exception: " + (e.InnerException == null ? "NULL" : e.InnerException.Message));
					Trace.WriteLine("## Trace: " + e.StackTrace);
                    throw e;
                }

                return str_output == null ? new String[] { } : str_output;

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
                string id_interface)
            {
				Trace.WriteLine ("takeUnit - BEGIN 1");
                string id_unit = null;
                Interface i2 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveSuper(c.Id_abstract, id_interface);
				Trace.WriteLine ("takeUnit - BEGIN 2 " + (i2==null));
                foreach (Interface i in br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.list(c.Id_abstract))
                {
					Trace.WriteLine ("takeUnit - BEGIN 3 " + i.Id_interface);

					string[] interface_id_super_top_list_2 = Interface.splitIDs (i2.Id_interface_super_top);
					string[] interface_id_super_top_list_1 = Interface.splitIDs (i.Id_interface_super_top);
					bool found = false;
					foreach (string interface_id_super_top_2 in interface_id_super_top_list_2)
					{
						found = false;
						foreach (string interface_id_super_top_1 in interface_id_super_top_list_1)
						{
							Trace.WriteLine ("takeUnit - testing " + interface_id_super_top_1 + "/" + interface_id_super_top_2);
							if (interface_id_super_top_2.Equals (interface_id_super_top_1))
								found = true;
						}
						if (!found)
							break;
					}
					if (found) 
					{
						Trace.WriteLine ("takeUnit - FOUND - " + id_unit);
						id_unit = i.Id_interface;
						break;
					}
                }

                return br.ufc.pargo.hpe.backend.DGAC.BackEnd.udao.retrieve(c.Id_concrete, id_unit);
            }
            
			#endregion RESOLUTION
			
			#region CALCULATE_CLASS_PARAMETERS
			
            public static System.Type[] calculateActualClassParameteres(Interface i, int id_functor_app, IDictionary<string, int> arguments)
            {
				Trace.WriteLine ("ENTER CALCULATE ACTUAL CLASS PARAMETERS = " + id_functor_app + "," + i.Id_interface);

                IList<InterfaceParameter> ipars = BackEnd.ipdao.list(i.Id_abstract,i.Id_interface);
                System.Type[] result = new System.Type[ipars.Count];
				
				Trace.WriteLine ("IPARS.LENGTH = " + ipars.Count);
                foreach (InterfaceParameter ipar in ipars)
                {
					Trace.WriteLine("parameter ----- " + ipar.ParId + "#" + id_functor_app);
					foreach (KeyValuePair<string,int> uuuu in arguments)
						Trace.WriteLine("KEY=" + uuuu.Key + "; VALUE=" + uuuu.Value); 
					
                    int id_functor_app_parameter;
                    string parid = ipar.ParId;
                    if (arguments.TryGetValue(parid, out id_functor_app_parameter) || 
                        arguments.TryGetValue(parid + "#" + id_functor_app, out id_functor_app_parameter))
                    {
						Trace.WriteLine("parameter (dentro do if) ----- " + id_functor_app_parameter);
                        AbstractComponentFunctorApplication acfa_parameter = BackEnd.acfadao.retrieve(id_functor_app_parameter);
                        AbstractComponentFunctor acf_parameter = BackEnd.acfdao.retrieve(acfa_parameter.Id_abstract);
                        Interface iPar = BackEnd.idao.retrieveSuper(acf_parameter.Id_abstract, ipar.Id_unit_parameter);

                        IDictionary<string, int> arguments_new;
                        determineArguments(arguments, id_functor_app_parameter, out arguments_new);
                        
                        System.Type[] parameters = calculateActualClassParameteres(iPar, id_functor_app_parameter, arguments_new);
                        
                        // Build a type from iPar applied to parType.

                        string assembly_string = iPar.Assembly_string;      // where to found the DLL (retrieve from the component).
                        string class_name = iPar.Class_name;  // the name of the class inside the DLL.
                        int class_nargs = iPar.Class_nargs;
                        string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");

						Trace.WriteLine(id_functor_app + "#" + id_functor_app_parameter + "# PAR class_name = "  + class_name);
						Trace.WriteLine(id_functor_app + "#" + id_functor_app_parameter + "# PAR class_nargs = " + class_nargs);
						Trace.WriteLine(id_functor_app + "#" + id_functor_app_parameter + "# PAR strType = " + strType);
						Trace.WriteLine(id_functor_app + "#" + id_functor_app_parameter + "# PAR parameters.Length = " + parameters.Length);

						foreach (System.Type tt in parameters)
						{
							Trace.WriteLine (id_functor_app + "#" + id_functor_app_parameter + "# is null ? " + (tt == null) + " , " + tt);
						}

                        Assembly a = Assembly.Load(assembly_string);
                        System.Type t = a.GetType(strType);
						Trace.WriteLine (id_functor_app + "#" + id_functor_app_parameter + "#" + (t==null));
                        System.Type closedT = parameters.Length > 0 ? t.MakeGenericType(parameters) : t;
						Trace.WriteLine (id_functor_app + "#" + id_functor_app_parameter + "#" + (closedT==null) + " ---- " + ipar.ParOrder + " +++ " + ipar.Id_interface);
						Trace.WriteLine ("closedT=" + closedT);
                        result[ipar.ParOrder] = closedT;

                    }
                }
                return result;
            }

           
            private static void calculateActualParams_(
                IDictionary<string,int> arguments,
                AbstractComponentFunctorApplication acfaRef,
                string id_interface,
                out System.Type[] actualParams)
            {
                IDictionary<string, int> arguments_new;
                determineArguments(arguments, acfaRef.Id_functor_app, out arguments_new);

                Interface i = BackEnd.idao.retrieveSuper(acfaRef.Id_abstract, id_interface);
                actualParams = calculateActualClassParameteres(i, acfaRef.Id_functor_app, arguments_new);
            }

            public static void calculateActualParams(
				IDictionary<string, int> arguments,
                AbstractComponentFunctorApplication acfaRef,
                string id_interface,
                out System.Type[] actualParams)
            {
                calculateActualParams_(arguments, acfaRef, id_interface, out actualParams);
            }
			
            public static void calculateActualParams(
                AbstractComponentFunctorApplication acfaRef,
                string id_interface,
                out System.Type[] actualParams)
            {
                calculateActualParams_(new Dictionary<string, int>(), acfaRef, id_interface, out actualParams);
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
				
				Trace.WriteLine("assembly_string = "  + assembly_string);
				Trace.WriteLine("class_name = "  + class_name);
				Trace.WriteLine("class_nargs = " + class_nargs);
				Trace.WriteLine("strType = " + strType);
				Trace.WriteLine("actualParams.Length = " + actualParams.Length);
				
                Assembly a = Assembly.Load(assembly_string);
                System.Type t = a.GetType(strType);
				
				for (int i=0; i < actualParams.Length; i++)
				{
					System.Type ttt = actualParams[i];
					if (ttt == null) 
					{
					   Trace.WriteLine("PARAM (actualParams): NULL ---" + t);
					   actualParams[i] = fetchTypeConstraint(u,i);					
					}
					else 
					{
					   Trace.WriteLine("PARAM (actualParams): " + ttt.AssemblyQualifiedName);
					}
				}
				
				Trace.WriteLine("END CALCULATE GENERIC CLASS NAME ...1 " + (t==null));
				System.Type closedT = t;
				if (actualParams.Length > 0)
				{
					Trace.WriteLine("END CALCULATE GENERIC CLASS NAME ...1.5 " + t==null);
					closedT = t.MakeGenericType(actualParams);
				}
				Trace.WriteLine("END CALCULATE GENERIC CLASS NAME ...2" + (closedT == null));
                type = closedT.FullName;
				Trace.WriteLine("END CALCULATE GENERIC CLASS NAME ...3");
            }
			
			public static System.Type fetchTypeConstraint(br.ufc.pargo.hpe.backend.DGAC.database.Unit u, int i) 
			{
			    br.ufc.pargo.hpe.backend.DGAC.database.Component c = br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieve(u.Id_concrete);	
				AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(c.Id_abstract);

				InterfaceParameter ip = br.ufc.pargo.hpe.backend.DGAC.BackEnd.ipdao.retrieveByOrder(acf.Id_abstract, u.Id_interface, i);

				SupplyParameterComponent spc = (SupplyParameterComponent) br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.retrieve(ip.ParId, c.Id_functor_app);
				AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(spc.Id_functor_app_actual);
				
				Interface iPar = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveSuper(acfa.Id_abstract, ip.Id_unit_parameter);
			    	
                string assembly_string = iPar.Assembly_string;      // where to found the DLL (retrieve from the component).
                string class_name = iPar.Class_name;  // the name of the class inside the DLL.
                int class_nargs = iPar.Class_nargs;
                string strType = class_name + (class_nargs > 0 ? "`" + class_nargs : "");

			//	Trace.WriteLine("PAR class_name = "  + class_name);
			//	Trace.WriteLine("PAR class_nargs = " + class_nargs);
			//	Trace.WriteLine ("PAR strType = " + strType);
						
                Assembly a = Assembly.Load(assembly_string);
                System.Type t = a.GetType(strType);

                //System.Type closedT = parameters.Length > 0 ? t.MakeGenericType(parameters) : t;

                //result[ipar.ParOrder] = closedT;
				
				
				return t;
	   }
			
            public static void determineArguments(IDictionary<string, int> arguments, int id_functor_app, out IDictionary<string, int> arguments_new)
            {
				Trace.WriteLine ("START determineArguments " + id_functor_app);
				
                arguments_new = new Dictionary<string, int>(); ;

                foreach (KeyValuePair<string, int> parameter in arguments)
                {
					Trace.WriteLine("traversing arguments : " + parameter.Key);
                    if (parameter.Key.Contains("#"))
                    {
                        arguments_new.Add(parameter);
						Trace.WriteLine("adding parameter key=" + parameter.Key + ", value="+  parameter.Value);
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
						Trace.WriteLine("TESTING " + spp.Id_argument + " : " + achou + " , " + id_functor_app_actual);
                        if (achou)
                        {
                            arguments_new.Add(spp.Id_parameter, id_functor_app_actual);
						    Trace.WriteLine("adding parameter (determineArguments) 1 key=" + spp.Id_parameter + "; value=" + id_functor_app_actual);
                        } 
						
                    }
                    else if (sp is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                        arguments_new.Add(spc.Id_parameter, spc.Id_functor_app_actual);

						Trace.WriteLine("adding parameter (determineArguments) 2 key=" + spc.Id_parameter + "; value="+ spc.Id_functor_app_actual);
						//AbstractComponentFunctorApplication rrrr = BackEnd.acfadao.retrieve (spc.Id_functor_app_actual);
						//Trace.WriteLine("adding parameter (determineArguments) 2 id_abstract=" + rrrr.Id_abstract);


						traverseArguments(spc.Id_functor_app_actual, spc.Id_functor_app_actual, arguments, arguments_new);
                    }
                }
				Trace.WriteLine ("END determineArguments " + id_functor_app);
                foreach (KeyValuePair<string, int> parameter in arguments_new)
                {
					Trace.WriteLine("END determineArguments arguments_new: key=" + parameter.Key + "; value=" + parameter.Value);
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
//					Trace.WriteLine("traversing top arguments : key=" + parameter.Key + "; value=" + parameter.Value);
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
							Trace.WriteLine("adding parameter (traverseParameters) 3 key=" + key + "; value="+ id_functor_app_actual + " -- " + achou + " --- " + spp.Id_argument);
						}
                    }
                    else if (sp is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spc = (SupplyParameterComponent)sp;
					//	Trace.WriteLine("traverseArguments - recursive - " + spc.Id_parameter + "," + spc.Id_functor_app + "," + spc.Id_functor_app_actual);
						string key = spc.Id_parameter + "#" + spc.Id_functor_app;
						if (!arguments.ContainsKey(key)) {
							arguments.Add(key, spc.Id_functor_app_actual);
							Trace.WriteLine("adding parameter (traverseParameters) 4 key=" + key + "; value="+ spc.Id_functor_app_actual);
						}
                        traverseArguments(spc.Id_functor_app_actual, spc.Id_functor_app_actual, argumentsTop, arguments);
                    } 
                }


            }

	  #endregion CALCULATE_CLASS_PARAMETERS
			
		#region CREATE_ACFA
		
		public static Instantiator.ComponentFunctorApplicationType saveACFAToInstantiator(AbstractComponentFunctorApplication instantiator)
		{
				Connector.openConnection ();

				AbstractComponentFunctor acf = acfdao.retrieve (instantiator.Id_abstract);

				Instantiator.ComponentFunctorApplicationType contextual_type = new Instantiator.ComponentFunctorApplicationType ();
				contextual_type.component_ref = acf.Library_path;

				IList<SupplyParameter> sp_list = spdao.list (instantiator.Id_functor_app);
				contextual_type.argument = new Instantiator.ContextArgumentType[sp_list.Count];

				int i = 0;
				foreach (SupplyParameter sp in sp_list) 
				{
					string parameter_id = sp.Id_parameter;
					SupplyParameterComponent spc = (SupplyParameterComponent)sp;

					Instantiator.ContextArgumentType argument_type = new Instantiator.ContextArgumentType ();
					argument_type.parameter_id = parameter_id;

					AbstractComponentFunctorApplication instantiator_argument = acfadao.retrieve(spc.Id_functor_app_actual);
					Instantiator.ComponentFunctorApplicationType contextual_type_argument = saveACFAToInstantiator (instantiator_argument);

					argument_type.Item = contextual_type_argument;

					contextual_type.argument [i++] = argument_type;
				}

				Connector.closeConnection ();
				
				return contextual_type;
		}
				
		public static AbstractComponentFunctorApplication loadACFAFromInstantiator(Instantiator.ComponentFunctorApplicationType instantiator)
            {
                AbstractComponentFunctorApplication aAppNew = null;

                try
                {
                    Connector.openConnection();

                    AbstractComponentFunctor acf = BackEnd.acfdao.retrieve_libraryPath(instantiator.component_ref);

                    aAppNew = new AbstractComponentFunctorApplication();
                    aAppNew.Id_functor_app = Connector.nextKey("id_functor_app", "abstractcomponentfunctorapplication");
                    aAppNew.Id_abstract = acf.Id_abstract;
					DGAC.BackEnd.acfadao.insert(aAppNew, instantiator.GetHashCode());

                    if (instantiator.argument != null)
                        foreach (Instantiator.ContextArgumentType ctx in instantiator.argument)
                        {
							AbstractComponentFunctorApplication acfa_par = loadACFAFromInstantiator((Instantiator.ComponentFunctorApplicationType) ctx.Item);

                            SupplyParameterComponent par = new SupplyParameterComponent();
							par.Id_abstract = aAppNew.Id_abstract;
                            par.Id_functor_app = aAppNew.Id_functor_app;
                            par.Id_parameter = ctx.parameter_id;
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
				

				public static int generateACFAforContext (int id_abstract,
				                                      int id_functor_app, 
				                                      IDictionary<string, int> arguments, 
				                                      IDictionary<string, int> argumentsTop,
			                                          int facet_index)
			{
			   /* TODO: ESSA FUNÇÃO PRECISA SER MELHORADA PARA CASAR NUMEROS DE ARGUMENTOS DIFERENTES ENTRE  O TIPO DO 
				        COMPONENTE retornado pela resolução e o tipo do componente aninhado, conforme as regras do HTS.
				        DO jeito que está, ambos tem que ter os mesmos argumentos */
					

				AbstractComponentFunctorApplication acfa = new AbstractComponentFunctorApplication(); 
					
				//acfa.Id_functor_app = Connector.nextKey("id_functor_app", "abstractcomponentfunctorapplication");				
				acfa.Id_abstract = id_abstract;
				acfadao.insert(acfa, facet_index);
				
				IList<SupplyParameter> spList = spdao.list(id_functor_app);

				Trace.WriteLine ("generateACFAContext -- id_functor_app_inner=" + id_functor_app + " / spList.Count=" + spList.Count);
					
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
//							|| arguments.TryGetValue(spp.Id_parameter + "#" + id_functor_app, out id_functor_app_actual))
						{
							spc_new.Id_functor_app_actual = id_functor_app_actual;
						}
						else
						{
							Trace.WriteLine("generateACFAforContext (DGAC.cs): Free parameter ? " + spp.Id_argument + "#" + spp.Id_functor_app);		
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
					
			private static void initializeComponent(ManagerComponentID cid, 
				                                     gov.cca.ports.BuilderService bsPort, 
				                                     gov.cca.Services frwServices)
			{
				if (!(cid is ManagerIgnoredComponentID)) 
				{
					onInitializeComponent (cid, bsPort, frwServices);
					afterInitializeComponent (cid, bsPort, frwServices);
				}
			}
				
			private static void onInitializeComponent(ManagerComponentID cid, 
				                                     gov.cca.ports.BuilderService bsPort, 
				                                     gov.cca.Services frwServices)
			{
				Dictionary<string,ConnectionID> inner_conn_list = new Dictionary<string, ConnectionID> ();

				fetchConnectionsAsUser(cid, inner_conn_list, bsPort);
								
				foreach (KeyValuePair<string, ConnectionID> inner in inner_conn_list /*InnerComponent ic in icList*/)				
				{					
					ComponentID inner_cid = inner.Value.getProvider();	
					if (!(inner_cid is ManagerIgnoredComponentID))
					{
						if (!initialized.ContainsKey(inner_cid))
						{
							onInitializeComponent((ManagerComponentID)inner_cid, bsPort, frwServices);	
							initialized.Add(inner_cid,true);
						}
					}
					else 
						Trace.WriteLine("onInitializeComponent: " + inner_cid.getInstanceName());
				}
					
				Trace.WriteLine("onInitializeComponent - START - Connecting to the Initialize port - " + cid.InstanceName);
				frwServices.registerUsesPort(Constants.INITIALIZE_PORT_NAME, Constants.INITIALIZE_PORT_TYPE, new TypeMapImpl());
				ConnectionID conn_cs = bsPort.connect(frwServices.getComponentID(), Constants.INITIALIZE_PORT_NAME, cid, Constants.INITIALIZE_PORT_NAME);            
				InitializePort initialize_port = (InitializePort) frwServices.getPort (Constants.INITIALIZE_PORT_NAME);
				Trace.WriteLine("onInitializeComponent - END - Connecting to the Initialize port - " + cid.InstanceName);
					

				initialize_port.on_initialize(); 
				
				Trace.WriteLine("AFTER RUNNING on_initialize" + cid);
				//initialized.Add(cid,true);
					
				frwServices.releasePort(Constants.INITIALIZE_PORT_NAME);
				bsPort.disconnect(conn_cs,0);	
				frwServices.unregisterUsesPort(Constants.INITIALIZE_PORT_NAME);
					
			}
				
			private static void afterInitializeComponent(ManagerComponentID cid, 
				                                     gov.cca.ports.BuilderService bsPort, 
				                                     gov.cca.Services frwServices)
			{
									
				Trace.WriteLine("afterInitializeComponent - START - Connecting to the Initialize port - " + cid.InstanceName);
				frwServices.registerUsesPort(Constants.INITIALIZE_PORT_NAME, Constants.INITIALIZE_PORT_TYPE, new TypeMapImpl());
				ConnectionID conn_cs = bsPort.connect(frwServices.getComponentID(), Constants.INITIALIZE_PORT_NAME, cid, Constants.INITIALIZE_PORT_NAME);            
				InitializePort initialize_port = (InitializePort) frwServices.getPort (Constants.INITIALIZE_PORT_NAME);
				Trace.WriteLine("afterInitializeComponent - END - Connecting to the Initialize port - "+ cid.InstanceName);
					
				//after_initialized.Add(cid,true);
				initialize_port.after_initialize();

				Trace.WriteLine("AFTER RUNNING after_initialize" + cid);

				frwServices.releasePort(Constants.INITIALIZE_PORT_NAME);
				bsPort.disconnect(conn_cs,0);	
				frwServices.unregisterUsesPort(Constants.INITIALIZE_PORT_NAME);
					
				Dictionary<string,ConnectionID> inner_conn_list = new Dictionary<string, ConnectionID>();		
				fetchConnectionsAsUser(cid, inner_conn_list, bsPort);
				
				foreach (KeyValuePair<string, ConnectionID> inner in inner_conn_list /*InnerComponent ic in icList*/)				
				{					
					Trace.WriteLine ("AFTER INIT - CONNECTION " + inner.Key + ", " + inner.Value.ToString());

					ComponentID inner_cid = inner.Value.getProvider();	
					if (!(inner_cid is ManagerIgnoredComponentID))
					{											
						if (!after_initialized.ContainsKey(inner_cid))
						{
							after_initialized.Add(inner_cid,true);
							afterInitializeComponent((ManagerComponentID)inner_cid, bsPort, frwServices);	
						}
					}			
					else 
						Trace.WriteLine("afterInitializeComponent: " + inner_cid.getInstanceName());
				}
					
			}
				
			#endregion INITIALIZE_APPLICATION			
								
			#region RESOLUTION_AT_MANAGER
			
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

			
	        public static void destroyApplicationInstance (ManagerComponentID app_cid, 
				                                           gov.cca.ports.BuilderService bsPort, 
			                                               string session_id)
			{
				Trace.WriteLine (" ----- BEGIN DESTROY " + app_cid.getInstanceName());

				gov.cca.Services frwServices = open_sessions[session_id].Services;
				ManagerObject frw = (ManagerObject) open_sessions[session_id].Framework;

				Services services = frw.getComponentServices(app_cid);
				IList<ComponentID> cidInnerList = new List<ComponentID>();
				
				Dictionary<string, ConnectionID> inner_conn_list = null;
								
				inner_conn_list = new Dictionary<string, ConnectionID>();					
				fetchConnectionsAsUser(app_cid, inner_conn_list, bsPort);

				foreach (KeyValuePair<string,ConnectionID> conn_pair in inner_conn_list)
				{
					string usesPortName = conn_pair.Key;
					ConnectionID conn = conn_pair.Value;

					ComponentID cid_provider = conn.getProvider ();
					cidInnerList.Add(cid_provider);
					
					Trace.WriteLine (" ... BEGIN DESTROY uses ports " + usesPortName);

					services.releasePort(usesPortName);
					bsPort.disconnect(conn, 0);
					services.unregisterUsesPort(usesPortName);					

					Trace.WriteLine (" ... END DESTROY uses ports " + usesPortName);
				}


				foreach (ComponentID cid_inner in cidInnerList) 
				{
					Trace.WriteLine ("WILL DESTROY " + cid_inner.getInstanceName () + " of " + app_cid.getInstanceName ());
					if (frw.getComponentServices((ManagerComponentID)cid_inner) != null)
						destroyApplicationInstance((ManagerComponentID) cid_inner, bsPort, session_id);
					// else
					//  the component was destroyed before ... 
				}

				IList<ConnectionID> provides_conn_list = new List<ConnectionID>();					
				fetchConnectionsAsProvider(app_cid, provides_conn_list, bsPort);

				if (provides_conn_list.Count == 0)
				{
					Trace.WriteLine (" ... BEGIN DESTROY provides ports ");
					services.removeProvidesPort(Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS);
					services.removeProvidesPort(Constants.INITIALIZE_PORT_NAME);
					services.removeProvidesPort(Constants.RECONFIGURE_PORT_NAME);
					if (app_cid.Kind == Constants.KIND_APPLICATION)
						services.removeProvidesPort(Constants.GO_PORT_NAME);
					Trace.WriteLine (" ... END DESTROY provides ports ");
					bsPort.destroyInstance (app_cid, 0);
					Trace.WriteLine (" ... DESTROYED instance: " + app_cid.getInstanceName());

				}
							
				Trace.WriteLine (" ****** END DESTROY " + app_cid.getInstanceName() + ", provides_conn_list.Count=" + provides_conn_list.Count);
				
			}
			
		
	        public static ComponentID createApplicationInstance
				(string instance_name, string instantiator_string, string session_id_string)
			{
				return createSystemComponentInstance(null, instance_name, instantiator_string, session_id_string);
			}

	        public static ComponentID createSystemComponentInstance
				                                       (ManagerComponentID curr_app_cid,
				 										string instance_name,
														string instantiator_string, 
				                                        string session_id_string)
	        {	
	            try
	            {
					ISession session = open_sessions[session_id_string];
					gov.cca.Services frwServices = session.Services;

					gov.cca.ports.BuilderService bsPort = (gov.cca.ports.BuilderService) frwServices.getPort (Constants.BUILDER_SERVICE_PORT_NAME);

					Connector.openConnection();
					
					Trace.WriteLine("Creating an instance of the application");
						
	                FileInfo file = FileUtil.writeToFile(session_id_string + ".xml", instantiator_string);
					Instantiator.InstanceType instantiator = LoaderApp.DeserializeInstantiator(file.FullName); 
	                DGAC.database.AbstractComponentFunctorApplication acfaRef = DGAC.BackEnd.loadACFAFromInstantiator(instantiator.contextual_type);
					DGAC.database.AbstractComponentFunctor acfRef = DGAC.BackEnd.acfdao.retrieve(acfaRef.Id_abstract);
					DGAC.database.Component c = resolveUnit(acfaRef);	
			
	                TypeMapImpl properties = new TypeMapImpl();					
					properties[Constants.ID_FUNCTOR_APP] = acfaRef.Id_functor_app;
					properties[Constants.PORT_NAME] = null;

					if (instantiator.unit_mapping != null && instantiator.unit_mapping.Length > 0) 
						properties[Constants.NODES_KEY] = instantiator.unit_mapping;
					else 
						throw new Exception("DGAC.createApplicationInstance - UNEXPECTED ERROR ...");

					Trace.WriteLine("create component instance 1");

					Tuple<int, Tuple<int,string>[]> facet_info = new Tuple<int,Tuple<int,string>[]>(instantiator.facet_instance, new Tuple<int, string>[instantiator.facet_address.Length]);

					IList<string> binding_sequentials = new List<string>();
					//calculate_binding_sequentials(acfaRef.Id_abstract, binding_sequentials);

				// ESTAVA COMENTADO *******************************************************
					string[] binding_access_address = null;
					int[] binding_access_port = null;
					int[] facet_of_instance = null;

					if (instantiator.facet_address != null)
					{
						// read facet information, if it exists.
						binding_access_address = new string[instantiator.facet_address.Length];
						binding_access_port = new int[instantiator.facet_address.Length];
						facet_of_instance = new int[instantiator.facet_address.Length];

						foreach (FacetAddressType fa in instantiator.facet_address)
						{
							if (fa.facet_instance < instantiator.facet_address.Length)
							{
								binding_access_address[fa.facet_instance] = fa.address;
								binding_access_port[fa.facet_instance] = fa.port;
								facet_of_instance[fa.facet_instance] = fa.facet;

								facet_info.Item2[fa.facet_instance] = new Tuple<int, string>(fa.facet, fa.address + ":" + fa.port);
								Console.WriteLine("FACET_INFO: " + fa.facet_instance + " / " + fa.facet + " / " + fa.address + " / " + fa.port);
							}
							else
							{
								throw new Exception("ERROR - Wrong facet configuration #1.");
							}
						}
					}
				 // ***************************************************

					int this_facet = facet_of_instance[instantiator.facet_instance];

					properties[Constants.FACET_INSTANCE] = instantiator.facet_instance;
					properties[Constants.FACET] = this_facet;

					Trace.WriteLine("create component instance 2");

					IDictionary<string, int> arguments = new Dictionary<string,int>();
					setUpParameters(acfaRef.Id_functor_app, arguments);	
						
					IDictionary<string, int> argumentsTop = new Dictionary<string,int>(arguments);
										
					properties[Constants.ENCLOSING_ARGUMENTS] = argumentsTop;

					// ESTAVA COMENTADO *******************************************************
					if (binding_access_address != null && binding_access_port != null && binding_access_port.Length == binding_access_address.Length) 
					{
						// IT IS SUPPOSED THIS IS A CONNECTOR, PROBABLY WITH INTERNAL BINDINGS.
						properties[Constants.FACET_IP_ADDRESS] = binding_access_address.Clone();
						properties[Constants.FACET_PORT] = binding_access_port.Clone();
					}
					else if (binding_access_address != null || binding_access_port != null)
						throw new Exception ("Invalid facet addressing");

					properties[Constants.FACET_TOPOLOGY] = facet_of_instance.Clone();
					// *******************************************************

					// Check whether the application is changed
					ManagerComponentID app_cid;
					if (curr_app_cid == null || !c.Library_path.Equals(curr_app_cid.ClassName))
						app_cid = (ManagerComponentID) bsPort.createInstance(instance_name, c.Library_path, properties);
					else
						app_cid = curr_app_cid;						

					Trace.WriteLine("createDelayedInstantiationTriggersOfSolutionComponents - CREATE THREADS ");
					// Create the threads of delayed instantiation of solution components and bindings. 
					thread_create_component =
							createDelayedInstantiationTriggersOfSolutionComponents
						                                 (session_id_string, 
								                          new List<ManagerComponentID>(), 
								                          (ManagerComponentID) curr_app_cid,
									                      (ManagerComponentID) app_cid,
									                      arguments, 
														  argumentsTop,
							                              instantiator.unit_mapping, 
							                              facet_info,
														  binding_sequentials
						                                 );
					
					Trace.WriteLine("createDelayedInstantiationTriggersOfSolutionComponents - EXECUTE THREADS ");


					foreach (Thread t in thread_create_component.Values)
					{
						t.Start();
						t.Join();
					}
					
					Trace.WriteLine("createDelayedInstantiationTriggersOfSolutionComponents - FINISH THREADS ");

					return app_cid;
	            }
	            catch (Exception e)
	            {
					Trace.WriteLine("## Exception: " + e.Message);
					Trace.WriteLine("## Inner Exception: " + (e.InnerException == null ? "NULL" : e.InnerException.Message));
					Trace.WriteLine("## Trace: " + e.StackTrace);
	                throw e;
	            }
	            finally
	            {
	                Connector.closeConnection();
	            }	
	        }
							
			private static IDictionary<string,Thread> thread_create_component = null;

			// Instantiate a the solution component required ...
			public static void instantiateSolutionComponentOrBinding(string cRef, int facet_instance, Tuple<int,string>[] facet_address_list)
			{
				thread_create_component [cRef].Start (new Tuple<int,Tuple<int,string>[]> (facet_instance, facet_address_list));
				thread_create_component [cRef].Join ();
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
				

			public static void createInnerComponentsOf(string session_id_string,
													   IList<ManagerComponentID> cid_chain, 
			                                           ManagerComponentID curr_cid, 
				                                       ManagerComponentID cid,
				                                       IDictionary<string, int> arguments,
	                            					   IDictionary<string, int> argumentsTop,
			                                           Instantiator.UnitMappingType[] unit_mapping_enclosing,
			                                           //string[] binding_access_address,
			                                           //int[] binding_access_port, 
													   int facet_instance,
													   int facet,
													   int[] facet_of_instance,
													   Tuple<int, Tuple<int,string>[]> facet_info,
													   IList<string> binding_sequentials)
			{
				createInnerComponentsOf(session_id_string, 
					                    cid_chain, 
					                    curr_cid, 
					                    cid, 
					                    new List<int>(), 
					                    new List<string>(), 
					                    arguments, 
					                    argumentsTop, 
					                    unit_mapping_enclosing,
				                        //binding_access_address,
				                        //binding_access_port,
				                        facet_instance, 
					                    facet, 
					                    facet_of_instance,
				                        facet_info,
										binding_sequentials);
			}


	/*		static void translate_facet_address (ComponentID cid, InnerComponent ic, string[] binding_access_address, int[] binding_access_port, ref string[] binding_access_address_inner, ref int[] binding_access_port_inner)
			{
				IDictionary<int,string> binding_access_address_inner_dict = new Dictionary<int,string> ();
				IDictionary<int,int> binding_access_port_inner_dict = new Dictionary<int,int> ();

				IList<Slice> sListInner = BackEnd.sdao.listByInner (ic.Id_abstract_owner, ic.Id_inner);
				foreach (Slice sInner in sListInner) 
				{
					Interface iOwner = BackEnd.idao.retrieve (ic.Id_abstract_owner, sInner.Id_interface);
					int facet_owner = iOwner.Facet;
					Interface iInner = BackEnd.idao.retrieve (ic.Id_abstract_inner, sInner.Id_interface_slice);
					int facet_inner = iInner.Facet < 0 ? iOwner.Facet : iInner.Facet ;
				
					Trace.WriteLine ("--- FACET " + ic.Id_abstract_inner + "." + facet_inner + " of inner " + ic.Id_inner + " -> FACET " + facet_owner + " of owner " + cid.getInstanceName());
					binding_access_address_inner_dict [facet_inner] = binding_access_address[facet_owner];
					binding_access_port_inner_dict [facet_inner] = binding_access_port[facet_owner];
					Trace.WriteLine ("+++ FACET " + ic.Id_abstract_inner + "." + facet_inner + " of inner " + ic.Id_inner + " -> FACET " + facet_owner + " of owner " + cid.getInstanceName());
				}

				binding_access_address_inner = new string[binding_access_address_inner_dict.Count];
				binding_access_port_inner = new int[binding_access_port_inner_dict.Count];
				foreach (KeyValuePair<int,string> pair in binding_access_address_inner_dict) 
					binding_access_address_inner [pair.Key] = pair.Value;
				foreach (KeyValuePair<int,int> pair in binding_access_port_inner_dict) 
					binding_access_port_inner [pair.Key] = pair.Value;
			}
*/

	        public static void createInnerComponentsOf(string session_id_string,
			                                           IList<ManagerComponentID> cid_chain, 
			                                           ManagerComponentID curr_cid, 
													   ManagerComponentID cid, 
				                                       IList<int> id_abstract_owner,
				                                       IList<string> id_inner_at_owner,
				                                       IDictionary<string, int> arguments,
	                            					   IDictionary<string, int> argumentsTop,
			                                           Instantiator.UnitMappingType[] unit_mapping_enclosing,
												       int facet_instance, 
													   int facet,
												       int[] facet_topology,
				                                       Tuple<int, Tuple<int,string>[]> facet_info,
													   IList<string> binding_sequentials)
			{	
				Trace.WriteLine("**********************************" + (cid==null));
				Trace.WriteLine("BEGIN CREATING INNER COMPONENTS OF " + cid.getInstanceName() + "-" + cid.Id_functor_app);

				// TAKE SESSION CONTEXT.
				ISession session = open_sessions [session_id_string];
				ManagerObject frw = (ManagerObject) session.Framework;
				gov.cca.Services frwServices = session.Services;

				gov.cca.ports.BuilderService bsPort = (gov.cca.ports.BuilderService) frwServices.getPort (Constants.BUILDER_SERVICE_PORT_NAME);

				AbstractComponentFunctorApplication acfa = acfadao.retrieve(cid.Id_functor_app);	
				int id_abstract = acfa.Id_abstract;
					
				IDictionary<string,ManagerComponentID> inner_cids = new Dictionary<string,ManagerComponentID>();
				
				IDictionary<InnerComponent, Instantiator.UnitMappingType[]> icList2 = new Dictionary<InnerComponent,Instantiator.UnitMappingType[]>();
				IDictionary<InnerComponent,Tuple<int,int,int[]>> icFacetConfig = new Dictionary<InnerComponent, Tuple<int, int, int[]>> ();
			
				IDictionary<string, ConnectionID> inner_conn_list = new Dictionary<string, ConnectionID>();					
				if  (curr_cid != null)
					fetchConnectionsAsUser(curr_cid, inner_conn_list, bsPort);

				IList<InnerComponent> icList = BackEnd.icdao.list(id_abstract);
									
				Tuple<int,string>[] facet_address = facet_info.Item2;

				foreach (InnerComponent ic in icList) if (!frw.isConnected(cid, ic.Id_inner))
				{
					string portName = ic.Id_inner;

					Trace.WriteLine("createInnerComponentsOf of " + cid.getInstanceName() + ": LOOP inner " + portName);
					
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
							
							if (ic.IsPublic && slice_kind != Constants.KIND_BINDING) 
							{
								Trace.WriteLine ("createInnerComponentsOf - ENTERING BINDING --- instance_name=" + cid.getInstanceName () + ", id_inner=" + ic.Id_inner);
								/* If the inner component is not a binding, 
							     * look for the inner component in the transitively enclosing component where it is private.
							     * Otherwise, the binding is always instantiated at the system level.
						         */
								int i = 0;
								foreach (ManagerComponentID cid_owner in cid_chain) 
								{
									Instantiator.UnitMappingType[] unit_mapping_inner;

									// find the inner componetn in the current parent 

									int inner_facet = -1;
									int inner_facet_instance = -1;
									int[] inner_facet_topology = null;
									inner_cid = findInnerComponentInTheHostComponent (cid_owner, cid, ic, id_abstract_owner [i], id_inner_at_owner [i], bsPort, out unit_mapping_inner, ref inner_facet, ref inner_facet_instance, ref facet_topology);

									Trace.WriteLine ((inner_cid == null ? "inner_cid is null !  " : "inner_cid found !  ") + cid_owner.InstanceName + " / " + portName);

									/* if not found, look at the the next parent in the next iteration. Otherwise, finish the loop.	 */
									if (inner_cid != null) 
									{
										//Trace.WriteLine ("createInnerComponentsOf ###: adding to icFacetConfig and icList2 --- " + ic.Id_abstract_owner + "." + ic.Id_inner );
								//		int inner_facet = -1;
								//		int inner_facet_instance = -1;
								//		build_unit_mapping_of_inner (ic, unit_mapping_enclosing, out unit_mapping_inner, facet_instance, facet, ref inner_facet_instance, ref inner_facet);
										//calculate_inner_facet_topology (unit_mapping_inner, ref inner_facet_topology);
										icList2 [ic] = unit_mapping_inner;
										icFacetConfig [ic] = new Tuple<int, int, int[]> (inner_facet_instance, inner_facet, inner_facet_topology);

										break;
									}
						
									i++;
								}

							//	if (inner_cid == null && ignore) 
							//	{
							//		string instance_name = cid.InstanceName + "#0";
							//		inner_cid = new ManagerIgnoredComponentIDImpl (instance_name, "");
							//	} 
							//	else if (inner_cid != null && ignore) 
							//	{
							//	}	
							} 
							else // it is private in this configuration, but it can be a public inner component of a public inner component.
							{
								// 1. Verificar se ele é inner component exposed
								// 2. Se não fôr, fazer nada.
								// 3. Se fôr, procurar uma conexão para ele no componente que o expõe.
								// 4. Se não fôr encontrado, fazer nada (será criado).
								// 5. Se fôr encontrado, conectar ...
								Instantiator.UnitMappingType[] unit_mapping_inner;

								int inner_facet = -1;
								int inner_facet_instance = -1;
								int[] inner_facet_topology = null;
								inner_cid = findInnerComponentInSomeInnerComponent (cid_chain[0], cid, ic, bsPort, out unit_mapping_inner, ref inner_facet, ref inner_facet_instance, ref inner_facet_topology);

								//calculate_inner_facet_topology (unit_mapping_inner, ref inner_facet_topology);
								icList2 [ic] = unit_mapping_inner;
								icFacetConfig [ic] = new Tuple<int, int, int[]> (inner_facet_instance, inner_facet, inner_facet_topology);


							}

							if (inner_cid == null ) 
							{  
								/* If the inner component private, create it. */
								Instantiator.UnitMappingType[] unit_mapping_inner = null;
								int inner_facet = -1;
								int inner_facet_instance = -1;
								 
								build_unit_mapping_of_inner (ic, unit_mapping_enclosing, out unit_mapping_inner, facet_instance, facet, ref inner_facet_instance, ref inner_facet);
								
								Trace.WriteLine("createInnerComponent - AFTER CALLING build_unit_mapping_to_inner id_abstract=" + ic.Id_abstract_owner + " inner = " + ic.Id_inner + " -- " + unit_mapping_enclosing.Length + "," + unit_mapping_inner.Length);

								int[] inner_facet_topology = null; // new int[facet_address.Length];
								calculate_inner_facet_topology (unit_mapping_inner, ref inner_facet_topology);

								if (unit_mapping_inner.Length == 0)
								{
									Trace.WriteLine("createInnerComponent: This inner component does not have slices in the units of the enclosing component.");
									return;
								}
									
								int id_functor_app_inner = ic.Id_functor_app;
								if (!ic.Parameter_top.Equals(""))
									arguments.TryGetValue(ic.Parameter_top, out id_functor_app_inner);
								
								inner_cid = createInnerComponent (cid, 
																  ic, 
																  curr_inner_cid, 
																  bsPort, 
																  arguments, 
																  argumentsTop, 
																  unit_mapping_inner,
																  facet_address,
																  facet_instance,
																  facet,
																  inner_facet_instance,
																  inner_facet,
																  inner_facet_topology,
								                                  binding_sequentials,
																  //inner_facet < 0 /* ignore */,
																  id_functor_app_inner);


								if (inner_cid == null) 
							    {
									Trace.WriteLine ("inner_cid == null ? " + (inner_cid == null) + " --- " + ic.Id_abstract_owner + "." + ic.Id_inner);
									continue;
								}
						
								Trace.WriteLine ("createInnerComponentsOf ***: adding to icFacetConfig and icList2 --- " + ic.Id_abstract_owner + "." + ic.Id_inner );

								icFacetConfig [ic] = new Tuple<int, int, int[]> (inner_facet_instance, inner_facet, inner_facet_topology);
								icList2 [ic] = unit_mapping_inner;
							}
							
							if (inner_cid == null) 
							{
								Trace.WriteLine("createInnerComponetsOf: public inner component not found ! " + cid.getInstanceName() + "." + portName);
								continue;
							}

							if (/*!(cid is ManagerIgnoredComponentID) && !(inner_cid is ManagerIgnoredComponentID) && */ (inner_cid != curr_inner_cid || curr_cid != cid)) 
							{
								
								// disconnect the old #-component, if it exists
								if (curr_inner_cid != null) {
									disconnectInnerComponent (curr_inner_connid, bsPort, frw);
									if (curr_cid != cid) {
										string usesPortName = curr_inner_connid.getUserPortName ();
										Services services = frw.getComponentServices (curr_cid);				
										services.unregisterUsesPort (usesPortName);										
									}
								}
							
								//bool ignore_connection = (cid is ManagerIgnoredComponentID) || (inner_cid is ManagerIgnoredComponentID);
								// connect to the new #-component
								Trace.WriteLine ("BEGIN CONNECT " + cid.getInstanceName () + "." + portName + " to " + inner_cid.getInstanceName ());
								connectInnerComponent (cid, portName, inner_cid, bsPort);	
								Trace.WriteLine ("END CONNECT " + cid.getInstanceName () + "." + portName + " to " + inner_cid.getInstanceName ());
							
							} 
							else 
							{
								Trace.WriteLine ("WILL NOT CONNECT !!! " + inner_cid.InstanceName);
							}

							if (inner_cid != null)
   							   inner_cids.Add(portName, inner_cid);
							else 
								Trace.WriteLine ("inner_cid is null " + inner_cid.InstanceName + " --- probably it has free context parameters");
						}
						else
						{
							Trace.Write ("createInnerComponentsOf: " + portName + " ALREADY EXISTS in inner_cids !!! --- ");
							foreach (string s in inner_cids.Keys)
								Trace.Write (s + ".");
							Trace.WriteLine ("...");
						}
							
					}
					else 
					{
						Trace.WriteLine ("createInnerComponentsOf: " + portName + " IS A QUALIFIER !!! Ignoring ...");
					}
						
				} 
				else
				{
					Trace.WriteLine("createInnerComponentsOf: ALREADY CONNECTED " + cid.getInstanceName() + " / " + ic.Id_inner);
				}

				Trace.WriteLine("createInnerComponentsOf: END TRAVERSING INNER COMPONENTS ");

				foreach (KeyValuePair<InnerComponent,Instantiator.UnitMappingType[]> ic_ in icList2)
				{
					Trace.WriteLine("createInnerComponentsOf: LOOP " + ic_.Key.Id_inner  + "," + ic_.Value.Length);
					InnerComponent ic = ic_.Key;
					Instantiator.UnitMappingType[] unit_mapping_inner = ic_.Value;

					Trace.WriteLine("createInnerComponentsOf: STEP 1 " + ic.Parameter_top + "#" + ic.Id_functor_app + "," + cid.Id_functor_app);
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

						Trace.Write ("createInnerComponentsOf: id_abstrac_owner=" + ic.Id_abstract_owner + ", id_inner=" + ic.Id_inner);

						int inner_facet_instance = icFacetConfig[ic].Item1;
						int inner_facet = icFacetConfig [ic].Item2;
						int[] inner_facet_topology = icFacetConfig [ic].Item3;

						Trace.WriteLine ("createInnerComponentsOf -------");

						createInnerComponentsOf(session_id_string,
						                        cid_chain_inner,
												curr_inner_cid,
						                        inner_cid,
							                    id_abstract_owner_inner,
							                    id_inner_at_owner_inner,
							                    arguments_new,
							                    argumentsTop, 
						                        unit_mapping_inner,
						                        inner_facet_instance,
						                        inner_facet, 
												inner_facet_topology,
							                    facet_info,
												binding_sequentials);
					}
				}
				
				if (curr_cid != null && curr_cid != cid)
				{
					Services services = frw.getComponentServices(curr_cid);
					services.removeProvidesPort(Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS);
					services.removeProvidesPort(Constants.INITIALIZE_PORT_NAME);
					services.removeProvidesPort(Constants.RECONFIGURE_PORT_NAME);
					//services.removeProvidesPort(Constants.RECONFIGURE_PORT_NAME);
					if (curr_cid.Kind == Constants.KIND_APPLICATION)
						services.removeProvidesPort(Constants.GO_PORT_NAME);
					Trace.WriteLine("DESTROY INSTANCE " + curr_cid);
					bsPort.destroyInstance(curr_cid, 0);
				}
									
				Trace.WriteLine("END CREATING INNER COMPONENTS OF " + cid.getInstanceName());
				Trace.WriteLine("********************************");
			}
	

			/* It will return a set of threads representing delayed instantiation of solution components and their bindings, 
			 * indexed by the their names. 
			 */

			public static IDictionary<string,Thread> createDelayedInstantiationTriggersOfSolutionComponents 
			                                         (
														string session_id_string,
														IList<ManagerComponentID> cid_chain, 
														ManagerComponentID curr_cid, 
														ManagerComponentID cid,
														IDictionary<string, int> arguments,
														IDictionary<string, int> argumentsTop,
														Instantiator.UnitMappingType[] unit_mapping_enclosing,
				                                        Tuple<int, Tuple<int,string>[]> facet_info,
														IList<string> binding_sequentials
			                                          )
			{	
				Trace.WriteLine("**********************************" + (cid==null));
				Trace.WriteLine("BEGIN CREATING INNER COMPONENTS OF " + cid.getInstanceName() + "-" + cid.Id_functor_app);

				// TAKE SESSION CONTEXT.
				ISession session = open_sessions [session_id_string];
				ManagerObject frw = (ManagerObject) session.Framework;
				gov.cca.Services frwServices = session.Services;

				gov.cca.ports.BuilderService bsPort = (gov.cca.ports.BuilderService) frwServices.getPort (Constants.BUILDER_SERVICE_PORT_NAME);

				AbstractComponentFunctorApplication acfa = acfadao.retrieve(cid.Id_functor_app);	
				int id_abstract = acfa.Id_abstract;

				IDictionary<string, ConnectionID> inner_conn_list = new Dictionary<string, ConnectionID>();					
				if  (curr_cid != null)
					fetchConnectionsAsUser(curr_cid, inner_conn_list, bsPort);

				IList<InnerComponent> icList = BackEnd.icdao.list(id_abstract);

				IDictionary<string,Thread> thread_create_ic = new Dictionary<string, Thread> ();

				Tuple<int,string>[] facet_address = facet_info.Item2;
				int facet_instance = facet_info.Item1;
				int facet = facet_address[facet_instance].Item1;

				foreach (InnerComponent ic in icList) 
				{
					Trace.WriteLine("createInnerComponent: " + ic.Id_abstract_owner + " / " +  ic.Id_inner);

					/* If the inner component private, create it. */
					Instantiator.UnitMappingType[] unit_mapping_inner = null;
					int inner_facet = -1;
					int inner_facet_instance = -1;
					int[] inner_facet_topology = null;

					build_unit_mapping_of_inner(ic, unit_mapping_enclosing, out unit_mapping_inner, facet_instance, facet, ref inner_facet_instance, ref inner_facet);
					Trace.WriteLine("createInnerComponent - AFTER CALLING build_unit_mapping_to_inner id_abstract=" + ic.Id_abstract_owner + " inner = " + ic.Id_inner + " -- " + unit_mapping_enclosing.Length + "," + unit_mapping_inner.Length);

					inner_facet_topology = new int[facet_address.Length];
					calculate_inner_facet_topology (unit_mapping_inner, ref inner_facet_topology);

					if (unit_mapping_inner.Length == 0)
					{
						Trace.WriteLine("createInnerComponent: This inner component does not have slices in the units of the enclosing component.");
						throw new Exception("createInnerComponent: This inner component does not have slices in the units of the enclosing component.");
					}

					thread_create_ic [ic.Id_inner] = new Thread ((ParameterizedThreadStart)delegate(object facet_info_) 
					{
						string portName = ic.Id_inner;

						Trace.WriteLine ("createInnerComponentsOf: LOOP inner " + portName + ", facet_instance = " + facet_instance + ", facet = " + facet);

						AbstractComponentFunctor acf = BackEnd.acfdao.retrieve (ic.Id_abstract_inner);
						ManagerComponentID inner_cid = null;

						// Take the inner component currently bound to the inner component
						ConnectionID curr_inner_connid;
						ManagerComponentID curr_inner_cid;								
						inner_conn_list.TryGetValue (portName, out curr_inner_connid);
						curr_inner_cid = curr_inner_connid != null ? (ManagerComponentID)curr_inner_connid.getProvider () : null;

						int id_functor_app_inner = ic.Id_functor_app;
						if (!ic.Parameter_top.Equals(""))
							arguments.TryGetValue(ic.Parameter_top, out id_functor_app_inner);
					
						inner_cid = createInnerComponent (cid, 
														  ic, 
														  curr_inner_cid, 
														  bsPort, 
														  arguments, 
														  argumentsTop, 
														  unit_mapping_inner,
														  facet_address,
														  facet_instance,
														  facet,
														  inner_facet_instance,
														  inner_facet,
														  inner_facet_topology,
														  binding_sequentials, 
						                                  //inner_facet < 0,
					                                      id_functor_app_inner);

						int id_functor_app_inner_actual = inner_cid.Id_functor_app; // ic.Id_functor_app;

						IDictionary<string, int> arguments_new;
						determineArguments (arguments, id_functor_app_inner_actual, out arguments_new);

						IList<ManagerComponentID> cid_chain_inner = new List<ManagerComponentID> (cid_chain);					
						cid_chain_inner.Insert (0, cid);

						List<int> id_abstract_owner_inner = new List<int> ();
						id_abstract_owner_inner.Insert (0, id_abstract);

						List<string> id_inner_at_owner_inner = new List<string> ();
						id_inner_at_owner_inner.Insert (0, portName);

						// connect to the new #-component
						//if (inner_facet >= 0) 
						//{
							bool ignore_connection = inner_facet < 0;
							connectInnerComponent (cid, portName, inner_cid, bsPort);	
						//}

						createInnerComponentsOf (
							session_id_string,
							cid_chain_inner,
							curr_inner_cid,
							inner_cid,
							id_abstract_owner_inner,
							id_inner_at_owner_inner,
							arguments_new,
							argumentsTop, 
							unit_mapping_inner,
							inner_facet_instance,
							inner_facet, 
							inner_facet_topology,
						    facet_info,
							binding_sequentials/*,
						    inner_facet < 0*/);

						// connect to the new #-component
						//if (inner_facet >= 0) 
					   // {
						Trace.WriteLine("BEGIN INITIALIZE COMPONENT " + inner_cid.InstanceName);
						initializeComponent (inner_cid, bsPort, frwServices);
						Trace.WriteLine("END INITIALIZE COMPONENT " + inner_cid.InstanceName);
						//}
					    //else
					    //{
						//	Trace.WriteLine("WILL NOT CONNECT " + inner_cid.InstanceName);
					    //}
					});
				} 					

				Trace.WriteLine("END CREATING INNER COMPONENTS OF " + cid.getInstanceName() + "-" + cid.Id_functor_app);
			    return thread_create_ic;
			}




			public static void connectInnerComponent (ManagerComponentID cid, 
				                                      string uses_port_name,
				                                      ManagerComponentID inner_cid, 
							                          gov.cca.ports.BuilderService bsPort)
			{
				Trace.WriteLine ("connectInnerComponent - BEGIN CONNECT " + inner_cid.InstanceName);
				bsPort.connect (cid, uses_port_name, inner_cid, Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS);
				Trace.WriteLine ("connectInnerComponent - END CONNECT");
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

			public static void copy_unit_mapping_to_dictionary (int facet_instance, Instantiator.UnitMappingType[] unit_mapping, 
				                                                out IDictionary<string, IList<Tuple<int,int[],int>>> unit_mapping_dict, 
				                                                out int count_nodes)
			{
				count_nodes = 0;
				unit_mapping_dict = new Dictionary<string, IList<Tuple<int,int[],int>>>();
				foreach (Instantiator.UnitMappingType unit_node in unit_mapping)
				{
					Trace.WriteLine ("copy_unit_mapping_to_dictionary - adding " + unit_node.unit_id);

					string key = unit_node.unit_id;
					IList<Tuple<int,int[],int>> list = null;
					if (!unit_mapping_dict.TryGetValue (key, out list)) 
					{
						list = new List<Tuple<int,int[],int>> ();
						unit_mapping_dict.Add (key, list);
					}

					list.Add (new Tuple<int,int[],int> (unit_node.facet_instance, unit_node.node, unit_node.facet));
					Trace.WriteLine ("unit_node.facet_instance=" + unit_node.facet_instance + ", facet_instance=" + facet_instance + ", unit_node.node.Length=" + unit_node.node.Length);
					if (unit_node.facet_instance == facet_instance)
						count_nodes += unit_node.node.Length;
				}
			}

			private static void build_unit_mapping_of_inner (InnerComponent ic, 
															 Instantiator.UnitMappingType[] unit_mapping_enclosing, 
															 out Instantiator.UnitMappingType[] unit_mapping_inner,
															 int enclosing_facet_instance,
															 int enclosing_facet,
															 ref int this_facet_instance,
															 ref int this_facet)
			{
				this_facet_instance = enclosing_facet_instance;

				int count_nodes;
				IDictionary<string,IList<Tuple<int,int[],int>>> unit_mapping_dict;
				BackEnd.copy_unit_mapping_to_dictionary(enclosing_facet_instance, unit_mapping_enclosing, out unit_mapping_dict, out count_nodes);

				Trace.WriteLine("build_unit_mapping_of_inner -1 - " + ic.Id_abstract_owner + "," + ic.Id_inner);
				IList<Slice> slice_list = BackEnd.sdao.listByInner(ic.Id_abstract_owner, ic.Id_inner);

				IDictionary<string,Instantiator.UnitMappingType> unit_mapping_save = new Dictionary<string,Instantiator.UnitMappingType>();
								
				foreach (Slice slice in slice_list)
				{
					int[] nodes;
					int facet_instance;
					int facet;
					Interface i_host = BackEnd.idao.retrieve(ic.Id_abstract_owner, slice.Id_interface);
					Trace.WriteLine("build_unit_mapping_of_inner 0 - " + i_host.Id_interface_super_top);
					IList<Tuple<int,int[],int>> info_list = null;
					if (unit_mapping_dict.TryGetValue (i_host.Id_interface_super_top, out info_list)) 
					{
						foreach (Tuple<int,int[],int> info in info_list) 
						{
							facet_instance = info.Item1;
							nodes = info.Item2;
							facet = info.Item3;
							Instantiator.UnitMappingType unit_mapping_slice;
							Interface i = BackEnd.idao.retrieveSuper (ic.Id_abstract_inner, slice.Id_interface_slice);
							Trace.WriteLine ("build_unit_mapping_of_inner: " + ic.Id_abstract_inner + "," + slice.Id_interface_slice + ", i_host.Facet = " + i_host.Facet + ", enclosing_facet = " + enclosing_facet + ", i.Facet = " + i.Facet);

							// CHECK THIS_FACET
							if (i_host.Facet == enclosing_facet)
							{
								if (this_facet == -1)
									this_facet = i.Facet;
								else if (this_facet != i.Facet)
									throw new Exception ("Wrong facet configuration !");
							}

							if (unit_mapping_save.TryGetValue (i.Id_interface_super_top + facet_instance/*i_host.Facet*/, out unit_mapping_slice)) 
							{
								Trace.WriteLine ("build_unit_mapping_of_inner 1");
								int[] nodes_ = new int[unit_mapping_slice.node.Length + nodes.Length];
								unit_mapping_slice.node.CopyTo (nodes_, 0);
								nodes.CopyTo (nodes_, unit_mapping_slice.node.Length);
								unit_mapping_slice.node = nodes_;
								Trace.WriteLine ("build_unit_mapping_of_inner 1: add unit_id=" + unit_mapping_slice.unit_id 
									                                        + ", unit_index=" + unit_mapping_slice.unit_index 
																			+ ", facet = " + i_host.Facet
									                                        + ", total nodes" + nodes_.Length);
							} 
							else 
							{
								Trace.WriteLine ("build_unit_mapping_of_inner 2 " + (nodes == null));
								unit_mapping_slice = new Instantiator.UnitMappingType ();
								unit_mapping_slice.facet_instance = facet_instance;
								unit_mapping_slice.facet = i.Facet;
								unit_mapping_slice.unit_id = i.Id_interface_super_top; 
								unit_mapping_slice.node = nodes;									

								unit_mapping_save.Add (unit_mapping_slice.unit_id + facet_instance /*i_host.Facet*/, unit_mapping_slice);

								Trace.WriteLine ("build_unit_mapping_of_inner 2: add unit_id=" + unit_mapping_slice.unit_id + 
									", unit_index=" + unit_mapping_slice.unit_index + 
									", facet = " + this_facet +
									", facet_instance = " + facet_instance +
									", total nodes = " + nodes.Length);
							}
						}
					} 
					else 
					{
						throw new Exception ("Wrong configuration !");
					}
				}

				unit_mapping_inner = new Instantiator.UnitMappingType[unit_mapping_save.Count];
				unit_mapping_save.Values.CopyTo(unit_mapping_inner,0);
			}
	
			private static void calculate_inner_facet_topology(Instantiator.UnitMappingType[] unit_mapping_inner, ref int[] facet_topology)
			{
				IList<Tuple<int,int>> facet_topology_list = new List<Tuple<int,int>> ();

				int max = 0;
				foreach (Instantiator.UnitMappingType um in unit_mapping_inner) 
				{
					Trace.WriteLine ("calculate_inner_facet_topology: (" + um.facet_instance + "," + um.facet + ")");
					facet_topology_list.Add (new Tuple<int, int> (um.facet_instance, um.facet));
					max = um.facet_instance > max ? um.facet_instance : max;
				}

				facet_topology = new int[max+1];
				for (int i = 0; i < facet_topology.Length; i++)
					facet_topology [i] = -1;

				foreach (Tuple<int,int> p in facet_topology_list)
					facet_topology[p.Item1] = p.Item2;

				for (int i = 0; i < facet_topology.Length; i++)
					Trace.WriteLine ("facet_topology[" + i + "] = " + facet_topology[i]);
			}

			public static ManagerComponentID createInnerComponent (ManagerComponentID cid, 
				                                                   InnerComponent ic, 
			                                                       ManagerComponentID current_inner_cid,
							                                       gov.cca.ports.BuilderService bsPort, 
							                                       IDictionary<string, int> arguments,
	                            					   			   IDictionary<string, int> argumentsTop,
			                                                       Instantiator.UnitMappingType[] unit_mapping_inner,
				                                                   Tuple<int,string>[] facet_address,
			                                                       int enclosing_facet_instance,
			                                                       int enclosing_facet,
																   int this_facet_instance,
				                                                   int this_facet,
																   int[] this_facet_topology,
																   IList<string> binding_sequentials,
																   //bool ignore,
																   int id_functor_app_inner)
			{

				AbstractComponentFunctorApplication acfa_inner = acfadao.retrieve(id_functor_app_inner);	//??? parameter_top ???

				Trace.WriteLine("BEFORE generateACFAForContext " + ic.Id_functor_app);
				foreach (KeyValuePair<string,int> uuuu in arguments)
					Trace.WriteLine("createInnerComponent (arguments) KEY=" + uuuu.Key + "; VALUE=" + uuuu.Value); 
				foreach (KeyValuePair<string,int> uuuu in argumentsTop)
					Trace.WriteLine("createInnerComponent (arguments TOP) KEY=" + uuuu.Key + "; VALUE=" + uuuu.Value); 				


				Trace.WriteLine ("creatennerComponent --- cid.Id_functor_app = " + (cid == null ? -1 : cid.Id_functor_app) + " / " + (current_inner_cid == null ? -1 : current_inner_cid.Id_functor_app));

				int id_functor_app = generateACFAforContext(acfa_inner.Id_abstract, id_functor_app_inner, arguments, argumentsTop, this_facet_instance);

				AbstractComponentFunctorApplication acfa = acfadao.retrieve(id_functor_app);	//??? parameter_top ???
					
				int version = current_inner_cid == null ? 0 : current_inner_cid.Version + 1;
				string inner_instance_name = cid.getInstanceName() + "-" + ic.Id_inner + "#" + version;
				bool has_free_parameter = false;
				ManagerComponentID inner_cid = null;
				DGAC.database.Component c = null;
				TypeMapImpl properties = null;
				int kind = default(int);	

				try 
				{
					c = resolveUnit(acfa, arguments, argumentsTop);	
					kind = Constants.kindMapping [c.Kind];
						
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
						

					Trace.WriteLine ("createInnerComponent - id_functor_app=" + id_functor_app + ",id_functor_app_inner=" + id_functor_app_inner);


					Trace.WriteLine("BEFORE START CREATING INNER COMPONENT name=" + inner_instance_name + " !");

					if (kind == Constants.KIND_BINDING) 
					{
						Trace.WriteLine ("createInnerComponent -- NEW BINDING -- inner_instance_name=" + inner_instance_name + " / count=" + binding_sequentials.Count);
						binding_sequentials.Add (inner_instance_name);
					}

					// Instantiate the inner component.
					properties = new TypeMapImpl();					
					properties[Constants.ID_FUNCTOR_APP] = id_functor_app;
					properties[Constants.PORT_NAME] = ic.Id_inner;
					properties[Constants.ENCLOSING_ARGUMENTS] = arguments;
					properties[Constants.NODES_KEY] = unit_mapping_inner;
					properties[Constants.FACET_INSTANCE] = this_facet_instance;
					properties[Constants.FACET] = this_facet;
					properties[Constants.FACET_TOPOLOGY] = this_facet_topology;
					properties[Constants.IGNORE] = this_facet < 0;
					if (kind == Constants.KIND_BINDING) 
					{ // If it is a binding ... 
						foreach (string n in binding_sequentials)
							Trace.WriteLine ("binding_sequentials: LOOKING FOR " + inner_instance_name + " / " + n);
						properties [Constants.BINDING_SEQUENTIAL] = binding_sequentials.IndexOf (inner_instance_name);
					}


					//Trace.WriteLine ("createInnerComponent - INSERTING binding access " + ic.Id_inner + "," + (binding_access_address != null ? binding_access_port.Length.ToString() : "NULL") + "," + (binding_access_port != null ? binding_access_address.Length.ToString() : "NULL"));
					//if (binding_access_address != null && binding_access_port != null && binding_access_port.Length == binding_access_address.Length) 
					if (facet_address != null)
					{
						// IT IS SUPPOSED THIS IS A CONNECTOR, PROBABLY WITH INTERNAL BINDINGS.
						string [] binding_access_address = new string[facet_address.Length];
						int[] binding_access_port = new int[facet_address.Length];
						int i = 0;
						foreach (Tuple<int,string> t in facet_address) 
						{
							string[] address = t.Item2.Split(new char[1] {':'});
							binding_access_address [i] = address [0];
							binding_access_port [i] = int.Parse(address [1]);
							i++;
						}

						properties[Constants.FACET_IP_ADDRESS] = binding_access_address;
						properties[Constants.FACET_PORT] = binding_access_port;
					}

					Trace.WriteLine("START CREATING INNER COMPONENT name=" + inner_instance_name + "...");
					foreach (Instantiator.UnitMappingType uuu in unit_mapping_inner) 
					{   Trace.WriteLine ("----");
						foreach (int nnn in uuu.node)
							Trace.WriteLine ("facet_instance=" + uuu.facet_instance + " - facet=" + uuu.facet + " - unit " + uuu.unit_id + uuu.unit_index + " at node " + nnn);
					}

					Trace.WriteLine ("bsPort == null ? " + (bsPort == null) + ", c == null ? " + (c == null) + ", inner_instance_name = " + (inner_instance_name == null ? "null" : inner_instance_name));

					inner_cid = (ManagerComponentID)bsPort.createInstance (inner_instance_name, c.Library_path, properties);				
					Trace.WriteLine ("FINISH CREATING INNER COMPONENT name=" + inner_instance_name + "...");
					Trace.WriteLine ("--");
					inner_cid.Version = version;
				}
				catch (FreeVariableException e) 
				{
					Trace.WriteLine ("FREE VARIABLE FOUND " + acfa.Id_functor_app + ". Component will be bypassed. Ignore=" + (this_facet < 0));
				}
					
				return inner_cid;
			}
	
			public static ManagerComponentID findInnerComponentInSomeInnerComponent(
				ManagerComponentID cid_owner,
				ManagerComponentID cid, 
				InnerComponent ic, 
				gov.cca.ports.BuilderService bsPort,
				out Instantiator.UnitMappingType[] unit_mapping_inner,
				ref int facet_instance,
				ref int facet,
				ref int[] facet_topology)
			{
				unit_mapping_inner = null;

				IList<InnerComponentExposed> ice_list = BackEnd.icedao.listOwnerOfExposedInner (ic.Id_abstract_owner, ic.Id_inner);
				if (ice_list == null || ice_list.Count==0)
					return null;



				ManagerComponentID cid_inner = null;

				foreach (InnerComponentExposed ice in ice_list) 
				{
					Trace.WriteLine ("findInnerComponentInSomeInnerComponent x -- " + ic.Id_abstract_owner + " / " + ice.Id_inner_owner);
					InnerComponent ic_owner = BackEnd.icdao.retrieve (ic.Id_abstract_owner, ice.Id_inner_owner);
					Trace.WriteLine ("findInnerComponentInSomeInnerComponent y -- " + ic_owner.IsPublic);

					if (!ic_owner.IsPublic)
						continue;
						
					AbstractComponentFunctorApplication acfa = BackEnd.acfadao.retrieve (cid_owner.Id_functor_app);
					AbstractComponentFunctor acf = BackEnd.acfdao.retrieve (acfa.Id_abstract);

					Trace.WriteLine ("findInnerComponentInSomeInnerComponent: checking " + acf.Id_abstract + " / " + cid.PortName + " / " + ice.Id_inner_owner);

					InnerComponentExposed ice_owner = BackEnd.icedao.retrieveContainer(acf.Id_abstract, cid.PortName, ice.Id_inner_owner);

					// -----------------------------------------------------------------------------------------------------------------

					// Get all connections where cid_owner participates, as user and provider.
					ConnectionID[] conn_list_1 = bsPort.getConnectionIDs (new ComponentID[] { cid_owner });

					Trace.WriteLine ("findInnerComponentInSomeInnerComponent 1: fetching connections " + cid_owner.InstanceName + " / conn_list.Length=" + conn_list_1.Length);
					Trace.WriteLine ("findInnerComponentInSomeInnerComponent 1: look for " + ice_owner.Id_inner_rename);

					ManagerComponentID cid_owner_2 = null;
					// Among them, find the connection wherer it is user and the provider port is ice.Id_inner.
					foreach (ConnectionID conn_id in conn_list_1) 
					{
						Trace.WriteLine ("findInnerComponentInSomeInnerComponent 1: TESTING " + conn_id.getUser ().getInstanceName () + "/" + conn_id.getUserPortName ());
						if (conn_id.getUser () == cid_owner && conn_id.getUserPortName ().Equals (ice_owner.Id_inner_rename)) {
							cid_owner_2 = (ManagerComponentID)conn_id.getProvider ();
							break;
						}
					}

					// -----------------------------------------------------------------------------------------------------------------

					if (cid_owner_2 != null)
					{
						// Get all connections where cid_owner participates, as user and provider.
						ConnectionID[] conn_list_2 = bsPort.getConnectionIDs (new ComponentID[] { cid_owner_2 });

						Trace.WriteLine ("findInnerComponentInSomeInnerComponent 2: fetching connections " + cid_owner_2.InstanceName + " / conn_list.Length=" + conn_list_2.Length);
						Trace.WriteLine ("findInnerComponentInSomeInnerComponent 2: look for " + ice.Id_inner);

						// Among them, find the connection wherer it is user and the provider port is ice.Id_inner.
						foreach (ConnectionID conn_id in conn_list_2) 
						{
							Trace.WriteLine ("findInnerComponentInSomeInnerComponent 2: TESTING " + conn_id.getUser ().getInstanceName () + "/" + conn_id.getUserPortName ());
							if (conn_id.getUser () == cid_owner_2 && conn_id.getUserPortName ().Equals (ice.Id_inner)) {
								cid_inner = (ManagerComponentID)conn_id.getProvider ();
								break;
							}
						}
					}

					// -----------------------------------------------------------------------------------------------------------------

					if (cid_inner == null) {
						Trace.WriteLine ("findInnerComponentInSomeInnerComponent 2 (DGAC.cs): connection for " + ice.Id_inner + " not found in " + cid_owner);
						return null;
					}

					// ----------------------------------------------------------------------------------------------------------------------------------------------------

					TypeMapImpl properties = (TypeMapImpl)bsPort.getComponentProperties (cid_inner);
					unit_mapping_inner = (Instantiator.UnitMappingType[])properties [Constants.NODES_KEY];
					facet_instance =(int)properties [Constants.FACET_INSTANCE];
					facet =(int)properties [Constants.FACET];
					facet_topology = (int[])properties [Constants.FACET_TOPOLOGY];
				}

				return cid_inner;

			}

			public static ManagerComponentID findInnerComponentInTheHostComponent (ManagerComponentID cid_owner, 
				                                                 ManagerComponentID cid, 
				                                                 InnerComponent ic, 
				                                                 int id_abstract_owner,
				                                                 string id_inner_at_owner, 
				                                       			 gov.cca.ports.BuilderService bsPort,
																 out Instantiator.UnitMappingType[] unit_mapping_inner,
																 ref int facet_instance,
																 ref int facet,
				                                                 ref int[] facet_topology)
			{
			 unit_mapping_inner = null;

			 InnerComponentExposed ice = icedao.retrieveContainer(id_abstract_owner, id_inner_at_owner, ic.Id_inner);
			 if (ice == null)
			 {
				Trace.WriteLine("findInnerComponent (DGAC.cs): " +  ic.Id_inner + " not found in " + id_abstract_owner + "/" + id_inner_at_owner);
				return null;
			 }
			 
			 ManagerComponentID cid_inner = null;
			
			 // Get all connections where cid_owner participates, as user and provider.
			 ConnectionID[] conn_list = bsPort.getConnectionIDs(new ComponentID[] {cid_owner});

				Trace.WriteLine ("findInnerComponent: fetching connections " + cid_owner.InstanceName + " / conn_list.Length=" + conn_list.Length);
				Trace.WriteLine ("findInnerComponent: look for " + ice.Id_inner_rename);


			 // Among them, find the connection wherer it is user and the provider port is ice.Id_inner.
			 foreach (ConnectionID conn_id in conn_list)
			 {
					Trace.WriteLine ("findInnerComponent: TESTING " + conn_id.getUser().getInstanceName() + "/" + conn_id.getUserPortName());
				if (conn_id.getUser() == cid_owner && conn_id.getUserPortName().Equals(ice.Id_inner_rename) ) 
				{
					    cid_inner = (ManagerComponentID) conn_id.getProvider();
						break;
				}
			 }
									
			 if (cid_inner == null)
			 {
				Trace.WriteLine("findInnerComponent (DGAC.cs): connection for " +  ice.Id_inner_rename + " not found in " + cid_owner);
				return null;
			 }
			 		
			 TypeMapImpl properties = (TypeMapImpl) bsPort.getComponentProperties(cid_inner);
			 unit_mapping_inner = (Instantiator.UnitMappingType[]) properties[Constants.NODES_KEY];
			 facet_instance =(int)properties [Constants.FACET_INSTANCE];
			 facet =(int)properties [Constants.FACET];
			 facet_topology = (int[])properties [Constants.FACET_TOPOLOGY];

					
			 return cid_inner;
			}
				
			public static void fetchConnectionsAsUser (ManagerComponentID cid, 
					                                   IDictionary<string, ConnectionID> inner_conn_list, 
						                               gov.cca.ports.BuilderService bsPort)
			{
				ConnectionID[] conn_id_list = bsPort.getConnectionIDs(new ComponentID[] {cid});	
				foreach (ConnectionID conn_id in conn_id_list)
					if (conn_id.getUser().getInstanceName().Equals(cid.getInstanceName()))
						inner_conn_list.Add(conn_id.getUserPortName(), conn_id);
			}
				
			public static void fetchConnectionsAsProvider (ManagerComponentID cid, 
						                                   IList<ConnectionID> provides_conn_list, 
							                               gov.cca.ports.BuilderService bsPort)
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
				Console.Error.WriteLine("Port " + portName + " still in use (release count = " + count_release + ")");
				throw new CCAExceptionImpl(CCAExceptionType.UsesPortNotReleased);
			}
			
			portReleases.Add (portName, count_release + 1);				
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
