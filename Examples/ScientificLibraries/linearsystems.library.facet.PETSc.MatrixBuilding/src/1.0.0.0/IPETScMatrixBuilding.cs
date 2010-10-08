using br.ufc.hpe.kinds;
using linearsystems.qualifier.PETSc;
using linearsystems.library.facet.MatrixBuilding;
using MPI;

namespace linearsystems.library.facet.PETSc.MatrixBuilding { 
  using PetscInt = System.Int32;
  using PetscMPIInt = System.Int32;
  using PetscScalar = System.Int32;
  using PetscReal = System.Single;
  using PetscLogDouble = System.Double;
  using PetscCookie = System.Int32;
  using PetscErrorCode = System.Int32;
  using MatSolverPackage = System.String;
  using MatType = System.String;
  using MatScalar = System.Single;

public interface IPETScMatrixBuilding<L> : BaseIPETScMatrixBuilding<L>, IMatrixBuildingFacet<L>
where L:IPETSc
{
	 PetscErrorCode  MatGetFactor(Mat a,MatSolverPackage b,MatFactorType c,Mat d);
	 PetscErrorCode  MatGetFactorAvailable(Mat a,MatSolverPackage b,MatFactorType c,PetscTruth d);
	 PetscErrorCode  MatFactorGetSolverPackage(Mat a,MatSolverPackage b);
	 
	  PetscErrorCode  MatInitializePackage(char[] a);

	 PetscErrorCode  MatCreate(Intracommunicator a,Mat b);
	//PetscPolymorphicFunction(MatCreate,(MPI_Comm comm),(comm,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreate,(),(PETSC_COMM_WORLD,&A),Mat,A)
	 PetscErrorCode  MatSetSizes(Mat a,PetscInt b,PetscInt c,PetscInt d,PetscInt e);
	 PetscErrorCode  MatSetType(Mat a,MatType b);
	 PetscErrorCode  MatSetFromOptions(Mat a);
	 PetscErrorCode  MatSetUpPreallocation(Mat a);
	 PetscErrorCode  MatRegisterAll(char[] a);
	 //preciso ver isso PetscErrorCode  MatRegister(const char[],const char[],const char[],PetscErrorCode(*)(Mat));
	
	 PetscErrorCode  MatSetOptionsPrefix(Mat a,char[] b);
	 PetscErrorCode  MatAppendOptionsPrefix(Mat a,char[] b);
	 unsafe PetscErrorCode  MatGetOptionsPrefix(Mat a,char*[] b);
	 
     PetscErrorCode  MatCreateSeqDense(Intracommunicator a,PetscInt b,PetscInt c,PetscScalar[] d,Mat e);
	 PetscErrorCode  MatCreateMPIDense(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscScalar[] f,Mat g); 
	 PetscErrorCode  MatCreateSeqAIJ(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt[] e,Mat f);
	//PetscPolymorphicFunction(MatCreateSeqAIJ,(PetscInt m,PetscInt n,PetscInt nz,const PetscInt nnz[]),(PETSC_COMM_SELF,m,n,nz,nnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateSeqAIJ,(PetscInt m,PetscInt n,PetscInt nz),(PETSC_COMM_SELF,m,n,nz,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateSeqAIJ,(PetscInt m,PetscInt n,const PetscInt nnz[]),(PETSC_COMM_SELF,m,n,0,nnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateSeqAIJ,(PetscInt m,PetscInt n),(PETSC_COMM_SELF,m,n,0,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicSubroutine(MatCreateSeqAIJ,(PetscInt m,PetscInt n,PetscInt nz,Mat *A),(PETSC_COMM_SELF,m,n,nz,PETSC_NULL,A))
	//PetscPolymorphicSubroutine(MatCreateSeqAIJ,(PetscInt m,PetscInt n,const PetscInt nnz[],Mat *A),(PETSC_COMM_SELF,m,n,0,nnz,A))
	//PetscPolymorphicSubroutine(MatCreateSeqAIJ,(PetscInt m,PetscInt n,Mat *A),(PETSC_COMM_SELF,m,n,0,PETSC_NULL,A))
	 PetscErrorCode  MatCreateMPIAIJ(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt f,PetscInt[] g,PetscInt h,PetscInt[] i,Mat j); 
	//PetscPolymorphicFunction(MatCreateMPIAIJ,(Intracommunicator a comm,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,const PetscInt nnz[],PetscInt onz,const PetscInt onnz[]),(comm,m,n,M,N,nz,nnz,onz,onnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIAIJ,(Intracommunicator a comm,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz),(comm,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIAIJ,(Intracommunicator a comm,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[]),(comm,m,n,M,N,0,nnz,0,onz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIAIJ,(Intracommunicator a comm,PetscInt m,PetscInt n,PetscInt M,PetscInt N),(comm,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicSubroutine(MatCreateMPIAIJ,(Intracommunicator a comm,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz,Mat *A),(comm,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,A))
	//PetscPolymorphicSubroutine(MatCreateMPIAIJ,(Intracommunicator a comm,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[],Mat *A),(comm,m,n,M,N,0,nnz,0,onz,A))
	//PetscPolymorphicSubroutine(MatCreateMPIAIJ,(Intracommunicator a comm,PetscInt m,PetscInt n,PetscInt M,PetscInt N,Mat *A),(comm,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,A))
	//PetscPolymorphicFunction(MatCreateMPIAIJ,(PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,const PetscInt nnz[],PetscInt onz,const PetscInt onnz[]),(PETSC_COMM_WORLD,m,n,M,N,nz,nnz,onz,onnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIAIJ,(PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz),(PETSC_COMM_WORLD,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIAIJ,(PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[]),(PETSC_COMM_WORLD,m,n,M,N,0,nnz,0,onz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIAIJ,(PetscInt m,PetscInt n,PetscInt M,PetscInt N),(PETSC_COMM_WORLD,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicSubroutine(MatCreateMPIAIJ,(PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz,Mat *A),(PETSC_COMM_WORLD,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,A))
	//PetscPolymorphicSubroutine(MatCreateMPIAIJ,(PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[],Mat *A),(PETSC_COMM_WORLD,m,n,M,N,0,nnz,0,onz,A))
	//PetscPolymorphicSubroutine(MatCreateMPIAIJ,(PetscInt m,PetscInt n,PetscInt M,PetscInt N,Mat *A),(PETSC_COMM_WORLD,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,A))
	 PetscErrorCode  MatCreateMPIAIJWithArrays(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt[] g,PetscInt[] h,PetscScalar[] i,Mat j);
	 PetscErrorCode  MatCreateMPIAIJWithSplitArrays(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt[] f,PetscInt[] g,PetscScalar[] h,PetscInt[] i,PetscInt[] j,PetscScalar[] l,Mat m);
	
	 PetscErrorCode  MatCreateMPIRowbs(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt[] e,Mat f); 
	 PetscErrorCode  MatCreateSeqBAIJ(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt[] f,Mat g); 
	//PetscPolymorphicFunction(MatCreateSeqBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt nz,const PetscInt nnz[]),(PETSC_COMM_SELF,bs,m,n,nz,nnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateSeqBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt nz),(PETSC_COMM_SELF,bs,m,n,nz,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateSeqBAIJ,(PetscInt bs,PetscInt m,PetscInt n,const PetscInt nnz[]),(PETSC_COMM_SELF,bs,m,n,0,nnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateSeqBAIJ,(PetscInt bs,PetscInt m,PetscInt n),(PETSC_COMM_SELF,bs,m,n,0,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicSubroutine(MatCreateSeqBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt nz,Mat *A),(PETSC_COMM_SELF,bs,m,n,nz,PETSC_NULL,A))
	//PetscPolymorphicSubroutine(MatCreateSeqBAIJ,(PetscInt bs,PetscInt m,PetscInt n,const PetscInt nnz[],Mat *A),(PETSC_COMM_SELF,bs,m,n,0,nnz,A))
	//PetscPolymorphicSubroutine(MatCreateSeqBAIJ,(PetscInt bs,PetscInt m,PetscInt n,Mat *A),(PETSC_COMM_SELF,bs,m,n,0,PETSC_NULL,A))
	 PetscErrorCode  MatCreateMPIBAIJ(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt f,PetscInt g,PetscInt[] h,PetscInt i,PetscInt[] j,Mat l);
	//PetscPolymorphicFunction(MatCreateMPIBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,const PetscInt nnz[],PetscInt onz,const PetscInt onnz[]),(comm,bs,m,n,M,N,nz,nnz,onz,onnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz),(comm,bs,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[]),(comm,bs,m,n,M,N,0,nnz,0,onz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N),(comm,bs,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicSubroutine(MatCreateMPIBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz,Mat *A),(comm,bs,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,A))
	//PetscPolymorphicSubroutine(MatCreateMPIBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[],Mat *A),(comm,bs,m,n,M,N,0,nnz,0,onz,A))
	//PetscPolymorphicSubroutine(MatCreateMPIBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,Mat *A),(comm,bs,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,A))
	//PetscPolymorphicFunction(MatCreateMPIBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,const PetscInt nnz[],PetscInt onz,const PetscInt onnz[]),(PETSC_COMM_WORLD,bs,m,n,M,N,nz,nnz,onz,onnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz),(PETSC_COMM_WORLD,bs,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[]),(PETSC_COMM_WORLD,bs,m,n,M,N,0,nnz,0,onz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPIBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N),(PETSC_COMM_WORLD,bs,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicSubroutine(MatCreateMPIBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz,Mat *A),(PETSC_COMM_WORLD,bs,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,A))
	//PetscPolymorphicSubroutine(MatCreateMPIBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[],Mat *A),(PETSC_COMM_WORLD,bs,m,n,M,N,0,nnz,0,onz,A))
	//PetscPolymorphicSubroutine(MatCreateMPIBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,Mat *A),(PETSC_COMM_WORLD,bs,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,A))
	 PetscErrorCode  MatCreateMPIAdj(Intracommunicator a,PetscInt b,PetscInt c,PetscInt[] d,PetscInt[] e,PetscInt[] f,Mat g);
	 PetscErrorCode  MatCreateSeqSBAIJ(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt[] f,Mat g); 
	//PetscPolymorphicFunction(MatCreateSeqSBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt nz,const PetscInt nnz[]),(PETSC_COMM_SELF,bs,m,n,nz,nnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateSeqSBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt nz),(PETSC_COMM_SELF,bs,m,n,nz,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateSeqSBAIJ,(PetscInt bs,PetscInt m,PetscInt n,const PetscInt nnz[]),(PETSC_COMM_SELF,bs,m,n,0,nnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateSeqSBAIJ,(PetscInt bs,PetscInt m,PetscInt n),(PETSC_COMM_SELF,bs,m,n,0,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicSubroutine(MatCreateSeqSBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt nz,Mat *A),(PETSC_COMM_SELF,bs,m,n,nz,PETSC_NULL,A))
	//PetscPolymorphicSubroutine(MatCreateSeqSBAIJ,(PetscInt bs,PetscInt m,PetscInt n,const PetscInt nnz[],Mat *A),(PETSC_COMM_SELF,bs,m,n,0,nnz,A))
	//PetscPolymorphicSubroutine(MatCreateSeqSBAIJ,(PetscInt bs,PetscInt m,PetscInt n,Mat *A),(PETSC_COMM_SELF,bs,m,n,0,PETSC_NULL,A))
	 PetscErrorCode  MatCreateMPISBAIJ(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt f,PetscInt g,PetscInt[] h,PetscInt i,PetscInt[] j,Mat l);
	//PetscPolymorphicFunction(MatCreateMPISBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,const PetscInt nnz[],PetscInt onz,const PetscInt onnz[]),(comm,bs,m,n,M,N,nz,nnz,onz,onnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPISBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz),(comm,bs,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPISBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[]),(comm,bs,m,n,M,N,0,nnz,0,onz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPISBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N),(comm,bs,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicSubroutine(MatCreateMPISBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz,Mat *A),(comm,bs,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,A))
	//PetscPolymorphicSubroutine(MatCreateMPISBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[],Mat *A),(comm,bs,m,n,M,N,0,nnz,0,onz,A))
	//PetscPolymorphicSubroutine(MatCreateMPISBAIJ,(Intracommunicator a comm,PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,Mat *A),(comm,bs,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,A))
	//PetscPolymorphicFunction(MatCreateMPISBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,const PetscInt nnz[],PetscInt onz,const PetscInt onnz[]),(PETSC_COMM_WORLD,bs,m,n,M,N,nz,nnz,onz,onnz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPISBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz),(PETSC_COMM_WORLD,bs,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPISBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[]),(PETSC_COMM_WORLD,bs,m,n,M,N,0,nnz,0,onz,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateMPISBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N),(PETSC_COMM_WORLD,bs,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,&A),Mat,A)
	//PetscPolymorphicSubroutine(MatCreateMPISBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,PetscInt nz,PetscInt nnz,Mat *A),(PETSC_COMM_WORLD,bs,m,n,M,N,nz,PETSC_NULL,nnz,PETSC_NULL,A))
	//PetscPolymorphicSubroutine(MatCreateMPISBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,const PetscInt nnz[],const PetscInt onz[],Mat *A),(PETSC_COMM_WORLD,bs,m,n,M,N,0,nnz,0,onz,A))
	//PetscPolymorphicSubroutine(MatCreateMPISBAIJ,(PetscInt bs,PetscInt m,PetscInt n,PetscInt M,PetscInt N,Mat *A),(PETSC_COMM_WORLD,bs,m,n,M,N,0,PETSC_NULL,0,PETSC_NULL,A))
	 unsafe PetscErrorCode  MatCreateShell(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,void* f,Mat g);
	//PetscPolymorphicFunction(MatCreateShell,(Intracommunicator a comm,PetscInt m,PetscInt n,PetscInt M,PetscInt N,void *ctx),(comm,m,n,M,N,ctx,&A),Mat,A)
	//PetscPolymorphicFunction(MatCreateShell,(PetscInt m,PetscInt n,PetscInt M,PetscInt N,void *ctx),(PETSC_COMM_WORLD,m,n,M,N,ctx,&A),Mat,A)
	 //preciso ver issoPetscErrorCode  MatCreateAdic(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,PetscInt,void (*)(void),Mat*);
	 PetscErrorCode  MatCreateNormal(Mat a,Mat b);
	//PetscPolymorphicFunction(MatCreateNormal,(Mat mat),(mat,&A),Mat,A)
	 PetscErrorCode  MatCreateLRC(Mat a,Mat b,Mat c,Mat d);
	 PetscErrorCode  MatCreateIS(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,ISLocalToGlobalMapping f,Mat g);
	 PetscErrorCode  MatCreateSeqCRL(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt[] e,Mat f);
	 PetscErrorCode  MatCreateMPICRL(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt[] e,PetscInt f,PetscInt[] g,Mat h);
	 PetscErrorCode  MatCreateScatter(Intracommunicator a,VecScatter b,Mat c);
	 PetscErrorCode  MatScatterSetVecScatter(Mat a,VecScatter b);
	 PetscErrorCode  MatScatterGetVecScatter(Mat a,VecScatter b);
	 unsafe PetscErrorCode  MatCreateBlockMat(Intracommunicator x,PetscInt a,PetscInt b,PetscInt c,PetscInt d,PetscInt* e,Mat f);
	 PetscErrorCode  MatCompositeAddMat(Mat a,Mat b);
	 PetscErrorCode  MatCompositeMerge(Mat a);
	 PetscErrorCode  MatCreateComposite(Intracommunicator a,PetscInt b,Mat c,Mat d);
	 
	 
	 PetscErrorCode  MatCompositeSetType(Mat a,MatCompositeType b);
	
	 PetscErrorCode  MatCreateSeqFFTW(Intracommunicator a,PetscInt b,PetscInt[] c,Mat d);
	 PetscErrorCode  MatCreateTranspose(Mat a,Mat b);
	
	 PetscErrorCode  MatCreatePython(Intracommunicator a,PetscInt b,PetscInt c,PetscInt d,PetscInt e,char[] f,Mat g);
	 PetscErrorCode  MatPythonSetType(Mat a,char[] b);
	
	
	 PetscErrorCode  MatSetUp(Mat a);
	 PetscErrorCode  MatDestroy(Mat a);
	
	 PetscErrorCode  MatConjugate(Mat a);
	 PetscErrorCode  MatRealPart(Mat a);
	 PetscErrorCode  MatImaginaryPart(Mat a);
	 PetscErrorCode  MatGetDiagonalBlock(Mat a,PetscTruth b,MatReuse c,Mat d);
	
	/* ------------------------------------------------------------*/
	 PetscErrorCode  MatSetValues(Mat a,PetscInt b,PetscInt[] c,PetscInt d,PetscInt[] e,PetscScalar[] f,InsertMode g);
	 PetscErrorCode  MatSetValuesBlocked(Mat a,PetscInt b,PetscInt[] d,PetscInt e,PetscInt[] f,PetscScalar[] g,InsertMode h);
	 PetscErrorCode  MatSetValuesRow(Mat a,PetscInt b,PetscScalar[] c);
	 PetscErrorCode  MatSetValuesRowLocal(Mat a,PetscInt b,PetscScalar[] c);
	 
	 
	 PetscErrorCode  MatSetValuesStencil(Mat a,PetscInt b,MatStencil[] c,PetscInt d,MatStencil[] e,PetscScalar[] f,InsertMode g);
	 PetscErrorCode  MatSetValuesBlockedStencil(Mat a,PetscInt b,MatStencil[] c,PetscInt d,MatStencil[] e,PetscScalar[] f,InsertMode g);
	 PetscErrorCode  MatSetStencil(Mat a,PetscInt b,PetscInt[] c,PetscInt[] d,PetscInt e);
	
	 PetscErrorCode  MatSetColoring(Mat a,ISColoring b);
	 unsafe PetscErrorCode  MatSetValuesAdic(Mat a,void* b);
	 unsafe PetscErrorCode  MatSetValuesAdifor(Mat a,PetscInt b,void* c);
	
	 PetscErrorCode  MatAssemblyBegin(Mat a,MatAssemblyType n);
	 PetscErrorCode  MatAssemblyEnd(Mat a,MatAssemblyType v);
	 PetscErrorCode  MatAssembled(Mat a,PetscTruth b);
	 
	 
	  PetscErrorCode  MatSetOption(Mat a,MatOption b,PetscTruth c);
	 PetscErrorCode  MatGetType(Mat a,MatType b);
	//PetscPolymorphicFunction(MatGetType,(Mat mat),(mat,&t),const MatType,t)
	
	 PetscErrorCode  MatGetValues(Mat a,PetscInt b,PetscInt[] c,PetscInt d,PetscInt[] e,PetscScalar[] f);
	 unsafe PetscErrorCode  MatGetRow(Mat a,PetscInt b,PetscInt* c,PetscInt*[] d,PetscScalar*[] e);
	 unsafe PetscErrorCode  MatRestoreRow(Mat a,PetscInt b,PetscInt* c,PetscInt*[] d,PetscScalar*[] e);
	 PetscErrorCode  MatGetRowUpperTriangular(Mat a);
	 PetscErrorCode  MatRestoreRowUpperTriangular(Mat a);
	 unsafe PetscErrorCode  MatGetColumn(Mat a,PetscInt b,PetscInt* c,PetscInt*[] d,PetscScalar*[] e);
	 unsafe PetscErrorCode  MatRestoreColumn(Mat a,PetscInt b,PetscInt* c,PetscInt*[] d,PetscScalar*[] e);
	 PetscErrorCode  MatGetColumnVector(Mat a,Vec b,PetscInt c);
	 unsafe PetscErrorCode  MatGetArray(Mat a,PetscScalar*[] c);
	//PetscPolymorphicFunction(MatGetArray,(Mat mat),(mat,&a),PetscScalar*,a)
	 unsafe PetscErrorCode  MatRestoreArray(Mat a,PetscScalar*[] b);
	 unsafe PetscErrorCode  MatGetBlockSize(Mat a,PetscInt* b);
	//PetscPolymorphicFunction(MatGetBlockSize,(Mat mat),(mat,&a),PetscInt,a)
	 PetscErrorCode  MatSetBlockSize(Mat a,PetscInt b);
	
	
	 PetscErrorCode  MatMult(Mat a,Vec b,Vec c);
	 PetscErrorCode  MatMultAdd(Mat a,Vec b,Vec c,Vec d);
	//PetscPolymorphicSubroutine(MatMultAdd,(Mat A,Vec x,Vec y),(A,x,y,y))
	 PetscErrorCode  MatMultTranspose(Mat a,Vec b,Vec c);
	 PetscErrorCode  MatIsTranspose(Mat a,Mat b,PetscReal c,PetscTruth d);
	//PetscPolymorphicFunction(MatIsTranspose,(Mat A,Mat B,PetscReal tol),(A,B,tol,&t),PetscTruth,t)
	//PetscPolymorphicFunction(MatIsTranspose,(Mat A,Mat B),(A,B,0,&t),PetscTruth,t)
	 PetscErrorCode  MatIsHermitianTranspose(Mat a,Mat b,PetscReal c,PetscTruth d);
	 PetscErrorCode  MatMultTransposeAdd(Mat a,Vec b,Vec c,Vec d);
	//PetscPolymorphicSubroutine(MatMultTransposeAdd,(Mat A,Vec x,Vec y),(A,x,y,y))
	 PetscErrorCode  MatMultConstrained(Mat a,Vec b,Vec c);
	 PetscErrorCode  MatMultTransposeConstrained(Mat a,Vec b,Vec c);
	 PetscErrorCode  MatMatSolve(Mat a,Mat b,Mat c);
	 
	 
	  PetscErrorCode  MatConvert(Mat a,MatType b,MatReuse c,Mat d);
	//PetscPolymorphicFunction(MatConvert,(Mat A,const MatType t),(A,t,MAT_INITIAL_MATRIX,&a),Mat,a)
	 PetscErrorCode  MatDuplicate(Mat a,MatDuplicateOption b,Mat c);
	//PetscPolymorphicFunction(MatDuplicate,(Mat A,MatDuplicateOption o),(A,o,&a),Mat,a)
	//PetscPolymorphicFunction(MatDuplicate,(Mat A),(A,MAT_COPY_VALUES,&a),Mat,a)
	
	
	 PetscErrorCode  MatCopy(Mat a,Mat b,MatStructure c);
	 PetscErrorCode  MatView(Mat a,PetscViewer b);
	 PetscErrorCode  MatIsSymmetric(Mat a,PetscReal b,PetscTruth c);
	//PetscPolymorphicFunction(MatIsSymmetric,(Mat A,PetscReal tol),(A,tol,&t),PetscTruth,t)
	//PetscPolymorphicFunction(MatIsSymmetric,(Mat A),(A,0,&t),PetscTruth,t)
	 PetscErrorCode  MatIsStructurallySymmetric(Mat a,PetscTruth b);
	//PetscPolymorphicFunction(MatIsStructurallySymmetric,(Mat A),(A,&t),PetscTruth,t)
	 PetscErrorCode  MatIsHermitian(Mat a,PetscReal b,PetscTruth c);
	//PetscPolymorphicFunction(MatIsHermitian,(Mat A),(A,0,&t),PetscTruth,t)
	 PetscErrorCode  MatIsSymmetricKnown(Mat a,PetscTruth b,PetscTruth c);
	 PetscErrorCode  MatIsHermitianKnown(Mat a,PetscTruth b,PetscTruth c);
	 unsafe PetscErrorCode  MatMissingDiagonal(Mat a,PetscTruth b,PetscInt* c);
	 PetscErrorCode  MatLoad(PetscViewer a,MatType b,Mat c);
	//PetscPolymorphicFunction(MatLoad,(PetscViewer v,const MatType t),(v,t,&a),Mat,a)
	
	 unsafe PetscErrorCode  MatGetRowIJ(Mat a,PetscInt b,PetscTruth c,PetscTruth d,PetscInt* e,PetscInt*[] f,PetscInt*[] g,PetscTruth* h);
	 unsafe PetscErrorCode  MatRestoreRowIJ(Mat a,PetscInt b,PetscTruth c,PetscTruth d,PetscInt* e,PetscInt*[] f,PetscInt*[] g,PetscTruth* h);
	 unsafe PetscErrorCode  MatGetColumnIJ(Mat a,PetscInt b,PetscTruth c,PetscTruth d,PetscInt* e,PetscInt*[] f,PetscInt*[] g,PetscTruth h);
	 unsafe PetscErrorCode  MatRestoreColumnIJ(Mat a,PetscInt b,PetscTruth c,PetscTruth d,PetscInt* e,PetscInt*[] f,PetscInt*[] g,PetscTruth h);
	 
	 
	 PetscErrorCode  MatGetInfo(Mat a,MatInfoType b,MatInfo c);
	 PetscErrorCode  MatValid(Mat a,PetscTruth b);
	 PetscErrorCode  MatGetDiagonal(Mat a,Vec b);
	 PetscErrorCode  MatGetRowMax(Mat a,Vec b,PetscInt[] c);
	 PetscErrorCode  MatGetRowMin(Mat a,Vec b,PetscInt[] c);
	 PetscErrorCode  MatGetRowMaxAbs(Mat a,Vec b,PetscInt[] c);
	 PetscErrorCode  MatGetRowMinAbs(Mat a,Vec b,PetscInt[] c);
	 PetscErrorCode  MatGetRowSum(Mat a,Vec b);
	 PetscErrorCode  MatTranspose(Mat a,MatReuse b,Mat c);
	//PetscPolymorphicFunction(MatTranspose,(Mat A),(A,MAT_INITIAL_MATRIX,&t),Mat,t)
	 PetscErrorCode  MatPermute(Mat a,IS b,IS c,Mat d);
	//PetscPolymorphicFunction(MatPermute,(Mat A,IS is1,IS is2),(A,is1,is2,&t),Mat,t)
	 PetscErrorCode  MatPermuteSparsify(Mat a,PetscInt b,PetscReal c,PetscReal d,IS e,IS f,Mat g);
	 PetscErrorCode  MatDiagonalScale(Mat a,Vec b,Vec c);
	 PetscErrorCode  MatDiagonalSet(Mat a,Vec b,InsertMode c);
	 PetscErrorCode  MatEqual(Mat a,Mat b,PetscTruth c);
	//PetscPolymorphicFunction(MatEqual,(Mat A,Mat B),(A,B,&t),PetscTruth,t)
	 PetscErrorCode  MatMultEqual(Mat a,Mat x,PetscInt b,PetscTruth c);
	 PetscErrorCode  MatMultAddEqual(Mat a,Mat b,PetscInt c,PetscTruth d);
	 PetscErrorCode  MatMultTransposeEqual(Mat a,Mat b,PetscInt c,PetscTruth d);
	 PetscErrorCode  MatMultTransposeAddEqual(Mat a,Mat b,PetscInt c,PetscTruth d);
	
	 unsafe PetscErrorCode  MatNorm(Mat a,NormType b,PetscReal* c);
	//PetscPolymorphicFunction(MatNorm,(Mat A,NormType t),(A,t,&n),PetscReal,n)
	 PetscErrorCode  MatZeroEntries(Mat a);
	 PetscErrorCode  MatZeroRows(Mat a,PetscInt b,PetscInt[] c,PetscScalar d);
	 PetscErrorCode  MatZeroRowsIS(Mat a,IS b,PetscScalar c);
	 unsafe PetscErrorCode  MatZeroColumns(Mat a,PetscInt b,PetscInt[] c,PetscScalar* d);
	 unsafe PetscErrorCode  MatZeroColumnsIS(Mat a,IS b,PetscScalar* c);
	
	 PetscErrorCode  MatUseScaledForm(Mat a,PetscTruth b);
	 PetscErrorCode  MatScaleSystem(Mat a,Vec b,Vec c);
	 PetscErrorCode  MatUnScaleSystem(Mat a,Vec b,Vec c);
	
	 unsafe PetscErrorCode  MatGetSize(Mat a,PetscInt* b,PetscInt* c);
	 unsafe PetscErrorCode  MatGetLocalSize(Mat a,PetscInt* b,PetscInt* c);
	 unsafe PetscErrorCode  MatGetOwnershipRange(Mat a,PetscInt* b,PetscInt* c);
	 unsafe PetscErrorCode  MatGetOwnershipRanges(Mat a,PetscInt** b);
	 unsafe PetscErrorCode  MatGetOwnershipRangeColumn(Mat a,PetscInt* b,PetscInt* c);
	 unsafe PetscErrorCode  MatGetOwnershipRangesColumn(Mat a,PetscInt** b);
	
	 PetscErrorCode  MatGetSubMatrices(Mat a,PetscInt b,IS[] c,IS[] d,MatReuse e,Mat[] f);
	 PetscErrorCode  MatDestroyMatrices(PetscInt a,Mat[] b);
	 PetscErrorCode  MatGetSubMatrix(Mat a,IS b,IS c,PetscInt d,MatReuse e,Mat f);
	 PetscErrorCode  MatGetSubMatrixRaw(Mat a,PetscInt b,PetscInt[] c,PetscInt d,PetscInt[] e,PetscInt f,MatReuse g,Mat h);
	 PetscErrorCode  MatGetSeqNonzeroStructure(Mat a,Mat[] b);
	 PetscErrorCode  MatDestroySeqNonzeroStructure(Mat[] a); 
	
	 PetscErrorCode  MatMerge(Intracommunicator comm,Mat a,PetscInt b,MatReuse c,Mat d);
	 PetscErrorCode  MatMerge_SeqsToMPI(Intracommunicator comm,Mat a,PetscInt b,PetscInt c,MatReuse d,Mat e);
	 PetscErrorCode  MatMerge_SeqsToMPISymbolic(Intracommunicator comm,Mat a,PetscInt b,PetscInt c,Mat d);
	 PetscErrorCode  MatMerge_SeqsToMPINumeric(Mat a,Mat b); 
	 PetscErrorCode  MatDestroy_MPIAIJ_SeqsToMPI(Mat a);
	 PetscErrorCode  MatGetLocalMat(Mat a,MatReuse b,Mat c);
	 PetscErrorCode  MatGetLocalMatCondensed(Mat a,MatReuse b,IS c,IS d,Mat e);
	 PetscErrorCode  MatGetBrowsOfAcols(Mat a,Mat b,MatReuse c,IS d,IS e,PetscInt f,Mat g);
	 unsafe PetscErrorCode  MatGetBrowsOfAoCols(Mat a,Mat b,MatReuse c,PetscInt** d,MatScalar** f,Mat g);
	 unsafe PetscErrorCode  MatGetCommunicationStructs(Mat a, Vec b, PetscInt*[] c, VecScatter d);
	
	
	 PetscErrorCode  MatIncreaseOverlap(Mat a,PetscInt b,IS[] c,PetscInt d);
	
	 PetscErrorCode  MatMatMult(Mat a,Mat b,MatReuse c,PetscReal d,Mat e);
	 PetscErrorCode  MatMatMultSymbolic(Mat a,Mat b,PetscReal c,Mat d);
	 PetscErrorCode  MatMatMultNumeric(Mat a,Mat b,Mat c);
	
	 PetscErrorCode  MatPtAP(Mat a,Mat b,MatReuse c,PetscReal d,Mat e);
	 PetscErrorCode  MatPtAPSymbolic(Mat a,Mat b,PetscReal c,Mat d);
	 PetscErrorCode  MatPtAPNumeric(Mat a,Mat b,Mat c);
	
	 PetscErrorCode  MatMatMultTranspose(Mat a,Mat b,MatReuse c,PetscReal e,Mat f);
	 PetscErrorCode  MatMatMultTransposeSymbolic(Mat a,Mat b,PetscReal c,Mat d);
	 PetscErrorCode  MatMatMultTransposeNumeric(Mat a,Mat b,Mat c);
	
	 PetscErrorCode  MatAXPY(Mat a,PetscScalar b,Mat c,MatStructure d);
	 PetscErrorCode  MatAYPX(Mat a,PetscScalar b,Mat c,MatStructure d);
	 PetscErrorCode  MatCompress(Mat a);
	
	 PetscErrorCode  MatScale(Mat a,PetscScalar b);
	 PetscErrorCode  MatShift(Mat a,PetscScalar b);
	
	 PetscErrorCode  MatSetLocalToGlobalMapping(Mat a,ISLocalToGlobalMapping b);
	 PetscErrorCode  MatSetLocalToGlobalMappingBlock(Mat a,ISLocalToGlobalMapping b);
	 PetscErrorCode  MatZeroRowsLocal(Mat a,PetscInt b,PetscInt[] c,PetscScalar d);
	 PetscErrorCode  MatZeroRowsLocalIS(Mat a,IS b,PetscScalar c);
	 PetscErrorCode  MatSetValuesLocal(Mat a,PetscInt b,PetscInt[] c,PetscInt d,PetscInt[] e,PetscScalar[] f,InsertMode g);
	 PetscErrorCode  MatSetValuesBlockedLocal(Mat a,PetscInt b,PetscInt[] c,PetscInt d,PetscInt[] e,PetscScalar[] f,InsertMode g);
	
	 PetscErrorCode  MatStashSetInitialSize(Mat a,PetscInt b,PetscInt c);
	 unsafe PetscErrorCode  MatStashGetInfo(Mat a,PetscInt* b,PetscInt* c,PetscInt* d,PetscInt* e);
	
	 PetscErrorCode  MatInterpolate(Mat a,Vec b,Vec c);
	 PetscErrorCode  MatInterpolateAdd(Mat a,Vec b,Vec c,Vec d);
	//PetscPolymorphicSubroutine(MatInterpolateAdd,(Mat A,Vec x,Vec y),(A,x,y,y))
	 PetscErrorCode  MatRestrict(Mat a,Vec b,Vec c);
	 PetscErrorCode  MatGetVecs(Mat a,Vec b,Vec c);
	 PetscErrorCode  MatGetRedundantMatrix(Mat a,PetscInt b,Intracommunicator comm,PetscInt d,MatReuse e,Mat f);
		 
	 
	 
	 

} // end main interface 

} // end namespace 
