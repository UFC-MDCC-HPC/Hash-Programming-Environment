package br.ufc.hpecmd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	private static String curDir = System.getProperty("user.dir")+File.separatorChar;
	public static String pkgName = "br.ufc.hpecmd.type.";
	/*
     * Alocando o properties
     */
    public static Properties getPropertiesFile(){
    	Properties properties = new Properties();
    	 
        try {
            properties.load(new FileInputStream(FileUtil.curDir+"hpecmd.properties"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return properties;
    }
}
