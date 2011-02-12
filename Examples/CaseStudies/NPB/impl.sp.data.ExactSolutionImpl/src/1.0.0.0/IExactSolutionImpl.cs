using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.data.ExactSolution;

namespace impl.sp.data.ExactSolutionImpl { 

	public class IExactSolutionImpl : BaseIExactSolutionImpl, IExactSolution
	{
	
		public IExactSolutionImpl() 
		{ 
		
		} 
				
		private double xi, eta, zeta; 
		private double[] dtemp; 
		private int offset;
		
	    protected double[,] ce ={{2.0d,1.0d,2.0d,2.0d,5.0d},
			                     {0.0d,0.0d,2.0d,2.0d,4.0d},
			                     {0.0d,0.0d,0.0d,0.0d,3.0d},
			                     {4.0d,0.0d,0.0d,0.0d,2.0d},
			                     {5.0d,1.0d,0.0d,0.0d,0.1d},
			                     {3.0d,2.0d,2.0d,2.0d,0.4d},
			                     {0.5d,3.0d,3.0d,3.0d,0.3d},
			                     {0.02d,0.01d,0.04d,0.03d,0.05d},
			                     {0.01d,0.03d,0.03d,0.05d,0.04d},
			                     {0.03d,0.02d,0.05d,0.04d,0.03d},
			                     {0.5d,0.4d,0.3,0.2d,0.1d},
			                     {0.4d,0.3d,0.5,0.1d,0.3d},
			                     {0.3d,0.5d,0.4,0.3d,0.2d}};

		public void setParameters(double xi, double eta, double zeta, double[] dtemp, int offset)
		{
			this.xi = xi;
			this.eta = eta;
			this.zeta = zeta;
			this.dtemp = dtemp;
			this.offset = offset;
		}
		
		override public void initialize()
		{
			int ndid = 0;
			ce[0,0] = 2.0d * (1.0d + ((double)ndid) * 0.01d);
		}
				
		public override void compute() { 
			
			for (int m = 0; m < 5; m++)
			{
				dtemp[m + offset] = ce[0,m] +
				xi * (ce[1,m] + xi * (ce[4,m] + xi * (ce[7,m] + xi * ce[10,m]))) +
				eta * (ce[2,m] + eta * (ce[5,m] + eta * (ce[8,m] + eta * ce[11,m]))) +
				zeta * (ce[3,m] + zeta * (ce[6,m] + zeta * (ce[9,m] +
				zeta * ce[12,m])));
			}
					
		
		} // end activate method 
	
	}

}
