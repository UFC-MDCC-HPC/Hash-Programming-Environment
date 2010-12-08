/**
 * ComponentRepositoryLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.ComponentRepository;

public class ComponentRepositoryLocator extends org.apache.axis.client.Service implements br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepository {

    public ComponentRepositoryLocator() {
    }


    public ComponentRepositoryLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ComponentRepositoryLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ComponentRepositorySoap
    private java.lang.String ComponentRepositorySoap_address = "http://localhost:62866/ComponentRepository.asmx";

    public java.lang.String getComponentRepositorySoapAddress() {
        return ComponentRepositorySoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ComponentRepositorySoapWSDDServiceName = "ComponentRepositorySoap";

    public java.lang.String getComponentRepositorySoapWSDDServiceName() {
        return ComponentRepositorySoapWSDDServiceName;
    }

    public void setComponentRepositorySoapWSDDServiceName(java.lang.String name) {
        ComponentRepositorySoapWSDDServiceName = name;
    }

    public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap getComponentRepositorySoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ComponentRepositorySoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getComponentRepositorySoap(endpoint);
    }

    public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap getComponentRepositorySoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoapStub _stub = new br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoapStub(portAddress, this);
            _stub.setPortName(getComponentRepositorySoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setComponentRepositorySoapEndpointAddress(java.lang.String address) {
        ComponentRepositorySoap_address = address;
    }


    // Use to get a proxy class for ComponentRepositorySoap12
    private java.lang.String ComponentRepositorySoap12_address = "http://localhost:62866/ComponentRepository.asmx";

    public java.lang.String getComponentRepositorySoap12Address() {
        return ComponentRepositorySoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ComponentRepositorySoap12WSDDServiceName = "ComponentRepositorySoap12";

    public java.lang.String getComponentRepositorySoap12WSDDServiceName() {
        return ComponentRepositorySoap12WSDDServiceName;
    }

    public void setComponentRepositorySoap12WSDDServiceName(java.lang.String name) {
        ComponentRepositorySoap12WSDDServiceName = name;
    }

    public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap getComponentRepositorySoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ComponentRepositorySoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getComponentRepositorySoap12(endpoint);
    }

    public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap getComponentRepositorySoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap12Stub _stub = new br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap12Stub(portAddress, this);
            _stub.setPortName(getComponentRepositorySoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setComponentRepositorySoap12EndpointAddress(java.lang.String address) {
        ComponentRepositorySoap12_address = address;
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
            if (br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap.class.isAssignableFrom(serviceEndpointInterface)) {
                br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoapStub _stub = new br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoapStub(new java.net.URL(ComponentRepositorySoap_address), this);
                _stub.setPortName(getComponentRepositorySoapWSDDServiceName());
                return _stub;
            }
            if (br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap.class.isAssignableFrom(serviceEndpointInterface)) {
                br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap12Stub _stub = new br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap12Stub(new java.net.URL(ComponentRepositorySoap12_address), this);
                _stub.setPortName(getComponentRepositorySoap12WSDDServiceName());
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
        if ("ComponentRepositorySoap".equals(inputPortName)) {
            return getComponentRepositorySoap();
        }
        else if ("ComponentRepositorySoap12".equals(inputPortName)) {
            return getComponentRepositorySoap12();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ComponentRepository.ports.cca.hpe.pargo.ufc.br/", "ComponentRepository");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ComponentRepository.ports.cca.hpe.pargo.ufc.br/", "ComponentRepositorySoap"));
            ports.add(new javax.xml.namespace.QName("http://ComponentRepository.ports.cca.hpe.pargo.ufc.br/", "ComponentRepositorySoap12"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ComponentRepositorySoap".equals(portName)) {
            setComponentRepositorySoapEndpointAddress(address);
        }
        else 
if ("ComponentRepositorySoap12".equals(portName)) {
            setComponentRepositorySoap12EndpointAddress(address);
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
