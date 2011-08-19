package hPE.frontend.base.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Juliano Efson Sales
 * @since 12 Aug 2011
 * 
 */
public class HPackage {

	protected String path;

	protected List<HComponent> componentList;

	// TODO gambiarra temporária em função de não poder preender os componente
	// HComponent.
	protected List<String> componentNameList;

	public HPackage() {
		componentList = new ArrayList<HComponent>();
		componentNameList = new ArrayList<String>();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<HComponent> getComponentList() {
		return componentList;
	}

	public void setComponentList(List<HComponent> componentList) {
		this.componentList = componentList;
	}

	public List<String> getComponentNameList() {
		return componentNameList;
	}

	public void setComponentNameList(List<String> componentNameList) {
		this.componentNameList = componentNameList;
	}

	public void addComponent(String com) {
		componentNameList.add(com);
	}
}
