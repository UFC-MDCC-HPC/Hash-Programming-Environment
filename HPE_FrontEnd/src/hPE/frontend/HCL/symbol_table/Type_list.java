package hPE.frontend.HCL.symbol_table;

import java.util.ArrayList;

public class Type_list {
	private ArrayList <Type> type_list;
	
	public Type_list(){
		type_list = new ArrayList <Type>();
	}
	
	public Type get(int index){
		return type_list.get(index);
	}
	
	public void add(Type type){
		type_list.add(type);
	}
	
	public void set(int index,Type type){
		type_list.set(index, type);
	}
	
	public int size(){
		return type_list.size();
	}
}
