package hPE.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLine {

	public static int SUCESSFULL_COMMAND = 0;	
	
	public static int runCommand(String[] cmd, String[] env, java.io.File file) {
		
		int r = 0;
		
		try 
		{ 
			Process p = Runtime.getRuntime().exec(cmd, env, file); 
			r = p.waitFor(); 
			
			BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
			String line=reader.readLine(); 
			while(line!=null) 
			{ 
				System.out.println(line); 
				line=reader.readLine(); 
			} 

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
