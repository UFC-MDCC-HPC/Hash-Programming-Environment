package hPE.frontend.codegen.C.datatype.raw;

import hPE.frontend.codegen.HBEAbstractFile;
import hPE.frontend.codegen.HBESourceVersion;
import hPE.frontend.codegen.C.datatype.HBESynthesizerDataType;
import hPE.frontend.kinds.data.model.HDataInterface;

public abstract class HBESynthesizerDataTypeRaw<SourceType extends HBEAbstractFile,
                                       VersionType extends HBESourceVersion<SourceType>,
                                       ModelType extends HDataInterface> 
      extends HBESynthesizerDataType<SourceType, VersionType, ModelType> {

	public HBESynthesizerDataTypeRaw() {
		super();
		// TODO Auto-generated constructor stub
	}

}
