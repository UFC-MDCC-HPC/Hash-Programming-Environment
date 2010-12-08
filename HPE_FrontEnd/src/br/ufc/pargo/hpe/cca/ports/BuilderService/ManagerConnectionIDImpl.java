/**
 * ManagerConnectionIDImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.BuilderService;

public class ManagerConnectionIDImpl  extends br.ufc.pargo.hpe.cca.ports.BuilderService.ManagerConnectionID  implements java.io.Serializable {
    public ManagerConnectionIDImpl() {
    }

    public ManagerConnectionIDImpl(
           int[] nodes,
           br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID provider,
           java.lang.String providesPortName,
           br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID user,
           java.lang.String usesPortName) {
        super(
            nodes,
            provider,
            providesPortName,
            user,
            usesPortName);
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ManagerConnectionIDImpl)) return false;
        ManagerConnectionIDImpl other = (ManagerConnectionIDImpl) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ManagerConnectionIDImpl.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ManagerConnectionIDImpl"));
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
