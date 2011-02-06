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
		
public override void compute() { 
			
		int no_time_steps = Instance.niter_default;
		double dt = Instance.dt_default;
			
		grid_points = Problem.grid_points;	
			
        double[] xcrref = new double[5], xceref = new double[5],
                 xcrdif = new double[5], xcedif = new double[5],
                 xce = Error_norm.xce, xcr = Rhs_norm.xcr;
        double dtref = 0;
        int m;
        
        char clss = 'U';
			
        //---------------------------------------------------------------------
        //   compute the error norm and the residual norm, and exit if not printing
        //---------------------------------------------------------------------
			
        // error_norm(xce);		
		Error_norm.compute();
		
        // copy_faces();
		Copy_faces.synchronize();
		
        //rhs_norm(xcr);
		Rhs_norm.compute();

        for (m = 0; m < 5; m++) 
            xcr[m] /= dt;

        for (m = 0; m < 5; m++)
        {
            xcrref[m] = 1.0d;
            xceref[m] = 1.0d;
        }
        //---------------------------------------------------------------------
        //    reference data for 12X12X12 grids after 100 time steps, with DT = 1.50d-02
        //---------------------------------------------------------------------
        if (grid_points[0] == 12
              && grid_points[1] == 12
              && grid_points[2] == 12
              && no_time_steps == 100
        )
        {

            clss = 'S';
            dtref = .015d;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of residual.
            //---------------------------------------------------------------------
            xcrref[0] = 2.7470315451339479E-2d;
            xcrref[1] = 1.0360746705285417E-2d;
            xcrref[2] = 1.6235745065095532E-2d;
            xcrref[3] = 1.5840557224455615E-2d;
            xcrref[4] = 3.4849040609362460E-2d;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of solution error.
            //---------------------------------------------------------------------
            xceref[0] = 2.7289258557377227E-5d;
            xceref[1] = 1.0364446640837285E-5d;
            xceref[2] = 1.6154798287166471E-5d;
            xceref[3] = 1.5750704994480102E-5d;
            xceref[4] = 3.4177666183390531E-5d;


            //---------------------------------------------------------------------
            //    reference data for 36X36X36 grids after 400 time steps, with DT = 
            //---------------------------------------------------------------------
        }
        else if ((grid_points[0] == 36) &&
               (grid_points[1] == 36) &&
               (grid_points[2] == 36) &&
               (no_time_steps == 400))
        {

            clss = 'W';
            dtref = .0015;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of residual.
            //---------------------------------------------------------------------
            xcrref[0] = 0.1893253733584E-2d;
            xcrref[1] = 0.1717075447775E-3d;
            xcrref[2] = 0.2778153350936E-3d;
            xcrref[3] = 0.2887475409984E-3d;
            xcrref[4] = 0.3143611161242E-2d;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of solution error.
            //---------------------------------------------------------------------
            xceref[0] = 0.7542088599534E-4d;
            xceref[1] = 0.6512852253086E-5d;
            xceref[2] = 0.1049092285688E-4d;
            xceref[3] = 0.1128838671535E-4d;
            xceref[4] = 0.1212845639773E-3d;

            //---------------------------------------------------------------------
            //    reference data for 64X64X64 grids after 400 time steps, with DT = 1.5d-03
            //---------------------------------------------------------------------
        }
        else if ((grid_points[0] == 64) &&
              (grid_points[1] == 64) &&
              (grid_points[2] == 64) &&
              (no_time_steps == 400))
        {

            clss = 'A';
            dtref = .0015d;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of residual.
            //---------------------------------------------------------------------
            xcrref[0] = 2.4799822399300195d;
            xcrref[1] = 1.1276337964368832d;
            xcrref[2] = 1.5028977888770491d;
            xcrref[3] = 1.4217816211695179d;
            xcrref[4] = 2.1292113035138280d;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of solution error.
            //---------------------------------------------------------------------
            xceref[0] = 1.0900140297820550E-4d;
            xceref[1] = 3.7343951769282091E-5d;
            xceref[2] = 5.0092785406541633E-5d;
            xceref[3] = 4.7671093939528255E-5d;
            xceref[4] = 1.3621613399213001E-4d;

            //---------------------------------------------------------------------
            //    reference data for 102X102X102 grids after 400 time steps,
            //    with DT = 1.0d-03
            //---------------------------------------------------------------------
        }
        else if ((grid_points[0] == 102) &&
              (grid_points[1] == 102) &&
              (grid_points[2] == 102) &&
              (no_time_steps == 400))
        {

            clss = 'B';
            dtref = .001d;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of residual.
            //---------------------------------------------------------------------
            xcrref[0] = 0.6903293579998E+02d;
            xcrref[1] = 0.3095134488084E+02d;
            xcrref[2] = 0.4103336647017E+02d;
            xcrref[3] = 0.3864769009604E+02d;
            xcrref[4] = 0.5643482272596E+02d;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of solution error.
            //---------------------------------------------------------------------
            xceref[0] = 0.9810006190188E-02d;
            xceref[1] = 0.1022827905670E-02d;
            xceref[2] = 0.1720597911692E-02d;
            xceref[3] = 0.1694479428231E-02d;
            xceref[4] = 0.1847456263981E-01d;

            //---------------------------------------------------------------------
            //    reference data for 162X162X162 grids after 400 time steps,
            //    with DT = 0.67d-03
            //---------------------------------------------------------------------
        }
        else if ((grid_points[0] == 162) &&
              (grid_points[1] == 162) &&
              (grid_points[2] == 162) &&
              (no_time_steps == 400))
        {

            clss = 'C';
            dtref = .00067d;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of residual.
            //---------------------------------------------------------------------
            xcrref[0] = 0.5881691581829E+03d;
            xcrref[1] = 0.2454417603569E+03d;
            xcrref[2] = 0.3293829191851E+03d;
            xcrref[3] = 0.3081924971891E+03d;
            xcrref[4] = 0.4597223799176E+03d;

            //---------------------------------------------------------------------
            //    Reference values of RMS-norms of solution error.
            //---------------------------------------------------------------------
            xceref[0] = 0.2598120500183d;
            xceref[1] = 0.2590888922315E-01d;
            xceref[2] = 0.5132886416320E-01d;
            xceref[3] = 0.4806073419454E-01d;
            xceref[4] = 0.5483377491301d;
        }
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
        if (clss != 'U')
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
                clss = 'U';
                Console.WriteLine("DT does not match the reference value of " + dtref);
            }
            Console.WriteLine(" Comparison of RMS-norms of residual");
        }
        else
        {
            Console.WriteLine(" Unknown CLASS");
            Console.WriteLine(" RMS-norms of residual");
        }
        verified = BMResults.printComparisonStatus(clss, verified, epsilon,
                                                 xcr, xcrref, xcrdif);
        if (clss != 'U')
        {
            Console.WriteLine(" Comparison of RMS-norms of solution error");
        }
        else
        {
            Console.WriteLine(" RMS-norms of solution error");
        }
        verified = BMResults.printComparisonStatus(clss, verified, epsilon,
                                                 xce, xceref, xcedif);

        BMResults.printVerificationStatus(clss, verified, BMName);
			
} // end activate method 

}

}
