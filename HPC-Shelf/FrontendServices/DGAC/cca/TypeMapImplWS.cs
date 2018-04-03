
using System;
using System.Collections.Generic;

namespace gov
{
    namespace cca
    {

       public struct Property
       {
            public string key;
            public string value;
            public Type type;
        }

      

        public class TypeMapImplWS : TypeMap
        {
            public TypeMapImplWS()
            {
            }

            public TypeMapImplWS(TypeMap properties)
            {
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
            }

            private void addPropertiesOfType(Type type, TypeMap properties)
            {
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
                        case Type.StringArray: this.putStringArray(key, properties.getStringArray(key, null)); break;
                    }
                }
            }


            private IList<Property> properties = null;

            public Property[] Properties
            {
                get
                {
                    if (properties.Count > 0)
                    {
                        if (properties == null) properties = new List<Property>();
                        Property[] p = new Property[properties.Count];
                        properties.CopyTo(p, 0);
                        return p;
                    }
                    else
                    {
                        return new Property[0];
                    }
                }
                set
                {
                    if (properties == null) properties = new List<Property>();
                    foreach (Property item in value){
                         this.properties.Add(item);
                    }
                }
            }

            public override TypeMap cloneTypeMap()
            {
                return new TypeMapImplWS(this);
            }

            public override TypeMap cloneEmpty()
            {
                return new TypeMapImpl();
            }

            private string findPropertyValue(string key)
            {
                foreach (Property p in properties)
                {
                    if (p.key.Equals(key))
                        return p.value;
                }

                throw new KeyNotFoundException();
            }

            public override int getInt(string key, int dflt)
            {
                int result; 
                try
                {
                    string value = findPropertyValue(key);
                    if (!int.TryParse(value, out result))
                        result = dflt;
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override long getLong(string key, long dflt)
            {
                long result;
                try
                {
                    string value = findPropertyValue(key);
                    if (!long.TryParse(value, out result))
                        result = dflt;
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override float getFloat(string key, float dflt)
            {
                float result;
                try
                {
                    string value = findPropertyValue(key);
                    if (!float.TryParse(value, out result))
                        result = dflt;
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override double getDouble(string key, double dflt)
            {
                double result;
                try
                {
                    string value = findPropertyValue(key);
                    if (!double.TryParse(value, out result))
                        result = dflt;
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override string getString(string key, string dflt)
            {
                string result;
                try
                {
                    result = findPropertyValue(key);
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override bool getBool(string key, bool dflt)
            {
                bool result;
                try
                {
                    string value = findPropertyValue(key);
                    if (!bool.TryParse(value, out result))
                        result = dflt;
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override int[] getIntArray(string key, int[] dflt)
            {
                int[] result;
                try
                {
                    string arraystr1 = findPropertyValue(key);
                    string[] arraystr2 = readArrayFromString(arraystr1);
                    result = new int[arraystr2.Length];
                    int i = 0;
                    foreach (string value in arraystr2)
                    {
                        int item;
                        if (!int.TryParse(value, out item))
                            throw new FormatException();
                        result[i++] = item;
                    }
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override long[] getLongArray(string key, long[] dflt)
            {
                long[] result;
                try
                {
                    string arraystr1 = findPropertyValue(key);
                    string[] arraystr2 = readArrayFromString(arraystr1);
                    result = new long[arraystr2.Length];
                    int i = 0;
                    foreach (string value in arraystr2)
                    {
                        long item;
                        if (!long.TryParse(value, out item))
                            throw new FormatException();
                        result[i++] = item;
                    }
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override float[] getFloatArray(string key, float[] dflt)
            {
                float[] result;
                try
                {
                    string arraystr1 = findPropertyValue(key);
                    string[] arraystr2 = readArrayFromString(arraystr1);
                    result = new float[arraystr2.Length];
                    int i = 0;
                    foreach (string value in arraystr2)
                    {
                        float item;
                        if (!float.TryParse(value, out item))
                            throw new FormatException();
                        result[i++] = item;
                    }
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override double[] getDoubleArray(string key, double[] dflt)
            {
                double[] result;
                try
                {
                    string arraystr1 = findPropertyValue(key);
                    string[] arraystr2 = readArrayFromString(arraystr1);
                    result = new double[arraystr2.Length];
                    int i = 0;
                    foreach (string value in arraystr2)
                    {
                        double item;
                        if (!double.TryParse(value, out item))
                            throw new FormatException();
                        result[i++] = item;
                    }
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override string[] getStringArray(string key, string[] dflt)
            {
                string[] result;
                try
                {
                    string arraystr1 = findPropertyValue(key);
                    string[] arraystr2 = readArrayFromString(arraystr1);
                    result = new string[arraystr2.Length];
                    int i = 0;
                    foreach (string item in arraystr2)
                    {
                        result[i++] = item;
                    }
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override bool[] getBoolArray(string key, bool[] dflt)
            {
                bool[] result;
                try
                {
                    string arraystr1 = findPropertyValue(key);
                    string[] arraystr2 = readArrayFromString(arraystr1);
                    result = new bool[arraystr2.Length];
                    int i = 0;
                    foreach (string value in arraystr2)
                    {
                        bool item;
                        if (!bool.TryParse(value, out item))
                            throw new FormatException();
                        result[i++] = item;
                    }
                }
                catch (KeyNotFoundException e)
                {
                    result = dflt;
                }
                return result;
            }

            public override void putInt(string key, int value)
            {
                addToProperties(key, value, Type.Int);
            }

            public override void putLong(string key, long value)
            {
                addToProperties(key, value, Type.Long);
            }

            public override void putFloat(string key, float value)
            {
                addToProperties(key, value, Type.Float);
            }

            public override void putDouble(string key, double value)
            {
                addToProperties(key, value, Type.Double);
            }

            public override void putString(string key, string value)
            {
                addToProperties(key, value, Type.String);
            }

            public override void putBool(string key, bool value)
            {
                addToProperties(key, value, Type.Bool);
            }

            public override void putIntArray(string key, int[] value)
            {
                addToPropertiesArray(key, value, Type.IntArray);
            }

            public override void putLongArray(string key, long[] value)
            {
                addToPropertiesArray(key, value, Type.LongArray);
            }

            public override void putFloatArray(string key, float[] value)
            {
                addToPropertiesArray(key, value, Type.FloatArray);
            }

            public override void putDoubleArray(string key, double[] value)
            {
                addToPropertiesArray(key, value, Type.DoubleArray);
            }

            public override void putStringArray(string key, string[] value)
            {
                addToPropertiesArray(key, value, Type.StringArray);
            }

            public override void putBoolArray(string key, bool[] value)
            {
                addToPropertiesArray(key, value, Type.BoolArray);
            }

            public override void remove(string key)
            {
                foreach (Property p in properties)
                {
                    if (p.key.Equals(key))
                    {
                        properties.Remove(p);
                    }
                }
                throw new KeyNotFoundException();
            }

            public override string[] getAllKeys(Type t)
            {
                IList<string> keysList = new List<string>();
               
                foreach (Property p in properties)
                {
                    if (p.type == t || t == Type.NoType)
                        keysList.Add(p.key);
                }
                string[] keys = new string[keysList.Count];
                keysList.CopyTo(keys, 0);
                return keys;
            }

            public override bool hasKey(string key)
            {
                foreach (Property p in properties)
                {
                    if (p.key.Equals(key)) 
                        return true;
                }
                return false;
            }

            public override Type typeOf(string key)
            {
                foreach (Property p in properties)
                {
                    if (p.key.Equals(key))
                        return p.type;
                }
                throw new KeyNotFoundException();
            }

            private void addToProperties(string key, object value, Type type)
            {
                Property property;
                property.key = key;
                property.value = value.ToString();
                property.type = type;
                properties.Add(property);
            }

            private void addToPropertiesArray(string key, System.Array array, Type type)
            {
                string value = writeArrayToString(array);

                Property property;
                property.key = key;
                property.value = value;
                property.type = type;
                properties.Add(property);
            }

            private string writeArrayToString(Array array)
            {
                string value = "[";
                foreach (object o in array)
                {
                    value += " " + o.ToString();
                }
                value = "]";
                return value;
            }

            private string[] readArrayFromString(string value)
            {
                string[] result = value.Split(new char[] { '[', ']', ',' }, StringSplitOptions.RemoveEmptyEntries);
                return result;
            }

        }
    }
}