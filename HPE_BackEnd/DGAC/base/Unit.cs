// /home/jefferson/projetos/appexample/appexample/kinds/DataKind.cs created with MonoDevelop
// User: jefferson at 11:14 30/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using br.ufc.pargo.hpe.kinds;
using MPI;
using br.ufc.pargo.hpe.backend.DGAC;
using gov.cca;
using br.ufc.pargo.hpe.ports;

namespace br.ufc.pargo.hpe.basic
{
    public interface IUnit : Component, AutomaticSlicesPort
    {
		int Rank {get; set;}      // Rank of the parallel unit.
		int Size {get; set;}      // Number of the parallel units.
		int[] Ranks {get; set;}   // Global ranks of the parallel units.
		int GlobalRank {get; set;} // Global rank of the unit.
		
        Intracommunicator WorldComm {get; set;}
       
        gov.cca.Services Services { get; }

        int Id_concrete { set; get; }
        int Id_functor_app { set; get; }
        int Id_abstract { get; }
        string Id_unit { set; get; }
		int PartitionIndex {set; get;}
        
		//string get_id_inner_0();
		string get_id_inner(IUnit container);
		void set_id_inner(IUnit container, string id_inner);

       // int GlobalRank { set; get; }                         // The rank of the process (application) where the unit is placed on
       // int LocalRank { get; }                               // = RanksInv[globalRank]
       // int[] Ranks { set; get; }                            // Global ranks of the units in the component. Ranks[i] = j (the i-th unit of the component is in the j-th process)
       // int[] RanksInv { get; }                              // Ranks[i]==j iif RanksInv[j]==i
       // IDictionary<string, int[]> Units { get; set; }
       // IDictionary<string, int>[] EnumRanks { set; get; }
       // IDictionary<string, int> EnumRank { get; }           // = EnumRanks[localRank]
       // int[] EnumPeers { get; }
       // IDictionary<string, int> EnumeratorCardinality { get; set; }

        IList<IUnit> Slices { get; }
        IList<IUnit> AllSlices { get; }
        IList<IUnit> ContainerSlice { get;}
		void addContainerSlice(IUnit u);
		
        void addSlice(IUnit slice);
        void addSliceAll(IUnit slice);
        void initialize();
        void post_initialize();
        void destroySlice();

        #region CreateSlicesPort

        new void create_slices();
        new void initialize_slices();
        new void post_initialize_slices();
        new void destroy_slices();

        #endregion CreateSlicesPort

		void create_slices(IUnit owner_unit);

        IDictionary<string, int> ActualParameters { get; set; }
        IDictionary<string, int> ActualParametersTop { get; set; }
        void setActualParameters(IDictionary<string, int> actualParameters_new);
        void setUpParameters(int id_functor_app);

//        bool getPermutation(string varid, out br.ufc.pargo.hpe.kinds.IEnumeratorKind permutation);
//        void addPermutation(string varid, br.ufc.pargo.hpe.kinds.IEnumeratorKind u);


        ComponentID CID { get; set; }
    }
}
