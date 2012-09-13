/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.config;

using System.Xml;
using System.Collections;
using System.Collections.Generic;

using System;

namespace br.ufc.pargo.hpe.connector.load
{
	public class XmlLoadUtil
	{
      
		protected List<MetaInnerComponent> innerComponents;

		public List<MetaInnerComponent> InnerComponents {
			set { innerComponents = value;}
		}
      
		protected IdGenerator generator;
		protected int numStates;
      
		//Construtor recebe os innerComponents do component hash que está sendo carregado.
		public XmlLoadUtil (IdGenerator generator)
		{
			this.generator = generator;
		}
      
		//Método para obteção dos parâmetros de um componente.
		public List<MetaParameter> getParameters (XmlNodeList nodes)
		{
         
			if (nodes != null) {
				IEnumerator ienum = (IEnumerator)nodes.GetEnumerator ();
            
				List<MetaParameter> parameterList = new List<MetaParameter> ();
				MetaParameter parameter;
				XmlNode data;
            
				while (ienum.MoveNext()) {
					XmlNode paramNode = (XmlNode)ienum.Current;
					parameter = new MetaParameter ();
					parameter.Id = generator.genId ();
               
					parameter.Identifier = paramNode.SelectSingleNode ("identifier").InnerText;
               
					data = paramNode.SelectSingleNode ("variable");
					if (data != null) {
						parameter.Variable = data.InnerText;
					}
               
					data = paramNode.SelectSingleNode ("constraint");
					if (data != null) {
						MetaHashComponent limitComponent = new MetaHashComponent ();
						limitComponent.Id = generator.genId ();
                  
						data = data.SelectSingleNode ("componentConstraint");
						limitComponent.Name = data.InnerText;
                  
						XmlNodeList subParamList = data.SelectNodes ("parameter");
						limitComponent.Parameters = getParameters (subParamList);
                  
						parameter.Constrain = limitComponent;
					}
               
					parameterList.Add (parameter);
				}
            
				if (parameterList.Count > 0) {
					return parameterList;
				}
			}
         
			return null;
		}
      
		/*
      Retorna o super componente.
      */
		public MetaHashComponent getSuperComponent (XmlNode node)
		{
			MetaHashComponent component = new MetaHashComponent ();
			component.Id = generator.genId ();
			supplyTypeInformation (node, component);
         
			return component;
		}
      
		/*
      Este método é utilizado para preencher informacões adicionais de um componente hash.
      */
		public void supplyTypeInformation (XmlNode typeNode, MetaHashComponent component)
		{
         
			if (typeNode != null) {
				component.Name = typeNode.SelectSingleNode ("componentName").InnerText;
				component.Parameters = getParameters (typeNode.SelectNodes ("parameter"));
            
				XmlNodeList publicInnerNodeList = typeNode.SelectNodes ("publicInnerComponent");
				IEnumerator ienum = (IEnumerator)publicInnerNodeList.GetEnumerator ();
				List<MetaInnerComponent> publicInnerList = new List<MetaInnerComponent> ();
				bool ok;
            
				while (ienum.MoveNext()) {   
					XmlNode innerNode = (XmlNode)ienum.Current;
					ok = false;
               
					foreach (MetaInnerComponent mic in innerComponents) {
						if (mic.Identifier.Equals (innerNode.InnerText)) {
							publicInnerList.Add (mic);
							ok = true;
							break;
						}
					}
               
					if (!ok) {
						throw new Exception ("a variável " + innerNode.InnerText + " não é um inner component válido.");
					}
				}
            
				if (publicInnerList.Count > 0) {
					component.InnerComponents = publicInnerList;
				}
			}
		}
      
      
		/*
      Método para carregar as informações das unidades a partir de um nó XML.
      */
		public List<MetaUnit> getUnits (XmlNodeList nodes)
		{
         
			if (nodes != null) {
				IEnumerator ienum = (IEnumerator)nodes.GetEnumerator ();
            
				List<MetaUnit> unitList = new List<MetaUnit> ();
				MetaUnit unit;
				XmlNode unitNode;
				XmlAttribute attr;
            
				while (ienum.MoveNext()) {
					unitNode = (XmlNode)ienum.Current;
					unit = new MetaUnit ();
					unit.Id = generator.genId ();
               
					attr = (XmlAttribute)unitNode.Attributes.GetNamedItem ("name");
					unit.Name = attr.Value;


					attr = (XmlAttribute)unitNode.Attributes.GetNamedItem ("index");
               
					if (attr != null) {
						unit.Index = Convert.ToInt32 (attr.Value);
					}
               
					attr = (XmlAttribute)unitNode.Attributes.GetNamedItem ("parallel");
					if (attr != null) {
						unit.Parallel = attr.Value.Equals ("true");
					}
               
					unit.Slices = getSlices (unitNode.SelectNodes ("slice"));               
					unit.Actions = getActions (unitNode.SelectNodes ("action"), unit);
               
					if (unitNode.SelectSingleNode ("validation") != null) {
						//TODO resolver a forma de representação do validation protocol.
					}
               
					unitList.Add (unit);
				}
            
				if (unitList.Count > 0) {
					return unitList;
				}
			}
         
			return null;
		}
      
		/*
      Procura e retorna a fatia procurada. Ela corresponde a uma unidade de um innerComponent.
      Caso não exista, a unidade será criada, atribuída ao innerComponent e ao final retornada.
      
      Caso innerComponent citado não exista, o retorno do método será nulo.
      */
		public List<MetaSlice> getSlices (XmlNodeList sliceNodes)
		{
			List<MetaSlice> slices = new List<MetaSlice> ();
         
			if (sliceNodes != null) {
            
				MetaUnit unit = null;
				MetaSlice slice = null;
				string innerName, unitName;
				int index;
				XmlAttribute attr;
				XmlNode sliceNode;
            
				IEnumerator senum = (IEnumerator)sliceNodes.GetEnumerator ();
            
				while (senum.MoveNext()) {
					sliceNode = (XmlNode)senum.Current;
               
					attr = (XmlAttribute)sliceNode.Attributes.GetNamedItem ("inner");
					innerName = attr.Value;

					attr = (XmlAttribute)sliceNode.Attributes.GetNamedItem ("unit");
					unitName = attr.Value;

					attr = (XmlAttribute)sliceNode.Attributes.GetNamedItem ("index");
					if (attr != null) {
						index = Convert.ToInt32 (attr.Value);
					} else {
						index = 0;
					}

					foreach (MetaInnerComponent comp in innerComponents) {
						if (comp.Identifier.Equals (innerName)) {
                     
							if (comp.Units != null) {
								foreach (MetaUnit u in comp.Units) {
									if (u.Name.Equals (unitName) && u.Index.Equals (index)) {
										unit = u;
										break;
									}
								}
							}
                     
							if (unit == null) {
								unit = new MetaUnit ();
								unit.Id = generator.genId ();
								unit.Father = comp;
								unit.Name = unitName;
								unit.Index = index;
                        
								comp.AddUnit (unit);
							}
                     
							break;
						}
					}
               
					if (unit != null) {
						slice = new MetaSlice (unit);
						slice.Inner = innerName;

						unit = null;
					}
               
					if (slice != null) {
						slices.Add (slice);
					} else {
						throw new Exception ("Erro ao carregar fatia: Inner component inexistente.");
					}
				}
			}
         
			return slices;
		}
      
		/*
      Retorna a lista de ações descritas na lista de nós XML.
      */
		protected List<MetaAction> getActions (XmlNodeList nodes, MetaUnit unit)
		{
         
			if (nodes != null) {
				IEnumerator ienum = (IEnumerator)nodes.GetEnumerator ();
            
				List<MetaAction> actionList = new List<MetaAction> ();
				MetaAction action;
				XmlNode actionNode;
            
				while (ienum.MoveNext()) {
					actionNode = (XmlNode)ienum.Current;
					action = new MetaAction ();
					action.Id = generator.genId ();
					action.Father = unit;
               
					action.Name = actionNode.SelectSingleNode ("identifier").InnerText;
					List<Transition> trans = getTransitions (actionNode.SelectSingleNode ("protocol").FirstChild, unit);

					action.Protocol = new Configuration (numStates, trans);
					actionList.Add (action);
				}
            
				if (actionList.Count > 0) {
					return actionList;
				}
			}
         
			return null;
		}
      
		/*
      geração das transitions baseado no protocolo da ação.
      */
		public List<Transition> getTransitions (XmlNode node, MetaUnit unit)
		{
         
			List<Transition> transitions = new List<Transition> ();
			Queue<Transition> treat = new Queue<Transition> ();
         
			int numTransations = 0;
			numStates = 2;
         
			treat.Enqueue (new Transition (Configuration.INITIAL_STATE, Configuration.FINAL_STATE, node, numTransations++));
         
			Transition t;
			XmlNode pivotNode, child, guardNode;
			XmlNodeList children;
			XmlAttribute attr;
			Condition condition;
			int initialState, finalState;
			bool repeat;
	
			initialState = finalState = 0;
         
			while (treat.Count > 0) {
				t = treat.Dequeue ();
				pivotNode = (XmlNode)t.Action;
				t.Action = null;
				transitions.Add (t);
				condition = null;

				attr = (XmlAttribute)pivotNode.Attributes.GetNamedItem ("id");
				if (attr != null) {
					t.AddId (attr.Value);
				}

				repeat = false;
				attr = (XmlAttribute)pivotNode.Attributes.GetNamedItem ("repeat");
				if (attr != null) {
					repeat = attr.Value.Equals ("true");
				}

				guardNode = pivotNode.SelectSingleNode ("guard");
				condition = null;

				if (pivotNode.Name.Equals ("seq") || pivotNode.Name.Equals ("par")) {
					if (guardNode != null) {
						condition = getCondition (guardNode);
						Transition tElse;
						initialState = numStates++;

						if(condition != null) { //condition nao é else.
							transitions.Add (new Transition (t.InitialState, initialState, new ExecutionAction (null, condition), Transition.INTERNAL_TRANSITION));
							tElse = new Transition (t.InitialState, t.FinalState, Configuration.LAMBDA_TRANSITION, Transition.INTERNAL_TRANSITION);
						} else {
							tElse = new Transition (t.InitialState, initialState, Configuration.LAMBDA_TRANSITION, Transition.INTERNAL_TRANSITION);
						}

						tElse.IsElse = true;
						transitions.Add (tElse);
					} else {
						initialState = t.InitialState;
					}
				}

				switch (pivotNode.Name) {
				case "seq":
              
					children = pivotNode.ChildNodes;
               
					for (int r = 0; r < children.Count; r++) {
						child = children.Item (r);

						if(child.Name.Equals ("guard"))
						   continue;
                  
						if (r == (children.Count - 1)) {
							if (repeat) {
								finalState = t.InitialState;
							} else {
								finalState = t.FinalState;
							}
						} else {
							finalState = numStates++;
						}
                  
						treat.Enqueue (new Transition (initialState, finalState, child.FirstChild, numTransations++));
                  
						initialState = finalState;
					}
               
					break;

				case "par":
               

					children = pivotNode.ChildNodes;


					if (repeat) {
						finalState = numStates++;
						transitions.Add (new Transition (finalState, t.InitialState, Configuration.LAMBDA_TRANSITION, Transition.INTERNAL_TRANSITION));
					} else {
						finalState = t.FinalState;
					}

					for (int r = 0; r < children.Count; r++) {
						child = children.Item (r);
                  
						if(child.Name.Equals ("guard"))
						continue;

						treat.Enqueue (new Transition (initialState, finalState, child.FirstChild, numTransations++));
					}

					break;

				case "perform":
					bool isElse = false;

					initialState = t.InitialState;
					finalState = t.FinalState;
               
					child = pivotNode;

					if (guardNode != null) {
						condition = getCondition (guardNode);
	
						if(condition == null) {
							isElse = true;
						}
					}
					attr = (XmlAttribute) child.Attributes.GetNamedItem ("slice_id");
					string sliceName = "";
					if (attr != null) {
						sliceName = attr.Value;
					}

					string methodName = child.Attributes.GetNamedItem ("action_id").Value;
					MetaAction selectedAction = null;
               
					if (sliceName.Equals ("")) {
						foreach (MetaAction mact in unit.Actions) {
							if (mact.Name.Equals (methodName)) {
								selectedAction = mact;
								break;
							}
						}

						if (selectedAction == null) {
							selectedAction = new MetaAction ();
							selectedAction.Id = generator.genId ();
							selectedAction.Name = methodName;
							selectedAction.Father = unit;
							unit.AddAction (selectedAction);
						}
					} else {
				
						foreach (MetaSlice slice in unit.Slices) {

							if (slice.Inner.Equals (sliceName)) {
                     
								if (slice.Unit.Actions != null) {
									foreach (MetaAction mact in slice.Unit.Actions) {
										if (mact.Name.Equals (methodName)) {
											selectedAction = mact;
											break;
										}
									}
								}

								if (selectedAction == null) {
									selectedAction = new MetaAction ();
									selectedAction.Id = generator.genId ();
									selectedAction.Name = methodName;
									selectedAction.Father = slice.Unit;
									slice.Unit.AddAction (selectedAction);
								}
                     
								break;
							}
						}
					}
               
					if (selectedAction != null) {
						Transition tst = new Transition (initialState, finalState, new ExecutionAction (selectedAction, condition), numTransations++);
						tst.IsElse = isElse;
						transitions.Add (tst);
					} else {
						throw new Exception ("Fatia inexistente nesta unidade: " + sliceName);
					}
               
					break;
				default :
					throw new Exception ("invalid action. " + pivotNode.Name);
               
				}
			}

			return transitions;
		}
      
      
		/*
      Gera o objeto Condition. Se retornar numm, é uma condiçao "else", a qual chamamos, condiçao de escape.
      */
		protected Condition getCondition (XmlNode node)
		{

			//se for uma transiçao else, retorna null.
			if (node.FirstChild.Name.Equals ("condition")) {
				if (node.FirstChild.Attributes.GetNamedItem ("cond_id").Equals ("else")) {
					return null;
				}
			}

			//trata condiçoes normais.
			Condition result, newCond;
			KeyValuePair<Condition, XmlNodeList> pivot;
			bool not = false;
			string sliceName, condName;
			XmlNode child;
			Queue<KeyValuePair<Condition, XmlNodeList>> toTreat = new Queue<KeyValuePair<Condition, XmlNodeList>> ();
			IEnumerator cenum;
			Condition.Operator oper;

			sliceName = condName = null;
			XmlAttribute attr = (XmlAttribute) node.Attributes.GetNamedItem ("not");
			if (attr != null) {
				not = attr.Value.Equals ("true");
			}

			result = new Condition (Condition.Operator.NULL, not);
			XmlNodeList children = node.ChildNodes;

			toTreat.Enqueue (new KeyValuePair<Condition, XmlNodeList> (result, children)); 
     
			while (toTreat.Count > 0) {

				pivot = toTreat.Dequeue ();
				cenum = pivot.Value.GetEnumerator();

				while (cenum.MoveNext()) {
					child = (XmlNode)cenum.Current;
					not = false;

					attr = (XmlAttribute) node.Attributes.GetNamedItem ("not");
					if (attr != null) {
						not = attr.Value.Equals ("true");
					}

					if (child.Name.Equals ("condition")) {
						attr = (XmlAttribute) child.Attributes.GetNamedItem ("slice_id");
						if (attr != null) {
							sliceName = attr.Value;
						}
               
						attr = (XmlAttribute) child.Attributes.GetNamedItem ("cond_id");
						condName = attr.Value;

						if(condName.Equals ("true") || condName.Equals ("false")) {
							newCond = new Condition (condName.Equals ("true"), not);
						} else {
							newCond = new Condition (sliceName, condName, not);
						}
						pivot.Key.Conditions.Add (newCond);
					} else {
						if (child.Name.Equals ("and")) {
							oper = Condition.Operator.AND;
						} else {
							oper = Condition.Operator.OR;
						}
		
						newCond = new Condition (oper, not);
						toTreat.Enqueue (new KeyValuePair<Condition, XmlNodeList> (newCond, child.ChildNodes));
					}
				}
			}
			return result;
		}
	}
}