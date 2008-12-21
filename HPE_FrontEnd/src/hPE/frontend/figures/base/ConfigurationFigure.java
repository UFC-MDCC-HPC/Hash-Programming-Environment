package hPE.frontend.figures.base;

import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Color;



public class ConfigurationFigure extends FreeformLayer 
                                 implements INameEditableFigure {

    TextFlow name = new TextFlow();
	
    FlowPage flowPage;
    
    RectangleFigure cnf;
    
	public ConfigurationFigure() {
		super();
	
		cnf = new RectangleFigure();		
		// add(cnf);
		cnf.setBounds(new Rectangle(new Point(0,0), new Dimension(100,50)));
		cnf.setBackgroundColor(ColorConstants.yellow);
		
		/* BEGIN edit label */		
		flowPage = new FlowPage();
		name.setLayoutManager(new ParagraphTextLayout(name, ParagraphTextLayout.WORD_WRAP_SOFT));
		flowPage.add(name);
		/* END edit label */
		
		this.add(flowPage);
		name.setFocusTraversable(true);
		Font name_font = new Font(null,"Arial",15,SWT.BOLD);
		name.setFont(name_font);

		Rectangle r = new Rectangle();
		r.resize(1024,768);
		
		this.setLayoutManager(new FreeformLayout());
		this.setBorder(new MarginBorder(5));
		this.setBounds(r);
				
	}

	private Color color = ColorConstants.white;
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	protected void paintFigure(Graphics g) {
		g.setBackgroundColor(color);
		g.fillRectangle(getBounds().getCopy());
		this.invalidateTree();
	}
	
	public void setName(String the_name) {
		name.setText(the_name);
		Label aux = new Label(name.getText());
		aux.setFont(name.getFont());
		
		
		flowPage.setBounds(aux.getTextBounds());
		
		int x = 10; // cnf.getLocation().x + (cnf.getBounds().width - aux.getTextBounds().width)/2;
		int y = 10; // cnf.getLocation().y + (cnf.getBounds().height - aux.getTextBounds().height)/2;
		
		flowPage.setLocation(new Point(x,y));
	}
	
	public String getName() {
		   return name.getText();	
		}
	
}
