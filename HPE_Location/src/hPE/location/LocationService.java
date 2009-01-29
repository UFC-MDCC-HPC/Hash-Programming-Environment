package hPE.location;

import hPE.location.interfaces.HLocationService;
import hPE.location.interfaces.Observer;
import hPE.location.interfaces.Subject;
import hPE.location.xml.ComponentType;
import hPE.location.xml.ObjectFactory;
import hPE.location.xml.PackageListType;
import hPE.location.xml.PackageType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@javax.jws.WebService
public class LocationService implements HLocationService, Subject {
	
	private PackageListType packages; //Lista de objetos packages contendo componentes 
	private LinkedList<Observer> observers = new LinkedList<Observer>(); 
	private Parser parser;
	
	public LocationService(){
		this.parser = Parser.getInstance(); 
		this.parser.setLS(this);
		setPackages(this.parser.getLocationXml());
		if (packages == null ) System.exit(1);
		attach(this.parser);
		verifyConsistency(this.packages);
	}
	
	protected void setPackages(PackageListType packages){		
		this.packages = packages;		
	}
	
	protected PackageListType getPackages(){		
		return this.packages;		
	}
	
	private PackageType findPackage(String path){
		for (PackageType p : this.packages.getPackage()) {
		     if(p.getPath().trim().equals(path.trim())) return p;
		}
		return null;
	}

	private ComponentType findComponent(PackageType p, String componentName, String version){
		for (ComponentType component : p.getComponent()) {
		     if(component.getName().equals(componentName) 
		    		 && (version == null || (version != null && component.getVersion().equals(version)))){
		    	 return component;
		     }
		}
		return null;
	}

	/**
	 * Observer Pattern
	 * @see location.Subject#attach(location.Observer)
	 */	
	public void attach(Observer o){
		this.observers.add(o);		
	}

	public void Notify(){	
		for (Observer o : this.observers) {
			o.update();
		}
	}

	////////////HLocationService...
	
	public String fetchPackages(){
		String str="";		
		for (PackageType p : this.packages.getPackage()) {
			str += p.getPath().trim()+" ( ";
			for (ComponentType c : p.getComponent()) {
		    	 str += c.getName().trim() + (c.getVersion() == null ? " " : ":" + c.getVersion() + " ");		    	 
		     }
		     str += " ) \n";
		}
		return str;
	}
	
	
	private PackageType createPackage(String packageName){
		//adicionar objeto Package se nao existir	
		PackageType p = null;
		
		if(packageName.equals("")){
		   System.out.println("Nome da package invalido");   
	   }
	   else
		   for(int i=0;i<packageName.length();i++)
		     if(!Character.isJavaIdentifierPart(packageName.charAt(i)) && packageName.charAt(i)!='.'){ //cada caractere pertece a [A-Z][a-z][0-9][_,$]
				System.out.println("Nome da package invalido");
			 }
	    
	   if(findPackage(packageName)!=null){
		   System.out.println("Package ja existe.");
	   }
	   else{
			ObjectFactory factory = new ObjectFactory();
			p = factory.createPackageType();
			p.setPath(packageName);
			System.out.println("Package adicionado.");
			Notify();	
	   }
	   return p;
	}
	
	private String removePackage(String packageName){
		//remove o pacote se o mesmo estiver vazio		
	    PackageType p = findPackage(packageName);		    
	    if(p!=null){
	    	if(p.getComponent().isEmpty()){
	    	   this.packages.getPackage().remove(p);
	    	   System.out.println("Package removido!");	
	    	   FileSystem.deleteDir(packageName);
	    	   Notify();	     
	    	   return "Package removido!";
	    	} 
	    	else{
	    		System.out.println("Impossivel remover. Package nao vazia.");
	    		return "Impossivel remover. Package nao vazia.";
	    	}
		}
	    else{
	    	System.out.println("Package nao existe");
	    	return "Package nao existe";
	    }
	}	

	public String registerComponent(String packageName, String componentName, 
			                        String version, 
			                        String contents, 
			                        Map<String, byte[]> binaries){
		
		if(componentName.equals("")){
			   System.out.println("Invalid component identification");   
			   return "Invalid component identification";	
		}
		else
		   for(int i=0;i<componentName.length();i++)
		     if(!Character.isJavaIdentifierPart(componentName.charAt(i))){ //cada caractere pertece a [A-Z][a-z][0-9][_,$]
				System.out.println("Invalid component identification");
				return "Invalid component identification";
			 }		

		PackageType p = findPackage(packageName);
		
		if(p == null){
			p = this.createPackage(packageName);
			this.packages.getPackage().add(p);
		}
		
		ComponentType component = findComponent(p,componentName,version);
		
		if(component==null){			
			component = new ComponentType();
			component.setName(componentName);
			if (version != null) component.setVersion(version);
			p.getComponent().add(component);
			FileSystem.createFile(p.getPath(),componentName,version);
			FileSystem.setText(p.getPath(),componentName,version, contents);
			for (Entry<String, byte[]> bin : binaries.entrySet()) {
				String fileName = bin.getKey();
				byte[] binContents = bin.getValue();
				FileSystem.createBinaryFile(p.getPath(),componentName,version,fileName,binContents);
			}
			System.out.println("Component registered");
			// Atualizar o location.xml
			Notify();	
			return "Component registered";
		}
		else{
 		    return "Component version already registered";
		}
	}
	// deletar tb a pasta ?!?
	public String unregisterComponent(String packageName, String componentName){		
		PackageType p = findPackage(packageName);
		if(p == null){
			System.out.println("Package nao existe.");
			return "Package nao existe.";
		}
		else{
			ComponentType component = findComponent(p, componentName,"1.0.0.0" /* TODO: Version */);
			if(component!=null){
				p.getComponent().remove(component);
				FileSystem.deleteFile(p.getPath(), componentName,"1.0.0.0" /* TODO: Version */);
				System.out.println("Component removido.");
				//FileSystem.deleteDir(p.getPath().trim()+"."+componentName.trim()+"/");
				Notify();	
				return "Component removido.";
			}
			else{
				System.out.println("Component nao existe.");
				return "Component nao existe.";
			}
		}
	}
	
	
	public String getComponent(String packageName, String componentName, String version){
		
		String s = FileSystem.getText(packageName, componentName, version); 	 	 	
		return s.equals("") ? null : s;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Local Location";
	}

	@Override
	public String getPresentationMessage() {
		// TODO Auto-generated method stub
		return "I am the local location ...";
	}

	public void verifyConsistency(PackageListType packages){
		
		List<ComponentType> tobeRemoved_c = new ArrayList<ComponentType>();
		List<PackageType> tobeRemoved_p = new ArrayList<PackageType>();

		for (PackageType p : packages.getPackage()) {
			 boolean emptyPackage = true;
		     for (ComponentType component : p.getComponent()) {
			     boolean exists = FileSystem.testFile(p.getPath(),component.getName(),component.getVersion());
			     emptyPackage = emptyPackage && !exists;
			     if (!exists) tobeRemoved_c.add(component);
		     }
		     if (emptyPackage) tobeRemoved_p.add(p);
		}
		
		packages.getPackage().removeAll(tobeRemoved_p);
		for (PackageType p : packages.getPackage()) {
		     p.getComponent().removeAll(tobeRemoved_c);	
		}
		
		Notify();
		
		
	}
	
}
