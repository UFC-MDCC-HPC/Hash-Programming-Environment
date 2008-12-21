package hPE.frontend.codegen;

import hPE.model.base.HInterface;


public abstract class HBEAbstractSynthesizer<FileType    extends HBEAbstractFile, 
                                             VersionType extends HBESourceVersion<FileType>, 
                                             ModelType   extends HInterface> {

	public HBEAbstractSynthesizer() {
		super();		
	}
	
	public abstract VersionType synthesize(ModelType i, String versionID);	

	
}
