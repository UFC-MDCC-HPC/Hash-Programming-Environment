package br.ufc.mdcc.hclc.codegen.xml.factory;

//import hPE.HPEProperties;
import br.ufc.mdcc.hclc.codegen.xml.component.*;
import br.ufc.mdcc.hclc.codegen.xml.component.util.*;
import br.ufc.mdcc.hclc.hpeproperties.HPEProperties;
import br.ufc.mdcc.hclc.symboltable.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public final class HComponentFactoryImpl implements HComponentFactory {

	public HComponentFactoryImpl() {
		super();
	}

	public static HComponentFactory eInstance = new HComponentFactoryImpl();

	public void saveComponent(ComponentType cX, File file,
			IProgressMonitor monitor) {
		try {
			// Create a resource set to hold the resources.
			//
			ResourceSet resourceSet = new ResourceSetImpl();

			// Register the appropriate resource factory to handle all file
			// extentions.
			//
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
					.put(Resource.Factory.Registry.DEFAULT_EXTENSION,
							new ComponentResourceFactoryImpl());

			// Register the package to ensure it is available during loading.
			//
			resourceSet.getPackageRegistry().put(ComponentPackage.eNS_URI,
					ComponentPackage.eINSTANCE);

			// If there are no arguments, emit an appropriate usage message.
			//
			URI uri = URI.createURI(file.getAbsolutePath());
			Resource resource = resourceSet.createResource(uri);

			DocumentRoot dX = factory.createDocumentRoot();
			// ComponentType cX = saveComponent2(c);
			dX.setComponent(cX);

			// file.setContents(dX, true, false, monitor);

			resource.getContents().add(dX);
			resource.save(null);

		} catch (IOException e) {

		}

	}

	public void saveComponent(Component c, File file, IProgressMonitor monitor) {

		this.component = c;
		ComponentType cX = marshallComponent(c);
		this.saveComponent(cX, file, monitor);

	}

	// Loads a ComponentType object from XML in a HComponent object

    HPEProperties properties = HPEProperties.getInstance();
	
	private Component component = null;

	private ComponentFactory factory = ComponentFactory.eINSTANCE;

	// Saves a HComponent object in a ComponentType object
	public ComponentType marshallComponent(Component c) {

		ComponentType xC = factory.createComponentType();
		ComponentHeaderType xH = factory.createComponentHeaderType();
		ComponentBodyType xI = factory.createComponentBodyType();
		xC.setHeader(xH); 
		xC.setComponentInfo(xI);

		saveHeader(c, xC.getHeader());
		saveInfo(c, xC.getComponentInfo());

		return xC;
	}

	private void saveHeader(Component c, ComponentHeaderType xH) {

		Extend sC = c.getName_base();
		Usings_list usings = c.getUsings_list();
		
		boolean isAbstract = sC != null && sC.isImplements();
		// save name
		xH.setName(c.getName());
		// save kind
		xH.setKind(SupportedKinds.get(c.getKind()));
		// save base type
		if (sC != null)
			saveBaseType(sC,usings, xH, isAbstract);

		// save package path
		xH.setPackagePath(c.getPackage());
		
		// save HashComponentUID
		// xH.setHashComponentUID(null);

		// save Remote Location UID
		// xH.setLocationURI(null);

		xH.setIsAbstract(isAbstract);
		
		VisualElementAttributes v = factory.createVisualElementAttributes();
		saveVisualDescription(c,v);		
		xH.setVisualAttributes(v);

		saveVersions(c, xH.getVersions());

	}

	private void saveVersions(Component sc, EList<VersionType> list) {

		for (Integer[] version : sc.getVersions()) {
			VersionType v = factory.createVersionType();
			v.setField1(version[0]);
			v.setField2(version[1]);
			v.setField3(version[2]);
			v.setField4(version[3]);
			list.add(v);
		}

	}

	private static String BASE_DEFAULT_REF = "base";
	
	private void saveBaseType(Extend baseType, Usings_list usings, ComponentHeaderType xH, boolean isAbstract) {
		
		BaseTypeType baseTypeX = factory.createBaseTypeType();
		ExtensionTypeType extType = factory.createExtensionTypeType();
		ComponentInUseType superTypeX = factory.createComponentInUseType();

		if (isAbstract)
			extType.setExtends(true);
		else
			extType.setImplements(true);

		baseTypeX.setExtensionType(extType);
		baseTypeX.setComponent(superTypeX);

		String name = baseType.getConfig().getId();
		String location = properties.getValue("local_location");
		String version = "1.0.0.0";
		String package_ = usings.packageOf(name);
		// String hash_component_UID = null;
		VisualElementAttributes v = factory.createVisualElementAttributes();
		saveVisualDescription(baseType, v);

		superTypeX.setName(name);
		superTypeX.setLocalRef(BASE_DEFAULT_REF);
		superTypeX.setLocation(location);
		superTypeX.setVersion(version);
		superTypeX.setPackage(package_);
		superTypeX.setVisualDescription(v);
		// superTypeX.setHashComponentUID(hash_component_UID);

		xH.setBaseType(baseTypeX);

		EList parameterRenaming = superTypeX.getParameter();
		saveVisualDescription(baseType, v);

		EList<UnitBoundsType> unitBounds = superTypeX.getUnitBounds();

		saveParameterRenamings(baseType, parameterRenaming); // OK !
		// savePorts(baseType, superTypeX.getPort());
		// saveUnitBounds(baseType.getAllUnits(), unitBounds);
	}

	private void saveInfo(Component c, ComponentBodyType xI) throws UndefinedRefInnerException, DuplicatedRefInnerException, DuplicatedSliceNamesException {

		saveInnerComponents(c, xI.getInnerComponent()); // OK !
		saveSupplyParameters(c, xI.getSupplyParameter()); // OK !
		saveParameters(c, xI.getParameter()); // OK !
		saveInnerRenamings(c, xI.getInnerRenaming());
		saveFusions(c, xI.getFusion());
		saveSplits(c, xI.getSplit());
		saveInterfaces(c, xI.getInterface());
		saveUnits(c, xI.getUnit());
		saveRecursiveEntries(c, xI.getRecursiveEntry());
		saveEnumerator(c.gettReplicators(), xI.getEnumerator());
		saveEnumeratorFusions(c.gettReplicators(), xI.getFusionsOfReplicators());
	}

	private void saveEnumeratorFusions(List<HReplicator> rs,
			EList<FusionsOfReplicatorsType> fRs) {

		List<HReplicator> touchedR = new ArrayList<HReplicator>();

		for (HReplicator r : rs) {
			HReplicator topR = r.getTopJoined();
			if (topR != r && !touchedR.contains(topR)) {
				touchedR.add(topR);
				List<List<HReplicator>> ss = topR.getFusionsInContext(this.component);

				for (List<HReplicator> rrs : ss) {
					FusionsOfReplicatorsType fOfr = factory
							.createFusionsOfReplicatorsType();
					EList<FusionOfReplicatorsType> ffs = fOfr
							.getFusionOfReplicators();
					FusionOfReplicatorsType ff = factory
							.createFusionOfReplicatorsType();
					ff.setERef(topR.getRef());
					List<Component> cOfrs = new ArrayList<Component>(topR
							.getConfigurations()); // ;
													// (Component)topR.getConfiguration();
					cOfrs.remove(0);
					List<String> cRefs = ff.getOriginRef();
					Component cOfr_ = null;
					for (Component cOfr : cOfrs) {
						String ref = cOfr_ != null
								&& cOfr.getSavedName().containsKey(cOfr_) ? cOfr
								.getSavedName().get(cOfr_)
								: cOfr.getRef();
						cRefs.add(ref);
						cOfr_ = cOfr;
					}

					ffs.add(ff);
					for (HReplicator r_ : rrs) {
						ff = factory.createFusionOfReplicatorsType();
						ff.setERef(r_.getRef());
						cOfrs = new ArrayList<Component>(r_
								.getConfigurations()); // ;
														// (Component)topR.getConfiguration();
						cOfrs.remove(0);
						cRefs = ff.getOriginRef();
						cOfr_ = null;
						for (Component cOfr : cOfrs) {
							String ref = cOfr_ != null
									&& cOfr.getSavedName().containsKey(cOfr_) ? cOfr
									.getSavedName().get(cOfr_)
									: cOfr.getRef();
							cRefs.add(ref);
							cOfr_ = cOfr;
						}

						ffs.add(ff);
					}
					fRs.add(fOfr);
					// }
				}
			}
		}

	}

	private void saveInnerRenamings(Component c, EList<InnerRenamingType> xRs) {

		Map<Component, List<Component>> vcs = new HashMap<Component, List<Component>>();

		for (Component vc : c.getComponents()) {
			// vcs.(c,vc);
			for (Component vc_ : vc.getExposedComponents())
				if (!vcs.containsKey(vc_)) {
					List<Component> l = new ArrayList<Component>();
					l.add(vc);
					vcs.put(vc_, l);
				} else {
					List<Component> l = vcs.get(vc_);
					l.add(vc);
				}
		}

		for (Entry<Component, List<Component>> vc : vcs.entrySet()) {
			List<Component> d1s = vc.getValue();
			Component d2 = vc.getKey();
			for (Component d1 : d1s) {
				String cRef = d1.getRef();
				String oldName = d2.getSavedName().get(d1);
				String newName = d2.getRef();
				if (oldName != null && !oldName.equals(newName)) {
					InnerRenamingType ir = factory.createInnerRenamingType();
					ir.setCRef(cRef);
					ir.setCOldName(oldName);
					ir.setCNewName(newName);
					xRs.add(ir);
				}
			}
		}
	}

	private void saveFusions(Component c, EList<FusionType> xFs) {

		Map<Component, List<Component>> vcs = new HashMap<Component, List<Component>>();

		for (Component _c : c.getComponents()) {
			for (Component __c : _c.getExposedComponents()) {
				if (vcs.containsKey(__c)) {
					List<Component> cs = vcs.get(__c);
					cs.add(0, _c);
				} else {
					List<Component> cs = new ArrayList<Component>();
					cs.add(_c);
					vcs.put(__c, cs);
				}
			}
		}

		List<Component> ccs1 = new ArrayList<Component>();
		List<Component> ccs2 = new ArrayList<Component>();
		
		for (Entry<Component, List<Component>> e : vcs.entrySet()) {
			if (e.getValue().size() <= 1) {
				ccs1.add(e.getKey());
			} else {
				ccs2.add(e.getKey());
			}
		}
		
		for (Component cc : ccs1) {
			vcs.remove(cc);
		}
		
		for (Entry<Component, List<Component>> e : vcs.entrySet()) {
			Component p = e.getKey();
			boolean flag = false;
			for (Component cc : ccs2) {
				if (cc != p && cc.getAllInnerConfigurations().contains(p)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				FusionType f = factory.createFusionType();
				xFs.add(f);
				f.setPRef(p.getRef());
				EList<String> ps = f.getCRefs();
				for (Component _c : e.getValue()) {
					ps.add(_c.getName2());
				}
			}
		}
	}

	private void saveParameters(Component c, EList<ParameterType> xI) {

		List<Component> cs = new ArrayList<Component>();

		cs.addAll(c.getComponents());
		for (Entry<String, Component> p : c.getSupplierComponents().entrySet())
			cs.add(p.getValue());

		for (Component ic : cs) {

			if (ic.isParameter() && ic.getSupplied() == null) {
				String formFieldId = null;
				String cRef = null;
				String varName = null;

				// SETUP VARIABLES

				formFieldId = ic.getParameterIdentifier(c);
				cRef = ic.getRef();
				varName = ic.getVariableName(c);

				// ---------------

				ParameterType p = factory.createParameterType();
				p.setFormFieldId(formFieldId);
				p.setComponentRef(cRef);
				p.setVarName(varName);

				xI.add(p);
			}
		}

	}

	private void saveInnerComponents(Component c, EList xI) {

		List<Component> cs = new ArrayList<Component>();
        int i = 0;
        
        List<String> cRefs = new ArrayList<String>();
		
        for (Component cInner : c.getComponents()) {
		    cs.add(cInner);
		    String cRef = cInner.getRef();
			if (cRefs.contains(cRef)) {
				   throw new DuplicatedRefInnerException(cRef); 
			} else {
			   cRefs.add(cRef);
			}
        }
        
		for (Entry<String, Component> p : c.getSupplierComponents().entrySet()) {
			cs.add(i++, p.getValue());
			String cRef = p.getValue().getRef();
			if (cRefs.contains(cRef)) {
				   throw new DuplicatedRefInnerException(cRef); 
			} else {
			   cRefs.add(cRef);
			}
		}
		
		if (c.isAbstract()) {
			for (HReplicator r : c.gettReplicators()) {
				for (HReplicatorSplit lr : r.getSplits()) {
					HEnumeratorComponent ec = lr.getPermutation();
					if (ec != null && !cs.contains(ec)) {
						cs.add(0,ec);
						String cRef = ec.getRef();
						if (cRefs.contains(cRef)) {
							   throw new DuplicatedRefInnerException(cRef); 
						} else {
						   cRefs.add(cRef);
						}
					}
				}
			}
		}

		for (Component ic : cs) {

			if (!ic.isDerivedFromPermutation() && ic != c.getSuperType() && ic != c.getWhoItImplements()) {
                
				InnerComponentType d = factory.createInnerComponentType();
				
				saveInnerComponent(ic, d);

				xI.add(d);
			}

		}
	}

	/*
	 * private void savePorts(Component ic, EList<PortType> ports) {
	 * 
	 * for (Component c : ic.getExposedComponents()) { PortType port =
	 * factory.createPortType(); String pRef = c.getSavedName().get(ic);
	 * port.setPRef(pRef != null ? pRef : c.getRef());
	 * port.setExposed(c.getExposed()); ports.add(port); VisualElementAttributes
	 * v = factory.createVisualElementAttributes();
	 * port.setVisualDescription(v); saveVisualDescription(c,v); }
	 * 
	 * }
	 */

	private void saveInnerComponent(Component ic, InnerComponentType d) throws UndefinedRefInnerException {

		VisualElementAttributes v = factory.createVisualElementAttributes();
		String name = ic.getComponentName();
		String localRef = ic.getRef();

		String location = ic.getRemoteLocation() == null ? ic.getRelativeLocation() : ic.getRemoteLocation();
		String package_ = ic.getPackagePath().toString();
		boolean exposed = ic.getExposed();
		String hash_component_UID = ic.getHasComponentUID();

		String parameterId = ic.getParameterIdentifier(this.component);

		if (localRef.equals(Component.UNDEFINED_NAME)) {
			throw new UndefinedRefInnerException(ic);
		}
		
		d.setLocalRef(localRef);
		d.setLocation(location);
		d.setPackage(package_);
		d.setName(name);
		//d.setVersion(version);
		d.setExposed(exposed);
		d.setHashComponentUID(hash_component_UID);
		d.setVisualDescription(v);
		if (!parameterId.equals("type ?"))
			d.setParameterId(parameterId);

		EList<ParameterRenaming> parameterRenaming = d.getParameter();
		EList<UnitBoundsType> unitBounds = d.getUnitBounds();
		// EList<PortType> ports = d.getPort();
		EList<InnerComponentType> ports = d.getPort();

		saveParameterRenamings(ic, parameterRenaming); // OK !
		savePorts(ic, ports);
		saveUnitBounds(ic.getAllUnits(), unitBounds);
		saveVisualDescription(ic, v);

	}

	private void savePorts(Component ic, EList<InnerComponentType> ports) throws UndefinedRefInnerException {

		for (Component c : ic.getExposedComponents()) 
		{
			InnerComponentType port = factory.createInnerComponentType();

			saveInnerComponent(c, port);

			String pRef = c.getSavedName().get(ic);
			port.setLocalRef(pRef != null ? pRef : c.getRef());

			ports.add(port);
		}

	}

	private void saveUnitBounds(List<IHUnit> units, EList unitBounds) {

		Integer replica = null;

		for (IHUnit u : units) {

			if (u.isClone()) {
				replica = u.cloneOf().getIndexOfClone(u);
			} else if (u.isCloned()) {
				replica = 0;
			}

			UnitBoundsType b = factory.createUnitBoundsType();
			VisualElementAttributes v = factory.createVisualElementAttributes();

			b.setURef(u.getName2());
			if (replica != null)
				b.setReplica(replica);
			b.setVisualDescription(v);

			saveVisualDescription(u, v);

			unitBounds.add(b);
		}

	}

	private void saveRecursiveEntries(Component component, EList xI) {

		for (Component c : component.getComponents()) {
			if (c.isRecursive()) {
				RecursiveEntryType r = factory.createRecursiveEntryType();
				r.setCRef(c.getName2());
				xI.add(r);
			}
		}
	}

	private void saveSplits(Component c, EList<SplitType> splitsX) {

		for (HReplicator r : c.gettReplicators()) {
			for (HReplicatorSplit split : r.getSplits()) {
				if (split.getContext() == c.getTopConfiguration()) {
					SplitType splitX = factory.createSplitType();

					String eRef = r.getRef();
					int n = split.getN();
					String cRefPermutation = split.getPermutation() != null ? split.getPermutation().getRef() : null;

					splitX.setERef(eRef);
					splitX.setN(n);
					if (cRefPermutation != null)
						splitX.setCRefPermutation(cRefPermutation);

					List<String> oRef = splitX.getOriginRef();
					List<Component> cOfrs = new ArrayList<Component>(r
							.getConfigurations()); // ;
													// (Component)topR.getConfiguration();
					cOfrs.remove(0);
					Component cOfr_ = null;
					for (Component cOfr : cOfrs) {
						String ref = cOfr_ != null
								&& cOfr.getSavedName().containsKey(cOfr_) ? cOfr
								.getSavedName().get(cOfr_)
								: cOfr.getRef();

						oRef.add(ref);
						cOfr_ = cOfr;
					}

					if (n != splitX.getSplitEnumerator().size()) { /* ERROR */
					}

					saveSplitLinks(split.getSplitLinks(), splitX.getSplitLink());
					saveSplitEnumerators(split.getTheReplicators(), splitX
							.getSplitEnumerator());

					splitsX.add(splitX);
				}
			}

		}
	}

	private void saveSplitLinks(List<HLinkToReplicator> links, EList splitsX) {

		for (HLinkToReplicator l : links) {

			IPointsToReplicator p = l.getReplicated();
			if (p instanceof HUnit) { /* ERROR */
			}
			HUnit u = (HUnit) p;
			Component cu = (Component) u.getConfiguration();
			if (cu.isTopConfiguration()
					|| !((Component) cu.getTopConfiguration()).getComponents()
							.contains(cu)) { /* ERROR */
			}

			SplitLinkType splitLink = factory.createSplitLinkType();
			splitLink.setCRef(cu.getRef());
			splitLink.setURef(u.getName2());
			splitsX.add(splitLink);

		}

	}

	private void saveSplitEnumerators(Collection<HReplicator> rs, EList enumsX) {
		for (HReplicator r : rs) {
			enumsX.add(r.getRef());
		}
	}

	private void saveParameterRenamings(Component c, EList parameterRenamings) {

		for (Entry<String, List<Component>> param : c.getParameters().entrySet()) {

			String formField = null;
			String varName = null;

			// SETUP VARIABLES: look for the current variable name of the
			// parameter in the configuration

			Component cc = param.getValue().get(0);

			varName = cc.getVariableName(component);
//			if (varName.equals("?"))
//			     varName = cc.getVariableName(c.getTopParentConfigurations().get(0));
			
			
			if (varName.indexOf('@') >= 0)
				varName = varName.substring(0, varName.indexOf('@'));
			formField = cc.getParameterIdentifier(c);

			// ---------------

			ParameterRenaming r = factory.createParameterRenaming();

			r.setFormFieldId(formField);
			r.setVarName(varName);

			parameterRenamings.add(r);
		}

	}

	private void saveInterfaces(Component c, EList<InterfaceType> xI) {

		for (HInterface i : c.getInterfaces())
			if (i.getConfiguration() == c) { // Only interfaces of the top
												// configuration

				ActionType a = null;
				String iRef = null;
				VisualElementAttributes v = factory
						.createVisualElementAttributes();

				int nargs = i.getParametersCount();

				InterfaceType iX = factory.createInterfaceType();

				// SETUP VARIABLES

				iRef = i.getPrimName();
				if (i instanceof HActivateInterface) {
					HActivateInterface ia = (HActivateInterface) i;
					if (ia.getProtocol() != null) {
						a = saveAction((HAction) ia.getProtocol().getAction());
						iX.setProtocol(a);
					}
				}
				// ---------------

				iX.setIRef(iRef);
				iX.setVisualDescription(v);
				iX.setNArgs(nargs);

				EList<InterfaceSliceType> slicesX = iX.getSlice();
				EList<SourceType> sourcesX = iX.getSources();
				EList<InterfacePortType> portsX = iX.getPort();
				EList<InterfaceParameterType> parametersX = iX.getParameter();

				saveInterfaceSlices(i.getSlices(), slicesX);
				saveInterfacePorts(i.getPorts(), portsX);
				saveSources(i.getSourceVersions(), sourcesX);
				saveParameters(i.getParameters(), parametersX);
				
				saveVisualDescription(i, v);
				
				List<String> externalRefs = iX.getExternalReferences();
				for (String eRef : i.getExternalReferences()) {
					externalRefs.add(eRef);
				}

				xI.add(iX);
			}

	}

	private void saveParameters(
			List<Triple<String, HInterface, String>> parameters,
			EList<InterfaceParameterType> parametersX) {
		
		Map<String,Integer> m = new HashMap<String,Integer>();
		
		int order = 0;
		for (Triple<String,HInterface,String> parameter : parameters) {
		    InterfaceParameterType parX = factory.createInterfaceParameterType();
		    parX.setParid(parameter.fst());		   
		    if (!m.containsKey(parX.getParid())) {
			   parX.setVarid(parameter.trd());
			   parX.setIname(parameter.snd().getPrimName());
			   parX.setUname(parameter.snd().getCompliantUnits().get(0).getName2());
	    	   parX.setOrder(order++);
		       parametersX.add(parX);
		       m.put(parX.getParid(),parX.getOrder());
		    }
		}
		
		
	}

	private void saveInterfacePorts(List<HPort> ports,
			EList<InterfacePortType> portsX) {

		for (HPort p : ports) {
			InterfacePortType portX = factory.createInterfacePortType();
			VisualElementAttributes v = factory.createVisualElementAttributes();
			List<PortSliceType> portSliceL = portX.getSlice();

			for (HInterfaceSlice sOwner : p.getOwners()) {

				String sRef = sOwner.getName();
				String pRef = p.getDefaultNameOf(sOwner);

				PortSliceType pst = factory.createPortSliceType();
				pst.setPRef(pRef);
				pst.setSRef(sRef);
				portSliceL.add(pst);
			}

			/*
			 * List<PortSliceType> portSliceL = portX.getSlice();
			 * Iterator<HInterfaceSlice> ss1 = p.getOwners().iterator();
			 * Iterator<HInterfaceSlice> ss2 =
			 * p.getInterfaceSlices().iterator(); while (ss1.hasNext() &&
			 * ss2.hasNext()) { HInterfaceSlice s1 = ss1.next(); HInterfaceSlice
			 * s2 = ss2.next(); String sRef = s1.getName(); String pRef =
			 * s2.getName(); PortSliceType pst = factory.createPortSliceType();
			 * pst.setPRef(pRef); pst.setSRef(sRef); portSliceL.add(pst); }
			 */
			portX.setName(p.getName());
			portX.setVisualDescription(v);
			saveVisualDescription(p, v);
			portsX.add(portX);
		}

	}

	private ActionType saveAction(HAction action) {

		ActionType actionX = null;

		if (action instanceof HCombinatorAction) {

			if (action instanceof HParAction) {
				actionX = factory.createActionCombinatorParType();

			} else if (action instanceof HSeqAction) {
				actionX = factory.createActionCombinatorSeqType();

			} else if (action instanceof HAltAction) {
				actionX = factory.createActionCombinatorAltType();
			}

			EList innerActionsX = ((ActionCombinatorType) actionX).getAction();

			HCombinatorAction combinatorAction = (HCombinatorAction) action;

			for (HAction a : combinatorAction.getActions()) {
				innerActionsX.add(saveAction(a));
			}

		} else if (action instanceof HPrimitiveAction) {
			if (action instanceof HDoAction) {
				actionX = factory.createActionActivateType();
				ActionActivateType actionXX = (ActionActivateType) actionX;
				IInterfaceSlice s = ((HDoAction) action).getSliceAbstraction();
				if (s != null)
				   actionXX.setSliceRef(s.getName()); 
			} else if (action instanceof HWaitAction) {
				actionX = factory.createActionWaitType();
				ActionWaitType actionXX = (ActionWaitType) actionX;
				actionXX.setSemaphore(((HWaitAction) action).getSemaphore()
						.getName());
			} else if (action instanceof HSignalAction) {
				actionX = factory.createActionSignalType();
				ActionSignalType actionXX = (ActionSignalType) actionX;
				actionXX.setSemaphore(((HSignalAction) action).getSemaphore()
						.getName());
			} else if (action instanceof HSkipAction) {
				actionX = factory.createActionSkipType();
				ActionSkipType actionXX = (ActionSkipType) actionX;
			}
		}

		VisualElementAttributes vX = factory.createVisualElementAttributes();
		saveVisualDescription(action, vX);
		actionX.setLabel(action.getLabel());
		actionX.setRepeat(action.getRepeatDepth());
		actionX.setVisualDescription(vX);

		return actionX;
	}

	private void saveVisualDescription(Object v, VisualElementAttributes vX) {

		if (v instanceof IHasColor) {
			IHasColor color = (IHasColor) v;
			ColorComplexType colorX = factory.createColorComplexType();
			colorX.setR((short) color.getColor().getRed());
			colorX.setG((short) color.getColor().getGreen());
			colorX.setB((short) color.getColor().getBlue());
			vX.setColor(colorX);
		}

		if (v instanceof IHVisualElement) {
			IHVisualElement ve = (IHVisualElement) v;
			if (ve.getBounds() != null) {
				vX.setX(ve.getBounds().x);
				vX.setY(ve.getBounds().y);
				vX.setH(ve.getBounds().height);
				vX.setW(ve.getBounds().width);
			}
		}

	}

	private void saveSources(
			Collection<HBESourceVersion<HBEAbstractFile>> sources,
			EList<SourceType> sourcesX) {

		for (HBESourceVersion<HBEAbstractFile> src : sources) {
			SourceType s = factory.createSourceType();

			List<SourceFileType> fsX = s.getFile();

			for (HBEAbstractFile f : src.getFiles()) {
				SourceFileType fX = factory.createSourceFileType();
				String uri = f.getBinaryPath().toString();
				String fileType = f.getFileType();
				String versionIdF = f.getVersionID();
				String srcType = f.getSrcType();
				fX.setUri(uri);
				fX.setFileType(fileType);
				fX.setName(f.getFileName());
				fX.setContents(f.getCurrentContents());
				fX.setVersionId(checkVersion(versionIdF) ? versionIdF : "1.0.0.0");
				fX.setSrcType(srcType == null ? "base" : srcType);
				List<String> deps = fX.getDependency();
				deps.addAll(f.getDependencies());
				List<String> edeps = fX.getExternalDependency();
				edeps.addAll(f.getExternalReferences());
				fsX.add(fX);
			}

			String version = src.getVersionID();
			String srcType = src.getFileType();

			s.setSourceType(srcType);
			s.setVersionId(checkVersion(version) ? version : "1.0.0.0");

			sourcesX.add(s);
		}
	}

	private boolean checkVersion(String version) {
		try {
			String[] v = version.split("[.]");
			boolean ok = true;
			for (String i : v) {
				Integer.parseInt(i);
			}
			return v.length == 4;
		} catch (NumberFormatException e) {
			return false;
		}

	}

	private void saveInterfaceSlices(List<HInterfaceSlice> slices,
			EList<InterfaceSliceType> slicesX) {
		
		Map<String, HInterfaceSlice> savedSlices = new HashMap<String, HInterfaceSlice>();
		
		for (HInterfaceSlice slice : slices) 
			if (!savedSlices.containsKey(slice.getName()))
		    /* if (!(slice instanceof HEnumeratorInterfaceSlice)) */ {
			savedSlices.put(slice.getName(), slice);

			InterfaceSliceType sliceX = factory.createInterfaceSliceType();
			VisualElementAttributes v = factory.createVisualElementAttributes();

			String sRef = null;
			String cORef = null;
			String iORef = null;

			// SETUP VARIABLES

			sRef = slice.getName();
			cORef = slice.getInterface().getConfiguration().getRef();
			iORef = ((HInterface) slice.getInterface()).getPrimName();

			// ---------------

			sliceX.setIsRef(sRef);

			InterfaceRefType oRef = factory.createInterfaceRefType();
			oRef.setCRef(cORef);
			oRef.setIRef(iORef);

			sliceX.setOriginRef(oRef);

			sliceX.setVisualDescription(v);

			saveVisualDescription(slice, v);

			slicesX.add(sliceX);
		}
	}

	private void saveUnits(Component c, EList xI) throws DuplicatedSliceNamesException {

		for (IHUnit u_ : c.getUnits()) {

			UnitType uX = factory.createUnitType();

			String uRef = null;
			String iRef = null;
			boolean isPrivate = false;
			boolean isSubUnit = false;
			boolean visibleInterface = true;
			String cRefSuper = null;
			String uRefSuper = null;
			Integer replica = null;

			VisualElementAttributes v = factory.createVisualElementAttributes();

			HUnit u = (HUnit) u_;

			isSubUnit = u.hasStubs();
			isPrivate = u.getHidden();
			visibleInterface = u.visibleInterface();
			uRef = u.getName2();
			HInterface i = (HInterface) u.getInterface();

			iRef = i != null ? i.getPrimName() : null;
			if (isSubUnit) {
				HUnitStub stubU = u.getMostRecentStub();
				cRefSuper = ((Component) stubU.getConfiguration()).getRef();
				uRefSuper = stubU.getOriginalName();
				if (u.isClone()) {
					replica = u.cloneOf().getIndexOfClone(u);
				} else if (u.isCloned()) {
					replica = 0;
				}
			}

			// ---------------

			uX.setURef(uRef);
			uX.setIRef(iRef);
			uX.setPrivate(isPrivate);
			uX.setVisibleInterface(visibleInterface);
			uX.setVisualDescription(v);

			if (isSubUnit) {
				UnitRefType superUnit = factory.createUnitRefType();
				superUnit.setCRef(cRefSuper);
				superUnit.setURef(uRefSuper);
				if (replica != null)
					superUnit.setReplica(replica);
				uX.setSuper(superUnit);
			}
			saveVisualDescription(u, v);

			EList slicesX = uX.getSlices();
			List<HUnitSlice> transitiveSlices = new ArrayList<HUnitSlice>();
			List<HUnitSlice> directSlices = new ArrayList<HUnitSlice>();
			List<HUnitSlice> ports = u.getPorts();
			List<HUnitSlice> slices = u.getSlices();
			transitiveSlices.addAll(ports);
			for (HUnitSlice usx : slices) {
				if (!transitiveSlices.contains(usx))
					transitiveSlices.add(usx);
			}
			directSlices.addAll(slices);
			saveUnitSlices(directSlices, transitiveSlices, slicesX);

			xI.add(uX);

		}

	}

	private void saveUnitSlices(List<HUnitSlice> directSlices,
			List<HUnitSlice> transitiveSlices, EList slicesX) throws DuplicatedSliceNamesException {

		Map<String, HUnitSlice> savedSlices = new HashMap<String, HUnitSlice>();
		
		for (HUnitSlice slice : transitiveSlices) {
			
			if (savedSlices.containsKey(slice.getName())) {
			//    throw new DuplicatedSliceNamesException(slice);
			}

			//if (!savedSlices.containsKey(slice.getName())) {
				savedSlices.put(slice.getName(), slice);

				// if (!slice.getHiddenSlice()) {
				/*
				 * Essa linha foi acrescentada devido a problema com fatias de
				 * unidades herdadas de subtyping ...
				 */

				IHUnit e = slice.getBinding().getEntry();

				UnitSliceType sliceX = factory.createUnitSliceType();
				VisualElementAttributes v = factory
						.createVisualElementAttributes();
				List<String> portsX = sliceX.getPort();

				String cRef = null;
				String uRef = null;
				int replica = 0;
				String sName = null;

				HUnit uSource = (HUnit) slice.getComponentEntry();

				cRef = uSource.getConfiguration().getRef();
				uRef = uSource.getName2();

				sName = slice.getName();

				if (uSource.isClone()) {
					replica = uSource.cloneOf().getIndexOfClone(uSource);
				} else if (uSource.isCloned()) {
					replica = 0;
				}
				sliceX.setReplica(replica);

				// ---------------

				sliceX.setCRef(cRef);
				sliceX.setURef(uRef);
				sliceX.setSliceName(sName);
				sliceX.setVisualDescription(v);
				sliceX.setTransitive(!directSlices.contains(slice));

				List<HUnitSlice> usPorts = uSource.getPorts();
				for (HUnitSlice usPort : usPorts) {
					HUnit usPortSource = (HUnit) usPort.getComponentEntry();
					String usPortName = usPort.getInterfaceSlice() != null ? usPort
							.getInterfaceSlice().getName()
							: usPortSource.getName2();
					portsX.add(usPortName);
				}

				saveVisualDescription(slice, v);

				slicesX.add(sliceX);
			}
		}
	

	private void saveSupplyParameters(Component c, EList xI) {

		for (Entry<String, Component> pair : c.getSupplierComponents().entrySet()) {

			ParameterSupplyType s = factory.createParameterSupplyType();
			String cRef = null;
			String varName = null;

			// SETUP VARIABLES

			Component supplier = pair.getValue();

			varName = pair.getKey();
			cRef = supplier.getRef();

			// ---------------

			s.setCRef(cRef);
			s.setVarName(varName);

			xI.add(s);
		}

	}

	private void saveEnumerator(Collection<HReplicator> replicators, EList xI) {

		Component topC = null;

		for (HReplicator e : replicators) /* if (e.getFactor() != 1) */ {

			List<Component> cs = new ArrayList<Component>(e.getConfigurations());
			cs.remove(0);

			EnumeratorType eX = factory.createEnumeratorType();
			VisualElementAttributes v = factory.createVisualElementAttributes();
			String eRef = null;
			List<String> coRefs = new ArrayList<String>();
			Component c_ = null;
			for (Component c : cs) {
				// USE THE ORIGINAL NAME OF THE INNER COMPONENT !!
				String ref = c_ != null && c.getSavedName().containsKey(c_) ? c
						.getSavedName().get(c_) : c.getRef();
				coRefs.add(ref);
				c_ = c;
			}
			// String eoRef = null;
			String varId = null;
			int cardinality = 0;
			boolean fromSplit;
			EnumeratorFromRecursionType fromRecursion = e.getReplicatorOrigin() == ReplicatorOrigin.RECURSION_CREATION ? factory
					.createEnumeratorFromRecursionType()
					: null;

			// SETUP VARIABLES

			eRef = e.getRef().trim();
			varId = e.getVarId();
			cardinality = e.getFactor();
			fromSplit = e.isSplitReplicator();
			if (fromRecursion != null)
				fromRecursion.setCRef(e.getRec().getRef());
			String cRefPermutation = null;

			// ---------------

			eX.setRef(eRef);
			eX.setVarId(varId);
			eX.setCardinality(cardinality);
			eX.setFromSplit(fromSplit);
			eX.setVisualDescription(v);
			eX.setFromRecursion(fromRecursion);

			List<String> oRefs = eX.getOriginRef();
			for (String coRef : coRefs) {
				oRefs.add(coRef);
			}

			// EList splitsX = eX.getSplits();
			EList linksX = eX.getLinks();

			// saveEnumeratorSplits(e.getSplits(),splitsX); //
			saveEnumeratorLinks(e.getDirectLinksToMe(), linksX);

			saveVisualDescription(e, v);

			xI.add(eX);
		}

	}

	private void saveEnumeratorLinks(Collection<HLinkToReplicator> linksToMe,
			EList linksX) {

		List replicatedOne = new ArrayList();

		List<String> componentsReplicated = new ArrayList<String>();
		
		for (HLinkToReplicator l : linksToMe) {
			IPointsToReplicator p = l.getReplicated();
			if (!replicatedOne.contains(p)) {
				if (p instanceof HUnit) {
					HUnit u = (HUnit) p;
					// Only units of the top configuration. It is possible to
					// infer replication
					// of entries of inner components from the unit slices,
					// below ....
					if (u.getConfiguration() == this.component) {
						EnumerableUnitType uX = factory.createEnumerableUnitType();
						uX.setRef(u.getName2());
						linksX.add(uX);
						replicatedOne.add(u);
					} else if (u.isEntry() && u.getMyClones().isEmpty()) {
						Component innerOf_u = (Component) u.getConfiguration();
				//		if (innerOf_u.isDirectSonOfTheTopConfiguration()) {
							EnumerableEntryType usX = factory.createEnumerableEntryType();
							HEnumeratorComponent ec = null; // l.getPermutation();
							usX.setCRef(u.getConfiguration().getRef());
							usX.setURef(u.getName2());
							if (u.cloneOf() != null) {
							  usX.setIndex(u.cloneOf().getIndexOfClone(u));
							}
							linksX.add(usX);
							replicatedOne.add(u);
				//		} else {
				//			System.out.print("UNEXPECTED GHOST INNER COMPONENT " + innerOf_u.getRef());
				//		}
					}

				} else if (p instanceof Component) {
					Component c = (Component) p;
					// Only direct inner components of the top configuration
					if (c.getConfiguration() == this.component && !componentsReplicated.contains(c.getRef())) {
						EnumerableComponentType cX = factory.createEnumerableComponentType();
						cX.setRef(c.getRef());
						linksX.add(cX);
						replicatedOne.add(c);
						componentsReplicated.add(c.getRef());
					}

				} 
				 else if (p instanceof HUnitSlice) { 
					 HUnitSlice s = (HUnitSlice) p; // only slices of units of the top configuration ... in fact, it is only necessary for recovering replication of units of inner components. 
					  if (s.getUnit().getConfiguration() == this.component) {
						  EnumerableUnitSliceType sX = factory.createEnumerableUnitSliceType();
						  sX.setURef(s.getUnit().getName2());
						  sX.setCRef(s.getBinding().getEntry().getConfiguration().getRef());
						  sX.setSRef(s.getBinding().getEntry().getName2());
						  if (s.getInterfaceSlice() != null) {
						     sX.setRef(s.getInterfaceSlice().getName());
						  } else {
							 sX.setRef(sX.getSRef());
						  }
						  IHUnit u = s.getBinding().getEntry();
						  sX.setSplitReplica(u.isClone() ? u.cloneOf().getIndexOfClone(u) : 0);
					      linksX.add(sX); 
					   } 
				}
				 
			}
		}

	}



	}






private void retrieveLibraries(HComponent innerC, URI locationUri) {

	// List<Integer[]> versions = innerC.getVersions();
	
	for (HInterface i : innerC.getInterfaces()) 
		if (i.getConfiguration() == innerC) {
			//for (Integer[] version : versions) {					
		        String versionID = null; // HInterface.toStringVersion(version);
				HBESourceVersion<HBEAbstractFile> sv = i.getSourceVersion(versionID == null ? "1.0.0.0" : versionID);
				for (HBEAbstractFile file : sv.getFiles()) {
					String packageName = innerC.getPackagePath().toString();
					String componentName = innerC.getComponentName();
					HPELocationEntry.getBinaryFile(packageName, componentName, versionID, file, locationUri);
				}
			//}
	}
	
	
}

public static void copyProjectToCache(HComponent innerC, String version) {

    IPath pathC = new Path(innerC.getLocalLocation());		
			
	IPath path = ResourcesPlugin.getWorkspace().getRoot().getFile(pathC).getLocation().removeLastSegments(1);
	
	String cachePath = addSegment(HPEProperties.getInstance().getValue("cache_root"), pathC.removeLastSegments(1).toString());
			
	try {
		copyDirectory(new File(path.toString()), new File(cachePath));
		    String gacutil_path = HPEProperties.getInstance().getValue("gacutil_path");
		    List<String> l = innerC.getModuleNames(version);
		    for (String fileName : l) {
            CommandLine.runCommand(new String[] {gacutil_path, "-i", ".." + fileName}, new String[] {}, path.toFile());
		    }

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private static void copyDirectory(File srcPath, File dstPath) throws IOException {

	if (srcPath.isDirectory()){
	
		if (!dstPath.exists()){			
			dstPath.mkdir();			
		}
		
		String files[] = srcPath.list();
		
		for(int i = 0; i < files.length; i++){
			copyDirectory(new File(srcPath, files[i]), 
			new File(dstPath, files[i]));			
		}
	}
	else{
		if(!srcPath.exists()){
			System.out.println("File or directory does not exist.");
			
			System.exit(0);
		}		
		else
		{
			InputStream in = new FileInputStream(srcPath);
			OutputStream out = new FileOutputStream(dstPath); 
			// Transfer bytes from in to out
			byte[] buf = new byte[1024];
			
			int len;
			
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
		}
	}
	
	// System.out.println("Directory copied.");

}


private static File getCachePath(URI locationUri) {

	String cachePath = HPEProperties.getInstance().getValue("cache_root");

	java.io.File cacheFilePath = new java.io.File(cachePath);
	if (!cacheFilePath.exists())
		cacheFilePath.mkdir();

	String fileName = addSegment(cachePath,locationUri.toString()) ;
	
	java.io.File configFilePath = new java.io.File(fileName);
	configFilePath = new java.io.File(configFilePath.getParent());
	if (!configFilePath.exists())
		configFilePath.mkdir();

	java.io.File binFilePath = new java.io.File(addSegment(configFilePath.getAbsolutePath(),"bin"));
	if (!binFilePath.exists())
		binFilePath.mkdir();
	
	
	// cachePath + Path.SEPARATOR + locationUri.toString();
	
	return new File(fileName);
}

private static String addSegment(String path, String adding) {
	int l = path.length() - 1;
	if (path.charAt(l) == Path.SEPARATOR) {
		return path + adding;
	} else {
		return path + Path.SEPARATOR + adding;
	}			
}

public static File getCachePath(String pk, String componentName, String version) {
	
	URI locationURI = HComponent.getStandardLocationPath(pk, componentName, version); 
	
	return getCachePath(locationURI);
}



}
