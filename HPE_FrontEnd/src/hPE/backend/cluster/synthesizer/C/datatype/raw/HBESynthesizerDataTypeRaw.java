package hPE.backend.cluster.synthesizer.C.datatype.raw;

import hPE.backend.cluster.synthesizer.HBEAbstractFile;
import hPE.backend.cluster.synthesizer.HBESourceVersion;
import hPE.backend.cluster.synthesizer.C.datatype.HBESynthesizerDataType;
import hPE.model.kinds.data.HDataInterface;

public abstract class HBESynthesizerDataTypeRaw<SourceType extends HBEAbstractFile,
                                       VersionType extends HBESourceVersion<SourceType>,
                                       ModelType extends HDataInterface> 
      extends HBESynthesizerDataType<SourceType, VersionType, ModelType> {

	public HBESynthesizerDataTypeRaw() {
		super();
		// TODO Auto-generated constructor stub
	}

}
