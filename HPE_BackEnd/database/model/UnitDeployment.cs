using System;
using System.IO;
using System.Runtime.Serialization;


namespace DGAC.database{

[Serializable()]
public class UnitDeployment {
 
	private int id_unit;
	private int id_deployment;
	private int id_node;
	
	public int Id_unit{
		get {return id_unit;}
        set {id_unit = value;}
	}
	
	public int Id_deployment{
		get {return id_deployment;}
        set {id_deployment = value;}
	}
	
	public int Id_node{
		get {return id_node;}
        set {id_node = value;}
	}
	
	
}//class

}//namespace