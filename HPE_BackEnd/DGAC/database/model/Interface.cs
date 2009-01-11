using System;
using System.IO;
using System.Runtime.Serialization;
using System.Collections.Generic;


namespace DGAC.database{

[Serializable()]
public class Interface {
 
	private string id_interface;
    private string id_interface_super;
    private string id_interface_super_top;

    private int order;

    public int Order
    {
        get { return order; }
        set { order = value; }
    }

    public string Id_interface_super_top
    {
        get {
            if (id_interface_super_top == null) {
                InterfaceDAO idao = new InterfaceDAO();
                AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
                AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();

                if (id_interface_super.Equals("")) {
                    id_interface_super_top = id_interface;
                } else {
                    string id_interface_super_ = Id_interface_super;
                    AbstractComponentFunctor acf = acfdao.retrieve(id_abstract);
                    if (acf.Id_functor_app_supertype != 0)
                    {
                        AbstractComponentFunctorApplication acfaSuper = acfadao.retrieve(acf.Id_functor_app_supertype);
                        Interface iSuper = idao.retrieve(acfaSuper.Id_abstract, id_interface_super_);
                        id_interface_super_top = iSuper.Id_interface_super_top;
                    }
                    else
                    {
                        id_interface_super_top = id_interface;
                    }
                }
                idao.setInterfaceSuperTop(id_abstract, id_interface,id_interface_super_top);
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
	private string assembly_string;
    private string source_code = null;

    public string Source_code
    {
        get { return source_code; }
        set { source_code = value; }
    }

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
    
    public string Assembly_string{
        get {return assembly_string;}
        set {assembly_string = value;}
    }

    public IList<string> References
    {
        get {
            return fetchReferences(new Dictionary<string,AbstractComponentFunctorApplication>());
        }
    }

    public IList<string> fetchReferences(IDictionary <string, AbstractComponentFunctorApplication> pars) {

        IList<string> refs = new List<string>();

        InterfaceDAO idao = new InterfaceDAO();
        InnerComponentDAO icdao = new InnerComponentDAO();
        SliceDAO sdao = new SliceDAO();
        AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
        AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();

        // Look at super type.

        AbstractComponentFunctor cThis = acfdao.retrieve(this.Id_abstract);
        AbstractComponentFunctorApplication cSuperApp = acfadao.retrieve(cThis.Id_functor_app_supertype);
        if (cSuperApp != null)
        {
            AbstractComponentFunctor acfsuper = acfdao.retrieve(cSuperApp.Id_abstract);
            IDictionary<string, AbstractComponentFunctorApplication> parsSuper = null;
            collectParameters(pars, cSuperApp, out parsSuper);
            Interface iSuper = idao.retrieve(cSuperApp.Id_abstract, this.Id_interface_super);
            refs = iSuper.fetchReferences(parsSuper);
            string refname = LoaderApp.buildDllName(acfsuper.Hash_component_UID, iSuper.Assembly_string);
            if (!refs.Contains(refname))
                refs.Add(refname);
        }

        // Traverse slices.
        IList<Slice> slices = sdao.list(Id_abstract, Id_interface);

        foreach (Slice s in slices)
        {
            InnerComponent ic = icdao.retrieve(Id_abstract, s.Id_inner); // findInnerComponentOwnerOfSlice(Id_abstract, s.Id_inner); 
            if (ic != null)
            {
                AbstractComponentFunctorApplication acfa = null;
                IDictionary<string, AbstractComponentFunctorApplication> parsSlice = null;

                // ---------------------------------------------------------------------------------------
                if (!ic.Parameter_top.Equals(""))
                {
                    pars.TryGetValue(ic.Parameter_top, out acfa);
                    acfa = acfa == null ? acfadao.retrieve(ic.Id_functor_app) : acfa;                    
                }
                else
                {
                    acfa = acfadao.retrieve(ic.Id_functor_app);
                }

                collectParameters(pars, acfa, out parsSlice);

                Interface i = idao.retrieveByMatching(acfa.Id_abstract, ic.Id_abstract_inner, s.Id_interface_slice);
                AbstractComponentFunctor acfSlice = acfdao.retrieve(acfa.Id_abstract);

                // ---------------------------------------------------------------------------------------

                IList<string> refsSlice = i.fetchReferences(parsSlice);

                foreach (string r in refsSlice)
                    if (!refs.Contains(r))
                        refs.Add(r);

                string refname = LoaderApp.buildDllName(acfSlice.Hash_component_UID, i.Assembly_string);
                if (!refs.Contains(refname))
                    refs.Add(refname);
            }
        }

        return refs; 
    }

    private InnerComponent findInnerComponentOwnerOfSlice(int Id_abstract, string id_inner)
    {
        InnerComponentDAO icdao = new InnerComponentDAO();
        AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
        AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
        int Id_abstract_traverse = Id_abstract;
        InnerComponent ic = null;
        while (ic == null && Id_abstract_traverse != 0)
        {
            ic = icdao.retrieve(Id_abstract_traverse, id_inner);
            if (ic == null)
            {
                AbstractComponentFunctor cTraverse = acfdao.retrieve(Id_abstract_traverse);
                AbstractComponentFunctorApplication cSuperApp = acfadao.retrieve(cTraverse.Id_functor_app_supertype);
                Id_abstract_traverse = cSuperApp.Id_abstract;
            }
        }
        return ic;
    }

    private void collectParameters(IDictionary<string, AbstractComponentFunctorApplication> pars, 
                                   AbstractComponentFunctorApplication acfa, 
                                   out IDictionary<string, AbstractComponentFunctorApplication> parsSlice)
    {
        SupplyParameterDAO spdao = new SupplyParameterDAO();
        AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
        IList<SupplyParameter> spList = spdao.list(acfa.Id_functor_app);

        parsSlice = new Dictionary<string, AbstractComponentFunctorApplication>();

        foreach (SupplyParameter sp in spList)
        {
            AbstractComponentFunctorApplication acfaPar=null;
            if (sp is SupplyParameterComponent)
            {
                SupplyParameterComponent sp_ = (SupplyParameterComponent) sp;
                acfaPar = acfadao.retrieve(sp_.Id_functor_app_actual);
                parsSlice.Add(sp_.Id_parameter, acfaPar);
            }
            else if (sp is SupplyParameterParameter)
            {
                SupplyParameterParameter sp_ = (SupplyParameterParameter) sp;
                acfaPar = null;
                pars.TryGetValue("#" + sp_.Id_functor_app + sp_.Id_parameter, out acfaPar);
                if (acfaPar == null)
                {
                    pars.TryGetValue(sp_.Id_parameter_actual, out acfaPar);
                    if (acfaPar != null)
                    {
                        parsSlice.Add(sp_.Id_parameter, acfaPar);
                    }
                    else // if (sp_.FreeVariable)
                    {
                        // find bound ...
                        AbstractComponentFunctorParameterDAO acfpdao = new AbstractComponentFunctorParameterDAO();
                        AbstractComponentFunctorParameter acfp = acfpdao.retrieve(sp_.Id_abstract, sp_.Id_parameter);
                        acfaPar = acfadao.retrieve(acfp.Bounds_of);
                        parsSlice.Add(sp_.Id_parameter, acfaPar);
                    }
                }
                else
                {
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
        
        SupplyParameterDAO spdao = new SupplyParameterDAO();
        IList<SupplyParameter> sps = spdao.list(acfa.Id_functor_app);
        foreach (SupplyParameter sp in sps)
        {
            if (sp is SupplyParameterComponent)
            {
                SupplyParameterComponent sp_ = (SupplyParameterComponent)sp;
                AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
                AbstractComponentFunctorApplication acfaPar = acfadao.retrieve(sp_.Id_functor_app_actual);
                collectFV(acfaPar, pars, apars);
            }
            else if (sp is SupplyParameterParameter)
            {
                SupplyParameterParameter sp_ = (SupplyParameterParameter)sp;
                AbstractComponentFunctorApplication acfaPar = null;
                pars.TryGetValue("#" + sp_.Id_functor_app + sp_.Id_parameter, out acfaPar);
                if (acfaPar == null)
                {
                    pars.TryGetValue(sp_.Id_parameter_actual, out acfaPar);
                }
                apars.Add("#" + sp_.Id_functor_app + sp_.Id_parameter, acfaPar);
            }

        }

       
    }

     
	
}//class

}//namespace