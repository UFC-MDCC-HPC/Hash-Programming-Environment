using System.Collections.Concurrent;
using System;
namespace br.ufc.pargo.hpe.backend.DGAC.TCOL.util
{
	public class MultiKeyConcurrentDictionary<TKey1,TKey2,TValue> :  
	ConcurrentDictionary<Tuple<TKey1, TKey2>, TValue>

	{

		public TValue this[TKey1 key1, TKey2 key2]
		{
			get { return base[Tuple.Create(key1, key2)]; }
			set { base[Tuple.Create(key1, key2)] = value; }
		}

		public void Add(TKey1 key1, TKey2 key2, TValue value)
		{
			base.TryAdd(Tuple.Create(key1, key2), value);
		}

		public bool ContainsKey(TKey1 key1, TKey2 key2)
		{
			return base.ContainsKey(Tuple.Create(key1, key2));
		}
		public TValue get(TKey1 key1, TKey2 key2){
			TValue v;
			base.TryGetValue (Tuple.Create(key1, key2), out v);
			return v;
		
		}

	}
}

