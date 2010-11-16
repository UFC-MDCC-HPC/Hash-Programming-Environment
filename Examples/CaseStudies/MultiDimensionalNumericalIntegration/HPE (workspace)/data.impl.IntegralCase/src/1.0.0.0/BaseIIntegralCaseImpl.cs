/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using jefferson.data.Double;
using data.Function;
using data.IntegralCase;

namespace data.impl.IntegralCase { 

public abstract class BaseIIntegralCaseImpl<F>: DataStructure, BaseIIntegralCase<F>
where F:IFunction
{

protected IDouble xinf = null;

protected IDouble Xinf {
	set {
		this.xinf = value;
	}
}

protected IDouble xsup = null;

protected IDouble Xsup {
	set {
		this.xsup = value;
	}
}

protected F function = default(F);

protected F Function {
	set {
		this.function = value;
	}
}


public BaseIIntegralCaseImpl() { 

} 

public static string UID = "00240000048000009400000006020000002400005253413100040000110000000150ccd58370af704b2eb5f8982bb78cc5a7372e6410b5403023e92329007113aa3445e171e48f8ec2cbd2799c4f730e51dea75dadeff0d5835166f62d280a9945a09a73ca631165e347b753a03875a3c9536dc327492f943a79af598b658223398e397d69e18f6a2ab703a07ff6c6a9c67610454dc17d21a0c1c535913ddfb3";

override public void createSlices() {
	base.createSlices();
	this.Function = (F) BackEnd.createSlice(this, UID,"function","function",new Type[] {});
	this.Xsup = (IDouble) BackEnd.createSlice(this, UID,"b","double",new Type[] {});
	this.Xinf = (IDouble) BackEnd.createSlice(this, UID,"a","double",new Type[] {});
} 


}

}
