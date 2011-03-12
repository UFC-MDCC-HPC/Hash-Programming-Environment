using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using bt.ADI;

namespace impl.bt.ADI { 

public class IADIImpl<C> : BaseIADIImpl<C>, IADI<C>
where C:IClass
{

public override void compute(){ 
	Copy_faces.synchronize();
	X_solve.compute();
	Y_solve.compute();
	Z_solve.compute();
	Add.compute();
} 

} // end activate method 

}
