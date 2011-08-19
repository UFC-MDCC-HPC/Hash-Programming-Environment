package hPE.core.library;

import hPE.frontend.backend.locations.Location;
import hPE.frontend.core.locations.LocationManager;
import hPE.ui.preferences.AddLocationDialog;
import hPE.ui.preferences.DuplicateLocationException;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;

/**
 * 
 * @author Juliano Efson Sales
 * @since 02 Aug 2011
 * 
 */
public class LocationView extends ViewPart {

	public static final int STATUS = 0;

	public static final int KEY = 1;

	public static final int SERVER_NAME = 2;

	public static final int URI = 3;

	public static final String CONNECTED_STATUS = "Connected";

	public static final String INVALID_STATUS = "Invalid/Inaccessible";

	public static final String IDLE_STATUS = "Idle";

	protected LocationManager manager;

	private IAction removeAction;

	private IAction editAction;

	private IAction addAction;

	private IAction connectAction;

	private IAction connectAllAction;

	private IAction disconnectAction;

	private IAction disconnectAllAction;

	private Table table;

	public LocationView() {
		manager = LocationManager.getInstance();
	}

	@Override
	public void createPartControl(Composite parent) {
		Font font = parent.getFont();
		table = new Table(parent, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 250;
		gd.widthHint = 500;
		table.setLayoutData(gd);
		table.setFont(font);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		int defaultwidth = (350 / 4) + 1;

		TableColumn column = new TableColumn(table, SWT.NULL);
		column.setText("Status");
		column.setWidth(defaultwidth);

		column = new TableColumn(table, SWT.NULL);
		column.setText("Key");
		column.setWidth(defaultwidth);

		column = new TableColumn(table, SWT.NULL);
		column.setText("Server Name");
		column.setWidth(defaultwidth * 2);

		column = new TableColumn(table, SWT.NULL);
		column.setText("URI");
		column.setWidth(defaultwidth * 2);

		table.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if (event.character == SWT.DEL && event.stateMask == 0) {
					removeLocation();
				}
			}
		});

		createActions();
		createMenus();
		updateTable();
	}

	@Override
	public void setFocus() {
		// do nothing
	}

	protected void createActions() {
		removeAction = new Action("Remove") {
			public void run() {
				removeLocation();
			}
		};

		addAction = new Action("Add") {
			public void run() {
				editLocation(true);
			}
		};

		editAction = new Action("Edit") {
			public void run() {
				editLocation(false);
			}
		};

		connectAction = new Action("Connect") {
			public void run() {

				connect(true);
			}
		};

		connectAllAction = new Action("Connect All") {
			public void run() {
				connectAll(true);
			}
		};

		disconnectAction = new Action("Disconnect") {
			public void run() {
				connect(false);
			}
		};

		disconnectAllAction = new Action("Disconnect All") {
			public void run() {
				connectAll(false);
			}
		};
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
		rootMenuManager.add(addAction);
		rootMenuManager.add(editAction);
		rootMenuManager.add(removeAction);
		rootMenuManager.add(connectAction);
		rootMenuManager.add(connectAllAction);
		rootMenuManager.add(disconnectAction);
		rootMenuManager.add(disconnectAllAction);
	}

	protected void removeLocation() {
		int index = table.getSelectionIndex();
		TableItem item = table.getItem(index);
		manager.removeLocation(item.getText(KEY));
		table.remove(index);
	}

	protected void editLocation(boolean newOne) {
		AddLocationDialog dlg;
		TableItem item = null;
		MessageDialog message = null;

		if (!newOne) {
			int index = table.getSelectionIndex();
			if (index != -1) {
				item = table.getItem(index);
				dlg = new AddLocationDialog(getSite().getShell(),
						item.getText(KEY), item.getText(URI));
			} else {
				message = new MessageDialog(getSite().getShell(), "Attention!",
						null, "Select a location to edit.",
						MessageDialog.ERROR, new String[] { "Ok" }, 0);
				message.open();
				message.close();
				return;
			}
		} else {
			dlg = new AddLocationDialog(getSite().getShell(), null, null);
		}

		Location l;

		while (true) {
			dlg.open();

			if (dlg.getReturnCode() != AddLocationDialog.CANCEL) {
				try {

					if (item != null) {
						manager.removeLocation(item.getText(KEY));
					} else {
						item = new TableItem(table, SWT.NONE);
					}
					l = manager.createNewLocation();
					l.setUri(dlg.getAddress());
					l.setLogin(dlg.getLogin());
					l.setPassword(dlg.getPassword());

					String serverName = null;
					try {
						serverName = manager.testConnection(l);
						l.setName(serverName);
					} catch (MalformedURLException e) {
						message = new MessageDialog(getSite().getShell(),
								"Error!", null,
								"This address doesn't represent a valide URL.",
								MessageDialog.INFORMATION,
								new String[] { "Ok" }, 0);
					} catch (Exception e) {
						message = new MessageDialog(getSite().getShell(),
								"Error!", null,
								"It isn't possible connect to the server./n"
										+ e.getMessage(),
								MessageDialog.INFORMATION,
								new String[] { "Ok" }, 0);
					} finally {
						if (message != null) {
							message.open();
							message.close();
						}
					}

					manager.addCoreLocation(dlg.getKey(), l);

					String status = null;

					if (serverName == null) {
						status = INVALID_STATUS;
						serverName = "<unknown>";
					} else {
						status = IDLE_STATUS;
					}

					item.setText(new String[] { status, dlg.getKey(),
							serverName, dlg.getAddress() });

					dlg.close();
					break;
				} catch (DuplicateLocationException e) {
					message = new MessageDialog(
							dlg.getShell(),
							"Attention!",
							null,
							"This key already exists. Please, give another one.",
							MessageDialog.ERROR, new String[] { "Ok" }, 0);
					message.open();
					message.close();
				}
			} else {
				break;
			}
		}

		dlg.close();
	}

	protected void updateTable() {
		Map<String, Location> locations = manager.getCoreLocations();
		TableItem item;
		Location location;
		String address, serverName, status;

		status = IDLE_STATUS;
		serverName = "<unknown>";

		Set<String> keys = locations.keySet();
		for (String key : keys) {
			item = new TableItem(table, SWT.NONE);
			location = locations.get(key);
			address = location.getUri();

			item.setText(new String[] { status, key, serverName, address });
		}

	}

	protected void connect(boolean connect) {
		int index = table.getSelectionIndex();

		connect(connect, index);
		if (!connect) {
			HPEComponentLibraryView.getLast().updateView();
		}
	}

	protected void connectAll(boolean connect) {
		int count = table.getItemCount();

		for (int i = 0; i < count; i++) {
			connect(connect, i);
		}

		if (!connect) {
			HPEComponentLibraryView.getLast().updateView();
		}
	}

	protected void connect(boolean connect, int index) {
		String key = table.getItem(index).getText(KEY);

		if (connect
				&& !table.getItem(index).getText(STATUS)
						.equals(CONNECTED_STATUS)) {
			try {
				table.getItem(index).setText(SERVER_NAME,
						manager.testConnection(key));
				table.getItem(index).setText(STATUS, CONNECTED_STATUS);
				HPEComponentLibraryView.getLast().showLocation(
						manager.addConnectedLocation(key));
			} catch (Exception e) {
				table.getItem(index).setText(STATUS, INVALID_STATUS);
			}
		} else if (!connect
				&& table.getItem(index).getText(STATUS)
						.equals(CONNECTED_STATUS)) {
			table.getItem(index).setText(STATUS, IDLE_STATUS);
			manager.removeConnectedLocation(key);
		}
	}
}