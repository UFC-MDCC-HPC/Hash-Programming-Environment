using br.ufc.pargo.hpe.kinds;

namespace common.topology.Ring { 

public interface ICell : BaseICell
{
   int successor { get; set; }
   int predecessor { get; set; }
   
} // end main interface 

} // end namespace 
