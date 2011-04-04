using br.ufc.pargo.hpe.kinds;

namespace lu.datapartition.BlocksInfo { 
	public interface IBlocksInfo : BaseIBlocksInfo {
		int nx {get;}
		int ny {get;}
		int nz {get;}
		int ipt {get;}
		int ist {get;}
		int iend {get;}
		int jpt {get;}
		int jst {get;}
		int jend {get;}
		
		int nx0 {get; set;}	   
		int ny0 {get; set;}
		int nz0 {get; set;}
						
		int north {get; set;}
		int south {get; set;}
		int east {get; set;}
		int west {get; set;}
						
		int row {get; set;}
		int col {get; set;}	
		int xdim {get; set;}
		int ydim {get; set;}
				 
//		int isiz1 {get;}
//		int isiz2 {get;} 
		int isiz3 {get;set;}   
		
        void subDomain();
        
//ProblemDefination	   
//	   int node {get;set;}
//	   int ndim {get;set;}
//	   int num {get;set;}
//	   int xdim {get;set;}
//	   int ydim {get;set;}
//	   int row {get;set;}
//	   int col {get;set;}

//	     bool[] icommn {get;set;}
//	     bool[] icomms {get;set;}
//       bool[] icomme {get;set;}
//       bool[] icommw {get;set;}
     
//Instance
//       double dt {get;set;}
//       int itmax {get;set;}
//       int inorm {get;set;}
//       int isiz01 {get;set;}
//       int isiz02 {get;set;}
//       int isiz03 {get;set;}

       
       //void initialize();       
	}
}
