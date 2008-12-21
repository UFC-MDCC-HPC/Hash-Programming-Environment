package hPE.frontend.library.model.classes;

import hPE.frontend.library.model.classes.NullDeltaListener;
import hPE.frontend.library.model.interfaces.IDeltaListener;
import hPE.frontend.library.model.interfaces.IHPEComponentLibraryItem;

import java.util.List;
import java.util.ArrayList;



public abstract class HPEComponentLibraryItem implements IHPEComponentLibraryItem {

	protected IDeltaListener listener = NullDeltaListener.getSoleInstance();
	
	public HPEComponentLibraryItem(IHPEComponentLibraryItem parent) {
		this.parent = parent;
		//readFrom(model);
	}	
	
	public HPEComponentLibraryItem() {
		this.parent = null;
	}	
	
	public abstract String getTitle(); 
	
	private IHPEComponentLibraryItem parent;
	
	public IHPEComponentLibraryItem getParent() {
		return parent;
	}	
	
	private List children = new ArrayList();
	
	public List getChildren() {
		return ((List) ((ArrayList) children).clone());
	}
	
	public void addChild(IHPEComponentLibraryItem child) {
		children.add(child);
	}
	
	public void removeChild(IHPEComponentLibraryItem child) {
		children.remove(child);
	}
	
	public void clearChildren() {
		children.clear();
	}
	
	public boolean isRoot() {
		return parent == null;
	}

	protected abstract void readFrom(Object model);
	
	public void addListener(IDeltaListener listener) {
		this.listener = listener;
	}
	
	public void removeListener(IDeltaListener listener) {
		if(this.listener.equals(listener)) {
			this.listener = NullDeltaListener.getSoleInstance();
		}
	}
	
	
}
