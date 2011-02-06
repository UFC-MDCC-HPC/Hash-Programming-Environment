/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace common.datapartition.Blocks3D { 

public interface BaseIBlocks3D<I,C> : IEnvironmentKind 
where I:IInstance<C>
where C:IClass
{

	ICell Z {get;}
	ICell Y {get;}
	ICell X {get;}
	IBlocks Blocks {get;}


} // end main interface 

} // end namespace 
