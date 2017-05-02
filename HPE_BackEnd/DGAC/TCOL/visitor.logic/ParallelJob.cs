using br.ufc.pargo.hpe.backend.DGAC.TCOL.grammar;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.util;
using br.ufc.pargo.hpe.backend.DGAC.TCOL.action.logic;
using System;
using System.Threading;
using br.ufc.pargo.hpe.kinds;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.visitor.logic{

public class ParallelJob{
		public Thread _thread;
	CertifierOrchestrationElement child;
	public int ret;
	public ParallelJob(CertifierOrchestrationElement child){
		this.child = child;
	}
		public  void run() {
			_thread = new Thread((ThreadStart)delegate() 
			                     {ret = this.child.run();

			});

			_thread.Start ();



		}
	
	}}