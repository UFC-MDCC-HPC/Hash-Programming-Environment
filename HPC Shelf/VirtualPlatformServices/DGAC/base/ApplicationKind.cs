// /home/jefferson/projetos/appexample/appexample/kinds/ApplicationKind.cs created with MonoDevelop
// User: jefferson at 13:21 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;
using gov.cca.ports;

namespace br.ufc.pargo.hpe.kinds
{


    public interface IApplicationKind : IComputationKind, IUnit
    {
     }
	
	//[Serializable]
    public abstract class Application : Computation, IApplicationKind
    {
    }
}
