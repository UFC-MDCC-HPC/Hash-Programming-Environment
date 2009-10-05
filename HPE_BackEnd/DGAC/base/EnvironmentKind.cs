// /home/jefferson/projetos/appexample/appexample/kinds/SynchronizerKind.cs created with MonoDevelop
// User: jefferson at 13:20 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using hpe.basic;

namespace hpe.kinds
{


    public interface IEnvironmentKind : IUnit
	{
		void listen();
        void stopListen();
	}
	
	public abstract class Environment : Unit {
	   
	}
		
}
