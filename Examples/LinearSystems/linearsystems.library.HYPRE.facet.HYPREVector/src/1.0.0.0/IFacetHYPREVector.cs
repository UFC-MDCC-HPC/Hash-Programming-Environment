using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.facet.LSSFacetVector;
using linearsystems.library.HYPRE;

namespace linearsystems.library.HYPRE.facet.HYPREVector { 

		using MPI_Comm = System.IntPtr;

public interface IFacetHYPREVector<L> : BaseIFacetHYPREVector<L>, IFacetVector<L>
where L:IHYPRE
{
   int HYPRE_IJVectorCreate(MPI_Comm comm, int jlower, int jupper, out HYPRE_IJVector vector);
   int HYPRE_IJVectorPrint(HYPRE_IJVector vector, string file);
   int HYPRE_IJVectorDestroy(HYPRE_IJVector vector);        
   int HYPRE_IJVectorInitialize(HYPRE_IJVector vector);        
   int HYPRE_IJVectorSetMaxOffProcElmts(HYPRE_IJVector vector, int max_off_proc_elmts);        
   int HYPRE_IJVectorSetValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values);        
   int HYPRE_IJVectorAddToValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values);        
   int HYPRE_IJVectorAssemble(HYPRE_IJVector vector);        
   int HYPRE_IJVectorGetValues(HYPRE_IJVector vector, int nvalues, int[] indices, double[] values);
   int HYPRE_IJVectorSetObjectType(HYPRE_IJVector vector, int type);        
   int HYPRE_IJVectorGetObjectType(HYPRE_IJVector vector, out int type);        
   int HYPRE_IJVectorGetLocalRange(HYPRE_IJVector vector, out int jlower, out int jupper);        
   int HYPRE_IJVectorGetObject(HYPRE_IJVector vector, out HYPRE_ParCRS_vector mtx_object);
} // end main interface 

} // end namespace 
