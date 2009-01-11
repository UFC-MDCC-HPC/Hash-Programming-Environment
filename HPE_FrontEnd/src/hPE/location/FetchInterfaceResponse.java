/**
 * FetchInterfaceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public class FetchInterfaceResponse  implements java.io.Serializable {
    private java.lang.String fetchInterfaceReturn;

    public FetchInterfaceResponse() {
    }

    public FetchInterfaceResponse(
           java.lang.String fetchInterfaceReturn) {
           this.fetchInterfaceReturn = fetchInterfaceReturn;
    }


    /**
     * Gets the fetchInterfaceReturn value for this FetchInterfaceResponse.
     * 
     * @return fetchInterfaceReturn
     */
    public java.lang.String getFetchInterfaceReturn() {
        return fetchInterfaceReturn;
    }


    /**
     * Sets the fetchInterfaceReturn value for this FetchInterfaceResponse.
     * 
     * @param fetchInterfaceReturn
     */
    public void setFetchInterfaceReturn(java.lang.String fetchInterfaceReturn) {
        this.fetchInterfaceReturn = fetchInterfaceReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FetchInterfaceResponse)) return false;
        FetchInterfaceResponse other = (FetchInterfaceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fetchInterfaceReturn==null && other.getFetchInterfaceReturn()==null) || 
             (this.fetchInterfaceReturn!=null &&
              this.fetchInterfaceReturn.equals(other.getFetchInterfaceReturn())));
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
        if (getFetchInterfaceReturn() != null) {
            _hashCode += getFetchInterfaceReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FetchInterfaceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://location.hPE", ">fetchInterfaceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fetchInterfaceReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://location.hPE", "fetchInterfaceReturn"));
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
