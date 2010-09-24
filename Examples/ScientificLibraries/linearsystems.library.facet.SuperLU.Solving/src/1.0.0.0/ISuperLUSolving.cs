using br.ufc.hpe.kinds;
using linearsystems.qualifier.SuperLU;
using linearsystems.library.facet.Solving;

namespace linearsystems.library.facet.SuperLU.Solving { 

public interface ISuperLUSolving<L> : BaseISuperLUSolving<L>, ISolvingFacet<L>
where L:ISuperLU
{
   
   //Resolve uma equação do sistema
   unsafe int sp_dtrsv_dist(string uplo,string	trans,string diag, SuperMatrix 	L,
		             SuperMatrix U, double* x, int* info);
   unsafe int sp_ztrsv_dist(string uplo,string	trans,string diag, SuperMatrix 	L,
		             SuperMatrix U, double* x, int* info);
		             
   //y := alpha*A*x + beta*y,   or   y := alpha*A'*x + beta*y
   unsafe int sp_dgemv_dist (string trans, double  	alpha,SuperMatrix 	A, double* x,
		                     int  	incx, double  	beta, double*  	y,int  	incy);
   unsafe int sp_zgemv_dist (string trans, double  	alpha,SuperMatrix 	A, double* x,
		                     int  	incx, double  	beta, double*  	y,int  	incy);		                     
   
   //C := alpha*op( A )*op( B ) + beta*C,
   unsafe int sp_dgemm_dist (string transa, string	transb,	int  	m,int  	n, int  	k,
		               double  	alpha, SuperMatrix	A,double*  	b, int  	ldb,
		               double  	beta,double*  	c,int  	ldc);
   unsafe int sp_zgemm_dist (string transa, string	transb,	int  	m,int  	n, int  	k,
		               double  	alpha, SuperMatrix	A,double*  	b, int  	ldb,
		               double  	beta,double*  	c,int  	ldc);
		               
   //Solve
   unsafe void pdgssvx_ABglobal (superlu_options_t a, SuperMatrix B, ScalePermstruct_t c,
                                 double* d, int e, int f, gridinfo_t g, LUstruct_t h,
                                 double* i, SuperLUStat_t j, int* l);
   unsafe void pzgssvx_ABglobal (superlu_options_t a, SuperMatrix B, ScalePermstruct_t c,
                                 double* d, int e, int f, gridinfo_t g, LUstruct_t h,
                                 double* i, SuperLUStat_t j, int* l);
   
   //Solve
   unsafe void pdgssvx (superlu_options_t a, SuperMatrix B, ScalePermstruct_t c, double* d,
                        int e, int f, gridinfo_t g, LUstruct_t h, SOLVEstruct_t i,
                        double* j, SuperLUStat_t l, int* m);
   unsafe void pzgssvx (superlu_options_t a, SuperMatrix B, ScalePermstruct_t c, double* d,
                        int e, int f, gridinfo_t g, LUstruct_t h, SOLVEstruct_t i,
                        double* j, SuperLUStat_t l, int* m);

   //	Initialize the data structure for the solution phase
   unsafe int dSolveInit (superlu_options_t a, SuperMatrix B, int[] c, int[] d, int e,
                         LUstruct_t f, gridinfo_t g, SOLVEstruct_t h);
   unsafe int zSolveInit (superlu_options_t a, SuperMatrix B, int[] c, int[] d, int e,
                         LUstruct_t f, gridinfo_t g, SOLVEstruct_t h);
   
                         
   //Set up the communication pattern for the triangular solution.
   unsafe int pxgstrs_init (int n,int m_loc, int  	nrhs, int  	fst_row, int[] perm_r,
		                    int[]	perm_c,	gridinfo_t 	grid, Glu_persist_t Glu_persist,
		                    SOLVEstruct_t SOLVEstruct); 
		                    
   unsafe void 	pxgstrs_finalize (pxgstrs_comm_t a);
   
   //Release the resources used for the solution phase. 
   unsafe void 	dSolveFinalize (superlu_options_t a, SOLVEstruct_t b);
   unsafe void 	zSolveFinalize (superlu_options_t a, SOLVEstruct_t b);
   
   //performs the LU factorization in parallel.
   unsafe int  pdgstrf (superlu_options_t a, int b, int c, double d, LUstruct_t e,
                        gridinfo_t f, SuperLUStat_t g, int* h);
   unsafe int  zdgstrf (superlu_options_t a, int b, int c, double d, LUstruct_t e,
                        gridinfo_t f, SuperLUStat_t g, int* h);
                        
   //solves a system of distributed linear equations A*X = B with a general N-by-N matrix A using the LU factorization
   unsafe void pdgstrs_Bglobal (int n, LUstruct_t LUstruct,	gridinfo_t 	grid,double* B,
		                        int	ldb, int nrhs,SuperLUStat_t stat,int* 	info);   
   unsafe void pzgstrs_Bglobal (int n, LUstruct_t LUstruct,	gridinfo_t 	grid,double* B,
		                        int	ldb, int nrhs,SuperLUStat_t stat,int* 	info);   
   

   unsafe void pdgstrs (int n, LUstruct_t LUstruct, ScalePermstruct_t ScalePermstruct,
		               gridinfo_t grid,	double*	B, int m_loc, int fst_row, int ldb,
		               int 	nrhs, SOLVEstruct_t	SOLVEstruct, SuperLUStat_t stat,int* info); 	
   unsafe void pzgstrs (int n, LUstruct_t LUstruct, ScalePermstruct_t ScalePermstruct,
		               gridinfo_t grid,	double*	B, int m_loc, int fst_row, int ldb,
		               int 	nrhs, SOLVEstruct_t	SOLVEstruct, SuperLUStat_t stat,int* info); 	
   
   //local block modifications: lsum[i] -= L_i,k * X[k].
   //unsafe void dlsum_fmod(double* lsum,double*	x,double*  	xk,	double* rtemp,
		        //          int  	nrhs,int  	knsupc,int	k,int*  	fmod, int nlb,
		      //            int	lptr, int  	luptr,	int*  	xsup, gridinfo_t grid,
		    //              LocalLU_t Llu, MPI_Request[] 	send_req, SuperLUStat_t	stat);
  // unsafe void zlsum_fmod(double* lsum,double*	x,double*  	xk,	double* rtemp,
	//	                  int  	nrhs,int  	knsupc,int	k,int*  	fmod, int nlb,
		//                  int	lptr, int  	luptr,	int*  	xsup, gridinfo_t grid,
		  //                LocalLU_t Llu, MPI_Request[] 	send_req, SuperLUStat_t	stat);
		                  
   //local block modifications: lsum[i] -= U_i,k * X[k].
   //unsafe void dlsum_bmod (double* lsum, double* x,double*	xk,	int nrhs, int k,
		  //                int*	bmod, int* 	Urbs, Ucb_indptr_t Ucb_indptr,
		//                  int**	Ucb_valptr, int* xsup, gridinfo_t grid, LocalLU_t Llu,
	//	                  MPI_Request[] send_req, SuperLUStat_t	stat);
  // unsafe void zlsum_bmod (double* lsum, double* x,double*	xk,	int nrhs, int k,
	//	                  int*	bmod, int* 	Urbs, Ucb_indptr_t Ucb_indptr,
	//	                  int**	Ucb_valptr, int* xsup, gridinfo_t grid, LocalLU_t Llu,
	//	                  MPI_Request[] send_req, SuperLUStat_t	stat);
   
   
   unsafe void 	pdgsrfs (int a, SuperMatrix B, double c, LUstruct_t d,
                        ScalePermstruct_t e, gridinfo_t f, double[] g, int h,
                        double[] i, int j, int l, SOLVEstruct_t m, double* n,
                        SuperLUStat_t o, int* p);
   unsafe void 	pzgsrfs (int a, SuperMatrix B, double c, LUstruct_t d,
                        ScalePermstruct_t e, gridinfo_t f, double[] g, int h,
                        double[] i, int j, int l, SOLVEstruct_t m, double* n,
                        SuperLUStat_t o, int* p);
                           
   //Improves the computed solution to a system of linear equations and provides error bounds and backward error estimates for the solution.
   unsafe void 	pdgsrfs_ABXglobal (int a, SuperMatrix B, double c, LUstruct_t d,
                                  gridinfo_t e, double f, int g, double* h, int i,
                                  int j, double* l, SuperLUStat_t m, int* n);
   unsafe void 	pzgsrfs_ABXglobal (int a, SuperMatrix B, double c, LUstruct_t d,
                                  gridinfo_t e, double f, int g, double* h, int i,
                                  int j, double* l, SuperLUStat_t m, int* n);
                                  
                                  
   unsafe int pdgsmv_AXglobal_setup (SuperMatrix A, Glu_persist_t b, gridinfo_t c,
                                     int* d, int*[] e, double*[] f,int*[] g, int[] h);
   unsafe int pzgsmv_AXglobal_setup (SuperMatrix A, Glu_persist_t b, gridinfo_t c,
                                     int* d, int*[] e, double*[] f,int*[] g, int[] h);
                                     
   unsafe int pdgsmv_AXglobal (int a, int[] b, double[] c, int[] d, double[] e,
                               double[] f);
   unsafe int pzgsmv_AXglobal (int a, int[] b, double[] c, int[] d, double[] e,
                               double[] f);
                               
   unsafe int pdgsmv_AXglobal_abs (int a, int[] b, double[] c, int[] d, double[] e,
                                   double[] f);
   unsafe int pzgsmv_AXglobal_abs (int a, int[] b, double[] c, int[] d, double[] e,
                                   double[] f);
                                   
   unsafe void pdgsmv_init (SuperMatrix A, int* b, gridinfo_t c, pdgsmv_comm_t d);
   unsafe void pzgsmv_init (SuperMatrix A, int* b, gridinfo_t c, pzgsmv_comm_t d);


   unsafe void pdgsmv (int a, SuperMatrix B, gridinfo_t c, pdgsmv_comm_t d, double[] x,
                       double[] ax);
   unsafe void pzgsmv (int a, SuperMatrix B, gridinfo_t c, pzgsmv_comm_t d, double[] x,
                       double[] ax);
   
   unsafe void pdgsmv_finalize (pdgsmv_comm_t a);
   unsafe void pzgsmv_finalize (pzgsmv_comm_t a);
} // end main interface 

} // end namespace 
