package hPE.frontend.base.model;

import org.eclipse.draw2d.geometry.Rectangle;

public interface IHVisualElement {

	/** 
	 * Getter of the property <tt>boundbox</tt>
	 * @return  Returns the boundbox.
	 * @uml.property  name="bounds"
	 */
	public abstract Rectangle getBounds();

	/**
	 * Setter of the property <tt>bounds</tt>
	 * @param bounds  The bounds to set.
	 * @uml.property  name="bounds"
	 */
	public abstract void setBounds(Rectangle bounds);

}