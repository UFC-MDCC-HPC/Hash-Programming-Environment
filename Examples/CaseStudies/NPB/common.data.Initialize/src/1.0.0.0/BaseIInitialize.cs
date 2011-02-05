/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace common.data.Initialize { 

public interface BaseIInitialize<I, C> : IComputationKind 
where I:IInstance<C>
where C:IClass
{

	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}


} // end main interface 

} // end namespace 
