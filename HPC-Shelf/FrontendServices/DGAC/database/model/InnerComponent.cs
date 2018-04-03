using System;
using System.IO;
using System.Runtime.Serialization;


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class InnerComponent{
 
	
	private bool is_public; 
	private int id_functor_app;
	private int id_abstract_inner;
	private string id_inner;
	private int id_abstract_owner;
    private string parameter_top;
    private bool transitive;
	private bool multiple;

    public bool Transitive
    {
        get { return transitive; }
        set { transitive = value; }
    }

	public bool Multiple
	{
		get { return multiple; }
		set { multiple = value; }
	}

	public bool IsPublic
    {
        get { return is_public; }
        set { is_public = value; }
    }

    public string Parameter_top
    {
        get { return parameter_top; }
        set { parameter_top = value; }
    }
	

  	public int Id_functor_app{
        get {return id_functor_app;}
        set {id_functor_app = value;}
    }
    
    public int Id_abstract_inner{
        get {return id_abstract_inner;}
        set {id_abstract_inner = value;}
    }
    
    public int Id_abstract_owner{
        get {return id_abstract_owner;}
        set {id_abstract_owner = value;}
    }
	
	public string Id_inner{
        get {return id_inner;}
        set {id_inner = value;}
    }
}//class

}//namespace