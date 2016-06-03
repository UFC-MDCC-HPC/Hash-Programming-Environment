package hPE.frontend.connector.xml;

import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.connector.xml.component.AccessType;
import hPE.frontend.connector.xml.component.ComponentPackage;
import hPE.frontend.connector.xml.component.DocumentRoot;
import hPE.frontend.connector.xml.component.GuardType;
import hPE.frontend.connector.xml.component.HashComponentType;
import hPE.frontend.connector.xml.component.Hpeaction;
import hPE.frontend.connector.xml.component.Hpecondition;
import hPE.frontend.connector.xml.component.HpeinnerComponent;
import hPE.frontend.connector.xml.component.Hpekind;
import hPE.frontend.connector.xml.component.Hpeparameter;
import hPE.frontend.connector.xml.component.HpeparameterType;
import hPE.frontend.connector.xml.component.HpesliceType;
import hPE.frontend.connector.xml.component.Hpetype;
import hPE.frontend.connector.xml.component.ProtocolChoiceType;
import hPE.frontend.connector.xml.component.Unittype;
import hPE.frontend.connector.xml.component.util.ComponentResourceFactoryImpl;
import hPE.frontend.kinds.activate.model.HActivateInterface;
import hPE.frontend.kinds.activate.model.HActivateUnit;
import hPE.frontend.kinds.activate.model.protocol.HProtocolChoice;
import hPE.xml.component.UnitSliceType;
import hPE.xml.component.VisualElementAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class XMLConfigurationGenerator {

	private static HComponent component = null;
	
	public static void saveComponent(HComponent c, java.io.File file)  
	{
		component = c;
		saveComponent(c, file, null);
	}

	public static void saveComponent(HComponent c, java.io.File file, IProgressMonitor monitor)  
	{
		HashComponentType cX = generate(c);
		saveComponent(cX, file, monitor);
	}

	public static hPE.frontend.connector.xml.component.ComponentFactory factory = hPE.frontend.connector.xml.component.ComponentFactory.eINSTANCE;
	
	private static void saveComponent(HashComponentType cX, java.io.File file, IProgressMonitor monitor) {
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
			URI uri = URI.createFileURI(file.getPath());
			Resource resource = resourceSet.createResource(uri);

			DocumentRoot dX = factory.createDocumentRoot();
			// ComponentType cX = saveComponent2(c);
			dX.setHashComponent(cX);

			// file.setContents(dX, true, false, monitor);

			resource.getContents().add(dX);
			resource.save(null);

		} catch (IOException e) {

		}

	}
	
	public static HashComponentType generate(HComponent c)
	{
		hPE.frontend.connector.xml.component.HashComponentType cX = factory.createHashComponentType();
		
		EList<String> usingsList = cX.getUsing();
		
		Hpekind cKind = Hpekind.get(c.kindString());
		String cName = c.getComponentName();
		String cPackagePath = c.getPackagePath().toPortableString();
		
		if (c.getSuperType() != null)
		{
			HComponent cSuper = c.getSuperType();
			Hpetype cSuperType = factory.createHpetype();
			
			String cSuperTypeName = cSuper.getComponentName();
			String cSuperPackage = cSuper.getPackagePath().toPortableString();
			if (!usingsList.contains(cSuperPackage)) usingsList.add(cSuperPackage);
			cSuperType.setComponentName(cSuperPackage + "." + cSuperTypeName);
			//cSuperType.setPackage(cSuperPackage);
			
			xmlConfig_saveParameters(cSuper, cSuperType.getParameter(), factory, usingsList);
			xmlConfig_savePublicInnerComponents(cSuper, cSuperType.getPublicInnerComponent());
			
			cX.setSuperComponent(cSuperType);
		}
		
		cX.setKind(cKind);
		cX.setName(cName);
		cX.setPackage(cPackagePath);
				
		xmlConfig_saveInnerComponents(c, cX.getInnerComponent(), usingsList, factory);
		xmlConfig_saveParameters(c, cX.getParameter(), factory, usingsList);
		xmlConfig_saveUnits(c, cX.getUnit(), factory);
		
		return cX;
	}

	private static List<HComponent> getInnerComponents(HComponent c)
	{
		List<HComponent> allCs = new ArrayList<HComponent>();
		
		HComponent c_= c;
		while (c_ != null)
		{
			for (HComponent c_inner : c_.getExposedComponents())
			{
				if (!allCs.contains(c_inner))
					allCs.add(c_inner);
			}
			
			for (HComponent c_inner : c_.getComponents())
			{
				if (!allCs.contains(c_inner))
					allCs.add(c_inner);
			}
			c_ = c_.getSuperType();
		}
		
		return allCs;
	}
	
	private static void xmlConfig_saveInnerComponents(HComponent c, EList<HpeinnerComponent> innerComponent, List<String> usingsList, hPE.frontend.connector.xml.component.ComponentFactory factory) 
	{
		List<HComponent> allCs = getInnerComponents(c);
		
		for (HComponent ic_ : allCs)
			if (!ic_.isHiddenInnerComponent() && ic_ != c.getSuperType())
		{	
			HComponent ic = ic_.getSupplier() != null ? ic_.getSupplier() : ic_;	
				
			hPE.frontend.connector.xml.component.HpeinnerComponent iX = factory.createHpeinnerComponent(); 
			
			AccessType iAccess = ic.isPublic() ? AccessType.PUBLIC : AccessType.PRIVATE;
			boolean iExportActions = true;// TODO
			String iIdentifier = ic.getRef();
			Hpekind iKind = Hpekind.get(ic.kindString());
						
			String iPackage = ic.getPackagePath().toPortableString();

			if (!usingsList.contains(iPackage)) usingsList.add(iPackage);
			
			Hpetype iType = factory.createHpetype();
			
			if (!(ic.isParameter() && ic.representsOpenParameter()))
			{
				String iTypeName = ic.getQualifiedName();
				iType.setComponentName(iTypeName);	
				xmlConfig_saveParameters(ic, iType.getParameter(), factory, usingsList);
				xmlConfig_savePublicInnerComponents(ic, iType.getPublicInnerComponent());
			}
			else 
			{
				String iTypeName = ic.getVariableName(c);
				iType.setComponentName(iTypeName);	
			}

			iX.setAccess(iAccess);
			iX.setExportActions(iExportActions);
			iX.setIdentifier(iIdentifier);
			iX.setKind(iKind);
			iX.setType(iType);
			
			innerComponent.add(iX);
		}
		
	}

	private static void xmlConfig_savePublicInnerComponents(HComponent ic, EList<String> publicInnerComponent) 
	{
		for (HComponent pic_ : ic.getExposedComponents())
		{
			HComponent pic = pic_.getSupplier() != null ? pic_.getSupplier() : pic_; 
			String pX = pic_.getRef();
			
			publicInnerComponent.add(pX);
		}
		
	}

	private static void xmlConfig_saveParameters(HComponent c, EList<Hpeparameter> parameter, hPE.frontend.connector.xml.component.ComponentFactory factory, List<String> usingsList) 
	{
		HComponent cTop = (HComponent) c.getTopConfiguration();
		
		for (Entry<String, List<HComponent>> par : c.getParameters().entrySet())
		{
			HComponent par_c = par.getValue().get(0);
			par_c = par_c.getSupplier() != null ? par_c.getSupplier() : par_c;
			String pIdentifier = par.getKey();
			String pVariable = null;
			HpeparameterType pConstraint = null;
			
			if (par_c.representsOpenParameter())
			{
				pVariable = par_c.getVariableName((HComponent) c.getTopConfiguration());				
			}
			
			//if (!(par_c.representsOpenParameter() && cTop.getVars().contains(pVariable)))
			//{
				pConstraint = factory.createHpeparameterType();
				String pPackage = par_c.getPackagePath().toPortableString();
				pConstraint.setComponentConstraint(pPackage + "." + par_c.getComponentName());
				
				if (!usingsList.contains(pPackage)) usingsList.add(pPackage);
				EList<Hpeparameter> inner_parameters = pConstraint.getParameter();
				xmlConfig_saveParameters(par_c, inner_parameters, factory, usingsList);
			//}			
			
			parameter.add(saveParameter(pConstraint, pIdentifier, pVariable, factory));
		}
	}

	private static Hpeparameter saveParameter(HpeparameterType pConstraint, String pIdentifier, String pVariable, hPE.frontend.connector.xml.component.ComponentFactory factory) 
	{
		hPE.frontend.connector.xml.component.Hpeparameter pX = factory.createHpeparameter();
		
		pX.setIdentifier(pIdentifier);
		if (pVariable != null)
			pX.setVariable(pVariable);
		if (pConstraint != null)
			pX.setConstraint(pConstraint);
		
		return pX;
	}

	private static void xmlConfig_saveUnits(HComponent c, EList<Unittype> unit, hPE.frontend.connector.xml.component.ComponentFactory factory) 
	{
		
		for (IHUnit u_ : c.getUnits())
		{
			HUnit u = (HUnit) u_;
			
			hPE.frontend.connector.xml.component.Unittype uX = factory.createUnittype(); 
			
			String uName = u.getName2();
			int uIndex = u.getSliceReplicaIndex();
			boolean uParallel = u.isMultiple();
			ProtocolChoiceType uProtocol = factory.createProtocolChoiceType();
			
			//xmlConfig_saveProtocol(uProtocol, factory);
			
			uX.setName(uName);
			uX.setIndex(uIndex);
			uX.setParallel(uParallel);
			//uX.setValidation(uProtocol);
			
			EList<Hpeaction> uAction = uX.getAction();
			EList<HpesliceType> uSlice = uX.getSlice();
			EList<Hpecondition> uCondition = uX.getCondition();
			
			List<HUnitSlice> transitiveSlices = new ArrayList<HUnitSlice>();
			List<HUnitSlice> directSlices = new ArrayList<HUnitSlice>();
			
			List<List<HUnitSlice>> ports_list = /* new ArrayList<HUnitSlice>(); */ u.getPorts();
			List<HUnitSlice> slices = /* new ArrayList<HUnitSlice>(); */ u.getSlices();

			for (List<HUnitSlice> ports_list_item : ports_list)
				transitiveSlices.addAll(ports_list_item);		
			
			for (HUnitSlice usx : slices) {
				if (!transitiveSlices.contains(usx))
					transitiveSlices.add(usx);
			}
			directSlices.addAll(slices);
			
			xmlConfig_saveSlice(directSlices, transitiveSlices, uSlice, factory);
			if (u instanceof HActivateUnit) 
			{
			  xmlConfig_saveActions((HActivateInterface) u.getInterface(), uAction, factory);
			  xmlConfig_saveConditions((HActivateInterface) u.getInterface(), uCondition, factory);
			}
			
			unit.add(uX);
		}
		
	}

	private static void calculateSlices(HComponent c_, HUnit u_, List<HUnitSlice> ports, List<HUnitSlice> slices) 
	{
		HUnit u = u_;
		HComponent c = c_;
	   	while (u != null) 
	   	{
			for (List<HUnitSlice> uport_list : u.getPorts())
			{
			   for (HUnitSlice uport : uport_list)
			   {
				   if (!ports.contains(uport))
					   ports.add(uport);
			   }
			}
			
			for (HUnitSlice uslice : u.getSlices()) 
			{
				if (!slices.contains(uslice))
					slices.add(uslice);
			}
			
			c = c.getSuperType();
			u = (HUnit) c.fetchUnit(u.getName2());
		}
		
	}

	private static void xmlConfig_saveActions(HActivateInterface i, EList<Hpeaction> uAction, hPE.frontend.connector.xml.component.ComponentFactory factory) 
	{
		for (Entry<String, HProtocolChoice> action : i.getActions().entrySet())
		{
			Hpeaction aX = factory.createHpeaction();
			
			String aIdentifier = action.getKey();
			
			aX.setIdentifier(aIdentifier);
			aX.setProtocol(action.getValue());
			
			uAction.add(aX);
		}
		
	}

	private static void xmlConfig_saveSlice(List<HUnitSlice> directSlices, List<HUnitSlice> transitiveSlices, EList<HpesliceType> uSlice, hPE.frontend.connector.xml.component.ComponentFactory factory) 
	{		
		
		Map<String, HUnitSlice> savedSlices = new HashMap<String, HUnitSlice>();

		Map<String, String> portNames = new HashMap<String, String>();
		for (HUnitSlice slice : transitiveSlices) 
		{
			HUnit uSource = (HUnit) slice.getComponentEntry();
			List<List<HUnitSlice>> usPorts = uSource.getPorts();
			for (List<HUnitSlice> usPort_list : usPorts) 
			{
				for (HUnitSlice usPort : usPort_list)
				{
					String usPortName = usPort.getConfiguration().getRef();
					portNames.put(usPortName, usPortName);
				}
			}
		}

		for (HUnitSlice slice : transitiveSlices)
		{
			//if (/*slice.getBinding().getConfiguration() == component ||*/ (/* !directSlices.contains(slice) && */portNames.containsKey(slice.getName()))) {

				if (savedSlices.containsKey(slice.getName())) {
					// throw new DuplicatedSliceNamesException(slice);
				}

				// if (!savedSlices.containsKey(slice.getName())) {
				savedSlices.put(slice.getName(), slice);

				// if (!slice.getHiddenSlice()) {
				/*
				 * Essa linha foi acrescentada devido a problema com fatias de
				 * unidades herdadas de subtyping ...
				 */

				IHUnit e = slice.getBinding().getEntry();

				HpesliceType sX = factory.createHpesliceType();

				String cRef = null;
				String uRef = null;
				int replica = 0;

				HUnit uSource = (HUnit) slice.getComponentEntry();

				cRef = uSource.getConfiguration().getRef();
				uRef = uSource.getName2();
				replica = uSource.getSliceReplicaIndex();

				sX.setInner(cRef);
				sX.setUnit(uRef);
				sX.setIndex(replica);

				uSlice.add(sX);
				
				/*				List<HUnitSlice> usPorts = uSource.getPorts();
				for (HUnitSlice usPort : usPorts) {
					HUnit usPortSource = (HUnit) usPort.getComponentEntry();
					String usPortName = usPort.getConfiguration().getRef();
					portsX.add(usPortName);
				}

				slicesX.add(sliceX);*/
				
			//}
		}
		
	}


	private static void xmlConfig_saveConditions(HActivateInterface i, EList<Hpecondition> uCondition, hPE.frontend.connector.xml.component.ComponentFactory factory) 
	{
		for (Entry<String,GuardType> condition : i.getConditions().entrySet())
		{
			Hpecondition cX = factory.createHpecondition();
			
			String cIdentifier = condition.getKey();	
			
			cX.setIdentifier(cIdentifier);
			cX.setGuard(condition.getValue());
			
			uCondition.add(cX);
		}
	}

}
