package br.ufc.pargo.hpe.cca.ports.BuilderService;

public class BuilderServiceSoapProxy implements br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap {
  private String _endpoint = null;
  private br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap builderServiceSoap = null;
  
  public BuilderServiceSoapProxy() {
    _initBuilderServiceSoapProxy();
  }
  
  public BuilderServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initBuilderServiceSoapProxy();
  }
  
  private void _initBuilderServiceSoapProxy() {
    try {
      builderServiceSoap = (new br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceLocator()).getBuilderServiceSoap();
      if (builderServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)builderServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)builderServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (builderServiceSoap != null)
      ((javax.xml.rpc.Stub)builderServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.BuilderServiceSoap getBuilderServiceSoap() {
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap;
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID createInstance(java.lang.String instanceName, java.lang.String className, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap properties) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.createInstance(instanceName, className, properties);
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[] getComponentIDs() throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.getComponentIDs();
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap getComponentProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.getComponentProperties(cid);
  }
  
  public void setComponentProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap map) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    builderServiceSoap.setComponentProperties(cid, map);
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID getDeserialization(java.lang.String s) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.getDeserialization(s);
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID getComponentID(java.lang.String componentInstanceName) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.getComponentID(componentInstanceName);
  }
  
  public void destroyInstance(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID toDie, float timeout) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    builderServiceSoap.destroyInstance(toDie, timeout);
  }
  
  public java.lang.String[] getProvidedPortNames(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.getProvidedPortNames(cid);
  }
  
  public java.lang.String[] getUsedPortNames(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.getUsedPortNames(cid);
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap getPortProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid, java.lang.String portName) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.getPortProperties(cid, portName);
  }
  
  public void setPortProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID cid, java.lang.String portName, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap map) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    builderServiceSoap.setPortProperties(cid, portName, map);
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connect(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID user, java.lang.String usingPortName, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID provider, java.lang.String providingPortName) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.connect(user, usingPortName, provider, providingPortName);
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID[] getConnectionIDs(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID[] componentList) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.getConnectionIDs(componentList);
  }
  
  public br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap getConnectionProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connID) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    return builderServiceSoap.getConnectionProperties(connID);
  }
  
  public void setConnectionProperties(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connID, br.ufc.pargo.hpe.cca.ports.BuilderService.TypeMap map) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    builderServiceSoap.setConnectionProperties(connID, map);
  }
  
  public void disconnect(br.ufc.pargo.hpe.cca.ports.BuilderService.ConnectionID connID, float timeout) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    builderServiceSoap.disconnect(connID, timeout);
  }
  
  public void disconnectAll(br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID id1, br.ufc.pargo.hpe.cca.ports.BuilderService.ComponentID id2, float timeout) throws java.rmi.RemoteException{
    if (builderServiceSoap == null)
      _initBuilderServiceSoapProxy();
    builderServiceSoap.disconnectAll(id1, id2, timeout);
  }
  
  
}