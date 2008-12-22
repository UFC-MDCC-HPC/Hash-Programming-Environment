package hPE.frontend.base.model;

import org.eclipse.swt.graphics.Color;
import java.io.Serializable;

public class MyColor implements Serializable {

	static final long serialVersionUID = 1;
	
	int red = 0;
	int green = 0;
	int blue = 0;
	
	public MyColor(Color color) {
		super();
		setColor(color);
	}
	
	public void setColor(Color color) {
		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
	}
	
	public Color getColor() {
		return new Color(null,red,green,blue);
	}

}
