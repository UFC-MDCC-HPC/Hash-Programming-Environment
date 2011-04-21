using br.ufc.pargo.hpe.kinds;

namespace ft.datapartition.BlocksInfo { 
	public interface IBlocks : BaseIBlocks{
		int Wfftblock {get;set;}
		int Wfftblockpad {get;set;}
		int Wnode {get;set;}
		int Wme1 {get;set;}
		int Wme2 {get;set;}
		int[] Wxstart {get;}
		int[] Wystart {get;}
		int[] Wzstart {get;}
		int[] Wxend {get;}
		int[] Wyend {get;}
		int[] Wzend {get;}
		
		void blocksConfig(int nx, int ny, int nz, int np1, int np2, int layout_type);
	}
}
