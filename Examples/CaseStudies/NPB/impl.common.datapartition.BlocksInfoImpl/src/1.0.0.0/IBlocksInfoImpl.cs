using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.BlocksInfo;

namespace impl.common.datapartition.BlocksInfoImpl { 

public class IBlocksInfoImpl : BaseIBlocksInfoImpl, IBlocks
{

	public IBlocksInfoImpl() 
	{ 
	} 
		
	override public void initialize()
	{
		int total_nodes = this.Ranks.Length;
		int no_nodes = total_nodes;
			
		int maxcells =  Convert.ToInt32(Math.Sqrt(total_nodes));
			
		_ncells_ = Convert.ToInt32(Math.Sqrt(no_nodes));
		_ndirs_ = 3;			
			
		_cell_coord_ = new int[maxcells,3];
		_cell_size_ = new int[maxcells,3];
		_cell_low_ = new int[maxcells,3];
		_cell_high_ = new int[maxcells,3];
		_cell_slice_ = new int[maxcells,3];
		
		_cell_start_ = new int[maxcells,3];
		_cell_end_ = new int[maxcells,3];
		
//		_predecessor_ = new int[3];
//		_sucessor_ = new int[3]; 
		
		_grid_points_ = new int[3] {0, 0, 0};
	}
		
				
	private int[,] _cell_coord_;
	private int[,] _cell_size_;
	private int[,] _cell_low_;
	private int[,] _cell_high_;
	private int[,] _cell_slice_;
	
	private int[,] _cell_start_;
	private int[,] _cell_end_;
	
//	private int[] _predecessor_;
//	private int[] _sucessor_;
	
	private int _ncells_;
	private int _ndirs_;
		
	private int[] _grid_points_;
			
	public int[,] cell_coord { get { return _cell_coord_; } }
	public int[,] cell_size {get { return _cell_size_; } }
	public int[,] cell_low {get { return _cell_low_; } }
	public int[,] cell_high {get { return _cell_high_; } }
	public int[,] cell_slice {get { return _cell_slice_; } }
	
	public int[,] cell_start {get { return _cell_start_; } }
	public int[,] cell_end {get { return _cell_end_; } }
	
//	public int[] predecessor {get { return _predecessor_; } }
//	public int[] sucessor {get { return _sucessor_; } } 
	
	public int ncells {get { return _ncells_; } set { _ncells_ = value; } } // sqrt(nodes)
	public int ndirs {get { return _ndirs_; } set { _ndirs_ = value; } }  // Assumed to be 3 ?
		
}

}
