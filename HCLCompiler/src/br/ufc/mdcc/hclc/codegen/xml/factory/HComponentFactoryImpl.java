package br.ufc.mdcc.hclc.codegen.xml.factory;

//import hPE.HPEProperties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import sun.tools.jar.CommandLine;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionActivateType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionCombinatorType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionSignalType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionSkipType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionType;
import br.ufc.mdcc.hclc.codegen.xml.component.ActionWaitType;
import br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType;
import br.ufc.mdcc.hclc.codegen.xml.component.ColorComplexType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentFactory;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentType;
import br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableComponentType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitSliceType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorFromRecursionType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumeratorType;
import br.ufc.mdcc.hclc.codegen.xml.component.ExtensionTypeType;
import br.ufc.mdcc.hclc.codegen.xml.component.FusionOfReplicatorsType;
import br.ufc.mdcc.hclc.codegen.xml.component.FusionType;
import br.ufc.mdcc.hclc.codegen.xml.component.FusionsOfReplicatorsType;
import br.ufc.mdcc.hclc.codegen.xml.component.InnerComponentType;
import br.ufc.mdcc.hclc.codegen.xml.component.InnerRenamingType;
import br.ufc.mdcc.hclc.codegen.xml.component.ParameterRenaming;
import br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType;
import br.ufc.mdcc.hclc.codegen.xml.component.ParameterType;
import br.ufc.mdcc.hclc.codegen.xml.component.RecursiveEntryType;
import br.ufc.mdcc.hclc.codegen.xml.component.SplitLinkType;
import br.ufc.mdcc.hclc.codegen.xml.component.SplitType;
import br.ufc.mdcc.hclc.codegen.xml.component.SupportedKinds;
import br.ufc.mdcc.hclc.codegen.xml.component.UnitBoundsType;
import br.ufc.mdcc.hclc.codegen.xml.component.UnitRefType;
import br.ufc.mdcc.hclc.codegen.xml.component.UnitSliceType;
import br.ufc.mdcc.hclc.codegen.xml.component.UnitType;
import br.ufc.mdcc.hclc.codegen.xml.component.VisualElementAttributes;
import br.ufc.mdcc.hclc.codegen.xml.component.util.ComponentResourceFactoryImpl;
import br.ufc.mdcc.hclc.hpeproperties.HPEProperties;
import br.ufc.mdcc.hclc.symboltable.Component;
import br.ufc.mdcc.hclc.symboltable.Config;
import br.ufc.mdcc.hclc.symboltable.Extend;
import br.ufc.mdcc.hclc.symboltable.Inner_Component;
import br.ufc.mdcc.hclc.symboltable.ParamType;
import br.ufc.mdcc.hclc.symboltable.Public_Component;
import br.ufc.mdcc.hclc.symboltable.Slice;
import br.ufc.mdcc.hclc.symboltable.Slice_list;
import br.ufc.mdcc.hclc.symboltable.Type;
import br.ufc.mdcc.hclc.symboltable.Unit;
import br.ufc.mdcc.hclc.symboltable.Usings_list;
import br.ufc.mdcc.hclc.symboltable.VarType;

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

		saveHeader(c, xC.getHeader(), xC.getComponentInfo().getParameter(), xC.getComponentInfo().getSupplyParameter());
		saveInfo(c, xC.getComponentInfo());

		return xC;
	}

	private List<Config> innerComponents = new ArrayList<Config>(); 
	private Map<String, Boolean> isExposed = new HashMap<String, Boolean>();
	
	private ParameterSupplyType newSupply(String var_id, String cRef) {		
		ParameterSupplyType s = factory.createParameterSupplyType();
		s.setCRef(cRef);
		s.setVarName(var_id);			
        return s;
	}
	
	private ParameterType newParameter(String var_id, String form_id, String cRef) {
		ParameterType p = factory.createParameterType();
		p.setComponentRef(cRef);
		p.setFormFieldId(form_id);
		p.setVarName(var_id);
		return p;
	}
	
	private void saveHeader(Component c, ComponentHeaderType xH, EList<ParameterType> parameters, EList<ParameterSupplyType> supplies) {

		Extend sC = c.getName_base();
		Usings_list usings = c.getUsings_list();		
		
		boolean isAbstract = sC != null && sC.isImplements();
		
		// save name
		xH.setName(c.getName());
		
		// save kind
		xH.setKind(SupportedKinds.get(c.getKind()));
		
		// save base type
		if (sC != null)
			saveBaseType(sC, usings, xH, isAbstract, supplies);

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

		//saveVersions(c, xH.getVersions());

	}

    private void pickInnerComponentsFromCApp(Config config, List<Config> innerComponents, EList<br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType> supplies) {
		
    	  innerComponents.add(config);
    	  
		  for (Entry<String, Type> param : config.getType_list()) {
			  Type type = param.getValue();
			  if(type instanceof Config) {
				  String form_id = param.getKey();
				  String var_id = /* TODO: How to get ?? */ null;
				  String cRef = /* TODO: How to get ?? */ null;
				  Config cType = (Config) type;
				  ParameterSupplyType s = newSupply(var_id, cRef);
				  isExposed.put(cRef, false);
				  pickInnerComponentsFromCApp(cType, innerComponents, supplies);
		      }
		  }
    }

/*	private void saveVersions(Component sc, EList<VersionType> list) {

		for (Integer[] version : sc.getVersions()) {
			VersionType v = factory.createVersionType();
			v.setField1(version[0]);
			v.setField2(version[1]);
			v.setField3(version[2]);
			v.setField4(version[3]);
			list.add(v);
		}

	}
	*/

	private static String BASE_DEFAULT_REF = "base";
	
	private void saveBaseType(Extend baseType, Usings_list usings, ComponentHeaderType xH, boolean isAbstract, EList<ParameterSupplyType> supplies) {
		
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

		EList<ParameterRenaming> parameterRenaming = superTypeX.getParameter();
		// saveVisualDescription(baseType, v);

		EList<UnitBoundsType> unitBounds = superTypeX.getUnitBounds();

		saveCAppParameters(baseType.getConfig(), parameterRenaming, supplies); // OK !
		// savePorts(baseType, superTypeX.getPort());
		// saveUnitBounds(baseType.getAllUnits(), unitBounds);
	}

	private void saveInfo(Component c, ComponentBodyType xI) {

		readInnerComponents(c, xI.getSupplyParameter(), xI.getInnerRenaming(), xI.getRecursiveEntry()); // OK !
		saveParameters(c, xI.getParameter(), xI.getSupplyParameter()); // OK !
		saveFusions(c, xI.getFusion());
		saveInnerComponents(c, xI.getInnerComponent(), xI.getSupplyParameter());
		saveSplits(c, xI.getSplit());
		saveUnits(c, xI.getUnit());
		saveEnumerator(c, xI.getEnumerator());
		saveEnumeratorFusions(c, xI.getFusionsOfReplicators());
	}

	private void saveInnerComponents(Component c, EList<InnerComponentType> innerComponentsX, EList<ParameterSupplyType> supplies) {
		
		Usings_list usings = c.getUsings_list();

		for (Config ic : innerComponents) {
			InnerComponentType icx = factory.createInnerComponentType();
			
			String cName = ic.getId();
			boolean exposed = isExposed.get(cName);
			// String hash_component_uid;
			String location = properties.getValue("local_location");
			String packageName = usings.packageOf(cName);;

			icx.setExposed(exposed);
			// icx.setHashComponentUID(hash_component_uid);
			icx.setLocation(location);
			icx.setName(cName);
			icx.setPackage(packageName);
			icx.setVersion("1.0.0.0");
			
			saveCAppParameters(ic, icx.getParameter(), supplies);
			innerComponentsX.add(icx);
		}
		
	}


	private void saveFusions(Component c, EList<FusionType> xFs) {

         for (Entry<String, List<String>> port : ports.entrySet()) {
        	 String port_id = port.getKey();
        	 List<String> cRefs = port.getValue();
        	 if (cRefs.size() > 1) 
        	 {
        		 FusionType f = factory.createFusionType();
        		 f.setPRef(port_id);
        		 EList<String> cRefsX = f.getCRefs();
        		 for (String cRef : cRefs) 
        		 {
        			 cRefsX.add(cRef);
        		 }
            	 xFs.add(f);
        	 }
         }
		
	}

	private void saveParameters(Component c, EList<ParameterType> parameters, EList<ParameterSupplyType> supplies) {

		// Traverse the context parameters of the configuration
		for (ParamType param : c.getParamtypelist()) 
		{
			String form_id = param.getForm_id();			
			String var_id = param.getId();
			Config config = param.getConfig();
			String cRef = /* TODO : create unique */ null;
			
			ParameterType p = newParameter(var_id, form_id, form_id);
			parameters.add(p);
			
			ParameterSupplyType s = newSupply(var_id, cRef);
			supplies.add(s);
			
			pickInnerComponentsFromCApp(config, innerComponents, supplies);
		}

	} 

	private Map<String, List<String>> ports = new HashMap<String, List<String>>();
	
	private void readInnerComponents(Component c, EList<ParameterSupplyType> supplies, EList<InnerRenamingType> renamings, EList<RecursiveEntryType> recursives) {

		for (Inner_Component inner : c.getInnercomplist()) {
			String access_type = inner.getAccess_type();
			String cRef = inner.getId();
			String kind = inner.getKind();
			for (Public_Component pc : inner.getPublic_component_list()) {			
				String pRef = pc.getNewId();
				String old_pRef = pc.getOldId(); 
				if (ports.containsKey(pRef)) 
				{
					ports.get(pRef).add(cRef);
				} 
				else 
				{   
					// This will cause a fusion of inner components.
					List<String> l = new ArrayList<String>();
					l.add(cRef);
					ports.put(pRef, l);					
				}
				InnerRenamingType renaming = factory.createInnerRenamingType();
				renaming.setCRef(cRef);
				renaming.setCOldName(old_pRef);
				renaming.setCNewName(pRef);		
				renamings.add(renaming);
			}
			
			if (inner.isRecursive()) {
				RecursiveEntryType r = factory.createRecursiveEntryType();
				r.setCRef(cRef);
				recursives.add(r);
			}
			
			Type cType = inner.getType();
			if (cType instanceof VarType) {
				VarType cvType = (VarType) cType;
				// é acrescentado por saveParameters em innerComponents.
			} else if (cType instanceof Config) {
				Config ccType = (Config) cType;
				isExposed.put(cRef, access_type.equals("public"));
				this.pickInnerComponentsFromCApp(ccType, innerComponents, supplies);
			}
			
		}
		
	}

	private void saveCAppParameters(Config c, EList<ParameterRenaming> parameterRenamings, EList<ParameterSupplyType> supplies) {		

		for (Entry<String,Type> param : c.getType_list()) {
			Type type = param.getValue();
			if (type instanceof Config) {
				Config cType = (Config) type;
				pickInnerComponentsFromCApp(cType, innerComponents, supplies);
			}
			else if (type instanceof VarType) {
				String formField = param.getKey();
				String varName = null;
				VarType vType = (VarType) type;
				varName = vType.getId();
				ParameterRenaming r = factory.createParameterRenaming();
				
				r.setFormFieldId(formField);
				r.setVarName(varName);				
				
				parameterRenamings.add(r);
			}		
		}

	}

	private void saveUnits(Component c, EList<UnitType> xI) {		
		
		for (Unit u : c.getUnitlist()) {

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

			isSubUnit = u.getSuperId() != null;
			isPrivate = u.isPrivate();
			visibleInterface = false;
			uRef = u.getId();
			iRef = u.getInterfaceId();
					
			
			uX.setURef(uRef);
			uX.setIRef(iRef);
			uX.setPrivate(isPrivate);
			uX.setVisibleInterface(visibleInterface);
			uX.setVisualDescription(v);

			if (isSubUnit) {
				UnitRefType superUnit = factory.createUnitRefType();
				superUnit.setCRef("base");
				superUnit.setURef(u.getSuperId());
				//if (replica != null)
				//	superUnit.setReplica(replica);
				uX.setSuper(superUnit);
			}
			saveVisualDescription(u, v);
			
			EList slicesX = uX.getSlices();
			saveUnitSlices(u.getSlice_list(), slicesX);

			xI.add(uX);

		}

	}
	
	private void saveUnitSlices(Slice_list slice_list, EList slicesX) {

				
		for (Slice slice : slice_list) {
			    
			    UnitSliceType sliceX = factory.createUnitSliceType();
			    
				String cRef = null;
				String uRef = null;
				int replica = 0;
				String sName = null;

				cRef = slice.getIdInner();
				uRef = slice.getIdUnitInner();
				sName = slice.getId();
				boolean transitive;

				//sliceX.setReplica(replica);
				sliceX.setCRef(cRef);
				sliceX.setURef(uRef);
				sliceX.setSliceName(sName);
				//sliceX.setVisualDescription(v);
				sliceX.setTransitive(this.ports.containsKey(cRef));

				//saveVisualDescription(slice, v);

				slicesX.add(sliceX);
			}
		}
	

	private void saveEnumeratorFusions(Component c, EList<FusionsOfReplicatorsType> fRs) {

		List<HReplicator> touchedR = new ArrayList<HReplicator>();

		for (HReplicator r : rs) {
			HReplicator topR = r.getTopJoined();
			if (topR != r && !touchedR.contains(topR)) {
				touchedR.add(null, topR);
				List<List<HReplicator>> ss = topR.getFusionsInContext(this.component);

				for (List<HReplicator> rrs : ss) {
					FusionsOfReplicatorsType fOfr = factory.createFusionsOfReplicatorsType();
					EList<FusionOfReplicatorsType> ffs = fOfr.getFusionOfReplicators();
					FusionOfReplicatorsType ff = factory.createFusionOfReplicatorsType();
					ff.setERef(topR.getRef());
					List<Component> cOfrs = new ArrayList<Component>(topR.getConfigurations()); // ;
													// (Component)topR.getConfiguration();
					cOfrs.remove(0);
					List<String> cRefs = ff.getOriginRef();
					Component cOfr_ = null;
					for (Component cOfr : cOfrs) {
						String ref = cOfr_ != null
								&& cOfr.getSavedName().containsKey(cOfr_) ? cOfr.getSavedName().get(cOfr_) : cOfr.getRef();
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
									&& cOfr.getSavedName().containsKey(cOfr_) ? cOfr.getSavedName().get(cOfr_)
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
				innerActionsX.add(null, saveAction(a));
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

	private void saveSplitEnumerators(Collection<HReplicator> rs, EList enumsX) {
		for (HReplicator r : rs) {
			enumsX.add(null, r.getRef());
		}
	}
	
	private void saveEnumerator(Component c, EList<EnumeratorType> xI) {

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

	private void saveEnumeratorLinks(Component c, EList linksX) {

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
						replicatedOne.add(null, u);
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
							replicatedOne.add(null, u);
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
						componentsReplicated.add(null, c.getRef());
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








private static String addSegment(String path, String adding) {
	int l = path.length() - 1;
	if (path.charAt(l) == Path.SEPARATOR) {
		return path + adding;
	} else {
		return path + Path.SEPARATOR + adding;
	}			
}




}
