package ufc.mdcc.hpe.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileUtil {

	/**
	 * Creates package directory structure.
	 * @param packageName Represents the name of the package, with folder's name separated by dots.
	 */
	 
	public static void createPackageDirStructure(String packageName){
		boolean success = true;
		StringTokenizer tokens = new StringTokenizer(packageName,".");
		String path = "";
		while(tokens.hasMoreTokens()){
			path += tokens.nextToken();
			success = (new File(path)).mkdirs();
			path += File.separator;
			if(!success){
				break;
			}
		}
		 
	}
	
	/**
	 * Creates a Java Class source file.
	 * @param className The Class name.
	 */
	public static void createJavaSourceFile(String className){
		try {
		    File file = new File(className+".java");

		    // Create file if it does not exist
		    boolean success = file.createNewFile();
		    if (success) {
		        // File did not exist and was created
		    } else {
		        // File already exists
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void appendToAFile(String fileName, String textToAppend){
		FileWriter out;
		try {
			out = new FileWriter(fileName, true);
			out.write(textToAppend);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		 
	public static void main(String[] args) {
		FileUtil.createPackageDirStructure("ufc.mdcc.hpe");
		FileUtil.createJavaSourceFile("ufc/mdcc/hpe/TestClass");
		FileUtil.appendToAFile("ufc/mdcc/hpe/TestClass.java", "teste");
		
	}
	
	
}
