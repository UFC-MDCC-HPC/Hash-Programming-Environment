package hPE.frontend.base.interfaces;


public interface IActionPrimitiveActivate extends IActionPrimitive {

	public IInterfaceSlice getSliceAbstraction();
	
	public IAction getEncapsulatedAction();
	
}
