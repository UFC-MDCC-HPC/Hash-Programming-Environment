/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.user.data.Vector;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.library.HYPRE.facet.HYPREVector;
using linearsystems.library.HYPRE.domain.LSSDomainHYPRE;
using linearsystems.library.HYPRE.facet.HYPRESetup;
using linearsystems.library.HYPRE.facet.HYPREMatrix;
using linearsystems.library.HYPRE.facet.HYPREPreConditioner;
using linearsystems.library.HYPRE.facet.HYPRESolver;
using linearsystems.user.data.MatrixCSR;
using linearsystems.user.qualifier.SparseMatrix;
using environment.messagepassing.MPICommunicator;
using linearsystems.user.qualifier.ConjugateGradient;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.computation.Solver;

namespace linearsystems.user.HYPRE.computation.impl.HYPRE_Solver_Example { 

public abstract class BaseHYPRE_PCGSolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, V, S, M, P, R, COM, DOM>: Computation, BaseISolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, V, S, M, P, R, COM, DOM>
where LIB:IHYPRE
where MPT:ISparseMatrix<LIB>
where NUM:IDoublePrecisionFPNumber
where MAT:IMatrixCSR<LIB, MPT, NUM>
where VEC:IVector<LIB, NUM>
where PRC:IPreConditioner<LIB, MPT>
where MTH:IConjugateGradient<LIB, MPT, PRC>
where V:IFacetHYPREVector<LIB>
where S:IFacetHYPRESetup<LIB>
where M:IFacetHYPREMatrix<LIB>
where P:IFacetHYPREPreConditioner<LIB>
where R:IFacetHYPRESolver<LIB>
where COM:IMPICommunicator
where DOM:ILSSDomainHYPRE<LIB,V, S, M, P, R, COM>
{

protected VEC rhs = default(VEC);

public VEC Rhs {
	set {
		this.rhs = value;
	}
}

protected VEC solution = default(VEC);

public VEC Solution {
	set {
		this.solution = value;
	}
}

protected V vector_facet = default(V);

public V Vector_facet {
	set {
		this.vector_facet = value;
		lssdomain.Vector_facet = value;
	}
}

protected DOM lssdomain = default(DOM);

protected DOM Lssdomain {
	set {
		this.lssdomain = value;
	}
}

protected P preconditioner_facet = default(P);

public P Preconditioner_facet {
	set {
		this.preconditioner_facet = value;
		lssdomain.Preconditioner_facet = value;
	}
}

protected MAT matrix = default(MAT);

public MAT Matrix {
	set {
		this.matrix = value;
	}
}

protected S setup_facet = default(S);

public S Setup_facet {
	set {
		this.setup_facet = value;
		lssdomain.Setup_facet = value;
	}
}

protected R solver_facet = default(R);

public R Solver_facet {
	set {
		this.solver_facet = value;
		lssdomain.Solver_facet = value;
	}
}

protected M matrix_facet = default(M);

public M Matrix_facet {
	set {
		this.matrix_facet = value;
		lssdomain.Matrix_facet = value;
	}
}

protected COM comm = default(COM);

public COM Comm {
	set {
		this.comm = value;
		lssdomain.Comm = value;
	}
}

protected LIB library = default(LIB);

public LIB Library {
	set {
		this.library = value;
		lssdomain.Library = value;
	}
}

protected MTH solution_method = default(MTH);

protected MTH Solution_method {
	set {
		this.solution_method = value;
	}
}


public BaseHYPRE_PCGSolver() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000115843cfbd21fb68741d7c5b0b0cc4eb089653e9d9d4c94d0278c11e2ef2f64588cbbe061bb4ba1355594f54bb93d3ff2e49ae53ac704165cf4015b29fca876cebe34fcf592137b9d488866201b267b10b89e100d03ec0b2509c15ef7fab8505913c3fc901e6626cb5bac5394bb5ef066a95a46e42dc33c3abbf9a2c17a77bc7";

override public void createSlices() {
	base.createSlices();
	this.Solution_method = (MTH) BackEnd.createSlice(this, UID,"solution_method","solution_method",new Type[] {typeof(LIB),typeof(MPT),typeof(PRC)});
	this.Lssdomain = (DOM) BackEnd.createSlice(this, UID,"domain","lssdomain",new Type[] {typeof(V),typeof(S),typeof(M),typeof(P),typeof(R)});
} 

abstract public void compute(); 


}

}
