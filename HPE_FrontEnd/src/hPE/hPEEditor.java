package hPE;



import hPE.frontend.ConfigurationEditPartFactory;
import hPE.frontend.NAntBuilder;
import hPE.frontend.base.actions.AddReferencesAction;
import hPE.frontend.base.actions.BrowseAction;
import hPE.frontend.base.actions.BuildInterfaceFromSlicesAction;
import hPE.frontend.base.actions.ChangeColorAction;
import hPE.frontend.base.actions.ChangeVariableNameAction;
import hPE.frontend.base.actions.DeployAction;
import hPE.frontend.base.actions.DetachInterfaceAction;
import hPE.frontend.base.actions.ExposedAction;
import hPE.frontend.base.actions.FuseComponentsAction;
import hPE.frontend.base.actions.FuseReplicatorAction;
import hPE.frontend.base.actions.ImplementsAction;
import hPE.frontend.base.actions.InheritFromAction;
import hPE.frontend.base.actions.JoinReplicatorAction;
import hPE.frontend.base.actions.LiftReplicatorAction;
import hPE.frontend.base.actions.LiftUnitAction;
import hPE.frontend.base.actions.NewVersionAction;
import hPE.frontend.base.actions.OpenSourceAction;
import hPE.frontend.base.actions.RegisterComponentAction;
import hPE.frontend.base.actions.SetParameterAction;
import hPE.frontend.base.actions.SetPermutationAction;
import hPE.frontend.base.actions.SetRecursiveAction;
import hPE.frontend.base.actions.SetReplicatorFactorAction;
import hPE.frontend.base.actions.SetSliceNameAction;
import hPE.frontend.base.actions.ShowInterfaceAction;
import hPE.frontend.base.actions.SplitReplicatorAction;
import hPE.frontend.base.actions.SupplyParameterAction;
import hPE.frontend.base.actions.UnbindAction;
import hPE.frontend.base.actions.UnfuseReplicatorAction;
import hPE.frontend.base.actions.UnsetReplicatorAction;
import hPE.frontend.base.dialogs.BrowseAndRunBackEndDialog;
import hPE.frontend.base.dnd.FileTransferDropTargetListener;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.kinds.activate.actions.AltAbsorbtionAction;
import hPE.frontend.kinds.activate.actions.CombineActionsAction;
import hPE.frontend.kinds.activate.actions.CutBranchAction;
import hPE.frontend.kinds.activate.actions.EditProtocolAction;
import hPE.frontend.kinds.activate.actions.InterleaveActionsAction;
import hPE.frontend.kinds.activate.actions.LiftActionAction;
import hPE.frontend.kinds.activate.actions.RepeatFusionAction;
import hPE.frontend.kinds.activate.actions.SetNestingFactorAction;
import hPE.frontend.kinds.activate.actions.SetPrivateUnitAction;
import hPE.frontend.kinds.activate.actions.UnfoldActionAction;
import hPE.frontend.kinds.activate.actions.UnnestActionAction;
import hPE.frontend.kinds.activate.model.HActivateConfiguration;
import hPE.frontend.kinds.application.actions.DeployApplicationAction;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.xml.component.ComponentType;
import hPE.xml.factory.HComponentFactory;
import hPE.xml.factory.HComponentFactoryImpl;
import hPE.xml.factory.HPEInvalidComponentResourceException;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedRefInnerException;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedSliceNamesException;
import hPE.xml.factory.HComponentFactoryImpl.UndefinedRefInnerException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.requests.SimpleFactory;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.CopyTemplateAction;
import org.eclipse.gef.ui.actions.DeleteAction;
import org.eclipse.gef.ui.actions.EditorPartAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.RedoAction;
import org.eclipse.gef.ui.actions.SaveAction;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.gef.ui.actions.StackAction;
import org.eclipse.gef.ui.actions.UndoAction;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gef.ui.palette.PaletteViewerProvider;
import org.eclipse.gef.ui.parts.GraphicalEditorWithPalette;
import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.MultiPageEditorSite;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetPage;


public class hPEEditor extends GraphicalEditorWithPalette {

	private DefaultEditDomain editDomain;
	private boolean isDirty;
	
	public hPEEditor() {
		super();		
	}
		
	private HComponent configuration = null; 
	
	public static HPEVersionEditor currentEditor = null;
	
	protected void initializeGraphicalViewer() {
		
		getGraphicalViewer().setEditPartFactory(getEditPartFactory());
		getGraphicalViewer().setContents(configuration);
		
		getGraphicalViewer().addDropTargetListener(new FileTransferDropTargetListener(getGraphicalViewer()));
		getSite().getPage().addPartListener(new IPartListener() {

			@Override
			public void partActivated(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				if (part instanceof HPEVersionEditor) {
				   currentEditor = (HPEVersionEditor) part;
				} else {
					currentEditor = null;
				}
				
				BrowseAndRunBackEndDialog.changeWindowName();
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void partClosed(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void partOpened(IWorkbenchPart part) {
				// TODO Auto-generated method stub
				
			}});
		
	}
	
	protected PaletteViewerProvider createPaletteViewerProvider() {
		return new PaletteViewerProvider(getEditDomain()) {
			private IMenuListener menuListener;
			protected void configurePaletteViewer(PaletteViewer viewer) {
				super.configurePaletteViewer(viewer);
				viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer));
			}
			protected void hookPaletteViewer(PaletteViewer viewer) {
				super.hookPaletteViewer(viewer);
				final CopyTemplateAction copy = (CopyTemplateAction)getActionRegistry()
						.getAction(ActionFactory.COPY.getId());
				viewer.addSelectionChangedListener(copy);
				if (menuListener == null)
					menuListener = new IMenuListener() {
						public void menuAboutToShow(IMenuManager manager) {
							manager.appendToGroup(GEFActionConstants.GROUP_COPY, copy);
						}
					};
				viewer.getContextMenu().addMenuListener(menuListener);
			}
		};
	}
	
	protected void configureGraphicalViewer() 
	{
		super.configureGraphicalViewer();
		
		GraphicalViewer viewer = getGraphicalViewer(); 
		
		viewer.getControl().setBackground(ColorConstants.listBackground);
		viewer.setRootEditPart(new ScalableFreeformRootEditPart());
		viewer.setKeyHandler(new GraphicalViewerKeyHandler(viewer));
		
		// configure the context menu provider
		ContextMenuProvider cmProvider = new hPEEditorContextMenuProvider(viewer, getActionRegistry(),configuration);
		viewer.setContextMenu(cmProvider);
		getSite().registerContextMenu(cmProvider, viewer);
		
	//	ActionBarContributor abContributor = new HPEEditorActionBarContributor();
		
		
		
	}
	
	protected Object getContent()
	{
		// todo return your model here
		return configuration;
	}
	
	protected EditPartFactory getEditPartFactory()
	{
		// todo return your EditPartFactory
		return new ConfigurationEditPartFactory();
	}
	
	
	public DefaultEditDomain getEditDomain()
	{
		if (editDomain == null)	editDomain = new DefaultEditDomain(this);
		return editDomain;		
		
	}
	
	
	private void createOutputStream(OutputStream os) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(getModel());
		oos.close();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	
	private HComponentFactory factory = HComponentFactory.eInstance;
	
	public void doSave(IProgressMonitor monitor) {
	    try {
		HComponent c = getModel();
		IFile file = ((IFileEditorInput) getEditorInput()).getFile();
		
		java.io.File file2 = new File(file.getLocation().toString());
		    
		factory.saveComponent(c,file2,monitor);
	    
// comment: build.xml is always built before "build project".			
		// NAntBuilder builder = NAntBuilder.instance;
   	    // builder.setComponent(c);
		// builder.setMonitor(monitor);
		// (new Thread(builder)).start();
	      getCommandStack().markSaveLocation();			
		} catch (UndefinedRefInnerException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "Saving Error",JOptionPane.ERROR_MESSAGE);
		} catch (DuplicatedRefInnerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Saving Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (DuplicatedSliceNamesException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Saving Error",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}	
	}
	
	

	public HComponent getModel() {
		
		return configuration;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.ISaveablePart#doSaveAs()
	 */
	public void doSaveAs() {
		// Show a SaveAs dialog
		Shell shell = getSite().getWorkbenchWindow().getShell();
		SaveAsDialog dialog = new SaveAsDialog(shell);
		dialog.setOriginalFile(((IFileEditorInput) getEditorInput()).getFile());
		dialog.open();
		
		IPath path = dialog.getResult();	
		if (path != null) {
			// try to save the editor's contents under a different file name
			final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			//final java.io.File file = HComponentFactoryImpl.getFileInWorkspace(path);
			try {
				new ProgressMonitorDialog(shell).run(
						false, // don't fork
						false, // not cancelable
						new WorkspaceModifyOperation() { // run this operation
							public void execute(final IProgressMonitor monitor) {
								try {
									ByteArrayOutputStream out = new ByteArrayOutputStream();
									createOutputStream(out);
									file.create(
										new ByteArrayInputStream(out.toByteArray()), // contents
										true, // keep saving, even if IFile is out of sync with the Workspace
										monitor); // progress monitor
								} catch (CoreException ce) {
									ce.printStackTrace();
								} catch (IOException ioe) {
									ioe.printStackTrace();
								} 
							}
						});
				// set input to the new file
				setInput(new FileEditorInput(file));
				getCommandStack().markSaveLocation();
			} catch (InterruptedException ie) {
	  			// should not happen, since the monitor dialog is not cancelable
				ie.printStackTrace(); 
			} catch (InvocationTargetException ite) { 
				ite.printStackTrace(); 
			}
		}
	}

	public boolean isSaveAsAllowed() {
		return false;		
	}
	
	
	
	public boolean isDirty ()
	{
		return isDirty;
	}
	
	protected void setDirty (boolean dirty)
	{
	  if (isDirty != dirty)
	  {
		  isDirty = dirty;
		  firePropertyChange(IEditorPart.PROP_DIRTY);
	  }
	}
	
	public CommandStack getCommandStack()
	{
		return getEditDomain().getCommandStack();
	}
	
	
	
	
	
public void init(IEditorSite site, IEditorInput input) throws PartInitException
	{
	    //store site and input
		setSite(site);	
		setInput(input);
		
		// add CommandStackListener
		getCommandStack().addCommandStackListener(getCommandStackListener());
		
	    // add selection change listener
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(this); 
		
		ActionRegistry registry = getActionRegistry();
		IActionBars bars = site.getActionBars();
		
		String id = ActionFactory.UNDO.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.REDO.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ActionFactory.DELETE.getId();
		bars.setGlobalActionHandler(id, registry.getAction(id));

		
		if (configuration instanceof HActivateConfiguration) {
			
//			bars.setGlobalActionHandler(id, registry.getAction(id));		
			id = EditProtocolAction.SHOW_PROTOCOL;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = EditProtocolAction.HIDE_PROTOCOL;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = SetNestingFactorAction.INCREMENT_NF;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = SetNestingFactorAction.DECREMENT_NF;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = UnfoldActionAction.UNFOLD_ACTION;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = UnfoldActionAction.FOLD_ACTION;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = LiftActionAction.LIFT_ACTION;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = CombineActionsAction.SEQ_ACTIONS;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = CombineActionsAction.PAR_ACTIONS;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = UnnestActionAction.UNNEST_ACTION;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = InterleaveActionsAction.INTERLEAVE_ACTIONS;
			bars.setGlobalActionHandler(id, registry.getAction(id));		
			id = CutBranchAction.CUT_BRANCH;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = AltAbsorbtionAction.ALT_ABSORPTION;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = RepeatFusionAction.REPEAT_FUSION;
			bars.setGlobalActionHandler(id, registry.getAction(id));
			id = DeployApplicationAction.DEPLOY_APPLICATION;
			bars.setGlobalActionHandler(id, registry.getAction(id));

		}
		else if (configuration instanceof HDataComponent) {
			

		}
		
		//id = DeployAction.DEPLOY;
		//bars.setGlobalActionHandler(id, registry.getAction(id));
		id = BrowseAction.BROWSE;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = FuseComponentsAction.FUSE_COMPONENTS;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ExposedAction.EXPOSED;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = FuseReplicatorAction.FUSE_REPLICATOR;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SetPermutationAction.SET_PERMUTATION;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = LiftReplicatorAction.LIFT_REPLICATOR;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SetReplicatorFactorAction.SET_REPLICATOR_FACTOR;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = UnfuseReplicatorAction.UNFUSE_REPLICATOR;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SetPrivateUnitAction.SET_PRIVATE_UNIT;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SetPrivateUnitAction.SET_PUBLIC_UNIT;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SupplyParameterAction.SUPPLY_PARAMETER;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SetSliceNameAction.SET_SLICE_NAME;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SetParameterAction.SET_PARAMETER;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SetParameterAction.UNSET_PARAMETER;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = UnbindAction.UNBIND;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = BuildInterfaceFromSlicesAction.CREATE_INTERFACE_FROM_SLICE;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = DetachInterfaceAction.DETACH_INTERFACE;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ShowInterfaceAction.SHOW_INTERFACE;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ShowInterfaceAction.HIDE_INTERFACE;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = UnsetReplicatorAction.UNSET_REPLICATOR;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SplitReplicatorAction.SPLIT_REPLICATOR;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = JoinReplicatorAction.JOIN_REPLICATOR;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ChangeColorAction.CHANGE_COLOR;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ChangeVariableNameAction.CHANGE_VARIABLE_NAME;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = InheritFromAction.INHERIT_FROM;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = LiftUnitAction.LIFT_UNIT;
		bars.setGlobalActionHandler(id, registry.getAction(id));
//		id = OpenSliceAction.OPEN_SLICE;
//		bars.setGlobalActionHandler(id, registry.getAction(id));
//		id = OpenSliceAction.CLOSE_SLICE;
//		bars.setGlobalActionHandler(id, registry.getAction(id));		
		id = OpenSourceAction.EDIT_SOURCE;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = AddReferencesAction.ADD_REFERENCES;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = SetRecursiveAction.SET_RECURSIVE;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = ImplementsAction.IMPLEMENTS;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = NewVersionAction.NEW_VERSION;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		id = RegisterComponentAction.REGISTER_COMPONENT;
		bars.setGlobalActionHandler(id, registry.getAction(id));
		
		bars.updateActionBars();
		
		// initializes actions
		createActions();
		

		
	}
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// If not the active editor, ignore selection changed.
		
		HPEVersionEditor e = (HPEVersionEditor) ((MultiPageEditorSite) this.getSite()).getMultiPageEditor();
		if (e.equals(getSite().getPage().getActiveEditor()))
			updateActions(this.getSelectionActions());
	}


	protected void createActions()
	{
		super.createActions();
		
		addStackAction(new UndoAction(this));
		addStackAction(new RedoAction(this));
		
		addEditPartAction(new DeleteAction((IWorkbenchPart) this));
		
		addEditorAction(new SaveAction(this));
		
		SelectionAction action;
		ActionRegistry registry = getActionRegistry();

		if (configuration instanceof HActivateConfiguration) {
						
			action = new EditProtocolAction(this,true);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new EditProtocolAction(this,false);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new SetNestingFactorAction(this,true);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new SetNestingFactorAction(this,false);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new UnfoldActionAction(this,false);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new UnfoldActionAction(this,true);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new LiftActionAction(this);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new CombineActionsAction(this,CombineActionsAction.PAR_ACTIONS_REQUEST);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new CombineActionsAction(this,CombineActionsAction.SEQ_ACTIONS_REQUEST);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new UnnestActionAction(this);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new InterleaveActionsAction(this);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new CutBranchAction(this);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new AltAbsorbtionAction(this);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new RepeatFusionAction(this);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
			
			action = new DeployApplicationAction(this);
			registry.registerAction(action);
			getSelectionActions().add(action.getId());
		}
		else if (configuration instanceof HDataComponent) {
			
			
		}
		
		//action = new DeployAction(this);
		//registry.registerAction(action);
		//getSelectionActions().add(action.getId());

		action = new BrowseAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		action = new FuseComponentsAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		action = new ExposedAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());


		action = new FuseReplicatorAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SetPermutationAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		action = new LiftReplicatorAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SetReplicatorFactorAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new UnfuseReplicatorAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SetPrivateUnitAction(this,true);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SetPrivateUnitAction(this,false);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SupplyParameterAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SetSliceNameAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SetParameterAction(this,true);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SetParameterAction(this,false);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new UnbindAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new BuildInterfaceFromSlicesAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		action = new DetachInterfaceAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		action = new ShowInterfaceAction(this,true);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new ShowInterfaceAction(this,false);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new UnsetReplicatorAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new SplitReplicatorAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new JoinReplicatorAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new ChangeColorAction(this,new ColorDialog(getSite().getWorkbenchWindow().getShell()));
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new ChangeVariableNameAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new InheritFromAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new LiftUnitAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
//		action = new OpenSliceAction(this,true);
//		registry.registerAction(action);
//		getSelectionActions().add(action.getId());
		
//		action = new OpenSliceAction(this,false);
//		registry.registerAction(action);
//		getSelectionActions().add(action.getId());
		
		action = new OpenSourceAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
				
		action = new AddReferencesAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		action = new SetRecursiveAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());

		action = new ImplementsAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new NewVersionAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
		
		action = new RegisterComponentAction(this);
		registry.registerAction(action);
		getSelectionActions().add(action.getId());
	}
	
	public void dispose()
	{
		// remove CommandStackListener
		getCommandStack().removeCommandStackListener(getCommandStackListener());
		
	    // remove selection listener
		getSite().getWorkbenchWindow().getSelectionService().removeSelectionListener(this); 
		
		// disposy the Action Registry (will dispose all actions)
		getActionRegistry().dispose();
		
		// important: always call super implementation of dispose
		super.dispose();	
	}
	
	public Object getAdapter(Class adapter)
	{
	    // we need to handle common GEF elements we created
		if (adapter == GraphicalViewer.class || adapter == EditPartViewer.class)
		    return getGraphicalViewer();
		else if (adapter == CommandStack.class)
		     return getCommandStack();
		else if (adapter == EditDomain.class)
		     return getEditDomain();
		else if (adapter == ActionRegistry.class)
			 return getActionRegistry();
		else if (adapter == IPropertySheetPage.class)
			return getPropertySheetPage();
		
	    // the super implementation handles the rest
		return super.getAdapter(adapter);	
	}
	
	private PropertySheetPage undoablePropertySheetPage;
	
	protected PropertySheetPage getPropertySheetPage()
	{
		if (null == undoablePropertySheetPage)
		{
			undoablePropertySheetPage = new PropertySheetPage();
			undoablePropertySheetPage.setRootEntry(
			new UndoablePropertySheetEntry(getCommandStack()));	
						
		}
		return undoablePropertySheetPage;
	}
	
	
	protected void initializePaletteViewer() {
		 setEditDomain(getEditDomain());
	}
	
	public void createPartControl(Composite parent)
	{
	    SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL);
	    createPaletteViewer(sashForm);
	    createGraphicalViewer(sashForm);
	    sashForm.setWeights(new int[] {30,70});
	}
	
	private PaletteRoot paletteRoot;
	
	protected PaletteRoot getPaletteRoot()
	{
	if (null == paletteRoot)
	{
		// create root
		paletteRoot = new PaletteRoot();
		List categories = new ArrayList();
		
		// a group of default control tools
		PaletteGroup controls = new PaletteGroup("Controls");
		
		// the selection tool
		ToolEntry tool = new SelectionToolEntry();		
		controls.add(tool);
		
		
		// use selection tool as default entry
		paletteRoot.setDefaultEntry(tool);
		
		// the marquee selection tool
		MarqueeToolEntry m = new MarqueeToolEntry(); 
		controls.add(m);
		
		// a separator
		PaletteSeparator separator = new PaletteSeparator("palette.separator");
		separator.setUserModificationPermission(PaletteEntry.PERMISSION_NO_MODIFICATION);
		controls.add(separator);
		
		// a tool for creating connection
		controls.add(
			new ConnectionCreationToolEntry(
			"Connections",
			"Create Connections",
			new CreationFactory() {
				public Object getNewObject() { return null; }
				// see ShapeEditPart#createEditPolicies() 
				// this is abused to transmit the desired line style 
				public Object getObjectType() { return null; }
			},
			ImageDescriptor.createFromFile(getClass(), "util/icons/connection16.gif"),
			ImageDescriptor.createFromFile(getClass(), "util/icons/connection24.gif")
			)
		);
		
		// todo add your palette drawers and entries here

		PaletteDrawer componentsDrawer = new PaletteDrawer("Configuration Elements");

		CombinedTemplateCreationEntry component = new CombinedTemplateCreationEntry(
				"Unit",
				"Create a unit", 
				HUnit.class,
				new SimpleFactory(HUnit.class), 
				ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/rectangle16.gif"), 
				ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/rectangle24.gif"));
		componentsDrawer.add(component);		

		component = new CombinedTemplateCreationEntry(
				"Enumerator",
				"Create an enumerator", 
				HReplicator.class,
				new SimpleFactory(HReplicator.class), 
				ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/port.gif"), 
				ImageDescriptor.createFromFile(HPEPlugin.class, "util/icons/port.gif"));
		componentsDrawer.add(component);		
		
		
		categories.add(controls);
		categories.add(componentsDrawer);
		
		// add all categroies to root
		paletteRoot.addAll(categories);
	}
	return paletteRoot;
	}
	
	private List editPartActionIDs = new ArrayList();
	private List stackActionIDs    = new ArrayList();
	private List editorActionIDs   = new ArrayList();
	
	protected void addEditPartAction(SelectionAction action)
	{
		getActionRegistry().registerAction(action);
		editPartActionIDs.add(action.getId());
	}
	
	protected void addStackAction(StackAction action)
	{
		getActionRegistry().registerAction(action);
		stackActionIDs.add(action.getId());
	}
	
	
	protected void addEditorAction(EditorPartAction action)
	{
		getActionRegistry().registerAction(action);
		editorActionIDs.add(action.getId());
	}
	
	protected void addAction(IAction action)
	{
		getActionRegistry().registerAction(action);
	}
		
	
	private CommandStackListener commandStackListener = new CommandStackListener()
	{
		public void commandStackChanged(EventObject event)
		{
			updateActions(stackActionIDs);
			setDirty(getCommandStack().isDirty());
		}
	};
	
	protected CommandStackListener getCommandStackListener()
	{
		return commandStackListener;
	}
	
	protected void createPaletteViewer(Composite parent)
	{
		
		//	 create graphical viewer		
		PaletteViewer viewer = new PaletteViewer();
		viewer.createControl(parent);
		
		//	 hook the viewer into the EditDomain (only one palette per EditDomain)
		getEditDomain().setPaletteViewer(viewer);
		
		//	 important: the palette is initialized via EditDomain
		getEditDomain().setPaletteRoot(getPaletteRoot());
		
	}	


	public static HComponent getConfiguration(URI uri) {
		
		HComponent c = null;
				
		try {
			c = HComponentFactoryImpl.eInstance.loadComponent(uri,true, false, false, false, true);
		} catch (HPEInvalidComponentResourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

		return c;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
	 */
	protected void setInput(IEditorInput input) {
		super.setInput(input);
		IFile file = ((IFileEditorInput) input).getFile();
		URI uri = URI.createURI(file.getFullPath().makeRelative().toPortableString());
		configuration = getConfiguration(uri);
		setPartName(file.getName());
	}
	
	private void handleLoadException(Exception e) {
		
		System.err.println("** Load failed. Using default configuration. **");
		e.printStackTrace();
		
	    configuration = new HDataComponent("New Configuration", null,null);
	}


	
	
}


