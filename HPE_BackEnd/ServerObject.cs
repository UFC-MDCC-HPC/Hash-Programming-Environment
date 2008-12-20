//Remoting!
using System;
using System.Runtime.CompilerServices;
using System.Runtime.Remoting;
using System.Collections;
using DGAC.utils;

namespace DGAC
{
 
		//WORKER
        public class ServerObject: MarshalByRefObject{
				 
				/**
		        * Salva arquivo fonte lido como um array de bytes em data, com o nome filename
                * em pasta definida pela classe Constants
		        */
                [MethodImpl(MethodImplOptions.Synchronized)]
				public void saveData(byte[] data, string filename){

                    Console.WriteLine("Worker writing file " + filename);
                    //saving source file
					if(data!=null)
						FileUtil.saveByteArraIntoFile(data,Constants.PATH_TEMP_WORKER+filename+".cs");
					
				}
		        
		        /*
		         *Compila fonte salvo pelo método anterior. O resultado por ser uma DLL ou arquivo executável,
                 *dependendo do parâmetro outFile, definido pela classe CONSTANTS.
		         *Se o fonte resultar em uma dll, ela é instalada no GAC, na pasta "HASH"
                 *Se o fonte for um executável, então ele é salvo numa pasta temporária, definida pela 
		         *classe Constants 
		         */ 
		        [MethodImpl(MethodImplOptions.Synchronized)]
		        public string compileClass(string cuid, string contents, string moduleName, string[] references, int outFile){
                    string publicKeyToken = null;
                    string moduleNameWithoutExtension = moduleName.Split('.')[0];
                    Console.WriteLine("Compiling " + moduleName);
			        if(outFile==Constants.EXE_OUT){
			           CommandLineUtil.compile_to_exe(contents,moduleName,references);
			        }else{
                      //creates the strong key, for new assembly
                      publicKeyToken = CommandLineUtil.create_strong_key(moduleName);
                      //compile, generate dll 
					  CommandLineUtil.compile_source(contents, moduleName, references);
					  //installing on local GAC
                      CommandLineUtil.gacutil_install(cuid, moduleNameWithoutExtension, 1);
			        }
                    // Erase temporary files.
                    // CommandLineUtil.clean(moduleNameWithoutExtension);
                    return publicKeyToken;
                }
		        
		        /*
		         *Roda arquivos executáveis gerados pelo metodo anterior
                 */
		        [MethodImpl(MethodImplOptions.Synchronized)]
		        public void runClass(string filename){
			        Console.WriteLine("Running " + filename);
					CommandLineUtil.run_exe(filename);
		        }
				
				//just for test
				[MethodImpl(MethodImplOptions.Synchronized)]
				public void sayHi(){
					Console.WriteLine("Hi!");
				}

        }

        
}
