using br.ufc.hpe.kinds;
using linearsystems.qualifier.Library;
using System.Runtime.InteropServices;
using MPI;


namespace linearsystems.qualifier.HYPRE { 

  
   [StructLayout(LayoutKind.Sequential)]
   public class hypre_Box{
	   public int[]  imin = new int[3];           /* min bounding indices */
	   public int[] imax = new int[3];           /* max bounding indices */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class  hypre_BoxArray{
	   public unsafe hypre_Box  boxes;         /* Array of boxes */
	   public int         size;          /* Size of box array */
	   public int         alloc_size;    /* Size of currently alloced space */
   }
	
   [StructLayout(LayoutKind.Sequential)]
   public class hypre_BoxArrayArray{
	   public hypre_BoxArray  box_arrays;    /* Array of pointers to box arrays */
	   public int               size;          /* Size of box array array */
   }


   [StructLayout(LayoutKind.Sequential)]
   public class hypre_StructAssumedPart{
	   /* the entries will be the same for all procs */  
	   public hypre_BoxArray      regions;
	   public int                 num_regions;      
	   public unsafe int*                 proc_partitions;
	   public unsafe int*[]         divisions = new int*[3];
	   
	   /* these entries are specific to each proc */
	   public hypre_BoxArray      my_partition;
	   public hypre_BoxArray      my_partition_boxes;
	   public unsafe int*                 my_partition_proc_ids;
	   public unsafe int*                 my_partition_boxnums;
	   public int                 my_partition_ids_size;   
	   public int                 my_partition_ids_alloc;
	   public int                 my_partition_num_distinct_procs;
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class hypre_BoxManEntry  {
	   public int[]  imin = new int[3];        
	   public int[] imax = new int[3]; 
	
	   public int proc; /*this is a two-part unique id: (proc, id) */
	   public int id;
	   public int[] num_ghost = new int[6];
	
	   public int position; /* this indicates the location of the entry in the
	                  * the box manager entries array and is used for
	                  * pairing with the info object (populated in addentry) */
	   
	   public unsafe void* boxman; /* the owning manager (populated in addentry)*/
	   
	   //preciso ver isso struct hypre_BoxManEntry_struct  *next;
	   public hypre_BoxManEntry  next;

   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class hypre_BoxManager {

	   public Intracommunicator comm;	
	   public int                 max_nentries;  /* storage in entries allocated to this 
	                                        amount */
	   public int                 is_gather_called; /* boolean to indicate  whether GatherEntries
	                                            function has been called  (prior to 
	                                            assemble) - may not want this (can tell
	                                            by the size of gather_regions array) */
	   public hypre_BoxArray     gather_regions;  /*this is where we collect boxes input 
	                                          by calls to BoxManGatherEntries - to be 
	                                          gathered in the assemble.  These are then 
	                                          deleted after the assemble */
	   public int                 all_global_known; /* Boolean to say that every
	                                            processor already has all
	                                            of the global data for
	                                            this manager (this could be
	                                            acessed by a coarsening routine, 
	                                            for example) */
	   public int                 is_entries_sort;     /* Boolean to say that entries were 
	                                            added in sorted order (id, proc)
	                                            (this could be
	                                            acessed by a coarsening routine, 
	                                           for example) */
	   public int                 entry_info_size;  /* in bytes, the (max) size of the info 
	                                            object for the entries */ 
	   public int                 is_assembled;        /* flag to indicate if the box manager has been 
	                                            assembled (use to control whether or not
	                                            functions can be used prior to assemble)*/
	    /* storing the entries */
	   public int                 nentries;     /* number of entries stored */
	   public hypre_BoxManEntry  entries;      /* These are the actual box manager entries - these
	                                      are sorted by (proc, id) at the end of the assemble)*/  
	   public unsafe int*                procs_sort;    /* the sorted procs corresponding to entries */
	   public unsafe int*                ids_sort;      /* sorted ids corresponding to the entries */
	   public int                num_procs_sort; /* number of distinct procs in *entries */
	   public unsafe int*                procs_sort_offsets;  /* offsets for procs into the 
	                                             *entry_sort array */
	   public int                first_local;      /* position of local infomation in entries*/  
	   public int                local_proc_offset;  /*position of local information in offsets */
	   /* here is the table  that organizes the entries spatially (by index)*/
	   
	   public unsafe hypre_BoxManEntry index_table;
	   
	    /* this points into 'entries' array  
	                                            and corresponds to the index arays*/
	   public unsafe int*[]                indexes = new int*[3]; /* here we have the x,y,z indexes (ordered) 
	                             for the imin and imax
	                                      of each box in the entries array*/
	                                      
	   public int[]                 size = new int[3];    /* how many indexes we have in each direction 
	                                      - x,y,z */ 
	   public int[]                 last_index = new int[3]; /* the last index used in the indexes map */
	   public int                 num_my_entries; /* number of entries with proc_id = myid */
	   public unsafe  int*                 my_ids;        /* an array of ids corresponding to my entries */
	    
	  //preciso ver isso public hypre_BoxManEntry   **my_entries;
	  public hypre_BoxManEntry   my_entries;
	  
	     /* points into *entries that are mine & corresponds to
	                                          my_ids array.  This is destroyed in the assemble */   
	   public unsafe void*               info_objects;    /* this is an array of info objects (of each is of 
	                                         size entry_info_size) -this is managed byte-wise */ 
	   public hypre_StructAssumedPart assumed_partition; /* the assumed partition object  - for now this is only
	                                                  used during the assemble (where it is created)*/
	   public int                 dim;           /* problem dimension (known in the grid) */
	   public hypre_Box           bounding_box;  /* bounding box - from associated grid */
	   public int                 next_id; /* counter to indicate the next id 
	                                   that would be unique (regardless of proc id) */  
	   /* ghost stuff  */
	   public int[]                num_ghost = new int[6]; 

   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class  hypre_CommEntryType{
	   public int  offset;           /* offset for the data */
	   public int  dim;              /* dimension of the communication */
	   public int[]  length_array = new int[3];  /* 4th dimension has length 'num_values' */
	   public int[]  stride_array = new int[4];
	   public unsafe int* order;            /* order of 4th dimension values */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class hypre_CommType{
	   public int                   proc;
	   public int                   bufsize;     /* message buffer size (in doubles) */
	   public int                   num_entries;
	   public hypre_CommEntryType  entries;
	
	   /* this is only needed until first send buffer prefix is packed */
	   public unsafe int*                  rem_boxnums; /* entry remote box numbers */
	   public hypre_Box            rem_boxes;   /* entry remote boxes */
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class hypre_CommPkg{
	   public Intracommunicator comm;
	
	   public int               first_comm; /* is this the first communication? */
	                   
	   public int               num_values;
	   public int[]       send_stride = new int[3];
	   public int[]       recv_stride = new int[3];
	   public int               send_bufsize; /* total send buffer size (in doubles) */
	   public int               recv_bufsize; /* total recv buffer size (in doubles) */
	
	   public int               num_sends;
	   public int               num_recvs;
	   public hypre_CommType   send_types;
	   public hypre_CommType   recv_types;
	
	   public hypre_CommType   copy_from_type;
	   public hypre_CommType   copy_to_type;
	
	   public int               num_orders;
	   public unsafe int**             orders;            /* num_orders x num_values */
	
	   public unsafe int*              recv_data_offsets; /* offsets into recv data (by box) */
	   public hypre_BoxArray   recv_data_space;   /* recv data dimensions (by box) */
	
	   public int[]       identity_coord = new int[3];
	   public int[]       identity_dir = new int[3];
	   public unsafe int*              identity_order;
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class  hypre_StructGrid{
	   public Intracommunicator comm;	                      
	   public int                  dim;          /* Number of grid dimensions */	                      
	   public unsafe hypre_BoxArray      boxes;        /* Array of boxes in this process */
	   public unsafe int*   ids;          /* Unique IDs for boxes */
	   public int[]          max_distance = new int[3]; /* Neighborhood size - in each dimension*/	
	   public hypre_Box           bounding_box; /* Bounding box around grid */	
	   public int                  local_size;   /* Number of grid points locally */
	   public int                  global_size;  /* Total number of grid points */	
	   public int[]          periodic = new int[3];     /* Indicates if grid is periodic */
	   public int                  num_periods;  /* number of box set periods */	   
	   public unsafe int*[]      pshifts = new int*[3];      /* shifts of periodicity */	
	   public int                  ref_count;	
	   public int                 ghlocal_size;   /* Number of vars in box including ghosts */
	   public int[] num_ghost = new int[6];   /* ghost layer size for each box  */	
	   public hypre_BoxManager   box_man;   
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class hypre_StructStencil{
	   public unsafe int*[]    shape = new int*[3];   /* Description of a stencil's shape */
	   public int            size;    /* Number of stencil coefficients */
	   public int            max_offset;
	                
	   public int            dim;     /* Number of dimensions */
	
	   public   int            ref_count;
   }

   [StructLayout(LayoutKind.Sequential)]
   public class  hypre_StructMatrix{
	   public Intracommunicator comm;
	   public hypre_StructGrid     grid;
	   public hypre_StructStencil  user_stencil;
	   public hypre_StructStencil  stencil;
	   public int                   num_values;   /* Number of "stored" coefficients */
	   public hypre_BoxArray       data_space;
	   public unsafe double*               data;         /* Pointer to matrix data */
	   public int                   data_alloced; /* Boolean used for freeing data */
	   public int                   data_size;    /* Size of matrix data */
	   public unsafe int**                 data_indices; /* num-boxes by stencil-size array
	                                          of indices into the data array.
	                                          data_indices[b][s] is the starting
	                                          index of matrix data corresponding
	                                          to box b and stencil coefficient s */
	   public int                   constant_coefficient;  /* normally 0; set to 1 for
	                                                   constant coefficient matrices
	                                                   or 2 for constant coefficient
	                                                   with variable diagonal */                      
	   public int                   symmetric;    /* Is the matrix symmetric */
	   public unsafe int*                  symm_elements;/* Which elements are "symmetric" */
	   public int[]                   num_ghost = new int[6]; /* Num ghost layers in each direction */
	                      
	   public int                   global_size;  /* Total number of nonzero coeffs */
	
	   public hypre_CommPkg        comm_pkg;     /* Info on how to update ghost data */
	
	   public int                   ref_count;
   }
   
   
   [StructLayout(LayoutKind.Sequential)]
   public class hypre_StructVector{
	   public Intracommunicator comm;
	
	   public hypre_StructGrid     grid;
	
	   public hypre_BoxArray       data_space;
	
	   public unsafe double*               data;         /* Pointer to vector data */
	   public int                   data_alloced; /* Boolean used for freeing data */
	   public int                   data_size;    /* Size of vector data */
	   public unsafe int*                  data_indices; /* num-boxes array of indices into
	                                          the data array.  data_indices[b]
	                                          is the starting index of vector
	                                          data corresponding to box b. */
	                      
	   public int[]                   num_ghost = new int[6]; /* Num ghost layers in each direction */
	                      
	   public int                   global_size;  /* Total number coefficients */
	
	   public int                   ref_count;
   }
   
   [StructLayout(LayoutKind.Sequential)]
   public class HYPRE_StructSolver{
      
   }
   
   
   public delegate int HYPRE_PtrToStructSolverFcn(HYPRE_StructSolver solve,
                                          hypre_StructMatrix A,
                                          hypre_StructVector b,
                                          hypre_StructVector x);
                                          
   public delegate int pcg_precond_solve();
                                          
    
   
  
public interface IHYPRE : BaseIHYPRE, ILibraryUnit
{   
  

} // end main interface 

} // end namespace 
