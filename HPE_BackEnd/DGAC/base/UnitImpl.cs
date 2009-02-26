// /home/jefferson/projetos/appexample/appexample/kinds/DataKind.cs created with MonoDevelop
// User: jefferson at 11:14 30/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using DGAC.database;


namespace hpe.basic
{

    [Serializable]
    public abstract class Unit : IUnit
	{
        private int id_concrete;

        public int Id_concrete
        {
            get { return id_concrete; }
            set { id_concrete = value; }
        }

        private IDictionary<string, int> actual_parameters = new Dictionary<string,int>();
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
            get { return slices; }
        }

        public void addSlice(IUnit slice)
        {
            if (slices == null) slices = new List<IUnit>();
            slices.Add(slice);
        }

        private int myGlobalRank = -1;
        public int GlobalRank { set { this.myGlobalRank = value; } get { return myGlobalRank; } }                        // The rank of the process (application) where the unit is placed on

        private int[] myRanks = null;
        public int[] Ranks { set { this.myRanks = value; } get { return myRanks; } }                           // Global ranks of the units in the component. Ranks[i] = j (the i-th unit of the component is in the j-th process)

        private IDictionary<string, IList<int>> myUnits = null;
        public IDictionary<string, IList<int>> Units { set { this.myUnits = value; } get { return myUnits; } }

        private IDictionary<string, int>[] myEnumRanks = null;
        public IDictionary<string, int>[] EnumRanks { set { this.myEnumRanks = value; } get { return myEnumRanks; } }

        virtual public void createSlices()
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
                    myRanksInv = new int[max+1];
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

        public int[] EnumPeers {
            get
            {
                IList<int> ranks = new List<int>();
                for (int i = 0; i < EnumRanks.Length; i++)
                {
                    ICollection<string> eKeysPeer = EnumRanks[i].Keys;
                    ICollection<string> eKey = EnumRank.Keys;
                    if (eKeysPeer.Count == eKeysPeer.Count)
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

        public void setActualParameters(IDictionary<string, int> actualParameters, int id_functor_app)
        {
            IDictionary<string, int> p = new Dictionary<string,int>();

            SupplyParameterDAO spdao = new SupplyParameterDAO();
            IList<SupplyParameter> spcList = spdao.list(id_functor_app);

            foreach (KeyValuePair<string, int> kkk in actualParameters)
            {
                if (kkk.Key.Contains("#"))
                {
                    ActualParameters.Add(kkk);
                }
            }

            foreach (SupplyParameter sp in spcList)
            {
                if (sp is SupplyParameterParameter)
                {
                    SupplyParameterParameter spp = (SupplyParameterParameter)sp;
                    int id_functor_app_actual;
                    bool achou = actualParameters.TryGetValue(spp.Id_parameter_actual, out id_functor_app_actual);
                    if (achou)
                    {
                        ActualParameters.Add(spp.Id_parameter, id_functor_app_actual);
                    }
                    else
                    {
/*                        Console.WriteLine("UNEXPECTED ERROR: " + spp.Id_parameter_actual + " NOT FOUND ! (In: setActualParameters - UnitImpl.cs)");
                        foreach (KeyValuePair<string, int> yyy in actualParameters)
                        {
                            Console.Write("("+ yyy.Key + "," + yyy.Value + ");");
                        } */
                    }
                }
                else if (sp is SupplyParameterComponent)
                {
                    SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                    ActualParameters.Add(spc.Id_parameter, spc.Id_functor_app_actual);
                    traverseParameters(spc.Id_functor_app_actual, spc.Id_functor_app_actual, actualParameters, ActualParameters);
                }
            }
        }

        private void traverseParameters(int id_functor_app_top, 
                                        int id_functor_app, 
                                        IDictionary<string, int> actualParametersTop, 
                                        IDictionary<string, int> actualParameters)
        {

            SupplyParameterDAO spdao = new SupplyParameterDAO();
            IList<SupplyParameter> spcList = spdao.list(id_functor_app);
            foreach (SupplyParameter sp in spcList)
            {
                if (sp is SupplyParameterParameter)
                {
                    SupplyParameterParameter spp = (SupplyParameterParameter)sp;
                    int id_functor_app_actual;
                    bool achou = actualParametersTop.TryGetValue(spp.Id_parameter_actual, out id_functor_app_actual);
                    actualParameters.Add(spp.Id_parameter + "#" + id_functor_app_top, id_functor_app_actual);
                }
                else if (sp is SupplyParameterComponent)
                {
                    SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                    traverseParameters(spc.Id_functor_app_actual, spc.Id_functor_app_actual, actualParametersTop, actualParameters);
                }
            }
           
        
        }

        public void setUpParameters(DGAC.database.Component c)
        {
            SupplyParameterDAO spdao = new SupplyParameterDAO();
            IList<SupplyParameter> spcList = spdao.list(c.Id_functor_app);
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
    }
}
