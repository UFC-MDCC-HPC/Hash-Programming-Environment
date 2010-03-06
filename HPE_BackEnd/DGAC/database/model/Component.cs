using System;
using System.IO;
using System.Runtime.Serialization;
using System.Collections.Generic;


namespace DGAC.database{

[Serializable()]
public class Component : HashComponent {
 
	
	private string library_path;
	private int id_concrete;
	private int id_concrete_supertype;
	private int id_functor_app;
	
	 
  	public string Library_path{
        get {return library_path;}
        set {library_path = value;}
    }
  	
  	public int Id_concrete{
        get {return id_concrete;}
        set {id_concrete = value;}
    }
  	
  	public int Id_concrete_supertype{
        get {return id_concrete_supertype;}
        set {id_concrete_supertype = value;}
    }
    
    public int Id_functor_app{
        get {return id_functor_app;}
        set {id_functor_app = value;}
    }

    public int Id_abstract
    {
        get { 
             AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
             AbstractComponentFunctorApplication acfa = acfadao.retrieve(this.Id_functor_app);             
             return acfa.Id_abstract; 
        
        }
    }

    public string Kind
    {
        get {
            AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
            AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
            AbstractComponentFunctorApplication acfa = acfadao.retrieve(this.Id_functor_app);
            return acfdao.retrieve(acfa.Id_abstract).Kind;
        }
    }

    public IDictionary<string, AbstractComponentFunctorApplication> Parameters
    {
        get
        {
            IDictionary<string, AbstractComponentFunctorApplication> pars = new Dictionary<string, AbstractComponentFunctorApplication>();
            SupplyParameterDAO spdao = new SupplyParameterDAO();
            AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
            IList<SupplyParameter> sps = spdao.list(this.Id_functor_app);
            foreach (SupplyParameter sp in sps)
            {
                SupplyParameterComponent sp_ = (SupplyParameterComponent) sp;                
                pars.Add(sp_.Id_parameter, acfadao.retrieve(sp_.Id_functor_app_actual));
            }
            return pars;   
        }
    }


    internal Unit fetchUnit(string id_interface)
    {
        InterfaceDAO idao = new InterfaceDAO();
        Interface i = idao.retrieve(this.Id_abstract, id_interface);

        UnitDAO udao = new UnitDAO();
        return udao.retrieve(Id_concrete, i.Order);
    }
}//class

}//namespace