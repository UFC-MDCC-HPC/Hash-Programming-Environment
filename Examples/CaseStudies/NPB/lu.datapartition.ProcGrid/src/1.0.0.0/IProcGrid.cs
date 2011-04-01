using br.ufc.pargo.hpe.kinds;

namespace lu.datapartition.ProcGrid { 
	public interface IProcGrid : BaseIProcGrid {
		int xdim {get;}
		int ydim {get;}
		int row {get;}
		int col {get;}
	}
}
