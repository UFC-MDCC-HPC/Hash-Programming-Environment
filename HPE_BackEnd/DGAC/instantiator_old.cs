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
namespace Instantiator {
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/instantiator")]
    [System.Xml.Serialization.XmlRootAttribute("application", Namespace="http://www.example.org/instantiator", IsNullable=false)]
    public partial class InstanceType {
        
        private ComponentFunctorApplicationType contextual_typeField;
        
        private int facet_instanceField;
        
        private bool facet_instanceFieldSpecified;
        
        private UnitMappingType[] unit_mappingField;
        
        private FacetAddressType[] facet_addressField;
        
        private string instance_refField;
        
        /// <remarks/>
        public ComponentFunctorApplicationType contextual_type {
            get {
                return this.contextual_typeField;
            }
            set {
                this.contextual_typeField = value;
            }
        }
        
        /// <remarks/>
        public int facet_instance {
            get {
                return this.facet_instanceField;
            }
            set {
                this.facet_instanceField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool facet_instanceSpecified {
            get {
                return this.facet_instanceFieldSpecified;
            }
            set {
                this.facet_instanceFieldSpecified = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("unit_mapping")]
        public UnitMappingType[] unit_mapping {
            get {
                return this.unit_mappingField;
            }
            set {
                this.unit_mappingField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("facet_address")]
        public FacetAddressType[] facet_address {
            get {
                return this.facet_addressField;
            }
            set {
                this.facet_addressField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string instance_ref {
            get {
                return this.instance_refField;
            }
            set {
                this.instance_refField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/instantiator")]
    public partial class ComponentFunctorApplicationType {
        
        private ContextArgumentType[] argumentField;
        
        private string component_refField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("argument")]
        public ContextArgumentType[] argument {
            get {
                return this.argumentField;
            }
            set {
                this.argumentField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string component_ref {
            get {
                return this.component_refField;
            }
            set {
                this.component_refField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/instantiator")]
    public partial class ContextArgumentType {
        
        private object itemField;
        
        private string parameter_idField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("type", typeof(ComponentFunctorApplicationType))]
        [System.Xml.Serialization.XmlElementAttribute("variable", typeof(string))]
        public object Item {
            get {
                return this.itemField;
            }
            set {
                this.itemField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string parameter_id {
            get {
                return this.parameter_idField;
            }
            set {
                this.parameter_idField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/instantiator")]
    public partial class FacetAddressType {
        
        private int facet_instanceField;
        
        private bool facet_instanceFieldSpecified;
        
        private int facetField;
        
        private bool facetFieldSpecified;
        
        private string addressField;
        
        private int portField;
        
        private bool portFieldSpecified;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public int facet_instance {
            get {
                return this.facet_instanceField;
            }
            set {
                this.facet_instanceField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool facet_instanceSpecified {
            get {
                return this.facet_instanceFieldSpecified;
            }
            set {
                this.facet_instanceFieldSpecified = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public int facet {
            get {
                return this.facetField;
            }
            set {
                this.facetField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool facetSpecified {
            get {
                return this.facetFieldSpecified;
            }
            set {
                this.facetFieldSpecified = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string address {
            get {
                return this.addressField;
            }
            set {
                this.addressField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public int port {
            get {
                return this.portField;
            }
            set {
                this.portField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool portSpecified {
            get {
                return this.portFieldSpecified;
            }
            set {
                this.portFieldSpecified = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/instantiator")]
    public partial class UnitMappingType {
        
        private int[] nodeField;
        
        private int facet_instanceField;
        
        private bool facet_instanceFieldSpecified;
        
        private int facetField;
        
        private bool facetFieldSpecified;
        
        private string unit_idField;
        
        private int unit_indexField;
        
        public UnitMappingType() {
            this.unit_indexField = 0;
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("node")]
        public int[] node {
            get {
                return this.nodeField;
            }
            set {
                this.nodeField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public int facet_instance {
            get {
                return this.facet_instanceField;
            }
            set {
                this.facet_instanceField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool facet_instanceSpecified {
            get {
                return this.facet_instanceFieldSpecified;
            }
            set {
                this.facet_instanceFieldSpecified = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public int facet {
            get {
                return this.facetField;
            }
            set {
                this.facetField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool facetSpecified {
            get {
                return this.facetFieldSpecified;
            }
            set {
                this.facetFieldSpecified = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string unit_id {
            get {
                return this.unit_idField;
            }
            set {
                this.unit_idField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        [System.ComponentModel.DefaultValueAttribute(0)]
        public int unit_index {
            get {
                return this.unit_indexField;
            }
            set {
                this.unit_indexField = value;
            }
        }
    }
}
