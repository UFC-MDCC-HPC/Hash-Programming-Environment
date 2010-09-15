using hpe.kinds;
using linearsystems.qualifier.SuperLU;
using linearsystems.library.facet.Setup;

namespace linearsystems.library.facet.SuperLU.Setup { 

public interface ISuperLUSetup<L> : BaseISuperLUSetup<L>, ISetup<L>
where L:ISuperLU
{


} // end main interface 

} // end namespace 
