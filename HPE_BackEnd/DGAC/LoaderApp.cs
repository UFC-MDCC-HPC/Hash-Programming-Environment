using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Xml;
using System.Xml.Serialization;
using DGAC.database;
using DGAC.utils;
using hpe.basic;

namespace DGAC.database
{
    public class LoaderApp
    {



        public static ComponentType DeserializeObject(string filename)
        {
            Console.WriteLine("Reading with XmlReader");

            // Create an instance of the XmlSerializer specifying type and namespace.
            XmlSerializer serializer = new XmlSerializer(typeof(ComponentType));

            // A FileStream is needed to read the XML document.
            FileStream fs = new FileStream(filename, FileMode.Open);
        
            XmlReader reader = new XmlTextReader(fs);


            // Declare an object variable of the type to be deserialized.
            ComponentType i;

            // Use the Deserialize method to restore the object's state.
            i = (ComponentType)serializer.Deserialize(reader);

            fs.Close();

            return i;

        }

        public static byte[] SerializeObject(string filename, EnvironmentType env)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(EnvironmentType));

            FileStream fs = new FileStream(filename, FileMode.Create);

            XmlWriter writer = new XmlTextWriter(fs, null);

            serializer.Serialize(writer, env);


            BinaryReader br = new BinaryReader(fs);
            int count = (int)fs.Length;
            fs.Position = 0;

            byte[] data = br.ReadBytes(count);
            br.Close();
            fs.Close();

            return data;
        }
    

	//receives id_concrete and id inner wich belongs for that inner
	//returns a impl of the inner
	//return -1 if the impl doesnt exist

	public static Unit resolveImpl(IUnit unit, int id_concrete, string id_inner, string id_interface){
	
		//local daos
		ComponentDAO componentDAO = new ComponentDAO();
		Component component = componentDAO.retrieve(id_concrete);
		AbstractComponentFunctorApplicationDAO acfaDAO = new AbstractComponentFunctorApplicationDAO();		
		AbstractComponentFunctorDAO acfDAO = new AbstractComponentFunctorDAO();		
		SupplyParameterDAO spDAO = new SupplyParameterDAO();
		InnerComponentDAO icDAO = new InnerComponentDAO();				 
		SupplyParameterParameterDAO supplyParameterParameterDAO = new SupplyParameterParameterDAO();
		SupplyParameterComponentDAO supplyParameterComponentDAO = new SupplyParameterComponentDAO();
	
		//get abstract component from received component for walking through its inner components
		AbstractComponentFunctorApplication acfa = acfaDAO.retrieve(component.Id_functor_app);
		
		//INIT 
		if(acfa!=null){
			
			//get functor
			AbstractComponentFunctor acf = acfDAO.retrieve(acfa.Id_abstract);			
			
			if(acf!=null){
					
				// analysing the inner component
				InnerComponent innerComponent = icDAO.retrieve(acf.Id_abstract, id_inner);

                int Id_functor_app_inner = -1;
                if (innerComponent.Parameter_top.Length == 0)
                {
                    Id_functor_app_inner = innerComponent.Id_functor_app;
                }
                else
                {
                    bool achei = unit.ActualParameters.TryGetValue(innerComponent.Parameter_top, out Id_functor_app_inner);
                    if (!achei)
                    {
                        achei = unit.ActualParameters.TryGetValue(innerComponent.Parameter_top + "#" + unit.Id_functor_app, out Id_functor_app_inner);
                    }

                    if (!achei)
                    {
                        Console.WriteLine("UNEXPECTED ERROR: " + innerComponent.Parameter_top + "#" + unit.Id_functor_app + " NOT FOUND !!! (In: resolveImpl - LoaderApp.cs)");
                    }
                }                                   

				AbstractComponentFunctorApplication acfaRef = acfaDAO.retrieve(Id_functor_app_inner);
				
				// get inner component application
                if (acfaRef != null)
                {
                    IList<SupplyParameter> supplyParameters = spDAO.list(acfaRef.Id_functor_app);

                    foreach (SupplyParameter supplyParameter in supplyParameters)
                    {

                        //if exist a supplied parameter, then check if it is suppllie for a component
                        SupplyParameterComponent spc = supplyParameterComponentDAO.retrieve(supplyParameter.Id_parameter,
                                                                                            supplyParameter.Id_functor_app);

                        if (spc != null)
                        {
                            acfaRef.addParameter(spc.Id_parameter, spc.Id_functor_app_actual);
                        }
                        else
                        {
                            SupplyParameterParameter spp = supplyParameterParameterDAO.retrieve(supplyParameter.Id_parameter,
                                                                                                supplyParameter.Id_functor_app);
                            if (spp != null)
                            {

                                int id_functor_app_actual_top;
                                unit.ActualParameters.TryGetValue(spp.Id_parameter_actual, out id_functor_app_actual_top);
                                if (id_functor_app_actual_top == 0)
                                {
                                    unit.ActualParametersTop.TryGetValue(spp.Id_parameter_actual, out id_functor_app_actual_top);
                                }
                                acfaRef.addParameter(spp.Id_parameter, id_functor_app_actual_top);

                            } // else NOT EXPECTED !!! A parameter is either a supplied component or an enclosing parameter.

                        }//else

                    }//for each SupplyParameter

                }
                else //acfaRef!=null  // ELSE UNEXPECTED: An inner component withour a functor application.
                {
                    Console.Out.WriteLine("UNEXPECTED ERROR: Inner component without functor application (id_functor_app_inner = " + Id_functor_app_inner + ")");
                }					 
					
                // AT THIS POINT, the FUNCTOR OF THE INNER COMPONENT, WITH PARAMETERS SUPPLIED, 
				//    HAVE BEEN DISCOVERED. Now, it is necessary to apply the procedure getHashComponent
				//    descrito no artigo.				
				
				Component componentRef = Resolution.findHashComponent(unit,acfaRef);

                if (componentRef==null) {
                    Console.WriteLine("componentRef NULL ! acfaRef = " + Id_functor_app_inner);
                    return null;
                } 

                string id_unit = null; // componentRef.getIdUnit(id_interface);

                

                UnitDAO udao = new UnitDAO();
                InterfaceDAO idao = new InterfaceDAO();

                Interface i2 = idao.retrieve(innerComponent.Id_abstract_inner, id_interface);

                foreach (Interface i in idao.list(componentRef.Id_abstract)) {
                    if (i.Id_interface_super_top.Equals(i2.Id_interface_super_top)) {
                        id_unit = i.Id_interface;
                    }
                }

                Unit u = udao.retrieve(componentRef.Id_concrete, id_unit, 1);
                if (u == null)
                {
                    Console.WriteLine("u is NULL ! acfaRef = " + Id_functor_app_inner + " - (" + componentRef.Id_concrete + "," + id_unit + "," + id_interface + ")");
                }

				// IList innerParameters = acfaRef.getParametersList();
				// //find a record in AbstractComponentFunctorApplication which matches with my object parameters
				// Component componentRef = matchParameters(innerParameters,acfaDAO,spDAO,componentDAO);
				return u;
				
			}//acf!=null
			
		}//acfa!=null  // UNEXPECTED !!!! A concrete component that does not implement and abstract one
		
		return null; 
	}//resolution
	
	
	//returns an icollection of 
	public static ICollection<InfoCompile> getReferences_Concrete(int id_concrete){

        SourceCodeDAO scdao = new SourceCodeDAO();
        SourceCodeReferenceDAO scrdao = new SourceCodeReferenceDAO();

		ComponentDAO cDAO = new ComponentDAO();		
		Component component = cDAO.retrieve(id_concrete);
		
		IList<InfoCompile> referencesSet = new List<InfoCompile>();
        
		AbstractComponentFunctorApplicationDAO acfaDAO = new AbstractComponentFunctorApplicationDAO();
		AbstractComponentFunctorApplication acfa = acfaDAO.retrieve(component.Id_functor_app);		
	
		AbstractComponentFunctorDAO acfDAO = new AbstractComponentFunctorDAO();
		InnerComponentDAO innerDAO = new InnerComponentDAO();		
	
		int id_abstract = acfa.Id_abstract;
		UnitDAO uDAO = new UnitDAO();
		IList<Unit> unitList= uDAO.list(id_concrete);

		UnitSliceDAO usDAO = new UnitSliceDAO(); 
		InterfaceDAO interfaceDAO = new InterfaceDAO();
				
		foreach (Unit unit in unitList){
			
			// IList<UnitSlice> unitSliceList = usDAO.listByUnit(id_concrete, unit.Id_unit, unit.Id_index);
			Interface interfaceUnit = interfaceDAO.retrieve(unit.Id_interface_abstract,unit.Id_interface_interface);
                        AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
            AbstractComponentFunctor acf = acfdao.retrieve(interfaceUnit.Id_abstract);

			IList<string> stringCompilationSet = new List<string>();

            IDictionary<string, AbstractComponentFunctorApplication> pars = component.Parameters;

            foreach (string reference in interfaceUnit.fetchReferences(pars))
            {
                stringCompilationSet.Add(reference);
            }
            
            string file_name_Interface = buildDllName(acf.Library_path,interfaceUnit.Assembly_string);
            if (!stringCompilationSet.Contains(file_name_Interface))
                stringCompilationSet.Add(file_name_Interface);
			
			string[] referencesArray = new string[stringCompilationSet.Count];
            stringCompilationSet.CopyTo(referencesArray,0);
            IList<string> libRefs = new List<string>();
            IList<SourceCode> scList = scdao.list('u', unit.Id_concrete, unit.Id_unit);
            foreach (SourceCode sc in scList)
            {
                IList<string> sourceRefs = sc.ExternalReferences;
                string[] referencesArrayAll = new string[referencesArray.Length + sourceRefs.Count];
                referencesArray.CopyTo(referencesArrayAll, 0);
                sourceRefs.CopyTo(referencesArrayAll, referencesArray.Length);

                InfoCompile info = new InfoCompile();
                info.moduleName = sc.File_name ; // buildDllName(unit.Assembly_string); ;
                info.unitId = unit.Id_unit;
                info.sourceCode = sc.Contents;
                info.cuid = component.Hash_component_UID;
                info.library_path = component.Library_path;
                info.id = component.Id_concrete;
                if (sc.File_type.Equals("exe")) {
                   string[] referencesArray_ = new string[referencesArrayAll.Length + libRefs.Count];
                   libRefs.CopyTo(referencesArray_,0);
                   referencesArrayAll.CopyTo(referencesArray_,libRefs.Count);
                   info.output_type = Constants.EXE_OUT;
                   info.references = referencesArray_;
                }
                else {
                    libRefs.Add(buildDllName(component.Library_path, info.moduleName.Split('.')[0]));
                    info.output_type = Constants.DLL_OUT;
                    info.references = referencesArrayAll;
                }

                referencesSet.Add(info);
            }
				
			
		}//foreach

        return referencesSet;			
	}

    //returns an icollection of 
    public static ICollection<InfoCompile> getReferences_Abstract(int id_abstract)
    {
        SourceCodeDAO scdao = new SourceCodeDAO();

        IList<InfoCompile> referencesSet = new List<InfoCompile>();
        InnerComponentDAO innerDAO = new InnerComponentDAO();
        SliceDAO sDAO = new SliceDAO();
        InterfaceDAO iDAO = new InterfaceDAO();
        AbstractComponentFunctorDAO acfDAO = new AbstractComponentFunctorDAO();
        AbstractComponentFunctorApplicationDAO acfaDAO = new AbstractComponentFunctorApplicationDAO();

        IList<Interface> iList = iDAO.list(id_abstract);

        foreach (Interface i in iList)
        {

            IList<string> stringCompilationSet = new List<string>();

//            foreach (string reference in i.ExternalReferences)
//            {
//                stringCompilationSet.Add(reference);
//            }

            foreach (string reference in i.References) {
                stringCompilationSet.Add(reference);
            }

            string[] referencesArray = new string[stringCompilationSet.Count];
            stringCompilationSet.CopyTo(referencesArray, 0);

            IList<SourceCode> scList = scdao.list('i', i.Id_abstract,i.Id_interface);
            foreach (SourceCode sc in scList)
            {
                IList<string> sourceRefs = sc.ExternalReferences;
                string[] referencesArrayAll = new string[referencesArray.Length + sourceRefs.Count];
                referencesArray.CopyTo(referencesArrayAll,0);
                sourceRefs.CopyTo(referencesArrayAll, referencesArray.Length);

                InfoCompile info = new InfoCompile();
                info.references = referencesArrayAll;
                AbstractComponentFunctor acf1 = acfDAO.retrieve(id_abstract);
                info.moduleName = sc.File_name;//  buildDllName(i.Assembly_string);
                info.unitId = i.Id_interface;
                info.sourceCode = sc.Contents;
                info.cuid = acf1.Hash_component_UID;
                info.library_path = acf1.Library_path;
                info.id = acf1.Id_abstract;
                info.output_type = sc.File_type.Equals("exe") ? Constants.EXE_OUT : Constants.DLL_OUT;
                referencesSet.Add(info);
            }


        }//foreach

        return referencesSet;
    }

    // Provides the DLL name from the assembly string but without the extension.
    // Ther assembly string contains a set of fields, separated by commas. The first fielt contains the name of the
    // assembly.
    public static string buildDllName(string library_path, string assemblyString)
    {
        return library_path + Path.DirectorySeparatorChar + assemblyString.Split(',')[0] /* + ".dll" */;
        
    } // get references

    public static string buildDllName(string assemblyString)
    {
        return assemblyString.Split(',')[0] /* + ".dll" */;

    } // get references




public struct InfoCompile{

	public string[] references;
    public string moduleName;
    public string unitId;
    public string sourceCode;
    public string cuid;
    public string library_path;
    public int id;
    public int output_type; // Constants.EXE_OUT or Constants.DLL_OUT;

}


}//class
	
}//namespace
