using System;
using System.IO;
using System.Net;
using System.Xml;
using System.Runtime.CompilerServices;


namespace DGAC.utils{

public class FileUtil{

  /// <summary>
  /// Method to save a byte array into a binary file
  /// </summary>
  /// <param name="file">Byte array that contains the file to be save</param>
  /// <param name="path">String that contains the path where the file must be saved</param>
  /// <returns>bool</returns>
  public static bool saveByteArraIntoFile(byte[] data, String path){
	
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
  public static void writingToFile(string fileName, string content){
  	 FileInfo f = new FileInfo(Constants.PATH_TEMP_WORKER+fileName);
	 StreamWriter w = f.CreateText();
	 w.WriteLine(content);
	 w.Close();
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

  public static string readConstant(string property)
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
                  Console.WriteLine("PROPERTY .... " + s);
                  return s;
              }
          }
      }
      Console.WriteLine("PROPERTY NOT FOUND ....");
      return null;
  }

  
}//fileutil

}//namespace