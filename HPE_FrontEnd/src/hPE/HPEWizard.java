package hPE;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.jface.wizard.*;

public class HPEWizard extends Wizard implements INewWizard {
		
		private HPEPage HPEPage = null;
		private IStructuredSelection selection;
		private IWorkbench workbench;
		
		public HPEWizard() {
			super();
			// TODO Auto-generated constructor stub
		}

		public void addPages(){
			HPEPage = new HPEPage(workbench,selection);
			addPage(HPEPage);
		}
		
		public boolean performFinish() {
			// TODO Auto-generated method stub
			return HPEPage.finish();
			
		}

		public void init(IWorkbench aWorkbench, IStructuredSelection currentSelection) {
			// TODO Auto-generated method stub
			workbench = aWorkbench;
			selection = currentSelection;
		}

	}
	
	

