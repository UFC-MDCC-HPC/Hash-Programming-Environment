using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using bt.problem_size.Instance_BT;
using common.problem_size.Class;
using common.orientation.Y;
using bt.solve.BeamWarmingMethod;
using bt.solve.BackSubstitute;

namespace impl.bt.solve.YBackSubstitute { 

public class IYBackSubstituteImpl<I, C, DIR, MTH> : BaseIYBackSubstituteImpl<I, C, DIR, MTH>, IBackSubstitute<I, C, DIR, MTH>
where I:IInstance_BT<C>
where C:IClass
where DIR:IY
where MTH:IBeamWarmingMethod
{
private double[,,,,,] lhsc;
private double[,,,] backsub_info;
private int first, last, c;

public void setParameters(double[,,,,,] lhsc, double[,,,] backsub_info, int first, int last, int c){
   this.lhsc = lhsc;
   this.backsub_info = backsub_info;
   this.first = first;
   this.last = last;
   this.c = c;
}

public IYBackSubstituteImpl() { 

} 

public override void compute() { 
	int i, k;
	int m, n, j, jsize, isize, ksize, jstart;
	
	jstart = 2;	
	isize = cell_size[c, 0] - end[c, 0] + 1;
	jsize = cell_size[c, 1] + 1;
	ksize = cell_size[c, 2] - end[c, 2] + 1;
	if(last == 0) {
	    for(k = start[c, 2]; k <= ksize; k++) {
	        for(i = start[c, 0]; i <= isize; i++) {
	            //---------------------------------------------------------------------
	            //     U[jsize] uses info from previous cell if not last cell
	            //---------------------------------------------------------------------
	            for(m = 0; m < 5; m++) {
	                for(n = 0; n < 5; n++) { //rhs[m,i,jsize,k,c]=rhs[m,i,jsize,k,c]-lhsc[m,n,i,jsize,k,c]*backsub_info[n,i,k,c];
	                    rhs[c, k, jsize, i, m] = rhs[c, k, jsize, i, m] - lhsc[c, k, jsize, i, n, m] * backsub_info[c, k, i, n];
	                }
	            }
	        }
	    }
	}
	for(k = start[c, 2]; k <= ksize; k++) {
	    for(j = jsize-1; j >= jstart; j--) {//for(j=jsize-1,jstart,-1;
	        for(i = start[c, 0]; i <= isize; i++) {
	            for(m = 0; m < 5; m++) {
	                for(n = 0; n < 5; n++) {  //rhs[m,i,j,k,c] = rhs[m,i,j,k,c] - lhsc[m,n,i,j,k,c]*rhs[n,i,j+1,k,c];
	                    rhs[c, k, j, i, m] = rhs[c, k, j, i, m] - lhsc[c, k, j, i, n, m] * rhs[c, k, j+1, i, n];
	                }
	            }
	        }
	    }
	}
} // end activate method 

}

}
