//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.21 às 01:43:12 PM BRT 
//


package hpcshelf.certification.orchestration.grammar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de XMLCertifierPrimOper complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="XMLCertifierPrimOper">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase">
 *       &lt;sequence>
 *         &lt;element name="action" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierAction"/>
 *       &lt;/sequence>
 *       &lt;attribute name="handle_id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLCertifierPrimOper", propOrder = {
    "action"
})
public class XMLCertifierPrimOper
    extends XMLCertifierBase
{

    @XmlElement(required = true)
    protected XMLCertifierAction action;
    @XmlAttribute(name = "handle_id")
    protected String handleId;

    /**
     * Obtém o valor da propriedade action.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierAction }
     *     
     */
    public XMLCertifierAction getAction() {
        return action;
    }

    /**
     * Define o valor da propriedade action.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierAction }
     *     
     */
    public void setAction(XMLCertifierAction value) {
        this.action = value;
    }

    /**
     * Obtém o valor da propriedade handleId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandleId() {
        return handleId;
    }

    /**
     * Define o valor da propriedade handleId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandleId(String value) {
        this.handleId = value;
    }

}
