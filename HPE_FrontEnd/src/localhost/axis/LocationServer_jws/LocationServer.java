/**
 * LocationServer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package localhost.axis.LocationServer_jws;

public interface LocationServer extends java.rmi.Remote {
    public java.lang.String fetchPackages() throws java.rmi.RemoteException;
    public java.lang.String createPackage(java.lang.String packageName) throws java.rmi.RemoteException;
    public java.lang.String removePackage(java.lang.String packageName) throws java.rmi.RemoteException;
    public int sum(int x, int y) throws java.rmi.RemoteException;
    public java.lang.String getComponent(java.lang.String packageName, java.lang.String componentName) throws java.rmi.RemoteException;
    public java.lang.String registerComponent(java.lang.String packageName, java.lang.String component) throws java.rmi.RemoteException;
    public java.lang.String unregisterComponent(java.lang.String packageName, java.lang.String component) throws java.rmi.RemoteException;
}
