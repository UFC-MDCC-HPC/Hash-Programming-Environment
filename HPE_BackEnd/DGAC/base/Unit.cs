// /home/jefferson/projetos/appexample/appexample/kinds/DataKind.cs created with MonoDevelop
// User: jefferson at 11:14 30/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using DGAC.kinds;
using MPI;

namespace DGAC.basic
{
	public interface IUnit
	{
        BackEnd.RunTimeContext Context { set; get; }

        int Id_concrete {set; get;}
        int Id_functor_app { set; get; }
        int Id_abstract { set; get; }
        string Id_interface { set; get; }

        int GlobalRank { set; get; }                         // The rank of the process (application) where the unit is placed on
        int LocalRank { get; }                               // = RanksInv[globalRank]
        int[] Ranks { set; get; }                            // Global ranks of the units in the component. Ranks[i] = j (the i-th unit of the component is in the j-th process)
        int[] RanksInv { get; }                              // Ranks[i]==j iif RanksInv[j]==i
        IDictionary<string, int[]> Units { get; set; }
        IDictionary<string, int>[] EnumRanks { set; get; }
        IDictionary<string, int> EnumRank { get; }           // = EnumRanks[localRank]
        int[] EnumPeers { get; }
        IDictionary<string, int> EnumeratorCardinality { get; set; }

        void createSlices();
        IList<IUnit> Slices { get; }
        IUnit ContainerSlice { get; set; }
        void addSlice(IUnit slice);
        void destroySlice();

        IDictionary<string, int> ActualParameters { get; set; }
        IDictionary<string, int> ActualParametersTop { get; set; }
        void setActualParameters(IDictionary<string, int> actualParameters_new);
        void setUpParameters(DGAC.database.Component c);

        bool getPermutation(string varid, out DGAC.kinds.IEnumeratorKind permutation);
        void addPermutation(string varid, DGAC.kinds.IEnumeratorKind u);

    }
}
