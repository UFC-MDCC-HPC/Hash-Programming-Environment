/**
 * BackEnd_WS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.backend;

public interface BackEnd_WS extends javax.xml.rpc.Service {
    public java.lang.String getBackEnd_WSSoapAddress();

    public hPE.backend.BackEnd_WSSoap getBackEnd_WSSoap() throws javax.xml.rpc.ServiceException;

    public hPE.backend.BackEnd_WSSoap getBackEnd_WSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getBackEnd_WSSoap12Address();

    public hPE.backend.BackEnd_WSSoap12 getBackEnd_WSSoap12() throws javax.xml.rpc.ServiceException;

    public hPE.backend.BackEnd_WSSoap12 getBackEnd_WSSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
