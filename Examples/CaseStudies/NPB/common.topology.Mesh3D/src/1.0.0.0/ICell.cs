using br.ufc.pargo.hpe.kinds;

namespace br.ufc.lia.pargo.hpe.casestudies.npb.common.topology.Mesh3D { 

public interface ICell : BaseICell
{
    int West   { get; };  // x direction
    int East   { get; };  // x direction
    
    int North  { get; };  // y direction
    int South  { get; };  // y direction
    
    int Top    { get; };  // z direction
    int Bottom { get; };  // z direction

} // end main interface 

} // end namespace 
