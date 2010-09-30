using br.ufc.hpe.kinds;
using linearsystems.qualifier.HYPRE;
using linearsystems.library.facet.Setup;
using MPI;

namespace linearsystems.library.facet.HYPRE.Setup { 

public interface IHYPRESetup<L> : BaseIHYPRESetup<L>, ISetup<L>
where L:IHYPRE
{


	int  hypre_StructGridCreate (Intracommunicator comm, int ndim, hypre_StructGrid grid);
	int  hypre_StructGridDestroy (hypre_StructGrid grid);
	unsafe int  hypre_StructGridSetExtents (hypre_StructGrid grid, int* ilower, int* iupper);
	int  hypre_StructGridAssemble (hypre_StructGrid grid);
	unsafe int  hypre_StructGridSetPeriodic (hypre_StructGrid grid, int* periodic);
	unsafe int  hypre_StructGridSetNumGhost (hypre_StructGrid grid, int* num_ghost);
   
    int   hypre_StructStencilCreate (int ndim, int size, hypre_StructStencil stencil);
          
	int      hypre_StructStencilDestroy (hypre_StructStencil stencil);
	unsafe int  hypre_StructStencilSetElement (hypre_StructStencil stencil, int entry, int* offset);
    

} // end main interface 

} // end namespace 
