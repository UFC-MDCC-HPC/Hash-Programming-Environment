package hPE.frontend;

import hPE.frontend.base.edits.ActionConnectionEditPart;
import hPE.frontend.base.edits.ActionEditPart;
import hPE.frontend.base.edits.AltActionEditPart;
import hPE.frontend.base.edits.BindingEditPart;
import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.edits.DoActionEditPart;
import hPE.frontend.base.edits.EntryActionCombinatorEditPart;
import hPE.frontend.base.edits.ExitActionCombinatorEditPart;
import hPE.frontend.base.edits.LinkToInterfaceEditPart;
import hPE.frontend.base.edits.LinkToReplicatorEditPart;
import hPE.frontend.base.edits.ParActionEditPart;
import hPE.frontend.base.edits.PortBindingConnectionEditPart;
import hPE.frontend.base.edits.ProtocolEditPart;
import hPE.frontend.base.edits.ProvidesPortEditPart;
import hPE.frontend.base.edits.ReplicatorEditPart;
import hPE.frontend.base.edits.ReplicatorSplitEditPart;
import hPE.frontend.base.edits.SeqActionEditPart;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HLinkToInterface;
import hPE.frontend.base.model.HLinkToReplicator;
import hPE.frontend.base.model.HPort;
import hPE.frontend.base.model.HReplicator;
import hPE.frontend.base.model.HReplicatorSplit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.KindConfiguration;
import hPE.frontend.kinds.KindManager;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HActionEntry;
import hPE.frontend.kinds.activate.model.protocol.HActionExit;
import hPE.frontend.kinds.activate.model.protocol.HAltAction;
import hPE.frontend.kinds.activate.model.protocol.HDoAction;
import hPE.frontend.kinds.activate.model.protocol.HParAction;
import hPE.frontend.kinds.activate.model.protocol.HProtocol;
import hPE.frontend.kinds.activate.model.protocol.HSeqAction;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

//TODO Rafael - Remover partes comentadas desnecessárias
public class ConfigurationEditPartFactory implements EditPartFactory {

	public ConfigurationEditPartFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;

		KindConfiguration kindConfiguration = KindManager.discoverKindConfiguration(model.getClass());

		if (model instanceof HComponent) {
			if (context == null) {
				//				if (model instanceof HApplicationComponent)
				//					part = new ApplicationConfigurationEditPart<HApplicationComponent,ApplicationConfigurationFigure>();
				//				else if (model instanceof HServiceComponent)
				//					part = new ServiceConfigurationEditPart<HServiceComponent,ServiceConfigurationFigure>();
				//				else if (model instanceof HComputationComponent)
				//					part = new ComputationConfigurationEditPart<HComputationComponent,ComputationConfigurationFigure>();
				//				else if (model instanceof HArchitectureComponent)
				//					part = new ArchitectureConfigurationEditPart<HArchitectureComponent,ArchitectureConfigurationFigure>();
				//				else if (model instanceof HDataComponent)
				//					part = new DataConfigurationEditPart<HDataComponent,DataConfigurationFigure>();
				//				else if (model instanceof HSynchronizationComponent)
				//					part = new SynchronizationConfigurationEditPart<HSynchronizationComponent,SynchronizationConfigurationFigure>();
				//				else if (model instanceof HQualifierComponent)
				//					part = new QualifierConfigurationEditPart<HQualifierComponent,QualifierConfigurationFigure>();
				//				else if (model instanceof HEnvironmentComponent)
				//					part = new EnvironmentConfigurationEditPart<HEnvironmentComponent,EnvironmentConfigurationFigure>();
				//				else if (model instanceof HEnumeratorComponent)
				//					part = new EnumeratorConfigurationEditPart<HEnumeratorComponent,EnumeratorConfigurationFigure>();
				//				else if (model instanceof HFacetComponent)
				//					part = new FacetConfigurationEditPart<HFacetComponent,FacetConfigurationFigure>();
				//				else if (model instanceof HDomainComponent)
				//					part = new DomainConfigurationEditPart<HDomainComponent,DomainConfigurationFigure>();
				//				else if (kindConfiguration != null)
				part = kindConfiguration.newConfigurationEditPart();
				//				else
				//					part = new ConfigurationEditPart<HComponent,ConfigurationFigure>();
			} else if (context instanceof ComponentEditPart) {
				// TODO: Exposed INNER COMPONENTS !!!!


			} else {
				//				if (model instanceof HApplicationComponent)
				//					part = new ApplicationComponentEditPart<HApplicationComponent,ApplicationComponentFigure>();
				//				else if (model instanceof HServiceComponent)
				//					part = new ServiceComponentEditPart<HServiceComponent,ServiceComponentFigure>();
				//				else if (model instanceof HComputationComponent)
				//					part = new ComputationComponentEditPart<HComputationComponent,ComputationComponentFigure>();
				//				else if (model instanceof HDataComponent)
				//					part = new DataComponentEditPart<HDataComponent,DataComponentFigure>();
				//				else if (model instanceof HArchitectureComponent)
				//					part = new ArchitectureComponentEditPart<HArchitectureComponent,ArchitectureComponentFigure>();
				//				else if (model instanceof HSynchronizationComponent)
				//					part = new SynchronizationComponentEditPart<HSynchronizationComponent,SynchronizationComponentFigure>();
				//				else if (model instanceof HQualifierComponent)
				//					part = new QualifierComponentEditPart<HQualifierComponent,QualifierComponentFigure>();
				//				else if (model instanceof HEnvironmentComponent)
				//					part = new EnvironmentComponentEditPart<HEnvironmentComponent,EnvironmentComponentFigure>();
				//				else if (model instanceof HEnumeratorComponent)
				//					part = new EnumeratorComponentEditPart<HEnumeratorComponent,EnumeratorComponentFigure>();
				//				else if (model instanceof HFacetComponent)
				//					part = new FacetComponentEditPart<HFacetComponent,FacetComponentFigure>();
				//				else if (model instanceof HDomainComponent)
				//					part = new DomainComponentEditPart<HDomainComponent,DomainComponentFigure>();
				//				else if (kindConfiguration != null)
				part = kindConfiguration.newComponentEditPart();
				//				else
				//					part = new ComponentEditPart<HComponent,ComponentFigure>();
			}
		} else if (model instanceof IHUnit) {
			if (context instanceof ConfigurationEditPart) {
				//				if (model instanceof IHApplicationUnit)
				//					part = new ApplicationUnitEditPart<HApplicationUnit,ApplicationUnitFigure>();
				//				else if (model instanceof IHComputationUnit)
				//					part = new ComputationUnitEditPart<HComputationUnit,ComputationUnitFigure>();
				//				else if (model instanceof IHServiceUnit)
				//					part = new ServiceUnitEditPart<HServiceUnit,ServiceUnitFigure>();
				//				else if (model instanceof IHDataUnit)
				//					part = new DataUnitEditPart<HDataUnit,DataUnitFigure>();
				//				else if (model instanceof IHArchitectureUnit)
				//					part = new ArchitectureUnitEditPart<HArchitectureUnit,ArchitectureUnitFigure>();
				//				else if (model instanceof IHSynchronizationUnit)
				//					part = new SynchronizationUnitEditPart<HSynchronizationUnit,SynchronizationUnitFigure>();
				//				else if (model instanceof IHEnvironmentUnit)
				//					part = new EnvironmentUnitEditPart<HEnvironmentUnit,EnvironmentUnitFigure>();
				//				else if (model instanceof IHQualifierUnit)
				//					part = new QualifierUnitEditPart<HQualifierUnit,QualifierUnitFigure>();
				//				else if (model instanceof IHEnumeratorUnit)
				//					part = new EnumeratorUnitEditPart<HEnumeratorUnit,EnumeratorUnitFigure>();
				//				else if (model instanceof IHFacetUnit)
				//					part = new FacetUnitEditPart<HFacetUnit,FacetUnitFigure>();
				//				else if (model instanceof IHDomainUnit)
				//					part = new DomainUnitEditPart<HDomainUnit,DomainUnitFigure>();
				//				else if (kindConfiguration != null)
				part = kindConfiguration.newUnitEditPart();
				//				else
				//					part = new UnitEditPart<HUnit,UnitFigure>();
			} else {
				//				if (model instanceof HApplicationUnit)
				//					part = new ApplicationEntryEditPart<HApplicationUnit,ApplicationEntryFigure>();
				//				else if (model instanceof HComputationUnit)
				//					part = new ComputationEntryEditPart<HComputationUnit,ComputationEntryFigure>();
				//				else if (model instanceof HServiceUnit)
				//					part = new ServiceEntryEditPart<HServiceUnit,ServiceEntryFigure>();
				//				else if (model instanceof HDataUnit)
				//					part = new DataEntryEditPart<HDataUnit,DataEntryFigure>();
				//				else if (model instanceof HArchitectureUnit)
				//					part = new ArchitectureEntryEditPart<HArchitectureUnit,ArchitectureEntryFigure>();
				//				else if (model instanceof HSynchronizationUnit)
				//					part = new SynchronizationEntryEditPart<HSynchronizationUnit,SynchronizationEntryFigure>();
				//				else if (model instanceof HEnvironmentUnit)
				//					part = new EnvironmentEntryEditPart<HEnvironmentUnit,EnvironmentEntryFigure>();
				//				else if (model instanceof HQualifierUnit)
				//					part = new QualifierEntryEditPart<HQualifierUnit,QualifierEntryFigure>();
				//				else if (model instanceof HEnumeratorUnit)
				//					part = new EnumeratorEntryEditPart<HEnumeratorUnit,EnumeratorEntryFigure>();
				//				else if (model instanceof HFacetUnit)
				//					part = new FacetEntryEditPart<HFacetUnit,FacetEntryFigure>();
				//				else if (model instanceof HDomainUnit)
				//					part = new DomainEntryEditPart<HDomainUnit,DomainEntryFigure>();
				//				else if (kindConfiguration != null)
				part = kindConfiguration.newEntryEditPart();
				//				else
				//					part = new EntryEditPart<HUnit,EntryFigure>();
			}

		} else if (model instanceof HUnitSlice) {
			//			if (model instanceof HApplicationUnitSlice)
			//				part = new ApplicationUnitSliceEditPart<HApplicationUnitSlice,ApplicationUnitSliceFigure>();
			//			else if (model instanceof HServiceUnitSlice)
			//				part = new ServiceUnitSliceEditPart<HServiceUnitSlice,ServiceUnitSliceFigure>();
			//			else if (model instanceof HComputationUnitSlice)
			//				part = new ComputationUnitSliceEditPart<HComputationUnitSlice,ComputationUnitSliceFigure>();
			//			else if (model instanceof HDataUnitSlice)
			//				part = new DataUnitSliceEditPart<HDataUnitSlice,DataUnitSliceFigure>();
			//			else if (model instanceof HArchitectureUnitSlice)
			//				part = new ArchitectureUnitSliceEditPart<HArchitectureUnitSlice,ArchitectureUnitSliceFigure>();
			//			else if (model instanceof HSynchronizationUnitSlice)
			//				part = new SynchronizationUnitSliceEditPart<HSynchronizationUnitSlice,SynchronizationUnitSliceFigure>();
			//			else if (model instanceof HEnvironmentUnitSlice)
			//				part = new EnvironmentUnitSliceEditPart<HEnvironmentUnitSlice,EnvironmentUnitSliceFigure>();
			//			else if (model instanceof HQualifierUnitSlice)
			//				part = new QualifierUnitSliceEditPart<HQualifierUnitSlice,QualifierUnitSliceFigure>();
			//			else if (model instanceof HEnumeratorUnitSlice)
			//				part = new EnumeratorUnitSliceEditPart<HEnumeratorUnitSlice,EnumeratorUnitSliceFigure>();
			//			else if (model instanceof HFacetUnitSlice)
			//			    part = new FacetUnitSliceEditPart<HFacetUnitSlice,FacetUnitSliceFigure>();
			//			else if (model instanceof HDomainUnitSlice)
			//			    part = new DomainUnitSliceEditPart<HDomainUnitSlice,DomainUnitSliceFigure>();
			//			else if (kindConfiguration != null)
			part = kindConfiguration.newUnitSliceEditPart();
			//			else
			//				part = new UnitSliceEditPart<HUnitSlice,UnitSliceFigure>();
		} else if (model instanceof HInterfaceSlice) {
			//			if (model instanceof HApplicationInterfaceSlice)
			//				part = new ApplicationInterfaceSliceEditPart<HApplicationInterfaceSlice,ApplicationInterfaceSliceFigure>();
			//			else if (model instanceof HServiceInterfaceSlice)
			//				part = new ServiceInterfaceSliceEditPart<HServiceInterfaceSlice,ServiceInterfaceSliceFigure>();
			//			else if (model instanceof HComputationInterfaceSlice)
			//				part = new ComputationInterfaceSliceEditPart<HComputationInterfaceSlice,ComputationInterfaceSliceFigure>();
			//			else if (model instanceof HDataInterfaceSlice)
			//				part = new DataInterfaceSliceEditPart<HDataInterfaceSlice,DataInterfaceSliceFigure>();
			//			else if (model instanceof HArchitectureInterfaceSlice)
			//				part = new ArchitectureInterfaceSliceEditPart<HArchitectureInterfaceSlice,ArchitectureInterfaceSliceFigure>();
			//			else if (model instanceof HSynchronizationInterfaceSlice)
			//				part = new SynchronizationInterfaceSliceEditPart<HSynchronizationInterfaceSlice,SynchronizationInterfaceSliceFigure>();
			//			else if (model instanceof HEnvironmentInterfaceSlice)
			//				part = new EnvironmentInterfaceSliceEditPart<HEnvironmentInterfaceSlice,EnvironmentInterfaceSliceFigure>();
			//			else if (model instanceof HQualifierInterfaceSlice)
			//				part = new QualifierInterfaceSliceEditPart<HQualifierInterfaceSlice,QualifierInterfaceSliceFigure>();
			//			else if (model instanceof HEnumeratorInterfaceSlice)
			//				part = new EnumeratorInterfaceSliceEditPart<HEnumeratorInterfaceSlice,EnumeratorInterfaceSliceFigure>();
			//			else if (model instanceof HFacetInterfaceSlice)
			//			    part = new FacetInterfaceSliceEditPart<HFacetInterfaceSlice,FacetInterfaceSliceFigure>();
			//			else if (model instanceof HDomainInterfaceSlice)
			//			    part = new DomainInterfaceSliceEditPart<HDomainInterfaceSlice,DomainInterfaceSliceFigure>();
			//			else if (kindConfiguration != null)
			part = kindConfiguration.newInterfaceSliceEditPart();
			//			else
			//				part = new InterfaceSliceEditPart<HInterfaceSlice,InterfaceSliceFigure>();
		} else if (model instanceof HBinding) {
			part = new BindingEditPart();
		} else if (model instanceof HInterface) {
			//			if (model instanceof HApplicationInterface)
			//				part = new ApplicationInterfaceEditPart<HApplicationInterface,ApplicationInterfaceFigure>();
			//			else if (model instanceof HServiceInterface)
			//				part = new ServiceInterfaceEditPart<HServiceInterface,ServiceInterfaceFigure>();
			//			else if (model instanceof HComputationInterface)
			//				part = new ComputationInterfaceEditPart<HComputationInterface,ComputationInterfaceFigure>();
			//			else if (model instanceof HDataInterface)
			//				part = new DataInterfaceEditPart<HDataInterface,DataInterfaceFigure>();
			//			else if (model instanceof HArchitectureInterface)
			//				part = new ArchitectureInterfaceEditPart<HArchitectureInterface,ArchitectureInterfaceFigure>();
			//			else if (model instanceof HSynchronizationInterface)
			//				part = new SynchronizationInterfaceEditPart<HSynchronizationInterface,SynchronizationInterfaceFigure>();
			//			else if (model instanceof HEnvironmentInterface)
			//				part = new EnvironmentInterfaceEditPart<HEnvironmentInterface,EnvironmentInterfaceFigure>();
			//			else if (model instanceof HQualifierInterface)
			//				part = new QualifierInterfaceEditPart<HQualifierInterface,QualifierInterfaceFigure>();
			//			else if (model instanceof HEnumeratorInterface)
			//				part = new EnumeratorInterfaceEditPart<HEnumeratorInterface,EnumeratorInterfaceFigure>();
			//			else if (model instanceof HFacetInterface)
			//				part = new FacetInterfaceEditPart<HFacetInterface,FacetInterfaceFigure>();
			//			else if (model instanceof HDomainInterface)
			//				part = new DomainInterfaceEditPart<HDomainInterface,DomainInterfaceFigure>();
			//			else if (kindConfiguration != null)
			part = kindConfiguration.newInterfaceEditPart();
			//			else
			//				part = new InterfaceEditPart<HInterface,InterfaceFigure>();
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
