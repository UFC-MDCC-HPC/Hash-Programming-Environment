/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using environment.MPIDirect;
using common.benchmarking.Timer;

namespace impl.common.benchmarking.TimerImpl { 

public abstract class BaseITimerImpl: br.ufc.pargo.hpe.kinds.Environment, BaseITimer
{

private IMPIDirect mpi = null;

public IMPIDirect Mpi {
	get {
		if (this.mpi == null)
			this.mpi = (IMPIDirect) Services.getPort("mpi");
		return this.mpi;
	}
}



}

}
