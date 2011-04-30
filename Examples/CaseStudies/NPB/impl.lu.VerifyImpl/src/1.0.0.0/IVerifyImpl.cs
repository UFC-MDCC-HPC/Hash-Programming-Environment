using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.Verify;
using lu.problem_size.Instance;

namespace impl.lu.VerifyImpl { 
	public class IVerifyImpl<I, C> : BaseIVerifyImpl<I, C>, IVerify<I, C>
	where I:IInstance_LU<C>
	where C:IClass {
	   
	    private double[] xcr;
	    private double[] xce;
	    private double xci;
		
		public override int go() 
		{ 
            double[] xcrdif = new double[5];
            double[] xcedif = new double[5];
            double epsilon, xcidif;
            int m;
            Console.WriteLine("BEGIN VERIFY 1");
            PROBLEM_CLASS clss = Instance.CLASS;
            epsilon = 1.0E-08;
            verified = 1;
            Console.WriteLine("BEGIN VERIFY 2 " + (xcr == null) + " - " + (xce == null) + " - " + (xcrref == null));
            for(m = 0; m < 5; m++) 
            {
                xcrdif[m] = Math.Abs((xcr[m]-xcrref[m])/xcrref[m]);
                xcedif[m] = Math.Abs((xce[m]-xceref[m])/xceref[m]);
            }
            Console.WriteLine("BEGIN VERIFY 3");
            
            xcidif = Math.Abs((xci - xciref)/xciref);
            
            if(clss != PROBLEM_CLASS.U) 
            {
                Console.WriteLine(" Verification being performed for class " + clss);
                Console.WriteLine(" Accuracy setting for epsilon = " + epsilon);
                verified = (Math.Abs(dt-dtref) <= epsilon)?1:0;
                if(!(verified==1)) 
                {
                    clss = PROBLEM_CLASS.U;
                    Console.WriteLine(" DT does not match the reference value of " + dtref);
                }
            }
            else 
            {
                Console.WriteLine(" Unknown class");
            }
            
            if(clss != PROBLEM_CLASS.U) 
            {
                Console.WriteLine(" Comparison of RMS-norms of residual");
            }
            else 
            {
                Console.WriteLine(" RMS-norms of residual");
            }
            
            for(m = 0; m< 5; m++) 
            {
                if(clss == PROBLEM_CLASS.U) 
                {
                    Console.WriteLine("          " + m + " " + xcr[m]);
                }
                else if(xcrdif[m] <= epsilon) 
                {
                    Console.WriteLine("          " + m + " " + xcr[m] + " " + xcrref[m] + " " + xcrdif[m]);
                }
                else 
                {
                    Console.WriteLine(" FAILURE: "+m+" "+xcr[m]+" "+xcrref[m]+" "+xcrdif[m]);
                    verified = 0;
                }
            }
            
            if(clss != PROBLEM_CLASS.U) 
            {
                Console.WriteLine(" Comparison of RMS-norms of solution error");
            }
            else 
            {
                Console.WriteLine(" RMS-norms of solution error");
            }
            
            for(m = 0; m< 5; m++) 
            {
                if(clss == PROBLEM_CLASS.U) 
                {
                    Console.WriteLine("          " + m + " " + xce[m]);
                }
                else if(xcedif[m] <= epsilon) 
                {
                    Console.WriteLine("          "+m+" "+xce[m]+" "+xceref[m]+" "+xcedif[m]);
                }
                else 
                {
                    verified = 0;
                    Console.WriteLine(" FAILURE: "+m+" "+xce[m]+" "+xceref[m]+" "+xcedif[m]);
                }
            }
            if(clss != PROBLEM_CLASS.U) {
                Console.WriteLine(" Comparison of surface integral");
            }
            else {
                Console.WriteLine(" Surface integral");
            }
            if(clss == PROBLEM_CLASS.U) {
                Console.WriteLine("          "+xci);
            }
            else if(xcidif <= epsilon) {
                Console.WriteLine("          " + xci + " " + xciref + " " + xcidif);
            }
            else {
                verified = 0;
                Console.WriteLine(" FAILURE: " + xci + " " + xciref + " " + xcidif);
            }
            if(clss == PROBLEM_CLASS.U) {
                Console.WriteLine("No reference values provided");
                Console.WriteLine(" No verification performed");
            }
            else if(verified==1) {
                Console.WriteLine(" Verification Successful");
            }
            else {
                Console.WriteLine(" Verification failed");
            }
			return 0;
		}
		
		public void setParameters(double[] xcr, double[] xce, double xci)
		{
		   this.xcr = xcr;
		   this.xce = xce;
		   this.xci = xci;
		}
		
		protected int verified;
		public int Verified {get { return verified; } }
	}
}
