package hPE.frontend.base.model;

import hPE.frontend.base.codegen.HBEAbstractSourceCodeFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.codegen.c_sharp.HBESourceVersionCSharp;
import hPE.frontend.base.dialogs.AddReferencesDialog.Reference;
import hPE.frontend.base.exceptions.HPENotFusableSlicesException;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.settings.HPlatformSettingsFileSet;
import hPE.util.Pair;
import hPE.util.Triple;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import org.eclipse.draw2d.geometry.Point;

public abstract class HInterface extends HPrimInterface implements IInterface,
		HHasExternalReferences {

	static final long serialVersionUID = 1;

	public HInterface(HComponent configuration, HInterfaceSig signature,
			IHPrimUnit unit, Point where) {

		super(configuration, signature, unit, where);

	}

	public void hide() {

		super.hide();

		if (getHidden()) {
			for (HInterfaceSlice s : this.getSlices()) {
				s.hideInterface();
			}
		}
	}

	public void signalUpdateVisual() {
		getListeners().firePropertyChange(HInterface.PROPERTY_SIGNATURE, null,
				getName2());
	}

	public final static String PROPERTY_NEW_MODULE = "PROPERTY_NEW_MODULE";

	public HPort fetchPort(String sliceOwner, String slicePortOriginalName) {
		HInterfaceSlice sOwner = this.fetchSlice(sliceOwner);
		if (sOwner != null) {
			for (HPort port_ : sOwner.getPorts()) {
				String originalName = port_.getDefaultNameOf(sOwner);
				if (originalName == null)
					System.out.println("aaa");
				else if (originalName.equals(slicePortOriginalName)) {
					return port_;
				}
			}
		}

		return null;
	}

	public HInterfaceSlice fetchSlice(String[] sliceQRef) {

		HInterface i = this;
		HInterfaceSlice s = null;
		for (int k = 1; k <= sliceQRef.length - 1; k++) {
			String ref = sliceQRef[k];
			s = i.fetchSlice(ref);
			if (s != null)
				i = (HInterface) s.getInterface();
			else
				return null;
		}

		return s;
	}

	public HInterfaceSlice fetchSlice(String sliceRef) {

		for (HInterfaceSlice s : this.getSlices()) {
			if (s.getName().equals(sliceRef))
				return s;
		}

		return null;
	}

	public void removeLinksInConfiguration(IComponent c) {

		Iterator ls = ((List) ((ArrayList) this.getLinksToTheInterface())
				.clone()).iterator();
		while (ls.hasNext()) {
			HLinkToInterface l = (HLinkToInterface) ls.next();
			if (l.getLinked().getConfiguration() == c) {
				l.removeMe();
			}
		}
	}

	public List<Pair<String, HInterface>> getCompilationDependencies() {

		List<String> lsStr = new ArrayList<String>();
		List<Pair<String, HInterface>> ls = new ArrayList<Pair<String, HInterface>>();

		HComponent c = (HComponent) this.getConfiguration();
		String typeString = c.getPackagePath() + "." + c.getComponentName()
				+ "." + this.getPrimName();
		lsStr.add(typeString);
		ls.add(new Pair<String, HInterface>(typeString, this));

		List<Triple<String, HInterface, String>> pars = this
				.getParameters((HComponent) this.getConfiguration());

		for (Triple<String, HInterface, String> p : pars) {
			HInterface i = p.snd();
			List<Pair<String, HInterface>> cds = i.getCompilationDependencies();

			for (Pair<String, HInterface> s : cds) {
				if (!lsStr.contains(s.fst())) {
					lsStr.add(s.fst());
					ls.add(s);
				}
			}
		}

		return ls;
	}

	public List<Triple<String, HInterface, String>> getParameters() 
	{
		HComponent cThis = (HComponent) this.getConfiguration();
		HComponent cThisI = cThis.getWhoItImplements();
		return getParameters(cThisI == null ? cThis : cThisI);
	}

	public List<Triple<String, HInterface, String>> getParameters2(
			HComponent cThis) {

		List<Triple<String, HInterface, String>> parameters = new ArrayList<Triple<String, HInterface, String>>();

		List<HInterfaceSlice> slices = this.getSlices();

		for (HInterfaceSlice c : slices) {
			HInterface ic = (HInterface) c.getInterface();
			List<IHPrimUnit> uList = ic.getCompliantUnits();
			HComponent cc = (HComponent) uList.get(0).getConfiguration();

			List<Triple<String, HInterface, String>> ic_parameters = ic
					.getParameters(cThis);

			for (Triple<String, HInterface, String> innerParameter : ic_parameters) {
				parameters.add(innerParameter);
			}

			String parId = cc.getParameterIdentifier(cThis);

			if (cc.isParameter() && !parId.equals("type ?")) {
				String varName = cc.getVariableName(cThis);
				parameters.add(new Triple<String, HInterface, String>(varName,
						ic, parId));
			}
		}

		return parameters;

	}

	// TODO: TOP LEVEL PARAMETERS ...
	public List<Triple<String, HInterface, String>> getParameters(HComponent cThis) 
	{
		List<Triple<String, HInterface, String>> parameters = new ArrayList<Triple<String, HInterface, String>>();

		List<HInterfaceSlice> slices = this.getSlices();
		for (HInterfaceSlice s : slices) 
		{
			HInterface is = (HInterface) s.getInterface();
			HInterface is_supplier = null;
			List<IHPrimUnit> uList = is.getCompliantUnits();
			HComponent c = (HComponent) uList.get(0).getConfiguration();
			
			
			  if (c.isParameter() && c.getSupplier() != null) 
			  { 
					Map<String, HComponent> pars = cThis.getParametersByDefinedVarNames(); 
					String varName = c.getVariableName(); 
					HComponent c_supplier = (HComponent) c.getSupplier(); 
					is_supplier = c_supplier.getInterfaceByName(is.getPrimName()); 
					c = c_supplier;
					is_supplier = is_supplier == null ? is : is_supplier;

					// if (c.isParameter()) {
					//String varName = old_c.getVariableName(cThis);
					String parId = c.getParameterIdentifier(cThis.isAbstract() ? cThis : cThis.getWhoItImplements());
					if (!parId.equals("type ?"))
						parameters.add(new Triple<String, HInterface, String>(varName,is_supplier, parId));
					// }
			  } 
			  else if (c.isParameter()) 
			  {
					HComponent cTop = (HComponent) cThis.getTopConfiguration();
					Map<String, HComponent> pars = cThis.getParametersByDefinedVarNames();
					String varName = c.getVariableName(cThis);
					if (pars.containsKey(varName)) 
					{
						HComponent c_parameter = pars.get(varName);
						is_supplier = c_parameter.getInterfaceByName(is.getPrimName());
						c = c_parameter;
					}
					is_supplier = is_supplier == null ? is : is_supplier;
	
					// if (c.isParameter()) {
					//String varName = old_c.getVariableName(cThis);
					String parId = c.getParameterIdentifier(cThis.isAbstract() ? cThis : cThis.getWhoItImplements());
					if (!parId.equals("type ?"))
						parameters.add(new Triple<String, HInterface, String>(varName,is_supplier, parId));
					// }
			} 
			else 
			{
				is_supplier = is_supplier == null ? is : is_supplier;
			}


			List<Triple<String, HInterface, String>> slice_parameters = is_supplier.getParameters(cThis);
			for (Triple<String, HInterface, String> spar : slice_parameters) 
			{
				String sVarName = spar.fst();
				HInterface sis = spar.snd();
				String sParId = spar.trd();
				List<IHPrimUnit> suList = sis.getCompliantUnits();
				HComponent sc = (HComponent) suList.get(0).getConfiguration();
				//if (sc.isParameter()) {
				if (!sParId.equals("type ?"))
				   parameters.add(new Triple<String, HInterface, String>(sVarName, sis, sParId));
				//}
			}
		}

		return parameters;

	}

	public String getParameterModifierName2(boolean onlyVariables, List<String> varContext) 
	{
		int parameterized = 0;
		String nameWithParameters = "";

		List<String> vs = new ArrayList<String>();

		for (Triple<String, HInterface, String> triple : this.getParameters()) 
		{
			HInterface i = triple.snd();
			String parId = triple.trd();

			if (!vs.contains(parId) && !onlyVariables) 
			{
				if (parameterized == 0)
					nameWithParameters = nameWithParameters.concat("<");
				parameterized++;
				if (parameterized > 1)
					nameWithParameters += ", ";
				nameWithParameters = nameWithParameters + i.getName2(false, varContext, null);
			}
			vs.add(parId /* varName */);
		}

		if (parameterized > 0) 
		{
			nameWithParameters = nameWithParameters.concat(">");
		}

		return nameWithParameters;
	}

	public String getParameterModifierName(boolean complete,
			boolean showBounds, int depth) {

		int parameterized = 0;
		String nameWithParameters = "";

		List<String> vs = new ArrayList<String>();

		HComponent topC = (HComponent) ((HComponent) this.getConfiguration()).getTopConfiguration();
		List<Triple<String, HInterface, String>> parameters = this.getParameters(topC);

		for (Triple<String, HInterface, String> triple : parameters) {
			String varName = triple.fst();
			HInterface i = triple.snd();
			String parId = triple.trd();

			if (parameterized == 0)
				nameWithParameters = nameWithParameters.concat("<");
			parameterized++;
			if (!vs.contains(varName)) {
				if (parameterized > 1)
					nameWithParameters += ", ";
				nameWithParameters = nameWithParameters
						+ i.getName(false, depth > 0 ? false : showBounds,
								depth + 1);
			}
			vs.add(varName);
		}

		if (parameterized > 0) {
			nameWithParameters = nameWithParameters.concat(">");
		}

		return nameWithParameters;
	}

	public String getName2() {
		return this.getPrimName();
	}

	public String getName(boolean showSuperType, boolean showBounds) {
		return getName(showSuperType, showBounds, 0);
	}

	public String getName(boolean showSuperType, boolean showBounds, int depth) {

		if (this.isParameter()) {
			HComponent c = (HComponent) this.getCompliantUnits().get(0)
					.getConfiguration();
			String varName = c.getVariableName();
			String parId = c.getParameterIdentifier();
			return varName
					+ (showBounds ? ": "
							+ this.getNonAbstractName(false, showBounds, depth,
									false) : "");
		} else {
			return this.getNonAbstractName(showSuperType, showBounds, depth,
					false);
		}
	}

	public String getName2(boolean onlyVariables, List<String> varContext, String varNameCtx) 
	{
		HComponent c = (HComponent) this.getCompliantUnits().get(0).getConfiguration();
		String varName = c.getVariableName((HComponent) this.getConfiguration().getTopConfiguration());
		boolean showVariable = (varNameCtx == null || !varName.equals(varNameCtx)) && varContext != null && varContext.contains(varName.split("@")[0]);
		boolean showBounds = !showVariable;

		return (showVariable ? varName.split("@")[0] : "")
				+ (showVariable && showBounds ? ":" : "")
				+ (showBounds ? this.getNonAbstractName2(onlyVariables, varContext) : "");
	}

	public boolean isParameter() {
		HComponent c = (HComponent) this.getCompliantUnits().get(0).getConfiguration();
		return c.isParameter() && (c.getSupplier() == null);
	}

	public boolean isAbstract() {
		HComponent c = (HComponent) this.getConfiguration();
		return c.isAbstractConfiguration();
	}

	private String getNonAbstractName2(boolean onlyVariables, List<String> varContext) {
		return this.getPrimName() + this.getParameterModifierName2(onlyVariables,varContext);
	}

	private String getNonAbstractName(boolean showSuperType,
			boolean showBounds, int depth, boolean base) {
		String name = base && !this.baseName.isEmpty() ? this.baseName.get(0): this.getPrimName();
		if (this.isAbstract() || base) {
			return name
					+ this.getParameterModifierName(showSuperType, showBounds, depth)
					+ (showSuperType && this.hasSuperType() ? ": " + this.getInheritedName() : "");
		} else {
			return name	+ (showSuperType && this.hasSuperType() ? ": " + this.getInheritedName() : "");
		}

		// String name = base ? this.baseName : this.getPrimName();

	}

	public HInterfaceSlice addInterfaceSlice(HUnitSlice uSlice, String name)
			throws HPENotFusableSlicesException {

		HInterfaceSig isig = this.getSignature();

		HInterfaceSlice s = uSlice.newInterfaceSlice(name, isig);

		s.addCompliantUnitSlice(uSlice);
		uSlice.setInterfaceSlice(s);

		s.setBounds(uSlice.getBounds());

		if (getListeners() != null)
			getListeners().firePropertyChange(PROPERTY_SIGNATURE, null,
					getName2());

		return s;
	}

	public class ListHBESourceVersion implements TableModel, Serializable {

		static final long serialVersionUID = 1;

		private HInterface i = null;

		public ListHBESourceVersion(HInterface i) {
			this.i = i;
		}

		public HHasExternalReferences getInterface() {
			return i;
		}

		/**
		 * @uml.property name="sourceVersionList"
		 * @uml.associationEnd multiplicity="(0 -1)"
		 *                     elementType="hPE.backend.cluster.synthesizer.HBESourceVersion"
		 */
		private Map<String, HBESourceVersion> sourceVersionList = null;

		public List<HBESourceVersion> getSourceVersionList() {
			List<HBESourceVersion> l = new ArrayList<HBESourceVersion>();
			if (this.sourceVersionList == null)
				this.sourceVersionList = new HashMap<String, HBESourceVersion>();
			l.addAll(sourceVersionList.values());
			return l;
		}

		public void addSourceVersion(
				HBESourceVersion sourceVersion) {
			if (this.sourceVersionList == null)
				this.sourceVersionList = new HashMap<String, HBESourceVersion>();
			this.sourceVersionList.put(sourceVersion.getVersionID(),sourceVersion);
		}

		public void delSourceVersion(
				HBESourceVersion sourceVersion) {
			if (this.sourceVersionList == null)
				this.sourceVersionList = new HashMap<String, HBESourceVersion>();
			this.sourceVersionList.remove(sourceVersion.getVersionID());
		}

		public HBESourceVersion getVersion(String versionID) {
			if (this.sourceVersionList == null)
				this.sourceVersionList = new HashMap<String, HBESourceVersion>();
			return this.sourceVersionList.get(versionID);
		}

		public boolean noSources() {
			return getSourceVersionList() == null
					|| getSourceVersionList().isEmpty();
		}

		public void cleanSources() {
			this.sourceVersionList = new HashMap<String, HBESourceVersion>();
		}

		public void cleanSource(HBESourceVersion srcVersion) {

			this.sourceVersionList.remove(srcVersion.getVersionID());

		}

		// Methods of Table Model.

		public int getRowCount() {
			int r = this.getSourceVersionList().size();
			return r;
		}

		public int getColumnCount() {
			return 3;
		}

		public String getColumnName(int columnIndex) {
			switch (columnIndex) {
			case 0:
				return "Version";
			case 1:
				return "Source Type";
			case 2:
				return "Source File";
			}
			return "";
		}

		public Class<?> getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			HBESourceVersion srcVersion = this.getSourceVersionList().get(rowIndex);

			switch (columnIndex) {
			case 0:
				return false;
			case 1:
				return srcVersion.getFiles().size() == 0;
			case 2:
				return srcVersion.getFiles().size() > 0;
			}
			return false;
		}

		private JComboBox theComboBox = null;

		private Map<Integer, String> selectedFileNames = new HashMap<Integer, String>();

		public Object getValueAt(int rowIndex, int columnIndex) {

			HBESourceVersion srcVersion = this.getSourceVersionList().get(rowIndex);

			HComponent c = (HComponent) i.getConfiguration();

			boolean abs = c.isAbstractConfiguration();

			String type = srcVersion.getFiles().size() == 0 ? (srcsUndef.containsKey(srcVersion) ? srcsUndef.get(srcVersion) : "Undefined") : srcVersion.getSynthesizerType(abs);

			switch (columnIndex) {
			case 0:
				return srcVersion;
			case 1:
				return type;
				// case 2: return srcVersion.getFiles().size() > 0 ?
				// srcVersion.getFiles().get(0).getFileName() : "";
			case 2: {
				// if (!cbs.containsKey(new Integer(rowIndex))) {
				// cbs.put(new Integer(rowIndex), newComboBox(rowIndex,
				// srcVersion.getFiles()));
				// }
				// JComboBox comboBox2 = cbs.get(new Integer(rowIndex));
				if (!getSelectedFileNames().containsKey(new Integer(rowIndex))) {
					Object o = this.getComboBox().getSelectedItem();
					if (o != null && rowIndex == jTable.getSelectedRow())
						getSelectedFileNames()
								.put(
										new Integer(rowIndex),
										this.getComboBox().getSelectedItem()
												.toString());
					else if (o == null && this.getComboBox().getItemCount() > 0) {
						this.getComboBox().setSelectedIndex(0);
						getSelectedFileNames()
								.put(
										new Integer(rowIndex),
										this.getComboBox().getSelectedItem()
												.toString());
					} else {
						getSelectedFileNames().put(new Integer(rowIndex), "");
					}
				}

				return srcVersion.getFiles().size() > 0 ? getSelectedFileNames()
						.get(new Integer(rowIndex))
						: "";
			}
			}

			return null;
		}

		public JComboBox newComboBox() {

			JComboBox comboBox2 = new JComboBox();

			TableColumn c2 = jTable.getColumn("Source File");
			c2.setCellEditor(new DefaultCellEditor(comboBox2));

			DefaultTableCellRenderer renderer2 = new DefaultTableCellRenderer();
			renderer2.setToolTipText("Click here to select source name ...");
			comboBox2.setName("Source Name");
			c2.setCellRenderer(renderer2);

			comboBox2.addItemListener(ComboListener.getInstance());

			ComboListener.getInstance().setSelectedFileNames(
					getSelectedFileNames());
			ComboListener.getInstance().setCombo(comboBox2);
			ComboListener.getInstance().setTable(jTable);

			this.setComboBox(comboBox2);

			return comboBox2;
		}

		public void clear() {
			this.theComboBox = null;
			this.setSelectedFileNames(null);
		}

		private Map<HBESourceVersion, String> srcsUndef = new HashMap<HBESourceVersion, String>();

		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			HBESourceVersion srcVersion = this
					.getSourceVersionList().get(rowIndex);
			if (columnIndex == 1 && srcVersion.getFiles().size() == 0)
				srcsUndef.put(srcVersion, (String) aValue.toString());
		}

		public void addTableModelListener(TableModelListener l) {

		}

		public void removeTableModelListener(TableModelListener l) {

		}

		public void reset() {
			srcsUndef.clear();
		}

		private JTable jTable = null;

		public void setTable(JTable jTable) {
			this.jTable = jTable;
		}

		public void setComboBox(JComboBox theComboBox) {
			this.theComboBox = theComboBox;
		}

		public JComboBox getComboBox() {
			if (theComboBox == null) {
				theComboBox = newComboBox();
			}
			return theComboBox;
		}

		public void setSelectedFileNames(Map<Integer, String> selectedFileNames) {
			this.selectedFileNames = selectedFileNames;
		}

		public Map<Integer, String> getSelectedFileNames() {
			if (this.selectedFileNames == null) {
				this.selectedFileNames = new HashMap<Integer, String>();
			}
			return selectedFileNames;
		}

	}

	private ListHBESourceVersion srcVersions = new ListHBESourceVersion(this);

	public void addSourceVersion(HBESourceVersion sourceVersion) {
		getSourceVersionList().addSourceVersion(sourceVersion);
	}

	public void replaceSourceVersion(HBESourceVersion sourceVersionOld,
			HBESourceVersion sourceVersionNew) {
		getSourceVersionList().delSourceVersion(sourceVersionOld);
		getSourceVersionList().addSourceVersion(sourceVersionNew);
	}

	public ListHBESourceVersion getSourceVersionList() {
		if (srcVersions == null)
			srcVersions = new ListHBESourceVersion(this);
		return srcVersions;
	}

	public Collection<HBESourceVersion> getSourceVersions() {
		return getSourceVersionList().getSourceVersionList();
	}

	public HBESourceVersion getSourceVersion(String versionID) {
		return srcVersions.getVersion(versionID);
	}

	public boolean noSources() {
		return getSourceVersionList().noSources();
	}

	public void cleanSources() {
		getSourceVersionList().cleanSources();
	}

	public void cleanSource(HBESourceVersion srcVersion) {
		getSourceVersionList().cleanSource(srcVersion);
	}

	public List<HBEAbstractSynthesizer> getSupportedSynthesizers() {

		List<HBEAbstractSynthesizer> s = new Vector<HBEAbstractSynthesizer>();

		return s;

	}

	public void removeMe() {
		HComponent c = (HComponent) this.getConfiguration();
		c.removeInterface(this);
	}

	public HHasExternalReferences peekThatOneThatIsSubTypeOfTheOthers(
			List<HInterface> is) {

		// Among the components passed as parameters, peek the one that is
		// subtype of the others.
		// If such component does not exist, return null;

		// ASSUME SINGLE INHERITANCE

		HInterface i = is.get(0);

		for (HInterface i_ : is) {
			if (i_.isSubTypeOf(i)) {
				i = i_;
			} else if (!i.isSubTypeOf(i_)) {
				return null;
			}
		}

		return i;
	}

	// Subtyping relation.

	public boolean isSubTypeOf(HInterface i) {
		HComponent c1 = (HComponent) this.getConfiguration();
		HComponent c2 = (HComponent) i.getConfiguration();

		return (c1.isSubTypeOf(c2) && (this.toString().equals(i.toString()) || this
				.getSuperTypeID().equals(i.toString())));

	}

	public boolean hasSuperType() {
		return this.getSuperTypeID() != null;
	}

	private String superTypeID = null;

	public void setSuperTypeID(String n) {
		superTypeID = n;
		this.cleanSources();
	}

	public String getSuperTypeID() {
		return superTypeID;
	}

	// Name of the base interface in case of implements or extends;
	private List<String> baseName = new ArrayList<String>();

	public void setImplements() {
		this.baseName.add(0, this.getName2());
		this.setName(null);
		this.cleanSources();
	}

	public void setExtends() {
		this.baseName.add(0, this.getName2());
		this.setName(null);
		this.cleanSources();
	}

	public boolean isEquivalentTo(HInterface i) {
		return this.isSubTypeOf(i) && i.isSubTypeOf(this);
	}

	// PUT S2 IN PLACE OF S1.
	public void replaceSlice(HInterfaceSlice s1, HInterfaceSlice s2) {

		this.getSignature().replaceSlice(s1, s2);

		getListeners().firePropertyChange(PROPERTY_COLOR, null, getName2());

	}

	public HInterfaceSlice fetchSlice(String cRef, String iRef) {

		for (HInterfaceSlice s : this.getSlices()) {
			HComponent c = (HComponent) s.getInterface().getConfiguration();
			if (c.getRef().equals(cRef)) {
				HHasExternalReferences i = c.fetchInterface(iRef);
				if (i == null)
					return null;
				else
					return s;
			}
		}

		return null;
	}

	public final static String PROPERTY_EDITABLE_SOURCE = "PROPERTY_EDITABLE_SOURCE";

	private boolean IsEditableSource = true;

	public void setEditableSource(boolean isEditableSource) {
		this.IsEditableSource = isEditableSource;
		this.getListeners().firePropertyChange(PROPERTY_EDITABLE_SOURCE, null,
				getName2());
	}

	public boolean getIsEditableSource() {
		return this.IsEditableSource;
	}

	private String inheritedName = null;

	private void saveInheritedName() {
		inheritedName = this.getNonAbstractName(false, false, 0, true);
		// this.setName(null);
	}

	public String getInheritedName() {
		if (this.inheritedName == null) {
			this.saveInheritedName();
		}
		return this.inheritedName;
	}

	private void setInheritedSlices() {

		for (HInterfaceSlice s : this.getSlices()) {
			s.setInherited(true);
			((HInterface) s.getInterface()).setInheritedSlices();
		}

	}


	public void setInherited(HComponent topConfiguration) {
		this.setSuperTypeID(this.toString());
		// this.saveInheritedName();
		
		this.setConfiguration(topConfiguration); // ?????????????????????????????????????????
		this.setEditable(true);
		this.setInheritedSlices();
	}

	public void setImplemented(HComponent topConfiguration) {
		superTypeID = null; // REASON: This is the supertype of the abstract
							// component and not of the concrete component.
		// this.saveInheritedName();
		this.setConfiguration(topConfiguration); // ?????????????????????????????????????????
		this.setEditable(true);
		this.setEditableSource(true);
		// this.setInheritedSlices();
	}

	public List<HPort> getPorts() {
		return this.getSignature().getPorts();
	}

	public int getParametersCount() {

		List<Triple<String, HInterface, String>> t = this.getParameters();
		List<String> r = new ArrayList<String>();

		for (Triple<String, HInterface, String> param : t) {
			if (!r.contains(param.fst()))
				r.add(param.fst());
		}

		return r.size();
	}

	public void keepVersionConsistency() {

		HComponent c = (HComponent) this.getConfiguration();

		List<HBESourceVersion> versions_ = new ArrayList<HBESourceVersion>();
		versions_.addAll(this.getSourceVersions());

		List<String> versionIds = new ArrayList<String>();

		for (HBESourceVersion v : versions_) {
			if (!c.containsVersion(toVersion(v.getVersionID()))) {
				this.cleanSource(v);
			} else {
				versionIds.add(v.getVersionID());
			}
		}

		List<Integer[]> versionsC = c.getVersions();

		// Check if versions are consistent with component versions.
		for (Integer[] v : versionsC) {
			String versionId = toStringVersion(v);
			if (!versionIds.contains(versionId)) {
				String sourceType = "C# Language";
				HBESourceVersion source = createSourceVersion(sourceType);
				source.setVersionID(versionId);
				this.addSourceVersion(source);
			}

		}

	}

	public HBESourceVersion createSourceVersion(String sourceType) {
		if (sourceType.equals(hPE.frontend.kinds.application.codegen.c_sharp.HBESourceVersionCSharp.getType())) {
			return new hPE.frontend.kinds.application.codegen.c_sharp.HBESourceVersionCSharp();
		} else if (sourceType.equals(HBESourceVersionCSharp.getType())) {
			return new HBESourceVersionCSharp();
		} else if (sourceType.equals(HPlatformSettingsFileSet.getType())){
			return new HPlatformSettingsFileSet();
		} else
			return null;
		
	}

	public static String toStringVersion(Integer[] v) {
		String vs = v[0].toString();
		for (int j = 1; j < 4; j++) {
			vs += "." + v[j].toString();
		}
		return vs;
	}

	public static Integer[] toVersion(String v) {
		String[] vI = v.split("[.]");
		Integer[] vIn = new Integer[vI.length];

		for (int i = 0; i < vI.length; i++) {
			vIn[i] = Integer.parseInt(vI[i]);
		}
		return vIn;
	}

	public List<HInterfaceSlice> getSortedSlices(List<HInterfaceSlice> list) {

		Comparator<HInterfaceSlice> comparator = new CompareSliceByDependence(
				this.getConfiguration().getInnerComponents());

		Collections.sort(list, comparator);

		return list;
	}

	private class CompareSliceByDependence implements
			Comparator<HInterfaceSlice> {

		private List<HComponent> cs = null;

		public CompareSliceByDependence(List<HComponent> cs) {
			this.cs = cs;
		}

		@Override
		public int compare(HInterfaceSlice o1, HInterfaceSlice o2) {


			HComponent c1 = (HComponent) o1.getConfiguration();
			HComponent c2 = (HComponent) o2.getConfiguration();

			if (c2.isInnerComponentOf(c1)) {
				return -1;
			} else {
				return +1;
			}

			// if (cs.indexOf(c1)>=(cs.indexOf(c2))) {
			// return +1;
			// } else {
			// return -1;
			// }
		}

	}

	private List<String> references;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hPE.frontend.base.model.HHasExternalReferences#addExternalReferences(
	 * java.util.List)
	 */
	public void addExternalReferences(List<String> selectedReferences) {
		if (references == null) {
			references = new ArrayList<String>();
		}

		for (String ref : selectedReferences) {
			references.add(ref);
		}

	}

	@Override
	public void removeExternalReferences(List<String> selectedReferences) {
		if (references == null) {
			references = new ArrayList<String>();
		}
		for (String ref : selectedReferences) {
			this.references.remove(ref);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hPE.frontend.base.model.HHasExternalReferences#getExternalReferences()
	 */
	public Set<String> getExternalReferences() {
		if (references == null) {
			references = new ArrayList<String>();
		}

		Set<String> ss = new HashSet<String>();
		ss.addAll(references);
		return ss;
	}

	public String getPrimBaseName() {
		return this.baseName.isEmpty() ? null : this.baseName.get(0);
	}

	public List<String> getPrimBaseNameAll() {
		return this.baseName;
	}

	public void resetDefaultPortNames() {
		for (HPort port : this.getPorts())
		{
			for (HInterfaceSlice slice : port.getInterfaceSlices())
			{
			   slice.resetDefaultName();
			}
		}
		
	}

}
