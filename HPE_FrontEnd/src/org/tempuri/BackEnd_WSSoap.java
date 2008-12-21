/**
 * BackEnd_WSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface BackEnd_WSSoap extends java.rmi.Remote {
    public java.lang.String deployAbstractComponent(byte[] data) throws java.rmi.RemoteException;
    public java.lang.String deployHashComponent(byte[] data) throws java.rmi.RemoteException;
    public java.lang.String touchBackEnd(java.lang.String message) throws java.rmi.RemoteException;
}
