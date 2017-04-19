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
using System.Diagnostics;

namespace br.ufc.pargo.hpe.kinds
{
    public interface ICertifierKind : IActivateKind, IUnit
    {
		void setData ();
    }
	
	//[Serializable]
	public abstract class Certifier : Activate, ICertifierKind
    {
		public enum CerificationResult {Conclusive, Inconclusive};

		public abstract void setData ();

		public abstract string Orchestration {get; }

		public override void main()
		{
			Stopwatch sw = new Stopwatch();
			sw.Start();

			setData();		
			CerificationResult result = perform_certify (Orchestration);

			sw.Stop();

			Console.WriteLine("Tempo total de verificação={0} : INCONCLUSIVE ? {1}",sw.Elapsed, result == CerificationResult.Inconclusive);
		}

		private CerificationResult perform_certify(string orchestration)
		{
			throw new Exception ("TODO perform_certify");
		}

	}
}
