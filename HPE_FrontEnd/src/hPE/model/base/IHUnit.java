package hPE.model.base;



import hPE.frontend.exceptions.HPEAbortException;
import hPE.model.interfaces.IComponentEntry;
import hPE.model.interfaces.IUnit;

import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;

public interface IHUnit extends IHPrimUnit, IUnit,
                                IComponentEntry, 
                                Cloneable {

	public final static String ADD_UNIT_ITEM = "remove_unit";

	/**
	 * Getter of the property <tt>unit_slice_abstractions</tt>
	 * @return  Returns the unit_slice_abstractions.
	 * @uml.property  name="unit_slice_abstractions"
	 */
	public abstract List<HUnitSlice> getSlices();

	public HUnitSlice newSlice(IHUnit the_source, Point where) throws HPEAbortException;
	
    public abstract void addUnitSlice(HUnitSlice unit_slice_abstraction);

	public abstract HInterface createInterface(Point location) throws HPEAbortException;

	public abstract void attachToInterface(HInterface i);

	public abstract void detachFromInterface();

	public abstract boolean matchForAttachment(HInterface i);

	public abstract void removeUnitSlice(HUnitSlice port);

	public abstract void remove();

	public final static String OPEN_SLICE = "open_slice";

	public abstract void lock();

	public abstract void unlock();

	public abstract List getInnerEntries();

	public abstract IUnit fetchCorrespondingUnit();
	
	public void setConfiguration(HComponent c);
	
	public void loadSavedBounds();
	
	public void saveBounds();
	
    public List<HUnitStub> getStubs();
	
	public void addStub(HUnitStub stub);
	
	public void removeStub(HUnitStub stub);
	
	
	public void killMe();
	
	public List<HUnitSlice> getUnitSlices();
	
	public boolean getHidden();
	
	public boolean isInterfaceEditable();
	
	public void setInterfaceEditable(boolean freezeInterface);
	
    public IHUnit getRealUnit();
    	
	public abstract boolean isExposed();

	public abstract Map<HUnitSlice, List<HUnitSlice>> getExposedSlices();

	public abstract HComponent getStubEnc(HUnitStub stub);

	public abstract void setStubEnc(HUnitStub stub, HComponent enc);

	public abstract Map<HPrimUnit, Integer> whatIsThePath(HUnitSlice uslice);



}