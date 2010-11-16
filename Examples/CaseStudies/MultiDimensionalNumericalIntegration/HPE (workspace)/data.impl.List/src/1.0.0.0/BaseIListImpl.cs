/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using jefferson.data.Data;
using data.List;

namespace data.impl.List { 

public abstract class BaseIListImpl<T>: DataStructure, BaseIList<T>
where T:IData
{

protected T data = default(T);

protected T Data {
	set {
		this.data = value;
	}
}


public BaseIListImpl() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000e32a277d2baf5bb26a9cea6b8b084b97e3931a514809ee86613f91ea1c45bc137e94628391ef9e98c1bbec52960bc026818908266b93d98dcff3dee071e30b707439b041f503bc91eef51c993c5210a5e7d3d015bedc2474547ec23ed8d0daebace1ce8473e7fac518baefedac525fe4382b4aa6ba4a359f5d4ff7ea6ce331aa";

override public void createSlices() {
	base.createSlices();
	this.Data = (T) BackEnd.createSlice(this, UID,"element factory","data",new Type[] {});
} 


}

}
