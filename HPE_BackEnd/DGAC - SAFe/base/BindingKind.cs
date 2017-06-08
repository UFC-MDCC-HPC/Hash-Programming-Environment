// /home/jefferson/projetos/appexample/appexample/main/TestMain.cs created with MonoDevelop
// User: jefferson at 15:03 12/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;
using gov.cca.ports;
using System.Diagnostics;
using System.Collections.Generic;
using MPI;
using System.Threading;

namespace br.ufc.pargo.hpe.kinds
{

	public struct FacetAccess
	{
		public FacetAccess(string ip_address_arg, int port_arg)
		{
			ip_address = ip_address_arg;
			port = port_arg;
		}

		public string ip_address;
		public int port;
	}

    public interface IBindingKind : IUnit
	{	

		int ThisFacetInstance { get; set; }
		int ThisFacet { get; set; }
		// FACET
		/* Para acessar o endereço IP (Facet[<unit_id>][<unit_index>].ip_address) ou 
		 * porta (Facet[<unit_id>][<unit_index>].port) de uma faceta.
		 * Ex: Facet["stream_unit"][2].ip_address
		 *     Facet["test_unit"][0].port
		 */

		IDictionary<int,FacetAccess> Facet { get; }

		void addFacetAccessInfo(int facet_number, FacetAccess facet_access);

		void server();
		void client();
	}
	
	public interface IBindingRootKind : IBindingKind
	{
	}

	//[Serializable]
	public abstract class Binding : Unit, IBindingKind
	{	    

		private Intercommunicator root_communicator = null;

		public Intercommunicator RootCommunicator {
			get { return root_communicator;	}
			set { this.root_communicator = value; }
		}

		private int this_facet;
		public int ThisFacet { get { return this_facet; } set {this_facet = value; } }

		private int this_facet_instance;
		public int ThisFacetInstance { get { return this_facet_instance; } set {this_facet_instance = value; } }

		#region IBindingKind implementation

	//	int IBindingKind.ThisFacet {
	//		get {
	//			throw new NotImplementedException ();
	//		}
	//	}

	//	IDictionary<int, int> IBindingKind.FacetSize {
	//		get {
	//			throw new NotImplementedException ();
	//		}
	//	}
		#endregion

		private IDictionary<int,FacetAccess> facet = null;
		public IDictionary<int,FacetAccess> Facet { get { return facet;	} }

		/* This method must be called by the worker process for informing the location of each facet */
		public void addFacetAccessInfo (int facet_number, FacetAccess facet_access)
		{
			if (facet == null)
				facet = new Dictionary<int, FacetAccess> ();

			facet.Add (facet_number, facet_access);   
		}

		private Thread server_thread = null;
		private Thread client_thread = null;

		public override void after_initialize()
		{
			server_thread = new Thread (server);
			client_thread = new Thread (client);
			server_thread.Start();
			client_thread.Start();
		}

		public abstract void server ();
		public abstract void client ();



		#region IDisposable implementation
		private bool disposed = false;

		protected virtual void Dispose(bool disposing)
		{
			if (!disposed)
			{
				if (disposing)
				{
					client_thread.Abort ();
					server_thread.Abort ();
				}
			}
			//dispose unmanaged resources
			disposed = true;
		}

		public void Dispose()
		{
			Dispose(true);
			GC.SuppressFinalize(this);
		}
		#endregion
	}
	
}
