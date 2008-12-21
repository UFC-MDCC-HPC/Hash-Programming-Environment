package hPE.frontend.library.model.interfaces;

import java.util.List;

public interface IHPEComponentLibraryItem {

	public String getTitle();
	
	public IHPEComponentLibraryItem getParent();
	
	public List getChildren();
	
	public void addChild(IHPEComponentLibraryItem child);
	public void removeChild(IHPEComponentLibraryItem child);
	public void clearChildren();
	
	public boolean isRoot(); // !isRoot() => getParent()==null

}
