using System;
using System.Collections.Generic;
using System.Text;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.Diagnostics;

namespace HPE_DGAC_LoadDB
{
    abstract class LoaderComponent
    {

        protected IList<InnerComponentType> inner = null;
        protected IList<InnerComponentType> innerAll = null;

        protected IList<ParameterType> parameter = null;
        protected IList<ParameterSupplyType> parameterSupply = null;
        protected IList<InnerRenamingType> innerRenaming = null;
        protected IDictionary<string,string> fusion = null;
        protected IList<SplitType> split = null;
        protected IList<RecursiveEntryType> recursiveEntry = null;
        protected IList<InterfaceType> anInterface = null;
        protected IList<UnitType> unit = null;
        protected IList<EnumeratorType> enumerator = null;
		protected IList<ExternalLibraryType> externalLibrary = null;
		//protected IList<FusionsOfReplicatorsType> fusionOfReplicators = null;

		public HashComponent loadComponent(ComponentType c, ref IList<ExternalLibraryType>  externalLibrary)
        {
            //ComponentHeaderType ch = c.header;
            LoadBodyItems(c.componentInfo);

            HashComponent cc = loadComponent_(c);

			externalLibrary = this.externalLibrary;

            return cc;
        }

        protected abstract HashComponent loadComponent_(ComponentType c);

        public abstract bool componentExists(string hash_component_uid, out HashComponent cRef);

        protected void LoadBodyItems(Object[] cb)
        {
			Console.Write ("LoadBodyItems:" + cb==null);
			foreach (Object o in cb)
            {
				Console.Write ("Object:");
                if (o is InnerComponentType)
                {
					Console.WriteLine("Object:InnerComponentType " + ((InnerComponentType)o).localRef);
					if (inner == null) {
                     inner = new List<InnerComponentType>();
                     innerAll = new List<InnerComponentType>();
                    }

                    inner.Add((InnerComponentType)o);
                    innerAll.Add((InnerComponentType)o);
                }
                else if (o is ParameterType)
                {
					Console.WriteLine ("Object:ParameterType");
					if (parameter == null) parameter = new List<ParameterType>();
                    parameter.Add((ParameterType)o);
                }
                else if (o is ParameterSupplyType)
                {
					Console.WriteLine ("Object:ParameterSupplyType");
                    if (parameterSupply == null) parameterSupply = new List<ParameterSupplyType>();
					//ParameterSupplyType o_ = (ParameterSupplyType)o;
					//if (o_.direct)
                    	parameterSupply.Add((ParameterSupplyType)o);
                }
                else if (o is InnerRenamingType)
                {
					Console.WriteLine ("Object:InnerRenamingType");
                    if (innerRenaming == null) innerRenaming = new List<InnerRenamingType>();
                    innerRenaming.Add((InnerRenamingType)o);
                }
                else if (o is FusionType)
                {
					Console.WriteLine ("Object:FusionType");
					if (fusion == null) fusion = new Dictionary<string, string>();
					FusionType fo = (FusionType)o;
					fusion.Add(fo.pRef,fo.cRefs[0]);
                }
                else if (o is SplitType)
                {
					Console.WriteLine ("Object:SplitType");
                    if (split == null) split = new List<SplitType>();
                    split.Add((SplitType)o);
                }
                else if (o is RecursiveEntryType)
                {
					Console.WriteLine ("Object:RecursiveEntryType");
                    if (recursiveEntry == null) recursiveEntry = new List<RecursiveEntryType>();
                    recursiveEntry.Add((RecursiveEntryType)o);
                }
                else if (o is InterfaceType)
                {
					Console.WriteLine ("Object:InterfaceType");
                    if (anInterface == null) anInterface = new List<InterfaceType>();
                    anInterface.Add((InterfaceType)o);
                }
                else if (o is UnitType)
                {
					Console.WriteLine ("Object:UnitType");
                    if (unit == null) unit = new List<UnitType>();
                    unit.Add((UnitType)o);
                }
                else if (o is EnumeratorType)
                {
					Console.WriteLine ("Object:EnumeratorType");
                    if (enumerator == null) enumerator = new List<EnumeratorType>();
                    enumerator.Add((EnumeratorType)o);
                } 
				else if (o is ExternalLibraryType)
				{
					Console.WriteLine ("Object:ExternalLibraryType");
					if (externalLibrary == null) externalLibrary = new List<ExternalLibraryType>();
					externalLibrary.Add((ExternalLibraryType)o);
				}
                else
                {
                    // Tipos inesperado ....
                }
            }
        }

        protected AbstractComponentFunctorApplication newAbstractComponentFunctorApplication(ComponentInUseType c)
        {
                AbstractComponentFunctor a = lookForAbstractComponentFunctor(c.package, c.name);
                if (a == null)
                {
                    return null;
                }

                // CREATE AbstractComponentFunctorApplication

                AbstractComponentFunctorApplication aAppNew = new AbstractComponentFunctorApplication();
                aAppNew.Id_functor_app = Connector.nextKey("id_functor_app", "abstractcomponentfunctorapplication");
			  //  Console.WriteLine("+++++++++++++++ " +  aAppNew.Id_functor_app);
                aAppNew.Id_abstract = a.Id_abstract;

                br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.insert(aAppNew);

                // REGISTER parameters (follow supply-of, configure formal-parameter)
                loadAbstractComponentFunctorApplicationParameters(c, aAppNew, aAppNew);

                return aAppNew;
       //     }
        }

        protected IList<AbstractComponentFunctorApplication> newAbstractComponentFunctorApplicationForImplements(ComponentInUseType c)
        {

		    IList<AbstractComponentFunctor> ancestrals = new List<AbstractComponentFunctor>();	

			AbstractComponentFunctor a_current = lookForAbstractComponentFunctor(c.package, c.name);
			if (a_current == null)
                return null;

			{
				AbstractComponentFunctor a = a_current;
				ancestrals.Add (a);				
				while (a.Id_functor_app_supertype > 0) {
					AbstractComponentFunctorApplication acfa_ancestral = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve (a.Id_functor_app_supertype);
					a = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve (acfa_ancestral.Id_abstract);
					ancestrals.Add (a);
				}
			}
			
			IList<AbstractComponentFunctorApplication> aAppNewList = new List<AbstractComponentFunctorApplication>();
			
			AbstractComponentFunctorApplication aAppNewOld = null;
			AbstractComponentFunctorApplication aAppNew = null;
			foreach (AbstractComponentFunctor a in ancestrals) 
			{
                // CREATE AbstractComponentFunctorApplication
				
                aAppNew = new AbstractComponentFunctorApplication();
                aAppNew.Id_abstract = a.Id_abstract;
				aAppNew.Id_functor_app = Connector.nextKey("id_functor_app", "abstractcomponentfunctorapplication");
			    br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.insert(aAppNew);
                loadAbstractComponentFunctorApplicationParameters(c, aAppNew, aAppNewOld == null ? aAppNew : aAppNewOld);
				aAppNewList.Add(aAppNew);
				if (aAppNewOld != null)
				   br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.updateIdFunctorAppNext(aAppNewOld, aAppNew.Id_functor_app);
				aAppNewOld = aAppNew;				
			}

            return aAppNewList;
       //     }
        }
        
		protected IList<SupplyParameter> loadAbstractComponentFunctorApplicationParameters(ComponentInUseType c, 
		                                                                                   AbstractComponentFunctorApplication aNew, 
		                                                                                   AbstractComponentFunctorApplication aNew_context)
        {
            IList<SupplyParameter> pars = new List<SupplyParameter>();

            if (c.parameter != null)
            {
                foreach (ParameterRenaming p in c.parameter)
                {
                    String formFieldId = p.formFieldId;
                    String varName = p.varName;
					Console.WriteLine("loadAbstractcomponentFunctorApplicationParameters -1 " + varName + "," + formFieldId);

                    SupplyParameter p_ = null;

                    ParameterType topParameter = lookForParameterByVarName(varName);
                    ParameterSupplyType s = lookForSupplyForVarName(varName);
                    
                    if (topParameter != null)
                    {
						Console.WriteLine("loadAbstractcomponentFunctorApplicationParameters 0 " + topParameter.formFieldId + ", " + varName);
                        p_ = new SupplyParameterParameter();
                        ((SupplyParameterParameter)p_).Id_argument = topParameter.formFieldId;
                        ((SupplyParameterParameter)p_).FreeVariable = false;

                    }
                    else if (s != null)
                    {
						Console.WriteLine("loadAbstractcomponentFunctorApplicationParameters 1 " + s.cRef + ", " + varName);
                        String cRef = s.cRef;

                        p_ = new SupplyParameterComponent();
                        // Look for the inner component that supplies that parameter.
                        InnerComponentType inner = lookForInnerComponent(cRef);
                        AbstractComponentFunctorApplication cPar = newAbstractComponentFunctorApplication(inner);
                        if (cPar == null)
                        {
                            throw new Exception("DEPLOY ERROR: Unresolved Dependency for base component (context actual parameter) : " + inner.name);
                        }
                        ((SupplyParameterComponent)p_).Id_functor_app_actual = cPar.Id_functor_app;

                    }
                    else
                    {
						Console.WriteLine("loadAbstractcomponentFunctorApplicationParameters 2 " + varName);
                        p_ = new SupplyParameterParameter();
                        ((SupplyParameterParameter)p_).Id_argument = null;
                        ((SupplyParameterParameter)p_).FreeVariable = true;
                    }


                    p_.Id_functor_app = aNew.Id_functor_app;
                    p_.Id_abstract = aNew.Id_abstract;
                    p_.Id_parameter = formFieldId;

                 //   SupplyParameterDAO p_DAO = new SupplyParameterDAO();
                    br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.insert(p_);

                    pars.Add(p_);
                }
            }

			loadSuppliedParametersOfSupertype (c, aNew, aNew_context);

            return pars;
        }

		void loadSuppliedParametersOfSupertype (ComponentInUseType c, AbstractComponentFunctorApplication aNew, AbstractComponentFunctorApplication aNew_context)
		{

			int id_functor_app_supertype;
			if (aNew_context.Id_abstract != aNew.Id_abstract)				 
			{
				Console.WriteLine ("id_abstract_context != aNew.Id_abstract : " + aNew_context.Id_abstract  + " " + aNew.Id_abstract);
				AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve (aNew_context.Id_abstract);
				id_functor_app_supertype = acf.Id_functor_app_supertype;
			} 
			else 
			{
				Console.WriteLine ("id_abstract_context == aNew.Id_abstract : " + aNew_context.Id_abstract  + " " + aNew.Id_abstract);
				AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve (aNew.Id_abstract);
				id_functor_app_supertype = acf.Id_functor_app_supertype;
			}

			while (id_functor_app_supertype > 0) 
			{
				AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve (id_functor_app_supertype);

				IList<SupplyParameter> sp_list = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list (id_functor_app_supertype);
				foreach (SupplyParameter sp in sp_list)
				{
					if (sp is SupplyParameterComponent) 
					{
						SupplyParameterComponent spc = (SupplyParameterComponent)sp;
						SupplyParameterComponent spc_new = new SupplyParameterComponent ();

						spc_new.Id_functor_app = aNew.Id_functor_app;
						spc_new.Id_abstract = aNew.Id_abstract;
						spc_new.Id_functor_app_actual = spc.Id_functor_app_actual;
						spc_new.Id_parameter = spc.Id_parameter;					
						br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.insert(spc_new);
					} 
					else if (sp is SupplyParameterParameter) 
					{

					}

				}

				AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve (acfa.Id_abstract);
				id_functor_app_supertype = acf.Id_functor_app_supertype;

				Trace.WriteLineIf (id_functor_app_supertype > 0, "LOOPING TO SUPERTYPE !!!");
			}

		}

        public ParameterType lookForParameterByCRef(string cRef)
        {
            if (parameter != null)
            {
                foreach (ParameterType p in parameter)
                {
                    if (p.componentRef.Equals(cRef))
                    {
                        return p;
                    }
                }
            }
            return null;
        }

        public ParameterType lookForParameterByVarName(string varName)
        {
            if (parameter != null)
            {
                foreach (ParameterType p in parameter)
                {
                    if (p.varName.Equals(varName))
                    {
                        return p;
                    }
                }
            }
            return null;
        }


        protected AbstractComponentFunctor lookForAbstractComponentFunctor(string package, string name)
        {
			string library_path = package + "." + name;
        	//Console.WriteLine("1");
            AbstractComponentFunctorDAO acf = new AbstractComponentFunctorDAO();
			AbstractComponentFunctor acfa = acf.retrieve_libraryPath (library_path);   // .retrieveByUID(component_UID);
            return acfa;
        }
        
        protected ParameterSupplyType lookForSupplyForVarName(string varName)
        {
            if (parameterSupply != null)
            {
                foreach (ParameterSupplyType s in parameterSupply)
                {
                    if (s.varName.Equals(varName))
                    {
                        return s;
                    }
                }
            }
            return null;
        }

        protected InnerComponentType lookForInnerComponent(string cRef)
        {
             foreach (InnerComponentType ic in innerAll) 
            {
				if (ic.localRef.Equals(cRef))
                {
                    return ic;
                }
            }
            return null;
        }

        protected bool isNotInSupply(InnerComponentType c)
        {
            if (parameterSupply != null)
            {
                foreach (ParameterSupplyType s in parameterSupply)
                {
                    if (s.cRef.Equals(c.localRef))
                    {
                        return false;
                    }
                }
            }
            return true;

        }


        protected string buildEnumeratorId(string[] originRef, string eRef)
        {
            string eId = "";
            if (originRef != null)
            {
                foreach (string cRef in originRef)
                {
                    eId += cRef + ".";
                }
            }
            eId += eRef;
            return eId;
        }

        protected InterfaceType lookForInterface(string iRef)
        {
            foreach (InterfaceType i in this.anInterface)
            {
                if (i.iRef.Equals(iRef))
                {
                    return i;
                }
            }
            return null;
        }


    }


}
