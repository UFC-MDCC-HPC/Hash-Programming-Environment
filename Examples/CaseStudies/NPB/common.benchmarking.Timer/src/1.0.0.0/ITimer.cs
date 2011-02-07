using br.ufc.pargo.hpe.kinds;

namespace common.benchmarking.Timer { 

public interface ITimer : BaseITimer
{
    void start(int n);
    void stop(int n);
    double readTimer(int n);
    void resetTimer(int n);
    void resetAllTimers();
	double readTimerGlobal(int n);
    
} // end main interface 

} // end namespace 
