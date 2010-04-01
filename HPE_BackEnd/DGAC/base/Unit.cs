// /home/jefferson/projetos/appexample/appexample/kinds/DataKind.cs created with MonoDevelop
// User: jefferson at 11:14 30/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using System.Collections.Generic;
using hpe.kinds;

namespace hpe.basic
{
	public interface IUnit
	{
        int Id_concrete {set; get;}
        int Id_functor_app { set; get; }
        int Id_abstract { set; get; }
        string Id_interface { set; get; }

        int GlobalRank { set; get; }                        // The rank of the process (application) where the unit is placed on

        int[] Ranks { set; get; }                           // Global ranks of the units in the component. Ranks[i] = j (the i-th unit of the component is in the j-th process)

        IDictionary<string, IList<int>> Units { get; set; }

        IDictionary<string, int>[] EnumRanks { set; get; }

        int[] RanksInv { get; }                        // Ranks[i]==j iif RanksInv[j]==i
        int LocalRank { get; }                         // = RanksInv[globalRank]
        IDictionary<string, int> EnumRank { get; }     // = EnumRanks[localRank]

        int[] EnumPeers { get; }

        void createSlices();

        IDictionary<string, int> ActualParameters { get; set; }

        IDictionary<string, int> ActualParametersTop { get; set; }

        void setActualParameters(IDictionary<string, int> actualParameters_new);

        void setUpParameters(DGAC.database.Component c);

        IDictionary<string, int> EnumeratorCardinality { get; set; }

        IList<IUnit> Slices { get; }
        IUnit ContainerSlice { get; set; }

        void addSlice(IUnit slice);

        bool getPermutation(string varid, out hpe.kinds.IEnumeratorKind permutation);

        void addPermutation(string varid, hpe.kinds.IEnumeratorKind u);

        void destroySlice();
    }
}
