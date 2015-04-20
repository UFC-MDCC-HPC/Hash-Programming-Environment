# Introduction #

This step-by-step aims to teach how to introduce a new component kind in the Front-End of HPE. The example introduces the kind **Enumerator**. The details of each created class and interfaces can be obtained by looking at the revisions 350 and 357 of HPE.


# Steps #

## 1. Create the following packages: ##

### 1.1. `hPE.frontend.kinds.enumerator.model` ###

### 1.2. `hPE.frontend.kinds.enumerator.figures` ###

### 1.3. `hPE.frontend.kinds.enumerator.edits` ###

## 2. Create the following classes in `hPE.frontend.kinds.enumerator.model` ##

### 2.1. `HEnumeratorComponent` ###

Model of inner components and configurations.

You have to provide the static property _KIND_, and the methods _createUnit_, _accepts_, and _kindString_. The method _createUnit_ is a factory of units of the new kind. The method _accepts_ says which kinds of inner components are valid. The method _kindString_ defines the name of the kind.

### 2.2. `HEnumeratorInterface` ###

Model of interfaces.

A method _getSupportedSynthesizers_ would be necessary to setup the synthesizer class which will generate the source code of units.

### 2.3. `HEnumeratorInterfaceSlice` ###

Model of slices of interfaces.

### 2.4. `HEnumeratorUnit` and `HEnumeratorUnitStub` ###

Model of units.

It is necessary to define the methods _newSlice_ and _newInterface_, factories of slices and interfaces of the new kind, respectively.

### 2.5. `HEnumeratorUnitSlice` ###

Model of slices of units.

It is necessary to define the method _newInterfaceSlice_, for creating a slice of interface.


### 2.6. `IHEnumeratorUnit` ###



## 3. Create the following classes in **hPE.frontend.kinds.enumerator.edits** ##

### 3.1. `HEnumeratorComponentEditPart` ###

Controller of the inner components.

### 3.2. `HEnumeratorConfigurationEditPart` ###

Controller of the configuration.

### 3.3. `HEnumeratorEntryEditPart` ###

Controller of the units of inner components.

### 3.4. `HEnumeratorInterfaceEditPart` ###

Controller of the interfaces.

### 3.5. `HEnumeratorInterfaceSliceEditPart` ###

Controller of the slices of interfaces.

### 3.6. `HEnumeratorUnitEditPart` ###

Controller of the units.

### 3.7. `HEnumeratorUnitSliceEditPart` ###

Controller of the slices of units.

## 4. Create the following classes in `hPE.frontend.kinds.enumerator.figures` ##

### 4.1. `HEnumeratorComponentFigure` ###

Controller of the inner components.

### 4.2. `HEnumeratorConfigurationFigure` ###

View of the configuration.

### 4.3. `HEnumeratorEntryFigure` ###

View of the units of inner components.

### 4.4. `HEnumeratorInterfaceFigure` ###

View of the interfaces.

### 4.5. `HEnumeratorInterfaceSliceFigure` ###

View of the slices of interfaces.

### 4.6. `HEnumeratorUnitFigure` ###

View of the units.

### 4.7. `HEnumeratorUnitSliceFigure` ###

View of the slices of units.

## 5. Edit the class `hPE.frontend.MainConfigurationEditPartFactory` ##

Where the models are created. Add lines for configuration elements of the new kind.

## 6. Edit the class `hPE.SetVersionDialog` ##

  1. Create a new radio button for the new kind;
  1. In the method _createGroupKinds_, add a line like "`radioEnumerator.addSelectionListener(sl);`" to the initialization of the new kind to add the selection listener.
```
   radioEnumerator = new Button(groupKinds, SWT.RADIO);
   radioEnumerator.setBounds(new Rectangle(128, 58, 106, 16));
   radioEnumerator.setText("Enumerator");
   radioEnumerator.addSelectionListener(sl);
   radioEnumerator.setSelection(false);
```
  1. Create a get method for the radio button (e.g. _getRadioEnumerator_).
```
   public Button getRadioEnumerator() {
  	return this.radioEnumerator;
   }
```


## 7. Edit the class `hPE.HPEPage` ##

  1. In the method _getWidgetSelected_, add a new branch to the if statement for the new kind, accessing the appropriate radio button;
  1. In the method _finish_, add a case to the switch statement to create a component of the new kind.

## 8. Edit the method _createComponent_ the class `HComponentFactoryImpl` ##

> Add a branch to the if statement to create the component of the new kind.

```
   else if (kind.getName().equals(HEnumeratorComponent.KIND)) {
      	   c = new HEnumeratorComponent(name, location, uri);
   }
```

## 9. Edit the `HashComponet.xsd` in the package hPE.xml ##

> Add the name of the new kind to the enumeration type **SupportedKinds**. Then, generate the model classes, using the EMF Model generator.

## 10. Edit the method _accepts_ of each `HxxxxxComponent` ##

> Add a branch

```
   if (c instanceof HyyyyComponent) return true; 
```

> in the _accepts_ method of each `HxxxxComponent` class, where xxxx is the name of a kind of components that accept the a component of the new kind yyyy as an inner component. Alternatively, if they are accepted by all component kinds, you can modity the _accepts_ method of `HBaseKindComponent`.