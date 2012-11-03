using System;
using br.ufc.hpe.backend.DGAC;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.CodeDom;
using br.ufc.pargo.hpe.connector.config;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.utils;

namespace TestWrapperGenerator
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			int rank = 0;
			string id_interface = "teste";
			ConfigurationManager configurationManager = new ConfigurationManager(null);
			
			String hcl_string = null;
				
			string path = Constants.PATH_TEMP_WORKER + "sp.adi.SP_ADI" + ".hcl";
				
			using (StreamReader sr = new StreamReader(path))
		    {
		        hcl_string = sr.ReadToEnd();                
		    }
		
			Console.WriteLine(hcl_string);	
				
			configurationManager.LoadComponent(path);				
			
		}
		
		
		public static void Main2 (string[] args)
		{
			Connector.openConnection();
			
			IWrapperGenerator w = WrapperGenerator.instance;
			
			string[] dependencies = null;
			
			CodeCompileUnit compile_unit = w.create_wrapper("impl.sp.solve.connector.SolverImpl","ISolverImpl",116,"solve",0, out dependencies);
			string source_code = w.generate_source_code("ISolverImpl", compile_unit);
						
			Connector.closeConnection();
			
		}
	}
}
