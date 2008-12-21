package hPE;

import hPE.frontend.actions.base.BuildInterfaceFromSlicesAction;
import hPE.frontend.actions.base.ChangeColorAction;
import hPE.frontend.actions.base.ChangeVariableNameAction;
import hPE.frontend.actions.base.DeployAction;
import hPE.frontend.actions.base.DetachInterfaceAction;
import hPE.frontend.actions.base.ExposedAction;
import hPE.frontend.actions.base.FuseComponentsAction;
import hPE.frontend.actions.base.FuseReplicatorAction;
import hPE.frontend.actions.base.ImplementsAction;
import hPE.frontend.actions.base.InheritFromAction;
import hPE.frontend.actions.base.JoinReplicatorAction;
import hPE.frontend.actions.base.LiftReplicatorAction;
import hPE.frontend.actions.base.LiftUnitAction;
import hPE.frontend.actions.base.OpenSourceAction;
import hPE.frontend.actions.base.SetParameterAction;
import hPE.frontend.actions.base.SetRecursiveAction;
import hPE.frontend.actions.base.SetReplicatorFactorAction;
import hPE.frontend.actions.base.SetSliceNameAction;
import hPE.frontend.actions.base.ShowInterfaceAction;
import hPE.frontend.actions.base.SplitReplicatorAction;
import hPE.frontend.actions.base.SupplyParameterAction;
import hPE.frontend.actions.base.UnbindAction;
import hPE.frontend.actions.base.UnfuseReplicatorAction;
import hPE.frontend.actions.base.UnsetReplicatorAction;
import hPE.frontend.actions.kinds.activate.AltAbsorbtionAction;
import hPE.frontend.actions.kinds.activate.CombineActionsAction;
import hPE.frontend.actions.kinds.activate.CutBranchAction;
import hPE.frontend.actions.kinds.activate.EditProtocolAction;
import hPE.frontend.actions.kinds.activate.InterleaveActionsAction;
import hPE.frontend.actions.kinds.activate.LiftActionAction;
import hPE.frontend.actions.kinds.activate.RepeatFusionAction;
import hPE.frontend.actions.kinds.activate.SetNestingFactorAction;
import hPE.frontend.actions.kinds.activate.SetPrivateUnitAction;
import hPE.frontend.actions.kinds.activate.UnfoldActionAction;
import hPE.frontend.actions.kinds.activate.UnnestActionAction;
import hPE.frontend.actions.kinds.activate.computation.application.DeployApplicationAction;
import hPE.model.interfaces.IComponent;
import hPE.model.kinds.activate.HActivateConfiguration;
import hPE.model.kinds.data.HDataComponent;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.actions.ActionFactory;

public class hPEEditorContextMenuProvider extends ContextMenuProvider {

	public hPEEditorContextMenuProvider(EditPartViewer viewer, ActionRegistry registry, IComponent configuration) {
		super(viewer);
		this.configuration = configuration;
		if (registry == null) {
			throw new IllegalArgumentException();
		}
		actionRegistry = registry;
	}
	
	/**
	 * Instantiate a new menu context provider for the specified EditPartViewer 
	 * and ActionRegistry.
	 * @param viewer	the editor's graphical viewer
	 * @param registry	the editor's action registry
	 * @throws IllegalArgumentException if registry is <tt>null</tt>. 
	 */

	/** The editor's action registry. */
	private ActionRegistry actionRegistry;
		
    IComponent configuration = null;
    
	
	/**
	 * Called when the context menu is about to show. Actions, 
	 * whose state is enabled, will appear in the context menu.
	 * @see org.eclipse.gef.ContextMenuProvider#buildContextMenu(org.eclipse.jface.action.IMenuManager)
	 */
	public void buildContextMenu(IMenuManager menu) {
		// Add standard action groups to the menu
		GEFActionConstants.addStandardActionGroups(menu);
		
		// Add actions to the menu
		menu.appendToGroup(
				GEFActionConstants.GROUP_UNDO, // target group id
				getAction(ActionFactory.UNDO.getId())); // action to add
		menu.appendToGroup(
				GEFActionConstants.GROUP_UNDO, 
				getAction(ActionFactory.REDO.getId()));
		menu.appendToGroup(
				GEFActionConstants.GROUP_EDIT,
				getAction(ActionFactory.DELETE.getId()));
		
		IAction action;

		if (configuration instanceof HActivateConfiguration) {			
			
			action = getAction(EditProtocolAction.SHOW_PROTOCOL);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(EditProtocolAction.HIDE_PROTOCOL);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(SetNestingFactorAction.INCREMENT_NF);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(SetNestingFactorAction.DECREMENT_NF);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(UnfoldActionAction.UNFOLD_ACTION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(UnfoldActionAction.FOLD_ACTION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(LiftActionAction.LIFT_ACTION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(CombineActionsAction.SEQ_ACTIONS);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(CombineActionsAction.PAR_ACTIONS);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(UnnestActionAction.UNNEST_ACTION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(InterleaveActionsAction.INTERLEAVE_ACTIONS);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(CutBranchAction.CUT_BRANCH);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(AltAbsorbtionAction.ALT_ABSORPTION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(RepeatFusionAction.REPEAT_FUSION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
						
			action = getAction(DeployApplicationAction.DEPLOY_APPLICATION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}

			
		} else if (configuration instanceof HDataComponent){
			

		}

		
		action = getAction(DeployAction.DEPLOY);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}

		action = getAction(FuseComponentsAction.FUSE_COMPONENTS);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}

		action = getAction(ExposedAction.EXPOSED);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
				
		
		action = getAction(FuseReplicatorAction.FUSE_REPLICATOR);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(LiftReplicatorAction.LIFT_REPLICATOR);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SetReplicatorFactorAction.SET_REPLICATOR_FACTOR);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(UnfuseReplicatorAction.UNFUSE_REPLICATOR);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SetPrivateUnitAction.SET_PRIVATE_UNIT);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SetPrivateUnitAction.SET_PUBLIC_UNIT);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SupplyParameterAction.SUPPLY_PARAMETER);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SetSliceNameAction.SET_SLICE_NAME);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SetParameterAction.SET_PARAMETER);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SetParameterAction.UNSET_PARAMETER);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(UnbindAction.UNBIND);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(BuildInterfaceFromSlicesAction.CREATE_INTERFACE_FROM_SLICE);
		if (action.isEnabled())	menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		action = getAction(DetachInterfaceAction.DETACH_INTERFACE);
		if (action.isEnabled())	menu.appendToGroup(GEFActionConstants.GROUP_REST, action);
		
		action = getAction(ShowInterfaceAction.SHOW_INTERFACE);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(ShowInterfaceAction.HIDE_INTERFACE);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(UnsetReplicatorAction.UNSET_REPLICATOR);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SplitReplicatorAction.SPLIT_REPLICATOR);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(JoinReplicatorAction.JOIN_REPLICATOR);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(ChangeColorAction.CHANGE_COLOR);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(ChangeVariableNameAction.CHANGE_VARIABLE_NAME);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(InheritFromAction.INHERIT_FROM);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}

		action = getAction(LiftUnitAction.LIFT_UNIT);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
//		action = getAction(OpenSliceAction.OPEN_SLICE);
//		if (action.isEnabled())	{ 
//			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
//		}
		
//		action = getAction(OpenSliceAction.CLOSE_SLICE);
//		if (action.isEnabled())	{ 
//			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
//		}
		
		action = getAction(OpenSourceAction.EDIT_SOURCE);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SetRecursiveAction.SET_RECURSIVE);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(ImplementsAction.IMPLEMENTS);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
	}

	private IAction getAction(String actionId) {
		return actionRegistry.getAction(actionId);
	}

	

}
