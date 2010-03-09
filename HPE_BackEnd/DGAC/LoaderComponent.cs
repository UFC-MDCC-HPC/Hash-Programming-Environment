using System;
using System.Collections.Generic;
using System.Text;
using DGAC.database;

namespace HPE_DGAC_LoadDB
{
    abstract class LoaderComponent
    {

        protected IList<InnerComponentType> inner = null;
        protected IList<InnerComponentType> innerAll = null;

        protected IList<ParameterType> parameter = null;
        protected IList<ParameterSupplyType> parameterSupply = null;
        protected IList<InnerRenamingType> innerRenaming = null;
        protected IList<FusionType> fusion = null;
        protected IList<SplitType> split = null;
        protected IList<RecursiveEntryType> recursiveEntry = null;
        protected IList<InterfaceType> anInterface = null;
        protected IList<UnitType> unit = null;
        protected IList<EnumeratorType> enumerator = null;
        protected IList<FusionsOfReplicatorsType> fusionOfReplicators = null;



        public HashComponent loadComponent(ComponentType c)
        {
            //ComponentHeaderType ch = c.header;
            LoadBodyItems(c.componentInfo);

            HashComponent cc = loadComponent_(c);
            return cc;
        }

        protected abstract HashComponent loadComponent_(ComponentType c);

        public abstract bool componentExists(string hash_component_uid, out HashComponent cRef);

        protected void LoadBodyItems(Object[] cb)
        {
            foreach (Object o in cb)
            {
                if (o is InnerComponentType)
                {
                    if (inner == null) {
                     inner = new List<InnerComponentType>();
                     innerAll = new List<InnerComponentType>();
                    }

                    inner.Add((InnerComponentType)o);
                    innerAll.Add((InnerComponentType)o);
                }
                else if (o is ParameterType)
                {
                    if (parameter == null) parameter = new List<ParameterType>();
                    parameter.Add((ParameterType)o);
                }
                else if (o is ParameterSupplyType)
                {
                    if (parameterSupply == null) parameterSupply = new List<ParameterSupplyType>();
                    parameterSupply.Add((ParameterSupplyType)o);
                }
                else if (o is InnerRenamingType)
                {
                    if (innerRenaming == null) innerRenaming = new List<InnerRenamingType>();
                    innerRenaming.Add((InnerRenamingType)o);
                }
                else if (o is FusionType)
                {
                    if (fusion == null) fusion = new List<FusionType>();
                    fusion.Add((FusionType)o);
                }
                else if (o is SplitType)
                {
                    if (split == null) split = new List<SplitType>();
                    split.Add((SplitType)o);
                }
                else if (o is RecursiveEntryType)
                {
                    if (recursiveEntry == null) recursiveEntry = new List<RecursiveEntryType>();
                    recursiveEntry.Add((RecursiveEntryType)o);
                }
                else if (o is InterfaceType)
                {
                    if (anInterface == null) anInterface = new List<InterfaceType>();
                    anInterface.Add((InterfaceType)o);
                }
                else if (o is UnitType)
                {
                    if (unit == null) unit = new List<UnitType>();
                    unit.Add((UnitType)o);
                }
                else if (o is EnumeratorType)
                {
                    if (enumerator == null) enumerator = new List<EnumeratorType>();
                    enumerator.Add((EnumeratorType)o);
                }
                else if (o is FusionsOfReplicatorsType)
                {
                    if (fusionOfReplicators == null) fusionOfReplicators = new List<FusionsOfReplicatorsType>();
                    fusionOfReplicators.Add((FusionsOfReplicatorsType)o);
                }
                else
                {
                    // Tipos inesperado ....
                }
            }
        }

        protected AbstractComponentFunctorApplication newAbstractComponentFunctorApplication(ComponentInUseType c)
        {
   //         AbstractComponentFunctorApplication aExisting = lookForAbstractComponentFunctorApplication(c);
     //       if (aExisting != null)
     //       {
     //           return aExisting;
     //       }
     //       else
     //       {   // FIND functor-app-of image 
                AbstractComponentFunctor a = lookForAbstractComponentFunctor(c.hash_component_UID);
                if (a == null)
                {
                    return null;
                }

                // CREATE AbstractComponentFunctorApplication

                AbstractComponentFunctorApplication aAppNew = new AbstractComponentFunctorApplication();
                aAppNew.Id_functor_app = Connector.nextKey("id_functor_app", "hashmodel.abstractcomponentfunctorapplication");
                aAppNew.Id_abstract = a.Id_abstract;

            //    AbstractComponentFunctorApplicationDAO aAppNewDAO = new AbstractComponentFunctorApplicationDAO();
                DGAC.BackEnd.acfadao.insert(aAppNew);

                // REGISTER parameters (follow supply-of, configure formal-parameter)
                loadAbstractComponentFunctorApplicationParameters(c, aAppNew);

                return aAppNew;
       //     }
        }

        
        protected IList<SupplyParameter> loadAbstractComponentFunctorApplicationParameters(ComponentInUseType c, AbstractComponentFunctorApplication aNew)
        {
            IList<SupplyParameter> pars = new List<SupplyParameter>();

            if (c.parameter != null)
            {
                foreach (ParameterRenaming p in c.parameter)
                {
                    String formFieldId = p.formFieldId;
                    String varName = p.varName;

                    SupplyParameter p_ = null;

                    ParameterSupplyType s = lookForSupplyForVarName(varName);
                    if (s != null)
                    {
                        String cRef = s.cRef;

                        // check whether "inner" is a parameter of the enclosing component ...
                        ParameterType parEnc = lookForParameterByCRef(cRef);
                        
                        if (parEnc == null)
                        {
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
                            p_ = new SupplyParameterParameter();
                            ((SupplyParameterParameter)p_).Id_parameter_actual = parEnc.formFieldId;
                            ((SupplyParameterParameter)p_).FreeVariable = false;
                        }

                    }
                    else
                    {
                        
                       p_ = new SupplyParameterParameter();
                       ((SupplyParameterParameter)p_).Id_parameter_actual = null;
                       ((SupplyParameterParameter)p_).FreeVariable = true;

                        // Não há free variable ...


                    }


                    p_.Id_functor_app = aNew.Id_functor_app;
                    p_.Id_abstract = aNew.Id_abstract;
                    p_.Id_parameter = formFieldId;

                 //   SupplyParameterDAO p_DAO = new SupplyParameterDAO();
                    DGAC.BackEnd.spdao.insert(p_);

                    pars.Add(p_);
                }
            }

            return pars;
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

        protected AbstractComponentFunctor lookForAbstractComponentFunctor(string component_UID)
        {
        	//Console.WriteLine("1");
            AbstractComponentFunctorDAO acf = new AbstractComponentFunctorDAO();
            AbstractComponentFunctor acfa = acf.retrieveByUID(component_UID);
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
