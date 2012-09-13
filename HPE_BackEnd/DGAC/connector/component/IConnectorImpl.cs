using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using br.ufc.pargo.hpe.connector.ports;
using br.ufc.pargo.hpe.connector.config;

namespace br.ufc.pargo.hpe.ConnectorImpl { 

	public interface IConnector : IActivateKind
{

      IConfigurationPort ConfigurationPort {get;}
      
      //Acho que é desnecessário uma nova porta. A ConfigurationPort pode tratar das reconfigurações.
      //IReconfigurationPort ReconfigurationPort {get;}
      
      IMonitorPort MonitorPort {get;}

      int perform_action(string action);
      int perform_protocol();
      bool get_condition(string condition);


} // end main interface 

public class IConnectorImpl : Activate, IConnector
{

	public IConnectorImpl() 
	{ 
         //TODO eu preciso que as propriedades rank e id_interface de Unit fiquem protected.
         int rank = 0;
         string id_interface = "unica";

         configurationManager = new ConfigurationManager(ref rank, ref id_interface);
	} 
		
	protected IConfigurationManager configurationManager;
	public IConfigurationPort ConfigurationPort {
	 get {return configurationManager;}
	}
	
	//TODO retornar o monitor da ação GO do configuration manager.
	public IMonitorPort MonitorPort {
	 get { return null;}
	}
	
	
	/*
	protected void linkEntities() {
	 if(configurationManager != null && configurationManager.Unit != null && !configurationManager.Unit.IsLinked) {
	    
	    MetaUnit metaUnit = configurationManager.Unit;
	    metaUnit.Entity = this;
	    
	    Queue<KeyValuePair<MetaUnit, ICollection<IUnit>>> unitsToLink = new Queue<KeyValuePair<MetaUnit, ICollection<IUnit>>>();
	    unitsToLink.Enqueue(new KeyValuePair(metaUnit, unit.Slice.));
	    
	    ICollection<IUnit> concreteSlices;
	    KeyValuePair<MetaUnit, ICollection<IUnit>> pair;
	    List<MetaUnit> metaSlices = new List<MetaUnit>();
	    
	    while(unitsToLink.Count > 0) {
	       pair = unitsToLink.Dequeue();
	       metaUnit = pair.Key;
	       concreteSlices = pair.Value;
	       
	       metaSlices.Clear();
	       
	       foreach(MetaSlice ms in metaUnit.Slices) {
	          metaSlices.Add(ms.Unit);
	       }
	       
	       foreach(MetaUnit meta in metaSlices) {
	          foreach(IUnit concrete in concreteSlices) {
	             if(meta.Name.Equals(concrete.CID.getInstanceName())) {
	                meta.Entity = concrete;
	                break;
	             }
	          }
	          
	          if(meta.Entity != null) {
	             if(meta.Slices != null && meta.Slices.Count > 0) {
	                unitsToLink.Enqueue(new KeyValuePair(meta, ((IUnit) meta.Entity).AllSlices()));
	             }
	          } else {
	             throw new Exception("InterpreterUnit.crate_slice: a fatia " + meta.Name + " não foi encontrada na unidade " + metaUnit.Name);
	          }   
	       }
	    }
	    
	    localManager.Unit.GenerateDelegates();
	    
	 } else {
	    throw new Exception("InterpreterUnit.crate_slice: antes da criação das fatias é necessário atribuir uma metaUnit (setMetaUnit)");
	 }         
	} */
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	* This method returns the value of a condition of the unit  *
	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	public bool get_condition(string condition) {
	 bool result = false;
	 
	 return result;
	}
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	* This method executes an action of the unit when called, *
	* whose name is given by the parameter 'action'           *
	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	public int perform_action(string action) {
	 
	 if(configurationManager != null) {
	    if(configurationManager.Unit.Entity == null) {
	       configurationManager.Unit.Entity = this;
	    }
	    
	    configurationManager.Run(action);
	
	    return 0;
	 } else {
	    throw new Exception("Connector.go: antes do início da execução é necessário atribuir uma configuração (setConfiguration)");
	 }
	}
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * * 
	* This method executes the protocol of the unit, possibly making calls *
	* to other actions using 'perform_action(action)'                      *
	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * ** * * * * * */
	public int perform_protocol() {
	 int result = 0;
	 
	 return result;
	}

		public int go() {
			return perform_action("go");
		}
		
}

}
