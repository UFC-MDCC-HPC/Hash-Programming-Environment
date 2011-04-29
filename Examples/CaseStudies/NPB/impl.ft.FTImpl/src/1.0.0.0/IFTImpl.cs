using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.problem_size.Class;
using ft.FT;
using MPI;
using NPB3_0_JAV.BMInOut;

namespace impl.ft.FTImpl { 
	public class IFTImpl<C> : BaseIFTImpl<C>, IFT<C>
	where C:IClass{
	   
	    private Intracommunicator worldcomm;
	    private int node, np, np1, np2, layout_type, root=0;
	    public static String BMName = "FT";
		protected int[,] dims;
		protected double[] twiddle;
	    protected double [,,,] u0;
	    protected double [,,,] u1;
	    protected double [,,,] u2;
	
		public IFTImpl() { 
		
		} 
		
		public override int go() { 
			runBenchMark();	
			return 0;
		}
        public void runBenchMark() {
            worldcomm = this.WorldComm;
            np = worldcomm.Size;
            node = worldcomm.Rank;
            for(int i = 1; i <= T_max; i++) Timer.resetTimer(i);
            int niter = initialConfig();
            
            Problem.problemConfig(np1, np2, layout_type);
            Blocks.blocksConfig(nx, ny, nz, np1, np2, layout_type);
            
			dims = Problem.dims;
			twiddle = Problem.twiddle;
			u0 = Problem.Field_u0;
			u1 = Problem.Field_u1;
			u2 = Problem.Field_u2;
            
            Compute_index_map.setParameters(twiddle, dims[0, 2], dims[1, 2], dims[2, 2]);
            Compute_index_map.go();            
            Compute_initial_conditions.setParameters(u1);
            Compute_initial_conditions.go();
            Fftinit.setParameters(dims[0, 0]);
            Fftinit.go();            
            Fft.setParameters(1, u1, u0);
            Fft.go();

            for(int i = 1; i <= T_max; i++) Timer.resetTimer(i);
            worldcomm.Barrier();

            Timer.start(T_total);

            Compute_index_map.setParameters(twiddle, dims[0, 2], dims[1, 2], dims[2, 2]);
            Compute_index_map.go();
            Compute_initial_conditions.setParameters(u1);
            Compute_initial_conditions.go();
            Fftinit.setParameters(dims[0, 0]);
            Fftinit.go();

            Fft.setParameters(1, u1, u0);
            Fft.go();

            double[] sums = new double[niter_default*2];
            for(int iter = 0; iter < niter; iter++) {
                Evolve.setParameters(u0, u1, twiddle, dims[0, 0], dims[1, 0], dims[2, 0]);
                Evolve.go();
                Fft.setParameters(-1, u1, u2);
                Fft.go();
                Checksum.setParameters(iter, sums, u2, dims[0, 0], dims[1, 0], dims[2, 0]);
                Checksum.go();
            }
            Verify.setParameters(niter, sums);
            int verified = Verify.go();
            Timer.stop(T_total);
            double total_time = Timer.readTimer(T_total);

            double ntotal_f = (double)(nx*ny*nz);
            double mflops=0.0;
            if(total_time != 0) {
                mflops = 0.000001*ntotal_f * (14.8157+7.19641*Math.Log(ntotal_f) +  (5.23518+7.21113*Math.Log(ntotal_f))*niter)/total_time;
            }
            else {
                mflops = 0.0;
            }
            if(node == 0) {
                BMResults results = new BMResults(BMName,
                                        problem_class.ToString()[0],
                                        nx,
                                        ny,
                                        nz,
                                        niter,
                                        total_time,
                                        mflops,
                                        "floating point",
                                        verified,
                                        true,
                                        np,
                                        -1);
                results.print();
            }
        }
        public int initialConfig() {
            int fstatus=0, niter=0;
            if(node == 0) {
                Console.WriteLine(" NAS Parallel Benchmarks "+ "3.3" +" -- FT Benchmark ");
                try {
                    Console.Write("Trying Read from input file inputft.data: ");
                    int[] conf = { 1, 1, 2 };//Line 1: 1 var; Line 2: 1 var; Line 3: 2 vars;
                    string[] vetTemp = readFileData("inputft.data", conf);
                    niter = int.Parse(vetTemp[0]);
                    layout_type = int.Parse(vetTemp[1]);
                    np1 = int.Parse(vetTemp[2]);
                    np2 = int.Parse(vetTemp[3]);
                }
                catch {
                    Console.WriteLine("inputft.data not found");
                    fstatus = 1;
                }

                if(fstatus == 0) {
                    Console.WriteLine("inputft.data found");
                    if(np1 * np2 != np) {
                        Console.WriteLine(" np1 and np2 given in input file are not valid.");
                        Console.WriteLine("Product is "+ np1*np2+" and should be "+np);
                        System.Environment.Exit(0);
                    }
                    if(layout_type != layout_0D && layout_type != layout_1D && layout_type != layout_2D) {
                        Console.WriteLine(" Layout type specified in inputft.data is invalid ");
                        System.Environment.Exit(0);
                    }
                    if(layout_type == layout_0D && (np1 != 1 || np2 != 1)) {
                        Console.WriteLine(" For 0D layout, both np1 and np2 must be 1 ");
                        System.Environment.Exit(0);
                    }
                    if(layout_type == layout_1D && np1 != 1) {
                        Console.WriteLine(" For 1D layout, np1 must be 1 ");
                        System.Environment.Exit(0);
                    }
                }
                else {
                    Console.WriteLine(" No input file inputft.data. Using compiled defaults");
                    niter = niter_default;
                    if(np == 1) {
                        np1 = 1;
                        np2 = 1;
                        layout_type = layout_0D;
                    }
                    else if(np <= nz) {
                        np1 = 1;
                        np2 = np;
                        layout_type = layout_1D;
                    }
                    else {
                        np1 = nz;
                        np2 = np/nz;
                        layout_type = layout_2D;
                    }
                }
                Console.WriteLine(" Size: " + nx + "x" + ny + "x" + nz);
                Console.WriteLine(" Iterations: "+ niter);
                Console.WriteLine(" Number of processes : "+ np);
                Console.WriteLine(" Processor array     : "+np1+"x"+np2);
                if(layout_type == layout_0D) {
                    Console.WriteLine(" Layout type: OD");
                }
                else if(layout_type == layout_1D) {
                    Console.WriteLine(" Layout type: 1D");
                }
                else {
                    Console.WriteLine(" Layout type: 2D");
                }
            }
            worldcomm.Broadcast<int>(ref np1, root);
            worldcomm.Broadcast<int>(ref niter, root);
            worldcomm.Broadcast<int>(ref np2, root);
            if(np1 == 1 && np2 == 1) {
                layout_type = layout_0D;
            }
            else if(np1 == 1) {
                layout_type = layout_1D;
            }
            else {
                layout_type = layout_2D;
            }
            return niter;
        }
        public static string[] readFileData(string path, int[] conf) {
            String s, temp = ""; int size = 0;
            for (int i = 0; i < conf.Length; i++) { if (conf[i]!=0) size = size + conf[i]; }
            string[] vet = new string[size];
            int count = 0;
            System.IO.StreamReader file = new System.IO.StreamReader(path);
            for (int k = 0; k < conf.Length; k++) {
                s = file.ReadLine(); s = s.Trim(' ');
                for (int j = 0; j < conf[k]; j++) {
                    for (int i = 0; i <= s.Length; i++) {
                        if (s.Length == 0) {
                            break;
                        }
                        else { if (s[0] == ' ') break; }
                        temp = temp + s[0];
                        s = s.Substring(1);
                        i--;
                    }
                    vet[count++] = temp; temp = "";
                    s = s.Trim(' ');
                }
            }
            for (int i = 0; i < vet.Length; i++) {
                string tTemp = "";
                for (int j = 0; j < vet[i].Length; j++) {
                    if (vet[i][j] == '.') {
                        tTemp = tTemp + ',';
                    }
                    else tTemp = tTemp + vet[i][j];
                }
                vet[i] = tTemp;
            }
            return vet;
        }
	}
}
