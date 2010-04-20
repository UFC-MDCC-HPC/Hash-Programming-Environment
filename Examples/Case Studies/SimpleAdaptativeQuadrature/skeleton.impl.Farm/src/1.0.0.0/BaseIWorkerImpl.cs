/* Automatically Generated Code */

using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using skeleton.Farm.Work;
using jefferson.data.Data;
using skeleton.Farm.Collect;
using skeleton.Farm.Distribute;
using environment.MPIDirect;
using skeleton.Farm;

namespace skeleton.impl.Farm { 

public abstract class BaseIWorkerImpl<R, G, J, S, W>: Computation, IWorker<R, G, J, S, W>
where R:IData
where G:ISend<R>
where J:IData
where S:IReceive<J>
where W:IWork<J, R>
{

protected W work = default(W);

protected W Work {
	set {
		this.work = value;
	}
}

protected G send = default(G);

protected G Send {
	set {
		this.send = value;
	}
}

protected S receive = default(S);

protected S Receive {
	set {
		this.receive = value;
	}
}

protected R result = default(R);

protected R Result {
	set {
		this.result = value;
		send.Data = value;
		work.Output_data = value;
	}
}

protected IMPIDirect mpi = null;

public IMPIDirect Mpi {
	set {
		this.mpi = value;
		receive.Mpi = value;
		send.Mpi = value;
	}
}

protected J job = default(J);

protected J Job {
	set {
		this.job = value;
		receive.Data = value;
		work.Input_data = value;
	}
}


public BaseIWorkerImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000a9bb3475ce895bfeb3d5c921eaafb222dced80f493b177e788ba2919ff74d68ea17a8f32bad33623c27fe52c7b5e468a7c814bc358cc197f49d0b2f777cddbdb925473d394659718e6d0055c8c0856f0b94b1739cdee73686f38f4a30e72c67f73f90d1a30c587b1f8941021fa23e6031c9a280a9b03c2d928b261ab69775ac8";

override public void createSlices() {
	base.createSlices();
	this.Receive = (S) BackEnd.createSlice(this, UID,"scatter","receive",new Type[] {typeof(J)});
	this.Send = (G) BackEnd.createSlice(this, UID,"gather","send",new Type[] {typeof(R)});
	this.Work = (W) BackEnd.createSlice(this, UID,"work","work",new Type[] {typeof(J),typeof(R)});
	this.Job = (J) BackEnd.createSlice(this, UID,"job","data",new Type[] {});
	this.Result = (R) BackEnd.createSlice(this, UID,"result","data",new Type[] {});
} 

abstract public void compute(); 


}

}
