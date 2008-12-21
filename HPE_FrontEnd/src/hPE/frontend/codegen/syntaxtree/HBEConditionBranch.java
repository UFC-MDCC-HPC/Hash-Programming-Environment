package hPE.frontend.codegen.syntaxtree;

public class HBEConditionBranch {

	public HBEConditionBranch(HBECommandBlock block) {
		super();
		this.setBlock(block);
	}

	private HBECommandBlock block = null;
	
	public HBECommandBlock getBlock() {
		return block;
	}
	
	protected void setBlock(HBECommandBlock block) {
		this.block = block;
	}
	

	
}
