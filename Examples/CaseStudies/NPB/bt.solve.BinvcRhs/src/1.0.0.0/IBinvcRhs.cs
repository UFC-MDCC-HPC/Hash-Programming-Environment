using br.ufc.pargo.hpe.kinds;
using common.solve.Method;

namespace bt.solve.BinvcRhs { 
	public interface IBinvcRhs<MTH> : BaseIBinvcRhs<MTH>
	where MTH:IMethod {
	   void setParameters(double[,,] lhs, 
	                      double[,,,,,] c, 
	                      double[, , , ,] r, 
	                      int l1, 
	                      int c1, int c2, int c3, int c4, 
	                      int r1, int r2, int r3, int r4);
	}
}
