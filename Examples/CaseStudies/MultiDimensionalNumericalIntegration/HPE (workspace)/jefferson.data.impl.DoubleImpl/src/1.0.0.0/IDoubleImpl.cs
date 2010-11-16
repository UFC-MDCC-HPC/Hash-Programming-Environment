using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using jefferson.data.Double;

namespace jefferson.data.impl.DoubleImpl { 

public class IDoubleImpl : BaseIDoubleImpl, IDouble
{

public IDoubleImpl() { 

} 

public Object createNew() {
   return new IDoubleImpl();
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
