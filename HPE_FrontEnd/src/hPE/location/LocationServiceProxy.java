package hPE.location;

public class LocationServiceProxy implements hPE.location.LocationService {
  private String _endpoint = null;
  private hPE.location.LocationService locationService = null;
  
  public LocationServiceProxy() {
    _initLocationServiceProxy();
  }
  
  public LocationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initLocationServiceProxy();
  }
  
  private void _initLocationServiceProxy() {
    try {
      locationService = (new hPE.location.LocationServiceServiceLocator()).getLocationService();
      if (locationService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)locationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)locationService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (locationService != null)
      ((javax.xml.rpc.Stub)locationService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public hPE.location.LocationService getLocationService() {
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService;
  }
  
  public java.lang.String getComponent(java.lang.String packageName, java.lang.String componentName) throws java.rmi.RemoteException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.getComponent(packageName, componentName);
  }
  
  public java.lang.String createPackage(java.lang.String packageName) throws java.rmi.RemoteException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.createPackage(packageName);
  }
  
  public java.lang.String removePackage(java.lang.String packageName) throws java.rmi.RemoteException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.removePackage(packageName);
  }
  
  public java.lang.String fetchPackages() throws java.rmi.RemoteException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.fetchPackages();
  }
  
  public java.lang.String registerComponent(java.lang.String packageName, java.lang.String componentName, java.lang.String contents) throws java.rmi.RemoteException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.registerComponent(packageName, componentName, contents);
  }
  
  public java.lang.String unregisterComponent(java.lang.String packageName, java.lang.String componentName) throws java.rmi.RemoteException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.unregisterComponent(packageName, componentName);
  }
  
  public java.lang.String registerInterface(java.lang.String packageName, java.lang.String componentName, hPE.location.xml.InterfaceType interf) throws java.rmi.RemoteException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.registerInterface(packageName, componentName, interf);
  }
  
  public java.lang.String fetchInterface(java.lang.String packageName, java.lang.String componentName, java.lang.String interfName) throws java.rmi.RemoteException{
    if (locationService == null)
      _initLocationServiceProxy();
    return locationService.fetchInterface(packageName, componentName, interfName);
  }
  
  
}