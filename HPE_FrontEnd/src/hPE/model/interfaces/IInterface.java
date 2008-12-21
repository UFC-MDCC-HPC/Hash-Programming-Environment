package hPE.model.interfaces;

import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HModule;

import java.util.List;


public interface IInterface {

	public String getName2();
	
	public String getName(boolean showSuperType, boolean showBounds);
	
	public String getPrimName();
	
	public boolean isUnamed();
	
	public IConfiguration getConfiguration();
		
	public List getModules();
	
	public void addModule(HModule module);
	
	public List<HInterfaceSlice> getSlices();
	
	public void setEditableSource(boolean isEditableSource);

	public void setEditable(boolean editable);
	
	public boolean isEditable();
	
}
