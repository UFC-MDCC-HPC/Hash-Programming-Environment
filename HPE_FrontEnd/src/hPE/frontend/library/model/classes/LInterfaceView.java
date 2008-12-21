package hPE.frontend.library.model.classes;

import java.util.Iterator;
import java.util.List;

import hPE.xml.component.InterfaceType;

import hPE.frontend.library.model.interfaces.IHPEComponentLibraryItem;
import hPE.frontend.library.model.interfaces.ILComponentView;
import hPE.frontend.library.model.interfaces.ILInterfaceCompositeView;
import hPE.frontend.library.model.interfaces.ILInterfaceView;
import hPE.frontend.library.model.interfaces.ILPackage;

import hPE.model.interfaces.IConfiguration;
import hPE.model.interfaces.IPort;
import hPE.model.interfaces.IUnit;

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
