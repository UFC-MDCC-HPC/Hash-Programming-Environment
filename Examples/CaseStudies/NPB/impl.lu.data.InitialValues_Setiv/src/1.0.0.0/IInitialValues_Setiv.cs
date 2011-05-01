using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using lu.problem_size.Instance_LU;
using common.problem_size.Class;
using lu.data.InitialValues;

namespace impl.lu.data.InitialValues_Setiv 
{ 

	public class IInitialValues_Setiv<I, C> : BaseIInitialValues_Setiv<I, C>, IInitialValues<I, C>
		where I:IInstance_LU<C>
		where C:IClass
	{
	
		public override int go() 
		{ 
            int i, j, k, m;
            int iglob, jglob;
            double  xi, eta, zeta;
            double  pxi, peta, pzeta;
            double[,,,] ue_1jk   = new double[1, 1, 1, 5];
            double[,,,] ue_nx0jk = new double[1, 1, 1, 5];
            double[,,,] ue_i1k   = new double[1, 1, 1, 5];
            double[,,,] ue_iny0k = new double[1, 1, 1, 5];
            double[,,,] ue_ij1   = new double[1, 1, 1, 5];
            double[,,,] ue_ijnz  = new double[1, 1, 1, 5];
            
            for(k = 2; k<=nz-1; k++) 
            {
                zeta = ((double)(k-1))/(nz-1);
                for(j = 1; j<= ny; j++) 
                {
                    jglob = jpt + j;
                    if(jglob!=1 && jglob!=ny0) 
                    {
                        eta = ((double)(jglob-1))/(ny0-1);
                        for(i = 1; i<= nx; i++) 
                        {
                            iglob = ipt + i;
                            if(iglob!=1 && iglob!=nx0) 
                            {
                                xi = ((double)(iglob-1))/(nx0-1);
                                Exact.setParameters(1, jglob, k, ue_1jk, 0, 0, 0);
                                Exact.go();
                                Exact.setParameters(nx0, jglob, k, ue_nx0jk, 0, 0, 0);
                                Exact.go();
                                Exact.setParameters(iglob, 1, k, ue_i1k, 0, 0, 0);
                                Exact.go();
                                Exact.setParameters(iglob, ny0, k, ue_iny0k, 0, 0, 0);
                                Exact.go();
                                Exact.setParameters(iglob, jglob, 1, ue_ij1, 0, 0, 0);
                                Exact.go();
                                Exact.setParameters(iglob, jglob, nz, ue_ijnz, 0, 0, 0);
                                Exact.go();
                                for(m = 0; m< 5; m++) 
                                {
                                    pxi =   (1.0d-xi) * ue_1jk[0, 0, 0, m] + xi   * ue_nx0jk[0, 0, 0, m];
                                    peta =  (1.0d-eta) * ue_i1k[0, 0, 0, m] + eta   * ue_iny0k[0, 0, 0, m];
                                    pzeta = (1.0d-zeta) * ue_ij1[0, 0, 0, m] + zeta   * ue_ijnz[0, 0, 0, m];
                                    u[k-1, j+1, i+1, m] = pxi + peta + pzeta - pxi * peta - peta * pzeta - pzeta * pxi + pxi * peta * pzeta;
                                }
                            }
                        }
                    }
                }
            }
			return 0;
		}
	}
}
