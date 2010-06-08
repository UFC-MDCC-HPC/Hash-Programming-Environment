package br.ufc.mdcc.hclc.symboltable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Usings_list {

	/* cs[<component name>] => <package name> */
	private Map<String, String> cs = new HashMap<String,String>();
	
	private List<String> openPk = new ArrayList<String>();
	
	public String packageOf(String c) {
		if (cs.containsKey(c)) {
			// TODO: CHECK THE LOCATION ...
			return cs.get(c);		
		} else {
			for (String pk : openPk) {
			     // TODO: LOOK AT THE LOCATION IN OPEN PACKAGE pk ...
			}
			return null;
		}
		
	}
	
	public void addComponent(String c, String p) {
		if (c != null) {
		   cs.put(c, p);
		} else {
			openPk.add(p);
		}
	}
	
}
