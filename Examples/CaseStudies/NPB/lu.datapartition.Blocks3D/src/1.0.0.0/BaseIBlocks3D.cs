/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.datapartition.BlocksInfo;
using lu.topology.Neighbors;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.datapartition.Blocks3D { 

public interface BaseIBlocks3D<I, C> : IEnvironmentKind 
where I:IInstance<C>
where C:IClass
{

	IBlocksInfo Blocks {get;}
	INeighbors Neighbors {get;}


} // end main interface 

} // end namespace 
