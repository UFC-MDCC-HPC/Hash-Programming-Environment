package hPE.frontend.HCL.symbol_table;

public class Import {
	private String component="";
	private int BeginLine;
	private int BeginColumn;

	public Import(String component, int BeginLine, int BeginColumn){
		this.component = component;
		this.BeginLine = BeginLine;
		this.BeginColumn = BeginColumn;
	}
	
	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public int getBeginLine() {
		return BeginLine;
	}

	public void setBeginLine(int beginLine) {
		BeginLine = beginLine;
	}

	public int getBeginColumn() {
		return BeginColumn;
	}

	public void setBeginColumn(int beginColumn) {
		BeginColumn = beginColumn;
	}
	
}
