using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;

namespace lu.problem_size.Instance { 
   
    public enum PROBLEM_CLASS {U, S, W, A, B, C};

	public interface IInstance<C> : BaseIInstance<C>
	where C:IClass {
	
		double dt {get;}
		int itmax {get;}
		int inorm {get;}
		int isiz01 {get;}
		int isiz02 {get;}
		int isiz03 {get;}
		int isiz3 {get;}
		PROBLEM_CLASS CLASS { get; }
			
	}
}
