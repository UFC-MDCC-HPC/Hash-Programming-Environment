/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.data.ProblemDefinition;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.datapartition.BlocksInfo;
using common.Discretization;
using lu.problem_size.Instance;
using lu.triangular.Lower;
using lu.ssor.TriangularPartJacobianMatrix;

namespace impl.lu.ssor.TriangularPartJacobianMatrix_Jacld 
{ 
	public abstract class BaseITriangularPartJacobianMatrix_Jacld<I, C, DIS>: Computation, BaseITriangularPartJacobianMatrix<I, C, DIS>
		where I:IInstance_LU<C>
		where C:IClass
		where DIS:ILower
	{
	   
		#region data
			protected int ist,jst,iend,jend;
			protected double dt;
      		protected double c1, c2, c3, c4, c5, 
      		                 tx1, tx2, 
      		                 ty1, ty2, 
      		                 tz1, tz2,
			                 dx1, dx2, dx3, dx4, dx5, 
			                 dy1, dy2, dy3, dy4, dy5, 
			                 dz1, dz2, dz3, dz4, dz5;
			protected double [,,,] u,d,a,b,c;
			
			override public void initialize()
			{
			    dt = Instance.dt;
			    
                ist  = Blocks.ist;
                jst  = Blocks.jst;                
                iend = Blocks.iend;
                jend = Blocks.jend;
                
                u    = Problem.Field_u;
                d    = Problem.Field_d;
                a    = Problem.Field_a;
                b    = Problem.Field_b;
                c    = Problem.Field_c;
                
                c1 = Constants.c1;
                c2 = Constants.c2;
                c3 = Constants.c3;
                c4 = Constants.c4;
                c5 = Constants.c5;
                
                tx1 = Constants.tx1;
                tx2 = Constants.tx2;

                ty1 = Constants.ty1;
                ty2 = Constants.ty2;
              
                tz1 = Constants.tz1;
                tz2 = Constants.tz2;

                dx1 = Constants.dx1;
                dx2 = Constants.dx2;
                dx3 = Constants.dx3;
                dx4 = Constants.dx4;
                dx5 = Constants.dx5;
               
                dy1 = Constants.dy1;
                dy2 = Constants.dy2;
                dy3 = Constants.dy3;
                dy4 = Constants.dy4;
                dy5 = Constants.dy5;
                
                dz1 = Constants.dz1;
                dz2 = Constants.dz2;
                dz3 = Constants.dz3;
                dz4 = Constants.dz4;
                dz5 = Constants.dz5;  
			}
			
		#endregion
	
		private IProblemDefinition<I, C> problem = null;
		
		public IProblemDefinition<I, C> Problem {
			get {
				if (this.problem == null)
					this.problem = (IProblemDefinition<I, C>) Services.getPort("problem_data");
				return this.problem;
			}
		}
		
		private IBlocksInfo blocks = null;
		
		public IBlocksInfo Blocks {
			get {
				if (this.blocks == null)
					this.blocks = (IBlocksInfo) Services.getPort("blocks_info");
				return this.blocks;
			}
		}
		
		private DIS discretization = default(DIS);
		
		protected DIS Discretization {
			get {
				if (this.discretization == null)
					this.discretization = (DIS) Services.getPort("discretization");
				return this.discretization;
			}
		}
		
		private I instance = default(I);
		
		protected I Instance {
			get {
				if (this.instance == null)
					this.instance = (I) Services.getPort("instance_type");
				return this.instance;
			}
		}	
		abstract public int go(); 
	}
}
