package br.ufc.mdcc.hclc.symboltable;

public class Component {
	private String name; 
	private String kind;
	private Public_Component_list public_component_list;
	private Inner_Component_list innercomplist;
	private Unit_list unitlist;
	private ParamType_list paramtypelist;
	private Extend extend;
	private int beginLine;
	private int beginColumn;

	public Component(){
		this.name=null;
		this.kind=null;
		this.public_component_list=null;
		this.innercomplist=null;
		this.paramtypelist=null;
		this.unitlist=null;
		this.beginLine=0;
		this.beginColumn=0;
	}

	public Component(String name, Extend extend,String kind, Public_Component_list public_component_list, Inner_Component_list innercomplist,ParamType_list paramtypelist,Unit_list unitlist, int beginLine, int beginColumn){
		this.name=name;
		this.kind=kind;
		this.public_component_list=public_component_list;
		this.innercomplist=innercomplist;
		this.paramtypelist=paramtypelist;
		this.unitlist=unitlist;
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
		this.extend=extend;
	}

	public ParamType_list getParamtypelist() {
		return paramtypelist;
	}

	public void setParamtypelist(ParamType_list paramtypelist) {
		this.paramtypelist = paramtypelist;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public Public_Component_list getPublic_component_list() {
		return public_component_list;
	}

	public void setPublic_component_list(Public_Component_list public_component_list) {
		this.public_component_list = public_component_list;
	}
	
	public Inner_Component_list getInnercomplist() {
		return innercomplist;
	}
	
	public void setInnercomplist(Inner_Component_list innercomplist) {
		this.innercomplist = innercomplist;
	}
	
	public Unit_list getUnitlist() {
		return unitlist;
	}
	
	public void setUnitlist(Unit_list unitlist) {
		this.unitlist = unitlist;
	}
	
	public Extend getName_extend() {
		return extend;
	}

	public void setName_extend(Extend extend) {
		this.extend = extend;
	}
	
	public int getBeginLine() {
		return beginLine;
	}

	public void setBeginLine(int beginLine) {
		this.beginLine = beginLine;
	}

	public int getBeginColumn() {
		return beginColumn;
	}

	public void setBeginColumn(int beginColumn) {
		this.beginColumn = beginColumn;
	}
}
