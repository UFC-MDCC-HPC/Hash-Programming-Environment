using br.ufc.pargo.hpe.kinds;

namespace common.data.Field { 

public interface IField : BaseIField
{

	double[,,,,] Field { get; }
		
	void initialize_field(string fieldName, int max_cells, int IMAX, int JMAX, int KMAX);	
	void initialize_field(string fieldName, int max_cells, int IMAX, int JMAX, int KMAX, int neq);	
		
	string FieldName { get; }
    int IMAX { get; }
	int JMAX { get; }
	int KMAX { get; }
	int MaxCells { get; }

} // end main interface 

} // end namespace 
