using br.ufc.pargo.hpe.backend.DGAC.utils;
using System;
using System.Linq;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.database;
using Instantiator;
using System.Collections;
using System.CodeDom;
using Microsoft.CSharp;
using System.CodeDom.Compiler;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC;
using SAFeSWL;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.backend
{
	public class LoaderSystem
	{
		internal enum ProxyComponentAttribute 
		{
			COMPONENT_NAME_ABSTRACT,
			INTERFACE_NAME_ABSTRACT,
			UNIT_NAME_ABSTRACT,
			COMPONENT_NAME_CONCRETE,
			INTERFACE_NAME_CONCRETE,
			UNIT_NAME_CONCRETE,
			INNER_COMPONENT_NAME
		}

		public static Tuple<Tuple<ComponentType,ComponentType>,   // application component (abstract + concrete)
							Tuple<ComponentType,ComponentType>,   // workflow component (abstract + concrete)
							Tuple<ComponentType,ComponentType>>   // system component (abstract + concrete)
				   createSystemComponent(string app_name,
										 string application_component_name,
										 string workflow_component_name,
										 IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
										 IDictionary<string, Instantiator.UnitMappingType[]> unit_mapping, 
                                         IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application,
			                             IList<Tuple<string, string, EnvironmentPortType, string>> bindings_workflow, 
										 IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system,
										 IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task,
										 IList<string> platforms) 
		{
			try {
					
				br.ufc.pargo.hpe.backend.DGAC.database.Connector.openConnection ();
				/* Applicaton, workflow and platform components need to know which are the environment ports. */

				IDictionary<ProxyComponentAttribute, string> application_attributes 
						= new Dictionary<ProxyComponentAttribute, string> () 
						  {
							{ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT, "Application"},
							{ProxyComponentAttribute.COMPONENT_NAME_CONCRETE, "ApplicationImpl"},
							{ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT, "IApplication"},
							{ProxyComponentAttribute.INTERFACE_NAME_CONCRETE, "IApplicationImpl"},
							{ProxyComponentAttribute.UNIT_NAME_ABSTRACT,"application_unit"},
							{ProxyComponentAttribute.UNIT_NAME_CONCRETE,"application_unit"},
							{ProxyComponentAttribute.INNER_COMPONENT_NAME, application_component_name}
						  };
				Tuple<ComponentType, ComponentType> app_component = createProxyComponent (app_name, bindings_application, new List<Tuple<string, Tuple<string, string,int>[]>>(), application_attributes, contracts, platforms);

				IDictionary<ProxyComponentAttribute, string> worklow_attributes 
						= new Dictionary<ProxyComponentAttribute, string> () 
				          {
							{ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT, "Workflow"},
							{ProxyComponentAttribute.COMPONENT_NAME_CONCRETE, "WorkflowImpl"},
							{ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT, "IWorkflow"},
							{ProxyComponentAttribute.INTERFACE_NAME_CONCRETE, "IWorkflowImpl"},
							{ProxyComponentAttribute.UNIT_NAME_ABSTRACT,"workflow_unit"},
							{ProxyComponentAttribute.UNIT_NAME_CONCRETE,"workflow_unit"},
					        {ProxyComponentAttribute.INNER_COMPONENT_NAME, workflow_component_name}
						  };
				Tuple<ComponentType, ComponentType> wrf_component = createProxyComponent (app_name, bindings_workflow, bindings_task, worklow_attributes, contracts, platforms);

				ComponentType system_abstract = createSystemAbstract (app_name, application_attributes, worklow_attributes, contracts, unit_mapping, bindings_application, bindings_workflow, bindings_system, bindings_task, platforms);
				ComponentType system_concrete = createSystemConcrete (app_name, system_abstract, contracts);

				Tuple<ComponentType, ComponentType> system_component = new Tuple<ComponentType, ComponentType> (system_abstract, system_concrete);

				return new Tuple<Tuple<ComponentType, ComponentType>, Tuple<ComponentType, ComponentType>, Tuple<ComponentType, ComponentType>>(app_component, wrf_component, system_component);
			}
			catch(Exception e) 
			{
				Console.Error.WriteLine (e.Message);
				Console.Error.WriteLine (e.StackTrace);
				if (e.InnerException != null) {
					Console.Error.WriteLine (e.InnerException.Message);
					Console.Error.WriteLine (e.InnerException.StackTrace);
				}

			}
			finally 
			{
				br.ufc.pargo.hpe.backend.DGAC.database.Connector.closeConnection ();
			}

			return null;
		}

		static ComponentType createSystemAbstract (string app_name,
		                                           IDictionary<ProxyComponentAttribute, string> application_attributes, 
		                                           IDictionary<ProxyComponentAttribute, string> worklow_attributes, 
												   IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts, 
									    		   IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping, 
		                                           IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application, 
		                                           IList<Tuple<string, string, EnvironmentPortType, string>> bindings_workflow,
												   IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system,
			                                       IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task, 
												   IList<string> platforms)
		{
			ComponentType c = new ComponentType ();

			ComponentHeaderType h = c.header = new ComponentHeaderType();
			h.hash_component_UID = h.GetHashCode().ToString() ; //?
			h.isAbstractSpecified = true;
			h.isAbstract = true; 
			h.kindSpecified = true;
			h.kind = SupportedKinds.Application;
			h.name = "System"; 
			h.packagePath = app_name /*+ "." + arch_ref*/; 

			IList<object> body_items = new List<object> ();

			// ADD INNER COMPONENTS (many, one for each environment bindind)
			createSystemComponentAbstractInner (app_name, body_items, contracts, application_attributes, worklow_attributes, bindings_application, bindings_workflow, bindings_system, bindings_task, platforms);

			// NO PARAMETERS
			// NO SUPPLY PARAMTERS
			fuseProxyBindings (body_items, application_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME],bindings_application, contracts, platforms);
			fuseProxyBindings (body_items, worklow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME], bindings_workflow, contracts, platforms);
			fuseBindings (body_items, bindings_system, platforms);
			fuseBindings (body_items, bindings_task, platforms);

			FusionType platform_SAFe_fusion = new FusionType ();
			platform_SAFe_fusion.cRefs = new string[] { "workflow", "application" };
			platform_SAFe_fusion.pRef = "platform_SAFe";
			body_items.Add (platform_SAFe_fusion);

			// NO SPLIT
			// NO RECURSIVE ENTRY

			// ADD UNIT (single)
			createSystemComponentAbstractUnit (app_name, body_items, contracts, unit_mapping, application_attributes, worklow_attributes, bindings_application, bindings_workflow, bindings_system, bindings_task, platforms);

			// ADD INTERFACE
			// createSystemComponentAbstractInterface (body_items, bindings_application);

			// NO FUSION OF REPLICATORS

			// NO EXTERNAL LIBRARIES

			c.componentInfo = new object[body_items.Count];
			body_items.CopyTo (c.componentInfo, 0);

			return c;
		}


		static void fuseBindings (IList<object> body_items, IList<Tuple<string, Tuple<string, string,int>[]>> bindings, IList<string> platforms)
		{
			IDictionary<string, IList<string>> platform_fusions = new Dictionary<string, IList<string>> ();

			foreach (Tuple<string,Tuple<string,string,int>[]> binding in bindings) 
			{
				// ignorar bindings para platformas
				if (!platforms.Contains (binding.Item2 [1].Item1)) 
				{					
					IList<string> b = new List<string> ();
					string bRef = binding.Item1;
					foreach (Tuple<string, string, int> port in binding.Item2) 
					{
						string cRef = port.Item1;
						string pRef = port.Item2;
						int facet = port.Item3;
						if (!b.Contains (cRef)) {
							string cOldName = pRef, cNewName = bRef;
							b.Add (cRef);
							if (!pRef.Equals (bRef)) 
							{
								InnerRenamingType renaming_peer = new InnerRenamingType ();
								body_items.Add (renaming_peer);
								renaming_peer.cRef = cRef;
								renaming_peer.cOldName = cOldName;
								renaming_peer.cNewName = cNewName;
							}
						}
					}

					if (b.Count > 1) {
						string[] cRefs = new string[b.Count];
						b.CopyTo (cRefs, 0);

						FusionType fusion = new FusionType ();
						body_items.Add (fusion);
						fusion.cRefs = cRefs;
						fusion.pRef = bRef;
					}
				} 
				else 
				{
					string cRef = binding.Item2 [0].Item1;
					string cOldName = binding.Item2 [0].Item2;
					string cNewName = binding.Item2 [1].Item1;
					if (!cOldName.Equals (cNewName)) 
					{
						InnerRenamingType renaming_peer = new InnerRenamingType ();
						body_items.Add (renaming_peer);
						renaming_peer.cRef = cRef;
						renaming_peer.cOldName = cOldName;
						renaming_peer.cNewName = cNewName;
					}

					IList<string> to_fuse = null;
					if (!platform_fusions.TryGetValue (cNewName, out to_fuse)) 
					{
						to_fuse = new List<string> ();
						platform_fusions.Add (cNewName, to_fuse);
					}
					to_fuse.Add (cRef);
				}
			}

			foreach (KeyValuePair<string,IList<string>> f in platform_fusions) 
			{			
				if (platform_fusions.Count > 1)
				{
					FusionType fusion = new FusionType ();
					body_items.Add (fusion);
					fusion.pRef = f.Key;
					fusion.cRefs = new string[f.Value.Count];
					f.Value.CopyTo (fusion.cRefs, 0);
				}
			}
		}

		static void fuseProxyBindings (IList<object> body_items, string inner_name, IList<Tuple<string, string, EnvironmentPortType, string>> bindings, IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts, IList<string> platforms)
		{
			foreach (Tuple<string, string, EnvironmentPortType, string> binding in bindings) 
			{
				string instance_ref = binding.Item1; // contracts [binding.Item1].component_ref;

				if (platforms.Contains (instance_ref)) continue;
	
				string port_name = binding.Item4;

				string cOldName = binding.Item2;
				string cNewName = port_name;

				if (!cOldName.Equals (cNewName)) 
				{
					InnerRenamingType renaming = new InnerRenamingType ();
					body_items.Add (renaming);
					renaming.cRef = instance_ref;
					renaming.cOldName = cOldName;
					renaming.cNewName = cNewName;
				}

				FusionType fusion = new FusionType ();
				body_items.Add (fusion);
				fusion.cRefs = new string[2];
				fusion.cRefs [0] = instance_ref;
				fusion.cRefs [1] = inner_name;
				fusion.pRef = port_name;
			}
		}

		static InnerComponentType[] addProxyPortPlatform(IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system)
		{
			IList<InnerComponentType> cs = new List<InnerComponentType> ();

			InnerComponentType ci = new InnerComponentType ();

			ci.exposedSpecified = true;
			ci.exposed = true;
			ci.localRef = "platform_SAFe";
			ci.location = "br.ufc.mdcc.hpcshelf.platform.Platform/Platform.hpe";
			ci.multipleSpecified = true;
			ci.multiple = false;
			ci.name = "Platform";
			ci.package = "br.ufc.mdcc.hpcshelf.platform";
			ci.parameter = new ParameterRenaming[1];
			ci.parameter [0] = new ParameterRenaming ();
			ci.parameter[0].formFieldId = "maintainer";
			ci.parameter[0].varName = "MSAFe";
			ci.unitBounds = new UnitBoundsType[1];
			ci.unitBounds [0] = new UnitBoundsType ();
			ci.unitBounds [0].parallelSpecified = true;
			ci.unitBounds [0].parallel = true;
			ci.unitBounds [0].uRef = "node";
			ci.visualDescription = new VisualElementAttributes();
			ci.visualDescription.x = 500;
			ci.visualDescription.y = 500;
			ci.visualDescription.w = 200;
			ci.visualDescription.h = 150;
			ci.visualDescription.color = new ColorComplexType ();
			ci.visualDescription.color.b = 20;
			ci.visualDescription.color.g = 20;
			ci.visualDescription.color.r = 20;

			cs.Add (ci);

			InnerComponentType[] cs_array = new InnerComponentType[cs.Count];
			cs.CopyTo (cs_array, 0);

			return cs_array;
		}

		static void createSystemComponentAbstractInner (string app_name,
		                                                IList<object> body_items, 
			                                            IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
		                                                IDictionary<ProxyComponentAttribute, string> application_attributes,
														IDictionary<ProxyComponentAttribute, string> workflow_attributes, 
														IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application, 
														IList<Tuple<string, string, EnvironmentPortType, string>> bindings_workflow,
														IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system,
														IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task, 
														IList<string> platforms)
		{
			IList<ParameterSupplyType> supply_list = new List<ParameterSupplyType> ();

			// APPLICATION PROXY COMPONENT
			InnerComponentType ci_app = new InnerComponentType ();
			ci_app.package = app_name /*+ "." + arch_ref*/;
			ci_app.name = application_attributes[ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT];
			ci_app.localRef = application_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME]; 
			ci_app.multipleSpecified = true;
			ci_app.multiple = false;
			ci_app.exposedSpecified = true;
			ci_app.exposed = false;

			ci_app.parameter = new ParameterRenaming[1];
			ci_app.parameter [0] = new ParameterRenaming ();
			ci_app.parameter [0].formFieldId = "maintainer";
			ci_app.parameter [0].varName = "M_SAFe";

			ci_app.visualDescription = new VisualElementAttributes();
			ci_app.visualDescription.x = 10;
			ci_app.visualDescription.y = 10;
			ci_app.visualDescription.w = 100;
			ci_app.visualDescription.h = 70;
			ci_app.visualDescription.color = new ColorComplexType ();
			ci_app.visualDescription.color.b = 25;
			ci_app.visualDescription.color.g = 217;
			ci_app.visualDescription.color.r = 217;

			InnerComponentType[] is1a = traverseEnvironmentBindings (contracts, bindings_application, false, platforms);
			InnerComponentType[] is2a = new InnerComponentType[0]; // addProxyPortPlatform(bindings_system);
			ci_app.port = new InnerComponentType[is1a.Length + is2a.Length];
			is1a.CopyTo (ci_app.port, 0);
			is2a.CopyTo (ci_app.port, is1a.Length);

			ci_app.unitBounds = new UnitBoundsType[1];
			ci_app.unitBounds [0] = new UnitBoundsType ();
			ci_app.unitBounds [0].parallelSpecified = true;
			ci_app.unitBounds [0].parallel = true;
			ci_app.unitBounds [0].uRef = application_attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT];
			ci_app.unitBounds [0].visualDescription = new VisualElementAttributes ();
			ci_app.unitBounds [0].visualDescription.x = 10;
			ci_app.unitBounds [0].visualDescription.y = 10;
			ci_app.unitBounds [0].visualDescription.w = 20;
			ci_app.unitBounds [0].visualDescription.h = 30;
			ci_app.unitBounds [0].visualDescription.color = new ColorComplexType ();
			ci_app.unitBounds [0].visualDescription.color.b = 138;
			ci_app.unitBounds [0].visualDescription.color.g = 119;
			ci_app.unitBounds [0].visualDescription.color.r = 215;

			body_items.Add (ci_app);

			// WORKFLOW PROXY COMPONENT
			InnerComponentType ci_wkf = new InnerComponentType ();
			ci_wkf.package = app_name /*+ "." + arch_ref*/;
			ci_wkf.name = workflow_attributes[ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT];
			ci_wkf.localRef = workflow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME]; 
			ci_wkf.multipleSpecified = true;
			ci_wkf.multiple = false;
			ci_wkf.exposedSpecified = true;
			ci_wkf.exposed = false;

			ci_wkf.parameter = new ParameterRenaming[1];
			ci_wkf.parameter [0] = new ParameterRenaming ();
			ci_wkf.parameter [0].formFieldId = "maintainer";
			ci_wkf.parameter [0].varName = "M_SAFe";

			InnerComponentType[] is1 = traverseEnvironmentBindings (contracts, bindings_workflow, false, platforms);
			Tuple<InnerComponentType[],InnerRenamingType[]> is2 = traverseTaskBindings(workflow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME], contracts, bindings_task, false);
			InnerComponentType[] is3 = new InnerComponentType[0]; // addProxyPortPlatform(bindings_system);
			ci_wkf.port = new InnerComponentType[is1.Length + is2.Item1.Length + is3.Length];
			is1.CopyTo (ci_wkf.port, 0);
			is2.Item1.CopyTo (ci_wkf.port, is1.Length);
			is3.CopyTo (ci_wkf.port, is1.Length + is2.Item1.Length);

			foreach (InnerRenamingType task_port_renaming in is2.Item2)
				body_items.Add (task_port_renaming);

			ci_wkf.unitBounds = new UnitBoundsType[1];
			ci_wkf.unitBounds [0] = new UnitBoundsType ();
			ci_wkf.unitBounds [0].parallelSpecified = true;
			ci_wkf.unitBounds [0].parallel = true;
			ci_wkf.unitBounds [0].uRef = workflow_attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT];
			ci_wkf.unitBounds [0].visualDescription = new VisualElementAttributes ();
			ci_wkf.unitBounds [0].visualDescription.x = 10;
			ci_wkf.unitBounds [0].visualDescription.y = 10;
			ci_wkf.unitBounds [0].visualDescription.w = 20;
			ci_wkf.unitBounds [0].visualDescription.h = 30;
			ci_wkf.unitBounds [0].visualDescription.color = new ColorComplexType ();
			ci_wkf.unitBounds [0].visualDescription.color.b = 138;
			ci_wkf.unitBounds [0].visualDescription.color.g = 119;
			ci_wkf.unitBounds [0].visualDescription.color.r = 215;

			ci_wkf.visualDescription = new VisualElementAttributes();
			ci_wkf.visualDescription.x = 10;
			ci_wkf.visualDescription.y = 10;
			ci_wkf.visualDescription.w = 100;
			ci_wkf.visualDescription.h = 70;
			ci_wkf.visualDescription.color = new ColorComplexType ();
			ci_wkf.visualDescription.color.b = 158;
			ci_wkf.visualDescription.color.g = 199;
			ci_wkf.visualDescription.color.r = 235;

			body_items.Add (ci_wkf);

			InnerComponentType ci_maintainer_SAFe = new InnerComponentType ();
			body_items.Add (ci_maintainer_SAFe);
			ci_maintainer_SAFe.localRef = "maintainer_SAFe";
			ci_maintainer_SAFe.location = "br.ufc.mdcc.hpcshelf.platform.maintainer.SAFeHost/SAFeHost.hpe";
			ci_maintainer_SAFe.multipleSpecified = true;
			ci_maintainer_SAFe.multiple = false;
			ci_maintainer_SAFe.name = "SAFeHost";
			ci_maintainer_SAFe.package = "br.ufc.mdcc.hpcshelf.platform.maintainer";
			ci_maintainer_SAFe.exposedSpecified = true;
			ci_maintainer_SAFe.exposed = false;

			ParameterSupplyType supply_maintainer = new ParameterSupplyType ();
			body_items.Add (supply_maintainer);
			supply_maintainer.cRef = "maintainer_SAFe";
			supply_maintainer.direct = true;
			supply_maintainer.varName ="M_SAFe";

			// REGULAR COMPONENTS
			foreach (KeyValuePair<string, Instantiator.ComponentFunctorApplicationType> binding in contracts) 
			{
				if (platforms.Contains (binding.Key))
					continue;					

				string port_name = binding.Key;
				string componentRef = binding.Value.component_ref;

				string package = null, name = null;
				fetchPackageAndName (componentRef, ref package, ref name);

				InnerComponentType ci = new InnerComponentType ();
				ci.package = package;
				ci.name = name;
				ci.localRef = port_name; 
				ci.multipleSpecified = true;
				ci.multiple = false;
				ci.exposedSpecified = true;
				ci.exposed = false;
				ci.parameter = traverseParameters (body_items, binding.Value.argument, supply_list);

				ci.port = traversePorts (componentRef);
				ci.unitBounds = traverseUnits (componentRef);

				ci.visualDescription = new VisualElementAttributes();
				ci.visualDescription.x = 10;
				ci.visualDescription.y = 10;
				ci.visualDescription.w = 100;
				ci.visualDescription.h = 70;
				ci.visualDescription.color = new ColorComplexType ();
				ci.visualDescription.color.b = 255;
				ci.visualDescription.color.g = 255;
				ci.visualDescription.color.r = 0;

				body_items.Add (ci);
			}

			foreach (ParameterSupplyType supply in supply_list)
				body_items.Add (supply);
		}

		private static UnitBoundsType[] traverseUnits (string componentRef)
		{
			List<UnitBoundsType> result_list = new List<UnitBoundsType> ();

			AbstractComponentFunctor acf = BackEnd.acfdao.retrieve_libraryPath (componentRef);
			int id_abstract = acf.Id_abstract;

			IList<Interface> i_list = BackEnd.idao.list (id_abstract);
			foreach (Interface i in i_list) 
			{
				UnitBoundsType u_bound = new UnitBoundsType ();

				u_bound.uRef = i.Id_interface;
				u_bound.parallelSpecified = true;
				u_bound.parallel = i.Is_parallel;

				u_bound.visualDescription = new VisualElementAttributes ();
				u_bound.visualDescription.x = 10;
				u_bound.visualDescription.y = 10;
				u_bound.visualDescription.w = 20;
				u_bound.visualDescription.h = 30;
				u_bound.visualDescription.color = new ColorComplexType ();
				u_bound.visualDescription.color.b = 138;
				u_bound.visualDescription.color.g = 119;
				u_bound.visualDescription.color.r = 215;
					
				result_list.Add (u_bound);
			}

			UnitBoundsType[] result = new UnitBoundsType[result_list.Count];
			result_list.CopyTo (result, 0);
			return result;
		}

		private static InnerComponentType[] traversePorts (string componentRef)
		{
			List<InnerComponentType> result_list = new List<InnerComponentType> ();

			AbstractComponentFunctor acf = BackEnd.acfdao.retrieve_libraryPath (componentRef);
			int id_abstract = acf.Id_abstract;

			IList<InnerComponent> ics = BackEnd.icdao.list (id_abstract);

			int i = 0;
			foreach (InnerComponent ic in ics)
				if (ic.IsPublic) 
				{
					AbstractComponentFunctor acf_port = BackEnd.acfdao.retrieve(ic.Id_abstract_inner);
					string package = null, name = null;
					fetchPackageAndName (acf_port.Library_path, ref package, ref name);

					InnerComponentType port = new InnerComponentType ();
					result_list.Add (port);

					port.localRef = ic.Id_inner;
					port.multipleSpecified = true;
					port.multiple = ic.Multiple;
					port.name = name;
					port.package = package;
					port.exposedSpecified = true;
					port.exposed = false;

					port.visualDescription = new VisualElementAttributes ();
					port.visualDescription.x = (uint) (10 + (i++)*120);
					port.visualDescription.y = 50;
					port.visualDescription.w = 100;
					port.visualDescription.h = 80;
					port.visualDescription.color = new ColorComplexType ();
					port.visualDescription.color.b = 243;
					port.visualDescription.color.g = 217;
					port.visualDescription.color.r = 217;

				}
			
			InnerComponentType[] result = new InnerComponentType[result_list.Count];
			result_list.CopyTo (result, 0);
			return result;
		}


		static void fetchPackageAndName (string componentRef, ref string package, ref string name)
		{
			int pos = componentRef.LastIndexOf ('.');
			package = componentRef.Substring (0, pos);
			name = componentRef.Substring (pos + 1);
		}

		static int count1 = 0;
		static string NextArgumentInner {get { return "__inner__" + (count1++); } }
		static int count2 = 0;
		static string NextVariable {get { return "__VAR__" + (count2++); } }

		static ParameterRenaming[] traverseParameters (IList<object> body_items, Instantiator.ContextArgumentType[] argument_list, IList<ParameterSupplyType> supply_list)
		{
			IList<ParameterRenaming> parameter_renaming_list = new List<ParameterRenaming> ();

			if (argument_list != null)
				foreach (Instantiator.ContextArgumentType argument in argument_list) 
				{
					ParameterRenaming parameter_renaming = new ParameterRenaming ();

					Instantiator.ComponentFunctorApplicationType argument_value = (Instantiator.ComponentFunctorApplicationType)argument.Item;

					string componentRef = argument_value.component_ref;
					string inner_name = NextArgumentInner;

					string package = null, name = null;
					fetchPackageAndName (componentRef, ref package, ref name);

					InnerComponentType ci = new InnerComponentType ();
					body_items.Add (ci);
					ci.package = package;
					ci.name = name;
					ci.localRef = inner_name; 
					ci.multipleSpecified = true;
					ci.multiple = false;
					ci.exposedSpecified = true;
					ci.exposed = false;
					ci.parameter = traverseParameters(body_items, argument_value.argument, supply_list);
					ci.port = traversePorts (componentRef);
					ci.unitBounds = traverseUnits (componentRef);

					ci.visualDescription = new VisualElementAttributes();
					ci.visualDescription.x = 10;
					ci.visualDescription.y = 10;
					ci.visualDescription.w = 170;
					ci.visualDescription.h = 120;
					ci.visualDescription.color = new ColorComplexType ();
					ci.visualDescription.color.b = 20;
					ci.visualDescription.color.g = 20;
					ci.visualDescription.color.r = 20;

					ParameterSupplyType supply = new ParameterSupplyType ();
					supply_list.Add (supply);
					supply.cRef = inner_name;
					supply.direct = true;
					supply.varName = NextVariable;

					parameter_renaming.formFieldId = argument.parameter_id;
					parameter_renaming.varName = supply.varName;

					parameter_renaming_list.Add (parameter_renaming);
				}

			ParameterRenaming[] parameter_return_array = new ParameterRenaming[parameter_renaming_list.Count];
			parameter_renaming_list.CopyTo (parameter_return_array, 0);
			return parameter_return_array;
		}

		static void createSystemComponentAbstractUnit (string app_name, IList<object> body_items,
													   IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts, 
													   IDictionary<string,Instantiator.UnitMappingType[]> c_unit_mapping, 
		                                               IDictionary<ProxyComponentAttribute, string> application_attributes, 
		                                               IDictionary<ProxyComponentAttribute, string> workflow_attributes, 
		                                               IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application, 
		                                               IList<Tuple<string, string, EnvironmentPortType, string>> bindings_workflow,
													   IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system,
													   IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task, 
											           IList<string> platforms)
		{

			IDictionary<int,SliceList> unit_mapping = new Dictionary<int, SliceList> ();

			foreach (KeyValuePair<string,Instantiator.ComponentFunctorApplicationType> kv1 in contracts) 
			{
				Instantiator.ComponentFunctorApplicationType c = kv1.Value;
				string cRef = kv1.Key;
				if (platforms.Contains (cRef)) continue;
				AbstractComponentFunctor acf = backend.DGAC.BackEnd.acfdao.retrieve_libraryPath(c.component_ref);
				if (c_unit_mapping.ContainsKey(kv1.Key))
					foreach (Instantiator.UnitMappingType u in c_unit_mapping[kv1.Key]) 					
					{
						string uRef = u.unit_id;
						string qualified_class_name = backend.DGAC.BackEnd.idao.retrieve (acf.Id_abstract, uRef).Class_name;
						string[] parts_class_name = qualified_class_name.Split (new char[] {'.'});
						string iRef = parts_class_name[parts_class_name.Length-1];

						foreach (int n in u.node) 
						{
							bool hasNode = unit_mapping.ContainsKey (n);
							SliceList units_at_node =  hasNode ? unit_mapping[n] : new SliceList ();

							units_at_node.Value.Add (new Tuple<string, string, string> (cRef, uRef, iRef));
							if (!hasNode)
								unit_mapping.Add (n, units_at_node);
						}
				}
			}

			IDictionary<SliceList, IList<int>> slice_mapping = new Dictionary<SliceList, IList<int>> ();

			SliceList slice_list_root = null; 

			foreach (KeyValuePair<int,SliceList> r in unit_mapping)
			{
				/* The SAFe facet (0) is treated separately. */
				if (r.Key != 0) 
				{
					bool hasSlice = slice_mapping.ContainsKey (r.Value);
					IList<int> node_list = hasSlice ? slice_mapping [r.Value] : new List<int> ();
					node_list.Add (r.Key);
					if (!hasSlice)
						slice_mapping.Add (r.Value, node_list);
				} 
				else 
				{
					slice_list_root = r.Value;
				}
			}

			slice_list_root = slice_list_root == null ? new SliceList () : slice_list_root;

			slice_list_root.Value.Add (new Tuple<string,string,string> (workflow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME],
				                                                        workflow_attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT], 
																	    workflow_attributes[ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT]));
			
			slice_list_root.Value.Add (new Tuple<string,string,string> (application_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME],
																		application_attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT], 
																		application_attributes[ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT]));


			IDictionary<string, IList<Tuple<string,string,string>>> binding_system_by_port = new Dictionary<string, IList<Tuple<string,string,string>>> ();

			foreach (Tuple<string, Tuple<string, string, int>[]> b in bindings_system) 
			{
				string binding_prov_cref = b.Item2 [1].Item1; //if (platforms.Contains(binding_prov_cref)) continue;
				string binding_prov_port = b.Item2 [1].Item2;
				int binding_prov_facet = b.Item2 [1].Item3;
				string binding_prov_unit = unit_of_facet (contracts, binding_prov_cref, binding_prov_facet);

				string binding_user_cref = b.Item2 [0].Item1;
				string binding_user_port = b.Item2 [0].Item2;
				int binding_user_facet = b.Item2 [0].Item3;
				string binding_user_unit = unit_of_facet (contracts, binding_user_cref, binding_user_facet);

				string binding_name = b.Item1;

				string key_user = binding_user_cref + ":" + binding_user_unit;
				string key_prov = binding_prov_cref + ":" + binding_prov_unit;

				if (!platforms.Contains(binding_prov_cref))
				{
					IList<Tuple<string,string,string>> s_user;
					if (!binding_system_by_port.TryGetValue (key_user, out s_user)) {
						s_user = new List<Tuple<string,string,string>> ();
						binding_system_by_port.Add (key_user, s_user);
					}
					s_user.Add (new Tuple<string,string,string> (binding_name, "client", binding_user_port));
					
					IList<Tuple<string,string,string>> s_prov;
					if (!binding_system_by_port.TryGetValue (key_prov, out s_prov)) 
					{
						s_prov = new List<Tuple<string,string,string>> ();
						binding_system_by_port.Add (key_prov, s_prov);
					}
					s_prov.Add (new Tuple<string,string,string> (binding_name, "server", binding_prov_port));
				}
				else
				{
					IList<Tuple<string,string,string>> s_node = new List<Tuple<string,string,string>> ();
					s_node.Add (new Tuple<string,string,string> (binding_prov_cref, "node", binding_prov_port));
					binding_system_by_port.Add (key_user, s_node);
				}
			}

			foreach (Tuple<string, Tuple<string, string, int>[]> b in bindings_task) 
			{
				string binding_name = b.Item1;

				foreach (Tuple<string, string, int> bindings_peer in b.Item2)
				{
					string binding_peer_cref = bindings_peer.Item1;
					string binding_peer_port = bindings_peer.Item2;
					int binding_peer_facet = bindings_peer.Item3;

					string binding_peer_unit = binding_peer_cref.Equals (workflow_attributes [ProxyComponentAttribute.INNER_COMPONENT_NAME]) 
													? workflow_attributes [ProxyComponentAttribute.UNIT_NAME_ABSTRACT] : 
													  unit_of_facet (contracts, binding_peer_cref, binding_peer_facet);

					string key_peer = binding_peer_cref + ":" + binding_peer_unit;

					IList<Tuple<string,string,string>> s_peer;

					if (!binding_system_by_port.TryGetValue (key_peer, out s_peer)) {
						s_peer = new List<Tuple<string,string,string>> ();
						binding_system_by_port.Add (key_peer, s_peer);
					}
					s_peer.Add (new Tuple<string,string,string> (binding_name, "peer",binding_peer_port));
				}
			}

			foreach (Tuple<string, string, EnvironmentPortType, string> slice in bindings_application) 
			{
				string cref = application_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME];
				string port = application_attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT];

				string key_peer = cref + ":" + port;

				IList<Tuple<string,string,string>> s_peer;

				if (!binding_system_by_port.TryGetValue (key_peer, out s_peer)) {
					s_peer = new List<Tuple<string,string,string>> ();
					binding_system_by_port.Add (key_peer, s_peer);
				}

				s_peer.Add (new Tuple<string,string,string> (slice.Item1, slice.Item3 == EnvironmentPortType.platform_user ? "node" : (slice.Item3 == EnvironmentPortType.user ? "client" : "server"), slice.Item4));
			}

			foreach (Tuple<string, string, EnvironmentPortType, string> slice in bindings_workflow) 
			{
				string cref = workflow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME];
				string port = workflow_attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT];

				string key_peer = cref + ":" + port;

				IList<Tuple<string,string,string>> s_peer;

				if (!binding_system_by_port.TryGetValue (key_peer, out s_peer)) {
					s_peer = new List<Tuple<string,string,string>> ();
					binding_system_by_port.Add (key_peer, s_peer);
				}
				s_peer.Add (new Tuple<string,string,string> (slice.Item1, slice.Item3 == EnvironmentPortType.platform_user ? "node" : (slice.Item3 == EnvironmentPortType.user ? "client" : "server"), slice.Item4));

			}

			//int facet_counter = 1;

			// PEER UNITS
			int unit_counter = 0;
			foreach (KeyValuePair<SliceList,IList<int>> r in slice_mapping) 
			{
				string uname = "peer_" + (unit_counter);
				string iname = "IPeer_" + (unit_counter++);

				UnitType cu = new UnitType ();
				body_items.Add (cu);

				//cu.facet = facet_counter++;
				cu.iRef = iname;
				cu.multipleSpecified = true;
				cu.multiple = true;
				cu.privateSpecified = true;
				cu.@private = false;
				cu.replicaSpecified = true;
				cu.replica = 0;
				cu.uRef = uname;   
				cu.visibleInterface = true;

				cu.visualDescription = new VisualElementAttributes();
				cu.visualDescription.x = 10;
				cu.visualDescription.y = 10;
				cu.visualDescription.w = 70;
				cu.visualDescription.h = 40;
				cu.visualDescription.color = new ColorComplexType ();
				cu.visualDescription.color.b = 0;
				cu.visualDescription.color.g = 255;
				cu.visualDescription.color.r = 255;

				InterfaceType ct = new InterfaceType ();
				body_items.Add (ct);

				ct.iRef = iname;
				ct.nArgsSpecified = true;
				ct.nArgs = 0;
				ct.sources = createSystemPeerAbstractSourceCode(app_name, ct.iRef); 

				ct.visualDescription = new VisualElementAttributes();
				ct.visualDescription.x = 10;
				ct.visualDescription.y = 10;
				ct.visualDescription.w = 70;
				ct.visualDescription.h = 40;
				ct.visualDescription.color = new ColorComplexType ();
				ct.visualDescription.color.b = 0;
				ct.visualDescription.color.g = 255;
				ct.visualDescription.color.r = 255;

				IDictionary<Tuple<string,string,string>,int> slice_counter = new Dictionary<Tuple<string,string,string>,int> ();

				IList<UnitSliceType> uslices_list = new List<UnitSliceType> ();
				IList<InterfaceSliceType> islices_list = new List<InterfaceSliceType> ();
				IList<InterfacePortType> iports_list = new List<InterfacePortType> ();

				IDictionary<string,UnitSliceType> check_local_bindings = new Dictionary<string, UnitSliceType> ();
				IDictionary<string,int> count_platform_refs = new Dictionary<string, int> ();

				IDictionary<string, IList<PortSliceType>> ports = new Dictionary<string, IList<PortSliceType>>();

				foreach (Tuple<string,string,string> slice in r.Key.Value) 
				{
					IList<string> slice_port_list = new List<string> ();

					string cRef = slice.Item1;

					bool hasSlice = slice_counter.ContainsKey (slice);
					int slice_replica = hasSlice ? slice_counter [slice] : 0;
					if (hasSlice) slice_counter.Remove (slice);
					slice_counter.Add (slice, slice_replica + 1);

					UnitSliceType us = new UnitSliceType ();
					us.cRef = cRef;
					us.uRef = slice.Item2; 
					us.sliceName = cRef;
					us.slice_replica = slice_replica;
					us.transitiveSpecified = true;
					us.transitive = false;

					us.visualDescription = new VisualElementAttributes();
					us.visualDescription.x = 10;
					us.visualDescription.y = 10;
					us.visualDescription.w = 15;
					us.visualDescription.h = 10;
					us.visualDescription.color = new ColorComplexType ();
					us.visualDescription.color.b = 20;
					us.visualDescription.color.g = 20;
					us.visualDescription.color.r = 20;

					uslices_list.Add (us);


					IList<Tuple<string,string,string>> bs = null;
					if (binding_system_by_port.TryGetValue(slice.Item1 + ":" + slice.Item2, out bs))
					{
						foreach (Tuple<string,string,string> b in bs) 
						{
							string uRef = b.Item2;
							UnitSliceType uss = null;

							if (check_local_bindings.TryGetValue (b.Item1, out uss)) 
								if (uRef.Equals("client") || uRef.Equals("server"))
								{
									uss.uRef = uRef = "client_server";
								    uss.inner_replica = 1;
								}							 

							int n = 0;
							if (platforms.Contains (b.Item1)) 
							{
								if (count_platform_refs.TryGetValue (b.Item1, out n)) 
									count_platform_refs.Remove (b.Item1);
								count_platform_refs[b.Item1] = n+1;
							}

							uss = new UnitSliceType ();
							uslices_list.Add (uss);

							uss.cRef = b.Item1;
							uss.uRef = uRef; 
							uss.sliceName = b.Item1;
							uss.slice_replica = 0;
							uss.inner_replica = n;
							uss.transitiveSpecified = true;
							uss.transitive = true;

							uss.visualDescription = new VisualElementAttributes ();
							uss.visualDescription.x = 10;
							uss.visualDescription.y = 10;
							uss.visualDescription.w = 15;
							uss.visualDescription.h = 10;
							uss.visualDescription.color = new ColorComplexType ();
							uss.visualDescription.color.b = 20;
							uss.visualDescription.color.g = 20;
							uss.visualDescription.color.r = 20;
						
							// PLACE THE UNIT IN THE CORRECT FACET (1,... N). Notice that facet 0 is where the root facet (SAFe) is ...
							if (platforms.Contains (cRef))
								cu.facet = platforms.IndexOf (cRef);

							IList<PortSliceType> ctp_plist = null;
							if (!ports.TryGetValue (b.Item1, out ctp_plist)) {
								ctp_plist = new List<PortSliceType> ();
								ports.Add (b.Item1, ctp_plist);
							}
							PortSliceType ctp_port = new PortSliceType ();

							ctp_port.pRef = b.Item3;
							ctp_port.sRef = slice.Item1;
							ctp_plist.Add (ctp_port);

							if (!check_local_bindings.ContainsKey (b.Item1)) 
								check_local_bindings [b.Item1] = uss;

							if (!slice_port_list.Contains(b.Item1))
								slice_port_list.Add (b.Item1);
						}
					}

					us.port = new string[slice_port_list.Count];
					slice_port_list.CopyTo (us.port, 0);

					if (!platforms.Contains (cRef)) 
					{
						InterfaceSliceType fs = new InterfaceSliceType ();
						islices_list.Add (fs);

						fs.isRef = cRef;
						fs.originRef = new InterfaceRefType ();
						fs.originRef.cRef = cRef;
						fs.originRef.iRef = slice.Item3;

						fs.visualDescription = new VisualElementAttributes ();
						fs.visualDescription.x = 10;
						fs.visualDescription.y = 10;
						fs.visualDescription.w = 15;
						fs.visualDescription.h = 10;
						fs.visualDescription.color = new ColorComplexType ();
						fs.visualDescription.color.b = 20;
						fs.visualDescription.color.g = 20;
						fs.visualDescription.color.r = 20;
					}
				}

				foreach (KeyValuePair<string, IList<PortSliceType>> port_item in ports) 
				{
					InterfacePortType ctp = new InterfacePortType ();
					iports_list.Add (ctp);
					ctp.name = port_item.Key;
					ctp.slice = new PortSliceType[port_item.Value.Count];
					port_item.Value.CopyTo (ctp.slice, 0);
					ctp.visualDescription = new VisualElementAttributes ();
					ctp.visualDescription.x = 10;
					ctp.visualDescription.y = 10;
					ctp.visualDescription.w = 15;
					ctp.visualDescription.h = 10;
					ctp.visualDescription.color = new ColorComplexType ();
					ctp.visualDescription.color.b = 20;
					ctp.visualDescription.color.g = 20;
					ctp.visualDescription.color.r = 20;
				}

				cu.slices = new UnitSliceType[uslices_list.Count];
				uslices_list.CopyTo (cu.slices, 0);

				ct.slice = new InterfaceSliceType[islices_list.Count];
				islices_list.CopyTo (ct.slice, 0);

				ct.port = new InterfacePortType[iports_list.Count];
				iports_list.CopyTo (ct.port, 0);
			}

			IList<UnitSliceType> uslices_root_list = new List<UnitSliceType> ();
			IList<InterfaceSliceType> islices_root_list = new List<InterfaceSliceType> ();

			// ROOT UNIT
			UnitType ru = new UnitType ();
			body_items.Add (ru);

			ru.facet = 0; // platforms.IndexOf ("platform_SAFe");
			ru.iRef = "IRoot";
			ru.multipleSpecified = true;
			ru.multiple = false;
			ru.privateSpecified = true;
			ru.@private = false;
			ru.replicaSpecified = true;
		    ru.replica = 0;
			ru.uRef = "root";   
			ru.visibleInterface = true;

			ru.visualDescription = new VisualElementAttributes();
			ru.visualDescription.x = 10;
			ru.visualDescription.y = 10;
			ru.visualDescription.w = 70;
			ru.visualDescription.h = 40;
			ru.visualDescription.color = new ColorComplexType ();
			ru.visualDescription.color.b = 50;
			ru.visualDescription.color.g = 204;
			ru.visualDescription.color.r = 50;

			// ROOT UNIT INTERFACE
			InterfaceType rt = new InterfaceType ();
			body_items.Add (rt);

			rt.iRef = "IRoot";
			rt.nArgsSpecified = true;
			rt.nArgs = 0;
			rt.sources = createSystemRootAbstractSourceCode(app_name, rt.iRef); 

			rt.visualDescription = new VisualElementAttributes();
			rt.visualDescription.x = 10;
			rt.visualDescription.y = 10;
			rt.visualDescription.w = 70;
			rt.visualDescription.h = 40;
			rt.visualDescription.color = new ColorComplexType ();
			rt.visualDescription.color.b = 50;
			rt.visualDescription.color.g = 204;
			rt.visualDescription.color.r = 153;

			IList<InterfacePortType> iports_root_list = new List<InterfacePortType> ();
			IDictionary<string,int> count_platform_refs_root = new Dictionary<string, int> ();

			IDictionary<string, IList<PortSliceType>> ports_root = new Dictionary<string, IList<PortSliceType>>();

			foreach (Tuple<string,string,string> slice_root in slice_list_root.Value)
			{
				IList<string> slice_port_list_root = new List<string> ();

				string cRef_root = slice_root.Item1;

				int slice_replica_root = 0;

				UnitSliceType u_slice_root = new UnitSliceType ();
				uslices_root_list.Add (u_slice_root);

				u_slice_root.cRef = cRef_root;
				u_slice_root.uRef = slice_root.Item2; 
				u_slice_root.sliceName = cRef_root;
				u_slice_root.slice_replica = 0;
				u_slice_root.transitiveSpecified = true;
				u_slice_root.transitive = false;

				u_slice_root.visualDescription = new VisualElementAttributes();
				u_slice_root.visualDescription.x = 10;
				u_slice_root.visualDescription.y = 10;
				u_slice_root.visualDescription.w = 15;
				u_slice_root.visualDescription.h = 10;
				u_slice_root.visualDescription.color = new ColorComplexType ();
				u_slice_root.visualDescription.color.b = 20;
				u_slice_root.visualDescription.color.g = 20;
				u_slice_root.visualDescription.color.r = 20;

				IList<Tuple<string,string,string>> bs = null;
				if (binding_system_by_port.TryGetValue(slice_root.Item1 + ":" + slice_root.Item2, out bs))
				{
					foreach (Tuple<string,string,string> b in bs) 
					{
						string uRef = b.Item2;
						UnitSliceType uss = null;

						int n = 0;
						if (platforms.Contains (b.Item1)) 
						{
							if (count_platform_refs_root.TryGetValue (b.Item1, out n)) 
								count_platform_refs_root.Remove (b.Item1);
							count_platform_refs_root[b.Item1] = n+1;
						}

						uss = new UnitSliceType ();
						uss.cRef = b.Item1;
						uss.uRef = uRef; 
						uss.sliceName = b.Item1;
						uss.slice_replica = 0;
						uss.inner_replica = n;
						uss.transitiveSpecified = true;
						uss.transitive = true;

						uss.visualDescription = new VisualElementAttributes ();
						uss.visualDescription.x = 10;
						uss.visualDescription.y = 10;
						uss.visualDescription.w = 15;
						uss.visualDescription.h = 10;
						uss.visualDescription.color = new ColorComplexType ();
						uss.visualDescription.color.b = 20;
						uss.visualDescription.color.g = 20;
						uss.visualDescription.color.r = 20;
					
						IList<PortSliceType> ctp_plist = null;
						if (!ports_root.TryGetValue (b.Item1, out ctp_plist)) {
							ctp_plist = new List<PortSliceType> ();
							ports_root.Add (b.Item1, ctp_plist);
						}
						PortSliceType ctp_port = new PortSliceType ();

						ctp_port.pRef = b.Item3;
						ctp_port.sRef = slice_root.Item1;
						ctp_plist.Add (ctp_port);

						if (!slice_port_list_root.Contains(b.Item1))
							slice_port_list_root.Add (b.Item1);

						uslices_root_list.Add (uss);
					}
				}


					
				u_slice_root.port = new string[slice_port_list_root.Count];
				slice_port_list_root.CopyTo (u_slice_root.port, 0);

				// INTERFACE SLICE
				if (!platforms.Contains (cRef_root)) 
				{
					InterfaceSliceType i_slice_root = new InterfaceSliceType ();
					islices_root_list.Add (i_slice_root);

					i_slice_root.isRef = cRef_root;
					i_slice_root.originRef = new InterfaceRefType ();
					i_slice_root.originRef.cRef = cRef_root;
					i_slice_root.originRef.iRef = slice_root.Item3;

					i_slice_root.visualDescription = new VisualElementAttributes();
					i_slice_root.visualDescription.x = 10;
					i_slice_root.visualDescription.y = 10;
					i_slice_root.visualDescription.w = 15;
					i_slice_root.visualDescription.h = 10;
					i_slice_root.visualDescription.color = new ColorComplexType ();
					i_slice_root.visualDescription.color.b = 20;
					i_slice_root.visualDescription.color.g = 20;
					i_slice_root.visualDescription.color.r = 20;
				}
				else
				{
					InterfacePortType fs = new InterfacePortType ();
					iports_root_list.Add (fs);

					fs.name = cRef_root;
					fs.slice = new PortSliceType[2];
					fs.slice[0] = new PortSliceType ();
					fs.slice[0].pRef = application_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME];
					fs.slice[0].sRef = cRef_root;
					fs.slice[1] = new PortSliceType ();
					fs.slice[1].pRef = workflow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME];
					fs.slice[1].sRef = cRef_root;
					fs.visualDescription = new VisualElementAttributes();

					fs.visualDescription.x = 14;
					fs.visualDescription.y = 14;
					fs.visualDescription.w = 30;
					fs.visualDescription.h = 25;
					fs.visualDescription.color = new ColorComplexType ();
					fs.visualDescription.color.b = 20;
					fs.visualDescription.color.g = 20;
					fs.visualDescription.color.r = 20;
				}
			}

			foreach (KeyValuePair<string, IList<PortSliceType>> port_item in ports_root) 
			{
				InterfacePortType ctp = new InterfacePortType ();
				iports_root_list.Add (ctp);
				ctp.name = port_item.Key;
				ctp.slice = new PortSliceType[port_item.Value.Count];
				port_item.Value.CopyTo (ctp.slice, 0);
				ctp.visualDescription = new VisualElementAttributes ();
				ctp.visualDescription.x = 10;
				ctp.visualDescription.y = 10;
				ctp.visualDescription.w = 15;
				ctp.visualDescription.h = 10;
				ctp.visualDescription.color = new ColorComplexType ();
				ctp.visualDescription.color.b = 20;
				ctp.visualDescription.color.g = 20;
				ctp.visualDescription.color.r = 20;
			}

			ru.slices = new UnitSliceType[uslices_root_list.Count];
			uslices_root_list.CopyTo (ru.slices, 0);

			rt.slice = new InterfaceSliceType[islices_root_list.Count];
			islices_root_list.CopyTo (rt.slice, 0);

			rt.port = new InterfacePortType[iports_root_list.Count];
			iports_root_list.CopyTo (rt.port, 0);
		}

		private static string unit_of_facet(IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts, string cref, int facet)
		{
			AbstractComponentFunctor acf = BackEnd.acfdao.retrieve_libraryPath (contracts [cref].component_ref);
			IList<Interface> i_list = BackEnd.idao.list (acf.Id_abstract);

			foreach (Interface i in i_list) 
				if (i.Facet == facet)
					return i.Id_interface;

			return null;
		}


		internal class SliceList
		{
			IList<Tuple<string,string,string>> value = new List<Tuple<string,string,string>>();

			public IList<Tuple<string,string,string>> Value {get { return value; } set { this.value = value; } }

			public override bool Equals(object obj)
			{
				SliceList rrr = obj as SliceList;
				IList<Tuple<string,string,string>> value2 = rrr.Value;

				foreach (Tuple<string,string,string> v1 in value)
					if (!value2.Contains (v1))
						return false;

				return value.Count == value2.Count;
			}

			public override int GetHashCode()
			{
				IOrderedEnumerable<Tuple<string,string,string>> value_ordered = value.OrderBy (x => x.Item1 + x.Item2);

				string key = "";
				foreach (Tuple<string,string,string> v in value_ordered)
					key += v.Item1 + v.Item2;

				return key.GetHashCode();

				//return this.FooId.GetHashCode();
			}
		
		}

		static SourceType[] createSystemPeerAbstractSourceCode (string app_name, string interface_name)
		{
			SourceType[] source_code = new SourceType[1];
			source_code [0] = new SourceType ();
			source_code [0].file = new SourceFileType[1];
			source_code [0].sourceType = "C# Language";
			source_code [0].versionId = "1.0.0.0";
			source_code [0].file [0] = new SourceFileType ();
			source_code [0].file [0].name = interface_name + ".cs";
			source_code [0].file [0].srcType = "user";
			source_code [0].file [0].contents = generate_system_peer_abstract_code(app_name, interface_name);
			//source_code [0].file [0].externalDependency;

			return source_code;
		}

		static string generate_system_peer_abstract_code (string app_name, string interface_name)
		{
			CodeCompileUnit compileUnit = new CodeCompileUnit();

			// * NAMESPACE
			CodeNamespace globalNamespace = new CodeNamespace();		
			compileUnit.Namespaces.Add(globalNamespace);

			CodeNamespace ns = new CodeNamespace(app_name + "." + "System");
			compileUnit.Namespaces.Add(ns);

			// ** INTERFACE
			CodeTypeDeclaration unit_interface = new CodeTypeDeclaration(interface_name);
			unit_interface.IsInterface = true;
			ns.Types.Add(unit_interface);

			// *** INTERFACE BASE TYPES
			unit_interface.BaseTypes.Add ("br.ufc.pargo.hpe.kinds.IApplicationKind");

			return generateCSharpCode (compileUnit, interface_name + ".cs");
		}

		static SourceType[] createSystemRootAbstractSourceCode (string app_name, string interface_name)
		{
			SourceType[] source_code = new SourceType[1];
			source_code [0] = new SourceType ();
			source_code [0].file = new SourceFileType[1];
			source_code [0].sourceType = "C# Language";
			source_code [0].versionId = "1.0.0.0";
			source_code [0].file [0] = new SourceFileType ();
			source_code [0].file [0].name = interface_name + ".cs";
			source_code [0].file [0].srcType = "user";
			source_code [0].file [0].contents = generate_system_root_abstract_code(app_name, interface_name);
			//source_code [0].file [0].externalDependency;

			return source_code;
		}

		static string generate_system_root_abstract_code (string app_name, string interface_name)
		{
			CodeCompileUnit compileUnit = new CodeCompileUnit();

			// * NAMESPACE
			CodeNamespace globalNamespace = new CodeNamespace();		
			compileUnit.Namespaces.Add(globalNamespace);

			CodeNamespace ns = new CodeNamespace(app_name + ".System");
			compileUnit.Namespaces.Add(ns);

			// ** INTERFACE
			CodeTypeDeclaration unit_interface = new CodeTypeDeclaration(interface_name);
			unit_interface.IsInterface = true;
			ns.Types.Add(unit_interface);

			// *** INTERFACE BASE TYPES
			unit_interface.BaseTypes.Add ("br.ufc.pargo.hpe.kinds.IApplicationKind");

			return generateCSharpCode (compileUnit, interface_name + ".cs");
		}


		static ComponentType createSystemConcrete (string app_name, ComponentType system_abstract, 
			                                       IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts)
		{
			ComponentType system_concrete = new ComponentType ();

			ComponentHeaderType h = system_concrete.header = new ComponentHeaderType();
			h.hash_component_UID =  h.GetHashCode().ToString(); //?
			h.isAbstractSpecified = true;
			h.isAbstract = false; 
			h.kindSpecified = true;
			h.kind = SupportedKinds.Application;
			h.name = "SystemImpl"; 
			h.packagePath = app_name + /*"." + arch_ref + */".impl";

			h.baseType = new BaseTypeType ();
			h.baseType.extensionType = new ExtensionTypeType();
			h.baseType.extensionType.Item = true;
			h.baseType.extensionType.ItemElementName = ItemChoiceType.implements;

			h.baseType.component = new ComponentInUseType();
			h.baseType.component.package = app_name /*+ "." + arch_ref*/;
			h.baseType.component.name = "System";
			h.baseType.component.localRef = "base";
			h.baseType.component.multipleSpecified = true;
			h.baseType.component.multiple = false;

			h.baseType.component.visualDescription = new VisualElementAttributes();
			h.baseType.component.visualDescription.x = 10;
			h.baseType.component.visualDescription.y = 10;
			h.baseType.component.visualDescription.w = 250;
			h.baseType.component.visualDescription.h = 150;
			h.baseType.component.visualDescription.color = new ColorComplexType ();
			h.baseType.component.visualDescription.color.b = 20;
			h.baseType.component.visualDescription.color.g = 20;
			h.baseType.component.visualDescription.color.r = 20;

			IList<object> body_items = new List<object> ();

			IDictionary<string,InnerComponentType> c_dict = new Dictionary<string, InnerComponentType> ();

			foreach (object o in system_abstract.componentInfo) 
			{
				if (o is InnerComponentType) 
				{
					InnerComponentType c = (InnerComponentType)o; 
					c_dict.Add (c.localRef, c);
				}
			}

			IDictionary<string,List<UnitType>> u_dict = new Dictionary<string, List<UnitType>> ();

			foreach (object o in system_abstract.componentInfo) 
			{
				if (o is UnitType) 
				{
					UnitType u = (UnitType)o; 

					UnitType cu = new UnitType ();

					cu.facet = 0;
					cu.iRef = u.iRef + "Impl";
					cu.multipleSpecified = true;
					cu.multiple = false;
					cu.privateSpecified = true;
					cu.@private = false;
					cu.replicaSpecified = true;
					cu.replica = 0;
					cu.uRef = u.uRef;   
					cu.visibleInterface = true;

					UnitRefType uRef = new UnitRefType ();
					uRef.cRef = "base";
					uRef.uRef = u.uRef;
					cu.super = new UnitRefType[1];
					cu.super[0] = uRef;

					cu.visualDescription = new VisualElementAttributes();
					cu.visualDescription.x = 10;
					cu.visualDescription.y = 10;
					cu.visualDescription.w = 130;
					cu.visualDescription.h = 90;
					cu.visualDescription.color = new ColorComplexType ();
					cu.visualDescription.color.b = 20;
					cu.visualDescription.color.g = 20;
					cu.visualDescription.color.r = 20;

					body_items.Add (cu);

					List<UnitType> u_list;
					if (!u_dict.TryGetValue (u.iRef, out u_list))
						u_list = new List<UnitType> ();
					u_list.Add (u);
					u_dict.Add (u.iRef, u_list);
				}
			}

			foreach (object o in system_abstract.componentInfo) 
			{
                if (o is InterfaceType) 
				{
					InterfaceType i = (InterfaceType)o;

					InterfaceType ct = new InterfaceType ();

					ct.iRef = i.iRef + "Impl";
					ct.nArgsSpecified = true;
					ct.nArgs = 0;
					ct.sources = createSystemPeerConcreteSourceCode(app_name, i.iRef, i.slice, c_dict, u_dict, contracts, new List<Tuple<string, string, EnvironmentPortType, string>>()); //?

					ct.visualDescription = new VisualElementAttributes();
					ct.visualDescription.x = 10;
					ct.visualDescription.y = 10;
					ct.visualDescription.w = 120;
					ct.visualDescription.h = 80;
					ct.visualDescription.color = new ColorComplexType ();
					ct.visualDescription.color.b = 20;
					ct.visualDescription.color.g = 20;
					ct.visualDescription.color.r = 20;

					body_items.Add (ct);
				}
			}

			system_concrete.componentInfo = new object[body_items.Count];
			body_items.CopyTo (system_concrete.componentInfo, 0);

			return system_concrete;
		}

		static SourceType[] createSystemPeerConcreteSourceCode (string app_name, 
			                                                    string interface_name, 
			                                                    InterfaceSliceType[] slice_list, 
			                                                    IDictionary<string,InnerComponentType> c_dict, 
			                                                    IDictionary<string,List<UnitType>> u_dict,
			                                                    IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
			                                                    IList<Tuple<string, string, EnvironmentPortType, string>> bindings)
		{
			SourceType[] source_code = new SourceType[1];
			source_code [0] = new SourceType ();
			source_code [0].sourceType = "C# Language";
			source_code [0].versionId = "1.0.0.0";
			source_code [0].file = new SourceFileType[1];

			source_code [0].file [0] = new SourceFileType ();
			source_code [0].file [0].name = interface_name + "Impl.cs";
			source_code [0].file [0].contents = generate_system_peer_concrete_code_user (app_name, interface_name, slice_list, c_dict, u_dict, contracts, bindings);
			source_code [0].file [0].srcType = "user";
				
			//source_code [0].file [0].externalDependency;

			return source_code;
		}

		static string generate_system_peer_concrete_code_user (string app_name, 
			                                                   string interface_name, 
			                                                   InterfaceSliceType[] slice_list, 
			                                                   IDictionary<string,InnerComponentType> c_dict, 
			                                                   IDictionary<string,List<UnitType>> u_dict,
			                                                   IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
			                                                   IList<Tuple<string, string, EnvironmentPortType, string>> bindings)
		{
			CodeCompileUnit compileUnit = new CodeCompileUnit();

	
			// * NAMESPACE
			CodeNamespace globalNamespace = new CodeNamespace();		
			compileUnit.Namespaces.Add(globalNamespace);

			globalNamespace.Imports.Add (new CodeNamespaceImport ("System"));
			globalNamespace.Imports.Add (new CodeNamespaceImport ("System.Threading"));
			globalNamespace.Imports.Add (new CodeNamespaceImport ("br.ufc.pargo.hpe.kinds"));
			foreach (InterfaceSliceType slice in slice_list) 
				if (contracts.ContainsKey(slice.originRef.cRef))
				{
					globalNamespace.Imports.Add (new CodeNamespaceImport (contracts [slice.originRef.cRef].component_ref));
				}
			globalNamespace.Imports.Add(new CodeNamespaceImport (app_name + ".System"));

			if (interface_name.Equals ("IRoot")) 
			{
				globalNamespace.Imports.Add (new CodeNamespaceImport (app_name + ".Workflow"));
				globalNamespace.Imports.Add (new CodeNamespaceImport (app_name + ".Application"));
			}


			CodeNamespace ns = new CodeNamespace(app_name + ".impl.SystemImpl");
			compileUnit.Namespaces.Add(ns);

			// ** CLASS
			CodeTypeDeclaration unit_class = new CodeTypeDeclaration(interface_name + "Impl");
			unit_class.IsClass = true;
			ns.Types.Add(unit_class);

			// *** CLASS BASE TYPES
			unit_class.BaseTypes.Add ("br.ufc.pargo.hpe.kinds.Application");
			unit_class.BaseTypes.Add (interface_name);

			// *** BUILD SLICES DICTIONARY ...

			IDictionary<string, Tuple<string,string>> server_port_dict = new Dictionary<string, Tuple<string,string>> ();
			IDictionary<string, Tuple<string,string,string>> client_port_dict = new Dictionary<string, Tuple<string, string,string>> ();
			foreach (Tuple<string, string, EnvironmentPortType, string> binding in bindings) 
			{
				string componentRef = binding.Item1;
				string port_name_inner = binding.Item2;
				string port_name_app = binding.Item4;
				EnvironmentPortType port_role = binding.Item3;

				// look for the type of the component connected to the application through the environment port
				AbstractComponentFunctor acf = backend.DGAC.BackEnd.acfdao.retrieve_libraryPath (componentRef);

				// look for the type of the environment port in the inner component.
				InnerComponent ic = backend.DGAC.BackEnd.icdao.retrieve (acf.Id_abstract, port_name_inner);
				AbstractComponentFunctor acf_inner = backend.DGAC.BackEnd.acfdao.retrieve (ic.Id_abstract_inner);

				string binding_library_path = acf_inner.Library_path; 

				IList<Interface> iList = backend.DGAC.BackEnd.idao.list (acf_inner.Id_abstract);
				foreach (Interface i in iList)
				{
					string id_interface_base = i.Id_interface_super_top;
					if (id_interface_base.Equals ("client") && port_role == EnvironmentPortType.user) 
					{
						// look for the type of the user interface
						string binding_type = i.Class_name;

						// look for the argument that defines the type of the port
						SupplyParameterComponent spc = backend.DGAC.BackEnd.spcdao.retrieve ("client_port_type", acf_inner.Id_functor_app_supertype);
						Interface i_port = backend.DGAC.BackEnd.idao.list (spc.Id_abstract)[0];
						string port_type = i_port.Class_name;  

						client_port_dict.Add(port_name_app,new Tuple<string, string, string>(binding_library_path, binding_type, port_type));
					} 
					else if (id_interface_base.Equals ("server") && port_role == EnvironmentPortType.provider) 
					{
						// look for the type of the user interface
						string binding_type = i.Class_name;

						// look for the argument that defines the type of the port
						SupplyParameterComponent spc = backend.DGAC.BackEnd.spcdao.retrieve ("server_port_type", acf_inner.Id_functor_app_supertype);
						Interface i_port = backend.DGAC.BackEnd.idao.list (spc.Id_abstract)[0];
						string port_type = i_port.Class_name;  

						server_port_dict.Add(port_name_app,new Tuple<string, string>(binding_type, port_type));
					}
				}
			}

			CodeMemberMethod go_method = new CodeMemberMethod();
			unit_class.Members.Add (go_method);

			go_method.Name = "Go";
			go_method.Attributes = MemberAttributes.Private;

			CodeParameterDeclarationExpression parameter_go = new CodeParameterDeclarationExpression (new CodeTypeReference("Object"), "o");
			go_method.Parameters.Add(parameter_go);

			var go_statements = go_method.Statements;

			CodeVariableReferenceExpression target_go_object = new CodeVariableReferenceExpression ("o");
			CodeCastExpression target_casted_go_object = new CodeCastExpression ("Activate", target_go_object);
			CodeMethodInvokeExpression invokeGoExpression = new CodeMethodInvokeExpression(target_casted_go_object, "go"); ;
			go_statements.Add (invokeGoExpression);

			// *** CLASS MAIN METHOD

			CodeMemberMethod main_method = new CodeMemberMethod();
			unit_class.Members.Add (main_method);

			main_method.Name = "main";
			main_method.Attributes = MemberAttributes.Override | MemberAttributes.Public;

			var main_statements = main_method.Statements;

			foreach (InterfaceSliceType slice in slice_list) 
			{
				// IMapper mapper = this.Services.getPort("mapper");
				CodePropertyReferenceExpression target_object1 = new CodePropertyReferenceExpression (new CodeThisReferenceExpression(), "Services");
				CodeExpression[] parameters1 = new CodeExpression[1];
				parameters1 [0] = new CodePrimitiveExpression (slice.isRef);
				CodeMethodInvokeExpression initExpression1 = new CodeMethodInvokeExpression(target_object1, "getPort", parameters1); 
				string u_ref = null;
				foreach (UnitSliceType u_slice in u_dict [interface_name] [0].slices) 
				{
					if (u_slice.sliceName.Equals(slice.isRef))
					{
						u_ref = u_slice.uRef;
						break;
					}
				}
						 
				CodeTypeReference type_reference_1 = contracts.ContainsKey (slice.originRef.cRef) ? 
					                                     setArgumentsOfInterface(slice.originRef.iRef, u_ref, contracts [slice.originRef.cRef])
					                                   : new CodeTypeReference(slice.originRef.iRef);
				CodeCastExpression initExpression0 = new CodeCastExpression(type_reference_1,initExpression1);
				CodeVariableDeclarationStatement decl1 = new CodeVariableDeclarationStatement(type_reference_1, slice.isRef, initExpression0);
				main_statements.Add (decl1);

				// Thread go_mapper = new Thread(new ParameterizedThreadStart(Go));
				CodeTypeReference createType31 = new CodeTypeReference("ParameterizedThreadStart");
				CodeObjectCreateExpression initExpression21 = new CodeObjectCreateExpression(createType31, new CodeExpression[1] {new CodeMethodReferenceExpression(new CodeThisReferenceExpression(),"Go")});

				CodeTypeReference createType32 = new CodeTypeReference("Thread");
				CodeObjectCreateExpression initExpression22 = new CodeObjectCreateExpression(createType32, new CodeExpression[1] {initExpression21});

				CodeVariableDeclarationStatement decl2 = new CodeVariableDeclarationStatement ("Thread", "go_" + slice.isRef, initExpression22);
				main_statements.Add (decl2);

				// go_mapper.Start(mapper);
				CodeVariableReferenceExpression target_object3 = new CodeVariableReferenceExpression("go_" + slice.isRef);
				CodeExpression[] parameters3 = new CodeExpression[1];
				parameters1 [0] = new CodeVariableReferenceExpression (slice.isRef);
				CodeMethodInvokeExpression invokeExpression3 = new CodeMethodInvokeExpression(target_object3, "Start", parameters1); ;
				main_statements.Add (invokeExpression3);
			}

			foreach (InterfaceSliceType slice in slice_list) 
			{			
				CodeMethodReferenceExpression method4 = new CodeMethodReferenceExpression(new CodeVariableReferenceExpression("go_" + slice.isRef), "Join");
				CodeMethodInvokeExpression invokeExpression4 = new CodeMethodInvokeExpression(method4,new CodeExpression[0]);
				main_statements.Add (invokeExpression4);
			}


			// PUBLISH the PORT METHODS TO THE WEB SERVICE via WCF.
			foreach (KeyValuePair<string, Tuple<string,string,string>> port in client_port_dict)
			{
				string port_name = port.Key;
				string binding_library_path = port.Value.Item1; // e.g. br.ufc.mdcc.hpc.storm.binding.environment.impl.BindingMbyNIntraExample
				string binding_type = port.Value.Item2;         // e.g. br.ufc.mdcc.hpc.storm.binding.environment.impl.BindingMbyNIntraExample.IBindingMyNIntraExampleClient
				string port_type = port.Value.Item3;            // e.g. br.ufc.mdcc.hpc.storm.binding.environment.example.MbyN.EnvironmentPortTypeClient.IMbyNClientPortTypeExample

				// BINDING_TYPE unit = this.Services.getPort (PORT_NAME);
				CodePropertyReferenceExpression target_object1 = new CodePropertyReferenceExpression (new CodeThisReferenceExpression(), "Services");
				CodeExpression[] parameters1 = new CodeExpression[1];
				parameters1 [1] = new CodePrimitiveExpression (port_name);
				CodeMethodInvokeExpression initExpression1 = new CodeMethodInvokeExpression(target_object1, "getPort", parameters1); ;
				CodeVariableDeclarationStatement decl1 = new CodeVariableDeclarationStatement (binding_type, "unit", initExpression1);
				main_statements.Add (decl1);

				// publishBindingService(<app_session_id>, unit.Service, typeof (PORT_TYPE), address, <binding_type_library_path>);
				var parameters2 = new CodeExpression[4];
				parameters2 [0] = null; // TODO : session id (system id) getHashCode ?
				parameters2 [1] = new CodePropertyReferenceExpression (new CodeVariableReferenceExpression ("unit"), "Service");
				parameters2 [2] = new CodeTypeOfExpression (port_type);
				parameters2 [3] = new CodePrimitiveExpression(binding_library_path + Path.PathSeparator + binding_type); 
				var method_invocation2 = new CodeMethodInvokeExpression (new CodeThisReferenceExpression (), "publishBindingService", parameters2);
				main_statements.Add (method_invocation2);
			}

			// CONNECT TO THE PORT METHODS.
			// TODO: ???
			foreach (KeyValuePair<string, Tuple<string,string>> port in server_port_dict) 
			{
				string port_name = port.Key;
				string binding_type = port.Value.Item1;         // e.g. br.ufc.mdcc.hpc.storm.binding.environment.impl.BindingMbyNIntraExample.IBindingMyNIntraExampleClient
				string port_type = port.Value.Item2;            // e.g. br.ufc.mdcc.hpc.storm.binding.environment.example.MbyN.EnvironmentPortTypeClient.IMbyNClientPortTypeExample

				// BINDING_TYPE unit = this.Services.getPort (PORT_NAME);
				CodePropertyReferenceExpression target_object1 = new CodePropertyReferenceExpression (new CodeThisReferenceExpression (), "Services");
				CodeExpression[] parameters1 = new CodeExpression[1];
				parameters1 [1] = new CodePrimitiveExpression (port_name);
				CodeMethodInvokeExpression initExpression1 = new CodeMethodInvokeExpression (target_object1, "getPort", parameters1);
				CodeVariableDeclarationStatement decl1 = new CodeVariableDeclarationStatement (binding_type, "unit", initExpression1);
				main_statements.Add (decl1);

				// PORT_TYPEStub server_stub = new PORT_TYPEStub();
				string port_stub_type = port_type + "Stub";
				var create_stub = new CodeObjectCreateExpression (port_stub_type);
				var declare_stub_variable = new CodeVariableDeclarationStatement (port_stub_type + "Stub", "server_stub", create_stub);
				main_statements.Add (declare_stub_variable);

				// unit.Service = server_stub
				var service_property = new CodePropertyReferenceExpression(new CodeVariableReferenceExpression("unit"),"Service");
				var assign_service = new CodeAssignStatement (service_property, new CodeVariableReferenceExpression("server_stub"));
				main_statements.Add (assign_service);
			}

			return generateCSharpCode (compileUnit, interface_name + "Impl.cs");
		}

		private static CodeTypeReference setArgumentsOfInterface(string i_ref, string c_ref, Instantiator.ComponentFunctorApplicationType context_arguments)
		{
			IDictionary<int, CodeTypeReference> type_arguments_list = new Dictionary<int, CodeTypeReference>();

			AbstractComponentFunctor acf = BackEnd.acfdao.retrieve_libraryPath (context_arguments.component_ref);

			IDictionary<string, Instantiator.ContextArgumentType> arg_dict = new Dictionary<string, Instantiator.ContextArgumentType> ();
			if (context_arguments.argument != null)
				foreach (Instantiator.ContextArgumentType arg in context_arguments.argument) 
					arg_dict.Add (arg.parameter_id, arg);

			IList<InterfaceParameter> ip_list = BackEnd.ipdao.list (acf.Id_abstract, c_ref);
			foreach (InterfaceParameter ip in ip_list)
			{
				Instantiator.ComponentFunctorApplicationType arg = (Instantiator.ComponentFunctorApplicationType) arg_dict [ip.ParId].Item;

				AbstractComponentFunctor acf_par =  BackEnd.acfdao.retrieve_libraryPath(arg.component_ref);
				Interface i_par = BackEnd.idao.retrieveSuper (acf_par.Id_abstract, ip.Id_unit_parameter);

				string interface_parameter = i_par.Class_name;
				string unit_parameter = ip.Id_unit_parameter;
				CodeTypeReference argument = setArgumentsOfInterface (interface_parameter, unit_parameter, arg);
			
				type_arguments_list.Add (ip.ParOrder, argument);
			}

			CodeTypeReference[] type_arguments_1 = new CodeTypeReference[type_arguments_list.Count];
			foreach (KeyValuePair<int,CodeTypeReference> kv in type_arguments_list) 
				type_arguments_1[kv.Key] = kv.Value;

			CodeTypeReference r = new CodeTypeReference (i_ref, type_arguments_1);
			return r;
		}
		/*
		public static void deploySystemComponent(SAFeSWL.Architecture workflow_architecture, IDictionary<string,Instantiator.UnitMappingType[]> all_unit_mapping) 
		{
			string app_name = null;
			string application_component_name = null;
			string workflow_component_name = null;
				IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application = null; 
			IList<Tuple<string, string, EnvironmentPortType, string>> bindings_workflow = null; 
			IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system = null;
			IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task = null;
			IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts = null;
			IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping = null;

			readArchitecture (workflow_architecture, 
				              null, // TODO: Which platform ???
							  null,
				              null,
				              ref app_name,
							  ref application_component_name,
							  ref workflow_component_name,
							  ref bindings_application, 
							  ref bindings_workflow,
				              ref bindings_system,
				              ref bindings_task,
				              ref contracts, 
				              ref unit_mapping);

			var system = createSystemComponent (app_name, null, application_component_name, workflow_component_name, contracts, all_unit_mapping, bindings_application, bindings_workflow, bindings_system, bindings_task); 

			ComponentType application_abstract = system.Item1.Item1;
			ComponentType application_concrete = system.Item1.Item2;
			ComponentType workflow_abstract = system.Item2.Item1;
			ComponentType workflow_concrete = system.Item2.Item2;
			ComponentType system_abstract = system.Item3.Item1;
			ComponentType system_concrete = system.Item3.Item2;

			try 
			{
				br.ufc.pargo.hpe.backend.DGAC.database.Connector.openConnection();
				br.ufc.pargo.hpe.backend.DGAC.database.Connector.beginTransaction();

				BackEnd.registerAbstractComponent (application_abstract);
				BackEnd.registerAbstractComponent (workflow_abstract);
				BackEnd.registerAbstractComponent (system_abstract);

				BackEnd.registerConcreteComponent (application_concrete);
				BackEnd.registerConcreteComponent (workflow_concrete);
				BackEnd.registerConcreteComponent (system_concrete);

				br.ufc.pargo.hpe.backend.DGAC.database.Connector.commitTransaction(); // if it is ok, commit ...
			}
			catch (Exception e)
			{
				Console.Error.Write("Rolling back transaction... " +  e.Message + " ----- stack:"+  e.StackTrace);
				br.ufc.pargo.hpe.backend.DGAC.database.Connector.rollBackTransaction();
				throw e;
			}
			finally
			{
				br.ufc.pargo.hpe.backend.DGAC.database.Connector.closeConnection();
			}
		}
*/
		public static IDictionary<string,int[]> componentsInPlatform (SAFeSWL.Architecture arch_desc, string platform_ref)
		{
			IDictionary<string,int[]> result = new Dictionary<string, int[]>();

			IDictionary<string,Tuple<int,string>[]> cs_placements = placementOfComponents (arch_desc);
			foreach (KeyValuePair<string,Tuple<int,string>[]> c_placement in cs_placements) 
			{
				IList<int> facet_list = new List<int>();
				foreach (Tuple<int,string> p in c_placement.Value) 
				{
					if (p.Item2.Equals (platform_ref)) 
					{
						facet_list.Add (p.Item1);
					}
				}
				if (facet_list.Count > 0) 
				{
					int[] facets = new int[facet_list.Count];
					facet_list.CopyTo (facets, 0);
					result.Add (c_placement.Key, facets);
				}
			}

			return result;
		}

		/* Placement of components and bindings */
		public static IDictionary<string,Tuple<int,string>[]> placementOfComponents (SAFeSWL.Architecture arch_desc)
		{
			IDictionary<string, Tuple<int,string>[]> result_1 = placementOfComputationsAndConnectors (arch_desc);
			result_1.Add (arch_desc.application.name, new Tuple<int,string>[1]{new Tuple<int, string>(0, "platform_SAFe")});
			result_1.Add (arch_desc.workflow.name, new Tuple<int,string>[1]{new Tuple<int, string>(0, "platform_SAFe")});
			IDictionary<string, Tuple<int,string>[]> result_2 = placementOfEnvironmentBindings (arch_desc, result_1);
			IDictionary<string, Tuple<int,string>[]> result_3 = placementOfTaskBindings (arch_desc, result_1);

			foreach (KeyValuePair<string,Tuple<int,string>[]> kv in result_2)
				result_1.Add (kv);

			foreach (KeyValuePair<string,Tuple<int,string>[]> kv in result_3)
				result_1.Add (kv);

			return result_1;
		}

		public static IDictionary<string,Tuple<int,string>[]> placementOfEnvironmentBindings (SAFeSWL.Architecture arch_desc, IDictionary<string, Tuple<int,string>[]> placement)
		{
			IDictionary<string, Tuple<int,string>[]> result = new Dictionary<string, Tuple<int,string>[]> ();

			IDictionary<int, SAFeSWL.Component> cids = getComponentsOfArchitecture (arch_desc);

			BindingEnvironment[] bs = arch_desc.env_binding;
			foreach (BindingEnvironment b in bs) 
			{
				SAFeSWL.Component user_partner = b.uses_port.id_component == arch_desc.application.id ? 
					arch_desc.application : 
					cids [b.uses_port.id_component];

				SAFeSWL.Component prov_parnter = b.provides_port.id_component == arch_desc.application.id ? 
					arch_desc.application : 
					cids [b.provides_port.id_component];
				if (!(prov_parnter is SAFeSWL.Platform)) 
				{
					string user_place = placement [user_partner.name] [b.uses_port.facet].Item2;
					string prov_place = placement [prov_parnter.name] [b.provides_port.facet].Item2;

					if (user_place.Equals (prov_place))
						result.Add (b.name, new Tuple<int,string>[1] { new Tuple<int, string> (0, user_place) });
					else
						result.Add (b.name, new Tuple<int,string>[2] { new Tuple<int, string> (0, user_place), 
							new Tuple<int, string> (1, prov_place)
						});
				}
			}

			return result;
		}

		public static IDictionary<string,Tuple<int,string>[]> placementOfTaskBindings (SAFeSWL.Architecture arch_desc, IDictionary<string, Tuple<int,string>[]> placement)
		{
			IDictionary<string, Tuple<int,string>[]> result = new Dictionary<string, Tuple<int,string>[]> ();

			IDictionary<int, SAFeSWL.Component> cids = getComponentsOfArchitecture (arch_desc);

			BindingTask[] bs = arch_desc.task_binding;
			foreach (BindingTask b in bs) 
			{
				IList<Tuple<int,string>> binding_platforms = new List<Tuple<int, string>> (); 

				int i = 0;
				foreach (PortTask port in b.peer) 
				{
					SAFeSWL.Component peer_partner = cids[port.id_component];
					string peer_place = placement[peer_partner.name][port.facet].Item2;
					binding_platforms.Add (new Tuple<int, string> (i++,peer_place));
				}
				Tuple<int,string>[] binding_platforms_array = new Tuple<int, string>[binding_platforms.Count];
				binding_platforms.CopyTo (binding_platforms_array, 0);

				result.Add (b.name, binding_platforms_array);
			}

			return result;
		}

		public static IDictionary<string, IDictionary<string, BindingEnvironment>> bindingsOfComponentInArchitecture (SAFeSWL.Architecture arch_desc)
		{
			IDictionary<string, IDictionary<string, BindingEnvironment>> result = new Dictionary<string, IDictionary<string, BindingEnvironment>> ();

			SAFeSWL.BindingEnvironment[] bs = arch_desc.env_binding;
			SAFeSWL.Component[] cs = arch_desc.body;
			foreach (SAFeSWL.Component c in cs) 
				if (!(c is SAFeSWL.Platform))
				{
					foreach (SAFeSWL.BindingEnvironment b in bs)
					{
						if (c.id == b.uses_port.id_component || c.id == b.provides_port.id_component) 
						{
							string port_name = c.id == b.uses_port.id_component ? b.uses_port.name : b.provides_port.name;
							IDictionary<string, BindingEnvironment> bindings_of_c;
							if (!result.TryGetValue (c.name, out bindings_of_c))
							{
								bindings_of_c = new Dictionary<string, BindingEnvironment> ();
								result.Add (c.name, bindings_of_c);
							}

							bindings_of_c.Add (port_name, b);
						}

					}
				}

			return result;
		}

		public static IDictionary<string,Tuple<int,string>[]> placementOfComputationsAndConnectors (SAFeSWL.Architecture arch_desc)
		{
			IDictionary<string, Tuple<int,string>[]> result = new Dictionary<string, Tuple<int,string>[]> ();

			IDictionary<int, SAFeSWL.Component> cids = getComponentsOfArchitecture (arch_desc);
			IDictionary<string, IDictionary<string, BindingEnvironment>> bs = bindingsOfComponentInArchitecture (arch_desc);

			/* TODO: Take repository into consideration. Repositories are platforms with a service for accessing data. */

			// Take the platform of each computation component
			SAFeSWL.Component[] cs = arch_desc.body;
			foreach (SAFeSWL.Component c in cs) 
			{
				if (c is SAFeSWL.Computation) 
				{
					BindingEnvironment b = bs [c.name]["platform"];
					SAFeSWL.Component c_platform = cids[b.provides_port.id_component];
					result.Add (c.name, new Tuple<int,string>[1] { new Tuple<int,string>(0, c_platform.name) });
				}
			}


			IDictionary<string, IDictionary<int,IList<string>>> connector_places = new Dictionary<string, IDictionary<int,IList<string>>> ();

			// Take the platforms of each connector component in connector_places
			foreach (SAFeSWL.Component c in cs) 
			{
				if (c is SAFeSWL.Connector) 
				{
					IDictionary<string, BindingEnvironment> bindings_of_c = bs [c.name];
					foreach (BindingEnvironment binding_of_c in bindings_of_c.Values) 
					{
						PortEnvironment port_of_other_c = binding_of_c.uses_port.id_component == c.id ? (PortEnvironment) binding_of_c.provides_port : (PortEnvironment) binding_of_c.uses_port;
						PortEnvironment port_of_c = binding_of_c.uses_port.id_component != c.id ? (PortEnvironment) binding_of_c.provides_port : (PortEnvironment) binding_of_c.uses_port;
						Debug.Assert (port_of_other_c.id_component != c.id);
						SAFeSWL.Component other_c = cids[port_of_other_c.id_component];
						if (other_c is SAFeSWL.Computation) 
						{
							IDictionary<int,IList<string>> places;
							if (!connector_places.TryGetValue (c.name, out places)) 
							{
								places = new Dictionary<int,IList<string>> ();
								connector_places.Add (c.name, places);
							}
							string platform = result [other_c.name][0].Item2;
							IList<string> platform_list;
							if (!places.TryGetValue (port_of_c.facet, out platform_list)) 
							{
								platform_list = new List<string> ();
								places.Add (port_of_c.facet, platform_list);
							}
							platform_list.Add (platform);
						}
					}
				}
			}

			// sorting placement list by facet.
			foreach (KeyValuePair<string,IDictionary<int,IList<string>>> placement in connector_places) 
			{
				string c_name = placement.Key;
				IDictionary<int,IList<string>> c_places = placement.Value;
				int count = 0;
				foreach (IList<string> facet_places in c_places.Values) 
					count += facet_places.Count;

				Tuple<int,string>[] c_places_array = new Tuple<int,string>[count];

				// Sort by facets.
				IList<string>[] facet_places_array = new IList<string>[c_places.Count];
				foreach (KeyValuePair<int,IList<string>> facet_places in c_places)
					facet_places_array [facet_places.Key] = facet_places.Value;

				// Calculate facet instances.
				int facet_instance = 0;
				for (int facet = 0; facet < facet_places_array.Length; facet++)
					foreach (string platform in facet_places_array[facet])
						c_places_array [facet_instance++] = new Tuple<int, string> (facet, platform);

				result.Add (c_name, c_places_array);
			}

			return result;
		}

		private static IDictionary<int, SAFeSWL.Component> getComponentsOfArchitecture (SAFeSWL.Architecture arch_desc)
		{
			IDictionary<int, SAFeSWL.Component> result = new Dictionary<int, SAFeSWL.Component> ();

			result.Add (arch_desc.application.id, arch_desc.application);
			result.Add (arch_desc.workflow.id, arch_desc.workflow);

			SAFeSWL.Component[] cs = arch_desc.body;
			foreach (SAFeSWL.Component c in cs) 
				result.Add (c.id, c);

			return result;
		}

		private static IDictionary<string, SAFeSWL.Component> getComponentsOfArchitectureByName (SAFeSWL.Architecture arch_desc)
		{
			IDictionary<string, SAFeSWL.Component> result = new Dictionary<string, SAFeSWL.Component> ();

			result.Add (arch_desc.application.name, arch_desc.application);
			result.Add (arch_desc.workflow.name, arch_desc.workflow);

			SAFeSWL.Component[] cs = arch_desc.body;
			foreach (SAFeSWL.Component c in cs) 
				result.Add (c.name, c);

			return result;
		}
			

		public static void readArchitecture
								 (SAFeSWL.Architecture workflow_architecture,
							      IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts,
								  IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping,
		                          ref string app_name,
								  ref string application_component_name,
								  ref string workflow_component_name,
								  ref IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application,
							      ref IList<Tuple<string, string, EnvironmentPortType, string>> bindings_workflow, 
								  ref IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system,
			                      ref IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task,
			                      ref IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts_in_platform,
			                      ref IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping_in_platform,
			                      ref IList<string> platform_list)
		{
			app_name = workflow_architecture.application_name;
			workflow_component_name = workflow_architecture.workflow.name;
			application_component_name = workflow_architecture.application.name;

			bindings_application = new List<Tuple<string, string, EnvironmentPortType, string>> ();
			bindings_workflow = new List<Tuple<string, string, EnvironmentPortType, string>> ();
			bindings_system = new List<Tuple<string, Tuple<string, string,int>[]>> ();
			contracts_in_platform = new Dictionary<string,Instantiator.ComponentFunctorApplicationType> ();
			platform_list = new List<string> ();
			//platform_list.Add ("platform_SAFe");

			SAFeSWL.Component application_component = workflow_architecture.application;
			SAFeSWL.Component workflow_component = workflow_architecture.workflow;

			IDictionary<int, string> uses_port_ownership = new Dictionary<int, string> ();
			IDictionary<int, string> prov_port_ownership = new Dictionary<int, string> ();
			IDictionary<int, string> task_port_ownership = new Dictionary<int, string> ();

			IDictionary<string,SAFeSWL.Component> components = getComponentsOfArchitectureByName (workflow_architecture);

			foreach (SAFeSWL.Component c in components.Values) 
			{
				string cRef = c.name;

				if (c is SAFeSWL.Platform)
					platform_list.Add (cRef);
						
				SAFeSWL.PortEnvironmentUses[] uses_port_list = c.uses_port;
				SAFeSWL.PortEnvironmentProvides[] prov_port_list = c.provides_port; 
				SAFeSWL.PortTask[] task_port_list = c is SAFeSWL.Worker ? ((SAFeSWL.Worker)c).task_port : null; 

				if (uses_port_list != null)
					foreach (SAFeSWL.PortEnvironmentUses p in uses_port_list)
						uses_port_ownership.Add (p.id, cRef);

				if (prov_port_list != null)
					foreach (SAFeSWL.PortEnvironmentProvides p in prov_port_list)
						prov_port_ownership.Add (p.id, cRef);

				if (task_port_list != null)
					foreach (SAFeSWL.PortTask p in task_port_list)
						task_port_ownership.Add (p.id, cRef);
			}

			SAFeSWL.BindingEnvironment[] env_bindings = workflow_architecture.env_binding;
			foreach (SAFeSWL.BindingEnvironment e in env_bindings)
			{
				EnvironmentPortType role;
				if (e.uses_port.id_component == application_component.id) 
				{
					role = platform_list.Contains(prov_port_ownership [e.provides_port.id]) ? EnvironmentPortType.platform_user : EnvironmentPortType.user;
					string cRef = prov_port_ownership [e.provides_port.id];
					string pRef = e.provides_port.name;    
					string pRefApp = e.uses_port.name; 
					bindings_application.Add (new Tuple<string, string, EnvironmentPortType, string> (cRef, pRef, role, pRefApp));
				} 
				else if (e.provides_port.id_component == application_component.id) 
				{					
					role = EnvironmentPortType.provider;
					string cRef = uses_port_ownership [e.uses_port.id];
					string pRef = e.uses_port.name;    
					string pRefApp = e.provides_port.name;
					bindings_application.Add (new Tuple<string, string, EnvironmentPortType, string> (cRef, pRef, role, pRefApp));
				} 
				else if (e.uses_port.id_component == workflow_component.id) 
				{
					role = platform_list.Contains(prov_port_ownership [e.provides_port.id]) ? EnvironmentPortType.platform_user : EnvironmentPortType.user;
					string cRef = prov_port_ownership [e.provides_port.id];
					string pRef = e.provides_port.name;    
					string pRefApp = e.uses_port.name; 
					bindings_workflow.Add (new Tuple<string, string, EnvironmentPortType, string> (cRef, pRef, role, pRefApp));
				} 
				else if (e.provides_port.id_component == workflow_component.id) 
				{
					role = EnvironmentPortType.provider;
					string cRef = uses_port_ownership [e.uses_port.id];
					string pRef = e.uses_port.name;
					string pRefApp = e.provides_port.name; 
					bindings_workflow.Add (new Tuple<string, string, EnvironmentPortType, string> (cRef, pRef, role, pRefApp));
				} 
				else  // binding entre dois componentes de solução ... 
				{
					string id_binding = e.name;
					string cRefUser = uses_port_ownership[e.uses_port.id];
					string pRefUser = e.uses_port.name;
					int facetUser = e.uses_port.facet;
					string cRefProvider = prov_port_ownership[e.provides_port.id];
					string pRefProvider = e.provides_port.name;
					int facetProvider = e.provides_port.facet;
					Tuple<string, string,int>[] peers = new Tuple<string, string, int>[2];
					peers [0] = new Tuple<string, string, int> (cRefUser, pRefUser, facetUser);
					peers [1] = new Tuple<string, string, int> (cRefProvider, pRefProvider, facetProvider);
					//if (cs.Contains (cRefUser) && cs.Contains (cRefProvider))
					bindings_system.Add (new Tuple<string, Tuple<string, string,int>[]> (id_binding, peers));
				}
			}

		
			bindings_task = new List<Tuple<string, Tuple<string, string,int>[]>>();

			foreach (SAFeSWL.BindingTask bt in workflow_architecture.task_binding) 
			{
				IList<Tuple<string, string, int>> peer_list = new List<Tuple<string, string, int>> ();
				foreach (SAFeSWL.PortTask pt in bt.peer) 
				{
					string cRef = task_port_ownership[pt.id];
					string pRef = pt.name;
					int facet = pt.facet;
					//if (cs.Contains (cRef)) 
					peer_list.Add (new Tuple<string, string, int> (cRef, pRef, facet));
				}
				Tuple<string,string,int>[] peers = new Tuple<string, string, int>[peer_list.Count];
				peer_list.CopyTo (peers, 0);

				bindings_task.Add (new Tuple<string, Tuple<string, string, int>[]> (bt.name, peers));
			}

			unit_mapping_in_platform = new Dictionary<string, Instantiator.UnitMappingType[]> ();

			unit_mapping_in_platform = unit_mapping;
			contracts_in_platform = contracts;

		}

	/*	public static void readArchitecture2
		(SAFeSWL.Architecture workflow_architecture,
			string platform_ref,
			IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts,
			IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping,
			ref string app_name,
			ref string application_component_name,
			ref string workflow_component_name,
			ref IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application,
			ref IList<Tuple<string, string, EnvironmentPortType, string>> bindings_workflow, 
			ref IList<Tuple<string, Tuple<string, string,int>[]>> bindings_system,
			ref IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task,
			ref IDictionary<string,Instantiator.ComponentFunctorApplicationType> contracts_in_platform,
			ref IDictionary<string,Instantiator.UnitMappingType[]> unit_mapping_in_platform)
		{
			app_name = workflow_architecture.application_name;
			workflow_component_name = workflow_architecture.workflow.name;
			application_component_name = workflow_architecture.application.name;

			bindings_application = new List<Tuple<string, string, EnvironmentPortType, string>> ();
			bindings_workflow = new List<Tuple<string, string, EnvironmentPortType, string>> ();
			bindings_system = new List<Tuple<string, Tuple<string, string,int>[]>> ();
			contracts_in_platform = new Dictionary<string,Instantiator.ComponentFunctorApplicationType> ();

			SAFeSWL.Component application_component = workflow_architecture.application;
			SAFeSWL.Component workflow_component = workflow_architecture.workflow;

			IDictionary<int, string> uses_port_ownership = new Dictionary<int, string> ();
			IDictionary<int, string> prov_port_ownership = new Dictionary<int, string> ();
			IDictionary<int, string> task_port_ownership = new Dictionary<int, string> ();

			//IList<SAFeSWL.Component> components = new List<SAFeSWL.Component> (workflow_architecture.body);
			//components.Add (workflow_architecture.application);
			//components.Add (workflow_architecture.workflow);

			IDictionary<string,int[]> cs_ = componentsInPlatform (workflow_architecture, platform_ref);
			IDictionary<string,SAFeSWL.Component> components = getComponentsOfArchitectureByName (workflow_architecture);

			string[] cs = new string[cs_.Keys.Count + 2];
			cs_.Keys.CopyTo (cs, 2);
			cs [0] = workflow_architecture.application.name;
			cs [1] = workflow_architecture.workflow.name;

			foreach (string cRef in cs) 
				if (components.ContainsKey(cRef))
				{
					SAFeSWL.Component c = components [cRef];
					if (contracts.ContainsKey(cRef))
						contracts_in_platform [cRef] = contracts [cRef];

					SAFeSWL.PortEnvironmentUses[] uses_port_list = c.uses_port;
					SAFeSWL.PortEnvironmentProvides[] prov_port_list = c.provides_port; 
					SAFeSWL.PortTask[] task_port_list = c is SAFeSWL.Worker ? ((SAFeSWL.Worker) c).task_port : null; 

					if (uses_port_list != null)
						foreach (SAFeSWL.PortEnvironmentUses p in uses_port_list) 
							uses_port_ownership.Add (p.id, cRef);

					if (prov_port_list != null)
						foreach (SAFeSWL.PortEnvironmentProvides p in prov_port_list) 
							prov_port_ownership.Add (p.id, cRef);

					if (task_port_list != null)
						foreach (SAFeSWL.PortTask p in task_port_list)
							task_port_ownership.Add (p.id, cRef);
				}


			SAFeSWL.BindingEnvironment[] env_bindings = workflow_architecture.env_binding;
			foreach (SAFeSWL.BindingEnvironment e in env_bindings)
				if (cs.Contains(e.name))
				{
					EnvironmentPortType role;
					if (e.uses_port.id == application_component.id) 
					{
						role = EnvironmentPortType.user;
						string cRef = uses_port_ownership [e.provides_port.id];
						string pRef = e.provides_port.name;    
						string pRefApp = e.uses_port.name; 
						bindings_application.Add (new Tuple<string, string, EnvironmentPortType, string> (cRef, pRef, role, pRefApp));
					} 
					else if (e.provides_port.id == application_component.id) 
					{
						role = EnvironmentPortType.provider;
						string cRef = prov_port_ownership [e.uses_port.id];
						string pRef = e.uses_port.name;    
						string pRefApp = e.provides_port.name;
						bindings_application.Add (new Tuple<string, string, EnvironmentPortType, string> (cRef, pRef, role, pRefApp));
					} 
					else if (e.uses_port.id == workflow_component.id) 
					{
						role = EnvironmentPortType.user;
						string cRef = uses_port_ownership [e.provides_port.id];
						string pRef = e.provides_port.name;    
						string pRefApp = e.uses_port.name; 
						bindings_workflow.Add (new Tuple<string, string, EnvironmentPortType, string> (cRef, pRef, role, pRefApp));
					} 
					else if (e.provides_port.id == workflow_component.id) 
					{
						role = EnvironmentPortType.provider;
						string cRef = prov_port_ownership [e.uses_port.id];
						string pRef = e.uses_port.name;
						string pRefApp = e.provides_port.name; 
						bindings_workflow.Add (new Tuple<string, string, EnvironmentPortType, string> (cRef, pRef, role, pRefApp));
					} 
					else  // binding entre dois componentes de solução ... 
					{
						string id_binding = e.name;
						string cRefUser = uses_port_ownership[e.uses_port.id];
						string pRefUser = e.uses_port.name;
						int facetUser = e.uses_port.facet;
						string cRefProvider = prov_port_ownership[e.provides_port.id];
						string pRefProvider = e.provides_port.name;
						int facetProvider = e.provides_port.facet;
						Tuple<string, string,int>[] peers = new Tuple<string, string, int>[2];
						peers [0] = new Tuple<string, string, int> (cRefUser, pRefUser, facetUser);
						peers [1] = new Tuple<string, string, int> (cRefProvider, pRefProvider, facetProvider);
						if (cs.Contains (cRefUser) && cs.Contains (cRefProvider))
							bindings_system.Add (new Tuple<string, Tuple<string, string,int>[]> (id_binding, peers));
					}
				}


			bindings_task = new List<Tuple<string, Tuple<string, string,int>[]>>();

			foreach (SAFeSWL.BindingTask bt in workflow_architecture.task_binding) 
				if (cs.Contains(bt.name))
				{
					IList<Tuple<string, string, int>> peer_list = new List<Tuple<string, string, int>> ();
					foreach (SAFeSWL.PortTask pt in bt.peer) 
					{
						string cRef = task_port_ownership[pt.id];
						string pRef = pt.name;
						int facet = pt.facet;
						if (cs.Contains (cRef)) 
							peer_list.Add (new Tuple<string, string, int> (cRef, pRef, facet));
					}
					Tuple<string,string,int>[] peers = new Tuple<string, string, int>[peer_list.Count];
					peer_list.CopyTo (peers, 0);

					bindings_task.Add (new Tuple<string, Tuple<string, string, int>[]> (bt.name, peers));
				}

			unit_mapping_in_platform = new Dictionary<string, Instantiator.UnitMappingType[]> ();

			IList<Tuple<string, Tuple<string, string,int>[]>> bindings_all = new List<Tuple<string, Tuple<string, string,int>[]>> (bindings_system);
			foreach (var binding in bindings_task) bindings_all.Add (binding);

			IDictionary<string, IList<int>> facet_mapping = new Dictionary<string, IList<int>> ();

			foreach (Tuple<string, Tuple<string,string,int>[]> binding in bindings_all) 
			{
				IList<int> current_facet_list;

				foreach (Tuple<string,string,int> peer in binding.Item2) 
				{
					string cRef = peer.Item1;
					int[] facets_in_platform = cs_.ContainsKey(cRef) ? cs_[cRef] : new int[0];
					int facet = peer.Item3;
					if (facets_in_platform.Contains (facet)) 
					{
						if (!facet_mapping.TryGetValue (cRef, out current_facet_list)) 
						{
							current_facet_list = new List<int> ();
							facet_mapping.Add (cRef, current_facet_list);
						}
						if (!current_facet_list.Contains (facet))
							current_facet_list.Add (facet);
					}
				}
			}

			foreach (KeyValuePair<string, Instantiator.UnitMappingType[]> u in unit_mapping) 
				if (cs.Contains (u.Key)) 
				{
					Instantiator.UnitMappingType[] um_list = u.Value;
					IList<Instantiator.UnitMappingType> um_list_in_platform_list = new List<Instantiator.UnitMappingType> ();
					foreach (Instantiator.UnitMappingType um in um_list) 
					{
						if (facet_mapping [u.Key].Contains(um.facet)) 
						{
							um_list_in_platform_list.Add (um);
						}
					}

					Instantiator.UnitMappingType[] um_list_in_platform = new Instantiator.UnitMappingType[um_list_in_platform_list.Count];
					um_list_in_platform_list.CopyTo (um_list_in_platform, 0);

					unit_mapping_in_platform.Add (u.Key, um_list_in_platform);
				}

			//	unit_mapping_in_platform = filter_unit_mapping (workflow_architecture, platform_ref, unit_mapping);




		}*/

		#region Application Component

		static Tuple<ComponentType,ComponentType> createProxyComponent 
		                 (string app_name,
						  IList<Tuple<string, string, EnvironmentPortType, string>> bindings_environment, 
			              IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task,
						  IDictionary<ProxyComponentAttribute,string> attributes,
						  IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts, 
						  IList<string> platforms)
		{
			ComponentType cAbs = createProxyComponentAbstract (app_name, bindings_environment, bindings_task, attributes, contracts, platforms);
			ComponentType cCon = createProxyComponentConcrete (app_name, bindings_environment, attributes, contracts, platforms);
			return new Tuple<ComponentType,ComponentType> (cAbs, cCon);
		}

		static ComponentType createProxyComponentAbstract (string app_name,
														   IList<Tuple<string, string, EnvironmentPortType, string>> bindings_environment, 
			                                               IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task, 
			                                               IDictionary<ProxyComponentAttribute,string> attributes, 
			                                               IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
															IList<string> platforms)
		
		{
			string proxy_name = attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME];

			ComponentType c = new ComponentType ();

			ComponentHeaderType h = c.header = new ComponentHeaderType();
			h.hash_component_UID = h.GetHashCode().ToString(); //?
			h.isAbstractSpecified = true;
			h.isAbstract = true; 
			h.kindSpecified = true;
			h.kind = SupportedKinds.Computation;
			h.name = attributes[ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT]; 
			h.packagePath = app_name /*+ "." +  arch_ref*/; 

			IList<object> body_items = new List<object> ();

			// ADD INNER COMPONENTS (many, one for each environment bindind)
			createProxyComponentAbstractInner (proxy_name, body_items, bindings_environment, bindings_task, contracts, platforms);

			// PARAMETER maintainer
			InnerComponentType inner_maintainer = new InnerComponentType ();
			body_items.Add (inner_maintainer);

			inner_maintainer.localRef = "maintainer";
			inner_maintainer.location = "br.ufc.mdcc.hpcshelf.platform.maintainer.SAFeHost/SAFeHost.hpe";
			inner_maintainer.multipleSpecified = true;
			inner_maintainer.multiple = false;
			inner_maintainer.name = "SAFeHost";
			inner_maintainer.package = "br.ufc.mdcc.hpcshelf.platform.maintainer";
			inner_maintainer.parameter_id = "maintainer";
			inner_maintainer.exposedSpecified = true;
			inner_maintainer.exposed = false;

			ParameterType par = new ParameterType();
			body_items.Add (par);

			par.componentRef = "maintainer";
			par.formFieldId = "maintainer";
			par.varName = "M";


			// NO SUPPLY PARAMTERS
			// NO INNER RENAMING
			// NO FUSION
			// NO SPLIT
			// NO RECURSIVE ENTRY

			// ADD UNIT (single)
			createProxyComponentAbstractUnit (body_items, bindings_environment, bindings_task, attributes);

			// ADD INTERFACE
			createProxyComponentAbstractInterface (app_name, body_items, bindings_environment, attributes);

			// NO FUSION OF REPLICATORS

			// NO EXTERNAL LIBRARIES

			c.componentInfo = new object[body_items.Count];
			body_items.CopyTo (c.componentInfo, 0);

			return c;
		}

		static void createProxyComponentAbstractInner (string proxy_name,
			                                           IList<object> body_items, 
			                                           IList<Tuple<string, string, EnvironmentPortType, string>> bindings_env, 
													   IList<Tuple<string, Tuple<string, string,int>[]>> bindings_tsk, 
			                                           IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
													   IList<string> platforms)
		
		{
			InnerComponentType[] ci_list_env = traverseEnvironmentBindings (contracts, bindings_env, true, platforms);
			foreach (InnerComponentType ci in ci_list_env)
				body_items.Add (ci);
			
			Tuple<InnerComponentType[],InnerRenamingType[]> ci_list_tsk = traverseTaskBindings (proxy_name, contracts, bindings_tsk, true);
			foreach (InnerComponentType ci in ci_list_tsk.Item1)
				body_items.Add (ci);
			foreach (InnerRenamingType ri in ci_list_tsk.Item2)
				body_items.Add (ri);
		}


		private static InnerComponentType[] traverseEnvironmentBindings (
								IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
			                    IList<Tuple<string, string, EnvironmentPortType, string>> bindings, 
								bool exposed, 
			                    IList<string> platforms)
		{
			IList<InnerComponentType> result_list = new List<InnerComponentType> ();

			foreach (Tuple<string, string, EnvironmentPortType, string> binding in bindings)
			{
				string componentRef = binding.Item1;
				string port_name = binding.Item2;
				string port_name_app = binding.Item4;

				Instantiator.ComponentFunctorApplicationType cc = contracts [componentRef];

				// search for the type of the component connected to the application through the environment port
				AbstractComponentFunctor acf = backend.DGAC.BackEnd.acfdao.retrieve_libraryPath (cc.component_ref);

				if (!platforms.Contains (componentRef)) 
				{
					// look for the type of the environment port in the inner component.
					InnerComponent ic = backend.DGAC.BackEnd.icdao.retrieve (acf.Id_abstract, port_name);
					acf = backend.DGAC.BackEnd.acfdao.retrieve (ic.Id_abstract_inner);
				}

				String library_path = acf.Library_path;

				InnerComponentType ci = new InnerComponentType ();
				ci.package = acf.Package;
				ci.name = acf.Name;
				ci.localRef = port_name_app;
				ci.multipleSpecified = true;
				ci.multiple = false;
				ci.exposedSpecified = true;
				ci.exposed = exposed;
				ci.port = traversePorts (cc.component_ref);
				ci.unitBounds = traverseUnits (cc.component_ref);

				ci.visualDescription = new VisualElementAttributes();
				ci.visualDescription.x = 500;
				ci.visualDescription.y = 500;
				ci.visualDescription.w = 200;
				ci.visualDescription.h = 150;
				ci.visualDescription.color = new ColorComplexType ();
				ci.visualDescription.color.b = 20;
				ci.visualDescription.color.g = 20;
				ci.visualDescription.color.r = 20;

				result_list.Add (ci);
			}

			InnerComponentType[] result = new InnerComponentType[result_list.Count];
			result_list.CopyTo (result, 0);

			return result;
		}

		private static Tuple<InnerComponentType[],InnerRenamingType[]> 
		                  traverseTaskBindings (string proxy_name,
												IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts, 
												IList<Tuple<string, Tuple<string, string, int>[]>> bindings_task,
												bool exposed)
		{
			IList<InnerComponentType> result_list_ports = new List<InnerComponentType> ();
			IList<InnerRenamingType> result_list_renamings = new List<InnerRenamingType> ();

			foreach (Tuple<string, Tuple<string, string,int>[]> binding in bindings_task) 
			{
				IDictionary <string,string> w = new Dictionary<string, string> ();
				string binding_name = binding.Item1;
				foreach (Tuple<string,string,int> peer in binding.Item2)
				{
					string cRef = peer.Item1;
					if (!cRef.Equals (proxy_name)) 
					{
						string pRef = peer.Item2;
						if (!w.ContainsKey (cRef + pRef)) 
						{
							w.Add (cRef + pRef, binding_name);

							Instantiator.ComponentFunctorApplicationType cc = contracts [cRef];

							AbstractComponentFunctor acf = BackEnd.acfdao.retrieve_libraryPath (cc.component_ref);
							InnerComponent ic = BackEnd.icdao.retrieve (acf.Id_abstract, binding_name);
							InnerComponentExposed ic_port = BackEnd.icedao.listExposedInnerOfOwner (acf.Id_abstract, binding_name) [0];
							AbstractComponentFunctor acf_ic_port = BackEnd.acfdao.retrieve (ic.Id_abstract_inner);

							string package = null;
							string name = null;
							fetchPackageAndName (acf_ic_port.Library_path, ref package, ref name);

							InnerComponentType ci = new InnerComponentType ();

							ci.package = package;
							ci.name = name;
							ci.localRef = ic.Id_inner;
							ci.multipleSpecified = true;
							ci.multiple = false;
							ci.exposedSpecified = true;
							ci.exposed = exposed;

							ci.visualDescription = new VisualElementAttributes ();
							ci.visualDescription.x = 10;
							ci.visualDescription.y = 10;
							ci.visualDescription.w = 70;
							ci.visualDescription.h = 40;
							ci.visualDescription.color = new ColorComplexType ();
							ci.visualDescription.color.b = 243;
							ci.visualDescription.color.g = 217;
							ci.visualDescription.color.r = 217;

							ci.unitBounds = traverseUnits (acf_ic_port.Library_path);
							ci.port = traversePorts (acf_ic_port.Library_path);

							InnerRenamingType task_port_renaming = new InnerRenamingType ();
							task_port_renaming.cRef = ci.localRef;
							task_port_renaming.cOldName = ci.port [0].localRef;
							task_port_renaming.cNewName = pRef;

							result_list_renamings.Add (task_port_renaming);
							result_list_ports.Add (ci);
						}
					}
				}
			}

			InnerComponentType[] result_ports = new InnerComponentType[result_list_ports.Count];
			result_list_ports.CopyTo (result_ports, 0);

			InnerRenamingType[] result_renamings = new InnerRenamingType[result_list_renamings.Count];
			result_list_renamings.CopyTo (result_renamings, 0);

			return new Tuple<InnerComponentType[],InnerRenamingType[]> (result_ports, result_renamings);
		}

		static void createProxyComponentAbstractInterface (string app_name, IList<object> body_items, IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application, IDictionary<ProxyComponentAttribute,string> attributes)
		{
			InterfaceType ct = new InterfaceType ();

			ct.iRef = attributes[ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT];
			ct.nArgsSpecified = true;
			ct.nArgs = 0;
			ct.sources = createProxyAbstractSourceCode(app_name, attributes); 

			ct.visualDescription = new VisualElementAttributes();
			ct.visualDescription.x = 10;
			ct.visualDescription.y = 10;
			ct.visualDescription.w = 150;
			ct.visualDescription.h = 100;
			ct.visualDescription.color = new ColorComplexType ();
			ct.visualDescription.color.b = 20;
			ct.visualDescription.color.g = 20;
			ct.visualDescription.color.r = 20;

			IList<InterfaceSliceType> slices_list = createProxyComponentAbstractInterfaceSlices (bindings_application);
			ct.slice = new InterfaceSliceType[slices_list.Count];
			slices_list.CopyTo (ct.slice, 0);

			body_items.Add (ct);
		}

		static SourceType[] createProxyAbstractSourceCode (string app_name, IDictionary<ProxyComponentAttribute, string> attributes)
		{
			string source_code_name;
			SourceType[] source_code = new SourceType[1];
			source_code [0] = new SourceType ();
			source_code [0].file = new SourceFileType[1];
			source_code [0].sourceType = "C# Language";
			source_code [0].versionId = "1.0.0.0";
			source_code [0].file [0] = new SourceFileType ();
			source_code [0].file [0].name = source_code_name = attributes[ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT] + ".cs";
			source_code [0].file [0].srcType = "user";
			source_code [0].file [0].contents = generate_proxy_abstract_code(app_name, source_code_name, attributes);
			//source_code [0].file [0].externalDependency;

			return source_code;
		}

		static string generate_proxy_abstract_code (string app_name, string source_file_name, IDictionary<ProxyComponentAttribute, string> attributes)
		{
			CodeCompileUnit compileUnit = new CodeCompileUnit();

			// * NAMESPACE
			CodeNamespace globalNamespace = new CodeNamespace();		
			compileUnit.Namespaces.Add(globalNamespace);

			CodeNamespace ns = new CodeNamespace(app_name + "." + attributes [ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT]);
			compileUnit.Namespaces.Add(ns);

			// ** INTERFACE
			string interface_name = attributes [ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT];
			CodeTypeDeclaration unit_interface = new CodeTypeDeclaration(interface_name);
			unit_interface.IsInterface = true;
			ns.Types.Add(unit_interface);

			// *** INTERFACE BASE TYPES
			unit_interface.BaseTypes.Add ("br.ufc.pargo.hpe.kinds.IComputationKind");

			return generateCSharpCode (compileUnit, source_file_name);
		}

		private static string generateCSharpCode(CodeCompileUnit compileunit, string sourceFileName)
		{
			string source_code;

			// Generate the code with the C# code provider.
			CSharpCodeProvider provider = new CSharpCodeProvider();

			// Build the output file name. 
			string sourceFile;
			if (provider.FileExtension[0] == '.')
				sourceFile = Constants.PATH_TEMP_WORKER + sourceFileName + provider.FileExtension;
			else
				sourceFile =  Constants.PATH_TEMP_WORKER + sourceFileName + "." + provider.FileExtension;

			// Create a TextWriter to a StreamWriter to the output file. 
			using (StreamWriter sw = new StreamWriter(sourceFile, false))
			{
				IndentedTextWriter tw = new IndentedTextWriter(sw, "    ");

				// Generate source code using the code provider.
				provider.GenerateCodeFromCompileUnit(compileunit, tw, new CodeGeneratorOptions());

				// Close the output file.
				tw.Close();
			}

			using (StreamReader sr = new StreamReader(sourceFile))
			{
				source_code = sr.ReadToEnd();
			}

			return source_code;
		}

		static IList<InterfaceSliceType> createProxyComponentAbstractInterfaceSlices (IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application)
		{
			IList<InterfaceSliceType> slices_list = new List<InterfaceSliceType> ();
			foreach (Tuple<string, string, EnvironmentPortType, string> binding in bindings_application) 
			{
				string port_name = binding.Item4;
				string slice_unit_name = Constants.envUnitName[binding.Item3];

				InterfaceSliceType s = new InterfaceSliceType ();
				s.isRef = port_name;
				s.originRef = new InterfaceRefType ();
				s.originRef.cRef = port_name;
				s.originRef.iRef = Constants.envInterfaceName[binding.Item3];
				s.visualDescription = null;

				s.visualDescription = new VisualElementAttributes();
				s.visualDescription.x = 10;
				s.visualDescription.y = 10;
				s.visualDescription.w = 20;
				s.visualDescription.h = 20;
				s.visualDescription.color = new ColorComplexType ();
				s.visualDescription.color.b = 20;
				s.visualDescription.color.g = 20;
				s.visualDescription.color.r = 20;

				slices_list.Add (s);
			}

			return slices_list;
		}

		static void createProxyComponentAbstractUnit (IList<object> body_items, 
			                                          IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application, 
			                                          IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task, 
			                                          IDictionary<ProxyComponentAttribute,string> attributes)
		{
			UnitType cu = new UnitType ();

			cu.facet = 0;
			cu.iRef = attributes[ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT];
			cu.multipleSpecified = true;
			cu.multiple = false;
			cu.privateSpecified = true;
			cu.@private = false;
			cu.replicaSpecified = true;
			cu.replica = 0;
			cu.uRef = attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT];   
			cu.visibleInterface = true;

			IList<UnitSliceType> slices_list = createProxyComponentAbstractUnitSlices (bindings_application, bindings_task);
			cu.slices = new UnitSliceType[slices_list.Count];
			slices_list.CopyTo (cu.slices, 0);

			cu.visualDescription = new VisualElementAttributes();
			cu.visualDescription.x = 10;
			cu.visualDescription.y = 10;
			cu.visualDescription.w = 100;
			cu.visualDescription.h = 50;
			cu.visualDescription.color = new ColorComplexType ();
			cu.visualDescription.color.b = 20;
			cu.visualDescription.color.g = 20;
			cu.visualDescription.color.r = 20;

			body_items.Add (cu);
		}

		static IList<UnitSliceType> createProxyComponentAbstractUnitSlices (IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application,
			                                                                IList<Tuple<string, Tuple<string, string,int>[]>> bindings_task)
		{
			IList<UnitSliceType> slices_list = new List<UnitSliceType> ();
			foreach (Tuple<string, string, EnvironmentPortType, string> binding in bindings_application) 
			{
				string port_name = binding.Item4;
				string slice_unit_name = Constants.envUnitName[binding.Item3];

				UnitSliceType s = new UnitSliceType ();
				s.cRef = port_name;
				s.uRef = slice_unit_name; 
				s.sliceName = port_name;
				s.slice_replica = 0;
				s.transitiveSpecified = true;
				s.transitive = false;

				s.visualDescription = new VisualElementAttributes();
				s.visualDescription.x = 10;
				s.visualDescription.y = 10;
				s.visualDescription.w = 15;
				s.visualDescription.h = 15;
				s.visualDescription.color = new ColorComplexType ();
				s.visualDescription.color.b = 20;
				s.visualDescription.color.g = 20;
				s.visualDescription.color.r = 20;

				slices_list.Add (s);
			}

			foreach (Tuple<string, Tuple<string, string,int>[]> t in bindings_task) 
			{
				string port_name = t.Item1;
				string slice_unit_name = Constants.tskUnitName;

				UnitSliceType s = new UnitSliceType ();
				s.cRef = port_name;
				s.uRef = slice_unit_name; 
				s.sliceName = port_name;
				s.slice_replica = 0;
				s.transitiveSpecified = true;
				s.transitive = false;

				s.visualDescription = new VisualElementAttributes();
				s.visualDescription.x = 10;
				s.visualDescription.y = 10;
				s.visualDescription.w = 15;
				s.visualDescription.h = 15;
				s.visualDescription.color = new ColorComplexType ();
				s.visualDescription.color.b = 20;
				s.visualDescription.color.g = 20;
				s.visualDescription.color.r = 20;

				slices_list.Add (s);
			}

			return slices_list;
		}

		static ComponentType createProxyComponentConcrete (
			string app_name,  
			IList<Tuple<string, string, EnvironmentPortType, string>> bindings_application, 
			IDictionary<ProxyComponentAttribute,string> attributes, 
			IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
			IList<string> platforms)
		{
			ComponentType c = new ComponentType ();

			ComponentHeaderType h = c.header = new ComponentHeaderType();
			h.hash_component_UID = h.GetHashCode().ToString(); //?
			h.isAbstractSpecified = true;
			h.isAbstract = false; 
			h.kindSpecified = true;
			h.kind = SupportedKinds.Computation;
			h.name = attributes[ProxyComponentAttribute.COMPONENT_NAME_CONCRETE]; 
			h.packagePath = app_name /*+ "." + arch_ref */+ ".impl";

			h.baseType = new BaseTypeType ();
			h.baseType.extensionType = new ExtensionTypeType();
			h.baseType.extensionType.Item = true;
			h.baseType.extensionType.ItemElementName = ItemChoiceType.implements;

			h.baseType.component = new ComponentInUseType();
			h.baseType.component.package = app_name /*+ "." + arch_ref*/;
			h.baseType.component.name = attributes[ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT];
			h.baseType.component.localRef = "base";
			h.baseType.component.multipleSpecified = true;
			h.baseType.component.multiple = false;

			h.baseType.component.visualDescription = new VisualElementAttributes();
			h.baseType.component.visualDescription.x = 10;
			h.baseType.component.visualDescription.y = 10;
			h.baseType.component.visualDescription.w = 100;
			h.baseType.component.visualDescription.h = 50;
			h.baseType.component.visualDescription.color = new ColorComplexType ();
			h.baseType.component.visualDescription.color.b = 20;
			h.baseType.component.visualDescription.color.g = 20;
			h.baseType.component.visualDescription.color.r = 20;

			IList<object> body_items = new List<object> ();

			// PARAMETER maintainer
			InnerComponentType inner_maintainer = new InnerComponentType ();
			body_items.Add (inner_maintainer);

			inner_maintainer.localRef = "maintainer";
			inner_maintainer.location = "br.ufc.mdcc.hpcshelf.platform.maintainer.SAFeHost/SAFeHost.hpe";
			inner_maintainer.multipleSpecified = true;
			inner_maintainer.multiple = false;
			inner_maintainer.name = "SAFeHost";
			inner_maintainer.package = "br.ufc.mdcc.hpcshelf.platform.maintainer";
			inner_maintainer.parameter_id = "maintainer";
			inner_maintainer.exposedSpecified = true;
			inner_maintainer.exposed = false;

			ParameterSupplyType supply_host = new ParameterSupplyType ();
			body_items.Add (supply_host);

			supply_host.cRef = "maintainer";
			supply_host.direct = true;
			supply_host.varName = "M";
		

			// ADD INNER COMPONENTS (many, one for each environment bindind)
			// NO INNER COMPONENTS

			// NO PARAMETERS
			// NO SUPPLY PARAMTERS
			// NO INNER RENAMING
			// NO FUSION
			// NO SPLIT
			// NO RECURSIVE ENTRY

			// ADD UNIT (single)
			createProxyComponentConcreteUnit (body_items, attributes);

			// ADD INTERFACE
			createProxyComponentConcreteInterface (app_name, bindings_application, body_items, attributes, contracts, platforms);

			// NO FUSION OF REPLICATORS

			// NO EXTERNAL LIBRARIES

			c.componentInfo = new object[body_items.Count];
			body_items.CopyTo (c.componentInfo, 0);

			return c;
		}

		static void createProxyComponentConcreteInterface (
									string app_name,  
									IList<Tuple<string, string, EnvironmentPortType, string>> bindings, 
									IList<object> body_items, IDictionary<ProxyComponentAttribute,string> attributes,
								    IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
								    IList<string> platforms)
		{
			InterfaceType ct = new InterfaceType ();

			ct.iRef = attributes[ProxyComponentAttribute.INTERFACE_NAME_CONCRETE];
			ct.nArgsSpecified = true;
			ct.nArgs = 0;
			ct.sources = createProxyConcreteSourceCode(app_name, bindings, attributes, contracts, platforms); //?

			ct.visualDescription = new VisualElementAttributes();
			ct.visualDescription.x = 10;
			ct.visualDescription.y = 10;
			ct.visualDescription.w = 150;
			ct.visualDescription.h = 100;
			ct.visualDescription.color = new ColorComplexType ();
			ct.visualDescription.color.b = 20;
			ct.visualDescription.color.g = 20;
			ct.visualDescription.color.r = 20;

			body_items.Add (ct);
		}

		static SourceType[] createProxyConcreteSourceCode (
								string app_name, 
								IList<Tuple<string, string, EnvironmentPortType, string>> bindings, 
								IDictionary<ProxyComponentAttribute, string> attributes,
								IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
								IList<string> platforms)
		{
			string source_file_name;
			SourceType[] source_code = new SourceType[1];
			source_code [0] = new SourceType ();
			source_code [0].sourceType = "C# Language";
			source_code [0].versionId = "1.0.0.0";
			source_code [0].file = new SourceFileType[1];
			source_code [0].file [0] = new SourceFileType ();
			source_code [0].file [0].name = source_file_name = attributes[ProxyComponentAttribute.INTERFACE_NAME_CONCRETE] + ".cs";
			source_code [0].file [0].contents = generate_proxy_concrete_code (app_name, bindings, source_file_name, attributes, contracts, platforms);
			source_code [0].file [0].srcType = "user";
			//source_code [0].file [0].externalDependency;

			return source_code;
		}

		static string generate_proxy_concrete_code (
			           string app_name, 
			           IList<Tuple<string, string, EnvironmentPortType, string>> bindings, 
			           string source_file_name, IDictionary<ProxyComponentAttribute, string> attributes,
					   IDictionary<string, Instantiator.ComponentFunctorApplicationType> contracts,
					   IList<string> platforms)
					
		{
			CodeCompileUnit compileUnit = new CodeCompileUnit();

			// * NAMESPACE
			CodeNamespace globalNamespace = new CodeNamespace();		
			compileUnit.Namespaces.Add(globalNamespace);

			CodeNamespace ns = new CodeNamespace(app_name + /*"." + arch_ref +*/ ".impl." + attributes [ProxyComponentAttribute.COMPONENT_NAME_CONCRETE]);
			compileUnit.Namespaces.Add(ns);

			// ** CLASS
			string class_name = attributes [ProxyComponentAttribute.INTERFACE_NAME_CONCRETE];
			CodeTypeDeclaration unit_class = new CodeTypeDeclaration(class_name);
			unit_class.IsClass = true;
			ns.Types.Add(unit_class);

			// *** CLASS BASE TYPES
			unit_class.BaseTypes.Add ("br.ufc.pargo.hpe.kinds.Computation");


			// *** BUILD SLICES DICTIONARY ...

			IDictionary<string, Tuple<string,string>> server_port_dict = new Dictionary<string, Tuple<string,string>> ();
			IDictionary<string, Tuple<string,string,string>> client_port_dict = new Dictionary<string, Tuple<string, string,string>> ();
			foreach (Tuple<string, string, EnvironmentPortType, string> binding in bindings) 
			{
				string componentRef = contracts[binding.Item1].component_ref;
				string port_name_inner = binding.Item2;
				string port_name_app = binding.Item4;
				EnvironmentPortType port_role = binding.Item3;

				// look for the type of the component connected to the application through the environment port
				AbstractComponentFunctor acf = backend.DGAC.BackEnd.acfdao.retrieve_libraryPath (componentRef);
				if (platforms.Contains (binding.Item1)) continue;

				// look for the type of the environment port in the inner component.
				InnerComponent ic = backend.DGAC.BackEnd.icdao.retrieve (acf.Id_abstract, port_name_inner);
				AbstractComponentFunctor acf_inner = backend.DGAC.BackEnd.acfdao.retrieve (ic.Id_abstract_inner);

				string binding_library_path = acf_inner.Library_path; 

				IList<Interface> iList = backend.DGAC.BackEnd.idao.list (acf_inner.Id_abstract);
				foreach (Interface i in iList)
				{
					string id_interface_base = i.Id_interface_super_top;
					if (id_interface_base.Equals ("client") && port_role == EnvironmentPortType.user) 
					{
						// look for the type of the user interface
						string binding_type = i.Class_name;

						// look for the argument that defines the type of the port
						SupplyParameterComponent spc = backend.DGAC.BackEnd.spcdao.retrieve ("client_port_type", acf_inner.Id_functor_app_supertype);
						Interface i_port = backend.DGAC.BackEnd.idao.list (spc.Id_abstract)[0];
						string port_type = i_port.Class_name;  

						client_port_dict.Add(port_name_app,new Tuple<string, string, string>(binding_library_path, binding_type, port_type));
					} 
					else if (id_interface_base.Equals ("server") && port_role == EnvironmentPortType.provider) 
					{
						// look for the type of the user interface
						string binding_type = i.Class_name;

						// look for the argument that defines the type of the port
						SupplyParameterComponent spc = backend.DGAC.BackEnd.spcdao.retrieve ("server_port_type", acf_inner.Id_functor_app_supertype);
						Interface i_port = backend.DGAC.BackEnd.idao.list (spc.Id_abstract)[0];
						string port_type = i_port.Class_name;  

						server_port_dict.Add(port_name_app,new Tuple<string, string>(binding_type, port_type));
					}
			   }
			}

			// *** CLASS MAIN METHOD

			CodeMemberMethod main_method = new CodeMemberMethod();
			unit_class.Members.Add (main_method);

			main_method.Name = "main";
			main_method.Attributes = MemberAttributes.Override | MemberAttributes.Public;

			var statements = main_method.Statements;

			// PUBLISH the PORT METHODS TO THE WEB SERVICE via WCF.
			foreach (KeyValuePair<string, Tuple<string,string,string>> port in client_port_dict)
			{
				string port_name = port.Key;
				string binding_library_path = port.Value.Item1; // e.g. br.ufc.mdcc.hpc.storm.binding.environment.impl.BindingMbyNIntraExample
				string binding_type = port.Value.Item2;         // e.g. br.ufc.mdcc.hpc.storm.binding.environment.impl.BindingMbyNIntraExample.IBindingMyNIntraExampleClient
				string port_type = port.Value.Item3;            // e.g. br.ufc.mdcc.hpc.storm.binding.environment.example.MbyN.EnvironmentPortTypeClient.IMbyNClientPortTypeExample

				// BINDING_TYPE unit = this.Services.getPort (PORT_NAME);
				CodePropertyReferenceExpression target_object1 = new CodePropertyReferenceExpression (new CodeThisReferenceExpression(), "Services");
				CodeExpression[] parameters1 = new CodeExpression[1];
				parameters1 [1] = new CodePrimitiveExpression (port_name);
				CodeMethodInvokeExpression initExpression1 = new CodeMethodInvokeExpression(target_object1, "getPort", parameters1); ;
				CodeVariableDeclarationStatement decl1 = new CodeVariableDeclarationStatement (binding_type, "unit", initExpression1);
				statements.Add (decl1);

				// publishBindingService(<app_session_id>, unit.Service, typeof (PORT_TYPE), address, <binding_type_library_path>);
				var parameters2 = new CodeExpression[4];
				parameters2 [0] = null; // TODO : session id (system id) getHashCode ?
				parameters2 [1] = new CodePropertyReferenceExpression (new CodeVariableReferenceExpression ("unit"), "Service");
				parameters2 [2] = new CodeTypeOfExpression (port_type);
				parameters2 [3] = new CodePrimitiveExpression(binding_library_path + Path.PathSeparator + binding_type); 
				var method_invocation2 = new CodeMethodInvokeExpression (new CodeThisReferenceExpression (), "publishBindingService", parameters2);
				statements.Add (method_invocation2);
			}

			// CONNECT TO THE PORT METHODS.
			// TODO: ???
			foreach (KeyValuePair<string, Tuple<string,string>> port in server_port_dict) 
			{
				string port_name = port.Key;
				string binding_type = port.Value.Item1;         // e.g. br.ufc.mdcc.hpc.storm.binding.environment.impl.BindingMbyNIntraExample.IBindingMyNIntraExampleClient
				string port_type = port.Value.Item2;            // e.g. br.ufc.mdcc.hpc.storm.binding.environment.example.MbyN.EnvironmentPortTypeClient.IMbyNClientPortTypeExample
							
				// BINDING_TYPE unit = this.Services.getPort (PORT_NAME);
				CodePropertyReferenceExpression target_object1 = new CodePropertyReferenceExpression (new CodeThisReferenceExpression (), "Services");
				CodeExpression[] parameters1 = new CodeExpression[1];
				parameters1 [1] = new CodePrimitiveExpression (port_name);
				CodeMethodInvokeExpression initExpression1 = new CodeMethodInvokeExpression (target_object1, "getPort", parameters1);
				CodeVariableDeclarationStatement decl1 = new CodeVariableDeclarationStatement (binding_type, "unit", initExpression1);
				statements.Add (decl1);

				// PORT_TYPEStub server_stub = new PORT_TYPEStub();
				string port_stub_type = port_type + "Stub";
				var create_stub = new CodeObjectCreateExpression (port_stub_type);
				var declare_stub_variable = new CodeVariableDeclarationStatement (port_stub_type + "Stub", "server_stub", create_stub);
				statements.Add (declare_stub_variable);

				// unit.Service = server_stub
				var service_property = new CodePropertyReferenceExpression(new CodeVariableReferenceExpression("unit"),"Service");
				var assign_service = new CodeAssignStatement (service_property, new CodeVariableReferenceExpression("server_stub"));
				statements.Add (assign_service);
			}

			return generateCSharpCode (compileUnit, source_file_name);
		}

		static void createProxyComponentConcreteUnit (IList<object> body_items, IDictionary<ProxyComponentAttribute,string> attributes)
		{
			UnitType cu = new UnitType ();

			cu.facet = 0;
			cu.iRef = attributes[ProxyComponentAttribute.INTERFACE_NAME_CONCRETE];
			cu.multipleSpecified = true;
			cu.multiple = false;
			cu.privateSpecified = true;
			cu.@private = false;
			cu.replica = 0;
			cu.uRef = attributes[ProxyComponentAttribute.UNIT_NAME_CONCRETE];   
			cu.visibleInterface = true;

			cu.super = new UnitRefType[1];
			UnitRefType uRef = new UnitRefType ();
			uRef.cRef = "base";
			uRef.uRef = attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT];
			cu.super [0] = uRef;

			cu.visualDescription = new VisualElementAttributes();
			cu.visualDescription.x = 10;
			cu.visualDescription.y = 10;
			cu.visualDescription.w = 150;
			cu.visualDescription.h = 100;
			cu.visualDescription.color = new ColorComplexType ();
			cu.visualDescription.color.b = 20;
			cu.visualDescription.color.g = 20;
			cu.visualDescription.color.r = 20;

			body_items.Add (cu);
		}

		#endregion Application Component




	}
}
