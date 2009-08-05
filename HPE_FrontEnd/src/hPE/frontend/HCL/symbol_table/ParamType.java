package hPE.frontend.HCL.symbol_table;

public class ParamType {
	private String id;
	private Config config;
	private String form_id;
	private int beginLine;
	private int beginColumn;
	
	public ParamType(String id, String form_id,Config config, int beginLine, int beginColumn){
		this.id=id;
		this.config=config;
		this.form_id=form_id;
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public String getForm_id() {
		return form_id;
	}

	public void setForm_id(String form_id) {
		this.form_id = form_id;
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
