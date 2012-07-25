using System;
using System.Collections.Generic;
using System.Text;
using br.ufc.pargo.hpe.backend.DGAC.database;

namespace HPE_DGAC_LoadDB
{
   class LoaderConcreteComponent : LoaderComponent
    {

       Component cConc = null;

       ComponentType xc;

       public override bool componentExists(string hash_component_uid, out HashComponent cRef)
       {
       //    ComponentDAO cdao = new ComponentDAO();
           Component concC = br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieve_uid(hash_component_uid);
           if (concC == null)
           {
               cRef = null;
               return false;
           }
           else
           {
               cRef = concC;
               return true;
           }

       }

       
       
       /* The parameter fileName points to the location of a concrete component.
        */
        public new HashComponent loadComponent(ComponentType c)
        {
            this.xc = c;
            cConc = (Component) base.loadComponent(c);
            prepareForEnumeration(cConc);
            // unfoldEnumerators(cConc); //This is now done dynamically. 
            return cConc;
        }

  /*

       private void unfoldEnumerators(Component cConc)
       {
           AbstractComponentFunctor acf = lookForAbstractComponentFunctorOfConcreteComponent(cConc);
           int id_abstract = acf.Id_abstract;

           EnumeratorDAO edao = new EnumeratorDAO();
           
           // List all enumerators od the abstract component.
           IList<Enumerator> enumerators = edao.list(id_abstract);

           foreach (Enumerator e in enumerators)
           {
               if (!e.From_split)
                   runEnumerator(cConc.Id_concrete, e);
           }

       }

       IDictionary<string, IList<EnumerationInterface>> efs = new Dictionary<string,IList<EnumerationInterface>>();
       IDictionary<string, IList<EnumerationSlice>> ess = new Dictionary<string,IList<EnumerationSlice>>();
       IDictionary<string, IList<EnumerationInner>> ens = new Dictionary<string,IList<EnumerationInner>>();
       IDictionary<string, IList<EnumeratorSplit>> esplit = new Dictionary<string,IList<EnumeratorSplit>>();

       private void runEnumerator(int id_concrete, Enumerator e)
       {
           //int id_abstract = e.Id_abstract;

           EnumeratorValuation ev = loadValuation(id_concrete, e);

           int rangeInf = ev.Range_inf;
           int rangeSup = ev.Range_sup;

           for (int i = rangeInf; i <= rangeSup+1 && i!=-1; i = i < rangeSup ? i+1 : -2)           
               enterEnumerator(e, i);             
           
       }

       private EnumeratorValuation loadValuation(int id_concrete, Enumerator e)
       {
           EnumeratorValuation ev = new EnumeratorValuation(); 

           if (enumerator != null)
           {
               foreach (EnumeratorType ex in enumerator)
               {
                   string id_enumerator = buildEnumeratorId(ex.originRef, ex.@ref);

                   if (id_enumerator.Equals(ex.originRef[0] + "." + e.Id_enumerator))
                   {
                       ev.Id_concrete = id_concrete;
                       ev.Id_enumerator = e.Id_enumerator;
                       ev.Range_inf = 0;
                       ev.Range_sup = ex.cardinality-1;

                       EnumeratorValuationDAO evdao = new EnumeratorValuationDAO();
                       evdao.insert(ev);

                       return ev;
                   }
               }


           }
           return null;
       }

       private void enterEnumerator(Enumerator e, int i)
       {
           int id_abstract = e.Id_abstract;

           // Touch all enumerated inner components
           if (!ens.ContainsKey(e.Id_enumerator))
           {
               EnumerationInnerDAO endao = new EnumerationInnerDAO();
               ens.Add(e.Id_enumerator, endao.list(id_abstract, e.Id_enumerator));
           }

           IList<EnumerationInner> ens_ = null;
           ens.TryGetValue(e.Id_enumerator, out ens_);
           foreach (EnumerationInner en in ens_)
               setEnumeratorToInner(e,i,en,id_abstract);
           
           
           // Touch all enumerated slices
           if (!ess.ContainsKey(e.Id_enumerator))
           {
               EnumerationSliceDAO esdao = new EnumerationSliceDAO();
               ess.Add(e.Id_enumerator, esdao.listByEnumerator(id_abstract, e.Id_enumerator));
           }

           IList<EnumerationSlice> ess_ = null;
           ess.TryGetValue(e.Id_enumerator, out ess_);
           foreach (EnumerationSlice es in ess_)
               setEnumeratorToSlice(e, i, es);

           // Touch all enumerated units
           if (!efs.ContainsKey(e.Id_enumerator))
           {
               EnumerationInterfaceDAO efdao = new EnumerationInterfaceDAO();
               efs.Add(e.Id_enumerator, efdao.list(id_abstract, e.Id_enumerator));
           }
           IList<EnumerationInterface> efs_ = null;
           efs.TryGetValue(e.Id_enumerator, out efs_);
           foreach (EnumerationInterface ef in efs_)
               setEnumeratorToUnit(e, i, ef);           
           
           // Touch all splits
           if (!esplit.ContainsKey(e.Id_enumerator))
           {
               EnumeratorSplitDAO esplitdao = new EnumeratorSplitDAO();
               esplit.Add(e.Id_enumerator, esplitdao.listall(id_abstract, e.Id_enumerator));
           }
           int id_split = -1;

           IList<EnumeratorSplit> esplit_ = null;
           esplit.TryGetValue(e.Id_enumerator, out esplit_);
           foreach (EnumeratorSplit es in esplit_)
           {
               if (id_split != es.Id_split)
               {
                   id_split = es.Id_split;
               }

               int enter = i;
               if (i>=0)
                  enter = tryEnter(e, i, es);

               if (enter >= 0 || i<0)
               {
                   EnumeratorDAO edao = new EnumeratorDAO();
                   Enumerator ee = edao.retrieve(es.Id_abstract, es.Id_enumerator_split);
                   enterEnumerator(ee, enter);
               }
           }
       }

       private void setEnumeratorToUnit(Enumerator e, int i, EnumerationInterface ef)
       {
           string id_unit = ef.Id_interface;

           EnumerationItemUnitDAO eiudao = new EnumerationItemUnitDAO();
           UnitDAO udao = new UnitDAO();

           IList<EnumerationItemUnit> eius = null;
           eiudao.listOpenEnumerations(cConc.Id_concrete, id_unit, e.Id_enumerator, out eius);

           foreach (EnumerationItemUnit eiu in eius)
           {
               if (i >= 0)
               {
                   int fresh_index = udao.getNextFreshIndex(eiu.Id_concrete, eiu.Id_unit);

                   Unit u = udao.retrieve(eiu.Id_concrete, eiu.Id_unit, eiu.Id_index);

                   Unit uNew = new Unit();
                   uNew.Id_concrete = u.Id_concrete;
                   uNew.Id_index = fresh_index; // NEW INDEX !!!
                   uNew.Id_interface_abstract = u.Id_interface_abstract;
                   uNew.Id_interface_interface = u.Id_interface_interface;
                   uNew.Id_unit = u.Id_unit;
                   uNew.Id_unit_super = u.Id_unit_super;
                   uNew.Class_name = u.Class_name;
                   uNew.Class_nargs = u.Class_nargs; // TODO
                   uNew.Assembly_string = u.Assembly_string;
                   uNew.URI_Source = u.URI_Source;

                   udao.insert(uNew);

                   // FOR ALL EXISTING ENUMERATIONS, CREATING CORRESPONDING ONES !!!!
                   IList<EnumerationItemUnit> eiu2s = eiudao.list(cConc.Id_concrete, id_unit, u.Id_index);
                   EnumerationItemUnit eiuNew = new EnumerationItemUnit();
                   foreach (EnumerationItemUnit eiu2 in eiu2s)
                   {
                       if (!eiu2.Id_enumerator.Equals(e.Id_enumerator))
                       {
                           eiuNew.Id_concrete = eiu2.Id_concrete;
                           eiuNew.Id_enumerator = eiu2.Id_enumerator;
                           eiuNew.Id_index = fresh_index; // NEW INDEX !
                           eiuNew.Id_unit = eiu2.Id_unit;
                           eiuNew.Value = eiu2.Value;
                       }
                       else
                       {
                           eiuNew.Id_concrete = eiu.Id_concrete;
                           eiuNew.Id_enumerator = eiu.Id_enumerator;
                           eiuNew.Id_index = fresh_index; // NEW INDEX !
                           eiuNew.Id_unit = eiu.Id_unit;
                           eiuNew.Value = i;
                       }
                       eiudao.insert(eiuNew);
                   }

                   UnitSliceDAO usdao = new UnitSliceDAO();
                   IList<UnitSlice> uss = usdao.listByUnit(cConc.Id_concrete, id_unit, -1);
                   foreach (UnitSlice us in uss)
                   {
                       EnumerationItemUnitSliceDAO eiusdao = new EnumerationItemUnitSliceDAO();
                       EnumerationItemConcreteInnerDAO eicidao = new EnumerationItemConcreteInnerDAO();
                       EnumerationItem ei = null;

                       // One of the conditions below is true ...

                       // Check if the unit slice is enumerated by e
                       ei = eiusdao.retrieve(us.Id_concrete, 
                                             us.Id_inner, 
                                             us.Id_index_inner, 
                                             us.Id_unit_slice, 
                                             us.Split_replica,
                                             us.Id_index, 
                                             e.Id_enumerator);

                       // Check if the component where the unit slice is placed on is enumerated by e
                       if (ei == null)
                       {
                           ei = eicidao.retrieve(us.Id_concrete,
                                                 us.Id_inner,
                                                 us.Id_index_inner,
                                                 e.Id_enumerator);
                       }

                       // The value of the enumerator must match the current value
                       if (ei != null && ei.Value == i)
                       {
                           us.Id_index_unit = fresh_index;
                           usdao.consolidateIdUnit(us);
                       }
                   }

               }
               else
               {
                   // APAGAR UNSET ENUMERATION INDEXES ...
                   eiudao.removeOpenEnumerations(cConc.Id_concrete, id_unit, e.Id_enumerator);
               }
           }

       }

       private void setEnumeratorToInner(Enumerator e, int i, EnumerationInner en, int id_abstract)
       {
           string id_inner = en.Id_inner;

           EnumerationItemConcreteInnerDAO eicidao = new EnumerationItemConcreteInnerDAO();
           InnerConcreteComponentDAO iccdao = new InnerConcreteComponentDAO();

           IList<EnumerationItemConcreteInner> eicis = null;
           eicidao.listOpenEnumerations(cConc.Id_concrete, id_inner, e.Id_enumerator, out eicis);

           foreach (EnumerationItemConcreteInner eici in eicis)
           {
               if (i >= 0)
               {
                   int fresh_index = iccdao.getNextFreshIndex(eici.Id_concrete, eici.Id_inner); // ??????????????

                   InnerConcreteComponent icc = iccdao.retrieve(eici.Id_concrete, eici.Id_inner, eici.Id_index);

                   InnerConcreteComponent iccNew = new InnerConcreteComponent();
                   iccNew.Id_concrete = icc.Id_concrete;
                   iccNew.Id_inner = icc.Id_inner;
                   iccNew.Id_index = fresh_index; // NEW_INDEX

                   iccdao.insert(iccNew);

                   // FOR ALL EXISTING ENUMERATIONS, CREATING CORRESPONDING ONES !!!!
                   IList<EnumerationItemConcreteInner> eici2s = eicidao.list(cConc.Id_concrete, id_inner, icc.Id_index);
                   EnumerationItemConcreteInner eiciNew = new EnumerationItemConcreteInner(); 
                   foreach (EnumerationItemConcreteInner eici2 in eici2s)
                   {
                       if (!eici2.Id_enumerator.Equals(e.Id_enumerator))
                       {
                           eiciNew.Id_concrete = eici2.Id_concrete;
                           eiciNew.Id_inner = eici2.Id_inner;
                           eiciNew.Id_index = fresh_index; // NEW_INDEX
                           eiciNew.Id_enumerator = eici2.Id_enumerator;
                           eiciNew.Value = eici2.Value;
                       }
                       else
                       {
                           // CURRENT ENUMERATOR ...
                           eiciNew.Id_concrete = eici.Id_concrete;
                           eiciNew.Id_inner = eici.Id_inner;
                           eiciNew.Id_index = fresh_index; // NEW_INDEX
                           eiciNew.Id_enumerator = e.Id_enumerator;
                           eiciNew.Value = i;
                       }

                       eicidao.insert(eiciNew);
                   }


                   UnitSliceDAO usdao = new UnitSliceDAO();
                   IList<UnitSlice> uss = usdao.list(icc.Id_concrete, id_inner, icc.Id_index);
                   foreach (UnitSlice us in uss)
                   {
                       UnitSlice newUs = new UnitSlice();
                       newUs.Id_concrete = us.Id_concrete;
                       newUs.Id_inner = us.Id_inner;
                       newUs.Id_index_inner = fresh_index; // NEW_INDEX
                       newUs.Id_unit_slice = us.Id_unit_slice;
                       newUs.Split_replica = us.Split_replica;
                       newUs.Id_index = us.Id_index;
                       newUs.Id_unit = us.Id_unit;
                       newUs.Id_index_unit = us.Id_index_unit ; 

                       usdao.insert(newUs);
                   }                    
               }
               else
               {
                   // APAGAR UNSET ENUMERATION INDEXES ...
                   eicidao.removeOpenEnumerations(cConc.Id_concrete, id_inner, e.Id_enumerator);
               }
           }
       }

       private void setEnumeratorToSlice(Enumerator e, int i, EnumerationSlice es)
       {
           string id_inner = es.Id_inner;
           string id_unit_slice = es.Id_interface_slice;
           int split_replica = es.Id_split_replica;

           EnumerationItemUnitSliceDAO eiusdao = new EnumerationItemUnitSliceDAO();
           UnitSliceDAO usdao = new UnitSliceDAO();

           IList<EnumerationItemUnitSlice> eiuss = null;
           eiusdao.listOpenEnumerations(cConc.Id_concrete, id_inner, id_unit_slice, split_replica, e.Id_enumerator, out eiuss);

           foreach (EnumerationItemUnitSlice eius in eiuss)
           {
               if (i >= 0)
               {
                   int fresh_index = usdao.getNextFreshIndex(eius.Id_concrete, eius.Id_inner, eius.Index_inner, eius.Id_interface_slice, eius.Split_replica);

                   UnitSlice us = usdao.retrieve(eius.Id_concrete, eius.Id_inner, eius.Index_inner, eius.Id_interface_slice,eius.Split_replica, eius.Id_index);

                   UnitSlice usNew = new UnitSlice();
                   usNew.Id_concrete = us.Id_concrete;
                   usNew.Id_inner = us.Id_inner;
                   usNew.Id_index_inner = us.Id_index_inner; // ok
                   usNew.Id_unit_slice = us.Id_unit_slice;
                   usNew.Split_replica = us.Split_replica;
                   usNew.Id_unit = us.Id_unit;
                   usNew.Id_index_unit = us.Id_index_unit;   // ??????
                   usNew.Id_index = fresh_index;


                   // FOR ALL EXISTING ENUMERATIONS, CREATING CORRESPONDING ONES !!!!
                   IList<EnumerationItemUnitSlice> eius2s = eiusdao.list(cConc.Id_concrete, id_inner, id_unit_slice, split_replica, us.Id_index);
                   EnumerationItemUnitSlice eiusNew = new EnumerationItemUnitSlice();
                   foreach (EnumerationItemUnitSlice eius2 in eius2s)
                   {
                       if (!eius2.Id_enumerator.Equals(e.Id_enumerator))
                       {
                           eiusNew.Id_concrete = eius2.Id_concrete;
                           eiusNew.Id_inner = eius2.Id_inner;
                           eiusNew.Index_inner = eius2.Index_inner;
                           eiusNew.Id_interface_slice = eius2.Id_interface_slice;
                           eiusNew.Split_replica = eius2.Split_replica;
                           eiusNew.Id_index = fresh_index;
                           eiusNew.Id_enumerator = eius2.Id_enumerator;
                           eiusNew.Value = eius2.Value;
                       }
                       else
                       {
                           eiusNew.Id_concrete = eius.Id_concrete;
                           eiusNew.Id_inner = eius.Id_inner;
                           eiusNew.Index_inner = eius2.Index_inner;
                           eiusNew.Id_interface_slice = eius.Id_interface_slice;
                           eiusNew.Split_replica = eius2.Split_replica;
                           eiusNew.Id_index = fresh_index;
                           eiusNew.Id_enumerator = eius2.Id_enumerator;
                           eiusNew.Value = i; // TODO: REORDER IS APPLIED HERE !!!
                       }
                   }

                   usdao.insert(usNew);
                   eiusdao.insert(eiusNew);
               }
               else
               {
                   // APAGAR UNSET ENUMERATION INDEXES ...
                   eiusdao.removeOpenEnumerations(cConc.Id_concrete, id_inner, id_unit_slice, split_replica, e.Id_enumerator);

               }
           }

       }

       private int tryEnter(Enumerator e, int i, EnumeratorSplit split)
       {
           int k = split.Id_total_split == 0 ? split.Id_total_split : i % split.Id_total_split;

           if (k == split.Id_split-1)
           {
               return i / split.Id_total_split;
           }
           else
           {
               return -1;
           }

       }
*/
       private AbstractComponentFunctor lookForAbstractComponentFunctorOfConcreteComponent(Component cConc)
       {
         //  AbstractComponentFunctorApplicationDAO acfadao = new AbstractComponentFunctorApplicationDAO();
           AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(cConc.Id_functor_app);
           
         //  AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
           AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(acfa.Id_abstract);
           return acf;
       }

        protected override HashComponent loadComponent_(ComponentType c)
        {
            // CREATE Component

            Component c_ = new Component();
            c_.Id_concrete = Connector.nextKey("id_concrete", "component");
            c_.Hash_component_UID = c.header.hash_component_UID;
            c_.Library_path = c.header.packagePath + "." + c.header.name; 
            
            ExtensionTypeType extType = c.header.baseType.extensionType;
            ComponentInUseType baseC = null;
            
            if (extType.ItemElementName == ItemChoiceType.implements && extType.Item) 
            {
                baseC = c.header.baseType.component;
                
                // FOLLOW arrow implements
                AbstractComponentFunctorApplication cApp = newAbstractComponentFunctorApplication(baseC);
                if (cApp == null)
                {
                    throw new Exception("DEPLOY ERROR: Unresolved Dependency for base component (implements) : " + c.header.baseType.component.name);
                }
                
                // FOLLOW arrow functor-app-of
                // Make implements points to it ...
                c_.Id_functor_app = cApp.Id_functor_app;                    
            } 
            else if (extType.ItemElementName == ItemChoiceType.extends && extType.Item) 
            {
                baseC = c.header.baseType.component;

                // FOLLOW arrow extends
                Component superC = lookForHashComponent(baseC.hash_component_UID);

                c_.Id_concrete_supertype = superC.Id_concrete;
            } 
            else 
            {
                // ERROR
                // It neither implements some abstract component nor is a subtype of 
                // another one that implements some abstract component.
                
            }

            br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.insert(c_);

            return c_;
        }

       private Component lookForHashComponent(string hash_component_UID)
       {
           Component c = br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieve_uid(hash_component_UID);
           return c;
       }


       private void prepareForEnumeration(Component cConc)
       {
           // CREATE INITIAL CONCRETE INNERS, UNIT SLICES AND UNITS ...
           loadUnits(cConc);
           loadInners(cConc);
       }

       private void loadInners(Component cConc)
       {
           AbstractComponentFunctorApplication absCapp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(cConc.Id_functor_app);

           int id_abstract = absCapp.Id_abstract;

           IList<InnerComponent> cs = br.ufc.pargo.hpe.backend.DGAC.BackEnd.icdao.list(id_abstract);

           foreach (InnerComponent c in cs)
           {
               InnerConcreteComponent icc = new InnerConcreteComponent();
               icc.Id_concrete = cConc.Id_concrete;
               icc.Id_inner = c.Id_inner;
               icc.Id_index = -1;

 /*              EnumerationItemConcreteInnerDAO eicidao = new EnumerationItemConcreteInnerDAO();
               EnumerationInnerDAO eidao = new EnumerationInnerDAO();
               IList<EnumerationInner> eics = eidao.listByInner(id_abstract, c.Id_inner);
               foreach (EnumerationInner eic in eics)
               {
                   EnumerationItemConcreteInner eici = new EnumerationItemConcreteInner();
                   eici.Id_concrete = cConc.Id_concrete;
                   eici.Id_inner = eic.Id_inner;
                   eici.Id_index = icc.Id_index = 1;
                   eici.Id_enumerator = eic.Id_enumerator;
                   eici.Value = -1;

                   eicidao.insert(eici);
               }
               */

               br.ufc.pargo.hpe.backend.DGAC.BackEnd.iccdao.insert(icc);

            /*   IList<Slice> ss = br.ufc.pargo.hpe.backend.DGAC.BackEnd.sdao.listByInner(id_abstract, c.Id_inner);
               foreach (Slice s in ss) 
               {
                   UnitSlice us = new UnitSlice();
                   us.Id_concrete = cConc.Id_concrete;
                   us.Id_inner = s.Id_inner;
                   us.Id_index_inner = icc.Id_index;
                   us.Id_unit_slice = s.Id_interface_slice;
                   us.Split_replica = s.Id_split_replica;
                   us.Id_index = -1;
                   us.Id_unit = s.Id_interface;
                   us.Id_index_unit = -1;
				 

                                      EnumerationItemUnitSliceDAO eiusdao = new EnumerationItemUnitSliceDAO();
                                      EnumerationSliceDAO esdao = new EnumerationSliceDAO();
                                      IList<EnumerationSlice> ess = esdao.list(id_abstract, icc.Id_inner, us.Id_unit_slice, us.Split_replica);
                                      foreach (EnumerationSlice es in ess)
                                      {
                                          EnumerationItemUnitSlice eiu = new EnumerationItemUnitSlice();

                                          eiu.Id_concrete = cConc.Id_concrete;
                                          eiu.Id_inner = c.Id_inner;
                                          eiu.Index_inner = us.Id_index_inner;
                                          eiu.Id_index = us.Id_index = 1;
                                          eiu.Id_interface_slice = us.Id_unit_slice;
                                          eiu.Split_replica = us.Split_replica;
                                          eiu.Id_enumerator = es.Id_enumerator;
                                          eiu.Value = -1;

                                          eiusdao.insert(eiu);
                                      }
                   
                   br.ufc.pargo.hpe.backend.DGAC.BackEnd.usdao.insert(us);
               }*/
           }
       }

       private IDictionary<string, Unit> loadUnits(Component c)
        {
            IDictionary<string, Unit> units = new Dictionary<string, Unit>();

            AbstractComponentFunctorApplication absCapp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(c.Id_functor_app);

            int id_abstract = absCapp.Id_abstract;

            // for each unit ...
            foreach (UnitType u in unit)
            {
                string uref = u.uRef;
                string iRef = u.iRef;
                string urefSuper = u.super == null ? null : u.super.uRef;
				int partition_index = u.replicaSpecified ? u.replica : 0;

                Interface i = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve(id_abstract, uref, partition_index);
                InterfaceType ui = lookForInterface(iRef);

                Unit uu = new Unit();
                uu.Id_concrete = c.Id_concrete;
                uu.Id_unit = uref;
                uu.Id_abstract = id_abstract;
                uu.Id_interface = uref;
                uu.Id_unit_super = urefSuper;
                uu.Partition_index = partition_index;
                uu.Class_name = xc.header.packagePath + "." + xc.header.name + "." + iRef;
                uu.Class_nargs = i.Class_nargs;
                uu.Assembly_string = uu.Class_name + ", Culture=neutral, Version=0.0.0.0"; // In the current implementation, the name of the dll is the name of the class of the unit.
                uu.Order = i.Order;

                units.Add(uu.Id_unit, uu);

                int order = 0;
                foreach (SourceFileType sft in ui.sources[ui.sources.Length - 1].file) 
                {
                     SourceCode ss = new SourceCode();
                     ss.Type_owner = 'u';
                     ss.Id_owner_container = uu.Id_concrete;
                     ss.Id_owner = uu.Id_unit;
                     ss.Contents = sft.contents;
                     ss.File_type= sft.fileType.Equals("exe") ? "exe" : "dll";
                     ss.File_name = sft.name ;
                     ss.Order = order++;
                     br.ufc.pargo.hpe.backend.DGAC.BackEnd.scdao.insert(ss);

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
                             if (br.ufc.pargo.hpe.backend.DGAC.BackEnd.scrdao.retrieve(ssr) == null)
                             {
                                 br.ufc.pargo.hpe.backend.DGAC.BackEnd.scrdao.insert(ssr);
							 }
                         }
                     }

                }
/*                
                EnumerationInterfaceDAO eidao = new EnumerationInterfaceDAO();
                EnumerationItemUnitDAO eiudao = new EnumerationItemUnitDAO();
                IList<EnumerationInterface> eis = eidao.listByInterface(id_abstract, uref);
                foreach (EnumerationInterface ei in eis)
                {                     
                    EnumerationItemUnit eiu = new EnumerationItemUnit();
                    eiu.Id_concrete = c.Id_concrete;
                    eiu.Id_unit = uref;
                    eiu.Id_index = uu.Id_index = 1;
                    eiu.Id_enumerator = ei.Id_enumerator;
                    eiu.Value = -1;

                    eiudao.insert(eiu);
                }
*/                
                UnitDAO udao = new UnitDAO();
                udao.insert(uu);
            }

            return units;
        }



       internal void updateSources(ComponentType ct, Component c)
       {

           LoadBodyItems(ct.componentInfo);

           IDictionary<string, Unit> units = new Dictionary<string, Unit>();

           AbstractComponentFunctorApplication absCapp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(c.Id_functor_app);

            int id_abstract = absCapp.Id_abstract;

           // for each unit ...
           foreach (UnitType u in unit)
           {
               string uref = u.uRef;
               string iRef = u.iRef;
               string urefSuper = u.super == null ? null : u.super.uRef;
			   int partition_index =  u.replicaSpecified ? u.replica : 0;

               Interface i = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve(id_abstract, uref, partition_index);
               InterfaceType ui = lookForInterface(iRef);

               foreach (SourceFileType sft in ui.sources[ui.sources.Length - 1].file)
               {
                   SourceCode ss = new SourceCode();
                   ss.Type_owner = 'u';
                   ss.Id_owner_container = c.Id_concrete;
                   ss.Id_owner = uref;
                   ss.Contents = sft.contents;
                   ss.File_type = sft.fileType.Equals("exe") ? "exe" : "dll";
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
