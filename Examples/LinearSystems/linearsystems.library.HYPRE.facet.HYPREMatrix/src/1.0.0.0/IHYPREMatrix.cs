using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.facet.LSSFacetMatrix;
using linearsystems.library.HYPRE;

namespace linearsystems.library.HYPRE.facet.HYPREMatrix { 

using MPI_Comm = System.IntPtr;

public interface IHYPREMatrix : BaseIHYPREMatrix, IFacetMatrix<IHYPRE>
{
	int HYPRE_IJMatrixCreate(MPI_Comm comm, int ilower, int iupper, int jlower, int jupper, out HYPRE_IJMatrix matrix);
  	int HYPRE_IJMatrixPrint(HYPRE_IJMatrix matrix, string filename);
    int HYPRE_IJMatrixDestroy(HYPRE_IJMatrix matrix);
    int HYPRE_IJMatrixInitialize(HYPRE_IJMatrix matrix);
    int HYPRE_IJMatrixSetValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values);
    int HYPRE_IJMatrixAddToValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values);
    int HYPRE_IJMatrixAssemble(HYPRE_IJMatrix matrix);
    int HYPRE_IJMatrixGetRowCounts(HYPRE_IJMatrix matrix, int nrows, int[] rows, int[] ncols);
    int HYPRE_IJMatrixGetValues(HYPRE_IJMatrix matrix, int nrows, int[] ncols, int[] rows, int[] cols, double[] values);
    int HYPRE_IJMatrixSetObjectType(HYPRE_IJMatrix matrix, int type);
    int HYPRE_IJMatrixGetObjectType(HYPRE_IJMatrix matrix, out int type);
    int HYPRE_IJMatrixGetLocalRange(HYPRE_IJMatrix matrix, ref int ilower, ref int iupper, ref int jlower, ref int jupper);
    int HYPRE_IJMatrixGetObject(HYPRE_IJMatrix matrix, out HYPRE_ParCSR_matrix mtx_object);
    int HYPRE_IJMatrixSetRowSizes(HYPRE_IJMatrix matrix, int[] sizes); 
    int HYPRE_IJMatrixSetDiagOffdSizes(HYPRE_IJMatrix matrix, int[] diag_sizes, int[] offdiag_sizes);
    int HYPRE_IJMatrixSetMaxOffProcElmts(HYPRE_IJMatrix matrix, int max_off_proc_elmts);

} // end main interface 

} // end namespace 
