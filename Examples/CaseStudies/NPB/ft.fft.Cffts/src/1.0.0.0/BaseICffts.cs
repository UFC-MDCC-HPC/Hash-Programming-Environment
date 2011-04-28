/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;
using ft.data.ProblemDefinition;
using ft.problem_size.Instance;
using common.problem_size.Class;
using common.orientation.Axis;

namespace ft.fft.Cffts { 

public interface BaseICffts<I, C, DIR> : IComputationKind 
where I:IInstance<C>
where C:IClass
where DIR:IAxis
{

	IBlocks Blocks {get;}
	IProblemDefinition<I, C> Problem {get;}


} // end main interface 

} // end namespace 
