/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;
using ft.data.ProblemDefinition;
using ft.problem_size.Instance;
using common.problem_size.Class;

namespace ft.data.FftInit { 

public interface BaseIFftInit<I, C> : IComputationKind 
where I:IInstance<C>
where C:IClass
{

	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}


} // end main interface 

} // end namespace 
