package hPE.frontend.HCL.symbol_table;

import java.util.ArrayList;

public class Component_list {
	private ArrayList <Component> component_list;
	
	public Component_list(){
		component_list = new ArrayList <Component>();
	}
	
	public Component get(int index){
		return component_list.get(index);
	}
	
	public Component getByName (String name){
		for(int i=0;i<=component_list.size()-1;i++){
			Component component= component_list.get(i);
			if (component.getName().equals(name))
				return component;
		}
		return null;
	}
	
	public void add(Component component){
		if (this.getByName(component.getName())!=null)
			SemanticError.addError("Two or more configurations with the same name "+component.getName());
		else
			component_list.add(component);
	}
	
	public void set(int index,Component component){
		if (this.getByName(component.getName())!=null)
			SemanticError.addError("Two configurations with the same name "+component.getName());
		else
			component_list.set(index, component);
	}
	
	public int size(){
		return component_list.size();
	}
}
