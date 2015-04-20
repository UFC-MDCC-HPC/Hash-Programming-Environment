# 1. Introduction #

This tutorial intends to teach you how to build configurations of abstract components and #-components, to deploy them to a parallel computing platform, and to execute them.

# 2. How to Create a Configuration #

## Step 1: Create a .NET Project ##

  1. Enter the menu **File/New/Other...**;
  1. Look for the ".NET project" wizard by expanding the ".NET" node in the tree;
> > The wizard ".NET Project" is only available if you have installed the Emonic plugin (see the wiki with instructions for installing the Front-End project in Eclipse). Click "Next".
  1. In the "New .NET Project" window, type the "Project Name" by informing _{package}.{component\_name}_. For example, if you want to create a configuration named _MatVecProduct_ in the package _math.linear\_algebra.level2_, type "_math.linear\_algebra.level2.MatVecProduct_";
  1. Probably, you will want to set "Target Framework" parameter, in the "Build" panel, to be "Mono-2.0";
  1. Click "Finish" if you want to complete the Wizard (this is sufficient for a basic ".NET Project".) or "Next" if you plan to configure copyright statement, default namespace, and references to other projects (not applicable for configuration projects);
  1. The project will appear in your "Configuration Sessions" view.


## Step 2: Create a Configuration ##

  1. Look for the project you have created in Step 1 in "Configuration Sessions" view;
  1. Click with right button on the project;
  1. On the floating menu, select **File/New/Other...**;
  1. Look for the "# Configuration" wizard in "Other" node;
  1. Click on "# Configuration" and click "Next" to initiate the wizard;
  1. In "Enter or select the parent folder", the name of the project appears;
  1. In the "Component Kinds" panel, you must select the kind of$the configuration among seven ones currently supported;
  1. On the right, you must select either "Abstract", if the configuration is for an abstract component, or "Concrete", if the configuration is for a #-component (implementations of abstract components);
  1. If you select "Concrete", you may also select the initial version of the #-component (above "Component Kinds" panel);
  1. Abstract components are not versioned, by definition;
  1. An empty configuration will be open in the editor area. The name of the component, as well its kind and nature, appear written in the configuration area. For example, if _MatVecProduct_ is an abstract component of kind computation, you will see "**Abstract Computation MatVecProduct**". If it is a #-component (concrete), you will see "**Computation MatVecProduct implements ?**". The **?** modifier means that the programmer must still define the base abstract component that will be implemented for some desired context;
  1. We will teach you to perform configuration operations in Sections 7 (Abstract Components) and 8 (#-Components). Before that, we will explain some top-level operations to perform with configurations.

# 3. How to Manage Versions (of #-Components) #


> You can work with several versions of a #-Component. For that, at any moment of the life cicle of a configuration, left-click on the editing area and then righ-click. In the floating menu, choose "Manage Versions". In the open window, you can specify the four fields that define a version (build, major, minor, revision). Then, you can either add (>) or remove (<) it in the list of versions of the #-component. The versioning conventions follow the ECMA-334 standard conventions for CLI platforms (.NET and Mono).

> An error dialog appears if you try to remove a version that has an implementation for one or more units of the #-component.

> Click "Exit" to confirm changes to versions or "Cancel" to ignore them.

# 4. How to Register a Component in a Location (Front-End to Core Interface) #

> After configuration, you can register a well-formed component in a **location**. Anyone who has access to the location may access the component from the **location**. If someone fetch the component from the **location**, the component cannot be deleted from the location by you (the owner of the component). However, you can make a component _obsolete_. An obsolete component cannot be presented for new users. It can be accessed only from existing users.

  1. Right-click the configuration area and left-click. In the floating menu, choose "Register Component ...";
  1. In the "Register Component" window, choose the **location** in the "Location" list box;
  1. If there is no **location** listed in the list box (you see only an item "manage..."), you need to add new **locations**;
    * To add new locations, select "manage...". In the "Manage Locations" windows, type the address of one or more location that you want to access and click OK.
    * _NOTE: If you cannot see the "manage..." item in the list box, you need to edit the_CoreLocations.xml_file. See the Front-End's installation guideline wiki to know how to find this file._
  1. You can fetch an introductory message about the **location** by clicking "About Location";
  1. Click "Register Component" if you want to register a component to the **location**;
  1. If you want to make the source code of your component avaiable, check "Open Source";
  1. The component is sent to the location only if it has been successfully compiled in your local environment. Otherwise, a error message dialog is presented;
  1. If you want to unregister the component from the **location**, click "Unregister component";
    * Your component will be removed from the location only if none has accessed the component.
  1. If you want to make your component unavailable for new users, click "Mark as Obsolete". Take care ! This is an irreversible operation.


# 5. How to Deploy a Component in a Execution Platform (Front-End to Back-End Interface) #

> You can deploy a registered component to the _environment of components_ of a parallel computing platform that has a Back-End of HPE available. The configuration will be sent through the Back-End's Web Service to the platform and compiled there. It is necessary that all inner components of the configuration must deployed in the environment of components.

  1. Right-click the configuration area and left-click. In the floating menu, choose "Browse/Deploy/Run...";
  1. In the "Back-End Connection" window, choose a Back-End in the "Back-End" list box;
  1. Now, you can:
    * **Browse** the _environment of components_ (environment) of the parallel computing platform managed by the selected Back-End;
    * **Deploy** the component;
    * **Run** some #-component of kind application that is deployed in the environment.

> ## BROWSING ##

  1. For browsing the environment, click "Browse";
  1. After clicking "Browse", you can see the deployed components in the environment in the "Deployed Components" table. In the tab "Abstract" you can see the abstract components. In the tab "Concrete", you can see the #-components. Below, the meaning of the columns for a component:
    * _1st column_: package;
    * _2nd column_: name;
    * _3rd column_: kind;
    * _4th column_: enumerators.
  1. On the left side, you can filter the kinds of components you are interested to see. By default, you see only application ones.
  1. On the "Sort" panel, you can order components by their packages, names, or kinds.

> ## DEPLOYING ##

  1. Click on "Deploy" to deploy a component to the environment of the parallel computing platform;
  1. If the component was not yet registered to a location, an error message is presented. Only registered components may be submitted to a Back-End service.
  1. If deployment is successful, a confirmation message is presented.


> ## RUNNING ##

  1. If you want to run an application #-componenet, select it in the tab "Concrete" and click "Run Application";
  1. In the window "Configure Enumerators" provide values to define the cardinality of each enumerator of the component;
    * The cardinality of the enumerators will define the number of processes to be launched;
  1. Click "Run" to start the application;
  1. In the window "Running _C_ on _P_. Waiting ...", the console output of each launched process will be presented in a distinct tab, but not before the application finishes execution;

> There are somes issues to be improved concerned with launching of application components:

  1. The output console of each process is only presented after execution. Since HPE has been developed for long running applications, this is not acceptable. It is necessary to implement asynchronous update of output tabs or some interface for monitoring execution;
  1. Users cannot yet provide input files or parameters to the application. This is an important issue to consider.

# 6. How to Build a Configuration of Abstract Components #

> In what follows, the configuration operations for specification of abstract components are presented.

## 6.1. Creating Units ##

  1. The _units_ of an abstract component are inserted in the configuration area by clicking on the "Unit" item on the left toolbar and then clicking in the position at the configuration area where the unit will appear;
  1. You can move and resize the rectangle that represents the _unit_;
  1. Give a name to each _unit_ by clicking on the _unit_, in order to change the focus to it, and then clicking again on the _unit_ to open an editor. The editor will appear inside the _unit_ and you can give an appropriate name to it. We suggest to use lowercase alphanumeric identifiers for _units_;

## 6.2. Fetching Inner Components from a Location ##

  1. By supposing that you have a working location in the "Repository" view, you can fetch an abstract component from the location by performing a drag-and-drop operation from the abstract component at the location tree view to the intended position of the configuration area;
  1. Only abstract components can be configured as _inner components_;
  1. The ellipse representing the _inner component_ is presented in the configuration area. Their _units_ are the rectangles inside the ellipse. The name of the abstract component that types the inner component is presented inside the ellipse, exposing their _context parameters_ if they exist.
  1. You can move and resize the ellipses and their comprising _units_;
  1. By clicking on the ellipse that represents the _inner component_ with the focus on it, the user may open an editor to set a name for the _inner component_. The name will replace the name initially provided generated by the system;
  1. Now, you have in the configuration area a set of _units_ and _inner components_. The next steps will specify the _slices_ of the _units_, which are _units_ of _inner components_. This operation is called _overlapping composition_, since the inner components appear to be overlapped in order to specify the units of the abstract component. This is possible only after all free _context variables_ of all _inner components_ be bound;
  1. In a well-formed configuration, each _unit_ of an _inner component_ will belong to one, and only one, _unit_ of the abstract component being configured.

### 6.2.1. Public and Private Inner Components ###

  1. You must decide to make the _inner component_ **private** or **public** (_visibility_ property);
  1. The default visibility is **private**.
  1. Private _inner components_ are presented as a dotted ellipse while public ones are presented as solid ellipse;
  1. For alternating between visibility modes of the _inner component_, right-click on the ellipse that represent it and choose "Exposed Yes/No" in the floating menu;

### 6.2.2. Sharing of Transitive Inner Components ###

  1. If an _inner component_ in a configuration has public _inner components_, they will be shown in the configuration area, linked to the inner component that owns it by a line. They are called _transitive inner components_;
  1. You may fuse _N_ _transitive inner components_, denoting that they are shared by the  _inner components_ that own them;
  1. In order to fuse a set of transitive _inner components_, select them using the mouse, right-click on some of selected ones, and choose "Fuse" on the floating menu;
  1. The fused _inner components_ must be of compatible types. That is, it must be possible to define a chain among them using subtyping relation.
  1. You can modify visibility of transitive inner components, by using the approach described in the Section 6.2.1.


### 6.2.3. Binding Context Variables of Inner Components ###

  1. Let **field name = _C_ : Example** be a free context variable of some _inner component_ **a**, where **_C_** is a variable name, **Example** is the abstract component that represent an upper context, and **field name** is an identifier for making direct reference to a parameter of an abstract component (in general, the name give some hint about the meaning of the parameter);
    * You can change the name of **_C_** while it is free. For that, right-click **a** and choose "Change Variable Name" in the floating menu. In the "Change Parameter Name" window, select the field name of the _context parameter_ and type the name of the variable;
    * Note: _Field names_ are context parameter identifiers that make possible to refer to a parameter of an abstract component directly. Do not confuse them with _context variables_;
  1. In order to bind **_C_**, fetch from the location some inner component that is a specialization of **Example**, say **Example'** (i.e. **Example'** extends **Example**);
  1. If you want to make **_C_** a context parameter of the current configuration, right-click on the ellipse that represent **Example'** and choose "Set Parameter" in the floating menu. Otherwise, ignore the next instruction;
  1. In the "Parameter Configuration" window, type a _field name_ for the parameter (e.g. "example parameter").
    * A new parameter, identified by "example parameter", will appear in the header of the current configuration header, with "?" for the context variable;
  1. For binding the variable **_C_**, right-click the ellipse representing **Example'** and choose "Supply Parameter" in the floating menu;
  1. In the "Supply Parameter" window, type **_C_**, i.e. the name the variable to be bound;
  1. After supplying, the inner component **Example'** disappear from the screen and the variable associated to the parameter "example parameter" is now **_C_**. Also, notice that the upper bound of **_C_** has been specialized to **Example'**;
  1. If **Example'** is a context parameter of the configuration but it is not bound to context variables of inner components, you can set its context variable name by right-click it and choosing "Change Variable Name" in the floating menu. In the "Change Parameter Name" window, select the field name of the context parameter and type the name of the variable.



## 6.5. Importing a Slice onto a Unit ##

  1. After binding all context variables of _inner components_, you can import their _units_ in order to become _slices_ of _units_ of the abstract component being configured;
  1. For that, click on the "Connections" item of the left toolbar. In connection mode, click on the _unit_ of _inner component_ to be imported. Then, click on the _unit_ where it will placed as a _slice_. A rectangle appears inside the target _unit_, representing the _slice_. The rectangle can be resized and moved.

### 6.5.1. Visibility of Slices ###

  1. _Slices_ that come from a **public** _inner components_ are _**public** slices_;
  1. _Slices_ that come from a **private** _inner components_ are _**private** slices_;
  1. A arbitrary public _slice_ **_w_** of an arbitrary _unit_ **_u_** of an arbitrary _inner component_ is also a _slice_ (i.e. _transitive slice_) of the arbitrary top-level _unit_ **_v_** where **_u_** is a _slice_.
    * In the rectangle that represent the _interface_ of the _unit_ **_v_**, **_s_** is shown as a small circle linked by a line to the rectangle that represent the slice **_u_**.

## 6.6. Creating Interfaces of Units ##

  1. After configuring all the _slices_, left-click over each _unit_ and select "Create Interface" on the floating menu. A new dashed rectangle linked to the rectangle that represents the _unit_ will appear. It represents the _interface_ of the _unit_ (do not confuse with interfaces from Java and C#), where the source code of the _unit_ will be attached. _Interfaces_ are useful abstractions when more than one _units_ share the same implementation;
  1. You can also resize and move the rectangles that represent _slices_ and _interfaces_;
  1. In addition, you can assign colors to _interfaces_, which will be assined to _units_.

## 6.7. Configuring Protocols of Unit Interfaces ##

  1. Units of computations and synchronizers are _action slices_ in a _unit_ where they reside in a well-formed configuration;
  1. _Action slices_ denote operations that must be executed in some order;
  1. The order of activation of _action slices_ is semantically defined by _activation traces_;
  1. _Activation traces_ must be defined in the _protocol_ of _unit_ _interfaces_;
  1. A _protocol_ is a kind of behaviour expression denoting an action;
  1. An _action_ is recursively defined by the application of an _action combinator_ to a list of _actions_ or a primitive action, denoted by an _action slice_;
  1. The basic supported action combinators are inspired on process combinators of OCCAM language (sequence, parallelism, alternative, repetition), but we are working on the support of more combinators for multicore and multiprocessor programming (parallel-for loops, ...);
  1. In order to configure the _protocol_ of an _interface_, right-click in the rectangle representing the _unit interface_ and choose "Set Protocol" in the floating menu;
  1. In the _protocol_ editor, you see the starting action PAR(s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>n</sub>), where s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>n</sub> are the slices of the units of the interface;
  1. From the start action, you can apply a sequence of action operations for restricting traces of action slices.

## 6.8. Attaching Source Code to a Unit Interface ##

  1. For attaching a source code to an arbitrary interface **I**, right-click on the rectangle tha represent **I** and select "Edit Source" in the floating menu;
  1. The source code of the _units_ of **I** (C#) will appear in an editor. The programmer do not need to change the code. It defines a C# interface whose properties represent acessors for the public slices of the _units_ of **I**;

## 6.9. Working with Enumerators (Towards Building Scalable #-Components) ##

  1. For scalable parallel programming, it is often necessary to configure an abstract component with a finite, but arbitrary, say _N_, number of units;
  1. At startup time, the value of _N_ for a given application is defined and _N_ _units_ (processes) are launched in the nodes of the parallel computing platform;
  1. For defining an enumeration of units, click on the "Enumerator" element in the left tool bar of the configuration area and then click on the configuration area at the position where you want to place an _enumerator_;
  1. The _enumerator_ is represented by a blue circle with an "`*`" inside. The "`*`" symbol means that an _enumerator_ variable name has not yet been defined;
  1. You may set the _enumerator_ variable name by clicking twice (not double-click) on the enumerator and then typing the variable name, say "i", in the embedded editor;

### 6.9.1. Enumerating Units ###

  1. Click on "Connections" at the left toolbar. In the connection mode, click on the _unit_ and then on the _enumerator_. A line will link the _unit_ to the _enumerator_. If the name of the unit is **_u_**, it will be shown as **_u_**`[`i`]`, where "i" is the variable name of the _enumerator_;
  1. You can link as many _enumerators_ as you desire to a _unit_. The name of the _unit_ looks like **_u_**`[`i<sub>1</sub>,i<sub>2</sub>,...,i<sub>n</sub>`]`, where i<sub>1</sub>, i<sub>2</sub>, ..., i<sub>n</sub> are variable names of _enumerators_, listed in the order that they are placed in the configuration area (left to right, top to bottom);
  1. Several _enumerators_ may have the same variable name;
  1. If a _unit_ is connected to many _enumerators_, say i<sub>1</sub>, i<sub>2</sub>, ..., i<sub>n</sub>, then it is possible to fetch the current index of each _enumerator_ in the source code attached to the interface of the unit. The methods for that are provided by the interface **Unit**, whose implementing class **UnitImpl** is the base class of the classes attached to the interface units of #-components;
  1. With enumeration of _units_, one may program in SPMD style (Single Program Multiple Data), popularized by MPI. **This ensures that HPE has the same expressiveness power of MPI for describing parallel programs, but dealing with structural scale and complexity of applications**. However, we argue that _unit_ enumerator indexes are only essential in the implementation of synchronizers, in order to make possible a _unit_ to address another _unit_ in the execution of a communication operation offered by an _inner component_ of kind environment, even when implementing _peer-to-peer_ communication patterns;
    * In our implementation of the MPI environment, _communicators_ are created for scoped communication among units in the same synchronizer component and among _units_ of the same _enumeration_. In this case, a cartesian topology is used for addressing among units. Thus, for MPI, it is not essential to use enumerator indexes for addressing of units;

### 6.9.2. Enumerating Inner Components ###

  1. It is also possible to link an _inner component_ to _enumerators_;
  1. If the _inner component_ identifier is **a** and the variable name of the linked _enumerators_ are i<sub>1</sub>, i<sub>2</sub>, ..., i<sub>n</sub>, the identifier of the _inner component_ is shown as **a**`[`i<sub>1</sub>,i<sub>2</sub>,...,i<sub>n</sub>`]`;
  1. If you import a _unit_ of an enumerated _inner component_ as a _slice_ of a configuration _unit_, this _unit_ is automatically linked to the _enumerators_ of the _inner component_ to ensure consistency.

### 6.9.3. Enumerators Inherited from Inner Components ###

  1. An _enumerator_ of an _inner component_ is inherited in the configuration, linked to one or more _units_ of the _inner component_;
  1. If you import an enumerated _unit_ of an _inner component_ as a _slice_ of a configuration _unit_, this _unit_ is automatically linked to the _enumerators_ of the _inner component_ to ensure consistency;

### 6.9.4. Fusion of Enumerators ###

> Many _enumerators_ having the same name can be fused, since they represent the same range domain of enumeration. For that, the following conditions, regarding the cardinality of the fused enumerators, must be ensured:
    * All _enumerators_ have arbitrary cardinality. In such case, the resulting _enumerator_ has arbitrary cardinality;
    * Exactly one _enumerator_ has fixed cardinality _**S**_ and the other ones have arbitrary cardinality. In such case, the resulting _enumerator_ has cardinality _**S**_;
    * Two _enumerators_, among all ones, have distinct fixed cardinality. In such case, fusion is not possible;

> #### How to fuse _enumerators_ ? ####

  1. Select all the _enumerators_ to be fused (they must have the same variable name);
  1. Right-click on one of the _enumerators_, called the _root_ of the fusion, and choose "Fuse Enumerators";
  1. All links and _splits_ of the fused _enumerators_ will be redirected to the _enumerator_that represents the _root_ of the fusion.

### 6.9.5. Splitting Enumerators ###

> Let **C** be an abstract component with one _unit_ **u** replicated by _enumerator_ _N_. Suppose that: (1) you have fetched an _inner component_ **_i_**, of abstract component **C**, from a location onto the configuration area; (2) your configuration has two _units_, say **v<sub>1</sub>** and **v<sub>2</sub>**, replicated by _enumerators_ _I_ and _J_ respectively; (3) you want to split the set of _units_ represented by **u** in two subsets, **u<sub>1</sub>** and **u<sub>2</sub>**, in order to make them _slices_ of **v<sub>1</sub>** and **v<sub>2</sub>** respectively. Of course, this is only possible if _N_=_I_+_J_. Since these _enumerators_ have arbitrary cardinality, such restriction must be ensured by the execution system.

> #### How to split an enumeration of _units_ ? ####

  1. Right-click on the link (solid line) between the _enumerator_ _N_ and the _unit_ **u** of the _inner component_ **_i_**. In the floating menu, choose "Split Enumerator";
  1. In the window "Setting Splitting Factor", type an greater than one value that represent the the number of divisions of the enumeration. For the example, the sppliting factor is 2. Then, click "OK";
  1. A black bullet appears inside the _enumerator_ _N_ and two new enumerators are created, with unspecified names;
  1. Give to them the names _I_ and _J_;
  1. If enumerators _I_ and _J_ already exists, linked to **v<sub>1</sub>** and **v<sub>2</sub>**, you may fuse them with the new enumerators. Otherwise, link **v<sub>1</sub>** and **v<sub>2</sub>** to the new enumearators.

> #### Current Limitations ####

> If an _enumerator_ is split in _n_ _enumerators_, the resulting _split_ (black bullet) must carry information about how the enumerated items are distributed in the resultant subsets of items. This is not yet implemented. It is still supposed that the first _m_ elements will belong to the first subset and the last _p_ ones will belong to the second subset, where _m_+_p_=_n_. This is not still appropriate to represent some process topologies. We plan to introduce universal ways to distribute elements in the subsets induced by _splits_.



# 7. How to Build a Configuration of #-Component #