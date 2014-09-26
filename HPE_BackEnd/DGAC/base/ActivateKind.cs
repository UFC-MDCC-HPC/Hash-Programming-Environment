// /home/jefferson/projetos/appexample/appexample/main/TestMain.cs created with MonoDevelop
// User: jefferson at 15:03 12/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;
using gov.cca.ports;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.kinds
{


    public interface IActivateKind : IUnit, GoPort
	{	
		void main();
	}
	
	
	//[Serializable]
	public abstract class Activate : Unit, IActivateKind
	{
	    
		public int go()
		{
			try 
			{
				this.main();
			}
			catch(Exception e)
			{
				Trace.WriteLine("Error in execution (go): " + e.Message + " *** " + e.StackTrace);
			}
			finally
			{
				
			}
			
			return 0;
		}		
		
		public abstract void main ();

	}	
	
}
