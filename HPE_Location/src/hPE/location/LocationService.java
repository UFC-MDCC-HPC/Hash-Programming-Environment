package hPE.location;

import hPE.location.interfaces.HLocationService;
import hPE.location.interfaces.Observer;
import hPE.location.interfaces.Subject;
import hPE.location.xml.ComponentType;
import hPE.location.xml.ObjectFactory;
import hPE.location.xml.PackageListType;
import hPE.location.xml.PackageType;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
		FileSystem.verifyConsistency(this.packages);
		attach(this.parser);
	}
	
	protected void setPackages(PackageListType packages){		
		this.packages = packages;		
	}
	
	protected PackageListType getPackages(){		
		return this.packages;		
	}
	
	private PackageType findPackage(String path){
		Iterator<PackageType> i = this.packages.getPackage().iterator();
		while(i.hasNext()){  	 
			PackageType p = i.next();		    
		     if(p.getPath().trim().equals(path.trim())) return p;
		}
		return null;
	}

	private ComponentType findComponent(PackageType p, String componentName){
		Iterator<ComponentType> i = p.getComponent().iterator();
		while(i.hasNext()){
			ComponentType component = i.next();
		     if(component.getName().equals(componentName)){
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
		Iterator<Observer> i = this.observers.iterator();
		while (i.hasNext()){			
			(i.next()).update();
		}
	}

	////////////HLocationService...
	
	public String fetchPackages(){
		String str="";		
		Iterator<PackageType> i = this.packages.getPackage().iterator();
		while(i.hasNext()){  	 
		     PackageType p = i.next();
		     Iterator<ComponentType> i2 = p.getComponent().iterator();		     
		     str += p.getPath().trim()+" ( ";
		     while(i2.hasNext()){
		    	 str += (i2.next()).getName().trim() + " ";		    	 
		     }
		     str += " ) \n";
		}
		return str;
	}
	
	
	private String createPackage(String packageName){
		//adicionar objeto Package se nao existir	
	   if(packageName.equals("")){
		   System.out.println("Nome da package invalido");   
		   return "Nome da package invalido";	
	   }
	   else
		   for(int i=0;i<packageName.length();i++)
		     if(!Character.isJavaIdentifierPart(packageName.charAt(i)) && packageName.charAt(i)!='.'){ //cada caractere pertece a [A-Z][a-z][0-9][_,$]
				System.out.println("Nome da package invalido");
				return "Nome da package invalido";
			 }
	    
	   if(findPackage(packageName)!=null){
		   System.out.println("Package ja existe.");
		   return "Package ja existe.";
	   }
	   else{
			ObjectFactory factory = new ObjectFactory();
			//Package p = factory.createPackagesPackage();
			PackageType p = factory.createPackageType();
			//Components c = factory.createPackagesPackageComponents();
			List<ComponentType> c = p.getComponent();//factory.
			p.setPath(packageName);
			//p.setComponents(c);
			this.packages.getPackage().add(p);
			System.out.println("Package adicionado.");
			//FileSystem.createDir(packageName);
			Notify();	
			return "Package adicionado.";
	   }
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

	public String registerComponent(String packageName, String componentName, String contents, Map<String, byte[]> binaries){
		
		if(componentName.equals("")){
			   System.out.println("Nome do component invalido");   
			   return "Nome do component invalido";	
		}
		else
		   for(int i=0;i<componentName.length();i++)
		     if(!Character.isJavaIdentifierPart(componentName.charAt(i))){ //cada caractere pertece a [A-Z][a-z][0-9][_,$]
				System.out.println("Nome do component invalido");
				return "Nome do component invalido";
			 }		

		PackageType p = findPackage(packageName);
		
		if(p == null){
			this.createPackage(packageName);
		}
		
		{
			if(findComponent(p,componentName)==null){
				ComponentType component = new ComponentType();
				component.setName(componentName);
				p.getComponent().add(component);
				// FileSystem.createDir(p.getPath().trim()+"."+componentName.trim());
				FileSystem.createFile(p.getPath(),componentName);
				FileSystem.setText(p.getPath(),componentName, contents);
				System.out.println("Componente adicionado.");
				// Atualizar o location.xml
				this.packages.getPackage().add(p);
				Notify();	
				return "Component adicionado.";
			}
			else{
				System.out.println("Component ja existe.");
				return "Component ja existe.";
			}
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
			ComponentType component = findComponent(p, componentName);
			if(component!=null){
				p.getComponent().remove(component);
				FileSystem.deleteFile(p.getPath(), componentName);
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
	
	
	public String getComponent(String packageName, String componentName){
		
		String s = FileSystem.getText(packageName, componentName); 	 	 	
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

	
}
