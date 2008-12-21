package hPE.model.base;

import org.eclipse.draw2d.geometry.Rectangle;

import java.io.Serializable;

public class HVisualElement  implements Serializable, IHVisualElement {

	static final long serialVersionUID = 1;

	public HVisualElement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @uml.property name="bounds"
	 */
	private Rectangle bounds = null;

	/* (non-Javadoc)
	 * @see hPE.base.model.IHVisualElement#getBounds()
	 */
	public Rectangle getBounds() {
		return bounds;
	}

	/* (non-Javadoc)
	 * @see hPE.base.model.IHVisualElement#setBounds(org.eclipse.draw2d.geometry.Rectangle)
	 */
	public void setBounds(Rectangle bounds) {
		if (bounds.x < 0) { bounds.x = 0; }
		if (bounds.y < 0) { bounds.y = 0; }
		if (bounds.height <= 0) { bounds.height = this.bounds.height < 0 ? 2 : this.bounds.height; }
		if (bounds.width <= 0) { bounds.width = this.bounds.width < 0 ? 2 : this.bounds.width; }
				
		this.bounds = bounds;
	}

	protected void adjustBoundsToFitChild(Rectangle old_bounds, Rectangle new_bounds) {
		// TODO: model (adjustBoundsToFitChild)
	}
	
	
	
	
}
