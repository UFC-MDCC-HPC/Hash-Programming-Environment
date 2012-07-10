package hPE.frontend;

import hPE.frontend.base.edits.ActionConnectionEditPart;
import hPE.frontend.base.edits.ActionEditPart;
import hPE.frontend.base.edits.AltActionEditPart;
import hPE.frontend.base.edits.BindingEditPart;
import hPE.frontend.base.edits.ComponentEditPart;
import hPE.frontend.base.edits.ConfigurationEditPart;
import hPE.frontend.base.edits.DoActionEditPart;
import hPE.frontend.base.edits.EntryActionCombinatorEditPart;
import hPE.frontend.base.edits.EntryEditPart;
import hPE.frontend.base.edits.ExitActionCombinatorEditPart;
import hPE.frontend.base.edits.InterfaceEditPart;
import hPE.frontend.base.edits.InterfaceSliceEditPart;
import hPE.frontend.base.edits.LinkToInterfaceEditPart;
import hPE.frontend.base.edits.ParActionEditPart;
import hPE.frontend.base.edits.PortBindingConnectionEditPart;
import hPE.frontend.base.edits.ProtocolEditPart;
import hPE.frontend.base.edits.ProvidesPortEditPart;
import hPE.frontend.base.edits.SeqActionEditPart;
import hPE.frontend.base.edits.UnitEditPart;
import hPE.frontend.base.edits.UnitSliceEditPart;
import hPE.frontend.base.figures.ComponentFigure;
import hPE.frontend.base.figures.ConfigurationFigure;
import hPE.frontend.base.figures.EntryFigure;
import hPE.frontend.base.figures.InterfaceFigure;
import hPE.frontend.base.figures.InterfaceSliceFigure;
import hPE.frontend.base.figures.UnitFigure;
import hPE.frontend.base.figures.UnitSliceFigure;
import hPE.frontend.base.model.HBinding;
import hPE.frontend.base.model.HComponent;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.base.model.HInterfaceSlice;
import hPE.frontend.base.model.HLinkToInterface;
import hPE.frontend.base.model.HPort;
import hPE.frontend.base.model.HUnit;
import hPE.frontend.base.model.HUnitSlice;
import hPE.frontend.base.model.IHUnit;
import hPE.frontend.kinds.activate.model.protocol.HAction;
import hPE.frontend.kinds.activate.model.protocol.HActionEntry;
import hPE.frontend.kinds.activate.model.protocol.HActionExit;
import hPE.frontend.kinds.activate.model.protocol.HAltAction;
import hPE.frontend.kinds.activate.model.protocol.HDoAction;
import hPE.frontend.kinds.activate.model.protocol.HParAction;
import hPE.frontend.kinds.activate.model.protocol.HProtocol;
import hPE.frontend.kinds.activate.model.protocol.HSeqAction;
import hPE.frontend.kinds.application.edits.ApplicationComponentEditPart;
import hPE.frontend.kinds.application.edits.ApplicationConfigurationEditPart;
import hPE.frontend.kinds.application.edits.ApplicationEntryEditPart;
import hPE.frontend.kinds.application.edits.ApplicationInterfaceEditPart;
import hPE.frontend.kinds.application.edits.ApplicationInterfaceSliceEditPart;
import hPE.frontend.kinds.application.edits.ApplicationUnitEditPart;
import hPE.frontend.kinds.application.edits.ApplicationUnitSliceEditPart;
import hPE.frontend.kinds.application.figures.ApplicationComponentFigure;
import hPE.frontend.kinds.application.figures.ApplicationConfigurationFigure;
import hPE.frontend.kinds.application.figures.ApplicationEntryFigure;
import hPE.frontend.kinds.application.figures.ApplicationInterfaceFigure;
import hPE.frontend.kinds.application.figures.ApplicationInterfaceSliceFigure;
import hPE.frontend.kinds.application.figures.ApplicationUnitFigure;
import hPE.frontend.kinds.application.figures.ApplicationUnitSliceFigure;
import hPE.frontend.kinds.application.model.HApplicationComponent;
import hPE.frontend.kinds.application.model.HApplicationInterface;
import hPE.frontend.kinds.application.model.HApplicationInterfaceSlice;
import hPE.frontend.kinds.application.model.HApplicationUnit;
import hPE.frontend.kinds.application.model.HApplicationUnitSlice;
import hPE.frontend.kinds.application.model.IHApplicationUnit;
import hPE.frontend.kinds.computation.edits.ComputationComponentEditPart;
import hPE.frontend.kinds.computation.edits.ComputationConfigurationEditPart;
import hPE.frontend.kinds.computation.edits.ComputationEntryEditPart;
import hPE.frontend.kinds.computation.edits.ComputationInterfaceEditPart;
import hPE.frontend.kinds.computation.edits.ComputationInterfaceSliceEditPart;
import hPE.frontend.kinds.computation.edits.ComputationUnitEditPart;
import hPE.frontend.kinds.computation.edits.ComputationUnitSliceEditPart;
import hPE.frontend.kinds.computation.figures.ComputationComponentFigure;
import hPE.frontend.kinds.computation.figures.ComputationConfigurationFigure;
import hPE.frontend.kinds.computation.figures.ComputationEntryFigure;
import hPE.frontend.kinds.computation.figures.ComputationInterfaceFigure;
import hPE.frontend.kinds.computation.figures.ComputationInterfaceSliceFigure;
import hPE.frontend.kinds.computation.figures.ComputationUnitFigure;
import hPE.frontend.kinds.computation.figures.ComputationUnitSliceFigure;
import hPE.frontend.kinds.computation.model.HComputationComponent;
import hPE.frontend.kinds.computation.model.HComputationInterface;
import hPE.frontend.kinds.computation.model.HComputationInterfaceSlice;
import hPE.frontend.kinds.computation.model.HComputationUnit;
import hPE.frontend.kinds.computation.model.HComputationUnitSlice;
import hPE.frontend.kinds.computation.model.IHComputationUnit;
import hPE.frontend.kinds.data.edits.DataComponentEditPart;
import hPE.frontend.kinds.data.edits.DataConfigurationEditPart;
import hPE.frontend.kinds.data.edits.DataEntryEditPart;
import hPE.frontend.kinds.data.edits.DataInterfaceEditPart;
import hPE.frontend.kinds.data.edits.DataInterfaceSliceEditPart;
import hPE.frontend.kinds.data.edits.DataUnitEditPart;
import hPE.frontend.kinds.data.edits.DataUnitSliceEditPart;
import hPE.frontend.kinds.data.figures.DataComponentFigure;
import hPE.frontend.kinds.data.figures.DataConfigurationFigure;
import hPE.frontend.kinds.data.figures.DataEntryFigure;
import hPE.frontend.kinds.data.figures.DataInterfaceFigure;
import hPE.frontend.kinds.data.figures.DataInterfaceSliceFigure;
import hPE.frontend.kinds.data.figures.DataUnitFigure;
import hPE.frontend.kinds.data.figures.DataUnitSliceFigure;
import hPE.frontend.kinds.data.model.HDataComponent;
import hPE.frontend.kinds.data.model.HDataInterface;
import hPE.frontend.kinds.data.model.HDataInterfaceSlice;
import hPE.frontend.kinds.data.model.HDataUnit;
import hPE.frontend.kinds.data.model.HDataUnitSlice;
import hPE.frontend.kinds.data.model.IHDataUnit;
import hPE.frontend.kinds.domain.edits.DomainComponentEditPart;
import hPE.frontend.kinds.domain.edits.DomainConfigurationEditPart;
import hPE.frontend.kinds.domain.edits.DomainEntryEditPart;
import hPE.frontend.kinds.domain.edits.DomainInterfaceEditPart;
import hPE.frontend.kinds.domain.edits.DomainInterfaceSliceEditPart;
import hPE.frontend.kinds.domain.edits.DomainUnitEditPart;
import hPE.frontend.kinds.domain.edits.DomainUnitSliceEditPart;
import hPE.frontend.kinds.domain.figures.DomainComponentFigure;
import hPE.frontend.kinds.domain.figures.DomainConfigurationFigure;
import hPE.frontend.kinds.domain.figures.DomainEntryFigure;
import hPE.frontend.kinds.domain.figures.DomainInterfaceFigure;
import hPE.frontend.kinds.domain.figures.DomainInterfaceSliceFigure;
import hPE.frontend.kinds.domain.figures.DomainUnitFigure;
import hPE.frontend.kinds.domain.figures.DomainUnitSliceFigure;
import hPE.frontend.kinds.domain.model.HDomainComponent;
import hPE.frontend.kinds.domain.model.HDomainInterface;
import hPE.frontend.kinds.domain.model.HDomainInterfaceSlice;
import hPE.frontend.kinds.domain.model.HDomainUnit;
import hPE.frontend.kinds.domain.model.HDomainUnitSlice;
import hPE.frontend.kinds.domain.model.IHDomainUnit;
import hPE.frontend.kinds.environment.edits.EnvironmentComponentEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentConfigurationEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentEntryEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentInterfaceEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentInterfaceSliceEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentUnitEditPart;
import hPE.frontend.kinds.environment.edits.EnvironmentUnitSliceEditPart;
import hPE.frontend.kinds.environment.figures.EnvironmentComponentFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentConfigurationFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentEntryFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentInterfaceFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentInterfaceSliceFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentUnitFigure;
import hPE.frontend.kinds.environment.figures.EnvironmentUnitSliceFigure;
import hPE.frontend.kinds.environment.model.HEnvironmentComponent;
import hPE.frontend.kinds.environment.model.HEnvironmentInterface;
import hPE.frontend.kinds.environment.model.HEnvironmentInterfaceSlice;
import hPE.frontend.kinds.environment.model.HEnvironmentUnit;
import hPE.frontend.kinds.environment.model.HEnvironmentUnitSlice;
import hPE.frontend.kinds.environment.model.IHEnvironmentUnit;
import hPE.frontend.kinds.facet.edits.FacetComponentEditPart;
import hPE.frontend.kinds.facet.edits.FacetConfigurationEditPart;
import hPE.frontend.kinds.facet.edits.FacetEntryEditPart;
import hPE.frontend.kinds.facet.edits.FacetInterfaceEditPart;
import hPE.frontend.kinds.facet.edits.FacetInterfaceSliceEditPart;
import hPE.frontend.kinds.facet.edits.FacetUnitEditPart;
import hPE.frontend.kinds.facet.edits.FacetUnitSliceEditPart;
import hPE.frontend.kinds.facet.figures.FacetComponentFigure;
import hPE.frontend.kinds.facet.figures.FacetConfigurationFigure;
import hPE.frontend.kinds.facet.figures.FacetEntryFigure;
import hPE.frontend.kinds.facet.figures.FacetInterfaceFigure;
import hPE.frontend.kinds.facet.figures.FacetInterfaceSliceFigure;
import hPE.frontend.kinds.facet.figures.FacetUnitFigure;
import hPE.frontend.kinds.facet.figures.FacetUnitSliceFigure;
import hPE.frontend.kinds.facet.model.HFacetComponent;
import hPE.frontend.kinds.facet.model.HFacetInterface;
import hPE.frontend.kinds.facet.model.HFacetInterfaceSlice;
import hPE.frontend.kinds.facet.model.HFacetUnit;
import hPE.frontend.kinds.facet.model.HFacetUnitSlice;
import hPE.frontend.kinds.facet.model.IHFacetUnit;
import hPE.frontend.kinds.platform.edits.PlatformComponentEditPart;
import hPE.frontend.kinds.platform.edits.PlatformConfigurationEditPart;
import hPE.frontend.kinds.platform.edits.PlatformEntryEditPart;
import hPE.frontend.kinds.platform.edits.PlatformInterfaceEditPart;
import hPE.frontend.kinds.platform.edits.PlatformInterfaceSliceEditPart;
import hPE.frontend.kinds.platform.edits.PlatformUnitEditPart;
import hPE.frontend.kinds.platform.edits.PlatformUnitSliceEditPart;
import hPE.frontend.kinds.platform.figures.PlatformComponentFigure;
import hPE.frontend.kinds.platform.figures.PlatformConfigurationFigure;
import hPE.frontend.kinds.platform.figures.PlatformEntryFigure;
import hPE.frontend.kinds.platform.figures.PlatformInterfaceFigure;
import hPE.frontend.kinds.platform.figures.PlatformInterfaceSliceFigure;
import hPE.frontend.kinds.platform.figures.PlatformUnitFigure;
import hPE.frontend.kinds.platform.figures.PlatformUnitSliceFigure;
import hPE.frontend.kinds.platform.model.HPlatformComponent;
import hPE.frontend.kinds.platform.model.HPlatformInterface;
import hPE.frontend.kinds.platform.model.HPlatformInterfaceSlice;
import hPE.frontend.kinds.platform.model.HPlatformUnit;
import hPE.frontend.kinds.platform.model.HPlatformUnitSlice;
import hPE.frontend.kinds.platform.model.IHPlatformUnit;
import hPE.frontend.kinds.qualifier.edits.QualifierComponentEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierConfigurationEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierEntryEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierInterfaceEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierInterfaceSliceEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierUnitEditPart;
import hPE.frontend.kinds.qualifier.edits.QualifierUnitSliceEditPart;
import hPE.frontend.kinds.qualifier.figures.QualifierComponentFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierConfigurationFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierEntryFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierInterfaceFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierInterfaceSliceFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierUnitFigure;
import hPE.frontend.kinds.qualifier.figures.QualifierUnitSliceFigure;
import hPE.frontend.kinds.qualifier.model.HQualifierComponent;
import hPE.frontend.kinds.qualifier.model.HQualifierInterface;
import hPE.frontend.kinds.qualifier.model.HQualifierInterfaceSlice;
import hPE.frontend.kinds.qualifier.model.HQualifierUnit;
import hPE.frontend.kinds.qualifier.model.HQualifierUnitSlice;
import hPE.frontend.kinds.qualifier.model.IHQualifierUnit;
import hPE.frontend.kinds.synchronization.edits.SynchronizationComponentEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationConfigurationEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationEntryEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationInterfaceEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationInterfaceSliceEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationUnitEditPart;
import hPE.frontend.kinds.synchronization.edits.SynchronizationUnitSliceEditPart;
import hPE.frontend.kinds.synchronization.figures.SynchronizationComponentFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationConfigurationFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationEntryFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationInterfaceFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationInterfaceSliceFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationUnitFigure;
import hPE.frontend.kinds.synchronization.figures.SynchronizationUnitSliceFigure;
import hPE.frontend.kinds.synchronization.model.HSynchronizationComponent;
import hPE.frontend.kinds.synchronization.model.HSynchronizationInterface;
import hPE.frontend.kinds.synchronization.model.HSynchronizationInterfaceSlice;
import hPE.frontend.kinds.synchronization.model.HSynchronizationUnit;
import hPE.frontend.kinds.synchronization.model.HSynchronizationUnitSlice;
import hPE.frontend.kinds.synchronization.model.IHSynchronizationUnit;
import hPE.frontend.kinds.topology.edits.TopologyComponentEditPart;
import hPE.frontend.kinds.topology.edits.TopologyConfigurationEditPart;
import hPE.frontend.kinds.topology.edits.TopologyEntryEditPart;
import hPE.frontend.kinds.topology.edits.TopologyInterfaceEditPart;
import hPE.frontend.kinds.topology.edits.TopologyInterfaceSliceEditPart;
import hPE.frontend.kinds.topology.edits.TopologyUnitEditPart;
import hPE.frontend.kinds.topology.edits.TopologyUnitSliceEditPart;
import hPE.frontend.kinds.topology.figures.TopologyComponentFigure;
import hPE.frontend.kinds.topology.figures.TopologyConfigurationFigure;
import hPE.frontend.kinds.topology.figures.TopologyEntryFigure;
import hPE.frontend.kinds.topology.figures.TopologyInterfaceFigure;
import hPE.frontend.kinds.topology.figures.TopologyInterfaceSliceFigure;
import hPE.frontend.kinds.topology.figures.TopologyUnitFigure;
import hPE.frontend.kinds.topology.figures.TopologyUnitSliceFigure;
import hPE.frontend.kinds.topology.model.HTopologyComponent;
import hPE.frontend.kinds.topology.model.HTopologyInterface;
import hPE.frontend.kinds.topology.model.HTopologyInterfaceSlice;
import hPE.frontend.kinds.topology.model.HTopologyUnit;
import hPE.frontend.kinds.topology.model.HTopologyUnitSlice;
import hPE.frontend.kinds.topology.model.IHTopologyUnit;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

public class ConfigurationEditPartFactory implements EditPartFactory {

	public ConfigurationEditPartFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditPart createEditPart(EditPart context, Object model) {
		
		EditPart part = null;
		
		if (model instanceof HComponent) {
			if (context == null) {
				if (model instanceof HApplicationComponent)
					part = new ApplicationConfigurationEditPart<HApplicationComponent,ApplicationConfigurationFigure>();
				else if (model instanceof HTopologyComponent)
			        part = new TopologyConfigurationEditPart<HTopologyComponent,TopologyConfigurationFigure>();
				else if (model instanceof HComputationComponent)
			        part = new ComputationConfigurationEditPart<HComputationComponent,ComputationConfigurationFigure>();
				else if (model instanceof HPlatformComponent)
					part = new PlatformConfigurationEditPart<HPlatformComponent,PlatformConfigurationFigure>();
				else if (model instanceof HDataComponent)
					part = new DataConfigurationEditPart<HDataComponent,DataConfigurationFigure>();
				else if (model instanceof HSynchronizationComponent)
					part = new SynchronizationConfigurationEditPart<HSynchronizationComponent,SynchronizationConfigurationFigure>();
				else if (model instanceof HQualifierComponent)
					part = new QualifierConfigurationEditPart<HQualifierComponent,QualifierConfigurationFigure>();
				else if (model instanceof HEnvironmentComponent)
					part = new EnvironmentConfigurationEditPart<HEnvironmentComponent,EnvironmentConfigurationFigure>();
				else if (model instanceof HFacetComponent)
					part = new FacetConfigurationEditPart<HFacetComponent,FacetConfigurationFigure>();
				else if (model instanceof HDomainComponent)
					part = new DomainConfigurationEditPart<HDomainComponent,DomainConfigurationFigure>();
				else 
					part = new ConfigurationEditPart<HComponent,ConfigurationFigure>();
			} else if (context instanceof ComponentEditPart) {
				// TODO: Exposed INNER COMPONENTS !!!!
				
				
			} else {
				if (model instanceof HApplicationComponent)
					part = new ApplicationComponentEditPart<HApplicationComponent,ApplicationComponentFigure>();
				else if (model instanceof HTopologyComponent)
			        part = new TopologyComponentEditPart<HTopologyComponent,TopologyComponentFigure>();
				else if (model instanceof HComputationComponent)
			        part = new ComputationComponentEditPart<HComputationComponent,ComputationComponentFigure>();
				else if (model instanceof HDataComponent)
					part = new DataComponentEditPart<HDataComponent,DataComponentFigure>();
				else if (model instanceof HPlatformComponent)
					part = new PlatformComponentEditPart<HPlatformComponent,PlatformComponentFigure>();
				else if (model instanceof HSynchronizationComponent)
					part = new SynchronizationComponentEditPart<HSynchronizationComponent,SynchronizationComponentFigure>();
				else if (model instanceof HQualifierComponent)
					part = new QualifierComponentEditPart<HQualifierComponent,QualifierComponentFigure>();
				else if (model instanceof HEnvironmentComponent)
					part = new EnvironmentComponentEditPart<HEnvironmentComponent,EnvironmentComponentFigure>();
				else if (model instanceof HFacetComponent)
					part = new FacetComponentEditPart<HFacetComponent,FacetComponentFigure>();
				else if (model instanceof HDomainComponent)
					part = new DomainComponentEditPart<HDomainComponent,DomainComponentFigure>();
				else 
					part = new ComponentEditPart<HComponent,ComponentFigure>();
			}
		} else if (model instanceof IHUnit) {
			if (context instanceof ConfigurationEditPart) {
				if (model instanceof IHApplicationUnit) 
					part = new ApplicationUnitEditPart<HApplicationUnit,ApplicationUnitFigure>();
				else if (model instanceof IHComputationUnit)
					part = new ComputationUnitEditPart<HComputationUnit,ComputationUnitFigure>();				
				else if (model instanceof IHTopologyUnit)
					part = new TopologyUnitEditPart<HTopologyUnit,TopologyUnitFigure>();				
				else if (model instanceof IHDataUnit) 
					part = new DataUnitEditPart<HDataUnit,DataUnitFigure>();
				else if (model instanceof IHPlatformUnit) 
					part = new PlatformUnitEditPart<HPlatformUnit,PlatformUnitFigure>();
				else if (model instanceof IHSynchronizationUnit) 
					part = new SynchronizationUnitEditPart<HSynchronizationUnit,SynchronizationUnitFigure>();
				else if (model instanceof IHEnvironmentUnit) 
					part = new EnvironmentUnitEditPart<HEnvironmentUnit,EnvironmentUnitFigure>();
				else if (model instanceof IHQualifierUnit) 
					part = new QualifierUnitEditPart<HQualifierUnit,QualifierUnitFigure>();
				else if (model instanceof IHFacetUnit) 
					part = new FacetUnitEditPart<HFacetUnit,FacetUnitFigure>();
				else if (model instanceof IHDomainUnit) 
					part = new DomainUnitEditPart<HDomainUnit,DomainUnitFigure>();
				else 
					part = new UnitEditPart<HUnit,UnitFigure>();
		    } else {
		    	if (model instanceof HApplicationUnit) 
					part = new ApplicationEntryEditPart<HApplicationUnit,ApplicationEntryFigure>();
				else if (model instanceof HComputationUnit)
			        part = new ComputationEntryEditPart<HComputationUnit,ComputationEntryFigure>();
				else if (model instanceof HTopologyUnit)
			        part = new TopologyEntryEditPart<HTopologyUnit,TopologyEntryFigure>();
				else if (model instanceof HDataUnit) 
					part = new DataEntryEditPart<HDataUnit,DataEntryFigure>();
				else if (model instanceof HPlatformUnit) 
					part = new PlatformEntryEditPart<HPlatformUnit,PlatformEntryFigure>();
				else if (model instanceof HSynchronizationUnit) 
					part = new SynchronizationEntryEditPart<HSynchronizationUnit,SynchronizationEntryFigure>();
				else if (model instanceof HEnvironmentUnit) 
					part = new EnvironmentEntryEditPart<HEnvironmentUnit,EnvironmentEntryFigure>();
				else if (model instanceof HQualifierUnit) 
					part = new QualifierEntryEditPart<HQualifierUnit,QualifierEntryFigure>();
				else if (model instanceof HFacetUnit) 
					part = new FacetEntryEditPart<HFacetUnit,FacetEntryFigure>();
				else if (model instanceof HDomainUnit) 
					part = new DomainEntryEditPart<HDomainUnit,DomainEntryFigure>();
				else 
					part = new EntryEditPart<HUnit,EntryFigure>();
		    }
			
		} else if (model instanceof HUnitSlice) {
			if (model instanceof HApplicationUnitSlice) 
			    part = new ApplicationUnitSliceEditPart<HApplicationUnitSlice,ApplicationUnitSliceFigure>();
			else if (model instanceof HTopologyUnitSlice)
			    part = new TopologyUnitSliceEditPart<HTopologyUnitSlice,TopologyUnitSliceFigure>();
			else if (model instanceof HComputationUnitSlice)
			    part = new ComputationUnitSliceEditPart<HComputationUnitSlice,ComputationUnitSliceFigure>();
			else if (model instanceof HDataUnitSlice) 
			    part = new DataUnitSliceEditPart<HDataUnitSlice,DataUnitSliceFigure>();
			else if (model instanceof HPlatformUnitSlice) 
			    part = new PlatformUnitSliceEditPart<HPlatformUnitSlice,PlatformUnitSliceFigure>();
			else if (model instanceof HSynchronizationUnitSlice) 
			    part = new SynchronizationUnitSliceEditPart<HSynchronizationUnitSlice,SynchronizationUnitSliceFigure>();
			else if (model instanceof HEnvironmentUnitSlice) 
			    part = new EnvironmentUnitSliceEditPart<HEnvironmentUnitSlice,EnvironmentUnitSliceFigure>();
			else if (model instanceof HQualifierUnitSlice) 
			    part = new QualifierUnitSliceEditPart<HQualifierUnitSlice,QualifierUnitSliceFigure>();
			else if (model instanceof HFacetUnitSlice) 
			    part = new FacetUnitSliceEditPart<HFacetUnitSlice,FacetUnitSliceFigure>();
			else if (model instanceof HDomainUnitSlice) 
			    part = new DomainUnitSliceEditPart<HDomainUnitSlice,DomainUnitSliceFigure>();
			else 
			    part = new UnitSliceEditPart<HUnitSlice,UnitSliceFigure>();
		} else if (model instanceof HInterfaceSlice) {
			if (model instanceof HApplicationInterfaceSlice) 
			    part = new ApplicationInterfaceSliceEditPart<HApplicationInterfaceSlice,ApplicationInterfaceSliceFigure>();
			else if (model instanceof HTopologyInterfaceSlice)
			    part = new TopologyInterfaceSliceEditPart<HTopologyInterfaceSlice,TopologyInterfaceSliceFigure>();
			else if (model instanceof HComputationInterfaceSlice)
			    part = new ComputationInterfaceSliceEditPart<HComputationInterfaceSlice,ComputationInterfaceSliceFigure>();
			else if (model instanceof HDataInterfaceSlice) 
			    part = new DataInterfaceSliceEditPart<HDataInterfaceSlice,DataInterfaceSliceFigure>();
			else if (model instanceof HPlatformInterfaceSlice) 
			    part = new PlatformInterfaceSliceEditPart<HPlatformInterfaceSlice,PlatformInterfaceSliceFigure>();
			else if (model instanceof HSynchronizationInterfaceSlice) 
			    part = new SynchronizationInterfaceSliceEditPart<HSynchronizationInterfaceSlice,SynchronizationInterfaceSliceFigure>();
			else if (model instanceof HEnvironmentInterfaceSlice) 
			    part = new EnvironmentInterfaceSliceEditPart<HEnvironmentInterfaceSlice,EnvironmentInterfaceSliceFigure>();
			else if (model instanceof HQualifierInterfaceSlice) 
			    part = new QualifierInterfaceSliceEditPart<HQualifierInterfaceSlice,QualifierInterfaceSliceFigure>();
			else if (model instanceof HFacetInterfaceSlice) 
			    part = new FacetInterfaceSliceEditPart<HFacetInterfaceSlice,FacetInterfaceSliceFigure>();
			else if (model instanceof HDomainInterfaceSlice) 
			    part = new DomainInterfaceSliceEditPart<HDomainInterfaceSlice,DomainInterfaceSliceFigure>();
			else 
			    part = new InterfaceSliceEditPart<HInterfaceSlice,InterfaceSliceFigure>();
		} else if (model instanceof HBinding) {
			part = new BindingEditPart();
		} else if (model instanceof HInterface) {
			if (model instanceof HApplicationInterface)
				part = new ApplicationInterfaceEditPart<HApplicationInterface,ApplicationInterfaceFigure>();
			else if (model instanceof HTopologyInterface)
			    part = new TopologyInterfaceEditPart<HTopologyInterface,TopologyInterfaceFigure>();
			else if (model instanceof HComputationInterface)
			    part = new ComputationInterfaceEditPart<HComputationInterface,ComputationInterfaceFigure>();
			else if (model instanceof HDataInterface)
				part = new DataInterfaceEditPart<HDataInterface,DataInterfaceFigure>();
			else if (model instanceof HPlatformInterface)
				part = new PlatformInterfaceEditPart<HPlatformInterface,PlatformInterfaceFigure>();
			else if (model instanceof HSynchronizationInterface)
				part = new SynchronizationInterfaceEditPart<HSynchronizationInterface,SynchronizationInterfaceFigure>();
			else if (model instanceof HEnvironmentInterface)
				part = new EnvironmentInterfaceEditPart<HEnvironmentInterface,EnvironmentInterfaceFigure>();
			else if (model instanceof HQualifierInterface)
				part = new QualifierInterfaceEditPart<HQualifierInterface,QualifierInterfaceFigure>();
			else if (model instanceof HFacetInterface)
				part = new FacetInterfaceEditPart<HFacetInterface,FacetInterfaceFigure>();
			else if (model instanceof HDomainInterface)
				part = new DomainInterfaceEditPart<HDomainInterface,DomainInterfaceFigure>();
			else 
				part = new InterfaceEditPart<HInterface,InterfaceFigure>();
		} else if (model instanceof HLinkToInterface) {
			part = new LinkToInterfaceEditPart();
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
