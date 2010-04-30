package br.ufc.mdcc.hclc.symboltable;

public class VarType extends Type{
	private String id;
	private int beginLine;
	private int beginColumn;
	
	public VarType(String id, int beginLine, int beginColumn){
		this.id=id;
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
