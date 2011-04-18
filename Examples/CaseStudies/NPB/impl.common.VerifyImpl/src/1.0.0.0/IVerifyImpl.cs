using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.Verify;
using common.problem_size.Class;
using common.problem_size.Instance;
using NPB3_0_JAV.BMInOut;

namespace impl.common.VerifyImpl { 

public class IVerifyImpl<I,C> : BaseIVerifyImpl<I,C>, IVerify<I,C>
where I:IInstance<C>
where C:IClass
{

public IVerifyImpl() { 

} 
		
		
private int[] grid_points;
private static String BMName = "SP";
private int verified = -1;
		
public int Verified { get { return verified; } }		
		
public override int go() { 
			
		int no_time_steps = Instance.niter_default;
		double dt = Instance.dt_default;
			
		grid_points = Problem.grid_points;	
			
        double[] xcrref = Instance.xcrref, xceref = Instance.xceref,
                 xcrdif = new double[5], xcedif = new double[5],
                 xce = Error_norm.xce, xcr = Rhs_norm.xcr;
        double dtref = Instance.dtref;
        int m;
        
        PROBLEM_CLASS clss = Instance.CLASS;
			
        //---------------------------------------------------------------------
        //   compute the error norm and the residual norm, and exit if not printing
        //---------------------------------------------------------------------
			
        // error_norm(xce);		
		Error_norm.go();
		
        // copy_faces();
		if (Ranks.Length > 1)
			Copy_faces.go();
			
		Compute_rhs.go();	
			
        //rhs_norm(xcr);
		Rhs_norm.go();

        for (m = 0; m < 5; m++) 
            xcr[m] /= dt;

        //for (m = 0; m < 5; m++)
        //{
        //    xcrref[m] = 1.0d;
        //    xceref[m] = 1.0d;
        //}
			
        //---------------------------------------------------------------------
        //    verification test for residuals if gridsize is either 12X12X12 or 
        //    64X64X64 or 102X102X102 or 162X162X162
        //---------------------------------------------------------------------

        //---------------------------------------------------------------------
        //    Compute the difference of solution values and the known reference values.
        //---------------------------------------------------------------------
        for (m = 0; m < 5; m++)
        {
            xcrdif[m] = Math.Abs((xcr[m] - xcrref[m]) / xcrref[m]);
            xcedif[m] = Math.Abs((xce[m] - xceref[m]) / xceref[m]);
        }
        //---------------------------------------------------------------------
        //   tolerance level
        //---------------------------------------------------------------------
        double epsilon = 1.0E-8d;
        //---------------------------------------------------------------------
        //    Output the comparison of computed results to known cases.
        //---------------------------------------------------------------------
        if (clss != PROBLEM_CLASS.U)
        {
            Console.WriteLine(" Verification being performed for class " + clss);
            Console.WriteLine(" Accuracy setting for epsilon = " + epsilon);
            if (Math.Abs(dt - dtref) <= epsilon)
            {
                if (verified == -1) verified = 1;
            }
            else
            {
                verified = 0;
                clss = PROBLEM_CLASS.U;
                Console.WriteLine("DT does not match the reference value of " + dtref);
            }
            Console.WriteLine(" Comparison of RMS-norms of residual");
        }
        else
        {
            Console.WriteLine(" Unknown CLASS");
            Console.WriteLine(" RMS-norms of residual");
        }
        verified = BMResults.printComparisonStatus(clss.ToString()[0], verified, epsilon,
                                                 xcr, xcrref, xcrdif);
        if (clss != PROBLEM_CLASS.U)
        {
            Console.WriteLine(" Comparison of RMS-norms of solution error");
        }
        else
        {
            Console.WriteLine(" RMS-norms of solution error");
        }
        verified = BMResults.printComparisonStatus(clss.ToString()[0], verified, epsilon,
                                                 xce, xceref, xcedif);

        BMResults.printVerificationStatus(clss.ToString()[0], verified, BMName);
			
		return 0;
			
} // end activate method 

}

}
