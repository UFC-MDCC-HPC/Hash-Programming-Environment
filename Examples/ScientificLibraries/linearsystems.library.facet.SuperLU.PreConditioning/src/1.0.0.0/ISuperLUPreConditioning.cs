using br.ufc.hpe.kinds;
using linearsystems.qualifier.SuperLU;
using linearsystems.library.facet.PreConditioning;

namespace linearsystems.library.facet.SuperLU.PreConditioning { 

public interface ISuperLUPreConditioning<L> : BaseISuperLUPreConditioning<L>, IPreConditioningFacet<L>
where L:ISuperLU
{
   //there is no method

} // end main interface 

} // end namespace 
