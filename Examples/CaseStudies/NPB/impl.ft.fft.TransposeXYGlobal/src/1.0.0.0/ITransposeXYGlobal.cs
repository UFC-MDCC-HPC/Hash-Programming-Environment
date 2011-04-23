using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using common.orientation.XY;
using ft.fft.TransposeGlobal;
using MPI;

namespace impl.ft.fft.TransposeXYGlobal { 
	public class ITransposeXYGlobal<I, C, DIR> : BaseITransposeXYGlobal<I, C, DIR>, ITransposeGlobal<I, C, DIR>
	where I:IInstance_FT<C>
	where C:IClass
	where DIR:IXY{
	   
	    private int d1, d2, d3;
	    private double[, , ,] xin;
	    private double[, , ,] xout;
	    protected Intracommunicator worldcomm, commslice2;
	
		public ITransposeXYGlobal() { 
		
		} 
		
		public override int go() { 
            double[] src       = new double[d1*d2*d3*2];
            double[] dst       = new double[d1*d2*d3*2];            
            worldcomm = this.WorldComm;
            commslice2 = (Intracommunicator)worldcomm.Split(me2, me1);
            setVetor(xin, src);
            commslice2.AlltoallFlattened<double>(src, d1*d2*d3*2/np1, ref dst);
            setVetor(dst, xout);
		   return 0;
		}
		public void setParameters(int d1, int d2, int d3, double[, , ,] xin, double[, , ,] xout) {
		   this.d1 = d1;
		   this.d2 = d2;
		   this.d3 = d3;
		   this.xin = xin;
		   this.xout = xout;
		}
        public static unsafe void setVetor(double[, , ,] s, double[] d) {
            int size = s.Length;
            if(size == d.Length) {
                fixed(double* ps = s, pd = d) {
                    double* p1 = ps;
                    double* p2 = pd;
                    for(int n = 0; n < size/2; n++) {
                        *((decimal*)p2) = *((decimal*)p1);
                        p2 += 2;
                        p1 += 2;
                    }
                }
            }
            else {
                throw new IndexOutOfRangeException();
            }
        }
        public static unsafe void setVetor(double[] s, double[, , ,] d) {
            int size = s.Length;
            if(size == d.Length) {
                fixed(double* ps = s, pd = d) {
                    double* p1 = ps;
                    double* p2 = pd;
                    for(int n = 0; n < size / 2; n++) {
                        *((decimal*)p2) = *((decimal*)p1);
                        p2 += 2;
                        p1 += 2;
                    }
                }
            }
            else {
                throw new IndexOutOfRangeException();
            }
        }
	}
}
