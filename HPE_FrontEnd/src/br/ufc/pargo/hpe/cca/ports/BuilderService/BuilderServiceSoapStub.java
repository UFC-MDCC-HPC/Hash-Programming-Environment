/**
 * BuilderServiceSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.BuilderService;

public class BuilderServiceSoapStub extends org.apache.axis.client.Stub implements br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[17];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createInstance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "instanceName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "className"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "properties"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "TypeMap"), br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"));
        oper.setReturnClass(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "createInstanceResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getComponentIDs");
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfComponentID"));
        oper.setReturnClass(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getComponentIDsResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getComponentProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "cid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "TypeMap"));
        oper.setReturnClass(br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getComponentPropertiesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setComponentProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "cid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "map"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "TypeMap"), br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDeserialization");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "s"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"));
        oper.setReturnClass(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getDeserializationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getComponentID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "componentInstanceName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"));
        oper.setReturnClass(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getComponentIDResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("destroyInstance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "toDie"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "timeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), float.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProvidedPortNames");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "cid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfString"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getProvidedPortNamesResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "string"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUsedPortNames");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "cid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfString"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getUsedPortNamesResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "string"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPortProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "cid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "portName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "TypeMap"));
        oper.setReturnClass(br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getPortPropertiesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setPortProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "cid"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "portName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "map"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "TypeMap"), br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("connect");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "user"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "usingPortName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "provider"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "providingPortName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ConnectionID"));
        oper.setReturnClass(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "connectResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getConnectionIDs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "componentList"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfConnectionID"));
        oper.setReturnClass(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getConnectionIDsResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ConnectionID"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getConnectionProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "connID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ConnectionID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "TypeMap"));
        oper.setReturnClass(br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getConnectionPropertiesResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setConnectionProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "connID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ConnectionID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "map"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "TypeMap"), br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("disconnect");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "connID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ConnectionID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "timeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), float.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("disconnectAll");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "id1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "id2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID"), br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "timeout"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), float.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

    }

    public BuilderServiceSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BuilderServiceSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BuilderServiceSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfComponentID");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID");
            qName2 = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfConnectionID");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ConnectionID");
            qName2 = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ConnectionID");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfInt");
            cachedSerQNames.add(qName);
            cls = int[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int");
            qName2 = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "int");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfProperty");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.Property[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "Property");
            qName2 = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "Property");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ArrayOfString");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "string");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ComponentID");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ConnectionID");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ManagerComponentID");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.ManagerComponentID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ManagerComponentIDImpl");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.ManagerComponentIDImpl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ManagerConnectionID");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.ManagerConnectionID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "ManagerConnectionIDImpl");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.ManagerConnectionIDImpl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "Property");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.Property.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "Type");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.Type.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "TypeMap");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "TypeMapImplWS");
            cachedSerQNames.add(qName);
            cls = br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMapImplWS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID createInstance(java.lang.String instanceName, java.lang.String className, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap properties) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/createInstance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "createInstance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {instanceName, className, properties});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID) org.apache.axis.utils.JavaUtils.convert(_resp, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[] getComponentIDs() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/getComponentIDs");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getComponentIDs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[]) org.apache.axis.utils.JavaUtils.convert(_resp, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap getComponentProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/getComponentProperties");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getComponentProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap) org.apache.axis.utils.JavaUtils.convert(_resp, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setComponentProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap map) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/setComponentProperties");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "setComponentProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cid, map});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID getDeserialization(java.lang.String s) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/getDeserialization");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getDeserialization"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {s});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID) org.apache.axis.utils.JavaUtils.convert(_resp, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID getComponentID(java.lang.String componentInstanceName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/getComponentID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getComponentID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {componentInstanceName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID) org.apache.axis.utils.JavaUtils.convert(_resp, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void destroyInstance(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID toDie, float timeout) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/destroyInstance");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "destroyInstance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {toDie, new java.lang.Float(timeout)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getProvidedPortNames(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/getProvidedPortNames");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getProvidedPortNames"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public java.lang.String[] getUsedPortNames(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/getUsedPortNames");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getUsedPortNames"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cid});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap getPortProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid, java.lang.String portName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/getPortProperties");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getPortProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cid, portName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap) org.apache.axis.utils.JavaUtils.convert(_resp, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setPortProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid, java.lang.String portName, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap map) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/setPortProperties");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "setPortProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cid, portName, map});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connect(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID user, java.lang.String usingPortName, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID provider, java.lang.String providingPortName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/connect");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "connect"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {user, usingPortName, provider, providingPortName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID) org.apache.axis.utils.JavaUtils.convert(_resp, br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID[] getConnectionIDs(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[] componentList) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/getConnectionIDs");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getConnectionIDs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {componentList});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID[]) org.apache.axis.utils.JavaUtils.convert(_resp, br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap getConnectionProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/getConnectionProperties");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "getConnectionProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {connID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap) org.apache.axis.utils.JavaUtils.convert(_resp, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setConnectionProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connID, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap map) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/setConnectionProperties");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "setConnectionProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {connID, map});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void disconnect(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connID, float timeout) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/disconnect");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "disconnect"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {connID, new java.lang.Float(timeout)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void disconnectAll(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID id1, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID id2, float timeout) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://BuilderService.ports.cca.hpe.pargo.ufc.br/disconnectAll");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "disconnectAll"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {id1, id2, new java.lang.Float(timeout)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
