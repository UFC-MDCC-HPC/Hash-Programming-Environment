using System;
using System.IO;
using System.Runtime.Serialization;


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class SupplyParameterParameter : SupplyParameter{
 
	//private string id_parameter;
	//private int id_functor_app;
	private string id_parameter_actual;

    private bool freeVariable;

	public bool FreeVariable {
		get {return freeVariable;}
        set {freeVariable = value;}
	}
	 
	
	/*public string Id_parameter{
		get {return id_parameter;}
        set {id_parameter = value;}
	}
	
	public int Id_functor_app{
		get {return id_functor_app;}
        set {id_functor_app = value;}
	}*/
	
	public string Id_parameter_actual{
		get {return id_parameter_actual;}
        set {id_parameter_actual = value;}
	}
	
	 
	
}//class

}//namespace