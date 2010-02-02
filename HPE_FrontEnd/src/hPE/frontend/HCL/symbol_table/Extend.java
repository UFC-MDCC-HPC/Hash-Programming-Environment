package hPE.frontend.HCL.symbol_table;

public class Extend {
	static public final int EXTENDS = 1;
	static public final int IMPLEMENTS = 2;
	private Config config;
	private int beginLine;
	private int beginColumn;
	private int type=0; //1=Extends 2=Implements
	
	
	public Extend(Config config, int beginLine, int beginColumn, int type){
		this.config=config;
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
		this.type=type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
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
