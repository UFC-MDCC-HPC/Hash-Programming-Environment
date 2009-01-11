/**
 * CreatePackageResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public class CreatePackageResponse  implements java.io.Serializable {
    private java.lang.String createPackageReturn;

    public CreatePackageResponse() {
    }

    public CreatePackageResponse(
           java.lang.String createPackageReturn) {
           this.createPackageReturn = createPackageReturn;
    }


    /**
     * Gets the createPackageReturn value for this CreatePackageResponse.
     * 
     * @return createPackageReturn
     */
    public java.lang.String getCreatePackageReturn() {
        return createPackageReturn;
    }


    /**
     * Sets the createPackageReturn value for this CreatePackageResponse.
     * 
     * @param createPackageReturn
     */
    public void setCreatePackageReturn(java.lang.String createPackageReturn) {
        this.createPackageReturn = createPackageReturn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreatePackageResponse)) return false;
        CreatePackageResponse other = (CreatePackageResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.createPackageReturn==null && other.getCreatePackageReturn()==null) || 
             (this.createPackageReturn!=null &&
              this.createPackageReturn.equals(other.getCreatePackageReturn())));
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
        if (getCreatePackageReturn() != null) {
            _hashCode += getCreatePackageReturn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreatePackageResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://location.hPE", ">createPackageResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createPackageReturn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://location.hPE", "createPackageReturn"));
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
