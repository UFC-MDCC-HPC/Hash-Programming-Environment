using System;
using System.Collections.Generic;
using System.Text;
using br.ufc.pargo.hpe.backend.DGAC.database;
using br.ufc.hpe.backend.DGAC;
using System.CodeDom;
using br.ufc.pargo.hpe.backend.DGAC.utils;

namespace HPE_DGAC_LoadDB
{
   class LoaderConcreteComponent : LoaderComponent
    {

       Component cConc = null;

       ComponentType xc;

       public override bool componentExists(string hash_component_uid, out HashComponent cRef)
       {
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
            return cConc;
        }

       private AbstractComponentFunctor lookForAbstractComponentFunctorOfConcreteComponent(Component cConc)
       {
           AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(cConc.Id_functor_app);
           
           AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(acfa.Id_abstract);
           return acf;
       }

        protected override HashComponent loadComponent_(ComponentType c)
        {
            // CREATE Component

            ComponentInUseType baseC = null;
            
            baseC = c.header.baseType.component;
            
            // FOLLOW arrow implements
            IList<AbstractComponentFunctorApplication> cAppList = newAbstractComponentFunctorApplicationForImplements(baseC);
            if (cAppList == null || cAppList.Count == 0)
            {
                throw new Exception("DEPLOY ERROR: Unresolved Dependency for base component (implements) : " + c.header.baseType.component.name);
            }
			
			Component c_first = null;
			foreach (AbstractComponentFunctorApplication cApp in cAppList)
			{   
	            Component c_ = new Component();
				if (c_first==null) c_first = c_;
	            c_.Id_concrete = Connector.nextKey("id_concrete", "component");
	            c_.Hash_component_UID = c.header.hash_component_UID;
	            c_.Library_path = c.header.packagePath + "." + c.header.name; 
	            c_.Id_functor_app = cApp.Id_functor_app;               					
					
	            br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.insert(c_);
				
	            loadUnits(c_);
//                loadInners(c_);

			}

            return c_first;
        }

       private Component lookForHashComponent(string hash_component_UID)
       {
           Component c = br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieve_uid(hash_component_UID);
           return c;
       }



       private IDictionary<string, Unit> loadUnits(Component c)
        {
            IDictionary<string, Unit> units = new Dictionary<string, Unit>();
			
			AbstractComponentFunctorApplication absCapp_ = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(c.Id_functor_app);
            AbstractComponentFunctorApplication absCapp = null;
			while (absCapp_ != null) {
			   absCapp = absCapp_;	
			   absCapp_ = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve_next(absCapp_.Id_functor_app);
			}
			
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
				if (ui.sources == null && ui.protocol != null && (c.Kind.Equals(Constants.KIND_COMPUTATION_NAME) 
				                                               || c.Kind.Equals(Constants.KIND_SYNCHRONIZER_NAME)))
				{
					 IWrapperGenerator wg = new WrapperGenerator();
					 string[] dependencies = null;
					 CodeCompileUnit compile_unit = wg.create_wrapper(uu.Id_abstract, uu.Id_interface, uu.Partition_index, out dependencies); 
					 string source_code = wg.generate_source_code(compile_unit);
					
				     SourceCode ss = new SourceCode();
                     ss.Type_owner = 'u';
                     ss.Id_owner_container = uu.Id_concrete;
                     ss.Id_owner = uu.Id_unit;
                     ss.Contents = source_code;
                     ss.File_type= "dll";
                     ss.File_name = ui.iRef + ".cs" ;
                     ss.Order = 0;
                     br.ufc.pargo.hpe.backend.DGAC.BackEnd.scdao.insert(ss);
				}
				else if (ui.sources != null)
				{
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
				} 
				else 
				{
					throw new Exception("Unit " + uu.Id_unit + " neither has a source code nor is a connector.");
				}

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
