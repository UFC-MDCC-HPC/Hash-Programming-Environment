/**
 * BuilderServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.BuilderService;

public interface BuilderServiceSoap extends java.rmi.Remote {
    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID createInstance(java.lang.String instanceName, java.lang.String className, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap properties) throws java.rmi.RemoteException;
    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[] getComponentIDs() throws java.rmi.RemoteException;
    public br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap getComponentProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid) throws java.rmi.RemoteException;
    public void setComponentProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap map) throws java.rmi.RemoteException;
    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID getDeserialization(java.lang.String s) throws java.rmi.RemoteException;
    public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID getComponentID(java.lang.String componentInstanceName) throws java.rmi.RemoteException;
    public void destroyInstance(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID toDie, float timeout) throws java.rmi.RemoteException;
    public java.lang.String[] getProvidedPortNames(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid) throws java.rmi.RemoteException;
    public java.lang.String[] getUsedPortNames(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid) throws java.rmi.RemoteException;
    public br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap getPortProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid, java.lang.String portName) throws java.rmi.RemoteException;
    public void setPortProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid, java.lang.String portName, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap map) throws java.rmi.RemoteException;
    public br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connect(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID user, java.lang.String usingPortName, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID provider, java.lang.String providingPortName) throws java.rmi.RemoteException;
    public br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID[] getConnectionIDs(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[] componentList) throws java.rmi.RemoteException;
    public br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap getConnectionProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connID) throws java.rmi.RemoteException;
    public void setConnectionProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connID, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap map) throws java.rmi.RemoteException;
    public void disconnect(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connID, float timeout) throws java.rmi.RemoteException;
    public void disconnectAll(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID id1, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID id2, float timeout) throws java.rmi.RemoteException;
}
