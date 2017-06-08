//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.09.21 às 01:43:12 PM BRT 
//


package hpcshelf.certification.orchestration.grammar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de choice_operComplexType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="choice_operComplexType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase">
 *       &lt;sequence>
 *         &lt;element name="item" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase">
 *                 &lt;sequence>
 *                   &lt;element name="operation" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierOperation"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="condition" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "choice_operComplexType", propOrder = {
    "item"
})
public class ChoiceOperComplexType
    extends XMLCertifierBase
{

    @XmlElement(required = true)
    protected List<ChoiceOperComplexType.Item> item;

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChoiceOperComplexType.Item }
     * 
     * 
     */
    public List<ChoiceOperComplexType.Item> getItem() {
        if (item == null) {
            item = new ArrayList<ChoiceOperComplexType.Item>();
        }
        return this.item;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase">
     *       &lt;sequence>
     *         &lt;element name="operation" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierOperation"/>
     *       &lt;/sequence>
     *       &lt;attribute name="condition" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "operation"
    })
    public static class Item
        extends XMLCertifierBase
    {

        @XmlElement(required = true)
        protected XMLCertifierOperation operation;
        @XmlAttribute(name = "condition")
        protected String condition;

        /**
         * Obtém o valor da propriedade operation.
         * 
         * @return
         *     possible object is
         *     {@link XMLCertifierOperation }
         *     
         */
        public XMLCertifierOperation getOperation() {
            return operation;
        }

        /**
         * Define o valor da propriedade operation.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLCertifierOperation }
         *     
         */
        public void setOperation(XMLCertifierOperation value) {
            this.operation = value;
        }

        /**
         * Obtém o valor da propriedade condition.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCondition() {
            return condition;
        }

        /**
         * Define o valor da propriedade condition.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCondition(String value) {
            this.condition = value;
        }

    }

}
