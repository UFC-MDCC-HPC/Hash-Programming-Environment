package hPE.frontend.base.dialogs;

import hPE.HPEProperties;
import hPE.frontend.NAntBuilder;
import hPE.frontend.base.externalreferences.DocumentRoot;
import hPE.frontend.base.externalreferences.ExternalreferencesFactory;
import hPE.frontend.base.externalreferences.ExternalreferencesPackage;
import hPE.frontend.base.externalreferences.ReferenceListType;
import hPE.frontend.base.externalreferences.ReferenceType;
import hPE.frontend.base.externalreferences.impl.DocumentRootImpl;
import hPE.frontend.base.externalreferences.util.ExternalreferencesResourceFactoryImpl;
import hPE.frontend.base.externalreferences.util.ExternalreferencesResourceImpl;
import hPE.frontend.base.model.HHasExternalReferences;
import hPE.ui.preferences.PreferenceConstants;

import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

//Refatorado para o novo HPEProperties
//TODO acredito que não deve ser usado swing, mas sim SWT. Isso pode ser causar problemas na geração do plugin.
public class AddReferencesDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JScrollPane jScrollPaneReferences = null;
	private JTable jTableReferences = null;
	private JButton jButtonAdd = null;
	private JButton jButtonRemove = null;
	private JButton Confirm = null;
	private JButton Ignore = null;

	/**
	 * @param owner
	 * @param i
	 */
	public AddReferencesDialog(Frame owner, HHasExternalReferences item) {
		super(owner);
		this.item = item;
		initialize();
		reloadReferences();
		fillWithRegisteredReferences();
	}

	public static class Reference {

		private String name;
		private File path;
		private String description;
		public boolean isExternal = false;

		public Reference(String name, File path, String description,
				boolean isExternal) {
			this.name = name;
			this.path = path;
			this.description = description;
			this.isExternal = isExternal;
		}

		public String getName() {
			return name;
		}

		public File getPath() {
			return path;
		}

		public String getDescription() {
			return description;
		}

	}

	private Map<String, Reference> references = null; // @jve:decl-index=0:

	private Map<String, Reference> getReferences() {
		if (references == null) {
			references = new HashMap<String, Reference>();
		}
		return references;
	}

	private void fillWithRegisteredReferences() {

		Map<String, Reference> references = this.getReferences();

		loadMonoReferences(references);
		loadExternalReferences(references);
		browseReferencesUpdate();
	}

	// TODO verificar se tem o comportamento esperado.
	private static void loadMonoReferences(Map<String, Reference> references) {
		String monoBin = HPEProperties.get(PreferenceConstants.MONO_BIN_PATH);

		if (monoBin != null) {
			IPath monoBinPath = new Path(monoBin);
			String monoHome = monoBinPath.toFile().getParent();

			File monoLibPath = new File(monoHome + File.pathSeparator + "lib");

			File[] files = monoLibPath.listFiles();
			for (File f : files) {
				if (f.isFile()) {
					String fname = f.getName();
					if (fname.endsWith(".dll")) {
						int i = fname.lastIndexOf('.');
						fname = fname.substring(0, i);
						String description = "System library";
						Reference ref = new Reference(fname, f, description,
								false);
						references.put(fname, ref);
					}
				}
			}
		} else {
			// TODO USAR SWT, não SWING. Tem que mudar a classe dialog toda.
			JOptionPane.showMessageDialog(null,
					"Variable MONO_PATH not set in hpe.frontend.properties.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private static String fileReferences = null; // @jve:decl-index=0:

	private static String getFileReferences() {
		if (fileReferences == null) {
			fileReferences = HPEProperties
					.get(PreferenceConstants.EXTERNAL_REFERENCES_XML);
		}
		return fileReferences;
	}

	public static void loadExternalReferences(Map<String, Reference> references) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
						new ExternalreferencesResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(ExternalreferencesPackage.eNS_URI,
				ExternalreferencesPackage.eINSTANCE);

		URI uri = URI.createFileURI(getFileReferences());

		Resource resource = null;

		boolean confirm = true;

		try {

			resource = resourceSet.getResource(uri, true);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			if (e.getCause() instanceof FileNotFoundException) {
				int i = JOptionPane
						.showConfirmDialog(
								null,
								"External references file not found. Create a externalreferences.xml in the home path ?",
								"Confirmation", JOptionPane.YES_NO_OPTION);
				if (i == JOptionPane.OK_OPTION) {
					resource = createNewReferenceFile(references);
				} else {
					confirm = false;
				}
			}
		} finally {

			if (confirm) {
				ExternalreferencesResourceImpl cResource = (ExternalreferencesResourceImpl) resource;
				EList rs = cResource.getContents();

				ReferenceListType refList = ((DocumentRootImpl) rs.get(0))
						.getExternal();
				if (refList.getReference() != null) {
					for (ReferenceType l : refList.getReference()) {
						File thePath = new File(l.getPath());
						String theDescription = l.getDescription();
						String theName = l.getDestailedName();
						Reference bel = new Reference(theName, thePath,
								theDescription, true);
						references.put(theName, bel);
					}
				}
			}
		}
	}

	private static ExternalreferencesFactory factory = ExternalreferencesFactory.eINSTANCE;

	private static Resource createNewReferenceFile(
			Map<String, Reference> references) {
		try {
			// Create a resource set to hold the resources.
			//
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register the appropriate resource factory to handle all file
			// extentions.
			//
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
							new ExternalreferencesResourceFactoryImpl());

			// Register the package to ensure it is available during loading.
			//
			resourceSet.getPackageRegistry().put(
					ExternalreferencesPackage.eNS_URI,
					ExternalreferencesPackage.eINSTANCE);

			// If there are no arguments, emit an appropriate usage message.
			//
			URI uri = URI.createFileURI(getFileReferences());
			Resource resource = resourceSet.createResource(uri);

			DocumentRoot dX = factory.createDocumentRoot();
			ReferenceListType cX = saveReferences(references);
			dX.setExternal(cX);

			resource.getContents().add(dX);
			resource.save(null);

			return resource;
		} catch (IOException e) {
			return null;
		}

	}

	private static ReferenceListType saveReferences(
			Map<String, Reference> references) {

		ReferenceListType refs = factory.createReferenceListType();
		EList<ReferenceType> ls = refs.getReference();

		for (Reference ref : references.values()) {
			if (ref.isExternal) {
				String n = ref.getName();
				File p = ref.getPath();
				String d = ref.getDescription();

				ReferenceType r = factory.createReferenceType();
				r.setDescription(d);
				r.setDestailedName(n);
				r.setPath(p.getAbsolutePath());

				ls.add(r);
			}
		}

		return refs;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(606, 370);
		this.setTitle("External References Browsing & Selecting");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJScrollPaneReferences(), null);
			jContentPane.add(getJButtonAdd(), null);
			jContentPane.add(getJButtonRemove(), null);
			jContentPane.add(getConfirm(), null);
			jContentPane.add(getIgnore(), null);
			jContentPane.add(getJTextAreaDescription(), null);
			jContentPane.add(getJListRefs(), null);
			jContentPane.add(getJButtonRemoveRef(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPaneReferences
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPaneReferences() {
		if (jScrollPaneReferences == null) {
			jScrollPaneReferences = new JScrollPane();
			jScrollPaneReferences.setBounds(new Rectangle(15, 15, 456, 246));
			jScrollPaneReferences.setViewportView(getJTableReferences());
		}
		return jScrollPaneReferences;
	}

	private class BrowseReferencesListener implements ListSelectionListener {

		private JTable table = null;
		private AddReferencesDialog dialog;
		private JTextArea descArea;

		public BrowseReferencesListener(AddReferencesDialog dialog) {
			this.table = dialog.getJTableReferences();
			this.descArea = dialog.getJTextAreaDescription();
			this.dialog = dialog;
		}

		@Override
		public void valueChanged(ListSelectionEvent event) {

			if (event.getSource() == table.getSelectionModel()
					&& event.getFirstIndex() >= 0) {
				int i = table.getSelectedRow();
				String refName = (String) table.getValueAt(i, 0);
				Reference r = references.get(refName);

				descArea.setText(r.getDescription());
				dialog.getJButtonRemove().setEnabled(r.isExternal);
			}
		}
	}

	// based on current kinds and grouping ...
	private void browseReferencesUpdate() {

		String[] columnNames = new String[2];
		Object[][] data = new Object[this.getReferences().size()][2];

		columnNames[0] = "Name";
		columnNames[1] = "Path";

		int j = 0;
		for (Reference r : this.getReferences().values()) {
			data[j][0] = r.getName();
			data[j][1] = r.getPath().getAbsolutePath();
			j++;
		}

		data = sort(data);

		BrowseReferencesTableModel btmAbs = new BrowseReferencesTableModel(
				columnNames, data);
		jTableReferences.setModel(btmAbs);

	}

	class BrowseReferencesTableModel extends AbstractTableModel {

		private String[] columnNames;
		private Object[][] data;

		public BrowseReferencesTableModel(String[] columnNames, Object[][] data) {
			this.columnNames = columnNames;
			this.data = data;
		}

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
			return data[row][col];
		}

		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		/*
		 * Don't need to implement this method unless your table's editable.
		 */
		public boolean isCellEditable(int row, int col) {
			return false;
		}

	}

	/**
	 * This method initializes jTableReferences
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTableReferences() {
		if (jTableReferences == null) {
			jTableReferences = new JTable();
			jTableReferences
					.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			jTableReferences.setName("");
			// jTableReferences.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			ListSelectionModel selectionModel = jTableReferences
					.getSelectionModel();
			selectionModel
					.addListSelectionListener(new BrowseReferencesListener(this));
		}
		return jTableReferences;
	}

	/**
	 * This method initializes jButtonAdd
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAdd() {
		if (jButtonAdd == null) {
			jButtonAdd = new JButton();
			jButtonAdd.setBounds(new Rectangle(15, 265, 46, 31));
			jButtonAdd.setToolTipText("Add new reference...");
			jButtonAdd.setText("+");
			jButtonAdd.addActionListener(this);
		}
		return jButtonAdd;
	}

	/**
	 * This method initializes jButtonRemove
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonRemove() {
		if (jButtonRemove == null) {
			jButtonRemove = new JButton();
			jButtonRemove.setBounds(new Rectangle(15, 300, 46, 31));
			jButtonRemove.setToolTipText("Remove reference");
			jButtonRemove.setText("-");
			jButtonRemove.addActionListener(this);
		}
		return jButtonRemove;
	}

	/**
	 * This method initializes Confirm
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getConfirm() {
		if (Confirm == null) {
			Confirm = new JButton();
			Confirm.setBounds(new Rectangle(480, 15, 111, 31));
			Confirm.setToolTipText("Click here to add a reference.");
			Confirm.setText("Add");
			Confirm.addActionListener(this);
		}
		return Confirm;
	}

	/**
	 * This method initializes Ignore
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getIgnore() {
		if (Ignore == null) {
			Ignore = new JButton();
			Ignore.setBounds(new Rectangle(480, 300, 111, 31));
			Ignore.setToolTipText("Ignore selection and exit.");
			Ignore.setText("Finish");
			Ignore.addActionListener(this);
		}
		return Ignore;
	}

	HHasExternalReferences item = null;

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();

		if (source == this.getConfirm()) {
			JTable table = this.getJTableReferences();
			TableModel model = table.getModel();
			int[] selectedRows = table.getSelectedRows();
			for (int i : selectedRows) {
				String name = (String) model.getValueAt(i, 0);
				String selectedRef = this.getReferences().get(name).getName();
				this.getSelectedReferences().add(selectedRef);
			}

			item.addExternalReferences(this.getSelectedReferences());
			this.selectedReferences.clear();
			reloadReferences();

		} else if (source == this.getJButtonRemoveRef()) {
			JTable table = this.getJTableReferences();
			TableModel model = table.getModel();
			int[] selectedRows = table.getSelectedRows();
			for (int i : selectedRows) {
				String name = (String) model.getValueAt(i, 0);
				String selectedRef = this.getReferences().get(name).getName();
				this.getSelectedReferences().add(selectedRef);
			}

			item.removeExternalReferences(this.getSelectedReferences());
			this.selectedReferences.clear();
			reloadReferences();

		} else if (source == this.getIgnore()) {
			this.setSelectedReferences(null);
			this.setVisible(false);
		} else if (source == this.getJButtonAdd()) {

			RegisterNewReferenceDialog dialog = new RegisterNewReferenceDialog(
					null);
			dialog.setAlwaysOnTop(true);
			dialog.setModal(true);
			dialog.setVisible(true);

			if (dialog.getResult() == JOptionPane.OK_OPTION) {
				Reference newRef = dialog.getRef();

				int r = JOptionPane.YES_OPTION;
				if (references.containsKey(newRef.getName())) {
					r = JOptionPane.showConfirmDialog(null, newRef.getName()
							+ " already registered. Overwrite ?",
							"Confirmation", JOptionPane.YES_NO_OPTION);
				}
				if (r == JOptionPane.YES_OPTION) {
					this.getReferences().put(newRef.getName(), newRef);
					createNewReferenceFile(references);
					NAntBuilder.clearExternalRefs();
					browseReferencesUpdate();
				}

			}

		} else if (source == this.getJButtonRemove()) {

			BrowseReferencesTableModel model = (BrowseReferencesTableModel) this
					.getJTableReferences().getModel();

			for (int i : this.getJTableReferences().getSelectedRows()) {
				String refNameToDelete = (String) model.getValueAt(this
						.getJTableReferences().getSelectedRow(), 0);
				Reference ref = this.getReferences().get(refNameToDelete);
				if (ref.isExternal) {
					this.getReferences().remove(ref.getName());
				}
			}

			createNewReferenceFile(references);
			browseReferencesUpdate();
		}

	}

	private void reloadReferences() {

		this.getJListRefs().setListData(item.getExternalReferences().toArray());

	}

	private void setSelectedReferences(List<String> selectedReferences) {
		this.selectedReferences = selectedReferences;
	}

	public List<String> getSelectedReferences() {
		if (selectedReferences == null) {
			selectedReferences = new ArrayList<String>();
		}
		return selectedReferences;
	}

	private List<String> selectedReferences; // @jve:decl-index=0:
	private JTextArea jTextAreaDescription = null;
	private JList jListRefs = null;
	private JButton jButtonRemoveRef = null;

	private Object[][] sort(Object[][] data) {

		if (data.length > 1) {

			Object[] pivot = data[0];
			List<Object[]> ll = new ArrayList<Object[]>();
			List<Object[]> lu = new ArrayList<Object[]>();
			for (int i = 1; i < data.length; i++) {
				if ((!data[i][0].equals(""))
						&& (data[i][0].toString()
								.compareTo(pivot[0].toString()) < 0 || (data[i][0]
								.toString().equals(pivot[0].toString()) && data[i][1]
								.toString().compareTo(pivot[1].toString()) < 0))) {
					ll.add(data[i]);
				} else {
					lu.add(data[i]);
				}
			}

			Object[][] arrl = new Object[ll.size()][4];
			Object[][] arru = new Object[lu.size()][4];

			int k = 0;
			for (Object[] ss : ll) {
				arrl[k++] = ss;
			}

			k = 0;
			for (Object[] ss : lu) {
				arru[k++] = ss;
			}

			arrl = sort(arrl);
			arru = sort(arru);

			Object[][] arr = new Object[arrl.length + arru.length + 1][4];
			System.arraycopy(arrl, 0, arr, 0, arrl.length);
			arr[arrl.length] = pivot;
			System.arraycopy(arru, 0, arr, arrl.length + 1, arru.length);

			return arr;

		} else {
			return data;
		}
	}

	/**
	 * This method initializes jTextAreaDescription
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaDescription() {
		if (jTextAreaDescription == null) {
			jTextAreaDescription = new JTextArea();
			jTextAreaDescription.setBounds(new Rectangle(70, 265, 396, 66));
		}
		return jTextAreaDescription;
	}

	/**
	 * This method initializes jListRefs
	 * 
	 * @return javax.swing.JList
	 */
	private JList getJListRefs() {
		if (jListRefs == null) {
			jListRefs = new JList();
			jListRefs.setBounds(new Rectangle(480, 90, 111, 171));
			jListRefs.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent event) {
					JList refs = (JList) (event.getSource());
					String ref = (String) refs.getSelectedValue();
					for (int i = 0; i < getJTableReferences().getRowCount(); i++) {
						String tableRef = (String) getJTableReferences()
								.getModel().getValueAt(i, 0);
						if (tableRef.equals(ref)) {
							int index0 = i;
							getJTableReferences().setRowSelectionInterval(
									index0, index0);
						}
					}

				}
			});
		}
		return jListRefs;
	}

	/**
	 * This method initializes jButtonRemoveRef
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonRemoveRef() {
		if (jButtonRemoveRef == null) {
			jButtonRemoveRef = new JButton();
			jButtonRemoveRef.setBounds(new Rectangle(480, 50, 111, 31));
			jButtonRemoveRef.setText("Remove");
			jButtonRemoveRef
					.setToolTipText("Click here to remove a reference.");
			jButtonRemoveRef.addActionListener(this);

		}
		return jButtonRemoveRef;
	}

} // @jve:decl-index=0:visual-constraint="99,8"
