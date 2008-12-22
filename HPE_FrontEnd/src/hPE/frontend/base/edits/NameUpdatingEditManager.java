package hPE.frontend.base.edits;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.CellEditorActionHandler;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;

import hPE.frontend.base.figures.INameEditableFigure;
import hPE.frontend.base.model.HNamed;

public class NameUpdatingEditManager extends DirectEditManager {

	public NameUpdatingEditManager(GraphicalEditPart source, CellEditorLocator locator) {
		super(source, null, locator);
	}


	private IActionBars actionBars;
	private CellEditorActionHandler actionHandler;
	private IAction copy, cut, paste, undo, redo, find, selectAll, delete;
	private Font scaledFont;

	/**
	 * @see org.eclipse.gef.tools.DirectEditManager#bringDown()
	 */
	protected void bringDown() {
		if (actionHandler != null) {
			actionHandler.dispose();
			actionHandler = null;
		}
		if (actionBars != null) {
			restoreSavedActions(actionBars);
			actionBars.updateActionBars();
			actionBars = null;
		}

		Font disposeFont = scaledFont;
		scaledFont = null;
		super.bringDown();
		if (disposeFont != null)
			disposeFont.dispose();
	}

	protected CellEditor createCellEditorOn(Composite composite) {
		return new TextCellEditor(composite, SWT.MULTI | SWT.WRAP);
	}

	protected void initCellEditor() {
		Text text = (Text)getCellEditor().getControl();
		INameEditableFigure stickyNote = (INameEditableFigure)getEditPart().getFigure();
		String initialLabelText = ((HNamed)this.getEditPart().getModel()).getName2();// stickyNote.getName();
		getCellEditor().setValue(initialLabelText);
		IFigure figure = getEditPart().getFigure();
		scaledFont = figure.getFont();
		FontData data = scaledFont.getFontData()[0];
		Dimension fontSize = new Dimension(0, data.getHeight());
		stickyNote.translateToAbsolute(fontSize);
		data.setHeight(fontSize.height);
		scaledFont = new Font(null, data);
		text.setFont(scaledFont);
		text.selectAll();

		// Hook the cell editor's copy/paste actions to the actionBars so that they can
		// be invoked via keyboard shortcuts.
		actionBars = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor().getEditorSite().getActionBars();
		saveCurrentActions(actionBars);
		actionHandler = new CellEditorActionHandler(actionBars);
		actionHandler.addCellEditor(getCellEditor());
		actionBars.updateActionBars();
	}

	private void restoreSavedActions(IActionBars actionBars){
		actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copy);
		actionBars.setGlobalActionHandler(ActionFactory.PASTE.getId(), paste);
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), delete);
		actionBars.setGlobalActionHandler(ActionFactory.SELECT_ALL.getId(), selectAll);
		actionBars.setGlobalActionHandler(ActionFactory.CUT.getId(), cut);
		actionBars.setGlobalActionHandler(ActionFactory.FIND.getId(), find);
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undo);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redo);
	}

	private void saveCurrentActions(IActionBars actionBars) {
		copy = actionBars.getGlobalActionHandler(ActionFactory.COPY.getId());
		paste = actionBars.getGlobalActionHandler(ActionFactory.PASTE.getId());
		delete = actionBars.getGlobalActionHandler(ActionFactory.DELETE.getId());
		selectAll = actionBars.getGlobalActionHandler(ActionFactory.SELECT_ALL.getId());
		cut = actionBars.getGlobalActionHandler(ActionFactory.CUT.getId());
		find = actionBars.getGlobalActionHandler(ActionFactory.FIND.getId());
		undo = actionBars.getGlobalActionHandler(ActionFactory.UNDO.getId());
		redo = actionBars.getGlobalActionHandler(ActionFactory.REDO.getId());
	}

}	
