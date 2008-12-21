package hPE.backend.cluster.synthesizer.syntaxtree;

public abstract class HBEVariable {

	public HBEVariable(String name, String type) {
		super();
		this.name = name;
		this.type = type;		
	}

	private String name;
	
	public String getName() {
		return name;
	}
	
	private String type;
	
	
	public String getType() {
		return this.type;
	}

}
