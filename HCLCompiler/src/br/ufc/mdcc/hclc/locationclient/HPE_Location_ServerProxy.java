package br.ufc.mdcc.hclc.locationclient;

public class HPE_Location_ServerProxy implements br.ufc.mdcc.hclc.locationclient.HPE_Location_Server {
  private String _endpoint = null;
  private br.ufc.mdcc.hclc.locationclient.HPE_Location_Server hPE_Location_Server = null;
  
  public HPE_Location_ServerProxy() {
    _initHPE_Location_ServerProxy();
  }
  
  public HPE_Location_ServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initHPE_Location_ServerProxy();
  }
  
  private void _initHPE_Location_ServerProxy() {
    try {
      hPE_Location_Server = (new br.ufc.mdcc.hclc.locationclient.HPE_Location_ServerServiceLocator()).getHPE_Location_Server();
      if (hPE_Location_Server != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hPE_Location_Server)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hPE_Location_Server)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hPE_Location_Server != null)
      ((javax.xml.rpc.Stub)hPE_Location_Server)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufc.mdcc.hclc.locationclient.HPE_Location_Server getHPE_Location_Server() {
    if (hPE_Location_Server == null)
      _initHPE_Location_ServerProxy();
    return hPE_Location_Server;
  }
  
  public java.lang.String getName() throws java.rmi.RemoteException{
    if (hPE_Location_Server == null)
      _initHPE_Location_ServerProxy();
    return hPE_Location_Server.getName();
  }
  
  public java.lang.String unregisterComponent(java.lang.String packageName, java.lang.String component, java.lang.String version) throws java.rmi.RemoteException{
    if (hPE_Location_Server == null)
      _initHPE_Location_ServerProxy();
    return hPE_Location_Server.unregisterComponent(packageName, component, version);
  }
  
  public java.lang.String registerComponent(java.lang.String packageName, java.lang.String component, java.lang.String version, java.lang.String contents, java.util.HashMap binaries) throws java.rmi.RemoteException{
    if (hPE_Location_Server == null)
      _initHPE_Location_ServerProxy();
    return hPE_Location_Server.registerComponent(packageName, component, version, contents, binaries);
  }
  
  public java.lang.String getComponent(java.lang.String packageName, java.lang.String componentName, java.lang.String version) throws java.rmi.RemoteException{
    if (hPE_Location_Server == null)
      _initHPE_Location_ServerProxy();
    return hPE_Location_Server.getComponent(packageName, componentName, version);
  }
  
  public java.lang.String fetchPackages(boolean showObsolete) throws java.rmi.RemoteException{
    if (hPE_Location_Server == null)
      _initHPE_Location_ServerProxy();
    return hPE_Location_Server.fetchPackages(showObsolete);
  }
  
  public java.lang.String getPresentationMessage() throws java.rmi.RemoteException{
    if (hPE_Location_Server == null)
      _initHPE_Location_ServerProxy();
    return hPE_Location_Server.getPresentationMessage();
  }
  
  public java.lang.String markAsObsolete(java.lang.String packageName, java.lang.String componentName, java.lang.String version) throws java.rmi.RemoteException{
    if (hPE_Location_Server == null)
      _initHPE_Location_ServerProxy();
    return hPE_Location_Server.markAsObsolete(packageName, componentName, version);
  }
  
  public byte[] getBinaryFile(java.lang.String packageName, java.lang.String componentName, java.lang.String version, java.lang.String filePath) throws java.rmi.RemoteException{
    if (hPE_Location_Server == null)
      _initHPE_Location_ServerProxy();
    return hPE_Location_Server.getBinaryFile(packageName, componentName, version, filePath);
  }
  
  
}