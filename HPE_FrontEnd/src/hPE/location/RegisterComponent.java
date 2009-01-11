/**
 * RegisterComponent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public class RegisterComponent  implements java.io.Serializable {
    private java.lang.String packageName;

    private java.lang.String componentName;

    private java.lang.String contents;

    public RegisterComponent() {
    }

    public RegisterComponent(
           java.lang.String packageName,
           java.lang.String componentName,
           java.lang.String contents) {
           this.packageName = packageName;
           this.componentName = componentName;
           this.contents = contents;
    }


    /**
     * Gets the packageName value for this RegisterComponent.
     * 
     * @return packageName
     */
    public java.lang.String getPackageName() {
        return packageName;
    }


    /**
     * Sets the packageName value for this RegisterComponent.
     * 
     * @param packageName
     */
    public void setPackageName(java.lang.String packageName) {
        this.packageName = packageName;
    }


    /**
     * Gets the componentName value for this RegisterComponent.
     * 
     * @return componentName
     */
    public java.lang.String getComponentName() {
        return componentName;
    }


    /**
     * Sets the componentName value for this RegisterComponent.
     * 
     * @param componentName
     */
    public void setComponentName(java.lang.String componentName) {
        this.componentName = componentName;
    }


    /**
     * Gets the contents value for this RegisterComponent.
     * 
     * @return contents
     */
    public java.lang.String getContents() {
        return contents;
    }


    /**
     * Sets the contents value for this RegisterComponent.
     * 
     * @param contents
     */
    public void setContents(java.lang.String contents) {
        this.contents = contents;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegisterComponent)) return false;
        RegisterComponent other = (RegisterComponent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.packageName==null && other.getPackageName()==null) || 
             (this.packageName!=null &&
              this.packageName.equals(other.getPackageName()))) &&
            ((this.componentName==null && other.getComponentName()==null) || 
             (this.componentName!=null &&
              this.componentName.equals(other.getComponentName()))) &&
            ((this.contents==null && other.getContents()==null) || 
             (this.contents!=null &&
              this.contents.equals(other.getContents())));
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
        if (getPackageName() != null) {
            _hashCode += getPackageName().hashCode();
        }
        if (getComponentName() != null) {
            _hashCode += getComponentName().hashCode();
        }
        if (getContents() != null) {
            _hashCode += getContents().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegisterComponent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://location.hPE", ">registerComponent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("packageName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://location.hPE", "packageName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("componentName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://location.hPE", "componentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contents");
        elemField.setXmlName(new javax.xml.namespace.QName("http://location.hPE", "contents"));
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
