package hPE.backend.cluster.synthesizer.syntaxtree;

import java.util.List;
import java.util.ArrayList;

public class HBECompoundBlock extends HBECommandBlock {

	public HBECompoundBlock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private List<HBECommandBlock> blocks = new ArrayList<HBECommandBlock>(); 

	public List<HBECommandBlock> getBlocks() {
		return blocks;
	}
	
	public void addBlock(HBECommandBlock block) {
		this.blocks.add(block);
	}
	
}
