using br.ufc.pargo.hpe.kinds;

namespace lu.data.Field { 
	public interface IField : BaseIField {
		double[,,,] Field { get; }
			
		void initialize_field(string fieldName, int i0, int i1, int i2, int i3);	
			
		string FieldName { get; }
	}
}
