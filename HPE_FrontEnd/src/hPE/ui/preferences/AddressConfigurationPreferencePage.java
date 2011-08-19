package hPE.ui.preferences;

import hPE.HPEPlugin;
import hPE.frontend.backend.locations.Location;
import hPE.frontend.core.locations.LocationManager;
import hPE.location.HPE_Location_Server;
import hPE.location.HPE_Location_ServerService;
import hPE.location.HPE_Location_ServerServiceLocator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * 
 * @author Juliano Efson Sales
 * @since Jul 04, 2011
 * 
 */
public class AddressConfigurationPreferencePage extends PreferencePage
		implements IWorkbenchPreferencePage {

	protected HPEPreferenceStore pStore;

	protected Table fTable;

	protected String addressType;

	public static final String DEFAULT_WEB_SERVICE = "";

	public AddressConfigurationPreferencePage(String addressType) {
		super();
		this.addressType = addressType;
		pStore = (HPEPreferenceStore) HPEPlugin.getDefault()
				.getPreferenceStore();
		setPreferenceStore(pStore);
		noDefaultAndApplyButton();
	}

	@Override
	protected Control createContents(Composite ancestor) {
		return createTablePane(ancestor);
	}

	@Override
	public void init(IWorkbench workbench) {

	}

	public Composite createTablePane(Composite ancestor) {
		Font font = ancestor.getFont();
		Composite parent = new Composite(ancestor, GridData.FILL_BOTH);
		// ancestor, font, 2, 1,GridData.FILL_BOTH);

		fTable = new Table(parent, SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);

		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = 250;
		gd.widthHint = 350;
		fTable.setLayoutData(gd);
		fTable.setFont(font);
		fTable.setHeaderVisible(true);
		fTable.setLinesVisible(true);

		int defaultwidth = (350 / 3) + 1;

		TableColumn column = new TableColumn(fTable, SWT.NULL);
		column.setText("Name");
		column.setWidth(defaultwidth);

		column = new TableColumn(fTable, SWT.NULL);
		column.setText("Address");
		column.setWidth(defaultwidth * 2);

		fTable.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				if (event.character == SWT.DEL && event.stateMask == 0) {
					removeLocation();
				}
			}
		});

		updateTable(fTable);

		Composite buttons = new Composite(parent,
				GridData.VERTICAL_ALIGN_BEGINNING);

		// SWTFactory.createComposite(parent, font, 1, 1,
		// GridData.VERTICAL_ALIGN_BEGINNING, 0, 0);

		Button fAddButton = new Button(buttons, 0);
		fAddButton.setText("Add");
		// SWTFactory.createPushButton(buttons, "Add", null);
		fAddButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				editLocation(true);
			}
		});

		Button fEditButton = new Button(buttons, 0);
		fEditButton.setText("Edit");
		// SWTFactory.createPushButton(buttons, "Edit", null);
		fEditButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				editLocation(false);

			}
		});

		Button fRemoveButton = new Button(buttons, 0);
		fRemoveButton.setText("Remove");
		// SWTFactory.createPushButton(buttons, "Remove", null);
		fRemoveButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				removeLocation();
			}
		});

		Button fTestButton = new Button(buttons, 0);
		fTestButton.setText("Test Connection");
		// SWTFactory.createPushButton(buttons, "Test Connection", null);
		fTestButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				testConnection();
			}
		});

		return parent;
	}

	protected void testConnection() {

		int index = fTable.getSelectionIndex();
		if (index != -1) {
			MessageDialog message = null;
			try {
				TableItem item = fTable.getItem(index);
				String urlWS = item.getText(1);
				URL url = new URL(urlWS);

				HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
				HPE_Location_Server server = locationServerService
						.getHPE_Location_Server(url);

				String name = server.getName();

				message = new MessageDialog(getShell(), "Connection Test!",
						null, "Connection test ok! Server " + name,
						MessageDialog.INFORMATION, new String[] { "Ok" }, 0);
			} catch (MalformedURLException e) {
				message = new MessageDialog(getShell(), "Connection Test!",
						null,
						"Error! This address doesn't represent a valide URL.",
						MessageDialog.INFORMATION, new String[] { "Ok" }, 0);
			} catch (Exception e) {
				message = new MessageDialog(getShell(), "Connection Test!",
						null, "Error! " + e.getMessage(),
						MessageDialog.INFORMATION, new String[] { "Ok" }, 0);
			} finally {
				message.open();
				message.close();
			}
		}

	}

	protected void removeLocation() {
		int index = fTable.getSelectionIndex();
		TableItem item = fTable.getItem(index);
		pStore.removeAddress(item.getText(0), addressType);
		fTable.remove(index);
	}

	protected void editLocation(boolean newOne) {
		AddLocationDialog dlg;
		TableItem item = null;
		Location location;

		if (!newOne) {
			int index = fTable.getSelectionIndex();
			if (index != -1) {
				item = fTable.getItem(index);
				dlg = new AddLocationDialog(getShell(), item.getText(0),
						item.getText(1));
			} else {
				MessageDialog message = new MessageDialog(getShell(),
						"Attention!", null, "Select a location to edit.",
						MessageDialog.ERROR, new String[] { "Ok" }, 0);
				message.open();
				message.close();
				return;
			}
		} else {
			dlg = new AddLocationDialog(getShell(), null, null);
		}

		while (true) {
			dlg.open();

			try {
				if (true) {

					if (item != null) {
						pStore.removeAddress(item.getText(0), addressType);
					} else {
						item = new TableItem(fTable, SWT.NONE);
					}

					location = LocationManager.getInstance()
							.createNewLocation();
					location.setName(dlg.getKey());
					location.setUri(dlg.getAddress());
					location.setLogin(dlg.getLogin());
					location.setPassword(dlg.getPassword());

					pStore.addBackend(location.getName(), location);
					item.setText(new String[] { "", dlg.getAddress() });
				}

				dlg.close();
				break;
			} catch (DuplicateLocationException e) {
				MessageDialog message = new MessageDialog(
						dlg.getShell(),
						"Attention!",
						null,
						"This location name already exists. Please, give another one.",
						MessageDialog.ERROR, new String[] { "Ok" }, 0);
				message.open();
				message.close();
			}
		}
	}

	protected void updateTable(Table table) {
		Collection<Location> locations = LocationManager.getInstance()
				.getBackendLocations().values();
		TableItem item;

		for (Location location : locations) {
			item = new TableItem(table, SWT.NONE);
			item.setText(new String[] { location.getName(), location.getUri() });
		}

	}
}
