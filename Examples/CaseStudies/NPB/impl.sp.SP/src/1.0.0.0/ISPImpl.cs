using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using sp.SP;
using common.data.ProblemDefinition;
using MPI;
using NPB3_0_JAV.BMInOut;

namespace impl.sp.SP { 

	public class ISPImpl<CLASS> : BaseISPImpl<CLASS>, ISP<CLASS>
		where CLASS:IClass
	{
        public int bid = -1;
    	public static String BMName = "SP";
		public char PROBLEM_CLASS = 'S';
		
		protected bool active;
		protected int node, no_nodes, total_nodes, root ,maxcells;
	    protected Intracommunicator worldcomm, comm_setup, comm_solve, comm_rhs = null;
		
		private int[,] cell_size;
		private int[] grid_points;
		
		private int problem_size;
		
		public BMResults results;
		
		public ISPImpl() 
	    { 
		
			setup_mpi();
			
			Problem.initialize_problem_data();
			
			Initialize.initialize();
			Lhsinit.initialize();
			Exact_rhs.initialize();
						
			cell_size = Blocks.cell_size;
			
			grid_points = Problem.grid_points;
			
			problem_size = Instance.problem_size;
			
			PROBLEM_CLASS = Instance.CLASS;			
		} 
		
		private void runBenchmark()
		{
		    if (!active)
		    {
		        Console.WriteLine("not active !");
		        System.Environment.Exit(0);
		    }
		
		    int niter = -1;
		    if (node == root)
		    {
		        BMArgs.Banner(BMName, PROBLEM_CLASS, false, total_nodes);
		
		    }
		
		    //---------------------------------------------------------------------
		    //      Read input file (if it exists), else take
		    //      defaults from parameters
		    //---------------------------------------------------------------------
		    //niter = getInputPars();
		
		    //comm_setup.Broadcast<int>(ref niter, root);
		    //comm_setup.Broadcast<int>(ref dp_type, root);
		    //comm_setup.Broadcast<int>(ref grid_points, root);
		    
		    Process.make_set();
		
//		    for (int c = 0; c < ncells; c++)
//		    {
//		        if ((cell_size[c, 0] > IMAX) ||
//		            (cell_size[c, 1] > JMAX) ||
//		            (cell_size[c, 2] > KMAX))
//		        {
//		            Console.WriteLine("Problem size too big for compiled array sizes");
//		            System.Environment.Exit(0);
//		        }
//		    }
		
			
		    Constants.set_constants(0, grid_points);
			Initialize.compute();
			Lhsinit.compute();
			Exact_rhs.compute();
		    //compute_buffer_size(5);
		
		    //---------------------------------------------------------------------
		    //      do one time step to touch all code, and reinitialize
		    //---------------------------------------------------------------------
		    Adi.compute();
		    Initialize.compute();
		
		    //---------------------------------------------------------------------
		    //      Synchronize before placing time stamp
		    //---------------------------------------------------------------------
		    // mpi_barrier(comm_setup, error);
		    comm_setup.Barrier();
		
//		    timer.resetAllTimers();
//		    timer.start(t_total);
		
		    Console.WriteLine("STARTING"); Console.Out.Flush();
		
		    for (int step = 1; step <= niter; step++)
		    {
		        if (node == 0 && (step % 20 == 0 || step == 1 || step == niter))
		        {
		            Console.WriteLine("Time step " + step);
		        }
				Adi.compute();
		    }
//		    timer.stop(1);
			Verify.compute(); // verify(niter);
		    int verified = Verify.Verified;
		
		    double tmax = 0; //comm_setup.Reduce<double>(timer.readTimer(t_total), Operation<double>.Max, root);
		
		    if (node == root)
		    {
		        double time = 0; // timer.readTimer(t_total);
		        results = new BMResults(BMName,
		                      PROBLEM_CLASS,
		                      grid_points[0],
		                      grid_points[1],
		                      grid_points[2],
		                      niter,
		                      time,
		                      getMFLOPS(time, niter),
		                      "floating point",
		                      verified,
		                      true,
		                      total_nodes,
		                      bid);
		        results.print();
		    }
		
		    worldcomm.Barrier();
//		    mpi.Dispose();
		}
		
		public override void compute() 
		{           
			runBenchmark();	
		
		} // end activate method 
		
	    private void setup_mpi()
	    {
	        int nc, color;
	
	//        string[] args = System.Environment.GetCommandLineArgs();
	//        mpi = new MPI.Environment(ref args);
	        
	        worldcomm = this.LocalCommunicator;
	
	        total_nodes = worldcomm.Size;
	        node = worldcomm.Rank;
	
	        //---------------------------------------------------------------------
	        //     compute square root; add small number to allow for roundoff
	        //---------------------------------------------------------------------
	        nc = Convert.ToInt32(Math.Sqrt(total_nodes) + 0.00001d);
	        maxcells = Convert.ToInt32(Math.Sqrt(total_nodes));
	
	        //---------------------------------------------------------------------
	        // We handle a non-square number of nodes by making the excess nodes
	        // inactive. However, we can never handle more cells than were compiled
	        // in. 
	        //---------------------------------------------------------------------
	
	        if (nc > maxcells) nc = maxcells;
	
	        if (node >= nc * nc)
	        {
	            active = false;
	            color = 1;
	        }
	        else
	        {
	            active = true;
	            color = 0;
	        }
	
	        comm_setup = (Intracommunicator)worldcomm.Split(color, node);
	
	        if (!active) return;
	
	        no_nodes = comm_setup.Size;
	        comm_solve = (Intracommunicator)comm_setup.Clone();
	        comm_rhs = (Intracommunicator)comm_setup.Clone();
	
	
	        //---------------------------------------------------------------------
	        //     let node 0 be the root for the group (there is only one)
	        //---------------------------------------------------------------------
	        root = 0;
	    }
	
	    public double getMFLOPS(double total_time, int niter)
	    {
	        double mflops = 0.0d;
	        if (total_time > 0)
	        {
	            mflops = (881.174d * Math.Pow(problem_size, 3)
	                    - 4683.91d * Math.Pow(problem_size, 2)
	                    + 11484.5d * problem_size
	                    - 19272.4d) * niter / (1.0d * 1000000.0d);
	        }
	        return mflops;
	    }
		

	}

}
