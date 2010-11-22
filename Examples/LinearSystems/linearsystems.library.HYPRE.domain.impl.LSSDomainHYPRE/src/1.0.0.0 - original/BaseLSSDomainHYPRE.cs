/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE.facet.HYPREVector;
using linearsystems.library.HYPRE.facet.HYPREPreConditioner;
using linearsystems.library.HYPRE.facet.HYPRESetup;
using linearsystems.library.HYPRE.facet.HYPRESolver;
using environment.messagepassing.Communicator;
using linearsystems.library.HYPRE.facet.HYPREMatrix;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.library.HYPRE.domain.impl.LSSDomainHYPRE { 

public abstract class BaseLSSDomainHYPRE<V, S, M, P, R>: Domain, BaseILSSDomain<V, S, M, P, R>
where V:IHYPREVector
where S:IHYPRESetup
where M:IHYPREMatrix
where P:IHYPREPreConditioner
where R:IHYPRESolver
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


public BaseLSSDomainHYPRE() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000095a06bfdd6dbd1f996fd9e941901d88366e679c7ef57494113587ef0f53d7d001660606c6a94772827c103d9243e05eb4ac03915655c0f759d5ad274413f10b51a652fb5b9c9b52d4b88163a3ece348a5ddcad77d5f58f8cd39a454f6c5f0dc1451ebb8a21224bbd8d3403bc575cd4c4ee7ec62b8b05e682d8be340317c58e88";

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
