package hPE.frontend.base.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;


public class LiftReplicatorCommand extends Command {

	private HLinkToReplicator link;
		
	public LiftReplicatorCommand(HLinkToReplicator link) {
		super();
		this.link = link;
	}

	public void execute() {
		
        link.liftReplicator();
		
		return;
	}
	
	public void undo () {

	}
	
	public void redo () {

	}
	
	public boolean canExecute() {
		return true;
	}

}
