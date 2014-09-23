package hPE.core.library;



import hPE.core.library.model.interfaces.ILComponentView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

public class HPELibraryDragSourceAdapter extends DragSourceAdapter {
    
    ISelectionProvider selectionProvider;
    
    public HPELibraryDragSourceAdapter(ISelectionProvider provider) {
        selectionProvider = provider;
    }
    
    /*
     * @see DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragStart(DragSourceEvent event) {
         // Workaround for 1GEUS9V
        DragSource dragSource = (DragSource) event.widget;
        Control control = dragSource.getControl();
        if (control != control.getDisplay().getFocusControl()) {
            event.doit = false;
            return;
        }

        IStructuredSelection selection = (IStructuredSelection) selectionProvider
                .getSelection();
        for (Iterator i = selection.iterator(); i.hasNext();) {
            Object next = i.next();
            if (!(next instanceof ILComponentView)) {
                event.doit = false;
                return;
            }
        }
        if (selection.isEmpty()) {
            event.doit = false;
            return;
        }
        LocalSelectionTransfer.getInstance().setSelection(selection);
        event.doit = true;
    }

    /*
     * @see DragSourceListener#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragFinished(DragSourceEvent event) {
        LocalSelectionTransfer.getInstance().setSelection(null);

        if (event.doit == false)
            return;
        
    }
    
    private Map<URI, java.io.File> getSelectedComponentResources() {
        
    	
    	Map<URI, java.io.File> resources = new HashMap<URI,java.io.File>();

        ISelection selection = selectionProvider.getSelection();
        if (!(selection instanceof IStructuredSelection) || selection.isEmpty()) {
            return null;
        }
        IStructuredSelection structuredSelection = (IStructuredSelection) selection;
        if (structuredSelection == null)
            return null;

        // loop through list and look for matching items
        Iterator itr = structuredSelection.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            if (obj instanceof ILComponentView) {
                ILComponentView c = (ILComponentView) obj;                
                java.io.File file = c.getComponent(false);
                resources.put(c.getLocationSite(), file);                                
            }
        }
        return resources;
    }
    
    /*
     * @see DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragSetData(DragSourceEvent event) {
    	
        Map<URI,java.io.File> resources = getSelectedComponentResources();
        String[] fnames = new String[resources.size()];
        // HComponent[] fnames = new HComponent[resources.length];
        
        int i = 0;
        for (Entry<URI,java.io.File> f : resources.entrySet()) {
        	String uri = f.getKey().toString();
        	String fname = f.getValue().getAbsolutePath();
        	
           // fnames[i++] = uri;
            fnames[i++] = fname;
           
           //URI uri = URI.createFileURI(f.getAbsolutePath()); //
           //fnames[i++] = hPEEditor.getConfiguration(uri);
        }
        
        if (resources == null || resources.size() == 0)
            return;
        
       event.data = fnames;
    }
    
}
