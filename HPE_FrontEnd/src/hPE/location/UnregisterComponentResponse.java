/**
 * UnregisterComponentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public class UnregisterComponentResponse  implements java.io.Serializable {
    private java.lang.String unregisterComponentReturn;

    public UnregisterComponentResponse() {
    }

    public UnregisterComponentResponse(
           java.lang.String unregisterComponentReturn) {
           this.unregisterComponentReturn = unregisterComponentReturn;
    }


    /**
     * Gets the unregisterComponentReturn value for this UnregisterComponentResponse.
     * 
     * @return unregisterComponentReturn
     */
    public java.lang.String getUnregisterComponentReturn() {
        return unregisterComponentReturn;
    }


    /**
     * Sets the unregisterComponentReturn value for this UnregisterComponentResponse.
     * 
     * @param unregisterComponentReturn
     */
    public void setUnregisterComponentReturn(java.lang.String unregisterComponentReturn) {
        this.unregisterComponentReturn = unregisterComponentReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnregisterComponentResponse)) return false;
        UnregisterComponentResponse other = (UnregisterComponentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.unregisterComponentReturn==null && other.getUnregisterComponentReturn()==null) || 
             (this.unregisterComponentReturn!=null &&
              this.unregisterComponentReturn.equals(other.getUnregisterComponentReturn())));
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
        if (getUnregisterComponentReturn() != null) {
            _hashCode += getUnregisterComponentReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnregisterComponentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://location.hPE", ">unregisterComponentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unregisterComponentReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://location.hPE", "unregisterComponentReturn"));
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
