package hPE.frontend.HCL.symbol_table;

import java.util.ArrayList;

public class Public_Component_list {
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
			if (public_component.getId().equals(id))
				return public_component;
		}
		return null;
	}
	
	public int indexOf(String public_component){
		for(int i=0;i<=public_component_list.size()-1;i++){
			if (public_component_list.get(i).getId().equals(public_component))
				return i;
		}
		return -1;
	}
	
	public void add(Public_Component public_component){
		Public_Component publiccomponent;
		if ((publiccomponent=this.getById(public_component.getId()))!=null)
			SemanticError.addError("Two public inner components with the same id "+public_component.getId()+" in line "+publiccomponent.getBeginLine()+" and colunm "+publiccomponent.getBeginColumn()+" and in line "+public_component.getBeginLine()+" and colunm "+public_component.getBeginColumn());
		else
			public_component_list.add(public_component);
	}
	
	public void set(int index,Public_Component public_component){
		Public_Component publiccomponent;
		if ((publiccomponent=this.getById(public_component.getId()))!=null)
			SemanticError.addError("Two public inner components with the same id "+public_component.getId()+" in line "+publiccomponent.getBeginLine()+" and colunm "+publiccomponent.getBeginColumn()+" and in line "+public_component.getBeginLine()+" and colunm "+public_component.getBeginColumn());
		else
			public_component_list.set(index, public_component);
	}
	
	public int size(){
		return public_component_list.size();
	}
}
