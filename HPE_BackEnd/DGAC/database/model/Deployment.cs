using System;
using System.IO;
using System.Runtime.Serialization;


namespace DGAC.database{

[Serializable()]
public class Deployment {
 
	 
	private int id_deployment;
	private int id_concrete_deployed;
	
	public int Id_concrete_deployed{
		get {return id_concrete_deployed;}
        set {id_concrete_deployed = value;}
	}
	
	public int Id_deployment{
		get {return id_deployment;}
        set {id_deployment = value;}
	}

}//class

}//namespace