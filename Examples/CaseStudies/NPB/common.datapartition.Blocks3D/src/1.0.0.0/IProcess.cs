using br.ufc.pargo.hpe.kinds;

namespace br.ufc.lia.pargo.hpe.casestudies.npb.common.datapartition.Blocks3D { 

public interface IProcess : BaseIProcess
{
  
  void make_set(int[] grid_points); // the size of grid_points determines ndirs.

} // end main interface 

} // end namespace 
