package hPE.core.library;


import hPE.core.library.model.classes.HPEComponentLibrary;
import hPE.core.library.model.classes.HPEComponentLibraryItem;
import hPE.core.library.model.classes.LComponentView;

import java.util.List;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.URLTransfer;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.PluginTransfer;
import org.eclipse.ui.part.ResourceTransfer;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;
import org.eclipse.ui.views.navigator.NavigatorDragAdapter;
import org.eclipse.ui.views.navigator.NavigatorDropAdapter;


/**
 * Insert the type's description here.
 * @see ViewPart
 */
public class HPEComponentLibraryView extends ViewPart {
	protected TreeViewer treeViewer;
	protected Text text;
	protected HPEComponentLibraryLabelProvider labelProvider;
		
	protected HPEComponentLibrary root;
	private Action refreshAction;
	private Action viewObsoleteAction;
	
	/**
	 * The constructor.
	 */
	public HPEComponentLibraryView() {
	}

	/*
	 * @see IWorkbenchPart#createPartControl(Composite)
	 */
	public void createPartControl(Composite parent) {
		/* Create a grid layout object so the text and treeviewer
		 * are layed out the way I want. */
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.verticalSpacing = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 2;
		parent.setLayout(layout);
		
		/* Create a "label" to display information in. I'm
		 * using a text field instead of a lable so you can
		 * copy-paste out of it. */
		text = new Text(parent, SWT.READ_ONLY | SWT.SINGLE | SWT.BORDER);
		// layout the text field above the treeviewer
		GridData layoutData = new GridData();
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.horizontalAlignment = GridData.FILL;
		text.setLayoutData(layoutData);
		
		// Create the tree viewer as a child of the composite parent
		treeViewer = new TreeViewer(parent);
		treeViewer.setContentProvider(new HPEComponentLibraryContentProvider());
		labelProvider = new HPEComponentLibraryLabelProvider();
		treeViewer.setLabelProvider(labelProvider);
		
		treeViewer.setUseHashlookup(true);
		
		// layout the tree viewer below the text field
		layoutData = new GridData();
		layoutData.grabExcessHorizontalSpace = true;
		layoutData.grabExcessVerticalSpace = true;
		layoutData.horizontalAlignment = GridData.FILL;
		layoutData.verticalAlignment = GridData.FILL;
		treeViewer.getControl().setLayoutData(layoutData);
		
		// Create menu, toolbars, filters, sorters.
		createFiltersAndSorters();
		createActions();
		createMenus();
		createToolbar();
		hookListeners();
        initDragAndDrop();

		
		treeViewer.setInput(getInitalInput());
		// treeViewer.expandAll();
	}
	
	protected void createFiltersAndSorters() {
/*		atLeastThreeFilter = new ThreeItemFilter();
		onlyBoardGamesFilter = new BoardgameFilter();
		booksBoxesGamesSorter = new BookBoxBoardSorter();
		noArticleSorter = new NoArticleSorter(); */
	}

	protected void hookListeners() {
				
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				// if the selection is empty clear the label
				if(event.getSelection().isEmpty()) {
					text.setText("");
					return;
				}
				if(event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection)event.getSelection();
					StringBuffer toShow = new StringBuffer();
					for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
						HPEComponentLibraryItem domain = (HPEComponentLibraryItem) iterator.next();
						if (domain instanceof LComponentView) {
							LComponentView cView = (LComponentView) domain;
							String value = cView.getName(); // domain.getSystemLocation();
							toShow.append(value);
							toShow.append(", ");
						}
					}
					// remove the trailing comma space pair
					if(toShow.length() > 0) {
						toShow.setLength(toShow.length() - 2);
					}
					text.setText(toShow.toString());
				}
			}
		});
		
        treeViewer.addDoubleClickListener(new IDoubleClickListener() {
            public void doubleClick(DoubleClickEvent event) {
                handleDoubleClick(event);
            }
        });
        treeViewer.addOpenListener(new IOpenListener() {
            public void open(OpenEvent event) {
                handleOpen(event);
            }
        });
        treeViewer.getControl().addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent event) {
                handleKeyPressed(event);
            }

            public void keyReleased(KeyEvent event) {
                handleKeyReleased(event);
            }
        });
		
	}
	
    protected void handleKeyPressed(KeyEvent event) {
    }

    protected void handleKeyReleased(KeyEvent event) {
    }
    
	
    protected void handleOpen(OpenEvent event) {
    }

    protected void handleDoubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event
                .getSelection();
        Object element = selection.getFirstElement();

        // 1GBZIA0: ITPUI:WIN2000 - Double-clicking in navigator should expand/collapse containers
        TreeViewer viewer = getTreeViewer();
        if (viewer.isExpandable(element)) {
            viewer.setExpandedState(element, !viewer.getExpandedState(element));
        }

    }

    
    protected void createActions() {
		refreshAction = new Action("Refresh") {
			public void run() {
				treeViewer.setInput(getInitalInput());
				treeViewer.refresh();
				refreshAction.setChecked(false);
				treeViewer.expandToLevel(2);
			}
		};
		
		viewObsoleteAction = new Action("Show obsolete") {
			public void run() {
		  		setShowObsolete(!getShowObsolete());
		  		viewObsoleteAction.setChecked(getShowObsolete());
				treeViewer.setInput(getInitalInput());
				treeViewer.refresh();
				treeViewer.expandToLevel(2);
			}
		};
		
		refreshAction.setChecked(false);
		viewObsoleteAction.setChecked(false);
	}
    
    private boolean showObsolete = false;
	
	private void setShowObsolete(boolean b) {
		showObsolete = b;
	}

	private boolean getShowObsolete() {
		return showObsolete;
	}
	
	/** Add a new book to the selected moving box.
	 * If a moving box is not selected, use the selected
	 * obect's moving box. 
	 * 
	 * If nothing is selected add to the root. */
	protected void addNewBook() {
		/* MovingBox receivingBox;
		if (treeViewer.getSelection().isEmpty()) {
			receivingBox = root;
		} else {
			IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
			Model selectedDomainObject = (Model) selection.getFirstElement();
			if (!(selectedDomainObject instanceof MovingBox)) {
				receivingBox = selectedDomainObject.getParent();
			} else {
				receivingBox = (MovingBox) selectedDomainObject;
			}
		}
		receivingBox.add(Book.newBook()); */
	}

	/** Remove the selected domain object(s).
	 * If multiple objects are selected remove all of them.
	 * 
	 * If nothing is selected do nothing. */
	protected void removeSelected() {
/*		if (treeViewer.getSelection().isEmpty()) {
			return;
		}
		IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
		/* Tell the tree to not redraw until we finish
		 * removing all the selected children. */
/*		treeViewer.getTree().setRedraw(false);
		for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
			Model model = (Model) iterator.next();
			MovingBox parent = model.getParent();
			parent.remove(model);
		}
		treeViewer.getTree().setRedraw(true); */
	}
	
	protected void createMenus() {
		IMenuManager rootMenuManager = getViewSite().getActionBars().getMenuManager();
		rootMenuManager.setRemoveAllWhenShown(true);
		rootMenuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				fillMenu(mgr);
			}
		});
		fillMenu(rootMenuManager);
	}


	protected void fillMenu(IMenuManager rootMenuManager) {
		//IMenuManager filterSubmenu = new MenuManager("Refresh");
		rootMenuManager.add(refreshAction);
		rootMenuManager.add(viewObsoleteAction);
		//filterSubmenu.add(refreshAction);
		
	}
	
	
	
	protected void updateSorter(Action action) {
/*		if(action == booksBoxesGamesAction) {
			noArticleAction.setChecked(!booksBoxesGamesAction.isChecked());
			if(action.isChecked()) {
				treeViewer.setSorter(booksBoxesGamesSorter);
			} else {
				treeViewer.setSorter(null);
			}
		} else if(action == noArticleAction) {
			booksBoxesGamesAction.setChecked(!noArticleAction.isChecked());
			if(action.isChecked()) {
				treeViewer.setSorter(noArticleSorter);
			} else {
				treeViewer.setSorter(null);
			}
		} */
			
	}
	
	/* Multiple filters can be enabled at a time. */
	protected void updateFilter(Action action) {
/*		if(action == atLeatThreeItems) {
			if(action.isChecked()) {
				treeViewer.addFilter(atLeastThreeFilter);
			} else {
				treeViewer.removeFilter(atLeastThreeFilter);
			}
		} else if(action == onlyBoardGamesAction) {
			if(action.isChecked()) {
				treeViewer.addFilter(onlyBoardGamesFilter);
			} else {
				treeViewer.removeFilter(onlyBoardGamesFilter);
			}
		} */
	}
	
	protected void createToolbar() {
		// IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
		// toolbarManager.add(addBookAction);
		// toolbarManager.add(removeAction);
	}
	
	
	public HPEComponentLibrary getInitalInput() {
		
		List<URI> locations;
		
		HPELocationFileTraversor locationFileTraversor = new HPELocationFileTraversor();
		
		locations = locationFileTraversor.fetchLocations();
		
		// TODO: library (getInitialInput)
		// Read machine locations, stored in a XML file whose 
		// path is pointed by a system variable HASH_LOCATIONS_FILE
		
		root = new HPEComponentLibrary(locations,getShowObsolete());
		
		return root;
	}

	/*
	 * @see IWorkbenchPart#setFocus()
	 */
	public void setFocus() {}

    private boolean dragDetected;

    private Listener dragDetectListener;
    
    /**
     * Adds drag and drop support to the navigator.
     * 
     * @since 2.0
     */
    protected void initDragAndDrop() {
        int ops = DND.DROP_COPY | DND.DROP_MOVE;
        Transfer[] transfers = new Transfer[] {
        		TextTransfer.getInstance(),
                LocalSelectionTransfer.getInstance(),
                ResourceTransfer.getInstance(), 
                FileTransfer.getInstance(),
                PluginTransfer.getInstance() 
                };
        TreeViewer viewer = getTreeViewer();
        viewer.addDragSupport(ops, transfers, new HPELibraryDragSourceAdapter(viewer));
        //HPELibraryDropTargetAdapter adapter = new HPELibraryDropTargetAdapter(viewer);
        //adapter.setFeedbackEnabled(false);
        //viewer.addDropSupport(ops | DND.DROP_DEFAULT, transfers, adapter);
        dragDetectListener = new Listener() {
            public void handleEvent(Event event) {
                dragDetected = true;
            }
        };
        viewer.getControl().addListener(SWT.DragDetect, dragDetectListener);
    }

    public TreeViewer getTreeViewer() {
        return treeViewer;
    }
    
}
