	using System;
	using System.Diagnostics;
	using br.ufc.pargo.hpe.backend.DGAC;
	using br.ufc.pargo.hpe.basic;
	using br.ufc.pargo.hpe.kinds;
	using br.ufc.pargo.hpe.connector.ports;
	using br.ufc.pargo.hpe.connector.config;
	using br.ufc.pargo.hpe.backend.DGAC.utils;
	using System.IO;
	
	namespace br.ufc.pargo.hpe.ConnectorImpl { 
	
		public interface IConnector : IActivateKind
	{
	
	      IConfigurationPort ConfigurationPort {get;}
	      
	      IMonitorPort MonitorPort {get;}
	
	      int perform_action(string action);
	      
		  int perform_protocol();
	      
		  bool get_condition(string condition);
	
	
	} // end main interface 
	
	public abstract class IConnectorImpl : Activate, IConnector
	{
	
		protected bool ready = false;

		public IConnectorImpl() 
		{ 
	        configurationManager = new ConfigurationManager(this);
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
		public bool get_condition(string condition) 
		{
	 		if (configurationManager.Unit != null && configurationManager.Unit.Conditions [condition] != null) 
			{
	           return configurationManager.Unit.Conditions [condition].Evaluate ();
	        } 
			else 
			{
	           return false;
	        }
		}
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		* This method executes an action of the unit when called, *
		* whose name is given by the parameter 'action'           *
		* * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		public int perform_action(string action) {
		 
			//Debug.WriteLine("UNIT :" + Id_unit);
			//Debug.WriteLine("[IConnectorImpl.perform_action] iniciando action {0} | configNull {1}", action, (configurationManager == null));
		 if(configurationManager != null) {
			
			//Debug.WriteLine("[IConnectorImpl.perform_action] ready:{0}", ready);
			if(!ready) {
				ConfigureComponent();
			}

			//Debug.WriteLine("[IConnectorImpl.perform_action] ConfManager.UnitNull {0}", (configurationManager.Unit == null));
		    if(configurationManager.Unit.Entity == null) {
		       configurationManager.Unit.Entity = this;
		    }
	
			//Debug.WriteLine("[IConnectorImpl.perform_action] run action:{0}", action);
		    configurationManager.Run(action);
		
		    return 0;
		 } else {
		    throw new Exception("Connector.perform_action: antes do início da execução é necessário atribuir uma configuração (setConfiguration)");
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
			
		public new int go()
		{	
			//Debug.WriteLine("[IConnectorImpl.go] iniciando... ready:{0}", ready);
			if(!ready) {
				ConfigureComponent();
			}
			base.go ();
			return 0;
		}
		
		//public new int go()
		protected void ConfigureComponent()
		{
			//Debug.WriteLine("[IConnectorImpl.ConfigureComponent] iniciando...");
			try 
			{				
				string path = Constants.PATH_TEMP_WORKER + this.QualifiedComponentTypeName + ".hcl";
					
				ConfigurationPort.LoadComponent(path);
				
				ready = true;
					
				//base.go ();
				
			}
			catch (Exception e)
			{
				Debug.WriteLine("[IConnectorImpl.ConfigureComponent] Error reading, loading or execution the configuration file. ");
				Debug.WriteLine("EXCEPTION : " + e.Message);
				if (e.InnerException != null) Debug.WriteLine("INNER EXCEPTION" + e.InnerException.Message);
				throw e;
			}
				
			//return 0;	
		}
			
		public override void main ()
		{ 
			//Debug.WriteLine("[IConnectorImpl.main]...");
			int result = perform_action("main");	
		}	
			
	}
	
	}
