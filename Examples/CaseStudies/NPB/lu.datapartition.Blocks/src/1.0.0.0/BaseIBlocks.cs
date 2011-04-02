/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using lu.topology.Mesh;
using lu.datapartition.BlocksInfo;
using lu.topology.Neighbors;
using lu.problem_size.Instance;
using common.problem_size.Class;

namespace lu.datapartition.Blocks { 

public interface BaseIBlocks<I, C> : IEnvironmentKind 
where I:IInstance<C>
where C:IClass
{

	ICell Cell {get;}
	IBlocksInfo Blocks {get;}


} // end main interface 

} // end namespace 
