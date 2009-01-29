/**
 * HPE_Location_ServerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public interface HPE_Location_ServerService extends javax.xml.rpc.Service {
    public java.lang.String getHPE_Location_ServerAddress();

    public hPE.location.HPE_Location_Server getHPE_Location_Server() throws javax.xml.rpc.ServiceException;

    public hPE.location.HPE_Location_Server getHPE_Location_Server(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
