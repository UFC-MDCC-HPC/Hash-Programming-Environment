using br.ufc.pargo.hpe.kinds;
using jefferson.data.Data;

namespace skeleton.Farm.Work { 

public interface IWork<I, O> : BaseIWork<I, O>
where I:IData
where O:IData
{


} // end main interface 

} // end namespace 
