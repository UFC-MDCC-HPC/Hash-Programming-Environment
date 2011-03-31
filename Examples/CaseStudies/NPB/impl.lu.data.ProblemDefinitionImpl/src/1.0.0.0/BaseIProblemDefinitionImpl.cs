/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance;
using common.problem_size.Class;
using lu.data.Field;
using lu.problem_size.Instance_LU;
using lu.data.ProblemDefinition;

namespace impl.lu.data.ProblemDefinitionImpl { 

public abstract class BaseIProblemDefinitionImpl<I, C>: DataStructure, BaseIProblemDefinition<I, C>
where I:IInstance_LU<C>
where C:IClass
{

private I instance = default(I);

protected I Instance {
	get {
		if (this.instance == null)
			this.instance = (I) Services.getPort("instance_type");
		return this.instance;
	}
}

private IField a = null;

protected IField A {
	get {
		if (this.a == null)
			this.a = (IField) Services.getPort("a");
		return this.a;
	}
}

private IField b = null;

protected IField B {
	get {
		if (this.b == null)
			this.b = (IField) Services.getPort("b");
		return this.b;
	}
}

private IField _c = null;

protected IField _C {
	get {
		if (this._c == null)
			this._c = (IField) Services.getPort("c");
		return this._c;
	}
}

private IField d = null;

protected IField D {
	get {
		if (this.d == null)
			this.d = (IField) Services.getPort("d");
		return this.d;
	}
}

private IField u = null;

protected IField U {
	get {
		if (this.u == null)
			this.u = (IField) Services.getPort("u");
		return this.u;
	}
}

private IField rsd = null;

protected IField Rsd {
	get {
		if (this.rsd == null)
			this.rsd = (IField) Services.getPort("rsd");
		return this.rsd;
	}
}

private IField frct = null;

protected IField Frct {
	get {
		if (this.frct == null)
			this.frct = (IField) Services.getPort("frct");
		return this.frct;
	}
}

private IField flux = null;

protected IField Flux {
	get {
		if (this.flux == null)
			this.flux = (IField) Services.getPort("flux");
		return this.flux;
	}
}



}

}
