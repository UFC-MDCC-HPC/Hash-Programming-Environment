using System;
using System.Collections.Generic;

using System.Text;
using br.ufc.pargo.hpe.backend.DGAC.database;

namespace HPE_DGAC_LoadDB
{
    class LoaderAbstractComponent : LoaderComponent
    {
        /* The parameter fileName points to the location of a concrete component.
         */

        private ComponentType xc;

        public override bool componentExists(string hash_component_uid, out HashComponent cRef)
        {
            AbstractComponentFunctor absC = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieveByUID(hash_component_uid);
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
            return absC;
        }
		
		
		/*
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
                        br.ufc.pargo.hpe.backend.DGAC.BackEnd.exldao.insert(ews);
                    }
                }
            
        }
        */

        private IList<ParameterRenaming> parameterRenamingSupper = null;

        protected override HashComponent loadComponent_(ComponentType c)
        {
            // CREATE Component
            
          //  InnerComponentExposedDAO iNewExpDAO = new InnerComponentExposedDAO();
         //   InnerComponentDAO iNewDAO = new InnerComponentDAO();

            AbstractComponentFunctor c_ = new AbstractComponentFunctor();
            c_.Id_abstract = Connector.nextKey("id_abstract", "abstractcomponentfunctor");
            c_.Hash_component_UID = c.header.hash_component_UID;
            c_.Library_path = c.header.packagePath + "." + c.header.name;
            c_.Kind = c.header.kind.ToString();
            
           // IList<AbstractComponentFunctorParameter> absParams = loadAbstractComponentFunctorParameters(c_);

            if (c.header.baseType != null)
            {
                ExtensionTypeType extType = c.header.baseType.extensionType;
                ComponentInUseType baseC = null;

				if (extType.ItemElementName == ItemChoiceType1.extends && extType.Item)
                {
                    baseC = c.header.baseType.component;

                    parameterRenamingSupper = baseC.parameter;

                    AbstractComponentFunctorApplication baseCapp = newAbstractComponentFunctorApplication(baseC);

                    // FOLLOW arrow subtype
                    if (baseCapp == null)
                        throw new Exception("DEPLOY ERROR: Unresolved Dependency for base component (extends) : " + baseC.name);

                    c_.Id_functor_app_supertype = baseCapp.Id_functor_app;
                }

            	br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.insert(c_);		

                // LOAD EXPOSED INNER COMPONENTS OF THE BASE
                if (baseC.port != null)
                {
                    foreach (InnerComponentType port in baseC.port)
                    {
                        innerAll.Add(port);

                        InnerComponent iNewPort = new InnerComponent();
                        iNewPort.Id_abstract_owner = c_.Id_abstract;
                        string old_port_localRef = port.localRef;
                        port.localRef = lookForRenamingNew(baseC.localRef, port.localRef);
                        iNewPort.Id_inner = port.localRef;
                        iNewPort.Parameter_top = port.parameter_id;
                        iNewPort.Transitive = true;
                        iNewPort.IsPublic = true;
						iNewPort.Multiple = port.multipleSpecified ? port.multiple : false;

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

                        br.ufc.pargo.hpe.backend.DGAC.BackEnd.icedao.insert(ice);

                        if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve(iNewPort.Id_abstract_owner, iNewPort.Id_inner) == null)
                            br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert(iNewPort);
                    }
                }

            } 
			else
            	br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.insert(c_);



            loadAbstractComponentFunctorParameters(c_);
            
            return c_;
        }


		private string mkSliceRef(string cRef, string uRef, int slice_replica)
		{
				return cRef + "." + uRef + "[" + slice_replica + "]";
		}

		private IDictionary<string,int> sliceToUnitReplicaMapping=null;

		private void loadSliceReplicaToUnitReplicaMapping (InnerComponentType c)
		{
				if (sliceToUnitReplicaMapping == null)
					sliceToUnitReplicaMapping = new Dictionary<string,int>();

				foreach (UnitBoundsType u in c.unitBounds) 
				{
					string cRef = c.localRef;
					string uRef = u.uRef;
					
					int slice_replica = /*u.slice_replicaSpecified ? */ u.slice_replica /*: 0*/;
					int unit_replica = /*u.unit_replicaSpecified ? */ u.unit_replica /*: slice_replica*/;

					string sRef = mkSliceRef(cRef, uRef, slice_replica);
					Console.WriteLine("loadSliceReplicaToUnitReplicaMapping sRef=" + sRef + ","+unit_replica);
					if (!sliceToUnitReplicaMapping.ContainsKey(sRef))
						sliceToUnitReplicaMapping.Add(sRef, unit_replica);
				}
		}

        private void loadInnerComponents(AbstractComponentFunctor absC)
        {
            IList<InnerComponentType> includeAsInner = new List<InnerComponentType>();

            importInnerComponentsOfSupper(absC, includeAsInner);

            IDictionary<string, InnerComponentType> innersByVarName= new Dictionary<string, InnerComponentType>();

            if (parameter != null) foreach (ParameterType ir in parameter)
            {
                InnerComponentType ic = this.lookForInnerComponent(ir.componentRef);
				if (!innersByVarName.ContainsKey(ir.varName))
					innersByVarName.Add(ir.varName, ic);
				else
					Console.WriteLine("ALREADY EXISTS - key=" + ir.varName + ", value=" + ic.localRef);
            }

            if (parameterSupply != null) foreach (ParameterSupplyType ir in parameterSupply)
            {
                InnerComponentType ic = this.lookForInnerComponent(ir.cRef);
				if (!innersByVarName.ContainsKey(ir.varName))
					innersByVarName.Add(ir.varName, ic);
				else
					Console.WriteLine("ALREADY EXISTS - key=" + ir.varName + ", value=" + ic.localRef);
            }

            if (inner != null)
            {
                foreach (InnerComponentType c in inner)
                {
					Console.WriteLine("BEGIN loadInnerComponent : " + c.localRef + " :: " + c.location);

                    // innerAll.Add(c);
                    if (((isNotInSupply(c) || this.findInSlices(c.localRef)) 
						 && (isNotParameter(c) || this.findInSlices(c.localRef))) 
						|| includeAsInner.Contains(c))
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
                        iNew.IsPublic = c.exposed;
						iNew.Multiple = c.multipleSpecified ? c.multiple : false;
						
                        // LOAD EXPOSED INNER COMPONENTS
                        if (c.port != null)
                        {
                            foreach (InnerComponentType port in c.port)
                            {
								Console.WriteLine("loadInnerComponent - BEGIN PORT " + port.localRef);
                                // --------------------------------------------------
                                string varName = null;
                                int id_abstract_port = app.Id_abstract;
                                string id_inner_port = port.localRef;
								
                                InnerComponent ic_port = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve(id_abstract_port,id_inner_port);
								
								Console.WriteLine("loadInnerComponent - STEP 1");

                                if (c.parameter != null && ic_port != null)
                                {
                                    foreach (ParameterRenaming par in c.parameter)
                                    {
										Console.WriteLine("loadInnerComponent - STEP 2 begin" + par.formFieldId + "-"+ par.varName);
                                        if (par.formFieldId.Equals(ic_port.Parameter_top))
                                        {
                                            varName = par.varName;
                                        }
										Console.WriteLine("loadInnerComponent - STEP 2 end " + par.formFieldId + " - "+ par.varName);
                                    }
                                }

                                InnerComponentType port_replace = port;
                                if (varName != null)
                                {
									Console.WriteLine("loadInnerComponent - STEP 3 " + varName);
									foreach (KeyValuePair<string, InnerComponentType> iii in innersByVarName) 
									{
											Console.WriteLine("loadInnerComponent " + iii.Key + " --- " + iii.Value.localRef + " , " + iii.Value.location);
									}
                                    innersByVarName.TryGetValue(varName, out port_replace);
								} else
									Console.WriteLine("loadInnerComponent - STEP 3 ");


                                // --------------------------------------------------
								


                                innerAll.Add(port);

                                InnerComponent iNewPort = new InnerComponent();
								Console.WriteLine("loadInnerComponent - STEP 3.1");
                                iNewPort.Id_abstract_owner = absC.Id_abstract;
								Console.WriteLine("loadInnerComponent - STEP 3.2");
                                string old_port_localRef = port.localRef;
								Console.WriteLine("loadInnerComponent - STEP 3.3");
                                port.localRef = lookForRenamingNew(c.localRef, port.localRef);
								Console.WriteLine("loadInnerComponent - STEP 3.4");
                                iNewPort.Id_inner = port.localRef;                               
								Console.WriteLine("loadInnerComponent - STEP 3.5");
                                iNewPort.Parameter_top = port_replace.parameter_id;
								Console.WriteLine("loadInnerComponent - STEP 3.6");
                                iNewPort.Transitive = true;
								Console.WriteLine("loadInnerComponent - STEP 3.7");
                                iNewPort.IsPublic = port.exposed;
								Console.WriteLine("loadInnerComponent - STEP 3.7");
								iNewPort.Multiple = port.multipleSpecified ? port.multiple : false;
								Console.WriteLine("loadInnerComponent - STEP 3.9");

                                AbstractComponentFunctorApplication appPort = newAbstractComponentFunctorApplication(port_replace);
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

                                br.ufc.pargo.hpe.backend.DGAC.BackEnd.icedao.insert(ice);

                                if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve(iNewPort.Id_abstract_owner, iNewPort.Id_inner) == null)
                                    br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert(iNewPort);
								
								Console.WriteLine("loadInnerComponent - END PORT " + port.localRef);

                            }
                        }


                        if (includeAsInner.Contains(c) && br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve(iNew.Id_abstract_owner, iNew.Id_inner) != null)
                        {
							Console.WriteLine("loadInnerComponent - BLOCK 2 OPEN");
                            br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.remove(iNew.Id_abstract_owner, iNew.Id_inner);
                            br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert(iNew);
							Console.WriteLine("loadInnerComponent - BLOCK 2 CLOSE");
                        }
                        else if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve(iNew.Id_abstract_owner, iNew.Id_inner) == null)
                        {
							Console.WriteLine("loadInnerComponent - BLOCK 3 OPEN");
                            br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert(iNew);
							Console.WriteLine("loadInnerComponent - BLOCK 3 CLOSE");
                        }

                    }
                    
					loadSliceReplicaToUnitReplicaMapping(c);

					Console.WriteLine("END loadInnerComponent : " + c.localRef + " :: " + c.location);

                }
            }


        }

        private bool findInSlices(string cref)
        {
			foreach (UnitType u in unit)
			{
				if (u.slices != null) 
				{
	                foreach (UnitSliceType s in u.slices)
	                {
	                    if (s.cRef.Equals(cref))
	                    {
	                        return true;
						}					
	                }					
				}
			}
			
            return false;
        }

        private bool isNotParameter(InnerComponentType c)
        {
            if (this.parameter != null)
            {
                foreach (ParameterType s in parameter)
                {
                    if (s.componentRef.Equals(c.localRef))
                    {
                        return false;
                    }
                }
            }
            return true;

        }

        private void importInnerComponentsOfSupper(AbstractComponentFunctor absC, IList<InnerComponentType> includeAsInner)
        {
			Console.WriteLine("importInnerComponentsOfSupper : " + "START");
            IDictionary<string, SupplyParameter> parsSuper = new Dictionary<string, SupplyParameter>();

            // Inner components of the supertype.
            if (absC.Id_functor_app_supertype > 0)
            {
                AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(absC.Id_functor_app_supertype);
                
               

                // It is a parameter in the subtype. Check if it is supplied in the type.
                IList<SupplyParameter> spList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list(acfa.Id_functor_app);
                foreach (SupplyParameter sp in spList)
                    parsSuper.Add(sp.Id_parameter, sp);

                IList<InnerComponent> iss = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.list(acfa.Id_abstract);
					foreach (InnerComponent i in iss) if (!i.IsPublic)
                {
						Console.WriteLine("importInnerComponentsOfSupper 1: " + i.Id_inner + " , " + i.Id_functor_app + " , "+ (i.Parameter_top));

                    InnerComponent iNew = new InnerComponent();
                    if (i.Parameter_top != null)
                    {
                        SupplyParameter sp = null; 
                        parsSuper.TryGetValue(i.Parameter_top, out sp);
							Console.WriteLine("importInnerComponentsOfSupper 2: " + i.Parameter_top + "," + i.Id_inner);

                        if (sp is SupplyParameterComponent)
                        {
							Console.WriteLine("importInnerComponentsOfSupper 3: " + "sp is SupplyParameterComponent");

                            // 1th CASE: It is not a parameter in the actual component.
                            // NOT YET TESTED !!!
                            SupplyParameterComponent spc = (SupplyParameterComponent)sp;

                            AbstractComponentFunctorApplication acfaReplace = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(spc.Id_functor_app_actual);
                            iNew.Id_abstract_inner = acfaReplace.Id_abstract;
                            iNew.Parameter_top = null;
                            iNew.Id_abstract_owner = absC.Id_abstract;
                            iNew.Id_functor_app = liftFunctorApp(acfaReplace.Id_functor_app, parsSuper);
                            iNew.Id_inner = i.Id_inner;

                            br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert(iNew);
                        }
                        else if (sp is SupplyParameterParameter)
                        {
							Console.WriteLine("importInnerComponentsOfSupper 4: " + "sp is SupplyParameterParameter");
                            // 2nd CASE: It continues to be a parameter in the actual component.
                            SupplyParameterParameter spp = (SupplyParameterParameter)sp;

                            String varName = null;
                            foreach (ParameterRenaming pr in parameterRenamingSupper)
                            {
                                if (pr.formFieldId.Equals(i.Parameter_top))
                                {
                                    varName = pr.varName;
                                    ParameterType parameter = this.lookForParameterByVarName(varName);
                                    InnerComponentType cReplace = lookForInnerComponent(parameter.componentRef);
                                    cReplace.localRef = i.Id_inner;
                                    cReplace.exposed = i.IsPublic;
									cReplace.multiple = i.Multiple;
                                    includeAsInner.Add(cReplace);

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
                        br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert(iNew);
                    }
                }
            }
			Console.WriteLine("importInnerComponentsOfSupper : " + "FINISH");
        }



        // NOT YET TESTED
        private int liftFunctorApp(int id_functor_app, IDictionary<string, SupplyParameter> parsSuper)
        {
            AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(id_functor_app);

            AbstractComponentFunctorApplication acfaNew = new AbstractComponentFunctorApplication();
            acfaNew.Id_abstract = acfa.Id_abstract;
            br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.insert(acfaNew);

            IList<SupplyParameter> supplyList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list(id_functor_app);
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

					if (parsSuper.Count >0) {
						foreach (KeyValuePair<string, SupplyParameter> p in parsSuper)
						{
							Console.WriteLine("Key=" + p.Key + ", Value=" + p.Value.Id_abstract);
						} 
					}
					else Console.WriteLine("parSupers EMPTY !!!!!!");

                    if (parsSuper.TryGetValue(spp.Id_argument, out spSuper))
					{
	                    if (spSuper is SupplyParameterComponent)
	                    {
	                        SupplyParameterComponent spcSuper = (SupplyParameterComponent)spSuper;
	                        spNew = new SupplyParameterComponent();
								Console.WriteLine("liftFunctorApp: 1" + (spNew==null));
	                        SupplyParameterComponent spcNew = (SupplyParameterComponent)spNew;
	
	                        spcNew.Id_functor_app = acfaNew.Id_functor_app;
	                        spcNew.Id_abstract = spSuper.Id_abstract;
	                        spcNew.Id_parameter = spp.Id_parameter;
	                        spcNew.Id_functor_app_actual = spSuper.Id_functor_app;
								Console.WriteLine("liftFunctorApp: 2" + (spcNew==null));
	                    }
	                    else if (spSuper is SupplyParameterParameter)
	                    {
								Console.WriteLine("liftFunctorApp: 3" + (spNew==null));
	                        SupplyParameterParameter sppSuper = (SupplyParameterParameter)spSuper;
	                        spNew = new SupplyParameterParameter();
	                        SupplyParameterParameter sppNew = (SupplyParameterParameter)spNew;
	
	                        sppNew.Id_functor_app = acfaNew.Id_functor_app;
	                        sppNew.Id_abstract = spSuper.Id_abstract;
	                        sppNew.Id_parameter = spp.Id_argument;
	                        sppNew.Id_argument = sppSuper.Id_argument;
	                        sppNew.FreeVariable = spp.FreeVariable;
								Console.WriteLine("liftFunctorApp: 4" + (sppNew==null));
	                    }
						else {
								Console.WriteLine("liftFunctorApp: 5 " + (spp.Id_argument));
						}
					}
					else 
					{
                        SupplyParameterParameter sppSuper = (SupplyParameterParameter)spSuper;
                        spNew = new SupplyParameterParameter();
                        SupplyParameterParameter sppNew = (SupplyParameterParameter)spNew;

						sppNew.Id_argument = spp.Id_argument;
						sppNew.FreeVariable = spp.FreeVariable;
                        sppNew.Id_functor_app = acfaNew.Id_functor_app;
                        sppNew.Id_abstract = acfaNew.Id_abstract;
                        sppNew.Id_parameter = spp.Id_argument;
                        //sppNew.Id_parameter_actual = sppSuper.Id_parameter_actual;
                        //sppNew.FreeVariable = spp.FreeVariable;
					}
                    br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.insert(spNew);
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

         

        private string lookForRenamingNew(string cRef, string pRef)
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

        private string lookForRenamingOld(string cRef, string pRef)
        {
            if (innerRenaming != null)
            {
                foreach (InnerRenamingType ir in innerRenaming)
                {
                    if (ir.cRef.Equals(cRef) && ir.cNewName.Equals(pRef))
                    {
                        return ir.cOldName;
                    }
                }
            }
            return pRef;
        }

        protected IList<AbstractComponentFunctorParameter> loadAbstractComponentFunctorParameters(AbstractComponentFunctor c_)
        {
            IList<AbstractComponentFunctorParameter> pars = new List<AbstractComponentFunctorParameter>();
            if (parameter != null) 
                foreach (ParameterType parameter_ in parameter)
                {
						Console.WriteLine("loadAbstractComponentFunctorParameters : PARAMETER " + parameter_.componentRef + ":" + parameter_.formFieldId);
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

                    br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.insert(p);

                    pars.Add(p);
                }
			Console.WriteLine("loadAbstractComponentFunctorParameters : END");
            return pars;
        }

		private int findUnitReplica (string cRefS, string uRefS, int slice_replica)
		{
			string sRef = mkSliceRef(cRefS, uRefS, slice_replica);
			int unit_replica;
			sliceToUnitReplicaMapping.TryGetValue(sRef,out unit_replica);
			return unit_replica;
		}

        private void loadInterfaces(AbstractComponentFunctor absC)
        {
            if (unit != null)
            {
                int count=0;
                // for each interface ...
                foreach (UnitType u in unit)
                {
                    string uRef = u.uRef;
                    string iRef = u.iRef;
					int unit_replica = u.replicaSpecified ? u.replica : 0;
                    string uRefSuper = u.super == null ? null : u.super.uRef;

                    InterfaceType ui = lookForInterface(iRef);
                    int nargs = ui.nArgsSpecified ? ui.nArgs : 0;

					Console.Error.WriteLine("STEP 5.3");
					
                    Interface i = new Interface();
                    i.Id_abstract = absC.Id_abstract;
                    i.Id_interface = uRef;
					i.Unit_replica = unit_replica;
                    i.Id_interface_super = uRefSuper;
                    i.Class_name = xc.header.packagePath + "." + xc.header.name + "." + iRef;
                    i.Class_nargs = nargs; // TODO
                    i.Assembly_string = i.Class_name + ", Culture=neutral, Version=0.0.0.0"; // In the current implementation, the name of the dll is the name of the class of the unit.
					i.Order 	= ++count;
					i.Is_parallel = u.multiple;
					
					Console.Error.WriteLine("STEP 5.4");
					
					if (ui.parameter != null)
                    {
						Console.Error.WriteLine("STEP 5.4 - " + ui.parameter);

                        foreach (InterfaceParameterType ipx in ui.parameter)
                        {
								Console.Error.WriteLine("STEP 5.4 BEGIN 1- " + ipx.parid);
                            InterfaceParameter ip = new InterfaceParameter();
								Console.Error.WriteLine("STEP 5.4 BEGIN 2- " + ipx.parid);
                            ip.Id_abstract = i.Id_abstract;
                            ip.Id_interface = i.Id_interface;
                            ip.ParId = ipx.parid;
                            ip.VarId = ipx.varid;
                            ip.Id_interface_parameter = ipx.iname;
                            ip.Id_unit_parameter = ipx.uname;
                            ip.ParOrder = ipx.order;
                            br.ufc.pargo.hpe.backend.DGAC.BackEnd.ipdao.insert(ip);
								Console.Error.WriteLine("STEP 5.4 END - " + ipx.parid);
                        }
                    }
						Console.Error.WriteLine("BEFORE STEP 5.5");
					Console.Error.WriteLine("STEP 5.5 --- " + (ui==null) + "," + (ui.sources[ui.sources.Length - 1].file==null));
					int order = 0;
                    foreach (SourceFileType sft in ui.sources[ui.sources.Length - 1].file)
                    {
						Console.Error.WriteLine("STEP 5.5.0");
                        SourceCode ss = new SourceCode();
                        ss.Type_owner = 'i';
                        ss.Id_owner_container = i.Id_abstract;
                        ss.Id_owner = i.Id_interface;
                        ss.Contents = sft.contents;
                        ss.File_name = sft.name;
                        ss.File_type = "dll";
                        ss.Order = order++; 
                        
						Console.Error.WriteLine("STEP 5.5.1");
						
                        br.ufc.pargo.hpe.backend.DGAC.BackEnd.scdao.insert(ss);
                        int size = (sft.externalDependency == null ? 0 : sft.externalDependency.Length) +
                                   (ui.externalReferences == null ? 0 : ui.externalReferences.Length);
						
						Console.Error.WriteLine("STEP 5.5.2");
                        if (size > 0)
                        {
                            string[] allRefs = new string[size];
                            if (ui.externalReferences != null)
                                ui.externalReferences.CopyTo(allRefs, 0);

                            if (sft.externalDependency != null)
                                sft.externalDependency.CopyTo(allRefs, ui.externalReferences == null ? 0 : ui.externalReferences.Length);
							
							Console.Error.WriteLine("STEP 5.5.3");
                            foreach (string extRef in allRefs)
                            {
                                SourceCodeReference ssr = new SourceCodeReference();
                                ssr.Type_owner = ss.Type_owner;
                                ssr.Id_owner_container = ss.Id_owner_container;
                                ssr.Id_owner = ss.Id_owner;
                                ssr.File_name = ss.File_name;
                                ssr.Reference = extRef;
                                if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.scrdao.retrieve(ssr) == null)
                                {
                                    br.ufc.pargo.hpe.backend.DGAC.BackEnd.scrdao.insert(ssr);
                                }
                            }
							Console.Error.WriteLine("STEP 5.5.4");
                        }
                    }
					
					Console.Error.WriteLine("STEP 5.6");
                    br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.insert(i);
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

					Console.Error.WriteLine("STEP 5.7");
                        // 3rd PASS:
                        foreach (UnitSliceType uS in u.slices)
                        {
                            string sname = uS.sliceName;
                            string cRefS = uS.cRef;
                            string uRefS = uS.uRef;
                            
                            InnerComponentType innerC = lookForInnerComponent(cRefS);
							Console.Error.WriteLine("STEP 5.8");
							
                            InnerComponent inner = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve(absC.Id_abstract,cRefS);
                            Console.Error.WriteLine("STEP 5.9 ---" + absC.Id_abstract + "," + cRefS);

							int unit_replica_slice = findUnitReplica(cRefS, uRefS, uS.slice_replica);

							Interface iii = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveTop(inner.Id_abstract_inner, uRefS, unit_replica_slice);
                            Console.Error.WriteLine("STEP 5.9.5 ---" + (iii==null));
							
							
							Slice s = new Slice();
                            s.Id_abstract = absC.Id_abstract;
                            s.Id_interface = uRef;
							s.Unit_replica_host = unit_replica;
                            s.Id_interface_slice = iii == null ? uRefS : iii.Id_interface;
                            s.Id_inner = innerC.localRef;
							s.Inner_replica = uS.inner_replica;
							s.Slice_replica = uS.slice_replica; 
							s.Unit_replica = unit_replica_slice; 
                            s.Transitive = mP.Contains(sname);
							Console.Error.WriteLine("STEP 5.10");
							
                            string property_name = uS.sliceName;
                            string fstletter = property_name.Substring(0, 1);
                            property_name = fstletter.ToUpper() + property_name.Substring(1, property_name.Length - 1);
							
							Console.Error.WriteLine("STEP 5.11");
							
                            s.PortName = property_name;
							
                            if (!s.Transitive && uS.port != null)
                            {
								Console.Error.WriteLine("STEP 5.12");
                                foreach (string pname in uS.port) {
									Console.Error.WriteLine("STEP 5.12.1 -- " + pname + ", " + (m.Count));
									
                                    UnitSliceType usPort = null;
                                    m.TryGetValue(pname, out usPort);
									Console.Error.WriteLine("STEP 5.12.2 -- " + pname + ", " + (usPort==null));
																		
									Console.Error.WriteLine("STEP 5.12.5 -- " + usPort.cRef);
									
                                    InnerComponentType innerCPort = lookForInnerComponent(usPort.cRef);
									
									Console.Error.WriteLine("STEP 5.13");

                                    InnerComponent inner2 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve(absC.Id_abstract,usPort.cRef);
									int unit_replica_port = this.findUnitReplica(usPort.cRef,usPort.uRef,uS.slice_replica);
										Interface iii2 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveTop(inner2.Id_abstract_inner, usPort.uRef, unit_replica_port);

                                    SliceExposed se = new SliceExposed();
                                    se.Id_abstract = s.Id_abstract;
                                    se.Id_inner = innerCPort.localRef;
                                    se.Id_inner_owner = s.Id_inner;
                                    se.Id_interface_slice_owner = s.Id_interface_slice_top; // mudado de s.Id_interface_slice em 28/06/2011
                                    se.Slice_replica_owner = s.Slice_replica;
									se.Slice_replica = usPort.slice_replica; // s.Id_split_replica;
                                    se.Id_interface_slice = iii2 == null ? usPort.uRef : iii2.Id_interface;
                                    
                                    // achar innerRenaming para cNewName = usPort.cRef e cRef = cRefS (uS.cRef) -- Id_inner_original = cOldName
                                    string id_inner_original = lookForRenamingOld(cRefS, usPort.cRef);
                                    se.Id_inner_original = id_inner_original != null ? id_inner_original : usPort.cRef;
                                    se.Id_interface_slice_original = usPort.uRef; // DEVE SER O TOP !!!
									if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.sedao.retrieve2(se.Id_inner,
									                                                          se.Id_interface_slice,
									                                                          se.Id_abstract,
									                                                          se.Id_interface_slice_owner, 
									                                                          se.Id_inner_owner) == null) 
                                    	br.ufc.pargo.hpe.backend.DGAC.BackEnd.sedao.insert(se);
                                }
                            }
                            if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.sdao.retrieve(s.Id_abstract,
							                                                        s.Id_inner,
							                                                        s.Inner_replica,
							                                                        s.Id_interface_slice,
							                                                        s.Slice_replica) == null) 
                            	br.ufc.pargo.hpe.backend.DGAC.BackEnd.sdao.insert(s);
                        }

                    }
					
					//if (ui.protocol != null)
						readProtocol(i, ui);
                }
            }
        }
		
		private void readProtocol(Interface i, InterfaceType ui)
		{
			//ProtocolChoiceType main_protocol = ui.protocol;			
			UnitActionType[] actions  = ui.action;
			UnitConditionType[] conditions = ui.condition;
						
			//readProtocol(i, "main", main_protocol);
			
			if (actions != null)
				foreach (UnitActionType action in actions)
				{
					readProtocol(i, action.id, action.protocol);				
				}
			
			if (conditions != null)
				foreach (UnitConditionType condition in conditions)
				{
					readCondition(i, condition);
				}
			
		}
		
		private void readProtocol(Interface i, string action_id, ProtocolChoiceType protocol)
		{
			InterfaceAction action_row = new InterfaceAction();
			action_row.Id_abstract = i.Id_abstract;
			action_row.Id_interface = i.Id_interface;
			action_row.PartitionIndex = i.Unit_replica;
			action_row.Id_action = action_id;
			action_row.IsCondition = false;
			action_row.Protocol = "";
			br.ufc.pargo.hpe.backend.DGAC.BackEnd.iadao.insert(action_row);
		}
		
		private void readCondition(Interface i, UnitConditionType condition)
		{
			InterfaceAction action_row = new InterfaceAction();
			action_row.Id_abstract = i.Id_abstract;
			action_row.Id_interface = i.Id_interface;
			action_row.PartitionIndex = i.Unit_replica;
			action_row.Id_action = condition.id;
			action_row.IsCondition = true;
			action_row.Protocol = "";
			br.ufc.pargo.hpe.backend.DGAC.BackEnd.iadao.insert(action_row);
		}

        internal void updateSources(ComponentType ct, AbstractComponentFunctor c)
        {
            LoadBodyItems(ct.componentInfo);

            IDictionary<string, Unit> units = new Dictionary<string, Unit>();

            int id_abstract = c.Id_abstract;

            // for each unit ...
            foreach (UnitType u in unit)
            {
                string uref = u.uRef;
                string iRef = u.iRef; 
                string urefSuper = u.super == null ? null : u.super.uRef;

             //   InterfaceDAO idao = new InterfaceDAO();
                Interface i = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve(id_abstract, uref,u.replicaSpecified ? u.replica : 0);
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
                    br.ufc.pargo.hpe.backend.DGAC.BackEnd.scdao.update(ss);

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
                            if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.scrdao.retrieve(ssr) != null)
                            {
                                // DGAC.BackEnd.scrdao.update(ssr);
                            }
                            else
                            {
                                br.ufc.pargo.hpe.backend.DGAC.BackEnd.scrdao.insert(ssr);
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
