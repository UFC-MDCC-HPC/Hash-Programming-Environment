using System;
using System.Collections;
using System.IO;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Formatters.Binary;

namespace backEndServices{

	public class ObjectSerializer{
 		
 		//this method serialize the hashtable into a binary file, 
		//we have a load function to load that exact saved file
//		public static void Save(ComponentType componentType)
//		{
			//file stream states the saved binary
//			FileStream fs = new FileStream ("../database/database.dat",FileMode.OpenOrCreate ,FileAccess.Write );
//			try
//			{
//				//Hashtable a = new Hashtable();
				//a = NameToAddress;
//				BinaryFormatter bf=new BinaryFormatter ();
				//as easy as 1,2,3...we serialize a to a binary formating using file stream.
//				bf.Serialize (fs,table);
//			}
//			finally
//			{
//				fs.Close ();
//			}
//		}

		//A method to load saved binary file
//		public static DBTableAbsImpl Load()
	//	{
	//		FileStream fs = new FileStream ("../database/database.dat",FileMode.Open ,FileAccess.Read );
	//		DBTableAbsImpl refDB = null;
	//		try
	//		{
	//			//Hashtable a = new Hashtable();
	//			BinaryFormatter bf=new BinaryFormatter ();
//
	//			//here we deserialize the binary to a hashtable
	//			refDB=(DBTableAbsImpl)bf.Deserialize (fs);
	//			
	//		}
	//		finally
	//		{
		//		fs.Close ();
	//		}
			
	//		return refDB;
			
	//	}
	}	
}