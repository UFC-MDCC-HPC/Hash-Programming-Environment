/* AUTOMATICALLY GENERATE CODE */

using hpe.kinds;
using jefferson.data.Data;

namespace skeleton.Farm.Work { 

public interface BaseIWork<I, O> : IComputationKind 
where I:IData
where O:IData
{

	O Output_data {set;}
	I Input_data {set;}


} // end main interface 

} // end namespace 
