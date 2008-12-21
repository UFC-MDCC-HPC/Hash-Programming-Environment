/**
 * LocationServerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.LocationServer_jws;

public class LocationServerServiceLocator extends org.apache.axis.client.Service implements localhost.axis.LocationServer_jws.LocationServerService {

    public LocationServerServiceLocator() {
    }


    public LocationServerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LocationServerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LocationServer
    private java.lang.String LocationServer_address = "http://localhost:8080/axis/LocationServer.jws";

    public java.lang.String getLocationServerAddress() {
        return LocationServer_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LocationServerWSDDServiceName = "LocationServer";

    public java.lang.String getLocationServerWSDDServiceName() {
        return LocationServerWSDDServiceName;
    }

    public void setLocationServerWSDDServiceName(java.lang.String name) {
        LocationServerWSDDServiceName = name;
    }

    public localhost.axis.LocationServer_jws.LocationServer getLocationServer() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LocationServer_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLocationServer(endpoint);
    }

    public localhost.axis.LocationServer_jws.LocationServer getLocationServer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            localhost.axis.LocationServer_jws.LocationServerSoapBindingStub _stub = new localhost.axis.LocationServer_jws.LocationServerSoapBindingStub(portAddress, this);
            _stub.setPortName(getLocationServerWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLocationServerEndpointAddress(java.lang.String address) {
        LocationServer_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (localhost.axis.LocationServer_jws.LocationServer.class.isAssignableFrom(serviceEndpointInterface)) {
                localhost.axis.LocationServer_jws.LocationServerSoapBindingStub _stub = new localhost.axis.LocationServer_jws.LocationServerSoapBindingStub(new java.net.URL(LocationServer_address), this);
                _stub.setPortName(getLocationServerWSDDServiceName());
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
        if ("LocationServer".equals(inputPortName)) {
            return getLocationServer();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://localhost:8080/axis/LocationServer.jws", "LocationServerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://localhost:8080/axis/LocationServer.jws", "LocationServer"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LocationServer".equals(portName)) {
            setLocationServerEndpointAddress(address);
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
