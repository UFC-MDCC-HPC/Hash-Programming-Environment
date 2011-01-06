package hPE.core.library.model.classes;

import hPE.core.library.model.interfaces.IDeltaListener;
import hPE.core.library.model.interfaces.IHPEComponentLibraryItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



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
	
	private List<IHPEComponentLibraryItem> children = new ArrayList<IHPEComponentLibraryItem>();
	
	@SuppressWarnings("unchecked")
	public List<IHPEComponentLibraryItem> getChildren() {
		children = (List<IHPEComponentLibraryItem>) ((ArrayList<IHPEComponentLibraryItem>) children).clone();
		Collections.sort(children, new Comparator<IHPEComponentLibraryItem>() {
			@Override
			public int compare(IHPEComponentLibraryItem o1, IHPEComponentLibraryItem o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
		return children;
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
