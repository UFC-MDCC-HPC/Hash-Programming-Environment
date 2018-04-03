// /home/jefferson/projetos/appexample/appexample/kinds/SynchronizerKind.cs created with MonoDevelop
// User: jefferson at 13:20 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;

namespace br.ufc.pargo.hpe.kinds
{


    public interface IEnvironmentKind : IUnit
	{
	}
	
	public abstract class Environment : Unit, IEnvironmentKind {
	   
	}
		
}
