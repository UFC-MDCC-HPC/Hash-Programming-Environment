package hPE.frontend.commandline.util;

public class HpePrinter {
	
	public static void out(String msg){
		consolePrinter(msg);
	}

	public static void consolePrinter(String msg){
		System.out.print(msg);
	}
}
