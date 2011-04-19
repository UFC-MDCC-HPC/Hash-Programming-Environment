using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.data.Field;

namespace impl.ft.data.FieldImpl { 
	public class IFieldImpl : BaseIFieldImpl, IField {
		public IFieldImpl() { 
		
		} 
		private double[,,,] field = null;

		public double[,,,] Field {
			get {
				if (field == null) {
					throw new NotInitializedFieldException(this.FieldName);
				}
				return field;
			}
		}

		public void initialize_field(string fieldName, int i0, int i1, int i2, int i3) {
			this.fieldName = fieldName;
			field = new double[i0, i1, i2, i3];
		}

		private string fieldName;

		public string FieldName { get {return fieldName; } }
	}
	public class NotInitializedFieldException : Exception {
		public NotInitializedFieldException(string fieldName) : base("Field " + fieldName + " not initialized."){
				
		}
	}
}
