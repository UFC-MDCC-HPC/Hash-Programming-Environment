using System;
using br.ufc.pargo.hpe.basic;

namespace br.ufc.pargo.hpe.kinds
{


    public interface ITopologyKind : IUnit
    {
		int Rank {set; get;}
		int PartitionCount{set;}
		int PartitionIndex{get;}
    }

    public abstract class Topology : Unit
    {
		private int rank;
	    private int partition_count;
		
		public int Rank {set {rank = value;} get {return rank;}}
		public int PartitionCount {set {partition_count = value;} } 
		public int PartitionIndex {get {return rank % partition_count;} }
		
    }

}
