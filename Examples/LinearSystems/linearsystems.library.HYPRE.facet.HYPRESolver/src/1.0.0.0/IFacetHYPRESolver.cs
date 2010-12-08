using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.facet.LSSFacetSolver;
using linearsystems.library.HYPRE;
using System;
// using MPI;

namespace linearsystems.library.HYPRE.facet.HYPRESolver { 

using MPI_Comm = System.IntPtr;

public interface IFacetHYPRESolver<L> : BaseIFacetHYPRESolver<L>, IFacetSolver<L>
where L:IHYPRE
{
	int HYPRE_ParCSRPCGCreate(MPI_Comm com, out  HYPRE_Solver solver);              
    int HYPRE_ParCSRPCGDestroy(HYPRE_Solver solver);        
    int HYPRE_ParCSRPCGSetup(HYPRE_Solver solver, HYPRE_ParCSR_matrix ParCSRMatrix_A, HYPRE_ParCRS_vector ParVector_b, HYPRE_ParCRS_vector ParVector_x);        
    int HYPRE_ParCSRPCGSolve(HYPRE_Solver solver, HYPRE_ParCSR_matrix ParCSRMatrix_A, HYPRE_ParCRS_vector ParVector_b, HYPRE_ParCRS_vector ParVector_x);        
    int HYPRE_ParCSRPCGSetTol(HYPRE_Solver solver, double tol);        
    int HYPRE_ParCSRPCGSetAbsoluteTol(HYPRE_Solver solver, double tol);        
    int HYPRE_ParCSRPCGSetMaxIter(HYPRE_Solver solver, int max_iter);        
    int HYPRE_ParCSRPCGSetTwoNorm(HYPRE_Solver solver, int two_norm);        
    int HYPRE_ParCSRPCGSetRelChange(HYPRE_Solver solver, int rel_change);        
    int HYPRE_ParCSRPCGSetPrecond(HYPRE_Solver solver, IntPtr PtrToParSolverFcn_precond, IntPtr PtrToParSolverFcn_precond_setup, IntPtr precond_solver);        
    int HYPRE_ParCSRPCGGetPrecond(HYPRE_Solver solver, out IntPtr precond_data);        
    int HYPRE_ParCSRPCGGetNumIterations(HYPRE_Solver solver, out int num_iterations);        
    int HYPRE_ParCSRPCGGetFinalRelativeResidualNorm(HYPRE_Solver solver, out double norm);        
    int HYPRE_ParCSRDiagScaleSetup(HYPRE_Solver solver, IntPtr ParCSRMatrix_A, IntPtr ParVector_y, IntPtr ParVector_x);        
    int HYPRE_ParCSRDiagScale(HYPRE_Solver solver, IntPtr ParCSRMatrix_HA, IntPtr ParVector_Hy, IntPtr ParVector_Hx);
} // end main interface 

} // end namespace 
