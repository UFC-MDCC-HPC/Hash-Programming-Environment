/**
 * HPE_Location_ServerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.mdcc.hclc.locationclient;

public class HPE_Location_ServerServiceLocator extends org.apache.axis.client.Service implements br.ufc.mdcc.hclc.locationclient.HPE_Location_ServerService {

    public HPE_Location_ServerServiceLocator() {
    }


    public HPE_Location_ServerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HPE_Location_ServerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HPE_Location_Server
    private java.lang.String HPE_Location_Server_address = "http://localhost:8081/HPE_Location/HPE_Location_Server.jws";

    public java.lang.String getHPE_Location_ServerAddress() {
        return HPE_Location_Server_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HPE_Location_ServerWSDDServiceName = "HPE_Location_Server";

    public java.lang.String getHPE_Location_ServerWSDDServiceName() {
        return HPE_Location_ServerWSDDServiceName;
    }

    public void setHPE_Location_ServerWSDDServiceName(java.lang.String name) {
        HPE_Location_ServerWSDDServiceName = name;
    }

    public br.ufc.mdcc.hclc.locationclient.HPE_Location_Server getHPE_Location_Server() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HPE_Location_Server_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHPE_Location_Server(endpoint);
    }

    public br.ufc.mdcc.hclc.locationclient.HPE_Location_Server getHPE_Location_Server(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.ufc.mdcc.hclc.locationclient.HPE_Location_ServerSoapBindingStub _stub = new br.ufc.mdcc.hclc.locationclient.HPE_Location_ServerSoapBindingStub(portAddress, this);
            _stub.setPortName(getHPE_Location_ServerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHPE_Location_ServerEndpointAddress(java.lang.String address) {
        HPE_Location_Server_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.ufc.mdcc.hclc.locationclient.HPE_Location_Server.class.isAssignableFrom(serviceEndpointInterface)) {
                br.ufc.mdcc.hclc.locationclient.HPE_Location_ServerSoapBindingStub _stub = new br.ufc.mdcc.hclc.locationclient.HPE_Location_ServerSoapBindingStub(new java.net.URL(HPE_Location_Server_address), this);
                _stub.setPortName(getHPE_Location_ServerWSDDServiceName());
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
        if ("HPE_Location_Server".equals(inputPortName)) {
            return getHPE_Location_Server();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8081/HPE_Location/HPE_Location_Server.jws", "HPE_Location_ServerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8081/HPE_Location/HPE_Location_Server.jws", "HPE_Location_Server"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HPE_Location_Server".equals(portName)) {
            setHPE_Location_ServerEndpointAddress(address);
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
