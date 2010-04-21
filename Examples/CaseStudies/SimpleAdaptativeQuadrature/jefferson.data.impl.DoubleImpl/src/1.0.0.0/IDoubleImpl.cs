using System;
using DGAC;
using hpe.basic;
using hpe.kinds;
using jefferson.data.Double;

namespace jefferson.data.impl.DoubleImpl { 

public class IDoubleImpl : BaseIDoubleImpl, IDouble
{

public IDoubleImpl() { 

} 

private double number;

public double Value{
		set{
			this.number = value;
		}
	    get{
		   return this.number;
	    }
	}
public void plus(IDouble b) { this.number += b.Value; }
public void times(IDouble b) { this.number *= b.Value; }
public void minus(IDouble b) { this.number -= b.Value; }

}

}
