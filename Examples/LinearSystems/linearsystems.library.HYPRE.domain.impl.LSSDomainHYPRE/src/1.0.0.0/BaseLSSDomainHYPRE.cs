/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE.facet.HYPREVector;
using linearsystems.library.HYPRE.facet.HYPREPreConditioner;
using linearsystems.library.HYPRE.facet.HYPRESetup;
using linearsystems.library.HYPRE.facet.HYPRESolver;
using environment.messagepassing.Communicator;
using linearsystems.library.HYPRE.facet.HYPREMatrix;
using linearsystems.library.HYPRE;
using linearsystems.library.HYPRE.domain.LSSDomainHYPRE;
using environment.messagepassing.MPICommunicator;

namespace linearsystems.library.HYPRE.domain.impl.LSSDomainHYPRE { 

public abstract class BaseLSSDomainHYPRE<L, COM>: Domain, BaseILSSDomainHYPRE<L, COM>
where L:IHYPRE
where COM:IMPICommunicator
{

	protected COM comm = default(COM);
	
	public COM Comm {
		set {
			this.comm = value;
		}
	}
	
	
	public BaseLSSDomainHYPRE() { 
	
	} 
	
	public static string UID = "0024000004800000940000000602000000240000525341310004000011000000ddd35a206e86765c030c48c0f0bf921058d18612a42dcef7d3b24872c4cc426794758010411cab1ac1808667b2f481b9d0296fd2a39a63adea7e41cf883f7c063cd95e639c72878da3ddde77419cadf8d377960bdb0bc62dba24ea227dfacd70fb41dd4f8526adb9fa8c7dcc03a9160050f0466babb02c021ef4bb388f55d09a";
	
	override public void createSlices() {
		base.createSlices();
	} 

}

}
