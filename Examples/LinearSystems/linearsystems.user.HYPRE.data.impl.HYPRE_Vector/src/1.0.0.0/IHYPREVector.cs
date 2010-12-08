using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.user.data.Vector;
using linearsystems.library.HYPRE.facet.HYPREVector;
using linearsystems.library.HYPRE.domain.LSSDomainHYPRE;
using environment.messagepassing.MPICommunicator;


namespace linearsystems.user.HYPRE.data.impl.HYPRE_Vector { 

public class IHYPREVector<LIB, NUM, COM> : BaseIHYPREVector<LIB, NUM, COM>, IVector<LIB, NUM, COM, ILSSDomainHYPRE<LIB, COM>>
where LIB:IHYPRE
where NUM:IDoublePrecisionFPNumber
where COM:IMPICommunicator
{
		private bool initialized;

		private HYPRE_IJVector b_IJ;
		private HYPRE_ParCRS_vector b_ParCRS;
        private int ilower, iupper;
		
		public IHYPREVector() { 
			
		} 
		
        public void initialize() 
		{
			System.IntPtr prim_comm = comm.BaseComm;
			
				   lssdomain.HYPRE_IJVectorCreate(prim_comm, ilower, iupper, out b_IJ);
				   lssdomain.HYPRE_IJVectorSetObjectType(b_IJ,lssdomain.HYPRE_PARCSR);
				   lssdomain.HYPRE_IJVectorInitialize(b_IJ);
		}
		
		public void setIndexes(int ilower, int iupper) 
		{
		    this.ilower = ilower;
			this.iupper = iupper;
		}
		
		
		public void setValues(int size, object[] values) 
		{
			int[] rows = new int[size];
			double[] values_ = Array.ConvertAll<object,double>(values, v => (double) v);
			
			for (int i=0; i<size; i++) 
			{
				rows[i] = i;
			}
			
			lssdomain.HYPRE_IJVectorSetValues(b_IJ, size, rows, values_);
		}
		
		public void setValues(int size, int[] rows, object[] values) 
		{
			double[] values_ = Array.ConvertAll<object,double>(values, v => (double) v);
		   lssdomain.HYPRE_IJVectorSetValues(b_IJ, size, rows, values_);
		}
		
		public void assemble() 
		{
   	       lssdomain.HYPRE_IJVectorAssemble(b_IJ);
		   lssdomain.HYPRE_IJVectorGetObject(b_IJ,out b_ParCRS);
		}
		
		public object Primitive { get { return (HYPRE_ParCRS_vector) b_ParCRS; } }
		
	}

}
