using System;
using System.IO;
using System.Runtime.Serialization;


namespace DGAC.database{

[Serializable()]
public class Node {
 
	private int id_node;
	private string host;
	 
	
	public string Host{
        get {return host;}
        set {host = value;}
    }
	 
	public int Id_node{
		get {return id_node;}
        set {id_node = value;}
	}

}//class

}//namespace