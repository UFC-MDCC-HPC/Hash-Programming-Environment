using br.ufc.pargo.hpe.kinds;

namespace common.topology.Ring { 

public interface ICell : BaseICell
{
   int sucessor { get; }
   int predecessor { get; }
   
} // end main interface 

} // end namespace 
