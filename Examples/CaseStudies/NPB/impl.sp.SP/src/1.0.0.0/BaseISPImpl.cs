/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.Verify;
using common.data.ProblemDefinition;
using sp.ADI;
using common.datapartition.Blocks3D;
using br.ufc.lia.pargo.hpe.casestudies.npb.SP;

namespace impl.sp.SP { 

public abstract class BaseISPImpl: Application, BaseISP
{

protected IVerify verify = null;

protected IVerify Verify {
	set {
		this.verify = value;
	}
}

protected IProblemDefinition problem = null;

protected IProblemDefinition Problem {
	set {
		this.problem = value;
		adi.Problem = value;
		verify.Problem = value;
	}
}

protected IADI adi = null;

protected IADI Adi {
	set {
		this.adi = value;
	}
}

protected IBlocks3D process = null;

protected IBlocks3D Process {
	set {
		this.process = value;
		adi.Data_partition = value;
		verify.Process = value;
	}
}


public BaseISPImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000ddeedcaba108d1ed5e25cabaf2bd29f9ccced4266b31e92a275abc158dba1dbdf7da446e2ab536fc6614be14bff8fb9183a4189b985fe4d27b5827017638da1116ce4f24f8a5746b4db9cfb95905093897bf3fdcf3414b497fd7a29025c44f2fc979f9c837232c7f1cb152b236d0f97ff543046b43f4bf10d66edbf4e6d2ffb2";

override public void createSlices() {
	base.createSlices();
	this.Adi = (IADI) BackEnd.createSlice(this, UID,"adi","adi);
	this.Verify = (IVerify) BackEnd.createSlice(this, UID,"verify","verify);
	this.Process = (IBlocks3D) BackEnd.createSlice(this, UID,"data_partition","process);
	this.Problem = (IProblemDefinition) BackEnd.createSlice(this, UID,"problem_data","problem);
} 

abstract public void compute(); 


}

}
