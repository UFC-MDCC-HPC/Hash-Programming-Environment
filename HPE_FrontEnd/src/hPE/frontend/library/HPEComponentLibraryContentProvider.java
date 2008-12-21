package hPE.frontend.library;

import java.util.Iterator;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import hPE.frontend.library.model.classes.DeltaEvent;
import hPE.frontend.library.model.classes.HPEComponentLibrary;
import hPE.frontend.library.model.classes.HPEComponentLibraryItem;
import hPE.frontend.library.model.interfaces.IDeltaListener;

public class HPEComponentLibraryContentProvider implements
		ITreeContentProvider, IDeltaListener {
	
	private static Object[] EMPTY_ARRAY = new Object[0];
	protected TreeViewer viewer;
	
	/*
	 * @see IContentProvider#dispose()
	 */
	public void dispose() {}

	/*
	 * @see IContentProvider#inputChanged(Viewer, Object, Object)
	 */
	/**
	* Notifies this content provider that the given viewer's input
	* has been switched to a different element.
	* <p>
	* A typical use for this method is registering the content provider as a listener
	* to changes on the new input (using model-specific means), and deregistering the viewer 
	* from the old input. In response to these change notifications, the content provider
	* propagates the changes to the viewer.
	* </p>
	*
	* @param viewer the viewer
	* @param oldInput the old input element, or <code>null</code> if the viewer
	*   did not previously have an input
	* @param newInput the new input element, or <code>null</code> if the viewer
	*   does not have an input
	*/
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (TreeViewer)viewer;
		if(oldInput != null) {
			removeListenerFrom((HPEComponentLibraryItem)oldInput);
		}
		if(newInput != null) {
			addListenerTo((HPEComponentLibraryItem)newInput);
		}
	}
	
	/** Because the domain model does not have a richer
	 * listener model, recursively remove this listener
	 * from each child box of the given box. */
	protected void removeListenerFrom(HPEComponentLibraryItem box) {
		box.removeListener(this);
		for (Iterator iterator = box.getChildren().iterator(); iterator.hasNext();) {
			HPEComponentLibraryItem aBox = (HPEComponentLibraryItem) iterator.next();
			removeListenerFrom(aBox);
		}
	}
	
	/** Because the domain model does not have a richer
	 * listener model, recursively add this listener
	 * to each child box of the given box. */
	protected void addListenerTo(HPEComponentLibraryItem item) {
		item.addListener(this);
		for (Iterator iterator = item.getChildren().iterator(); iterator.hasNext();) {
			HPEComponentLibraryItem aItem = (HPEComponentLibraryItem) iterator.next();
			addListenerTo(aItem);
		}
	}
	
	
	

	/*
	 * @see ITreeContentProvider#getChildren(Object)
	 */
	public Object[] getChildren(Object parentElement) {
		if(parentElement instanceof HPEComponentLibraryItem) {
			HPEComponentLibraryItem item = (HPEComponentLibraryItem)parentElement;
			return item.getChildren().toArray();
		}
		return EMPTY_ARRAY;
	}
	
	/*
	 * @see ITreeContentProvider#getParent(Object)
	 */
	public Object getParent(Object element) {
		if(element instanceof HPEComponentLibraryItem) {
			return ((HPEComponentLibraryItem)element).getParent();
		}
		return null;
	}

	/*
	 * @see ITreeContentProvider#hasChildren(Object)
	 */
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	/*
	 * @see IStructuredContentProvider#getElements(Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/*
	 * @see IDeltaListener#add(DeltaEvent)
	 */
	public void add(DeltaEvent event) {
		Object movingBox = ((HPEComponentLibraryItem)event.receiver()).getParent();
		viewer.refresh(movingBox, false);
	}

	/*
	 * @see IDeltaListener#remove(DeltaEvent)
	 */
	public void remove(DeltaEvent event) {
		add(event);
	}

}
