using System;
using System.IO;
using System.Runtime.Serialization;


namespace DGAC.database{

[Serializable()]
public class InnerComponent{
 
	
	 
	private int id_functor_app;
	private int id_abstract_inner;
	private string id_inner;
	private int id_abstract_owner;
    private string parameter_top;
    private bool transitive;

    public bool Transitive
    {
        get { return transitive; }
        set { transitive = value; }
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