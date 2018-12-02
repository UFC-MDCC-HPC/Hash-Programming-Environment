using System;
using System.Collections.Generic;

using System.Text;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.Diagnostics;

namespace HPE_DGAC_LoadDB
{
    class LoaderAbstractComponent : LoaderComponent
    {
        /* The parameter fileName points to the location of a concrete component.
         */

        private ComponentType xc;

        public override bool componentExists(string library_path, out HashComponent cRef)
        {
			AbstractComponentFunctor absC = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve_libraryPath(library_path);
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

		public new HashComponent loadComponent(ComponentType c, ref IList<ExternalLibraryType>  externalLibrary)
        {
            this.xc = c;
			AbstractComponentFunctor absC = (AbstractComponentFunctor)base.loadComponent(c, ref externalLibrary);
            loadInnerComponents(absC);
            loadInterfaces(absC);
            return absC;
        }
		

        private IList<ParameterRenaming> parameterRenamingSuper = null;

        protected override HashComponent loadComponent_(ComponentType c)
        {
            // CREATE Component
            
            AbstractComponentFunctor c_ = new AbstractComponentFunctor();
            c_.Id_abstract = Connector.nextKey("id_abstract", "abstractcomponentfunctor");
            c_.Hash_component_UID = c.header.hash_component_UID;
            c_.Library_path = c.header.packagePath + "." + c.header.name;
            c_.Kind = c.header.kind.ToString();
            

            if (c.header.baseType != null)
            {
                ExtensionTypeType extType = c.header.baseType.extensionType;
                ComponentInUseType baseC = null;

				if (extType.ItemElementName == ItemChoiceType.extends && extType.Item)
                {
                    baseC = c.header.baseType.component;

                    parameterRenamingSuper = baseC.parameter;

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


		private string mkSliceRef(string cRef, string uRef)
		{
				return cRef + "." + uRef;
		}


        private void loadInnerComponents(AbstractComponentFunctor absC)
        {
            IList<InnerComponentType> includeAsInner = new List<InnerComponentType>();

            IDictionary<string, InnerComponentType> innersByVarName= new Dictionary<string, InnerComponentType>();

            if (parameter != null) foreach (ParameterType ir in parameter)
            {
                InnerComponentType ic = this.lookForInnerComponent(ir.componentRef);
				if (ic == null) Console.WriteLine("LOOK FOR INNER COMPONENT RETURNED NULL " + ir.componentRef);
					if (!innersByVarName.ContainsKey(ir.varName))
					innersByVarName[ir.varName] = ic;
				else
					Console.WriteLine("ALREADY EXISTS - key=" + ir.varName + ", value=" + ic.localRef);
            }

            if (parameterSupply != null) foreach (ParameterSupplyType ir in parameterSupply)
            {
                InnerComponentType ic = this.lookForInnerComponent(ir.cRef);
				if (!innersByVarName.ContainsKey(ir.varName))
					innersByVarName[ir.varName] = ic;
				else
					Console.WriteLine("ALREADY EXISTS - key=" + ir.varName + ", value=" + ic.localRef);
            }

			importInnerComponentsOfSuper(absC, includeAsInner);

			if (inner != null)
            {
                foreach (InnerComponentType c in inner)
                {
					Console.WriteLine("BEGIN loadInnerComponent : " + c.localRef + " :: " + c.package + "." + c.name);

                    // innerAll.Add(c);
                    if (((isNotInSupply(c) || this.findInSlices(c.localRef)) && (isNotParameter(c) || this.findInSlices(c.localRef))) || includeAsInner.Contains(c))
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
								
								InnerComponent ic_port = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve (id_abstract_port, id_inner_port);
								
								Console.WriteLine("loadInnerComponent - STEP 1");

                                if (c.parameter != null && ic_port != null)
                                {
                                    foreach (ParameterRenaming par in c.parameter)
                                    {
										Console.WriteLine("loadInnerComponent - STEP 2 begin" + par.formFieldId + " - "+ par.varName);
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
										Console.WriteLine("loadInnerComponent x " + iii.Key);
                                        Console.WriteLine("loadInnerComponent y " + (iii.Value == null));
										Console.WriteLine("loadInnerComponent z " + c.package);
										Console.WriteLine("loadInnerComponent w " + c.name);
									}
                                    port_replace = innersByVarName[varName];
								} else
									Console.WriteLine("loadInnerComponent - STEP 3 ");


                                // --------------------------------------------------
								


                                innerAll.Add(port);

                                InnerComponent iNewPort = new InnerComponent();
                                iNewPort.Id_abstract_owner = absC.Id_abstract;
                                string old_port_localRef = port.localRef;
                                port.localRef = lookForRenamingNew(c.localRef, port.localRef);
                                iNewPort.Id_inner = port.localRef;                               
                                iNewPort.Parameter_top = port_replace.parameter_id;
                                iNewPort.Transitive = true;
                                iNewPort.IsPublic = port.exposed;
								iNewPort.Multiple = port.multipleSpecified ? port.multiple : false;

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

								InnerComponent ic_port_exists = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve (iNewPort.Id_abstract_owner, iNewPort.Id_inner);

								if (ic_port_exists == null && (fusion == null || !fusion.ContainsKey(port.localRef) || (fusion.ContainsKey(port.localRef) && fusion[port.localRef].Equals(c.localRef))))
                                    br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert(iNewPort);
								
								Console.WriteLine("loadInnerComponent - END PORT " + port.localRef);
                            }
                        }


						InnerComponent ic = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve (iNew.Id_abstract_owner, iNew.Id_inner);

						if (ic != null && includeAsInner.Contains (c)) 
						{
							Console.WriteLine ("loadInnerComponent - BLOCK 2 OPEN");
							br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.remove (iNew.Id_abstract_owner, iNew.Id_inner);
							br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert (iNew);
							Console.WriteLine ("loadInnerComponent - BLOCK 2 CLOSE");
						} 
						else if (ic == null) 
						{
							Console.WriteLine ("loadInnerComponent - BLOCK 3 OPEN");
							br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert (iNew);
							Console.WriteLine ("loadInnerComponent - BLOCK 3 CLOSE");
						}

                    }
                    
					Console.WriteLine("END loadInnerComponent : " + c.localRef + " :: " + c.package + "." + c.name);

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

        private void importInnerComponentsOfSuper(AbstractComponentFunctor absC, IList<InnerComponentType> includeAsInner)
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
				{
					Console.WriteLine ("Adding to parSuper - key="+sp.Id_parameter + ", value: " + sp.Id_functor_app + "/" + sp.Id_abstract + "/" + sp.Id_parameter);
					parsSuper.Add (sp.Id_parameter, sp);
				}

                IList<InnerComponent> iss = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.list(acfa.Id_abstract);
				Console.WriteLine ("importInnerComponentsOfSuper: " + iss.Count + " - acfa.Id_abstract=" + acfa.Id_abstract);
				foreach (InnerComponent i in iss) //if (!i.IsPublic)
                {
					Console.WriteLine ("[importInnerComponentsOfSupper 1: " + i.Id_inner + " , " + i.Id_functor_app + " , " + (i.Parameter_top));

                    InnerComponent iNew = new InnerComponent();
					if (i.Parameter_top != null && i.Parameter_top != "")
                    {
                        SupplyParameter sp = null; 
                        parsSuper.TryGetValue(i.Parameter_top, out sp);
						Console.WriteLine("importInnerComponentsOfSupper 2: " + i.Parameter_top + "," + i.Id_inner);

                        if (sp is SupplyParameterComponent)
                        {
							Console.WriteLine("importInnerComponentsOfSupper 3: " + "sp is SupplyParameterComponent");

                            // 1th CASE: It is not a parameter in the current component.
                            // NOT YET TESTED !!!
                            SupplyParameterComponent spc = (SupplyParameterComponent)sp;

                            AbstractComponentFunctorApplication acfaReplace = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(spc.Id_functor_app_actual);
							if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.retrieve (absC.Id_abstract, i.Id_inner) == null) 
							{
								iNew.Id_abstract_inner = acfaReplace.Id_abstract;
								iNew.Parameter_top = null;
								iNew.Id_abstract_owner = absC.Id_abstract;
								iNew.Id_functor_app = liftFunctorApp (acfaReplace.Id_functor_app, parsSuper);
								iNew.Id_inner = i.Id_inner;
								br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert (iNew);
							}
                        }
                        else if (sp is SupplyParameterParameter)
                        {
							Console.WriteLine("importInnerComponentsOfSupper 4: " + "sp is SupplyParameterParameter");
                            // 2nd CASE: It continues to be a parameter in the current component.
                            SupplyParameterParameter spp = (SupplyParameterParameter)sp;

                            String varName = null;
							foreach (ParameterRenaming pr in parameterRenamingSuper)
                            {
                                if (pr.formFieldId.Equals(i.Parameter_top))
                                {
                                    varName = pr.varName;
                                    ParameterType parameter = this.lookForParameterByVarName(varName);
                                    InnerComponentType cReplace = lookForInnerComponent(parameter.componentRef);
                                    //cReplace.localRef = i.Id_inner;
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
                                    includeAsInner.Add(cReplace);
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
						iNew.IsPublic = i.IsPublic;
                        br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.insert(iNew);
                    }
                }
            }
			Console.WriteLine("importInnerComponentsOfSuper : FINISH");
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
				SupplyParameter spNew = null;
				if (sp is SupplyParameterComponent)
				{
					SupplyParameterComponent spc = (SupplyParameterComponent)sp;
					SupplyParameterComponent spcNew = new SupplyParameterComponent();
					spNew = spcNew;
					spcNew.Id_functor_app = acfaNew.Id_functor_app;
					spcNew.Id_functor_app_actual = liftFunctorApp(spc.Id_functor_app_actual, parsSuper);
					spcNew.Id_abstract = spc.Id_abstract;
					spcNew.Id_parameter = spc.Id_parameter;
				}
				else if (sp is SupplyParameterParameter)
				{
					SupplyParameterParameter spp = (SupplyParameterParameter)sp;
					SupplyParameter spSuper = null;

					if (parsSuper.Count > 0)
					{
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
							SupplyParameterComponent spcNew = new SupplyParameterComponent();
							spNew = spcNew;
							Console.WriteLine("liftFunctorApp: 1" + (spNew == null));

							AbstractComponentFunctorApplication acfa_spcSuper = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(spcSuper.Id_functor_app_actual);

							spcNew.Id_functor_app = acfaNew.Id_functor_app;
							spcNew.Id_abstract = acfa_spcSuper.Id_abstract;
							spcNew.Id_parameter = spp.Id_parameter;
							spcNew.Id_functor_app_actual = spcSuper.Id_functor_app_actual;
							Console.WriteLine("liftFunctorApp: 2" + (spcNew == null));
						}
						else if (spSuper is SupplyParameterParameter)
						{
							SupplyParameterParameter sppSuper = (SupplyParameterParameter)spSuper;
							SupplyParameterParameter sppNew = new SupplyParameterParameter();
							spNew = sppNew;
							Console.WriteLine("liftFunctorApp: 3 " + (spNew == null) + " spp.Id_argument=" + spp.Id_argument + ", spp.Id_parameter=" + spp.Id_parameter);

							sppNew.Id_functor_app = acfaNew.Id_functor_app;
							sppNew.Id_abstract = spSuper.Id_abstract;
							sppNew.Id_parameter = spp.Id_parameter;
							sppNew.Id_argument = sppSuper.Id_argument;
							sppNew.FreeVariable = spp.FreeVariable;
							Console.WriteLine("liftFunctorApp: 4" + (sppNew == null));
						}
						else
						{
							Console.WriteLine("liftFunctorApp: 5 " + (spp.Id_argument));
						}
					}
					else
					{
						Console.WriteLine("liftFunctorApp: 5 ");
						SupplyParameterParameter sppSuper = (SupplyParameterParameter)spSuper;
						SupplyParameterParameter sppNew = new SupplyParameterParameter();
						spNew = sppNew;

						sppNew.Id_argument = spp.Id_argument;
						sppNew.FreeVariable = spp.FreeVariable;
						sppNew.Id_functor_app = acfaNew.Id_functor_app;
						sppNew.Id_abstract = acfaNew.Id_abstract;
						sppNew.Id_parameter = spp.Id_parameter;
						//sppNew.Id_parameter_actual = sppSuper.Id_parameter_actual;
						//sppNew.FreeVariable = spp.FreeVariable;
					}
				}
				br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.insert(spNew);
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
					p.Variance = parameter_.variance;

					if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.retrieve(p.Id_abstract, p.Id_parameter) == null)
						br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfpdao.insert(p);

                    pars.Add(p);
                }
			Console.WriteLine("loadAbstractComponentFunctorParameters : END");
            return pars;
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

					string uRefSuper = u.super == null || u.super.Length == 0 ? "" : u.super[0].uRef;
					if (u.super != null)
						for (int j=1; j<u.super.Length;j++) 
							uRefSuper += "+" + u.super[j].uRef;

                    InterfaceType ui = lookForInterface(iRef);
                    int nargs = ui.nArgsSpecified ? ui.nArgs : 0;

					Console.Error.WriteLine("STEP 5.3");
					
                    Interface i = new Interface();
                    i.Id_abstract = absC.Id_abstract;
                    i.Id_interface = uRef;
//					i.Unit_replica = unit_replica;
					i.Facet = u.facet;
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

					Console.Error.WriteLine("BEFORE STEP 5.5 " + (ui==null));
					Console.Error.WriteLine("STEP 5.5 --- " + (ui.sources[ui.sources.Length - 1].file==null));
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
								Console.WriteLine ("external reference = " + extRef);
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

					Console.Error.WriteLine("STEP 5.7 ---");
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

							Interface iii = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveTop(inner.Id_abstract_inner, uRefS);
                            Console.Error.WriteLine("STEP 5.9.5 ---" + (iii==null));							
							
							Slice s = new Slice();
                            s.Id_abstract = absC.Id_abstract;
							s.Id_inner = innerC.localRef;
							s.Id_interface_slice = iii == null ? uRefS : iii.Id_interface;
                            s.Id_interface = uRef;
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
									Interface iii2 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieveTop(inner2.Id_abstract_inner, usPort.uRef);

                                    SliceExposed se = new SliceExposed();
                                    se.Id_abstract = s.Id_abstract;
                                    se.Id_inner = innerCPort.localRef;
                                    se.Id_inner_owner = s.Id_inner;
                                    se.Id_interface_slice_owner = s.Id_interface_slice_top; // mudado de s.Id_interface_slice em 28/06/2011
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
							if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.sdao.retrieve (s.Id_abstract, s.Id_inner, s.Id_interface_slice, s.Id_interface) == null) 
							{
								br.ufc.pargo.hpe.backend.DGAC.BackEnd.sdao.insert (s);
								Console.WriteLine ("SLICE REGISTERED " + s.Id_abstract + "/" + s.Id_inner + "/" + s.Id_interface_slice + " --- " + s.Id_interface);
							}
							else
								Console.WriteLine ("SLICE NOT REGISTERED " + s.Id_abstract + "/" + s.Id_inner + "/" + s.Id_interface_slice + " --- " + s.Id_interface);
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
//			action_row.PartitionIndex = i.Unit_replica;
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
//			action_row.PartitionIndex = i.Unit_replica;
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
                //string urefSuper = u.super == null ? null : u.super.uRef;

             //   InterfaceDAO idao = new InterfaceDAO();
                Interface i = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve(id_abstract, uref);
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
    }
}
