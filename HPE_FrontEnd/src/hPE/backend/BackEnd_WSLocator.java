/**
 * BackEnd_WSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.backend;

public class BackEnd_WSLocator extends org.apache.axis.client.Service implements hPE.backend.BackEnd_WS {

    public BackEnd_WSLocator() {
    }


    public BackEnd_WSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BackEnd_WSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BackEnd_WSSoap
    private java.lang.String BackEnd_WSSoap_address = "http://localhost:3494/teste/BackEndWS.asmx";

    public java.lang.String getBackEnd_WSSoapAddress() {
        return BackEnd_WSSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BackEnd_WSSoapWSDDServiceName = "BackEnd_WSSoap";

    public java.lang.String getBackEnd_WSSoapWSDDServiceName() {
        return BackEnd_WSSoapWSDDServiceName;
    }

    public void setBackEnd_WSSoapWSDDServiceName(java.lang.String name) {
        BackEnd_WSSoapWSDDServiceName = name;
    }

    public hPE.backend.BackEnd_WSSoap getBackEnd_WSSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BackEnd_WSSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBackEnd_WSSoap(endpoint);
    }

    public hPE.backend.BackEnd_WSSoap getBackEnd_WSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            hPE.backend.BackEnd_WSSoapStub _stub = new hPE.backend.BackEnd_WSSoapStub(portAddress, this);
            _stub.setPortName(getBackEnd_WSSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBackEnd_WSSoapEndpointAddress(java.lang.String address) {
        BackEnd_WSSoap_address = address;
    }


    // Use to get a proxy class for BackEnd_WSSoap12
    private java.lang.String BackEnd_WSSoap12_address = "http://localhost:3494/teste/BackEndWS.asmx";

    public java.lang.String getBackEnd_WSSoap12Address() {
        return BackEnd_WSSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BackEnd_WSSoap12WSDDServiceName = "BackEnd_WSSoap12";

    public java.lang.String getBackEnd_WSSoap12WSDDServiceName() {
        return BackEnd_WSSoap12WSDDServiceName;
    }

    public void setBackEnd_WSSoap12WSDDServiceName(java.lang.String name) {
        BackEnd_WSSoap12WSDDServiceName = name;
    }

    public hPE.backend.BackEnd_WSSoap getBackEnd_WSSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BackEnd_WSSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBackEnd_WSSoap12(endpoint);
    }

    public hPE.backend.BackEnd_WSSoap getBackEnd_WSSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            hPE.backend.BackEnd_WSSoap12Stub _stub = new hPE.backend.BackEnd_WSSoap12Stub(portAddress, this);
            _stub.setPortName(getBackEnd_WSSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBackEnd_WSSoap12EndpointAddress(java.lang.String address) {
        BackEnd_WSSoap12_address = address;
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
            if (hPE.backend.BackEnd_WSSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                hPE.backend.BackEnd_WSSoapStub _stub = new hPE.backend.BackEnd_WSSoapStub(new java.net.URL(BackEnd_WSSoap_address), this);
                _stub.setPortName(getBackEnd_WSSoapWSDDServiceName());
                return _stub;
            }
            if (hPE.backend.BackEnd_WSSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                hPE.backend.BackEnd_WSSoap12Stub _stub = new hPE.backend.BackEnd_WSSoap12Stub(new java.net.URL(BackEnd_WSSoap12_address), this);
                _stub.setPortName(getBackEnd_WSSoap12WSDDServiceName());
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
        if ("BackEnd_WSSoap".equals(inputPortName)) {
            return getBackEnd_WSSoap();
        }
        else if ("BackEnd_WSSoap12".equals(inputPortName)) {
            return getBackEnd_WSSoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://backend.hPE/", "BackEnd_WS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://backend.hPE/", "BackEnd_WSSoap"));
            ports.add(new javax.xml.namespace.QName("http://backend.hPE/", "BackEnd_WSSoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BackEnd_WSSoap".equals(portName)) {
            setBackEnd_WSSoapEndpointAddress(address);
        }
        else 
if ("BackEnd_WSSoap12".equals(portName)) {
            setBackEnd_WSSoap12EndpointAddress(address);
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
