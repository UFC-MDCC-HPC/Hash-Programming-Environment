package hPE.frontend.connector.xml;

import hPE.frontend.base.model.HComponent;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class XMLConfigurationGenerator {

	public static void saveComponent(HComponent c, java.io.File file)  
	{
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
			cSuperType.setComponentName(cSuperTypeName);
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

	private static void xmlConfig_saveInnerComponents(HComponent c, EList<HpeinnerComponent> innerComponent, List<String> usingsList, hPE.frontend.connector.xml.component.ComponentFactory factory) 
	{
		List<HComponent> allCs = new ArrayList<HComponent>();
		allCs.addAll(c.getExposedComponents());
		allCs.addAll(c.getComponents());
		
		for (HComponent ic_ : allCs)
			if (!ic_.isHiddenInnerComponent())
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
			
			if (!(par_c.representsOpenParameter() && cTop.getVars().contains(pVariable)))
			{
				pConstraint = factory.createHpeparameterType();
				pConstraint.setComponentConstraint(par_c.getComponentName());
				String pPackage = par_c.getPackagePath().toPortableString();
				if (!usingsList.contains(pPackage)) usingsList.add(pPackage);
				EList<Hpeparameter> inner_parameters = pConstraint.getParameter();
				xmlConfig_saveParameters(par_c, inner_parameters, factory, usingsList);
			}			
			
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
		
		for (IHUnit u : c.getUnits())
		{
			hPE.frontend.connector.xml.component.Unittype uX = factory.createUnittype(); 
			
			String uName = u.getName2();
			int uIndex = u.getIndex();
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
			
			xmlConfig_saveSlice(u.getSlices(), uSlice, factory);
			if (u instanceof HActivateUnit) 
			{
			  xmlConfig_saveActions((HActivateInterface) u.getInterface(), uAction, factory);
			  xmlConfig_saveConditions((HActivateInterface) u.getInterface(), uCondition, factory);
			}
			
			unit.add(uX);
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

	private static void xmlConfig_saveSlice(List<HUnitSlice> slices, EList<HpesliceType> uSlice, hPE.frontend.connector.xml.component.ComponentFactory factory) 
	{		
		for (HUnitSlice slice : slices)
		{
			HpesliceType sX = factory.createHpesliceType();
			
			IHUnit unit_of_slice = (IHUnit) slice.getComponentEntry();
			
			String sInner = unit_of_slice.getConfiguration().getRef();
			String sUnit = unit_of_slice.getName2();
			int sIndex = unit_of_slice.getIndex();
			
			sX.setInner(sInner);
			sX.setUnit(sUnit);
			sX.setIndex(sIndex);
			
			uSlice.add(sX);
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
