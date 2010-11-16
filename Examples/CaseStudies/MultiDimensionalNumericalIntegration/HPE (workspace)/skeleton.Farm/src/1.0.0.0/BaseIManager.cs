/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using environment.MPIDirect;
using jefferson.data.Data;
using skeleton.Farm.Distribute;
using skeleton.Farm.Collect;

namespace skeleton.Farm { 

public interface BaseIManager<I, S, O, G> : IComputationKind 
where I:IData
where S:IDistribute<I>
where O:IData
where G:ICollect<O>
{

	IMPIDirect Mpi {set;}
	O Output_data {set;}
	I Input_data {set;}


} // end main interface 

} // end namespace 
