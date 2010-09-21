using br.ufc.hpe.kinds;
using linearsystems.qualifier.SuperLU;
using linearsystems.library.facet.MatrixBuilding;
using System.Runtime.InteropServices;



namespace linearsystems.library.facet.SuperLU.MatrixBuilding { 

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

  
 	
public interface ISuperLUMatrixBuilding<L> : BaseISuperLUMatrixBuilding<L>, IMatrixBuildingFacet<L>
where L:ISuperLU
{


} // end main interface 

} // end namespace 
