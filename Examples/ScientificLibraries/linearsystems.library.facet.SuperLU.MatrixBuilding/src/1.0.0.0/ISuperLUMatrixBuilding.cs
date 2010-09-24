using br.ufc.hpe.kinds;
using linearsystems.qualifier.SuperLU;
using linearsystems.library.facet.MatrixBuilding;
using System.Runtime.InteropServices;



namespace linearsystems.library.facet.SuperLU.MatrixBuilding { 

	

  
 	
public interface ISuperLUMatrixBuilding<L> : BaseISuperLUMatrixBuilding<L>, IMatrixBuildingFacet<L>
where L:ISuperLU
{
   unsafe void dCreate_CompCol_Matrix_dist (SuperMatrix A, int b, int c, int d, double* e, int* f,
                                           int* g, Stype_t h, Dtype_t i, Mtype_t j);
   unsafe void zCreate_CompCol_Matrix_dist (SuperMatrix A, int b, int c, int d, double* e, int* f,
                                           int* g, Stype_t h, Dtype_t i, Mtype_t j);
   
   
   unsafe void dCreate_CompRowLoc_Matrix_dist (SuperMatrix A, int m, int n, int nnz_loc, int m_loc,
			                                                             int fst_row, double* nzval1, int* colind1, int* rowptr1,
		                                                             Stype_t stype, Dtype_t dtype, Mtype_t mtype);
   unsafe void zCreate_CompRowLoc_Matrix_dist (SuperMatrix A, int m, int n, int nnz_loc, int m_loc,
			                                                             int fst_row, double* nzval1, int* colind1, int* rowptr1,
			                                                             Stype_t stype, Dtype_t dtype, Mtype_t mtype);

   unsafe void dCompRow_to_CompCol_dist (int a, int b, int c, double* d, int* e, int* f,
                                        double** g, int** h, int** i);
   unsafe void zCompRow_to_CompCol_dist (int a, int b, int c, double* d, int* e, int* f,
                                        double** g, int** h, int** i);
   
   unsafe int pdCompRow_loc_to_CompCol_global (int a, SuperMatrix B, gridinfo_t c,
                                              SuperMatrix D);
   unsafe int pzCompRow_loc_to_CompCol_global (int a, SuperMatrix B, gridinfo_t c,
                                              SuperMatrix D);
                                              
   unsafe void dCopy_CompCol_Matrix_dist (SuperMatrix A, SuperMatrix B);
   unsafe void zCopy_CompCol_Matrix_dist (SuperMatrix A, SuperMatrix B);
   
   unsafe void dCreate_Dense_Matrix_dist (SuperMatrix A, int b, int c, double* d,
                                          int e, Stype_t stype, Dtype_t dtype,
                                          Mtype_t mtype);
   unsafe void zCreate_Dense_Matrix_dist (SuperMatrix A, int b, int c, double* d,
                                          int e, Stype_t stype, Dtype_t dtype,
                                          Mtype_t mtype);
   
                                          
   unsafe void dCreate_SuperNode_Matrix_dist (SuperMatrix A, int b, int c, int d,
                                              double* e, int* f, int* g, int* h,
                                              int* i, int* j, Stype_t stype,
                                              Dtype_t dtype, Mtype_t mtype);
   unsafe void zCreate_SuperNode_Matrix_dist (SuperMatrix A, int b, int c, int d,
                                              double* e, int* f, int* g, int* h,
                                              int* i, int* j, Stype_t stype,
                                              Dtype_t dtype, Mtype_t mtype);
   
                                              
   unsafe void dCopy_Dense_Matrix_dist (int a, int b, double* c, int d, double* e,
                                        int f);
   unsafe void zCopy_Dense_Matrix_dist (int a, int b, double* c, int d, double* e,
                                        int f);

                                        
   unsafe void dallocateA_dist (int a, int b, double** c, int** d, int** e);
   unsafe void zallocateA_dist (int a, int b, double** c, int** d, int** e);   
   
   unsafe void dGenXtrue_dist (int a, int b, double* c, int d);
   unsafe void zGenXtrue_dist (int a, int b, double* c, int d);
   
   
   unsafe void dFillRHS_dist (string a, int b, double* c, int d, SuperMatrix F,
                              double* g, int h);
   unsafe void zFillRHS_dist (string a, int b, double* c, int d, SuperMatrix F,
                              double* g, int h);
   
 //  unsafe int dcreate_matrix (SuperMatrix A, int b, double** c, int* d, double** e,
  //                            int* f, FILE* g, gridinfo_t* h);
  // unsafe int zcreate_matrix (SuperMatrix A, int b, double** c, int* d, double** e,
   //                           int* f, FILE* g, gridinfo_t* h);
                              
   //Equilibrar Matriz
   unsafe void dgsequ_dist (SuperMatrix A, double* r, double* c, double* rowcnd,
		                    double* colcnd,	double* amax, int* info);
   unsafe void zgsequ_dist (SuperMatrix A, double* r, double* c, double* rowcnd,
		                    double* colcnd,	double* amax, int* info);
	
		                    
   //retorna norma
   unsafe double dlangs_dist ( string norm, SuperMatrix A); 
   unsafe double zlangs_dist ( string norm, SuperMatrix A);
   
   //Equilibrar Matriz 
   unsafe void dlaqgs_dist (SuperMatrix A, double* r, double* c,double rowcnd,
		                    double colcnd, double  	amax, string equed);	
   unsafe void zlaqgs_dist (SuperMatrix A, double* r, double* c,double rowcnd,
		                    double colcnd, double  	amax, string equed);

	                    
   //Permutar matriz densa
   unsafe int pdPermute_Dense_Matrix(int a, int b, int[] c, int[] d, double[] e,
                                     int f, double[] g, int h, int i, gridinfo_t j);
   unsafe int pzPermute_Dense_Matrix(int a, int b, int[] c, int[] d, double[] e,
                                     int f, double[] g, int h, int i, gridinfo_t j);
                                     
   //Distribui matriz em malha 2D
   unsafe int ddistribute(fact_t fact,int	n,SuperMatrix 	A, Glu_freeable_t Glu_freeable,
                          LUstruct_t LUstruct,	gridinfo_t grid);
   unsafe int zdistribute(fact_t fact,int	n,SuperMatrix 	A, Glu_freeable_t Glu_freeable,
                          LUstruct_t LUstruct,	gridinfo_t grid);
                             
   unsafe int pddistribute (fact_t a, int b, SuperMatrix C, ScalePermstruct_t d,
                            Glu_freeable_t e, LUstruct_t g, gridinfo_t h);
   unsafe int pzdistribute (fact_t a, int b, SuperMatrix C, ScalePermstruct_t d,
                            Glu_freeable_t e, LUstruct_t g, gridinfo_t h);
                            
   //finds a row permutation so that the matrix has large entries on the diagonal.
   unsafe void dldperm (int	 job,int  	n, int  	nnz, int[]	colptr,	int[] adjncy,
		               double[]	nzval, int*  	perm, double[]	u, double[] v); 		                    	
   unsafe void zldperm (int	 job,int  	n, int  	nnz, int[]	colptr,	int[] adjncy,
		               double[]	nzval, int*  	perm, double[]	u, double[] v); 		                    	
   
   //Destroy distributed L & U matrices. 
   unsafe void 	Destroy_LU (int a, gridinfo_t b, LUstruct_t c);
   
   //Allocate storage in LUstruct. 
   //unsafe void LUstructInit (const int a, const int b, LUstruct_t c);
   
   //Deallocate LUstruct.
   unsafe void 	LUstructFree (LUstruct_t a);
   
   //Fills a double precision array with a given value.	
   unsafe void dfill_dist (double* a, int b, double c);
   unsafe void zfill_dist (double* a, int b, double c);
    	
   //Check the inf-norm of the error vector.
   unsafe void 	dinf_norm_error_dist (int a, int b,double* c, int d, double* e,
                                      int f, gridinfo_t g);
   unsafe void 	zinf_norm_error_dist (int a, int b,double* c, int d, double* e,
                                      int f, gridinfo_t g);
 	 	
   //Check the inf-norm of the error vector
   unsafe void 	pdinf_norm_error (int a, int b, int c, double[] d, int e, double[] f,
                                  int g, gridinfo_t h);
   unsafe void 	zdinf_norm_error (int a, int b, int c, double[] d, int e, double[] f,
                                  int g, gridinfo_t h);
 	
   // Read a DOUBLE PRECISION matrix stored in Harwell-Boeing format 
  // unsafe void dreadhb_dist (int iam,FILE*	fp,	int*  	nrow, int*  ncol,int* nonz,
	//	                     double** nzval, int**	rowind, int** colptr);
   //unsafe void zreadhb_dist (int iam,FILE*	fp,	int*  	nrow, int*  ncol,int* nonz,
	//	                     double** nzval, int**	rowind, int** colptr);
   
   //  Distribute the input matrix onto the 2D process mesh.		                     
   unsafe int ddist_psymbtonum	(fact_t fact, int 	n,	SuperMatrix A, ScalePermstruct_t ScalePermstruct,
		                        Pslu_freeable_t	Pslu_freeable,	LUstruct_t LUstruct, gridinfo_t grid);
   unsafe int zdist_psymbtonum	(fact_t fact, int 	n,	SuperMatrix A, ScalePermstruct_t ScalePermstruct,
		                        Pslu_freeable_t	Pslu_freeable,	LUstruct_t LUstruct, gridinfo_t grid);
		                        
   //Print the blocks in the factored matrix L.
   unsafe void 	dPrintLblocks (int a, int b, gridinfo_t c, Glu_persist_t d,
                               LocalLU_t e);
   unsafe void 	zPrintLblocks (int a, int b, gridinfo_t c, Glu_persist_t d,
                               LocalLU_t e);
   
    //Print the blocks in the factored matrix U.
   unsafe void 	dPrintUblocks (int a, int b, gridinfo_t c, Glu_persist_t d,
                               LocalLU_t e);
   unsafe void 	zPrintUblocks (int a, int b, gridinfo_t c, Glu_persist_t d,
                               LocalLU_t e);
 	
   unsafe void 	dPrint_CompCol_Matrix_dist (SuperMatrix A);
   unsafe void 	zPrint_CompCol_Matrix_dist (SuperMatrix A);
   
   unsafe void 	dPrint_Dense_Matrix_dist (SuperMatrix A);
   unsafe void 	zPrint_Dense_Matrix_dist (SuperMatrix A);
   
   unsafe int dPrint_CompRowLoc_Matrix_dist (SuperMatrix A);
   unsafe int zPrint_CompRowLoc_Matrix_dist (SuperMatrix A);
   
   unsafe int dgemm_ (string a, string b, int* c, int* d, int* e, double* f,
                      double* g, int* h, double* i, int* j, double* l, double* m, int* n);
   unsafe int zgemm_ (string a, string b, int* c, int* d, int* e, double* f,
                      double* g, int* h, double* i, int* j, double* l, double* m, int* n);
   
                      
   unsafe int dtrsv_ (string a, string b, string c, int* d , double* e,int* f,
                      double* g, int* h);
   unsafe int ztrsv_ (string a, string b, string c, int* d , double* e,int* f,
                      double* g, int* h);
   
   unsafe int dger_ (int* a, int* b, double* c, double* d, int* e, double* f, int* g,
                     double* h, int* i);
   unsafe int zger_ (int* a, int* b, double* c, double* d, int* e, double* f, int* g,
                     double* h, int* i);
 	
} // end main interface 

} // end namespace 
