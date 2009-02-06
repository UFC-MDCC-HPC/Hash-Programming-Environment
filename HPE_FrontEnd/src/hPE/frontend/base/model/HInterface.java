package hPE.frontend.base.model;

import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.codegen.c_sharp.HBESourceVersionCSharp;
import hPE.frontend.base.exceptions.HPENotFusableSlicesException;
import hPE.frontend.base.interfaces.IComponent;
import hPE.frontend.base.interfaces.IInterface;
import hPE.util.Pair;
import hPE.util.Triple;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.eclipse.draw2d.geometry.Point;

public abstract class HInterface extends HPrimInterface implements IInterface {

	static final long serialVersionUID = 1;
	
	public HInterface(HComponent configuration, HInterfaceSig signature,IHPrimUnit unit, Point where) {
		
		super(configuration,signature,unit, where);
		
		
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
		getListeners().firePropertyChange(HInterface.PROPERTY_SIGNATURE,null,getName2());
	}
	
	public final static String PROPERTY_NEW_MODULE = "PROPERTY_NEW_MODULE";
		
	public HPort fetchPort(String sliceOwner, String slicePortOriginalName) {
		HInterfaceSlice sOwner = this.fetchSlice(sliceOwner);
		for (HPort port_ : sOwner.getPorts()) {
			String originalName = port_.getOriginalNameOf(sOwner);
			if (originalName == null) 
				System.out.println("aaa");
			else if (originalName.equals(slicePortOriginalName)) {
				return port_;
			}
		}
		
		return null;
	}
		
	public HInterfaceSlice fetchSlice(String[] sliceQRef) {
		
		HInterface i = this;
		HInterfaceSlice s = null;
		for (int k=1; k<=sliceQRef.length-1;k++) {
			String ref = sliceQRef[k];
			s = i.fetchSlice(ref);
			if (s!=null) i = (HInterface) s.getInterface();
			else return null;
		}
		
		return s;
	}
	
	public HInterfaceSlice fetchSlice(String sliceRef) {
		
		Iterator<HInterfaceSlice> ss = this.getSlices().iterator();
		while (ss.hasNext()) {
			HInterfaceSlice s = ss.next();
			if (s.getName().equals(sliceRef)) return s;			
		}
		
		return null;
	}
	
	public void removeLinksInConfiguration(IComponent c) {

		Iterator ls = ((List)((ArrayList)this.getLinksToTheInterface()).clone()).iterator();
		while (ls.hasNext()) {
			HLinkToInterface l = (HLinkToInterface) ls.next();
			if (l.getLinked().getConfiguration() == c) {
				l.removeMe();
			}
			
		}
		
	}
	
	public List<Triple<String,HInterface,String>> getParameters() {
		HComponent cThis =(HComponent)this.getConfiguration();
		HComponent cThisI = cThis.getWhoItImplements();
		return getParameters2(cThisI == null ? cThis : cThisI);
	}
	
	public List<Triple<String,HInterface,String>> getParameters3() {
		return getParameters2(((HComponent)this.getConfiguration()).getWhoItImplements());
	}
	
    public List<Triple<String,HInterface,String>> getParameters3(HComponent cThis) {
    	
    	List<Triple<String,HInterface,String>> p = new ArrayList<Triple<String,HInterface,String>>();
    	
    	for (HInterfaceSlice c : this.getSlices()) {
    		HInterface ic = (HInterface) c.getInterface();
    		HComponent cc = (HComponent)ic.getCompliantUnits().get(0).getConfiguration();
    		
    		for (Triple<String,HInterface,String> innerParameter : ic.getParameters2(cThis)) {
    	    	p.add(innerParameter);
    	    }
    		
    		String parId = cc.getParameterIdentifier(cThis);

    	    if (cc.isParameter() && !parId.equals("type ?")) {
     	       String varName = cc.getVariableName(); 
     	       p.add(new Triple<String,HInterface,String> (varName,ic, parId));
     	    }
    	}    	
    	
    	return p;
    	
    }    

    public List<Pair<String,HInterface>> getParameters(HComponent cThis) {
    	
    	List<Pair<String,HInterface>> p = new ArrayList<Pair<String,HInterface>>();
    	
    	for (HInterfaceSlice c : this.getSlices()) {
    		HInterface ic = (HInterface) c.getInterface();
    		HComponent cc = (HComponent) ic.getConfiguration();
    		
    		for (Pair<String,HInterface> innerParameter : ic.getParameters(cThis)) {
    	    	p.add(innerParameter);
    	    }
    	    if (cc.isParameter() && !cc.getParameterIdentifier(cThis).equals("type ?")) {
     	       String varName = cc.getVariableName(); //.getParameterIdentifier((HConfiguration)cc.getConfiguration());
     	       p.add(new Pair<String,HInterface> (varName,ic));
     	    }
    	}    	
    	
    	return p;
    	
    }
    
    public List<String> getCompilationDependencies() {
    
    	List<String> ls = new ArrayList<String>();
    
    	HComponent c = (HComponent)this.getConfiguration();
    	String typeString = c.getPackagePath() + "." + c.getComponentName() + "." + this.getPrimName();
    	ls.add(typeString);
    	
    	List<Triple<String,HInterface,String>> pars = this.getParameters2((HComponent)this.getConfiguration());
    	
    	for (Triple<String,HInterface,String> p : pars) {
    	      HInterface i = p.snd();
    	      List<String> cds = i.getCompilationDependencies();
    	          	      
    	      for (String s : cds) {
    	    	  if (!ls.contains(s)) {
    	    	     ls.add(s);
    	    	  }
    	      }    	      
    	}
    	
    	
    	return ls;
    }
    
    public List<Pair<String,HInterface>> getCompilationDependencies3() {
        
    	List<String> lsStr = new ArrayList<String>();
    	List<Pair<String,HInterface>> ls = new ArrayList<Pair<String,HInterface>>();
    
    	HComponent c = (HComponent)this.getConfiguration();
    	String typeString = c.getPackagePath() + "." + c.getComponentName() + "." + this.getPrimName();
    	lsStr.add(typeString);
    	ls.add(new Pair<String,HInterface>(typeString,this));
    	
    	List<Triple<String,HInterface,String>> pars = this.getParameters2((HComponent)this.getConfiguration());
    	
    	for (Triple<String,HInterface,String> p : pars) {
    	      HInterface i = p.snd();
    	      List<Pair<String,HInterface>> cds = i.getCompilationDependencies3();
    	          	      
    	      for (Pair<String,HInterface> s : cds) {
    	    	  if (!lsStr.contains(s.fst())) {
    	    	     lsStr.add(s.fst());
    	    	     ls.add(s);
    	    	  }
    	      }    	      
    	}
    	
    	
    	return ls;
    }

    public List<HInterface> getCompilationDependencies2() {
        
    	List<HInterface> ls = new ArrayList<HInterface>();   
    	List<String> lsStr = new ArrayList<String>();
    	ls.add(this);
    	List<HInterface> pars = this.getSuppliedParameters((HComponent)this.getConfiguration());
    	
    	for (HInterface i : pars) {
    	      List<HInterface> cds = i.getCompilationDependencies2();
    	      
    	      for (HInterface s : cds) {
    	    	  if (!lsStr.contains(s.getPrimName())) {
    	    	     ls.add(s);
    	    	     lsStr.add(s.getPrimName());
    	    	  }
    	      }    	      
    	}
    	
    	return ls;
    }
    
    public List<Triple<String,HInterface,String>> getParameters2(HComponent cThis) {
    	
    	List<Triple<String,HInterface,String>> p = new ArrayList<Triple<String,HInterface,String>>();
    	
    	for (HInterfaceSlice c : this.getSlices()) {
    		HInterface ic = (HInterface) c.getInterface();
    		HComponent cc = (HComponent)ic.getCompliantUnits().get(0).getConfiguration();
    		
    		for (Triple<String,HInterface,String> innerParameter : ic.getParameters2(cThis)) {
    	    	p.add(innerParameter);
    	    }
    		
    		String parId = cc.getParameterIdentifier(cThis);

    	    if (cc.isParameter() && !parId.equals("type ?")) {
     	       String varName = cc.getVariableName(); 
     	       p.add(new Triple<String,HInterface,String> (varName,ic, parId));
     	    }
    	}    	
    	
    	return p;
    	
    }
    
    public List<HInterface> getSuppliedParameters(HComponent cThis) {
    	
    	List<HInterface> p = new ArrayList<HInterface>();
    	
    	for (HInterfaceSlice c : this.getSlices()) {
    		HInterface ic = (HInterface) c.getInterface();
    		HComponent cc = (HComponent)ic.getCompliantUnits().get(0).getConfiguration();
    		
    		for (HInterface innerParameter : ic.getSuppliedParameters(cThis)) {
    	    	p.add(innerParameter);
    	    }
    		
    	    if (cc.isParameter()) {
     	       p.add(ic);
     	    }
    	}    	
    	
    	return p;
    	
    }

    public String getParameterModifierName2(boolean complete,List<String> varContext) {
    	
    	int parameterized = 0;
    	String nameWithParameters = "";

    	List<String> vs = new ArrayList<String>();	
    	
    	for (Triple<String,HInterface,String> triple : this.getParameters()) {
    		String varName = triple.fst();
    		HInterface i = triple.snd();
    		String parId = triple.trd();
    		    		
   	        if (parameterized == 0) nameWithParameters = nameWithParameters.concat("<");
		       parameterized ++;			      
   	        if (!vs.contains(parId)) {
	           if (parameterized > 1) nameWithParameters += ", ";
    	       nameWithParameters = nameWithParameters + i.getName2(false, varContext);
            }
    		vs.add(parId /*varName*/);
    	}
    	    	
    	if (parameterized > 0) {
    		nameWithParameters = nameWithParameters.concat(">");
    	}
    	
    	return nameWithParameters;    	
    }	

    
    public String getParameterModifierName(boolean complete, boolean showBounds, int depth) {
    	
    	int parameterized = 0;
    	String nameWithParameters = "";

    	List<String> vs = new ArrayList<String>();	
    	
    	for (Triple<String,HInterface,String> triple : this.getParameters()) {
    		String varName = triple.fst();
    		HInterface i = triple.snd();
    		String parId = triple.trd();
    		    		
   	        if (parameterized == 0) nameWithParameters = nameWithParameters.concat("<");
		       parameterized ++;			      
   	        if (!vs.contains(parId)) {
	           if (parameterized > 1) nameWithParameters += ", ";
    	       nameWithParameters = nameWithParameters + i.getName(false, depth > 0 ? false : showBounds, depth+1);
            }
    		vs.add(parId /*varName*/);
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
    	return getName(showSuperType, showBounds,0);
    }

	public String getName(boolean showSuperType, boolean showBounds, int depth) {
		
		HComponent c = (HComponent) this.getCompliantUnits().get(0).getConfiguration();
		if (this.isAbstract()) {
		   String varName = c.getVariableName();
		   String parId = c.getParameterIdentifier((HComponent)c.getTopConfiguration());
		   return /*parId.concat(" = ").*/ varName + (showBounds ? ": " + this.getNonAbstractName(false,showBounds,depth) : "");
		}
		else {
		   return this.getNonAbstractName(showSuperType,showBounds, depth);
		}
	}
	
	public String getName2(boolean showSuperType, List<String> varContext) {
		
	   HComponent c = (HComponent) this.getCompliantUnits().get(0).getConfiguration();
	   String varName = c.getVariableName();
	   boolean showVariable = varContext.contains(varName);
	   boolean showBounds = !showVariable;
	   
	   return (showVariable ? varName.split("@")[0] : "") + 
	          (showVariable && showBounds ? ":" : "" ) +  
	          (showBounds ? this.getNonAbstractName2(false,varContext) : "");
	}
	
	public boolean isAbstract() {
		HComponent c = (HComponent) this.getCompliantUnits().get(0).getConfiguration();
		return c.isParameter() && c.getSupplied()==null;
	}
	
	public boolean isAbstract2() {
		HComponent c = (HComponent) this.getCompliantUnits().get(0).getConfiguration();
		return c.isParameter();
	}
	
	public boolean isAbstractInterface() {
		HComponent c = (HComponent) this.getConfiguration();
		return c.isAbstractConfiguration();
	}
	
	private String getNonAbstractName2(boolean showSuperType, List<String> varContext) {
		return this.getPrimName() + this.getParameterModifierName2(showSuperType,varContext) + (showSuperType && this.inheritedName != null ? ": " + this.getInheritedName() : "");
	}
	
	private String getNonAbstractName(boolean showSuperType, boolean showBounds, int depth) {
		return this.getPrimName() + this.getParameterModifierName(showSuperType,showBounds,depth) + (showSuperType && this.inheritedName != null ? ": " + this.getInheritedName() : "");
	}
	
	public HInterfaceSlice addInterfaceSlice(HUnitSlice uSlice, String name) throws HPENotFusableSlicesException {
		
	    HInterfaceSig isig = this.getSignature();
		
		HInterfaceSlice s = uSlice.newInterfaceSlice(name,isig);
		
		s.addCompliantUnitSlice(uSlice);
		uSlice.setInterfaceSlice(s);
		
		s.setBounds(uSlice.getBounds());						
	
	    if (getListeners()!=null) getListeners().firePropertyChange(PROPERTY_SIGNATURE,null,getName2());
		
	    return s;
	}

	
	
	
	public class ListHBESourceVersion implements TableModel, Serializable {
		
		static final long serialVersionUID = 1;
		
		private HInterface i = null;
		
		public ListHBESourceVersion(HInterface i) {
			this.i = i;
		}
		
		public HInterface getInterface() {
			return i;
		}
		
		/**
		 * @uml.property   name="sourceVersionList"
		 * @uml.associationEnd   multiplicity="(0 -1)" elementType="hPE.backend.cluster.synthesizer.HBESourceVersion"
		 */
		private Map<String,HBESourceVersion<HBEAbstractFile>> sourceVersionList = null;
		
		public List<HBESourceVersion<HBEAbstractFile>> getSourceVersionList() {
			List<HBESourceVersion<HBEAbstractFile>> l = new ArrayList<HBESourceVersion<HBEAbstractFile>>();
			if (this.sourceVersionList == null) this.sourceVersionList = new HashMap<String,HBESourceVersion<HBEAbstractFile>>();
			l.addAll(sourceVersionList.values());
			return l;
		}
		
		public void addSourceVersion(HBESourceVersion<HBEAbstractFile> sourceVersion) {
			if (this.sourceVersionList == null) this.sourceVersionList = new HashMap<String,HBESourceVersion<HBEAbstractFile>>();
			this.sourceVersionList.put(sourceVersion.getVersionID(),sourceVersion);
		}
		
		public void delSourceVersion(HBESourceVersion<HBEAbstractFile> sourceVersion) {
			if (this.sourceVersionList == null) this.sourceVersionList = new HashMap<String,HBESourceVersion<HBEAbstractFile>>();
			this.sourceVersionList.remove(sourceVersion.getVersionID());
		}
		
		public HBESourceVersion<HBEAbstractFile> getVersion(String versionID) {
			if (this.sourceVersionList == null) this.sourceVersionList = new HashMap<String,HBESourceVersion<HBEAbstractFile>>();
			return this.sourceVersionList.get(versionID);
		}
		
		public boolean noSources() {
			return getSourceVersionList() == null || getSourceVersionList().isEmpty();
		}
		
		public void cleanSources() {
			this.sourceVersionList = new HashMap<String,HBESourceVersion<HBEAbstractFile>>();
		}
	
		public void cleanSource(HBESourceVersion<HBEAbstractFile> srcVersion) {
			
			this.sourceVersionList.remove(srcVersion.getVersionID());
			
		}
		
		// Methods of Table Model.
		
	    public int getRowCount() {
	    	int r = this.getSourceVersionList().size() ;
	    	return r;
	    }

	    public int getColumnCount() {
	    	return 2;
	    }

	    public String getColumnName(int columnIndex) {
	    	switch (columnIndex) {
	    	case 0: return "Version";
	    	case 1: return "Source Type";
	    	//case 2: return "Created";
	    	}
	    	return "";
	    }

	    public Class<?> getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }


	    public boolean isCellEditable(int rowIndex, int columnIndex) {
	    	HBESourceVersion<HBEAbstractFile> srcVersion = this.getSourceVersionList().get(rowIndex);
	    	
	    	switch (columnIndex) {
	    	case 0: return false; 
	    	case 1: return srcVersion.getFiles().size() == 0;
	    	case 2: return false; 
	    	}
	    	return false;
	    }

	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	
	    	HBESourceVersion<HBEAbstractFile> srcVersion = this.getSourceVersionList().get(rowIndex);
	    	
	    	HComponent c = (HComponent) i.getConfiguration();
	    	
	    	boolean abs = c.isAbstractConfiguration();
	    	
	    	String type = srcVersion.getFiles().size() == 0 ? (srcsUndef.containsKey(srcVersion) ? srcsUndef.get(srcVersion) : "Undefined") : srcVersion.getSynthesizerType(abs);
	    	
	    	switch (columnIndex) {
	    	case 0: return srcVersion; 
	    	case 1: return type;
	    	//case 2: return srcVersion.getFiles().size() == 0 ? "no" : "yes"; 
	    	}
	    	
	    	return null;	    	
	    }

	    private Map<HBESourceVersion<HBEAbstractFile>, String> srcsUndef = new HashMap<HBESourceVersion<HBEAbstractFile>, String>();
	    
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	    	HBESourceVersion<HBEAbstractFile> srcVersion = this.getSourceVersionList().get(rowIndex);
	    	if (columnIndex == 1 && srcVersion.getFiles().size()==0)
	    		srcsUndef.put(srcVersion, (String) aValue.toString());
	    }

	    public void addTableModelListener(TableModelListener l) {
	    	
	    }

	    public void removeTableModelListener(TableModelListener l) {
	    	
	    }

		public void reset() {
			srcsUndef.clear();			
		}
		
		
	}
	
	private ListHBESourceVersion srcVersions = new ListHBESourceVersion(this);
	
	public void addSourceVersion(HBESourceVersion sourceVersion) {
		getSourceVersionList().addSourceVersion(sourceVersion);
	}
	
	public void replaceSourceVersion(HBESourceVersion sourceVersionOld, HBESourceVersion sourceVersionNew) {
		getSourceVersionList().delSourceVersion(sourceVersionOld);
		getSourceVersionList().addSourceVersion(sourceVersionNew);
	}
	
	public ListHBESourceVersion getSourceVersionList() {
		if (srcVersions == null) srcVersions = new ListHBESourceVersion(this);
		return srcVersions;
	}
	
	public Collection<HBESourceVersion<HBEAbstractFile>> getSourceVersions() {
		return getSourceVersionList().getSourceVersionList();
	}
	
	public HBESourceVersion<HBEAbstractFile> getSourceVersion(String versionID) {
		return srcVersions.getVersion(versionID);
	}
	
	public boolean noSources() {
		return getSourceVersionList().noSources();
	}
	
	public void cleanSources() {
		getSourceVersionList().cleanSources();		
	}

	public void cleanSource(HBESourceVersion<HBEAbstractFile> srcVersion) {
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
		
	
    public HInterface peekThatOneThatIsSubTypeOfTheOthers(List<HInterface> is) {
        
   	 // Among the components passed as parameters, peek the one that is subtype of the others. 
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
		
		  return (c1.isSubTypeOf(c2) && (this.toString().equals(i.toString()) || this.getSuperTypeID().equals(i.toString())));
		
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
	
	public void setImplements () {
		this.cleanSources();
	}
	
	public boolean isEquivalentTo(HInterface i) {
          return this.isSubTypeOf(i) && i.isSubTypeOf(this);		
	}
	
	 
	
	// PUT S2 IN PLACE OF S1.
	public void replaceSlice (HInterfaceSlice s1, HInterfaceSlice s2) {
		
		this.getSignature().replaceSlice(s1,s2);
		
		getListeners().firePropertyChange(PROPERTY_COLOR, null, getName2());
		
	}
	
	public HInterfaceSlice fetchSlice(String cRef, String iRef) {
		
		for (HInterfaceSlice s : this.getSlices()) {
			HComponent c = (HComponent) s.getInterface().getConfiguration();
			if (c.getRef().equals(cRef)) {
				HInterface i = c.fetchInterface(iRef);
				if (i==null) return null;
				else return s;
			}
		}
		
		return null;
	}

	public final static String PROPERTY_EDITABLE_SOURCE = "PROPERTY_EDITABLE_SOURCE";

	private boolean IsEditableSource = true;
	
	public void setEditableSource(boolean isEditableSource) {
		this.IsEditableSource = isEditableSource;
	   	this.getListeners().firePropertyChange(PROPERTY_EDITABLE_SOURCE,null,getName2());
	}
	
	public boolean getIsEditableSource() {
		return this.IsEditableSource;
	}
		
	private String inheritedName = null;
	
	private void saveInheritedName() {
		inheritedName = this.getName(false, true);
		this.setName(null);
	}
	
	public String getInheritedName() {
		return this.inheritedName;		
	}
	
	private void setInheritedSlices() {
	
		for (HInterfaceSlice s : this.getSlices()) {
			s.setInerited(true);
			((HInterface)s.getInterface()).setInheritedSlices();
		}
		    
		
	}
	
	public void setInherited(HComponent topConfiguration) {
 	    this.setSuperTypeID(this.toString());
 	    this.saveInheritedName();
		this.setConfiguration(topConfiguration); // ?????????????????????????????????????????
 	    this.setEditable(true);
 	    this.setInheritedSlices();
	}
	
	public void setImplemented(HComponent topConfiguration) {
		this.saveInheritedName();
		this.setConfiguration(topConfiguration); // ?????????????????????????????????????????
		this.setEditable(true);
		this.setEditableSource(true);
 	    // this.setInheritedSlices();
	}


	public List<HPort> getPorts() {
		return this.getSignature().getPorts();
	}

	public int getParametersCount() {
		
		List<Triple<String,HInterface,String>> t = this.getParameters();
		List<String> r = new ArrayList<String>();
		
		for (Triple<String,HInterface,String> param : t) {
		   if (!r.contains(param.fst())) 
			   r.add(param.fst());
		}
		
		return r.size();
	}

	public void keepVersionConsistency() {
		
		HComponent c = (HComponent)this.getConfiguration();
		
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
	    if (sourceType.equals(hPE.frontend.kinds.application.codegen.c_sharp.HBESourceVersionCSharp.getType()))	{
		    return new hPE.frontend.kinds.application.codegen.c_sharp.HBESourceVersionCSharp();
	    } else if (sourceType.equals(HBESourceVersionCSharp.getType())) {
	    	return  new HBESourceVersionCSharp();
	    } else {
	        return null;
	    }
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
		
		for (int i=0; i<vI.length; i++) { 
			vIn[i] = Integer.parseInt(vI[i]);
		}
		return vIn;
	}
	
	
}
