// /home/jefferson/projetos/appexample/appexample/main/TestMain.cs created with MonoDevelop
// User: jefferson at 15:03 12/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using hpe.basic;

namespace hpe.kinds
{


    public interface IComputationKind : IUnit
	{	
		void compute();		
	}
	
	public abstract class Computation : Unit {
	   
	}	
	
}
