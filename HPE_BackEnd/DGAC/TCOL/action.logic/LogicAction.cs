using System.Threading;

namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic{

public abstract class LogicAction {
		public string compId;
		public string handleId;
		public Thread _thread;
	public abstract void run();
		public abstract void start ();
}
}