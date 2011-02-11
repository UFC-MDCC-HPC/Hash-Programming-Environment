using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using sp.problem_size.Instance_SP;
using common.problem_size.Class;
using common.data.LHSInit;
using common.data.ProblemDefinition;

namespace impl.sp.data.LHSInitImpl { 

	public class ILHSInitImpl<I, C> : BaseILHSInitImpl<I, C>, ILHSInit<I, C>
		where I:IInstance_SP<C>
		where C:IClass
	{
		
		public ILHSInitImpl() 
		{ 
		}		
				
		public override void compute() 
		{ 

        //---------------------------------------------------------------------
        // loop over all cells                                       
        //---------------------------------------------------------------------
        for (int c = 0; c < ncells; c++)
        {
            //---------------------------------------------------------------------
            // first, initialize the start and end arrays
            //---------------------------------------------------------------------

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


            //---------------------------------------------------------------------
            // zap the whole left hand side for starters
            //---------------------------------------------------------------------

            for (int k = 2; k < 2 + cell_size[c, 2]; k++)
            {
                for (int j = 2; j < 2 + cell_size[c, 1]; j++)
                {
                    for (int i = 2; i < 2 + cell_size[c, 0]; i++)
                    {
                        for (int n = 0; n < 15; n++)
                        {
                            lhs[c, k, j, i, n] = 0.0d;
                        }
                    }
                }
            }

            //---------------------------------------------------------------------
            // next, set all diagonal values to 1. This is overkill, but convenient
            //---------------------------------------------------------------------

            for (int n = 0; n < 3; n++)
            {
                for (int k = 2; k < 2 + cell_size[c, 2]; k++)
                {
                    for (int j = 2; j < 2 + cell_size[c, 1]; j++)
                    {
                        for (int i = 2; i < 2 + cell_size[c, 0]; i++)
                        {
                            lhs[c, k, j, i, 5 * n + 2] = 1.0d;
                        }
                    }
                }
            }
        }
		} // end activate method 
	
	}

}
