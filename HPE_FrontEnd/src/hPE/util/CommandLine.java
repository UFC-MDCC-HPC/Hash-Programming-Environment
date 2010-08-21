package hPE.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class CommandLine {

	public static int SUCESSFULL_COMMAND = 0;	
	
	private static class Exec extends Thread  {
		  InputStream is;
		  String type;
		  OutputStream os;

		  Exec(InputStream is, String type) {
		    this(is, type, null);
		  }

		  Exec(InputStream is, String type, OutputStream redirect) {
		    this.is = is;
		    this.type = type;
		    this.os = redirect;
		  }

		  public void run() {
		    try {
		      PrintWriter pw = null;
		      if (os != null) {
		        pw = new PrintWriter(os);
		      }  
		     
		      InputStreamReader isr = new InputStreamReader(is);
		      BufferedReader br = new BufferedReader(isr);

		      String line = null; 
		      while ((line = br.readLine()) != null) {
		        if (pw != null) {
		          pw.println(line);
		          pw.flush();
		        }
		 
		        System.out.println(type + ">" + line);
		      }
		 
		      if (pw != null) {
		        pw.flush();
		      }
		    } catch (IOException ioe) { /* Forward to handler */ }
		  }
		}
	
	public static int runCommand(String[] cmd, java.io.File file) {
		
		int r = 0;
		
		try 
		{
			  FileOutputStream fos = new FileOutputStream("h:\\output.txt");
		      Runtime rt = Runtime.getRuntime();
		      Process proc = rt.exec(cmd, null, file);

		      // Any error message?
		      Exec errorGobbler = new Exec(proc.getErrorStream(), "ERROR");
			
		      // Any output?
		      Exec outputGobbler = new Exec(proc.getInputStream(), "OUTPUT", fos);
			
		      errorGobbler.start();
		      outputGobbler.start();
			
		      // Any error?
		      int exitVal = proc.waitFor();
		      errorGobbler.join();     // Handle condition where the
		      outputGobbler.join();    // process ends before the threads finish 

		      fos.flush();
		      fos.close();			
			
		/*
		  	Process p = Runtime.getRuntime().exec(cmd, null, file); 
		 
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
			String line= null; // reader.readLine(); 

		    
			r = p.waitFor(); 
			
			while(line!=null) 
			{ 
				System.out.println(line); 
				line=reader.readLine(); 
			} */ 

		} 
		catch(IOException e1) {
			e1.printStackTrace();
			r = -1;
		} 
		catch(InterruptedException e2) {
			e2.printStackTrace();
			r = -2;
		}
		
		return r;
		
	}

}
