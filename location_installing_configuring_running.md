# 1. Introduction #

Here, we present basic instructions on how to install and run the HPE\_Location project on Eclipse Ganymede (3.4).


# 2. Dependencies #

For development on Eclipse Ganymede, the following plugings are necessary:

  * SVN (_Subversion_);
    * Access the **"Help / Software Updates"** menu. In the tab **"Available Software"**, click on **"Add Site..."**. Enter http://subclipse.tigris.org/update_1.4.x and click "**OK**" to come back to **"Available Software"** tab. Finally, check http://subclipse.tigris.org/update_1.4.x and click on **"Install..."** button to complete installation of SVN client support.

  * WTP (_Web Tools Platform_);
    * Access the **"Help / Software Updates"** menu. In the tab **"Available Software"**, click on **"Manage Sites..."**. Check **"Web Tools (WTP) Update Site"** and click **"OK"** to come back to **"Available Software"** tab.  Finally, check **"Web Tools (WTP) Update Site"** again and click on **"Install..."** button to complete installation of WTP.

It is necessary to install a server to run the application. We have tested with Apache Tomcat 6.0.

# 3. Configuration #

The file _hpe.location.properties_ contains the property LOCATION\_HOME, which points to the base directory of the location, where it will put the managed component configurations. The path where the Location will find _hpe.location.properties_ may be defined by an environment variable called HPE\_LOCATION\_PROPERTIES. If it does not exist, the file must be found in the user home directory.

In our tests, we have created a folder _location service_ to be the **custom location** of the server. One may configure the **server location** by clicking twice on the server in the _Servers_ tab. Inside this folder, we have created a folder _RUN\_BASE_, for which our LOCATION\_HOME points to.

In the **Downloads** tab, you can take the file location.xml, where information about stored configurations is kept. It is initially empty. You can put it in the folder _RUN\_BASE_ before executing the Location.

<a href='Hidden comment: 
In the *Downloads* tab, we have put a _RUN_BASE.zip_ file, which contains an example of RUN_BASE folder. You may extract it into the path indicated by LOCATION_HOME to do tests and check your proect installation.
'></a>

# 4. Execution #

You can run the Location on a server (menu "Run As"/"Run on Server"). Choose the appropriate server.



