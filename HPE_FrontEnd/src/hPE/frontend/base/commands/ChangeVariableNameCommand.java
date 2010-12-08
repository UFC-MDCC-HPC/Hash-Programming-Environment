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
	private String new_name;
	
	public ChangeVariableNameCommand(HComponent c) {
		super();
		this.c = c;
	}


	DialogChangeVarName newVarNameDialog = null;
	
	
	public void execute() {
		this.newVarNameDialog = new DialogChangeVarName(c);
        this.newVarNameDialog.setAlwaysOnTop(true);
        this.newVarNameDialog.setModal(true);
        Map<String,List<HComponent>> m = c.getParameters();
        
        List<HComponent> cupdate = new ArrayList<HComponent>();
        
        for (String var : m.keySet()) {
        	 List<HComponent> innerCs = m.get(var);
        	 cupdate.addAll(innerCs);
        	 HComponent cVar = ((List<HComponent>)innerCs).get(0) ;
        	 if (cVar.getSupplier()==null) // Só pode alterar se for filho direto da configuração ...
        		 this.newVarNameDialog.addVarName(new Pair<String,List<HComponent>>(var,innerCs));
        }
        this.newVarNameDialog.show();
                
        for (HComponent c : cupdate) {
        	c.forceUpdateName();
        }
        
        c.adviceChangeParameterName();

        return;
	}
	
    	
	public boolean canExecute() {
		return true;
	}

}

