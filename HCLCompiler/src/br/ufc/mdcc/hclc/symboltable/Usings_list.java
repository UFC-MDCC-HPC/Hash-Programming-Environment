package br.ufc.mdcc.hclc.symboltable;

import java.util.HashMap;
import java.util.Map;

public class Usings_list {

	/* cs[<component name>] => <package name> */
	private Map<String, String> cs = new HashMap<String,String>();
	
	public String packageOf(String c) {
		return cs.get(c);
	}
	
	public void addComponent(String c, String p) {
		cs.put(c, p);
	}
	
}
