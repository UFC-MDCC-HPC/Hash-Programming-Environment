
using System;
using System.Collections.Generic;

namespace gov
{
    namespace cca
    {
        [Serializable]
        public abstract class HPETypeMap : gov.cca.TypeMap, IDictionary<string, object>
        {
            protected IDictionary<string, object> dict = null;
            protected IDictionary<string, Type> property_type = null;

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

        [Serializable]
        public class TypeMapImpl : HPETypeMap
        {
           // public int teste = 0;

           // public static TypeMap NEW_EMPTY_TYPEMAP { get { return new TypeMapImpl(); } }
            
            public TypeMapImpl()
            {
                dict = new Dictionary<string, object>();
                property_type = new Dictionary<string, Type>();
				fill_typeMapTypes();
            }


            public TypeMapImpl(TypeMap properties)
            {
                dict = new Dictionary<string, object>();
                property_type = new Dictionary<string, Type>();

                addPropertiesOfType(Type.Bool, properties);
                addPropertiesOfType(Type.BoolArray, properties);
                addPropertiesOfType(Type.Double, properties);
                addPropertiesOfType(Type.DoubleArray, properties);
                addPropertiesOfType(Type.Float, properties);
                addPropertiesOfType(Type.FloatArray, properties);
                addPropertiesOfType(Type.Int, properties);
                addPropertiesOfType(Type.IntArray, properties);
                addPropertiesOfType(Type.Long, properties);
                addPropertiesOfType(Type.LongArray, properties);
                addPropertiesOfType(Type.String, properties);
                addPropertiesOfType(Type.StringArray, properties);
				fill_typeMapTypes();
            }

            private void addPropertiesOfType(Type type, TypeMap properties)
            {
                properties = properties == null ? new TypeMapImpl() : properties;

                foreach (string key in properties.getAllKeys(type))
                {
                    switch (type)
                    {
                        case Type.Bool: this.putBool(key, properties.getBool(key, false)); break;
                        case Type.BoolArray: this.putBoolArray(key, properties.getBoolArray(key, null)); break;
                        case Type.Double: this.putDouble(key, properties.getDouble(key, 0)); break;
                        case Type.DoubleArray: this.putDoubleArray(key, properties.getDoubleArray(key, null)); break;
                        case Type.Float: this.putFloat(key, properties.getFloat(key, 0)); break;
                        case Type.FloatArray: this.putFloatArray(key, properties.getFloatArray(key, null)); break;
                        case Type.Int: this.putInt(key, properties.getInt(key, 0)); break;
                        case Type.IntArray: this.putIntArray(key, properties.getIntArray(key, null)); break;
                        case Type.Long: this.putLong(key, properties.getLong(key, 0)); break;
                        case Type.LongArray: this.putLongArray(key, properties.getLongArray(key, null)); break;
                        case Type.String: this.putString(key, properties.getString(key, null)); break;
                        case Type.StringArray:
                            {
                                string[] arr_str = properties.getStringArray(key, null);
                                //  string[] arr_str = arr_str.Split(',');
                                this.putStringArray(key, arr_str); break;
                            }
                    }
                }
            }

            public override TypeMap cloneTypeMap() { return null; }

            public override TypeMap cloneEmpty() { return null; }

			public override int getInt(string key, int dflt) { object v; if (dict.TryGetValue(key, out v)) return (int)v; else return dflt; }
			public override long getLong(string key, long dflt) { object v; if (dict.TryGetValue(key, out v)) return (long)v; else return dflt; }
			public override float getFloat(string key, float dflt) { object v; if (dict.TryGetValue(key, out v)) return (float)v; else return dflt; }
			public override double getDouble(string key, double dflt) { object v; if (dict.TryGetValue(key, out v)) return (double)v; else return dflt; }
			public override string getString(string key, string dflt) { object v; if (dict.TryGetValue(key, out v)) return (string)v; else return dflt; }
			public override bool getBool(string key, bool dflt) { object v; if (dict.TryGetValue(key, out v)) return (bool)v; else return dflt; }

			public override int[] getIntArray(string key, int[] dflt) { object v; if (dict.TryGetValue(key, out v)) return (int[])v; else return dflt; }
			public override long[] getLongArray(string key, long[] dflt) { object v; if (dict.TryGetValue(key, out v)) return (long[])v; else return dflt; }
			public override float[] getFloatArray(string key, float[] dflt) { object v; if (dict.TryGetValue(key, out v)) return (float[])v; else return dflt; }
			public override double[] getDoubleArray(string key, double[] dflt) { object v; if (dict.TryGetValue(key, out v)) return (double[])v; else return dflt; }
			public override string[] getStringArray(string key, string[] dflt) { object v; if (dict.TryGetValue(key, out v)) return (string[])v; else return dflt; }
			public override bool[] getBoolArray(string key, bool[] dflt) { object v; if (dict.TryGetValue(key, out v)) return (bool[])v; else return dflt; }

            public override void putInt(string key, int value) { dict.Add(key, value); property_type.Add(key,Type.Int); }
            public override void putLong(string key, long value) { dict.Add(key, value); property_type.Add(key, Type.Long); }
            public override void putFloat(string key, float value) { dict.Add(key, value); property_type.Add(key, Type.Double); }
            public override void putDouble(string key, double value) { dict.Add(key, value); property_type.Add(key, Type.String); }
            public override void putString(string key, string value) { dict.Add(key, value); property_type.Add(key, Type.Bool); }
            public override void putBool(string key, bool value) { dict.Add(key, value); }

            public override void putIntArray(string key, int[] value) { dict.Add(key, value); property_type.Add(key, Type.IntArray); }
            public override void putLongArray(string key, long[] value) { dict.Add(key, value); property_type.Add(key, Type.LongArray); }
            public override void putFloatArray(string key, float[] value) { dict.Add(key, value); property_type.Add(key, Type.FloatArray); }
            public override void putDoubleArray(string key, double[] value) { dict.Add(key, value); property_type.Add(key, Type.DoubleArray); }
            public override void putStringArray(string key, string[] value) { dict.Add(key, value); property_type.Add(key, Type.StringArray); }
            public override void putBoolArray(string key, bool[] value) { dict.Add(key, value); property_type.Add(key, Type.BoolArray); }

            public override void remove(string key) { dict.Remove(key); property_type.Remove(key); }

            public override string[] getAllKeys(Type t)
            {
                IList<string> keys = new List<string>();
                foreach (KeyValuePair<string, Type> key_type in property_type)
                {
                    if (key_type.Value == t || t == Type.NoType)
                    {
                        keys.Add(key_type.Key);
                    }
                }

                string[] keyArray = new string[keys.Count];
                keys.CopyTo(keyArray, 0);
                return keyArray;
            }

            public override bool hasKey(string key) { return dict.ContainsKey(key); }

            public override Type typeOf(string key)
            {
                return property_type[key];

/*                object v;
                dict.TryGetValue(key, out v);
                gov.cca.Type type;
                typeMapTypes.TryGetValue(v.GetType(), out type);
                return type;*/
            }

            public new void Add(string key, object value)
            {
                base.Add(key, value);
                property_type.Add(key, typeMapTypes[value.GetType()]);
            }

            private static IDictionary<System.Type, gov.cca.Type> typeMapTypes = new Dictionary<System.Type, gov.cca.Type>();
			
			private void fill_typeMapTypes()
			{
				typeMapTypes[typeof(int)] = Type.Int;
				typeMapTypes[typeof(long)] = Type.Long;
				typeMapTypes[typeof(float)] = Type.Float;
				typeMapTypes[typeof(double)] = Type.Double;
				typeMapTypes[typeof(string)] = Type.String;
				typeMapTypes[typeof(bool)] = Type.Bool;
				typeMapTypes[typeof(int[])] = Type.IntArray;
				typeMapTypes[typeof(long[])] = Type.LongArray;
				typeMapTypes[typeof(float[])] = Type.FloatArray;
				typeMapTypes[typeof(double[])] = Type.DoubleArray;
				typeMapTypes[typeof(string[])] = Type.StringArray;

			}


    }


	}
}