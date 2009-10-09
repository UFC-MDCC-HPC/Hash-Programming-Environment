package hPE;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

import org.eclipse.ui.IEditorPart;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.viewers.ISelection;



public class HPEVersionEditor extends MultiPageEditorPart implements IResourceChangeListener {

	public HPEVersionEditor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	protected void createPages() {
        try { 
          setEditor(new hPEEditor());  
		  int index = this.addPage(getEditor(),this.getEditorInput());
		   
		  setPageText(index, getEditor().getTitle());
		  setTitle(getEditor().getTitle());
        }
        catch (PartInitException e) {
          System.err.println("ERROR opening HPE Editor");	
        }     
        
        
	}
	
	public void newPage(IEditorPart te, FileEditorInput fei, String pageText) {
		try {
			// Buscar se já existe uma página aberta ...
			int i,n = this.getPageCount();
			for (i=0;i<n && !this.getPageText(i).equals(pageText); i++);
			if (i>=n) { 
		        int index = this.addPage(te,fei);      		
		 		this.setPageText(index, pageText);
		 		this.setActivePage(index);
			} else {
				this.setActivePage(i);
			}
	    }
	    catch (PartInitException e) {
	    	
	    }

	}
	
/*    public String getTitle() {
		int i = this.getActivePage();
		if (this.getPageCount() > 0)
		   return getEditor(i).getTitle();
		else 
		   return "Loading Component";
		
		
		
	} 
    */
    public void pageChange (int newPageIndex) {
    	super.pageChange(newPageIndex);
    	this.setTitle(getEditor(newPageIndex).getTitle());    	
    }

	public void doSave(IProgressMonitor monitor) {
		//int i = this.getActivePage();
		for (int i=0 ; i < this.getPageCount(); i++)
		    	getEditor(i).doSave(monitor);
		
	}

	public void doSaveAs() {
		int i = this.getActivePage();
		IEditorPart editor = getEditor(i);
		editor.doSaveAs();
		setPageText(i, editor.getTitle());
		setInput(editor.getEditorInput());
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	
	public void gotoMarker(IMarker marker) {
		int i = this.getActivePage();
		setActivePage(i);
		IDE.gotoMarker(getEditor(i), marker);
	}
	
	private hPEEditor editor;
	
	/**
	 * Closes all project files on project close.
	 */
	public void resourceChanged(final IResourceChangeEvent event){
		if(event.getType() == IResourceChangeEvent.PRE_CLOSE){
			Display.getDefault().asyncExec(new Runnable(){
				public void run(){
					IWorkbenchPage[] pages = getSite().getWorkbenchWindow().getPages();
					for (int i = 0; i<pages.length; i++){
						if(((FileEditorInput)getEditor().getEditorInput()).getFile().getProject().equals(event.getResource())){
							IEditorPart editorPart = pages[i].findEditor(getEditor().getEditorInput());
							pages[i].closeEditor(editorPart,true);
						}
					}
				}            
			});
		}
	}
	
	public void removePage(String title) {
		
		int count = this.getPageCount();
		for (int i=0;i<count;i++) {
			String t = this.getPageText(i);
			if (t.equals(title)) {
				this.removePage(i);
				break;
			}
		}
		
		
	}



	public void setEditor(hPEEditor editor) {
		this.editor = editor;
	}



	public hPEEditor getEditor() {
		return editor;
	}
	
	
}
