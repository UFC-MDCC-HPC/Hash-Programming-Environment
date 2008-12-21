package hPE.frontend.library.model.classes;

import hPE.frontend.library.model.interfaces.ILComponentView;
import hPE.frontend.library.model.interfaces.ILInterfaceCompositeView;
import hPE.xml.component.InterfaceType;

public class LInterfaceCompositeView extends LInterfaceView implements
		ILInterfaceCompositeView {
	
	public LInterfaceCompositeView(ILInterfaceCompositeView parentUnit, InterfaceType theInterface) {
		super(parentUnit,theInterface);
	}
	
	public LInterfaceCompositeView(ILComponentView parentComponent, InterfaceType theInterface) {
		super(parentComponent,theInterface);
	}
	
	
	
	public String getTitle() {
		return this.getName();
	}
	


		
	@Override
	protected void readFrom(Object model) {
		// TODO Auto-generated method stub
		
	}

	
	
}
