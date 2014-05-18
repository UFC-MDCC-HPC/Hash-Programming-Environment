using System;
using System.IO;
using System.Runtime.Serialization;


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class SupplyParameterParameter : SupplyParameter{
 
	//private string id_parameter;
	//private int id_functor_app;
	private string id_argument;

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
	
	public string Id_argument{
		get {return id_argument;}
        set {id_argument = value;}
	}
	
	 
	
}//class

}//namespace