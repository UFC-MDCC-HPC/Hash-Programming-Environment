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

namespace br.ufc.pargo.hpe.connector.load {
   
   public class XmlLoader {
      
      protected static XmlFormatValidator validator = new XmlFormatValidator();
      
      public static readonly string COMPONENT_XSD = "../../HPE_BackEnd/DGAC/connector/xml/hpe_component.xsd";
      
      public static readonly string REQUEST_XSD = "../../HPE_BackEnd/DGAC/connector/xml/hpe_reconfiguration_request.xsd";
      
      protected IdGenerator generator;
      
      protected XmlLoadUtil uLoader;
      
      public XmlLoader() {
         generator = new IdGenerator();
         uLoader = new XmlLoadUtil(generator);
      }
      
      protected void clear() {
         uLoader.InnerComponents = null;
      }
      
      public ReconfigurationRequest loadRequest(string xml, MetaHashComponent component) {
         ReconfigurationRequest request = null;
         
         if(validator.IsValid(REQUEST_XSD, xml)) {
            
            clear();
            generator.setInitialCode(component.LastIdCode);

            request = new ReconfigurationRequest();
            XmlDocument document = new XmlDocument();
            XmlNode nodeRequest, data;
            
            document.Load(xml);
            nodeRequest = document.SelectSingleNode("reconfigurationRequest");
            data = nodeRequest.SelectSingleNode("targetComponent");
            request.TargetComponent = data.InnerText;

            List<MetaParameter> parameterList = uLoader.getParameters(nodeRequest.SelectNodes("parameter"));            
            if(parameterList != null) {
               request.StructuralRequest = new StructuralReconfigurationRequest(parameterList);
            }
            
            BehavioralReconfigurationRequest behavioralRequest = null;

            List<MetaInnerComponent> innerComponents = generateInnerComponents(nodeRequest.SelectNodes("innerComponent"));
            if(innerComponents != null) {
               behavioralRequest = new BehavioralReconfigurationRequest();

               behavioralRequest.NewInnerComponents = innerComponents;
               //TODO verificar se é preciso desta variável. Se sim, a lista tem que ser diferente.
               // ou então remover as inserções abaixo.

               foreach(MetaInnerComponent mic in  component.InnerComponents) {
                  innerComponents.Add(mic);
               }
            }
            
            uLoader.InnerComponents = innerComponents;
            XmlNodeList changeActionList = nodeRequest.SelectNodes("changeAction");

            if(changeActionList != null) {
               IEnumerator ienum = changeActionList.GetEnumerator();
               BehavioralChange change;
               XmlNode changeNode;

               if(behavioralRequest == null) {
                  behavioralRequest = new BehavioralReconfigurationRequest();
               }

               XmlAttribute attr;
               int intialCode;
               while (ienum.MoveNext()) {
                  changeNode = (XmlNode) ienum.Current;
                  
                  change = new BehavioralChange();
                  intialCode = generator.getCurrentCode();
                  
                  attr = (XmlAttribute) changeNode.Attributes.GetNamedItem("type");
                  if(attr.Value.Equals("remove")) {
                     change.Type = BehavioralChange.BehavioralChangeType.REMOVE;
                  } else {
                     change.Type = BehavioralChange.BehavioralChangeType.INCLUDE;
                  }

                  attr = (XmlAttribute) changeNode.Attributes.GetNamedItem("unit");
                  change.Unit = attr.Value;
                  
                  attr = (XmlAttribute) changeNode.Attributes.GetNamedItem("action");
                  change.Action = attr.Value;

                  attr = (XmlAttribute) changeNode.Attributes.GetNamedItem("point");
                  change.Point = attr.Value;

                  change.NewSlices = uLoader.getSlices(changeNode.SelectNodes("slice"));
                  
                  MetaUnit u = component.getUnit(change.Unit);

                  if(u != null) {
                     change.Transitions = uLoader.getTransitions(changeNode.SelectSingleNode("protocol"), u);
                  } else {
                     throw new Exception("Unidade da ação a ser alterada não existe: " + change.Unit);   
                  }

                  change.AditionalStates = generator.getCurrentCode() - intialCode;
                  behavioralRequest.AddChange(change);
               }
            }

            component.LastIdCode = generator.getCurrentCode();
         }

         return request;
      }

      public MetaHashComponent loadComponent(string xml) {
         
         MetaHashComponent component = null;
         
         if(validator.IsValid(COMPONENT_XSD, xml)) {
            clear();
            
            component = new MetaHashComponent();
            component.Id = generator.genId();
            
            XmlDocument document = new XmlDocument();
            
            document.Load(xml);
            
            XmlNode nodeComponent = document.SelectSingleNode("hashComponent");
            component.Package = nodeComponent.SelectSingleNode("package").InnerText;
            XmlNodeList usingNodeList = nodeComponent.SelectNodes("using");
            
            IEnumerator ienum = usingNodeList.GetEnumerator();
            List<string> usingList = new List<string>();
            
            while (ienum.MoveNext()) {
               XmlNode usingNode = (XmlNode) ienum.Current;
               usingList.Add(usingNode.InnerText);
            }
            
            if(usingList.Count > 0) {
               component.UsingList = usingList;
            }
            
            component.Kind = nodeComponent.SelectSingleNode("kind").InnerText;
            component.Name = nodeComponent.SelectSingleNode("name").InnerText;
            
            XmlNodeList parameterList = nodeComponent.SelectNodes("parameter");
            component.Parameters = uLoader.getParameters(parameterList);
            
            XmlNodeList innerComponentList = nodeComponent.SelectNodes("innerComponent");
            
            List<MetaInnerComponent> inners = generateInnerComponents(innerComponentList);
            uLoader.InnerComponents = inners;
            component.InnerComponents = inners;
            
            XmlNode superComponent = nodeComponent.SelectSingleNode("superComponent");
            component.SuperComponent = uLoader.getSuperComponent(superComponent);
            
            XmlNodeList unitList = nodeComponent.SelectNodes("unit");
            component.Units = uLoader.getUnits(unitList);
            
         }

         component.LastIdCode = generator.getCurrentCode();
         return component;
      }

      protected List<MetaInnerComponent> generateInnerComponents(XmlNodeList nodes) {
         
         if(nodes != null) {
            IEnumerator ienum = nodes.GetEnumerator();
            
            List<MetaInnerComponent> componentList = new List<MetaInnerComponent>();
            MetaInnerComponent component;
            
            while (ienum.MoveNext()) {   
               XmlNode compNode = (XmlNode) ienum.Current;
               
               component = new MetaInnerComponent();
               component.Id = generator.genId();
               
               component.Kind = compNode.SelectSingleNode("kind").InnerText;
               component.Identifier = compNode.SelectSingleNode("identifier").InnerText;

               component.Access = compNode.SelectSingleNode("access").InnerText;
               component.ExportActions = compNode.SelectSingleNode("exportActions").InnerText.Equals("true");
               
               XmlNode typeNode = compNode.SelectSingleNode("type");
               uLoader.supplyTypeInformation(typeNode, component);
               
               componentList.Add(component);
            }
            
            if(componentList.Count > 0) {
               return componentList;
            }
         }

         return null;
      }
   }
}