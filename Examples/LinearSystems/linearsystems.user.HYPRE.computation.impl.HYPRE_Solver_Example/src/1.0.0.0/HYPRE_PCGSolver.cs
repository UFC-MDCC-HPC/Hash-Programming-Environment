using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.user.data.MatrixCSR;
using linearsystems.user.data.Vector;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.qualifier.ConjugateGradient;
using linearsystems.library.HYPRE.facet.HYPREVector;
using linearsystems.library.HYPRE.facet.HYPRESetup;
using linearsystems.library.HYPRE.facet.HYPREMatrix;
using linearsystems.library.HYPRE.facet.HYPREPreConditioner;
using linearsystems.library.HYPRE.facet.HYPRESolver;
using environment.messagepassing.MPICommunicator;
using linearsystems.library.HYPRE.domain.LSSDomainHYPRE;
using linearsystems.user.computation.Solver;

namespace linearsystems.user.HYPRE.computation.impl.HYPRE_Solver_Example { 

public class HYPRE_PCGSolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, COM> : BaseHYPRE_PCGSolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, COM>, ISolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, COM, ILSSDomainHYPRE<LIB, COM>>
where LIB:IHYPRE
where MPT:ISparseMatrix<LIB>
where NUM:IDoublePrecisionFPNumber
where MAT:IMatrixCSR<LIB, MPT, NUM, COM, ILSSDomainHYPRE<LIB, COM>>
where VEC:IVector<LIB, NUM, COM, ILSSDomainHYPRE<LIB, COM>>
where PRC:IPreConditioner<LIB, MPT>
where MTH:IConjugateGradient<LIB, MPT, PRC>
where COM:IMPICommunicator
{

		public HYPRE_PCGSolver() { 
		
		} 
		
		private int maxiter;
		private double tol;
		private int num_iterations;
		private double final_res_norm;
		private HYPRE_Solver solverCG;

		public override void compute() { 
			     
			/* Get primitive structures */
			HYPRE_ParCRS_vector b_ParCRS = (HYPRE_ParCRS_vector) rhs.Primitive;
			HYPRE_ParCRS_vector x_ParCRS = (HYPRE_ParCRS_vector) solution.Primitive;
			HYPRE_ParCSR_matrix A_ParCSR = (HYPRE_ParCSR_matrix) matrix.Primitive;
			
			/* Setup solver parameters */
			lssdomain.HYPRE_ParCSRPCGSetMaxIter(solverCG, maxiter);
			lssdomain.HYPRE_ParCSRPCGSetTol(solverCG, tol);
			lssdomain.HYPRE_ParCSRPCGSetTwoNorm(solverCG,1);
			
			/* Consolidate data structures */
			lssdomain.HYPRE_ParCSRPCGSetup(solverCG,A_ParCSR,b_ParCRS,x_ParCRS);
						
			/* Solve ! */
			lssdomain.HYPRE_ParCSRPCGSolve(solverCG,A_ParCSR,b_ParCRS,x_ParCRS);   
			
			/* Get some information about execution */
			lssdomain.HYPRE_ParCSRPCGGetNumIterations(solverCG, out num_iterations);
			lssdomain.HYPRE_ParCSRPCGGetFinalRelativeResidualNorm(solverCG, out final_res_norm);
			
			/* Destroy solver */
			lssdomain.HYPRE_ParCSRPCGDestroy(solverCG);
			
		} // end activate method 

		
		public void initialize() 
		{
			lssdomain.HYPRE_ParCSRPCGCreate(comm.BaseComm,out solverCG);
		}

		
		public void setMaxIterations(int maxiter_) 
		{
		   	this.maxiter = maxiter_;
		}
		
		public void setTolerance(int tol_) 
		{
		   	this.tol = tol_;
		}
		
		public int getIterations() 
		{
			return num_iterations;
		}

}

}
