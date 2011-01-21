/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using br.ufc.lia.pargo.hpe.casestudies.npb.common.topology.Ring;
using br.ufc.lia.pargo.hpe.casestudies.npb.common.datapartition.BlocksInfo;
using br.ufc.lia.pargo.hpe.casestudies.npb.common.data.ProblemDefinition;
using br.ufc.lia.pargo.hpe.casestudies.npb.common.datapartition.Blocks3D;

namespace br.ufc.lia.pargo.hpe.casestudies.npb.sp.ADI { 

public interface BaseIADI : IComputationKind 
{

	IProblemDefinition Problem {set;}
	IBlocks3D Data_partition {set;}


} // end main interface 

} // end namespace 
