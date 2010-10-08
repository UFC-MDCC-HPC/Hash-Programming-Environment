using br.ufc.hpe.kinds;
using linearsystems.qualifier.Library;
using MPI;
using System.Runtime.InteropServices;

namespace linearsystems.qualifier.PETSc { 

  using PetscInt = System.Int32;
  using PetscMPIInt = System.Int32;
  using PetscScalar = System.Int32;
  using PetscReal = System.Single;
  using PetscLogDouble = System.Double;
  using PetscCookie = System.Int32;
  using PetscErrorCode = System.Int32;
  using MatSolverPackage = System.String;
  using ISColoringValue = System.UInt32;
 
  
  public enum  PetscTruth{
      PETSC_FALSE,
      PETSC_TRUE
  }
  public enum  ScatterMode{
     SCATTER_FORWARD=0, 
     SCATTER_REVERSE=1, 
     SCATTER_FORWARD_LOCAL=2, 
     SCATTER_REVERSE_LOCAL=3, 
     SCATTER_LOCAL=2
  }
  public enum  VecOption{
     VEC_IGNORE_OFF_PROC_ENTRIES,
     VEC_IGNORE_NEGATIVE_INDICES
  }
  public enum  NormType{
     NORM_1=0,
     NORM_2=1,
     NORM_FROBENIUS=2,
     NORM_INFINITY=3,
     NORM_1_AND_2=4
  }
  public enum  InsertMode{
     NOT_SET_VALUES,
     INSERT_VALUES, 
     ADD_VALUES, 
     MAX_VALUES
  }
  public enum  MatFactorType{
     MAT_FACTOR_NONE, 
     MAT_FACTOR_LU, 
     MAT_FACTOR_CHOLESKY, 
     MAT_FACTOR_ILU, 
     MAT_FACTOR_ICC
  }
  public enum  MatCompositeType{
     MAT_COMPOSITE_ADDITIVE,
     MAT_COMPOSITE_MULTIPLICATIVE
  }
  
  public enum  MatReuse{
     MAT_INITIAL_MATRIX,
     MAT_REUSE_MATRIX
  }
  
  public enum  MatAssemblyType{
     MAT_FLUSH_ASSEMBLY=1,
     MAT_FINAL_ASSEMBLY=0
  }
  
  public enum  ISColoringType{
     IS_COLORING_GLOBAL,
     IS_COLORING_GHOSTED
  }
  
  public enum  MatOption{MAT_ROW_ORIENTED,MAT_NEW_NONZERO_LOCATIONS,      
              MAT_SYMMETRIC,          
              MAT_STRUCTURALLY_SYMMETRIC,
              MAT_NEW_DIAGONALS,MAT_IGNORE_OFF_PROC_ENTRIES,
              MAT_NEW_NONZERO_LOCATION_ERR,
              MAT_NEW_NONZERO_ALLOCATION_ERR,MAT_USE_HASH_TABLE,
              MAT_KEEP_ZEROED_ROWS,MAT_IGNORE_ZERO_ENTRIES,
              MAT_USE_INODES,
              MAT_HERMITIAN,
              MAT_SYMMETRY_ETERNAL,
              MAT_USE_COMPRESSEDROW,
              MAT_IGNORE_LOWER_TRIANGULAR,MAT_ERROR_LOWER_TRIANGULAR,
              MAT_GETROW_UPPERTRIANGULAR,MAT_UNUSED_NONZERO_LOCATION_ERR,
              NUM_MAT_OPTIONS}
  
  public enum  MatDuplicateOption{
     MAT_DO_NOT_COPY_VALUES,
     MAT_COPY_VALUES
  }
  
  public enum  MatStructure{
     SAME_NONZERO_PATTERN,
     DIFFERENT_NONZERO_PATTERN,
     SAME_PRECONDITIONER,
     SUBSET_NONZERO_PATTERN
  }
  
  public enum  MatInfoType{
     MAT_LOCAL=1,
     MAT_GLOBAL_MAX=2,
     MAT_GLOBAL_SUM=3
  }
  
  [StructLayout(LayoutKind.Sequential)]
  public class ISColoring {
	  public PetscInt        refct;
	  public PetscInt        n;                /* number of colors */
	  //preciso ver isso public IS              is;              /* for each color indicates columns */
	  public Intracommunicator        comm;
	  public ISColoringValue colors;          /* for each column indicates color */
	  public PetscInt        N;                /* number of columns */
	  public ISColoringType  ctype;
   }
  
  [StructLayout(LayoutKind.Sequential)]
  public class  PetscFList{
     
  }
  
  [StructLayout(LayoutKind.Sequential)]
  public class  PetscOList{
     
  }
  
  [StructLayout(LayoutKind.Sequential)]
  public class  PetscViewer{
     
  }
  
  [StructLayout(LayoutKind.Sequential)]
  public struct  PetscOps{
	   public delegate PetscErrorCode getcomm(PetscObject obj,Intracommunicator comm);
	   
	   public delegate PetscErrorCode view(PetscObject obj,PetscViewer view);
	   public delegate PetscErrorCode destroy(PetscObject obj);
	   public delegate PetscErrorCode compose(PetscObject obj,char[] a,PetscObject obj2);
	   public delegate PetscErrorCode query(PetscObject obj,char[] a,PetscObject obj2);
	   //preciso ver public delegate PetscErrorCode composefunction(PetscObject obj, char[] a, char[] a,void (*)(void));
	   //preciso ver public delegate PetscErrorCode queryfunction(PetscObject obj,char[] a,void (**)(void));
	   public delegate PetscErrorCode publish(PetscObject obj);
   }
  
  
  [StructLayout(LayoutKind.Sequential)]
  public class  PetscObject{
	  public PetscCookie    cookie;                                        
	  public PetscOps       bops;                                         
	  public Intracommunicator        comm;                                          
	  public PetscInt       type;                                          
	  public PetscLogDouble flops,time,mem;                                
	  public PetscInt       id;                                            
	  public PetscInt       refct;                                         
	  public PetscMPIInt    tag;                                           
	  public PetscFList     qlist;                                         
	  public PetscOList     olist;                                         
	  public string           class_name;                                   
	  public string           type_name;                                    
	  public PetscObject    parent;                                        
	  public PetscInt       parentid;                                      
	  public string          name;                                          
	  public string           prefix;                                       
	  public PetscInt       tablevel;                                      
	  public unsafe void*           cpp;                                          
	  public PetscInt       amem;                                          
	  public PetscInt       state;                                         
	  public PetscInt       int_idmax,        intstar_idmax;               
	  public unsafe PetscInt*       intcomposedstate,intstarcomposedstate;       
	  public unsafe PetscInt*       intcomposeddata;
	  public unsafe PetscInt** intstarcomposeddata;       
	  public PetscInt       real_idmax,        realstar_idmax;             
	  public unsafe PetscInt*       realcomposedstate,realstarcomposedstate;     
	  public unsafe PetscReal*      realcomposeddata;
	  public unsafe PetscReal** realstarcomposeddata;     
	  public PetscInt       scalar_idmax,        scalarstar_idmax;         
	  public unsafe PetscInt*       scalarcomposedstate,scalarstarcomposedstate; 
	  public unsafe PetscScalar*    scalarcomposeddata;
	  public unsafe PetscScalar** scalarstarcomposeddata; 
	  //void           (**fortran_func_pointers)(void);                  /* used by Fortran interface functions to stash user provided Fortran functions */
	  public unsafe void*           python_context;                               
	  //public PetscErrorCode (*python_destroy)(void*);
  }
 
  [StructLayout(LayoutKind.Sequential)]
  public class ISLocalToGlobalMapping{
	  //PETSCHEADER(int);
	  public PetscObject hdr;	       
      public unsafe int*      ops;
	  public PetscInt n;                  /* number of local indices */
	  public unsafe PetscInt* indices;           /* global index of each local index */
	  public PetscInt globalstart;        /* first global referenced in indices */
	  public PetscInt globalend;          /* last + 1 global referenced in indices */
	  public unsafe PetscInt* globals;           /* local index for each global index between start and end */
   }
 
  [StructLayout(LayoutKind.Sequential)]
  public class  VecStash {
	  public PetscInt      nmax;                   /* maximum stash size */
	  public PetscInt      umax;                   /* max stash size user wants */
	  public PetscInt      oldnmax;                /* the nmax value used previously */
	  public PetscInt      n;                      /* stash size */
	  public PetscInt      bs;                     /* block size of the stash */
	  public PetscInt      reallocs;               /* preserve the no of mallocs invoked */           
	  public unsafe PetscInt*      idx;                   /* global row numbers in stash */
	  public unsafe PetscScalar*   array;                 /* array to hold stashed values */
	  /* The following variables are used for communication */
	  public Intracommunicator      comm;
	  public PetscMPIInt   size,rank;
	  public PetscMPIInt   tag1,tag2;
	  public Request[]   send_waits;            /* array of send requests */
	  public Request[]   recv_waits;            /* array of receive requests */
	  //preciso ver isso public Request[]    send_status;           /* array of send status */
	  public PetscInt      nsends,nrecvs;          /* numbers of sends and receives */
	  public unsafe PetscScalar*   svalues,rvalues;      /* sending and receiving data */
	  public PetscInt      rmax;                   /* maximum message length */
	  public unsafe PetscInt*      nprocs;                /* tmp data used both during scatterbegin and end */
	  public PetscInt      nprocessed;             /* number of messages already processed */
	  public PetscTruth    donotstash;
	  public PetscTruth    ignorenegidx;           /* ignore negative indices passed into VecSetValues/VetGetValues */
	  public InsertMode    insertmode;
	  public unsafe PetscInt*      bowners;
   }
  
  [StructLayout(LayoutKind.Sequential)]
  public class PetscMap {
	  public Intracommunicator  comm;
	  public PetscInt  n,N;         /* local, global vector size */
	  public PetscInt  rstart,rend; /* local start, local end + 1 */
	  public unsafe PetscInt*  range;      /* the offset of each processor */
	  public PetscInt  bs;          /* number of elements in each block (generally for multi-component problems) Do NOT multiply above numbers by bs */
	  public PetscInt  refcnt;      /* MPI Vecs obtained with VecDuplicate() and from MatGetVecs() reuse map of input object */
   }
   
  [StructLayout(LayoutKind.Sequential)]
  public class PetscRandom{
     
  }
   
  [StructLayout(LayoutKind.Sequential)]
  public class _ISOps {
	  public unsafe delegate PetscErrorCode  getsize (IS a,PetscInt* b);
	  public unsafe delegate PetscErrorCode  getlocalsize (IS a,PetscInt* b);
	  public unsafe delegate PetscErrorCode  getindices (IS a,PetscInt*[] b);
	  public unsafe delegate PetscErrorCode  restoreindices (IS a,PetscInt*[] b) ;
	  public unsafe delegate PetscErrorCode  invertpermutation (IS a,PetscInt b,IS c);
	  public delegate PetscErrorCode  sortindices (IS a);
	  public delegate PetscErrorCode  sorted (IS a,PetscTruth b);
	  public delegate PetscErrorCode  duplicate (IS a,IS b);
	  public delegate PetscErrorCode  destroy (IS a);
	  public delegate PetscErrorCode  view (IS a,PetscViewer b);
	  public delegate PetscErrorCode  identity (IS a,PetscTruth b);
  }

  [StructLayout(LayoutKind.Sequential)]
  public class IS {
	  //PETSCHEADER(struct _ISOps);
	  public PetscObject hdr;
      public _ISOps     ops;
	  public PetscTruth   isperm;          /* if is a permutation */
	  public PetscInt     max,min;         /* range of possible values */
	  public unsafe void*         data;
	  public PetscTruth   isidentity;
  }
  
  [StructLayout(LayoutKind.Sequential)]
  public class VecScatter {
	  //PETSCHEADER(int);
	  public PetscObject hdr;
	  public unsafe int* ops;
	  public PetscInt       to_n,from_n;
	  public PetscTruth     inuse;                /* prevents corruption from mixing two scatters */
	  public PetscTruth     beginandendtogether;  /* indicates that the scatter begin and end  function are called together, VecScatterEnd()
	                                          is then treated as a nop */
	  public PetscTruth     packtogether;         /* packs all the messages before sending, same with receive */
	  public PetscTruth     reproduce;            /* always receive the ghost points in the same order of processes */
	  public delegate PetscErrorCode begin(VecScatter a,Vec b,Vec c,InsertMode d,ScatterMode e);
	  public delegate PetscErrorCode end(VecScatter a,Vec b,Vec c,InsertMode d,ScatterMode e);
	  public delegate PetscErrorCode copy(VecScatter a,VecScatter b);
	  public delegate PetscErrorCode destroy(VecScatter a);
	  public delegate PetscErrorCode view(VecScatter a,PetscViewer b);
	  public unsafe void*           fromdata,todata;
  }
  
  [StructLayout(LayoutKind.Sequential)]
  public class VecOps {
	  public delegate PetscErrorCode duplicate (Vec a,Vec[] b);         /* get single vector */
	  public unsafe delegate PetscErrorCode  duplicatevecs (Vec a,PetscInt b,Vec[][] c);     /* get array of vectors */
	  public delegate PetscErrorCode  destroyvecs (Vec[] a,PetscInt b);           /* free array of vectors */
	  public unsafe delegate PetscErrorCode  dot (Vec a,Vec b,PetscScalar* c);             /* z = x^H * y */
	  public unsafe delegate PetscErrorCode  mdot (Vec a,PetscInt b,Vec[] c,PetscScalar* d); /* z[j] = x dot y[j] */
	  public unsafe delegate PetscErrorCode  norm (Vec a,NormType b,PetscReal* c);        /* z = sqrt(x^H * x) */
	  public unsafe delegate PetscErrorCode  tdot (Vec a,Vec b,PetscScalar* c);             /* x'*y */
	  public unsafe delegate PetscErrorCode  mtdot (Vec a,PetscInt b,Vec[] c,PetscScalar* d);/* z[j] = x dot y[j] */
	  public delegate PetscErrorCode  scale (Vec a,PetscScalar b);                 /* x = alpha * x   */
	  public delegate PetscErrorCode  copy (Vec a,Vec b);                     /* y = x */
	  public delegate PetscErrorCode  set (Vec a,PetscScalar b);                        /* y = alpha  */
	  public delegate PetscErrorCode  swap (Vec a,Vec b);                               /* exchange x and y */
	  public delegate PetscErrorCode  axpy (Vec a,PetscScalar b,Vec c);                   /* y = y + alpha * x */
	  public delegate PetscErrorCode  axpby (Vec a,PetscScalar b,PetscScalar c,Vec d);      /* y = alpha * x + beta * y*/
	  public unsafe delegate PetscErrorCode  maxpy (Vec a,PetscInt b,PetscScalar* c,Vec[] d); /* y = y + alpha[j] x[j] */
	  public delegate PetscErrorCode  aypx(Vec a,PetscScalar b,Vec c);                   /* y = x + alpha * y */
	  public delegate PetscErrorCode  waxpy (Vec a,PetscScalar b,Vec c,Vec d);         /* w = y + alpha * x */
	  public delegate PetscErrorCode  axpbypcz (Vec a,PetscScalar b,PetscScalar c,PetscScalar d,Vec e,Vec f);   /* z = alpha * x + beta *y + gamma *z*/
	  public delegate PetscErrorCode  pointwisemult (Vec a,Vec b,Vec c);        /* w = x .* y */
	  public delegate PetscErrorCode  pointwisedivide (Vec a,Vec b,Vec c);      /* w = x ./ y */
	  public delegate PetscErrorCode  setvalues (Vec a,PetscInt b,PetscInt[] c,PetscScalar[] d,InsertMode e);
	  public delegate PetscErrorCode  assemblybegin (Vec a);                /* start global assembly */
	  public delegate PetscErrorCode  assemblyend (Vec a);                  /* end global assembly */
	  public unsafe delegate PetscErrorCode  getarray (Vec a,PetscScalar** b);            /* get data array */
	  public unsafe delegate PetscErrorCode  getsize (Vec a,PetscInt* b);
	  public unsafe delegate PetscErrorCode  getlocalsize (Vec a,PetscInt* b);
	  public unsafe delegate PetscErrorCode  restorearray (Vec a,PetscScalar** b);        /* restore data array */
	  public unsafe delegate PetscErrorCode  max (Vec a,PetscInt* b,PetscReal* c);      /* z = max(x ; idx=index of max(x) */
	  public unsafe delegate PetscErrorCode  min (Vec a,PetscInt* b,PetscReal* c);      /* z = min(x); idx=index of min(x) */
	  public delegate PetscErrorCode  setrandom (Vec a,PetscRandom b);         /* set y[j] = random numbers */
	  public delegate PetscErrorCode  setoption (Vec a,VecOption b,PetscTruth c) ;
	  public delegate PetscErrorCode  setvaluesblocked (Vec a,PetscInt b,PetscInt[] c,PetscScalar[] d,InsertMode e);
	  public delegate PetscErrorCode  destroy (Vec a);
	  public delegate PetscErrorCode  view (Vec a,PetscViewer b);
	  public unsafe delegate PetscErrorCode  placearray (Vec a,PetscScalar* b);     /* place data array */
	  public unsafe delegate PetscErrorCode  replacearray (Vec a,PetscScalar* b);     /* replace data array */
	  public unsafe delegate PetscErrorCode  dot_local (Vec a,Vec b,PetscScalar* c);
	  public unsafe delegate PetscErrorCode  tdot_local (Vec a,Vec b,PetscScalar* c);
	  public unsafe delegate PetscErrorCode  norm_local (Vec a,NormType b,PetscReal* c);
	  public unsafe delegate PetscErrorCode  mdot_local (Vec a,PetscInt b,Vec[] c,PetscScalar* d);
	  public unsafe delegate PetscErrorCode  mtdot_local (Vec a,PetscInt b,Vec[] c,PetscScalar* d);
	  public delegate PetscErrorCode  loadintovector (PetscViewer a,Vec b);
	  public delegate PetscErrorCode  loadintovectornative (PetscViewer a,Vec b);
	  public delegate PetscErrorCode  reciprocal(Vec a);
	  public delegate PetscErrorCode  viewnative (Vec a,PetscViewer b);
	  public delegate PetscErrorCode  conjugate (Vec a);
	  public delegate PetscErrorCode  setlocaltoglobalmapping (Vec a,ISLocalToGlobalMapping b);
	  public unsafe delegate PetscErrorCode  setvalueslocal (Vec a,PetscInt b, PetscInt* c,PetscScalar* d,InsertMode e);
	  public delegate PetscErrorCode  resetarray (Vec a);      /* vector points to its original array, i.e. undoes any VecPlaceArray() */
	  public delegate PetscErrorCode  setfromoptions (Vec a);
	  public unsafe delegate PetscErrorCode  maxpointwisedivide (Vec a,Vec b,PetscReal* c);      /* m = max abs(x ./ y) */
	  //public delegate PetscErrorCode  load (PetscViewer a,const VecType b,Vec*);
	  public delegate PetscErrorCode  pointwisemax(Vec a,Vec b,Vec c);
	  public delegate PetscErrorCode  pointwisemaxabs(Vec a,Vec b,Vec c);
	  public delegate PetscErrorCode pointwisemin(Vec a,Vec b,Vec c);
	  public delegate PetscErrorCode getvalues(Vec a,PetscInt b,PetscInt[] c,PetscScalar[] d);
	  public delegate PetscErrorCode sqrt(Vec a);
	  public delegate PetscErrorCode abs(Vec a);
	  public delegate PetscErrorCode exp(Vec a);
	  public delegate PetscErrorCode log(Vec a);
	  public delegate PetscErrorCode shift(Vec a);
	  public delegate PetscErrorCode create(Vec a);
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class Vec{
	  //PETSCHEADER(struct _VecOps);
	  public PetscObject hdr;
      public VecOps     ops;
	  public PetscMap               map;
	  public unsafe void*                   data;     /* implementation-specific data */
	  public ISLocalToGlobalMapping mapping;   /* mapping used in VecSetValuesLocal() */
	  public ISLocalToGlobalMapping bmapping;  /* mapping used in VecSetValuesBlockedLocal() */
	  public PetscTruth             array_gotten;
	  public VecStash               stash,bstash; /* used for storing off-proc values during assembly */
	  public PetscTruth             petscnative;  /* means the ->data starts with VECHEADER and can use VecGetArrayFast()*/
   }
    
   [StructLayout(LayoutKind.Sequential)]
   public class MatInfo{
	  public PetscLogDouble block_size;                         /* block size */
	  public PetscLogDouble nz_allocated,nz_used,nz_unneeded;   /* number of nonzeros */
	  public PetscLogDouble memory;                             /* memory allocated */
	  public PetscLogDouble assemblies;                         /* number of matrix assemblies called */
	  public PetscLogDouble mallocs;                            /* number of mallocs during MatSetValues() */
	  public PetscLogDouble fill_ratio_given,fill_ratio_needed; /* fill ratio for LU/ILU */
	  public PetscLogDouble factor_mallocs;                     /* number of mallocs during factorization */
   }
   
  [StructLayout(LayoutKind.Sequential)]
  public class  MatStash{
	  public PetscInt      nmax;                   /* maximum stash size */
	  public PetscInt      umax;                   /* user specified max-size */
	  public PetscInt      oldnmax;                /* the nmax value used previously */
	  public PetscInt      n;                      /* stash size */
	  public PetscInt      bs;                     /* block size of the stash */
	  public PetscInt      reallocs;               /* preserve the no of mallocs invoked */    
	  public PetscMatStashSpace space_head,space;  /* linked list to hold stashed global row/column numbers and matrix values */
	  /* The following variables are used for communication */
	  public Intracommunicator      comm;
	  public PetscMPIInt   size,rank;
	  public PetscMPIInt   tag1,tag2;
	  public Request[]   send_waits;            /* array of send requests */
	  public Request[]   recv_waits;            /* array of receive requests */
	  //preciso ver isso public MPI_Status*    send_status;           /* array of send status */
	  public PetscInt      nsends,nrecvs;          /* numbers of sends and receives */
	  public unsafe PetscScalar*   svalues;               /* sending data */
	  public unsafe PetscScalar**   rvalues;              /* receiving data (values) */
	  public unsafe PetscInt**      rindices;             /* receiving data (indices) */
	  public unsafe PetscMPIInt*   nprocs;                /* tmp data used both during scatterbegin and end */
	  public PetscInt      nprocessed;             /* number of messages already processed */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class PetscMatStashSpace {
	  public PetscMatStashSpace next;
	  public unsafe PetscScalar*        space_head,val;
	  public unsafe PetscInt*           idx,idy;
	  public PetscInt           total_space_size;
	  public PetscInt           local_used;
	  public PetscInt           local_remaining;
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class MatNullSpace {
	  public PetscObject hdr;
      public unsafe int*     ops;
	  public PetscTruth     has_cnst;
	  public PetscInt       n;
	  public Vec           vecs;
	  public unsafe PetscScalar*   alpha;                 /* for projections */
	  public Vec            vec;                   /* for out of place removals */
	  public unsafe delegate PetscErrorCode remove(Vec a,void* b);  /* for user provided removal function */
	  public unsafe void*          rmctx;                 /* context for remove() function */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class MatStencilInfo{
	  public PetscInt   dim;
	  public PetscInt[]   dims = new PetscInt[4];
	  public PetscInt[]   starts = new PetscInt[4];
	  public PetscTruth noc;        /* this is a single component problem, hence user will not set MatStencil.c */
  }
  
   [StructLayout(LayoutKind.Sequential)]
   public class  MatStencil{
     public PetscInt k,j,i,c;
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class Mat {
	  //PETSCHEADER(struct _MatOps);
	  public PetscMap               rmap,cmap;
	  public unsafe void*                   data;            /* implementation-specific data */
	  public MatFactorType          factor;           /* MAT_FACTOR_LU, or MAT_FACTOR_CHOLESKY */
	  public PetscTruth             assembled;        /* is the matrix assembled? */
	  public PetscTruth             was_assembled;    /* new values inserted into assembled mat */
	  public PetscInt               num_ass;          /* number of times matrix has been assembled */
	  public PetscTruth             same_nonzero;     /* matrix has same nonzero pattern as previous */
	  public MatInfo                info;             /* matrix information */
	  public ISLocalToGlobalMapping mapping;          /* mapping used in MatSetValuesLocal() */
	  public ISLocalToGlobalMapping bmapping;         /* mapping used in MatSetValuesBlockedLocal() */
	  public InsertMode             insertmode;       /* have values been inserted in matrix or added? */
	  public MatStash               stash,bstash;     /* used for assembling off-proc mat emements */
	  public MatNullSpace           nullsp;
	  public PetscTruth             preallocated;
	  public MatStencilInfo         stencil;          /* information for structured grid */
	  public PetscTruth             symmetric,hermitian,structurally_symmetric;
	  public PetscTruth             symmetric_set,hermitian_set,structurally_symmetric_set; /* if true, then corresponding flag is correct*/
	  public PetscTruth             symmetric_eternal;
	  public unsafe void*                   spptr;          /* pointer for special library like SuperLU */
	  public MatSolverPackage       solvertype;
   }
   
    public delegate PetscErrorCode PetscObjectFunction(PetscObject obj);
    public delegate PetscErrorCode PetscObjectViewerFunction(PetscObject obj,PetscViewer view);
 
 


public interface IPETSc : BaseIPETSc, ILibraryUnit
{


} // end main interface 

} // end namespace 
