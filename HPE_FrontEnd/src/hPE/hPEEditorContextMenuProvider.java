package hPE;

import hPE.frontend.base.actions.AddReferencesAction;
import hPE.frontend.base.actions.BrowseAction;
import hPE.frontend.base.actions.BuildInterfaceFromSlicesAction;
import hPE.frontend.base.actions.ChangeColorAction;
import hPE.frontend.base.actions.ChangeVariableNameAction;
import hPE.frontend.base.actions.CleanSourcesAction;
import hPE.frontend.base.actions.DetachInterfaceAction;
import hPE.frontend.base.actions.ExposedAction;
import hPE.frontend.base.actions.FuseComponentsAction;
import hPE.frontend.base.actions.ImplementsAction;
import hPE.frontend.base.actions.InheritFromAction;
import hPE.frontend.base.actions.LiftUnitAction;
import hPE.frontend.base.actions.NewVersionAction;
import hPE.frontend.base.actions.OpenSourceAction;
import hPE.frontend.base.actions.RegisterComponentAction;
import hPE.frontend.base.actions.SetMultipleAction;
import hPE.frontend.base.actions.SetParameterAction;
import hPE.frontend.base.actions.SetPrivateUnitAction;
import hPE.frontend.base.actions.SetRecursiveAction;
import hPE.frontend.base.actions.SetSliceNameAction;
import hPE.frontend.base.actions.ShowInterfaceAction;
import hPE.frontend.base.actions.SplitEntryAction;
import hPE.frontend.base.actions.SupplyParameterAction;
import hPE.frontend.base.actions.UnbindAction;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.kinds.activate.actions.ChangeOrderSEQProtocolAction;
import hPE.frontend.kinds.activate.actions.EditProtocolAction;
import hPE.frontend.kinds.activate.actions.NewProtocolBoxAction;
import hPE.frontend.kinds.activate.actions.NewUnitActionProtocolAction;
import hPE.frontend.kinds.activate.actions.RemoveActionProtocolAction;
import hPE.frontend.kinds.activate.actions.SetProtocolTypeAction;
import hPE.frontend.kinds.activate.actions.ToggleLoopProtocolAction;
import hPE.frontend.kinds.activate.model.HActivateComponent;
import hPE.frontend.kinds.application.actions.DeployApplicationAction;
import hPE.frontend.kinds.data.model.HDataComponent;

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

		if (configuration instanceof HActivateComponent) {			
			
			action = getAction(EditProtocolAction.SHOW_PROTOCOL);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(EditProtocolAction.HIDE_PROTOCOL);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
						
			action = getAction(NewProtocolBoxAction.NEW_PROTOCOL);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}

			action = getAction(NewUnitActionProtocolAction.NEW_UNIT_ACTION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}			
			
			action = getAction(ChangeOrderSEQProtocolAction.CHANGE_ORDER_SEQ);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(RemoveActionProtocolAction.REMOVE_ACTION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(ToggleLoopProtocolAction.TOGGLE_LOOP);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}

			action = getAction(SetProtocolTypeAction.SET_PROTOCOL_TYPE_ALT);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(SetProtocolTypeAction.SET_PROTOCOL_TYPE_PAR);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(SetProtocolTypeAction.SET_PROTOCOL_TYPE_SEQ);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(SetProtocolTypeAction.SET_PROTOCOL_TYPE_PERFORM);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}
			
			action = getAction(DeployApplicationAction.DEPLOY_APPLICATION);
			if (action.isEnabled())	{ 
				menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
			}

			
		} else if (configuration instanceof HDataComponent){
			

		}

		
	//	action = getAction(DeployAction.DEPLOY);
	//	if (action.isEnabled())	{ 
	//		menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
	//	}

		action = getAction(BrowseAction.BROWSE);
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
		
		action = getAction(CleanSourcesAction.CLEAN_SOURCES);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}

		action = getAction(AddReferencesAction.ADD_REFERENCES);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}

		action = getAction(SetRecursiveAction.SET_RECURSIVE);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(SetMultipleAction.SET_PARALLEL);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}

		action = getAction(SplitEntryAction.SPLIT_ENTRY);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}

		action = getAction(ImplementsAction.IMPLEMENTS);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(NewVersionAction.NEW_VERSION);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
		action = getAction(RegisterComponentAction.REGISTER_COMPONENT);
		if (action.isEnabled())	{ 
			menu.appendToGroup(GEFActionConstants.GROUP_REST, action);		
		}
		
	}

	private IAction getAction(String actionId) {
		return actionRegistry.getAction(actionId);
	}

	

}
