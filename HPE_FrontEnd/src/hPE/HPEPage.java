package hPE;

import hPE.model.base.HComponent;
import hPE.model.factory.base.HComponentFactory;
import hPE.model.kinds.activate.computation.HComputationComponent;
import hPE.model.kinds.activate.computation.application.HApplicationComponent;
import hPE.model.kinds.activate.synchronization.HSynchronizationComponent;
import hPE.model.kinds.data.HDataComponent;
import hPE.model.kinds.qualifier.HQualifierComponent;
import hPE.model.kinds.qualifier.architecture.HArchitectureComponent;
import hPE.model.kinds.qualifier.environment.HEnvironmentComponent;

import java.io.ByteArrayInputStream;
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
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;

public class HPEPage extends WizardNewFileCreationPage implements
		SelectionListener {

	private IWorkbench workbench;
	private static int exampleCount = 1;
	
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
	}

	public HPEPage(IWorkbench aWorkbench, IStructuredSelection selection) {
		super("Hash", selection);  //$NON-NLS-1$
		this.setTitle("Title");
		this.setDescription("Description");
		// this.setImageDescriptor(ImageDescriptor.createFromFile(getClass(),"icons/logicbanner.gif"));  //$NON-NLS-1$
		this.workbench = aWorkbench;
		
	}	
	
	private boolean existentialType = false;
	
	private Button check = null;
	private Button model1 = null;
	private Button model2 = null;
	private Button model3= null;
	private Button model4 = null; 
	private Button model5= null;
	private Button model6 = null; 
	private Button model7 = null; 
    private Button model8 = null; 
	private int modelSelected1 = 1;
//	private int modelSelected2 = 1;
	
	public void createControl(Composite parent) {
		super.createControl(parent);
		this.setFileName("empty" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		Composite composite1 = (Composite)getControl();
		
		
		// sample section generation group
		Group group1 = new Group(composite1,SWT.NONE);
		group1.setLayout(new GridLayout());
		group1.setText("Kind of Component"); 
		group1.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		// sample section generation group
	//	Group group2 = new Group(composite1,SWT.NONE);
	//	group2.setLayout(new GridLayout());
	//	group2.setText("Existential Type"); 
	//	group2.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		
		// sample section generation checkboxes

	//	check = new Button(group2,SWT.CHECK);
	//	check.setText("Existential");
	//	check.addSelectionListener(this);
		
		// sample section generation checkboxes
		model1 = new Button(group1,SWT.RADIO);
		model1.setText("Data");
		model1.addSelectionListener(this);
		model1.setSelection(true);

		model2 = new Button(group1,SWT.RADIO);
		model2.setText("Computation");
		model2.addSelectionListener(this);

		model3 = new Button(group1,SWT.RADIO);
		model3.setText("Synchronizer");
		model3.addSelectionListener(this);

		model4 = new Button(group1,SWT.RADIO);
		model4.setText("Architecture");
		model4.addSelectionListener(this);

		model5 = new Button(group1,SWT.RADIO);
		model5.setText("Environment");
		model5.addSelectionListener(this);

		model6 = new Button(group1,SWT.RADIO);
		model6.setText("Qualifier");
		model6.addSelectionListener(this);

		model7 = new Button(group1,SWT.RADIO);
		model7.setText("Application");
		model7.addSelectionListener(this);
		
	//	model8 = new Button(group1,SWT.RADIO);
	//	model8.setText("Grouping");
	//	model8.addSelectionListener(this);
		
		new Label(composite1,SWT.NONE);

		setPageComplete(validatePage());
		
	}
	
	
	public boolean finish() {
		IFile newFile = createNewFile();
		if (newFile == null) 
			return false;  // ie.- creation was unsuccessful

		// Since the file resource was created fine, open it for editing
		// iff requested by the user
		try {
			IWorkbenchWindow dwindow = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = dwindow.getActivePage();
			if (page != null) IDE.openEditor(page, newFile, true);
			
		} 
		catch (org.eclipse.ui.PartInitException e) {
			e.printStackTrace();
			return false;
		}
		exampleCount++;
		return true;
	}	

	/**
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		
		if( e.getSource() == check ){
			existentialType = ! existentialType;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == model1 ){
			modelSelected1 = 1;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == model2 ){
			modelSelected1 = 2;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == model3 ){
			modelSelected1 = 3;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == model4 ){
			modelSelected1 = 4;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == model5 ){
			modelSelected1 = 5;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == model6 ){
			modelSelected1 = 6;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == model7 ){
			modelSelected1 = 7;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		} if( e.getSource() == model8 ){
			modelSelected1 = 8;
			// setFileName("Unamed" + exampleCount + ".hpe");  //$NON-NLS-2$//$NON-NLS-1$
		}
	}	
	
	public void widgetDefaultSelected(SelectionEvent e) {
	}

	protected InputStream getInitialContents() {
		
		String s = this.getFileName();
		String separator = ".";
		s = s.substring(0,s.lastIndexOf(separator));
		
		String absolutePath = this.getContainerFullPath().append(this.getFileName()).toPortableString();
		
		String absolutePath2 = absolutePath.substring(0,absolutePath.lastIndexOf(".")) + ".xml";
		
		URI uri = URI.createFileURI(absolutePath2);
		
		HComponent c = null;
		if (modelSelected1 == 1) {
	       c = new HDataComponent(s,null,uri);	       
		} else if (modelSelected1 == 2) {
		   c = new HComputationComponent(s,null,uri);		   
		} else if (modelSelected1 == 3) {
			   c = new HSynchronizationComponent(s,null,uri);		   
		} else if (modelSelected1 == 4) {
			   c = new HArchitectureComponent(s,null,uri);		   
		} else if (modelSelected1 == 5) {
			   c = new HEnvironmentComponent(s,null,uri);		   
		} else if (modelSelected1 == 6) {
			   c = new HQualifierComponent(s,null,uri);		   
		} else if (modelSelected1 == 7) {
			   c = new HApplicationComponent(s,null,uri);		   
		} else {
			// ERROR;
		}
		
		c.setLocation(absolutePath);
		
		IPath path = new Path(absolutePath);
		c.setPackagePath(path.uptoSegment(1).makeRelative());
		
		IFile file = persistSourceFile("", path);
		
		factory.saveComponent(c,file,null);
		
		ByteArrayInputStream bais = null;
//		try {
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			ObjectOutputStream oos = new ObjectOutputStream(baos);
//			oos.writeObject(c);
//			oos.flush();
//			oos.close();
//			baos.close(); 
		//	bais = new ByteArrayInputStream(baos.toByteArray());
		//	bais.close();
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		} */

		return bais ;
		
	}
	
	private HComponentFactory factory = HComponentFactory.eInstance;	
	
	public IFile persistSourceFile(String programText, IPath path) {
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			    							
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
	    // Create a new file resource in the workspace
	//    if (linkTargetPath != null)
	//               fileHandle.createLink(linkTargetPath,
	//                     IResource.ALLOW_MISSING_LOCAL, monitor);
	//       else {
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