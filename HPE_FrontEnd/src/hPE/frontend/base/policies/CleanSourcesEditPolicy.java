package hPE.frontend.base.policies;

import hPE.HPEVersionEditor;
import hPE.frontend.NAntBuilder;
import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
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


public class CleanSourcesEditPolicy extends ComponentEditPolicy {

public CleanSourcesEditPolicy() {
	super();
}
	
private static final String
	CLEAN_SOURCES_REQUEST = "Clean Sources";  //$NON-NLS-1$

public Command getCommand(Request request) {
	
//	IHUnit model = (Interface) ((AbstractEditPart) getHost()).getModel();
	
	if (CLEAN_SOURCES_REQUEST.equals(request.getType()))
		return new CleanSourcesCommand((InterfaceEditPart)this.getHost());
	return 
	    super.getCommand(request);
	
	
	
}

static class CleanSourcesCommand 
extends org.eclipse.gef.commands.Command{

private InterfaceEditPart part;

private HInterface i = null;

public CleanSourcesCommand(InterfaceEditPart part)
{
  this.part = part;
  i = (HInterface) part.getModel();      
}

public void execute()
{
    i.cleanSources();
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


}





}
