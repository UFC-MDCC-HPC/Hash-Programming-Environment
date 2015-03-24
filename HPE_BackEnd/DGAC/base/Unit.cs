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

	public struct FacetAccess
	{
		public FacetAccess(string ip_address_arg, int port_arg)
		{
			ip_address = ip_address_arg;
			port = port_arg;
		}

		string ip_address;
		int port;
	}

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

		// FACET
		/* Para acessar o endereço IP (Facet[<unit_id>][<unit_index>].ip_address) ou 
		 * porta (Facet[<unit_id>][<unit_index>].port) de uma faceta.
		 * Ex: Facet["stream_unit"][2].ip_address
		 *     Facet["test_unit"][0].port
		 */
		IDictionary<string, IDictionary<int,FacetAccess>> Facet { get; }
		void readFacetConfiguration (string[] facet_unit_id,
		                             int[] facet_unit_index,
		                             string[] facet_ip_address,
		                             int [] facet_port);
       
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
