package hPE.frontend.kinds.activate.model.protocol;


public class HSkipAction extends HPrimitiveAction {

	public HSkipAction(String label) {
		super(label);
	}

	public HSkipAction(String label, HProtocol protocol) {
		super(label, protocol);
	}

	public HSkipAction(String label, HCombinatorAction action_combinator) {
		super(label, action_combinator);
	}

}
