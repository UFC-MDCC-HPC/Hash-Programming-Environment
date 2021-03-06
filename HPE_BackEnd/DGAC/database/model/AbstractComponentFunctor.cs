using System;
using System.IO;
using System.Collections.Generic;

using System.Runtime.Serialization;

namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class AbstractComponentFunctor : HashComponent {
	
	private int id_functor_app_supertype;
	private int id_abstract;
	
	private int facet_count = -1;
	public int FacetCount
	{
		get {
				if (facet_count == -1) 
					facet_count = BackEnd.idao.count_facets(Id_abstract); 
				return facet_count;
			}
	}

	

	//private IList parameters;

    private string library_path;
    public string Library_path
    {
        get {return library_path;}
        set {library_path = value;}
    }

	public string Name
	{
		get {
				string[] path = library_path.Split(new Char[] {'.'});
				return path[path.Length-1];
			}
	}

	public string Package
	{
		get {
				int pos = library_path.LastIndexOf (".");
				return library_path.Substring(0,pos);
			}
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
    
  //  public IList Parameters{
  //      get {return parameters;}
   //     set {parameters = value;}
  //  }
		
	public int getPartitionCount (string id_interface)
	{
		IList<Interface> iList = DGAC.BackEnd.idao.listByInterface(id_abstract,id_interface);
		return iList.Count;
	}
		
	public IDictionary<string, AbstractComponentFunctorApplication> ParameterBounds	
	{
		get {
				IDictionary<string, AbstractComponentFunctorApplication> r = new Dictionary<string, AbstractComponentFunctorApplication>();
				IList<AbstractComponentFunctorParameter> acfpList = BackEnd.acfpdao.list(Id_abstract);
				foreach (AbstractComponentFunctorParameter acfp in acfpList)
				{
					AbstractComponentFunctorApplication acfa_bounds = BackEnd.acfadao.retrieve(acfp.Bounds_of);
					r.Add(acfp.Id_parameter,acfa_bounds);	
				}	
				return r;
			}
	}
}//class

}//namespace


