/**
 * Type.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.ufc.pargo.hpe.cca.ports.BuilderService;

public class Type implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Type(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _NoType = "NoType";
    public static final java.lang.String _Int = "Int";
    public static final java.lang.String _Long = "Long";
    public static final java.lang.String _Float = "Float";
    public static final java.lang.String _Double = "Double";
    public static final java.lang.String _Fcomplex = "Fcomplex";
    public static final java.lang.String _Dcomplex = "Dcomplex";
    public static final java.lang.String _String = "String";
    public static final java.lang.String _Bool = "Bool";
    public static final java.lang.String _IntArray = "IntArray";
    public static final java.lang.String _LongArray = "LongArray";
    public static final java.lang.String _FloatArray = "FloatArray";
    public static final java.lang.String _DoubleArray = "DoubleArray";
    public static final java.lang.String _FcomplexArray = "FcomplexArray";
    public static final java.lang.String _DcomplexArray = "DcomplexArray";
    public static final java.lang.String _StringArray = "StringArray";
    public static final java.lang.String _BoolArray = "BoolArray";
    public static final Type NoType = new Type(_NoType);
    public static final Type Int = new Type(_Int);
    public static final Type Long = new Type(_Long);
    public static final Type Float = new Type(_Float);
    public static final Type Double = new Type(_Double);
    public static final Type Fcomplex = new Type(_Fcomplex);
    public static final Type Dcomplex = new Type(_Dcomplex);
    public static final Type String = new Type(_String);
    public static final Type Bool = new Type(_Bool);
    public static final Type IntArray = new Type(_IntArray);
    public static final Type LongArray = new Type(_LongArray);
    public static final Type FloatArray = new Type(_FloatArray);
    public static final Type DoubleArray = new Type(_DoubleArray);
    public static final Type FcomplexArray = new Type(_FcomplexArray);
    public static final Type DcomplexArray = new Type(_DcomplexArray);
    public static final Type StringArray = new Type(_StringArray);
    public static final Type BoolArray = new Type(_BoolArray);
    public java.lang.String getValue() { return _value_;}
    public static Type fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Type enumeration = (Type)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Type fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Type.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://BuilderService.ports.cca.hpe.pargo.ufc.br/", "Type"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
