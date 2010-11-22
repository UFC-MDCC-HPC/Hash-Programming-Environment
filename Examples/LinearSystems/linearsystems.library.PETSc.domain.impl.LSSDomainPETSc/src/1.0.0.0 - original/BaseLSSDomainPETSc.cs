/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.PETSc.facet.PETScVector;
using linearsystems.library.PETSc.facet.PETScPreConditioner;
using linearsystems.library.PETSc.facet.PETScSetup;
using linearsystems.library.PETSc.facet.PETScSolver;
using environment.messagepassing.Communicator;
using linearsystems.library.PETSc.facet.PETScMatrix;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.library.PETSc.domain.impl.LSSDomainPETSc { 

public abstract class BaseLSSDomainPETSc<V, S, M, P, R>: Domain, BaseILSSDomain<V, S, M, P, R>
where V:IPETScVector
where S:IPETScSetup
where M:IPETScMatrix
where P:IPETScPreConditioner
where R:IPETScSolver
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


public BaseLSSDomainPETSc() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000898c8a437c759861e5fdb4282024eb785d243695fc017acf76faaac13c189808df574cafc45dcc4d84a81d6c39c1ad211b6d5f50c46d6f69c02e1660edad54b366be552e3236f301daa328543e2080913ad2fdc8bb08d09fb6f0845a27cfd49eceebdc79dc00ef76abf668aff0d1b53fdf8ec7697345c8aef6d45fdf116560a4";

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
