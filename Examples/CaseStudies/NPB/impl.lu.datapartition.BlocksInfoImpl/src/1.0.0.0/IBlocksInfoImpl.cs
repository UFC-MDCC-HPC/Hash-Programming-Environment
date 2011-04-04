using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.datapartition.BlocksInfo;

namespace impl.lu.datapartition.BlocksInfoImpl { 
	public class IBlocksInfoImpl : BaseIBlocksInfoImpl, IBlocksInfo {
		public IBlocksInfoImpl() { 
		
		}	
		
//		override public void initialize(){
//		   
//		}	
		
		public void subDomain(){
            int mm;
            mm   = (int)mod(_nx0, _xdim);
            if(_row<=mm) {
                _nx = _nx0/_xdim + 1;
                _ipt = (_row-1)*_nx;
            }
            else {
                _nx = _nx0/_xdim;
                _ipt = (_row-1)*_nx + mm;
            }
            mm   = (int)mod(_ny0, _ydim);
            if(_col<=mm) {
                _ny = _ny0/_ydim + 1;
                _jpt = (_col-1)*_ny;
            }
            else {
                _ny = _ny0/_ydim;
                _jpt = (_col-1)*_ny + mm;
            }
            _nz = _nz0;
            
            //setCheck();
            
            if((_nx < 4) || (_ny < 4) || (_nz < 4)) {
                Console.WriteLine("SUBDOMAIN SIZE IS TOO SMALL - ADJUST PROBLEM SIZE OR NUMBER OF PROCESSORS, "+
                    "SO THAT NX, NY AND NZ ARE GREATER THAN OR EQUAL TO 4 THEY ARE CURRENTLY: "+_nx+"x"+_ny+"x"+_nz);
                //worldcomm.Abort(0);//CALL MPI_ABORT[ MPI_COMM_WORLD,ERRORCODE,IERROR ]
                //mpi.Dispose();
                throw new System.Exception("Check SUBDOMAIN SIZE");
            }
            setCheck();
            if((_nx > _isiz1) || (_ny > _isiz2) || (_nz > _isiz3)) {
                Console.WriteLine("SUBDOMAIN SIZE IS TOO LARGE - ADJUST PROBLEM SIZE OR NUMBER OF PROCESSORS" +
                    "SO THAT NX, NY AND NZ ARE LESS THAN OR EQUAL TO ISIZ1, ISIZ2 AND ISIZ3 RESPECTIVELY. THEY ARE CURRENTLY"+
                    " "+_nx+"x"+_ny+"x"+_nz);
                //worldcomm.Abort(0);//CALL MPI_ABORT[ MPI_COMM_WORLD,ERRORCODE, IERROR ]
                //mpi.Dispose();
                throw new System.Exception("Check SUBDOMAIN SIZE");
            }
            _ist = 1;
            _iend = _nx;
            if(_north==-1)
                _ist = 2;
            if(_south==-1)
                _iend = _nx - 1;
            _jst = 1;
            _jend = _ny;
            if(_west==-1)
                _jst = 2;
            if(_east==-1)
                _jend = _ny - 1;
		}
		
		private void setCheck(){
		    int _num    = this.Ranks.Length;
            int ydiv = ilog2(_num) / 2;
            int xdiv = ydiv;
            if(xdiv + ydiv != ilog2(_num)) xdiv += 1;
            xdiv = ipow2(xdiv);
            ydiv = ipow2(ydiv);
            _isiz1 = _nx0 / xdiv;
            if(_isiz1 * xdiv < _nx0) _isiz1++;
            _isiz2 = _nx0 / ydiv;
            if(_isiz2 * ydiv < _nx0) _isiz2++;
		}
		
		public static double mod(double a, double b) { return (a % b); }
        public static int ilog2(int i) {
            int log2, exp2 = 1;
            if(i <= 0) return (-1);
            for(log2 = 0; log2 < 20; log2++) {
                if(exp2 == i) return (log2);
                exp2 *= 2;
            }
            return (-1);
        }        
        public static int ipow2(int i) {
            int pow2 = 1;
            if(i < 0) return (-1);
            if(i == 0) return (1);
            while(i-->0) pow2 *= 2;
            return (pow2);
        }	
		
		protected int _north, _south, _east, _west;
		protected int _xdim, _ydim, _row, _col;
		protected int _nx0, _ny0, _nz0;
		protected int _nx, _ny, _nz, _ipt, _ist, _iend, _jpt, _jst, _jend;
		protected int _isiz1, _isiz2, _isiz3;
		
		public int north      {get { return _north; } set { _north = value; } }
		public int south      {get { return _south; } set { _south = value; } }
		public int east      {get { return _east; } set { _east = value; } }
		public int west      {get { return _west; } set { _west = value; } }	
			
		public int xdim      {get { return _xdim; } set { _xdim = value; } }
		public int ydim      {get { return _ydim; } set { _ydim = value; } }
		public int row       {get { return _row;  } set { _row  = value; } }
		public int col       {get { return _col;  } set { _col  = value; } }    
		    
		public int nx0      {get { return _nx0;  } set { _nx0  = value; } }	
		public int ny0      {get { return _ny0;  } set { _ny0  = value; } }
		public int nz0      {get { return _nz0;  } set { _nz0  = value; } }		
			
		public int nx   { get { return _nx;   } }
		public int ny   { get { return _ny;   } }
		public int nz   { get { return _nz;   } }
		
		public int ipt  { get { return _ipt;  } }
		public int ist  { get { return _ist;  } }
		public int iend { get { return _iend; } }
		public int jpt  { get { return _jpt;  } }
		public int jst  { get { return _jst;  } }
		public int jend { get { return _jend; } }
					
		public int isiz3 {get { return _isiz3;  } set { _isiz3  = value; } }	
	}
}
