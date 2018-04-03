// /home/jefferson/projetos/appexample/appexample/kinds/ApplicationKind.cs created with MonoDevelop
// User: jefferson at 13:21 29/5/2008
//
// To change standard headers go to Edit->Preferences->Coding->Standard Headers
//

using System;
using br.ufc.pargo.hpe.basic;
using gov.cca.ports;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.ServiceModel;
using System.IO;

namespace br.ufc.pargo.hpe.kinds
{
    public interface ITacticalKind : IActivateKind, IUnit
    {
    }
	
	//[Serializable]
	public abstract class Tactical : Activate, ITacticalKind
    {


	}
}
