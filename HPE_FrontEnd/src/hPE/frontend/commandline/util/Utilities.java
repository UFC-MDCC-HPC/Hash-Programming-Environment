package hPE.frontend.commandline.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

public class Utilities {
	private static String curDir = System.getProperty("user.dir")+File.separatorChar;
	public static String pkgName = "hPE.frontend.commandline.type.";
	/*
     * Alocando o properties
     */
    public static Properties readCmdPropertiesFile(){
    	Properties properties = new Properties();
    	 
        try {
            properties.load(new FileInputStream(Utilities.curDir+"hpecmd.properties"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return properties;
    }
    
    public static Properties readSettingsPropertiesFile(){
    	Properties properties = new Properties();
    	 
        try {
            properties.load(new FileInputStream(Utilities.curDir+"hpesettings.properties"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return properties;
    }
    
    public static void writeSettingsPropertiesFile(Properties properties) {
    	 
        try {
            OutputStream out = new FileOutputStream(Utilities.curDir+"hpesettings.properties");
			properties.store(out, "");
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
    }
    
	public static boolean match(String text, String pattern)
    {
        // Create the cards by splitting using a RegEx. If more speed 
        // is desired, a simpler character based splitting can be done.
        String [] cards = pattern.split("\\*");

        // Iterate over the cards.
        for (String card : cards)
        {
            int idx = text.indexOf(card);
            
            // Card not detected in the text.
            if(idx == -1)
            {
                return false;
            }
            
            // Move ahead, towards the right of the text.
            text = text.substring(idx + card.length());
        }
        
        return true;
    }	

}
