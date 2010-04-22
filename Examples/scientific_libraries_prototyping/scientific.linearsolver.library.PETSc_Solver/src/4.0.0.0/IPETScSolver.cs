using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using scientific.linearsolver.PETScSetupFacet;
using scientific.linearsolver.PETScSolverFacet;
using scientific.linearsolver.library.PETSc;
using scientific.linearsolver.PETScMatrixFacet;
using scientific.linearsolver.Solver;

namespace scientific.linearsolver.library.PETSc_Solver { 

public class IPETScSolver<M, E, S, L>: Computation, ISolve<M, E, S, L>
where M:IPETScMatrixFacet
where E:IPETScSetupFacet
where S:IPETScSolverFacet
where L:IPETSc
{

private E facet_setup = default(E);

private E Facet_setup {
	set {
		this.facet_setup = value;
		library.Facet_setup = value;
	}
}

private S facet_solver = default(S);

public S Facet_solver {
	set {
		this.facet_solver = value;
		library.Facet_solver = value;
	}
}

private L library = default(L);

private L Library {
	set {
		this.library = value;
	}
}

private M facet_matrix = default(M);

private M Facet_matrix {
	set {
		this.facet_matrix = value;
		library.Facet_matrix = value;
	}
}


public IPETScSolver() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000611a0c5f312392a93185d201600e6831cbf218cdd9bbf3e467c81d66456122d238d761530308361d73a91d5c8fa0ee16251374975e7e50dad7158a541174cb64dfba003a14150b92292c3768f9d9cb0039c1a6467887db556de0d3c034da6f0de39ce21d5b053b5dfd15c003a4826bcfc3b208330603683f709e5335d222008a";

override public void createSlices() {
	base.createSlices();
	this.Library = (L) BackEnd.createSlice(this, UID,"library","library",new Type[] {});
	this.Facet_setup = (E) BackEnd.createSlice(this, UID,"setup","facet",new Type[] {});
	this.Facet_matrix = (M) BackEnd.createSlice(this, UID,"matrix","facet",new Type[] {});
} 

public void compute() { 

	;

} // end activate method 

}

}
