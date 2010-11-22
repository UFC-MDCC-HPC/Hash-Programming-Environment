/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.user.qualifier.ConjugateGradient;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.user.qualifier.PreConditioner;
using linearsystems.user.computation.Solver;

namespace linearsystems.user.HYPRE.computation.impl.HYPRE_Solver_Example { 

public abstract class BaseIHyprePCGSolver<LIB, MPT, PRC, MTH>: Computation, BaseISolver<LIB, MPT, PRC, MTH>
where LIB:IHYPRE
where MPT:ISparseMatrix<LIB>
where PRC:IPreConditioner<LIB, MPT>
where MTH:IConjugateGradient<LIB, MPT, PRC>
{

protected MTH solution_method = default(MTH);

protected MTH Solution_method {
	set {
		this.solution_method = value;
	}
}


public BaseIHyprePCGSolver() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000115843cfbd21fb68741d7c5b0b0cc4eb089653e9d9d4c94d0278c11e2ef2f64588cbbe061bb4ba1355594f54bb93d3ff2e49ae53ac704165cf4015b29fca876cebe34fcf592137b9d488866201b267b10b89e100d03ec0b2509c15ef7fab8505913c3fc901e6626cb5bac5394bb5ef066a95a46e42dc33c3abbf9a2c17a77bc7";

override public void createSlices() {
	base.createSlices();
	this.Solution_method = (MTH) BackEnd.createSlice(this, UID,"solution_method","solution_method",new Type[] {typeof(LIB),typeof(MPT),typeof(PRC)});
} 

abstract public void compute(); 


}

}
