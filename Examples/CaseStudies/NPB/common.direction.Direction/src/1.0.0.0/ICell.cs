using br.ufc.pargo.hpe.kinds;

namespace br.ufc.lia.pargo.hpe.casestudies.npb.common.topology.Ring { 

public interface ICell : BaseICell
{
   int sucessor { get; }
   int predecessor { get; }
   
} // end main interface 

} // end namespace 
