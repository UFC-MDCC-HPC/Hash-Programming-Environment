using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Xml;
using System.Xml.Serialization;
using br.ufc.pargo.hpe.backend.DGAC.database;
using br.ufc.pargo.hpe.backend.DGAC.utils;
using br.ufc.pargo.hpe.basic;
using System.Threading;

namespace br.ufc.pargo.hpe.backend.DGAC.database
{
    public class LoaderApp
    {

        public static ComponentType DeserializeObject(string filename)
        {
            // Declare an object variable of the type to be deserialized.
            ComponentType i = null;
            FileStream fs = null;
            try
            {
                Console.WriteLine("Reading with XmlReader");

                // Create an instance of the XmlSerializer specifying type and namespace.
                XmlSerializer serializer = new XmlSerializer(typeof(ComponentType));

                // A FileStream is needed to read the XML document.
                fs = new FileStream(filename, FileMode.Open);

                XmlReader reader = new XmlTextReader(fs);


                // Use the Deserialize method to restore the object's state.
                i = (ComponentType)serializer.Deserialize(reader);

            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
            finally
            {
                if (fs != null)
                    fs.Close();
            }

            return i;

        }

        public static ComponentFunctorApplicationType DeserializeInstantiator(string filename)
        {
            // Declare an object variable of the type to be deserialized.
            ComponentFunctorApplicationType i = null;
            FileStream fs = null;
            try
            {
                Console.WriteLine("Reading with XmlReader");

                // Create an instance of the XmlSerializer specifying type and namespace.
                XmlSerializer serializer = new XmlSerializer(typeof(ComponentFunctorApplicationType));

                // A FileStream is needed to read the XML document.
                fs = new FileStream(filename, FileMode.Open);

                XmlReader reader = new XmlTextReader(fs);

                // Use the Deserialize method to restore the object's state.
                i = (ComponentFunctorApplicationType)serializer.Deserialize(reader);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
            finally
            {
                if (fs != null)
                    fs.Close();
            }

            return i;

        }

        public static byte[] SerializeEnvironment(string filename, EnvironmentType env)
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

        public static byte[] serializeInstantiator(string filename, ComponentFunctorApplicationType inst)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(ComponentFunctorApplicationType));

            FileStream fs = new FileStream(filename, FileMode.Create);

            XmlWriter writer = new XmlTextWriter(fs, null);

            serializer.Serialize(writer, inst);

            BinaryReader br = new BinaryReader(fs);
            int count = (int)fs.Length;
            fs.Position = 0;

            byte[] data = br.ReadBytes(count);
            br.Close();
            fs.Close();

            return data;
        }

        public static string serializeInstantiatorToString(ComponentFunctorApplicationType inst)
        {
            string filename = Constants.PATH_TEMP_WORKER + "service.xml";

            XmlSerializer serializer = new XmlSerializer(typeof(ComponentFunctorApplicationType));

            FileStream fs = new FileStream(filename, FileMode.Create);

            XmlWriter writer = new XmlTextWriter(fs, null);

            serializer.Serialize(writer, inst);

            TextReader br = File.OpenText(filename);
            string result = br.ReadToEnd();

            br.Close();
            fs.Close();            

            return result;
        }

        //receives id_concrete and id inner wich belongs for that inner
        //returns a impl of the inner
        //return -1 if the impl doesnt exist    


        public static Component resolveImpl(AbstractComponentFunctorApplication acfaRef, IDictionary<string, int> actualParameters, IDictionary<string, int> actualParametersTop)
        {


            // get inner component application
            if (acfaRef != null)
            {
                IList<SupplyParameter> supplyParameters = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spdao.list(acfaRef.Id_functor_app);

                foreach (SupplyParameter supplyParameter in supplyParameters)
                {

                    //if exist a supplied parameter, then check if it is suppllie for a component
                    SupplyParameterComponent spc = br.ufc.pargo.hpe.backend.DGAC.BackEnd.spcdao.retrieve(supplyParameter.Id_parameter,
                                                                                        supplyParameter.Id_functor_app);

                    if (spc != null)
                    {
                        acfaRef.addParameter(spc.Id_parameter, spc.Id_functor_app_actual);
                    }
                    else
                    {
                        SupplyParameterParameter spp = br.ufc.pargo.hpe.backend.DGAC.BackEnd.sppdao.retrieve(supplyParameter.Id_parameter,
                                                                                            supplyParameter.Id_functor_app);
                        if (spp != null)
                        {
                            int id_functor_app_actual_top;
                            actualParameters.TryGetValue(spp.Id_parameter_actual, out id_functor_app_actual_top);
                            if (id_functor_app_actual_top == 0)
                            {
                                actualParametersTop.TryGetValue(spp.Id_parameter_actual, out id_functor_app_actual_top);
                            }
                            acfaRef.addParameter(spp.Id_parameter, id_functor_app_actual_top);

                        } // else NOT EXPECTED !!! A parameter is either a supplied component or an enclosing parameter.

                    }//else

                }//for each SupplyParameter

            }

            // AT THIS POINT, the FUNCTOR OF THE INNER COMPONENT, WITH PARAMETERS SUPPLIED, 
            //    HAVE BEEN DISCOVERED. Now, it is necessary to apply the procedure findHashComponent
            //    descrito no artigo.				

            Component componentRef = Resolution.findHashComponent(actualParametersTop, acfaRef);

            if (componentRef == null)
            {
                Console.WriteLine("componentRef NULL ! acfaRef = " + acfaRef.Id_functor_app);
                return null;
            }
            else
            {
                return componentRef;
            }

        }//resolution



        //returns an icollection of 
        public static IList<InfoCompile> getReferences_Concrete(int id_concrete)
        {

            //  SourceCodeDAO scdao = new SourceCodeDAO();
            //   SourceCodeReferenceDAO scrdao = new SourceCodeReferenceDAO();

            //	ComponentDAO cDAO = new ComponentDAO();		
            Component component = br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieve(id_concrete);

            IList<InfoCompile> referencesSet = new List<InfoCompile>();

            //	AbstractComponentFunctorApplicationDAO acfaDAO = new AbstractComponentFunctorApplicationDAO();
            AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(component.Id_functor_app);

            //	AbstractComponentFunctorDAO acfDAO = new AbstractComponentFunctorDAO();
            //	InnerComponentDAO innerDAO = new InnerComponentDAO();		

            int id_abstract = acfa.Id_abstract;
            //	UnitDAO uDAO = new UnitDAO();
            IList<Unit> unitList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.udao.list(id_concrete);

            //	UnitSliceDAO usDAO = new UnitSliceDAO(); 
            //	InterfaceDAO interfaceDAO = new InterfaceDAO();

            foreach (Unit unit in unitList)
            {

                // IList<UnitSlice> unitSliceList = usDAO.listByUnit(id_concrete, unit.Id_unit, unit.Id_index);
                Interface interfaceUnit = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve(unit.Id_interface_abstract, unit.Id_interface_interface);
                //                   AbstractComponentFunctorDAO acfdao = new AbstractComponentFunctorDAO();
                AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(interfaceUnit.Id_abstract);

                IList<string> stringCompilationSet = new List<string>();

                IDictionary<string, AbstractComponentFunctorApplication> pars = component.Parameters;

                foreach (string reference in interfaceUnit.fetchReferences(pars))
                {
                    stringCompilationSet.Add(reference);
                }

                string file_name_Interface = buildDllName(acf.Library_path, interfaceUnit.Assembly_string);
                if (!stringCompilationSet.Contains(file_name_Interface))
                    stringCompilationSet.Add(file_name_Interface);

                string file_name_Interface_base = buildDllNameBase(acf.Library_path, interfaceUnit.Assembly_string);
                if (!stringCompilationSet.Contains(file_name_Interface_base))
                    stringCompilationSet.Add(file_name_Interface_base);

                string[] referencesArray = new string[stringCompilationSet.Count];
                stringCompilationSet.CopyTo(referencesArray, 0);
                IList<string> libRefs = new List<string>();
                IList<SourceCode> scList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.scdao.list('u', unit.Id_concrete, unit.Id_unit);
                foreach (SourceCode sc in scList)
                {
                    IList<string> sourceRefs = sc.ExternalReferences;
                    string[] referencesArrayAll = new string[referencesArray.Length + sourceRefs.Count];
                    referencesArray.CopyTo(referencesArrayAll, 0);
                    sourceRefs.CopyTo(referencesArrayAll, referencesArray.Length);

                    InfoCompile info = new InfoCompile();
                    info.moduleName = sc.File_name.Split('.')[0]; // buildDllName(unit.Assembly_string); ;
                    info.unitId = unit.Id_unit;
                    info.sourceCode = sc.Contents;
                    info.cuid = component.Hash_component_UID;
                    info.library_path = component.Library_path;
                    info.id = component.Id_concrete;

                    string[] referencesArray_ = new string[referencesArrayAll.Length + libRefs.Count];
                    libRefs.CopyTo(referencesArray_, 0);
                    referencesArrayAll.CopyTo(referencesArray_, libRefs.Count);
                    info.references = referencesArray_;

                    if (sc.File_type.Equals("exe"))
                    {
                        info.output_type = Constants.EXE_OUT;
                    }
                    else
                    {
                        libRefs.Add(buildDllName(component.Library_path, info.moduleName.Split('.')[0]));
                        info.output_type = Constants.DLL_OUT;
                    }

                    referencesSet.Add(info);
                }


            }//foreach

            return referencesSet;
        }

        //returns an icollection of 
        public static IList<InfoCompile> getReferences_Abstract(int id_abstract)
        {

            IList<InfoCompile> referencesSet = new List<InfoCompile>();
            IList<Interface> iList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.list(id_abstract);

            foreach (Interface i in iList)
            {

                IList<string> stringCompilationSet = new List<string>();

                foreach (string reference in i.References)
                {
                    stringCompilationSet.Add(reference);
                }

                string[] referencesArray = new string[stringCompilationSet.Count];
                stringCompilationSet.CopyTo(referencesArray, 0);

                IList<string> libRefs = new List<string>();
                IList<SourceCode> scList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.scdao.list('i', i.Id_abstract, i.Id_interface);
                foreach (SourceCode sc in scList)
                {
                    IList<string> sourceRefs = sc.ExternalReferences;
                    string[] referencesArrayAll = new string[referencesArray.Length + sourceRefs.Count];
                    referencesArray.CopyTo(referencesArrayAll, 0);
                    sourceRefs.CopyTo(referencesArrayAll, referencesArray.Length);

                    InfoCompile info = new InfoCompile();

                    string[] referencesArray_ = new string[referencesArrayAll.Length + libRefs.Count];
                    libRefs.CopyTo(referencesArray_, 0);
                    referencesArrayAll.CopyTo(referencesArray_, libRefs.Count);
                    info.references = referencesArray_;

                    AbstractComponentFunctor acf1 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(id_abstract);
                    info.moduleName = sc.File_name.Split('.')[0];//  buildDllName(i.Assembly_string);
                    info.unitId = i.Id_interface;
                    info.sourceCode = sc.Contents;
                    info.cuid = acf1.Hash_component_UID;
                    info.library_path = acf1.Library_path;
                    info.id = acf1.Id_abstract;
                    info.output_type = sc.File_type.Equals("exe") ? Constants.EXE_OUT : Constants.DLL_OUT;
                    referencesSet.Add(info);
                    libRefs.Add(buildDllName(acf1.Library_path, info.moduleName.Split('.')[0]));
                }


            }//foreach

            return referencesSet;
        }

        // Provides the DLL name from the assembly string but without the extension.
        // Ther assembly string contains a set of fields, separated by commas. The first fielt contains the name of the
        // assembly.
        public static string buildDllName(string library_path, string assemblyString)
        {
            return library_path + Path.DirectorySeparatorChar + library_path + "." + (assemblyString.Split(',')[0]) /* + ".dll" */;

        } // get references

        public static string buildDllNameBase(string library_path, string assemblyString)
        {
            return library_path + Path.DirectorySeparatorChar + "Base" + assemblyString.Split(',')[0] /* + ".dll" */;

        } // get references

        public static string buildDllName(string assemblyString)
        {
            return assemblyString.Split(',')[0] /* + ".dll" */;

        } // get references




        public struct InfoCompile
        {

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
