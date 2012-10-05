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
	
	public class AutomaticSlicesPortWrapper : MarshalByRefObject, AutomaticSlicesPort
	{
		
		public delegate void MTH();
		
		private MTH create_slices_mth;
		private MTH destroy_slices_mth;
		
		
		public AutomaticSlicesPortWrapper(MTH create_slices_mth, MTH destroy_slices_mth)
		{
			this.create_slices_mth = create_slices_mth;
			this.destroy_slices_mth = destroy_slices_mth;
		}
		#region AutomaticSlicesPort implementation
		public void create_slices ()
		{
			this.create_slices_mth();
		}

		public void destroy_slices ()
		{
			this.destroy_slices_mth();
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
                // The uses port name will be the name of the property
               services.registerUsesPort(slice.Id_inner/*slice.PortName*/, "", new TypeMapImpl());
            }
			
			
				
			
            Interface i = BackEnd.idao.retrieve(id_abstract, id_interface, partition_index);  
			
            services.addProvidesPort(this, Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS, i.Class_name, new TypeMapImpl());
			
			AutomaticSlicesPort create_slices_app_port_wrapper = new AutomaticSlicesPortWrapper(((AutomaticSlicesPort)this).create_slices, ((AutomaticSlicesPort)this).destroy_slices);
            services.addProvidesPort(create_slices_app_port_wrapper, Constants.CREATE_SLICES_PORT_NAME, Constants.CREATE_SLICES_PORT_TYPE, new TypeMapImpl());
			
			if (slice_kind == Constants.KIND_APPLICATION) {		
				gov.cca.ports.GoPort app_port_wrapper = new GoPortWrapper(((gov.cca.ports.GoPort) this).go);
			    services.addProvidesPort(app_port_wrapper, Constants.GO_PORT_NAME, Constants.GO_PORT_TYPE, new TypeMapImpl());
			}
        }

        #region CreateSlicesPort
		
		private IDictionary<string, bool> connected_slice = new Dictionary<string,bool>();
		
		[MethodImpl(MethodImplOptions.Synchronized)]
		public void create_slices()
		{
			create_slices(null);
		}
		
		[MethodImpl(MethodImplOptions.Synchronized)]
        public void create_slices(IUnit owner_unit)
        {
            Connector.openConnection();
            // CREATE SLICES !!!
			Console.WriteLine("BEGIN - SLICES OF " + id_abstract + " - " + this.getSliceName(owner_unit));
            
			IList<Slice> sList = BackEnd.sdao.listByInterface(id_abstract, id_interface, partition_index);
			
		//	foreach (Slice slice in sList)
		//	{
		//		Console.WriteLine("inner = " + slice.Id_inner + ", unit =" + slice.Id_interface_slice);
		//	}
		//	Console.WriteLine("END - SLICES OF " + this.get_id_inner(owner_unit));
			
			
            foreach (Slice slice in sList)
            {
                InnerComponent ic = BackEnd.icdao.retrieve(slice.Id_abstract, slice.Id_inner);
                AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(ic.Id_abstract_inner);
                int slice_kind = Constants.kindMapping[acf.Kind];
                if (slice_kind != Constants.KIND_QUALIFIER)
                {
					if (!this.connected_slice.ContainsKey(slice.Id_inner)) 
					{
	                    if (!slice.isPublic())
	                    {
	                        /* This method will:
	                         *   1. instantiate the inner component (local slice) if it is not yet be instantiated and connected
	                         *   2. connect the uses port to the implements (provides) port of the inner component                     * 
	                         */
	                        BackEnd.createSlice(this, slice);														
							connected_slice.Add(slice.Id_inner, true);
	                    }
	                    else
	                    {
							IUnit owner_unit_ = owner_unit;
							while (owner_unit_ != null) 
							{
		                        // Look for the port in the enclosing unit.
		                        ComponentID user_id = this.CID;
		                        string portName = slice.Id_inner; /*slice.PortName;*/
		                        ComponentID container_id = owner_unit_.CID;
		
		                        Interface i = BackEnd.idao.retrieve(this.Id_abstract, this.id_interface, this.partition_index);
		
		                        /* The actual name of the current component */
		                        string id_inner_owner = this.getSliceName(owner_unit_);
								int id_abstract_owner = owner_unit_.Id_abstract; // this.ContainerSlice.Id_abstract;
		
		                        SliceExposed se = BackEnd.sedao.retrieveContainerByOriginal(
	                                                      slice.Id_inner,               // id_inner_original
	                                                      slice.Id_interface_slice_top, // id_interface_slice_original
	                                                      id_abstract_owner,            // id_abstract
	                                                      i.Id_interface_super_top,     // id_interface_slice_owner
	                                                      id_inner_owner                // id_inner_owner
	                                                      );
								
								
								Console.WriteLine ("BEGIN /////////////");
								Console.WriteLine(slice.Id_inner);                 // id_inner_original
								Console.WriteLine(slice.Id_interface_slice_top);   // id_interface_slice_original
								Console.WriteLine(id_abstract_owner);              // id_abstract
								Console.WriteLine(i.Id_interface_super_top);       // id_interface_slice_owner
								Console.WriteLine(id_inner_owner);                 // id_inner_owner
								Console.WriteLine ("END /////////////");
								
								if (se != null)
								{
			                        string container_portName = se.Id_inner;		
									Console.WriteLine("REDIRECT SLICE user_id=" + user_id.getInstanceName() + ", portName=" + portName + ", container_id=" + container_id.getInstanceName() + ", container_portName=" + container_portName);
			                        BackEnd.redirectSlice(user_id, portName, container_id, container_portName);
									connected_slice.Add(slice.Id_inner, true);
									break;
								} 
								

								owner_unit_ = owner_unit_.ContainerSlice.Count == 0 ? null : owner_unit_.ContainerSlice[0];
							}
							
							if (owner_unit_ == null)
							{
		                        BackEnd.createSlice(this, slice);
								connected_slice.Add(slice.Id_inner, true);
							}
	                    }						
					}
					else 
					{
//						Console.WriteLine("INNER COMPONENT CONNECTED - " + slice.Id_inner);
					}
                }
            }            

//			Console.WriteLine("STARTING SLICES ... " + this.AllSlices.Count);
            foreach (IUnit unit_slice in this.AllSlices)
            {
			    unit_slice.create_slices(this);
            }
			
			this.initialize_slices();
			this.post_initialize_slices();
			
//			Console.WriteLine("END SLICES OF " + id_abstract + " - " + this.get_id_inner(owner_unit));
			//Console.WriteLine();
            Connector.closeConnection();
        }
		
		private bool initialized_flag = false;
		private bool after_initialized_flag = false;
       // private static IDictionary<IUnit, bool> initialized = new Dictionary<IUnit, bool>();
		
		
		[MethodImpl(MethodImplOptions.Synchronized)]
        public void initialize_slices()
        {
			if (!initialized_flag)
			{
	            foreach (IUnit unit_slice in this.AllSlices)
	            {
	               // if (!initialized.ContainsKey(unit_slice))
	               // {
	                    unit_slice.initialize_slices();
	                   // initialized.Add(unit_slice, true);
	               // }
	            }
						
				initialize();
				initialized_flag = true;

				Console.WriteLine("initialize " + this.CID.getInstanceName());
			}
			//Console.Error.WriteLine(this.GlobalRank + ": " + cid.getInstanceName() + " initialized !!! ");
        }

		[MethodImpl(MethodImplOptions.Synchronized)]
        public void post_initialize_slices()
        {
			if (initialized_flag && !after_initialized_flag)
			{
				post_initialize();
				after_initialized_flag = true;
				Console.WriteLine("after initialize " + this.CID.getInstanceName());			
	
				foreach (IUnit unit_slice in this.AllSlices)
	            {
	                //if (initialized.ContainsKey(unit_slice))
	                //{
	                    unit_slice.post_initialize_slices();
	                   // initialized.Remove(unit_slice);
	                //}
	            }
			}
			//Console.Error.WriteLine(this.GlobalRank + ": " + cid.getInstanceName() + " post initialized !!! ");
        }
		
        private static IDictionary<IUnit, bool> destroyed = new Dictionary<IUnit, bool>();

		[MethodImpl(MethodImplOptions.Synchronized)]
        public void destroy_slices()
        {

            foreach (IUnit unit_slice in this.AllSlices)
            {
                if (!destroyed.ContainsKey(unit_slice))
                {
                    unit_slice.destroy_slices();
                    destroyed.Add(unit_slice, true);
                }
            }

            destroySlice();
        }

        #endregion CreateSlicesPort



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

       private ICollection<IUnit> AllSlices
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






    }
	
}
