package br.ufc.mdcc.hclc.symboltable;

public class Config extends Type{
	private String id;
	private Type_list type_list;
	private int beginLine;
	private int beginColumn;
	
	public Config(String id, Type_list type_list, int beginLine, int beginColumn){
		this.id=id;
		this.type_list=type_list;
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Type_list getType_list() {
		return type_list;
	}

	public void setType_list(Type_list type_list) {
		this.type_list = type_list;
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
