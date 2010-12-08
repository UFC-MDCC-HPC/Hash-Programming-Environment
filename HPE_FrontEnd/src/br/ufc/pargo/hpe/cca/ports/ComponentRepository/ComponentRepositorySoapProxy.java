package br.ufc.pargo.hpe.cca.ports.ComponentRepository;

public class ComponentRepositorySoapProxy implements br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap {
  private String _endpoint = null;
  private br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap componentRepositorySoap = null;
  
  public ComponentRepositorySoapProxy() {
    _initComponentRepositorySoapProxy();
  }
  
  public ComponentRepositorySoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initComponentRepositorySoapProxy();
  }
  
  private void _initComponentRepositorySoapProxy() {
    try {
      componentRepositorySoap = (new br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositoryLocator()).getComponentRepositorySoap();
      if (componentRepositorySoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)componentRepositorySoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)componentRepositorySoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (componentRepositorySoap != null)
      ((javax.xml.rpc.Stub)componentRepositorySoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentRepositorySoap getComponentRepositorySoap() {
    if (componentRepositorySoap == null)
      _initComponentRepositorySoapProxy();
    return componentRepositorySoap;
  }
  
  public br.ufc.pargo.hpe.cca.ports.ComponentRepository.ComponentClassDescription[] getAvailableComponentClasses() throws java.rmi.RemoteException{
    if (componentRepositorySoap == null)
      _initComponentRepositorySoapProxy();
    return componentRepositorySoap.getAvailableComponentClasses();
  }
  
  
}