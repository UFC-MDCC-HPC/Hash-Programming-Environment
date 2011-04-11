using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.Add;
using common.problem_size.Class;
using common.problem_size.Instance;

namespace impl.common.AddImpl { 

	public class IAddImpl<I,C> : BaseIAddImpl<I,C>, IAdd<I,C>
			where I:IInstance<C>
			where C:IClass
	{
	
		public IAddImpl() 
		{ 
		} 
		
		
		public override int go() 
		{ 			
		    int c, i, j, k, m;
		
		    for (c = 0; c < ncells; c++)
		    {
		        for (k = start[c, 2]; k < 2 + cell_size[c, 2] - end[c, 2]; k++)
		        {
		            for (j = start[c, 1]; j < 2 + cell_size[c, 1] - end[c, 1]; j++)
		            {
		                for (i = start[c, 0]; i < 2 + cell_size[c, 0] - end[c, 0]; i++)
		                {
		                    for (m = 0; m < 5; m++)
		                    {
		                      //  Console.Write("u["+ c + "," + k + "," + j + "," + i + "," + m +"] = " + u[c, k, j, i, m]);
		                      //  Console.Write(", ");
		                      //  Console.WriteLine("rhs["+ c + "," + k + "," + j + "," + i + "," + m +"] : " + rhs[c, k, j, i, m]);
		                        u[c, k, j, i, m] += rhs[c, k, j, i, m];
		                    }
		                }
		            }
		        }
		    }
			
			return 0;
		
		} // end activate method 
		
	}

}
