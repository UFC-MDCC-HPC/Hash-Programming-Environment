package hPE.frontend.base.codegen;

import hPE.frontend.base.model.HHasExternalReferences;


public abstract class HBEAbstractSynthesizer<FileType    extends HBEAbstractSourceCodeFile, 
                                             VersionType extends HBESourceVersion, 
                                             ModelType   extends HHasExternalReferences> {

	public HBEAbstractSynthesizer() {
		super();		
	}
	
	public abstract VersionType synthesize(ModelType i, String versionID);	

	
}
