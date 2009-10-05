// /home/jefferson/projetos/appexample/appexample/kinds/ApplicationKind.cs created with MonoDevelop
// User: jefferson at 13:21 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using hpe.basic;

namespace hpe.kinds
{


    public interface IApplicationKind : IComputationKind, IUnit
	{
		 
	}
	
	public abstract class Application : Computation {
	   
	}
}
