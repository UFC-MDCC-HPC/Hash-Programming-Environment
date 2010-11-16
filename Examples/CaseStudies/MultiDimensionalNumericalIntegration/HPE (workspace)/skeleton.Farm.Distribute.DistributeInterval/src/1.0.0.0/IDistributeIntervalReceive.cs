using br.ufc.pargo.hpe.kinds;
using data.Function;
using data.List;
using data.IntegralCase;
using skeleton.Farm.Distribute;

namespace skeleton.Farm.Distribute.DistributeInterval { 

public interface IDistributeIntervalReceive<F, Dt> : BaseIDistributeIntervalReceive<F, Dt>, IReceive<Dt>
where F:IFunction
where Dt:IList<IIntegralCase<F>>
{


} // end main interface 

} // end namespace 
