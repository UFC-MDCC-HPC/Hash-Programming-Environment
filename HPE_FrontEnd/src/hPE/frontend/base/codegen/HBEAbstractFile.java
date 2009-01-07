package hPE.frontend.base.codegen;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;

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

public abstract class HBEAbstractFile implements Serializable {

	static final long serialVersionUID = 1;

	private String versionID=".";
	
	public HBEAbstractFile(String name, String contents, String rootPath, String versionID) {
		
		super();
		
		this.fileName = name;
		this.versionID = versionID;
			
	//	this.persistSourceFile(contents,rootPath);
		
	}
	
	private String fileName;
	private String sPath;
	
	
	public String getContents() {
		
    	IPath path = new Path(sPath);	
    	IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
    	
    	StringBuffer s = new StringBuffer();

		try {				
			FileInputStream contents = (FileInputStream) file.getContents();
			
			Reader reader = new InputStreamReader(contents);
			char[] readBuffer = new char[2048];
			int n = reader.read(readBuffer);
			while (n > 0) {
				s.append(readBuffer, 0, n);
				n = reader.read(readBuffer);
			}
			 			
			String ss = s.toString();           	    	
			
		    return ss;
			
		} catch (CoreException e) {
        	JOptionPane.showMessageDialog(null,
        		    "Error Fetching File Contents - ".concat(e.getMessage()),
        		    "Error",
        		    JOptionPane.ERROR_MESSAGE);
	    } catch (IOException e) {
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
		
		return null;
		
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
	
	public String getPath() {
		return this.sPath;
	}
	
	public abstract String getFileType();
	
	
	public void persistSourceFile(String programText, String rootPath) {
		
			String programName = this.getFileName();
			
			InputStream is = new java.io.StringBufferInputStream(programText);
	
	    	String uName = programName; 
			
	    	this.sPath = rootPath.substring(0,rootPath.lastIndexOf(".")).concat("/").concat(this.getFileType()).concat("/").concat(this.getVersionID()).concat("/").concat(uName);
	    	IPath path = new Path(sPath);	    	
	    	
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
            // Create a new file resource in the workspace
//            if (linkTargetPath != null)
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

        if (monitor.isCanceled())
            throw new OperationCanceledException();
    }

    private IProgressMonitor getProgressMonitor() {
        
    	return new org.eclipse.core.runtime.NullProgressMonitor();
    }

}
