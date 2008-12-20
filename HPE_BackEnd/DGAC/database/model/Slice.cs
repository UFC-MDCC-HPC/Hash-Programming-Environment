using System;
using System.IO;
using System.Runtime.Serialization;


namespace DGAC.database{

[Serializable()]
public class Slice {

    private int id_abstract;
    private string id_interface;
    private string id_interface_slice;
    private int id_split_replica;
    private string id_inner;
    bool transitive;

    public bool Transitive
    {
        get { return transitive; }
        set { transitive = value; }
    }

    public int Id_abstract
    {
        get { return id_abstract; }
        set { id_abstract = value; }
    }

    public string Id_interface
    {
        get {return id_interface;}
        set {id_interface = value;}
    }

  /*  public int Id_abstract_slice
    {
        get { return id_abstract_slice; }
        set { id_abstract_slice = value; }
    }
    */

    public string Id_interface_slice
    {
        get { return id_interface_slice; }
        set { id_interface_slice = value; }
    }
    	
	public string Id_inner{
        get {return id_inner;}
        set {id_inner = value;}
    }


    public int Id_split_replica
    {
        get { return id_split_replica; }
        set { id_split_replica = value; }
    }




}//class

}//namespace