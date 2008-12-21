package hPE.frontend.codegen.base.syntaxtree;

public class HBERepeatBlock extends HBECommandBlock {

	public HBERepeatBlock(HBECommandBlock block, HBEConditionBranch conditionBranch) {
		super();
		setBlock(block);
		setConditionBranch(conditionBranch);
	}

	private HBECommandBlock block = null;
	
	public HBECommandBlock getBlock() {
		return block;
	}
	
	protected void setBlock(HBECommandBlock block) {
		this.block = block;
	}
	
	private HBEConditionBranch conditionBranch = null;
	
	public HBEConditionBranch getConditionBranch() {
		return conditionBranch;
	}
	
	protected void setConditionBranch(HBEConditionBranch conditionBranch) {
		this.conditionBranch = conditionBranch;
	}
}
