/* Automatically Generated Code */

using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using skeleton.Farm.Collect;
using jefferson.data.Data;
using skeleton.Farm.Distribute;
using environment.MPIDirect;
using skeleton.Farm;

namespace skeleton.impl.Farm { 

public abstract class BaseIManagerImpl<I, S, O, G>: Computation, IManager<I, S, O, G>
where I:IData
where S:IDistribute<I>
where O:IData
where G:ICollect<O>
{

protected G collect = default(G);

protected G Collect {
	set {
		this.collect = value;
	}
}

protected S distribute = default(S);

protected S Distribute {
	set {
		this.distribute = value;
	}
}

protected IMPIDirect mpi = null;

public IMPIDirect Mpi {
	set {
		this.mpi = value;
		distribute.Mpi = value;
		collect.Mpi = value;
	}
}

protected O output_data = default(O);

public O Output_data {
	set {
		this.output_data = value;
		collect.Data = value;
	}
}

protected I input_data = default(I);

public I Input_data {
	set {
		this.input_data = value;
		distribute.Data = value;
	}
}


public BaseIManagerImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000a9bb3475ce895bfeb3d5c921eaafb222dced80f493b177e788ba2919ff74d68ea17a8f32bad33623c27fe52c7b5e468a7c814bc358cc197f49d0b2f777cddbdb925473d394659718e6d0055c8c0856f0b94b1739cdee73686f38f4a30e72c67f73f90d1a30c587b1f8941021fa23e6031c9a280a9b03c2d928b261ab69775ac8";

override public void createSlices() {
	base.createSlices();
	this.Distribute = (S) BackEnd.createSlice(this, UID,"scatter","distribute",new Type[] {typeof(I)});
	this.Collect = (G) BackEnd.createSlice(this, UID,"gather","collect",new Type[] {typeof(O)});
} 

abstract public void compute(); 


}

}
