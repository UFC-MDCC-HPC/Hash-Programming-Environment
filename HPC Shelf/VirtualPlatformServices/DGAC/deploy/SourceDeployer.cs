

using System;
using System.Collections.Generic;
using System.Runtime.CompilerServices;
using br.ufc.pargo.hpe.backend.DGAC.utils;

public class SourceDeployer
{
 			#region DEPLOYER
		
		
            /**
            * Salva arquivo fonte lido como um array de bytes em data, com o nome filename
            * em pasta definida pela classe Constants
            */
                [MethodImpl(MethodImplOptions.Synchronized)]
				public void saveData(byte[] data, string filename){

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
			 		 string moduleName,
                     Tuple<string,string>[] sourceContents, 
                     string[] references, 
                     int outFile, 
                     string userName, 
                     string password, 
                     string curDir)
                {
                    string publicKeyToken = null; 

					//creates the strong key, for new assembly
                    publicKeyToken = CommandLineUtil.create_strong_key(moduleName, userName, password, curDir);
                    //compile, generate dll 
                    CommandLineUtil.compile_source(sourceContents, moduleName, references, userName, password, curDir);
                    //installing on local GAC
                    CommandLineUtil.gacutil_install(library_path, moduleName, 1, userName, password);

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
		
			#endregion


}
