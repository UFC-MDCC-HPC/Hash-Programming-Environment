/**
 * GetComponentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public class GetComponentResponse  implements java.io.Serializable {
    private java.lang.String getComponentReturn;

    public GetComponentResponse() {
    }

    public GetComponentResponse(
           java.lang.String getComponentReturn) {
           this.getComponentReturn = getComponentReturn;
    }


    /**
     * Gets the getComponentReturn value for this GetComponentResponse.
     * 
     * @return getComponentReturn
     */
    public java.lang.String getGetComponentReturn() {
        return getComponentReturn;
    }


    /**
     * Sets the getComponentReturn value for this GetComponentResponse.
     * 
     * @param getComponentReturn
     */
    public void setGetComponentReturn(java.lang.String getComponentReturn) {
        this.getComponentReturn = getComponentReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetComponentResponse)) return false;
        GetComponentResponse other = (GetComponentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getComponentReturn==null && other.getGetComponentReturn()==null) || 
             (this.getComponentReturn!=null &&
              this.getComponentReturn.equals(other.getGetComponentReturn())));
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
        if (getGetComponentReturn() != null) {
            _hashCode += getGetComponentReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetComponentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://location.hPE", ">getComponentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getComponentReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://location.hPE", "getComponentReturn"));
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
