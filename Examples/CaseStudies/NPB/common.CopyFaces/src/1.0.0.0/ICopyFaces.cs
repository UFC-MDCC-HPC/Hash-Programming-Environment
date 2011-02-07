using br.ufc.pargo.hpe.kinds;
using common.problem_size.Instance;
using common.problem_size.Class;

namespace common.CopyFaces { 

public interface ICopyFaces<I,C> : BaseICopyFaces<I,C>
		where I:IInstance<C>
		where C:IClass
{

} // end main interface 

} // end namespace 
