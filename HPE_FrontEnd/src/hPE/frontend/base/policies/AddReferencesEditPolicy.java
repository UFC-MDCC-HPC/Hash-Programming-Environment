package hPE.frontend.base.policies;

import hPE.HPEVersionEditor;
import hPE.frontend.NAntBuilder;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.dialogs.AddReferencesDialog;
import hPE.frontend.base.dialogs.HBEVersionControlDialog;
import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.frontend.base.model.HInterface;

import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
import org.eclipse.ui.internal.EditorManager;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.registry.EditorDescriptor;
import org.eclipse.ui.part.FileEditorInput;


public class AddReferencesEditPolicy extends ComponentEditPolicy {

public AddReferencesEditPolicy() {
	super();
}
	
public static final String
	ADD_REFERENCES = "Add References";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
	if (ADD_REFERENCES.equals(request.getType()))
		return new AddReferencesCommand((HHasExternalReferences)this.getHost().getModel());
	return 
	    super.getCommand(request);
		
}

static class AddReferencesCommand 
extends org.eclipse.gef.commands.Command{

private HHasExternalReferences i = null;


public AddReferencesCommand(HHasExternalReferences i){

  this.i = i;

      
}

public void execute(){

  AddReferencesDialog dialog = new AddReferencesDialog(null, i);
  dialog.setAlwaysOnTop(true);
  dialog.setModal(true);
  dialog.setVisible(true);

}


public void undo(){

}

public void redo(){
   execute();
}

public boolean canExecute() {
	
	return true;
}



}





}
