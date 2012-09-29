/*=============================================================
(c) 2012 by Juliano Efson Sales
      www.mdcc.ufc.br
================================================================*/
using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.reconfig
{

	//Classe que encapsula uma requisão de reconfiguração sobre uma configuração.
	public class ReconfigurationRequest
	{

		//identificador do componente alvo a sofrer a reconfiguração.
		protected string targetComponent;

		public string TargetComponent {
			get{ return targetComponent;}
			set{ targetComponent = value;}
		}

		//Mudança estrutural que deve ser aplicada.
		protected StructuralReconfigurationRequest structuralRequest;

		public StructuralReconfigurationRequest StructuralRequest {
			get { return structuralRequest;}
			set { structuralRequest = value;}
		}

		//Requisção de reconfiguração comportamental e/ou inclusão de inner component. 
		protected BehavioralReconfigurationRequest behavioralRequest;

		public BehavioralReconfigurationRequest BehavioralRequest {
			get{ return behavioralRequest;}
			set{ behavioralRequest = value;}
		}
	}
}
