/**
 * BuilderServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.BuilderService;

public class BuilderServiceLocator extends org.apache.axis.client.Service implements br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderService {

    public BuilderServiceLocator() {
    }


    public BuilderServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BuilderServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BuilderServiceSoap12
    private java.lang.String BuilderServiceSoap12_address = "http://localhost:62822/BuilderService.asmx";

    public java.lang.String getBuilderServiceSoap12Address() {
        return BuilderServiceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BuilderServiceSoap12WSDDServiceName = "BuilderServiceSoap12";

    public java.lang.String getBuilderServiceSoap12WSDDServiceName() {
        return BuilderServiceSoap12WSDDServiceName;
    }

    public void setBuilderServiceSoap12WSDDServiceName(java.lang.String name) {
        BuilderServiceSoap12WSDDServiceName = name;
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap getBuilderServiceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BuilderServiceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBuilderServiceSoap12(endpoint);
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap getBuilderServiceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap12Stub _stub = new br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap12Stub(portAddress, this);
            _stub.setPortName(getBuilderServiceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBuilderServiceSoap12EndpointAddress(java.lang.String address) {
        BuilderServiceSoap12_address = address;
    }


    // Use to get a proxy class for BuilderServiceSoap
    private java.lang.String BuilderServiceSoap_address = "http://localhost:62822/BuilderService.asmx";

    public java.lang.String getBuilderServiceSoapAddress() {
        return BuilderServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BuilderServiceSoapWSDDServiceName = "BuilderServiceSoap";

    public java.lang.String getBuilderServiceSoapWSDDServiceName() {
        return BuilderServiceSoapWSDDServiceName;
    }

    public void setBuilderServiceSoapWSDDServiceName(java.lang.String name) {
        BuilderServiceSoapWSDDServiceName = name;
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap getBuilderServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BuilderServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBuilderServiceSoap(endpoint);
    }

    public br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap getBuilderServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoapStub _stub = new br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoapStub(portAddress, this);
            _stub.setPortName(getBuilderServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBuilderServiceSoapEndpointAddress(java.lang.String address) {
        BuilderServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap12Stub _stub = new br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap12Stub(new java.net.URL(BuilderServiceSoap12_address), this);
                _stub.setPortName(getBuilderServiceSoap12WSDDServiceName());
                return _stub;
            }
            if (br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoapStub _stub = new br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoapStub(new java.net.URL(BuilderServiceSoap_address), this);
                _stub.setPortName(getBuilderServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BuilderServiceSoap12".equals(inputPortName)) {
            return getBuilderServiceSoap12();
        }
        else if ("BuilderServiceSoap".equals(inputPortName)) {
            return getBuilderServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "BuilderService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "BuilderServiceSoap12"));
            ports.add(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "BuilderServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BuilderServiceSoap12".equals(portName)) {
            setBuilderServiceSoap12EndpointAddress(address);
        }
        else 
if ("BuilderServiceSoap".equals(portName)) {
            setBuilderServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
