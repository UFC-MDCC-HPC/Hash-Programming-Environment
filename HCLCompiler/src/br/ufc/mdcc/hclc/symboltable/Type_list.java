package br.ufc.mdcc.hclc.symboltable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Type_list implements Iterable<Entry<String,Type>>{
	private Map <String, Type> type_list;
	
	public Type_list(){
		type_list = new HashMap <String, Type>();
	}
	
	public Type get(int index){
		return type_list.get(index);
	}
	
	public void add(String form_id, Type type){
		type_list.put(form_id, type);
	}
	
	
	public int size(){
		return type_list.size();
	}

	@Override
	public Iterator<Entry<String,Type>> iterator() {
		
		return type_list.entrySet().iterator();
	}
}
