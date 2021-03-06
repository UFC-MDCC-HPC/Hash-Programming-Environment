package hPE.frontend.base.dnd;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;

public class FileTransferDropTargetListener extends
		AbstractTransferDropTargetListener {

	  public FileTransferDropTargetListener(EditPartViewer viewer, Transfer xfer) {
	      super(viewer, xfer);
	   }

	   public FileTransferDropTargetListener(EditPartViewer viewer) {
	      super(viewer, FileTransfer.getInstance());
	   }
	   
	   protected void updateTargetRequest() {
		   ((CreateRequest)getTargetRequest()).setLocation(getDropLocation());
		}

	    public void dragEnter(DropTargetEvent event) {
	        // always indicate a copy
	        event.detail = DND.DROP_COPY;
	    }

	    public void dragOperationChanged(DropTargetEvent event) {
	        // always indicate a copy
	        // event.detail = DND.DROP_COPY;
	    }
	    
	   protected void handleDragOver() {
		   getCurrentEvent().detail = DND.DROP_COPY;
		   super.handleDragOver();
		}
	   
	   protected void handleDrop() {
		   //HComponent[] files = (HComponent[]) getCurrentEvent().data;
           String[] files = (String[]) getCurrentEvent().data;
		   factory.setFiles(files);
		   super.handleDrop();
		}
	   
	    public void drop(final DropTargetEvent event) {
	    	super.drop(event);
	    }
		
	   private NewComponentFactory2 factory = new NewComponentFactory2();
	   
	   protected Request createTargetRequest() {
		   CreateRequest request = new CreateRequest();
		   request.setFactory(factory);
		   return request;
		}
	   
	   static public class NewComponentFactory2 implements CreationFactory {

		   //private HComponent[] files;
		   private String[] files;

	      public Object getNewObject() {
	    	  return files;
		  }

		  public Object getObjectType() {
		      return HComponent.class;
		  }

		  public void setFiles(String[] s /*HComponent[] s*/) {
		      files = s;
		  }
		}	   
}
