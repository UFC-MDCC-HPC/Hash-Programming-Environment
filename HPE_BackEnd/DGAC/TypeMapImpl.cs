
using System;
using System.Collections.Generic;

namespace gov {	
	namespace cca {
		
		public class TypeMapImpl : IDictionary<string, object>, gov.cca.TypeMap {
			
			private IDictionary<string, object> dict = null;
			
			
			public void Add(KeyValuePair<string, object> item) 
			{
				dict.Add(item);
			}
			
			public void Clear() 
			{
				dict.Clear();
			}

			public int Count { get { return dict.Count; } }

					
			public bool Contains(KeyValuePair<string,object> item) 
			{
				return dict.Contains(item);
			}

			public void CopyTo(KeyValuePair<string, object>[] array,int arrayIndex) 
			{
				dict.CopyTo(array, arrayIndex);
			}

					
			public bool Remove(KeyValuePair<string,object> item) 
			{
				return dict.Remove(item);
			}

			public bool Remove(string item) 
			{
				return dict.Remove(item);
			}
					
				
		    public TypeMapImpl() 
			{
				dict = new Dictionary<string,object>();
			}
			
		    public TypeMapImpl(TypeMap properties) 
			{
				dict = new Dictionary<string,object>();
			    foreach (KeyValuePair<string,object> property in (TypeMapImpl)properties) 
				{
					dict.Add(property);
				}
			}
			
			public bool IsReadOnly {get { return dict.IsReadOnly; } } 
			
			public object this[string key] {get { return dict[key]; } set { dict[key] = value; } } 
		
			public ICollection<string> Keys { get {return dict.Keys; } } 
			
		    public bool TryGetValue(string key, out object val) 
			{
				return dict.TryGetValue(key, out val);
			}

			public void Add(string key, object val) 
			{
				dict.Add(key, val);
			}

			public bool ContainsKey(string key) 
			{
				return dict.ContainsKey(key);
			}
			

			public ICollection<object> Values {get { return dict.Values; } } 

			
		    public IEnumerator<KeyValuePair<string,object>> GetEnumerator() 
			{
				return dict.GetEnumerator();
			}

			System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator() 
			{
				return dict.GetEnumerator();
			}
			
			
			
	public TypeMap cloneTypeMap() { return null; }

	public TypeMap cloneEmpty() { return null; }
	
	public int      getInt(string key, int dflt) { object v; dict.TryGetValue(key, out v); return (int) v; }
	public long     getLong(string key, long dflt) { object v; dict.TryGetValue(key, out v); return (long) v; }
	public float    getFloat(string key, float dflt) { object v; dict.TryGetValue(key, out v); return (float) v; }
	public double   getDouble(string key, double dflt) { object v; dict.TryGetValue(key, out v); return (double) v; }
	public string   getString(string key, string dflt) { object v; dict.TryGetValue(key, out v); return (string) v; }
	public bool     getBool(string key, bool dflt) { object v; dict.TryGetValue(key, out v); return (bool) v; }
	
	public int[]      getIntArray(string key, int[] dflt)  { object v; dict.TryGetValue(key, out v); return (int[]) v;  }
	public long[]     getLongArray(string key, long[] dflt) { object v; dict.TryGetValue(key, out v); return (long[]) v; }
	public float[]    getFloatArray(string key, float[] dflt) { object v; dict.TryGetValue(key, out v); return (float[]) v;  }
	public double[]   getDoubleArray(string key, double[] dflt) { object v; dict.TryGetValue(key, out v); return (double[]) v;  }
	public string[]   getStringArray(string key, string[] dflt) { object v; dict.TryGetValue(key, out v); return (string[]) v;  }
	public bool[]     getBoolArray(string key, bool[] dflt) { object v; dict.TryGetValue(key, out v); return (bool[]) v;  }
	
	public void putInt(string key, int value) { dict.Add(key,value); }
	public void putLong(string key, long value) { dict.Add(key,value); }
	public void putFloat(string key, float value) { dict.Add(key,value); }
	public void putDouble(string key, double value) { dict.Add(key,value); }
	public void putString(string key, string value) { dict.Add(key,value); }
	public void putBool(string key, bool value) { dict.Add(key,value); }
	
	public void putIntArray(string key, int[] value) { dict.Add(key,value); }
	public void putLongArray(string key, long[] value) { dict.Add(key,value); }
	public void putFloatArray(string key, float[] value) { dict.Add(key,value); }
	public void putDoubleArray(string key, double[] value) { dict.Add(key,value); }
	public void putStringArray(string key, string[] value) { dict.Add(key,value); }
	public void putBoolArray(string key, bool[] value) { dict.Add(key,value); }
	
	public void remove (string key)  { dict.Remove(key); }
	
	public string[] getAllKeys(Type t) 
	{ 
		ICollection<string> keys = dict.Keys;
		string[] keyArray  = new string[keys.Count];
		keys.CopyTo(keyArray, 0);				
		return keyArray; 
	}
	
	public bool hasKey(string key) { return dict.ContainsKey(key); }
	
	public Type typeOf(string key) 
	{ 
		object v; 
		dict.TryGetValue(key, out v);  
		gov.cca.Type type;
	    typeMapTypes.TryGetValue(v.GetType(), out type);
		return type;
	}			
			
	private static IDictionary<System.Type,gov.cca.Type> typeMapTypes = new Dictionary<System.Type,gov.cca.Type>()
	{
	    { null, Type.NoType},
	    { typeof(int) , Type.Int},
	    { typeof(long), Type.Long},
	    { typeof(float), Type.Float},
	    { typeof(double), Type.Double},
	    { typeof(string), Type.String},
	    { typeof(bool), Type.Bool},
	    { typeof(int[]), Type.IntArray},
	    { typeof(long[]), Type.LongArray},
	    { typeof(float[]), Type.FloatArray},
	    { typeof(double[]), Type.DoubleArray},
	    { typeof(string[]), Type.StringArray}
	//    { 112, Fcomplex},
	//    { 112, Dcomplex},
	//    { 112, FcomplexArray},
	//    { 112, DcomplexArray}
	};
			
		}
	}	
	
	

}