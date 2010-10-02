using br.ufc.hpe.kinds;
using linearsystems.qualifier.HYPRE;
using linearsystems.library.facet.Solving;
using MPI;

namespace linearsystems.library.facet.HYPRE.Solving { 

public interface IHYPRESolving<L> : BaseIHYPRESolving<L>, ISolvingFacet<L>
where L:IHYPRE
{
    //Method Jacobi   
	int HYPRE_StructJacobiCreate ( Intracommunicator comm , HYPRE_StructSolver solver );
	int HYPRE_StructJacobiDestroy ( HYPRE_StructSolver solver );
	int HYPRE_StructJacobiSetup ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructJacobiSolve ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructJacobiSetTol ( HYPRE_StructSolver solver , double tol );
	unsafe int HYPRE_StructJacobiGetTol ( HYPRE_StructSolver solver , double* tol );
	int HYPRE_StructJacobiSetMaxIter ( HYPRE_StructSolver solver , int max_iter );
	unsafe int HYPRE_StructJacobiGetMaxIter ( HYPRE_StructSolver solver , int* max_iter );
	int HYPRE_StructJacobiSetZeroGuess ( HYPRE_StructSolver solver );
	unsafe int HYPRE_StructJacobiGetZeroGuess ( HYPRE_StructSolver solver , int* zeroguess );
	int HYPRE_StructJacobiSetNonZeroGuess ( HYPRE_StructSolver solver );
	unsafe int HYPRE_StructJacobiGetNumIterations ( HYPRE_StructSolver solver , int* num_iterations );
	unsafe int HYPRE_StructJacobiGetFinalRelativeResidualNorm ( HYPRE_StructSolver solver , double* norm );
	
	//Method PFMG
	int HYPRE_StructPFMGCreate ( Intracommunicator comm , HYPRE_StructSolver solver );
	int HYPRE_StructPFMGDestroy ( HYPRE_StructSolver solver );
	unsafe int HYPRE_StructPFMGSetup ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructPFMGSolve ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructPFMGSetTol ( HYPRE_StructSolver solver , double tol );
	unsafe int HYPRE_StructPFMGGetTol ( HYPRE_StructSolver solver , double* tol );
	int HYPRE_StructPFMGSetMaxIter ( HYPRE_StructSolver solver , int max_iter );
	unsafe int HYPRE_StructPFMGGetMaxIter ( HYPRE_StructSolver solver , int* max_iter );
	int HYPRE_StructPFMGSetMaxLevels ( HYPRE_StructSolver solver , int max_levels );
	unsafe int HYPRE_StructPFMGGetMaxLevels ( HYPRE_StructSolver solver , int* max_levels );
	int HYPRE_StructPFMGSetRelChange ( HYPRE_StructSolver solver , int rel_change );
	unsafe int HYPRE_StructPFMGGetRelChange ( HYPRE_StructSolver solver , int* rel_change );
	int HYPRE_StructPFMGSetZeroGuess ( HYPRE_StructSolver solver );
	unsafe int HYPRE_StructPFMGGetZeroGuess ( HYPRE_StructSolver solver , int* zeroguess );
	int HYPRE_StructPFMGSetNonZeroGuess ( HYPRE_StructSolver solver );
	int HYPRE_StructPFMGSetRelaxType ( HYPRE_StructSolver solver , int relax_type );
	unsafe int HYPRE_StructPFMGGetRelaxType ( HYPRE_StructSolver solver , int* relax_type );
	int HYPRE_StructPFMGSetJacobiWeight ( HYPRE_StructSolver solver , double weight );
	unsafe int HYPRE_StructPFMGGetJacobiWeight ( HYPRE_StructSolver solver , double* weight );
	int HYPRE_StructPFMGSetRAPType ( HYPRE_StructSolver solver , int rap_type );
	unsafe int HYPRE_StructPFMGGetRAPType ( HYPRE_StructSolver solver , int* rap_type );
	int HYPRE_StructPFMGSetNumPreRelax ( HYPRE_StructSolver solver , int num_pre_relax );
	unsafe int HYPRE_StructPFMGGetNumPreRelax ( HYPRE_StructSolver solver , int* num_pre_relax );
	int HYPRE_StructPFMGSetNumPostRelax ( HYPRE_StructSolver solver , int num_post_relax );
	unsafe int HYPRE_StructPFMGGetNumPostRelax ( HYPRE_StructSolver solver , int* num_post_relax );
	int HYPRE_StructPFMGSetSkipRelax ( HYPRE_StructSolver solver , int skip_relax );
	unsafe int HYPRE_StructPFMGGetSkipRelax ( HYPRE_StructSolver solver , int* skip_relax );
	unsafe int HYPRE_StructPFMGSetDxyz ( HYPRE_StructSolver solver , double* dxyz );
	int HYPRE_StructPFMGSetLogging ( HYPRE_StructSolver solver , int logging );
	unsafe int HYPRE_StructPFMGGetLogging ( HYPRE_StructSolver solver , int* logging );
	int HYPRE_StructPFMGSetPrintLevel ( HYPRE_StructSolver solver , int print_level );
	unsafe int HYPRE_StructPFMGGetPrintLevel ( HYPRE_StructSolver solver , int* print_level );
	unsafe int HYPRE_StructPFMGGetNumIterations ( HYPRE_StructSolver solver , int* num_iterations );
	unsafe int HYPRE_StructPFMGGetFinalRelativeResidualNorm ( HYPRE_StructSolver solver , double* norm );
	
	//Method SMG
	int HYPRE_StructSMGCreate ( Intracommunicator comm , HYPRE_StructSolver solver );
	int HYPRE_StructSMGDestroy ( HYPRE_StructSolver solver );
	int HYPRE_StructSMGSetup ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructSMGSolve ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructSMGSetMemoryUse ( HYPRE_StructSolver solver , int memory_use );
	unsafe int HYPRE_StructSMGGetMemoryUse ( HYPRE_StructSolver solver , int* memory_use );
	int HYPRE_StructSMGSetTol ( HYPRE_StructSolver solver , double tol );
	unsafe int HYPRE_StructSMGGetTol ( HYPRE_StructSolver solver , double* tol );
	int HYPRE_StructSMGSetMaxIter ( HYPRE_StructSolver solver , int max_iter );
	unsafe int HYPRE_StructSMGGetMaxIter ( HYPRE_StructSolver solver , int* max_iter );
	int HYPRE_StructSMGSetRelChange ( HYPRE_StructSolver solver , int rel_change );
	unsafe int HYPRE_StructSMGGetRelChange ( HYPRE_StructSolver solver , int* rel_change );
	int HYPRE_StructSMGSetZeroGuess ( HYPRE_StructSolver solver );
	unsafe int HYPRE_StructSMGGetZeroGuess ( HYPRE_StructSolver solver , int* zeroguess );
	int HYPRE_StructSMGSetNonZeroGuess ( HYPRE_StructSolver solver );
	int HYPRE_StructSMGSetNumPreRelax ( HYPRE_StructSolver solver , int num_pre_relax );
	unsafe int HYPRE_StructSMGGetNumPreRelax ( HYPRE_StructSolver solver , int* num_pre_relax );
	int HYPRE_StructSMGSetNumPostRelax ( HYPRE_StructSolver solver , int num_post_relax );
	unsafe int HYPRE_StructSMGGetNumPostRelax ( HYPRE_StructSolver solver , int* num_post_relax );
	int HYPRE_StructSMGSetLogging ( HYPRE_StructSolver solver , int logging );
	unsafe int HYPRE_StructSMGGetLogging ( HYPRE_StructSolver solver , int* logging );
	int HYPRE_StructSMGSetPrintLevel ( HYPRE_StructSolver solver , int print_level );
	unsafe int HYPRE_StructSMGGetPrintLevel ( HYPRE_StructSolver solver , int* print_level );
	unsafe int HYPRE_StructSMGGetNumIterations ( HYPRE_StructSolver solver , int* num_iterations );
	unsafe int HYPRE_StructSMGGetFinalRelativeResidualNorm ( HYPRE_StructSolver solver , double* norm );
	
	//Method PCG
	int HYPRE_StructPCGCreate ( Intracommunicator comm , HYPRE_StructSolver solver );
	int HYPRE_StructPCGDestroy ( HYPRE_StructSolver solver );
	int HYPRE_StructPCGSetup ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructPCGSolve ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructPCGSetTol ( HYPRE_StructSolver solver , double tol );
	int HYPRE_StructPCGSetAbsoluteTol ( HYPRE_StructSolver solver , double tol );
	int HYPRE_StructPCGSetMaxIter ( HYPRE_StructSolver solver , int max_iter );
	int HYPRE_StructPCGSetTwoNorm ( HYPRE_StructSolver solver , int two_norm );
	int HYPRE_StructPCGSetRelChange ( HYPRE_StructSolver solver , int rel_change );
	//int HYPRE_StructPCGSetPrecond ( HYPRE_StructSolver solver , HYPRE_PtrToStructSolverFcn precond , HYPRE_PtrToStructSolverFcn precond_setup , HYPRE_StructSolver precond_solver );
	int HYPRE_StructPCGSetLogging ( HYPRE_StructSolver solver , int logging );
	int HYPRE_StructPCGSetPrintLevel ( HYPRE_StructSolver solver , int print_level );
	unsafe int HYPRE_StructPCGGetNumIterations ( HYPRE_StructSolver solver , int* num_iterations );
	unsafe int HYPRE_StructPCGGetFinalRelativeResidualNorm ( HYPRE_StructSolver solver , double* norm );
	int HYPRE_StructDiagScaleSetup ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector y , hypre_StructVector x );
	int HYPRE_StructDiagScale ( HYPRE_StructSolver solver , hypre_StructMatrix HA , hypre_StructVector Hy , hypre_StructVector Hx );
	
	//Method LGMRES
	int HYPRE_StructLGMRESCreate ( Intracommunicator comm , HYPRE_StructSolver solver );
	int HYPRE_StructLGMRESDestroy ( HYPRE_StructSolver solver );
	int HYPRE_StructLGMRESSetup ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructLGMRESSolve ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructLGMRESSetTol ( HYPRE_StructSolver solver , double tol );
	int HYPRE_StructLGMRESSetAbsoluteTol ( HYPRE_StructSolver solver , double tol );
	int HYPRE_StructLGMRESSetMaxIter ( HYPRE_StructSolver solver , int max_iter );
	int HYPRE_StructLGMRESSetKDim ( HYPRE_StructSolver solver , int k_dim );
	int HYPRE_StructLGMRESSetAugDim ( HYPRE_StructSolver solver , int aug_dim );
	//int HYPRE_StructLGMRESSetPrecond ( HYPRE_StructSolver solver , HYPRE_PtrToStructSolverFcn precond , HYPRE_PtrToStructSolverFcn precond_setup , HYPRE_StructSolver precond_solver );
	int HYPRE_StructLGMRESSetLogging ( HYPRE_StructSolver solver , int logging );
	int HYPRE_StructLGMRESSetPrintLevel ( HYPRE_StructSolver solver , int print_level );
	unsafe int HYPRE_StructLGMRESGetNumIterations ( HYPRE_StructSolver solver , int* num_iterations );
	unsafe int HYPRE_StructLGMRESGetFinalRelativeResidualNorm ( HYPRE_StructSolver solver , double* norm );
	
	//Method GMRES
	int HYPRE_StructGMRESCreate ( Intracommunicator comm , HYPRE_StructSolver solver );
	int HYPRE_StructGMRESDestroy ( HYPRE_StructSolver solver );
	int HYPRE_StructGMRESSetup ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructGMRESSolve ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructGMRESSetTol ( HYPRE_StructSolver solver , double tol );
	int HYPRE_StructGMRESSetAbsoluteTol ( HYPRE_StructSolver solver , double atol );
	int HYPRE_StructGMRESSetMaxIter ( HYPRE_StructSolver solver , int max_iter );
	int HYPRE_StructGMRESSetKDim ( HYPRE_StructSolver solver , int k_dim );
	//int HYPRE_StructGMRESSetPrecond ( HYPRE_StructSolver solver , HYPRE_PtrToStructSolverFcn precond , HYPRE_PtrToStructSolverFcn precond_setup , HYPRE_StructSolver precond_solver );
	int HYPRE_StructGMRESSetLogging ( HYPRE_StructSolver solver , int logging );
	int HYPRE_StructGMRESSetPrintLevel ( HYPRE_StructSolver solver , int print_level );
	unsafe int HYPRE_StructGMRESGetNumIterations ( HYPRE_StructSolver solver , int* num_iterations );
	unsafe int HYPRE_StructGMRESGetFinalRelativeResidualNorm ( HYPRE_StructSolver solver , double* norm );
	
	//Method BiCGSTAB
	int HYPRE_StructBiCGSTABCreate ( Intracommunicator comm , HYPRE_StructSolver solver );
	int HYPRE_StructBiCGSTABDestroy ( HYPRE_StructSolver solver );
	int HYPRE_StructBiCGSTABSetup ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructBiCGSTABSolve ( HYPRE_StructSolver solver , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	int HYPRE_StructBiCGSTABSetTol ( HYPRE_StructSolver solver , double tol );
	int HYPRE_StructBiCGSTABSetAbsoluteTol ( HYPRE_StructSolver solver , double tol );
	int HYPRE_StructBiCGSTABSetMaxIter ( HYPRE_StructSolver solver , int max_iter );
	//int HYPRE_StructBiCGSTABSetPrecond ( HYPRE_StructSolver solver , HYPRE_PtrToStructSolverFcn precond , HYPRE_PtrToStructSolverFcn precond_setup , HYPRE_StructSolver precond_solver );
	int HYPRE_StructBiCGSTABSetLogging ( HYPRE_StructSolver solver , int logging );
	int HYPRE_StructBiCGSTABSetPrintLevel ( HYPRE_StructSolver solver , int level );
	unsafe int HYPRE_StructBiCGSTABGetNumIterations ( HYPRE_StructSolver solver , int* num_iterations );
	unsafe int HYPRE_StructBiCGSTABGetFinalRelativeResidualNorm ( HYPRE_StructSolver solver , double* norm );
	unsafe int HYPRE_StructBiCGSTABGetResidual ( HYPRE_StructSolver solver , void** residual );
	
	//Method Hybrid
	unsafe void* hypre_HybridCreate ( Intracommunicator comm );
	unsafe int hypre_HybridDestroy ( void* hybrid_vdata );
	unsafe int hypre_HybridSetTol ( void* hybrid_vdata , double tol );
	unsafe int hypre_HybridSetConvergenceTol ( void* hybrid_vdata , double cf_tol );
	unsafe int hypre_HybridSetDSCGMaxIter ( void* hybrid_vdata , int dscg_max_its );
	unsafe int hypre_HybridSetPCGMaxIter ( void* hybrid_vdata , int pcg_max_its );
	unsafe int hypre_HybridSetPCGAbsoluteTolFactor ( void* hybrid_vdata , double pcg_atolf );
	unsafe int hypre_HybridSetTwoNorm ( void* hybrid_vdata , int two_norm );
	unsafe int hypre_HybridSetStopCrit ( void* hybrid_vdata , int stop_crit );
	unsafe int hypre_HybridSetRelChange ( void* hybrid_vdata , int rel_change );
	unsafe int hypre_HybridSetSolverType ( void* hybrid_vdata , int solver_type );
	unsafe int hypre_HybridSetKDim ( void* hybrid_vdata , int k_dim );
	//int hypre_HybridSetPrecond ( void* pcg_vdata , int (*pcg_precond_solve )(), int (*pcg_precond_setup )(), void* pcg_precond );
	unsafe int hypre_HybridSetLogging ( void* hybrid_vdata , int logging );
	unsafe int hypre_HybridSetPrintLevel ( void* hybrid_vdata , int print_level );
	unsafe int hypre_HybridGetNumIterations ( void* hybrid_vdata , int* num_its );
	unsafe int hypre_HybridGetDSCGNumIterations ( void* hybrid_vdata , int* dscg_num_its );
	unsafe int hypre_HybridGetPCGNumIterations ( void* hybrid_vdata , int* pcg_num_its );
	unsafe int hypre_HybridGetFinalRelativeResidualNorm ( void* hybrid_vdata , double* final_rel_res_norm );
	unsafe int hypre_HybridSetup ( void* hybrid_vdata , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	unsafe int hypre_HybridSolve ( void* hybrid_vdata , hypre_StructMatrix A , hypre_StructVector b , hypre_StructVector x );
	
	

} // end main interface 

} // end namespace 
