package hPE.core.library;

import hPE.HPEPlugin;
import hPE.core.library.model.classes.HPEComponentLibrary;
import hPE.core.library.model.classes.HPEComponentLibraryItem;
import hPE.core.library.model.classes.LComponentView;
import hPE.frontend.backend.locations.Location;
import hPE.frontend.base.model.HPackage;
import hPE.frontend.core.locations.LocationManager;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.eclipse.core.runtime.Preferences.IPropertyChangeListener;
import org.eclipse.core.runtime.Preferences.PropertyChangeEvent;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
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

/**
 * Insert the type's description here.
 * 
 * @see ViewPart
 */
public class HPEComponentLibraryView extends ViewPart implements
		IPropertyChangeListener {

	private static HPEComponentLibraryView last;

	public static String PROPERTY_LOCATION_CHANGED = "PROPERTY_LOCATION_CHANGED";

	protected TreeViewer treeViewer;

	protected Text text;

	protected HPEComponentLibraryLabelProvider labelProvider;

	protected HPEComponentLibrary root;

	private Action refreshAction;

	private Action viewObsoleteAction;

	private boolean dragDetected;

	private Listener dragDetectListener;

	protected LocationManager manager;

	private boolean showObsolete = false;

	/**
	 * The constructor.
	 */
	public HPEComponentLibraryView() {
		last = this;
		root = new HPEComponentLibrary();
		manager = LocationManager.getInstance();
	}

	/*
	 * @see IWorkbenchPart#createPartControl(Composite)
	 */
	public void createPartControl(Composite parent) {
		/*
		 * Create a grid layout object so the text and treeviewer are layed out
		 * the way I want.
		 */
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.verticalSpacing = 2;
		layout.marginWidth = 0;
		layout.marginHeight = 2;
		parent.setLayout(layout);

		/*
		 * Create a "label" to display information in. I'm using a text field
		 * instead of a lable so you can copy-paste out of it.
		 */
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
		createActions();
		createMenus();
		createToolbar();
		hookListeners();
		initDragAndDrop();

		HPEPlugin plugin = HPEPlugin.getDefault();
		plugin.addPropertyChangeListener(this);

		// nao vai mais mostrar tudo de in’cio.
		treeViewer.setInput(root);
	}

	protected void hookListeners() {

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				// if the selection is empty clear the label
				if (event.getSelection().isEmpty()) {
					text.setText("");
					return;
				}
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) event
							.getSelection();
					StringBuffer toShow = new StringBuffer();
					for (Iterator iterator = selection.iterator(); iterator
							.hasNext();) {
						HPEComponentLibraryItem domain = (HPEComponentLibraryItem) iterator
								.next();
						if (domain instanceof LComponentView) {
							LComponentView cView = (LComponentView) domain;
							String value = cView.getName(); // domain.getSystemLocation();
							toShow.append(value);
							toShow.append(", ");
						}
					}
					// remove the trailing comma space pair
					if (toShow.length() > 0) {
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

		TreeViewer viewer = getTreeViewer();
		if (viewer.isExpandable(element)) {
			viewer.setExpandedState(element, !viewer.getExpandedState(element));
		}

	}

	protected void createActions() {
		refreshAction = new Action("Refresh") {
			public void run() {
				updateView();
			}
		};

		viewObsoleteAction = new Action("Show obsolete") {
			public void run() {
				showObsolete = !showObsolete;
				viewObsoleteAction.setChecked(showObsolete);
				updateView();
			}
		};

		refreshAction.setChecked(false);
		viewObsoleteAction.setChecked(false);
	}

	/**
	 * Add a new book to the selected moving box. If a moving box is not
	 * selected, use the selected obect's moving box.
	 * 
	 * If nothing is selected add to the root.
	 */
	protected void addNewBook() {
		/*
		 * MovingBox receivingBox; if (treeViewer.getSelection().isEmpty()) {
		 * receivingBox = root; } else { IStructuredSelection selection =
		 * (IStructuredSelection) treeViewer.getSelection(); Model
		 * selectedDomainObject = (Model) selection.getFirstElement(); if
		 * (!(selectedDomainObject instanceof MovingBox)) { receivingBox =
		 * selectedDomainObject.getParent(); } else { receivingBox = (MovingBox)
		 * selectedDomainObject; } } receivingBox.add(Book.newBook());
		 */
	}

	/**
	 * Remove the selected domain object(s). If multiple objects are selected
	 * remove all of them.
	 * 
	 * If nothing is selected do nothing.
	 */
	protected void removeSelected() {
		/*
		 * if (treeViewer.getSelection().isEmpty()) { return; }
		 * IStructuredSelection selection = (IStructuredSelection)
		 * treeViewer.getSelection(); /* Tell the tree to not redraw until we
		 * finish removing all the selected children.
		 */
		/*
		 * treeViewer.getTree().setRedraw(false); for (Iterator iterator =
		 * selection.iterator(); iterator.hasNext();) { Model model = (Model)
		 * iterator.next(); MovingBox parent = model.getParent();
		 * parent.remove(model); } treeViewer.getTree().setRedraw(true);
		 */
	}

	protected void createMenus() {
		IMenuManager rootMenuManager = getViewSite().getActionBars()
				.getMenuManager();
		rootMenuManager.setRemoveAllWhenShown(true);
		rootMenuManager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager mgr) {
				fillMenu(mgr);
			}
		});
		fillMenu(rootMenuManager);
	}

	protected void fillMenu(IMenuManager rootMenuManager) {
		rootMenuManager.add(refreshAction);
		rootMenuManager.add(viewObsoleteAction);
	}

	protected void updateSorter(Action action) {
		/*
		 * if(action == booksBoxesGamesAction) {
		 * noArticleAction.setChecked(!booksBoxesGamesAction.isChecked());
		 * if(action.isChecked()) { treeViewer.setSorter(booksBoxesGamesSorter);
		 * } else { treeViewer.setSorter(null); } } else if(action ==
		 * noArticleAction) {
		 * booksBoxesGamesAction.setChecked(!noArticleAction.isChecked());
		 * if(action.isChecked()) { treeViewer.setSorter(noArticleSorter); }
		 * else { treeViewer.setSorter(null); } }
		 */

	}

	/* Multiple filters can be enabled at a time. */
	protected void updateFilter(Action action) {
		/*
		 * if(action == atLeatThreeItems) { if(action.isChecked()) {
		 * treeViewer.addFilter(atLeastThreeFilter); } else {
		 * treeViewer.removeFilter(atLeastThreeFilter); } } else if(action ==
		 * onlyBoardGamesAction) { if(action.isChecked()) {
		 * treeViewer.addFilter(onlyBoardGamesFilter); } else {
		 * treeViewer.removeFilter(onlyBoardGamesFilter); } }
		 */
	}

	protected void createToolbar() {
		// IToolBarManager toolbarManager = getViewSite().getActionBars()
		// .getToolBarManager();
		// toolbarManager.add(addLocationAction);
		// toolbarManager.add(removeAction);
	}

	/*
	 * @see IWorkbenchPart#setFocus()
	 */
	public void setFocus() {
	}

	/**
	 * Adds drag and drop support to the navigator.
	 * 
	 * @since 2.0
	 */
	protected void initDragAndDrop() {
		int ops = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] transfers = new Transfer[] { TextTransfer.getInstance(),
				LocalSelectionTransfer.getInstance(),
				ResourceTransfer.getInstance(), FileTransfer.getInstance(),
				PluginTransfer.getInstance() };
		TreeViewer viewer = getTreeViewer();
		viewer.addDragSupport(ops, transfers, new HPELibraryDragSourceAdapter(
				viewer));
		// HPELibraryDropTargetAdapter adapter = new
		// HPELibraryDropTargetAdapter(viewer);
		// adapter.setFeedbackEnabled(false);
		// viewer.addDropSupport(ops | DND.DROP_DEFAULT, transfers, adapter);
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

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(PROPERTY_LOCATION_CHANGED)) {
			this.updateView();
		}
	}

	public static HPEComponentLibraryView getLast() {
		return last;
	}

	public void showLocation(Location location) {
		List<HPackage> list;
		try {
			list = manager.fetchPackagesFromLocation(location, showObsolete);
			root.showPackages(list, location, showObsolete);

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} finally {
			updateTreeView();
		}
	}

	private void updateTreeView() {
		treeViewer.getControl().getDisplay().syncExec(new Runnable() {
			public void run() {
				treeViewer.refresh();
				refreshAction.setChecked(false);
				treeViewer.expandToLevel(2);
			}
		});

	}

	public void updateView() {
		root.clearChildren();

		Collection<Location> locations = manager.getConnectedLocations();

		for (Location l : locations) {
			showLocation(l);
		}

		updateTreeView();
	}
}
