using System;
using System.IO;
using System.Runtime.Serialization;
using System.Collections.Generic;


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class Component : HashComponent {
 
	
	private string library_path;
	private int id_concrete;
	private int id_concrete_supertype;
	private int id_functor_app;
	private int id_abstract;
	
	 
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
		//		return id_abstract;
				AbstractComponentFunctorApplication acfa = null;
				AbstractComponentFunctorApplication acfa_previous = null;
				bool found = false;
				Component cThis = this;
				while (!found)
				{
					acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(cThis.Id_functor_app);             
	                acfa_previous = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve_next(acfa.Id_functor_app);					
					if (acfa_previous == null)
					{
						found = true;
					} 
					else
					{
						cThis = br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieveByFunctorApp(acfa_previous.Id_functor_app);					
					}
						
				}
					
	             return acfa.Id_abstract; 
	        }
			set { id_abstract = value; }
    }

    public string Kind
    {
        get {
            //AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
           // AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
            AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(this.Id_functor_app);
            return br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(acfa.Id_abstract).Kind;
        }
    }

    public IDictionary<string, AbstractComponentFunctorApplication> Arguments
    {
        get
        {
				Console.Error.WriteLine("get_Parameter enter");
            IDictionary<string, AbstractComponentFunctorApplication> pars = new Dictionary<string, AbstractComponentFunctorApplication>();
            IList<SupplyParameter> sps = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list(this.Id_functor_app);
            foreach (SupplyParameter sp in sps)
            {
				Console.Error.WriteLine("get_Parameter loop");
				if (sp is SupplyParameterComponent)
				{
                	SupplyParameterComponent sp_ = (SupplyParameterComponent) sp;					
                    pars.Add(sp_.Id_parameter, br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(sp_.Id_functor_app_actual));
				} 
				else // sp_ is SupplyParameterParameter
				{
					SupplyParameterParameter sp_ = (SupplyParameterParameter) sp;					
					Console.Error.WriteLine("sp_.Id_parameter = " + sp_.Id_parameter);
					Console.Error.WriteLine("sp_.Id_parameter_actual = " + sp_.Id_argument);
					Console.Error.WriteLine("sp_.FreeVariable = " + sp_.FreeVariable);	
					throw new InvalidCastException();							
				}
            }
            return pars;   
        }
    }


}//class

}//namespace