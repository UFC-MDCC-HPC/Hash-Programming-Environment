/**
 * LocationServerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.LocationServer_jws;

public interface LocationServerService extends javax.xml.rpc.Service {
    public java.lang.String getLocationServerAddress();

    public localhost.axis.LocationServer_jws.LocationServer getLocationServer() throws javax.xml.rpc.ServiceException;

    public localhost.axis.LocationServer_jws.LocationServer getLocationServer(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
