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
		string ClassName {get; set;}
    	
		int Kind {get; set;}
    	
		string[] PortNames { get; set;}
    	
		int Rank {get; set;}      // Rank of the parallel unit.
		int Size {get; set;}      // Number of the parallel units.
		int[] Ranks {get; set;}   // Global ranks of the parallel units.
		int GlobalRank {get; set;} // Global rank of the unit.
		IDictionary<string, IUnit> Slice {get;}
		
        Intracommunicator WorldComm {get; set;}
       
        gov.cca.Services Services { get; }

        string Id_unit { set; get; }
		string QualifiedComponentTypeName { get; set; }
        
		void addSlice(IUnit slice, string portName);
		
        new void initialize();
        new void post_initialize();
        void destroySlice();
		
		new void changePort(string portName);
		
        ComponentID CID { get; set; }
    }
}
