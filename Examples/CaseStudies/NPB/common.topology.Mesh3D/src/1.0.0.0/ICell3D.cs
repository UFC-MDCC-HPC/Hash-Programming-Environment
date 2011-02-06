using br.ufc.pargo.hpe.kinds;

namespace common.topology.Mesh3D { 

public interface ICell3D : BaseICell3D
{
    int West   { get; set; }  // x direction
    int East   { get; set; }  // x direction
    
    int North  { get; set; }  // y direction
    int South  { get; set; }  // y direction
    
    int Top    { get; set; }  // z direction
    int Bottom { get; set; }  // z direction


} // end main interface 

} // end namespace 
