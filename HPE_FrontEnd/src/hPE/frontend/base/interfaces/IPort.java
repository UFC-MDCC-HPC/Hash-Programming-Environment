package hPE.frontend.base.interfaces;


import java.util.Collection;

public interface IPort {
	
	public IInterface getPortType();
	
	public boolean boundTo(IPort port);
	
	public boolean boundToAnyOtherPort(IPort port);
	
	public Collection getBindClosure(); 
	
	public boolean isPrivate();
	
	public String getName();
}
