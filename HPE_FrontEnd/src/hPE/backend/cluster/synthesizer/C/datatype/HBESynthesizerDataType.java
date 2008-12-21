package hPE.backend.cluster.synthesizer.C.datatype;

import hPE.backend.cluster.synthesizer.HBEAbstractFile;
import hPE.backend.cluster.synthesizer.HBEAbstractSynthesizer;
import hPE.backend.cluster.synthesizer.HBESourceVersion;
import hPE.backend.cluster.synthesizer.C.HBECSource;
import hPE.backend.cluster.synthesizer.C.HBESourceVersionRawDataTypeForC;
import hPE.model.base.HInterface;
import hPE.model.kinds.data.HDataInterface;

public abstract class HBESynthesizerDataType<SourceType extends HBEAbstractFile,
                                    VersionType extends HBESourceVersion<SourceType>,
                                    ModelType extends HDataInterface> 
       extends HBEAbstractSynthesizer<SourceType, VersionType, ModelType> {

	public HBESynthesizerDataType() {
		super();
		// TODO Auto-generated constructor stub
	}

}
