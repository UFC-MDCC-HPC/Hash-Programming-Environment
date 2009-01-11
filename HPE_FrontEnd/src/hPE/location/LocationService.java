/**
 * LocationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public interface LocationService extends java.rmi.Remote {
    public java.lang.String getComponent(java.lang.String packageName, java.lang.String componentName) throws java.rmi.RemoteException;
    public java.lang.String createPackage(java.lang.String packageName) throws java.rmi.RemoteException;
    public java.lang.String removePackage(java.lang.String packageName) throws java.rmi.RemoteException;
    public java.lang.String fetchPackages() throws java.rmi.RemoteException;
    public java.lang.String registerComponent(java.lang.String packageName, java.lang.String componentName, java.lang.String contents) throws java.rmi.RemoteException;
    public java.lang.String unregisterComponent(java.lang.String packageName, java.lang.String componentName) throws java.rmi.RemoteException;
    public java.lang.String registerInterface(java.lang.String packageName, java.lang.String componentName, hPE.location.xml.InterfaceType interf) throws java.rmi.RemoteException;
    public java.lang.String fetchInterface(java.lang.String packageName, java.lang.String componentName, java.lang.String interfName) throws java.rmi.RemoteException;
}
