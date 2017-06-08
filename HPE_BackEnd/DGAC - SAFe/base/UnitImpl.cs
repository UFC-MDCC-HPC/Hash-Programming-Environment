// /home/jefferson/projetos/appexample/appexample/kinds/DataKind.cs created with MonoDevelop
// User: jefferson at 11:14 30/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.database;
using br.ufc.pargo.hpe.backend.DGAC;
using gov.cca;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.ports;
using MPI;
using br.ufc.pargo.hpe.kinds;
using System.Runtime.CompilerServices;
using System.Diagnostics;
using Instantiator;
using System.Runtime.Serialization;
using System.ServiceModel;

namespace br.ufc.pargo.hpe.basic
{

    [DataContract]
    public abstract class Unit : IUnit
    {
		private bool trace_flag = false;

		public bool TraceFlag 
		{ 
			get { return trace_flag; }  
			set { trace_flag = value; } 
		}

       	public Unit()
        {
        }

        private gov.cca.Services services = null;

        /* The context object contains DGAC services. It will be shared by all slices of an application, passed downwards the hierarchy */
        public gov.cca.Services Services { get { return services; } }


        public void setServices(gov.cca.Services services)
        {
            this.services = services;
			
			foreach (string portName in PortNames)
					services.registerUsesPort(portName, "", new TypeMapImpl());

            services.addProvidesPort(this, Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS, this.ClassName, new TypeMapImpl());
			
			InitializePort initialize_port_wrapper = (InitializePort)this; 
            services.addProvidesPort(initialize_port_wrapper, Constants.INITIALIZE_PORT_NAME, Constants.INITIALIZE_PORT_TYPE, new TypeMapImpl());

			if (Kind == Constants.KIND_COMPUTATION || Kind == Constants.KIND_SYNCHRONIZER || Kind == Constants.KIND_APPLICATION) 
			{	
				gov.cca.ports.GoPort app_port_wrapper = (gov.cca.ports.GoPort)this; 
			    services.addProvidesPort(app_port_wrapper, Constants.GO_PORT_NAME, Constants.GO_PORT_TYPE, new TypeMapImpl());
			}
		}


        public void addSlice(IUnit slice, string portName)
        {
            if (slice_map == null) 
				slice_map = new Dictionary<string,IUnit>();
			if (portName != null && !slice_map.ContainsKey(portName))
			{
            	slice_map.Add(portName, slice);
			}
        }

        virtual public void destroySlice()
        {
        }

		#region IUnit Members

		[MethodImpl(MethodImplOptions.Synchronized)]
		virtual public void on_initialize()
		{
			Console.WriteLine("VIRTUAL ON INITIALIZE");
		}

		[MethodImpl(MethodImplOptions.Synchronized)]
		virtual public void after_initialize()
		{
			Console.WriteLine("VIRTUAL AFTER INITIALIZE");
		}



		public bool IsParallelUnit {get { return false; }}
		public bool IsSingletonUnit {get { return true; }}

		#region facet configuration

		private int this_facet;
		public int ThisFacet { get { return this_facet; } set {this_facet = value; } }

		private int this_facet_instance;
		public int ThisFacetInstance { get { return this_facet_instance; } set {this_facet_instance = value; } }

		private IDictionary<int,int[]> facet_indexes = new Dictionary<int, int[]>(); 
		public IDictionary<int,int[]> FacetIndexes { get { return facet_indexes; } }

		private IDictionary<int,int> facet_multiplicity = new Dictionary<int, int>(); 
		public IDictionary<int,int> FacetMultiplicity { get { return facet_multiplicity; } }

		private IDictionary<int, IDictionary<string,int>> unit_size_in_facet = new Dictionary<int, IDictionary<string, int>>();
		public IDictionary<int, IDictionary<string,int>> UnitSizeInFacet { get { return unit_size_in_facet; } }

		#endregion 


		public void configure_facet_topology(int[] facet_topology, Instantiator.UnitMappingType[] unit_mapping)
		{
			Console.WriteLine ("configure_facet_topology 1 - " + facet_topology.Length);
			foreach (int f in facet_topology)
				Trace.Write (f + ",");
			Console.WriteLine (".");

			IDictionary<int,IList<int>> facet_instances_list = new Dictionary<int, IList<int>> ();

			for (int facet_instance = 0; facet_instance < facet_topology.Length; facet_instance++) 
			{
				int facet = facet_topology [facet_instance];
				if (facet >= 0) 
				{
					IList<int> facet_instance_list = null;
					if (!facet_instances_list.TryGetValue (facet, out facet_instance_list)) 
					{
						facet_instance_list = new List<int> ();
						facet_instances_list.Add (facet, facet_instance_list);
					}
					facet_instance_list.Add (facet_instance);
				}
			}

			Console.WriteLine ("configure_facet_topology 2 - " + facet_instances_list.Count);

			foreach (KeyValuePair<int,IList<int>> f in facet_instances_list) 
			{
				int facet = f.Key;
				IList<int> facet_instance_list = f.Value;
				FacetMultiplicity.Add (facet, facet_instance_list.Count);
				int[] facet_instance_array = new int[FacetMultiplicity [facet]];
				facet_instance_list.CopyTo (facet_instance_array, 0);
				FacetIndexes.Add (facet, facet_instance_array);
			}

			foreach (Instantiator.UnitMappingType unit_mapping_item in unit_mapping) 
			{
				int facet_instance = unit_mapping_item.facet_instance;
				string unit_id = unit_mapping_item.unit_id;
				int size = unit_mapping_item.node.Length;
				IDictionary<string,int> dict;
				Console.WriteLine ("configure_facet_topology --- facet_instance="+facet_instance + " / unit_id="+unit_id + " / size=" + size);
				if (!UnitSizeInFacet.TryGetValue(facet_instance, out dict))
				{   dict = new Dictionary<string, int> ();
					UnitSizeInFacet [facet_instance] = dict; 
				}
				dict[unit_id] = size;
			}

		}
			
        private ComponentID cid = null;

        public ComponentID CID 
		{ 
			set { this.cid = value; }
            get { return cid; } 
		}

		protected string id_interface;

        public string Id_unit
        {
            get { return id_interface; }
            set { id_interface = value; }
        }
		private string qualified_type_name = null;
		
		public string QualifiedComponentTypeName
		{
			get { return qualified_type_name; }			
			set { this.qualified_type_name = value; }
		}
		
		private IDictionary<string, IUnit> slice_map = new Dictionary<string, IUnit>();

		public IDictionary<string, IUnit> Slice 
		{
			get { return slice_map; }
		}
		
		private string[] portNames = null;

		public string[] PortNames 
		{
			get { return this.portNames; }
			set { this.portNames = value; }
		}

		private string class_name = null;


		public string ClassName 
		{
			get { return this.class_name; }
			set { this.class_name = value; }
		}
				
		private int kind = -1;
		
		public int Kind
		{
			get { return this.kind; }
			set { this.kind = value;}
		}
		
		#endregion

		#region ReconfigurationAdvicePort implementation
		virtual public void changePort (string portName) 
		{ 
			Console.WriteLine("CHANGE PORT " + portName + " OF " + CID);
			Slice[portName] = (IUnit) services.getPort (portName);
		}
		#endregion

    }
	
}
