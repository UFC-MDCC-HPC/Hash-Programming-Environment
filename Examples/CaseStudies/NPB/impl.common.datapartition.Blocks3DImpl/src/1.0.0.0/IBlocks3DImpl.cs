using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.datapartition.Blocks3D;
using common.problem_size.Class;
using common.problem_size.Instance;

namespace impl.common.datapartition.Blocks3DImpl { 

public class IBlocks3DImpl<I, C> : BaseIBlocks3DImpl<I, C>, IBlocks3D<I, C>
where I:IInstance<C>
where C:IClass
{

public IBlocks3DImpl() 
{ 
} 
		
protected int[] grid_points ;
		
		
//---------------------------------------------------------------------
// This function allocates space for a set of cells and fills the set     
// such that communication between cells on different nodes is only
// nearest neighbor                                                   
//---------------------------------------------------------------------
override public void initialize() // make_set()
{			
	int[,] cell_coord, cell_low, cell_high, cell_size, slice, start, end;

    cell_coord = Blocks.cell_coord;
	cell_low = Blocks.cell_low;
	cell_high = Blocks.cell_high;
	cell_size = Blocks.cell_size;
	slice = Blocks.cell_slice;
	start = Blocks.cell_start;
	end = Blocks.cell_end;	
			
	int ncells;
	int total_nodes = this.Ranks.Length;
	int no_nodes = this.Ranks.Length;	
	int node = this.GlobalRank;			
	int maxcells =  Convert.ToInt32(Math.Sqrt(total_nodes));
	int problem_size = Instance.problem_size;
			
    int MAX_CELL_DIM = (problem_size/maxcells) + 1; 
			
	grid_points = new int[3];
	grid_points[0] = grid_points[1] = grid_points[2] = problem_size;					
			
	// The official make_set start here ...		
			
    int p, i, j, c, dir, size, excess;

    //---------------------------------------------------------------------
    //     compute square root; add small number to allow for roundoff
    //     (note: this is computed in setup_mpi.f also, but prefer to do
    //     it twice because of some include file problems).
    //---------------------------------------------------------------------
    ncells = Convert.ToInt32(Math.Sqrt(no_nodes));
	Blocks.ncells = ncells;

    //---------------------------------------------------------------------
    //      this makes coding easier
    //---------------------------------------------------------------------
    p = ncells;

    //---------------------------------------------------------------------
    //      determine the location of the cell at the bottom of the 3D 
    //      array of cells
    //---------------------------------------------------------------------
    cell_coord[0, 0] = mod(node, p);   //mod(node,p);
    cell_coord[0, 1] = node / p;
    cell_coord[0, 2] = 0;

    //---------------------------------------------------------------------
    //      set the cell_coords for cells in the rest of the z-layers; 
    //      this comes down to a simple linear numbering in the z-direct-
    //      ion, and to the doubly-cyclic numbering in the other dirs     
    //---------------------------------------------------------------------
    for (c = 1; c < p; c++)
    {
        cell_coord[c, 0] = mod(cell_coord[c - 1, 0] + 1, p) ;                           // mod(cell_coord(1,c-1)+1,p);
        cell_coord[c, 1] = mod(cell_coord[c - 1, 1] - 1 + p, p) ;                           // mod(cell_coord(2,c-1)-1+p,p); 
        cell_coord[c, 2] = c ;
    }

    //---------------------------------------------------------------------
    //      slice(n,dir) contains the sequence number of the cell that is in
    //      coordinate plane n in the dir direction
    //---------------------------------------------------------------------
    for (dir = 0; dir < 3; dir++)
    {
        for (c = 0; c < p; c++)
        {
            slice[cell_coord[c, dir], dir] = c;
//            Console.WriteLine(node + ": slice[" + cell_coord[c, dir] + "," + dir +  "] = " + c);
        }
    }
    
    //---------------------------------------------------------------------
    //      fill the predecessor and successor entries, using the indices 
    //      of the bottom cells (they are the same at each level of k 
    //      anyway) acting as if full periodicity pertains; note that p is
    //      added to those arguments to the mod functions that might
    //      otherwise return wrong values when using the modulo function
    //---------------------------------------------------------------------
    i = cell_coord[0, 0];
    j = cell_coord[0, 1];

    X.predecessor = /* predecessor[0] = */ mod(i - 1 + p, p) + p * j;
    Y.predecessor = /* predecessor[1] = */ i + p * mod(j - 1 + p, p);
    Z.predecessor = /* predecessor[2] = */ mod(i + 1, p) + p * mod(j - 1 + p, p);

    X.successor = /* successor[0] = */ mod(i + 1, p) + p * j;
    Y.successor = /* successor[1] = */ i + p * mod(j + 1, p);
    Z.successor = /* successor[2] = */ mod(i - 1 + p, p) + p * mod(j + 1, p);
						
//	Console.Error.WriteLine(node + ": " + X.predecessor + ","
//	                                    + Y.predecessor + ","
//	                                    + Z.predecessor + ","
//	                                    + X.successor + ","
//	                                    + Y.successor + ","
//	                                    + Z.successor);					
//						
    //---------------------------------------------------------------------
    // now compute the sizes of the cells                                    
    //---------------------------------------------------------------------
    for (dir = 0; dir < 3; dir++)
    {
        //---------------------------------------------------------------------
        //         set cell_coord range for each direction                            
        //---------------------------------------------------------------------
        size = grid_points[dir] / p;
        excess = mod(grid_points[dir], p);

        for (c = 0; c < ncells; c++)
        {
            if (cell_coord[c, dir] < excess)
            {
                cell_size[c, dir] = size + 1;
                cell_low[c, dir] = (cell_coord[c, dir]) * (size + 1);
                cell_high[c, dir] = cell_low[c, dir] + size;
            }
            else
            {
                cell_size[c, dir] = size;
                cell_low[c, dir] = excess * (size + 1) + (cell_coord[c, dir] - excess) * size;
                cell_high[c, dir] = cell_low[c, dir] + size - 1;
            }
            if (cell_size[c, dir] <= 2)
            {
                Console.WriteLine("Error: Cell size too small. Min size is 3");
              //  worldcomm.Abort(ierrcode); 
                System.Environment.Exit(0);
            }
        }
  //      Console.WriteLine(node + ": grid_points[" + dir + "] = " + grid_points[dir]);
  //      for (c = 0; c < ncells; c++)
  //      {
  //          Console.WriteLine(node + ": excess = " + excess);
  //          Console.WriteLine(node + ": cell_coord[" + c + "," + dir + "] = " + cell_coord[c, dir]);
  //          Console.WriteLine(node + ": cell_size[" + c + "," + dir + "] = " + cell_size[c, dir]);
  //      }
        
    }
			
	//---------------------------------------------------------------------
    // first, initialize the start and end arrays
    //---------------------------------------------------------------------
	
    for (c = 0; c < ncells; c++) 
	{
        for (int d = 0; d < 3; d++)
        {
            if (cell_coord[c, d] == 0)
                start[c, d] = 3;
            else
                start[c, d] = 2;

            if (cell_coord[c, d] == ncells - 1)
                end[c, d] = 1;
            else
                end[c, d] = 0;
        }
	}
	

}
		
private int mod(int a, int b)
{
    int r;
    Math.DivRem(a, b, out r);
    return r;
}


}
}
