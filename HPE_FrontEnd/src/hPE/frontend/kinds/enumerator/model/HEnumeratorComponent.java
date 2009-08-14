package hPE.frontend.kinds.enumerator.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.base.model.HBaseKindComponent;

import java.util.List;

import org.eclipse.emf.common.util.URI;

public class HEnumeratorComponent extends HBaseKindComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2515274189846041617L;

	public static final String KIND = "Enumerator";

	public HEnumeratorComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
	}

	@Override
	public HUnit createUnit() {
		List<IHUnit> us = this.getUnits();
		if (us.size() == 0) {
	     HUnit new_unit = new HEnumeratorUnit(null, this);
	     return new_unit;
		} else {
			return null;
		}
	     
	}
	
    public boolean accepts(IComponent c) {    	
    	return false;
    }

    public String kindString() {
    	return "Enumerator";
    }    

}
