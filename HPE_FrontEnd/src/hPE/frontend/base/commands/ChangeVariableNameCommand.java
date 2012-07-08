package hPE.frontend.base.commands;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.dialogs.DialogChangeVarName;
import hPE.frontend.base.model.HComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import hPE.util.Pair;
import java.util.Map;

import javax.swing.JOptionPane;


public class ChangeVariableNameCommand extends Command {

	private HComponent c;
	public ChangeVariableNameCommand(HComponent c) {
		super();
		this.c = c;
	}


	DialogChangeVarName newVarNameDialog = null;
	
	
	public void execute() {
		this.newVarNameDialog = DialogChangeVarName.getInstance();
		this.newVarNameDialog.setModel(c);
        
		Map<String,List<HComponent>> m = c.getParameters();
        
		this.newVarNameDialog.clearVars();
		 
        List<HComponent> cupdate = new ArrayList<HComponent>();
        
        for (String var : m.keySet()) {
        	 List<HComponent> innerCs = m.get(var);
        	 cupdate.addAll(innerCs);
        	 HComponent cVar = ((List<HComponent>)innerCs).get(0) ;
        	 if (cVar.getSupplier()==null) // Só pode alterar se for filho direto da configuração ...
        		 this.newVarNameDialog.addVarName(new Pair<String,List<HComponent>>(var,innerCs));
        }
        
        this.newVarNameDialog.setUpdates(cupdate);
		this.newVarNameDialog.setVisible(true);
                

        return;
	}
	
    	
	public boolean canExecute() {
		return true;
	}

}

