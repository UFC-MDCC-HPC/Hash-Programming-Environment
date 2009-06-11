package hPE.frontend.base.commands;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.dialogs.DialogChangeVarName;
import hPE.frontend.base.model.HComponent;

import java.util.Iterator;
import java.util.List;
import hPE.util.Pair;
import java.util.Map;

import javax.swing.JOptionPane;


public class ChangeVariableNameCommand extends Command {

	private HComponent c;
	private String new_name;
	
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
        
        for (String var : m.keySet()) {
        	 List<HComponent> innerCs = (List) m.get(var);
        	 HComponent cVar = (HComponent) ((List)innerCs).get(0) ;
        	 if (cVar.getSupplied()==null) // Só pode alterar se for filho direto da configuração ...
        		 this.newVarNameDialog.addVarName(new Pair(var,innerCs));
        }
        this.newVarNameDialog.show();
        
        varToBeChanged = (Pair) this.newVarNameDialog.getOldVarName();
        newVarName = this.newVarNameDialog.getNewVarName();
        
        if (newVarName != null && !newVarName.equals("")) {
	        if (c.isTopConfiguration() && (varToBeChanged.snd().size() > 1 || (varToBeChanged.snd().size() == 1 && !varToBeChanged.snd().get(0).isDirectSonOfTheTopConfiguration()) ) ) {
	        	JOptionPane.showMessageDialog(null, "Don't make the things more difficult to programmers ! \n It is not allowed to change the name of a non top-level variable !", "Invalid Operation", JOptionPane.ERROR_MESSAGE);
	        }  else  {
	        	for (HComponent innerC : varToBeChanged.snd()) {
		            innerC.setVariableName(newVarName);
		        }
		        c.adviceChangeParameterName();
	        }
        } else {
        	System.err.println("Invalid Variable Name !! (ChangeVariableNameCommand.execute())");
        	
        }
        
		return;
	}
	
    private Pair<String, List<HComponent>> varToBeChanged = null;
    private String newVarName = null;
    
	public void undo () {
        
		String oldVarName = (String) varToBeChanged.fst();
		for (HComponent innerC : varToBeChanged.snd()) {
            innerC.setVariableName(oldVarName);
        }
        
        c.adviceChangeParameterName();
	}
	
	public void redo () {
		
		for (HComponent innerC : varToBeChanged.snd()) {
            innerC.setVariableName(newVarName);
        }
        
        c.adviceChangeParameterName();
	}
	
	public boolean canExecute() {
		return true;
	}

}

