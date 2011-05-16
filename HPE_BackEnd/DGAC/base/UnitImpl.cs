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

namespace br.ufc.pargo.hpe.basic
{

    [Serializable]
    public abstract class Unit : IUnit
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

            IList<Slice> sList = BackEnd.sdao.listByInterface(id_abstract, id_interface);
            foreach (Slice slice in sList)
            {
                // The uses port name will be the name of the property
               services.registerUsesPort(slice.Id_inner/*slice.PortName*/, "", new TypeMapImpl());
            }

            Interface i = BackEnd.idao.retrieve(id_abstract, id_interface);            
            services.addProvidesPort(this, Constants.DEFAULT_PROVIDES_PORT_IMPLEMENTS, i.Class_name, new TypeMapImpl());
            services.addProvidesPort(this, Constants.DEFAULT_CREATESLICES_PORT_IMPLEMENTS, Constants.CREATE_SLICES_PORT_TYPE, new TypeMapImpl());
        }

        #region CreateSlicesPort

        public void create_slices()
        {
            Connector.openConnection();
            // CREATE SLICES !!!
            IList<Slice> sList = BackEnd.sdao.listByInterface(id_abstract, id_interface);
            foreach (Slice slice in sList)
            {
                InnerComponent ic = BackEnd.icdao.retrieve(slice.Id_abstract, slice.Id_inner);
                AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(ic.Id_abstract_inner);
                int slice_kind = Constants.kindMapping[acf.Kind];
                if (slice_kind != Constants.KIND_QUALIFIER)
                {
                    if (!slice.isPublic())
                    {
                        /* This method will:
                         *   1. instantiate the inner component (local slice) if it is not yet be instantiated and connected
                         *   2. connect the uses port to the implements (provides) port of the inner component                     * 
                         */
                        BackEnd.createSlice(this, slice);
                    }
                    else
                    {
                        // Look for the port in the enclosing unit.
                        ComponentID user_id = this.CID;
                        string portName = slice.Id_inner; /*slice.PortName;*/
                        ComponentID container_id = this.containerSlice.CID;

                        Interface i = BackEnd.idao.retrieve(this.Id_abstract, this.id_interface);

                        /* The actual name of the current component */
                        string id_inner_owner = this.Id_inner;

                        SliceExposed se = BackEnd.sedao.retrieveContainerByOriginal(
                                                                  slice.Id_inner,
                                                                  slice.Id_interface_slice_top,
                                                                  this.containerSlice.Id_abstract,
                                                                  i.Id_interface_super_top,
                                                                  id_inner_owner
                                                                  );

                        if (se==null) { 
							Console.Error.WriteLine(container_id.ToString());
							Console.Error.WriteLine(user_id.ToString());
							Console.Error.WriteLine(" id_inner_original = " + slice.Id_inner +
                                                              " id_interface_slice_original = " + slice.Id_interface_slice_top +
                                                              " id_abstract = " + this.containerSlice.Id_abstract +
                                                              " id_interface = " + i.Id_interface_super_top + 
                                                              " id_inner_owner = " + id_inner_owner);
						} /*
                         else Console.Error.WriteLine("id_abstract = " + this.Id_abstract + "id_inner_owner = " + id_inner_owner);
                        */
                        string container_portName = se.Id_inner;

                        BackEnd.redirectSlice(user_id, portName, container_id, container_portName);
                    }
                }
            }            
            
            foreach (IUnit unit_slice in this.Slices)
            {
                unit_slice.create_slices();
            }

            Connector.closeConnection();
        }

        private static IDictionary<IUnit, bool> initialized = new Dictionary<IUnit, bool>();

        public void initialize_slices()
        {

            foreach (IUnit unit_slice in this.AllSlices)
            {
                if (!initialized.ContainsKey(unit_slice))
                {
                    unit_slice.initialize_slices();
                    initialized.Add(unit_slice, true);
                }
            }

            initialize();
        }

        private static IDictionary<IUnit, bool> destroyed = new Dictionary<IUnit, bool>();

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

        private string id_interface;

        public string Id_unit
        {
            get { return id_interface; }
            set { id_interface = value; }
        }

        private string id_inner = "top";
        
        public string Id_inner
        {
            get { return id_inner; }
            set { id_inner = value; }
        }

        private int id_abstract = 0;

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

        IList<IUnit> slices;

        public IList<IUnit> Slices
        {
            get { return slices == null ? new List<IUnit>() : slices; }
        }

        IList<IUnit> all_slices;

        public IList<IUnit> AllSlices
        {
            get { return all_slices == null ? new List<IUnit>() : all_slices; }
        }

        public void addSlice(IUnit slice)
        {
            if (slices == null) slices = new List<IUnit>();
            slices.Add(slice);
        }

        public void addSliceAll(IUnit slice)
        {
            if (all_slices == null) all_slices = new List<IUnit>();
            all_slices.Add(slice);
        }

        private int myGlobalRank = -1;
        public int GlobalRank { set { this.myGlobalRank = value; } get { return myGlobalRank; } }                        // The rank of the process (application) where the unit is placed on

        private int[] myRanks = null;
        public int[] Ranks
        {
            set
            {
                this.myRanks = value;
                Array.Sort<int>(this.myRanks);
            }
            get { return myRanks; }
        }

        // Global ranks of the units in the component. Ranks[i] = j (the i-th unit of the component is in the j-th process)

        private IDictionary<string, int[]> myUnits = null;
        public IDictionary<string, int[]> Units { set { this.myUnits = value; } get { return myUnits; } }

        private IDictionary<string, int>[] myEnumRanks = null;
        public IDictionary<string, int>[] EnumRanks { set { this.myEnumRanks = value; } get { return myEnumRanks; } }


        virtual public void destroySlice()
        {
        }

        private IUnit containerSlice;

        public IUnit ContainerSlice
        {
            get { return containerSlice; }
            set
            {
                containerSlice = value;
                value.addSlice(this);
            }
        }



        private int[] myRanksInv = null;
        public int[] RanksInv
        {
            get
            {
                if (myRanksInv != null)
                    return myRanksInv;
                else if (myRanks != null)
                {
                    int max = 0;
                    for (int i = 0; i < Ranks.Length; i++)
                        max = Ranks[i] > max ? Ranks[i] : max;
                    myRanksInv = new int[max + 1];
                    for (int i = 0; i < Ranks.Length; i++)
                        myRanksInv[Ranks[i]] = i;
                    return myRanksInv;
                }
                else
                    return null;
            }
        }                        // Ranks[i]==j iif RanksInv[j]==i
        public int LocalRank { get { return RanksInv[GlobalRank]; } }                         // = RanksInv[globalRank]
        public IDictionary<string, int> EnumRank { get { return EnumRanks[LocalRank]; } }     // = EnumRanks[localRank]

        public int[] EnumPeers
        {
            get
            {
                IList<int> ranks = new List<int>();
                for (int i = 0; i < EnumRanks.Length; i++)
                {
                    ICollection<string> eKeysPeer = EnumRanks[i].Keys;
                    ICollection<string> eKey = EnumRank.Keys;
                    if (eKeysPeer.Count == eKey.Count)
                    {
                        bool flag = true;
                        foreach (string k in eKeysPeer)
                            flag = (eKey.Contains(k));
                        if (flag)
                            ranks.Add(Ranks[i]);
                    }
                }

                int[] arrRanks = new int[ranks.Count];
                ranks.CopyTo(arrRanks, 0);

                return arrRanks;
            }
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

        private IDictionary<string, br.ufc.pargo.hpe.kinds.IEnumeratorKind> permutations = null;

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

        virtual public void initialize()
        {
        }
        
        private Intracommunicator comm = null;
        
        public Intracommunicator WorldComm {get { return comm; } set { this.comm = value; }}

        #endregion

    }
}
