package hPE.frontend.edits.base;

import hPE.frontend.edits.kinds.activate.computation.ComputationComponentEditPart;
import hPE.frontend.edits.kinds.activate.computation.ComputationConfigurationEditPart;
import hPE.frontend.edits.kinds.activate.computation.ComputationEntryEditPart;
import hPE.frontend.edits.kinds.activate.computation.ComputationInterfaceEditPart;
import hPE.frontend.edits.kinds.activate.computation.ComputationInterfaceSliceEditPart;
import hPE.frontend.edits.kinds.activate.computation.ComputationUnitEditPart;
import hPE.frontend.edits.kinds.activate.computation.ComputationUnitSliceEditPart;
import hPE.frontend.edits.kinds.activate.computation.application.ApplicationComponentEditPart;
import hPE.frontend.edits.kinds.activate.computation.application.ApplicationConfigurationEditPart;
import hPE.frontend.edits.kinds.activate.computation.application.ApplicationEntryEditPart;
import hPE.frontend.edits.kinds.activate.computation.application.ApplicationInterfaceEditPart;
import hPE.frontend.edits.kinds.activate.computation.application.ApplicationInterfaceSliceEditPart;
import hPE.frontend.edits.kinds.activate.computation.application.ApplicationUnitEditPart;
import hPE.frontend.edits.kinds.activate.computation.application.ApplicationUnitSliceEditPart;
import hPE.frontend.edits.kinds.activate.synchronization.SynchronizationComponentEditPart;
import hPE.frontend.edits.kinds.activate.synchronization.SynchronizationConfigurationEditPart;
import hPE.frontend.edits.kinds.activate.synchronization.SynchronizationEntryEditPart;
import hPE.frontend.edits.kinds.activate.synchronization.SynchronizationInterfaceEditPart;
import hPE.frontend.edits.kinds.activate.synchronization.SynchronizationInterfaceSliceEditPart;
import hPE.frontend.edits.kinds.activate.synchronization.SynchronizationUnitEditPart;
import hPE.frontend.edits.kinds.activate.synchronization.SynchronizationUnitSliceEditPart;
import hPE.frontend.edits.kinds.data.DataComponentEditPart;
import hPE.frontend.edits.kinds.data.DataConfigurationEditPart;
import hPE.frontend.edits.kinds.data.DataEntryEditPart;
import hPE.frontend.edits.kinds.data.DataInterfaceEditPart;
import hPE.frontend.edits.kinds.data.DataInterfaceSliceEditPart;
import hPE.frontend.edits.kinds.data.DataUnitEditPart;
import hPE.frontend.edits.kinds.data.DataUnitSliceEditPart;
import hPE.frontend.edits.kinds.qualifier.QualifierComponentEditPart;
import hPE.frontend.edits.kinds.qualifier.QualifierConfigurationEditPart;
import hPE.frontend.edits.kinds.qualifier.QualifierEntryEditPart;
import hPE.frontend.edits.kinds.qualifier.QualifierInterfaceEditPart;
import hPE.frontend.edits.kinds.qualifier.QualifierInterfaceSliceEditPart;
import hPE.frontend.edits.kinds.qualifier.QualifierUnitEditPart;
import hPE.frontend.edits.kinds.qualifier.QualifierUnitSliceEditPart;
import hPE.frontend.edits.kinds.qualifier.architecture.ArchitectureComponentEditPart;
import hPE.frontend.edits.kinds.qualifier.architecture.ArchitectureConfigurationEditPart;
import hPE.frontend.edits.kinds.qualifier.architecture.ArchitectureEntryEditPart;
import hPE.frontend.edits.kinds.qualifier.architecture.ArchitectureInterfaceEditPart;
import hPE.frontend.edits.kinds.qualifier.architecture.ArchitectureInterfaceSliceEditPart;
import hPE.frontend.edits.kinds.qualifier.architecture.ArchitectureUnitEditPart;
import hPE.frontend.edits.kinds.qualifier.architecture.ArchitectureUnitSliceEditPart;
import hPE.frontend.edits.kinds.qualifier.environment.EnvironmentComponentEditPart;
import hPE.frontend.edits.kinds.qualifier.environment.EnvironmentConfigurationEditPart;
import hPE.frontend.edits.kinds.qualifier.environment.EnvironmentEntryEditPart;
import hPE.frontend.edits.kinds.qualifier.environment.EnvironmentInterfaceEditPart;
import hPE.frontend.edits.kinds.qualifier.environment.EnvironmentInterfaceSliceEditPart;
import hPE.frontend.edits.kinds.qualifier.environment.EnvironmentUnitEditPart;
import hPE.frontend.edits.kinds.qualifier.environment.EnvironmentUnitSliceEditPart;
import hPE.frontend.figures.base.ComponentFigure;
import hPE.frontend.figures.base.ConfigurationFigure;
import hPE.frontend.figures.base.EntryFigure;
import hPE.frontend.figures.base.InterfaceFigure;
import hPE.frontend.figures.base.InterfaceSliceFigure;
import hPE.frontend.figures.base.UnitFigure;
import hPE.frontend.figures.base.UnitSliceFigure;
import hPE.frontend.figures.kinds.activate.computation.ComputationComponentFigure;
import hPE.frontend.figures.kinds.activate.computation.ComputationConfigurationFigure;
import hPE.frontend.figures.kinds.activate.computation.ComputationEntryFigure;
import hPE.frontend.figures.kinds.activate.computation.ComputationInterfaceFigure;
import hPE.frontend.figures.kinds.activate.computation.ComputationInterfaceSliceFigure;
import hPE.frontend.figures.kinds.activate.computation.ComputationUnitFigure;
import hPE.frontend.figures.kinds.activate.computation.ComputationUnitSliceFigure;
import hPE.frontend.figures.kinds.activate.computation.application.ApplicationComponentFigure;
import hPE.frontend.figures.kinds.activate.computation.application.ApplicationConfigurationFigure;
import hPE.frontend.figures.kinds.activate.computation.application.ApplicationEntryFigure;
import hPE.frontend.figures.kinds.activate.computation.application.ApplicationInterfaceFigure;
import hPE.frontend.figures.kinds.activate.computation.application.ApplicationInterfaceSliceFigure;
import hPE.frontend.figures.kinds.activate.computation.application.ApplicationUnitFigure;
import hPE.frontend.figures.kinds.activate.computation.application.ApplicationUnitSliceFigure;
import hPE.frontend.figures.kinds.activate.synchronization.SynchronizationComponentFigure;
import hPE.frontend.figures.kinds.activate.synchronization.SynchronizationConfigurationFigure;
import hPE.frontend.figures.kinds.activate.synchronization.SynchronizationEntryFigure;
import hPE.frontend.figures.kinds.activate.synchronization.SynchronizationInterfaceFigure;
import hPE.frontend.figures.kinds.activate.synchronization.SynchronizationInterfaceSliceFigure;
import hPE.frontend.figures.kinds.activate.synchronization.SynchronizationUnitFigure;
import hPE.frontend.figures.kinds.activate.synchronization.SynchronizationUnitSliceFigure;
import hPE.frontend.figures.kinds.data.DataComponentFigure;
import hPE.frontend.figures.kinds.data.DataConfigurationFigure;
import hPE.frontend.figures.kinds.data.DataEntryFigure;
import hPE.frontend.figures.kinds.data.DataInterfaceFigure;
import hPE.frontend.figures.kinds.data.DataInterfaceSliceFigure;
import hPE.frontend.figures.kinds.data.DataUnitFigure;
import hPE.frontend.figures.kinds.data.DataUnitSliceFigure;
import hPE.frontend.figures.kinds.qualifier.QualifierComponentFigure;
import hPE.frontend.figures.kinds.qualifier.QualifierConfigurationFigure;
import hPE.frontend.figures.kinds.qualifier.QualifierEntryFigure;
import hPE.frontend.figures.kinds.qualifier.QualifierInterfaceFigure;
import hPE.frontend.figures.kinds.qualifier.QualifierInterfaceSliceFigure;
import hPE.frontend.figures.kinds.qualifier.QualifierUnitFigure;
import hPE.frontend.figures.kinds.qualifier.QualifierUnitSliceFigure;
import hPE.frontend.figures.kinds.qualifier.architecture.ArchitectureComponentFigure;
import hPE.frontend.figures.kinds.qualifier.architecture.ArchitectureConfigurationFigure;
import hPE.frontend.figures.kinds.qualifier.architecture.ArchitectureEntryFigure;
import hPE.frontend.figures.kinds.qualifier.architecture.ArchitectureInterfaceFigure;
import hPE.frontend.figures.kinds.qualifier.architecture.ArchitectureInterfaceSliceFigure;
import hPE.frontend.figures.kinds.qualifier.architecture.ArchitectureUnitFigure;
import hPE.frontend.figures.kinds.qualifier.architecture.ArchitectureUnitSliceFigure;
import hPE.frontend.figures.kinds.qualifier.environment.EnvironmentComponentFigure;
import hPE.frontend.figures.kinds.qualifier.environment.EnvironmentConfigurationFigure;
import hPE.frontend.figures.kinds.qualifier.environment.EnvironmentEntryFigure;
import hPE.frontend.figures.kinds.qualifier.environment.EnvironmentInterfaceFigure;
import hPE.frontend.figures.kinds.qualifier.environment.EnvironmentInterfaceSliceFigure;
import hPE.frontend.figures.kinds.qualifier.environment.EnvironmentUnitFigure;
import hPE.frontend.figures.kinds.qualifier.environment.EnvironmentUnitSliceFigure;
import hPE.model.base.HBinding;
import hPE.model.base.HComponent;
import hPE.model.base.HInterface;
import hPE.model.base.HInterfaceSlice;
import hPE.model.base.HLinkToInterface;
import hPE.model.base.HLinkToReplicator;
import hPE.model.base.HPort;
import hPE.model.base.HReplicator;
import hPE.model.base.HReplicatorSplit;
import hPE.model.base.HUnit;
import hPE.model.base.HUnitSlice;
import hPE.model.base.IHUnit;
import hPE.model.kinds.activate.computation.HComputationComponent;
import hPE.model.kinds.activate.computation.HComputationInterface;
import hPE.model.kinds.activate.computation.HComputationInterfaceSlice;
import hPE.model.kinds.activate.computation.HComputationUnit;
import hPE.model.kinds.activate.computation.HComputationUnitSlice;
import hPE.model.kinds.activate.computation.IHComputationUnit;
import hPE.model.kinds.activate.computation.application.HApplicationComponent;
import hPE.model.kinds.activate.computation.application.HApplicationInterface;
import hPE.model.kinds.activate.computation.application.HApplicationInterfaceSlice;
import hPE.model.kinds.activate.computation.application.HApplicationUnit;
import hPE.model.kinds.activate.computation.application.HApplicationUnitSlice;
import hPE.model.kinds.activate.computation.application.IHApplicationUnit;
import hPE.model.kinds.activate.synchronization.HSynchronizationComponent;
import hPE.model.kinds.activate.synchronization.HSynchronizationInterface;
import hPE.model.kinds.activate.synchronization.HSynchronizationInterfaceSlice;
import hPE.model.kinds.activate.synchronization.HSynchronizationUnit;
import hPE.model.kinds.activate.synchronization.HSynchronizationUnitSlice;
import hPE.model.kinds.activate.synchronization.IHSynchronizationUnit;
import hPE.model.kinds.data.HDataComponent;
import hPE.model.kinds.data.HDataInterface;
import hPE.model.kinds.data.HDataInterfaceSlice;
import hPE.model.kinds.data.HDataUnit;
import hPE.model.kinds.data.HDataUnitSlice;
import hPE.model.kinds.data.IHDataUnit;
import hPE.model.kinds.qualifier.HQualifierComponent;
import hPE.model.kinds.qualifier.HQualifierInterface;
import hPE.model.kinds.qualifier.HQualifierInterfaceSlice;
import hPE.model.kinds.qualifier.HQualifierUnit;
import hPE.model.kinds.qualifier.HQualifierUnitSlice;
import hPE.model.kinds.qualifier.IHQualifierUnit;
import hPE.model.kinds.qualifier.architecture.HArchitectureComponent;
import hPE.model.kinds.qualifier.architecture.HArchitectureInterface;
import hPE.model.kinds.qualifier.architecture.HArchitectureInterfaceSlice;
import hPE.model.kinds.qualifier.architecture.HArchitectureUnit;
import hPE.model.kinds.qualifier.architecture.HArchitectureUnitSlice;
import hPE.model.kinds.qualifier.architecture.IHArchitectureUnit;
import hPE.model.kinds.qualifier.environment.HEnvironmentComponent;
import hPE.model.kinds.qualifier.environment.HEnvironmentInterface;
import hPE.model.kinds.qualifier.environment.HEnvironmentInterfaceSlice;
import hPE.model.kinds.qualifier.environment.HEnvironmentUnit;
import hPE.model.kinds.qualifier.environment.HEnvironmentUnitSlice;
import hPE.model.kinds.qualifier.environment.IHEnvironmentUnit;
import hPE.model.protocol.kinds.activate.HAction;
import hPE.model.protocol.kinds.activate.HActionEntry;
import hPE.model.protocol.kinds.activate.HActionExit;
import hPE.model.protocol.kinds.activate.HAltAction;
import hPE.model.protocol.kinds.activate.HDoAction;
import hPE.model.protocol.kinds.activate.HParAction;
import hPE.model.protocol.kinds.activate.HProtocol;
import hPE.model.protocol.kinds.activate.HSeqAction;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

public class MainConfigurationEditPartFactory implements EditPartFactory {

	public MainConfigurationEditPartFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditPart createEditPart(EditPart context, Object model) {
		
		EditPart part = null;
		
		if (model instanceof HComponent) {
			if (context == null) {
				if (model instanceof HApplicationComponent)
					part = new ApplicationConfigurationEditPart<HApplicationComponent,ApplicationConfigurationFigure>();
				else if (model instanceof HComputationComponent)
			        part = new ComputationConfigurationEditPart<HComputationComponent,ComputationConfigurationFigure>();
				else if (model instanceof HArchitectureComponent)
					part = new ArchitectureConfigurationEditPart<HArchitectureComponent,ArchitectureConfigurationFigure>();
				else if (model instanceof HDataComponent)
					part = new DataConfigurationEditPart<HDataComponent,DataConfigurationFigure>();
				else if (model instanceof HSynchronizationComponent)
					part = new SynchronizationConfigurationEditPart<HSynchronizationComponent,SynchronizationConfigurationFigure>();
				else if (model instanceof HQualifierComponent)
					part = new QualifierConfigurationEditPart<HQualifierComponent,QualifierConfigurationFigure>();
				else if (model instanceof HEnvironmentComponent)
					part = new EnvironmentConfigurationEditPart<HEnvironmentComponent,EnvironmentConfigurationFigure>();
				else 
					part = new ConfigurationEditPart<HComponent,ConfigurationFigure>();
			} else if (context instanceof ComponentEditPart) {
				// TODO: Exposed INNER COMPONENTS !!!!
				
				
			} else {
				if (model instanceof HApplicationComponent)
					part = new ApplicationComponentEditPart<HApplicationComponent,ApplicationComponentFigure>();
				else if (model instanceof HComputationComponent)
			        part = new ComputationComponentEditPart<HComputationComponent,ComputationComponentFigure>();
				else if (model instanceof HDataComponent)
					part = new DataComponentEditPart<HDataComponent,DataComponentFigure>();
				else if (model instanceof HArchitectureComponent)
					part = new ArchitectureComponentEditPart<HArchitectureComponent,ArchitectureComponentFigure>();
				else if (model instanceof HSynchronizationComponent)
					part = new SynchronizationComponentEditPart<HSynchronizationComponent,SynchronizationComponentFigure>();
				else if (model instanceof HQualifierComponent)
					part = new QualifierComponentEditPart<HQualifierComponent,QualifierComponentFigure>();
				else if (model instanceof HEnvironmentComponent)
					part = new EnvironmentComponentEditPart<HEnvironmentComponent,EnvironmentComponentFigure>();
				else 
					part = new ComponentEditPart<HComponent,ComponentFigure>();
			}
		} else if (model instanceof IHUnit) {
			if (context instanceof ConfigurationEditPart) {
				if (model instanceof IHApplicationUnit) 
					part = new ApplicationUnitEditPart<HApplicationUnit,ApplicationUnitFigure>();
				else if (model instanceof IHComputationUnit)
					part = new ComputationUnitEditPart<HComputationUnit,ComputationUnitFigure>();				
				else if (model instanceof IHDataUnit) 
					part = new DataUnitEditPart<HDataUnit,DataUnitFigure>();
				else if (model instanceof IHArchitectureUnit) 
					part = new ArchitectureUnitEditPart<HArchitectureUnit,ArchitectureUnitFigure>();
				else if (model instanceof IHSynchronizationUnit) 
					part = new SynchronizationUnitEditPart<HSynchronizationUnit,SynchronizationUnitFigure>();
				else if (model instanceof IHEnvironmentUnit) 
					part = new EnvironmentUnitEditPart<HEnvironmentUnit,EnvironmentUnitFigure>();
				else if (model instanceof IHQualifierUnit) 
					part = new QualifierUnitEditPart<HQualifierUnit,QualifierUnitFigure>();
				else 
					part = new UnitEditPart<HUnit,UnitFigure>();
		    } else {
		    	if (model instanceof HApplicationUnit) 
					part = new ApplicationEntryEditPart<HApplicationUnit,ApplicationEntryFigure>();
				else if (model instanceof HComputationUnit)
			        part = new ComputationEntryEditPart<HComputationUnit,ComputationEntryFigure>();
				else if (model instanceof HDataUnit) 
					part = new DataEntryEditPart<HDataUnit,DataEntryFigure>();
				else if (model instanceof HArchitectureUnit) 
					part = new ArchitectureEntryEditPart<HArchitectureUnit,ArchitectureEntryFigure>();
				else if (model instanceof HSynchronizationUnit) 
					part = new SynchronizationEntryEditPart<HSynchronizationUnit,SynchronizationEntryFigure>();
				else if (model instanceof HEnvironmentUnit) 
					part = new EnvironmentEntryEditPart<HEnvironmentUnit,EnvironmentEntryFigure>();
				else if (model instanceof HQualifierUnit) 
					part = new QualifierEntryEditPart<HQualifierUnit,QualifierEntryFigure>();
				else 
					part = new EntryEditPart<HUnit,EntryFigure>();
		    }
			
		} else if (model instanceof HUnitSlice) {
			if (model instanceof HApplicationUnitSlice) 
			    part = new ApplicationUnitSliceEditPart<HApplicationUnitSlice,ApplicationUnitSliceFigure>();
			else if (model instanceof HComputationUnitSlice)
			    part = new ComputationUnitSliceEditPart<HComputationUnitSlice,ComputationUnitSliceFigure>();
			else if (model instanceof HDataUnitSlice) 
			    part = new DataUnitSliceEditPart<HDataUnitSlice,DataUnitSliceFigure>();
			else if (model instanceof HArchitectureUnitSlice) 
			    part = new ArchitectureUnitSliceEditPart<HArchitectureUnitSlice,ArchitectureUnitSliceFigure>();
			else if (model instanceof HSynchronizationUnitSlice) 
			    part = new SynchronizationUnitSliceEditPart<HSynchronizationUnitSlice,SynchronizationUnitSliceFigure>();
			else if (model instanceof HEnvironmentUnitSlice) 
			    part = new EnvironmentUnitSliceEditPart<HEnvironmentUnitSlice,EnvironmentUnitSliceFigure>();
			else if (model instanceof HQualifierUnitSlice) 
			    part = new QualifierUnitSliceEditPart<HQualifierUnitSlice,QualifierUnitSliceFigure>();
			else 
			    part = new UnitSliceEditPart<HUnitSlice,UnitSliceFigure>();
		} else if (model instanceof HInterfaceSlice) {
			if (model instanceof HApplicationInterfaceSlice) 
			    part = new ApplicationInterfaceSliceEditPart<HApplicationInterfaceSlice,ApplicationInterfaceSliceFigure>();
			else if (model instanceof HComputationInterfaceSlice)
			    part = new ComputationInterfaceSliceEditPart<HComputationInterfaceSlice,ComputationInterfaceSliceFigure>();
			else if (model instanceof HDataInterfaceSlice) 
			    part = new DataInterfaceSliceEditPart<HDataInterfaceSlice,DataInterfaceSliceFigure>();
			else if (model instanceof HArchitectureInterfaceSlice) 
			    part = new ArchitectureInterfaceSliceEditPart<HArchitectureInterfaceSlice,ArchitectureInterfaceSliceFigure>();
			else if (model instanceof HSynchronizationInterfaceSlice) 
			    part = new SynchronizationInterfaceSliceEditPart<HSynchronizationInterfaceSlice,SynchronizationInterfaceSliceFigure>();
			else if (model instanceof HEnvironmentInterfaceSlice) 
			    part = new EnvironmentInterfaceSliceEditPart<HEnvironmentInterfaceSlice,EnvironmentInterfaceSliceFigure>();
			else if (model instanceof HQualifierInterfaceSlice) 
			    part = new QualifierInterfaceSliceEditPart<HQualifierInterfaceSlice,QualifierInterfaceSliceFigure>();
			else 
			    part = new InterfaceSliceEditPart<HInterfaceSlice,InterfaceSliceFigure>();
		} else if (model instanceof HBinding) {
			part = new BindingEditPart();
		} else if (model instanceof HInterface) {
			if (model instanceof HApplicationInterface)
				part = new ApplicationInterfaceEditPart<HApplicationInterface,ApplicationInterfaceFigure>();
			else if (model instanceof HComputationInterface)
			    part = new ComputationInterfaceEditPart<HComputationInterface,ComputationInterfaceFigure>();
			else if (model instanceof HDataInterface)
				part = new DataInterfaceEditPart<HDataInterface,DataInterfaceFigure>();
			else if (model instanceof HArchitectureInterface)
				part = new ArchitectureInterfaceEditPart<HArchitectureInterface,ArchitectureInterfaceFigure>();
			else if (model instanceof HSynchronizationInterface)
				part = new SynchronizationInterfaceEditPart<HSynchronizationInterface,SynchronizationInterfaceFigure>();
			else if (model instanceof HEnvironmentInterface)
				part = new EnvironmentInterfaceEditPart<HEnvironmentInterface,EnvironmentInterfaceFigure>();
			else if (model instanceof HQualifierInterface)
				part = new QualifierInterfaceEditPart<HQualifierInterface,QualifierInterfaceFigure>();
			else 
				part = new InterfaceEditPart<HInterface,InterfaceFigure>();
		} else if (model instanceof HReplicator) {
			part = new ReplicatorEditPart();			
		} else if (model instanceof HReplicatorSplit) {
			part = new ReplicatorSplitEditPart();
		} else if (model instanceof HLinkToInterface) {
			part = new LinkToInterfaceEditPart();
		} else if (model instanceof HLinkToReplicator) {
			part = new LinkToReplicatorEditPart();
		} else if (model instanceof HSeqAction) {
			part = new SeqActionEditPart();
		} else if (model instanceof HParAction) {
			part = new ParActionEditPart();
		} else if (model instanceof HAltAction) {
			part = new AltActionEditPart();
		} else if (model instanceof HDoAction) {
			part = new DoActionEditPart();
		} else if (model instanceof HAction) {
			part = new ActionEditPart();
		} else if (model instanceof HProtocol) {
			part = new ProtocolEditPart();
		} else if (model instanceof HActionEntry) {
			part = new EntryActionCombinatorEditPart();
		} else if (model instanceof HActionExit) {
			part = new ExitActionCombinatorEditPart();
		} else if (model instanceof String) {
			String s = (String) model;
			String s2 = s.substring(0,s.indexOf("."));
			if (s2.equals("PortOwnership")) {
			  part = new PortBindingConnectionEditPart();
			} else { 			
			  part = new ActionConnectionEditPart();
			}
		} else if (model instanceof HPort) {
			part = new ProvidesPortEditPart();	 	
			//model = ((PortWrapper)model).getWrappedPort();
		} else {
			part = null;
		}
		

		
		part.setModel(model);
		

		
		
		return part;
	}

}
