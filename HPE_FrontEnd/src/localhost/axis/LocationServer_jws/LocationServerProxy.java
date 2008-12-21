package localhost.axis.LocationServer_jws;

public class LocationServerProxy implements localhost.axis.LocationServer_jws.LocationServer {
  private String _endpoint = null;
  private localhost.axis.LocationServer_jws.LocationServer locationServer = null;
  
  public LocationServerProxy() {
    _initLocationServerProxy();
  }
  
  public LocationServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initLocationServerProxy();
  }
  
  private void _initLocationServerProxy() {
    try {
      locationServer = (new localhost.axis.LocationServer_jws.LocationServerServiceLocator()).getLocationServer();
      if (locationServer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)locationServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)locationServer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (locationServer != null)
      ((javax.xml.rpc.Stub)locationServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.axis.LocationServer_jws.LocationServer getLocationServer() {
    if (locationServer == null)
      _initLocationServerProxy();
    return locationServer;
  }
  
  public java.lang.String fetchPackages() throws java.rmi.RemoteException{
    if (locationServer == null)
      _initLocationServerProxy();
    return locationServer.fetchPackages();
  }
  
  public java.lang.String createPackage(java.lang.String packageName) throws java.rmi.RemoteException{
    if (locationServer == null)
      _initLocationServerProxy();
    return locationServer.createPackage(packageName);
  }
  
  public java.lang.String removePackage(java.lang.String packageName) throws java.rmi.RemoteException{
    if (locationServer == null)
      _initLocationServerProxy();
    return locationServer.removePackage(packageName);
  }
  
  public int sum(int x, int y) throws java.rmi.RemoteException{
    if (locationServer == null)
      _initLocationServerProxy();
    return locationServer.sum(x, y);
  }
  
  public java.lang.String getComponent(java.lang.String packageName, java.lang.String componentName) throws java.rmi.RemoteException{
    if (locationServer == null)
      _initLocationServerProxy();
    return locationServer.getComponent(packageName, componentName);
  }
  
  public java.lang.String registerComponent(java.lang.String packageName, java.lang.String component) throws java.rmi.RemoteException{
    if (locationServer == null)
      _initLocationServerProxy();
    return locationServer.registerComponent(packageName, component);
  }
  
  public java.lang.String unregisterComponent(java.lang.String packageName, java.lang.String component) throws java.rmi.RemoteException{
    if (locationServer == null)
      _initLocationServerProxy();
    return locationServer.unregisterComponent(packageName, component);
  }
  
  
}