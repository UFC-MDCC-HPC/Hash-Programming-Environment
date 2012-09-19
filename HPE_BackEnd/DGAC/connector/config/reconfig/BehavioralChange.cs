/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.load;
using br.ufc.pargo.hpe.connector.config;

using System.Collections.Generic;

namespace br.ufc.pargo.hpe.connector.reconfig
{
	public class BehavioralChange
	{

		public enum BehavioralChangeType
		{
			INCLUDE,
			REMOVE }
		;

		protected BehavioralChangeType type;

		public BehavioralChangeType Type {
			get { return type;}
			set { type = value;}
		}

		protected List<Transition> transitions;

		public List<Transition> Transitions {
			get{ return transitions;}
			set{ transitions = value;}
		}

		protected List<MetaSlice> newSlices;

		public List<MetaSlice> NewSlices {
			get { return newSlices;}
			set { newSlices = value;}
		}

		protected string unit;

		public string Unit {
			get { return unit;}
			set { unit = value;}
		}

		protected string action;

		public string Action {
			get { return action;}
			set { action = value;}
		}

		protected string point;

		public string Point {
			get { return point;}
			set { point = value;}
		}

		protected int aditionalStates;

		public int AditionalStates {
			get { return aditionalStates;}
			set { aditionalStates = value;}
		}
	}
}
