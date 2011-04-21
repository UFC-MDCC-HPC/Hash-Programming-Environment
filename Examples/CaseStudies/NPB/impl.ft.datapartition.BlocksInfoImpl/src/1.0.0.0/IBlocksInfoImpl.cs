using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.datapartition.BlocksInfo;

namespace impl.ft.datapartition.BlocksInfoImpl { 
	public class IBlocksInfoImpl : BaseIBlocksInfoImpl, IBlocks{
		public IBlocksInfoImpl() { 
		
		} 
		override public void initialize(){
		   
		}
		public void blocksConfig(int nx, int ny, int nz, int np1, int np2, int layout_type){
		    int layout_0D = 0, layout_1D = 1, layout_2D = 2;
		    int fftblock_default=16, fftblockpad_default=18;
		    int node = this.GlobalRank;
            _me2 = (int)mod(node, np2);
            _me1 = node/np2;
            if(layout_type == layout_0D) {
                for(int i = 0; i < 3; i++) {
                    _xstart[i] = 1;
                    _xend[i]   = nx;
                    _ystart[i] = 1;
                    _yend[i]   = ny;
                    _zstart[i] = 1;
                    _zend[i]   = nz;
                }

            }
            else if(layout_type == layout_1D) {
                _xstart[0] = 1;
                _xend[0]   = nx;
                _ystart[0] = 1;
                _yend[0]   = ny;
                _zstart[0] = 1 + _me2 * nz/np2;
                _zend[0]   = (_me2+1) * nz/np2;

                _xstart[1] = 1;
                _xend[1]   = nx;
                _ystart[1] = 1;
                _yend[1]   = ny;
                _zstart[1] = 1 + _me2 * nz/np2;
                _zend[1]   = (_me2+1) * nz/np2;

                _xstart[2] = 1;
                _xend[2]   = nx;
                _ystart[2] = 1 + _me2 * ny/np2;
                _yend[2]   = (_me2+1) * ny/np2;
                _zstart[2] = 1;
                _zend[2] = nz;

            }
            else if(layout_type == layout_2D) {

                _xstart[0] = 1;
                _xend[0]   = nx;
                _ystart[0] = 1 + _me1 * ny/np1;
                _yend[0]   = (_me1+1) * ny/np1;
                _zstart[0] = 1 + _me2 * nz/np2;
                _zend[0]   = (_me2+1) * nz/np2;

                _xstart[1] = 1 + _me1 * nx/np1;
                _xend[1]   = (_me1+1)*nx/np1;
                _ystart[1] = 1;
                _yend[1]   = ny;
                _zstart[1] = _zstart[0];
                _zend[1]   = _zend[0];

                _xstart[2] = _xstart[1];
                _xend[2]   = _xend[1];
                _ystart[2] = 1 + _me2 *ny/np2;
                _yend[2]   = (_me2+1)*ny/np2;
                _zstart[2] = 1;
                _zend[2] = nz;
            }
            _fftblock = fftblock_default;
            _fftblockpad = fftblockpad_default;

            int dim1 = ny/np1;
            int dim2 = nx/np1;
            int dim3 = nx/np1;
            if(layout_type == layout_2D) {
                if(dim1 < _fftblock)
                    _fftblock = dim1;
                if(dim2 < _fftblock)
                    _fftblock = dim2;
                if(dim3 < _fftblock)
                    _fftblock = dim3;
            }

            if(_fftblock != fftblock_default)
                _fftblockpad = _fftblock + 3;
		}
		
		public static double mod(double a, double b) { return (a % b); }
		
		private int _fftblock, _fftblockpad, _node, _me1, _me2;
		private int[] _xstart = {0,0,0};
		private int[] _ystart = {0,0,0};
		private int[] _zstart = {0,0,0};
		private int[] _xend = {0,0,0};
		private int[] _yend = {0,0,0};
		private int[] _zend = {0,0,0};
		
		public int fftblock    {get { return _fftblock; }    set { _fftblock = value; } }
		public int fftblockpad {get { return _fftblockpad; } set { _fftblockpad = value; } }
		public int node        {get { return _node; }        set { _node = value; } }
		public int me1         {get { return _me1; }         set { _me1 = value; } }
		public int me2         {get { return _me2; }         set { _me2 = value; } }
		
		public int[] xstart {get { return _xstart; } }
		public int[] ystart {get { return _ystart; } }
		public int[] zstart {get { return _zstart; } }
		public int[] xend   {get { return _xend; } }
		public int[] yend   {get { return _yend; } }
		public int[] zend   {get { return _zend; } }
	}
}
