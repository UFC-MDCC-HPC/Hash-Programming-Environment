//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections.Generic;
using DGAC.utils;
using MPI;
// using cca;

namespace DGAC
{ 
		//MANAGER
        public class ManagerObject: MarshalByRefObject{

 
    	    /**
	     * 	Creates an instance of a CCA component of the type defined by the 
	     * 	string className.  The string classname uniquely defines the
	     * 	"type" of the component, e.g.
	     * 	    doe.cca.Library.GaussianElmination. 
	     * 	It has an instance name given by the string instanceName.
	     * 	The instanceName may be empty (zero length) in which case
	     * 	the instanceName will be assigned to the component automatically.
	     * 	@throws CCAException If the Component className is unknown, or if the
	     * 		instanceName has already been used, a CCAException is thrown.
	     * 	@return A ComponentID corresponding to the created component. Destroying
	     * 		the returned ID does not destroy the component; 
	     * 		see destroyInstance instead.
	     */
            [MethodImpl(MethodImplOptions.Synchronized)]
            public void createInstance(string instanceName, string className /*, cca.TypeMap properties */)
            {
             try {
                Console.WriteLine("CREATE INSTANCE");
             } 
             catch (Exception e) 
             {
                Console.WriteLine(e.Message);
             }
            }

            /**
            * Salva arquivo fonte lido como um array de bytes em data, com o nome filename
            * em pasta definida pela classe Constants
            */
                [MethodImpl(MethodImplOptions.Synchronized)]
				public void saveData(byte[] data, string filename){

                    Console.WriteLine("Worker writing file " + filename);
                    //saving source file
					if(data!=null)
						FileUtil.saveByteArrayIntoFile(data,Constants.PATH_TEMP_WORKER+filename+".cs");
					
				}
		        
		        /*
		         *Compila fonte salvo pelo método anterior. O resultado por ser uma DLL ou arquivo executável,
                 *dependendo do parâmetro outFile, definido pela classe CONSTANTS.
		         *Se o fonte resultar em uma dll, ela é instalada no GAC, na pasta "HASH"
                 *Se o fonte for um executável, então ele é salvo numa pasta temporária, definida pela 
		         *classe Constants 
		         */
                [MethodImpl(MethodImplOptions.Synchronized)]
                public string compileClass
                    (string library_path,                                            
                     string contents, 
                     string moduleName, 
                     string[] references, 
                     int outFile, 
                     string userName, 
                     string password, 
                     string curDir)
                {
                    string publicKeyToken = null; 
                    string moduleNameWithoutExtension = moduleName.Split('.')[0];
                    Console.WriteLine("Compiling " + moduleName);
                    Console.WriteLine("password = " + password);
                    if (outFile == Constants.EXE_OUT)
                    {
                        CommandLineUtil.compile_to_exe(contents, moduleName, references, userName, password, curDir);
                    }
                    else
                    {
                        //creates the strong key, for new assembly
                        publicKeyToken = CommandLineUtil.create_strong_key(moduleName, userName, password, curDir);
                        //compile, generate dll 
                        CommandLineUtil.compile_source(contents, moduleName, references, userName, password, curDir);
                        //installing on local GAC
                        CommandLineUtil.gacutil_install(library_path, moduleNameWithoutExtension, 1, userName, password);
                    }
                    // Erase temporary files.
                    // CommandLineUtil.clean(moduleNameWithoutExtension);
                    return publicKeyToken;
                }
		        
		        /*
		         *Roda arquivos executáveis gerados pelo metodo anterior
                 */
		        [MethodImpl(MethodImplOptions.Synchronized)]
                public void runClass
                    (IDictionary<string, int> files, 
                     IDictionary<string, int> enums, 
                     int session_id, 
                     string userName, 
                     string password, 
                     String curDir)
                {
					CommandLineUtil.run_exe(files, enums, session_id, userName, password, curDir);
		        }
				
				//just for test
				[MethodImpl(MethodImplOptions.Synchronized)]
				public void sayHi(){
					Console.WriteLine("Hi!");
				}

        }

        
}
