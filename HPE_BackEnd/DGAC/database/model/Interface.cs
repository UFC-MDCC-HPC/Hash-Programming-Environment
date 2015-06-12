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
        get {
            if (id_interface_super_top == null) {

                if (id_interface_super.Equals("")) {
                    id_interface_super_top = id_interface;
					unit_replica_super_top = unit_replica;
                } else {
                    string id_interface_super_ = Id_interface_super;
					int partition_index_super_ = Unit_replica_super;
                    AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(id_abstract);
                    if (acf.Id_functor_app_supertype != 0)
                    {
                        AbstractComponentFunctorApplication acfaSuper = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acf.Id_functor_app_supertype);
                        Interface iSuper = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve(acfaSuper.Id_abstract, id_interface_super_, partition_index_super_);
                        id_interface_super_top = iSuper.Id_interface_super_top;
						unit_replica_super_top = iSuper.Unit_replica_super_top;
                    }
                    else
                    {
                        id_interface_super_top = id_interface;
						unit_replica_super_top = unit_replica;
                    }
                }
                br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.setInterfaceSuperTop(id_abstract, id_interface, unit_replica, id_interface_super_top, unit_replica_super_top);
                return id_interface_super_top;
            } else {
                return id_interface_super_top;
            }
        }
        set
        {
            id_interface_super_top = value;
        }
    }
    
    private int id_abstract;
    private int unit_replica;
	private int unit_replica_super;
	private int unit_replica_super_top;
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
		
    public int Unit_replica_super
    {
        get {return unit_replica_super;}
        set {unit_replica_super = value;}
    }
		
    public int Unit_replica_super_top
    {
        get {return unit_replica_super_top;}
        set {unit_replica_super_top = value;}
    }

    public int Id_abstract
    {
        get {return id_abstract;}
        set {id_abstract = value;}
    }
    
    public int Unit_replica
    {
        get {return unit_replica;}
        set {unit_replica = value;}
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
			Trace.WriteLine("ENTER fetchReferences - id_abstract=" + this.Id_abstract + ", id_interface="+ this.Id_interface);

							foreach (KeyValuePair<string, AbstractComponentFunctorApplication> y in pars )
							{
								if (y.Key != null && y.Value != null)
									Trace.WriteLine("key=" + y.Key + ", value=" + y.Value.Id_abstract);
								else {
										Trace.WriteLine("somthing strange : " + (y.Key==null ? "null" : y.Key.ToString()) + " , " + (y.Value==null ? "null" : y.Value.ToString()));
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
            Interface iSuper = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve(cSuperApp.Id_abstract, this.Id_interface_super, this.Unit_replica_super);
            refs = iSuper.fetchReferences(parsSuper);
            string refname = LoaderApp.buildDllName(acfsuper.Library_path, iSuper.Assembly_string);
            if (!refs.Contains(refname))
                refs.Add(refname);
            //string refnamebase = LoaderApp.buildDllNameBase(acfsuper.Library_path, iSuper.Assembly_string);
            //if (!refs.Contains(refnamebase))
            //    refs.Add(refnamebase);
        }

        // Traverse slices.
        IList<Slice> slices = br.ufc.pargo.hpe.backend.DGAC.BackEnd.sdao.listByInterface(Id_abstract, Id_interface, Unit_replica);

        foreach (Slice s in slices)
        {
			Trace.WriteLine("SLICE (fetchReference): " + Id_abstract + ":" + Id_interface + ":" + s.Id_inner + " - " + s.PortName + " -- " + s.Slice_replica);

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
						Trace.WriteLine("fetchReferences - TRACE 1.1 - ic.Parameter_top=" + ic.Parameter_top + ", acfa.Id_abstract=" + acfa.Id_abstract);
					}
					else
					{
							Trace.WriteLine("fetchReferences - TRACE 1.2 - ic.Parameter_top=" + ic.Parameter_top + ", acfa.Id_abstract=" + acfa.Id_abstract + ", ic.id_inner=" + ic.Id_inner);
					}
                }
                else
                {
                    acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(ic.Id_functor_app);
					Trace.WriteLine("fetchReferences - TRACE 2 - acfa.Id_abstract=" + acfa.Id_abstract);
                }

                collectParameters(pars, acfa, out parsSlice);

				Trace.WriteLine("RETRIEVE BY MATCHING: " + acfa.Id_abstract + "," +  ic.Id_abstract_inner + "," + s.Id_interface_slice + "," + s.Slice_replica);
                Interface i = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveByMatching(acfa.Id_abstract, ic.Id_abstract_inner, s.Id_interface_slice, s.Slice_replica);
                if (i == null) {
                   Trace.WriteLine("i is null : " + acfa.Id_abstract + "," + ic.Id_abstract_inner + "," + s.Id_interface_slice);
                }
                AbstractComponentFunctor acfSlice = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(acfa.Id_abstract);

                // ---------------------------------------------------------------------------------------

                IList<string> refsSlice = i.fetchReferences(parsSlice);

                foreach (string r in refsSlice)
                    if (!refs.Contains(r))
                        refs.Add(r);

                string refname = LoaderApp.buildDllName(acfSlice.Library_path, i.Assembly_string);
                if (!refs.Contains(refname))
                    refs.Add(refname);
                //string refnamebase = LoaderApp.buildDllNameBase(acfSlice.Library_path, i.Assembly_string);
                //if (!refs.Contains(refnamebase))
                //    refs.Add(refnamebase);
            }
        }

			Trace.WriteLine("EXIT fetchReferences - id_abstract=" + this.Id_abstract + ", id_interface="+ this.Id_interface);
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
				Trace.WriteLine("collectParameter -TRACE 1 " + sp_.Id_parameter + ":" + acfaPar.Id_abstract);
            }
            else if (sp is SupplyParameterParameter)
            {
                SupplyParameterParameter sp_ = (SupplyParameterParameter) sp;
                acfaPar = null;
				Trace.WriteLine("collectParameter -TRACE 2 " + "#" + sp_.Id_functor_app + sp_.Id_parameter);
                
				pars.TryGetValue("#" + sp_.Id_functor_app + sp_.Id_parameter, out acfaPar);
                if (acfaPar == null)
                {
					Trace.WriteLine("collectParameter -TRACE 3 " + sp_.Id_argument);
                    
                    if (pars.TryGetValue(sp_.Id_argument, out acfaPar))
                    {
                        parsSlice.Add(sp_.Id_parameter, acfaPar);
						Trace.WriteLine("collectParameter -TRACE 4 " + sp_.Id_parameter + " : " + acfaPar.Id_abstract);
                    }
                    else 
                    {
                        AbstractComponentFunctorParameter acfp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(Id_abstract, sp_.Id_argument);
                        if (acfp == null)
								acfp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(sp_.Id_abstract,sp_.Id_parameter);
						acfaPar = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acfp.Bounds_of);
                        parsSlice.Add(sp_.Id_parameter, acfaPar);
						Trace.WriteLine("collectParameter -TRACE 5 " + sp_.Id_parameter + " : " + acfaPar.Id_abstract);
                    }
                }
                else
                {
					Trace.WriteLine("collectParameter -TRACE 6 " + "#" + sp_.Id_functor_app + sp_.Id_parameter + " : " + acfaPar.Id_abstract);
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
					Trace.WriteLine("collectFV : id_functor_app=" + acfa.Id_functor_app + ", id_abstract=" + acfa.Id_abstract + ", " + "#" + sp_.Id_functor_app + sp_.Id_parameter + ", " + ", " + sp_.Id_argument + (acfaPar==null));
                apars.Add("#" + sp_.Id_functor_app + sp_.Id_parameter, acfaPar);
            }

        }

       
    }

     
	
}//class

}//namespace
