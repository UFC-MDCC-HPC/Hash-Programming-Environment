package hPE.frontend.HCL.semantic_analisys;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

import hPE.hPEEditor;
import hPE.location.HPE_Location_Server;
import hPE.location.HPE_Location_ServerService;
import hPE.location.HPE_Location_ServerServiceLocator;
import hPE.xml.component.ComponentType;

import hPE.core.library.HPELocationFileTraversor;
import hPE.frontend.HCL.symbol_table.*;
import hPE.frontend.base.model.HComponent;

public class MakeXml {
	private String xml="";
	private int ident=0;
	
	public void inicializaXml(){
		xml="";
	}
	public String getXml(){
		return xml;
	}
	public void appendString(String string){
		if (string.startsWith("<")&&(!string.startsWith("</"))&&(!string.endsWith("/>"))){
			for(int i=1;i<=ident;i++)
				xml+="\t";
			ident++;
		}
		else{
			if(string.startsWith("</")){
				ident--;
				for(int i=1;i<=ident;i++)
					xml+="\t";
			}
		}
		xml+=string+"\n";
	}
	public String makeXml (Component component) throws MalformedURLException, RemoteException, ServiceException{
		inicializaXml();
		makeComponentType(component);
		return SemanticError.hasError() ? "" : this.xml;
	}
	public void makeComponentType(Component component) throws MalformedURLException, RemoteException, ServiceException{
		appendString("<component:component xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:component=\"http://www.example.org/HashComponent\">");
		makeHeaderType(component);
		makeComponentBodyType(component);
		appendString("</component:component>");
	}
	
//---------------------------------- HEADER ---------------------------------------//
	public void makeHeaderType(Component component) throws MalformedURLException, RemoteException, ServiceException{
		String hash_component_UID="hash_component_UID=\""+"12_hashcomponentUID_Aqui_39"+"\"";
		String isAbstract="isAbstract=\""+component.getIsAbstract()+"\"";
		String kind="kind=\""+component.getKind()+"\"";
		String locationURI="locationURI=\""+"http://locationURI_aqui:8080/HPE_Location_Server.jws"+"\"";
		String name="name=\""+component.getName()+"\"";
		String packagePath="packagePath=\"package.path\"";
		
		appendString("<header "+hash_component_UID+" "+isAbstract+" "+kind+" "+locationURI+" "+name+" "+packagePath+">");
		
		if (component.getExtend()!=null){
			String ctName = component.getExtend().getConfig().getId();
			String pkName="";
			for(int i=0;i<=component.getUses_list().size()-1;i++){
				pkName = component.getUses_list().get(i).getComponent();
				if (pkName.endsWith(ctName))
					break;
			}
			if (pkName.equals(""))
				SemanticError.addError("Component "+ctName+" not declared in line "+component.getExtend().getBeginLine()+" and column "+component.getExtend().getBeginColumn()+".");
			makeBaseTypeType(pkName,ctName,component.getExtend().getType());
		}
		makeVersionType(component);
		makeVisualElementAttributes();
		appendString("</header>");
	}
	public void makeBaseTypeType(String pkName, String ctName,int typeExtension) throws MalformedURLException, ServiceException, RemoteException{
		HPELocationFileTraversor locationFileTraversor = new HPELocationFileTraversor();		
		List <URI> l = locationFileTraversor.fetchLocations();
		String cts=null;
		for (URI uri : l){
			String urlWS = uri.toString(); 
			
			URL url = new URL(urlWS);
		
			HPE_Location_ServerService locationServerService = new HPE_Location_ServerServiceLocator();
			
		    HPE_Location_Server server = locationServerService.getHPE_Location_Server(url); 
								
			cts = server.getComponent(new Path(pkName).toPortableString(),ctName,"1.0.0.0");			
			if (cts!=null)
				break;
		}
		if (cts==null)
			SemanticError.addError("Component "+pkName+"."+ctName+" not founded in any of the locations.");
		
		File tempFile = new File(pkName+"."+ctName);
		try {
			FileOutputStream fouts = new FileOutputStream(tempFile);
			fouts.write(cts.getBytes());
			fouts.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HComponent ct = hPEEditor.getConfiguration(URI.createURI(tempFile.toURI().toString()));
		
		appendString("<baseType>");
		makeExtensionTypeType(typeExtension);
		makeComponentInUseType(ct);
		appendString("</baseType>");
	}	
	public void makeExtensionTypeType(int typeExtension) {
		appendString("<extensionType>");
		switch(typeExtension){
			case Extend.EXTENDS:{
				appendString("<extends>");
				appendString("true");
				appendString("</extends>");
				break;
			}
			case Extend.IMPLEMENTS:{
				appendString("<implements>");
				appendString("true");
				appendString("</implements>");
				break;
			}
			default:
				break;
		}
		appendString("</extensionType>");
	}
	public void makeComponentInUseType(HComponent ct) {
		String hash_component_UID="hash_component_UID=\""+ct.getHashComponentUID()+"\"";
		String location="location=\""+ct.getLocalLocation()+"\"";
		String localRef="localRef=\"base\"";
		String name="name=\""+ct.getComponentName()+"\"";
		String packageS="packagePath=\""+ct.getPackagePath().toPortableString()+"\"";
		String version="version=\""+ct.getCurrentVersion()[0]+"."+ct.getCurrentVersion()[1]+"."+ct.getCurrentVersion()[2]+"."+ct.getCurrentVersion()[3]+"\"";
		
		appendString("<component "+hash_component_UID+" "+localRef+" "+location+" "+name+" "+packageS+" "+version+">");
		makeVisualElementAttributes();		
		makeParameterRenaming(ct);
		makeInnerComponentType();
		makeUnitBoundsType();
		appendString("</component>");
	}
	public void makeVisualElementAttributes() {
		appendString("<visualAttributes x=\"0\" y=\"0\" z=\"0\" h=\"0\">");
		makeColorComplexType();
		appendString("</visualAttributes>");
	}
	public void makeColorComplexType() {
		appendString("<color b=\"255\" g=\"255\" r=\"255\"/>");		
	}
	private void makeParameterRenaming(HComponent ct) {
		Map<String, List<HComponent>> map = ct.getParameters();
		for(;;){			
			String formFieldId = "formFieldId=\""+""+"\"";
			String varName = "varName=\""+""+"\"";
			appendString("<parameter "+formFieldId+" "+varName+"/>");
		}
	}
	public void makeInnerComponentType() {
		// TODO Auto-generated method stub
		
	}
	private void makeUnitBoundsType() {
		// TODO Auto-generated method stub
		
	}
	
//---------------------------------- BODY ---------------------------------------//	
	public void makeComponentBodyType(Component component){
		appendString("<componentInfo>");
		makeInnerComponentType();
		makeParameterType();
		makeParameterSupplyType();
		makeInnerRenamingType();
		makeFusionType();
		makeSplitType();
		makeRecursiveEntryType();
		makeInterfaceType();
		makeUnitType();
		makeEnumeratorType();
		makeFusionsOfReplicatorsType();
		appendString("</componentInfo>");
	}
	
	public void makeVersionType(Component component) {
		appendString("<versions field1=\""+component.getVersion()[0]+"\" field2=\""+component.getVersion()[1]+"\" field3=\""+component.getVersion()[2]+"\" field4=\""+component.getVersion()[3]+"\"/>");
	}
	public void makeParameterType() {
		// TODO Auto-generated method stub
		
	}
	public void makeParameterSupplyType() {
		// TODO Auto-generated method stub
		
	}
	public void makeInnerRenamingType() {
		// TODO Auto-generated method stub
		
	}
	public void makeFusionType() {
		// TODO Auto-generated method stub
		
	}
	public void makeSplitType() {
		// TODO Auto-generated method stub
		
	}
	public void makeRecursiveEntryType() {
		// TODO Auto-generated method stub
		
	}
	public void makeInterfaceType() {
		// TODO Auto-generated method stub
		
	}
	public void makeUnitType() {
		// TODO Auto-generated method stub
		
	}
	public void makeEnumeratorType() {
		// TODO Auto-generated method stub
		
	}
	public void makeFusionsOfReplicatorsType() {
		// TODO Auto-generated method stub
		
	}
}
