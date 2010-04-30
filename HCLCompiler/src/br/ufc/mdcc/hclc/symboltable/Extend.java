package br.ufc.mdcc.hclc.symboltable;

public class Extend {
	private Config config;
	private int beginLine;
	private int beginColumn;
	
	public Extend(Config config, int beginLine, int beginColumn){
		this.config=config;
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
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
