package hPE.frontend.base.codegen.C.datatype;

import hPE.frontend.base.codegen.HBEAbstractFile;
import hPE.frontend.base.codegen.HBEAbstractSynthesizer;
import hPE.frontend.base.codegen.HBESourceVersion;
import hPE.frontend.base.codegen.C.HBECSource;
import hPE.frontend.base.codegen.C.HBESourceVersionRawDataTypeForC;
import hPE.frontend.base.model.HInterface;
import hPE.frontend.kinds.data.model.HDataInterface;

public abstract class HBESynthesizerDataType<SourceType extends HBEAbstractFile,
                                    VersionType extends HBESourceVersion<SourceType>,
                                    ModelType extends HDataInterface> 
       extends HBEAbstractSynthesizer<SourceType, VersionType, ModelType> {

	public HBESynthesizerDataType() {
		super();
		// TODO Auto-generated constructor stub
	}

}
