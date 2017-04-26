namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.util{

public class CertifierConstants {

		public static  string ORCHESTRATION_XSD 
			= "/home/allberson/Dropbox/HPC-Shelf-MapReduce/br.ufc.mdcc.hpcshelf.certifier.impl.computation.CertfierC4Impl/src/1.0.0.0/xml/Certifier_Orchestration.xsd";

		//"src/1.0.0.0/xml/Certifier_Orchestration.xsd";

		//public static  string ORCHESTRATION_FILE_TEST = "/home/allberson/Dropbox/HPC-Shelf-MapReduce/br.ufc.mdcc.hpcshelf.certifier.impl.computation.CertfierC4Impl/src/1.0.0.0/xml/orchestration_sequence_parallel_perform.xml";
		public static  string ORCHESTRATION_FILE_TEST = "/home/allberson/Dropbox/HPC-Shelf-MapReduce/br.ufc.mdcc.hpcshelf.certifier.impl.computation.CertfierC4Impl/src/1.0.0.0/xml/orchestration_sequence_parallel_switch.xml";

			//"src/1.0.0.0/xml/orchestration_sequence_parallel_start.xml";



	

	public static  int BREAK_SIGNAL = 2;  
	public static  int CONTINUE_SIGNAL = 3;

	//public static  int RETURN_VERIFY_INCONCLUSIVE = 1;  
	//public static  int RETURN_VERIFY_CONCLUSIVE = 0;
	public static  int NORMAL_SIGNAL = -1;

}
}