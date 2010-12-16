using System;
using System.IO;
using System.Collections;

using System.Runtime.Serialization;

namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class AbstractComponentFunctor : HashComponent {
 
	
	private int id_functor_app_supertype;
	private int id_abstract;
	
	private IList parameters;

    private string library_path;
    public string Library_path
    {
        get {return library_path;}
        set {library_path = value;}
    }

    private string kind;
    public string Kind
    {
        get { return kind; }
        set { kind = value; }
    }
  	
  	public int Id_functor_app_supertype{
        get { return id_functor_app_supertype; }
        set { id_functor_app_supertype = value; }
    }
    
    public int Id_abstract{
        get {return id_abstract;}
        set {id_abstract = value;}
    }
    
    public IList Parameters{
        get {return parameters;}
        set {parameters = value;}
    }
	
}//class

}//namespace