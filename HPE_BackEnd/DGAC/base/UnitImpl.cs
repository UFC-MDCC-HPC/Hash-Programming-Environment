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
	[ServiceContract]
	public class GoPortWrapper : gov.cca.ports.GoPort
	{
		public delegate int Go_app();

		[DataMember]
		private Go_app go_app;
		
		
		public GoPortWrapper(Go_app go_app)
		{
			this.go_app = go_app;
		}
		
		
		#region GoPort implementation
		public int go ()
		{
			int r;
			Trace.WriteLine ("BEFORE CALLING GO " + this.go_app);
			r = go_app();
			Trace.WriteLine ("AFTER CALLING GO " + this.go_app);
			return r;
		}
		#endregion
	}

	[DataContract]
	public class InitializePortWrapper : InitializePort
	{		
		public delegate void MTH();

	    private MTH initialize_mth;

		private MTH after_initialize_mth;

		[DataMember]
		public MTH InitializeMth { get { return initialize_mth; } set { this.initialize_mth = value; } }

		[DataMember]
		public MTH AfterInitializeMth { get { return after_initialize_mth; } set { this.after_initialize_mth = value; } }

		public InitializePortWrapper()
		{
		}

		public InitializePortWrapper(MTH initialize_mth, MTH after_initialize_mth)
		{
			this.initialize_mth = initialize_mth;
			this.after_initialize_mth = after_initialize_mth;
		}
		#region AutomaticSlicesPort implementation
		public void on_initialize ()
		{
			this.initialize_mth();
		}

		public void after_initialize ()
		{
			this.after_initialize_mth();
		}
		#endregion


	}

	[DataContract]
	public class ReconfigurationAdvicePortWrapper : ReconfigurationAdvicePort
	{
		
		public delegate void MTH(string portName);
		
		[DataMember]
		private MTH changePort_mth;
		
		public ReconfigurationAdvicePortWrapper(MTH changePort_mth)
		{
			this.changePort_mth = changePort_mth;
		}
		#region ReconfigurationAdvicePort implementation
		public void changePort (string portName)
		{
			this.changePort_mth(portName);
		}
		#endregion


	}

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
			
			InitializePort initialize_port_wrapper = new InitializePortWrapper(((InitializePort)this).on_initialize, ((InitializePort)this).after_initialize);                        
            services.addProvidesPort(initialize_port_wrapper, Constants.INITIALIZE_PORT_NAME, Constants.INITIALIZE_PORT_TYPE, new TypeMapImpl());

			ReconfigurationAdvicePort reconfiguration_port_wrapper = new ReconfigurationAdvicePortWrapper(((ReconfigurationAdvicePort)this).changePort);                        
            services.addProvidesPort(reconfiguration_port_wrapper, Constants.RECONFIGURE_PORT_NAME, Constants.RECONFIGURE_PORT_TYPE, new TypeMapImpl());
			
			if (Kind == Constants.KIND_APPLICATION) 
			{	
				gov.cca.ports.GoPort app_port_wrapper = new GoPortWrapper(((gov.cca.ports.GoPort) this).go);
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
        }
        
		[MethodImpl(MethodImplOptions.Synchronized)]
        virtual public void after_initialize()
        {
        }
		
        private Intracommunicator global_comm = null;        
        public Intracommunicator WorldComm {get { return global_comm; } set { this.global_comm = value; }}
		public int GlobalRank {get {return WorldComm.Rank;}}   // Number of the parallel units.		
		public int GlobalSize {get {return WorldComm.Size;}}   // Number of the parallel units.		

        private Intracommunicator local_comm = null;
        public Intracommunicator Communicator {get { return local_comm; } set { this.local_comm = value; }}
		public int Rank {get {return Communicator.Rank;}}   
		public int Size {get {return Communicator.Size;}}  		

        private Intracommunicator peer_comm = null;
        public Intracommunicator PeerComm {get { return peer_comm; } set { this.peer_comm = value; }}
        public int PeerRank {get {return PeerComm.Rank; }}   
		public int PeerSize { get { return PeerComm.Size; }}


		IDictionary<string, int[]> unit_ranks = new Dictionary<string, int[]>();
 		public IDictionary<string, int[]> UnitRanks { get { return unit_ranks; } }

		IDictionary<string, int> unit_size = new Dictionary<string, int>();
		public IDictionary<string, int> UnitSize { get { return unit_size; } }

		public bool IsParallelUnit {get { return PeerSize > 1; }}
		public bool IsSingletonUnit {get { return !IsParallelUnit; }}

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


		public void calculate_topology ()
		{
			string[] rank_units = this.Communicator.Allgather<string>(this.Id_unit);

			Trace.WriteLine (this.Rank + " ALL GATHER :");
			foreach (string unit_id in rank_units) Trace.Write (unit_id + ",");
			Console.WriteLine (".");
			
			IDictionary<string, IList<int>> unit_rank_list = new Dictionary<string, IList<int>>();

			for (int rank=0; rank < rank_units.Length; rank++)
			{
				string id_unit = rank_units[rank];
				IList<int> ranks;
				if (!unit_rank_list.TryGetValue(id_unit, out ranks)) 
				{
					ranks = new List<int>();
					unit_rank_list.Add(id_unit, ranks);
					unit_size.Add(id_unit, 0);
				} 
				ranks.Add(rank);
				int count = unit_size[id_unit];
				unit_size.Remove(id_unit);
				unit_size.Add(id_unit, count + 1);
			}
			
			foreach (KeyValuePair<string, IList<int>> unit_rank_item in unit_rank_list)
			{
				string id_unit = unit_rank_item.Key;
				IList<int> ranks = unit_rank_item.Value;
				int[] ranks_array = new int[ranks.Count];
				ranks.CopyTo(ranks_array,0);
				this.unit_ranks.Add(id_unit,ranks_array);
			}
		}
		public void configure_facet_topology(int[] facet_topology, Instantiator.UnitMappingType[] unit_mapping)
		{
			Trace.WriteLine ("configure_facet_topology 1 - " + facet_topology.Length);
			foreach (int f in facet_topology)
				Trace.Write (f + ",");
			Trace.WriteLine (".");

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

			Trace.WriteLine ("configure_facet_topology 2 - " + facet_instances_list.Count);

			foreach (KeyValuePair<int,IList<int>> f in facet_instances_list) 
			{
				int facet = f.Key;
				IList<int> facet_instance_list = f.Value;
				FacetMultiplicity.Add (facet, facet_instance_list.Count);
				int[] facet_instance_array = new int[FacetMultiplicity [facet]];
				facet_instance_list.CopyTo (facet_instance_array, 0);
				FacetIndexes.Add (facet, facet_instance_array);
			}

			foreach (KeyValuePair<int,int[]> kv in FacetIndexes) 
			{
				Trace.Write ("configure_facet_topology - facet=" + kv.Key + ": ");
				foreach (int v in kv.Value)
					Trace.Write (v + " ");
				Trace.WriteLine (".");
			}

			foreach (KeyValuePair<int,int> kv in FacetMultiplicity) 
			{
				Trace.WriteLine ("configure_facet_topology - facet=" + kv.Key + " - size=" + kv.Value);
			}



			foreach (Instantiator.UnitMappingType unit_mapping_item in unit_mapping) 
			{
				int facet_instance = unit_mapping_item.facet_instance;
				string unit_id = unit_mapping_item.unit_id;
				int size = unit_mapping_item.node.Length;
				IDictionary<string,int> dict;
				Trace.WriteLine ("configure_facet_topology --- facet_instance="+facet_instance + " / unit_id="+unit_id + " / size=" + size);
				if (!UnitSizeInFacet.TryGetValue(facet_instance, out dict))
				{   dict = new Dictionary<string, int> ();
					UnitSizeInFacet [facet_instance] = dict; 
				}
				dict[unit_id] = size;
			}

			foreach (KeyValuePair<int,IDictionary<string,int>> r in UnitSizeInFacet) 
				foreach(KeyValuePair<string,int> s in r.Value)
					Trace.WriteLine (this.GlobalRank + ": UnitSizeInFacet: facet_instance = " + r.Key + " --  unit_id = " + s.Key + " -- size = " + s.Value);
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
			Trace.WriteLine("CHANGE PORT " + portName + " OF " + CID);
			Slice[portName] = (IUnit) services.getPort (portName);
		}
		#endregion

    }
	
}
