using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.solve.BlockDiagonalMatVecProduct;
using common.problem_size.Instance;
using common.problem_size.Class;
using common.data.ProblemDefinition;
using common.orientation.Axis;
using common.solve.Method;

namespace impl.sp.solve.PINVR { 

	public class IPNVR<I,C,DIR,MTH> : BaseIPNVR<I,C,DIR,MTH>, IBlockDiagonalMatVecProduct<I,C,DIR,MTH>
			where I:IInstance<C>
			where C:IClass
			where DIR:IAxis
			where MTH:IMethod
	{
	
		public IPNVR() 
		{ 
		} 
							
		private int c;
		
		public void enterStage(int stage)			
		{
		    c = slice[stage, 1];
		}	                       
				
		
		public override int go() { 
					
		    int i, j, k;
		    double r1, r2, r3, r4, r5, t1, t2;
		
		    int ksize = cell_size[c, 2] + 2;
		    int jsize = cell_size[c, 1] + 2;
		    int isize = cell_size[c, 0] + 2;
		
		    for (k = start[c, 2]; k < ksize - end[c, 2]; k++)
		    {
		        for (j = start[c, 1]; j < jsize - end[c, 1]; j++)
		        {
		            for (i = start[c, 0]; i < isize - end[c, 0]; i++)
		            {
		
		                r1 = rhs[c, k, j, i, 0];
		                r2 = rhs[c, k, j, i, 1];
		                r3 = rhs[c, k, j, i, 2];
		                r4 = rhs[c, k, j, i, 3];
		                r5 = rhs[c, k, j, i, 4];
		
		                t1 = bt * r1;
		                t2 = 0.5d * (r4 + r5);
		
		                rhs[c, k, j, i, 0] = bt * (r4 - r5);
		                rhs[c, k, j, i, 1] = -r3;
		                rhs[c, k, j, i, 2] = r2;
		                rhs[c, k, j, i, 3] = -t1 + t2;
		                rhs[c, k, j, i, 4] = t1 + t2;
                    //    for (int m=0;m<5;m++)		                
		             //       Console.WriteLine("pinvr - rhs" + "[" + c + "," + k + "," + j + "," + i + "," + m + "] = " + rhs[c, k, j, i, m]);
		            }
		        }
		    }
			
			return 0;		
		} // end activate method 
	
	}

}
