package hPE.frontend.base.codegen.C;

import hPE.frontend.base.codegen.C.datatype.raw.HBESynthesizerDataTypeRaw;
import hPE.frontend.kinds.data.model.HDataInterface;

public class HBESynthesizerDataTypeRawForC
              extends HBESynthesizerDataTypeRaw<HBECSource,HBESourceVersionRawDataTypeForC,HDataInterface> {

	public HBESynthesizerDataTypeRawForC() {
		super();
		
	}

	public HBESourceVersionRawDataTypeForC synthesize(HDataInterface i, String versionID) {

  
        String procName = i.getPrimName();
        String headerText = "typedef <? basic type ?> ".concat(i.getPrimName()).concat(";");
        
        
	    String loc = i.getConfiguration().getLocation();
        
        
		HBECSourceHeader sourceHeader = new HBECSourceHeader(procName.concat(".h"), headerText,loc,versionID);	
		HBECSourceCode   sourceCode   = new HBECSourceCode  (procName.concat(".c"), "",loc,versionID);
		
		HBESourceVersionRawDataTypeForC version = new HBESourceVersionRawDataTypeForC(sourceCode,sourceHeader);
		version.setVersionID(versionID);
		i.addSourceVersion(version);
	    
		return version;
		
        
	}
	
	public String toString() {
		return "C Language - Data Type";
	}
	
}
