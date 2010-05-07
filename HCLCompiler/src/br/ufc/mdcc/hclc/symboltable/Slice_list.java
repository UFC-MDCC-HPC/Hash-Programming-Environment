package br.ufc.mdcc.hclc.symboltable;

import java.util.ArrayList;
import java.util.Iterator;

public class Slice_list implements Iterable<Slice> {
	private ArrayList <Slice> slice_list;
	
	public Slice_list(){
		slice_list = new ArrayList <Slice>();
	}
	
	public Slice get(int index){
		return slice_list.get(index);
	}
	
	public Slice getById(String id){
		for(int i=0;i<=slice_list.size()-1;i++){
			Slice slice=slice_list.get(i);
			if (slice.getId().equals(id))
				return slice;
		}
		return null;
	}
	
	public void add(Slice slicep){
		Slice slice;
		if ((slice=this.getById(slicep.getId()))!=null)
			SemanticError.addError("Two slices of the unit "+slice.getUnit()+" with the same id "+slice.getId()+" in lines "+slice.getBeginLine()+" and "+slicep.getBeginLine());
		else
			slice_list.add(slicep);
	}
	
	public void set(int index,Slice slicep){
		Slice slice;
		if ((slice=this.getById(slicep.getId()))!=null)
			SemanticError.addError("Two slices of the unit "+slice.getUnit()+" with the same id "+slice.getId()+" in lines "+slice.getBeginLine()+" and "+slicep.getBeginLine());
		else
			slice_list.set(index, slicep);
	}
	
	public int size(){
		return slice_list.size();
	}

	@Override
	public Iterator<Slice> iterator() {
		
		return this.slice_list.iterator();
	}
}
