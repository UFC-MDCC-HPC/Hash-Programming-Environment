// /home/jefferson/projetos/appexample/appexample/kinds/ApplicationKind.cs created with MonoDevelop
// User: jefferson at 13:21 29/5/2008
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
using System.Collections.Concurrent;
using ExpressionEvaluator;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using System.Collections.Generic;


namespace br.ufc.pargo.hpe.kinds
{
	public interface ICertifierKind : IActivateKind, IUnit
	{
		void setData ();
	}

	//[Serializable]
	public abstract class Certifier : Activate, ICertifierKind
	{   

		public static ConcurrentDictionary <string, LogicActionInstantiate> InstantiateActions = new ConcurrentDictionary<string, LogicActionInstantiate>();
		public static ConcurrentDictionary <string, LogicActionCompute> ComputeActions = new ConcurrentDictionary<string, LogicActionCompute>();
		public static TypeRegistry variables = new TypeRegistry();
		public static MultiKeyConcurrentDictionary <string,string, bool> formal_properties = new MultiKeyConcurrentDictionary <string, string, bool>();
		public static Dictionary <int, ITaskBindingKind> verify_actions;

		public enum CerificationResult {Conclusive, Inconclusive};

		public abstract void setData ();

		public abstract string Orchestration {get; }

		public override void main()
		{

			//Services.getPort ("");
			verify_actions.Add (1, Verify1);
			verify_actions.Add (2, Verify2);


			Stopwatch sw = new Stopwatch();
			sw.Start();

			setData();		
			CerificationResult result = perform_certify (Orchestration);

			sw.Stop();

			Console.WriteLine("Tempo total de verificação={0} : INCONCLUSIVE ? {1}",sw.Elapsed, result == CerificationResult.Inconclusive);
		}

		private CerificationResult perform_certify(string orchestration)
		{


			CertifierOrchestrationParser parser = new CertifierOrchestrationParser();
			//parser.readOrchestrationXML(CertifierConstants.ORCHESTRATION_FILE_TEST);
			parser.readOrchestrationXML(Orchestration);
			CertifierConsoleLogger.write(parser.getOrchestration().toString()); 

			variables.Add ("formal_properties", formal_properties);


			parser.getOrchestration().run(); //


			Console.WriteLine ("iterating remaining start threads");
			foreach (KeyValuePair <String, LogicActionInstantiate> entry in InstantiateActions)
			{
				if (entry.Value._thread != null) {
					entry.Value._thread.Join ();
				}
			}
			foreach (KeyValuePair <String, LogicActionCompute> entry in ComputeActions)
			{
				if (entry.Value._thread != null) {
					entry.Value._thread.Join();
				}

			}

			throw new Exception ("TODO perform_certify");
		}





	}
}
