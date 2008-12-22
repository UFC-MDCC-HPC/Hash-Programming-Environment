package hPE.frontend.kinds.activate.model.protocol;

import hPE.frontend.base.interfaces.IAction;
import hPE.frontend.base.interfaces.IActionPrimitiveActivate;
import hPE.frontend.base.interfaces.IInterfaceSlice;
import hPE.frontend.base.model.HInterfaceSlice;

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
