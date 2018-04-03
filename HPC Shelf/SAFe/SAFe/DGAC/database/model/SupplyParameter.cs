using System;
using System.IO;
using System.Runtime.Serialization;


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public abstract class SupplyParameter {
 
	private string id_parameter;
	private int id_functor_app;
	private int id_abstract;
	 
	
	public string Id_parameter{
		get {return id_parameter;}
        set {id_parameter = value;}
	}
	
	public int Id_functor_app{
		get {return id_functor_app;}
        set {id_functor_app = value;}
	}
	
	public int Id_abstract{
		get {return id_abstract;}
        set {id_abstract = value;}
	}
	
	 
	
}//class

}//namespace