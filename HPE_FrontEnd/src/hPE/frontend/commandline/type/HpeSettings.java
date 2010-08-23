package hPE.frontend.commandline.type;

import hPE.frontend.commandline.util.FileUtil;

import java.util.Properties;

public class HpeSettings {

	public static HpeSettings instance = new HpeSettings();
	
	public Properties properties = null;
	public Properties commands = null;
	public String workspace_path = null;
	
	HpeSettings() {
		properties = FileUtil.readSettingsPropertiesFile();
		commands = FileUtil.readCmdPropertiesFile();
		workspace_path = properties.getProperty("workspace_path");
	}
	
}
