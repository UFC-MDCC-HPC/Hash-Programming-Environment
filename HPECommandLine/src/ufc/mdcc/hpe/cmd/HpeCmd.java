package ufc.mdcc.hpe.cmd;

public class HpeCmd {

	private String value;
	private String name;
	private int id;
	
	public void setValue(String value){
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object o) {
		HpeCmd hpeCmd = (HpeCmd)o;
		if(hpeCmd.getId() == this.id)
			return true;
		return false;
	}
	public void execute(){
		
	}
	
	
}
