package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.interfaces.IUnit;

import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;

public class HUnitStub extends HPrimUnitStub implements IHUnit {

	static final long serialVersionUID = 1;

	public void killMe() {
		getActualUnit().killMe();
	}
	
    public IHUnit getActualUnit() {
        return (IHUnit) super.getActualUnit();    	
    }

	public HUnitStub(IHUnit unit) {
		super(unit);
		unit.addStub(this);
	}
	
	
	public HUnitStub(IHUnit unit, HComponent enc) {
		super(unit);
		unit.addStub(this);
		unit.setStubEnc(this, enc);
	}
	
	public List<HUnitSlice> getSlices() {
		return getActualUnit().getSlices();
	}
	

	public HUnitSlice newSlice(IHUnit the_source, Point where) throws HPEAbortException{
		return getActualUnit().newSlice(the_source,where);
	}
	
	
	
	public void addUnitSlice(HUnitSlice unit_slice_abstraction) {
		getActualUnit().addUnitSlice(unit_slice_abstraction);
		getListeners().firePropertyChange(ADD_UNIT_ITEM,null,unit_slice_abstraction);
	}

	public HHasExternalReferences createInterface(Point location) throws HPEAbortException{
        return getActualUnit().createInterface(location);
	}

	public void removeUnitSlice(HUnitSlice port) {
		getActualUnit().removeUnitSlice(port);

	}



	public void lock() {
		getActualUnit().lock();

	}

	public void unlock() {
		getActualUnit().unlock();

	}

	public List getInnerEntries() {
		return getActualUnit().getInnerEntries();
	}

	public IUnit fetchCorrespondingUnit() {
		return getActualUnit().fetchCorrespondingUnit();
	}

	public void setHidden (boolean hidden) {
		this.getActualUnit().setHidden(hidden);
		getListeners().firePropertyChange(HIDDEN_PROPERTY,null,getBounds());
	}
	
	public boolean getHidden() {
		return false; // this.getRealUnit().getHidden();
	}
	
	public boolean getHiddenBlocked() {
		return this.getActualUnit().getHiddenBlocked();
	}
	
	public void setHiddenBlocked(boolean hiddenBlocked) {
		this.getActualUnit().setHiddenBlocked(hiddenBlocked);
	}
	
	public boolean isInterfaceEditable() {
		return this.getActualUnit().isInterfaceEditable();
	}
	
	public void setInterfaceEditable(boolean freezeInterface) {
		this.getActualUnit().setInterfaceEditable(freezeInterface);
	}
	
	
	public void loadSavedBounds() {
		getActualUnit().loadSavedBounds();
	}
	
	public void saveBounds() {
	    getActualUnit().saveBounds();	
	}
	
	public List<HUnitStub> getStubs() {
	    return getActualUnit().getStubs(); 	
	}
	
	public void addStub(HUnitStub stub) {
		getActualUnit().addStub(stub);
	}
	
    public HComponent getStubEnc(HUnitStub stub) {
    	return getActualUnit().getStubEnc(stub);
    }
    
    public void setStubEnc(HUnitStub stub, HComponent enc) {
    	getActualUnit().setStubEnc(stub,enc);
    }
    
	public void removeStub(HUnitStub stub) {
		getActualUnit().removeStub(stub);
	}

	public List<HUnitSlice> getUnitSlices() {
		return this.getActualUnit().getUnitSlices();
	}
	
	

	@Override
	public Map<HUnitSlice, List<HUnitSlice>> getExposedSlices() {
		
		return this.getActualUnit().getExposedSlices();
	}

	@Override
	public boolean isExposed() {
		
		return this.getActualUnit().isExposed();
	}

	@Override
	public Map<HPrimUnit, Integer> whatIsThePath(HUnitSlice uslice) {
		
		return this.getActualUnit().whatIsThePath(uslice);
	}

	@Override
	public List<HPrimUnit> getTopUnits(Map<HPrimUnit, Integer> path) {
		return this.getActualUnit().getTopUnits(path);
	}

	@Override
	public void removeBinding(HBinding b) {
		this.getActualUnit().removeBinding(b);
		
	}

	@Override
	public void align(HPrimUnit u1) {
       this.getActualUnit().align(u1);
		
	}


	@Override
	public void setSupersededName(String name2) {
		this.getActualUnit().setSupersededName(name2);
		
	}

	@Override
	public String getSupersededName() {
		// TODO Auto-generated method stub
		return this.getActualUnit().getSupersededName();
	}

	@Override
	public boolean isMultiple() {		
		return this.getActualUnit().isMultiple();
	}

	@Override
	public void setMultiple(boolean is_multiple) {
		this.getActualUnit().setMultiple(is_multiple);		
	}




}
