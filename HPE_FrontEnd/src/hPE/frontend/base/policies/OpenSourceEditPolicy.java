package hPE.frontend.base.policies;

import hPE.HPEVersionEditor;
import hPE.frontend.NAntBuilder;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.dialogs.HBEVersionControlDialog;
import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.xml.factory.HComponentFactoryImpl;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.registry.EditorDescriptor;
import org.eclipse.ui.part.FileEditorInput;


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
	boolean isImplementing = !i.isAbstract();
	
	boolean onlyEdit = isSubTyping || isImplementing;

	int result = -1;
	HBESourceVersion<HBEAbstractFile> version = null;
	HBEAbstractSynthesizer synthesizer = null;
	
	i.keepVersionConsistency();
	
	if (isImplementing) {
		HBEVersionControlDialog dialog = new HBEVersionControlDialog(i, onlyEdit);
	    dialog.setModal(true);
	    dialog.setVisible(true);
	    result = dialog.getButtonPressed();
	    if (result != -1 && result != HBEVersionControlDialog.BUTTON_EXIT) { 
	    	version = dialog.getSelectedSourceVersion(); 
	        synthesizer = dialog.getSeletectedSourceType();
	    }
	} else {
		Collection<HBESourceVersion<HBEAbstractFile>> vs = i.getSourceVersions();
		if (vs.size()==1) {
			Object[] vsa = vs.toArray();
			version = (HBESourceVersion<HBEAbstractFile>) vsa[0];
			synthesizer = i.getSupportedSynthesizers().get(0);
		} else {
			throw new Exception("Unexpected interface with more than one version (OpenSourceEditPolicy)");
		}
		result = HBEVersionControlDialog.BUTTON_EDIT;
	}
	
	
	if (result == HBEVersionControlDialog.BUTTON_EDIT) {		
	    if (version.getFiles().isEmpty()) {
 			 openExistingSourceCodeFile(synthesizer.synthesize(i,version.getVersionID()));
 			 NAntBuilder builder = NAntBuilder.instance;
 			 builder.setComponent((HComponent) i.getConfiguration());
 			 builder.setMonitor(new NullProgressMonitor());
 			 (new Thread(builder)).start();
 	    } else {
	    	openExistingSourceCodeFile(version);
	    }
	} else {
		
	}
	
	} catch (ClassCastException e) {
		System.err.print(e.getMessage());
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, (String) e.getMessage(), "Unexpected Exception", JOptionPane.ERROR_MESSAGE);		
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

	for (HBEAbstractFile srcFile : sourceVersion.getFiles()) 
	{ 
		srcFile.persistSourceFile();
		if (srcFile.getSrcType().equals("user"))  
		{			
			 String sPath = (String) srcFile.getSourcePath().toString();
			 IPath path = new Path(sPath);
			
			 String programName = srcFile.getVersionID().concat(":").concat(path.lastSegment());
			
			 // Nesso caso particular, � necess�rio acessar pela workspace.
	    	 IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	    	 FileEditorInput fei = new FileEditorInput(file); 
	    	
	    	 IWorkbench wb = PlatformUI.getWorkbench();    	
	    	 EditorDescriptor er = (EditorDescriptor) wb.getEditorRegistry().getDefaultEditor(sPath);
	    	    	
	    	
	    	 IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	    	 //EditorManager em = ((WorkbenchPage) page).getEditorManager();
	    	 
	    	 
	  		 IEditorReference editorRef = ((WorkbenchPage) page).getEditorReferences()[0];// em.openEditor(er.getId(),fei,true,null);
	    	 IEditorPart te = editorRef.getEditor(true);
	    	 IEditorPart te2 = te.getClass().newInstance();
	    	 //page.closeEditor(te,false);
	    	 
			 editor.newPage(te2,fei,programName);
		}
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
	} catch (PartInitException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} */catch (InstantiationException e) {
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
		String sPath = (String) srcFile.getSourcePath().toString();
		IPath path = new Path(sPath);
		// IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		java.io.File file = HComponentFactoryImpl.getFileInWorkspace(path);
		
		//IFolder folder1 = ResourcesPlugin.getWorkspace().getRoot().getFolder(path.removeLastSegments(1));
		//IFolder folder2 = ResourcesPlugin.getWorkspace().getRoot().getFolder(path.removeLastSegments(2));
		java.io.File folder1 = file.getParentFile();
		java.io.File folder2 = folder1.getParentFile();
		  		    		
		editor.removePage(srcFile.getVersionID().concat(":").concat(path.lastSegment()));
		
		try {
		   file.delete();
		   if (folder1.list().length == 0) {    		   
		     folder1.delete();
		   }
		   if (folder2.list().length == 0) {    		   
  		     folder2.delete();
  		   }
		   
		} catch (Exception e) {
			
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
