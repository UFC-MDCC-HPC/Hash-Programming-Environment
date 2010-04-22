using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using data.Integer;

namespace data.impl.Integer { 

public class IIntegerImpl : BaseIIntegerImpl, IInteger
{

private int value_;

public int Value { get { return value_; } set { value_ = value; } }

public IIntegerImpl() { 

} 


}

}
