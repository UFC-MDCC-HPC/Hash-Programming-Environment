package hPE.frontend.codegen.C.datatype;

import hPE.frontend.codegen.HBEAbstractFile;
import hPE.frontend.codegen.HBEAbstractSynthesizer;
import hPE.frontend.codegen.HBESourceVersion;
import hPE.frontend.codegen.C.HBECSource;
import hPE.frontend.codegen.C.HBESourceVersionRawDataTypeForC;
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
