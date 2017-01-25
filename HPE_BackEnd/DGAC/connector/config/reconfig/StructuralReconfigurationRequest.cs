/*=============================================================
(c) 2012 by Juliano Efson Sales
      www.mdcc.ufc.br
================================================================*/
using System;
using System.Collections.Generic;

using br.ufc.pargo.hpe.connector.meta;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.connector.reconfig
{

	//Requisição de alteração estritamente estrutural.
	public class StructuralReconfigurationRequest
	{

		protected List<MetaParameter> changedParameters;

		public StructuralReconfigurationRequest (List<MetaParameter> changedParameters)
		{
			this.changedParameters = changedParameters;
		}
		//Lista de par (componente velho/novo) a ser alterado.
		protected List<StructuralChange> changes = new List<StructuralChange>();

		public List<StructuralChange> Changes {
			get{ return changes;}
		}

		public void GenerateChanges (MetaHashComponent component)
		{
			PairInnerComponent pair = null;
			Dictionary<string, PairInnerComponent> changedInners = new Dictionary<string, PairInnerComponent> ();
			
			foreach (MetaInnerComponent inner in component.InnerComponents) {
				
				if (inner.Parameters != null) {
					foreach (MetaParameter innerParam in inner.Parameters) {
						foreach (MetaParameter changedParam in changedParameters) {
							if (innerParam.Identifier.Equals (changedParam.Identifier)) {
								Console.WriteLine ("[StructuralReconfigurationRequest.GenerateChanges] Componente '" + inner.Identifier + "' impactado pelo parametro '" + innerParam.Identifier + "': ");	
								if (!changedInners.TryGetValue (inner.Identifier, out pair)) {
									pair = new PairInnerComponent (inner, inner.Clone ());
								
									changedInners.Add (inner.Identifier, pair);
								}
							
								pair.New.Parameters.Remove (innerParam);
								pair.New.Parameters.Add (changedParam);
							}
						}
					}
				}
			}

			Console.WriteLine ("[StructuralReconfigurationRequest.GenerateChanges] Finalizada a avaliação dos InnerComponents!");
			Console.WriteLine ("[StructuralReconfigurationRequest.GenerateChanges] Avaliando unidades impactadas...");
			foreach (PairInnerComponent innerPair in changedInners.Values) {
			
				if(innerPair.Old.Units != null) {
					foreach (MetaUnit metaUnit in innerPair.Old.Units.Values) {
					//	Console.WriteLine ("[StructuralReconfigurationRequest.GenerateChanges] Unidade será '{0}.{1}' impactada.", ((MetaInnerComponent) metaUnit.Father).Identifier, metaUnit.Name);
		
						changes.Add (new StructuralChange (metaUnit, innerPair.New.Units [metaUnit.Name]));
						//Console.WriteLine("OK {0} ", metaUnit.Name);
					}
				} else {
					//Console.WriteLine ("[StructuralReconfigurationRequest.GenerateChanges] InnerComponent {0} não possui Units");		
				}
			}
		}
		
	}
	
	class PairInnerComponent
	{
	
		public MetaInnerComponent Old;
		public MetaInnerComponent New;
		
		public PairInnerComponent (MetaInnerComponent old, MetaInnerComponent _new)
		{
			this.Old = old;
			this.New = _new;
		}
	}
}
