/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;
using common.data.ProblemDefinition;
using common.problem_size.Class;
using common.problem_size.Instance;

namespace common.Add { 

public interface BaseIAdd<I,C> : IComputationKind 
		where I:IInstance<C>
		where C:IClass
{

	IBlocks Blocks {get;}
	IProblemDefinition<I,C> Problem {get;}


} // end main interface 

} // end namespace 
