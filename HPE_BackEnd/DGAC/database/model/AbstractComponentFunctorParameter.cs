using System;
using System.IO;

using System.Runtime.Serialization;

namespace DGAC.database{

[Serializable()]
public class AbstractComponentFunctorParameter{
 
	
	private string id_parameter;
	private int bounds_of;
	private int id_abstract;
	
	public string Id_parameter{
        get {return id_parameter;}
        set {id_parameter = value;}
    }
	  
  	public int Bounds_of{
        get {return bounds_of;}
        set {bounds_of = value;}
    }
    
    public int Id_abstract{
        get {return id_abstract;}
        set {id_abstract = value;}
    }
	
}//class

}//namespace