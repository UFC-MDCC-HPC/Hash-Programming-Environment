using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using common.Buffer;

namespace impl.common.BufferImpl { 
	
	
	
public class IBufferImpl : BaseIBufferImpl, IBuffer
{

public IBufferImpl() { 

} 

private double[] array;	

		
public double[] Array { get { return array; } set { array = value; } }		
		
}

}
