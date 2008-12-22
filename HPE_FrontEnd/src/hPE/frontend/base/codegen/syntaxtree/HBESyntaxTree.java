package hPE.frontend.base.codegen.syntaxtree;

import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HPort;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.HActivateInterfaceSlice;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HAltAction;
import hPE.frontend.kinds.activate.model.protocol.HCombinatorAction;
import hPE.frontend.kinds.activate.model.protocol.HDoAction;
import hPE.frontend.kinds.activate.model.protocol.HProtocol;
import hPE.frontend.kinds.activate.model.protocol.HSignalAction;
import hPE.frontend.kinds.activate.model.protocol.HSkipAction;
import hPE.frontend.kinds.activate.model.protocol.HWaitAction;
import hPE.frontend.kinds.application.model.HApplicationInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;




public class HBESyntaxTree {

	String procName = null;
	
	public HBESyntaxTree(String name, HActivateInterface i) {
		
		super();
		
		procName = name;
		ToProcedure(i);		
	}
	
	public HBESyntaxTree(HActivateInterface i) {
		
		super();
		
		procName = i.getPrimName();
		ToProcedure(i);		
	}
	
	private Map<HInterface, HBEProcedureCall> activations = new HashMap<HInterface, HBEProcedureCall>();
	
	public Map<HInterface, HBEProcedureCall> getActivations() {
		return activations;
	}
	
	private HBEProcedure procedure = null;
	
	public String getModuleName() {
		return procName;
	}
	
	public HBEProcedure getMainProcedure() {
		return this.procedure;
	}
	
	public List<String> getExternalReferences() {
		List<String> externalReferences = new ArrayList<String>();
		Iterator<HInterface> is = activations.keySet().iterator();
		while (is.hasNext()) {
			HInterface i = is.next();
			if (!externalReferences.contains(i.getName(false,false))) 			
			   externalReferences.add(i.getName(false,false));
		}
		
		return externalReferences;
	}
	
	protected void ToProcedure(HActivateInterface i) {
		
		// The protocol.
		HProtocol protocol = (HProtocol) i.getProtocol();
		
		// The ports.
		List<HPort> ports = i.getPorts();
		
		// The grouping.
	//	List<HGroupingInterfaceSlice> grouping = null; 
	//	HGroupingInterfaceSlice myIdInGrouping = i.getGrouping(grouping); 

		procedure = new HBEProcedure(procName);
		
		String gVarName = null; // TODO !!!
		String gVarType = null; // TODO !!!
		HBEGroupingVariable gVar = new HBEGroupingVariable(gVarName,gVarType);
		
	//	if (myIdInGrouping != null) 
		//	procedure.setGroupingVariable(gVar);
		
		Integer c = 0;
		
		for (HPort p : ports) {
			if (p.isPrivate()) {
				String varName = p.getName().concat("_").concat(c.toString());
				HInterface ip = (HInterface)p.getPortType();
				String varType = ip.getPrimName();
				HBELocalVariable var = new HBELocalVariable(varName,varType);
				if (!this.activations.containsKey(ip)) activations.put(ip, null);								
				procedure.addLocalVariable(p,var);
			} else { //if (!(i instanceof HApplicationInterface)){
				String varName = p.getName().concat("_").concat(c.toString());
				HInterface ip = (HInterface)p.getPortType();
				String varType = ip.getPrimName();
				HBEParameter var = new HBEParameter(varName,varType);
				if (!this.activations.containsKey(ip)) activations.put(ip, null);
				procedure.addParameter(p,var);
			//} else {
            //	JOptionPane.showMessageDialog(null,
            //		    "Ports of an application interface cannot be public !",
            //		    "Error in generating code - HBESyntaxTree (ToProcedure)",
            //		    JOptionPane.ERROR_MESSAGE);

			}
			c++;
		}

		// Traverse protocol
		if (protocol == null) {
			protocol = new HProtocol(i);
			protocol.setAction(new HSkipAction("",protocol));
		}
		HBECommandBlock mainBlock = actionToCommand((HAction)protocol.getAction());
		
		if (!(mainBlock instanceof HBECompoundBlock)) {
			HBECompoundBlock eBlock = new HBESequentialBlock();
			eBlock.addBlock(mainBlock);
			mainBlock = eBlock;
		}
		
		procedure.setMainBlock(mainBlock);
		
		// innerProcedures.add(procedure);
	}

	private HBECommandBlock actionToCommand(HAction action) {

        HBECommandBlock block = HBEBlockFactory.newCommandBlock(action);
        
        if (action.isRepeat()) {
        	HBERepeatTestBranch rtb = new HBERepeatTestBranch(block);
        	block.setBranch(rtb);
        }
        
        
	    if (action instanceof HCombinatorAction) {
	        
			HCombinatorAction cAction = (HCombinatorAction) action;	
	        List actions = cAction.getActions();
	        Iterator as = actions.iterator();
	        HBECompoundBlock cBlock = (HBECompoundBlock) block;
	        while (as.hasNext()) {
	           HAction a = (HAction) as.next();
	           HBECommandBlock innerBlock = actionToCommand(a);
	           cBlock.addBlock(innerBlock);        	   
	        }
	        
	        if (action instanceof HAltAction) {
	        	List<HBECommandBlock> blocks = cBlock.getBlocks();
	        	Iterator bs = blocks.iterator();
	        	while (bs.hasNext()) {
	        		HBECommandBlock b = (HBECommandBlock) bs.next();
	        		HBESimpleTestBranch rtb = new HBESimpleTestBranch(block);
	        		b.setBranch(rtb);
	        	}
	        }
	        
        
        } else if (action instanceof HDoAction){
        	
        	HBEProcedureCall pc = (HBEProcedureCall) block;        	
        	HDoAction doAction = (HDoAction) action;
        	
        	HActivateInterfaceSlice is = (HActivateInterfaceSlice) doAction.getSliceAbstraction();
        	HActivateInterface i = (HActivateInterface) is.getInterface(); 
    
        	pc.setActivateSlice(is);
        	
        	String calledProcName = is.getName(); // i.getPrimName();
        	
        	// BEGIN POG Block
        	if (activations.containsKey(i)) {
        		pc = activations.get(i);
        	} else {
        		activations.put(i, pc);
        	} 
        	// END POG Block
        	
        	
        	
        	pc.setName(calledProcName);
        	
        	List<HPort> ports = is.getPorts();
        	
        	for (HPort p : ports) {
        		HBEVariable v = procedure.getVariable(p);
        		if (v==null) {
        		   System.out.print("NULL PORT !!!! HBEProtocol2Procedure");
        		}
            	pc.addParameter(v);
        	}

        	// HBEProtocol2Procedure innerProc = new HBEProtocol2Procedure(calledProcName,i);
            
        	// if (!this.externalReferences.contains(calledProcName)) this.externalReferences.add(calledProcName);   	
        	
        } else if (action instanceof HSkipAction) {
        	return block;       	
        	
        } else if (action instanceof HSignalAction) {
        	
        } else if (action instanceof HWaitAction) {
        	
        }
		
		return block;
	}
	
	
}
