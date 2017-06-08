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
 * <p>Classe Java de XMLCertifierOperation complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="XMLCertifierOperation">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase">
 *       &lt;choice>
 *         &lt;element name="skip_oper" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase"/>
 *         &lt;element name="break_oper" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase"/>
 *         &lt;element name="continue_oper" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase"/>
 *         &lt;element name="return_oper" type="{http://www.example.org/Certifier_Orchestration}XML_Certifier_Return_Oper"/>
 *         &lt;element name="start_oper" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierPrimOper"/>
 *         &lt;element name="wait_oper" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierPrimOper"/>
 *         &lt;element name="cancel_oper" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierPrimOper"/>
 *         &lt;element name="invoke_oper" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierAction"/>
 *         &lt;element name="sequence_oper" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierCompOper"/>
 *         &lt;element name="parallel_oper" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierCompOper"/>
 *         &lt;element name="choice_oper" type="{http://www.example.org/Certifier_Orchestration}choice_operComplexType"/>
 *         &lt;element name="iterate_oper">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase">
 *                 &lt;sequence>
 *                   &lt;element name="operation" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierOperation" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLCertifierOperation", propOrder = {
    "skipOper",
    "breakOper",
    "continueOper",
    "returnOper",
    "startOper",
    "waitOper",
    "cancelOper",
    "invokeOper",
    "sequenceOper",
    "parallelOper",
    "choiceOper",
    "iterateOper"
})
public class XMLCertifierOperation
    extends XMLCertifierBase
{

    @XmlElement(name = "skip_oper")
    protected XMLCertifierBase skipOper;
    @XmlElement(name = "break_oper")
    protected XMLCertifierBase breakOper;
    @XmlElement(name = "continue_oper")
    protected XMLCertifierBase continueOper;
    @XmlElement(name = "start_oper")
    protected XMLCertifierPrimOper startOper;
    @XmlElement(name = "wait_oper")
    protected XMLCertifierPrimOper waitOper;
    @XmlElement(name = "cancel_oper")
    protected XMLCertifierPrimOper cancelOper;
    @XmlElement(name = "invoke_oper")
    protected XMLCertifierAction invokeOper;
    @XmlElement(name = "sequence_oper")
    protected XMLCertifierCompOper sequenceOper;
    @XmlElement(name = "parallel_oper")
    protected XMLCertifierCompOper parallelOper;
    @XmlElement(name = "choice_oper")
    protected ChoiceOperComplexType choiceOper;
    @XmlElement(name = "iterate_oper")
    protected XMLCertifierOperation.IterateOper iterateOper;
    @XmlElement(name = "return_oper")
    protected XMLCertifierReturnOper returnOper;
    
   
    
    /**
     * Obtém o valor da propriedade skipOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierBase }
     *     
     */
    public XMLCertifierBase getSkipOper() {
        return skipOper;
    }

    /**
     * Define o valor da propriedade skipOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierBase }
     *     
     */
    public void setSkipOper(XMLCertifierBase value) {
        this.skipOper = value;
    }

    /**
     * Obtém o valor da propriedade breakOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierBase }
     *     
     */
    public XMLCertifierBase getBreakOper() {
        return breakOper;
    }

    /**
     * Define o valor da propriedade breakOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierBase }
     *     
     */
    public void setBreakOper(XMLCertifierBase value) {
        this.breakOper = value;
    }

    /**
     * Obtém o valor da propriedade continueOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierBase }
     *     
     */
    public XMLCertifierBase getContinueOper() {
        return continueOper;
    }

    /**
     * Define o valor da propriedade continueOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierBase }
     *     
     */
    public void setContinueOper(XMLCertifierBase value) {
        this.continueOper = value;
    }

    
    /**
     * Obtém o valor da propriedade startOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierPrimOper }
     *     
     */
    public XMLCertifierPrimOper getStartOper() {
        return startOper;
    }

    /**
     * Define o valor da propriedade startOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierPrimOper }
     *     
     */
    public void setStartOper(XMLCertifierPrimOper value) {
        this.startOper = value;
    }

    /**
     * Obtém o valor da propriedade waitOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierPrimOper }
     *     
     */
    public XMLCertifierPrimOper getWaitOper() {
        return waitOper;
    }

    /**
     * Define o valor da propriedade waitOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierPrimOper }
     *     
     */
    public void setWaitOper(XMLCertifierPrimOper value) {
        this.waitOper = value;
    }

    /**
     * Obtém o valor da propriedade cancelOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierPrimOper }
     *     
     */
    public XMLCertifierPrimOper getCancelOper() {
        return cancelOper;
    }

    /**
     * Define o valor da propriedade cancelOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierPrimOper }
     *     
     */
    public void setCancelOper(XMLCertifierPrimOper value) {
        this.cancelOper = value;
    }

    /**
     * Obtém o valor da propriedade invokeOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierAction }
     *     
     */
    public XMLCertifierAction getInvokeOper() {
        return invokeOper;
    }

    /**
     * Define o valor da propriedade invokeOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierAction }
     *     
     */
    public void setInvokeOper(XMLCertifierAction value) {
        this.invokeOper = value;
    }

    /**
     * Obtém o valor da propriedade sequenceOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierCompOper }
     *     
     */
    public XMLCertifierCompOper getSequenceOper() {
        return sequenceOper;
    }

    /**
     * Define o valor da propriedade sequenceOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierCompOper }
     *     
     */
    public void setSequenceOper(XMLCertifierCompOper value) {
        this.sequenceOper = value;
    }

    /**
     * Obtém o valor da propriedade parallelOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierCompOper }
     *     
     */
    public XMLCertifierCompOper getParallelOper() {
        return parallelOper;
    }

    /**
     * Define o valor da propriedade parallelOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierCompOper }
     *     
     */
    public void setParallelOper(XMLCertifierCompOper value) {
        this.parallelOper = value;
    }

    /**
     * Obtém o valor da propriedade choiceOper.
     * 
     * @return
     *     possible object is
     *     {@link ChoiceOperComplexType }
     *     
     */
    public ChoiceOperComplexType getChoiceOper() {
        return choiceOper;
    }

    /**
     * Define o valor da propriedade choiceOper.
     * 
     * @param value
     *     allowed object is
     *     {@link ChoiceOperComplexType }
     *     
     */
    public void setChoiceOper(ChoiceOperComplexType value) {
        this.choiceOper = value;
    }

    /**
     * Obtém o valor da propriedade iterateOper.
     * 
     * @return
     *     possible object is
     *     {@link XMLCertifierOperation.IterateOper }
     *     
     */
    public XMLCertifierReturnOper getReturnOper() {
        return returnOper;
    }

    /**
     * Define o valor da propriedade iterateOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierOperation.IterateOper }
     *     
     */
    public void setReturnOper(XMLCertifierReturnOper value) {
        this.returnOper = value;
    }

    public XMLCertifierOperation.IterateOper getIterateOper() {
        return iterateOper;
    }

    /**
     * Define o valor da propriedade iterateOper.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLCertifierOperation.IterateOper }
     *     
     */
    public void setIterateOper(XMLCertifierOperation.IterateOper value) {
        this.iterateOper = value;
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
     *         &lt;element name="operation" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierOperation" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *       &lt;attribute name="max" type="{http://www.w3.org/2001/XMLSchema}int" />
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
    public static class IterateOper
        extends XMLCertifierBase
    {

        @XmlElement(required = true)
        protected List<XMLCertifierOperation> operation;
        @XmlAttribute(name = "max")
        protected Integer max;

        /**
         * Gets the value of the operation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOperation().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLCertifierOperation }
         * 
         * 
         */
        public List<XMLCertifierOperation> getOperation() {
            if (operation == null) {
                operation = new ArrayList<XMLCertifierOperation>();
            }
            return this.operation;
        }

        /**
         * Obtém o valor da propriedade max.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getMax() {
            return max;
        }

        /**
         * Define o valor da propriedade max.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setMax(Integer value) {
            this.max = value;
        }

    }
    
}
