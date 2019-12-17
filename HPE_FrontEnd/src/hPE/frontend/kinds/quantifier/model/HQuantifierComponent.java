package hPE.frontend.kinds.quantifier.model;

import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IPackageLocation;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.base.model.HBaseKindComponent;

import org.eclipse.emf.common.util.URI;

public class HQuantifierComponent extends HBaseKindComponent {

	static final long serialVersionUID = 1668311650924947931L;

	public static final String KIND = "Quantifier";

	public HQuantifierComponent(String name, IPackageLocation location, URI uri) {
		super(name, location, uri);
		// TODO Auto-generated constructor stub
	}

	private String value;
	
	public String getComponentNameForPrinting() {
		return value + (super.getComponentName().endsWith("Up") ? "\u2191" : "\u2193");
	}

	
	@Override
	public HUnit createUnit() {
	     HUnit new_unit = new HQuantifierUnit(null, this);
	     return new_unit;
	}
	
    public boolean accepts(IComponent c) {
    	if (c instanceof HQuantifierComponent) return true;
    	return super.accepts(c);
    }

    public String kindString() {
    	return "Quantifier";
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}    
    
}
