package hPE.frontend.commandline;

import hPE.frontend.commandline.main.HpeCmd;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;


/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CommandLineHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public CommandLineHandler() {
	}

	
	
	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		//MessageDialog.openInformation(
		//		window.getShell(),
		//		"HPE Plug-in",
		//		"Hello, Eclipse world");
		try {
			HpeCmd hpecmd = new HpeCmd("HPE Command Line");
			hpecmd.start();
		} catch (Exception e) {
		   System.out.print(e.getMessage());	
		   System.out.print(e.getLocalizedMessage());	
		}
		return null;
	}

		 
}		
	


