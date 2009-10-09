/**
 * BackEnd_WSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.backend;

public interface BackEnd_WSSoap extends java.rmi.Remote {
    public java.lang.String deployHashComponent(byte[] data, java.lang.String userName, java.lang.String password, java.lang.String curDir) throws java.rmi.RemoteException;
    public byte[] readEnvironment() throws java.rmi.RemoteException;
    public java.lang.String[] runApplication(int id_concrete, java.lang.String[] eIds, int[] eVls, java.lang.String userName, java.lang.String password, java.lang.String curDir) throws java.rmi.RemoteException;
    public java.lang.String hosts() throws java.rmi.RemoteException;
}
