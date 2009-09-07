package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.interfaces.IUnit;

import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;

public class HUnitStub extends HPrimUnitStub implements IHUnit {

	static final long serialVersionUID = 1;

	public void killMe() {
		getRealUnit().killMe();
	}
	
    public IHUnit getRealUnit() {
        return (IHUnit) super.getRealUnit();    	
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
		return getRealUnit().getSlices();
	}
	

	public HUnitSlice newSlice(IHUnit the_source, Point where) throws HPEAbortException{
		return getRealUnit().newSlice(the_source,where);
	}
	
	
	
	public void addUnitSlice(HUnitSlice unit_slice_abstraction) {
		getRealUnit().addUnitSlice(unit_slice_abstraction);
		getListeners().firePropertyChange(ADD_UNIT_ITEM,null,unit_slice_abstraction);
	}

	public HHasExternalReferences createInterface(Point location) throws HPEAbortException{
        return getRealUnit().createInterface(location);
	}

	public void removeUnitSlice(HUnitSlice port) {
		getRealUnit().removeUnitSlice(port);

	}



	public void lock() {
		getRealUnit().lock();

	}

	public void unlock() {
		getRealUnit().unlock();

	}

	public List getInnerEntries() {
		return getRealUnit().getInnerEntries();
	}

	public IUnit fetchCorrespondingUnit() {
		return getRealUnit().fetchCorrespondingUnit();
	}

	public void setHidden (boolean hidden) {
		this.getRealUnit().setHidden(hidden);
		getListeners().firePropertyChange(HIDDEN_PROPERTY,null,getBounds());
	}
	
	public boolean getHidden() {
		return false; // this.getRealUnit().getHidden();
	}
	
	public boolean getHiddenBlocked() {
		return this.getRealUnit().getHiddenBlocked();
	}
	
	public void setHiddenBlocked(boolean hiddenBlocked) {
		this.getRealUnit().setHiddenBlocked(hiddenBlocked);
	}
	
	public boolean isInterfaceEditable() {
		return this.getRealUnit().isInterfaceEditable();
	}
	
	public void setInterfaceEditable(boolean freezeInterface) {
		this.getRealUnit().setInterfaceEditable(freezeInterface);
	}
	
	
	public void loadSavedBounds() {
		getRealUnit().loadSavedBounds();
	}
	
	public void saveBounds() {
	    getRealUnit().saveBounds();	
	}
	
	public List<HUnitStub> getStubs() {
	    return getRealUnit().getStubs(); 	
	}
	
	public void addStub(HUnitStub stub) {
		getRealUnit().addStub(stub);
	}
	
    public HComponent getStubEnc(HUnitStub stub) {
    	return getRealUnit().getStubEnc(stub);
    }
    
    public void setStubEnc(HUnitStub stub, HComponent enc) {
    	getRealUnit().setStubEnc(stub,enc);
    }
    
	public void removeStub(HUnitStub stub) {
		getRealUnit().removeStub(stub);
	}

	public List<HUnitSlice> getUnitSlices() {
		return this.getRealUnit().getUnitSlices();
	}
	
	public HReplicator getReplicatorByVarId(String v) {
		return this.getRealUnit().getReplicatorByVarId(v);
	}
	
	public IHPrimUnit getClone(int i) {
		return getRealUnit().getClone(i);
	}

	@Override
	public Map<HUnitSlice, List<HUnitSlice>> getExposedSlices() {
		
		return this.getRealUnit().getExposedSlices();
	}

	@Override
	public boolean isExposed() {
		
		return this.getRealUnit().isExposed();
	}

	@Override
	public void addLinkToReplicator(HLinkToReplicator l) {
		this.getRealUnit().addLinkToReplicator(l);
		
	}

	@Override
	public void removeLinkToReplicator(HLinkToReplicator linkToReplicator) {
		this.getRealUnit().removeLinkToReplicator(linkToReplicator);
		
	}

	@Override
	public Map<HPrimUnit, Integer> whatIsThePath(HUnitSlice uslice) {
		
		return this.getRealUnit().whatIsThePath(uslice);
	}

	@Override
	public List<IHPrimUnit> getMyClones() {
		
		return this.getRealUnit().getMyClones();
	}

	@Override
	public HReplicatorSplit splitBy(HReplicatorSplit cloneBySplit) {
		return this.getRealUnit().splitBy(cloneBySplit);		
	}

	@Override
	public List<HPrimUnit> getTopUnits(Map<HPrimUnit, Integer> path) {
		return this.getRealUnit().getTopUnits(path);
	}

	@Override
	public void removeBinding(HBinding b) {
		this.getRealUnit().removeBinding(b);
		
	}

	@Override
	public void align(HPrimUnit u1) {
       this.getRealUnit().align(u1);
		
	}

	@Override
	public List<IHPrimUnit> getMyClonesSorted() {
		return this.getRealUnit().getMyClonesSorted();
	}

	@Override
	public void setSupersededName(String name2) {
		this.getRealUnit().setSupersededName(name2);
		
	}

	@Override
	public String getSupersededName() {
		// TODO Auto-generated method stub
		return this.getRealUnit().getSupersededName();
	}


}
