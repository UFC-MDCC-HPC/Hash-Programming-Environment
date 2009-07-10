package hPE.backend;

public class BackEnd_WSSoapProxy implements hPE.backend.BackEnd_WSSoap {
  private String _endpoint = null;
  private hPE.backend.BackEnd_WSSoap backEnd_WSSoap = null;
  
  public BackEnd_WSSoapProxy() {
    _initBackEnd_WSSoapProxy();
  }
  
  public BackEnd_WSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initBackEnd_WSSoapProxy();
  }
  
  private void _initBackEnd_WSSoapProxy() {
    try {
      backEnd_WSSoap = (new hPE.backend.BackEnd_WSLocator()).getBackEnd_WSSoap();
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
  
  public hPE.backend.BackEnd_WSSoap getBackEnd_WSSoap() {
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap;
  }
  
  public byte[] readEnvironment() throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.readEnvironment();
  }
  
  public java.lang.String hosts() throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.hosts();
  }
  
  public java.lang.String deployHashComponent(byte[] data, java.lang.String userName, java.lang.String password_) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.deployHashComponent(data, userName, password_);
  }
  
  public java.lang.String[] runApplication(int id_concrete, java.lang.String[] eIds, int[] eVls, java.lang.String userName, java.lang.String password_) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.runApplication(id_concrete, eIds, eVls, userName, password_);
  }
  
  
}