using br.ufc.pargo.hpe.kinds;

namespace lu.datapartition.BlocksInfo { 
	public interface IBlocksInfo : BaseIBlocksInfo {
	   int nx {get;set;}
	   int ny {get;set;}
	   int nz {get;set;}
	   int nx0 {get;set;}
	   int ny0 {get;set;}
	   int nz0 {get;set;}
	   int ipt {get;set;}
	   int ist {get;set;}
	   int iend {get;set;}
	   int jpt {get;set;}
	   int jst {get;set;}
	   int jend {get;set;}
	   int ii1 {get;set;}
	   int ii2 {get;set;}
	   int ji1 {get;set;}
	   int ji2 {get;set;}
	   int ki1 {get;set;}
	   int ki2 {get;set;}
	   
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
//       int isiz1 {get;set;}
//       int isiz2 {get;set;} 
      
       double frc {get;set;}
       
//Instance
//       double dt {get;set;}
//       int itmax {get;set;}
//       int inorm {get;set;}
//       int isiz01 {get;set;}
//       int isiz02 {get;set;}
//       int isiz03 {get;set;}
//       int isiz3 {get;set;}
       
       void initialize();
	}
}
