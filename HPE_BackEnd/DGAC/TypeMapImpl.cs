
using System;
using System.Collections.Generic;

namespace gov
{
    namespace cca
    {

        public abstract class HPETypeMap : gov.cca.TypeMap, IDictionary<string, object>
        {
            protected IDictionary<string, object> dict = null;

            #region IDictionary<string,object> Members

            public void Add(string key, object value)
            {
                dict.Add(key, value);
            }

            public bool ContainsKey(string key)
            {
                return dict.ContainsKey(key);
            }

            public ICollection<string> Keys
            {
                get { return dict.Keys; }
            }

            public bool Remove(string key)
            {
                return dict.Remove(key);
            }

            public bool TryGetValue(string key, out object value)
            {
                return dict.TryGetValue(key, out value);
            }

            public ICollection<object> Values
            {
                get { return dict.Values; }
            }

            public object this[string key]
            {
                get
                {
                    return dict[key];
                }
                set
                {
                    dict[key] = value;
                }
            }

            #endregion

            #region ICollection<KeyValuePair<string,object>> Members

            public void Add(KeyValuePair<string, object> item)
            {
                dict.Add(item);
            }

            public void Clear()
            {
                dict.Clear();
            }

            public bool Contains(KeyValuePair<string, object> item)
            {
                return dict.Contains(item);
            }

            public void CopyTo(KeyValuePair<string, object>[] array, int arrayIndex)
            {
                dict.CopyTo(array, arrayIndex);
            }

            public int Count           

            {
                get { return dict.Count; }
            }

            public bool IsReadOnly
            {
                get { return dict.IsReadOnly; }
            }

            public bool Remove(KeyValuePair<string, object> item)
            {
                return dict.Remove(item);
            }

            #endregion

            #region IEnumerable<KeyValuePair<string,object>> Members

            public IEnumerator<KeyValuePair<string, object>> GetEnumerator()
            {
                return dict.GetEnumerator();
            }

            #endregion

            #region IEnumerable Members

            System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
            {
                return dict.GetEnumerator();
            }

            #endregion
        }

        //[Serializable]
        public class TypeMapImpl : HPETypeMap
        {
            public int teste = 0;

            public static TypeMap NEW_EMPTY_TYPEMAP { get { return new TypeMapImpl(); } }
            
            public TypeMapImpl()
            {
                dict = new Dictionary<string, object>();
            }

            public TypeMapImpl(TypeMap properties)
            {
                dict = new Dictionary<string, object>();
                foreach (KeyValuePair<string, object> property in (TypeMapImpl)properties)
                {
                    dict.Add(property);
                }
            }


            public override TypeMap cloneTypeMap() { return null; }

            public override TypeMap cloneEmpty() { return null; }

            public override int getInt(string key, int dflt) { object v; dict.TryGetValue(key, out v); return (int)v; }
            public override long getLong(string key, long dflt) { object v; dict.TryGetValue(key, out v); return (long)v; }
            public override float getFloat(string key, float dflt) { object v; dict.TryGetValue(key, out v); return (float)v; }
            public override double getDouble(string key, double dflt) { object v; dict.TryGetValue(key, out v); return (double)v; }
            public override string getString(string key, string dflt) { object v; dict.TryGetValue(key, out v); return (string)v; }
            public override bool getBool(string key, bool dflt) { object v; dict.TryGetValue(key, out v); return (bool)v; }

            public override int[] getIntArray(string key, int[] dflt) { object v; dict.TryGetValue(key, out v); return (int[])v; }
            public override long[] getLongArray(string key, long[] dflt) { object v; dict.TryGetValue(key, out v); return (long[])v; }
            public override float[] getFloatArray(string key, float[] dflt) { object v; dict.TryGetValue(key, out v); return (float[])v; }
            public override double[] getDoubleArray(string key, double[] dflt) { object v; dict.TryGetValue(key, out v); return (double[])v; }
            public override string[] getStringArray(string key, string[] dflt) { object v; dict.TryGetValue(key, out v); return (string[])v; }
            public override bool[] getBoolArray(string key, bool[] dflt) { object v; dict.TryGetValue(key, out v); return (bool[])v; }

            public override void putInt(string key, int value) { dict.Add(key, value); }
            public override void putLong(string key, long value) { dict.Add(key, value); }
            public override void putFloat(string key, float value) { dict.Add(key, value); }
            public override void putDouble(string key, double value) { dict.Add(key, value); }
            public override void putString(string key, string value) { dict.Add(key, value); }
            public override void putBool(string key, bool value) { dict.Add(key, value); }

            public override void putIntArray(string key, int[] value) { dict.Add(key, value); }
            public override void putLongArray(string key, long[] value) { dict.Add(key, value); }
            public override void putFloatArray(string key, float[] value) { dict.Add(key, value); }
            public override void putDoubleArray(string key, double[] value) { dict.Add(key, value); }
            public override void putStringArray(string key, string[] value) { dict.Add(key, value); }
            public override void putBoolArray(string key, bool[] value) { dict.Add(key, value); }

            public override void remove(string key) { dict.Remove(key); }

            public override string[] getAllKeys(Type t)
            {
                ICollection<string> keys = dict.Keys;
                string[] keyArray = new string[keys.Count];
                keys.CopyTo(keyArray, 0);
                return keyArray;
            }

            public override bool hasKey(string key) { return dict.ContainsKey(key); }

            public override Type typeOf(string key)
            {
                object v;
                dict.TryGetValue(key, out v);
                gov.cca.Type type;
                typeMapTypes.TryGetValue(v.GetType(), out type);
                return type;
            }

            private static IDictionary<System.Type, gov.cca.Type> typeMapTypes = new Dictionary<System.Type, gov.cca.Type>()
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