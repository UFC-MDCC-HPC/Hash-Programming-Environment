using System.Threading;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using System;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic{


public  class LogicActionInstantiate : LogicAction{
	//String command;
	//String compId;
	
		public LogicActionInstantiate(String compId, string handleId){
	//	this.command = command;
		this.compId=compId;
			this.handleId = handleId;
			
		
	}
		public override void start() {
			_thread = new Thread((ThreadStart)delegate() 
			                     {
				try {

						CertifierConsoleLogger.write("Instantiating by thread component " + compId + " whose handle informed is " +handleId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					CertifierConsoleLogger.write("Action by thread was interrupted!" +  e.Message);
					//e.printStackTrace();
				}

			});


			_thread.Start ();
	  
		
	}
		public override void run() {

				try {

				CertifierConsoleLogger.write("Instantiating component " + compId+ " whose handleid informed is "+handleId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					CertifierConsoleLogger.write("Action was interrupted!" +  e.Message);
					//e.printStackTrace();
				}



		}


	}}
