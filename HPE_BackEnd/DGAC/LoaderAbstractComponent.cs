using System;
using System.Collections.Generic;

using System.Text;
using DGAC.database;

namespace HPE_DGAC_LoadDB
{
    class LoaderAbstractComponent : LoaderComponent
    {
        /* The parameter fileName points to the location of a concrete component.
         */

        private ComponentType xc;

        public override bool componentExists(string hash_component_uid, out HashComponent cRef)
        {
          //  AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
            AbstractComponentFunctor absC = DGAC.BackEnd.acfdao.retrieveByUID(hash_component_uid);
            if (absC == null)
            {
                cRef = null;
                return false;
            }
            else
            {
                cRef = absC;
                return true;
            }

        }

        public new HashComponent loadComponent(ComponentType c)
        {
            this.xc = c;
            AbstractComponentFunctor absC = (AbstractComponentFunctor)base.loadComponent(c);
            loadInnerComponents(absC);
            loadInterfaces(absC);
            loadEnumerators(absC);
            return absC;
        }

        private void loadEnumerators(AbstractComponentFunctor absC)
        {
            int id_abstract = absC.Id_abstract;

          //  EnumerationSliceDAO sdao = new EnumerationSliceDAO();
         //   SliceExposedDAO esdao = new SliceExposedDAO();
         //   SliceDAO sliceDAO = new SliceDAO();

            // COLLECT ENUMERATORS ...

            IDictionary<string, Enumerator> eList = new Dictionary<string, Enumerator>();
            IDictionary<string, EnumerableType[]> rXs = new Dictionary<string,EnumerableType[]>();
            if (enumerator != null)
            {
                foreach (EnumeratorType eX in enumerator)
                {
                    Enumerator e = new Enumerator();
                    e.Valuation = eX.cardinality == 1 ? 1 : -1;
                    if (eX.cardinality != 1) // Ignoring unitary enumerators ... 05/MAR/2010
                    {
                        e.Id_abstract = id_abstract;
                        e.Id_enumerator = buildEnumeratorId(eX.originRef, eX.@ref);
                        e.From_split = eX.fromSplit;
                        e.Variable = eX.varId;
                        rXs.Add(e.Id_enumerator, eX.links);
                        eList.Add(e.Id_enumerator, e);
                    }
                }
            }

          //  EnumeratorMappingDAO emdao = new EnumeratorMappingDAO();

            Dictionary<string, string> es = new Dictionary<string, string>();

            // APPLY FUSION OF REPLICATORS
            
            if (fusionOfReplicators != null)
            {
                foreach (FusionsOfReplicatorsType f in fusionOfReplicators)
                {
                    string id_enumerator_fst = null;
                    foreach (FusionOfReplicatorsType ff in f.fusionOfReplicators)
                    {
                        string id_enumerator = buildEnumeratorId(ff.originRef, ff.eRef).Trim();
                        id_enumerator_fst = id_enumerator_fst == null ? id_enumerator : id_enumerator_fst;
                        // es.Add(id_enumerator, id_enumerator_fst);
                        EnumeratorMapping em = new EnumeratorMapping(); 
                        if (ff.originRef != null && ff.originRef.Length > 0)
                        {
                            em.Id_abstract = id_abstract;
                            em.Id_inner = ff.originRef[0];
                            em.Id_enumerator_inner = id_enumerator;
                            em.Id_enumerator_container = id_enumerator_fst;
                        }
                        else
                        {
                            em.Id_abstract = id_abstract;
                            em.Id_inner = "";
                            em.Id_enumerator_inner = id_enumerator;
                            em.Id_enumerator_container = id_enumerator_fst;
                        }
                        DGAC.BackEnd.exmdao.insert(em);
                        //if (!id_enumerator.Equals(id_enumerator_fst)) 
                        //    eList.Remove(id_enumerator);
                    }
                }
            }
            
         //   EnumeratorDAO edao = new EnumeratorDAO();
            foreach (Enumerator e in eList.Values)
            {
                DGAC.BackEnd.edao.insert(e);
            }

            IDictionary<string, IList<SliceExposed>> lateExposedSlices = new Dictionary<string, IList<SliceExposed>>();

            // ENUMERATE ITEMS !!!
            foreach (KeyValuePair<string, EnumerableType[]> rXp in rXs)
            {
                string Id_enumerator = null;
                es.TryGetValue(rXp.Key, out Id_enumerator); // take the enumerator id of the fusion group representant ...
                Id_enumerator = Id_enumerator == null ? rXp.Key : Id_enumerator;
                EnumerableType[] links = rXp.Value;
                if (links != null)
                {
                    foreach (EnumerableType rX in links)
                    {
                        if (rX is EnumerableComponentType)
                        {
                            EnumerableComponentType rX_c = (EnumerableComponentType)rX;
                            string cRef = rX_c.@ref;

                            EnumerationInner i = new EnumerationInner();
                            i.Id_abstract = absC.Id_abstract;
                            i.Id_enumerator = Id_enumerator;
                            i.Id_inner = cRef;

                           // EnumerationInnerDAO idao = new EnumerationInnerDAO();

                          //  InnerComponentExposedDAO icedao = new InnerComponentExposedDAO();

                            // ALL EXPOSED INNER COMPONENTS ARE ENUMERATED BY THE ENUMERATION OF THE OWNER INNER COMPONENT !
                            IList<InnerComponentExposed> ports = DGAC.BackEnd.icedao.listExposedInnerOfOwner(absC.Id_abstract, cRef);
                            foreach (InnerComponentExposed port in ports)
                            {
                                EnumerationInner ip = new EnumerationInner();
                                ip.Id_abstract = absC.Id_abstract;
                                ip.Id_enumerator = Id_enumerator;
                                ip.Id_inner = port.Id_inner_rename;

                                EnumerationInner iQp = DGAC.BackEnd.exindao.retrieve(ip.Id_abstract, ip.Id_inner, ip.Id_enumerator);
                                if (iQp == null)
                                    DGAC.BackEnd.exindao.insert(ip);
                            }

                            EnumerationInner iQ = DGAC.BackEnd.exindao.retrieve(i.Id_abstract, i.Id_inner, i.Id_enumerator);
                            if (iQ == null)
                                DGAC.BackEnd.exindao.insert(i);
                        }
                        else if (rX is EnumerableUnitType)
                        {
                            EnumerableUnitType rX_u = (EnumerableUnitType)rX;
                            string uRef = rX_u.@ref;

                            EnumerationInterface u = new EnumerationInterface();
                            u.Id_abstract = absC.Id_abstract;
                            u.Id_enumerator = Id_enumerator;
                            u.Id_interface = uRef;

                         //   EnumerationInterfaceDAO udao = new EnumerationInterfaceDAO();

                            EnumerationInterface uQ = DGAC.BackEnd.exitdao.retrieve(u.Id_abstract, u.Id_interface, u.Id_enumerator);
                            if (uQ == null)
                                DGAC.BackEnd.exitdao.insert(u);

                        }
                        else if (rX is EnumerableEntryType)
                        {
                            EnumerableEntryType rX_s = (EnumerableEntryType)rX;
                            string cRef = rX_s.cRef;
                            string uRef = rX_s.uRef;
                            string sRef = uRef;

                            /* }
                            else if (rX is EnumerableUnitSliceType)
                            { 
                                EnumerableUnitSliceType rX_s = (EnumerableUnitSliceType)rX;
                                string cRef = rX_s.cRef;
                                string sRef = rX_s.sRef; */
                            int splitReplica = rX_s.index; //splitReplica;

                            EnumerationSlice s = new EnumerationSlice();
                            s.Id_abstract = absC.Id_abstract;
                            s.Id_inner = cRef;
                            s.Id_interface_slice = sRef;
                            s.Id_split_replica = splitReplica;
                            s.Id_enumerator = Id_enumerator;


                            IList<SliceExposed> ses = DGAC.BackEnd.sedao.listExposedSlicesByContainer(s.Id_abstract,
                                                                                         s.Id_inner,// owner
                                                                                         s.Id_interface_slice, //owner
                                                                                         s.Id_split_replica);

                            lateExposedSlices.Add(Id_enumerator, ses);


                            EnumerationSlice sQ = DGAC.BackEnd.exsdao.retrieve(s.Id_abstract, s.Id_inner, s.Id_interface_slice, s.Id_enumerator);
                            if (sQ == null)
                                DGAC.BackEnd.exsdao.insert(s);
                        }
                    }
                }
            }


            foreach (KeyValuePair<string, IList<SliceExposed>> pair in lateExposedSlices)
            {
                string Id_enumerator = pair.Key;
                IList<SliceExposed> ses = pair.Value;

                foreach (SliceExposed se in ses)
                {
                   // EnumerationInnerDAO eidao = new EnumerationInnerDAO();

                    EnumerationInner ei = DGAC.BackEnd.exindao.retrieve(se.Id_abstract, se.Id_inner, Id_enumerator);
                    if (ei == null)
                    {
                        // take the slice row of the exposed slice
                        EnumerationSlice sexposed = new EnumerationSlice();
                        sexposed.Id_abstract = se.Id_abstract;
                        sexposed.Id_inner = se.Id_inner;
                        sexposed.Id_interface_slice = se.Id_interface_slice;
                        sexposed.Id_split_replica = se.Id_split_replica;
                        sexposed.Id_enumerator = Id_enumerator;

                        EnumerationSlice sQE = DGAC.BackEnd.exsdao.retrieve(sexposed.Id_abstract,
                                                             sexposed.Id_inner,
                                                             sexposed.Id_interface_slice,
                                                             sexposed.Id_enumerator);
                        if (sQE == null)
                            DGAC.BackEnd.exsdao.insert(sexposed);
                    }
                }
            }

            loadSplits(absC.Id_abstract, es);
        }

        private void loadSplits(int id_abstract, Dictionary<string,string> es)
        {
            int splitIx = 0;

            if (split != null)
            {
                foreach (SplitType s in split)
                {
                    string id_enumerator = buildEnumeratorId(s.originRef, s.eRef).Trim();
                    foreach (string id_enumerator_split in s.splitEnumerator) // all these enumerators are enumerators of the top configuration ...
                    {
                        EnumeratorSplit ews = new EnumeratorSplit();

                        string id_enumerator_group = null;
                        es.TryGetValue(id_enumerator, out id_enumerator_group);
                        id_enumerator_group = id_enumerator_group == null ? id_enumerator : id_enumerator_group;

                        string id_enumerator_split_2 = null;
                        es.TryGetValue(id_enumerator_split, out id_enumerator_split_2);
                        id_enumerator_split_2 = id_enumerator_split_2 == null ? id_enumerator_split : id_enumerator_split_2; 

                        ews.Id_abstract = id_abstract;
                        ews.Id_split = ++splitIx;
                        ews.Id_enumerator = id_enumerator_group;
                        ews.Id_enumerator_split = id_enumerator_split_2;
                        ews.Id_total_split = s.n;    // sem essa linha Id_total_split sempre é ZERO. Fiquei na dúvida ...

                      //  EnumeratorSplitDAO splitdao = new EnumeratorSplitDAO();
                        DGAC.BackEnd.exldao.insert(ews);
                    }
                }
            }
        }

        private IList<ParameterRenaming> parameterRenamingSupper = null;

        protected override HashComponent loadComponent_(ComponentType c)
        {
            // CREATE Component
            
          //  InnerComponentExposedDAO iNewExpDAO = new InnerComponentExposedDAO();
         //   InnerComponentDAO iNewDAO = new InnerComponentDAO();

            AbstractComponentFunctor c_ = new AbstractComponentFunctor();
            c_.Id_abstract = Connector.nextKey("id_abstract", "hashmodel.abstractcomponentfunctor");
            c_.Hash_component_UID = c.header.hash_component_UID;
            c_.Library_path = c.header.packagePath + "." + c.header.name;
            c_.Kind = c.header.kind.ToString();
            
           // IList<AbstractComponentFunctorParameter> absParams = loadAbstractComponentFunctorParameters(c_);

            if (c.header.baseType != null)
            {
                ExtensionTypeType extType = c.header.baseType.extensionType;
                ComponentInUseType baseC = null;

                if (extType.ItemElementName == ItemChoiceType.extends && extType.Item)
                {
                    baseC = c.header.baseType.component;

                    parameterRenamingSupper = baseC.parameter;

                    AbstractComponentFunctorApplication baseCapp = newAbstractComponentFunctorApplication(baseC);

                    // FOLLOW arrow subtype
                    if (baseCapp == null)
                    {
                        throw new Exception("DEPLOY ERROR: Unresolved Dependency for base component (extends) : " + baseC.name);
                    }

                    c_.Id_functor_app_supertype = baseCapp.Id_functor_app;
                }

                // LOAD EXPOSED INNER COMPONENTS OF THE BASE
                if (baseC.port != null)
                {
                    foreach (InnerComponentType port in baseC.port)
                    {
                        innerAll.Add(port);

                        InnerComponent iNewPort = new InnerComponent();
                        iNewPort.Id_abstract_owner = c_.Id_abstract;
                        string old_port_localRef = port.localRef;
                        port.localRef = lookForRenaming(baseC.localRef, port.localRef);
                        iNewPort.Id_inner = port.localRef;
                        iNewPort.Parameter_top = port.parameter_id;
                        iNewPort.Transitive = true;

                        AbstractComponentFunctorApplication appPort = newAbstractComponentFunctorApplication(port);
                        if (appPort == null)
                        {
                            throw new Exception("DEPLOY ERROR: Unresolved Dependency for base component (public inner component) : " + port.name);
                        }

                        iNewPort.Id_functor_app = appPort.Id_functor_app;
                        iNewPort.Id_abstract_inner = appPort.Id_abstract;

                        InnerComponentExposed ice = new InnerComponentExposed();
                        ice.Id_abstract = c_.Id_abstract;
                        ice.Id_inner_rename = iNewPort.Id_inner;
                        ice.Id_inner_owner = null;
                        ice.Id_inner = old_port_localRef;

                        DGAC.BackEnd.icedao.insert(ice);

                        if (DGAC.BackEnd.icdao.retrieve(iNewPort.Id_abstract_owner, iNewPort.Id_inner) == null)
                            DGAC.BackEnd.icdao.insert(iNewPort);
                    }
                }

            }

         //   AbstractComponentFunctorDAO absCdao = new AbstractComponentFunctorDAO();
            DGAC.BackEnd.acfdao.insert(c_);

            loadAbstractComponentFunctorParameters(c_);
            
            return c_;
        }


        private void loadInnerComponents(AbstractComponentFunctor absC)
        {
            IList<InnerComponentType> includeAsInner = new List<InnerComponentType>();

          //  InnerComponentDAO iNewDAO = new InnerComponentDAO();

            importInnerComponentsOfSupper(absC, includeAsInner);

          //  InnerComponentExposedDAO iNewExpDAO = new InnerComponentExposedDAO();
            // For each inner component.
            if (inner != null)
            {
                foreach (InnerComponentType c in inner)
                {
                    // innerAll.Add(c);
                    if (isNotInSupply(c) || includeAsInner.Contains(c))
                    {
                        // CREATE INNER COMPONENT
                        InnerComponent iNew = new InnerComponent();
                        iNew.Id_abstract_owner = absC.Id_abstract;
                        iNew.Id_inner = c.localRef;       // localRef is used to uniquely identify the inner component among the inner components....

                        // FOLLOW arrow has-parameters
                        AbstractComponentFunctorApplication app = newAbstractComponentFunctorApplication(c);
                        if (app == null)
                        {
                            throw new Exception("DEPLOY ERROR: Unresolved Dependency for base component (inner component) : " + c.name);
                        }

                        iNew.Id_functor_app = app.Id_functor_app;
                        iNew.Id_abstract_inner = app.Id_abstract;

                        // CHECKS IF IT IS A TOP PARAMETER 
                        ParameterType p = lookForParameterByCRef(c.localRef);
                        iNew.Parameter_top = p != null ? p.formFieldId : null;

                        iNew.Transitive = false;

                        // LOAD EXPOSED INNER COMPONENTS
                        if (c.port != null)
                        {
                            foreach (InnerComponentType port in c.port)
                            {
                                innerAll.Add(port);

                                InnerComponent iNewPort = new InnerComponent();
                                iNewPort.Id_abstract_owner = absC.Id_abstract;
                                string old_port_localRef = port.localRef;
                                port.localRef = lookForRenaming(c.localRef, port.localRef);
                                iNewPort.Id_inner = port.localRef;                               
                                iNewPort.Parameter_top = port.parameter_id;
                                iNewPort.Transitive = true;

                                AbstractComponentFunctorApplication appPort = newAbstractComponentFunctorApplication(port);
                                if (appPort == null)
                                {
                                    throw new Exception("DEPLOY ERROR: Unresolved Dependency for base component (public inner component) : " + port.name);
                                }

                                iNewPort.Id_functor_app = appPort.Id_functor_app;
                                iNewPort.Id_abstract_inner = appPort.Id_abstract;

                                InnerComponentExposed ice = new InnerComponentExposed();
                                ice.Id_abstract = absC.Id_abstract;
                                ice.Id_inner_rename = iNewPort.Id_inner;
                                ice.Id_inner_owner = iNew.Id_inner;
                                ice.Id_inner = old_port_localRef;

                                DGAC.BackEnd.icedao.insert(ice);

                                if (DGAC.BackEnd.icdao.retrieve(iNewPort.Id_abstract_owner, iNewPort.Id_inner) == null)
                                    DGAC.BackEnd.icdao.insert(iNewPort);
                            }
                        }
                        if (DGAC.BackEnd.icdao.retrieve(iNew.Id_abstract_owner, iNew.Id_inner) == null)
                            DGAC.BackEnd.icdao.insert(iNew);

                    }
                }
            }

        //    SupplyParameterParameterDAO sppdao = new SupplyParameterParameterDAO();
            IList<SupplyParameterParameter> sppList = DGAC.BackEnd.sppdao.listFreeVariables(absC);

 
          //  InnerComponentDAO icdao = new InnerComponentDAO();
          //  InnerComponentExposedDAO icedao = new InnerComponentExposedDAO();

            foreach (SupplyParameterParameter spp in sppList)
            {
                InnerComponent ic = DGAC.BackEnd.icdao.retrieve2(absC.Id_abstract, spp.Id_functor_app);
                IList<InnerComponentExposed> ice = DGAC.BackEnd.icedao.listOwnerOfExposedInner(ic.Id_abstract_owner, ic.Id_inner);
                InnerComponent icc = DGAC.BackEnd.icdao.retrieve(absC.Id_abstract, ice[0].Id_inner_owner);
                InnerComponent ic_ = DGAC.BackEnd.icdao.retrieve(icc.Id_abstract_inner, ice[0].Id_inner);
               // SupplyParameterComponentDAO spcdao = new SupplyParameterComponentDAO();
                SupplyParameterComponent spc = DGAC.BackEnd.spcdao.retrieve(spp.Id_parameter, ic_.Id_functor_app);

                SupplyParameterComponent spcNew = new SupplyParameterComponent();
                spcNew.Id_abstract =spp.Id_abstract;
                spcNew.Id_functor_app=spp.Id_functor_app;
                spcNew.Id_functor_app_actual=spc.Id_functor_app_actual;
                spcNew.Id_parameter=spp.Id_parameter;
                DGAC.BackEnd.spcdao.insert(spcNew);

                DGAC.BackEnd.sppdao.remove(spp);

            }

        }

        private void importInnerComponentsOfSupper(AbstractComponentFunctor absC, IList<InnerComponentType> includeAsInner)
        {
           // InnerComponentDAO iNewDAO = new InnerComponentDAO();
            IDictionary<string, SupplyParameter> parsSuper = new Dictionary<string, SupplyParameter>();

            // Inner components of the supertype.
          //  AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
          //  SupplyParameterDAO spdao = new SupplyParameterDAO();
            if (absC.Id_functor_app_supertype > 0)
            {
                AbstractComponentFunctorApplication acfa = DGAC.BackEnd.acfadao.retrieve(absC.Id_functor_app_supertype);
                
                // It is a parameter in the subtype. Check if it is supplied in the type.
                IList<SupplyParameter> spList = DGAC.BackEnd.spdao.list(acfa.Id_functor_app);
                foreach (SupplyParameter sp in spList)
                    parsSuper.Add(sp.Id_parameter, sp);

                IList<InnerComponent> iss = DGAC.BackEnd.icdao.list(acfa.Id_abstract);
                foreach (InnerComponent i in iss)
                {
                    InnerComponent iNew = new InnerComponent();
                    if (i.Parameter_top != null)
                    {

                        SupplyParameter sp = null; 
                        parsSuper.TryGetValue(i.Parameter_top, out sp);

                        if (sp is SupplyParameterComponent)
                        {
                            // 1th CASE: It is not a parameter in the actual component.
                            // NOT YET TESTED !!!
                            SupplyParameterComponent spc = (SupplyParameterComponent)sp;

                            AbstractComponentFunctorApplication acfaReplace = DGAC.BackEnd.acfadao.retrieve(spc.Id_functor_app_actual);
                            iNew.Id_abstract_inner = acfaReplace.Id_abstract;
                            iNew.Parameter_top = null;
                            iNew.Id_abstract_owner = absC.Id_abstract;
                            iNew.Id_functor_app = liftFunctorApp(acfaReplace.Id_functor_app, parsSuper);
                            iNew.Id_inner = i.Id_inner;
                            DGAC.BackEnd.icdao.insert(iNew);
                        }
                        else if (sp is SupplyParameterParameter)
                        {
                            // 2nd CASE: It continues to be a parameter in the actual component.
                            SupplyParameterParameter spp = (SupplyParameterParameter)sp;

                            String varName = null;
                            foreach (ParameterRenaming pr in parameterRenamingSupper)
                            {
                                if (pr.formFieldId.Equals(i.Parameter_top))
                                {
                                    varName = pr.varName;
                                }
                            }

                            ParameterSupplyType supply = lookForSupplyForVarName(varName);
                            if (supply != null)
                            {
                                InnerComponentType cReplace = lookForInnerComponent(supply.cRef);
                                if (cReplace != null)
                                {
                                    includeAsInner.Add(cReplace);
                                }
                            }
                        }

                    }
                    else
                    {
                        // 3rd CASE: 
                        // NOT YET TESTED !!! 
                        iNew.Id_abstract_inner = i.Id_abstract_inner;
                        iNew.Parameter_top = null;
                        iNew.Id_abstract_owner = absC.Id_abstract;
                        iNew.Id_functor_app = liftFunctorApp(i.Id_functor_app, parsSuper);
                        iNew.Id_inner = i.Id_inner;
                        DGAC.BackEnd.icdao.insert(iNew);
                    }
                }
            }
        }



        // NOT YET TESTED
        private int liftFunctorApp(int id_functor_app, IDictionary<string, SupplyParameter> parsSuper)
        {
          //  AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
         //   SupplyParameterDAO spdao = new SupplyParameterDAO();

            AbstractComponentFunctorApplication acfa = DGAC.BackEnd.acfadao.retrieve(id_functor_app);

            AbstractComponentFunctorApplication acfaNew = new AbstractComponentFunctorApplication();
            acfaNew.Id_abstract = acfa.Id_abstract;
            DGAC.BackEnd.acfadao.insert(acfaNew);

            IList<SupplyParameter> supplyList = DGAC.BackEnd.spdao.list(id_functor_app);
            foreach (SupplyParameter sp in supplyList)
            {
                if (sp is SupplyParameterComponent)
                {
                    SupplyParameterComponent spc = (SupplyParameterComponent)sp;
                    SupplyParameterComponent spcNew = new SupplyParameterComponent();
                    spcNew.Id_functor_app = acfaNew.Id_functor_app;
                    spcNew.Id_functor_app_actual = liftFunctorApp(spc.Id_functor_app_actual, parsSuper);
                    spcNew.Id_abstract = spc.Id_abstract;
                    spcNew.Id_parameter = spc.Id_parameter;

                }
                else if (sp is SupplyParameterParameter)
                {
                    SupplyParameterParameter spp = (SupplyParameterParameter)sp;
                    SupplyParameter spNew = null;
                    SupplyParameter spSuper = null;

                    parsSuper.TryGetValue(spp.Id_parameter_actual, out spSuper);

                    if (spSuper is SupplyParameterComponent)
                    {
                        SupplyParameterComponent spcSuper = (SupplyParameterComponent)spSuper;
                        spNew = new SupplyParameterComponent();
                        SupplyParameterComponent spcNew = (SupplyParameterComponent)spNew;

                        spcNew.Id_functor_app = acfaNew.Id_functor_app;
                        spcNew.Id_abstract = spSuper.Id_abstract;
                        spcNew.Id_parameter = spp.Id_parameter;
                        spcNew.Id_functor_app_actual = spSuper.Id_functor_app;
                    }
                    else if (spSuper is SupplyParameterParameter)
                    {
                        SupplyParameterParameter sppSuper = (SupplyParameterParameter)spSuper;
                        spNew = new SupplyParameterParameter();
                        SupplyParameterParameter sppNew = (SupplyParameterParameter)spNew;

                        sppNew.Id_functor_app = acfaNew.Id_functor_app;
                        sppNew.Id_abstract = spSuper.Id_abstract;
                        sppNew.Id_parameter = spp.Id_parameter_actual;
                        sppNew.Id_parameter_actual = sppSuper.Id_parameter_actual;
                        sppNew.FreeVariable = spp.FreeVariable;
                    }
                    DGAC.BackEnd.spdao.insert(sp);
                }
            }
            return acfaNew.Id_functor_app;
        }

        private ParameterType lookForParameterByParameterId(string parId)
        {
            if (parameter != null)
            {
                foreach (ParameterType p in parameter)
                {
                    if (p.formFieldId.Equals(parId))
                    {
                        return p;
                    }
                }
            }
            return null;
        }

         

        private string lookForRenaming(string cRef, string pRef)
        {
            if (innerRenaming != null)
            {
                foreach (InnerRenamingType ir in innerRenaming)
                {
                    if (ir.cRef.Equals(cRef) && ir.cOldName.Equals(pRef))
                    {
                        return ir.cNewName;
                    }
                }
            }
            return pRef;
        }

        protected IList<AbstractComponentFunctorParameter> loadAbstractComponentFunctorParameters(AbstractComponentFunctor c_)
        {
            IList<AbstractComponentFunctorParameter> pars = new List<AbstractComponentFunctorParameter>();
          //  AbstractComponentFunctorParameterDAO pdao = new AbstractComponentFunctorParameterDAO();
            if (parameter != null) 
                foreach (ParameterType parameter_ in parameter)
                {
                    AbstractComponentFunctorParameter p = new AbstractComponentFunctorParameter();

                    p.Id_abstract = c_.Id_abstract;
                    p.Id_parameter = parameter_.formFieldId;

                    ComponentInUseType cBound = lookForInnerComponent(parameter_.componentRef);
                    AbstractComponentFunctorApplication cApp = newAbstractComponentFunctorApplication(cBound);
                    if (cApp == null)
                    {
                        throw new Exception("DEPLOY ERROR: Unresolved Dependency for base component (context parameter bound) : " + cBound.name);
                    }

                    p.Bounds_of = cApp.Id_functor_app;

                    DGAC.BackEnd.acfpdao.insert(p);

                    pars.Add(p);
                }
            return pars;
        }


        private void loadInterfaces(AbstractComponentFunctor absC)
        {
         //   SliceDAO sdao = new SliceDAO();
         //   SliceExposedDAO sedao = new SliceExposedDAO();
         //   SourceCodeDAO scdao = new SourceCodeDAO();
          //  SourceCodeReferenceDAO scrdao = new SourceCodeReferenceDAO();

            if (unit != null)
            {
                int count=0;
                // for each interface ...
                foreach (UnitType u in unit)
                {
                    string uRef = u.uRef;
                    string iRef = u.iRef;
                    string uRefSuper = u.super == null ? null : u.super.uRef;

                    InterfaceType ui = lookForInterface(iRef);
                    int nargs = ui.nArgsSpecified ? ui.nArgs : 0;

                    Interface i = new Interface();
                    i.Id_abstract = absC.Id_abstract;
                    i.Id_interface = uRef;
                    i.Id_interface_super = uRefSuper;
                    i.Class_name = xc.header.packagePath + "." + xc.header.name + "." + iRef;
                    i.Class_nargs = nargs; // TODO
                    i.Assembly_string = iRef + ", Culture=neutral, Version=0.0.0.0"; // In the current implementation, the name of the dll is the name of the class of the unit.
                    i.Order = ++count;

                    foreach (SourceFileType sft in ui.sources[ui.sources.Length - 1].file)
                    {
                        SourceCode ss = new SourceCode();
                        ss.Type_owner = 'i';
                        ss.Id_owner_container = i.Id_abstract;
                        ss.Id_owner = i.Id_interface;
                        ss.Contents = sft.contents;
                        ss.File_name = sft.name;
                        ss.File_type = "dll";
                        DGAC.BackEnd.scdao.insert(ss);
                        int size = (sft.externalDependency == null ? 0 : sft.externalDependency.Length) +
                                   (ui.externalReferences == null ? 0 : ui.externalReferences.Length);
                        if (size > 0)
                        {
                            string[] allRefs = new string[size];
                            if (ui.externalReferences != null)
                                ui.externalReferences.CopyTo(allRefs, 0);

                            if (sft.externalDependency != null)
                                sft.externalDependency.CopyTo(allRefs, ui.externalReferences == null ? 0 : ui.externalReferences.Length);

                            foreach (string extRef in allRefs)
                            {
                                SourceCodeReference ssr = new SourceCodeReference();
                                ssr.Type_owner = ss.Type_owner;
                                ssr.Id_owner_container = ss.Id_owner_container;
                                ssr.Id_owner = ss.Id_owner;
                                ssr.File_name = ss.File_name;
                                ssr.Reference = extRef;
                                if (DGAC.BackEnd.scrdao.retrieve(ssr) == null)
                                {
                                    DGAC.BackEnd.scrdao.insert(ssr);
                                }
                            }
                        }
                    }

                //    InterfaceDAO idao = new InterfaceDAO();
                    DGAC.BackEnd.idao.insert(i);
                    if (u.slices != null)
                    {
                        IList<string> mS = new List<string>();
                        IList<String> mP = new List<string>();
                        IDictionary<string, UnitSliceType> m = new Dictionary<string, UnitSliceType>();
                        
                        // 1st PASS: COLLECT ALL MAPPINGS SLICE/EXPOSED SLICES
                        foreach (UnitSliceType uS in u.slices)
                        {
                            string sliceName = uS.sliceName;
                            if (uS.port != null) 
                                foreach (string portName in uS.port)
                                {
                                    mS.Add(sliceName);
                                    mP.Add(portName);
                                }
                        }

                        // 2nd PASS: 
                        foreach (UnitSliceType uS in u.slices)
                        {
                            string sliceName = uS.sliceName;
                            if (mP.Contains(sliceName) && !m.ContainsKey(sliceName))
                            {   
                                m.Add(sliceName, uS);
                            }
                        }

                        // 3rd PASS:
                        foreach (UnitSliceType uS in u.slices)
                        {
                            string sname = uS.sliceName;
                            string cRefS = uS.cRef;
                            string uRefS = uS.uRef;
                            
                            InnerComponentType innerC = lookForInnerComponent(cRefS);

                            Slice s = new Slice();
                            s.Id_abstract = absC.Id_abstract;
                            s.Id_interface = uRef;
                            s.Id_interface_slice = uRefS;
                            s.Id_inner = innerC.localRef;
                            s.Id_split_replica = uS.replica;
                            s.Transitive = mP.Contains(sname);

                            if (!s.Transitive && uS.port != null)
                            {
                                foreach (string pname in uS.port) {
                                    UnitSliceType usPort = null;
                                    m.TryGetValue(pname, out usPort);

                                    InnerComponentType innerCPort = lookForInnerComponent(usPort.cRef);

                                    SliceExposed se = new SliceExposed();
                                    se.Id_abstract = s.Id_abstract;
                                    se.Id_inner = innerCPort.localRef;
                                    se.Id_inner_owner = s.Id_inner;
                                    se.Id_interface_slice_owner = s.Id_interface_slice;
                                    se.Id_split_replica_owner = s.Id_split_replica;
                                    se.Id_split_replica = usPort.replica; // s.Id_split_replica;
                                    se.Id_interface_slice = usPort.uRef;

                                    DGAC.BackEnd.sedao.insert(se);
                                }
                            }
                            //if (sdao.retrieve(s.Id_abstract,s.Id_inner,s.Id_interface_slice,s.Id_split_replica) == null) 
                            DGAC.BackEnd.sdao.insert(s);
                        }
                    }
                }
            }
        }

        internal void updateSources(ComponentType ct, AbstractComponentFunctor c)
        {
          //  UnitDAO udao = new UnitDAO();

            LoadBodyItems(ct.componentInfo);

            IDictionary<string, Unit> units = new Dictionary<string, Unit>();

         //   SourceCodeDAO scdao = new SourceCodeDAO();
          //  SourceCodeReferenceDAO scrdao = new SourceCodeReferenceDAO();

            int id_abstract = c.Id_abstract;

            // for each unit ...
            foreach (UnitType u in unit)
            {
                string uref = u.uRef;
                string iRef = u.iRef; 
                string urefSuper = u.super == null ? null : u.super.uRef;

             //   InterfaceDAO idao = new InterfaceDAO();
                Interface i = DGAC.BackEnd.idao.retrieve(id_abstract, uref);
                InterfaceType ui = lookForInterface(iRef);

                foreach (SourceFileType sft in ui.sources[ui.sources.Length - 1].file)
                {
                    SourceCode ss = new SourceCode();
                    ss.Type_owner = 'i';
                    ss.Id_owner_container = c.Id_abstract;
                    ss.Id_owner = i.Id_interface;
                    ss.Contents = sft.contents;
                    ss.File_type = "dll";
                    ss.File_name = sft.name;
                    DGAC.BackEnd.scdao.update(ss);
                    if (sft.externalDependency != null)
                    {
                        foreach (string extRef in sft.externalDependency)
                        {
                            SourceCodeReference ssr = new SourceCodeReference();
                            ssr.Type_owner = ss.Type_owner;
                            ssr.Id_owner_container = ss.Id_owner_container;
                            ssr.Id_owner = ss.Id_owner;
                            ssr.File_name = ss.File_name;
                            ssr.Reference = extRef;
                            if (DGAC.BackEnd.scrdao.retrieve(ssr) != null)
                            {
                                DGAC.BackEnd.scrdao.update(ssr);
                            }
                            else
                            {
                                DGAC.BackEnd.scrdao.insert(ssr);
                            }
                        }
                    }
                }
            }
        }
 
       /* private Interface lookForUnit(AbstractComponentFunctor c, string uRefS)
        {
            InterfaceDAO udao = new InterfaceDAO();
            Interface u = udao.retrieve(c.Id_abstract, uRefS);
            return u;
        }*/

  
    }
}
