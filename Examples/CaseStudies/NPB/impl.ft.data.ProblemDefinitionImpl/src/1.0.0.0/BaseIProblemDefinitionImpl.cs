/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance;
using common.problem_size.Class;
using ft.data.Field;
using ft.problem_size.Instance_FT;
using ft.data.ProblemDefinition;

namespace impl.ft.data.ProblemDefinitionImpl { 

public abstract class BaseIProblemDefinitionImpl<I, C>: DataStructure, BaseIProblemDefinition<I, C>
where I:IInstance_FT<C>
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

private IField u0 = null;

protected IField U0 {
	get {
		if (this.u0 == null)
			this.u0 = (IField) Services.getPort("u0");
		return this.u0;
	}
}

private IField u1 = null;

protected IField U1 {
	get {
		if (this.u1 == null)
			this.u1 = (IField) Services.getPort("u1");
		return this.u1;
	}
}

private IField u2 = null;

protected IField U2 {
	get {
		if (this.u2 == null)
			this.u2 = (IField) Services.getPort("u2");
		return this.u2;
	}
}



}

}
