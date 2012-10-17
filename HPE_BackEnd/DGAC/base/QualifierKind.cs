// /home/jefferson/projetos/appexample/appexample/main/TestMain.cs created with MonoDevelop
// User: jefferson at 15:03 12/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;

namespace br.ufc.pargo.hpe.kinds
{


    public interface IQualifierKind : IUnit
	{
		
	}
	
	public abstract class Qualifier : Unit, IQualifierKind {
	   
	}	
}
