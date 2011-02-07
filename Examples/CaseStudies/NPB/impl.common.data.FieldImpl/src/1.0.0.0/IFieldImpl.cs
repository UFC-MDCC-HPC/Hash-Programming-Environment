using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.data.Field;

namespace impl.common.data.FieldImpl { 

public class IFieldImpl : BaseIFieldImpl, IField
{
    private double[,,,,] field = null;
		
    public double[,,,,] Field { 
			get 
			{ 
				if (field == null) 
				{
					throw new NotInitializedFieldException(this.FieldName);
				}
				return field; 
			} 
		}
		
	public void initialize_field(string fieldName, int maxcells, int IMAX, int JMAX, int KMAX, int neq) 
	{
		this.fieldName = fieldName;
		this._IMAX = IMAX;
		this._JMAX = JMAX;
		this._KMAX = KMAX;
		this.maxcells = maxcells;
		this.neq = neq;
			
		field = new double[maxcells, KMAX + 3, JMAX + 3, IMAX + 3, neq];
	}
		
	public void initialize_field(string fieldName, int maxcells, int IMAX, int JMAX, int KMAX) 
	{
		this.initialize_field(fieldName, maxcells, IMAX, JMAX, KMAX, 1);
	}

	private string fieldName;
	private int maxcells;
	private int _IMAX, _JMAX, _KMAX;
	private int neq = 1;
		
	public string FieldName { get {return fieldName; } }
    public int IMAX { get { return _IMAX; } }
	public int JMAX { get { return _JMAX; } }
	public int KMAX { get { return _KMAX; } }
	public int MaxCells { get { return maxcells; } }
	public int NEQ { get {return neq; } }
		

}

public class NotInitializedFieldException : Exception	
{
    public NotInitializedFieldException(string fieldName) : base("Field " + fieldName + " not initialized.")
	{
			
	}
}
	
}