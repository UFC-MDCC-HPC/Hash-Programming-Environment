using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.user.data.MatrixCSR;
using linearsystems.library.HYPRE.facet.HYPREMatrix;
using environment.messagepassing.MPICommunicator;
using linearsystems.library.HYPRE.domain.LSSDomainHYPRE;
using MPI;

namespace linearsystems.user.HYPRE.data.impl.HYPRE_Matrix { 

public class IHYPREMatrix<LIB, MPT, NUM, COM> : BaseIHYPREMatrix<LIB, MPT, NUM, COM>, IMatrixCSR<LIB, MPT, NUM, COM, ILSSDomainHYPRE<LIB, COM>>
where LIB:IHYPRE
where MPT:ISparseMatrix<LIB>
where NUM:IDoublePrecisionFPNumber
where COM:IMPICommunicator
{
		private HYPRE_IJMatrix A_IJ;
		private HYPRE_ParCSR_matrix A_ParCSR;
		private bool initialized = false;
		private int ilower, iupper, jlower, jupper;
		
		
		public IHYPREMatrix() { 
			
		} 
		
		
		public void initialize() 
		{
			if (initialized) 
			{
				lssdomain.HYPRE_IJMatrixDestroy(A_IJ);
			}
			
			// matrix = new HYPREMatrix();
									
			System.IntPtr prim_comm = comm.BaseComm;
			
			lssdomain.HYPRE_IJMatrixCreate(prim_comm,ilower,iupper,jlower,jupper,out A_IJ);				
			lssdomain.HYPRE_IJMatrixSetObjectType(A_IJ,lssdomain.HYPRE_PARCSR);
			lssdomain.HYPRE_IJMatrixInitialize(A_IJ);
			
			initialized = true;
		}
		
		public void setValues(int[] ncols,int[] rows, int[] cols, object[] values) 
		{			
			double[] valuesPrim = new double[values.Length];
			values.CopyTo(valuesPrim, 0);
			lssdomain.HYPRE_IJMatrixSetValues(A_IJ,1,ncols,rows,cols,valuesPrim);
		}
		
		public void setIndexes(int ilower, int iupper, int jlower, int jupper) 
		{
		    this.ilower = ilower;
			this.iupper = iupper;
			this.jlower = jlower;
			this.jupper = jupper;
		}

		
		public void assemble() 
		{
			lssdomain.HYPRE_IJMatrixAssemble(A_IJ);
			lssdomain.HYPRE_IJMatrixGetObject(A_IJ,out A_ParCSR);
		}
		
		public void create(int ilower, int iupper, int jlower, int jupper, int[] ncols,int[] rows, int[] cols, object[] values) 
		{
			setIndexes(ilower, iupper, jlower, jupper);
			initialize();
			setValues(ncols,rows,cols,values);
			assemble();
		}
	
		public object Primitive { get { return (HYPRE_ParCSR_matrix) A_ParCSR; } }
		
}

}
