using br.ufc.pargo.hpe.kinds;
using data.Function;
using data.IntegralCase;
using skeleton.Farm.Distribute;

namespace skeleton.Farm.Distribute.DistributeInterval { 

public interface IDistributeIntervalSend<F, Ds> : BaseIDistributeIntervalSend<F, Ds>, IDistribute<Ds>
where F:IFunction
where Ds:IIntegralCase<F>
{


} // end main interface 

} // end namespace 
