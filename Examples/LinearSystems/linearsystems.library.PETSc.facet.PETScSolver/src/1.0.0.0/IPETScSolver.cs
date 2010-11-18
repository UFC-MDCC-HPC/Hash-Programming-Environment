using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.facet.LSSFacetSolver;
using linearsystems.library.PETSc;

namespace linearsystems.library.PETSc.facet.PETScSolver { 

using PetscInt = System.Int32;
using PetscMPIInt = System.Int32;
using PetscScalar = System.Int32;
using PetscReal = System.Single;
using PetscLogDouble = System.Double;
using PetscCookie = System.Int32;
using PetscErrorCode = System.Int32;
using MatSolverPackage = System.String;
using ISColoringValue = System.UInt32;
using MatType = System.String;
using KSPType = System.String;

public interface IPETScSolver : BaseIPETScSolver, IFacetSolver<PETSc>
{
     PetscErrorCode  KSPCreate(Intracommunicator comm,KSP a);
	 PetscErrorCode  KSPSetType(KSP a,KSPType b);
	 PetscErrorCode  KSPSetUp(KSP a);
	 PetscErrorCode  KSPSetUpOnBlocks(KSP a);
	 PetscErrorCode  KSPSolve(KSP a,Vec b,Vec c);
	 PetscErrorCode  KSPSolveTranspose(KSP a,Vec b,Vec c);
	 PetscErrorCode  KSPDestroy(KSP a);
	
	 PetscErrorCode  KSPRegisterAll(char[] a);
	 PetscErrorCode  KSPRegisterDestroy();
	 //PetscErrorCode  KSPRegister(char[] a,char[] b,char[] c,PetscErrorCode (*)(KSP));
	
	 PetscErrorCode  KSPGetType(KSP a,KSPType b);
	 PetscErrorCode  KSPSetPreconditionerSide(KSP a,PCSide b);
	 PetscErrorCode  KSPGetPreconditionerSide(KSP a,PCSide b);
	 unsafe PetscErrorCode  KSPGetTolerances(KSP a,PetscReal* b,PetscReal* c,PetscReal* d,PetscInt* e);
	 PetscErrorCode  KSPSetTolerances(KSP a,PetscReal b,PetscReal c,PetscReal d,PetscInt e);
	 PetscErrorCode  KSPSetInitialGuessNonzero(KSP a,PetscTruth b);
	 PetscErrorCode  KSPGetInitialGuessNonzero(KSP a,PetscTruth b);
	 PetscErrorCode  KSPSetInitialGuessKnoll(KSP a,PetscTruth b);
	 PetscErrorCode  KSPGetInitialGuessKnoll(KSP a,PetscTruth b);
	 PetscErrorCode  KSPGetComputeEigenvalues(KSP a,PetscTruth b);
	 PetscErrorCode  KSPSetComputeEigenvalues(KSP a,PetscTruth b);
	 PetscErrorCode  KSPGetComputeSingularValues(KSP a,PetscTruth b);
	 PetscErrorCode  KSPSetComputeSingularValues(KSP a,PetscTruth b);
	 PetscErrorCode  KSPGetRhs(KSP a,Vec b);
	 PetscErrorCode  KSPGetSolution(KSP a,Vec b);
	 unsafe PetscErrorCode  KSPGetResidualNorm(KSP a,PetscReal* b);
	 unsafe PetscErrorCode  KSPGetIterationNumber(KSP a,PetscInt* v);
	 PetscErrorCode  KSPSetNullSpace(KSP a,MatNullSpace b);
	 PetscErrorCode  KSPGetNullSpace(KSP a,MatNullSpace b);
	 unsafe PetscErrorCode  KSPGetVecs(KSP a,PetscInt b,Vec[] c,PetscInt d,Vec[] e);
	
	 PetscErrorCode  KSPSetPC(KSP a,PC b);
	 PetscErrorCode  KSPGetPC(KSP a,PC b);
	
	 //PetscErrorCode  KSPMonitorSet(KSP a,PetscErrorCode (*)(KSP,PetscInt,PetscReal,void*),void *,PetscErrorCode (*)(void*));
	 PetscErrorCode  KSPMonitorCancel(KSP a);
	 unsafe PetscErrorCode  KSPGetMonitorContext(KSP a,void** b);
	 unsafe PetscErrorCode  KSPGetResidualHistory(KSP a,PetscReal*[] b,PetscInt* c);
	 PetscErrorCode  KSPSetResidualHistory(KSP a,PetscReal[] b,PetscInt c,PetscTruth d);
	
	/* not sure where to put this */
	 PetscErrorCode  PCKSPGetKSP(PC a,KSP b);
	 unsafe PetscErrorCode  PCBJacobiGetSubKSP(PC a,PetscInt* b,PetscInt* c,KSP[] d);
	 unsafe PetscErrorCode  PCASMGetSubKSP(PC a,PetscInt* b,PetscInt* c,KSP[] d);
	 unsafe PetscErrorCode  PCFieldSplitGetSubKSP(PC a,PetscInt* b,KSP[] c);
	
	 PetscErrorCode  PCGalerkinGetKSP(PC a,KSP b);
	
	 PetscErrorCode  KSPBuildSolution(KSP a,Vec b,Vec c);
	 PetscErrorCode  KSPBuildResidual(KSP a,Vec b,Vec c,Vec d);
	
	 PetscErrorCode  KSPRichardsonSetScale(KSP a,PetscReal b);
	 PetscErrorCode  KSPChebychevSetEigenvalues(KSP a,PetscReal b,PetscReal c);
	 unsafe PetscErrorCode  KSPComputeExtremeSingularValues(KSP a,PetscReal* b,PetscReal* c);
	 unsafe PetscErrorCode  KSPComputeEigenvalues(KSP a,PetscInt b,PetscReal* c,PetscReal* d,PetscInt* e);
	 unsafe PetscErrorCode  KSPComputeEigenvaluesExplicitly(KSP a,PetscInt b,PetscReal* c,PetscReal* d);
	
	 PetscErrorCode  KSPGMRESSetRestart(KSP a, PetscInt b);
	 PetscErrorCode  KSPGMRESSetHapTol(KSP a,PetscReal b);
	
	 PetscErrorCode  KSPGMRESSetPreAllocateVectors(KSP a);
	 //PetscErrorCode  KSPGMRESSetOrthogonalization(KSP a,PetscErrorCode (*)(KSP,PetscInt));
	 PetscErrorCode  KSPGMRESModifiedGramSchmidtOrthogonalization(KSP a,PetscInt b);
	 PetscErrorCode  KSPGMRESClassicalGramSchmidtOrthogonalization(KSP a,PetscInt b);
	
	 PetscErrorCode  KSPLGMRESSetAugDim(KSP a,PetscInt b);
	 PetscErrorCode  KSPLGMRESSetConstant(KSP a);
	 
	  PetscErrorCode  KSPGMRESSetCGSRefinementType(KSP a,KSPGMRESCGSRefinementType b);

	 unsafe PetscErrorCode  KSPFGMRESModifyPCNoChange(KSP a,PetscInt b,PetscInt c,PetscReal d,void* f);
	 unsafe PetscErrorCode  KSPFGMRESModifyPCKSP(KSP a,PetscInt b,PetscInt c,PetscReal d,void* e);
	 //PetscErrorCode  KSPFGMRESSetModifyPC(KSP,PetscErrorCode (*)(KSP,PetscInt,PetscInt,PetscReal,void*),void*,PetscErrorCode(*)(void*));
	
	 PetscErrorCode  KSPQCGSetTrustRegionRadius(KSP a,PetscReal b);
	 unsafe PetscErrorCode  KSPQCGGetQuadratic(KSP a,PetscReal* b);
	 unsafe PetscErrorCode  KSPQCGGetTrialStepNorm(KSP a,PetscReal* b);
	
	 PetscErrorCode  KSPBCGSLSetXRes(KSP a,PetscReal b);
	 PetscErrorCode  KSPBCGSLSetPol(KSP a,PetscTruth b);
	 PetscErrorCode  KSPBCGSLSetEll(KSP a,int b);
	
	 PetscErrorCode  KSPSetFromOptions(KSP a);
	 //PetscErrorCode  KSPAddOptionsChecker(PetscErrorCode (*)(KSP));
	
	 unsafe PetscErrorCode  KSPMonitorSingularValue(KSP a,PetscInt b,PetscReal c,void* d);
	 unsafe PetscErrorCode  KSPMonitorDefault(KSP a,PetscInt b,PetscReal c,void* d);
	 unsafe PetscErrorCode  KSPMonitorRange(KSP a,PetscInt b,PetscReal c,void* d);
	 unsafe PetscErrorCode  KSPMonitorTrueResidualNorm(KSP a,PetscInt b,PetscReal c,void* d);
	 unsafe PetscErrorCode  KSPMonitorDefaultShort(KSP a,PetscInt b,PetscReal c,void* d);
	 unsafe PetscErrorCode  KSPMonitorSolution(KSP a,PetscInt b,PetscReal c,void* d);
	 unsafe PetscErrorCode  KSPGMRESMonitorKrylov(KSP a,PetscInt b,PetscReal c,void* d);
	
	 PetscErrorCode  KSPUnwindPreconditioner(KSP a,Vec b,Vec c);
	 PetscErrorCode  KSPDefaultBuildSolution(KSP a,Vec b,Vec c);
	 PetscErrorCode  KSPDefaultBuildResidual(KSP a,Vec b,Vec c,Vec d);
	 PetscErrorCode  KSPInitialResidual(KSP a,Vec b,Vec c,Vec d,Vec e,Vec f);
	
	 PetscErrorCode  KSPSetOperators(KSP a,Mat b,Mat c,MatStructure d);
	 PetscErrorCode  KSPGetOperators(KSP a,Mat b,Mat c,MatStructure d);
	 PetscErrorCode  KSPGetOperatorsSet(KSP a,PetscTruth b,PetscTruth c);
	 PetscErrorCode  KSPSetOptionsPrefix(KSP a,char[] b);
	 PetscErrorCode  KSPAppendOptionsPrefix(KSP a,char[] b);
	 unsafe PetscErrorCode  KSPGetOptionsPrefix(KSP a,char*[] b);
	
	 PetscErrorCode  KSPSetDiagonalScale(KSP a,PetscTruth b);
	 PetscErrorCode  KSPGetDiagonalScale(KSP a,PetscTruth b);
	 PetscErrorCode  KSPSetDiagonalScaleFix(KSP a,PetscTruth b);
	 PetscErrorCode  KSPGetDiagonalScaleFix(KSP a,PetscTruth b);
	
	 PetscErrorCode  KSPView(KSP a,PetscViewer b);
	
	 PetscErrorCode  KSPLSQRSetStandardErrorVec(KSP a,Vec b);
	 PetscErrorCode  KSPLSQRGetStandardErrorVec(KSP a,Vec b);
	 
	 PetscErrorCode  KSPSetNormType(KSP a,KSPNormType b);
	 PetscErrorCode  KSPGetNormType(KSP a,KSPNormType b);
	 PetscErrorCode  KSPSetCheckNormIteration(KSP a,PetscInt b);
	 PetscErrorCode  KSPSetLagNorm(KSP a,PetscTruth b);
	
	 //PetscErrorCode  KSPSetConvergenceTest(KSP,PetscErrorCode (*)(KSP,PetscInt,PetscReal,KSPConvergedReason*,void*),void *,PetscErrorCode (*)(void*));
	 unsafe PetscErrorCode  KSPGetConvergenceContext(KSP a,void** b);
	 unsafe PetscErrorCode  KSPDefaultConverged(KSP a,PetscInt b,PetscReal c,KSPConvergedReason d,void* e);
	 unsafe PetscErrorCode  KSPDefaultConvergedDestroy(void* a);
	 unsafe PetscErrorCode  KSPDefaultConvergedCreate(void** a);
	 PetscErrorCode  KSPDefaultConvergedSetUIRNorm(KSP a);
	 PetscErrorCode  KSPDefaultConvergedSetUMIRNorm(KSP a);
	 unsafe PetscErrorCode  KSPSkipConverged(KSP a,PetscInt b,PetscReal c,KSPConvergedReason d,void* e);
	 PetscErrorCode  KSPGetConvergedReason(KSP a,KSPConvergedReason b);
	
	 PetscErrorCode  KSPComputeExplicitOperator(KSP a,Mat n);
	 PetscErrorCode  KSPCGSetType(KSP a,KSPCGType b);
	
	 PetscErrorCode  KSPNASHSetRadius(KSP a,PetscReal b);
	 unsafe PetscErrorCode  KSPNASHGetNormD(KSP a,PetscReal* b);
	 unsafe PetscErrorCode  KSPNASHGetObjFcn(KSP a,PetscReal* b);
	
	 PetscErrorCode  KSPSTCGSetRadius(KSP a,PetscReal b);
	 unsafe PetscErrorCode  KSPSTCGGetNormD(KSP a,PetscReal* b);
	 unsafe PetscErrorCode  KSPSTCGGetObjFcn(KSP a,PetscReal* b);
	
	 PetscErrorCode  KSPGLTRSetRadius(KSP a,PetscReal b);
	 unsafe PetscErrorCode  KSPGLTRGetNormD(KSP a,PetscReal* b);
	 unsafe PetscErrorCode  KSPGLTRGetObjFcn(KSP a,PetscReal* b);
	 unsafe PetscErrorCode  KSPGLTRGetMinEig(KSP a,PetscReal* b);
	 unsafe PetscErrorCode  KSPGLTRGetLambda(KSP a,PetscReal* b);
	
	 PetscErrorCode  KSPPythonSetType(KSP a,char[] b);
	
	 PetscErrorCode  PCPreSolve(PC a,KSP b);
	 PetscErrorCode  PCPostSolve(PC a,KSP b);
	
	 PetscErrorCode  KSPMonitorLGCreate(char[] a,char[] b,int c,int d,int e,int f,PetscDrawLG g);
	 unsafe PetscErrorCode  KSPMonitorLG(KSP a,PetscInt b,PetscReal c,void* d);
	 PetscErrorCode  KSPMonitorLGDestroy(PetscDrawLG a);
	 PetscErrorCode  KSPMonitorLGTrueResidualNormCreate(Intracommunicator comm,char[] a,char[] b,int c,int d,int e,int f,PetscDrawLG g);
	 unsafe PetscErrorCode  KSPMonitorLGTrueResidualNorm(KSP a,PetscInt b,PetscReal c,void* d);
	 PetscErrorCode  KSPMonitorLGTrueResidualNormDestroy(PetscDrawLG a);
	 PetscErrorCode  KSPMonitorLGRangeCreate(char[] a,char[] b,int c,int d,int e,int f,PetscDrawLG g);
	 unsafe PetscErrorCode  KSPMonitorLGRange(KSP a,PetscInt b,PetscReal c,void* d);
	 PetscErrorCode  KSPMonitorLGRangeDestroy(PetscDrawLG a);
	
	 //preciso ver isso PetscErrorCode  PCShellSetPreSolve(PC,PetscErrorCode (*)(void*,KSP,Vec,Vec));
	 //preciso ver isso PetscErrorCode  PCShellSetPostSolve(PC,PetscErrorCode (*)(void*,KSP,Vec,Vec));
	
	 unsafe PetscErrorCode  MatMFFDKSPMonitor(KSP a,PetscInt b,PetscReal c,void* d);
	 
	 PetscErrorCode  KSPFischerGuessCreate(KSP a,PetscInt b,PetscInt c,KSPFischerGuess d);
	 PetscErrorCode  KSPFischerGuessDestroy(KSPFischerGuess a);
	 PetscErrorCode  KSPFischerGuessReset(KSPFischerGuess a);
	 PetscErrorCode  KSPFischerGuessUpdate(KSPFischerGuess a,Vec b);
	 PetscErrorCode  KSPFischerGuessFormGuess(KSPFischerGuess a,Vec b,Vec c);
	 PetscErrorCode  KSPFischerGuessSetFromOptions(KSPFischerGuess a);
	
	 PetscErrorCode  KSPSetUseFischerGuess(KSP a,PetscInt b,PetscInt c);
	 PetscErrorCode  KSPSetFischerGuess(KSP a,KSPFischerGuess b);
	 PetscErrorCode  KSPGetFischerGuess(KSP a,KSPFischerGuess b);
	
	 PetscErrorCode  MatCreateSchurComplement(Mat a,Mat b,Mat c,Mat d,Mat e);
	 PetscErrorCode  MatSchurComplementGetKSP(Mat a,KSP b);
	 PetscErrorCode  MatSchurComplementUpdate(Mat a,Mat b,Mat c,Mat d,Mat e,MatStructure f);
	 PetscErrorCode  MatSchurComplementGetSubmatrices(Mat a,Mat b,Mat c,Mat d,Mat e);
	 


} // end main interface 

} // end namespace 
