package br.ufc.mdcc.hclc.symboltable;

public class Unit {
	private String id;
	private Slice_list slice_list;
	
	private boolean isPrivate;
	private String iName;
	private String idSuper;
	
	private int beginLine;
	private int beginColumn;
	
	public Unit(String id, Slice_list slice_list/*, Tree action*/,int beginLine, int beginColumn){
		this.id=id;
		this.slice_list=slice_list;
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Slice_list getSlice_list() {
		return slice_list;
	}

	public void setSlice_list(Slice_list slice_list) {
		this.slice_list = slice_list;
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

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setInterfaceId(String iName) {
		this.iName = iName;
	}

	public String getInterfaceId() {
		return iName;
	}

	public void setSuperId(String idSuper) {
		this.idSuper = idSuper;
	}

	public String getSuperId() {
		return idSuper;
	}
}
