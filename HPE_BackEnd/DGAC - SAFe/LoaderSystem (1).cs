using br.ufc.pargo.hpe.backend.DGAC.utils;
using System;
using System.Linq;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.database;
using Instantiator;
using System.Collections;

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

		public static void createSystemComponent(string app_name, 
		                                         IDictionary<string, InstanceType> component_refs,
		                                         IList<Tuple<string, string, EnvironmentPortType>> bindings_application,
		                                         IList<Tuple<string, string, EnvironmentPortType>> bindings_workflow) 
		{
			/* Applicaton, workflow and platform components need to know which are the environment ports. */

			IList<string> port_names = null;
			IDictionary<ProxyComponentAttribute, string> application_attributes 
					= new Dictionary<ProxyComponentAttribute, string> () {
						{ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT, "Application"},
						{ProxyComponentAttribute.COMPONENT_NAME_CONCRETE, "AplicationImpl"},
						{ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT, "IApplication"},
						{ProxyComponentAttribute.INTERFACE_NAME_CONCRETE, "IApplicationImpl"},
						{ProxyComponentAttribute.UNIT_NAME_ABSTRACT,"application_unit"},
						{ProxyComponentAttribute.UNIT_NAME_CONCRETE,"application_unit"},
						{ProxyComponentAttribute.INNER_COMPONENT_NAME,"application"}
					};
			createApplicationComponent (app_name, bindings_application, ref port_names, application_attributes);

			IDictionary<ProxyComponentAttribute, string> worklow_attributes = 
			new Dictionary<ProxyComponentAttribute, string> () {
				{ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT, "Workflow"},
				{ProxyComponentAttribute.COMPONENT_NAME_CONCRETE, "WorkflowImpl"},
				{ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT, "IWorkflow"},
				{ProxyComponentAttribute.INTERFACE_NAME_CONCRETE, "IWorkflowImpl"},
				{ProxyComponentAttribute.UNIT_NAME_ABSTRACT,"workflow_unit"},
				{ProxyComponentAttribute.UNIT_NAME_CONCRETE,"workflow_unit"},
				{ProxyComponentAttribute.INNER_COMPONENT_NAME,"workflow"}
			};
			createApplicationComponent (app_name, bindings_workflow, ref port_names, worklow_attributes);

			ComponentType system_abstract = createSystemAbstract (app_name, application_attributes, worklow_attributes, component_refs, bindings_application, bindings_workflow);
			ComponentType system_concrete = createSystemConcrete (app_name, system_abstract);
		}

		static ComponentType createSystemAbstract (string app_name, 
		                                           IDictionary<ProxyComponentAttribute, string> application_attributes, 
		                                           IDictionary<ProxyComponentAttribute, string> worklow_attributes, 
		                                           IDictionary<string, InstanceType> component_refs, 
		                                           IList<Tuple<string, string, EnvironmentPortType>> bindings_application, 
		                                           IList<Tuple<string, string, EnvironmentPortType>> bindings_workflow)
		{
			ComponentType c = new ComponentType ();

			ComponentHeaderType h = c.header = new ComponentHeaderType();
			h.hash_component_UID = null; //?
			h.isAbstract = true; 
			h.kind = SupportedKinds.System;
			h.name = "System"; 
			h.packagePath = app_name; 

			IList<object> body_items = new List<object> ();

			// ADD INNER COMPONENTS (many, one for each environment bindind)
			createSystemComponentAbstractInner (app_name, body_items, component_refs, application_attributes, worklow_attributes);

			// NO PARAMETERS
			// NO SUPPLY PARAMTERS
			fuseEnvironmentBindings (application_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME],bindings_application, component_refs);
			fuseEnvironmentBindings (worklow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME], bindings_workflow, component_refs);
			// NO SPLIT
			// NO RECURSIVE ENTRY

			// ADD UNIT (single)
			createSystemComponentAbstractUnit (body_items, component_refs, application_attributes, worklow_attributes, bindings_application, bindings_workflow);

			// ADD INTERFACE
			// createSystemComponentAbstractInterface (body_items, bindings_application);

			// NO FUSION OF REPLICATORS

			// NO EXTERNAL LIBRARIES

			c.componentInfo = new object[body_items.Count];
			body_items.CopyTo (c.componentInfo, 0);

			return c;
		}

		static void fuseEnvironmentBindings (string inner_name, IList<Tuple<string, string, EnvironmentPortType>> bindings, IDictionary<string, InstanceType> component_refs)
		{
			int counter = 0;
			foreach (Tuple<string, string, EnvironmentPortType> binding in bindings) 
			{
				string port_name = binding.Item2 + (counter++);
				string instance_ref = component_refs [binding.Item1].instance_ref;

				InnerRenamingType renaming = new InnerRenamingType ();
				renaming.cRef = instance_ref;
				renaming.cOldName = binding.Item2;
				renaming.cNewName = port_name;

				FusionType fusion = new FusionType();
				fusion.cRefs = new string[2];
				fusion.cRefs [0] = instance_ref;
				fusion.cRefs [1] = inner_name;
				fusion.pRef = port_name;
			}
		}

		static void createSystemComponentAbstractInner (string app_name, 
		                                                IList<object> body_items, 
		                                                IDictionary<string, InstanceType> component_refs,
		                                                IDictionary<ProxyComponentAttribute, string> application_attributes,
		                                                IDictionary<ProxyComponentAttribute, string> workflow_attributes)
		{
			// APPLICARTION PROXY COMPONENT
			InnerComponentType ci_app = new InnerComponentType ();
			ci_app.package = app_name;
			ci_app.name = application_attributes[ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT];
			ci_app.localRef = application_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME]; 
			ci_app.multiple = false;
			ci_app.exposed = false;
			body_items.Add (ci_app);

			// WORKFLOW PROXY COMPONENT
			InnerComponentType ci_wkf = new InnerComponentType ();
			ci_wkf.package = app_name;
			ci_wkf.name = workflow_attributes[ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT];
			ci_wkf.localRef = workflow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME]; 
			ci_wkf.multiple = false;
			ci_wkf.exposed = false;
			body_items.Add (ci_wkf);

			// REGULAR COMPONENTS
			foreach (KeyValuePair<string, InstanceType> binding in component_refs) 
			{
				string componentRef = binding.Key;
				string port_name = binding.Value.instance_ref;

				string package = null, name = null;
				fetchPackageAndName (componentRef, ref package, ref name);

				InnerComponentType ci = new InnerComponentType ();
				ci.package = package;
				ci.name = name;
				ci.localRef = port_name; 
				ci.multiple = false;
				ci.exposed = false;
				ci.parameter = traverseParameters (body_items, binding.Value.contextual_type.argument);

				body_items.Add (ci);
			}
		}

		static void fetchPackageAndName (string componentRef, ref string package, ref string name)
		{
			int pos = componentRef.LastIndexOf ('.');
			package = componentRef.Substring (0, pos - 1);
			name = componentRef.Substring (pos + 1);
		}

		static int count1 = 0;
		static string NextArgumentInner {get { return "__inner__" + (count1++); } }
		static int count2 = 0;
		static string NextVariable {get { return "__VAR__" + (count2++); } }

		static ParameterRenaming[] traverseParameters (IList<object> body_items, ContextArgumentType[] argument_list)
		{
			IList<ParameterRenaming> parameter_renaming_list = new List<ParameterRenaming> ();

			foreach (ContextArgumentType argument in argument_list) 
			{
				ParameterRenaming parameter_renaming = new ParameterRenaming ();

				ComponentFunctorApplicationType argument_value = (ComponentFunctorApplicationType)argument.Item;

				string componentRef = argument_value.component_ref;
				string inner_name = NextArgumentInner;

				string package = null, name = null;
				fetchPackageAndName (componentRef, ref package, ref name);

				InnerComponentType ci = new InnerComponentType ();
				body_items.Add (ci);
				ci.package = package;
				ci.name = name;
				ci.localRef = inner_name; 
				ci.multiple = false;
				ci.exposed = false;
				ci.parameter = traverseParameters(body_items, argument_value.argument);

				ParameterSupplyType supply = new ParameterSupplyType ();
				body_items.Add (supply);
				supply.cRef = inner_name;
				supply.varName = NextVariable;

				parameter_renaming.formFieldId = argument.parameter_id;
				parameter_renaming.varName = supply.varName;

				parameter_renaming_list.Add (parameter_renaming);
			}

			ParameterRenaming[] parameter_return_array = new ParameterRenaming[parameter_renaming_list.Count];
			parameter_renaming_list.CopyTo (parameter_return_array, 0);
			return parameter_return_array;
		}

		static void createSystemComponentAbstractUnit (IList<object> body_items, 
		                                               IDictionary<string, InstanceType> component_refs, 
		                                               IDictionary<ProxyComponentAttribute, string> application_attributes, 
		                                               IDictionary<ProxyComponentAttribute, string> workflow_attributes, 
		                                               IList<Tuple<string, string, EnvironmentPortType>> bindings_application, 
		                                               IList<Tuple<string, string, EnvironmentPortType>> bindings_workflow)
		{
			IDictionary<int,SliceList> unit_mapping = new Dictionary<int, SliceList> ();

			foreach (InstanceType c in component_refs.Values) 
			{
				string cRef = c.contextual_type.component_ref;
				foreach (UnitMappingType u in c.unit_mapping) 
				{
					string uRef = u.unit_id;
					foreach (int n in u.node) 
					{
						AbstractComponentFunctor acf = backend.DGAC.BackEnd.acfdao.retrieve_libraryPath(cRef);
						string qualified_class_name = backend.DGAC.BackEnd.idao.retrieve (acf.Id_abstract, uRef, 0).Class_name;
						string[] parts_class_name = qualified_class_name.Split (new char[] {'.'});
						string iRef = parts_class_name[parts_class_name.Length-1];

						bool hasNode = unit_mapping.ContainsKey (n);
						SliceList units_at_node =  hasNode ? unit_mapping[n] : new SliceList ();

						units_at_node.Value.Add(new Tuple<string, string, string>(cRef,uRef,iRef));
						if (!hasNode) 
							unit_mapping.Add(n,units_at_node);
					}
				}
			}

			IDictionary<SliceList, IList<int>> slice_mapping = new Dictionary<SliceList, IList<int>> ();

			foreach (KeyValuePair<int,SliceList> r in unit_mapping)
			{
				bool hasSlice = slice_mapping.ContainsKey (r.Value);
 				IList<int> node_list = hasSlice ? slice_mapping [r.Value] : new List<int> ();
				node_list.Add (r.Key);
				if (!hasSlice) 
					slice_mapping.Add (r.Value, node_list);
			}

			// PEER UNITS
			int unit_counter = 0;
			foreach (KeyValuePair<SliceList,IList<int>> r in slice_mapping) 
			{
				string uname = "peer" + (unit_counter++);
				string iname = "IPeer" + (unit_counter++);

				UnitType cu = new UnitType ();
				cu.facet = 0;
				cu.iRef = iname;
				cu.multiple = true;
				cu.@private = false;
				cu.replica = 0;
				cu.uRef = uname;   
				cu.visibleInterface = true;
				
				InterfaceType ct = new InterfaceType ();
				ct.iRef = iname;
				ct.nArgs = 0;
				ct.sources = null; //?

				IDictionary<Tuple<string,string,string>,int> slice_counter = new Dictionary<Tuple<string,string,string>,int> ();

				IList<UnitSliceType> uslices_list = new List<UnitSliceType> ();
				IList<InterfaceSliceType> islices_list = new List<InterfaceSliceType> ();

				foreach (Tuple<string,string,string> slice in r.Key.Value) 
				{
					string cRef = component_refs [slice.Item1].instance_ref;

					bool hasSlice = slice_counter.ContainsKey (slice);
					int slice_replica = hasSlice ? slice_counter [slice] : 0;
					if (hasSlice) slice_counter.Remove (slice);
					slice_counter.Add (slice, slice_replica + 1);

					UnitSliceType us = new UnitSliceType ();
					us.cRef = cRef;
					us.uRef = slice.Item2; 
					us.sliceName = cRef;
					us.slice_replica = slice_replica;
					us.transitive = false;
					uslices_list.Add (us);

					InterfaceSliceType fs = new InterfaceSliceType ();
					fs.isRef = cRef;
					fs.originRef = new InterfaceRefType ();
					fs.originRef.cRef = cRef;
					fs.originRef.iRef = slice.Item3;
					islices_list.Add (fs);
				}

				cu.slices = new UnitSliceType[uslices_list.Count];
				uslices_list.CopyTo (cu.slices, 0);

				ct.slice = new InterfaceSliceType[islices_list.Count];
				islices_list.CopyTo (ct.slice, 0);

				body_items.Add (ct);

				body_items.Add (cu);
			}

			IList<UnitSliceType> uslices_root_list = new List<UnitSliceType> ();
			IList<InterfaceSliceType> islices_root_list = new List<InterfaceSliceType> ();

			// ROOT UNIT
			UnitType ru = new UnitType ();
			ru.facet = 0;
			ru.iRef = "IRoot";
			ru.multiple = false;
			ru.@private = false;
			ru.replica = 0;
			ru.uRef = "root";   
			ru.visibleInterface = true;

			// APPLICATION UNIT SLICE OF THE ROOT UNIT
			UnitSliceType u_slice_app = new UnitSliceType ();
			u_slice_app.cRef = application_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME];
			u_slice_app.uRef = application_attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT]; 
			u_slice_app.sliceName = u_slice_app.cRef;
			u_slice_app.slice_replica = 0;
			u_slice_app.transitive = false;
			uslices_root_list.Add (u_slice_app);

			// WORKFLOW UNIT SLICE OF THE ROOT UNIT
			UnitSliceType u_slice_wrf = new UnitSliceType ();
			u_slice_wrf.cRef = workflow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME];
			u_slice_wrf.uRef = workflow_attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT]; 
			u_slice_wrf.sliceName = u_slice_wrf.cRef;
			u_slice_wrf.slice_replica = 0;
			u_slice_wrf.transitive = false;
			uslices_root_list.Add (u_slice_wrf);

			// ROOT UNIT INTERFACE
			InterfaceType rt = new InterfaceType ();
			rt.iRef = "IRoot";
			rt.nArgs = 0;
			rt.sources = null; //??

			// APPLICATION INTERFACE SLICE OF THE ROOT UNIT
			InterfaceSliceType i_slice_app = new InterfaceSliceType ();
			i_slice_app.isRef = u_slice_app.cRef;
			i_slice_app.originRef = new InterfaceRefType ();
			i_slice_app.originRef.cRef = u_slice_app.cRef;
			i_slice_app.originRef.iRef = application_attributes[ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT];
			islices_root_list.Add (i_slice_app);

			// WORKFLOW INTERFACE SLICE OF THE ROOT UNIT
			InterfaceSliceType i_slice_wrf = new InterfaceSliceType ();
			i_slice_wrf.isRef = u_slice_wrf.cRef;
			i_slice_wrf.originRef = new InterfaceRefType ();
			i_slice_wrf.originRef.cRef = u_slice_wrf.cRef;
			i_slice_wrf.originRef.iRef = workflow_attributes[ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT];
			islices_root_list.Add (i_slice_wrf);

			IList<InterfacePortType> iports_root_list = new List<InterfacePortType> ();

			int counter = 0;

			// TRANSITIVE SLICES (environment ports) OF THE APPLICATION SLICE
			foreach (Tuple<string, string, EnvironmentPortType> slice in bindings_application) 
			{
				string port_name = slice.Item2 + (counter++);

				// UNIT SLICES
				UnitSliceType us = new UnitSliceType ();
				us.cRef = port_name;
				us.uRef = Constants.envUnitName[slice.Item3]; 
				us.sliceName = port_name;
				us.slice_replica = 0;
				us.transitive = true;
				uslices_root_list.Add (us);

				// INTERFACE PORTS (TRANSITIVE SLICES)
				InterfacePortType fs = new InterfacePortType ();
				fs.name = port_name;
				fs.slice = new PortSliceType[1];
				fs.slice[0].pRef = application_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME];
				fs.slice[0].sRef = port_name;
				iports_root_list.Add (fs);
			}

			counter = 0;

			// TRANSITIVE SLICES (environment ports) OF THE WORKFLOW SLICE
			foreach (Tuple<string, string, EnvironmentPortType> slice in bindings_workflow) 
			{
				string port_name = slice.Item2 + (counter++);

				// UNIT SLICES
				UnitSliceType us = new UnitSliceType ();
				us.cRef = port_name;
				us.uRef = Constants.envUnitName[slice.Item3]; 
				us.sliceName = port_name;
				us.slice_replica = 0;
				us.transitive = true;
				uslices_root_list.Add (us);

				// INTERFACE PORTS (TRANSITIVE SLICES)
				InterfacePortType fs = new InterfacePortType ();
				fs.name = port_name;
				fs.slice = new PortSliceType[1];
				fs.slice[0].pRef = workflow_attributes[ProxyComponentAttribute.INNER_COMPONENT_NAME];
				fs.slice[0].sRef = port_name;
				iports_root_list.Add (fs);
			}

			ru.slices = new UnitSliceType[uslices_root_list.Count];
			uslices_root_list.CopyTo (ru.slices, 0);

			rt.slice = new InterfaceSliceType[islices_root_list.Count];
			islices_root_list.CopyTo (rt.slice, 0);

			rt.port = new InterfacePortType[iports_root_list.Count];
			iports_root_list.CopyTo (rt.port, 0);
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
				value = (IList<Tuple<string,string,string>>) value.OrderBy (x => x.Item1 + x.Item2);

				string key = "";
				foreach (Tuple<string,string,string> v in value)
					key += v.Item1 + v.Item2;

				return key.GetHashCode();

				//return this.FooId.GetHashCode();
			}
		
		}



		static ComponentType createSystemConcrete (string app_name, ComponentType system_abstract)
		{
			ComponentType system_concrete = new ComponentType ();

			ComponentHeaderType h = system_concrete.header = new ComponentHeaderType();
			h.hash_component_UID = null; //?
			h.isAbstract = false; 
			h.kind = SupportedKinds.System;
			h.name = "SystemImpl"; 
			h.packagePath = app_name;

			h.baseType.extensionType = new ExtensionTypeType();
			h.baseType.extensionType.Item = true;
			h.baseType.extensionType.ItemElementName = ItemChoiceType1.implements;

			h.baseType.component = new ComponentInUseType();
			h.baseType.component.package = app_name;
			h.baseType.component.name = "System";
			h.baseType.component.localRef = "base";
			h.baseType.component.multiple = false;

			IList<object> body_items = new List<object> ();

			foreach (object o in system_abstract.componentInfo) 
			{
				if (o is UnitType) 
				{
					UnitType u = (UnitType)o; 

					UnitType cu = new UnitType ();

					cu.facet = 0;
					cu.iRef = u.iRef + "Impl";
					cu.multiple = false;
					cu.@private = false;
					cu.replica = 0;
					cu.uRef = u.uRef;   
					cu.visibleInterface = true;

					UnitRefType uRef = new UnitRefType ();
					uRef.cRef = "base";
					uRef.uRef = u.uRef;
					cu.super = uRef;

					body_items.Add (cu);

				} 
				else if (o is InterfaceType) 
				{
					InterfaceType i = (InterfaceType)o;

					InterfaceType ct = new InterfaceType ();

					ct.iRef = i.iRef + "Impl";
					ct.nArgs = 0;
					ct.sources = null; //?

					body_items.Add (ct);
				}
			}

			system_concrete.componentInfo = new object[body_items.Count];
			body_items.CopyTo (system_concrete.componentInfo, 0);

			return system_concrete;
		}

		public static void deploySystemComponent() 
		{
			deployApplicationComponent ();
			deployWorkflowComponent ();
		}


		#region Application Component

		static Tuple<ComponentType,ComponentType> createApplicationComponent (string app_name, IList<Tuple<string, string, EnvironmentPortType>> bindings_application, ref IList<string> port_names, IDictionary<ProxyComponentAttribute,string> attributes)
		{
			ComponentType cAbs = createApplicationComponentAbstract (app_name, bindings_application, ref port_names, attributes);
			ComponentType cCon = createApplicationComponentConcrete (app_name, attributes);
			return new Tuple<ComponentType,ComponentType> (cAbs, cCon);
		}

		static ComponentType createApplicationComponentAbstract (string app_name, IList<Tuple<string, string, EnvironmentPortType>> bindings_application, ref IList<string> port_names, IDictionary<ProxyComponentAttribute,string> attributes)
		{
			ComponentType c = new ComponentType ();

			ComponentHeaderType h = c.header = new ComponentHeaderType();
			h.hash_component_UID = null; //?
			h.isAbstract = true; 
			h.kind = SupportedKinds.Proxy;
			h.name = attributes[ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT]; 
			h.packagePath = app_name; 

			IList<object> body_items = new List<object> ();

			// ADD INNER COMPONENTS (many, one for each environment bindind)
			createApplicationComponentAbstractInner (body_items, bindings_application, ref port_names);

			// NO PARAMETERS
			// NO SUPPLY PARAMTERS
			// NO INNER RENAMING
			// NO FUSION
			// NO SPLIT
			// NO RECURSIVE ENTRY

			// ADD UNIT (single)
			createApplicationComponentAbstractUnit (body_items, bindings_application, attributes);

			// ADD INTERFACE
			createApplicationComponentAbstractInterface (body_items, bindings_application, attributes);

			// NO FUSION OF REPLICATORS

			// NO EXTERNAL LIBRARIES

			c.componentInfo = new object[body_items.Count];
			body_items.CopyTo (c.componentInfo, 0);

			return c;
		}

		static void createApplicationComponentAbstractInner (IList<object> body_items, IList<Tuple<string, string, EnvironmentPortType>> bindings_application, ref IList<string> port_names)
		{
			int port_count = 0;
			port_names = new List<string> ();

			foreach (Tuple<string, string, EnvironmentPortType> binding in bindings_application)
			{
				string componentRef = binding.Item1;
				string port_name = binding.Item2;

				// search for the type of the component connected to the application through the environment port
				AbstractComponentFunctor acf = backend.DGAC.BackEnd.acfdao.retrieve_libraryPath (componentRef);

				// search for the type of the environment port in the inner component.
				InnerComponent ic = backend.DGAC.BackEnd.icdao.retrieve (acf.Id_abstract, port_name);
				AbstractComponentFunctor acf_inner = backend.DGAC.BackEnd.acfdao.retrieve (ic.Id_abstract_inner);
				String library_path = acf_inner.Library_path;

				InnerComponentType ci = new InnerComponentType ();
				ci.package = acf_inner.Package;
				ci.name = acf_inner.Name;
				ci.localRef = port_name + (port_count++); 
				ci.multiple = false;
				ci.exposed = true;

				port_names.Add (ci.localRef);

				body_items.Add (ci);
			}

		}

		static void createApplicationComponentAbstractInterface (IList<object> body_items, IList<Tuple<string, string, EnvironmentPortType>> bindings_application, IDictionary<ProxyComponentAttribute,string> attributes)
		{
			InterfaceType ct = new InterfaceType ();

			ct.iRef = attributes[ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT];
			ct.nArgs = 0;
			ct.sources = null; //?

			IList<InterfaceSliceType> slices_list = createApplicationComponentAbstractInterfaceSlices (bindings_application);
			ct.slice = new InterfaceSliceType[slices_list.Count];
			slices_list.CopyTo (ct.slice, 0);

			body_items.Add (ct);
		}

		static IList<InterfaceSliceType> createApplicationComponentAbstractInterfaceSlices (IList<Tuple<string, string, EnvironmentPortType>> bindings_application)
		{
			int port_counter = 0;

			IList<InterfaceSliceType> slices_list = new List<InterfaceSliceType> ();
			foreach (Tuple<string, string, EnvironmentPortType> binding in bindings_application) 
			{
				string port_name = binding.Item2 + (port_counter++);
				string slice_unit_name = Constants.envUnitName[binding.Item3];

				InterfaceSliceType s = new InterfaceSliceType ();
				s.isRef = port_name;
				s.originRef = new InterfaceRefType ();
				s.originRef.cRef = port_name;
				s.originRef.iRef = Constants.envInterfaceName[binding.Item3];
				s.visualDescription = null;
				slices_list.Add (s);
			}

			return slices_list;
		}

		static void createApplicationComponentAbstractUnit (IList<object> body_items, IList<Tuple<string, string, EnvironmentPortType>> bindings_application, IDictionary<ProxyComponentAttribute,string> attributes)
		{
			UnitType cu = new UnitType ();

			cu.facet = 0;
			cu.iRef = attributes[ProxyComponentAttribute.INTERFACE_NAME_ABSTRACT];
			cu.multiple = false;
			cu.@private = false;
			cu.replica = 0;
			cu.uRef = attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT];   
			cu.visibleInterface = true;

			IList<UnitSliceType> slices_list = createApplicationComponentAbstractUnitSlices (bindings_application);
			cu.slices = new UnitSliceType[slices_list.Count];
			slices_list.CopyTo (cu.slices, 0);

			body_items.Add (cu);
		}

		static IList<UnitSliceType> createApplicationComponentAbstractUnitSlices (IList<Tuple<string, string, EnvironmentPortType>> bindings_application)
		{
			int port_counter = 0;

			IList<UnitSliceType> slices_list = new List<UnitSliceType> ();
			foreach (Tuple<string, string, EnvironmentPortType> binding in bindings_application) 
			{
				string port_name = binding.Item2 + (port_counter++);
				string slice_unit_name = Constants.envUnitName[binding.Item3];

				UnitSliceType s = new UnitSliceType ();
				s.cRef = port_name;
				s.uRef = slice_unit_name; 
				s.sliceName = port_name;
				s.slice_replica = 0;
				s.transitive = true;
				slices_list.Add (s);
			}

			return slices_list;
		}

		static ComponentType createApplicationComponentConcrete (string app_name, IDictionary<ProxyComponentAttribute,string> attributes)
		{
			ComponentType c = new ComponentType ();

			ComponentHeaderType h = c.header = new ComponentHeaderType();
			h.hash_component_UID = null; //?
			h.isAbstract = false; 
			h.kind = SupportedKinds.Proxy;
			h.name = attributes[ProxyComponentAttribute.COMPONENT_NAME_CONCRETE]; 
			h.packagePath = app_name;

			h.baseType.extensionType = new ExtensionTypeType();
			h.baseType.extensionType.Item = true;
			h.baseType.extensionType.ItemElementName = ItemChoiceType1.implements;

			h.baseType.component = new ComponentInUseType();
			h.baseType.component.package = app_name;
			h.baseType.component.name = attributes[ProxyComponentAttribute.COMPONENT_NAME_ABSTRACT];
			h.baseType.component.localRef = "base";
			h.baseType.component.multiple = false;

			IList<object> body_items = new List<object> ();

			// ADD INNER COMPONENTS (many, one for each environment bindind)
			// NO INNER COMPONENTS

			// NO PARAMETERS
			// NO SUPPLY PARAMTERS
			// NO INNER RENAMING
			// NO FUSION
			// NO SPLIT
			// NO RECURSIVE ENTRY

			// ADD UNIT (single)
			createApplicationComponentConcreteUnit (body_items, attributes);

			// ADD INTERFACE
			createApplicationComponentConreteInterface (body_items, attributes);

			// NO FUSION OF REPLICATORS

			// NO EXTERNAL LIBRARIES

			c.componentInfo = new object[body_items.Count];
			body_items.CopyTo (c.componentInfo, 0);

			return c;
		}

		static void createApplicationComponentConreteInterface (IList<object> body_items, IDictionary<ProxyComponentAttribute,string> attributes)
		{
			InterfaceType ct = new InterfaceType ();

			ct.iRef = attributes[ProxyComponentAttribute.INTERFACE_NAME_CONCRETE];
			ct.nArgs = 0;
			ct.sources = null; //?

			body_items.Add (ct);
		}

		static void createApplicationComponentConcreteUnit (IList<object> body_items, IDictionary<ProxyComponentAttribute,string> attributes)
		{
			UnitType cu = new UnitType ();

			cu.facet = 0;
			cu.iRef = attributes[ProxyComponentAttribute.INTERFACE_NAME_CONCRETE];
			cu.multiple = false;
			cu.@private = false;
			cu.replica = 0;
			cu.uRef = attributes[ProxyComponentAttribute.UNIT_NAME_CONCRETE];   
			cu.visibleInterface = true;

			UnitRefType uRef = new UnitRefType ();
			uRef.cRef = "base";
			uRef.uRef = attributes[ProxyComponentAttribute.UNIT_NAME_ABSTRACT];
			cu.super = uRef;

			body_items.Add (cu);
		}

		#endregion Application Component



		static void deployApplicationComponent ()
		{
			throw new System.NotImplementedException ();
		}

		static void deployWorkflowComponent ()
		{
			throw new System.NotImplementedException ();
		}

	}
}
