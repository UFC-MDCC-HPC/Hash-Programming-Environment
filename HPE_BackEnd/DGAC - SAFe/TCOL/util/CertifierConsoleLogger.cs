using System;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.util{

public class CertifierConsoleLogger {

	public static bool ON = true;
	
	public static void write(String msg){
		if(CertifierConsoleLogger.ON) Console.WriteLine("MSG: "+msg);
	}
}
}