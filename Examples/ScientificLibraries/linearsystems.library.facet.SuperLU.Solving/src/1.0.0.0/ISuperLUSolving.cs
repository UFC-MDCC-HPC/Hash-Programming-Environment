using hpe.kinds;
using linearsystems.qualifier.SuperLU;
using linearsystems.library.facet.Solving;

namespace linearsystems.library.facet.SuperLU.Solving { 

public interface ISuperLUSolving<L> : BaseISuperLUSolving<L>, ISolvingFacet<L>
where L:ISuperLU
{


} // end main interface 

} // end namespace 
