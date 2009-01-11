/**
 * FetchPackagesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public class FetchPackagesResponse  implements java.io.Serializable {
    private java.lang.String fetchPackagesReturn;

    public FetchPackagesResponse() {
    }

    public FetchPackagesResponse(
           java.lang.String fetchPackagesReturn) {
           this.fetchPackagesReturn = fetchPackagesReturn;
    }


    /**
     * Gets the fetchPackagesReturn value for this FetchPackagesResponse.
     * 
     * @return fetchPackagesReturn
     */
    public java.lang.String getFetchPackagesReturn() {
        return fetchPackagesReturn;
    }


    /**
     * Sets the fetchPackagesReturn value for this FetchPackagesResponse.
     * 
     * @param fetchPackagesReturn
     */
    public void setFetchPackagesReturn(java.lang.String fetchPackagesReturn) {
        this.fetchPackagesReturn = fetchPackagesReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FetchPackagesResponse)) return false;
        FetchPackagesResponse other = (FetchPackagesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fetchPackagesReturn==null && other.getFetchPackagesReturn()==null) || 
             (this.fetchPackagesReturn!=null &&
              this.fetchPackagesReturn.equals(other.getFetchPackagesReturn())));
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
        if (getFetchPackagesReturn() != null) {
            _hashCode += getFetchPackagesReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FetchPackagesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://location.hPE", ">fetchPackagesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fetchPackagesReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://location.hPE", "fetchPackagesReturn"));
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
