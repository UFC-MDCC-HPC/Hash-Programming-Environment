using br.ufc.pargo.hpe.kinds;

namespace common.topology.Mesh2D { 

public interface ICell2D : BaseICell2D
{

    int West   { get; set; }  // x direction
    int East   { get; set; }  // x direction
    
    int North  { get; set; }  // y direction
    int South  { get; set; }  // y direction


} // end main interface 

} // end namespace 
