//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:2.0.50727.1433
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using System.Xml.Serialization;

// 
// This source code was auto-generated by xsd, Version=2.0.50727.42.
// 


/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "2.0.50727.42")]
[System.SerializableAttribute()]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/externalreferences")]
[System.Xml.Serialization.XmlRootAttribute("external", Namespace="http://www.example.org/externalreferences", IsNullable=false)]
public partial class ReferenceListType {
    
    private ReferenceType[] referenceField;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute("reference")]
    public ReferenceType[] reference {
        get {
            return this.referenceField;
        }
        set {
            this.referenceField = value;
        }
    }
}

/// <remarks/>
[System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "2.0.50727.42")]
[System.SerializableAttribute()]
[System.Diagnostics.DebuggerStepThroughAttribute()]
[System.ComponentModel.DesignerCategoryAttribute("code")]
[System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/externalreferences")]
public partial class ReferenceType {
    
    private string[] aliasField;
    
    private string destailedNameField;
    
    private string descriptionField;
    
    private string pathField;
    
    /// <remarks/>
    [System.Xml.Serialization.XmlElementAttribute("alias")]
    public string[] alias {
        get {
            return this.aliasField;
        }
        set {
            this.aliasField = value;
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlAttributeAttribute()]
    public string destailedName {
        get {
            return this.destailedNameField;
        }
        set {
            this.destailedNameField = value;
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlAttributeAttribute()]
    public string description {
        get {
            return this.descriptionField;
        }
        set {
            this.descriptionField = value;
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlAttributeAttribute()]
    public string path {
        get {
            return this.pathField;
        }
        set {
            this.pathField = value;
        }
    }
}
