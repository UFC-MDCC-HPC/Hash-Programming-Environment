using System;
using System.IO;
using System.Runtime.Serialization;


namespace DGAC.database{

[Serializable()]
public class Permutation {

    private int id_abstract;
    private string id_inner;
    private string id_interface_slice;
    private int id_split_replica = -1;
    private string id_enumerator;
    private int id_abstract_enumerator;
    private string id_interface;

    public int Id_abstract
    {
        get { return id_abstract; }
        set { id_abstract = value; }
    }

	public string Id_inner{
        get {return id_inner;}
        set {id_inner = value;}
    }


    public string Id_interface_slice
    {
        get { return id_interface_slice; }
        set { id_interface_slice = value; }
    }
    	
    public int Id_split_replica
    {
        get { return id_split_replica; }
        set { id_split_replica = value; }
    }

    public string Id_enumerator
    {
        get { return Id_enumerator; }
        set { Id_enumerator = value; }
    }

    public int Id_abstract_enumerator
    {
        get { return Id_abstract_enumerator; }
        set { Id_abstract_enumerator = value; }
    }

    public string Id_interface
    {
        get {return id_interface;}
        set {id_interface = value;}
    }



}//class

}//namespace