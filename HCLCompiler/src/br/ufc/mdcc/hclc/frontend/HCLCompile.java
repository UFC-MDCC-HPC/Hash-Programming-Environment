package br.ufc.mdcc.hclc.frontend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.runtime.IPath;

import br.ufc.mdcc.hclc.codegen.xml.factory.HComponentFactory;
import br.ufc.mdcc.hclc.codegen.xml.factory.HComponentFactoryImpl;
import br.ufc.mdcc.hclc.parser.HCLParser;
import br.ufc.mdcc.hclc.parser.ParseException;
import br.ufc.mdcc.hclc.symboltable.Component;

public class HCLCompile {

	public static void hclc(String pathIn, String pathOut) throws IOException {
		
        FileInputStream file = null;
        InputStreamReader in = null;
        
		try {
    	    file = new FileInputStream(pathIn);
    	    
    	    in = new InputStreamReader(file, "UTF-8");
        
		    HCLParser parser = new HCLParser(in);
			
			Component c = parser.Start();
			
			HComponentFactory factory = HComponentFactoryImpl.eInstance;		
			
			factory.saveComponent(c, "file://" + pathOut, null);
									
		} catch (ParseException e) {
			
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			HCLParser.ReInit(in);
			in.close();
			file.close();
		}

	}
}
