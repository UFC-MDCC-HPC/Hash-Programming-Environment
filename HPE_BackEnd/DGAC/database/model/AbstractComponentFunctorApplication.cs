using System;
using System.IO;
using System.Collections.Generic;
using System.Runtime.Serialization;

namespace br.ufc.hpe.backend.DGAC.database{

[Serializable()]
public class AbstractComponentFunctorApplication{
 
	private int id_functor_app = -1;
	private int id_abstract = -1;
  	private IDictionary<string, int> parametersList = null;
  	
  	public AbstractComponentFunctorApplication(){
  	
  		parametersList =  new Dictionary<string,int>();
  	}
  	
  	public int Id_functor_app{
        get {return id_functor_app;}
        set {id_functor_app = value;}
    }
    
    public int Id_abstract{
        get {return id_abstract;}
        set {id_abstract = value;}
    }
    
    public void addParameter(string id_parameter_actual, int id_functor_app_actual){
        if (this.parametersList.ContainsKey(id_parameter_actual)) {
           this.parametersList.Remove(id_parameter_actual);
        }
        this.parametersList.Add(id_parameter_actual, id_functor_app_actual);
    }
    
    public IDictionary<string,int> ParametersList {
        get { return parametersList; }
    }
	
}//class

}//namespace
