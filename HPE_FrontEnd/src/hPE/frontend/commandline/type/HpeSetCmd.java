package hPE.frontend.commandline.type;

import hPE.frontend.commandline.exception.ArgException;
import hPE.frontend.commandline.exception.CmdException;
import hPE.frontend.commandline.util.FileUtil;
import hPE.frontend.commandline.util.HpePrinter;

public class HpeSetCmd implements HpeGenericCmd {

	@Override
	public void action(String[] args) throws ArgException, CmdException {

		if (args == null || args.length == 0 || args.length > 2) {
			HpePrinter.out(help());
			throw new ArgException();
		}

		if (args.length == 1) {
            String which_property = args[0];
            String which_value = HpeSettings.instance.properties.getProperty(which_property);
            HpePrinter.out(which_value);
		}
		
		if (args.length == 2) {
		    String which_property = args[0];
		    String which_value = args[1];
		    HpeSettings.instance.properties.put(which_property, which_value);
		    FileUtil.writeSettingsPropertiesFile(HpeSettings.instance.properties);
		    HpePrinter.out(which_property + " = " + which_value);
		}
		

	}

	@Override
	public String help() {
		return "set <option> <value>";
	}

}


