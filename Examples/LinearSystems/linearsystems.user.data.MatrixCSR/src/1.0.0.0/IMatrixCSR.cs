using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.user.qualifier.ElementDataType;
using linearsystems.user.data.Matrix;
using environment.messagepassing.Communicator;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.user.data.MatrixCSR { 

public interface IMatrixCSR<LIB, MPT, NUM, COM, DOM> : BaseIMatrixCSR<LIB, MPT, NUM, COM, DOM>, IMatrix<LIB, MPT, NUM, COM, DOM>
where LIB:ILibrary
where MPT:ISparseMatrix<LIB>
where NUM:IElementDataType
where COM:ICommunicator
where DOM:ILSSDomain<LIB, COM>
{

	void create(int ilower, int iupper, int jlower, int jupper, int[] ncols,int[] rows, int[] cols, object[] values);
	void initialize();
	void setIndexes(int ilower, int iupper, int jlower, int jupper);
	void setValues(int[] ncols,int[] rows, int[] cols, object[] values);		
	void assemble();		
		

} // end main interface 

} // end namespace 
