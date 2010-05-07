package br.ufc.mdcc.hclc.symboltable;

public class Public_Component {
	private String left_id;
	private String right_id;
	private int beginLine;
	private int beginColumn;
	
	public Public_Component(String left_id, String right_id, int beginLine, int beginColumn){
		this.right_id=right_id;
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
	
	
}
