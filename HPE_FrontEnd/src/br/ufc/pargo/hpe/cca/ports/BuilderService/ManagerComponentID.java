/**
 * ManagerComponentID.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.BuilderService;

public abstract class ManagerComponentID  extends br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID  implements java.io.Serializable {
    private java.lang.String instanceName;

    private int[] workerNodes;

    private java.lang.String[] workerUnitNames;

    private int[] workerUnitIndexes;

    public ManagerComponentID() {
    }

    public ManagerComponentID(
           java.lang.String instanceName,
           int[] workerNodes,
           java.lang.String[] workerUnitNames,
           int[] workerUnitIndexes) {
        this.instanceName = instanceName;
        this.workerNodes = workerNodes;
        this.workerUnitNames = workerUnitNames;
        this.workerUnitIndexes = workerUnitIndexes;
    }


    /**
     * Gets the instanceName value for this ManagerComponentID.
     * 
     * @return instanceName
     */
    public java.lang.String getInstanceName() {
        return instanceName;
    }


    /**
     * Sets the instanceName value for this ManagerComponentID.
     * 
     * @param instanceName
     */
    public void setInstanceName(java.lang.String instanceName) {
        this.instanceName = instanceName;
    }


    /**
     * Gets the workerNodes value for this ManagerComponentID.
     * 
     * @return workerNodes
     */
    public int[] getWorkerNodes() {
        return workerNodes;
    }


    /**
     * Sets the workerNodes value for this ManagerComponentID.
     * 
     * @param workerNodes
     */
    public void setWorkerNodes(int[] workerNodes) {
        this.workerNodes = workerNodes;
    }


    /**
     * Gets the workerUnitNames value for this ManagerComponentID.
     * 
     * @return workerUnitNames
     */
    public java.lang.String[] getWorkerUnitNames() {
        return workerUnitNames;
    }


    /**
     * Sets the workerUnitNames value for this ManagerComponentID.
     * 
     * @param workerUnitNames
     */
    public void setWorkerUnitNames(java.lang.String[] workerUnitNames) {
        this.workerUnitNames = workerUnitNames;
    }


    /**
     * Gets the workerUnitIndexes value for this ManagerComponentID.
     * 
     * @return workerUnitIndexes
     */
    public int[] getWorkerUnitIndexes() {
        return workerUnitIndexes;
    }


    /**
     * Sets the workerUnitIndexes value for this ManagerComponentID.
     * 
     * @param workerUnitIndexes
     */
    public void setWorkerUnitIndexes(int[] workerUnitIndexes) {
        this.workerUnitIndexes = workerUnitIndexes;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ManagerComponentID)) return false;
        ManagerComponentID other = (ManagerComponentID) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.instanceName==null && other.getInstanceName()==null) || 
             (this.instanceName!=null &&
              this.instanceName.equals(other.getInstanceName()))) &&
            ((this.workerNodes==null && other.getWorkerNodes()==null) || 
             (this.workerNodes!=null &&
              java.util.Arrays.equals(this.workerNodes, other.getWorkerNodes()))) &&
            ((this.workerUnitNames==null && other.getWorkerUnitNames()==null) || 
             (this.workerUnitNames!=null &&
              java.util.Arrays.equals(this.workerUnitNames, other.getWorkerUnitNames()))) &&
            ((this.workerUnitIndexes==null && other.getWorkerUnitIndexes()==null) || 
             (this.workerUnitIndexes!=null &&
              java.util.Arrays.equals(this.workerUnitIndexes, other.getWorkerUnitIndexes())));
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
        if (getInstanceName() != null) {
            _hashCode += getInstanceName().hashCode();
        }
        if (getWorkerNodes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWorkerNodes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWorkerNodes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWorkerUnitNames() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWorkerUnitNames());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWorkerUnitNames(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWorkerUnitIndexes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWorkerUnitIndexes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWorkerUnitIndexes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ManagerComponentID.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ManagerComponentID"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instanceName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "InstanceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workerNodes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "WorkerNodes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "int"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workerUnitNames");
        elemField.setXmlName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "WorkerUnitNames"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "string"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workerUnitIndexes");
        elemField.setXmlName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "WorkerUnitIndexes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "int"));
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
