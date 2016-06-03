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
		int PeerRank {get;}      // Rank of the unit in the parallel unit.
		int PeerSize {get;}      // = UnitSize[<unit_name>]

		bool IsParallelUnit {get;}
		bool IsSingletonUnit {get;}

		#region unit configuration (current facet)

		IDictionary<string, int[]> UnitRanks { get; }  // Ranks of the units (if singleton, the result has only one element)
		IDictionary<string, int> UnitSize { get; }     // Number of units (it returns 1 for singleton units)

		#endregion

		bool TraceFlag { get; set; }


		#region facet configuration

		/* Each facet is identified by a number, from 0 to f-1, where f is the number of facets 
		   FacetNumbers[i] returns the current facet indexes of the facet i. 
		   Ex: Let 0, 1 and 2 be the set of facets of a given component C. 
		       Suppose that facet 0, 1 and 2 have, respectively, multiplicities 4, 1 and 2. So, 
		       FacetIndexes[0] = {0,1,2,3} -  FacetMultiplicity[0] = 4
		       FacetIndexes[1] = {4}       -  FacetMultiplicity[1] = 1
		       FacetIndexes[2] = {5,6}     -  FacetMultiplicity[2] = 2
		*/
		int ThisFacetInstance { get; set; }
		int ThisFacet { get; set; }

		IDictionary<int,int[]> FacetIndexes { get; }
		IDictionary<int,int> FacetMultiplicity { get; }

		/* returns the ranks and size of units of a given facet.
		 * By using the last example, they are indexed by 0,1,2,3,4,5 and 6, 
		 * returning the local UnitRanks and UnitSize of each facet.
		*/

		//IDictionary<int, IDictionary<string,int[]>> UnitRanksInFacet { get; }
		IDictionary<int, IDictionary<string,int>> UnitSizeInFacet { get; }


		#endregion 


		void calculate_topology ();  
		void configure_facet_topology (int[] facet_topology, Instantiator.UnitMappingType[] unit_mapping);

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
