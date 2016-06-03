// /home/jefferson/projetos/appexample/appexample/kinds/ApplicationKind.cs created with MonoDevelop
// User: jefferson at 13:21 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;
using gov.cca.ports;
using System.Threading;
using System.Collections.Generic;

namespace br.ufc.pargo.hpe.kinds
{


    public interface ISystemKind : IApplicationKind, IUnit
    {
    }
	
	//[Serializable]
    public class System : Application, ISystemKind
    {
		public override void main ()
		{
			IList<Thread> thread_list = new List<Thread> ();

			// Disparar todos os componentes de computação e sincronizadores (activate kind).
			foreach (string port_name in PortNames) 
			{
				gov.cca.Port unit = Services.getPort (port_name);
				if (unit is GoPort) 
				{
					GoPort unit_go = (GoPort) unit;
					Thread tgo = new Thread (new ThreadStart(() => unit_go.go()));
					tgo.Start ();
				}
			}

			foreach (Thread t in thread_list)
				t.Join ();
		}
    }
}
