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
using Instantiator;

namespace br.ufc.pargo.hpe.basic
{


    public interface IUnit : Component, InitializePort, ReconfigurationAdvicePort
    {
		string ClassName {get; set;}
    	
		int Kind {get; set;}
    	
		string[] PortNames { get; set;}
    	
		// GLOBAL COMMUNICATOR 
		Intracommunicator WorldComm {get; set;}
		int GlobalRank {get;} // Global rank of the unit.
		int GlobalSize {get;} // Global rank of the unit.

		// COMPONENT COMUNICATOR (inter-units)
		Intracommunicator Communicator {get; set;}
		int Rank {get;}      // Rank of the unit in the component.
		int Size {get;}      // Number of units in the component.

		// PARALLEL UNIT COMMUNICATOR 
        Intracommunicator PeerComm {get; set;}
		int PeerRank {get;}      // Rank of the unit in the component.
		int PeerSize {get;}      // = UnitSize[<unit_name>]

		IDictionary<string, int[]> UnitRanks { get; }  // Ranks of the units (if singleton, the result has only one element)
		IDictionary<string, int> UnitSize { get; }     // Number of units (it returns 1 for singleton units)
		bool IsParallelUnit {get;}
		bool IsSingletonUnit {get;}

		void calculate_topology ();        

		IDictionary<string, IUnit> Slice {get;}

       
        gov.cca.Services Services { get; }

        string Id_unit { set; get; }
		string QualifiedComponentTypeName { get; set; }
        
		void addSlice(IUnit slice, string portName);
		
	    new void on_initialize();
        new void after_initialize();
        void destroySlice();
		
		new void changePort(string portName);
		
        ComponentID CID { get; set; }
    }
}
