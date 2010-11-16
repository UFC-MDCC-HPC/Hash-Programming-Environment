/* AUTOMATICALLY GENERATE CODE */

using br.ufc.pargo.hpe.kinds;
using data.Function;
using data.List;
using data.IntegralCase;
using skeleton.Farm.Distribute;

namespace skeleton.Farm.Distribute.DistributeInterval { 

public interface BaseIDistributeIntervalReceive<F, Dt> : BaseIReceive<Dt>, ISynchronizerKind 
where F:IFunction
where Dt:IList<IIntegralCase<F>>
{



} // end main interface 

} // end namespace 
