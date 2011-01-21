using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using environment.MPIDirect;
using MPI;

namespace environment.impl.MPIDirectImpl { 

public class IMPIDirectImpl: hpe.kinds.Environment, IMPIDirect, IDisposable
{

   private MPI.Environment mpi = null;

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


   public IMPIDirectImpl() { 
  
       string[] args = System.Environment.GetCommandLineArgs();
   	   mpi = new MPI.Environment(ref args);
   	
   	   Console.WriteLine("MPI.NET Init for process #" + Communicator.world.Rank);

   } 

   public void Dispose()
   {
   }


public void listen() {}
public void stopListen() {}

public static string UID = "00240000048000009400000006020000002400005253413100040000110000000bbb0626f28821a36ca1e4c38fc1d5be9f1226bc480901123cdbad3814e90a01c8fa20d2cf19c6d48f8358e0fb0c1399579f904637643642dcdcda2fff015badb64c524f0deed96c1246291aaa5b8b972da89ede8580bdf1acacda864092a431dc6795c9ca1a0d30ea5be8e6e96adc7f54ef4a429786ca8a13c85d60de73adba";

override public void createSlices() {
	base.createSlices();
} 

override public void destroySlice() {
    Console.Write("Finalizing MPI ...");
    mpi.Dispose();
    Console.WriteLine(" finished");
}

}

}
