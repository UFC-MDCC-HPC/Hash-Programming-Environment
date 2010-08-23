package hPE.frontend.base.codegen;

import hPE.frontend.base.dialogs.AddReferencesDialog.Reference;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.xml.factory.HComponentFactoryImpl;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

public abstract class HBEAbstractFile implements Serializable, HHasExternalReferences {

	static final long serialVersionUID = 1;

	private String versionID=".";
	
	private HHasExternalReferences i = null;
	
	public HBEAbstractFile(String name, String contents, String rootPath, String versionID, HHasExternalReferences i, String srcType) {
		
		super();
		
		this.i = i;
		this.fileName = name;
		this.setSrcType(srcType);
		this.versionID = versionID;
		this.contents = contents;
    	this.sPath = rootPath.substring(0,rootPath.lastIndexOf("/")).concat("/src/")/*.concat(this.getFileType()).concat("/")*/.concat(this.getVersionID()).concat("/").concat(this.getFileName());
			
	//	this.persistSourceFile(contents,rootPath);
		
	}
	
	private String fileName;
	private String srcType;
	private String sPath;
	
	private String contents;
	
/*	public void setContents(String contents) {
	    this.contents = contents;
	}
	*/
	
	public String getCurrentContents() {
				
    	IPath path = new Path(sPath);	
    	// IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    	java.io.File file = HComponentFactoryImpl.getFileInWorkspace(path);
    	
    	StringBuffer s = new StringBuffer();

		try {				
			FileInputStream contents = new FileInputStream(file);
			if (contents != null) {
				Reader reader = new InputStreamReader(contents);
				char[] readBuffer = new char[2048];
				int n = reader.read(readBuffer);
				while (n > 0) {
					s.append(readBuffer, 0, n);
					n = reader.read(readBuffer);
				}
				 			
				String ss = s.toString();
				
				this.contents = ss;
			} 
			
		    return this.contents;
			
		} /* catch (CoreException e) {
			if (this.contents != null)
				persistSourceFile();
        	// JOptionPane.showMessageDialog(null,
        	//	    "Error Fetching File Contents - ".concat(e.getMessage()),
        	//	    "Error",
        	//	    JOptionPane.ERROR_MESSAGE);
	    } */ 
		catch (IOException e) {
        	JOptionPane.showMessageDialog(null,
        		    "Error Reading File Contents - ".concat(e.getMessage()),
        		    "Error",
        		    JOptionPane.ERROR_MESSAGE);
//		} catch (ClassNotFoundException e) {
//        	JOptionPane.showMessageDialog(null,
//        		    "Error Fetching File Contents".concat(e.getMessage()),
//        		    "Error",
//        		    JOptionPane.ERROR_MESSAGE);
//			
		}
		
		return this.contents;
		
	}
	
	public String getVersionID() {
		return versionID;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public void setPath(String path) {
		this.sPath = path;
	}
	
	public IPath getSourcePath() {
		return new Path(this.sPath);
	}
	
	public IPath getBinaryPath() {
		IPath path = new Path(this.getSourcePath().toString().replace("/src/","/bin/"));
		path = path.removeFileExtension().addFileExtension(this.getBinaryExtension());
		return path;
	}
	
	private List<String> dependencies = null;
	
	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;		
	}

	public List<String> getDependencies() {
		return this.dependencies;		
	}

	private List<String> externalDependencies;

	public void addExternalReferences(List<String> selectedReferences) {
		if (externalDependencies == null) {
			externalDependencies = new ArrayList<String>();
		}
		
		for (String ref : selectedReferences) {
			externalDependencies.add(ref);
		}
		
	}

	public Set<String> getExternalReferences() {
		if (externalDependencies == null) {
			externalDependencies = new ArrayList<String>();
		}
		Set<String> ss = new HashSet<String>();
		
		ss.addAll(i.getExternalReferences());
		ss.addAll(externalDependencies);
		return ss;
	}
	
	@Override
	public void removeExternalReferences(List<String> selectedReferences) {
		if (externalDependencies == null) {
			externalDependencies = new ArrayList<String>();
		}
		for (String ref : selectedReferences) {
			if (this.externalDependencies.contains(ref)) {
       		   this.externalDependencies.remove(ref);
			} else {
				if (i.getExternalReferences().contains(ref)) {
   				   JOptionPane.showMessageDialog(null, "It is not possible to remove " + ref + " because it is a reference of the interface.", "Forbidden Operation", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}

	public abstract String getFileType();
	
	public abstract String getBinaryExtension();
	
	public abstract String getSourceExtension();
	
	public void persistSourceFile() {
		
			InputStream is = new java.io.StringBufferInputStream(this.contents);
	
	    	IPath path = this.getSourcePath();	    	
	    	
	    	IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	    		    							
			try {				
				createFile(file,is,this.getProgressMonitor());				
			} catch (CoreException e) {
            	JOptionPane.showMessageDialog(null,
            		    "Error Creating File - ".concat(e.getMessage()),
            		    "Error",
            		    JOptionPane.ERROR_MESSAGE);
			}

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

        if (monitor.isCanceled())
            throw new OperationCanceledException();
    }

    private IProgressMonitor getProgressMonitor() {
        
    	return new org.eclipse.core.runtime.NullProgressMonitor();
    }

	public void setSrcType(String srcType) {
		this.srcType = srcType;
	}

	public String getSrcType() {
		return srcType;
	}

}
