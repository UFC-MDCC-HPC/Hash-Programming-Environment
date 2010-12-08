using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE.facet.HYPREVector;
using linearsystems.library.HYPRE.facet.HYPRESetup;
using linearsystems.library.HYPRE.facet.HYPREMatrix;
using linearsystems.library.HYPRE.facet.HYPREPreConditioner;
using linearsystems.library.HYPRE.facet.HYPRESolver;
using linearsystems.library.HYPRE.domain.LSSDomainHYPRE;
using System.Runtime.InteropServices;
using environment.messagepassing.MPICommunicator;

namespace linearsystems.library.HYPRE.domain.impl.LSSDomainHYPRE { 

			using MPI_Comm = System.IntPtr;

public class LSSDomainHYPRE<L, V, S, M, P, R, COM> : BaseLSSDomainHYPRE<L, V, S, M, P, R, COM>, ILSSDomainHYPRE<L, V, S, M, P, R, COM>
where L:IHYPRE
where V:IFacetHYPREVector<L>
where S:IFacetHYPRESetup<L>
where M:IFacetHYPREMatrix<L>
where P:IFacetHYPREPreConditioner<L>
where R:IFacetHYPRESolver<L>
where COM:IMPICommunicator			
{

		public LSSDomainHYPRE() { 
		
			this.solver_facet = (R) new FacetHYPRESolver<L>();
			this.vector_facet = (V) new FacetHYPREVector<L>();
			this.matrix_facet = (M) new FacetHYPREMatrix<L>();
			this.setup_facet = (S) new FacetHYPRESetup<L>();
			this.preconditioner_facet = (P) new FacetHYPREPreConditioner<L>();
			
		}
				
}

		public class FacetHYPRESolver<L> : IFacetHYPRESolver<L>
		where L:IHYPRE
		{
			public int HYPRE_ParCSRPCGCreate(MPI_Comm com, out  HYPRE_Solver solver){
				return ParCSRPCGCreate(com, out  solver);
			}
	
	              
	        public int HYPRE_ParCSRPCGDestroy(HYPRE_Solver solver){
				return ParCSRPCGDestroy( solver);
			}
	
	        
	        public int HYPRE_ParCSRPCGSetup(HYPRE_Solver solver, HYPRE_ParCSR_matrix ParCSRMatrix_A, HYPRE_ParCRS_vector ParVector_b, HYPRE_ParCRS_vector ParVector_x){
				return ParCSRPCGSetup( solver,  ParCSRMatrix_A,  ParVector_b,  ParVector_x);
			}
	
	        
	        public int HYPRE_ParCSRPCGSolve(HYPRE_Solver solver, HYPRE_ParCSR_matrix ParCSRMatrix_A, HYPRE_ParCRS_vector ParVector_b, HYPRE_ParCRS_vector ParVector_x){
				return ParCSRPCGSolve( solver,  ParCSRMatrix_A,  ParVector_b,  ParVector_x);
			}
	
	        
	        public int HYPRE_ParCSRPCGSetTol(HYPRE_Solver solver, double tol){
				return ParCSRPCGSetTol( solver, tol);
			}
	
	        
	        public int HYPRE_ParCSRPCGSetAbsoluteTol(HYPRE_Solver solver, double tol){
				return ParCSRPCGSetAbsoluteTol( solver, tol);
			}
	
	        
	        public int HYPRE_ParCSRPCGSetMaxIter(HYPRE_Solver solver, int max_iter){
				return ParCSRPCGSetMaxIter( solver, max_iter);
			}
	
	        
	        public int HYPRE_ParCSRPCGSetTwoNorm(HYPRE_Solver solver, int two_norm){
				return ParCSRPCGSetTwoNorm( solver, two_norm);
			}
	
	        
	        public int HYPRE_ParCSRPCGSetRelChange(HYPRE_Solver solver, int rel_change){
				return ParCSRPCGSetRelChange( solver,rel_change);
			}
	
	        
	        public int HYPRE_ParCSRPCGSetPrecond(HYPRE_Solver solver, IntPtr PtrToParSolverFcn_precond, IntPtr PtrToParSolverFcn_precond_setup, IntPtr precond_solver){
				return ParCSRPCGSetPrecond( solver, PtrToParSolverFcn_precond, PtrToParSolverFcn_precond_setup, precond_solver);
			}
	
	        
	        public int HYPRE_ParCSRPCGGetPrecond(HYPRE_Solver solver, out IntPtr precond_data){
				return ParCSRPCGGetPrecond( solver, out precond_data);
			}
	
	        
	        public int HYPRE_ParCSRPCGGetNumIterations(HYPRE_Solver solver, out int num_iterations){
				return ParCSRPCGGetNumIterations( solver, out num_iterations);
			}
	
	        
	        public int HYPRE_ParCSRPCGGetFinalRelativeResidualNorm(HYPRE_Solver solver, out double norm){
				return ParCSRPCGGetFinalRelativeResidualNorm( solver, out norm);
			}
	
	        
	        public int HYPRE_ParCSRDiagScaleSetup(HYPRE_Solver solver, IntPtr ParCSRMatrix_A, IntPtr ParVector_y, IntPtr ParVector_x){
				return ParCSRDiagScaleSetup( solver, ParCSRMatrix_A, ParVector_y, ParVector_x);
			}
	
	        
	        public int HYPRE_ParCSRDiagScale(HYPRE_Solver solver, IntPtr ParCSRMatrix_HA, IntPtr ParVector_Hy, IntPtr ParVector_Hx){
				return ParCSRDiagScale( solver, ParCSRMatrix_HA, ParVector_Hy, ParVector_Hx);
			}
	        
			
			//Chamada nativa
			[DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGCreate")]
	        private static extern int ParCSRPCGCreate(MPI_Comm com, out   HYPRE_Solver solver);
	
	              
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGDestroy")]
	        private static extern int ParCSRPCGDestroy(HYPRE_Solver solver);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGSetup")]
	        private static extern int ParCSRPCGSetup(HYPRE_Solver solver, HYPRE_ParCSR_matrix ParCSRMatrix_A, HYPRE_ParCRS_vector ParVector_b, HYPRE_ParCRS_vector ParVector_x);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGSolve")]
	        private static extern int ParCSRPCGSolve(HYPRE_Solver solver, HYPRE_ParCSR_matrix ParCSRMatrix_A, HYPRE_ParCRS_vector ParVector_b, HYPRE_ParCRS_vector ParVector_x);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGSetTol")]
	        private static extern int ParCSRPCGSetTol(HYPRE_Solver solver, double tol);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGSetAbsoluteTol")]
	        private static extern int ParCSRPCGSetAbsoluteTol(HYPRE_Solver solver, double tol);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGSetMaxIter")]
	        private static extern int ParCSRPCGSetMaxIter(HYPRE_Solver solver, int max_iter);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGSetTwoNorm")]
	        private static extern int ParCSRPCGSetTwoNorm(HYPRE_Solver solver, int two_norm);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGSetRelChange")]
	        private static extern int ParCSRPCGSetRelChange(HYPRE_Solver solver, int rel_change);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGSetPrecond")]
	        private static extern int ParCSRPCGSetPrecond(HYPRE_Solver solver, IntPtr PtrToParSolverFcn_precond, IntPtr PtrToParSolverFcn_precond_setup, IntPtr precond_solver);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGGetPrecond")]
	        private static extern int ParCSRPCGGetPrecond(HYPRE_Solver solver, out IntPtr precond_data);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGGetNumIterations")]
	        private static extern int ParCSRPCGGetNumIterations(HYPRE_Solver solver, out int num_iterations);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRPCGGetFinalRelativeResidualNorm")]
	        private static extern int ParCSRPCGGetFinalRelativeResidualNorm(HYPRE_Solver solver, out double norm);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRDiagScaleSetup")]
	        private static extern int ParCSRDiagScaleSetup(HYPRE_Solver solver, IntPtr ParCSRMatrix_A, IntPtr ParVector_y, IntPtr ParVector_x);
	
	        
	        [DllImport("libHYPRE_parcsr_ls.so", EntryPoint = "HYPRE_ParCSRDiagScale")]
	        private static extern int ParCSRDiagScale(HYPRE_Solver solver, IntPtr ParCSRMatrix_HA, IntPtr ParVector_Hy, IntPtr ParVector_Hx);
		}
		
		public class FacetHYPREVector<L> : IFacetHYPREVector<L>
		where L:IHYPRE
		{
			
			public int HYPRE_IJVectorCreate(MPI_Comm comm, int jlower, int jupper, out HYPRE_IJVector vector){
				return Create(comm, jlower, jupper, out vector);
			}
	       
	
	        public int HYPRE_IJVectorPrint(HYPRE_IJVector vector, string file){
				return PrintVector(vector, file);
			}
			
			
	        public int HYPRE_IJVectorDestroy(HYPRE_IJVector vector){
				return Destroy(vector);
			}
	
	        
	        public int HYPRE_IJVectorInitialize(HYPRE_IJVector vector){
				return Initialize(vector);
			}
	
	        
	        public int HYPRE_IJVectorSetMaxOffProcElmts(HYPRE_IJVector vector, int max_off_proc_elmts){
				return SetMaxOffProcElmts(vector, max_off_proc_elmts);
			}
	
	        
	        public int HYPRE_IJVectorSetValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values){
				return SetValues(vector, nvalues, indices, values);
			}
	
	        
	        public int HYPRE_IJVectorAddToValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values){
				return AddToValues(vector, nvalues, indices, values);
			}
	
	        
	        public int HYPRE_IJVectorAssemble(HYPRE_IJVector vector){
				return Assemble(vector);
			}
	
	        
	        public int HYPRE_IJVectorGetValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values){
				return GetValues(vector, nvalues, indices,  values);
			}
	
	        
	        public int HYPRE_IJVectorSetObjectType(HYPRE_IJVector vector, int type){
				return SetObjectType(vector, type);
			}
	
	        
	        public int HYPRE_IJVectorGetObjectType(HYPRE_IJVector vector, out int type){
				return GetObjectType(vector, out type);
			}
	
	        
	        public int HYPRE_IJVectorGetLocalRange(HYPRE_IJVector vector, out int jlower, out int jupper){
				return GetLocalRange(vector, out jlower, out jupper);
			}
	
	        
	        public int HYPRE_IJVectorGetObject(HYPRE_IJVector vector, out HYPRE_ParCRS_vector mtx_object){
				return GetObject(vector, out mtx_object);
			}
			
			
			//chamada nativa
			
			[DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorCreate")]
	        private static extern int Create(MPI_Comm comm, int jlower, int jupper, out HYPRE_IJVector vector);
	       
	
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorPrint")]
	        private static extern int PrintVector(HYPRE_IJVector MPI_Comm, string file);
			
			
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorDestroy")]
	        private static extern int Destroy(HYPRE_IJVector vector);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorInitialize")]
	        private static extern int Initialize(HYPRE_IJVector vector);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorSetMaxOffProcElmts")]
	        private static extern int SetMaxOffProcElmts(HYPRE_IJVector vector, int max_off_proc_elmts);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorSetValues")]
	        private static extern int SetValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorAddToValues")]
	        private static extern int AddToValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorAssemble")]
	        private static extern int Assemble(HYPRE_IJVector vector);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorGetValues")]
	        private static extern int GetValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorSetObjectType")]
	        private static extern int SetObjectType(HYPRE_IJVector vector, int type);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorGetObjectType")]
	        private static extern int GetObjectType(HYPRE_IJVector vector, out int type);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorGetLocalRange")]
	        private static extern int GetLocalRange(HYPRE_IJVector vector, out int jlower, out int jupper);
	
	        
	        [DllImport("HYPRE", EntryPoint = "HYPRE_IJVectorGetObject")]
	        private static extern int GetObject(HYPRE_IJVector vector, out HYPRE_ParCRS_vector mtx_object);

		}

		public class FacetHYPRESetup<L> : IFacetHYPRESetup<L>
		where L:IHYPRE
		{
			
		}
		
		public class FacetHYPREMatrix<L> : IFacetHYPREMatrix<L>
		where L:IHYPRE
		{
			
			public int HYPRE_IJMatrixCreate(MPI_Comm comm, int ilower, int iupper, int jlower, int jupper, out HYPRE_IJMatrix matrix){
				return Create(comm, ilower, iupper, jlower, jupper, out matrix);
			}
	
	      	public int HYPRE_IJMatrixPrint(HYPRE_IJMatrix matrix, string filename){
				return Print(matrix, filename);
			}
	
	        public int HYPRE_IJMatrixDestroy(HYPRE_IJMatrix matrix){
				return Destroy(matrix);
			}
	
	        public int HYPRE_IJMatrixInitialize(HYPRE_IJMatrix matrix){
				return Initialize(matrix);
			}
	
	        public int HYPRE_IJMatrixSetValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values){
				return SetValues(matrix, nrows, ncols, rows, cols, values);
			}
	
	        public int HYPRE_IJMatrixAddToValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values){
				return AddToValues(matrix, nrows, ncols, rows, cols, values);
				
			}
	
	        public int HYPRE_IJMatrixAssemble(HYPRE_IJMatrix matrix){
				return Assemble(matrix);
			}
	
	        public int HYPRE_IJMatrixGetRowCounts(HYPRE_IJMatrix matrix, int nrows, int[] rows, int[] ncols){
				return GetRowCounts(matrix,nrows,rows, ncols);
				
			}
	
	        public int HYPRE_IJMatrixGetValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values){
				return GetValues(matrix, nrows, ncols, rows, cols, values);
			}
	 
	        public int HYPRE_IJMatrixSetObjectType(HYPRE_IJMatrix matrix, int type){
				return SetObjectType(matrix, type);
			}
	
	        public int HYPRE_IJMatrixGetObjectType(HYPRE_IJMatrix matrix, out int type){
				return GetObjectType(matrix, out type);
			}
	
	        public int HYPRE_IJMatrixGetLocalRange(HYPRE_IJMatrix matrix, ref int ilower, ref int iupper, ref int jlower, ref int jupper){
				return GetLocalRange(matrix, ref ilower, ref iupper, ref jlower, ref jupper);
			}
	
	        public int HYPRE_IJMatrixGetObject(HYPRE_IJMatrix matrix, out HYPRE_ParCSR_matrix mtx_object){
				return GetObject(matrix, out mtx_object);
			}
	
	        public int HYPRE_IJMatrixSetRowSizes(HYPRE_IJMatrix matrix, int[] sizes){
				return SetRowSizes(matrix, sizes);
			}
	 
	        public int HYPRE_IJMatrixSetDiagOffdSizes(HYPRE_IJMatrix matrix, int[] diag_sizes, int[] offdiag_sizes){
				return SetDiagOffdSizes(matrix,diag_sizes, offdiag_sizes);
			}
	
	        public int HYPRE_IJMatrixSetMaxOffProcElmts(HYPRE_IJMatrix matrix, int max_off_proc_elmts){
				return SetMaxOffProcElmts(matrix, max_off_proc_elmts);
			}
			
			
			
			[DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixCreate")]
	        extern private static int Create(MPI_Comm comm, int ilower, int iupper, int jlower, int jupper, out HYPRE_IJMatrix matrix);
	
	        
			[DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixPrint")]
	        extern private static int Print(HYPRE_IJMatrix matrix, string filename);
	
	               
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixDestroy")]
	        extern private static int Destroy(HYPRE_IJMatrix matrix);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixInitialize")]
	        extern private static int Initialize(HYPRE_IJMatrix matrix);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixSetValues")]
	        extern private static int SetValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixAddToValues")]
	        extern private static int AddToValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixAssemble")]
	        extern private static int Assemble(HYPRE_IJMatrix matrix);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixGetRowCounts")]
	        extern private static int GetRowCounts(HYPRE_IJMatrix matrix, int nrows, int[] rows, int[] ncols);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixGetValues")]
	        extern private static int GetValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values);
	 
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixSetObjectType")]
	        extern private static int SetObjectType(HYPRE_IJMatrix matrix, int type);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixGetObjectType")]
	        extern private static int GetObjectType(HYPRE_IJMatrix matrix, out int type);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixGetLocalRange")]
	        extern private static int GetLocalRange(HYPRE_IJMatrix matrix, ref int ilower, ref int iupper, ref int jlower, ref int jupper);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixGetObject")]
	        extern private static int GetObject(HYPRE_IJMatrix matrix, out HYPRE_ParCSR_matrix mtx_object);
	
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixSetRowSizes")]
	        extern private static int SetRowSizes(HYPRE_IJMatrix matrix, int[] sizes);
	 
	        
	        [DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixSetDiagOffdSizes")]
	        extern private static int SetDiagOffdSizes(HYPRE_IJMatrix matrix, int[] diag_sizes, int[] offdiag_sizes);
	
	        
			[DllImport("libHYPRE_IJ_mv.so", EntryPoint = "HYPRE_IJMatrixSetMaxOffProcElmts")]
	        extern private static int SetMaxOffProcElmts(HYPRE_IJMatrix matrix, int max_off_proc_elmts);

		}

		public class FacetHYPREPreConditioner<L> : IFacetHYPREPreConditioner<L>
		where L:IHYPRE
		{
			
		}

}
