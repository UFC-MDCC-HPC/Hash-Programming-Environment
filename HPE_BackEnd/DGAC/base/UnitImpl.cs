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

            // REGISTER USES PORTS !
            int id_abstract = this.Id_abstract;
            string id_interface = this.Id_unit;
			int partition_index = this.partition_index;
			
            AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(id_abstract);
            int slice_kind = Constants.kindMapping[acf.Kind];
            IList<Slice> sList = BackEnd.sdao.listByInterface(id_abstract, id_interface, partition_index);
			
            foreach (Slice slice in sList)
            {
			   InnerComponent ic = BackEnd.icdao.retrieve(slice.Id_abstract, slice.Id_inner);
			   AbstractComponentFunctor acf_inner = BackEnd.acfdao.retrieve(ic.Id_abstract_inner);
				
			   int slice_kind_inner = Constants.kindMapping[acf_inner.Kind];
                // The uses port name will be the name of the property
               if (slice_kind_inner != Constants.KIND_QUALIFIER) {		
			   	   services.registerUsesPort(slice.Id_inner, "", new TypeMapImpl());
			   }
            }
			
            Interface i = BackEnd.idao.retrieve(id_abstract, id_interface, partition_index);  
			
            services.addProvidesPort(this, Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS, i.Class_name, new TypeMapImpl());
			
			InitializePort initialize_port_wrapper = new InitializePortWrapper(((InitializePort)this).initialize, ((InitializePort)this).post_initialize);                        
            services.addProvidesPort(initialize_port_wrapper, Constants.INITIALIZE_PORT_NAME, Constants.INITIALIZE_PORT_TYPE, new TypeMapImpl());
			
			ReconfigurationAdvicePort reconfiguration_port_wrapper = new ReconfigurationAdvicePortWrapper(((ReconfigurationAdvicePort)this).changePort);                        
            services.addProvidesPort(reconfiguration_port_wrapper, Constants.RECONFIGURE_PORT_NAME, Constants.RECONFIGURE_PORT_TYPE, new TypeMapImpl());
			
			if (slice_kind == Constants.KIND_APPLICATION) {		
				gov.cca.ports.GoPort app_port_wrapper = new GoPortWrapper(((gov.cca.ports.GoPort) this).go);
			    services.addProvidesPort(app_port_wrapper, Constants.GO_PORT_NAME, Constants.GO_PORT_TYPE, new TypeMapImpl());
			}
        }




        private int id_concrete;

        public int Id_concrete
        {
            get { return id_concrete; }
            set { id_concrete = value; }
        }

        protected string id_interface;

        public string Id_unit
        {
            get { return id_interface; }
            set { id_interface = value; }
        }

        private int partition_index;

        public int PartitionIndex
        {
            get { return partition_index; }
            set { partition_index = value; }
        }

		private IDictionary<IUnit,string> id_inner_map = null;
        
		public string getSliceName(IUnit container)
		{
			if (id_inner_map == null)
				id_inner_map = new Dictionary<IUnit,string>();
			
			string id_inner;
			if (container == null) return "top";
			if (id_inner_map.TryGetValue(container, out id_inner))
				return id_inner;
			return null;
		}
		
		private void set_id_inner(IUnit container, string id_inner)
		{
			if (id_inner_map == null)
				id_inner_map = new Dictionary<IUnit,string>();
			id_inner_map.Add(container,id_inner);
		}
		
        private int id_abstract = 0;
		
		private string qualified_type_name = null;
		
		public string QualifiedComponentTypeName
		{
			get 
			{
				if (qualified_type_name == null)
				{
					AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(Id_abstract);
					qualified_type_name = acf.Library_path;
				}
				return qualified_type_name;					
			}			
		}
			
		public int Id_abstract
        {
            get
            {
                if (id_abstract == 0 && this.Id_concrete > 0)
                {
                    br.ufc.pargo.hpe.backend.DGAC.database.Component c = BackEnd.cdao.retrieve(this.Id_concrete);
                    id_abstract = c.Id_abstract;					
                }
                return id_abstract;
            }
            //set { id_abstract = value; }
        }

        private IDictionary<string, int> actual_parameters = new Dictionary<string, int>();
        private IDictionary<string, int> actual_parameters_top = new Dictionary<string, int>();

        public IDictionary<string, int> ActualParameters
        {
            get { return actual_parameters; }
            set { actual_parameters = value; }
        }

        public IDictionary<string, int> ActualParametersTop
        {
            get { return actual_parameters_top; }
            set { actual_parameters_top = value; }
        }

       public ICollection<IUnit> AllSlices
       {
           get { return slice_map == null ? new List<IUnit>() : slice_map.Values; }
       }

        private void addSliceAll(IUnit slice)
        {
            if (slice_map == null) 
				slice_map = new Dictionary<string,IUnit>();
			string sliceName = slice.getSliceName(this);
			if (sliceName != null && !slice_map.ContainsKey(sliceName))
			{
            	slice_map.Add(sliceName, slice);
			}
        }
		
        private IList<IUnit> containerSlice = null;

        public IList<IUnit> ContainerSlice
        {
            get 
			{ 
				if (containerSlice == null) 
					containerSlice = new List<IUnit>();
			  	return containerSlice; 
			}
        }

	    public void addContainerSlice(IUnit u, string portName)
		{
			if (containerSlice == null) 
				containerSlice = new List<IUnit>();
			containerSlice.Add(u);
			set_id_inner(u, portName);
			((Unit)u).addSliceAll(this);			
		}


        virtual public void destroySlice()
        {
        }

		
        public void setActualParameters(IDictionary<string, int> actualParameters_new)
        {
            ActualParameters = actualParameters_new;
        }

        public void setUpParameters(int id_functor_app)
        {
            SupplyParameterDAO spdao = new SupplyParameterDAO();
            IList<SupplyParameter> spcList = spdao.list(id_functor_app);
            foreach (SupplyParameterComponent spc in spcList)
            {
                ActualParameters.Add(spc.Id_parameter, spc.Id_functor_app_actual);
            }
        }

        private IDictionary<string, int> enumeratorCardinality;

        public IDictionary<string, int> EnumeratorCardinality
        {
            get { return enumeratorCardinality; }
            set { enumeratorCardinality = value; }
        }

        private int id_functor_app;

        public int Id_functor_app
        {
            get { return id_functor_app; }
            set { id_functor_app = value; }
        }

/*        private IDictionary<string, br.ufc.pargo.hpe.kinds.IEnumeratorKind> permutations = null;

        public bool getPermutation(string id_enumerator, out br.ufc.pargo.hpe.kinds.IEnumeratorKind permutation)
        {
            if (permutations == null)
                permutations = new Dictionary<string, br.ufc.pargo.hpe.kinds.IEnumeratorKind>();
            return permutations.TryGetValue(id_enumerator, out permutation);
        }

        public void addPermutation(string id_enumerator, br.ufc.pargo.hpe.kinds.IEnumeratorKind u)
        {
            if (permutations == null)
                permutations = new Dictionary<string, br.ufc.pargo.hpe.kinds.IEnumeratorKind>();
            permutations.Add(id_enumerator, u);
            u.V = id_enumerator;
        }
		 */
		
        #region IUnit Members

        private ComponentID cid = null;

        public ComponentID CID
        {
            set
            {
                this.cid = value;
            }
            get
            {
                return cid;
            }
        }
		
		[MethodImpl(MethodImplOptions.Synchronized)]
        virtual public void initialize()
        {
        }
        
		[MethodImpl(MethodImplOptions.Synchronized)]
        virtual public void post_initialize()
        {
        }
		
        private Intracommunicator comm = null;
        
        public Intracommunicator WorldComm {get { return comm; } set { this.comm = value; }}

        #endregion
		
		protected int rank = -1;
		private int size = -1;
		private int[] ranks = null;
		private int global_rank = -1;
		
        public int Rank {get {return rank;} set {rank = value;}}   // Rank of the parallel unit.
		public int Size {get {return size;} set {size = value;}}   // Number of the parallel units.		
		public int[] Ranks {get {return ranks;} set {ranks = value;}}   // Number of the parallel units.		
		public int GlobalRank {get {return global_rank;} set {global_rank = value;}}   // Number of the parallel units.		
		
		private IDictionary<string, IUnit> slice_map = new Dictionary<string, IUnit>();
		
		#region IUnit implementation
		public IDictionary<string, IUnit> Slice {
			get {
				return slice_map;
			}
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
