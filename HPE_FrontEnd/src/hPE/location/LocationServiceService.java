/**
 * LocationServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public interface LocationServiceService extends javax.xml.rpc.Service {
    public java.lang.String getLocationServiceAddress();

    public hPE.location.LocationService getLocationService() throws javax.xml.rpc.ServiceException;

    public hPE.location.LocationService getLocationService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
