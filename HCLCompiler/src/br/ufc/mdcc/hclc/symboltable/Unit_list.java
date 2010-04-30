package br.ufc.mdcc.hclc.symboltable;

import java.util.ArrayList;

public class Unit_list {
	private ArrayList <Unit> unit_list;
	
	public Unit_list(){
		unit_list = new ArrayList <Unit>();
	}
	
	public Unit get(int index){
		return unit_list.get(index);
	}
	
	public Unit getById(String id){
		for(int i=0;i<=unit_list.size()-1;i++){
			Unit unit=unit_list.get(i);
			if (unit.getId().equals(id))
				return unit;
		}
		return null;
	}
	
	public void add(Unit unitp){
		Unit unit;
		if ((unit=this.getById(unitp.getId()))!=null)
			SemanticError.addError("Two units with the same id "+unit.getId()+" in lines "+unit.getBeginLine()+" and "+unitp.getBeginLine());
		else
			unit_list.add(unitp);
	}
	
	public void set(int index,Unit unitp){
		Unit unit;
		if ((unit=this.getById(unitp.getId()))!=null)
			SemanticError.addError("Two units with the same id "+unit.getId()+" in lines "+unit.getBeginLine()+" and "+unitp.getBeginLine());
		else
			unit_list.set(index, unitp);
	}
	
	public int size(){
		return unit_list.size();
	}
}
