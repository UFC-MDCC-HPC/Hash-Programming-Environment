using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using bt.solve.BeamWarmingMethod;
using bt.solve.BlockDiagonalMatVecProduct;

namespace impl.bt.solve.MatVecSub { 

public class IMatVecSubImpl<I, C, MTH> : BaseIMatVecSubImpl<I, C, MTH>, IBlockDiagonalMatVecProduct<I, C, MTH>
where I:IInstance_BT<C>
where C:IClass
where MTH:IBeamWarmingMethod
{
private double[,,] ablock;
private double[,,,,] avec;
private double[,,,,] bvec;
private int ab1, av1, av2, av3, av4, bv1, bv2, bv3, bv4;

public void matvec_sub(double[,,] ablock, double[,,,,] avec, double[,,,,] bvec, int ab1, int av1, int av2, int av3, int av4, int bv1, int bv2, int bv3, int bv4) {
	this.ablock = ablock;
	this.avec = avec;
	this.bvec = bvec;
	this.ab1 = ab1;
	this.av1 = av1;
	this.av2 = av2;
	this.av3 = av3;
	this.av4 = av4;
	this.bv1 = bv1;
	this.bv2 = bv2;
	this.bv3 = bv3;
	this.bv4 = bv4;
}

public IMatVecSubImpl() { 

} 

public override void compute() { 
	bvec[bv1, bv2, bv3, bv4, 0] = bvec[bv1, bv2, bv3, bv4, 0] - ablock[ab1, 0, 0] * avec[av1, av2, av3, av4, 0] - ablock[ab1, 1, 0] * avec[av1, av2, av3, av4, 1] - ablock[ab1, 2, 0] * avec[av1, av2, av3, av4, 2] - ablock[ab1, 3, 0] * avec[av1, av2, av3, av4, 3] - ablock[ab1, 4, 0] * avec[av1, av2, av3, av4, 4];
	bvec[bv1, bv2, bv3, bv4, 1] = bvec[bv1, bv2, bv3, bv4, 1] - ablock[ab1, 0, 1] * avec[av1, av2, av3, av4, 0] - ablock[ab1, 1, 1] * avec[av1, av2, av3, av4, 1] - ablock[ab1, 2, 1] * avec[av1, av2, av3, av4, 2] - ablock[ab1, 3, 1] * avec[av1, av2, av3, av4, 3] - ablock[ab1, 4, 1] * avec[av1, av2, av3, av4, 4];
	bvec[bv1, bv2, bv3, bv4, 2] = bvec[bv1, bv2, bv3, bv4, 2] - ablock[ab1, 0, 2] * avec[av1, av2, av3, av4, 0] - ablock[ab1, 1, 2] * avec[av1, av2, av3, av4, 1] - ablock[ab1, 2, 2] * avec[av1, av2, av3, av4, 2] - ablock[ab1, 3, 2] * avec[av1, av2, av3, av4, 3] - ablock[ab1, 4, 2] * avec[av1, av2, av3, av4, 4];
	bvec[bv1, bv2, bv3, bv4, 3] = bvec[bv1, bv2, bv3, bv4, 3] - ablock[ab1, 0, 3] * avec[av1, av2, av3, av4, 0] - ablock[ab1, 1, 3] * avec[av1, av2, av3, av4, 1] - ablock[ab1, 2, 3] * avec[av1, av2, av3, av4, 2] - ablock[ab1, 3, 3] * avec[av1, av2, av3, av4, 3] - ablock[ab1, 4, 3] * avec[av1, av2, av3, av4, 4];
	bvec[bv1, bv2, bv3, bv4, 4] = bvec[bv1, bv2, bv3, bv4, 4] - ablock[ab1, 0, 4] * avec[av1, av2, av3, av4, 0] - ablock[ab1, 1, 4] * avec[av1, av2, av3, av4, 1] - ablock[ab1, 2, 4] * avec[av1, av2, av3, av4, 2] - ablock[ab1, 3, 4] * avec[av1, av2, av3, av4, 3] - ablock[ab1, 4, 4] * avec[av1, av2, av3, av4, 4];
} // end activate method 

}

}