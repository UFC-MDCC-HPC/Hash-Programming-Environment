package br.ufc.mdcc.hclc.symboltable;

public class Public_Component {
	private String left_id;
	private String right_id;
	private String owner_id;
	private int beginLine;
	private int beginColumn;
	
	public Public_Component(String left_id, String right_id, String owner_id, int beginLine, int beginColumn){
		this.right_id = right_id;
		this.left_id = left_id;
		this.setOwnerInnerId(owner_id);
		this.beginLine=beginLine;
		this.beginColumn=beginColumn;
	}

	public String getNewId() {
		return right_id;
	}

	public void setNewId(String id) {
		this.right_id = id;
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

	public String setOldId() {
		// TODO Auto-generated method stub
		return left_id;
	}
	
	public String getOldId() {
		// TODO Auto-generated method stub
		return left_id;
	}

	public void setOwnerInnerId(String owner_id) {
		this.owner_id = owner_id;
	}

	public String getOwnerInnerId() {
		return owner_id;
	}
	
	private boolean is_imported_enumerator = false;

	public boolean isImportedEnumerator() {
		return is_imported_enumerator;
	}

	public void setIsImportedEnumerator(boolean is_imported_enumerator) {
		this.is_imported_enumerator = is_imported_enumerator;
	}
	
	
}
