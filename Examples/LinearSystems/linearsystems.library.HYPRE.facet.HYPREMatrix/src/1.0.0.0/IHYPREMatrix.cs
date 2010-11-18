using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.facet.LSSFacetMatrix;
using linearsystems.library.HYPRE;

namespace linearsystems.library.HYPRE.facet.HYPREMatrix { 

public interface IHYPREMatrix : BaseIHYPREMatrix, IFacetMatrix<HYPRE>
{
	int hypre_StructMatrixCreate ( Intracommunicator comm , hypre_StructGrid grid , hypre_StructStencil stencil , hypre_StructMatrix  matrix );
	int hypre_StructMatrixDestroy ( hypre_StructMatrix matrix );
	int hypre_StructMatrixInitialize ( hypre_StructMatrix matrix );
	unsafe int  hypre_StructMatrixSetValues ( hypre_StructMatrix matrix , int* grid_index , int num_stencil_indices , int* stencil_indices , double* values );
	unsafe int hypre_StructMatrixGetValues ( hypre_StructMatrix matrix , int* grid_index , int num_stencil_indices , int* stencil_indices , double* values );
	unsafe int hypre_StructMatrixSetBoxValues ( hypre_StructMatrix matrix , int* ilower , int* iupper , int num_stencil_indices , int* stencil_indices , double* values );
	unsafe int hypre_StructMatrixGetBoxValues ( hypre_StructMatrix matrix , int* ilower , int* iupper , int num_stencil_indices , int* stencil_indices , double* values );
	unsafe int hypre_StructMatrixSetConstantValues ( hypre_StructMatrix matrix , int num_stencil_indices , int* stencil_indices , double* values );
	unsafe int hypre_StructMatrixAddToValues ( hypre_StructMatrix matrix , int* grid_index , int num_stencil_indices , int* stencil_indices , double* values );
	unsafe int hypre_StructMatrixAddToBoxValues ( hypre_StructMatrix matrix , int* ilower , int* iupper , int num_stencil_indices , int* stencil_indices , double* values );
	unsafe int hypre_StructMatrixAddToConstantValues ( hypre_StructMatrix matrix , int num_stencil_indices , int* stencil_indices , double* values );
	int hypre_StructMatrixAssemble ( hypre_StructMatrix matrix );
	unsafe int hypre_StructMatrixSetNumGhost ( hypre_StructMatrix matrix , int* num_ghost );
	int hypre_StructMatrixGetGrid ( hypre_StructMatrix matrix , hypre_StructGrid  grid );
	int hypre_StructMatrixSetSymmetric ( hypre_StructMatrix matrix , int symmetric );
	unsafe int hypre_StructMatrixSetConstantEntries ( hypre_StructMatrix matrix , int nentries , int* entries );
	int hypre_StructMatrixPrint ( string filename , hypre_StructMatrix matrix , int all );
	int hypre_StructMatrixMatvec ( double alpha , hypre_StructMatrix A , hypre_StructVector x , double beta , hypre_StructVector y );


} // end main interface 

} // end namespace 
