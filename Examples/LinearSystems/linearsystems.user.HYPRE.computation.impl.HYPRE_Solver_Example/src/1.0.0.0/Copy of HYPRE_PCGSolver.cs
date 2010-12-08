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

public class HYPRE_PCGSolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, V, S, M, P, R, COM, DOM> : BaseHYPRE_PCGSolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, V, S, M, P, R, COM, DOM>, ISolver<LIB, MPT, NUM, MAT, VEC, PRC, MTH, V, S, M, P, R, COM, DOM>
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

		public HYPRE_PCGSolver() { 
		
		} 
		
		private int maxiter;
		private double tol;
		private int num_iterations;
		private HYPRE_Solver solverCG;

		public override void compute() { 

				  solver_facet.HYPRE_ParCSRPCGSetMaxIter(solverCG,maxiter);
				  solver_facet.HYPRE_ParCSRPCGSetTol(solverCG, tol);
				  solver_facet.HYPRE_ParCSRPCGSetTwoNorm(solverCG,1);
				   
			      solver_facet.HYPRE_ParCSRPCGSetup(solverCG,A_ParCSR,b_ParCRS,x_ParCRS);
											
				  solver_facet.HYPRE_ParCSRPCGSolve(solverCG,A_ParCSR,b_ParCRS,x_ParCRS);   
			      
			      
				  solver_facet.HYPRE_ParCSRPCGGetNumIterations(solverCG, out num_iterations);
				  // solver.HYPRE_ParCSRPCGGetFinalRelativeResidualNorm(solverCG, out final_res_norm);
			
						      /* Destroy solver */
			      solver_facet.HYPRE_ParCSRPCGDestroy(solverCG);

		} // end activate method 

		
		public void initialize() 
		{
			      solver.HYPRE_ParCSRPCGCreate(comm.BaseComm,out solverCG);
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
