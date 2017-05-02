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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de XMLCertifierCompOper complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="XMLCertifierCompOper">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.example.org/Certifier_Orchestration}XMLCertifierBase">
 *       &lt;sequence>
 *         &lt;element name="operation" type="{http://www.example.org/Certifier_Orchestration}XMLCertifierOperation" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XMLCertifierCompOper", propOrder = {
    "operation"
})
public class XMLCertifierCompOper
    extends XMLCertifierBase
{

    @XmlElement(required = true)
    protected List<XMLCertifierOperation> operation;

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

}
