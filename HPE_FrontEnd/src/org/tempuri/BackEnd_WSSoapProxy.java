package org.tempuri;

public class BackEnd_WSSoapProxy implements org.tempuri.BackEnd_WSSoap {
  private String _endpoint = null;
  private org.tempuri.BackEnd_WSSoap backEnd_WSSoap = null;
  
  public BackEnd_WSSoapProxy() {
    _initBackEnd_WSSoapProxy();
  }
  
  public BackEnd_WSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initBackEnd_WSSoapProxy();
  }
  
  private void _initBackEnd_WSSoapProxy() {
    try {
      backEnd_WSSoap = (new org.tempuri.BackEnd_WSLocator()).getBackEnd_WSSoap();
      if (backEnd_WSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)backEnd_WSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)backEnd_WSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (backEnd_WSSoap != null)
      ((javax.xml.rpc.Stub)backEnd_WSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.BackEnd_WSSoap getBackEnd_WSSoap() {
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap;
  }
  
  public java.lang.String deployAbstractComponent(byte[] data) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.deployAbstractComponent(data);
  }
  
  public java.lang.String deployHashComponent(byte[] data) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.deployHashComponent(data);
  }
  
  public java.lang.String touchBackEnd(java.lang.String message) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.touchBackEnd(message);
  }
  
  
}