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
  
  public java.lang.String getSiteName() throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.getSiteName();
  }
  
  public java.lang.String deployHashComponent(byte[] data, java.lang.String userName, java.lang.String password, java.lang.String curDir, boolean flag_compile) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.deployHashComponent(data, userName, password, curDir, flag_compile);
  }
  
  public java.lang.String deployHashConfiguration(byte[] data, byte[] hcl_data, java.lang.String userName, java.lang.String password, java.lang.String curDir, boolean flag_compile) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.deployHashConfiguration(data, hcl_data, userName, password, curDir, flag_compile);
  }
  
  public byte[] readEnvironment() throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.readEnvironment();
  }
  
  public java.lang.String readCatalog() throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.readCatalog();
  }
  
  public java.lang.String hosts() throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.hosts();
  }
  
  public java.lang.String openSession(java.lang.String session_id) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.openSession(session_id);
  }
  
  public java.lang.String[] getPorts(java.lang.String session_id, java.lang.String instance_id) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.getPorts(session_id, instance_id);
  }
  
  public void closeSession(java.lang.String session_id) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    backEnd_WSSoap.closeSession(session_id);
  }
  
  public java.lang.String[] runApplication(java.lang.String instantiator_string, java.lang.String session) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    return backEnd_WSSoap.runApplication(instantiator_string, session);
  }
  
  public void createApplicationInstance(java.lang.String session_id_string, java.lang.String instance_name, java.lang.String instantiator_string) throws java.rmi.RemoteException{
    if (backEnd_WSSoap == null)
      _initBackEnd_WSSoapProxy();
    backEnd_WSSoap.createApplicationInstance(session_id_string, instance_name, instantiator_string);
  }
  
  
}