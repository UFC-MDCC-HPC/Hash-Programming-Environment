package hPE.frontend.base.dialogs;

import hPE.HPEPlugin;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Utility class that makes showing eclipse dialogs easily
 */
public final class DialogUtil {

	private DialogUtil() {
	}

	public static void openError(String message) {
		openError("HPE - Error", message);
	}

	public static void openError(String title, String message) {
		MessageDialog.openError(getShell(), title, message);
	}

	public static void openError(String message, Throwable exception) {
		openError("HPE - Error", message, exception);
	}

	public static void openError(String title, String message, Throwable exception) {
		ErrorDialog.openError(getShell(), title, null, new Status(Status.ERROR, getPluginId(), message, exception));
	}

	public static void openInformation(String message) {
		openInformation("HPE - Information", message);
	}

	public static void openInformation(String title, String message) {
		MessageDialog.openInformation(getShell(), title, message);
	}

	public static String getPluginId() {
		return HPEPlugin.getDefault().getBundle().getSymbolicName();
	}

	public static Shell getShell() {
		return Display.getCurrent().getActiveShell();
	}
}
