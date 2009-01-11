/**
 * LocationServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public class LocationServiceServiceLocator extends org.apache.axis.client.Service implements hPE.location.LocationServiceService {

    public LocationServiceServiceLocator() {
    }


    public LocationServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LocationServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LocationService
    private java.lang.String LocationService_address = "http://localhost:8081/HPE_Location/services/LocationService";

    public java.lang.String getLocationServiceAddress() {
        return LocationService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LocationServiceWSDDServiceName = "LocationService";

    public java.lang.String getLocationServiceWSDDServiceName() {
        return LocationServiceWSDDServiceName;
    }

    public void setLocationServiceWSDDServiceName(java.lang.String name) {
        LocationServiceWSDDServiceName = name;
    }

    public hPE.location.LocationService getLocationService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LocationService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLocationService(endpoint);
    }

    public hPE.location.LocationService getLocationService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            hPE.location.LocationServiceSoapBindingStub _stub = new hPE.location.LocationServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getLocationServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLocationServiceEndpointAddress(java.lang.String address) {
        LocationService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (hPE.location.LocationService.class.isAssignableFrom(serviceEndpointInterface)) {
                hPE.location.LocationServiceSoapBindingStub _stub = new hPE.location.LocationServiceSoapBindingStub(new java.net.URL(LocationService_address), this);
                _stub.setPortName(getLocationServiceWSDDServiceName());
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
        if ("LocationService".equals(inputPortName)) {
            return getLocationService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://location.hPE", "LocationServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://location.hPE", "LocationService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LocationService".equals(portName)) {
            setLocationServiceEndpointAddress(address);
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
