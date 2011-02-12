using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.benchmarking.Timer;
using MPI;

namespace impl.common.benchmarking.TimerImpl { 

public class ITimerImpl : BaseITimerImpl, ITimer
{

  public static int max_counters=64;
  double[] start_time=new double[max_counters];
  double[] elapsed_time =new double[max_counters];
  double[] total_time=new double[max_counters];

  public ITimerImpl(){
  }
  
  override public void initialize()
  {
    for(int i=0;i<max_counters;i++){
      start_time[i]=0;
      elapsed_time[i]=0;
      total_time[i]=0;
    }
  }

  public void start(int n){  
    start_time[n]=currentTimeMillis();
  }
  
  public void stop(int n){
    elapsed_time[n]=  currentTimeMillis()-start_time[n];
    elapsed_time[n]/=1000;
    total_time[n] += elapsed_time[n];
  }
  
  public double readTimer(int n){
    return total_time[n];
  }
  
  public void resetTimer(int n){
    elapsed_time[n]=start_time[n]=total_time[n]=0;
  }
  
  public void resetAllTimers(){
    for(int i=0;i<max_counters;i++) resetTimer(i);
  }
		
  public double readTimerGlobal(int n){
	Intracommunicator comm_setup = Mpi.localComm(this);
    double tmax = comm_setup.Allreduce<double>(this.readTimer(n), Operation<double>.Max);
	return tmax;
  }
		

  private static readonly DateTime Jan1st1970 = new DateTime
      (1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);

  public static long currentTimeMillis()
  {
      return (long)(DateTime.UtcNow - Jan1st1970).TotalMilliseconds;
  }


}

}
