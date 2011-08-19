package hPE.core.library.model.classes;

import hPE.core.library.model.classes.NullDeltaListener;
import hPE.core.library.model.interfaces.IDeltaListener;
import hPE.core.library.model.interfaces.IHPEComponentLibraryItem;

import java.util.List;
import java.util.ArrayList;

public abstract class HPEComponentLibraryItem implements
		IHPEComponentLibraryItem {

	protected IDeltaListener listener = NullDeltaListener.getSoleInstance();

	private IHPEComponentLibraryItem parent;

	private List<IHPEComponentLibraryItem> children = new ArrayList<IHPEComponentLibraryItem>();

	protected String title = "<undefined>";

	/**
	 * construtor
	 */

	public HPEComponentLibraryItem(IHPEComponentLibraryItem parent) {
		this.parent = parent;
		// readFrom(model);
	}

	public HPEComponentLibraryItem() {
		this(null);
	}

	protected abstract void readFrom(Object model);

	public String getTitle() {
		return title;
	}

	public IHPEComponentLibraryItem getParent() {
		return parent;
	}

	@SuppressWarnings("unchecked")
	public List<IHPEComponentLibraryItem> getChildren() {
		return ((List<IHPEComponentLibraryItem>) ((ArrayList<IHPEComponentLibraryItem>) children)
				.clone());
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

	public void addListener(IDeltaListener listener) {
		this.listener = listener;
	}

	public void removeListener(IDeltaListener listener) {
		if (this.listener.equals(listener)) {
			this.listener = NullDeltaListener.getSoleInstance();
		}
	}
}
