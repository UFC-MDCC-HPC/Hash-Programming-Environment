package hPE.frontend.HCL.symbol_table;

public class Slice {
	private String id;
	private String idInner;
	private String idUnitInner;
	private String unit;
	private int beginLine;
	private int beginColumn;
	
	public Slice(String id,String idInner, String idUnitInner, String unit,int beginLine, int beginColumn){
		this.id=id;
		this.idInner=idInner;
		this.idUnitInner=idUnitInner;
		this.unit=unit;
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdInner() {
		return idInner;
	}

	public void setIdInner(String idInner) {
		this.idInner = idInner;
	}

	public String getIdUnitInner() {
		return idUnitInner;
	}

	public void setIdUnitInner(String idUnitInner) {
		this.idUnitInner = idUnitInner;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
