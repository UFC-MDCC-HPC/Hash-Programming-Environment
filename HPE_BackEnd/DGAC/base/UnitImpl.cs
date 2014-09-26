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

namespace br.ufc.pargo.hpe.basic
{

	public class GoPortWrapper : MarshalByRefObject, gov.cca.ports.GoPort
	{
		public delegate int Go_app();
		
		private Go_app go_app;
		
		
		public GoPortWrapper(Go_app go_app)
		{
			this.go_app = go_app;
		}
		
		
		#region GoPort implementation
		public int go ()
		{
			return go_app();
			
		}
		#endregion
	}
	
	public class InitializePortWrapper : MarshalByRefObject, InitializePort
	{
		
		public delegate void MTH();
		
		private MTH initialize_mth;
		private MTH after_initialize_mth;
		
		
		public InitializePortWrapper(MTH initialize_mth, MTH after_initialize_mth)
		{
			this.initialize_mth = initialize_mth;
			this.after_initialize_mth = after_initialize_mth;
		}
		#region AutomaticSlicesPort implementation
		public void initialize ()
		{
			this.initialize_mth();
		}

		public void post_initialize ()
		{
			this.after_initialize_mth();
		}
		#endregion


	}
	
	public class ReconfigurationAdvicePortWrapper : MarshalByRefObject, ReconfigurationAdvicePort
	{
		
		public delegate void MTH(string portName);
		
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

    //[Serializable]
    public abstract class Unit : MarshalByRefObject, IUnit
    {
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
			{
					services.registerUsesPort(portName, "", new TypeMapImpl());
			}
			
            services.addProvidesPort(this, Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS, this.ClassName, new TypeMapImpl());
			
			InitializePort initialize_port_wrapper = new InitializePortWrapper(((InitializePort)this).initialize, ((InitializePort)this).post_initialize);                        
            services.addProvidesPort(initialize_port_wrapper, Constants.INITIALIZE_PORT_NAME, Constants.INITIALIZE_PORT_TYPE, new TypeMapImpl());

			ReconfigurationAdvicePort reconfiguration_port_wrapper = new ReconfigurationAdvicePortWrapper(((ReconfigurationAdvicePort)this).changePort);                        
            services.addProvidesPort(reconfiguration_port_wrapper, Constants.RECONFIGURE_PORT_NAME, Constants.RECONFIGURE_PORT_TYPE, new TypeMapImpl());
			
			if (Kind == Constants.KIND_APPLICATION) {	
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
        virtual public void initialize()
        {
        }
        
		[MethodImpl(MethodImplOptions.Synchronized)]
        virtual public void post_initialize()
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

		public void calculate_topology ()
		{
			string[] rank_units = this.Communicator.Allgather<string>(this.Id_unit);
			
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
