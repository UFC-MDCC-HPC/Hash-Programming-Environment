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

namespace br.ufc.pargo.hpe.connector.load {
   
   public class XmlLoadUtil {
      
      protected List<MetaInnerComponent> innerComponents;
      public List<MetaInnerComponent> InnerComponents {
         set {innerComponents = value;}
      }
      
      protected IdGenerator generator;
      
      protected int numStates;
      
      //Construtor recebe os innerComponents do component hash que está sendo carregado.
      public XmlLoadUtil(IdGenerator generator) {
         this.generator = generator;
      }
      
      //Método para obteção dos parâmetros de um componente.
      public List<MetaParameter> getParameters(XmlNodeList nodes) {
         
         if(nodes != null) {
            IEnumerator ienum = (IEnumerator) nodes.GetEnumerator();
            
            List<MetaParameter> parameterList = new List<MetaParameter>();
            MetaParameter parameter;
            XmlNode data;
            
            while (ienum.MoveNext()) {
               XmlNode paramNode = (XmlNode) ienum.Current;
               parameter = new MetaParameter();
               parameter.Id = generator.genId();
               
               parameter.Identifier = paramNode.SelectSingleNode("identifier").InnerText;
               
               data = paramNode.SelectSingleNode("variable");
               if(data != null) {
                  parameter.Variable = data.InnerText;
               }
               
               data = paramNode.SelectSingleNode("constraint");
               if(data != null) {
                  MetaHashComponent limitComponent = new MetaHashComponent();
                  limitComponent.Id = generator.genId();
                  
                  data = data.SelectSingleNode("componentConstraint");
                  limitComponent.Name = data.InnerText;
                  
                  XmlNodeList subParamList = data.SelectNodes("parameter");
                  limitComponent.Parameters = getParameters(subParamList);
                  
                  parameter.Constrain = limitComponent;
               }
               
               parameterList.Add(parameter);
            }
            
            if(parameterList.Count > 0) {
               return parameterList;
            }
         }
         
         return null;
      }
      
      /*
      Retorna o super componente.
      */
      public MetaHashComponent getSuperComponent(XmlNode node) {
         MetaHashComponent component = new MetaHashComponent();
         component.Id = generator.genId();
         supplyTypeInformation(node, component);
         
         return component;
      }
      
      /*
      Este método é utilizado para preencher informacões adicionais de um componente hash.
      */
      public void supplyTypeInformation(XmlNode typeNode, MetaHashComponent component) {
         
         if(typeNode != null) {
            component.Name = typeNode.SelectSingleNode("componentName").InnerText;
            component.Parameters = getParameters(typeNode.SelectNodes("parameter"));
            
            XmlNodeList publicInnerNodeList = typeNode.SelectNodes("publicInnerComponent");
            IEnumerator ienum = (IEnumerator) publicInnerNodeList.GetEnumerator();
            List<MetaInnerComponent> publicInnerList = new List<MetaInnerComponent>();
            bool ok;
            
            while (ienum.MoveNext()) {   
               XmlNode innerNode = (XmlNode) ienum.Current;
               ok = false;
               
               foreach(MetaInnerComponent mic in innerComponents) {
                  if(mic.Identifier == innerNode.InnerText) {
                     publicInnerList.Add(mic);
                     ok = true;
                     break;
                  }
               }
               
               if(!ok) {
                  throw new Exception("a variável " + innerNode.InnerText +" não é um inner component válido.");
               }
            }
            
            if(publicInnerList.Count > 0) {
               component.InnerComponents = publicInnerList;
            }
         }
      }
      
      
      /*
      Método para carregar as informações das unidades a partir de um nó XML.
      */
      public List<MetaUnit> getUnits(XmlNodeList nodes) {
         
         if(nodes != null) {
            IEnumerator ienum = (IEnumerator) nodes.GetEnumerator();
            
            List<MetaUnit> unitList = new List<MetaUnit>();
            MetaUnit unit;
            XmlNode unitNode;
            
            while (ienum.MoveNext()) {
               unitNode = (XmlNode) ienum.Current;
               unit = new MetaUnit();
               unit.Id = generator.genId();
               
               unit.Name = unitNode.SelectSingleNode("name").InnerText;
               XmlAttribute attr = (XmlAttribute) unitNode.SelectSingleNode("name").Attributes.GetNamedItem("index");
               
               if(attr != null) {
                  unit.Index = Convert.ToInt32(attr.Value);
               }
               
               attr = (XmlAttribute) unitNode.Attributes.GetNamedItem("parallel");
               if(attr != null) {
                  unit.Parallel = attr.Value.Equals("true");
               }
               
               attr = (XmlAttribute) unitNode.Attributes.GetNamedItem("split");
               if(attr != null) {
                  unit.Split = Convert.ToInt32(attr.Value);
               }
               
               unit.Slices = getSlices(unitNode.SelectNodes("slice"));               
               unit.Actions = getActions(unitNode.SelectNodes("action"), unit);
               
               if(unitNode.SelectSingleNode("validation") != null) {
                  //TODO resolver a forma de representação do validation protocol.
               }
               
               unitList.Add(unit);
            }
            
            if(unitList.Count > 0) {
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
      public List<MetaSlice> getSlices(XmlNodeList sliceNodes) {
         List<MetaSlice> slices = new List<MetaSlice>();
         
         if(sliceNodes != null) {
            
            MetaUnit unit = null;
            MetaSlice slice = null;
            string innerName, unitName;
            int index;
            XmlAttribute attr;
            XmlNode sliceNode;
            
            IEnumerator senum = (IEnumerator) sliceNodes.GetEnumerator();
            
            while (senum.MoveNext()) {
               sliceNode = (XmlNode) senum.Current;
               
               attr = (XmlAttribute) sliceNode.Attributes.GetNamedItem("inner");
               innerName = attr.Value;

               attr = (XmlAttribute) sliceNode.Attributes.GetNamedItem("unit");
               unitName = attr.Value;

               attr = (XmlAttribute) sliceNode.Attributes.GetNamedItem("index");
               if(attr != null) {
                  index = Convert.ToInt32(attr.Value);
               } else {
                  index = 0;
               }

               foreach(MetaInnerComponent comp in innerComponents) {
                  if(comp.Identifier.Equals(innerName)) {
                     
                     if(comp.Units != null) {
                        foreach(MetaUnit u in comp.Units) {
                           if(u.Name.Equals(unitName) && u.Index.Equals(index)) {
                              unit = u;
                              break;
                           }
                        }
                     }
                     
                     if(unit == null) {
                        unit = new MetaUnit();
                        unit.Id = generator.genId();
                        unit.Father = comp;
                        unit.Name = unitName;
                        unit.Index = index;
                        
                        comp.AddUnit(unit);
                     }
                     
                     break;
                  }
               }
               
               if(unit != null) {
                  slice = new MetaSlice(unit);
                  slice.Inner = inner;

                  unit = null;
               }
               
               if(slice != null) {
                  slices.Add(slice);
               } else {
                  throw new Exception("Erro ao carregar fatia: Inner component inexistente.");
               }
            }
         }
         
         return slices;
      }
      
      /*
      Retorna a lista de ações descritas na lista de nós XML.
      */
      protected List<MetaAction> getActions(XmlNodeList nodes, MetaUnit unit) {
         
         if(nodes != null) {
            IEnumerator ienum = (IEnumerator) nodes.GetEnumerator();
            
            List<MetaAction> actionList = new List<MetaAction>();
            MetaAction action;
            XmlNode actionNode;
            
            while (ienum.MoveNext()) {
               actionNode = (XmlNode) ienum.Current;
               action = new MetaAction();
               action.Id = generator.genId();
               action.Father = unit;
               
               action.Name = actionNode.SelectSingleNode("identifier").InnerText;
               List<Transition> trans = getTransitions(actionNode.SelectSingleNode("protocol").FirstChild, unit);

               action.Protocol = new Configuration(numStates, trans);
               actionList.Add(action);
            }
            
            if(actionList.Count > 0) {
               return actionList;
            }
         }
         
         return null;
      }
      
      /*
      geração das transitions baseado no protocolo da ação.
      */
      public List<Transition> getTransitions(XmlNode node, MetaUnit unit) {
         
         List<Transition> transitions = new List<Transition>();
         Queue<Transition> treat = new Queue<Transition>();
         
         int numTransations = 0;
         numStates = 2;
         
         treat.Enqueue(new Transition(Configuration.INITIAL_STATE, Configuration.FINAL_STATE, node, numTransations++));
         
         Transition t;
         XmlNode pivotNode, child;
         XmlNodeList children;
         XmlAttribute attr;
         int initialState, finalState;
         
         while(treat.Count > 0) {
            t = treat.Dequeue();
            pivotNode = (XmlNode) t.Action;
            
            attr = (XmlAttribute) pivotNode.Attributes.GetNamedItem("id");
            if(attr != null) {
               t.AddId(attr.Value);
            }
            
            t.Action = null;
            transitions.Add(t);
            
            children = pivotNode.ChildNodes;
            
            switch (pivotNode.Name)
            {
               case "seq":
               
               initialState = t.InitialState;
               
               for(int r = 0; r < children.Count; r++) {
                  child = children.Item(r);
                  
                  if(r == children.Count-1) {
                     finalState = t.FinalState;
                  } else {
                     finalState = numStates++;
                  }
                  
                  treat.Enqueue(new Transition(initialState, finalState, child, numTransations++));
                  
                  initialState = finalState;
               }
               
               break;
               case "par":
               
               initialState = t.InitialState;
               finalState = t.FinalState;
               
               for(int r = 0; r < children.Count; r++) {
                  child = children.Item(r);
                  
                  treat.Enqueue(new Transition(initialState, finalState, child, numTransations++));
               }
               
               break;
               
               case "alt":
               
               initialState = t.InitialState;
               finalState = t.FinalState;
               Condition condition;
               
               for(int r = 0; r < children.Count-1; r=r+2) {
                  
                  child = children.Item(r);
                  condition = getCondition(child);
                  
                  child = children.Item(r+1);
                  if(child.Name.Equals("protocol")) {
                     
                     int newState = numStates++;
                     
                     transitions.Add(new Transition(initialState, newState, new ExecutionAction(null, condition), numTransations++));                
                     treat.Enqueue(new Transition(newState, finalState, child.FirstChild, numTransations++));
                     
                  } else {
                     throw new Exception("invalid alt protocol");
                  }
               }
               
               child = children.Item(children.Count-1);
               
               if(child != null && child.Name.Equals("else")) {
                  treat.Enqueue(new Transition(initialState, finalState, child.FirstChild, numTransations++));
               }
               
               break;
               
               case "if":
                goto case "alt";
               
               case "loop":
               
               initialState = t.InitialState;
               finalState = t.FinalState;
               
               child = pivotNode.SelectSingleNode("cond");
               if(child != null) {
                  condition = getCondition(child);  
               } else {
                  throw new Exception("invalid loop protocol");
               }
               
               child = pivotNode.SelectSingleNode("protocol");
               if(child != null) {
                  
                  attr = (XmlAttribute) pivotNode.Attributes.GetNamedItem("type");
                  if(attr.Value.Equals("repeat")) {
                     throw new Exception("repeat not implemented. Use while");
                  }
                  
                  //initialState para initialState forma o loop
                  treat.Enqueue(new Transition(initialState, initialState, child, numTransations++));
                  
                  Transition elset = new Transition(initialState, finalState, Configuration.LAMBDA_TRANSITION, numTransations++);
                  elset.IsElse = true;
                  transitions.Add(elset);
                  
               } else {
                  throw new Exception("invalid loop protocol");
               }
               
               break;
               
               case "action":
               initialState = t.InitialState;
               finalState = t.FinalState;
               
               child = pivotNode;
               
               //TODO fazer um tratamento que: quando não houver slice, colocar como sendo uma ação da unidade principal.
               string sliceName = child.InnerText.Substring(0, child.InnerText.IndexOf('.'));
               string methodName = child.InnerText.Substring(child.InnerText.IndexOf('.')+1);
               MetaAction selectedAction = null;
               
               foreach(MetaSlice slice in unit.Slices) {

                  if(slice.Inner.Equals(sliceName)) {
                     
                     if(slice.Unit.Actions != null) {
                        foreach (MetaAction mact in slice.Unit.Actions) {
                           if(mact.Name.Equals(methodName)) {
                              selectedAction = mact;
                              break;
                           }
                        }
                     }
                     
                     if(selectedAction == null) {
                        selectedAction = new MetaAction();
                        selectedAction.Id = generator.genId();
                        selectedAction.Name = methodName;
                        selectedAction.Father = slice.Unit;
                        slice.Unit.AddAction(selectedAction);
                        
                        //System.Console.WriteLine("Slice: " + slice.Inner + " | Action: " + methodName);
                     }
                     
                     break;
                  }
               }
               
               if(selectedAction != null) {
                  transitions.Add(new Transition(initialState, finalState, new ExecutionAction(selectedAction, null), numTransations++));
               } else {
                  throw new Exception("Fatia inexistente nesta unidade: " + sliceName);
               }
               
               break;
               default :
               throw new Exception("invalid action. " + pivotNode.Name);
               
            }
         }
         
         return transitions;
      }
      
      
      /*
      Gera o objeto Condition.
      */
      protected Condition getCondition(XmlNode node) {
         if(node.Name.Equals("guard")) {
            Condition c = new Condition();
            bool not = false;
            
            XmlNode child = node.FirstChild;
            
            if(child.Name.Equals("not")) {
               child = child.FirstChild;
               not = true;
            }
            
            if(child.Name.Equals("condition")) {
               //String condString = child.InnerText;
               
               //TODO mover para o momento da ligação dos objetos. deve ser gerado por um processo a parte. Apenas iremos pesquisar a existencia.
               //Condition.DCondition deleg = generateDCondition(condString);
               
               c.AddDelegate(not, null);
            } else {
               throw new Exception("Condições compostas não estão implementadas.");
            }
            
            return c;
         }
         return null;
      }
   }
}