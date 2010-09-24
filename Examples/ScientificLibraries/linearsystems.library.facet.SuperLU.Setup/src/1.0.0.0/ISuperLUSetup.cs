using br.ufc.hpe.kinds;
using linearsystems.qualifier.SuperLU;
using linearsystems.library.facet.Setup;
using System;
using MPI;

namespace linearsystems.library.facet.SuperLU.Setup { 

public interface ISuperLUSetup<L> : BaseISuperLUSetup<L>, ISetup<L>
where L:ISuperLU
{

     void    set_default_options_dist(superlu_options_t a);
     void    print_options_dist(superlu_options_t a);

	 float   slamch_(string a);
	 double  dlamch_(string a);
	 unsafe void*   superlu_malloc_dist(IntPtr a);
	 unsafe void    superlu_free_dist(void* a);
	 unsafe int*   intMalloc_dist(int a);
	 unsafe int*   intCalloc_dist(int a);
	
	/* Auxiliary routines */
	 double  SuperLU_timer_();
	 void    superlu_abort_and_exit_dist(string a);
	 int   sp_ienv_dist (int a);
	 int     lsame_ (string a, string b);
	 unsafe int     xerbla_ (string a, int* b);
	 
	 
	 unsafe void    super_stats_dist (int a, int* b);
	// void    ScalePermstructInit(const int a, const int b, 
		//			   ScalePermstruct_t c);
	 void    ScalePermstructFree(ScalePermstruct_t a);
	 void  superlu_gridinit(Intracommunicator a, int b, int c, gridinfo_t d);
	 void  superlu_gridmap(Intracommunicator a, int b, int c, int[] d, int e,
				           gridinfo_t f);
	 void  superlu_gridexit(gridinfo_t a);
	 
	 
	// unsafe void  a_plus_at_dist(const int a, const int b, int* c, int* d,
		//		                int* e, int** f, int** g);
	 
	// unsafe void  bcast_tree(void* a, int b, MPI_Datatype c, int d, int e,
		//		            gridinfo_t f, int g, int* h);
				            
	 unsafe  void  get_diag_procs(int a, Glu_persist_t b, gridinfo_t c,
	                             int* d, int** e, int** f);
	                             
	 int QuerySpace_dist(int a, int b, Glu_freeable_t c, mem_usage_t d);
	 
	 
	 
	 void  pxerbla (string a, gridinfo_t b, int c);
	 
	 void  PStatInit(SuperLUStat_t a);
	 void  PStatFree(SuperLUStat_t a);
	 void  PStatPrint(superlu_options_t a, SuperLUStat_t b, gridinfo_t c);
	
	
	
	
	/* Routines for debugging */
	 unsafe void  print_panel_seg_dist(int a, int b, int c, int d, int* e,
	                                   int* f);
	                                   
	 unsafe void  check_repfnz_dist(int a, int b, int c, int* d);
	 
	 unsafe int CheckZeroDiagonal(int a, int* b, int* c, int* d);
	 unsafe void  PrintDouble5(string a, int b, double* c);
	 unsafe void  PrintInt10(string a, int b, int* c);
	// unsafe int   file_PrintInt10(FILE* a, string b, int c, int* d);


} // end main interface 

} // end namespace 
