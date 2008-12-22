package hPE.core.location;

import java.util.Iterator;
import java.util.LinkedList;

import hPE.core.location.Packages.Package;
import hPE.core.location.Packages.Package.Components;

@javax.jws.WebService
public class LocationService implements HLocationService, Subject {
	
	private Packages packages; //Lista de objetos packages contendo componentes 
	private LinkedList<Observer> observers = new LinkedList<Observer>(); 
	private Parser parser;
		
	public LocationService(){
		System.out.println(System.getenv("LOCATION_ENTRY").concat("/location.xml"));
		this.parser = Parser.getInstance(); 
		this.parser.setLS(this);
		setPackages(this.parser.getLocationXml());
		if (packages == null ) System.exit(1);
		FileSystem.verifyConsistency(this.packages);
		attach(this.parser);
	}	
	
	protected void setPackages(Packages packages){		
		this.packages = packages;		
	}
	
	protected Packages getPackages(){		
		return this.packages;		
	}
	
	/**
	* Packages
	* @param path
	* @return
	*/	
	private Package findPackage(String path){
		Iterator i = this.packages.getPackage().iterator();
		while(i.hasNext()){  	 
		     Package p = (Package) i.next();		    
		     if(p.getPath().trim().equals(path.trim())) return p;
		}
		return null;
	}

	/**
	 * Components
	 * @param p
	 * @param component
	 * @return
	 */	
	private String findComponent(Package p, String component){
		Iterator i = p.fetchComponents().getComponent().iterator();
		while(i.hasNext()){  	 
		     String c = (String)i.next();
		     if(c.equals(component)){
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
		Iterator i = this.observers.iterator();
		while (i.hasNext()){			
			((Observer)i.next()).update();
		}		
	}

	////////////HLocationService...
	
	public String fetchPackages(){
		String str="";		
		Iterator i = this.packages.getPackage().iterator();
		while(i.hasNext()){  	 
		     Package p = (Package) i.next();
		     Iterator i2 = p.fetchComponents().getComponent().iterator();		     
		     str += p.getPath().trim()+" ( ";
		     while(i2.hasNext()){		    	 
		    	 str +=((String)i2.next()).trim() + " ";		    	 
		     }
		     str += " ) ";
		}		
		return str;
	}	
	
   public String createPackage(String packageName){
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
			Package p = factory.createPackagesPackage();
			Components c = factory.createPackagesPackageComponents();
			p.setPath(packageName);
			p.setComponents(c);
			this.packages.getPackage().add(p);
			System.out.println("Package adicionado.");
			FileSystem.createDir(packageName);
			Notify();	
			return "Package adicionado.";
	   }		
	}
	
	public String removePackage(String packageName){
		//remove o pacote se o mesmo estiver vazio		
	    Package p = findPackage(packageName);		    
	    if(p!=null){
	    	if(p.fetchComponents().getComponent().isEmpty()){
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
	
	
	public String registerComponent(String packageName, String component){
		
		if(component.equals("")){
			   System.out.println("Nome do component invalido");   
			   return "Nome do component invalido";	
		}
		else
		   for(int i=0;i<component.length();i++)
		     if(!Character.isJavaIdentifierPart(component.charAt(i))){ //cada caractere pertece a [A-Z][a-z][0-9][_,$]
				System.out.println("Nome do component invalido");
				return "Nome do component invalido";
			 }		
		
		Package p = findPackage(packageName);
		if(p == null){
			System.out.println("Package nao existe.");
			return "Package nao existe.";
		}
		else{	
			if(findComponent(p,component)==null){
				p.fetchComponents().getComponent().add(component);			
				System.out.println("Component adicionado.");
				FileSystem.createFile(p.getPath().trim()+"/"+component.trim()+".hpe");
				Notify();	
				return "Component adicionado.";
			}
			else{
				System.out.println("Component ja existe.");
				return "Component ja existe.";
			}
		}		
	}
	
	public String unregisterComponent(String packageName, String component){		
		Package p = findPackage(packageName);
		if(p == null){
			System.out.println("Package nao existe.");
			return "Package nao existe.";
		}
		else{
			if(findComponent(p, component)!=null){
				p.fetchComponents().getComponent().remove(component);
				System.out.println("Component removido.");
				FileSystem.deleteFile(p.getPath().trim()+"/"+component.trim()+".hpe");
				Notify();	
				return "Component removido.";
			}
			else{
				System.out.println("Component nao existe.");
				return "Component nao existe.";
			}
		}		
	}	

	

	public String getComponent(String packageName, String componentName ){
			
		String s = FileSystem.getText(packageName+"/"+componentName+".hpe");
		return s.equals("") ? null : s;
	}
}
