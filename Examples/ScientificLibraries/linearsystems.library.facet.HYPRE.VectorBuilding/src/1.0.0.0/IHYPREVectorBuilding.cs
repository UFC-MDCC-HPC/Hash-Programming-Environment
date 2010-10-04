using br.ufc.hpe.kinds;
using linearsystems.qualifier.HYPRE;
using linearsystems.library.facet.VectorBuilding;
using MPI;

namespace linearsystems.library.facet.HYPRE.VectorBuilding { 

public interface IHYPREVectorBuilding<L> : BaseIHYPREVectorBuilding<L>, IVectorBuildingFacet<L>
where L:IHYPRE
{
    //Interface Struct
	int hypre_StructVectorCreate ( Intracommunicator comm , hypre_StructGrid grid , hypre_StructVector vector );
	int hypre_StructVectorDestroy ( hypre_StructVector struct_vector );
	int hypre_StructVectorInitialize ( hypre_StructVector vector );
	unsafe int hypre_StructVectorSetValues ( hypre_StructVector vector , int* grid_index , double values );
	unsafe int hypre_StructVectorSetBoxValues ( hypre_StructVector vector , int* ilower , int* iupper , double* values );
	unsafe int hypre_StructVectorAddToValues ( hypre_StructVector vector , int* grid_index , double values );
	unsafe int hypre_StructVectorAddToBoxValues ( hypre_StructVector vector , int* ilower , int* iupper , double* values );
	int hypre_StructVectorScaleValues ( hypre_StructVector vector , double factor );
	unsafe int hypre_StructVectorGetValues ( hypre_StructVector vector , int* grid_index , double* values );
	unsafe int hypre_StructVectorGetBoxValues ( hypre_StructVector vector , int* ilower , int* iupper , double* values );
	int hypre_StructVectorAssemble ( hypre_StructVector vector );
	int hypre_StructVectorPrint ( string filename , hypre_StructVector vector , int all );
	unsafe int hypre_StructVectorSetNumGhost ( hypre_StructVector vector , int* num_ghost );
	int hypre_StructVectorCopy ( hypre_StructVector x , hypre_StructVector y );
	int hypre_StructVectorSetConstantValues ( hypre_StructVector vector , double values );
	int hypre_StructVectorGetMigrateCommPkg ( hypre_StructVector from_vector , hypre_StructVector to_vector , hypre_CommPkg comm_pkg );
	int hypre_StructVectorMigrate ( hypre_CommPkg comm_pkg , hypre_StructVector from_vector , hypre_StructVector to_vector );
	int hypre_CommPkgDestroy ( hypre_CommPkg comm_pkg );

} // end main interface 

} // end namespace 
