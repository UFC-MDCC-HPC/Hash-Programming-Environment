package hPE.frontend.base.dialogs;

import hPE.HPEPlugin;
import hPE.core.library.HPEComponentLibraryView;
import hPE.core.library.HPELocationEntry;
import hPE.core.library.InexistentSourcesException;
import hPE.core.library.UncompiledSourcesException;
import hPE.frontend.CoreLocationList;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedRefInnerException;
import hPE.xml.factory.HComponentFactoryImpl.DuplicatedSliceNamesException;
import hPE.xml.factory.HComponentFactoryImpl.UndefinedRefInnerException;

import java.awt.Frame;
import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.xml.rpc.ServiceException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;

//TODO substituir Swing por SWT.
public class RegisterComponentDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private HComponent c; // @jve:decl-index=0:
	private JComboBox jComboBoxLocations = null;
	private JCheckBox jCheckBoxFreeSource = null;
	private JButton jButtonRegister = null;
	private JButton jButtonInfo = null;
	private Map<String, URI> locations = new HashMap<String, URI>(); // @jve:decl-index=0:
	private JComboBox jComboBoxVersions = null;
	private JLabel jLabelLocation = null;
	private JLabel jLabelVersion = null;
	private JButton jButtonRegisterMarkObsolete = null;
	private JButton jButtonUnregisterComponent = null;

	/**
	 * @param owner
	 * @param c
	 */
	public RegisterComponentDialog(Frame owner, HComponent c) {
		super(owner);
		this.setComponent(c);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(421, 168);
		this.setTitle("Register " + c.getComponentName() + " in a Location");
		this.setContentPane(getJContentPane());
		// HPELocationFileTraversor locationFileTraversor = new
		// HPELocationFileTraversor();

		List<URI> l = CoreLocationList.fetchLocations();
		for (URI uri : l) {
			String locationName = null;
			try {
				locationName = HPELocationEntry.fetchLocationName(uri);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			if (locationName != null) {
				this.locations.put(locationName, uri);
				this.getJComboBoxLocations().addItem(locationName);
			} else {
				JOptionPane.showMessageDialog(null,
						"RegisterComponentDialog: Unable to reach location at \n"
								+ uri.toString(), "Location Fetch Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		List<Integer[]> vs = c.getVersions();
		for (Integer[] v : vs) {
			this.getJComboBoxVersions().addItem(HInterface.toStringVersion(v));
		}
		this.getJComboBoxVersions().setSelectedIndex(vs.size() - 1);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelVersion = new JLabel();
			jLabelVersion.setBounds(new Rectangle(15, 55, 62, 16));
			jLabelVersion.setText("Version");
			jLabelLocation = new JLabel();
			jLabelLocation.setBounds(new Rectangle(15, 10, 69, 16));
			jLabelLocation.setText("Location");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJComboBoxLocations(), null);
			jContentPane.add(getJCheckBoxFreeSource(), null);
			jContentPane.add(getJButtonRegister(), null);
			jContentPane.add(getJButtonInfo(), null);
			jContentPane.add(getJComboBoxVersions(), null);
			jContentPane.add(jLabelLocation, null);
			jContentPane.add(jLabelVersion, null);
			jContentPane.add(getJButtonRegisterMarkObsolete(), null);
			jContentPane.add(getJButtonUnregisterComponent(), null);
			jLabelVersion.setVisible(!c.isAbstract());

		}
		return jContentPane;
	}

	private void setComponent(HComponent c) {
		this.c = c;
	}

	private HComponent getComponent() {
		return c;
	}

	/**
	 * This method initializes jComboBoxLocations
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxLocations() {
		if (jComboBoxLocations == null) {
			jComboBoxLocations = new JComboBox();
			jComboBoxLocations.setBounds(new Rectangle(15, 25, 231, 21));
		}
		return jComboBoxLocations;
	}

	/**
	 * This method initializes jCheckBoxFreeSource
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getJCheckBoxFreeSource() {
		if (jCheckBoxFreeSource == null) {
			jCheckBoxFreeSource = new JCheckBox();
			jCheckBoxFreeSource.setBounds(new Rectangle(15, 100, 161, 21));
			jCheckBoxFreeSource.setSelected(true);
			jCheckBoxFreeSource.setText("Open Source");
		}
		return jCheckBoxFreeSource;
	}

	/**
	 * This method initializes jButtonRegister
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonRegister() {
		if (jButtonRegister == null) {
			jButtonRegister = new JButton();
			jButtonRegister.setBounds(new Rectangle(265, 40, 141, 26));
			jButtonRegister.setText("Register");
			jButtonRegister
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String locationName = (String) getJComboBoxLocations()
									.getSelectedItem();
							URI uri = locations.get(locationName);
							String version = c.isAbstract() ? null
									: (String) getJComboBoxVersions()
											.getSelectedItem();
							registerComponent(uri, version,
									getJCheckBoxFreeSource().isSelected());
						}
					});
		}
		return jButtonRegister;
	}

	private void registerComponent(URI uri, String version, boolean freeSource) {

		String errorMessage = null;

		try {

			String message = HPELocationEntry.registerComponent(c, uri,
					version, freeSource);

			JOptionPane.showMessageDialog(null, message, "Location Answer",
					JOptionPane.INFORMATION_MESSAGE);

			HPEPlugin plugin = HPEPlugin.getDefault();
			plugin
					.notifyListeners(HPEComponentLibraryView.PROPERTY_LOCATION_CHANGED);

		} catch (MalformedURLException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (ServiceException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (RemoteException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (CoreException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (UndefinedRefInnerException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (DuplicatedRefInnerException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (DuplicatedSliceNamesException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (UncompiledSourcesException e) {
			e.printStackTrace();
			if (!c.isAbstract()) {
				JOptionPane.showMessageDialog(null,
						"[RegisterComponentDialog] Version " + version + " of "
								+ c.getComponentName()
								+ " has uncompiled sources !", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"[RegisterComponentDialog] " + c.getComponentName()
								+ " has uncompiled sources !", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (InexistentSourcesException e) {
			e.printStackTrace();
			if (!c.isAbstract()) {
				JOptionPane
						.showMessageDialog(
								null,
								" The sources for version "
										+ version
										+ " of "
										+ c.getComponentName()
										+ " must be generated !\n hint: execute \"Edit Source\" on the pop-up menu of each interface of "
										+ c.getComponentName() + ".", "Error",
								JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane
						.showMessageDialog(
								null,
								" The sources for "
										+ c.getComponentName()
										+ " must be generated !\n hint: execute \"Edit Source\" on the pop-up menu of each interface of "
										+ c.getComponentName() + ".", "Error",
								JOptionPane.ERROR_MESSAGE);
			}
		} finally {
			if (errorMessage != null)
				JOptionPane.showMessageDialog(null, errorMessage,
						"Register Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * This method initializes jButtonInfo
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonInfo() {
		if (jButtonInfo == null) {
			jButtonInfo = new JButton();
			jButtonInfo.setBounds(new Rectangle(265, 10, 141, 26));
			jButtonInfo.setText("About Location");
			jButtonInfo.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String locationName = (String) getJComboBoxLocations()
							.getSelectedItem();
					URI uri = locations.get(locationName);
					String message = "Error connecting to location to fetch information.";
					try {
						message = HPELocationEntry
								.getLocationPresentationMessage(uri);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					} catch (ServiceException e1) {
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, message, "About "
							+ locationName, JOptionPane.INFORMATION_MESSAGE);
				}

			});
		}
		return jButtonInfo;
	}

	/**
	 * This method initializes jComboBoxVersions
	 * 
	 * @return javax.swing.JComboBox
	 */
	private JComboBox getJComboBoxVersions() {
		if (jComboBoxVersions == null) {
			jComboBoxVersions = new JComboBox();
			jComboBoxVersions.setBounds(new Rectangle(15, 70, 129, 21));
			jComboBoxVersions.setVisible(!c.isAbstract());
		}
		return jComboBoxVersions;
	}

	/**
	 * This method initializes jButtonRegisterMarkObsolete
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonRegisterMarkObsolete() {
		if (jButtonRegisterMarkObsolete == null) {
			jButtonRegisterMarkObsolete = new JButton();
			jButtonRegisterMarkObsolete.setBounds(new Rectangle(265, 100, 141,
					26));
			jButtonRegisterMarkObsolete.setText("Make Obsolete");
			jButtonRegisterMarkObsolete
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String locationName = (String) getJComboBoxLocations()
									.getSelectedItem();
							URI uri = locations.get(locationName);
							String version = c.isAbstract() ? null
									: (String) getJComboBoxVersions()
											.getSelectedItem();
							String message = "";
							try {
								message = HPELocationEntry.markAsObsolete(c,
										uri, version);
							} catch (RemoteException e1) {
								message = e1.getMessage();
								e1.printStackTrace();
							} catch (MalformedURLException e1) {
								message = e1.getMessage();
								e1.printStackTrace();
							} catch (ServiceException e1) {
								message = e1.getMessage();
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, message,
									"Location Answer",
									JOptionPane.INFORMATION_MESSAGE);
						}

					});
		}
		return jButtonRegisterMarkObsolete;
	}

	/**
	 * This method initializes jButtonUnregisterComponent
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonUnregisterComponent() {
		if (jButtonUnregisterComponent == null) {
			jButtonUnregisterComponent = new JButton();
			jButtonUnregisterComponent
					.setBounds(new Rectangle(265, 70, 141, 26));
			jButtonUnregisterComponent.setText("Unregister");
			jButtonUnregisterComponent
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							String locationName = (String) getJComboBoxLocations()
									.getSelectedItem();
							URI uri = locations.get(locationName);
							String version = c.isAbstract() ? null
									: (String) getJComboBoxVersions()
											.getSelectedItem();
							unregisterComponent(uri, version);
						}
					});
		}
		return jButtonUnregisterComponent;
	}

	protected void unregisterComponent(URI uri, String version) {
		String message = null;
		try {
			message = HPELocationEntry.unregisterComponent(c, uri, version);
		} catch (MalformedURLException e) {
			message = e.getMessage();
			e.printStackTrace();
		} catch (ServiceException e) {
			message = e.getMessage();
			e.printStackTrace();
		} catch (RemoteException e) {
			message = e.getMessage();
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, message, "Location Answer",
				JOptionPane.INFORMATION_MESSAGE);
	}

} // @jve:decl-index=0:visual-constraint="10,10"
