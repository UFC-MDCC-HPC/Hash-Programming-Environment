using System;
using System.IO;
using System.Runtime.Serialization;
using System.Collections;

namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class Unit {
 
	private string id_unit;
    private string id_unit_super;
    private int id_concrete;
	private string assembly_string;
    private int id_abstract;
    private string id_interface;
    private int order;
	private bool is_parallel;

    public int Order
    {
        get { return order; }
        set { order = value; }
    }

    //private string library_path = null; // this field can be computed ...

/*    public string Library_path
    {
        get {
            ComponentDAO cdao = new ComponentDAO();
            Component c = cdao.retrieve(id_concrete);
            return c.Library_path;
        }
    } */

    private string class_name; // Nome da interface no Front-End.

    public string Class_name
    {
        get { return class_name; }
        set { class_name = value; }
    }

    private int class_nargs;

    public int Class_nargs
    {
        get { return class_nargs; }
        set { class_nargs = value; }
    }
	
	 
	
	public string Assembly_string{
        get {
    //          string[] s = assembly_string.Split(',');
    //          string culture = s[1];
    //          string version = s[2];
    //          string key = s[3];
    //          string new_assembly_string = Class_name + "," + s[1] + "," + s[2] + "," + s[3];
    //          return new_assembly_string;
            return assembly_string;
        }
        set {assembly_string = value;}
    }

    string uri_source;
    public string URI_Source
    {
        get { return uri_source; }
        set { uri_source = value; }
    }

    public string Id_unit
    {
		get {return id_unit;}
        set {id_unit = value;}
	}

    public string Id_unit_super
    {
        get { return id_unit_super; }
        set { id_unit_super = value; }
    }

    public int Id_concrete
    {
		get {return id_concrete;}
        set {id_concrete = value;}
	}
	
	public string Id_interface 
    {
		get {return id_interface;}
        set {id_interface = value;}
	}
		
//	public int Unit_replica
//    {
//		get {return unit_replica;}
 //       set {unit_replica = value;}
//	}

    public int Id_abstract
    {
        get { return id_abstract; }
        set { id_abstract = value; }
    }


 
}//class

}//namespace
