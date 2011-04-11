using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using sp.ADI;

namespace impl.sp.solve.ADI { 

public class IADIImpl<C> : BaseIADIImpl<C>, IADI<C>
where C:IClass
{

public override int go() 
{ 
	int no_nodes = Ranks.Length;
	if (no_nodes > 1) {
	   Copy_faces.go();
	}
	Compute_rhs.go();
	Txinvr.go();
	X_solve.go();
	Y_solve.go();
	Z_solve.go();
	Add.go();
			
	//Console.WriteLine("Iterate !!!");
			
	return 0;
}

} // end activate method 

}

