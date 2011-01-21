/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.data.Field;
using common.data.ProblemDefinition;

namespace impl.common.data.ProblemDefinition { 

public abstract class BaseIProblemDefinitionImpl: DataStructure, BaseIProblemDefinition
{

private IField lhs = null;

protected IField Lhs {
	get {
		if (lhs==null) 
			lhs = (IField) Services.getPort("lhs");
		return lhs;
	}
}

private IField u = null;

protected IField U {
	get {
		if (u == null) 
			u = (IField) Services.getPort("u");
		return u;
	}
}

private IField us = null;

protected IField Us {
	get {
		if (us == null) 
			us = (IField) Services.getPort("us");
		return us;
	}
}

private IField vs = null;

protected IField Vs {
	get {
		if (vs==null) 
			vs = (IField) Services.getPort("vs");
		return vs;
	}
}

private IField ws = null;

protected IField Ws {
	get {
		if (ws==null) 
			ws = (IField) Services.getPort("ws");
		return ws;
	}
}

private IField qs = null;

protected IField Qs {
	get {
		if (qs==null) 
			qs = (IField) Services.getPort("qs");
		return qs;
	}
}

private IField rho = null;

protected IField Rho {
	get {
		if (rho==null) 
			rho = (IField) Services.getPort("rho");
		return rho;
	}
}

private IField ainv = null;

protected IField Ainv {
	get {
		if (ainv==null) 
			ainv = (IField) Services.getPort("ainv");
		return ainv;
	}
}

private IField speed = null;

protected IField Speed {
	get {
		if (speed==null) 
			speed = (IField) Services.getPort("speed");
		return speed;
	}
}

private IField square = null;

protected IField Square {
	get {
		if (square==null) 
			square = (IField) Services.getPort("square");
		return square;
	}
}

private IField rhs = null;

protected IField Rhs {
	get {
		if (rhs==null) 
			rhs = (IField) Services.getPort("rhs");
		return rhs;
	}
}

private IField forcing = null;

protected IField Forcing {
	get {
		if (forcing==null) 
			forcing = (IField) Services.getPort("forcing");
		return rhs;
	}
}

}

}
