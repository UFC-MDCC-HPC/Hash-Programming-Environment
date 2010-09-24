using br.ufc.hpe.kinds;
using linearsystems.qualifier.Library;
using System.Runtime.InteropServices;
using MPI;


namespace linearsystems.qualifier.SuperLU { 
   
   public enum Stype_t{
		SLU_NC,    
		SLU_NCP,   
		SLU_NR,    
		SLU_SC,    /* column-wise, supernode */
		SLU_SCP,   /* supernode, column-wise, permuted */    
		SLU_SR,    /* row-wise, supernode */
		SLU_DN,     /* Fortran style column-wise storage for dense matrix */
		SLU_NR_loc  /* distributed compressed row format  */ 
	};


	public enum  Dtype_t{
		SLU_S,     /* single */
		SLU_D,     /* double */
		SLU_C,     /* single complex */
		SLU_Z      /* double complex */
	};
		
   public enum  Mtype_t{
		SLU_GE,    /* general */
		SLU_TRLU,  /* lower triangular, unit diagonal */
		SLU_TRUU,  /* upper triangular, unit diagonal */
		SLU_TRL,   /* lower triangular */
		SLU_TRU,   /* upper triangular */
		SLU_SYL,   /* symmetric, store lower half */
		SLU_SYU,   /* symmetric, store upper half */
		SLU_HEL,   /* Hermitian, store lower half */
		SLU_HEU    /* Hermitian, store upper half */
	};

   public enum yes_no_t{
       NO,
       YES
   };
   
   public enum fact_t{
      DOFACT,
      SamePattern, 
      SamePattern_SameRowPerm, 
      FACTORED
   };
   
   public enum rowperm_t{
      NOROWPERM, 
      LargeDiag, 
      MY_PERMR
   };

   public enum colperm_t{
      NATURAL, 
      MMD_AT_PLUS_A, 
      MMD_ATA, 
      METIS_AT_PLUS_A,
	  PARMETIS,
	  ZOLTAN,
	  MY_PERMC
   };
   
   public enum trans_t{
      NOTRANS,
      TRANS,
      CONJ
   };
   
   public enum DiagScale_t{
      NOEQUIL,
      ROW,
      COL,
      BOTH
   };
   
   
   public enum IterRefine_t{
      NOREFINE,
      SINGLE=1,
      DOUBLE,
      EXTRA
   };
   
   public enum MemType{
      LUSUP, 
      UCOL, 
      LSUB, 
      USUB, 
      LLVL, 
      ULVL
   };

   public enum stack_end_t{
      HEAD,
      TAIL
   };

   public enum LU_space_t{
      SYSTEM,
      USER
   };
   
   public enum  PhaseType{
	    COLPERM, /* find a column ordering that minimizes fills */
	    ROWPERM, /* find a row ordering maximizes diagonal. */
	    RELAX,   /* find artificial supernodes */
	    ETREE,   /* compute column etree */
	    EQUIL,   /* equilibrate the original matrix */
	    SYMBFAC, /* symbolic factorization. */
	    DIST,    /* distribute matrix. */
	    FACT,    /* perform LU factorization */
	    COMM,    /* communication for factorization */
	    SOL_COMM,/* communication for solve */
	    RCOND,   /* estimate reciprocal condition number */
	    SOLVE,   /* forward and back solves */
	    REFINE,  /* perform iterative refinement */
	    FLOAT,   /* time spent in floating-point operations */
	    TRSV,    /* fraction of FACT spent in xTRSV */
	    GEMV,    /* fraction of FACT spent in xGEMV */
	    FERR,    /* estimate error bounds after iterative refinement */
	    NPHASES  /* total number of phases */
   };

	[StructLayout(LayoutKind.Sequential)]
	public class SuperLUStat_t{
	    public unsafe int* panel_histo; /* histogram of panel size distribution */
	    public unsafe double* utime;       /* running time at various phases */
	    public unsafe float* ops;         /* operation count at various phases */
	    public int     TinyPivots;   /* number of tiny pivots */
	    public int     RefineSteps;  /* number of iterative refinement steps */
   } 

/* Headers for 2 types of dynamatically managed memory */
   [StructLayout(LayoutKind.Sequential)]
   public class ExpHeader {
	    public int size;      /* length of the memory that has been used */
	    public unsafe void* mem;     /* pointer to the new malloc'd store */
   }

   [StructLayout(LayoutKind.Sequential)]
   public class  LU_stack_t{
	    public int  size;
	    public int  used;
	    public int  top1;  /* grow upward, relative to &array[0] */
	    public int  top2;  /* grow downward */
	    public unsafe void* array;
   }
   
   
   [StructLayout(LayoutKind.Sequential)]
   public class superlu_scope_t{
	    public Intracommunicator comm;        /* MPI communicator */
	    public int Np;               /* number of processes */
	    public int Iam;              /* my process number */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class gridinfo_t{
	     public Intracommunicator comm;        /* MPI communicator */
	     public superlu_scope_t rscp; /* row scope */
	     public superlu_scope_t cscp; /* column scope */
	     public int iam;              /* my process number in this scope */
	     public int nprow;          /* number of process rows */
	     public int npcol;          /* number of process columns */
	}

   [StructLayout(LayoutKind.Sequential)]
   public class Glu_persist_t{
	    public unsafe int* xsup;
	    public unsafe int* supno;
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class  Glu_freeable_t{
	    public unsafe int* lsub;     /* compressed L subscripts */
	    public unsafe int* xlsub;
	    public unsafe int* usub;     /* compressed U subscripts */
	    public unsafe int* xusub;
	    public int  nzlmax;    /* current max size of lsub */
	    public int  nzumax;    /*    "    "    "      usub */
	    public LU_space_t MemModel; /* 0 - system malloc'd; 1 - user provided */
	    public unsafe int* llvl;     /* keep track of level in L for level-based ILU */
	    public unsafe int* ulvl;     /* keep track of level in U for level-based ILU */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class  ScalePermstruct_t{
	    public DiagScale_t DiagScale;
	    public unsafe double* R;
	    public unsafe double* C; 
	    public unsafe int* perm_r;
	    public unsafe int* perm_c;
   }
   
   [StructLayout(LayoutKind.Sequential)]
	public class superlu_options_t
	{
	    public fact_t        Fact;
	    public yes_no_t      Equil;
	    public yes_no_t      ParSymbFact;
	    public colperm_t     ColPerm;
	    public rowperm_t     RowPerm;
	    public double        DiagPivotThresh;
	    public IterRefine_t  IterRefine;
	    public trans_t       Trans;
	    public yes_no_t      ReplaceTinyPivot;
	    public yes_no_t      SolveInitialized;
	    public yes_no_t      RefineInitialized;
	    public yes_no_t      PrintStat;
	}

   [StructLayout(LayoutKind.Sequential)]
	public class mem_usage_t
	{
	    public float for_lu;
        public float total;
        public int expansions;
        public int nnzL, nnzU;
	} 
   
   [StructLayout(LayoutKind.Sequential)]
   public class doublecomplex{
      double r, i;      
   }

   [StructLayout(LayoutKind.Sequential)]
   public class SuperMatrix{
       public Stype_t Stype;
       public Dtype_t Dtype;
       public Mtype_t Mtype;
	   public int nrow;
	   public int ncol;
	   public unsafe void* Store;
   }

   [StructLayout(LayoutKind.Sequential)]
   public class NCformat{
      public int nnz;
      public unsafe void* nzval;    
      public unsafe int*   rowind; 
      public unsafe int*   colptr;
   }

   [StructLayout(LayoutKind.Sequential)]
   public class NRformat{
      public int nnz;	    
      public unsafe void*   nzval;    
      public unsafe int*   colind; 
      public unsafe int*   rowptr;
   }

   [StructLayout(LayoutKind.Sequential)]
   public class SCformat{
      public int  nnz;	     
      public int  nsuper;    
      public unsafe void* nzval;
      public unsafe int*   nzval_colptr;
      public unsafe  int*   rowind;      
      public unsafe  int*   rowind_colptr;
      public unsafe  int*   col_to_sup;
      public unsafe int*   sup_to_col;
      
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class SCPformat{
      public int  nnz;	     
      public int  nsuper;    
      public unsafe void* nzval;
      public unsafe int*   nzval_colbeg;
      public unsafe int*   nzval_colend;			  
      public unsafe int*   rowind;      			  
      public unsafe int* rowind_colbeg;			  
      public unsafe int*   rowind_colend;			  
      public unsafe int*   col_to_sup;   			  
      public unsafe int*   sup_to_colbeg;			   
      public unsafe int*   sup_to_colend; 
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class NCPformat{
      public int nnz;	 
      public unsafe void*   nzval;
      public unsafe int*   rowind;
      public unsafe int*   colbeg;                     
      public unsafe int*   colend;
   }

   [StructLayout(LayoutKind.Sequential)]
   public class DNformat{
      public int lda;    /* leading dimension */
      public unsafe void*   nzval;
   }

   [StructLayout(LayoutKind.Sequential)]
   public class NRformat_loc{
      public int nnz_loc;   
      public int m_loc;     
      public int fst_row;   
      public unsafe void*   nzval;    
      public unsafe int*   rowptr;   //HERE
      public unsafe int*   colind;
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class LocalLU_t{
      public unsafe int**   Lrowind_bc_ptr; /* size ceil(NSUPERS/Pc)                 */
      public unsafe double**   Lnzval_bc_ptr;  /* size ceil(NSUPERS/Pc)                 */
      public unsafe int**   Ufstnz_br_ptr;  /* size ceil(NSUPERS/Pr)                 */
      public unsafe double**   Unzval_br_ptr;  /* size ceil(NSUPERS/Pr)                 */
//#if 0
    //  public unsafe int*   Lsub_buf;        /* Buffer for the remote subscripts of L */
    //  public unsafe double*   Lval_buf;        /* Buffer for the remote nonzeros of L   */
//#endif
      
      public unsafe int*[]  Lsub_buf_2 = new int*[2];   /* Buffers for the remote subscripts of L*/
      public unsafe double*[]  Lval_buf_2 = new double*[2];   /* Buffers for the remote nonzeros of L  */
      
      public unsafe int*   Usub_buf;        /* Buffer for the remote subscripts of U */
      public unsafe double*   Uval_buf;        /* Buffer for the remote nonzeros of U   */
      public unsafe double*   ujrow;           /* used in panel factorization.          */
      public int[]   bufmax = new int[5]; /* Buffer size; 5 entries
			       *     0 : size of Lsub_buf[]
			       *     1 : size of Lval_buf[]
			       *     2 : size of Usub_buf[] 
			       *     3 : size of Uval_buf[]
			       *     4 : size of tempv[LDA]
			       */

    /*-- Record communication schedule for factorization. --*/
      public unsafe int*   ToRecv;          /* Recv from no one (0), left (1), and up (2).*/
      public unsafe int*   ToSendD;         /* Whether need to send down block row.       */
      public unsafe int**   ToSendR;        /* List of processes to send right block col. */

    /*-- Record communication schedule for forward/back solves. --*/
      public unsafe int*   fmod;            /* Modification count for L-solve            */
      public unsafe int**   fsendx_plist;   /* Column process list to send down Xk       */
      public unsafe int*   frecv;           /* Modifications to be recv'd in proc row    */
      public int   nfrecvx;          /* Number of Xk I will receive in L-solve    */
      public int   nfsendx;          /* Number of Xk I will send in L-solve       */
      public unsafe int*   bmod;            /* Modification count for U-solve            */
      public unsafe int**   bsendx_plist;   /* Column process list to send down Xk       */
      public unsafe int*   brecv;           /* Modifications to be recv'd in proc row    */
      public int   nbrecvx;          /* Number of Xk I will receive in U-solve    */
      public int   nbsendx;          /* Number of Xk I will send in U-solve       */
      public unsafe int*   mod_bit;         /* Flag contribution from each row blocks    */

    /*-- Auxiliary arrays used for forward/back solves. --*/
      public unsafe int*   ilsum;           /* Starting position of each supernode in lsum
				 (local)  */
      public int   ldalsum;          /* LDA of lsum (local) */
      public int   SolveMsgSent;     /* Number of actual messages sent in LU-solve */
      public int   SolveMsgVol;      /* Volume of messages sent in the solve phase */


    /*********************/	
    /* The following variables are used in the hybrid solver */

    /*-- Counts to be used in U^{-T} triangular solve. -- */
      public int UT_SOLVE;
      public int L_SOLVE;
      public int FRECV;
      public int ut_ldalsum;        /* LDA of lsum (local) */
      public unsafe int*   ut_ilsum;         /* ilsum in column-wise                        */
      public unsafe int*   utmod;            /* Modification count for Ut-solve.            */
      public unsafe int**   ut_sendx_plist;  /* Row process list to send down Xk            */
      public unsafe int*   utrecv;           /* Modifications to be recev'd in proc column. */
      public int n_utsendx;         /* Number of Xk I will receive                 */
      public int n_utrecvx;         /* Number of Xk I will send                    */
      public int n_utrecvmod;
      public int nroot;
      public unsafe int*   ut_modbit;
      public unsafe int*   Urbs;
      public Ucb_indptr_t   Ucb_indptr;/* Vertical linked list pointing to Uindex[] */
      public unsafe int**   Ucb_valptr;      /* Vertical linked list pointing to Unzval[] */

    /* some additional counters for L solve */
      public int n;
      public int nleaf;
      public int nfrecvmod;
   }
   
   
   [StructLayout(LayoutKind.Sequential)]
   public class  LUstruct_t{
       public unsafe int* etree;
       public Glu_persist_t Glu_persist;
       public LocalLU_t Llu;
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class   Ucb_indptr_t{
       public int lbnum;  /* Row block number (local).      */
       public int indpos; /* Starting position in Uindex[]. */
   }
   
   
   [StructLayout(LayoutKind.Sequential)]
   public class pdgsmv_comm_t{
	    public unsafe int* extern_start;
	    public unsafe int* ind_tosend;    /* X indeices to be sent to other processes */
	    public unsafe int* ind_torecv;    /* X indeices to be received from other processes */
	    public unsafe int* ptr_ind_tosend;/* Printers to ind_tosend[] (Size procs)
				     (also point to val_torecv) */
	    public unsafe int* ptr_ind_torecv;/* Printers to ind_torecv[] (Size procs)
				     (also point to val_tosend) */
	    public unsafe int* SendCounts;    /* Numbers of X indices to be sent
				     (also numbers of X values to be received) */
	    public unsafe int* RecvCounts;    /* Numbers of X indices to be received
				     (also numbers of X values to be sent) */
	    public unsafe double* val_tosend;   /* X values to be sent to other processes */
	    public unsafe double* val_torecv;   /* X values to be received from other processes */
	    public int TotalIndSend;   /* Total number of indices to be sent
				     (also total number of values to be received) */
	    public int TotalValSend;   /* Total number of values to be sent.
				     (also total number of indices to be received) */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class  pxgstrs_comm_t{
   
	    public unsafe int* B_to_X_SendCnt;
	    public unsafe int* X_to_B_SendCnt;
	    public unsafe int* ptr_to_ibuf, ptr_to_dbuf;
	
	    /* the following are needed in the hybrid solver */	
	    public unsafe int* X_to_B_iSendCnt;
	    public unsafe int* X_to_B_vSendCnt;
	    public unsafe int* disp_ibuf;
	    public unsafe int* send_ibuf;
	    public unsafe void* send_dbuf;
	
	    public int  x2b, b2x;
	    public unsafe int* send_ibuf2;
	    public unsafe int* recv_ibuf2;
	    public unsafe void* send_dbuf2;
	    public unsafe void* recv_dbuf2;
   }
   
   
   [StructLayout(LayoutKind.Sequential)]
   public class   SOLVEstruct_t{
	    public unsafe int* row_to_proc;
	    public unsafe int* inv_perm_c;
	    public int num_diag_procs;
	    public unsafe int* diag_procs, diag_len;
	    public pdgsmv_comm_t gsmv_comm;
	    public pxgstrs_comm_t gstrs_comm;
	    public unsafe int* A_colind_gsmv; /* After pdgsmv_init(), the global column
	                             indices of A are translated into the relative
	                             positions in the gathered x-vector.
	                             This is re-used in repeated calls to pdgsmv() */
	    public unsafe int* xrow_to_proc;
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class   pzgsmv_comm_t{
	   public unsafe int* 	extern_start;
	   public unsafe int* 	ind_tosend;
	   public unsafe int* 	ind_torecv;
	   public unsafe int* 	ptr_ind_tosend;
	   public unsafe int* 	ptr_ind_torecv;
	   public unsafe int* 	SendCounts;
	   public unsafe int* 	RecvCounts;
	   public unsafe doublecomplex 	val_tosend;
	   public unsafe doublecomplex 	val_torecv;
	   public int 	TotalIndSend;
	   public int TotalValSend;
   }
   
   
   [StructLayout(LayoutKind.Sequential)]
   public class Pslu_freeable_t{
	  public unsafe int     *xlsub;  /* pointer to the beginning of each column of L */
	  public unsafe int     *lsub;   /* compressed L subscripts, stored by columns */
	  public int     szLsub;  /* current max size of lsub */
	  public unsafe int* xusub;  /* pointer to the beginning of each row of U */
	  public unsafe int* usub;   /* compressed U subscripts, stored by rows */
	  public int     szUsub;  /* current max size of usub */
	  public unsafe int* supno_loc;  
	  public unsafe int* xsup_beg_loc;
	  public unsafe int* xsup_end_loc;
	  public int     nvtcs_loc;       /* number of local vertices */
	  unsafe int* globToLoc;      /* global to local indexing */
	  unsafe int  maxNvtcsPProc;   /* max number of vertices on the processors */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class  Llu_symbfact_t {
	  public unsafe int* xlsubPr;  /* pointer to pruned structure of L */
	  public unsafe int* lsubPr;   /* pruned structure of L */
	  public int     szLsubPr;  /* size of lsubPr array */
	  public int    indLsubPr; /* current index in lsubPr */
	  public unsafe int* xusubPr;  /* pointer to pruned structure of U */
	  public unsafe int* usubPr;   /* pruned structure of U */
	  public int     szUsubPr;  /* size of usubPr array */
	  public int     indUsubPr; /* current index in usubPr */
	
	  public unsafe int* xlsub_rcvd;
	  public unsafe int* xlsub;     /* pointer to structure of L, stored by columns */
	  public unsafe int* lsub;      /* structure of L, stored by columns */
	  public int    szLsub;     /* current max size of lsub */
	  public int     nextl;      /* pointer to current computation in lsub */
	  
	  public unsafe int* xusub_rcvd; /* */
	  public unsafe int* xusub;      /* pointer to structure of U, stored by rows */
	  public unsafe int* usub;       /* structure of U, stored by rows */
	  public int     szUsub;      /* current max size of usub */
	  public int     nextu;       /* pointer to current computation in usub */
	  
	  public unsafe int* cntelt_vtcs; /* size of column/row for each vertex */
	  public unsafe int* cntelt_vtcsA_lvl; /* size of column/row of A for each vertex at the
					  current level */
	  
	  public LU_space_t MemModel; /* 0 - system malloc'd; 1 - user provided */
	  public unsafe int  no_expand;    /* Number of memory expansions */
	  public int  no_expand_pr; /* Number of memory expansions of the pruned structures */
	  public int  no_expcp;     /* Number of memory expansions due to the right looking 
				  overestimation approach */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class  vtcsInfo_symbfact_t{
	  public int  maxSzBlk;        /* Max no of vertices in a block */
	  public int  maxNvtcsNds_loc; /* Max number of vertices of a node distributed on one
				     processor.  The maximum is computed among all the nodes 
				     of the sep arator tree and among all the processors */
	  public int  maxNeltsVtx;     /* Max number of elements of a vertex,
				     that is condisering that the matrix is
				     dense */
	  public int  nblks_loc;       /* Number of local blocks */
	  public unsafe int  *begEndBlks_loc; /* Begin and end vertex of each local block.
				     Array of size 2 * nblks_loc */
	  public int  curblk_loc;      /* Index of current block in the level under computation */
	  public int  nvtcs_loc;       /* Number of local vertices distributed on a processor */
	  public int  nvtcsLvl_loc;    /* Number of local vertices for current
				     level under computation */
	  public int    filledSep;       /* determines if curent or all separators are filled */
	  public int  nnz_asup_loc;    /* Number of nonzeros in asup not yet consumed.  Used during
				     symbolic factorization routine to determine how much 
				     of xusub, usub is still used to store the input matrix AS */
	  public int  nnz_ainf_loc;    /* Number of nonzeros in ainf.  Similar to nnz_asup_loc. */
	  public int  xusub_nextLvl;   /* Pointer to usub of the next level */
	  public int  xlsub_nextLvl;   /* Pointer to lsub of the next level */
	  public int  fstVtx_nextLvl;  /* First vertex of the next level */
   }

/*! \brief Structure used for redistributing A for the symbolic factorization algorithm */
   [StructLayout(LayoutKind.Sequential)]
   public class   matrix_symbfact_t{
	  public unsafe int* x_ainf;   /* pointers to columns of Ainf */
	  public unsafe int* ind_ainf; /* column indices of Ainf */
	  public unsafe int* x_asup;   /* pointers to rows of Asup */
	  public unsafe int* ind_asup; /* row indices of Asup */
   }


   [StructLayout(LayoutKind.Sequential)]
   public class   comm_symbfact_t{
	  public unsafe int* rcv_interLvl; /* from which processors iam receives data */
	  public unsafe int* snd_interLvl; /* to which processors iam sends data */
	  public unsafe int* snd_interSz;  /* size of data to be send */
	  public unsafe int* snd_LinterSz; /* size of data in L part to be send */
	  public unsafe int* snd_vtxinter; /* first vertex from where to send data */
	
	  /* inter level data structures */
	  public unsafe int* snd_intraLvl; /* to which processors iam sends data */
	  public int  snd_intraSz;   /* size of data to send */
	  public int  snd_LintraSz;  /* size of data to send */
	  public unsafe int* rcv_intraLvl; /* from which processors iam receives data */
	  public unsafe int* rcv_buf;      /* buffer to receive data */
	  public int  rcv_bufSz;     /* size of the buffer to receive data */
	  public unsafe int* snd_buf;      /* buffer to send data */
	  public int  snd_bufSz;     /* size of the buffer to send data */
	  public unsafe int* ptr_rcvBuf;   /* pointer to rcv_buf, the buffer to receive data */
   } 

/* relaxation parameters used in the algorithms - for future release */
/*! \brief statistics collected during parallel symbolic factorization */

   [StructLayout(LayoutKind.Sequential)]
   public class    psymbfact_stat_t{
   
	  public int  fill_par;     /* Estimation of fill.  It corresponds to sp_ienv_dist(6) */
	  public float  relax_seps;   /* relaxation parameter -not used in this version */
	  public float  relax_curSep; /* relaxation parameter -not used in this version */
	  public float  relax_gen;    /* relaxation parameter -not used in this version */
	
	  /* number of operations performed during parallel symbolic factorization */
	  public float  nops;
	  
	  /* no of dense current separators per proc */
	  public int nDnsCurSep;
	  /* no of dense separators up per proc */
	  public int  nDnsUpSeps;
	  
	  public float  no_shmSnd;    /* Number of auxiliary messages for send data */
	  public float  no_msgsSnd;   /* Number of messages sending data */
	  public int  maxsz_msgSnd; /* Max size of messages sending data */
	  public float  sz_msgsSnd;   /* Average size of messages sending data */
	  public float  no_shmRcvd;   /* Number of auxiliary messages for rcvd data */
	  public float  no_msgsRcvd;  /* Number of messages receiving data */
	  public int  maxsz_msgRcvd;/* Max size of messages receiving data */
	  public float  sz_msgsRcvd;  /* Average size of messages receiving data */
	  public float  no_msgsCol;   /* Number of messages sent for estimating size
				  of rows/columns, setup information
				  interLvl_symbfact,  */
	  public int  maxsz_msgCol; /* Average size of messages counted in
				  no_msgsCol */
	  public float  sz_msgsCol;   /* Max size of messages counted in no_msgsCol */
	
	  /* statistics on fill-in */
	  public float[]  fill_pelt = new float[6];
      
	
	  /* Memory usage */
	  public int  estimLSz; /* size of lsub due to right looking overestimation */
	  public int  estimUSz; /* size of usub due to right looking overestimation */
	  public int  maxSzLPr; /* maximum size of pruned L */
	  public int  maxSzUPr; /* maximum size of pruned U */
	  public int  maxSzBuf; /* maximum size of the send and receive buffers */
	  public int  szDnsSep; /* size of memory used when there are dense separators */
	  public float  allocMem; /* size of the total memory allocated (in bytes) */
   }
   
   
   
public interface ISuperLU : BaseISuperLU, ILibraryUnit
{


} // end main interface 

} // end namespace 
