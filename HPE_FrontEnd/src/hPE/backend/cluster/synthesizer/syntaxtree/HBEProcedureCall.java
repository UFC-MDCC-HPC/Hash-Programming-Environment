package hPE.backend.cluster.synthesizer.syntaxtree;


import hPE.model.kinds.activate.HActivateInterfaceSlice;

import java.util.List;
import java.util.ArrayList;

public class HBEProcedureCall extends HBECommandBlock {

	public HBEProcedureCall() {
		super();
	}

	private HActivateInterfaceSlice slice = null;
	
	public HActivateInterfaceSlice getActivateSlice() {
		return this.slice;
	}
	
	public void setActivateSlice(HActivateInterfaceSlice s) {
		this.slice = s;
	}
	
	private String name;
	private List<HBEVariable> parameters = new ArrayList<HBEVariable>(); 
	
	public String getName() {
		return name;
	}
	
	public List<HBEVariable> getParameters() {
		return parameters;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addParameter(HBEVariable var) {
		parameters.add(var);
	}
	
	
	
}
