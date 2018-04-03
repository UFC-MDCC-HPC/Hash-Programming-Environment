using System;
using System.IO;
using System.Runtime.Serialization;
using System.Collections.Generic;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using System.Xml.Serialization;
using System.Xml;
using System.Diagnostics;

namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class Interface {
 
	private string id_interface;
    private string id_interface_super;
    private string id_interface_super_top;

	private int facet;

	public int Facet {
		get {
			return facet;
		}
		set {
			this.facet = value;
		}
	}

	private bool is_parallel;
		

	public bool Is_parallel {
		get {
			return is_parallel;
		}
		set {
			this.is_parallel = value;
		}
	}

    private int order;

    public int Order
    {
        get { return order; }
        set { order = value; }
    }
		
	private string[] actions;	
		
	public string[] Actions
	{
		get { return Actions; }
		set { actions = value; }
	}

	private string[] conditions;	
		
	public string[] Conditions
	{
		get { return Conditions; }
		set { conditions = value; }
	}
		
	private string protocol;	
		
	public string Protocol
	{
		get { return Protocol; }
		set { protocol = value; }
	}
		
    	public string Id_interface_super_top
    {
        get 
		{
			//	Console.WriteLine("Id_interface_super_top ... BEGIN");
            if (id_interface_super_top == null) 
			{
                if (id_interface_super.Equals("")) 
				{
				//		Console.WriteLine ("Id_interface_super_top 1: " + id_interface);
                    id_interface_super_top = id_interface;
                } 
				else 
				{
					//	Console.WriteLine ("Id_interface_super_top 2.1: " + id_interface_super + " / " + id_abstract);
					string[] id_interface_super_list_ = Interface.splitIDs(Id_interface_super);
                    AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(id_abstract);
					//	Console.WriteLine ("Id_interface_super_top 2.2: " + acf.Id_functor_app_supertype);
                    if (acf.Id_functor_app_supertype != 0)
                    {
                        AbstractComponentFunctorApplication acfaSuper = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acf.Id_functor_app_supertype);
							if (id_interface_super_list_.Length == 0)
								id_interface_super_top = "";
							else 
							{
								string id_interface_super_1 = id_interface_super_list_[0];
								Interface iSuper1 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve (acfaSuper.Id_abstract, id_interface_super_1);
								id_interface_super_top = iSuper1.Id_interface_super_top;
								for (int j = 1; j < id_interface_super_list_.Length; j++) 
								{
									string id_interface_super_2 = id_interface_super_list_[j];
							//		Console.WriteLine ("Id_interface_super_top 3.1: " + id_interface_super_2);
									Interface iSuper2 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve (acfaSuper.Id_abstract, id_interface_super_2);
									id_interface_super_top += "+" + iSuper2.Id_interface_super_top;
							//		Console.WriteLine ("Id_interface_super_top 3.2: " + id_interface_super_top);
								}
							}
                    }
                    else
                    {
                        id_interface_super_top = id_interface;
                    }
                }
                br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.setInterfaceSuperTop(id_abstract, id_interface, id_interface_super_top);
				//	Console.WriteLine("Id_interface_super_top ... END ");
			    return id_interface_super_top;
            } 
			else 
			{
                return id_interface_super_top;
            }
        }
        set
        {
            id_interface_super_top = value;
        }
    }
    
    private int id_abstract;
	private string assembly_string;

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

    string uri_source;
    public string URI_Source
    {
        get { return uri_source; }
        set { uri_source = value; }
    }
	 
	
	public string Id_interface{
        get {return id_interface;}
        set {id_interface = value;}
    }

    public string Id_interface_super
    {
        get { return id_interface_super; }
        set { id_interface_super = value; }
    }

    public int Id_abstract
    {
        get {return id_abstract;}
        set {id_abstract = value;}
    }
    

    public string Assembly_string
	{
        get { return assembly_string; }
        set { assembly_string = value; }
    }




    public IList<string> References
    {
        get
        {
			AbstractComponentFunctor acf = BackEnd.acfdao.retrieve(Id_abstract);	
			return fetchReferences(acf.ParameterBounds);
        }
    }


    public IList<string> fetchReferences(IDictionary <string, AbstractComponentFunctorApplication> pars) 
    {
		Console.WriteLine("ENTER fetchReferences - id_abstract=" + this.Id_abstract + ", id_interface="+ this.Id_interface);

		foreach (KeyValuePair<string, AbstractComponentFunctorApplication> y in pars )
		{
			if (y.Key != null && y.Value != null)
				Console.WriteLine("key=" + y.Key + ", value=" + y.Value.Id_abstract);
			else {
					Console.WriteLine("somthing strange : " + (y.Key==null ? "null" : y.Key.ToString()) + " , " + (y.Value==null ? "null" : y.Value.ToString()));
			}
		}

        IList<string> refs = new List<string>();
			
        AbstractComponentFunctor cThis = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(this.Id_abstract);
        AbstractComponentFunctorApplication cSuperApp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(cThis.Id_functor_app_supertype);
        if (cSuperApp != null)
        {				
            AbstractComponentFunctor acfsuper = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(cSuperApp.Id_abstract);
            IDictionary<string, AbstractComponentFunctorApplication> parsSuper = null;
            collectParameters(pars, cSuperApp, out parsSuper);

			string[] id_interface_super_list = Interface.splitIDs (this.Id_interface_super);
				Console.WriteLine ("fetchReferences: id_interface_super_list.Length = " + id_interface_super_list.Length + ", this.Id_Interface_super=" + this.Id_interface_super);
				foreach (string sss in id_interface_super_list) 
				{
					Console.WriteLine ("fetchReference - SUPER: " + sss);
				}

			foreach (string id_interface_super in id_interface_super_list) 
			{
				Interface iSuper = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve(cSuperApp.Id_abstract, id_interface_super);
				foreach (string iref in iSuper.fetchReferences(parsSuper))
					refs.Add (iref);
				string refname = LoaderApp.buildDllName(acfsuper.Library_path, iSuper.Assembly_string);
				if (!refs.Contains(refname))
					refs.Add(refname);
			}

        }

        // Traverse slices.
        IList<Slice> slices = br.ufc.pargo.hpe.backend.DGAC.BackEnd.sdao.listByInterface(Id_abstract, Id_interface);

        foreach (Slice s in slices)
        {
			Console.WriteLine("SLICE (fetchReference): " + Id_abstract + ":" + Id_interface + ":" + s.Id_inner + " - " + s.PortName );

            InnerComponent ic = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve(Id_abstract, s.Id_inner); 
			if (ic != null)
            {
                AbstractComponentFunctorApplication acfa = null;
                IDictionary<string, AbstractComponentFunctorApplication> parsSlice = null;

                // ---------------------------------------------------------------------------------------
                if (!ic.Parameter_top.Equals(""))
                {
                    if (!pars.TryGetValue(ic.Parameter_top, out acfa)) {
                    	acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(ic.Id_functor_app);                    
						Console.WriteLine("fetchReferences - TRACE 1.1 - ic.Parameter_top=" + ic.Parameter_top + ", acfa.Id_abstract=" + acfa.Id_abstract);
					}
					else
					{
						Console.WriteLine("fetchReferences - TRACE 1.2 - ic.Parameter_top=" + ic.Parameter_top + ", acfa.Id_abstract=" + acfa.Id_abstract + ", ic.id_inner=" + ic.Id_inner);
					}
                }
                else
                {
                    acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(ic.Id_functor_app);
					Console.WriteLine("fetchReferences - TRACE 2 - acfa.Id_abstract=" + acfa.Id_abstract);
                }

                collectParameters(pars, acfa, out parsSlice);

				Console.WriteLine("RETRIEVE BY MATCHING: " + acfa.Id_abstract + "," +  ic.Id_abstract_inner + "," + s.Id_interface_slice);
                Interface[] i_list = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveByMatching(acfa.Id_abstract, ic.Id_abstract_inner, s.Id_interface_slice);

				if (i_list == null || i_list.Length == 0) {
                   Console.WriteLine("i is null : " + acfa.Id_abstract + "," + ic.Id_abstract_inner + "," + s.Id_interface_slice);
                }
                AbstractComponentFunctor acfSlice = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(acfa.Id_abstract);

				foreach (Interface i in i_list)
				{
	                IList<string> refsSlice = i.fetchReferences(parsSlice);

	                foreach (string r in refsSlice)
	                    if (!refs.Contains(r))
	                        refs.Add(r);

	                string refname = LoaderApp.buildDllName(acfSlice.Library_path, i.Assembly_string);
	                if (!refs.Contains(refname))
	                    refs.Add(refname);
				}
            }
        }

			Console.WriteLine("EXIT fetchReferences - id_abstract=" + this.Id_abstract + ", id_interface="+ this.Id_interface);
        return refs; 
    }

    private InnerComponent findInnerComponentOwnerOfSlice(int Id_abstract, string id_inner)
    {
        int Id_abstract_traverse = Id_abstract;
        InnerComponent ic = null;
        while (ic == null && Id_abstract_traverse != 0)
        {
            ic = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve(Id_abstract_traverse, id_inner);
            if (ic == null)
            {
                AbstractComponentFunctor cTraverse = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(Id_abstract_traverse);
                AbstractComponentFunctorApplication cSuperApp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(cTraverse.Id_functor_app_supertype);
                Id_abstract_traverse = cSuperApp.Id_abstract;
            }
        }
        return ic;
    }

    private void collectParameters(IDictionary<string, AbstractComponentFunctorApplication> pars, 
                                   AbstractComponentFunctorApplication acfa, 
                                   out IDictionary<string, AbstractComponentFunctorApplication> parsSlice)
    {
        IList<SupplyParameter> spList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list(acfa.Id_functor_app);

        parsSlice = new Dictionary<string, AbstractComponentFunctorApplication>();

        foreach (SupplyParameter sp in spList)
        {
            AbstractComponentFunctorApplication acfaPar=null;
            if (sp is SupplyParameterComponent)
            {
                SupplyParameterComponent sp_ = (SupplyParameterComponent) sp;
                acfaPar = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(sp_.Id_functor_app_actual);
                parsSlice.Add(sp_.Id_parameter, acfaPar);
				Console.WriteLine("collectParameter -TRACE 1 " + sp_.Id_parameter + ":" + acfaPar.Id_abstract);
            }
            else if (sp is SupplyParameterParameter)
            {
                SupplyParameterParameter sp_ = (SupplyParameterParameter) sp;
                acfaPar = null;
				Console.WriteLine("collectParameter -TRACE 2 " + "#" + sp_.Id_functor_app + sp_.Id_parameter);
                
				pars.TryGetValue("#" + sp_.Id_functor_app + sp_.Id_parameter, out acfaPar);
                if (acfaPar == null)
                {
					Console.WriteLine("collectParameter -TRACE 3 " + sp_.Id_argument);
                    
                    if (pars.TryGetValue(sp_.Id_argument, out acfaPar))
                    {
                        parsSlice.Add(sp_.Id_parameter, acfaPar);
						Console.WriteLine("collectParameter -TRACE 4 " + sp_.Id_parameter + " : " + acfaPar.Id_abstract);
                    }
                    else 
                    {
                        AbstractComponentFunctorParameter acfp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(Id_abstract, sp_.Id_argument);
                        if (acfp == null)
								acfp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(sp_.Id_abstract,sp_.Id_parameter);
						acfaPar = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acfp.Bounds_of);
                        parsSlice.Add(sp_.Id_parameter, acfaPar);
						Console.WriteLine("collectParameter -TRACE 5 " + sp_.Id_parameter + " : " + acfaPar.Id_abstract);
                    }
                }
                else
                {
					Console.WriteLine("collectParameter -TRACE 6 " + "#" + sp_.Id_functor_app + sp_.Id_parameter + " : " + acfaPar.Id_abstract);
                    parsSlice.Add(sp_.Id_parameter, acfaPar);
                }


                /* else
                {
                    throw new Exception("ERROR !!!! collectParameters (Interface.cs)");
                }*/
            }

            collectFV(acfaPar, pars, parsSlice);
        }
        
        

    }

    private void collectFV(AbstractComponentFunctorApplication acfa, 
                           IDictionary<string, AbstractComponentFunctorApplication> pars, 
                           IDictionary<string, AbstractComponentFunctorApplication> apars)
    {
        
        //SupplyParameterDAO spdao = new SupplyParameterDAO();
        IList<SupplyParameter> sps = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list(acfa.Id_functor_app);
        foreach (SupplyParameter sp in sps)
        {
            if (sp is SupplyParameterComponent)
            {
                SupplyParameterComponent sp_ = (SupplyParameterComponent)sp;
               // AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
                AbstractComponentFunctorApplication acfaPar = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(sp_.Id_functor_app_actual);
                collectFV(acfaPar, pars, apars);
            }
            else if (sp is SupplyParameterParameter) 
            {
                SupplyParameterParameter sp_ = (SupplyParameterParameter)sp;
                AbstractComponentFunctorApplication acfaPar = null;
                pars.TryGetValue("#" + sp_.Id_functor_app + sp_.Id_parameter, out acfaPar);
                if (acfaPar == null)
                {
                    pars.TryGetValue(sp_.Id_argument, out acfaPar);
                }
					Console.WriteLine("collectFV : id_functor_app=" + acfa.Id_functor_app + ", id_abstract=" + acfa.Id_abstract + ", " + "#" + sp_.Id_functor_app + sp_.Id_parameter + ", " + ", " + sp_.Id_argument + (acfaPar==null));
                apars.Add("#" + sp_.Id_functor_app + sp_.Id_parameter, acfaPar);
            }

        }

       
    }

	public static string[] splitIDs (string id_interface_composed)
	{
		return id_interface_composed.Split (new char[1] { '+' });
	}

	
}//class

}//namespace
