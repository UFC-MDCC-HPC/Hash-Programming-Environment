package hPE;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveFactory;

public class HPEPerspective implements IPerspectiveDescriptor,
		IPerspectiveFactory {

	public HPEPerspective() {
	}

	public String getDescription() {
		return "Hash Programming Enviroment - A High Performance Platform of Components";
	}

	public String getId() {
		return "HPE";
	}

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getLabel() {
		return "Hash Programming Environment";
	}

	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);
	}

	public void defineActions(IPageLayout layout) {
		// Add "new wizards".
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
		layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");
		layout.addNewWizardShortcut("org.eclipse.HPE.HPEWizard");

		// Add "show views".
		layout.addShowViewShortcut("hPE.HPEResourceNavigator");
		layout.addShowViewShortcut("hPE.library.HPEComponentLibraryView");
		layout.addShowViewShortcut("hPE.core.library.LocationView");
	}

	public void defineLayout(IPageLayout layout) {
		// Editors are placed for free.
		String editorArea = layout.getEditorArea();

		// Place navigator and outline to left of
		// editor area.
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT,
				(float) 0.20, editorArea);
		IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT,
				(float) 0.75, editorArea);
		IFolderLayout bottom = layout.createFolder("bottom",
				IPageLayout.BOTTOM, (float) 0.7, editorArea);

		left.addView("hPE.HPEResourceNavigator");
		right.addView("hPE.library.HPEComponentLibraryView");
		bottom.addView("hPE.core.library.LocationView");
	}
}
