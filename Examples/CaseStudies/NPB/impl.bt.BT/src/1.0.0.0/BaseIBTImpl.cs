/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.topology.Ring;
using common.datapartition.BlocksInfo;
using bt.problem_size.Instance_BT;
using common.data.ProblemDefinition;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.datapartition.Blocks3D;
using common.data.Initialize;
using bt.ADI;
using common.data.ExactRHS;
using environment.MPIDirect;
using common.benchmarking.Timer;
using common.Verify;
using common.data.LHSInit;
using bt.BT;

namespace impl.bt.BT { 

public abstract class BaseIBTImpl<IClass>: Application, BaseIBT<IClass>
{

private ICell y = null;

protected ICell Y {
	get {
		if (this.y == null)
			this.y = (ICell) Services.getPort();
		return this.y;
	}
}

private ICell z = null;

protected ICell Z {
	get {
		if (this.z == null)
			this.z = (ICell) Services.getPort();
		return this.z;
	}
}

private ICell x = null;

protected ICell X {
	get {
		if (this.x == null)
			this.x = (ICell) Services.getPort();
		return this.x;
	}
}

private ICell cell = null;

protected ICell Cell {
	get {
		if (this.cell == null)
			this.cell = (ICell) Services.getPort();
		return this.cell;
	}
}

private ICell x = null;

protected ICell X {
	get {
		if (this.x == null)
			this.x = (ICell) Services.getPort();
		return this.x;
	}
}

private ICell y = null;

protected ICell Y {
	get {
		if (this.y == null)
			this.y = (ICell) Services.getPort();
		return this.y;
	}
}

private ICell z = null;

protected ICell Z {
	get {
		if (this.z == null)
			this.z = (ICell) Services.getPort();
		return this.z;
	}
}

private IBlocks blocks = null;

protected IBlocks Blocks {
	get {
		if (this.blocks == null)
			this.blocks = (IBlocks) Services.getPort();
		return this.blocks;
	}
}

private IInstance_BT instance = null;

protected IInstance_BT Instance {
	get {
		if (this.instance == null)
			this.instance = (IInstance_BT) Services.getPort();
		return this.instance;
	}
}

private IProblemDefinition<IInstance<IClass>> problem = null;

protected IProblemDefinition<IInstance<IClass>> Problem {
	get {
		if (this.problem == null)
			this.problem = (IProblemDefinition<IInstance<IClass>>) Services.getPort();
		return this.problem;
	}
}

private IBlocks3D<IInstance<IClass>> process = null;

protected IBlocks3D<IInstance<IClass>> Process {
	get {
		if (this.process == null)
			this.process = (IBlocks3D<IInstance<IClass>>) Services.getPort();
		return this.process;
	}
}

private IInitialize<IInstance<IClass>> initialize = null;

protected IInitialize<IInstance<IClass>> Initialize {
	get {
		if (this.initialize == null)
			this.initialize = (IInitialize<IInstance<IClass>>) Services.getPort();
		return this.initialize;
	}
}

private IADI adi = null;

protected IADI Adi {
	get {
		if (this.adi == null)
			this.adi = (IADI) Services.getPort();
		return this.adi;
	}
}

private IExactRHS<IInstance<IClass>> exact_rhs = null;

protected IExactRHS<IInstance<IClass>> Exact_rhs {
	get {
		if (this.exact_rhs == null)
			this.exact_rhs = (IExactRHS<IInstance<IClass>>) Services.getPort();
		return this.exact_rhs;
	}
}

private IMPIDirect mpi = null;

protected IMPIDirect Mpi {
	get {
		if (this.mpi == null)
			this.mpi = (IMPIDirect) Services.getPort();
		return this.mpi;
	}
}

private ITimer timer = null;

protected ITimer Timer {
	get {
		if (this.timer == null)
			this.timer = (ITimer) Services.getPort();
		return this.timer;
	}
}

private IVerify<IInstance<IClass>> verify = null;

protected IVerify<IInstance<IClass>> Verify {
	get {
		if (this.verify == null)
			this.verify = (IVerify<IInstance<IClass>>) Services.getPort();
		return this.verify;
	}
}

private ILHSInit<IInstance<IClass>> lhsinit = null;

protected ILHSInit<IInstance<IClass>> Lhsinit {
	get {
		if (this.lhsinit == null)
			this.lhsinit = (ILHSInit<IInstance<IClass>>) Services.getPort();
		return this.lhsinit;
	}
}


public BaseIBTImpl() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000039b582fe463a1ff49c270b45eadadbac5a59b0dac54fe433fc17aea566349527ef4ea467332d7f2165fa5ca2d000127117ee4354ccc448d9a68a2581f26f97f6a0f438110f0858e8e72165783986dc4c6ea118840b0b1b20ec4bdbd98ba6d22cf214dac3ae467cd900f96187ea0d5b153e7291d8a5850ae2270eb951122a5f96";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
