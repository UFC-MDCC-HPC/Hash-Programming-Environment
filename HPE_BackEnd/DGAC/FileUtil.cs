using System;
using System.IO;
using System.Net;
using System.Xml;
using System.Runtime.CompilerServices;
using System.Collections.Generic;
using System.Xml.Serialization;


namespace br.ufc.pargo.hpe.backend.DGAC.utils{

public class FileUtil{

  /// <summary>
  /// Method to save a byte array into a binary file
  /// </summary>
  /// <param name="file">Byte array that contains the file to be save</param>
  /// <param name="path">String that contains the path where the file must be saved</param>
  /// <returns>bool</returns>
  public static bool saveByteArrayIntoFile(byte[] data, String path){
	
	if(File.Exists(path))
		FileUtil.deleteFile(path);
	FileStream fStream = new FileStream(path, FileMode.CreateNew);		
	BinaryWriter bw = new BinaryWriter(fStream);		
	bw.Write(data);
	bw.Close();	
	fStream.Close();
	
	return true;
  }

  /// <summary>
  /// Method wite to a file, creating a new one.
  /// </summary>
  /// <param name="fileFullPath">String that defines name of the file</param>
  /// <param name="content">String that defines the content wich will be written in the file</param>
  /// <returns>void</returns>
  public static FileInfo writeToFile(string fileName, string content){
  	 FileInfo f = new FileInfo(Constants.PATH_TEMP_WORKER + fileName);
	 StreamWriter w = f.CreateText();
	 w.WriteLine(content);
	 w.Close();
     return f;
  }
  
  /// <summary>
  /// Method to read a URI to byte array
  /// </summary>
  /// <param name="URI">string that defines the URI</param>
  /// <returns>byte array</returns>
  public static byte[] readByteArrayFromURI(string URI){
  	WebClient client = new WebClient();
	byte [] bytedata = client.DownloadData(URI);
	return bytedata;
  }

  /// <summary>
  /// Method to delete a local file
  /// </summary>
  /// <param name="path">string that defines the file path</param>
  /// <returns>byte array</returns>
  [MethodImpl(MethodImplOptions.Synchronized)]
  public static bool deleteFile(string path){
  	FileInfo fi = new FileInfo(path);
	fi.Delete();
	
	return true;
  }

  public static string[] readProperty(string property){
  
  	string[] res = null;
  	string xml_file = Constants.PROPERTIES_FILE;
  	XmlTextReader bankReader = null;
    bankReader = new XmlTextReader (xml_file);
    //count ocurrencies
    int n = 0;
    while (bankReader.Read()){
    	if (bankReader.NodeType == XmlNodeType.Element){
    		 if (bankReader.LocalName.Equals(property)){    		 	  
                  n++;
             }
    	}
    }
    
    bankReader = new XmlTextReader (xml_file);
    res = new string[n];
    n=0;
    while (bankReader.Read()){
    	if (bankReader.NodeType == XmlNodeType.Element){
    		 if (bankReader.LocalName.Equals(property)){                   
                   res[n++] = bankReader.ReadString(); 
             }
    	}
    }
  	return res;
  }

  private static IDictionary<string, string> defaultProperties = loadDefaultProperties();

  private static IDictionary<string, string> loadDefaultProperties()
  {
      IDictionary<string, string> defaultProperties = new Dictionary<string, string>();
      defaultProperties.Add("external_references_file", Environment.CurrentDirectory + Path.DirectorySeparatorChar + "externalReferences.xml");
      defaultProperties.Add("cs_compiler", "gmcs");
      defaultProperties.Add("cs_compiler_flags", "");
      defaultProperties.Add("cli_runtime", "mono");
      defaultProperties.Add("gac_util", "gacutil");
      defaultProperties.Add("mpi_run", "mpirun");
      defaultProperties.Add("mpi_run_flags", "");
      // etc ... add !
      return defaultProperties;
  }
        


   public static string readConstant(string property) {
       string defaultValue;
       defaultProperties.TryGetValue(property, out defaultValue);
       return readConstant(property, defaultValue);
   }

  public static string readConstant(string property, string default_value)
  {

      string xml_file = Constants.PROPERTIES_FILE;
      XmlTextReader bankReader = null;
      bankReader = new XmlTextReader(xml_file);

      while (bankReader.Read())
      {
          if (bankReader.NodeType == XmlNodeType.Element)
          {
              if (bankReader.LocalName.Equals(property))
              {
                  string s = bankReader.ReadString(); 
//                  Console.WriteLine("PROPERTY .... " + s);
                  return s;
              }
          }
      }
      bankReader.Close();
//      Console.WriteLine("PROPERTY NOT FOUND ....");
      return default_value;
  }


  public static IDictionary<string, ReferenceType> loadExternalReferences()
  {
          Dictionary<string, ReferenceType> d = new Dictionary<string, ReferenceType>();

          try
          {
              string filename = Constants.externalRefsFile;

              // Create an instance of the XmlSerializer specifying type and namespace.
              XmlSerializer serializer = new XmlSerializer(typeof(ReferenceListType));

      Console.WriteLine(filename);

              // A FileStream is needed to read the XML document.
              FileStream fs = new FileStream(filename, FileMode.Open);

              XmlReader reader = new XmlTextReader(fs);


              // Declare an object variable of the type to be deserialized.
              ReferenceListType i;

              // Use the Deserialize method to restore the object's state.
              i = (ReferenceListType)serializer.Deserialize(reader);

				Console.WriteLine("EXTERNAL REFERENCES:");
              foreach (ReferenceType extRef in i.reference)
              {
					Console.WriteLine("KEY:" + extRef.destailedName + " VALUE:" + extRef.path);
                  d.Add(extRef.destailedName, extRef);
              }

              fs.Close();

          }
          catch (Exception e)
          {
              Console.WriteLine(e.Message);
          }

      return d;

  }

}//fileutil

}//namespace
