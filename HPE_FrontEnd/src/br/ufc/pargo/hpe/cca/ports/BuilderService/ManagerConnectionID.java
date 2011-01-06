/**
 * ManagerConnectionID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.BuilderService;

public abstract class ManagerConnectionID  extends br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID  implements java.io.Serializable {
    private int[] nodes;

    private br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID provider;

    private java.lang.String providesPortName;

    private br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID user;

    private java.lang.String usesPortName;

    public ManagerConnectionID() {
    }

    public ManagerConnectionID(
           int[] nodes,
           br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID provider,
           java.lang.String providesPortName,
           br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID user,
           java.lang.String usesPortName) {
        this.nodes = nodes;
        this.provider = provider;
        this.providesPortName = providesPortName;
        this.user = user;
        this.usesPortName = usesPortName;
    }


    /**
     * Gets the nodes value for this ManagerConnectionID.
     * 
     * @return nodes
     */
    public int[] getNodes() {
        return nodes;
    }


    /**
     * Sets the nodes value for this ManagerConnectionID.
     * 
     * @param nodes
     */
    public void setNodes(int[] nodes) {
        this.nodes = nodes;
    }


    /**
     * Gets the provider value for this ManagerConnectionID.
     * 
     * @return provider
     */
    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID getProvider() {
        return provider;
    }


    /**
     * Sets the provider value for this ManagerConnectionID.
     * 
     * @param provider
     */
    public void setProvider(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID provider) {
        this.provider = provider;
    }


    /**
     * Gets the providesPortName value for this ManagerConnectionID.
     * 
     * @return providesPortName
     */
    public java.lang.String getProvidesPortName() {
        return providesPortName;
    }


    /**
     * Sets the providesPortName value for this ManagerConnectionID.
     * 
     * @param providesPortName
     */
    public void setProvidesPortName(java.lang.String providesPortName) {
        this.providesPortName = providesPortName;
    }


    /**
     * Gets the user value for this ManagerConnectionID.
     * 
     * @return user
     */
    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID getUser() {
        return user;
    }


    /**
     * Sets the user value for this ManagerConnectionID.
     * 
     * @param user
     */
    public void setUser(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID user) {
        this.user = user;
    }


    /**
     * Gets the usesPortName value for this ManagerConnectionID.
     * 
     * @return usesPortName
     */
    public java.lang.String getUsesPortName() {
        return usesPortName;
    }


    /**
     * Sets the usesPortName value for this ManagerConnectionID.
     * 
     * @param usesPortName
     */
    public void setUsesPortName(java.lang.String usesPortName) {
        this.usesPortName = usesPortName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ManagerConnectionID)) return false;
        ManagerConnectionID other = (ManagerConnectionID) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.nodes==null && other.getNodes()==null) || 
             (this.nodes!=null &&
              java.util.Arrays.equals(this.nodes, other.getNodes()))) &&
            ((this.provider==null && other.getProvider()==null) || 
             (this.provider!=null &&
              this.provider.equals(other.getProvider()))) &&
            ((this.providesPortName==null && other.getProvidesPortName()==null) || 
             (this.providesPortName!=null &&
              this.providesPortName.equals(other.getProvidesPortName()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.usesPortName==null && other.getUsesPortName()==null) || 
             (this.usesPortName!=null &&
              this.usesPortName.equals(other.getUsesPortName())));
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
        if (getNodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProvider() != null) {
            _hashCode += getProvider().hashCode();
        }
        if (getProvidesPortName() != null) {
            _hashCode += getProvidesPortName().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getUsesPortName() != null) {
            _hashCode += getUsesPortName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ManagerConnectionID.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ManagerConnectionID"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nodes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "Nodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provider");
        elemField.setXmlName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "Provider"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("providesPortName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ProvidesPortName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usesPortName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "UsesPortName"));
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
