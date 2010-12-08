/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.user.data.Vector;
using linearsystems.library.HYPRE.domain.LSSDomainHYPRE;
using environment.messagepassing.MPICommunicator;

namespace linearsystems.user.HYPRE.data.impl.HYPRE_Vector { 

public abstract class BaseIHYPREVector<LIB, NUM, COM>: DataStructure, BaseIVector<LIB, NUM, COM, ILSSDomainHYPRE<LIB, COM>>
where LIB:IHYPRE
where NUM:IDoublePrecisionFPNumber
where COM:IMPICommunicator
{

protected LIB library = default(LIB);

protected LIB Library {
	set {
		this.library = value;
	}
}

protected NUM element_type = default(NUM);

protected NUM Element_type {
	set {
		this.element_type = value;
	}
}

protected ILSSDomainHYPRE<LIB, COM> lssdomain = null;

protected ILSSDomainHYPRE<LIB, COM> Lssdomain {
	set {
		this.lssdomain = value;
	}
}

protected COM comm = default(COM);

public COM Comm {
	set {
		this.comm = value;
		lssdomain.Comm = value;
	}
}
		
		

public BaseIHYPREVector() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000abf9e670f763dde111fa28a6e105ccc7e427a679e5fd8ed71e4369748aa6898f89965353db22c699f62af32dce8fffff0980efe17f8a111571a44d5bf286307fbe29bd5c97fae2157f3445fe527ddb3827eafd796d25db05de6c0b793f58c530cbdb114210794b3e30a4db3896b5c45b5f1438fc79bbe6b09d3e30266d721fa2";

override public void createSlices() {
	base.createSlices();
	this.Element_type = (NUM) BackEnd.createSlice(this, UID,"element_type","element_type",new Type[] {});
	this.Library = (LIB) BackEnd.createSlice(this, UID,"library","library",new Type[] {});
	this.Lssdomain = (ILSSDomainHYPRE<LIB, COM>) BackEnd.createSlice(this, UID,"domain","lssdomain", null);
} 


}

}
