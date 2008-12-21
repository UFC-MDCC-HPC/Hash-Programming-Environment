package hPE.backend.cluster.synthesizer.syntaxtree;

public class HBEParameter extends HBEVariable {

	public HBEParameter(String name, String type) {
		super(name,type);
	}

	private boolean in = true;
	private boolean out = true;
	
	public void setIn(boolean in) {
		this.in = in;		
	}
	
	public void setOut(boolean out) {
		this.out = out;		
	}
	
	public boolean getIn() {
		return this.in;
	}
	
	public boolean getOut() {
		return this.out; 
	}
	
	
}
