/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.data.ProblemDefinition;
using common.error.RHSNorm;

namespace impl.common.error.RHSNormImpl { 

public abstract class BaseIRHSNormImpl: Computation, BaseIRHSNorm
{

protected IProblemDefinition problem = null;

public IProblemDefinition Problem {
	set {
		this.problem = value;
	}
}


public BaseIRHSNormImpl() { 

} 

public static string UID = "002400000480000094000000060200000024000052534131000400001100000021a4a229c0f4621d60b0bb4a23e3997818281a24c8d40dcb9799917951d415da250af7c05771d71f31c46b2cc0542d764a4945f23b04b116647201ba56cbe1da5148e2f8c1dca475c71a12da487f1f74aab0ea067d0b0989414da7f000b96452de6229363f826685005bb371768d237527972692cf56f3a6d961bbb10e6bc0a6";

override public void createSlices() {
	base.createSlices();
} 

abstract public void compute(); 


}

}
