package hPE.frontend.base.interfaces;

import java.util.Collection;
import java.util.List;

import hPE.frontend.base.model.HComponent;

public interface IComputationConfiguration extends IConfiguration {

	public Collection getComponents();
		
	public Collection getInterfaces();
	
	public List<HComponent> getInnerComponents();
	
}
