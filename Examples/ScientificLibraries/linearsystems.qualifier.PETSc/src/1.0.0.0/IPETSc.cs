using br.ufc.hpe.kinds;
using linearsystems.qualifier.Library;
using MPI;
using System.Runtime.InteropServices;

namespace linearsystems.qualifier.PETSc { 

  using PetscInt = System.Int32;
  using PetscMPIInt = System.Int32;
  using PetscScalar = System.Int32;
  
  public enum  PetscTruth{
      PETSC_FALSE,
      PETSC_TRUE
  }
  public enum  InsertMode{
     NOT_SET_VALUES,
     INSERT_VALUES, 
     ADD_VALUES, 
     MAX_VALUES
  }
 
  [StructLayout(LayoutKind.Sequential)]
  public class ISLocalToGlobalMapping{
	  //PETSCHEADER(int);
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
	  public Request[]    send_status;           /* array of send status */
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
   public class  _p_Vec{
	  //PETSCHEADER(struct _VecOps);
	  public PetscMap               map;
	  public unsafe void*                   data;     /* implementation-specific data */
	  public ISLocalToGlobalMapping mapping;   /* mapping used in VecSetValuesLocal() */
	  public ISLocalToGlobalMapping bmapping;  /* mapping used in VecSetValuesBlockedLocal() */
	  public PetscTruth             array_gotten;
	  public VecStash               stash,bstash; /* used for storing off-proc values during assembly */
	  public PetscTruth             petscnative;  /* means the ->data starts with VECHEADER and can use VecGetArrayFast()*/
   }
 
 


public interface IPETSc : BaseIPETSc, ILibraryUnit
{


} // end main interface 

} // end namespace 
