/**
 * RegisterComponentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public class RegisterComponentResponse  implements java.io.Serializable {
    private java.lang.String registerComponentReturn;

    public RegisterComponentResponse() {
    }

    public RegisterComponentResponse(
           java.lang.String registerComponentReturn) {
           this.registerComponentReturn = registerComponentReturn;
    }


    /**
     * Gets the registerComponentReturn value for this RegisterComponentResponse.
     * 
     * @return registerComponentReturn
     */
    public java.lang.String getRegisterComponentReturn() {
        return registerComponentReturn;
    }


    /**
     * Sets the registerComponentReturn value for this RegisterComponentResponse.
     * 
     * @param registerComponentReturn
     */
    public void setRegisterComponentReturn(java.lang.String registerComponentReturn) {
        this.registerComponentReturn = registerComponentReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegisterComponentResponse)) return false;
        RegisterComponentResponse other = (RegisterComponentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.registerComponentReturn==null && other.getRegisterComponentReturn()==null) || 
             (this.registerComponentReturn!=null &&
              this.registerComponentReturn.equals(other.getRegisterComponentReturn())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRegisterComponentReturn() != null) {
            _hashCode += getRegisterComponentReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegisterComponentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://location.hPE", ">registerComponentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registerComponentReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://location.hPE", "registerComponentReturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
