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
using System.Diagnostics;

namespace br.ufc.pargo.hpe.backend.DGAC.database
{
    public class LoaderApp
    {

		public static ComponentReference.ComponentReference loadComponentReference(string contents)
		{
			// Declare an object variable of the type to be deserialized.
			ComponentReference.ComponentReference i = null;
			FileStream fs = null;
			try
			{
				// Create an instance of the XmlSerializer specifying type and namespace.
				XmlSerializer serializer = new XmlSerializer(typeof(ComponentReference.ComponentReference));

				string filename = Path.GetTempFileName();
				File.WriteAllText(filename, contents);

				// A FileStream is needed to read the XML document.
				fs = new FileStream(filename, FileMode.OpenOrCreate);

				XmlReader reader =  new XmlTextReader(fs);

				// Use the Deserialize method to restore the object's state.
				i = (ComponentReference.ComponentReference)serializer.Deserialize(reader);

			}
			catch (Exception e)
			{
				Trace.WriteLine(e.StackTrace);
			}
			finally
			{
				if (fs != null)
					fs.Close();
			}

			return i;

		}


        public static ComponentType DeserializeObject(string filename)
        {
            // Declare an object variable of the type to be deserialized.
            ComponentType i = null;
            FileStream fs = null;
            try
            {
                Trace.WriteLine("Reading with XmlReader " + filename);

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
                Trace.WriteLine(e.StackTrace);
            }
            finally
            {
                if (fs != null)
                    fs.Close();
            }

            return i;

        }

		public static T deserialize<T>(string contents)
		{
			string filename = Path.GetTempFileName ();
			File.WriteAllText (filename,contents);

			// Declare an object variable of the type to be deserialized.
			T i = default(T);
			FileStream fs = null;
			try
			{
				Trace.WriteLine("Reading with XmlReader " + filename);

				// Create an instance of the XmlSerializer specifying type and namespace.
				XmlSerializer serializer = new XmlSerializer(typeof(T));

				// A FileStream is needed to read the XML document.
				fs = new FileStream(filename, FileMode.Open);

				XmlReader reader = new XmlTextReader(fs);

				// Use the Deserialize method to restore the object's state.
				i = (T)serializer.Deserialize(reader);

			}
			catch (Exception e)
			{
				Trace.WriteLine(e.StackTrace);
			}
			finally
			{
				if (fs != null)
					fs.Close();
			}

			return i;

		}

		public static Instantiator.InstanceType DeserializeInstantiator(string filename)
        {
            // Declare an object variable of the type to be deserialized.
            Instantiator.InstanceType i = null;
            FileStream fs = null;
            try
            {
                Trace.WriteLine("Reading with XmlReader");

                // Create an instance of the XmlSerializer specifying type and namespace.
                XmlSerializer serializer = new XmlSerializer(typeof(Instantiator.InstanceType));

                // A FileStream is needed to read the XML document.
                fs = new FileStream(filename, FileMode.Open);

                XmlReader reader = new XmlTextReader(fs);

                // Use the Deserialize method to restore the object's state.
                i = (Instantiator.InstanceType)serializer.Deserialize(reader);
            }
            catch (Exception e)
            {
                Trace.WriteLine(e.StackTrace);
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
		
        public static string SerializeCatalog(string filename, Catalog.CatalogType env)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(Catalog.CatalogType));

            FileStream fs = new FileStream(filename, FileMode.Create);

            XmlWriter writer = new XmlTextWriter(fs, null);

            serializer.Serialize(writer, env);

			fs.Close();


 			string result = System.IO.File.ReadAllText(filename);

            return result;
        }

        public static string SerializeDeployedComponentInfoType(string filename, DeployedComponentInfoType env)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(DeployedComponentInfoType));

            FileStream fs = new FileStream(filename, FileMode.Create);

            XmlWriter writer = new XmlTextWriter(fs, null);

            serializer.Serialize(writer, env);

			fs.Close();
			
			return File.ReadAllText(filename);	
			
        }
		
		public static string serializeInstantiator(Instantiator.InstanceType instance)
		{
			XmlSerializer serializer = new XmlSerializer(typeof(Instantiator.InstanceType));

			string filename = Path.GetTempFileName ();

			FileStream fs = new FileStream(filename, FileMode.Open);

			XmlWriter writer = new XmlTextWriter(fs, null);

			serializer.Serialize(writer, instance);

			fs.Close();

			return File.ReadAllText(filename);	

		}

	/*	public static string serialize<T>(T instance)
		{
			XmlSerializer serializer = new XmlSerializer(typeof(T));

			string filename = Path.GetTempFileName ();

			FileStream fs = new FileStream(filename, FileMode.Open);

			XmlWriter writer = new XmlTextWriter(fs, null);

			serializer.Serialize(writer, instance);

			fs.Close();

			return File.ReadAllText(filename);	

		}
*/
		public static byte[] serializeInstantiator(string filename, Instantiator.InstanceType inst)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(Instantiator.InstanceType));

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


		public static string serializeContractToString(Instantiator.ComponentFunctorApplicationType inst)
        {
			string filename = Path.GetTempFileName ();

			XmlSerializer serializer = new XmlSerializer(typeof(Instantiator.ComponentFunctorApplicationType));

			FileStream fs = new FileStream(filename, FileMode.OpenOrCreate);

            XmlWriter writer = new XmlTextWriter(fs, null);

            serializer.Serialize(writer, inst);

			fs.Close();     

			string result = File.ReadAllText(filename);                 

            return result;
        }

		public static string serialize<T>(T inst)
		{
			string filename = Path.GetTempFileName ();

			XmlSerializer serializer = new XmlSerializer(typeof(T));

			FileStream fs = new FileStream(filename, FileMode.OpenOrCreate);

			XmlWriter writer = new XmlTextWriter(fs, null);

			serializer.Serialize(writer, inst);

			fs.Close();     

			string result = File.ReadAllText(filename);                 

			return result;
		}

		//receives id_concrete and id inner wich belongs for that inner
        //returns a impl of the inner
        //return -1 if the impl doesnt exist    


        public static Component resolveImpl(AbstractComponentFunctorApplication acfaRef, IDictionary<string, int> actualParameters, IDictionary<string, int> actualParametersTop)
        {
			//Trace.WriteLine("RESOLVE IMPL - id_functor_app=" + acfaRef.Id_functor_app + " - id_abstract=" + acfaRef.Id_abstract);

            // get inner component application
            if (acfaRef != null)
            {
				IDictionary<string,int> actualParameters_new = new Dictionary<string,int>();
				IDictionary<string,int> actualParameters_old = new Dictionary<string,int>(actualParametersTop);
				foreach (KeyValuePair<string,int> pair in actualParameters)
				{
					if (!actualParameters_old.ContainsKey(pair.Key)) actualParameters_old.Add(pair);
				}				
				
				DGAC.BackEnd.determineArguments(actualParameters_old, acfaRef.Id_functor_app, out actualParameters_new);
				
				foreach (KeyValuePair<string,int> pair in actualParameters_new)
				{
					acfaRef.addParameter(pair.Key, pair.Value);
				}				
            }

            // AT THIS POINT, the FUNCTOR OF THE INNER COMPONENT, WITH PARAMETERS SUPPLIED, 
            //    HAVE BEEN DISCOVERED. Now, it is necessary to apply the procedure findHashComponent
            //    descrito no artigo.				

			Trace.WriteLine("resolveImpl ENTER findHashComponent ! " + acfaRef.Id_functor_app);

            Component componentRef = Resolution.findHashComponent(actualParametersTop, acfaRef);

            if (componentRef == null)
            {
				Trace.WriteLine("componentRef NULL ! id_functor_app = " + acfaRef.Id_functor_app + ", id_abstract = " + acfaRef.Id_abstract);
                return null;
            }
            else
            {
				Trace.WriteLine("resolveImpl OK ! " + componentRef.Library_path);
                return componentRef;
            }

        }//resolution
			

        //returns an icollection of 
        public static IList<InfoCompile> getReferences_Concrete(int id_concrete)
        {
            Component component = br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.retrieve(id_concrete);
            IList<InfoCompile> referencesSet = new List<InfoCompile>();
            IList<Unit> unitList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.udao.list(id_concrete);

            foreach (br.ufc.pargo.hpe.backend.DGAC.database.Unit unit in unitList)
            {
                Interface interfaceUnit = br.ufc.pargo.hpe.backend.DGAC.BackEnd.idao.retrieve(unit.Id_abstract, unit.Id_interface);

				AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(interfaceUnit.Id_abstract);

				IList<string> referencesArrayAll_list = new List<string> ();
  
                IDictionary<string, AbstractComponentFunctorApplication> pars = component.Arguments;
				
				Trace.WriteLine ("BEGIN TAKING REFERENCES OF " + (unit.Id_abstract) + ", " + id_concrete);
                foreach (string reference in interfaceUnit.fetchReferences(pars))
                {
					Trace.WriteLine(reference);
					referencesArrayAll_list.Add(reference);
                }
				Trace.WriteLine ("END TAKING REFERENCES OF " + (unit.Id_abstract));

                string file_name_Interface = buildDllName(acf.Library_path, interfaceUnit.Assembly_string);
				if (!referencesArrayAll_list.Contains(file_name_Interface))
					referencesArrayAll_list.Add(file_name_Interface);

             //   string file_name_Interface_base = buildDllNameBase(acf.Library_path, interfaceUnit.Assembly_string);
			//	if (!referencesArrayAll_list.Contains(file_name_Interface_base))
				//	referencesArrayAll_list.Add(file_name_Interface_base);

                IList<SourceCode> scList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.scdao.list('u', unit.Id_concrete, unit.Id_unit);  

				InfoCompile info = new InfoCompile();

				IList<Tuple<string,string>> sourceContents_list = new List<Tuple<string, string>> ();

				foreach (SourceCode sc in scList)
                {
					if (sc.File_type.Equals ("dll")) 
					{
						IList<string> sourceRefs = sc.ExternalReferences;
						foreach (string sourceRef in sourceRefs)
							referencesArrayAll_list.Add (sourceRef);
						sourceContents_list.Add(new Tuple<string,string> (sc.File_name.Split ('.') [0], sc.Contents));
					} 
                }

				info.sourceContents = new Tuple<string,string>[sourceContents_list.Count];
				sourceContents_list.CopyTo (info.sourceContents, 0);

				string[] referencesArrayAll = new string[referencesArrayAll_list.Count];
				referencesArrayAll_list.CopyTo (referencesArrayAll, 0);

				info.moduleName = unit.Class_name;
				info.unitId = unit.Id_unit;
				info.cuid = component.Hash_component_UID;
				info.library_path = component.Library_path;
				info.id = component.Id_concrete;
				info.output_type = Constants.DLL_OUT;
				info.references = referencesArrayAll;

				referencesSet.Add(info);

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
				IList<string> referencesArrayAll_list = new List<string> ();

				foreach (string reference in i.References)
                {
					Trace.WriteLine("REFERENCE: " + id_abstract + " - " + i.Class_name + " -- " + reference);
					referencesArrayAll_list.Add (reference);
                }

                IList<SourceCode> scList = br.ufc.pargo.hpe.backend.DGAC.BackEnd.scdao.list('i', i.Id_abstract, i.Id_interface);

				InfoCompile info = new InfoCompile();

				info.sourceContents = new Tuple<string,string>[scList.Count];

				int source_counter = 0;
				foreach (SourceCode sc in scList)
                {
                    IList<string> sourceRefs = sc.ExternalReferences;
					foreach (string sourceRef in sourceRefs) referencesArrayAll_list.Add (sourceRef);
					info.sourceContents [source_counter] = new Tuple<string, string> (sc.File_name.Split('.')[0], sc.Contents);
					source_counter ++;
				}

				string[] referencesArrayAll = new string[referencesArrayAll_list.Count];
				referencesArrayAll_list.CopyTo (referencesArrayAll, 0);

				AbstractComponentFunctor acf1 = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(id_abstract);
				info.moduleName = i.Class_name;
				info.unitId = i.Id_interface;
			//	info.partition_index = i.Unit_replica;
				info.cuid = acf1.Hash_component_UID;
				info.library_path = acf1.Library_path;
				info.id = acf1.Id_abstract;
				info.references = referencesArrayAll;

				referencesSet.Add(info);
				// libRefs.Add(buildDllName(acf1.Library_path, acf1.Library_path + "." + info.sourceName.Split('.')[0])); // DESNECESSÁRIO, pois agora tudo vai ser compilado junto
				info.output_type = /*sc.File_type.Equals("exe") ? Constants.EXE_OUT : */ Constants.DLL_OUT;


            }//foreach

            return referencesSet;
        }

        // Provides the DLL name from the assembly string but without the extension.
        // Ther assembly string contains a set of fields, separated by commas. The first fielt contains the name of the
        // assembly.
        public static string buildDllName(string library_path, string assemblyString)
        {
            return library_path + Path.DirectorySeparatorChar + (assemblyString.Split(',')[0]) /* + ".dll" */;

        } // get references

        public static string buildDllNameBase(string library_path, string assemblyString)
        {
            int dllpos = assemblyString.IndexOf(",");
            string s = assemblyString.Substring(0, dllpos);
            int i = s.LastIndexOf(".");
            i = i >= 0 ? i : 0;
            s = s.Insert(i+1, "Base");            
            
            return library_path + Path.DirectorySeparatorChar  + s + ".dll" ;

        } // get references

        public static string buildDllName(string assemblyString)
        {
            return assemblyString.Split(',')[0] /* + ".dll" */;

        } // get references




        public struct InfoCompile
        {
			public string moduleName;
            public string[] references;
			public int partition_index;
            public string unitId;
			public Tuple<string,string>[] sourceContents;
            public string cuid;
            public string library_path;
            public int id;
            public int output_type; // Constants.EXE_OUT or Constants.DLL_OUT;

        }


    }//class

}//namespace
