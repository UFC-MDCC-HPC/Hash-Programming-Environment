package hPE.frontend.base.interfaces;

public interface IAction {

	public String getLabel();
	
	public boolean isRepeat();
	
	public IActionRepeat getRepeatAction();	
	
}
