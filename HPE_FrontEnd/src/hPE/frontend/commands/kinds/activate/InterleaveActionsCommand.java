package hPE.frontend.commands.kinds.activate;

import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HAltAction;
import hPE.model.protocol.kinds.activate.HCombinatorAction;
import hPE.model.protocol.kinds.activate.HParAction;
import hPE.model.protocol.kinds.activate.HSeqAction;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.EditPart;

public class InterleaveActionsCommand  extends Command{

HAction model;
HAltAction alt_model;

public InterleaveActionsCommand(HAction model){

  this.model = model;

}

List other_models_copies = new ArrayList();

HAction undo_top_action = null;
HAction redo_top_action = null;


public void setTopActionCopy(HAction top_action) {
	this.undo_top_action = top_action;
}

public void execute(){

	
   HSeqAction seq_model = (HSeqAction) model.getActionCombinator();
   HParAction par_model = (HParAction) seq_model.getActionCombinator();
   

   par_model.removeAction(seq_model);
   
   HSeqAction seq_model_copy_1 = (HSeqAction) seq_model.getCopy(alt_model);
   Iterator as = ((ArrayList)((ArrayList)seq_model_copy_1.getActions()).clone()).iterator();
   as.next();
   while (as.hasNext()) {
	   HAction a = (HAction) as.next();
	   seq_model_copy_1.removeAction(a);   
   }
   
   
   HParAction inner_par_model = new HParAction(null,seq_model_copy_1);
   
   HSeqAction seq_model_copy_2 = (HSeqAction) seq_model.getCopy(inner_par_model);
   if (seq_model_copy_2.getActions().size() > 1) {
      inner_par_model.addAction(seq_model_copy_2);
      seq_model_copy_2.removeAction((HAction)seq_model_copy_2.getActions().get(0));
   }

   
   inner_par_model.addAction(this.getOtherModelsCopies(inner_par_model));
   
   alt_model.addAction(seq_model_copy_1);   

   par_model.organizeAction();

   redo_top_action = alt_model.getTopActionCopy();

   
}

public void setOtherModels(List parts) {
	
	this.parts = parts;
	
}

public List getOtherModelsCopies(HParAction inner_par_action) {
	
	ArrayList r = new ArrayList(); 
	
	Iterator ps = parts.iterator();
	while (ps.hasNext()) {		
		HAction a = (HAction) ((EditPart) ps.next()).getModel();
		if (a!=model) {
		   HSeqAction seq_of_a = (HSeqAction) a.getActionCombinator();
	       r.add(seq_of_a.getCopy(inner_par_action));
		}
	}
	
	return r;
	
}


private List parts;

public void undo(){

	
 if (undo_top_action != null) { 
  	 undo_top_action.getProtocol().setAction(undo_top_action);
 }
	
}

public void redo(){
	
 if (redo_top_action != null) { 
  	 redo_top_action.getProtocol().setAction(redo_top_action);
 }
	 
}

public void setAltCombinator(HAltAction alt_action) {
	
	this.alt_model = alt_action;
	
}

}
