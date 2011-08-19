package hPE.frontend.commandline.type;

import hPE.HPEProperties;
import hPE.frontend.NAntBuilder;
import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.commandline.exception.ArgException;
import hPE.frontend.commandline.exception.CmdException;
import hPE.frontend.commandline.util.HpePrinter;
import hPE.frontend.commandline.util.Utilities;
import hPE.ui.preferences.PreferenceConstants;
import hPE.util.CommandLine;
import hPE.xml.factory.HComponentFactoryImpl;
import hPE.xml.factory.HPEInvalidComponentResourceException;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

//REFATORADA PARA O NOVO HPEPROPERTIES.
public class HpeWorkspaceCmd implements HpeGenericCmd {

	public static int WORKSPACE_SET_COMMAND_INDEX = 0;
	public static int WORKSPACE_BUILD_COMMAND_INDEX = 0;
	public static int WORKSPACE_LIST_COMMAND_INDEX = 0;

	public static String WORKSPACE_SET_COMMAND_TOKEN = "set";
	public static String WORKSPACE_BUILD_COMMAND_TOKEN = "build";
	public static String WORKSPACE_LIST_COMMAND_TOKEN = "list";

	@Override
	public void action(String[] args) throws ArgException, CmdException {

		if (args == null || args.length == 0) {
			HpePrinter.out(help());
			throw new ArgException();
		}

		if (args[WORKSPACE_SET_COMMAND_INDEX]
				.equals(WORKSPACE_SET_COMMAND_TOKEN)) {
			action_set(args);
		} else if (args[WORKSPACE_BUILD_COMMAND_INDEX]
				.equals(WORKSPACE_BUILD_COMMAND_TOKEN)) {
			action_build(args);
		} else if (args[WORKSPACE_LIST_COMMAND_INDEX]
				.equals(WORKSPACE_LIST_COMMAND_TOKEN)) {
			action_list(args);
		} else {
			HpePrinter.out(this.help());
			throw new ArgException("unrecognized platform command.");
		}
	}

	private void action_list(String[] args) throws ArgException {

		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-package");
		Map<String, String> options_register = traverseOptions(args,
				allowedArgs);

		String pattern = "*";
		if (options_register.containsKey("package")) {
			pattern = options_register.get("package");
		}

		String workspace_path = HpeSettings.instance.workspace_path;
		File workspaceDirectory = new File(workspace_path);
		if (workspaceDirectory.exists()) {
			File[] dirs = workspaceDirectory.listFiles();
			for (File dir : dirs) {
				String dirStr = (new Path(dir.getName())).lastSegment();
				if (dir.isDirectory() && !dir.isHidden() && findDotProject(dir)
						&& Utilities.match(dirStr, pattern)) {
					HpePrinter.out(dirStr + "\n");
				}
			}
		} else {
			String msg = workspace_path
					+ " does not exist. Use 'workspace set <path>' to set the workspace path.";
			throw new ArgException(msg);
		}

	}

	private boolean findDotProject(File dir) {

		FilenameFilter filter = new FilenameFilter() {

			@Override
			public boolean accept(File arg0, String name) {

				return name.equals(".project");
			}
		};

		return dir.list(filter).length > 0;
	}

	private void action_build(String[] args) throws ArgException, CmdException {

		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-project");
		Map<String, String> options_register = traverseOptions(args,
				allowedArgs);

		final String project = options_register.get("project");
		try {
			if (project == null) {
				String msg = "Project must be defined using '-project' option";
				throw new ArgException(msg);
			}

			String workspace_path = HpeSettings.instance.workspace_path;
			File workspaceDirectory = new File(workspace_path);
			if (workspaceDirectory.exists()) {

				String project_path = workspaceDirectory.getPath()
						+ Path.SEPARATOR + project;
				File projectDirectory = new File(project_path);

				FilenameFilter filter = new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						String[] segments = project.split("[.]");
						String cName = segments[segments.length - 1];
						String configFileName = cName + ".hpe";

						return name.equals(configFileName);
					}
				};

				File[] files = projectDirectory.listFiles(filter);
				if (files == null || files.length == 0) {
					String msg = "Project " + project
							+ " was not found in the workspace "
							+ workspace_path;
					throw new ArgException(msg);
				}

				File file = files[0];

				// Build bulid.xml
				HComponent c = null;
				URI uri = URI.createURI(file.getPath());
				c = HComponentFactoryImpl.eInstance.loadComponent(uri, true,
						false, false, false, false);
				NAntBuilder.createBuildFile(c);

				// execute nant

				int exitCode = CommandLine.runCommand(new String[] { "nant",
						"-buildfile:build.xml" }, file.getParentFile());

				// install dll's in GAC

				if (exitCode == CommandLine.SUCESSFULL_COMMAND) {
					String gacutil_path = HPEProperties
							.get(PreferenceConstants.GACUTIL_PATH);
					for (IHUnit u : c.getUnits()) {
						HInterface i = (HInterface) u.getInterface();
						Collection<HBESourceVersion<HBEAbstractFile>> sources = i
								.getSourceVersions();
						for (HBESourceVersion<HBEAbstractFile> source : sources) {
							for (HBEAbstractFile srcfile : source.getFiles()) {
								IPath path = srcfile.getBinaryPath();
								CommandLine.runCommand(new String[] {
										gacutil_path, "-i", path.toString() },
										null);
							}
						}
					}

					// CommandLine.runCommand(new String[] {gacutil_path, "-i",
					// fileName.toString()},null);
				}

			} else {
				String msg = workspace_path
						+ " does not exist. Use 'workspace set <path>' to set the workspace path.";
				throw new ArgException(msg);
			}

		} catch (HPEInvalidComponentResourceException e) {
			String msg = "Error loading configuration of project " + project;
			CmdException ee = new CmdException(msg);
			ee.initCause(e);
			throw ee;
		} catch (ArgException e) {
			throw e;
		}

	}

	private Map<String, String> traverseOptions(String[] args,
			List<String> allowedArgs) throws ArgException {

		Map<String, String> options_register = new HashMap<String, String>();

		for (int j = 1; j < args.length; j++) {
			String arg = args[j];
			if (allowedArgs.contains(arg)) {
				if (arg.equals("-project")) {
					if (j + 1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException(
								"Project expected after '-project'");
					}
					options_register.put("project", args[++j]);
				} else if (arg.equals("-package")) {
					if (j + 1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException(
								"Package expected after '-package'");
					}
					options_register.put("package", args[++j]);
				} else if (arg.equals("-path")) {
					if (j + 1 >= args.length) {
						HpePrinter.out(help());
						throw new ArgException("Path expected after '-path'");
					}
					options_register.put("path", args[++j]);
				} else {
					System.err
							.println("UNEXPECTED ERROR: argument is not included in the list of allowed arguments.");
					throw new ArgException("unknown argument: " + arg);
				}
			} else {
				HpePrinter.out(help());
				throw new ArgException("unknown argument: " + arg + "\n");
			}
		}

		return options_register;
	}

	private void action_set(String[] args) throws ArgException {

		List<String> allowedArgs = new ArrayList<String>();
		allowedArgs.add("-path");
		Map<String, String> options_register = traverseOptions(args,
				allowedArgs);

		final String workspace_path = options_register.get("path");
		if (workspace_path == null) {
			String msg = "Path must be specified using '-path'";
			throw new ArgException(msg);
		}

		File workspaceDirectory = new File(workspace_path);
		if (workspaceDirectory.exists()) {
			HpeSettings.instance.properties.put("workspace_path",
					workspace_path);
			Utilities
					.writeSettingsPropertiesFile(HpeSettings.instance.properties);
			HpePrinter.out("workspace_path = " + workspace_path);
		} else {
			String msg = workspace_path + " does not exist.";
			throw new ArgException(msg);
		}

	}

	@Override
	public String help() {
		return "workspace set -path <path>\n"
				+ "workspace build -project <qname>\n"
				+ "workspace list -package <pattern>\n";
	}

}
