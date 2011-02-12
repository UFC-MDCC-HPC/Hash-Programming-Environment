using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using environment.MPIDirect;
using MPI;

namespace impl.environment.MPIDirectImpl { 

public class IMPIDirectImpl : BaseIMPIDirectImpl, IMPIDirect
{

   private MPI.Environment mpi = null;
   
   public IMPIDirectImpl() { 

   } 
   
   new public void initialize()
   {
   
      // string[] args = System.Environment.GetCommandLineArgs();
   	  // mpi = new MPI.Environment(ref args);
   	
   	   Console.WriteLine("MPI.NET Init for process #" + Communicator.world.Rank);
   }

   public MPI.Environment MPI {
      get { return mpi; }
   }

   public Intracommunicator worldComm()
   {
      return Communicator.world;
   
   }
   
   public Intracommunicator localComm(IUnit caller)
   {
       Intracommunicator _localComm;   
       _localComm = (Intracommunicator)Communicator.world.Create(Communicator.world.Group.IncludeOnly(caller.Ranks));
       return _localComm;
   }
   
   public Intracommunicator enumComm(IUnit caller)
   {
       Intracommunicator _enumComm;   
       _enumComm = (Intracommunicator)Communicator.world.Create(Communicator.world.Group.IncludeOnly(caller.EnumPeers));
       return _enumComm;
   }
   
   public int[] ranksOf(IUnit caller, string id)
   {
      int[] ranks;   
      caller.Units.TryGetValue(id, out ranks);
      return ranks;
   } 

   override public void destroySlice() {
       Console.Write("Finalizing MPI ...");
       //mpi.Dispose();
       Console.WriteLine(" finished");
   }

   public void listen() {}
   public void stopListen() {}

}

}
