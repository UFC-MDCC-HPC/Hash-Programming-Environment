package hPE.frontend.HCL.symbol_table;

import java.util.ArrayList;

public class Imports_list {
	private ArrayList <Import> uses_list;
	
	public Imports_list(){
		uses_list = new ArrayList <Import>();
	}
	
	public Import get(int index){
		return uses_list.get(index);
	}
	
	public Import getByComponentUsed(String componentUsed){
		for(int i=0;i<=uses_list.size()-1;i++){
			Import imports=uses_list.get(i);
			if (imports.getComponent().equals(componentUsed))
				return imports;
		}
		return null;
	}
	
	public int indexOf(String uses){
		for(int i=0;i<=uses_list.size()-1;i++){
			if (uses_list.get(i).getComponent().equals(uses))
				return i;
		}
		return -1;
	}
	
	public void add(Import imports){
		Import importsc;
		if ((importsc=this.getByComponentUsed(imports.getComponent()))!=null)
			SemanticError.addWarning("Component "+imports.getComponent()+" declared twice in line "+importsc.getBeginLine()+" and colunm "+importsc.getBeginColumn()+" and in line "+imports.getBeginLine()+" and colunm "+imports.getBeginColumn());
		uses_list.add(imports);
	}
	
	public void set(int index,Import imports){
		Import importsc;
		if ((importsc=this.getByComponentUsed(imports.getComponent()))!=null)
			SemanticError.addWarning("Component "+imports.getComponent()+" declared twice in line "+importsc.getBeginLine()+" and colunm "+importsc.getBeginColumn()+" and in line "+imports.getBeginLine()+" and colunm "+imports.getBeginColumn());
		uses_list.set(index, imports);
	}
	
	public int size(){
		return uses_list.size();
	}
}
