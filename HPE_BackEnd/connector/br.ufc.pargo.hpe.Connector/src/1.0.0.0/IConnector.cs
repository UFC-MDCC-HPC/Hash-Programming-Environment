using br.ufc.pargo.hpe.kinds;
using br.ufc.pargo.hpe.connector.ports;

namespace br.ufc.pargo.hpe.Connector { 

public interface IConnector : BaseIConnector
{

      IConfigurationPort ConfigurationPort {get;}
      
      //Acho que é desnecessário uma nova porta. A ConfigurationPort pode tratar das reconfigurações.
      //IReconfigurationPort ReconfigurationPort {get;}
      
      IMonitorPort MonitorPort {get;}

      int perform_action(string action);
      int perform_protocol();
      bool get_condition(string condition);


} // end main interface 

} // end namespace 
