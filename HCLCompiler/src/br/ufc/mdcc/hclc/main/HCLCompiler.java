/**
 * 
 */
package br.ufc.mdcc.hclc.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import br.ufc.mdcc.hclc.codegen.xml.component.ComponentType;
import br.ufc.mdcc.hclc.codegen.xml.factory.HComponentFactory;
import br.ufc.mdcc.hclc.codegen.xml.factory.HComponentFactoryImpl;
import br.ufc.mdcc.hclc.parser.HCLParser;
import br.ufc.mdcc.hclc.parser.ParseException;
import br.ufc.mdcc.hclc.symboltable.Component;

/**
 * @author Heron
 *
 */
public final class HCLCompiler {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
        System.out.println("The HCL Compiler");
        
        FileInputStream file = null;
        InputStreamReader in = null;
        
		try {
    	    file = new FileInputStream("h:\\temp\\teste.hcl");
    	    
    	    in = new InputStreamReader(file, "UTF-8");
        
		    HCLParser parser = new HCLParser(in);
			
			Component c = parser.Start();
			
			HComponentFactory factory = HComponentFactoryImpl.eInstance;		
			
			File fileOut = File.createTempFile("hclc_testing", ".hpe", new File("h:\\temp\\"));
									
		
			
			factory.saveComponent(c, "file://" + fileOut.getAbsolutePath(), null);
						
			System.out.print("Finished !");
			
		} catch (ParseException e) {
			
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			in.close();
			file.close();
		}
		
		
		
	}

}
