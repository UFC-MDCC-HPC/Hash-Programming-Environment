/**
 * BackEnd_WSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.backend;

public interface BackEnd_WSSoap extends java.rmi.Remote {
    public java.lang.String deployHashComponent(byte[] data) throws java.rmi.RemoteException;
    public byte[] readEnvironment() throws java.rmi.RemoteException;
    public java.lang.String runApplication(int id_concrete, java.lang.String[] eIds, int[] eVls) throws java.rmi.RemoteException;
    public java.lang.String touchBackEnd(java.lang.String message) throws java.rmi.RemoteException;
}
