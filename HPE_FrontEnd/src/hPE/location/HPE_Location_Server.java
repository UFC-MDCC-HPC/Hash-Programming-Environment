/**
 * HPE_Location_Server.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package hPE.location;

public interface HPE_Location_Server extends java.rmi.Remote {
    public java.lang.String getName() throws java.rmi.RemoteException;
    public java.lang.String getComponent(java.lang.String packageName, java.lang.String componentName, java.lang.String version) throws java.rmi.RemoteException;
    public java.lang.String registerComponent(java.lang.String packageName, java.lang.String component, java.lang.String version, java.lang.String contents, java.util.HashMap binaries) throws java.rmi.RemoteException;
    public java.lang.String fetchPackages(boolean showObsolete) throws java.rmi.RemoteException;
    public java.lang.String getPresentationMessage() throws java.rmi.RemoteException;
    public java.lang.String unregisterComponent(java.lang.String packageName, java.lang.String component, java.lang.String version) throws java.rmi.RemoteException;
    public java.lang.String markAsObsolete(java.lang.String packageName, java.lang.String componentName, java.lang.String version) throws java.rmi.RemoteException;
    public byte[] getBinaryFile(java.lang.String packageName, java.lang.String componentName, java.lang.String version, java.lang.String filePath) throws java.rmi.RemoteException;
}
