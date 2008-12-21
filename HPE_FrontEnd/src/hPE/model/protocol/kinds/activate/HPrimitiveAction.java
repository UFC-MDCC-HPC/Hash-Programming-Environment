package hPE.model.protocol.kinds.activate;

import java.io.Serializable;

import hPE.model.interfaces.IActionPrimitive;

public abstract class HPrimitiveAction extends hPE.model.protocol.kinds.activate.HAction  implements Serializable, IActionPrimitive {

	static final long serialVersionUID = 1;

	/**
	 */
	public HPrimitiveAction(String label) {
		super(label);
	}

	public HPrimitiveAction(String label, HProtocol protocol) {
		super(label, protocol);
	}

	
	public HPrimitiveAction(String label, HCombinatorAction action_combinator) {
		super(label, action_combinator);
	}

}
