package hPE.core.library.model.classes;

import java.util.Iterator;
import java.util.List;

import hPE.xml.component.InterfaceType;

import hPE.core.library.model.interfaces.IHPEComponentLibraryItem;
import hPE.core.library.model.interfaces.ILComponentView;
import hPE.core.library.model.interfaces.ILInterfaceCompositeView;
import hPE.core.library.model.interfaces.ILInterfaceView;
import hPE.core.library.model.interfaces.ILPackage;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IPort;
import hPE.frontend.base.interfaces.IUnit;


public abstract class LInterfaceView extends HPEComponentLibraryItem implements ILInterfaceView{

	private String unitName;

	public LInterfaceView(ILInterfaceCompositeView parentUnit, InterfaceType theInterface) {
		super(parentUnit);	
		unitName = theInterface.getIRef();
		readFrom(theInterface);
	}
		
	public LInterfaceView(ILComponentView parentComponent, InterfaceType theInterface) {
		super(parentComponent);	
		unitName = theInterface.getIRef();
		readFrom(theInterface);
	}
	
	public String getTitle() {
		return getName();
	}
	
	public String getName() {
		return unitName;
	}
		
	
}
