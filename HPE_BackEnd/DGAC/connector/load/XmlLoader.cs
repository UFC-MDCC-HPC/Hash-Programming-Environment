/*=============================================================
(c) 2012 by Juliano Efson Sales
www.mdcc.ufc.br
================================================================*/
using br.ufc.pargo.hpe.connector.meta;
using br.ufc.pargo.hpe.connector.config;
using br.ufc.pargo.hpe.connector.reconfig;

using System.Collections;
using System.Collections.Generic;
using System.Xml;
using System;
using br.ufc.pargo.hpe.basic;

namespace br.ufc.pargo.hpe.connector.load
{
	public class XmlLoader
	{
      
		protected static XmlFormatValidator validator = new XmlFormatValidator ();
		public static readonly string COMPONENT_XSD = "../../../../../workspace/HPE_BackEnd/DGAC/connector/xml/hpe_component.xsd";
		public static readonly string REQUEST_XSD = "../../HPE_BackEnd/DGAC/connector/xml/hpe_reconfiguration_request.xsd";
		protected IdGenerator generator;
		protected XmlLoadUtil uLoader;
      
		private IUnit the_unit = null;
		
		public XmlLoader (IUnit the_unit)
		{
			this.the_unit = the_unit;
			generator = new IdGenerator ();
			uLoader = new XmlLoadUtil (generator, the_unit);
		}
      
		protected void clear ()
		{
			uLoader.InnerComponents = null;
		}
      
		public ReconfigurationRequest loadRequest (string xml, MetaHashComponent component)
		{
			ReconfigurationRequest request = null;
			System.Console.WriteLine("Arquivo de configuração: " + xml);
         
			//TODO resolver os problemas dos validadores xsd.
			if (true /*validator.IsValid (REQUEST_XSD, xml)*/) {
            
				clear ();
				generator.setInitialCode (component.LastIdCode);

				request = new ReconfigurationRequest ();
				XmlDocument document = new XmlDocument ();
				XmlNode nodeRequest, data;
            
				document.Load (xml);
				nodeRequest = document.SelectSingleNode ("reconfigurationRequest");

				data = nodeRequest.SelectSingleNode ("targetComponent");
				request.TargetComponent = data.InnerText;

				List<MetaParameter> parameterList = uLoader.getParameters (nodeRequest.SelectNodes ("parameter"));
				if (parameterList != null) {
					request.StructuralRequest = new StructuralReconfigurationRequest (parameterList);
				}
				//TODO se tiver parametros, eu posso ter modificacoes relevantes nos inner componentes que pode impactar
				//o behavioral?
            
				BehavioralReconfigurationRequest behavioralRequest = null;

				List<MetaInnerComponent> innerComponents = generateInnerComponents (nodeRequest.SelectNodes ("innerComponent"));
				if (innerComponents != null) {
					behavioralRequest = new BehavioralReconfigurationRequest ();

					behavioralRequest.NewInnerComponents = innerComponents;
					innerComponents.AddRange (component.InnerComponents);
					//TODO talvez seja preciso clonar os objetos para garantir que nao ficará lixo caso a reconfiguraçao nao funcione.
				}
            
				uLoader.InnerComponents = innerComponents;
				XmlNodeList changeActionList = nodeRequest.SelectNodes ("changeAction");

				if (changeActionList != null) {
					IEnumerator ienum = changeActionList.GetEnumerator ();
					BehavioralChange change;
					XmlNode changeNode;

					if (behavioralRequest == null) {
						behavioralRequest = new BehavioralReconfigurationRequest ();
					}

					XmlAttribute attr;
					int initialCode;
					while (ienum.MoveNext()) {
						changeNode = (XmlNode)ienum.Current;
                  
						change = new BehavioralChange ();
						initialCode = generator.getCurrentCode ();
                  
						attr = (XmlAttribute)changeNode.Attributes.GetNamedItem ("unit");
						change.Unit = attr.Value;

						MetaUnit u = component.Units[change.Unit];

						if (u != null) {

							attr = (XmlAttribute)changeNode.Attributes.GetNamedItem ("action");
							change.Action = attr.Value;
							MetaAction a = u.Actions[change.Action];

							if(a != null && !a.IsNative) {
								attr = (XmlAttribute)changeNode.Attributes.GetNamedItem ("type");
								if (attr.Value.Equals ("remove")) {
									change.Type = BehavioralChange.BehavioralChangeType.REMOVE;
								} else {
									change.Type = BehavioralChange.BehavioralChangeType.INCLUDE;
								}
								
								attr = (XmlAttribute)changeNode.Attributes.GetNamedItem ("point");
								change.Point = attr.Value;

								Transition t = a.Protocol.getTransition(change.Point);

								if(t != null) {
									change.NewSlices = uLoader.getSlices (changeNode.SelectNodes ("slice"));

									if(change.Type == BehavioralChange.BehavioralChangeType.INCLUDE) {
										change.Transitions = uLoader.getTransitions (changeNode.SelectSingleNode ("protocol"), u, t.InitialState, t.FinalState, a.Protocol.NumStates, a.Protocol.LastTransationId);
									} else {
										change.Transitions = new List<Transition>();
										change.Transitions.Add(new Transition(t.InitialState, t.FinalState, Configuration.LAMBDA_TRANSITION, a.Protocol.LastTransationId++));
									}
								} else {
									throw new Exception ("Ponto de reconfiguração não existe: " + change.Point);   
								}

							} else {
									throw new Exception ("Ação a ser alterada não existe ou nãoo é uma configuração: " + change.Action);   
							}
						} else {
							throw new Exception ("Unidade da ação a ser alterada não existe: " + change.Unit);
						}

						change.AditionalStates = generator.getCurrentCode () - initialCode;
						behavioralRequest.AddChange (change);
					}
				}

				request.BehavioralRequest = behavioralRequest;
				component.LastIdCode = generator.getCurrentCode ();
			}

			return request;
		}

		public MetaHashComponent loadComponent (string xml)
		{
         
			MetaHashComponent component = null;
         	System.Console.WriteLine("Arquivo de configuração: " + xml);
			
			//TODO validador da erros que nao consigo identificar a razao.
			if (true /*validator.IsValid (COMPONENT_XSD, xml)*/) {
				clear ();
            
				component = new MetaHashComponent ();
				component.Id = generator.genId ();
            
				XmlDocument document = new XmlDocument ();

				document.Load (xml);
            
				XmlNode nodeComponent = document.SelectSingleNode("hashComponent");
				
				component.Package = nodeComponent.SelectSingleNode ("package").InnerText;
				XmlNodeList usingNodeList = nodeComponent.SelectNodes ("using");
            
				IEnumerator ienum = usingNodeList.GetEnumerator ();
				List<string> usingList = new List<string> ();
            
				while (ienum.MoveNext()) {
					XmlNode usingNode = (XmlNode)ienum.Current;
					usingList.Add (usingNode.InnerText);
				}
            
				if (usingList.Count > 0) {
					component.UsingList = usingList;
				}
            
				component.Kind = nodeComponent.SelectSingleNode ("kind").InnerText;
				component.Name = nodeComponent.SelectSingleNode ("name").InnerText;
            
				XmlNodeList parameterList = nodeComponent.SelectNodes ("parameter");
				component.Parameters = uLoader.getParameters (parameterList);
            
				XmlNodeList innerComponentList = nodeComponent.SelectNodes ("innerComponent");
            
				List<MetaInnerComponent> inners = generateInnerComponents (innerComponentList);
				uLoader.InnerComponents = inners;
				component.InnerComponents = inners;
            
				XmlNode superComponent = nodeComponent.SelectSingleNode ("superComponent");
				component.SuperComponent = uLoader.getSuperComponent (superComponent);
            
				XmlNodeList unitList = nodeComponent.SelectNodes ("unit");
				component.Units = uLoader.getUnits (unitList);

				foreach (MetaUnit mu in component.Units.Values) {

					foreach (MetaAction ma in mu.Actions.Values) {
						foreach (Transition t in ma.Protocol.Transitions) {

							if (t.getExecutionAction () != null) {
								Queue<Condition> queue = new Queue<Condition> ();
								queue.Enqueue (t.getExecutionAction ().Condition);

								while (queue.Count > 0) {
									Condition c = queue.Dequeue ();
					
									if(c != null) {
										foreach (Condition e in c.Conditions) {
											queue.Enqueue (e);
										}
										
										if(c.Slice != null && !c.Slice.Equals(""))
										{
											mu.Slices[c.Slice].Unit.Conditions.Add ((c.Name == null || c.Name.Equals ("") ? c.Id + "": c.Name), c);

										}
									}
								}
							}
						}
					}
				}

				component.LastIdCode = generator.getCurrentCode ();
			}

			return component;
		}

		protected List<MetaInnerComponent> generateInnerComponents (XmlNodeList nodes)
		{
         
			if (nodes != null) {
				IEnumerator ienum = nodes.GetEnumerator ();
            
				List<MetaInnerComponent> componentList = new List<MetaInnerComponent> ();
				MetaInnerComponent component;
            
				while (ienum.MoveNext()) {   
					XmlNode compNode = (XmlNode)ienum.Current;
               
					component = new MetaInnerComponent ();
					component.Id = generator.genId ();
               
					component.Kind = compNode.SelectSingleNode ("kind").InnerText;
					component.Identifier = compNode.SelectSingleNode ("identifier").InnerText;

					component.Access = compNode.SelectSingleNode ("access").InnerText;
					component.ExportActions = compNode.SelectSingleNode ("exportActions").InnerText.Equals ("true");
               
					XmlNode typeNode = compNode.SelectSingleNode ("type");
					uLoader.supplyTypeInformation (typeNode, component, false);
               
					componentList.Add (component);
				}
            
				if (componentList.Count > 0) {
					return componentList;
				}
			}

			return null;
		}
	}
}