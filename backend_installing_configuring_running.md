# 1. Introduction #

Here, we present basic instructions on how to install the HPE\_BackEnd project on Eclipse Ganymede (3.4) and how to configure it for execution on the Mono platform.


# 2. Dependencies #

## 2.1. For development on Eclipse Ganymede ##

  * Plug-in SVN (use configuration manager to find);
    * Access the **"Help / Software Updates"** menu. In the tab **"Available Software"**, click on **"Add Site..."**. Enter http://subclipse.tigris.org/update_1.4.x and click "**OK**" to come back to **"Available Software"** tab. Finally, check http://subclipse.tigris.org/update_1.4.x and click on **"Install..."** button to complete installation of SVN client support.

  * Mono 2.0.1;
    * http://www.mono-project.com/Main_Page

  * NAnt – A .NET Build Tool
    * http://nant.sourceforge.net/

  * Plug-in Emonic
    * http://sourceforge.net/projects/emonic
    * http://www.ibm.com/developerworks/library/os-eclipse-migratenetvs/index.html

## 2.2. For Execution on Mono Platform ##

  * MySQL 6.0;
    * after installing MySQL, create a database named "hashmodel" and execute the script _DGAC.SQL_ found in the **Downloads** tab of the project site.
    * The Back-End access the database using the configuration found in _hpe.backend.properties.xml_, mentioned in the next section.
    * Configure the root user for the Back-End to access the database. We had problems when trying to use a different account in Linux and Windows. If you are interested to test and fix this problem, try it and inform us about your conclusions !
  * Mono 2.0.1;
    * http://www.mono-project.com/Main_Page

  * Open MPI, MPICH2 (Linux) or MSMPI (Windows);
    * In fact, any MPI distribution that has been tested with MPI.NET;

  * MPI.NET
    * http://www.osl.iu.edu/research/mpi.net/

I recommend to install Open MPI and MPI.NET by compiling from the sources.



# 3. Configuration #

The file _hpe.backend.properties_ defines the set of current properties that affect the execution of the Back-End. The user must setup their values according the their systems. There is an example of _hpe.backend.properties_ located at the root of the project folder. The file is self-explaining. It contains comments that explain the meaning of each property.
The path where the Back-End processes will look for _hpe.backend.properties.xml_ may be defined by a command line argument "--properties _path_". If it is not provided, the Back-End will look for an environment variable BACKEND\_PROPERTIES\_FILE. If it does not exist, the file must be found in the current path of the process.

# 4. Execution on the Local System #

The Back-End is formed by one master process and a worker process. The master is responsible to process requisitions from the web service (entry point of the Back-End). The worker is responsible to respond requisitions from the master for executing commands for compiling sources, managing the assembly cache, and running programs by calling _mpirun_. Such separation ensures that commands are executed in the _hpe.backend_ user mode, independently of the kind of server adopted.

## 4.1. Launching the Worker ##

The worker is a windows services that runs in user mode (_hpe.backend_ in Castanhão). The Back-End communicates to it using the IPC protocol. The command line to launch the worker service is:

> _mono-service2 bin/WorkerService.exe_



## 4.2. Deploying the Web Service ##

The simplest way to deploy the Back-End's web service (_BackEndWS.asmx_) is using xsp.

More detailed instructions on how to deploy a ASP.NET web service using Mono may be found on http://www.mono-project.com/ASP.NET.

# 5. Access #

The Back-End provides services for **deploying** a component on the cluster, **running** an application component, and **browsing** the environment of components deployed in the cluster. Moreover, there are plans to include services for monitoring execution of an application in the future.

The Front-End has been developed to be the client of the Back-End's Web Service, but any other client application may consume the Back-End's Web Service to deploy and run components.

## 5.1. Deploying a Component ##

Call the service **deployHashComponent** from the _client_ program, by providing as argument an array of bytes corresponding to the configuration (a xml format). It is supposed that all inner components of the component being deployed (its dependencies) are already deployed.

## 5.2. Running an Application ##

Call the service **runApplication** from the _client_ program, by providing as argument the component identifier, and actual values for its enumerators.

The values of the enumerators will define the number of processes to be launched.