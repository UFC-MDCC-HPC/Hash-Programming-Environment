package hpcshelf.certification.orchestration.action.logic;

import hpcshelf.certification.util.CertifierConsoleLogger;
import hpcshelf.certification.web.service.CertifierComponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class LogicActionProve3 extends LogicAction{
	String command[] ;

	public LogicActionProve3(String command[]){
		this.command = command;
	}
	@Override
	public void run() {
		// isActive = true;
		/*if (this.isInterrupted())
			return;*/
		String line1, linev[];
		int i,k=-1,m=-1;
		boolean hasTrue,hasFalse;
		ProcessBuilder builder = new ProcessBuilder(command);
		Process p;
		builder.redirectErrorStream(true);
		try {
			p = builder.start();
			p.waitFor();

			BufferedReader bri = new BufferedReader
					(new InputStreamReader(p.getInputStream()));
			BufferedReader bre = new BufferedReader
					(new InputStreamReader(p.getErrorStream()));
			//CertifierConsoleLogger.write("Normal exit:");
			synchronized(this){
				while ((line1 = bri.readLine()) != null) {
					
								linev  = line1.split(" ");
							
								
								
								//line1 = bri.readLine();
								hasTrue = linev[1].equals("true");
								hasFalse = linev[1].equals("false");
						
					if(hasTrue || hasFalse){
						CertifierConsoleLogger.write("Verification condition: " +  linev[0] + "Status: " + linev[1]);
						
						if(CertifierComponent.firstRun){
							CertifierComponent.VCs.add(linev[0]);
							m++;
						}else{
							k++;
						}
						if(hasTrue){
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
						if(hasFalse){
							if(CertifierComponent.firstRun){
								CertifierComponent.totalFailureVCs++;
								CertifierComponent.VCsStatus.add(false);
							}
						}
					}
					

				}
				if(CertifierComponent.firstRun){
					CertifierComponent.firstRun =false;
				}
				CertifierComponent.totalVCs = CertifierComponent.totalValidVCs  + 	  CertifierComponent.totalFailureVCs;
				CertifierComponent.provedVCPercent = ((float) CertifierComponent.totalValidVCs / CertifierComponent.totalVCs)*100;
				CertifierComponent.variables.put("provedVCPercent", CertifierComponent.provedVCPercent);
			}
			CertifierConsoleLogger.write("====> Statistics: Total VCs: " +  CertifierComponent.totalVCs + " Total Valid: " +  
					CertifierComponent.totalValidVCs + " Total Failures: " + CertifierComponent.totalFailureVCs+ " Proved VC percent: " +
					CertifierComponent.provedVCPercent + " Vcs stored size: " + CertifierComponent.VCs.size());
			for( i=0;i<CertifierComponent.VCs.size() ; i++ )  
			{  
				CertifierConsoleLogger.write("====> VC: " + CertifierComponent.VCs.get(i) + " : " + CertifierComponent.VCsStatus.get(i));
			}  
			bri.close();
			bre.close();
			// p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			CertifierConsoleLogger.write("Action prove was interrupted!");
			//e.printStackTrace();
		}



	}
}



