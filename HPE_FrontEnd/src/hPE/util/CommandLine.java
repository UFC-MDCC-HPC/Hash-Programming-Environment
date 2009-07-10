package hPE.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLine {

	public static void runCommand(String[] cmd, String[] env, java.io.File file) {
		
		try 
		{ 
			Process p = Runtime.getRuntime().exec(cmd, env, file); 
			int r = p.waitFor(); 
			
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
		} 
		catch(InterruptedException e2) {
			e2.printStackTrace();
		} 	
	}

}
