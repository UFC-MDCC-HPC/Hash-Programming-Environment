package hPE;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.frontend.kinds.binding.model.HBindingComponent;
import hPE.frontend.kinds.certifier.model.HCertifierComponent;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.platform.model.HPlatformComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.quantifier.model.HQuantifierComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;
import hPE.frontend.kinds.tactical.model.HTacticalComponent;
import hPE.frontend.kinds.topology.model.HTopologyComponent;
import hPE.xml.factory.HComponentFactory;
import hPE.xml.factory.HComponentFactoryImpl;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedRefInnerException;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedSliceNamesException;
import hPE.xml.factory.HComponentFactoryImpl.UndefinedRefInnerException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.ide.misc.ContainerSelectionGroup;

public class HPEPage extends WizardNewFileCreationPage implements
		SelectionListener {

	private IWorkbench workbench;
	private static int exampleCount = 1;
	
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
	}

	public HPEPage(IWorkbench aWorkbench, IStructuredSelection selection) {
		super("Hash", selection);  //$NON-NLS-1$
		this.setTitle("New Configuration");
		this.setDescription("Creating a new configuration");
		// this.setImageDescriptor(ImageDescriptor.createFromFile(getClass(),"icons/logicbanner.gif"));  //$NON-NLS-1$
		this.workbench = aWorkbench;
		
	}	
	
	private boolean existentialType = false;
	
	private Button check = null;
	private int modelSelected1 = 7;
//	private int modelSelected2 = 1;
	

	private SetVersionDialog composite2 = null;
	
	public void createControl(Composite parent) 
	{
		super.createControl(parent);
		this.setFileName("xxx");  //$NON-NLS-2$//$NON-NLS-1$
		Composite composite1 = (Composite)getControl();
		Control[] cs = composite1.getChildren();
		Control[] cs1 = ((Composite)cs[0]).getChildren();
		//Control[] cs2 = ((Composite)cs[1]).getChildren();
		
		//ContainerSelectionGroup ssss = (ContainerSelectionGroup) cs1[0];
		
	    Control[] cs11 = ((Composite)cs1[1]).getChildren();
	    
	    Label fileLabel = (Label) cs11[0];
	    Text fileName = (Text) cs11[1];
		
	    		
		composite2 = new SetVersionDialog(this, composite1, SWT.NONE);
						
		setPageComplete(validatePage());
		
	    fileName.setVisible(false);
	    fileLabel.setVisible(false);
	}
	
	
	public boolean finish() {

		try {

			IPath containerRelativePath = this.getContainerFullPath();
			IPath containerAbsolutePath = HComponentFactoryImpl.buildWPath(containerRelativePath);
			
			String ss = containerRelativePath.toString();
			
			if (!ss.contains(".")) {
				JOptionPane.showMessageDialog(null, "Unrecognized component package. Use <package>.<name>", "Creation Error", JOptionPane.ERROR_MESSAGE);
					throw new Exception("Unrecognized component name.");
			}
			
			String packageName = ss.substring(1,ss.lastIndexOf('.'));
			String s = ss.substring(ss.lastIndexOf('.') + 1); 
	
			this.setFileName(s + ".hpe");
						
			// String absolutePath = this.getContainerFullPath().append(s + ".hpe").toPortableString();
			String absolutePathString = containerAbsolutePath.append(s + ".hpe").toString();
			String relativePathString = containerRelativePath.append(s + ".hpe").toString();
					
			URI uriAbsolutePath = URI.createFileURI(absolutePathString);
			
			HComponent c = null;
			switch (modelSelected1) {
			case 1: c = new HDataComponent(s,null,uriAbsolutePath); break;
			case 2: c = new HComputationComponent(s,null,uriAbsolutePath); break;
			case 3: c = new HSynchronizationComponent(s,null,uriAbsolutePath); break;
			case 4: c = new HPlatformComponent(s,null,uriAbsolutePath); break;
			case 5: c = new HEnvironmentComponent(s,null,uriAbsolutePath); break;
			case 6: c = new HQualifierComponent(s,null,uriAbsolutePath); break;
			case 7: c = new HApplicationComponent(s,null,uriAbsolutePath); break;
		    case 8: c = new HQuantifierComponent(s,null,uriAbsolutePath); break;
			case 10: c = new HCertifierComponent(s,null,uriAbsolutePath); break;
			case 11: c = new HBindingComponent(s,null,uriAbsolutePath); break;
			case 12: c = new HTacticalComponent(s,null,uriAbsolutePath); break;
			}
			
			setComponentVersion(c);
			c.setAbstract(composite2.isAbstract());
			
			IPath absolutePath = new Path(absolutePathString); 
			IPath relativePath = new Path(relativePathString); 
			c.setPackagePath(new Path(packageName));
			
			try {
				c.createComponentKey();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			IFile file = persistSourceFile("", relativePath);
			
			java.io.File file2 = HComponentFactoryImpl.getFileInWorkspace(absolutePath);
			
			try {
				factory.saveComponent(c,file2,null);
			} catch (UndefinedRefInnerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DuplicatedRefInnerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DuplicatedSliceNamesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
			try {
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// IFile newFile = createNewFile();
			//if (newFile == null) 
			//	return false;  // ie.- creation was unsuccessful
	
			// Since the file resource was created fine, open it for editing
			// iff requested by the user
			try {
				IWorkbenchWindow dwindow = workbench.getActiveWorkbenchWindow();
				IWorkbenchPage page = dwindow.getActivePage();
				if (page != null) IDE.openEditor(page, file, true);
				
			} 
			catch (org.eclipse.ui.PartInitException e) {
				e.printStackTrace();
				return false;
			}
			exampleCount++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}	

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		
		if( e.getSource() == check ){
			existentialType = ! existentialType;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioDataStructure() ){
			modelSelected1 = 1;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioComputation() ){
			modelSelected1 = 2;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioSynchronizer() ){
			modelSelected1 = 3;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioArchitecture() ){
			modelSelected1 = 4;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioEnvironment() ){
			modelSelected1 = 5;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioQualifier() ){
			modelSelected1 = 6;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioApplication() ){
			modelSelected1 = 7;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioQuantifier() ){
			modelSelected1 = 8;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioCertifier() ){
			modelSelected1 = 10;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioBinding() ){
			modelSelected1 = 11;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == composite2.getRadioTactical() ){
			modelSelected1 = 12;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		}
		
		Object source = e.getSource();
		if (source instanceof Button) {
			Button button = (Button) source;
		    composite2.getRadioButtonConcrete().setEnabled(!button.getText().equals(HQualifierComponent.KIND));
		}
		
	}	
	
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	protected InputStream getInitialContents() {

		ByteArrayInputStream bais = null;
		
		return bais ;
		
	}

	

	private void setComponentVersion(HComponent c) {
		Integer[] version = new Integer[4];
		for (int i=0; i<=3;i++)
		    version[i] = composite2.getVersionField(i);
		c.newVersion(version);
	}

	private HComponentFactory factory = HComponentFactory.eInstance;	
	
	public IFile persistSourceFile(String programText, IPath path) {
		
		 IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		// java.io.File file = HComponentFactoryImpl.getFileInWorkspace(path);
		
			    							
		try {				
			createFile(file,null,null);				
		} catch (CoreException e) {
	    	JOptionPane.showMessageDialog(null,
	    		    "Error Creating File - ".concat(e.getMessage()),
	    		    "Error",
	    		    JOptionPane.ERROR_MESSAGE);
		}
	
		return file;
	}
	
	/**
	* Creates a file resource given the file handle and contents.
	*
	* @param fileHandle the file handle to create a file resource with
	* @param contents the initial contents of the new file resource, or
	*   <code>null</code> if none (equivalent to an empty stream)
	* @param monitor the progress monitor to show visual progress with
	* @exception CoreException if the operation fails
	* @exception OperationCanceledException if the operation is canceled
	*/
	protected void createFile(IFile fileHandle, InputStream contents,
	    IProgressMonitor monitor) throws CoreException {
	if (contents == null)
	    contents = new ByteArrayInputStream(new byte[0]);
	
	try {
	        IPath path = fileHandle.getFullPath();
	        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
	        int numSegments= path.segmentCount();
	        if (numSegments > 2 && !root.getFolder(path.removeLastSegments(1)).exists()) {
	            // If the direct parent of the path doesn't exist, try to create the
	            // necessary directories.
	            for (int i= numSegments - 2; i > 0; i--) {
	                IFolder folder = root.getFolder(path.removeLastSegments(i));
	                if (!folder.exists()) {
	                    folder.create(false, true, monitor);
	                }
	            }
	        }
	        fileHandle.create(contents, true, monitor);
	    
	} catch (CoreException e) {
	    // If the file already existed locally, just refresh to get contents
	    if (e.getStatus().getCode() == IResourceStatus.PATH_OCCUPIED)
	        fileHandle.refreshLocal(IResource.DEPTH_ZERO, null);
	    else {
	        throw e;
	    }
	}
	
	}	

}