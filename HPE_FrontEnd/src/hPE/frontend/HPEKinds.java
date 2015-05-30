package hPE.frontend;

import java.util.HashMap;
import java.util.Map;

public class HPEKinds {

	
	public static String[] kindsStr = {"application", "computation", "synchronizer", "data structure", "environment", "architecture", "qualifier", "enumerator"};

	private static Map<String, Integer> k1 = null;
	private static Map<Integer, String> k2 = null;
	
	public static int kind(String kind) {
		if (k1 == null) {
		    k1 = new HashMap<String, Integer>();
		    k1.put("Application",0);
		    k1.put("Computation",1);
		    k1.put("Synchronizer",2);
		    k1.put("Data",3);
		    k1.put("Environment",4);
		    k1.put("Architecture",5);
		    k1.put("Qualifier",6);
		    k1.put("Enumerator",7);
		    k1.put("Binding",8);
		} 
				
		return k1.get(kind);
	}
	
	public static String kind(int kind) {
		if (k2 == null) {
		    k2 = new HashMap<Integer,String>();
		    k2.put(0,"Application");
		    k2.put(1,"Computation");
		    k2.put(2,"Synchronizer");
		    k2.put(3,"Data");
		    k2.put(4,"Environment");
		    k2.put(5,"Architecture");
		    k2.put(6,"Qualifier");
		    k2.put(7,"Enumerator");
		    k2.put(8,"Binding");
		} 
				
		return k2.get(kind);
	}
}
