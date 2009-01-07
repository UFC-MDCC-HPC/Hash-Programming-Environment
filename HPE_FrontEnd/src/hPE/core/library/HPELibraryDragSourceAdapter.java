package hPE.core.library;



import org.eclipse.emf.common.util.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException; */

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.IPath;


import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ReadOnlyStateChecker;
import org.eclipse.ui.internal.views.navigator.ResourceNavigatorMessages;
import org.eclipse.ui.part.ResourceTransfer;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

import hPE.ComponentFile;
import hPE.core.library.model.interfaces.ILComponentView;
import hPE.core.library.model.interfaces.ILPackage;
import hPE.frontend.base.model.HComponent;
import hPE.xml.factory.HComponentFactoryImpl;

public class HPELibraryDragSourceAdapter extends DragSourceAdapter {

    private static final String CHECK_MOVE_TITLE = "";

    private static final String CHECK_DELETE_MESSAGE = "";
    
    private TransferData lastDataType;
    
    ISelectionProvider selectionProvider;
    
    public HPELibraryDragSourceAdapter(ISelectionProvider provider) {
        selectionProvider = provider;
    }
    
    /*
     * @see DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragStart(DragSourceEvent event) {
        lastDataType = null;
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

    private String tempPath = "temp/";
    
    private java.io.File[] getSelectedComponentResources() {
        
    	List<java.io.File> resources = new ArrayList<java.io.File>();
        java.io.File[] result = new java.io.File[0];

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
                
                // HComponent f = c.saveToTemporaryFile(tempPath);
                java.io.File file = c.getComponent(false);
                resources.add(file);

                /* TODO: Criar arquivo XML temporario para armazenar o objeto serializado......
                 * 
                 * 
                 */
/*                
                ILPackage  p = (ILPackage ) c.getParent();
                ILLocation l = (ILLocation) p.getParent();
                
                if (l instanceof LWorkspaceLocation) {
                	String projectName = ((LWorkspaceLocation) l).getProjectName();
                	IPath path = new Path(projectName.concat(p.getPackagePathRaw()).concat("/").concat(c.getName()).concat(".hpe"));
//                    IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
                	IFile file = new ComponentFile(path, (Workspace)ResourcesPlugin.getWorkspace(),c);
                    
                    resources.add(file);
                } else {
                	break;
                }
  */              
               
                
                                
            }
        }
        result = new java.io.File[resources.size()]; 
        resources.toArray(result);
        return result;
    }
    
    /*
     * @see DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
     */
    public void dragSetData(DragSourceEvent event) {
    	
        java.io.File[] resources = getSelectedComponentResources();
        String[] fnames = new String[resources.length];
        
        int i = 0;
        for (java.io.File f : resources) {
           fnames[i++] = f.getAbsolutePath();
        }
        
        if (resources == null || resources.length == 0)
            return;

        // lastDataType = event.dataType;
        //use local selection transfer if possible
//        if (LocalSelectionTransfer.getInstance()
  //              .isSupportedType(event.dataType)) {
          //  event.data = LocalSelectionTransfer.getInstance().getSelection();
 //           return;
    //    }
        
       event.data = fnames;
    }
    
}
