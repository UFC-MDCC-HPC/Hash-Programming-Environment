package hPE.frontend.base.interfaces;

import java.util.Collection;


public interface IProtocol {

	public IAction getAction();
	
	public Collection getSemaphores();
	
	public IInterface getInterface();
	
	
}
