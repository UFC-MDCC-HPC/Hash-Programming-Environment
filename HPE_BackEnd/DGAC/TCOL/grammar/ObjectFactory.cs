using System.Xml;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar{

//import javax.xml.bind.JAXBElement;
//import javax.xml.bind.annotation.XmlElementDecl;
//import javax.xml.bind.annotation.XmlRegistry;
//import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the hpcshelf.certification.orchestration.grammar package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
//[System.Xml.Serialization..XmlTypeAttribute(Namespace="http://www.example.org/Certifier_Orchestration")]
//@XmlRegistry
public class ObjectFactory {

  //  private final static QName _Orchestration_QNAME = new QName("http://www.example.org/Certifier_Orchestration", "orchestration");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: hpcshelf.certification.orchestration.grammar
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChoiceOperComplexType }
     * 
     */
		public selectoperComplexType createSelectOperComplexType() {
			return new selectoperComplexType();
    }
		public switchoperComplexType createSwitchOperComplexType() {
			return new switchoperComplexType();
		}

    /**
     * Create an instance of {@link XMLCertifierOperation }
     * 
     */
    public XMLCertifierOperation createXMLCertifierOperation() {
        return new XMLCertifierOperation();
    }

    /**
     * Create an instance of {@link XMLCertifierReturnOper }
     * 
     */


    /**
     * Create an instance of {@link XMLCertifierPrimOper }
     * 
     */
    public XMLCertifierPrimOper createXMLCertifierPrimOper() {
        return new XMLCertifierPrimOper();
    }

    /**
     * Create an instance of {@link XMLCertifierAction }
     * 
     */
    public XMLCertifierAction createXMLCertifierAction() {
        return new XMLCertifierAction();
    }

    /**
     * Create an instance of {@link XMLCertifierCompOper }
     * 
     */
    public XMLCertifierCompOper createXMLCertifierCompOper() {
        return new XMLCertifierCompOper();
    }

    /**
     * Create an instance of {@link XMLCertifierBase }
     * 
     */
    public XMLCertifierBase createXMLCertifierBase() {
        return new XMLCertifierBase();
    }

    /**
     * Create an instance of {@link ChoiceOperComplexType.Item }
     * 
     */
		public switchoperComplexTypeChoice createswitchoperComplexTypeChoice() {
			return new switchoperComplexTypeChoice();
    }
		public selectoperComplexTypeChoice createselectoperComplexTypeChoice() {
			return new selectoperComplexTypeChoice();
		}

    /**
     * Create an instance of {@link XMLCertifierOperation.IterateOper }
     * 
     */
		public RepeatOper createXMLCertifierOperationRepeatOper() {
			return new RepeatOper();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLCertifierOperation }{@code >}}
     * 
     */
  /*  @XmlElementDecl(namespace = "http://www.example.org/Certifier_Orchestration", name = "orchestration")
    public JAXBElement<XMLCertifierOperation> createOrchestration(XMLCertifierOperation value) {
        return new JAXBElement<XMLCertifierOperation>(_Orchestration_QNAME, XMLCertifierOperation.class, null, value);
    */}

}