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
    public interface IUnit : Component, InitializePort, ReconfigurationAdvicePort
    {
		int Rank {get; set;}      // Rank of the parallel unit.
		int Size {get; set;}      // Number of the parallel units.
		int[] Ranks {get; set;}   // Global ranks of the parallel units.
		int GlobalRank {get; set;} // Global rank of the unit.
		IDictionary<string, IUnit> Slice {get;}
		
        Intracommunicator WorldComm {get; set;}
       
        gov.cca.Services Services { get; }

        int Id_concrete { set; get; }
        int Id_functor_app { set; get; }
        int Id_abstract { get; }
        string Id_unit { set; get; }
		int PartitionIndex {set; get;}
		string QualifiedComponentTypeName { get; }
        
		string getSliceName(IUnit container);

        IList<IUnit> ContainerSlice { get;}
		void addContainerSlice(IUnit u, string portName);
		
        new void initialize();
        new void post_initialize();
        void destroySlice();
		
		new void changePort(string portName);
		
		ICollection<IUnit> AllSlices {get; }
		

        IDictionary<string, int> ActualParameters { get; set; }
        IDictionary<string, int> ActualParametersTop { get; set; }
        void setActualParameters(IDictionary<string, int> actualParameters_new);
        void setUpParameters(int id_functor_app);

        ComponentID CID { get; set; }
    }
}
