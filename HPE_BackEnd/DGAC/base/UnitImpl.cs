// /home/jefferson/projetos/appexample/appexample/kinds/DataKind.cs created with MonoDevelop
// User: jefferson at 11:14 30/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Runtime.Serialization;
using System.ServiceModel;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.ports;
using gov.cca;
using MPI;

namespace br.ufc.pargo.hpe.basic
{
    [ServiceContract]
	[ServiceBehavior(InstanceContextMode=InstanceContextMode.Single,
		ConcurrencyMode=ConcurrencyMode.Multiple)]
	[CallbackBehavior(UseSynchronizationContext = false)] 
	public class GoPortWrapper : gov.cca.ports.GoPort
	{
		public delegate int Go_app();

		[DataMember]
		private Go_app go_app;
		System.Type t = null;
		
		
		public GoPortWrapper(Go_app go_app, System.Type t)
		{
			this.go_app = go_app;
			this.t = t;
		}
		
		
		#region GoPort implementation
		public int go ()
		{
			int r;
			Console.WriteLine ("BEFORE CALLING GO " + t.FullName);
			r = go_app();	
			Console.WriteLine ("AFTER CALLING GO " + t.FullName);
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
			Console.WriteLine ("BEGIN ON_INITIALIZE");
			this.initialize_mth();
			Console.WriteLine ("END ON_INITIALIZE");
		}

		public void after_initialize ()
		{
			Console.WriteLine ("BEGIN AFTER_INITIALIZE");
			this.after_initialize_mth();
			Console.WriteLine ("END AFTER_INITIALIZE");
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

			Console.WriteLine("---- BEFORE REGISTERING USES PORT {0} {1} {2}", this.ThisFacet, this.Id_unit, this.CID);

            foreach (string portName in PortNames)
					services.registerUsesPort(portName, "", new TypeMapImpl());

            services.addProvidesPort(this, Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS, this.ClassName, new TypeMapImpl());
			
			InitializePort initialize_port_wrapper = new InitializePortWrapper(((InitializePort)this).on_initialize, ((InitializePort)this).after_initialize);                        
            services.addProvidesPort(initialize_port_wrapper, Constants.INITIALIZE_PORT_NAME, Constants.INITIALIZE_PORT_TYPE, new TypeMapImpl());

			ReconfigurationAdvicePort reconfiguration_port_wrapper = new ReconfigurationAdvicePortWrapper(((ReconfigurationAdvicePort)this).changePort);                        
            services.addProvidesPort(reconfiguration_port_wrapper, Constants.RECONFIGURE_PORT_NAME, Constants.RECONFIGURE_PORT_TYPE, new TypeMapImpl());
			
			if (Kind == Constants.KIND_COMPUTATION || Kind == Constants.KIND_SYNCHRONIZER || Kind == Constants.KIND_APPLICATION) 
			{	
				gov.cca.ports.GoPort app_port_wrapper = new GoPortWrapper(((gov.cca.ports.GoPort) this).go, this.GetType());
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

			Console.WriteLine (this.Rank + "- ALL GATHER :");
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
			IDictionary<int,IList<int>> facet_instances_list = new Dictionary<int, IList<int>> ();

            foreach (Instantiator.UnitMappingType unit_mapping_item in unit_mapping)
            {
                int facet = unit_mapping_item.facet;
                int facet_instance = unit_mapping_item.facet_instance;
				IList<int> facet_instance_list = null;
				if (!facet_instances_list.TryGetValue(facet, out facet_instance_list))
				{
					facet_instance_list = new List<int>();
					facet_instances_list.Add(facet, facet_instance_list);
				}
				facet_instance_list.Add(facet_instance);
			}


			/*for (int facet_instance = 0; facet_instance < facet_topology.Length; facet_instance++) 
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
			}*/

			Console.WriteLine ("{1} - facet_instance={0}, configure_facet_topology 2 - " + facet_instances_list.Count, this_facet_instance, this.GetHashCode());

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
				Console.Write ("{1} - facet_instance={0}, configure_facet_topology - facet=" + kv.Key + ": ", this_facet_instance, this.GetHashCode());
				foreach (int v in kv.Value)
					Trace.Write (v + " ");
				Console.WriteLine (".");
			}

			foreach (KeyValuePair<int,int> kv in FacetMultiplicity) 
			{
				Console.WriteLine ("{1} - facet_instance={0}, configure_facet_topology - facet=" + kv.Key + " - size=" + kv.Value, this_facet_instance, this.GetHashCode());
			}



			foreach (Instantiator.UnitMappingType unit_mapping_item in unit_mapping) 
			{
				int facet_instance = unit_mapping_item.facet_instance;
                int facet = unit_mapping_item.facet;
				string unit_id = unit_mapping_item.unit_id;
				int size = unit_mapping_item.node.Length;
				IDictionary<string,int> dict;
                Console.WriteLine("{1} - facet_instance={0}, configure_facet_topology --- facet=" + facet + " / facet_instance=" + facet_instance + " / unit_id=" + unit_id + " / size=" + size, this_facet_instance, this.GetHashCode());
				if (!UnitSizeInFacet.TryGetValue(facet_instance, out dict))
				{   dict = new Dictionary<string, int> ();
					UnitSizeInFacet [facet_instance] = dict; 
				}
				dict[unit_id] = size;
			}

			foreach (KeyValuePair<int,IDictionary<string,int>> r in UnitSizeInFacet) 
				foreach(KeyValuePair<string,int> s in r.Value)
					Console.WriteLine ("{1} - facet_instance={0}, " + this.GlobalRank + ": UnitSizeInFacet: facet_instance = " + r.Key + " --  unit_id = " + s.Key + " -- size = " + s.Value, this_facet_instance, this.GetHashCode());
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
