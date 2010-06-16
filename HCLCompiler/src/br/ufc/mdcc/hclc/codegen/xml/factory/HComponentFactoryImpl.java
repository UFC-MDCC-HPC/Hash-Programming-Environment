package br.ufc.mdcc.hclc.codegen.xml.factory;

/*
enumerator a: SplitEnumerator(c,d)
enumerator b: Enumerator
enumerator c
enumerador d

computation x: Computation(a)
computation y: Computation(a,b)
computation z: Computation(b)

computation w: Computation(c)
computation u: Computation(d)
*/

//import hPE.HPEProperties;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import br.ufc.mdcc.hclc.codegen.xml.component.BaseTypeType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentBodyType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentFactory;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentHeaderType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentInUseType;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentPackage;
import br.ufc.mdcc.hclc.codegen.xml.component.ComponentType;
import br.ufc.mdcc.hclc.codegen.xml.component.DocumentRoot;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableComponentType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableEntryType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableType;
import br.ufc.mdcc.hclc.codegen.xml.component.EnumerableUnitType;
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
import br.ufc.mdcc.hclc.parser.HCLParserConstants;
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

	public void saveComponent(ComponentType cX, String path, IProgressMonitor monitor) {
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
			URI uri = URI.createURI(path);
			Resource resource = resourceSet.createResource(uri);

			DocumentRoot dX = factory.createDocumentRoot();
			// ComponentType cX = saveComponent2(c);
			dX.setComponent(cX);

			// file.setContents(dX, true, false, monitor);

			resource.getContents().add(dX);
			resource.save(null);

		} catch (Exception e) {
            e.printStackTrace();
		} 

	}

	public void saveComponent(Component c, String path, IProgressMonitor monitor) {

		this.component = c;
		ComponentType cX = marshallComponent(c);
		this.saveComponent(cX, path, monitor);

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

	private Map<String,Config> innerComponents = new HashMap<String, Config>(); 
	private Map<String, Boolean> isExposed = new HashMap<String, Boolean>();
	
	private HashMap<String, ParameterSupplyType> supplies_save = new HashMap<String,ParameterSupplyType>();
	
	private ParameterSupplyType newSupply(String var_id, String ref) {		
		if (!supplies_save.containsKey(ref + var_id)) {
			ParameterSupplyType s = factory.createParameterSupplyType();
			s.setCRef(ref);
			s.setVarName(var_id);			
			supplies_save.put(ref + var_id, s);
	        return s;
		} else {
			return null;
		}
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
		
		boolean isAbstract = !(sC != null && sC.isImplements());
		
		// save name
		xH.setName(c.getName());
		
		
		// save kind
		String kind = c.getKind();
		kind = kind.substring(0,1).toUpperCase() + kind.substring(1,kind.length());
		
		xH.setKind(SupportedKinds.get(kind));
		
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
//		saveVisualDescription(c,v);		
		xH.setVisualAttributes(v);

		//saveVersions(c, xH.getVersions());

	}

	Map<String, List<ParameterRenaming>> par_renamings = new HashMap<String, List<ParameterRenaming>>();
	
    private void pickInnerComponentsFromCApp(String ref, Config config, Map<String,Config> innerComponents, EList<br.ufc.mdcc.hclc.codegen.xml.component.ParameterSupplyType> supplies) {
		
    	  innerComponents.put(ref, config);
    	  
			    	  
		  for (Entry<String, Type> param : config.getType_list()) {
			  Type type = param.getValue();
			  String form_id = param.getKey();
			  if(type instanceof Config) {
				  String var_id = uniqueID("capp_var");
				  addParameterRenaming(ref, form_id,var_id);
				  String cRef = uniqueID("capp_ref");
				  Config cType = (Config) type;				  
				  refConfig.put(cType,cRef);
				  cType.setId(cType.getId());
				  ParameterSupplyType s = newSupply(var_id, cRef);
				  if (s != null) 
					  supplies.add(s);
				  isExposed.put(cRef.toString(), false);
				  pickInnerComponentsFromCApp(cRef, cType, innerComponents, supplies);
		      } else if (type instanceof VarType) {
		    	  VarType varType = (VarType) type;
		    	  String var_id = varType.getId();
				  addParameterRenaming(ref, form_id,var_id);
		    	  ParamType varParam = component.getParamtypelist().getById(var_id);
		    	  this.var_applied.put(var_id, true);
		    	  ParameterType par = this.the_parameters.get(var_id);
		    	  this.parameters.add(par);
		    	  if (this.the_parameters_supplies.containsKey(var_id)) 
		    	      this.supplies.add(the_parameters_supplies.get(var_id));
				  ParameterSupplyType s = newSupply(var_id, refConfig.get(varParam.getConfig()));
				  if (s != null)
				     supplies.add(s);
		      }
		  }
    }

	private void addParameterRenaming(String ref, String form_id, String var_id) {
  	  ParameterRenaming r = factory.createParameterRenaming();
	  r.setFormFieldId(form_id);
	  r.setVarName(var_id);
	  if (par_renamings.containsKey(ref)) {
		  par_renamings.get(ref).add(r);
	  } else {
		  List<ParameterRenaming> l = new ArrayList<ParameterRenaming>();
		  l.add(r);
		  par_renamings.put(ref, l);
	  }		
	}

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
		//String location = properties.getValue("local_location");
		String version = "1.0.0.0";
		String package_ = usings.packageOf(name);
		// String hash_component_UID = null;
		VisualElementAttributes v = factory.createVisualElementAttributes();
//		saveVisualDescription(baseType, v);

		superTypeX.setName(name);
		superTypeX.setLocalRef(BASE_DEFAULT_REF);
		//superTypeX.setLocation(location);
		superTypeX.setVersion(version);
		superTypeX.setPackage(package_);
		superTypeX.setVisualDescription(v);
		// superTypeX.setHashComponentUID(hash_component_UID);

		xH.setBaseType(baseTypeX);

		EList<ParameterRenaming> parameterRenaming = superTypeX.getParameter();
		// saveVisualDescription(baseType, v);

		EList<UnitBoundsType> unitBounds = superTypeX.getUnitBounds();

		 saveCAppParameters(baseType.getConfig(), parameterRenaming, BASE_DEFAULT_REF); // OK !
		// savePorts(baseType, superTypeX.getPort());
		// saveUnitBounds(baseType.getAllUnits(), unitBounds);
	}

	private void saveInfo(Component c, ComponentBodyType xI) {
		saveParameters(c, xI.getParameter(), xI.getSupplyParameter()); // OK !
		readInnerComponents(c, xI.getSupplyParameter(), xI.getInnerRenaming(), xI.getRecursiveEntry(), xI.getParameter()); // OK !
		saveFusions(c, xI.getFusion());
		saveInnerComponents(c, xI.getInnerComponent(), xI.getSupplyParameter(), xI.getParameter());
		saveUnits(c, xI.getUnit());
		saveEnumerator(c, xI.getEnumerator(), xI.getSplit(), xI.getFusionsOfReplicators());
		resolveSplitsLinks();
	}

	private void resolveSplitsLinks() {

         for (Entry<Inner_Component, SplitType> entry : this.delayResolveSplits.entrySet()) {
        	 Inner_Component e = entry.getKey();
        	 SplitType split = entry.getValue();
        	 EList<SplitLinkType> splitLinkList = split.getSplitLink();        	 
        	 String eRef = split.getERef();
        	 List<String> splitEnums = split.getSplitEnumerator();
        	 
        	 // 1. PARA TODO componentes direto C que expõe o enumerador eRef mas não expõe os enumeradores em splitEnums.        	 
        	 List<String> rList1 = new ArrayList<String>();
        	 List<Public_Component> l = this.imported_enumerators.get(eRef);
        	 for (Public_Component pc1 : l) {
        		 if (!rList1.contains(pc1.getOwnerInnerId())) {
        		    rList1.add(pc1.getOwnerInnerId());
        		 }
        	 }
        	 
        	 for (String eRefSplitEnum : splitEnums) {
            	 List<String> rList2 = new ArrayList<String>();
            	 List<Public_Component> l2 = this.imported_enumerators.get(eRefSplitEnum);
            	 for (Public_Component pc2 : l2) {
            		 if (!rList2.contains(pc2.getOwnerInnerId())) {
            		    rList2.add(pc2.getOwnerInnerId());
            		 }
            	 }
            	 rList1.removeAll(rList2);        		 
        	 }
        	 // pegar somente os diretos ...
        	 Map<String, String> cs = new HashMap<String, String>();
        	 for (String pc : rList1) {
        		 String cRef = pc;
        		 if (!ports.containsKey(cRef)) {
        			 cs.put(cRef, pc);
        		 }
        	 }        	         	 
        	 
        	 // 2. PARA CADA unidade U de C que é fatia de múltiplas unidades replicadas por enumeradores em splitEnums.
        	 for (Entry<String, String> c : cs.entrySet()) 
        	 {
    			 boolean ok = true;
    			 String uRef = null;
    			 String cRef = null;
    			 String uRefInner = null;
        		 List<UnitSliceType> ss = this.slicesOfInner.get(c.getKey());
        		 List<UnitSliceType> ssWriteReplica = new ArrayList<UnitSliceType>();
        		 for (UnitSliceType s : ss) {
        			 cRef = s.getCRef();
        			 uRef = this.unitOfSlice.get(s);
        			 uRefInner = s.getURef();
        			 List<Slice> enum_ss = this.unitEnumerators.get(uRef);
        			 List<String> ll = new ArrayList<String>();
        			 for (Slice enum_s : enum_ss) {        				 
        				 // Enumerator name
        				 String eRef1 = enum_s.getIdInner();
        				 if (splitEnums.contains(eRef1) && !ll.contains(eRef1)) {
        			        ll.add(eRef1);
        			        ssWriteReplica.add(s);
        				 } else {
        					 ok = false;
        					 break;
        				 }
        			 }
        		 }
        		 if (ok) {
               	   // 3. Criar splitLink cRef = C e uRef  = U.
                    SplitLinkType splitLink = factory.createSplitLinkType();
                    splitLink.setCRef(cRef);
                    splitLink.setURef(uRefInner);
                    splitLinkList.add(splitLink);
                    int count = 1;
                    for (UnitSliceType slicex : ssWriteReplica) {
                    	slicex.setReplica(count++);
                    }
                    
        		 } else {
        			 ssWriteReplica.clear();
        		 }
        	 }
        	 
        	 
        		 
        	 
        	 
        	 
        	 
         }
		
	}

	private void saveInnerComponents(Component c, EList<InnerComponentType> innerComponentsX, EList<ParameterSupplyType> supplies, EList<ParameterType> eList) {
		
        
		Usings_list usings = c.getUsings_list();

		for (Entry<String, Config> icEntry : innerComponents.entrySet()) {
			InnerComponentType icx = factory.createInnerComponentType();			
			String cName = icEntry.getKey(); 
			if (!ports.containsKey(cName)) {
			
				Config ic = icEntry.getValue();
				
				boolean exposed = isExposed.containsKey(cName) ? isExposed.get(cName) : false;
				// String hash_component_uid;
				//String location = properties.getValue("local_location");
				
				String packageName = usings != null ? usings.packageOf(ic.getId()) : null;
	
				icx.setExposed(exposed);
				// icx.setHashComponentUID(hash_component_uid);
				// icx.setLocation(location);
				icx.setName(ic.getId());
				icx.setLocalRef(cName);
				icx.setPackage(packageName);
				icx.setVersion("1.0.0.0");			
				
				saveCAppParameters(ic, icx.getParameter(), cName);
				innerComponentsX.add(icx);
			}
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
        			 if (this.direct_inner_components.containsKey(cRef)) {
        			    cRefsX.add(cRef);
        			 }
        		 }
            	 xFs.add(f);
        	 }
         }
		
	}

	private Integer countUID = 0;
	
	private String uniqueID (String prefix) {
		return prefix + "_" + (countUID++).toString();
	}
	
	private Map<String,Boolean> var_applied = new HashMap<String,Boolean>();
	
	private Map<Config, String> refConfig = new HashMap<Config,String>();
	
	private Map<String, ParameterType> the_parameters = new HashMap<String, ParameterType>();
	private Map<String, ParameterSupplyType> the_parameters_supplies = new HashMap<String, ParameterSupplyType>();
	
	private EList<ParameterType> parameters = null;
	private EList<ParameterSupplyType> supplies = null;

	private void saveParameters(Component c,  EList<ParameterType> parameters,  EList<ParameterSupplyType> supplies) {

		this.parameters = parameters;
		this.supplies = supplies;
		
		// Traverse the context parameters of the configuration
		if (c.getParamtypelist() != null) {
			for (ParamType param : c.getParamtypelist()) 
			{
				String form_id = param.getForm_id();			
				String var_id = param.getId();
				Config config = param.getConfig();
				String cRef = uniqueID("param");
				String cName = config.getId();
				config.setId(cName);
				
				refConfig.put(config, cRef);				
				
				ParameterType p = newParameter(var_id, form_id, cRef);
				the_parameters.put(var_id, p);
					
				ParameterSupplyType s = newSupply(var_id, cRef);
				if (s != null) {
					the_parameters_supplies.put(var_id, s);
				}
				pickInnerComponentsFromCApp(cRef, config, innerComponents, supplies);
			}
		}

	} 

	private Map<String, List<String>> ports = new HashMap<String, List<String>>();
	
	private Map<Inner_Component, String> enumerators = new HashMap<Inner_Component, String>();
	private Map<String, List<Public_Component>> imported_enumerators = new HashMap<String, List<Public_Component>> ();
	private Map<String, List<Slice>> slice_enumerators = new HashMap<String, List<Slice>>();
	private Map<Inner_Component, List<String>> enumerator_splits = new HashMap<Inner_Component, List<String>>();

	private Map<String, Inner_Component> actual_inner_components = new HashMap<String, Inner_Component>();
	private Map<String, Inner_Component> direct_inner_components = new HashMap<String, Inner_Component>();
	private List<String> splitEnumerators = new ArrayList<String>();

	private boolean isEnumerator(Inner_Component ic) {		
		String k = ic.getKind();
		String tkEnumerator = "enumerator";
		boolean r = k.equals(tkEnumerator);;
		return r; 
	}
	
	private boolean isImportedEnumerator(Public_Component pc) {
		
		return pc.isImportedEnumerator();
	}
	
	private boolean isSliceEnumerator(Slice s) {        		
		Inner_Component c = this.actual_inner_components.get(s.getIdInner());
		String k = c.getKind() ;
		String tkEnumerator = "enumerator";
		boolean r = k.equals(tkEnumerator);;
		return r; 
	}

	private boolean isEnumeratorSplit(Inner_Component ic) {
		return isEnumerator(ic) && ic.getPublic_component_list().size() > 0;
	}

	private void readInnerComponents(Component c, EList<ParameterSupplyType> supplies, EList<InnerRenamingType> renamings, EList<RecursiveEntryType> recursives, EList<ParameterType> parameters) {

		for (Inner_Component inner : c.getInnercomplist()) {
			actual_inner_components.put(inner.getId(), inner);
			direct_inner_components.put(inner.getId(), inner);
			if (!isEnumerator(inner)) {
				String access_type = inner.getAccess_type();
				String cRef = inner.getId();
				String kind = inner.getKind();
				for (Public_Component pc : inner.getPublic_component_list()) {
					if (!isImportedEnumerator(pc)) {
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
						if (!old_pRef.equals(pRef)) {
							InnerRenamingType renaming = factory.createInnerRenamingType();
							renaming.setCRef(cRef);
							renaming.setCOldName(old_pRef);
							renaming.setCNewName(pRef);		
							renamings.add(renaming);
						}
					} else {
						List<Public_Component> list = null;
						if (imported_enumerators.containsKey(pc.getNewId())) {
							list = imported_enumerators.get(pc.getNewId());
						} else {
							list = new ArrayList<Public_Component>();
							imported_enumerators.put(pc.getNewId(), list);
						}
						list.add(pc);
					}
				}
				
				if (inner.isRecursive()) {
					RecursiveEntryType r = factory.createRecursiveEntryType();
					r.setCRef(cRef);
					recursives.add(r);
				}
				
				Type cType = inner.getType();
				if (cType instanceof VarType) {
					VarType cvType = (VarType) cType;
					isExposed.put(cRef, false);
					ParamType param = component.getParamtypelist().getById(cvType.getId());
					ParameterType p = newParameter(cvType.getId(), param.getForm_id(), cRef);
					Config config = param.getConfig();
					innerComponents.put(cRef,config);
					// parameters.add(p);
					// ï¿½ acrescentado por saveParameters em innerComponents.
				} else if (cType instanceof Config) {
					Config ccType = (Config) cType;
					isExposed.put(cRef, access_type.equals("public"));
					delayedPickInnerComponentsFromCApp.put(cRef, ccType);
					
				}
			}
			else if (isEnumeratorSplit(inner)) {
				// SPLIT ENUMERATOR
				String eid_original = null;
				List<String> eid_splits = new ArrayList<String>();
				for (Public_Component pc : inner.getPublic_component_list()) {
				    // pc.getOldId() ignored.
					eid_splits.add(pc.getNewId());
				}
				enumerator_splits.put(inner, eid_splits);	
				splitEnumerators.addAll(eid_splits);
				
				enumerators.put(inner, inner.getId());
			} else {
				// SIMPLE ENUMERATOR
				enumerators.put(inner, inner.getId());
			}
		}		
		
		for (Entry<String, List<String>> port : ports.entrySet()) {
			this.direct_inner_components.remove(port.getKey());
		}
		
		for (Entry<String,Config> p : delayedPickInnerComponentsFromCApp.entrySet()) {
			String cRef = p.getKey();
			Config ccType = p.getValue();
			if (!ports.containsKey(cRef)) {
		       this.pickInnerComponentsFromCApp(cRef, ccType, innerComponents, supplies);
			}
		}
	}

	private Map<String, Config> delayedPickInnerComponentsFromCApp = new HashMap<String, Config>();



	private void saveCAppParameters(Config c, EList<ParameterRenaming> parameterRenamings, String cRef) {		

		if (par_renamings.containsKey(cRef))
		   parameterRenamings.addAll(this.par_renamings.get(cRef));
		
/*		for (Entry<String,Type> param : c.getType_list()) {
			Type type = param.getValue();
			if (type instanceof Config) {
				Config cType = (Config) type;
				// pickInnerComponentsFromCApp(cType, innerComponents, supplies);
			}
			else if (type instanceof VarType) {
				String formField = param.getKey();
				String varName = null;
				VarType vType = (VarType) type;
				varName = vType.getId();
				ParameterRenaming r = factory.createParameterRenaming();
				
				r.setFormFieldId(formField);
				r.setVarName(varName);				
				
				
			}		
		} */

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
//			saveVisualDescription(u, v);
			
			EList slicesX = uX.getSlices();
			saveUnitSlices(u.getSlice_list(), slicesX);

			xI.add(uX);

		}

	}
	
	private Map<String, List<UnitSliceType>> slicesOfInner = new HashMap<String, List<UnitSliceType>>();
	private Map<String, List<Slice>> unitEnumerators = new HashMap<String, List<Slice>>();
	private Map<UnitSliceType, String> unitOfSlice = new HashMap<UnitSliceType,String>();
	
	private void saveUnitSlices(Slice_list slice_list, EList slicesX) {

				
		for (Slice slice : slice_list) {
			    if (!this.isSliceEnumerator(slice)) {
				    UnitSliceType sliceX = factory.createUnitSliceType();
				    
					String cRef = null;
					String uRef = null;
					int replica = 0;
					String sName = null;
	
					cRef = slice.getIdInner();
					uRef = slice.getIdUnitInner();
					sName = slice.getId();
					boolean transitive;
	
					sliceX.setReplica(0);
					sliceX.setCRef(cRef);
					sliceX.setURef(uRef);
					sliceX.setSliceName(sName);
					sliceX.setTransitive(this.ports.containsKey(cRef));				
	
					slicesX.add(sliceX);
					
					List<UnitSliceType> slices = null;
					if (!slicesOfInner.containsKey(cRef)) {
						slices = new ArrayList<UnitSliceType>();
						slicesOfInner.put(cRef, slices);
					} else {
						slices = slicesOfInner.get(cRef);
					}
					slices.add(sliceX);
					this.unitOfSlice.put(sliceX, slice.getUnit());
					
					
			    } else {
			    	String cRef = slice.getIdInner();
			    	String uRef = slice.getUnit();
			    	List<Slice> list = null;
			    	
			    	if (slice_enumerators.containsKey(cRef)) {
			    		list = slice_enumerators.get(cRef);
			    	} else {
			    	    list = new ArrayList<Slice>();
			    	    slice_enumerators.put(cRef, list);
			    	}
		    		list.add(slice);
		    		
		    		// Remember unit enumerators
					if (!unitEnumerators.containsKey(uRef)) {
						list = new ArrayList<Slice>();
						unitEnumerators.put(uRef, list);
					} else {
						list = unitEnumerators.get(uRef);
					}
					list.add(slice);
		    		
		    		
			    }
			}
		}
	

	private Map<Inner_Component, SplitType> delayResolveSplits = new HashMap<Inner_Component, SplitType>();

	
	private void saveEnumerator(Component c, EList<EnumeratorType> xI, EList<SplitType> splits, EList<FusionsOfReplicatorsType> fusions) {

		for (Entry<Inner_Component, String> eentry : enumerators.entrySet()) {
			// New enumerator.
			Inner_Component e = eentry.getKey();
			String eid = eentry.getValue();
			
    		EList<EnumerableType> links = null;
			
			// create new replicator
			EnumeratorType eX = factory.createEnumeratorType(); xI.add(eX);
			links = eX.getLinks();
			eX.setCardinality(-1); // TODO: Support for unitary enumerators.
			// eX.setFromRecursion(false); // TODO: Yet supposing no recursion.
			eX.setFromSplit(splitEnumerators.contains(eid));
			// eX.setVisualDescription(value);
			EList<String> origin = eX.getOriginRef();			
			eX.setRef(eid);			
			
			String origin_str = null;
			if (this.imported_enumerators.get(eid).size() > 1) {
				// FUSED IMPORTED ENUMERATORS
				FusionsOfReplicatorsType fOfr = factory.createFusionsOfReplicatorsType(); 
				EList<FusionOfReplicatorsType> fOfrList = fOfr.getFusionOfReplicators();
            
				int count = 0;
				
				boolean first = true;
				
				// Fuse-me, too.
				FusionOfReplicatorsType ffme = factory.createFusionOfReplicatorsType();
				ffme.setERef(eid);
				fOfrList.add(ffme);
				
				for (Public_Component pc : this.imported_enumerators.get(eid)) {
					if (!this.ports.containsKey(pc.getOwnerInnerId())) {
						count ++;
						if (first) {
							eX.setVarId(pc.getNewId());
							origin_str = pc.getOwnerInnerId();
							first = false;
						} 
						FusionOfReplicatorsType ff = factory.createFusionOfReplicatorsType();
						ff.setERef(pc.getNewId());
						EList<String> orl = ff.getOriginRef();
						orl.add(pc.getOwnerInnerId());
						fOfrList.add(ff);
					}					
				}				
				
				if (count > 1)
				   fusions.add(fOfr);
				
			} else if (this.imported_enumerators.get(eid).size() == 1) {
				// SINGLE IMPORTED ENUMERATOR
				Public_Component pc = this.imported_enumerators.get(eid).get(0);
				eX.setRef(pc.getOldId());
				eX.setVarId(pc.getNewId());
				origin_str = pc.getOwnerInnerId();
				origin.add(origin_str);
			} else {
				// NEW ENUMERATOR
                eX.setRef(eid);
                eX.setVarId(eid);                
			}

			if (this.imported_enumerators.get(eid).size() >= 1) {
				
				// CREATE IMPORTED ENUMERATORS
				for (Public_Component imp_enum : this.imported_enumerators.get(eid)) { 
					if (!ports.containsKey(imp_enum.getOwnerInnerId())) {
						EnumeratorType eX_imp = factory.createEnumeratorType(); xI.add(eX_imp);
						links = eX_imp.getLinks();
						eX_imp.setCardinality(-1); // TODO: Support for unitary enumerators.
						eX_imp.setFromSplit(false);
						eX_imp.getOriginRef().add(imp_enum.getOwnerInnerId());
						eX_imp.setRef(imp_enum.getOldId());
						eX_imp.setVarId(imp_enum.getNewId());
					}
				}

				// ONLY IMPORTED UNITS MAY BE SPLIT
				if (this.enumerator_splits.containsKey(e)) {
					List<String> esplit_list = this.enumerator_splits.get(e);
					
					SplitType split = factory.createSplitType(); splits.add(split);
					
					EList<String> origin_list = split.getOriginRef();
					EList<String> split_enum_list = split.getSplitEnumerator();
					//EList<SplitLinkType> split_link_list = split.getSplitLink();
					
					delayResolveSplits.put(e, split);
					
					//split.setCRefPermutation(value);
					split.setERef(eid);
					split.setN(esplit_list.size());
					origin_list.add(origin_str);
										
					for (String eid_split : esplit_list) {
						split_enum_list.add(eid_split);
					}
					
					// SplitLinkType split_link = factory.createSplitLinkType();
					//split_link.setCRef(value);
					//split_link.setURef(value);
					// split_link_list.add(split_link);
					
				}
				
				
				
				
			} else {
				// ERROR !
			}

			if (slice_enumerators.containsKey(eid)) {
				for (Slice es : slice_enumerators.get(eid)) {
				    // new enumeration of unit (causes enumeration of entries and inners)
					EnumerableUnitType link_unit = factory.createEnumerableUnitType(); 
					link_unit.setRef(es.getUnit());
				    links.add(link_unit);	
				    if (!this.imported_enumerators.get(eid).contains(es.getIdInner())) { // ENTRY ENUMERATOR
				    	EnumerableEntryType link_entry = factory.createEnumerableEntryType();
				    	String cRef = es.getIdInner();
				    	String uRef = es.getIdUnitInner();
				    	Inner_Component inner = this.actual_inner_components.get(cRef);
				    	if (inner != null && !this.isEnumerator(inner)) {
					    	link_entry.setCRef(cRef);
					    	link_entry.setURef(uRef);
					    	// link_entry.setIndex(??); //TODO:
					    	links.add(link_entry);
				    	}
				    } else { // INNER ENUMERATOR
				    	EnumerableComponentType link_inner = factory.createEnumerableComponentType();
				    	link_inner.setRef(es.getIdInner());
				    	links.add(link_inner);
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
