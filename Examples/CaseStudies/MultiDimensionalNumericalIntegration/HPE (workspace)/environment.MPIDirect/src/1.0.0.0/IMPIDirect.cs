using hpe.kinds;
using hpe.basic;
using MPI;

namespace environment.MPIDirect { 

public interface IMPIDirect : BaseIMPIDirect
{

   MPI.Environment MPI { get; }
   
   Intracommunicator worldComm();       // the global communicator
   Intracommunicator localComm(IUnit caller);       // a communicator for the units inside the components.
   Intracommunicator enumComm(IUnit caller);        // a communicator for the enumeration of the units.
   int[] ranksOf(IUnit caller, string id);          // the ranks of the units named id 


} // end main interface 

} // end namespace 
