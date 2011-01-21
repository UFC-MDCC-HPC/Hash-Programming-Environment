using br.ufc.pargo.hpe.kinds;

namespace common.datapartition.BlocksInfo { 

public interface IBlocks : BaseIBlocks
{
  int[,] cell_coord {get;}
  int[,] cell_size {get;}
  int[,] cell_low {get;}
  int[,] cell_high {get;}
  int[,] cell_slice {get;}
  
  int[,] cell_start {get;}
  int[,] cell_end {get;}

  int[] predecessor {get;}
  int[] sucessor {get;} 

  int ncells {get;} // sqrt(nodes)
  int ndirs {get;}  // Assumed to be 3 ?
  
} // end main interface 

} // end namespace 
