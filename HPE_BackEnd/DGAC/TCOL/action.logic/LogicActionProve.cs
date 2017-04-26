package hpcshelf.certification.orchestration.action.logic;

import hpcshelf.certification.tactical.adapter.JNICaller;
import hpcshelf.certification.util.CertifierConsoleLogger;
import hpcshelf.certification.web.service.CertifierComponent;



public  class LogicActionProve extends LogicAction{
	String command;

	public LogicActionProve(String command){
		this.command = command;
	}
	@Override
	public void run() {
		// isActive = true;
		/*if (this.isInterrupted())
			return;*/
		String linev[];
		int i=0,k=-1,m=-1;
		boolean hasTrue;
		JNICaller jdo = new JNICaller();

		String array[] = jdo.run(command);


		//synchronized(this){
		while(!array[i].equals("-1")){


			linev  = array[i].split(" ");



			//line1 = bri.readLine();
			hasTrue = linev[1].equals("true");
			//if(hasTrue || hasFalse){
			CertifierConsoleLogger.write("Verification condition: " +  linev[0] + " Status: " + linev[1]);
			synchronized(this){
			if(CertifierComponent.firstRun){
				CertifierComponent.VCs.add(linev[0]);
				m++;
			}else{
				k++;
			}
			}
			if(hasTrue){
				synchronized(this){
				if(CertifierComponent.firstRun){
					// System.out.println("=========================> totalValidVCs: " +  CertifierComponent.totalValidVCs);
					//System.out.println("======> " + tokens[i-1]);
					// System.out.println("======> " + line1);
					if(m==3 || m==4){//teste
						CertifierComponent.totalFailureVCs++;
						CertifierComponent.VCsStatus.add(false);
					}else{
						CertifierComponent.totalValidVCs++;
						CertifierComponent.VCsStatus.add(true);
					}
				}else{
					if(!CertifierComponent.VCsStatus.get(k)){
						CertifierComponent.VCsStatus.set(k,true);
						CertifierComponent.totalFailureVCs--;
						CertifierComponent.totalValidVCs++;
					}
				}
				}
			}else{
				//if(hasFalse){
				synchronized(this){
				if(CertifierComponent.firstRun){
					CertifierComponent.totalFailureVCs++;
					CertifierComponent.VCsStatus.add(false);
				}
				}
			}
			//}

			i++;
		}
		synchronized(this){
		if(CertifierComponent.firstRun){
			CertifierComponent.firstRun =false;
		}
		CertifierComponent.totalVCs = CertifierComponent.totalValidVCs  + 	  CertifierComponent.totalFailureVCs;
		CertifierComponent.provedVCPercent = ((float) CertifierComponent.totalValidVCs / CertifierComponent.totalVCs)*100;
		CertifierComponent.variables.put("provedVCPercent", CertifierComponent.provedVCPercent);
		}
		//}
		CertifierConsoleLogger.write("====> Statistics: Total VCs: " +  CertifierComponent.totalVCs + " Total Valid: " +  
				CertifierComponent.totalValidVCs + " Total Failures: " + CertifierComponent.totalFailureVCs+ " Proved VC percent: " +
				CertifierComponent.provedVCPercent + " Vcs stored size: " + CertifierComponent.VCs.size());
		for( i=0;i<CertifierComponent.VCs.size() ; i++ )  
		{  
			CertifierConsoleLogger.write("====> VC: " + CertifierComponent.VCs.get(i) + " : " + CertifierComponent.VCsStatus.get(i));
		}  



	}
}



