/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.SuperLU.facet.SuperLUVector;
using linearsystems.library.SuperLU.facet.SuperLUPreConditioner;
using linearsystems.library.SuperLU.facet.SuperLUSetup;
using linearsystems.library.SuperLU.facet.SuperLUSolver;
using environment.messagepassing.Communicator;
using linearsystems.library.SuperLU.facet.SuperLUMatrix;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.library.SuperLU.domain.impl.LSSDomainSuperLU { 

public abstract class BaseLSSDomainSuperLU<V, S, M, P, R>: Domain, BaseILSSDomain<V, S, M, P, R>
where V:ISuperLUVector
where S:ISuperLUSetup
where M:ISuperLUMatrix
where P:ISuperLUPreConditioner
where R:ISuperLUSolver
{

protected V v = default(V);

protected V V {
	set {
		this.v = value;
	}
}

protected P p = default(P);

protected P P {
	set {
		this.p = value;
	}
}

protected S s = default(S);

protected S S {
	set {
		this.s = value;
	}
}

protected R r = default(R);

protected R R {
	set {
		this.r = value;
	}
}

protected ICommunicator comm = null;

protected ICommunicator Comm {
	set {
		this.comm = value;
	}
}

protected M m = default(M);

protected M M {
	set {
		this.m = value;
	}
}


public BaseLSSDomainSuperLU() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000049bddda308c4f2a8b5fcd4fc155331fa3b6fc605e1591fcb59925795280bdedfe115d60d452e3897fd589236b90c44c8c0a74bd1e12c47ace94fc933f93b68b8e24c4eb347bacbad930ea570c41c5e612d1408c9c54d8027e48522bc57384fa9f59b6f90b844d31532dbfdc65db2ef2e970db1d145351a04ed7689b5c3a7f6a0";

override public void createSlices() {
	base.createSlices();
	this.M = (M) BackEnd.createSlice(this, UID,"matrix","facet_unit",new Type[] {});
	this.Comm = (ICommunicator) BackEnd.createSlice(this, UID,"comm","comm",new Type[] {});
	this.R = (R) BackEnd.createSlice(this, UID,"solver","facet_unit",new Type[] {});
	this.S = (S) BackEnd.createSlice(this, UID,"setup","facet_unit",new Type[] {});
	this.P = (P) BackEnd.createSlice(this, UID,"pre_conditioner","facet_unit",new Type[] {});
	this.V = (V) BackEnd.createSlice(this, UID,"vector","facet_unit",new Type[] {});
} 


}

}
