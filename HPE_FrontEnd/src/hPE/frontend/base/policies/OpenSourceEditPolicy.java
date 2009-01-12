package hPE.frontend.base.policies;

import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IFileEditorMapping;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.internal.EditorManager;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.registry.EditorDescriptor;
import org.eclipse.ui.part.FileEditorInput;

// import fr.improve.csharp.editor.CSharpEditor;
import hPE.HPEVersionEditor;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.codegen.C.HBESynthesizerForC;
import hPE.frontend.base.dialogs.HBEVersionControlDialog;
import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.model.HInterface;

import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;


public class OpenSourceEditPolicy extends ComponentEditPolicy {

public OpenSourceEditPolicy() {
	super();
}
	
private static final String
	EDIT_SOURCE_REQUEST = "Edit Source";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
//	IHUnit model = (Interface) ((AbstractEditPart) getHost()).getModel();
	
	if (EDIT_SOURCE_REQUEST.equals(request.getType()))
		return new OpenSliceCommand((InterfaceEditPart)this.getHost());
	return 
	    super.getCommand(request);
	
	
	
}

static class OpenSliceCommand 
extends org.eclipse.gef.commands.Command{

private InterfaceEditPart part;

private HInterface i = null;
private HPEVersionEditor editor = null;


public OpenSliceCommand(InterfaceEditPart part){

  this.part = part;
  i = (HInterface) part.getModel();

      
}

public void execute(){

	try {
	
	editor = (HPEVersionEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();

	boolean isSubTyping = i.hasSuperType();
	boolean isImplementing = !i.isAbstractInterface();
	
	boolean onlyEdit = isSubTyping || isImplementing;
	
	HBEVersionControlDialog dialog = new HBEVersionControlDialog(i, onlyEdit);

    dialog.setModal(true);
    dialog.pack();
    dialog.setVisible(true);

	switch	(dialog.getButtonPressed()) {
	case 0: {
 		 HBEAbstractSynthesizer synthesizer = dialog.getSeletectedSourceType();
		 openExistingSourceCodeFile(synthesizer.synthesize(i,dialog.getVersionID()));
	//	 dialog.dispose();
		 break;   
	}
	case 1: {
		HBESourceVersion<HBEAbstractFile> version = dialog.getSelectedSourceVersion();
		
	    if (onlyEdit && (version.isInherit() || version.isImplement())) {
 		     HBEAbstractSynthesizer synthesizer = dialog.getSeletectedSourceType();	    	
 			 openExistingSourceCodeFile(synthesizer.synthesize(i,version.getVersionID()));
	    } else {
	    	openExistingSourceCodeFile(dialog.getSelectedSourceVersion());
	    }
	//	dialog.dispose();
		break;
	}
	case 2: {
		closeSourceCodeFile(dialog.getSelectedSourceVersion());
	//	dialog.dispose();
		break;
	}
		
	}
	
	// dialog.dispose();
	
	} catch (ClassCastException e) {
		System.err.print(e.getMessage());
	}

}


public void undo(){

}

public void redo(){
   execute();
}

public boolean canExecute() {
	if (i.isUnamed()) {
		JOptionPane.showMessageDialog(null, "Unamed Interface !","Edit Source Code Error", JOptionPane.ERROR_MESSAGE);
		return false;
	} else
		return true;
}

public void openExistingSourceCodeFile(HBESourceVersion<HBEAbstractFile> sourceVersion) {
	
	try {

	for (HBEAbstractFile srcFile : sourceVersion.getFiles()) {
			
		 String sPath = (String) srcFile.getPath();
		 IPath path = new Path(sPath);
		
		 srcFile.persistSourceFile();
		
		 String programName = srcFile.getVersionID().concat(":").concat(path.lastSegment());
		
    	 IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    	 FileEditorInput fei = new FileEditorInput(file); 
    	
    	 IWorkbench wb = PlatformUI.getWorkbench();    	
    	 EditorDescriptor er = (EditorDescriptor) wb.getEditorRegistry().getDefaultEditor(sPath);
    	    	
    	
    	 IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    	 EditorManager em = ((WorkbenchPage) page).getEditorManager();
  		 IEditorReference editorRef = em.openEditor(er.getId(),fei,true,null);
    	 IEditorPart te = editorRef.getEditor(true);
    	 IEditorPart te2 = te.getClass().newInstance();
    	 page.closeEditor(te,false);
    	 
		 editor.newPage(te2,fei,programName);
	}
		
	} /*catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} */catch (PartInitException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}

public void closeSourceCodeFile(HBESourceVersion sourceVersion) {
        	
	// ModelType i = (ModelType) getModel();
	
	HPEVersionEditor editor = (HPEVersionEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	
	Iterator<HBEAbstractFile> ss = sourceVersion.getFiles().iterator();
	while (ss.hasNext()) {
		HBEAbstractFile srcFile = (HBEAbstractFile) ss.next();			
		String sPath = (String) srcFile.getPath();
		IPath path = new Path(sPath);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		IFolder folder1 = ResourcesPlugin.getWorkspace().getRoot().getFolder(path.removeLastSegments(1));
		IFolder folder2 = ResourcesPlugin.getWorkspace().getRoot().getFolder(path.removeLastSegments(2));
		  		    		
		editor.removePage(srcFile.getVersionID().concat(":").concat(path.lastSegment()));
		
		try {
		   file.delete(true,getProgressMonitor());
		   if (folder1.members().length == 0) {    		   
		     folder1.delete(false,getProgressMonitor());
		   }
		   if (folder2.members().length == 0) {    		   
  		     folder2.delete(false,getProgressMonitor());
  		   }
		   
		} catch (CoreException e) {
			
        	JOptionPane.showMessageDialog(null,
        		    "Error Deleting File - ".concat(sPath).concat(" - ").concat(e.getMessage()),
        		    "Error",
        		    JOptionPane.ERROR_MESSAGE);
	}   		
		
		
	}
	
	i.cleanSource(sourceVersion);
	
	
}

private IProgressMonitor getProgressMonitor() {
    
	return new org.eclipse.core.runtime.NullProgressMonitor();
}

}





}
