/**
 * ManagerComponentClassDescription.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.ComponentRepository;

public abstract class ManagerComponentClassDescription  extends br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentClassDescription  implements java.io.Serializable {
    private java.lang.String componentClassName;

    public ManagerComponentClassDescription() {
    }

    public ManagerComponentClassDescription(
           java.lang.String componentClassName) {
        this.componentClassName = componentClassName;
    }


    /**
     * Gets the componentClassName value for this ManagerComponentClassDescription.
     * 
     * @return componentClassName
     */
    public java.lang.String getComponentClassName() {
        return componentClassName;
    }


    /**
     * Sets the componentClassName value for this ManagerComponentClassDescription.
     * 
     * @param componentClassName
     */
    public void setComponentClassName(java.lang.String componentClassName) {
        this.componentClassName = componentClassName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ManagerComponentClassDescription)) return false;
        ManagerComponentClassDescription other = (ManagerComponentClassDescription) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.componentClassName==null && other.getComponentClassName()==null) || 
             (this.componentClassName!=null &&
              this.componentClassName.equals(other.getComponentClassName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getComponentClassName() != null) {
            _hashCode += getComponentClassName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ManagerComponentClassDescription.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ComponentRepository.ports.cca.hpe.pargo.ufc.br/", "ManagerComponentClassDescription"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componentClassName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ComponentRepository.ports.cca.hpe.pargo.ufc.br/", "ComponentClassName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
