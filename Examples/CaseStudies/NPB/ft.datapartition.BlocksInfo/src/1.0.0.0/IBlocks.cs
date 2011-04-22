using br.ufc.pargo.hpe.kinds;

namespace ft.datapartition.BlocksInfo { 
	public interface IBlocks : BaseIBlocks{
		int fftblock {get;set;}
		int fftblockpad {get;set;}
		int node {get;set;}
		int me1 {get;set;}
		int me2 {get;set;}
		int size1 {get;set;}
		int size2 {get;set;}
		int[] xstart {get;}
		int[] ystart {get;}
		int[] zstart {get;}
		int[] xend {get;}
		int[] yend {get;}
		int[] zend {get;}
		
		void blocksConfig(int nx, int ny, int nz, int np1, int np2, int layout_type);
	}
}
