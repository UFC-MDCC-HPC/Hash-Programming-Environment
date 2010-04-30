package br.ufc.mdcc.hclc.symboltable;

import java.util.ArrayList;

public class ParamType_list {
	private ArrayList <ParamType> paramType_list;
	
	public ParamType_list(){
		paramType_list = new ArrayList <ParamType>();
	}
	
	public ParamType get(int index){
		return paramType_list.get(index);
	}
	
	public ParamType getById(String id){
		for(int i=0;i<=paramType_list.size()-1;i++){
			ParamType paramType=paramType_list.get(i);
			if (paramType.getId().equals(id))
				return paramType;
		}
		return null;
	}
	
	public ParamType getByFormId(String id){
		for(int i=0;i<=paramType_list.size()-1;i++){
			ParamType paramType=paramType_list.get(i);
			if (paramType.getForm_id().equals(id))
				return paramType;
		}
		return null;
	}
	
	public void add(ParamType paramType){
		ParamType param_component;
		if ( ((param_component=this.getById(paramType.getId()))!=null) || ((param_component=this.getByFormId(paramType.getForm_id()))!=null))
			SemanticError.addError("Two parameter type variables with the same id or form id "+param_component.getId()+" in line "+param_component.getBeginLine()+" and colunm "+param_component.getBeginColumn()+" and in line "+paramType.getBeginLine()+" and colunm "+paramType.getBeginColumn());
		else
			paramType_list.add(paramType);
	}
	
	public void set(int index,ParamType paramType){
		ParamType param_component;
		if ( ((param_component=this.getById(paramType.getId()))!=null) || ((param_component=this.getByFormId(paramType.getForm_id()))!=null))
			SemanticError.addError("Two parameter type variables with the same id or form id "+param_component.getId()+" in line "+param_component.getBeginLine()+" and colunm "+param_component.getBeginColumn()+" and in line "+paramType.getBeginLine()+" and colunm "+paramType.getBeginColumn());
		else
			paramType_list.set(index, paramType);
	}
	
	public int size(){
		return paramType_list.size();
	}
}
