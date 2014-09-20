// ------------------------------------------------------------------------------
//  <autogenerated>
//      This code was generated by a tool.
//      Mono Runtime Version: 4.0.30319.17020
// 
//      Changes to this file may cause incorrect behavior and will be lost if 
//      the code is regenerated.
//  </autogenerated>
// ------------------------------------------------------------------------------

// 
//This source code was auto-generated by MonoXSD
//
namespace Catalog {
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/catalog")]
    [System.Xml.Serialization.XmlRootAttribute("catalog", Namespace="http://www.example.org/catalog", IsNullable=false)]
    public partial class CatalogType {
        
        private string site_nameField;
        
        private string backend_urlField;
        
        private ComponentType[] componentField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string site_name {
            get {
                return this.site_nameField;
            }
            set {
                this.site_nameField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="", DataType="anyURI")]
        public string backend_url {
            get {
                return this.backend_urlField;
            }
            set {
                this.backend_urlField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("component")]
        public ComponentType[] component {
            get {
                return this.componentField;
            }
            set {
                this.componentField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/catalog")]
    public partial class ComponentType {
        
        private string component_refField;
        
        private string kindField;
        
        private string component_ref_superField;
        
        private UnitType[] unitField;
        
        private UsesPortType[] uses_portField;
        
        private ProvidesPortType[] provides_portField;
        
        private ParameterType[] parameterField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string component_ref {
            get {
                return this.component_refField;
            }
            set {
                this.component_refField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string kind {
            get {
                return this.kindField;
            }
            set {
                this.kindField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string component_ref_super {
            get {
                return this.component_ref_superField;
            }
            set {
                this.component_ref_superField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("unit")]
        public UnitType[] unit {
            get {
                return this.unitField;
            }
            set {
                this.unitField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("uses_port")]
        public UsesPortType[] uses_port {
            get {
                return this.uses_portField;
            }
            set {
                this.uses_portField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("provides_port")]
        public ProvidesPortType[] provides_port {
            get {
                return this.provides_portField;
            }
            set {
                this.provides_portField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("parameter")]
        public ParameterType[] parameter {
            get {
                return this.parameterField;
            }
            set {
                this.parameterField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/catalog")]
    public partial class UnitType {
        
        private string unit_refField;
        
        private bool is_parallelField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string unit_ref {
            get {
                return this.unit_refField;
            }
            set {
                this.unit_refField = value;
            }
        }
        
        /// <remarks/>
        [System.ComponentModel.DefaultValue(false)]
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public bool is_parallel {
            get {
                return this.is_parallelField;
            }
            set {
                this.is_parallelField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/catalog")]
    public partial class UsesPortType : PortType {
        
        private SliceType[] sliceField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("slice")]
        public SliceType[] slice {
            get {
                return this.sliceField;
            }
            set {
                this.sliceField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/catalog")]
    public partial class SliceType {
        
        private string host_unitField;
        
        private string slice_unitField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string host_unit {
            get {
                return this.host_unitField;
            }
            set {
                this.host_unitField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string slice_unit {
            get {
                return this.slice_unitField;
            }
            set {
                this.slice_unitField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/catalog")]
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(UsesPortType))]
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(ProvidesPortType))]
    public partial class PortType {
        
        private string port_refField;
        
        private ComponentFunctorApplicationType typeField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string port_ref {
            get {
                return this.port_refField;
            }
            set {
                this.port_refField = value;
            }
        }
        
        /// <remarks/>
        public ComponentFunctorApplicationType type {
            get {
                return this.typeField;
            }
            set {
                this.typeField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/instantiator")]
    public partial class ComponentFunctorApplicationType {
        
        private string component_refField1;
        
        private ContextArgumentType[] argumentField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string component_ref {
            get {
                return this.component_refField1;
            }
            set {
                this.component_refField1 = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("argument", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public ContextArgumentType[] argument {
            get {
                return this.argumentField;
            }
            set {
                this.argumentField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/instantiator")]
    public partial class ContextArgumentType {
        
        private string parameter_idField;
        
        private object itemField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string parameter_id {
            get {
                return this.parameter_idField;
            }
            set {
                this.parameter_idField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("type", Type=typeof(ComponentFunctorApplicationType), Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        [System.Xml.Serialization.XmlElementAttribute("variable", Type=typeof(string), Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public object Item {
            get {
                return this.itemField;
            }
            set {
                this.itemField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/catalog")]
    public partial class ProvidesPortType : PortType {
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/catalog")]
    public partial class ParameterType {
        
        private string parameter_idField1;
        
        private string variable_idField;
        
        private ComponentFunctorApplicationType bounds_typeField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string parameter_id {
            get {
                return this.parameter_idField1;
            }
            set {
                this.parameter_idField1 = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string variable_id {
            get {
                return this.variable_idField;
            }
            set {
                this.variable_idField = value;
            }
        }
        
        /// <remarks/>
        public ComponentFunctorApplicationType bounds_type {
            get {
                return this.bounds_typeField;
            }
            set {
                this.bounds_typeField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/instantiator")]
    [System.Xml.Serialization.XmlRootAttribute("application", Namespace="http://www.example.org/instantiator", IsNullable=false)]
    public partial class InstanceType {
        
        private string instance_refField;
        
        private ComponentFunctorApplicationType contextual_typeField;
        
        private UnitMappingType[] unit_mappingField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string instance_ref {
            get {
                return this.instance_refField;
            }
            set {
                this.instance_refField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public ComponentFunctorApplicationType contextual_type {
            get {
                return this.contextual_typeField;
            }
            set {
                this.contextual_typeField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("unit_mapping", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public UnitMappingType[] unit_mapping {
            get {
                return this.unit_mappingField;
            }
            set {
                this.unit_mappingField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.0.30319.17020")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/instantiator")]
    public partial class UnitMappingType {
        
        private string unit_idField;
        
        private int unit_indexField;
        
        private int[] nodeField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public string unit_id {
            get {
                return this.unit_idField;
            }
            set {
                this.unit_idField = value;
            }
        }
        
        /// <remarks/>
        [System.ComponentModel.DefaultValue(0)]
        [System.Xml.Serialization.XmlAttributeAttribute(Namespace="")]
        public int unit_index {
            get {
                return this.unit_indexField;
            }
            set {
                this.unit_indexField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("node", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int[] node {
            get {
                return this.nodeField;
            }
            set {
                this.nodeField = value;
            }
        }
    }
}
