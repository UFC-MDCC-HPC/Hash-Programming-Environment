package hPE.frontend.commands.base;

import org.eclipse.gef.commands.Command;

import hPE.frontend.dialogs.base.DialogChangeVarName;
import hPE.model.base.HComponent;

import java.util.Iterator;
import java.util.List;
import hPE.util.Pair;
import java.util.Map;


public class ChangeVariableNameCommand extends Command {

	HComponent c;
	String new_name;
	
	public ChangeVariableNameCommand(HComponent c) {
		super();
		this.c = c;
	}


	DialogChangeVarName newVarNameDialog = null;
	
	
	public void execute() {
		this.newVarNameDialog = new DialogChangeVarName();
        this.newVarNameDialog.setAlwaysOnTop(true);
        this.newVarNameDialog.setModal(true);
        Map<String,List<HComponent>> m = c.getParameters2();
        Iterator vs = m.keySet().iterator();
        
        while (vs.hasNext()) {
        	 String var = (String) vs.next();
        	 List<HComponent> innerCs = (List) m.get(var);
        	 HComponent cVar = (HComponent) ((List)innerCs).get(0) ;
        	 if (cVar.getSupplied()==null) 
        		 this.newVarNameDialog.addVarName(new Pair(var,innerCs));
        }
        this.newVarNameDialog.show();
        
        varToBeChanged = (Pair) this.newVarNameDialog.getOldVarName();
        newVarName = this.newVarNameDialog.getNewVarName();
        
        if (newVarName != null && !newVarName.equals("")) {
	        Iterator cs = ((List) varToBeChanged.snd()).iterator();
	        while (cs.hasNext()) {
	        	HComponent innerC = (HComponent) cs.next();
	            innerC.setVariableName(newVarName);
	        }
	        c.adviceChangeParameterName();
        } else {
        	System.err.println("Invalid Variable Name !! (ChangeVariableNameCommand.execute())");
        	
        }
        
		return;
	}
	
    private Pair varToBeChanged = null;
    private String newVarName = null;
    
	public void undo () {
        
		String oldVarName = (String) varToBeChanged.fst();
        Iterator cs = ((List) varToBeChanged.snd()).iterator();        
        while (cs.hasNext()) {
        	HComponent innerC = (HComponent) cs.next();
            innerC.setVariableName(oldVarName);
        }
        
        c.adviceChangeParameterName();
	}
	
	public void redo () {
		
        Iterator cs = ((List) varToBeChanged.snd()).iterator();        
        while (cs.hasNext()) {
        	HComponent innerC = (HComponent) cs.next();
            innerC.setVariableName(newVarName);
        }
        
        c.adviceChangeParameterName();
	}
	
	public boolean canExecute() {
		return true;
	}

}

