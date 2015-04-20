# 1. Introduction #

Here, we present basic instructions on how to install the HPE\_FrontEnd project on Eclipse Ganymede (3.4).


# 2. Dependencies #

For development on Eclipse Ganymede, the following plugings are necessary:

  * SVN (_Subversion_);
    * Access the **"Help / Software Updates"** menu. In the tab **"Available Software"**, click on **"Add Site..."**. Enter http://subclipse.tigris.org/update_1.4.x and click "**OK**" to come back to **"Available Software"** tab. Finally, check http://subclipse.tigris.org/update_1.4.x and click on **"Install..."** button to complete installation of SVN client support.

  * GEF (_Graphical Editing Framework_);
    * Access the **"Help / Software Updates"** menu. In the tab **"Available Software"**, click on **"Manage Sites..."**. Check **"GEF Update Site"** and click **"OK"** to come back to **"Available Software"** tab.  Finally, check **"GEF Update Site"** again and click on **"Install..."** button to complete installation of GEF.

  * EMF (_Eclipse Modeling Framework_);
    * Access the **"Help / Software Updates"** menu. In the tab **"Available Software"**, click on **"Manage Sites..."**. Check **"EMF Update Site"** and click **"OK"** to come back to **"Available Software"** tab.  Finally, check **"EMF Update Site"** again and click on **"Install..."** button to complete installation of EMF.

  * WTP (_Web Tools Platform_);
    * Access the **"Help / Software Updates"** menu. In the tab **"Available Software"**, click on **"Manage Sites..."**. Check **"Web Tools (WTP) Update Site"** and click **"OK"** to come back to **"Available Software"** tab.  Finally, check **"Web Tools (WTP) Update Site"** again and click on **"Install..."** button to complete installation of WTP.

  * VE (_Visual Editor_)
    * **do not** update from the official repository of VE, because VE has not been ported to Ganymede.
    * use the unofficial version of VE available at http://wiki.eclipse.org/VE/Update or in the **Downloads** tab of the project site.

  * [Emonic](http://emonic.sourceforge.net/) (Eclipse support for Mono and .NET development).
    * Access the **"Help / Software Updates"** menu. In the tab **"Available Software"**, click on **"Add Site..."**. Enter http://emonic.sourceforge.net/updatesite/nchc/site.xml and click "**OK**" to come back to **"Available Software"** tab. Finally, check http://emonic.sourceforge.net/updatesite/nchc/site.xml (Eclipse Mono Integration) and click on **"Install..."** button to complete installation of Emonic.


# 3. Configuration #

In the file _hpe.frontend.properties_, the following properties must be configured by the user:

  * _**backend\_locations**_ points to the file where the necessary information to access available Back-Ends is placed on. If either _hpe.frontend.properties_ is not found or _backend\_locations_ is not set, the system will look for _<user home directory>/BackEndLocations.xml_;

  * _**core\_locations**_ points to the _xml_ file (_library.xml_) where it may be retrieved the information that the Front-End needs to connect to the _**locations**_ where components are stored. The Front-End merges the contents of the pointed location repositories. If either _hpe.frontend.properties_ is not found or _core\_locations_ is not set, the system will look for _<user home directory>/CoreLocations.xml_;

  * _**sn\_path**_ points to the path where the _sn_ utility is installed on. It is optional. The default value is "sn", by supposing that the installation directory is set on the path;

  * _**gacutil\_path**_ points to the path where the _gacutil_ utility is installed on. It is optional. The default value is "gacutil", by supposing that the installation directory is set on the path;

  * _**dgac\_path**_ points to the path where _DGAC.dll_ may be found. In general, it points to the GAC directory where DGAC.dll is deployed (e.g. _/usr/lib/mono/gac/DGAC_), but the user may configure it to point to any other directory where it want to place DGAC.dll. If either _hpe.frontend.properties_ is not found or _dgac\_path_ is not set, the system will look for _<user home directory>/DGAC.dll_

  * _**cache\_root**_ points to the root path where configurations fetched from remote locations are cached for fast further access. If either _hpe.frontend.properties_ is not found or _cache\_root_ is not set, the system will look for _<user home directory>/hpe\_cache_

  * _**mono\_lib\_version**_ specifies the version of mono current library (current possible values: 1.0, 2.0, 3.5).

  * _**mono\_path**_ points to the path where the directory where standard libraries of Mono may be found. Im simpler terms, it is the directory where _lib/mono/**mono\_lib\_version**_ may be found. In Linux, it is _/usr/_.


> Example:

> _backend\_locations_ = h:\\runtime-workspace\\BackEndLocations.xml

> _core\_locations_ = h:\\runtime-workspace\\CoreLocations.xml

> _sn\_path_ = C:\\Program Files\\Mono-2.0.1\\bin\\sn.bat

> _gacutil\_path_ = C:\\Program Files\\Mono-2.0.1\\bin\\gacutil.bat

> _dgac\_path_ = C:\\Program Files\\Mono-2.0.1\\lib\\mono\\DGAC\\DGAC.dll

> _cache\_root_ = C:\\Documents and Settings\\Heron\\hpe\_cache

> _mono\_path_ = C:\\Program Files\\Mono-2.0.1\\

> _mono\_lib\_version_ = 2.0

The files _BackEndLocations.xml_ and _CoreLocations.xml_ are automatically created, empty, if they are not found when the Front-End is launched. The Front-End provides a visual interface to configure information that are stored in these files. In the Downloads tab, you can take examples of these files.

The Front-End will look for the path where the file _hpe.frontend.properties_ is placed on using the following methods, in this order:

  1. The value of an argument of the form "--properties _path_";
  1. The value of an environment variable HPE\_FRONTEND\_PROPERTIES;
  1. The home user directory.

# 4. Execution #

You can run the Front-End as an Eclipse pluging. For that, create a **Run Configuration** of type **Eclipse Application** by accessing the menu **"Run / Run Configurations..."**. In **Workspace Data**, make **Location** point to the path of the intended runtime workspace, where configuration projects will be stored. When the Front-End is launched, check if it is in the **# Programming Perspective**. If not, select this perspective to see the views of locations, if the location web service is correctly deployed and a reference to it is correctly configured in _library.xml_, and configurations projects.

If you want to access the configurations of the application example, unzip the file _"runtime-workspace - vx.zip"_ in the runtime workspace path. Then, import the projects into the workspace. For that, access the **"File / Import..."** menu. In the **"select import source"** directory tree, select **"General / Existing Projects into Workspace"** and click **"Next >"**. In the root directory, type the path of the runtime workspace. In the **"Projects"** list, check all projects and click **"Finish"**.

