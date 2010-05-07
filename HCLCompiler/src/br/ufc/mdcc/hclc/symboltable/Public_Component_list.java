package br.ufc.mdcc.hclc.symboltable;

import java.util.ArrayList;
import java.util.Iterator;

public class Public_Component_list implements Iterable<Public_Component> {
	private ArrayList <Public_Component> public_component_list;
	
	public Public_Component_list(){
		public_component_list = new ArrayList <Public_Component>();
	}
	
	public Public_Component get(int index){
		return public_component_list.get(index);
	}
	
	public Public_Component getById(String id){
		for(int i=0;i<=public_component_list.size()-1;i++){
			Public_Component public_component=public_component_list.get(i);
			if (public_component.getNewId().equals(id))
				return public_component;
		}
		return null;
	}
	
	public int indexOf(String public_component){
		for(int i=0;i<=public_component_list.size()-1;i++){
			if (public_component_list.get(i).getNewId().equals(public_component))
				return i;
		}
		return -1;
	}
	
	public void add(Public_Component public_component){
		Public_Component publiccomponent;
		if ((publiccomponent=this.getById(public_component.getNewId()))!=null)
			SemanticError.addError("Two public inner components with the same id "+public_component.getNewId()+" in line "+publiccomponent.getBeginLine()+" and colunm "+publiccomponent.getBeginColumn()+" and in line "+public_component.getBeginLine()+" and colunm "+public_component.getBeginColumn());
		else
			public_component_list.add(public_component);
	}
	
	public void set(int index,Public_Component public_component){
		Public_Component publiccomponent;
		if ((publiccomponent=this.getById(public_component.getNewId()))!=null)
			SemanticError.addError("Two public inner components with the same id "+public_component.getNewId()+" in line "+publiccomponent.getBeginLine()+" and colunm "+publiccomponent.getBeginColumn()+" and in line "+public_component.getBeginLine()+" and colunm "+public_component.getBeginColumn());
		else
			public_component_list.set(index, public_component);
	}
	
	public int size(){
		return public_component_list.size();
	}

	@Override
	public Iterator<Public_Component> iterator() {
		
		return public_component_list.iterator();
	}
}
