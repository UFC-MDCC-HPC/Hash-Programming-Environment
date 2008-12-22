package hPE.frontend.base.figures;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;

public interface INameEditableFigure {

	public void setName(String name);
	public String getName();
	public Rectangle getClientArea();
	public void translateToAbsolute(Translatable t);	
	
}

