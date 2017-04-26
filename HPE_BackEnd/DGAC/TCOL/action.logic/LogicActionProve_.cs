package hpcshelf.certification.orchestration.action.logic;

import hpcshelf.certification.util.CertifierConsoleLogger;
import hpcshelf.certification.web.service.CertifierComponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class LogicActionProve_ extends LogicAction{
	String command[] ;


	public LogicActionProve_(String command[]){
		this.command = command;
	}
	@Override
	public void run() {
		// isActive = true;
		/*if (this.isInterrupted())
			return;*/
		String line1;
		boolean hasValid, hasFailure, isVC;
		String[] tokens;
		int i,j = 0, k=-1,m=-1;
		
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
					
					hasValid = line1.contains("Valid");
					hasFailure = line1.contains("HighFailure") || line1.contains("Unknown");
					isVC = hasValid || hasFailure;

					if(isVC){

						tokens = line1.split(" ");
						for (i=0; i< tokens.length; i++)
						{
							if (tokens[i].compareTo(":") == 0){

								CertifierConsoleLogger.write("Verification condition: " +  tokens[i-1]);
								if(CertifierComponent.firstRun){

									CertifierComponent.VCs.add(tokens[i-1]);
									m++;

								}else{

									k++;
								}
							}
						}
						if(hasValid){
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

						if(hasFailure){


							if(CertifierComponent.firstRun){
								CertifierComponent.totalFailureVCs++;
								CertifierComponent.VCsStatus.add(false);

							}

						}

					}

					CertifierConsoleLogger.write("N "+ j +": " + line1); 
					j++;


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
			CertifierConsoleLogger.write("Error exit:");
			while ((line1 = bre.readLine()) != null) {

				CertifierConsoleLogger.write("E:" + line1);
			}
			bre.close();
			// p.waitFor();
			CertifierConsoleLogger.write("Process finished.");

			//String[] command = {"/home/allberson/.opam/4.01.0/bin/frama-c", "-jessie", "-jessie-atp=why3ml", "-jessie-why3-opt=\"prove -P z3 -a split_goal_wp\"", "/home/allberson/matrix_op.c" };

			/*ProcessBuilder pb = new ProcessBuilder(command);
				Process process = pb.start();
				final InputStream is = process.getInputStream();
				BufferedReader reader =
		                new BufferedReader(new InputStreamReader(is));
		        String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }*/

			/*// the background thread watches the output from the process
				new Thread(new Runnable() {
				    public void run() {
				        try {
				            BufferedReader reader =
				                new BufferedReader(new InputStreamReader(is));
				            String line;
				            while ((line = reader.readLine()) != null) {
				                System.out.println(line);
				            }
				        } catch (IOException e) {
				            e.printStackTrace();
				        } finally {
				            try {
								is.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        }
				    }
				}).start();*/
			// the outer thread waits for the process to finish
			//p.waitFor();

			/*   while(true)
		  		  System.out.println("Process finished.");*/

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



