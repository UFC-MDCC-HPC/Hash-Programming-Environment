/**
 * BackEnd_WSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.backend;

public interface BackEnd_WSSoap extends java.rmi.Remote {
    public java.lang.String getSiteName() throws java.rmi.RemoteException;
    public java.lang.String deployHashComponent(byte[] data, java.lang.String userName, java.lang.String password, java.lang.String curDir, boolean flag_compile) throws java.rmi.RemoteException;
    public java.lang.String deployHashConfiguration(byte[] data, byte[] hcl_data, java.lang.String userName, java.lang.String password, java.lang.String curDir, boolean flag_compile) throws java.rmi.RemoteException;
    public byte[] readEnvironment() throws java.rmi.RemoteException;
    public java.lang.String readCatalog() throws java.rmi.RemoteException;
    public java.lang.String hosts() throws java.rmi.RemoteException;
    public java.lang.String openSession(java.lang.String session_id) throws java.rmi.RemoteException;
    public java.lang.String[] getPorts(java.lang.String session_id, java.lang.String instance_id) throws java.rmi.RemoteException;
    public void closeSession(java.lang.String session_id) throws java.rmi.RemoteException;
    public java.lang.String[] runApplication(java.lang.String instantiator_string, java.lang.String session) throws java.rmi.RemoteException;
    public void createApplicationInstance(java.lang.String session_id_string, java.lang.String instance_name, java.lang.String instantiator_string) throws java.rmi.RemoteException;
}
