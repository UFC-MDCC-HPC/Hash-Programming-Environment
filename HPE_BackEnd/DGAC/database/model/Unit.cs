using System;
using System.IO;
using System.Runtime.Serialization;
using System.Collections;

namespace DGAC.database{

[Serializable()]
public class Unit {
 
	private string id_unit;
    private string id_unit_super;
    private int id_concrete;
	private string assembly_string;
    private int id_interface_abstract;
    private string id_interface_interface;
    private int id_index;
    private string source_code = null;
    private int order;

    public int Order
    {
        get { return order; }
        set { order = value; }
    }

    public string Source_code
    {
        get { return source_code; }
        set { source_code = value; }
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

    public int Id_index
    {
        get { return id_index; }
        set { id_index = value; }
    }
	
	 
	
	public string Assembly_string{
        get {return assembly_string;}
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
	
	public string Id_interface_interface 
    {
		get {return id_interface_interface;}
        set {id_interface_interface = value;}
	}

    public int Id_interface_abstract
    {
        get { return id_interface_abstract; }
        set { id_interface_abstract = value; }
    }


 
}//class

}//namespace