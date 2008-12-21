package hPE.frontend.codegen.syntaxtree;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;

public class HBEProcedure {

	public HBEProcedure(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * @uml.property   name="localVariables"
	 * @uml.associationEnd   qualifier="key:java.lang.Object hPE.backend.cluster.synthesizer.syntaxtree.HBELocalVariable"
	 */
	private Map<Object,HBELocalVariable> localVariables = new HashMap<Object,HBELocalVariable>();
	/**
	 * @uml.property   name="parameters"
	 * @uml.associationEnd   qualifier="key:java.lang.Object hPE.backend.cluster.synthesizer.syntaxtree.HBEParameter"
	 */
	private Map<Object,HBEParameter> parameters = new HashMap<Object,HBEParameter>();
	private HBECommandBlock mainBlock = null;
	
	public List<HBELocalVariable> getVariables() {
		ArrayList<HBELocalVariable> l = new ArrayList<HBELocalVariable>();
		Set<Object> s = localVariables.keySet();
		Iterator ps = s.iterator();
		while (ps.hasNext()) {
	        Object o = ps.next();
	        l.add(localVariables.get(o));
		}		
		return l;

	}
	
	public List<HBEParameter> getParameters() {
		
		ArrayList<HBEParameter> l = new ArrayList<HBEParameter>();
		Set<Object> s = parameters.keySet();
		Iterator ps = s.iterator();
		while (ps.hasNext()) {
	        Object o = ps.next();
	        l.add(parameters.get(o));
		}		
		// List<HBEParameter> l = (List<HBEParameter>) parameters.values();
		return l;
	}
	
	public HBECommandBlock getMainBlock() {
		return mainBlock;
	}
	
	
	public void addParameter(Object obj, HBEParameter parameter) {
		this.parameters.put(obj,parameter);
	}
	
	public void addLocalVariable(Object obj,HBELocalVariable variable) {
		this.localVariables.put(obj,variable);
	}
	
	public HBEParameter getParameter(Object objId) {
		return this.parameters.get(objId);
	}
	
	public HBELocalVariable getLocalVariable(Object objId) {
		return this.localVariables.get(objId);
	}
	
	public HBEVariable getVariable(Object objId) {
		HBEVariable v = getParameter(objId);
		if (v == null) v = getLocalVariable(objId);
		return v;
	}
	
	public void setMainBlock(HBECommandBlock mainBlock) {
		this.mainBlock = mainBlock;
	}
	
	private String name = null;
	
	public String getName() {
		return name;
	}

	private HBEGroupingVariable groupingVariable = null;
	
	public void setGroupingVariable(HBEGroupingVariable gVar) {
	    this.groupingVariable = gVar;	
	}
	
	public HBEGroupingVariable getGroupingVariable() {
		return this.groupingVariable;
	}
	
	public boolean haveGroupingVariable() {
	    return groupingVariable != null;	
	}
	
}
