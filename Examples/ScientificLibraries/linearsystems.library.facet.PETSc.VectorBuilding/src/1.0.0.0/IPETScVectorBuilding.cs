using br.ufc.hpe.kinds;
using linearsystems.qualifier.PETSc;
using linearsystems.library.facet.VectorBuilding;
using MPI;

namespace linearsystems.library.facet.PETSc.VectorBuilding {
   
 using PetscInt = System.Int32;
  using PetscMPIInt = System.Int32;
  using PetscScalar = System.Int32;
  using PetscReal = System.Single;
  using PetscLogDouble = System.Double;
  using PetscCookie = System.Int32;
  using PetscErrorCode = System.Int32;
  using VecType = System.String;

public interface IPETScVectorBuilding<L> : BaseIPETScVectorBuilding<L>, IVectorBuildingFacet<L>
where L:IPETSc
{
   
	PetscErrorCode  VecInitializePackage(char[] a);
	PetscErrorCode  VecFinalizePackage();
	
	PetscErrorCode  VecCreate(Intracommunicator a,Vec b);
	//PetscPolymorphicSubroutine(VecCreate,(Vec a),(PETSC_COMM_SELF,x))
	PetscErrorCode  VecCreateSeq(Intracommunicator a,PetscInt b,Vec c);
	//PetscPolymorphicSubroutine(VecCreateSeq,(PetscInt n,Vec *x),(PETSC_COMM_SELF,n,x))
	PetscErrorCode  VecCreateMPI(Intracommunicator a,PetscInt b,PetscInt c,Vec d);
	//PetscPolymorphicSubroutine(VecCreateMPI,(PetscInt n,PetscInt N,Vec *x),(PETSC_COMM_WORLD,n,N,x))
	PetscErrorCode  VecCreateSeqWithArray(Intracommunicator a,PetscInt b,PetscScalar[] c,Vec d);
	//PetscPolymorphicSubroutine(VecCreateSeqWithArray,(PetscInt n,PetscScalar s[],Vec *x),(PETSC_COMM_SELF,n,s,x))
	PetscErrorCode  VecCreateMPIWithArray(Intracommunicator a,PetscInt b,PetscInt c,PetscScalar[] d,Vec e);
	//PetscPolymorphicSubroutine(VecCreateMPIWithArray,(PetscInt n,PetscInt N,PetscScalar s[],Vec *x),(PETSC_COMM_WORLD,n,N,s,x))
	PetscErrorCode  VecCreateShared(Intracommunicator a,PetscInt b,PetscInt c,Vec d);
	PetscErrorCode  VecSetFromOptions(Vec a);
	PetscErrorCode  VecSetUp(Vec a);
	PetscErrorCode  VecDestroy(Vec a);
	PetscErrorCode  VecZeroEntries(Vec a);
	PetscErrorCode  VecSetOptionsPrefix(Vec a,char[] b);
	PetscErrorCode  VecAppendOptionsPrefix(Vec a,char[] b);
	unsafe PetscErrorCode  VecGetOptionsPrefix(Vec a,char*[] b);
	
	PetscErrorCode  VecSetSizes(Vec a,PetscInt b,PetscInt c);
	
	unsafe PetscErrorCode  VecDotNorm2(Vec a,Vec b,PetscScalar* c,PetscScalar* d);
	unsafe PetscErrorCode  VecDot(Vec a,Vec b,PetscScalar* c);
	//PetscPolymorphicFunction(VecDot,(Vec x,Vec y),(x,y,&s),PetscScalar,s)
	unsafe PetscErrorCode  VecTDot(Vec a,Vec b,PetscScalar* c);  
	//PetscPolymorphicFunction(VecTDot,(Vec x,Vec y),(x,y,&s),PetscScalar,s)
	PetscErrorCode  VecMDot(Vec a,PetscInt b,Vec[] c,PetscScalar[] d);
	PetscErrorCode  VecMTDot(Vec a,PetscInt b,Vec[] c,PetscScalar[] d); 
	
	
	 unsafe PetscErrorCode  VecNorm(Vec a,NormType b,PetscReal* c);
	//PetscPolymorphicSubroutine(VecNorm,(Vec x,PetscReal *r),(x,NORM_2,r))
	//PetscPolymorphicFunction(VecNorm,(Vec x,NormType t),(x,t,&r),PetscReal,r)
	//PetscPolymorphicFunction(VecNorm,(Vec x),(x,NORM_2,&r),PetscReal,r)
	 unsafe PetscErrorCode  VecNormalize(Vec a,PetscReal* b);
	 unsafe PetscErrorCode  VecSum(Vec a,PetscScalar* b);
	 unsafe PetscErrorCode  VecMax(Vec a,PetscInt* b,PetscReal* c);
	//PetscPolymorphicSubroutine(VecMax,(Vec x,PetscReal *r),(x,PETSC_NULL,r))
	 unsafe PetscErrorCode  VecMin(Vec a,PetscInt* b,PetscReal* c);
	//PetscPolymorphicSubroutine(VecMin,(Vec x,PetscReal *r),(x,PETSC_NULL,r))
	 PetscErrorCode  VecScale(Vec a,PetscScalar b);
	 PetscErrorCode  VecCopy(Vec a,Vec b);        
	 PetscErrorCode  VecSetRandom(Vec a,PetscRandom b);
	 PetscErrorCode  VecSet(Vec a,PetscScalar b);
	 PetscErrorCode  VecSwap(Vec a,Vec b);
	 PetscErrorCode  VecAXPY(Vec a,PetscScalar b,Vec c);  
	 PetscErrorCode  VecAXPBY(Vec a,PetscScalar b,PetscScalar c,Vec d);  
	 PetscErrorCode  VecMAXPY(Vec a,PetscInt b,PetscScalar[] c,Vec[] d);
	 PetscErrorCode  VecAYPX(Vec a,PetscScalar b,Vec c);
	 PetscErrorCode  VecWAXPY(Vec a,PetscScalar b,Vec c,Vec d);
	 PetscErrorCode  VecAXPBYPCZ(Vec a,PetscScalar b,PetscScalar c,PetscScalar d,Vec e,Vec f);
	 PetscErrorCode  VecPointwiseMax(Vec a,Vec b,Vec c);    
	//PetscPolymorphicSubroutine(VecPointwiseMax,(Vec x,Vec y),(x,y,y))
	 PetscErrorCode  VecPointwiseMaxAbs(Vec a,Vec b,Vec c);    
	//PetscPolymorphicSubroutine(VecPointwiseMaxAbs,(Vec x,Vec y),(x,y,y))
	 PetscErrorCode  VecPointwiseMin(Vec a,Vec b,Vec c);    
	//PetscPolymorphicSubroutine(VecPointwiseMin,(Vec x,Vec y),(x,y,y))
	 PetscErrorCode  VecPointwiseMult(Vec a,Vec b,Vec c);    
	//PetscPolymorphicSubroutine(VecPointwiseMult,(Vec x,Vec y),(x,x,y))
	 PetscErrorCode  VecPointwiseDivide(Vec a,Vec b,Vec c);    
	//PetscPolymorphicSubroutine(VecPointwiseDivide,(Vec x,Vec y),(x,x,y))
	 unsafe PetscErrorCode  VecMaxPointwiseDivide(Vec a,Vec b,PetscReal* c);    
	 PetscErrorCode  VecShift(Vec a,PetscScalar b);
	 PetscErrorCode  VecReciprocal(Vec a);
	 PetscErrorCode  VecPermute(Vec a, IS b, PetscTruth c);
	 PetscErrorCode  VecSqrt(Vec a);
	 PetscErrorCode  VecLog(Vec a);
	 PetscErrorCode  VecExp(Vec a);
	 PetscErrorCode  VecAbs(Vec a);
	 PetscErrorCode  VecDuplicate(Vec a,Vec b);          
	 PetscErrorCode  VecDuplicateVecs(Vec a,PetscInt b,Vec[] c);         
	 PetscErrorCode  VecDestroyVecs(Vec[] a,PetscInt b); 
	 PetscErrorCode  VecStrideNormAll(Vec a,NormType b, PetscReal[] c);
	 PetscErrorCode  VecStrideMaxAll(Vec a,PetscInt[] b,PetscReal[] c);
	 PetscErrorCode  VecStrideMinAll(Vec a,PetscInt[] b,PetscReal[] c);
	 PetscErrorCode  VecStrideScaleAll(Vec a,PetscScalar[] b);
	
	 unsafe PetscErrorCode  VecStrideNorm(Vec a,PetscInt b,NormType c,PetscReal* d);
	//PetscPolymorphicFunction(VecStrideNorm,(Vec x,PetscInt i),(x,i,NORM_2,&r),PetscReal,r)
	//PetscPolymorphicFunction(VecStrideNorm,(Vec x,PetscInt i,NormType t),(x,i,t,&r),PetscReal,r)
	 unsafe PetscErrorCode  VecStrideMax(Vec a,PetscInt b,PetscInt* c,PetscReal* d);
	//PetscPolymorphicFunction(VecStrideMax,(Vec x,PetscInt i),(x,i,PETSC_NULL,&r),PetscReal,r)
	 unsafe PetscErrorCode  VecStrideMin(Vec a,PetscInt b,PetscInt* c,PetscReal* d);
	//PetscPolymorphicFunction(VecStrideMin,(Vec x,PetscInt i),(x,i,PETSC_NULL,&r),PetscReal,r)
	 PetscErrorCode  VecStrideScale(Vec a,PetscInt b,PetscScalar c);
	
	
	 PetscErrorCode  VecStrideGather(Vec a,PetscInt b,Vec c,InsertMode d);
	 PetscErrorCode  VecStrideScatter(Vec a,PetscInt b,Vec c,InsertMode d);
	 PetscErrorCode  VecStrideGatherAll(Vec a,Vec[] b,InsertMode c);
	 PetscErrorCode  VecStrideScatterAll(Vec[] a,Vec b,InsertMode c);
	
	 PetscErrorCode  VecSetValues(Vec a,PetscInt b,PetscInt[] c,PetscScalar[] d,InsertMode e);
	 PetscErrorCode  VecGetValues(Vec a,PetscInt b,PetscInt[] c,PetscScalar[] d);
	 PetscErrorCode  VecAssemblyBegin(Vec a);
	 PetscErrorCode  VecAssemblyEnd(Vec a);
	 PetscErrorCode  VecStashSetInitialSize(Vec a,PetscInt b,PetscInt c);
	 PetscErrorCode  VecStashView(Vec a,PetscViewer b);
	 unsafe PetscErrorCode  VecStashGetInfo(Vec a,PetscInt* b,PetscInt* c,PetscInt* d,PetscInt* e);
	 
	 
	 PetscErrorCode  VecSetBlockSize(Vec a,PetscInt b);
	 unsafe PetscErrorCode  VecGetBlockSize(Vec a,PetscInt* b);
	//PetscPolymorphicFunction(VecGetBlockSize,(Vec x),(x,&i),PetscInt,i)
	 PetscErrorCode  VecSetValuesBlocked(Vec a,PetscInt b,PetscInt[] c,PetscScalar[] d,InsertMode e);
	
	/* Dynamic creation and loading functions */
	
	 PetscErrorCode  VecSetType(Vec a, VecType b);
	 PetscErrorCode  VecGetType(Vec a, VecType c);
	 //preciso ver isso PetscErrorCode  VecRegister(char[] a,char[] b,char[] c,PetscErrorCode (*)(Vec));
	 PetscErrorCode  VecRegisterAll(char[] b);
	 PetscErrorCode  VecRegisterDestroy();
	
	
	
	
	
	 PetscErrorCode  VecScatterCreate(Vec a,IS b,Vec c,IS d,VecScatter e);
	//PetscPolymorphicFunction(VecScatterCreate,(Vec x,IS is1,Vec y,IS is2),(x,is1,y,is2,&s),VecScatter,s)
	//PetscPolymorphicSubroutine(VecScatterCreate,(Vec x,IS is,Vec y,VecScatter *s),(x,is,y,PETSC_NULL,s))
	//PetscPolymorphicFunction(VecScatterCreate,(Vec x,IS is,Vec y),(x,is,y,PETSC_NULL,&s),VecScatter,s)
	//PetscPolymorphicSubroutine(VecScatterCreate,(Vec x,Vec y,IS is,VecScatter *s),(x,PETSC_NULL,y,is,s))
	//PetscPolymorphicFunction(VecScatterCreate,(Vec x,Vec y,IS is),(x,PETSC_NULL,y,is,&s),VecScatter,s)
	 PetscErrorCode  VecScatterCreateEmpty(Intracommunicator a,VecScatter b);
	 PetscErrorCode  VecScatterCreateLocal(VecScatter a,PetscInt b,PetscInt[] c,PetscInt[] d,PetscInt[] e,PetscInt f,PetscInt[] g,PetscInt[] h,PetscInt[] i,PetscInt j);
	 PetscErrorCode  VecScatterBegin(VecScatter a,Vec b,Vec c,InsertMode d,ScatterMode e);
	 PetscErrorCode  VecScatterEnd(VecScatter a,Vec b,Vec c,InsertMode d,ScatterMode e); 
	 PetscErrorCode  VecScatterDestroy(VecScatter a);
	 PetscErrorCode  VecScatterCopy(VecScatter a,VecScatter b);
	 PetscErrorCode  VecScatterView(VecScatter a,PetscViewer b);
	 unsafe PetscErrorCode  VecScatterRemap(VecScatter a,PetscInt* b,PetscInt* c);
	 PetscErrorCode  VecScatterGetMerged(VecScatter a,PetscTruth b);
	
	 unsafe PetscErrorCode  VecGetArray_Private(Vec a,PetscScalar*[] b);
	 unsafe PetscErrorCode  VecRestoreArray_Private(Vec a,PetscScalar*[] b);
	 unsafe PetscErrorCode  VecGetArray4d(Vec a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt f,PetscInt g,PetscInt h,PetscInt i,PetscScalar****[] j);
	 unsafe PetscErrorCode  VecRestoreArray4d(Vec a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt f,PetscInt g,PetscInt h,PetscInt i,PetscScalar****[] j);
	 unsafe PetscErrorCode  VecGetArray3d(Vec a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt f,PetscInt g,PetscScalar***[] h);
	 unsafe PetscErrorCode  VecRestoreArray3d(Vec a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt f,PetscInt g,PetscScalar***[] h);
	 unsafe PetscErrorCode  VecGetArray2d(Vec a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscScalar**[] f);
	 unsafe PetscErrorCode  VecRestoreArray2d(Vec a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscScalar**[] f);
	 unsafe PetscErrorCode  VecGetArray1d(Vec a,PetscInt b,PetscInt c,PetscScalar*[] d);
	 unsafe PetscErrorCode  VecRestoreArray1d(Vec a,PetscInt b,PetscInt c,PetscScalar*[] d);
	
	 PetscErrorCode  VecPlaceArray(Vec a,PetscScalar[] b);
	 PetscErrorCode  VecResetArray(Vec a);
	 PetscErrorCode  VecReplaceArray(Vec a,PetscScalar[] b);
	 unsafe PetscErrorCode  VecGetArrays(Vec[] a,PetscInt b,PetscScalar**[] c);
	 unsafe PetscErrorCode  VecRestoreArrays(Vec[] a,PetscInt b, PetscScalar**[] c);
	
	 PetscErrorCode  VecValid(Vec a,PetscTruth b);
	 PetscErrorCode  VecView(Vec a,PetscViewer b);
	 PetscErrorCode  VecViewFromOptions(Vec a,string b);
	 unsafe PetscErrorCode  VecEqual(Vec a,Vec b,PetscTruth* c);
	//PetscPolymorphicFunction(VecEqual,(Vec x,Vec y),(x,y,&s),PetscTruth,s)
	 PetscErrorCode  VecLoad(PetscViewer a,VecType b,Vec c);
	 PetscErrorCode  VecLoadIntoVector(PetscViewer a,Vec b);
	
	 unsafe PetscErrorCode  VecGetSize(Vec a,PetscInt* b);
	//PetscPolymorphicFunction(VecGetSize,(Vec x),(x,&s),PetscInt,s)
	 unsafe PetscErrorCode  VecGetLocalSize(Vec a,PetscInt* b);
	//PetscPolymorphicFunction(VecGetLocalSize,(Vec x),(x,&s),PetscInt,s)
	 unsafe PetscErrorCode  VecGetOwnershipRange(Vec a,PetscInt* b,PetscInt* c);
	 unsafe PetscErrorCode  VecGetOwnershipRanges(Vec a,PetscInt*[] b);
	
	 PetscErrorCode  VecSetLocalToGlobalMapping(Vec a,ISLocalToGlobalMapping b);
	 PetscErrorCode  VecSetValuesLocal(Vec a,PetscInt e,PetscInt[] b,PetscScalar[] c,InsertMode d);
      
      PetscErrorCode  VecSetLocalToGlobalMappingBlock(Vec a,ISLocalToGlobalMapping b);
	 PetscErrorCode  VecSetValuesBlockedLocal(Vec a,PetscInt b,PetscInt[] c,PetscScalar[] d,InsertMode e);
	
	 unsafe PetscErrorCode  VecDotBegin(Vec a,Vec b,PetscScalar* c);
	//PetscPolymorphicSubroutine(VecDotBegin,(Vec x,Vec y),(x,y,PETSC_NULL))
	unsafe PetscErrorCode  VecDotEnd(Vec a,Vec b,PetscScalar* d);
	//PetscPolymorphicFunction(VecDotEnd,(Vec x,Vec y),(x,y,&s),PetscScalar,s)
	 unsafe PetscErrorCode  VecTDotBegin(Vec a,Vec b,PetscScalar* c);
	//PetscPolymorphicSubroutine(VecTDotBegin,(Vec x,Vec y),(x,y,PETSC_NULL))
	 unsafe PetscErrorCode  VecTDotEnd(Vec a,Vec b,PetscScalar* c);
	//PetscPolymorphicFunction(VecTDotEnd,(Vec x,Vec y),(x,y,&s),PetscScalar,s)
	 unsafe PetscErrorCode  VecNormBegin(Vec a,NormType b,PetscReal* c);
	//PetscPolymorphicSubroutine(VecNormBegin,(Vec x,NormType t),(x,t,PETSC_NULL))
	//PetscPolymorphicSubroutine(VecNormBegin,(Vec x),(x,NORM_2,PETSC_NULL))
	 unsafe PetscErrorCode  VecNormEnd(Vec a,NormType b,PetscReal* c);
	//PetscPolymorphicFunction(VecNormEnd,(Vec x,NormType t),(x,t,&s),PetscReal,s)
	//PetscPolymorphicFunction(VecNormEnd,(Vec x),(x,NORM_2,&s),PetscReal,s)
	
	 PetscErrorCode  VecMDotBegin(Vec a,PetscInt b,Vec[] c,PetscScalar[] d);
	 PetscErrorCode  VecMDotEnd(Vec a,PetscInt b,Vec[] c,PetscScalar[] d);
	 PetscErrorCode  VecMTDotBegin(Vec a,PetscInt b,Vec[] c,PetscScalar[] d);
	 PetscErrorCode  VecMTDotEnd(Vec a,PetscInt b,Vec[] c,PetscScalar[] d);
	 
	  PetscErrorCode  VecSetOption(Vec a,VecOption b,PetscTruth c);


	
	 PetscErrorCode  VecContourScale(Vec a,PetscReal b,PetscReal c);
	
	
	
	 //preciso ver isso PetscErrorCode  VecSetOperation(Vec,VecOperation,void(*)(void));
	
	
	 PetscErrorCode  VecCreateGhost(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt[] e,Vec f);  
	 PetscErrorCode  VecCreateGhostWithArray(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt[] e,PetscScalar[] f,Vec g);  
	 PetscErrorCode  VecCreateGhostBlock(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt[] f,Vec g);  
	 PetscErrorCode  VecCreateGhostBlockWithArray(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt[] f,PetscScalar[] g,Vec h);  
	 PetscErrorCode  VecGhostGetLocalForm(Vec a,Vec b);
	//PetscPolymorphicFunction(VecGhostGetLocalForm,(Vec x),(x,&s),Vec,s)
	 PetscErrorCode  VecGhostRestoreLocalForm(Vec a,Vec b);
	 PetscErrorCode  VecGhostUpdateBegin(Vec a,InsertMode b,ScatterMode c);
	 PetscErrorCode  VecGhostUpdateEnd(Vec a,InsertMode b,ScatterMode c);
	
	 PetscErrorCode  VecConjugate(Vec a);
	
	 PetscErrorCode  VecScatterCreateToAll(Vec a,VecScatter b,Vec c);
	 PetscErrorCode  VecScatterCreateToZero(Vec a,VecScatter b,Vec c);
	
	 PetscErrorCode  PetscViewerMathematicaGetVector(PetscViewer a, Vec b);
	 PetscErrorCode  PetscViewerMathematicaPutVector(PetscViewer a, Vec b);
	 

} // end main interface 

} // end namespace 
