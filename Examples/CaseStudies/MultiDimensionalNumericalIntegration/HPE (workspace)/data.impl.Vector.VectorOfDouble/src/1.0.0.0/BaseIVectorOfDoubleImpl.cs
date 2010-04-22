/* Automatically Generated Code */

using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using jefferson.data.Double;
using data.Integer;
using data.Vector.VectorOfDouble;

namespace data.impl.Vector.VectorOfDouble { 

public abstract class BaseIVectorOfDoubleImpl<T>: DataStructure, BaseIVectorOfDouble<T>
where T:IDouble
{

protected T data = default(T);

protected T Data {
	set {
		this.data = value;
	}
}

protected IInteger vec_size = null;

protected IInteger Vec_size {
	set {
		this.vec_size = value;
	}
}


public BaseIVectorOfDoubleImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000b154ff9e0a504d81312a3e7838fc698376ed8df0f81eaa2a6ea483bbbc3641f50c5cf08574629db00604517ade92b6667e7e6dec9908ee93b07912b1fb6f5d7bdd2e181a0ccf661832741c8a6a5d2fc4ba9bee065a5e3abe0e1d0eeda9505df68bc0297537835b5169e9f375b230ec890a3f57005f78a8717b8f3c9df15580c3";

override public void createSlices() {
	base.createSlices();
	this.Vec_size = (IInteger) BackEnd.createSlice(this, UID,"size","integer",new Type[] {});
	this.Data = (T) BackEnd.createSlice(this, UID,"element","double",new Type[] {});
} 


}

}
