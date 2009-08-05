package hPE.frontend.HCL.symbol_table;

import java.util.ArrayList;

public class Inner_Component_list {
	private ArrayList <Inner_Component> inner_component_list;
	
	public Inner_Component_list(){
		inner_component_list = new ArrayList <Inner_Component>();
	}
	
	public Inner_Component get(int index){
		return inner_component_list.get(index);
	}
	
	public Inner_Component getById(String id){
		for(int i=0;i<=inner_component_list.size()-1;i++){
			Inner_Component inner_component=inner_component_list.get(i);
			if (inner_component.getId().equals(id))
				return inner_component;
		}
		return null;
	}
	
	public void add(Inner_Component inner_component){
		Inner_Component innercomponent;
		if ((innercomponent=this.getById(inner_component.getId()))!=null)
			SemanticError.addError("Two inner components with the same id "+inner_component.getId()+" in lines "+innercomponent.getBeginLine()+" and "+inner_component.getBeginLine());
		else
			inner_component_list.add(inner_component);
	}
	
	public void set(int index,Inner_Component inner_component){
		Inner_Component innercomponent;
		if ((innercomponent=this.getById(inner_component.getId()))!=null)
			SemanticError.addError("Two inner components with the same id "+inner_component.getId()+" in lines "+innercomponent.getBeginLine()+" and "+inner_component.getBeginLine());
		else
			inner_component_list.set(index, inner_component);
	}
	
	public int size(){
		return inner_component_list.size();
	}
}
