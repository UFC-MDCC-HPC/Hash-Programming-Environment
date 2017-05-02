using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using System;
using System.Collections.Generic;
using System.Xml;
using System.Collections;
using System.Reflection;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar{

/*import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import hpcshelf.certification.orchestration.visitor.C4ImplVisitor;
import hpcshelf.certification.orchestration.visitor.CertifierVisitorImpl;*/
	using System.IO;
	using System.Xml.Serialization;
public class CertifierOrchestration {

	private XMLCertifierOperation orchestration;
	private CertifierOrchestrationElement root;
		private CertifierVisitor safeVisitor;

	public CertifierOrchestration(String XMLfileName) {
		this.safeVisitor = new CertifierVisitorImpl();
			using (FileStream xmlStream = new FileStream(XMLfileName, FileMode.Open)) {
				using (XmlReader xmlReader = XmlReader.Create(xmlStream)) {
					XmlSerializer serializer = new XmlSerializer (typeof(XMLCertifierOperation));
					//XMLCertifierOperation op = serializer.Deserialize(xmlReader) as XMLCertifierOperation ;
					this.orchestration = serializer.Deserialize (xmlReader) as XMLCertifierOperation;


					this.navigate (); // this method constructs the tree node orchestration





				}



			}


	}

	/*public void parseorchestration(String fileName) {
		try {
			JAXBContext jc = JAXBContext
					.newInstance("hpcshelf.certification.orchestration.grammar");
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			Object out = unmarshaller.unmarshal(new File(fileName));
			JAXBElement<?> je = (JAXBElement<?>) out;
			this.orchestration = (XMLCertifierOperation) je.getValue();
			this.navigate(); // this method constructs the tree node orchestration
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
	*/
	

	private void navigate() {
		if (this.orchestration == null)
			return;
		this.root = new CertifierOrchestrationElement();
		this.root.accept(this.safeVisitor);
		int level = 1;
		int order = 100;

		Stack<Object> elementsStack = new Stack<Object>();
		Stack<CertifierOrchestrationElement> wfElements = new Stack<CertifierOrchestrationElement>();
		
		elementsStack.Push(this.orchestration);


		((XMLCertifierBase) this.orchestration).level=level; // for fun
		((XMLCertifierBase) this.orchestration).order=order;
		((XMLCertifierBase) this.orchestration).oper_name="orchestration";

		this.root.setElement(this.orchestration);
		this.root.setOperation(((XMLCertifierBase) this.orchestration).oper_name);
		wfElements.Push(this.root);

		while (elementsStack.Count!=0) {
			Object element = elementsStack.Pop();
			CertifierOrchestrationElement wfElement = wfElements.Pop();

			
			int myLevel = ((XMLCertifierBase) element).level;

			List<Object> children = this.getChildren(element);
				int orderCounter = children.Count;
				Console.WriteLine ("count children " + orderCounter);
			for (int i = children.Count - 1; i >= 0; i--) {
				Object child = children[i];
					Console.WriteLine ("Oper name " + ((XMLCertifierBase)child).oper_name);
					if(string.Equals(((XMLCertifierBase) child).oper_name, CertifierOrchestrationOperation.OPERATION.ToString(), StringComparison.OrdinalIgnoreCase)){
				

					child = this.getChildren(child)[0];
				}

				// level control, for graphical purpouses
				((XMLCertifierBase) child).level = myLevel + 1;
				((XMLCertifierBase) child).order = (myLevel + 1) * 100+ orderCounter;

				elementsStack.Push(child);
				orderCounter--;

				// wfElement
				CertifierOrchestrationElement wfChild = new CertifierOrchestrationElement();
				//adding visitor
				wfChild.accept(this.safeVisitor);
				wfChild.setElement((XMLCertifierBase) child);
				wfChild.setOperation(((XMLCertifierBase) child).oper_name);
				wfElement.addWorflowElement(wfChild);
				wfElements.Push(wfChild);
			}
		}

	}

	private List<Object> getChildren(Object element) {

			MethodInfo[] orchestrationMethods = 
				element.GetType().GetMethods();

		List<Object> children = new List<Object>();
		foreach (MethodInfo method in orchestrationMethods) {
				
			if (method.Name.StartsWith("get_")
					&& !method.Name.StartsWith("GetType")) {
					Console.WriteLine ("method " + method.Name);
					Object []args = new Object[0]; //useless..
					Object child = method.Invoke(element, args);

					if (child != null) {
						String operName = method.Name.Replace("get_", "");
						//String operName = method.Name;

						Console.WriteLine ("type child "+ child.GetType().ToString());
						if (child.GetType().IsArray)  {
							//.GetType().IsInstanceOfType(typeof(List<>))
							//List <Object> l = (List <Object> ) child;

							foreach (Object o in (Object[])child){
								if ( o is XMLCertifierBase) {
									((XMLCertifierBase) o).oper_name=operName;
		//							o.GetType().IsInstanceOfType(typeof(XMLCertifierBase)) ||
									children.Add(o);
								}
							}

						} else if (child is XMLCertifierBase) {
							Console.WriteLine ("child "+ child.GetType().ToString() + " is a base");
							((XMLCertifierBase) child).oper_name=operName;

							children.Add(child);
						}

					}

			
			}
		}
		return children;
	}

	/**
	 * Runs the orchestration
	 */
	public int run(){
		
		
		//System.out.println(ret);
		return this.root.run();
	}
	
	/**
	 * Translates the abstract tree to a String
	 */
	public String toString() {
		String res = "";
		if (this.orchestration == null)
			return "";

		Stack<CertifierOrchestrationElement> nodes = new Stack<CertifierOrchestrationElement>();
		nodes.Push(this.root);

		while (nodes.Count!=0) {

			CertifierOrchestrationElement e = nodes.Pop();
			String space = "";
			for (int i = 0; i <= e.getElement().level; i++) {
				space += "    ";
			}

			res += space + e + "\n";
			foreach (CertifierOrchestrationElement child in e.getChildren()) {
				nodes.Push(child);
			}
		}

		return res;
	}
	}}

/* HOW TO COMPILE THE XSD FILE
 * xjc -p br.ufc.mdcc.pargo.safe.grammar.flow SAFe_orchestration.xsd -d ../../../../../../
 */
