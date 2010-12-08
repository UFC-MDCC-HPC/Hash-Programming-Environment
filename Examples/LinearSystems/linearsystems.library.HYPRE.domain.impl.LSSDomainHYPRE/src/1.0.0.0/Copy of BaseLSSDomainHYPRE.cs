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

public abstract class BaseLSSDomainHYPRE<L, V, S, M, P, R, COM>: Domain, BaseILSSDomainHYPRE<L, V, S, M, P, R, COM>
where L:IHYPRE
where V:IFacetHYPREVector<L>
where S:IFacetHYPRESetup<L>
where M:IFacetHYPREMatrix<L>
where P:IFacetHYPREPreConditioner<L>
where R:IFacetHYPRESolver<L>
where COM:IMPICommunicator
{

protected V vector_facet = default(V);

public V Vector_facet {
	set {
		this.vector_facet = value;
	}
}

protected P preconditioner_facet = default(P);

public P Preconditioner_facet {
	set {
		this.preconditioner_facet = value;
	}
}

protected S setup_facet = default(S);

public S Setup_facet {
	set {
		this.setup_facet = value;
	}
}

protected R solver_facet = default(R);

public R Solver_facet {
	set {
		this.solver_facet = value;
	}
}

protected COM comm = default(COM);

public COM Comm {
	set {
		this.comm = value;
	}
}

protected M matrix_facet = default(M);

public M Matrix_facet {
	set {
		this.matrix_facet = value;
	}
}

protected L library = default(L);

public L Library {
	set {
		this.library = value;
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
