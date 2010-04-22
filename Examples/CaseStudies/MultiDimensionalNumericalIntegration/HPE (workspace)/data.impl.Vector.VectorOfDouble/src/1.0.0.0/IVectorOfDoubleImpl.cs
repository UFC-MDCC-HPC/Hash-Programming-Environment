using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using jefferson.data.Double;
using data.Vector.VectorOfDouble;

namespace data.impl.Vector.VectorOfDouble { 

public class IVectorOfDoubleImpl<T> : BaseIVectorOfDoubleImpl<T>, IVectorOfDouble<T>
where T:IDouble
{

 public int Size { 
    get {
       return vec_size.Value;
    } 
    set {
       vec_size.Value = value;
    }
}
 
public IVectorOfDoubleImpl() { 

} 


}

}
