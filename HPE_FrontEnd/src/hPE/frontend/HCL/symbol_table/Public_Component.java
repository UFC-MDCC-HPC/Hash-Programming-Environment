package hPE.frontend.HCL.symbol_table;

public class Public_Component {
	private String id;
	private int beginLine;
	private int beginColumn;
	
	public Public_Component(String id, int beginLine, int beginColumn){
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
