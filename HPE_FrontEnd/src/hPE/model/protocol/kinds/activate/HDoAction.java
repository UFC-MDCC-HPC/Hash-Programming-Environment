package hPE.model.protocol.kinds.activate;

import hPE.model.base.HInterfaceSlice;
import hPE.model.interfaces.IAction;
import hPE.model.interfaces.IActionPrimitiveActivate;
import hPE.model.interfaces.IInterfaceSlice;

public class HDoAction extends HPrimitiveAction implements IActionPrimitiveActivate {

	static final long serialVersionUID = 1;

	public HDoAction(String label, HInterfaceSlice sliceAbstraction) {
		super(label);
		this.sliceAbstraction = sliceAbstraction;
	}
	
	public HDoAction(String label, HProtocol protocol, HInterfaceSlice sliceAbstraction) {
		super(label, protocol);
		this.sliceAbstraction = sliceAbstraction;
	}

	public HDoAction(String label, HCombinatorAction action_combinator, HInterfaceSlice sliceAbstraction) {
		super(label, action_combinator);
		this.sliceAbstraction = sliceAbstraction;
	}

	HInterfaceSlice sliceAbstraction = null;
	
	public IInterfaceSlice getSliceAbstraction() {
		return sliceAbstraction;
	}

	
	HAction encapsulatedAction;
	
	public void setEncapsulatedAction(HAction action) {
		this.encapsulatedAction = action;
	}
	
	public IAction getEncapsulatedAction() {
		return this.encapsulatedAction;
	}
	
}
