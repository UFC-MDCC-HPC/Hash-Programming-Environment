package hPE.frontend.HCL.symbol_table;

public class Inner_Component {
	private Type type;
	private String access_type;
	private Public_Component_list public_component_list;
	private String kind;
	private String id;
	private int beginLine;
	private int beginColumn;
	
	public Inner_Component(String id,Type type, String access_type, String kind, Public_Component_list public_component_list,int beginLine, int beginColumn){
		this.type=type;
		this.access_type=access_type;
		this.kind=kind;
		this.id=id;
		this.public_component_list=public_component_list;
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public String getAccess_type() {
		return access_type;
	}
	
	public void setAccess_type(String access_type) {
		this.access_type = access_type;
	}
	
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Public_Component_list getPublic_component_list() {
		return public_component_list;
	}

	public void setPublic_component_list(Public_Component_list public_component_list) {
		this.public_component_list = public_component_list;
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
