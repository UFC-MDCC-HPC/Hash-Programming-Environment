using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using ft.problem_size.Instance_FT;
using common.problem_size.Class;
using ft.data.ComputeInitialConditions;

namespace impl.ft.data.ComputeInitialConditionsImpl { 
	public class IComputeInitialConditionsImpl<I, C> : BaseIComputeInitialConditionsImpl<I, C>, IComputeInitialConditions<I, C>
	where I:IInstance_FT<C>
	where C:IClass{
	   
	    private double[, , ,] u1;
	
		public IComputeInitialConditionsImpl() { 
		
		} 
		
		public override int go() { 
            int k;
            double x0, start, an, dummy;
            double seed = 314159265, a = 1220703125;
            start = seed;
            an = ipow46(a, 2*nx, (zstart[0]-1)*ny + (ystart[0]-1));
            dummy = randlc(ref start, an);
            an = ipow46(a, 2*nx, ny);
            for(k = 0; k < dims[2, 0]; k++) {
                x0 = start;
                vranlc(2 * nx * dims[1, 0], x0, a, u1, k);
                if((k+1) != dims[2, 0])
                    dummy = randlc(ref start, an);
            }
		   return 0;
		}
        public double ipow46(double a, int exp_1, int exp_2) {
            double result;
            double dummy, q, r;
            int n, n2;
            bool  two_pow;
            result = 1;
            if(exp_2 == 0 || exp_1 == 0)
                return result;
            q = a;
            r = 1;
            n = exp_1;
            two_pow = true;

            while(two_pow) {
                n2 = n/2;
                if(n2 * 2 == n) {
                    dummy = randlc(ref q, q);
                    n = n2;
                }
                else {
                    n = n * exp_2;
                    two_pow = false;
                }
            }

            while(n > 1) {
                n2 = n/2;
                if(n2 * 2 == n) {
                    dummy = randlc(ref q, q);
                    n = n2;
                }
                else {
                    dummy = randlc(ref r, q);
                    n = n-1;
                }
            }
            dummy = randlc(ref r, q);
            result = r;
            return result;
        }
        public double randlc(ref double x, double a) {
            double r23, r46, t23, t46, t1, t2, t3, t4, a1, a2, x1, x2, z;

            r23 = Math.Pow(0.5, 23);
            r46 = Math.Pow(r23, 2);
            t23 = Math.Pow(2.0, 23);
            t46 = Math.Pow(t23, 2);

            t1 = r23 * a;
            a1 = (int)(t1);
            a2 = a - t23 * a1;

            t1 = r23 * x;
            x1 = (int)(t1);
            x2 = x - t23 * x1;


            t1 = a1 * x2 + a2 * x1;
            t2 = (int)(r23 * t1);
            z = t1 - t23 * t2;
            t3 = t23 * z + a2 * x2;
            t4 = (int)(r46 * t3);
            x = t3 - t46 * t4;
            return (r46*x);
        }
        public void vranlc(int n, double x, double a, double[, , ,] u1, int k) {
            double r23, r46, t23, t46;
            int nv;
            r23 = Math.Pow(2.0, (-23));
            r46 = r23 * r23;
            t23 = Math.Pow(2.0, 23);
            t46 = t23 * t23;
            nv = 64;
            double[] xv = new double[nv];
            double t1, t2, t3, t4, an, a1=0, a2=0, x1, x2, yy;
            int n1, i, j;
            t1 = x;
            n1 = (int)min(n, nv);
            for(i = 1; i <= n1; i++) {
                xv[i-1] = t46 * randlc(ref t1, a);
            }
            if(n > nv) {
                t1 = a;
                t2 = r46 * a;

                for(i = 1; i <= nv - 1; i++) {
                    t2 = randlc(ref t1, a);
                }
                an = t46 * t2;
                t1 = r23 * an;
                a1 = (int)(t1);
                a2 = an - t23 * a1;
            }
            for(j = 0; j <= n - 1; j = j + nv) {
                n1 = (int)min(nv, n - j);
                int io;
                for(i = 0; i < n1; i++) {
                    io = (i + j) + (2 * nx * dims[1, 0] * k);

                    int m1 = (io % size1);
                    int m2 = (m1 % size2);
                    int _i = io/size1;
                    int _j = m1/size2;
                    int _k = m2/2;
                    int _t = (m2 % 2);

                    u1[_i, _j, _k, _t] = r46*xv[i];
                }
                if(j + n1 == n) {
                    x = xv[n1-1];
                    return;
                }
                for(i = 0; i < nv; i++) {
                    t1 = r23 * xv[i];
                    x1 = (int)(t1);
                    x2 = xv[i] - t23 * x1;
                    t1 = a1 * x2 + a2 * x1;
                    t2 = (int)(r23 * t1);
                    yy = t1 - t23 * t2;
                    t3 = t23 * yy + a2 * x2;
                    t4 = (int)(r46 * t3);
                    xv[i] = t3 - t46 * t4;
                }
            }
        }
        public double min(int n1, int n2) { return n1 < n2 ? n1 : n2; }		
		public void setParameters(double[, , ,] u1){
		   this.u1 = u1;
		}
	}
}
