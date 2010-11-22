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
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.library.HYPRE.domain.impl.LSSDomainHYPRE { 

	using MPI_Comm = System.IntPtr;
	
public abstract class BaseLSSDomainHYPRE: Domain, 
                                          BaseILSSDomain<IHYPRE>,
                                          IHYPREVector,
                                          IHYPRESetup,
                                          IHYPREMatrix,
                                          IHYPREPreConditioner,
                                          IHYPRESolver
{


protected ICommunicator comm = null;

protected ICommunicator Comm {
	set {
		this.comm = value;
	}
}

public BaseLSSDomainHYPRE() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000095a06bfdd6dbd1f996fd9e941901d88366e679c7ef57494113587ef0f53d7d001660606c6a94772827c103d9243e05eb4ac03915655c0f759d5ad274413f10b51a652fb5b9c9b52d4b88163a3ece348a5ddcad77d5f58f8cd39a454f6c5f0dc1451ebb8a21224bbd8d3403bc575cd4c4ee7ec62b8b05e682d8be340317c58e88";

override public void createSlices() {
	base.createSlices();
	this.Comm = (ICommunicator) BackEnd.createSlice(this, UID,"comm","comm",new Type[] {});
} 
		
		#region IVector members		

public abstract int HYPRE_IJVectorCreate(MPI_Comm comm, int jlower, int jupper, out HYPRE_IJVector vector);
public abstract int HYPRE_IJVectorPrint(HYPRE_IJVector vector, string file);
public abstract int HYPRE_IJVectorDestroy(HYPRE_IJVector vector);        
public abstract int HYPRE_IJVectorInitialize(HYPRE_IJVector vector);        
public abstract int HYPRE_IJVectorSetMaxOffProcElmts(HYPRE_IJVector vector, int max_off_proc_elmts);        
public abstract int HYPRE_IJVectorSetValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values);        
public abstract int HYPRE_IJVectorAddToValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values);        
public abstract int HYPRE_IJVectorAssemble(HYPRE_IJVector vector);        
public abstract int HYPRE_IJVectorGetValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values);
public abstract int HYPRE_IJVectorSetObjectType(HYPRE_IJVector vector, int type);        
public abstract int HYPRE_IJVectorGetObjectType(HYPRE_IJVector vector, out int type);        
public abstract int HYPRE_IJVectorGetLocalRange(HYPRE_IJVector vector, out int jlower, out int jupper);        
public abstract int HYPRE_IJVectorGetObject(HYPRE_IJVector vector, out HYPRE_ParCRS_vector mtx_object);
		
		#endregion
		
		#region IMatrix members
		
public abstract	int HYPRE_IJMatrixCreate(MPI_Comm comm, int ilower, int iupper, int jlower, int jupper, out HYPRE_IJMatrix matrix);
public abstract int HYPRE_IJMatrixPrint(HYPRE_IJMatrix matrix, string filename);
public abstract int HYPRE_IJMatrixDestroy(HYPRE_IJMatrix matrix);
public abstract int HYPRE_IJMatrixInitialize(HYPRE_IJMatrix matrix);
public abstract int HYPRE_IJMatrixSetValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values);
public abstract int HYPRE_IJMatrixAddToValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values);
public abstract int HYPRE_IJMatrixAssemble(HYPRE_IJMatrix matrix);
public abstract int HYPRE_IJMatrixGetRowCounts(HYPRE_IJMatrix matrix, int nrows, int[] rows, int[] ncols);
public abstract int HYPRE_IJMatrixGetValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values);
public abstract int HYPRE_IJMatrixSetObjectType(HYPRE_IJMatrix matrix, int type);
public abstract int HYPRE_IJMatrixGetObjectType(HYPRE_IJMatrix matrix, out int type);
public abstract int HYPRE_IJMatrixGetLocalRange(HYPRE_IJMatrix matrix, ref int ilower, ref int iupper, ref int jlower, ref int jupper);
public abstract int HYPRE_IJMatrixGetObject(HYPRE_IJMatrix matrix, out HYPRE_ParCSR_matrix mtx_object);
public abstract int HYPRE_IJMatrixSetRowSizes(HYPRE_IJMatrix matrix, int[] sizes); 
public abstract int HYPRE_IJMatrixSetDiagOffdSizes(HYPRE_IJMatrix matrix, int[] diag_sizes, int[] offdiag_sizes);
public abstract int HYPRE_IJMatrixSetMaxOffProcElmts(HYPRE_IJMatrix matrix, int max_off_proc_elmts);
		
		#endregion
		
		#region ISolver members
		
public abstract int HYPRE_ParCSRPCGCreate(MPI_Comm com, out  HYPRE_Solver solver);              
public abstract int HYPRE_ParCSRPCGDestroy(HYPRE_Solver solver);        
public abstract int HYPRE_ParCSRPCGSetup(HYPRE_Solver solver, HYPRE_ParCSR_matrix ParCSRMatrix_A, HYPRE_ParCRS_vector ParVector_b, HYPRE_ParCRS_vector ParVector_x);        
public abstract int HYPRE_ParCSRPCGSolve(HYPRE_Solver solver, HYPRE_ParCSR_matrix ParCSRMatrix_A, HYPRE_ParCRS_vector ParVector_b, HYPRE_ParCRS_vector ParVector_x);        
public abstract int HYPRE_ParCSRPCGSetTol(HYPRE_Solver solver, double tol);        
public abstract int HYPRE_ParCSRPCGSetAbsoluteTol(HYPRE_Solver solver, double tol);        
public abstract int HYPRE_ParCSRPCGSetMaxIter(HYPRE_Solver solver, int max_iter);        
public abstract int HYPRE_ParCSRPCGSetTwoNorm(HYPRE_Solver solver, int two_norm);        
public abstract int HYPRE_ParCSRPCGSetRelChange(HYPRE_Solver solver, int rel_change);        
public abstract int HYPRE_ParCSRPCGSetPrecond(HYPRE_Solver solver, IntPtr PtrToParSolverFcn_precond, IntPtr PtrToParSolverFcn_precond_setup, IntPtr precond_solver);        
public abstract int HYPRE_ParCSRPCGGetPrecond(HYPRE_Solver solver, out IntPtr precond_data);        
public abstract int HYPRE_ParCSRPCGGetNumIterations(HYPRE_Solver solver, out int num_iterations);        
public abstract int HYPRE_ParCSRPCGGetFinalRelativeResidualNorm(HYPRE_Solver solver, out double norm);        
public abstract int HYPRE_ParCSRDiagScaleSetup(HYPRE_Solver solver, IntPtr ParCSRMatrix_A, IntPtr ParVector_y, IntPtr ParVector_x);        
public abstract int HYPRE_ParCSRDiagScale(HYPRE_Solver solver, IntPtr ParCSRMatrix_HA, IntPtr ParVector_Hy, IntPtr ParVector_Hx);
		
		#endregion
		

}

}
