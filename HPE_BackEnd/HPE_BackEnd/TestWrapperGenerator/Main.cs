using System;
using br.ufc.hpe.backend.DGAC;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.CodeDom;

namespace TestWrapperGenerator
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			Connector.openConnection();
			
			IWrapperGenerator w = WrapperGenerator.instance;
			
			string[] dependencies = null;
			
			CodeCompileUnit compile_unit = w.create_wrapper(56,"adi",0, out dependencies);
			string source_code = w.generate_source_code(compile_unit);
			
		//	string dllFile = sourceFile.Replace(".cs",".dll");
			
		//	w.compile_wrapper(sourceFile, dllFile, dependencies);
			
			Connector.closeConnection();
			
		}
	}
}
