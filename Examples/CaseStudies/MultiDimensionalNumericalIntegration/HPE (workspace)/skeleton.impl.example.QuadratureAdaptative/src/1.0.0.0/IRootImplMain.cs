using System;
using DGAC;
using data.Function.TestingFunction;

namespace skeleton.impl.example.QuadratureAdaptative { 

	public class IRootImplMain {

		static void Main(string [] args) {

			IRootImpl<ITestingFunction> root = new IRootImpl<ITestingFunction>();

			BackEnd.DGACInit("00240000048000009400000006020000002400005253413100040000110000006d05c82bff26ad72150a252c8c9742c86f6c62e6fe0cb696e223e19c0441a20a249526c60ee5553b2eddc609f73c569a23cfd334b51d25d1bd36d608dc901932e635a71bce017f93a1aabc8a129f65b9a7d3d384b42ae038d9d1006b984abdf11cc686520195bdac3acc399a24871f11885f37168f0ac04580fbce53d438e394","root",root,args);
            TimeSpan timeW = TimeSpan.FromSeconds(0);
			DateTime startTimeW = DateTime.Now;
			root.createSlices();
			DateTime stopTimeW = DateTime.Now;
			timeW = stopTimeW - startTimeW;
            Console.WriteLine("STARTUP TIME = " + timeW.TotalMilliseconds + "ms");
			root.compute();
			BackEnd.DGACFinalize();
		}

	}

}
