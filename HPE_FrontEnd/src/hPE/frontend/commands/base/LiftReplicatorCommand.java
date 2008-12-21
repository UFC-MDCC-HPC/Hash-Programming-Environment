package hPE.frontend.commands.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.gef.commands.Command;

import hPE.model.base.HComponent;
import hPE.model.base.HLinkToReplicator;
import hPE.model.base.HReplicator;
import hPE.model.base.HUnit;
import hPE.model.base.HUnitSlice;
import hPE.model.base.exceptions.HPEUnmatchingEnumeratorsException;


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
