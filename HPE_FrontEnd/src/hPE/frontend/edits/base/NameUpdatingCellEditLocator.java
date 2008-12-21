package hPE.frontend.edits.base;
import org.eclipse.swt.widgets.Text;

import org.eclipse.jface.viewers.CellEditor;

import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.gef.tools.CellEditorLocator;

import hPE.frontend.figures.base.INameEditableFigure;


final public class NameUpdatingCellEditLocator
	implements CellEditorLocator
{

private INameEditableFigure stickyNote;

public NameUpdatingCellEditLocator(INameEditableFigure stickyNote) {
	setLabel(stickyNote);
}

public void relocate(CellEditor celleditor) {
	Text text = (Text)celleditor.getControl();
	Rectangle rect = stickyNote.getClientArea().getCopy();
	stickyNote.translateToAbsolute(rect);
	org.eclipse.swt.graphics.Rectangle trim = text.computeTrim(0, 0, 0, 0);
	rect.translate(trim.x, trim.y);
	rect.width += trim.width;
	rect.height += trim.height;
	text.setBounds(rect.x, rect.y, rect.width, rect.height);
}

/**
 * Returns the stickyNote figure.
 */
protected INameEditableFigure getLabel() {
	return stickyNote;
}

/**
 * Sets the Sticky note figure.
 * @param stickyNote The stickyNote to set
 */
protected void setLabel(INameEditableFigure stickyNote) {
	this.stickyNote = stickyNote;
}

}