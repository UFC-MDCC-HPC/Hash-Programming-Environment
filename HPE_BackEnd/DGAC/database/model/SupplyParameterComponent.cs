using System;
using System.IO;
using System.Runtime.Serialization;


namespace br.ufc.lia.hpe.backend.DGAC.database{

[Serializable()]
public class SupplyParameterComponent : SupplyParameter{
 
	//private string id_parameter;
	//private int id_functor_app;
	private int id_functor_app_actual;
	 
	 
	
	
	/*public string Id_parameter{
		get {return id_parameter;}
        set {id_parameter = value;}
	}
	
	public int Id_functor_app{
		get {return id_functor_app;}
        set {id_functor_app = value;}
	}*/
	
	public int Id_functor_app_actual{
		get {return id_functor_app_actual;}
        set {id_functor_app_actual = value;}
	}
	
	 
	
}//class

}//namespace