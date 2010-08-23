package hPE.frontend.commandline.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

public class FileUtil {
	private static String curDir = System.getProperty("user.dir")+File.separatorChar;
	public static String pkgName = "hPE.frontend.commandline.type.";
	/*
     * Alocando o properties
     */
    public static Properties readCmdPropertiesFile(){
    	Properties properties = new Properties();
    	 
        try {
            properties.load(new FileInputStream(FileUtil.curDir+"hpecmd.properties"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return properties;
    }
    
    public static Properties readSettingsPropertiesFile(){
    	Properties properties = new Properties();
    	 
        try {
            properties.load(new FileInputStream(FileUtil.curDir+"hpesettings.properties"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return properties;
    }
    
    public static void writeSettingsPropertiesFile(Properties properties) {
    	 
        try {
            OutputStream out = new FileOutputStream(FileUtil.curDir+"hpesettings.properties");
			properties.store(out, "");
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
    }
}
