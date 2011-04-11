using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.X;
using bt.solve.BeamWarmingMethod;
using bt.solve.BackSubstitute;

namespace impl.bt.solve.XBackSubstitute 
{ 

public class IXBackSubstituteImpl<I, C, DIR, MTH> : BaseIXBackSubstituteImpl<I, C, DIR, MTH>, IBackSubstitute<I, C, DIR, MTH>
where I:IInstance_BT<C>
where C:IClass
where DIR:IX
where MTH:IBeamWarmingMethod
{
	private double[,,,,,] lhsc;
	private double[,,,] backsub_info;
	private int first, last, c;
	
	public void setParameters(double[,,,,,] lhsc, double[,,,] backsub_info, int first, int last, int c)
	{
	   this.lhsc = lhsc;
	   this.backsub_info = backsub_info;
	   this.first = first;
	   this.last = last;
	   this.c = c;
	}
		
	public override int go()   
	{ 
		int i, j, k;
		int m, n, isize, jsize, ksize, istart;
		
		istart = 2;
		isize = cell_size[c, 0] + 1;
		jsize = cell_size[c, 1] - end[c, 1] + 1;
		ksize = cell_size[c, 2] - end[c, 2] + 1;
		
		if(last == 0) 
		{
		    for(k = start[c, 2]; k <= ksize; k++) 
		    {
		        for(j = start[c, 1]; j <= jsize; j++) 
		        {
		            //---------------------------------------------------------------------
		            //     U[isize] uses info from previous cell if not last cell
		            //---------------------------------------------------------------------
		            for(m = 0; m < 5; m++) 
		            {
		                for(n = 0; n < 5; n++) 
		                {//rhs[m,isize,j,k,c] = rhs[m,isize,j,k,c] - lhsc[m,n,isize,j,k,c]*backsub_info[n,j,k,c]
		                    rhs[c, k, j, isize, m] = rhs[c, k, j, isize, m] - lhsc[c, k, j, isize, n, m] * backsub_info[c, k, j, n];
		                }
		            }
		        }
		    }
		}
		
		for(k = start[c, 2]; k <= ksize; k++) 
		{
		    for(j = start[c, 1]; j <= jsize; j++) 
		    {
		        for(i = isize-1; i >= istart; i--) 
		        {  //for(i=isize-1,istart,-1;
		            for(m = 0; m < 5; m++) 
		            {
		                for(n = 0; n < 5; n++) 
		                { //rhs[m,i,j,k,c] = rhs[m,i,j,k,c] - lhsc[m,n,i,j,k,c]*rhs[n,i+1,j,k,c];
		                    rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - lhsc[c, k, j, i, n, m] * rhs[c, k, j, i+1, n];
		                }
		            }
		        }
		    }
		}
	
	   return 0;	   
	} // end activate method 

}

}
