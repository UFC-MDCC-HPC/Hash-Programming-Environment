package br.ufc.hpecmd.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import br.ufc.hpecmd.exception.ArgException;
import br.ufc.hpecmd.exception.CmdException;
import br.ufc.hpecmd.type.HpeGenericCmd;
import br.ufc.hpecmd.util.FileUtil;
import br.ufc.hpecmd.util.HpePrinter;

public class HpeCmd {
	
	private Properties commands;
	
	
	public HpeCmd() {
		this.commands = FileUtil.getPropertiesFile();
		
	}
	
	private void analyse(String args[]){
		Class<HpeGenericCmd> cmd = null;
		HpeGenericCmd genericCmd = null;
		try {
			String className = findClassName(args[0]);
			cmd =  (Class<HpeGenericCmd>) Class.forName(FileUtil.pkgName+className);
			
			if(cmd!=null){
				genericCmd = (HpeGenericCmd)cmd.newInstance();
				if(args.length >=2){
					List<String> argsDyn = new ArrayList<String>();
					for(int i=1;i<args.length;i++)
						argsDyn.add(args[i]);
					genericCmd.action(argsDyn.toArray(new String[0]));
				}else
					genericCmd.action(null);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CmdException e) {
			HpePrinter.out(this.helpHpeCmd());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArgException e) {
			HpePrinter.out(genericCmd.help());
		}
	}
	
	private String findClassName(String arg) throws CmdException{
		
		String value = this.commands.getProperty(arg);
		if(value == null || value == ""){
			throw new CmdException();
		} 
		return value.trim();
	}
	
	private String helpHpeCmd(){
		StringBuffer buffer = new StringBuffer();
		Enumeration<String> keys = (Enumeration<String>)commands.propertyNames();
		buffer.append("\nUsage: [cmd] [args...] \n\n");
		buffer.append("where cmd are:");
		while(keys.hasMoreElements()){
			buffer.append("\n\t"+keys.nextElement());
		}
		return buffer.toString();
	}
	
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		HpeCmd hpeCmd = new HpeCmd();
		Scanner scanner = new Scanner(System.in);
		String in = "";
		HpePrinter.out("Welcome to HPE command line v.0.1.\n");
		HpePrinter.out(">>");
		in = scanner.nextLine();
		
		while(!in.equals("exit")){
			
			hpeCmd.analyse(in.split(" "));
			HpePrinter.out("\n>> ");
			in = scanner.nextLine();
			
		};
		 
	}
}
