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
namespace SAFeSWL {
    
    
    /// <remarks/>
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_SelectionGuardType))]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/SAFe_workflow_V6")]
    [System.Xml.Serialization.XmlRootAttribute("workflow", Namespace="http://www.example.org/SAFe_workflow_V6", IsNullable=false)]
    public partial class SAFeSWL_OperationAnyType : SAFeSWL_OperationBaseType {
        
        private object itemField;
        
        private ItemChoiceType itemElementNameField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("break", typeof(SAFeSWL_OperationPrimitiveType))]
        [System.Xml.Serialization.XmlElementAttribute("cancel", typeof(SAFeSWL_OperationPrimitiveInvokeActionAsyncType))]
        [System.Xml.Serialization.XmlElementAttribute("choice", typeof(SAFeSWL_OperationChoiceType))]
        [System.Xml.Serialization.XmlElementAttribute("continue", typeof(SAFeSWL_OperationPrimitiveType))]
        [System.Xml.Serialization.XmlElementAttribute("invoke", typeof(SAFeSWL_OperationPrimitiveInvokeActionType))]
        [System.Xml.Serialization.XmlElementAttribute("iterate", typeof(SAFeSWL_OperationAnyType))]
        [System.Xml.Serialization.XmlElementAttribute("parallel", typeof(SAFeSWL_OperationManyType))]
        [System.Xml.Serialization.XmlElementAttribute("sequence", typeof(SAFeSWL_OperationManyType))]
        [System.Xml.Serialization.XmlElementAttribute("skip", typeof(SAFeSWL_OperationPrimitiveType))]
        [System.Xml.Serialization.XmlElementAttribute("start", typeof(SAFeSWL_OperationPrimitiveInvokeActionAsyncType))]
        [System.Xml.Serialization.XmlElementAttribute("wait", typeof(SAFeSWL_OperationPrimitiveInvokeActionAsyncType))]
        [System.Xml.Serialization.XmlChoiceIdentifierAttribute("ItemElementName")]
        public object Item {
            get {
                return this.itemField;
            }
            set {
                this.itemField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public ItemChoiceType ItemElementName {
            get {
                return this.itemElementNameField;
            }
            set {
                this.itemElementNameField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_OperationPrimitiveInvokeActionType))]
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_OperationPrimitiveInvokeActionAsyncType))]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/SAFe_workflow_V6")]
    public partial class SAFeSWL_OperationPrimitiveType : SAFeSWL_OperationBaseType {
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_OperationAnyType))]
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_SelectionGuardType))]
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_OperationPrimitiveType))]
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_OperationPrimitiveInvokeActionType))]
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_OperationPrimitiveInvokeActionAsyncType))]
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_OperationManyType))]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/SAFe_workflow_V6")]
    public partial class SAFeSWL_OperationBaseType {
        
        private int orderField;
        
        private bool orderFieldSpecified;
        
        private string valueField;
        
        private string oper_nameField;
        
        private int levelField;
        
        private bool levelFieldSpecified;
        
        private string base_labelField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public int order {
            get {
                return this.orderField;
            }
            set {
                this.orderField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool orderSpecified {
            get {
                return this.orderFieldSpecified;
            }
            set {
                this.orderFieldSpecified = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string value {
            get {
                return this.valueField;
            }
            set {
                this.valueField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string oper_name {
            get {
                return this.oper_nameField;
            }
            set {
                this.oper_nameField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public int level {
            get {
                return this.levelField;
            }
            set {
                this.levelField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool levelSpecified {
            get {
                return this.levelFieldSpecified;
            }
            set {
                this.levelFieldSpecified = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string base_label {
            get {
                return this.base_labelField;
            }
            set {
                this.base_labelField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(TypeName="SAFeSWL_OperationChoiceType", Namespace="http://www.example.org/SAFe_workflow_V6")]
    public partial class SAFeSWL_OperationChoiceType {
        
        private SAFeSWL_SelectionGuardType[] selectField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("select")]
        public SAFeSWL_SelectionGuardType[] select {
            get {
                return this.selectField;
            }
            set {
                this.selectField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/SAFe_workflow_V6")]
    public partial class SAFeSWL_SelectionGuardType : SAFeSWL_OperationAnyType {
        
        private SAFeSWL_OperationAnyType branchField;
        
        private string id_portField;
        
        private string actionField;
        
        /// <remarks/>
        public SAFeSWL_OperationAnyType branch {
            get {
                return this.branchField;
            }
            set {
                this.branchField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string id_port {
            get {
                return this.id_portField;
            }
            set {
                this.id_portField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string action {
            get {
                return this.actionField;
            }
            set {
                this.actionField = value;
            }
        }
    }
        
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/SAFe_workflow_V6")]
    public partial class SAFeSWL_OperationManyType : SAFeSWL_OperationBaseType {
        
        private object[] itemsField;
        
        private ItemsChoiceType[] itemsElementNameField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("break", typeof(SAFeSWL_OperationPrimitiveType))]
        [System.Xml.Serialization.XmlElementAttribute("cancel", typeof(SAFeSWL_OperationPrimitiveInvokeActionAsyncType))]
        [System.Xml.Serialization.XmlElementAttribute("choice", typeof(SAFeSWL_OperationChoiceType))]
        [System.Xml.Serialization.XmlElementAttribute("continue", typeof(SAFeSWL_OperationPrimitiveType))]
        [System.Xml.Serialization.XmlElementAttribute("invoke", typeof(SAFeSWL_OperationPrimitiveInvokeActionType))]
        [System.Xml.Serialization.XmlElementAttribute("iterate", typeof(SAFeSWL_OperationAnyType))]
        [System.Xml.Serialization.XmlElementAttribute("parallel", typeof(SAFeSWL_OperationManyType))]
        [System.Xml.Serialization.XmlElementAttribute("sequence", typeof(SAFeSWL_OperationManyType))]
        [System.Xml.Serialization.XmlElementAttribute("skip", typeof(SAFeSWL_OperationPrimitiveType))]
        [System.Xml.Serialization.XmlElementAttribute("start", typeof(SAFeSWL_OperationPrimitiveInvokeActionAsyncType))]
        [System.Xml.Serialization.XmlElementAttribute("wait", typeof(SAFeSWL_OperationPrimitiveInvokeActionAsyncType))]
        [System.Xml.Serialization.XmlChoiceIdentifierAttribute("ItemsElementName")]
        public object[] Items {
            get {
                return this.itemsField;
            }
            set {
                this.itemsField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("ItemsElementName")]
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public ItemsChoiceType[] ItemsElementName {
            get {
                return this.itemsElementNameField;
            }
            set {
                this.itemsElementNameField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/SAFe_workflow_V6")]
    public partial class SAFeSWL_OperationPrimitiveInvokeActionAsyncType : SAFeSWL_OperationPrimitiveInvokeActionType {
        
        private string handle_idField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string handle_id {
            get {
                return this.handle_idField;
            }
            set {
                this.handle_idField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.Xml.Serialization.XmlIncludeAttribute(typeof(SAFeSWL_OperationPrimitiveInvokeActionAsyncType))]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/SAFe_workflow_V6")]
    public partial class SAFeSWL_OperationPrimitiveInvokeActionType : SAFeSWL_OperationPrimitiveType {
        
        private string id_portField;
        
        private string actionField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string id_port {
            get {
                return this.id_portField;
            }
            set {
                this.id_portField = value;
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlAttributeAttribute()]
        public string action {
            get {
                return this.actionField;
            }
            set {
                this.actionField = value;
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/SAFe_workflow_V6", IncludeInSchema=false)]
    public enum ItemsChoiceType {
        
        /// <remarks/>
        @break,
        
        /// <remarks/>
        cancel,
        
        /// <remarks/>
        choice,
        
        /// <remarks/>
        @continue,
        
        /// <remarks/>
        invoke,
        
        /// <remarks/>
        iterate,
        
        /// <remarks/>
        parallel,
        
        /// <remarks/>
        sequence,
        
        /// <remarks/>
        skip,
        
        /// <remarks/>
        start,
        
        /// <remarks/>
        wait,
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("xsd", "0.0.0.0")]
    [System.SerializableAttribute()]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://www.example.org/SAFe_workflow_V6", IncludeInSchema=false)]
    public enum ItemChoiceType {
        
        /// <remarks/>
        @break,
        
        /// <remarks/>
        cancel,
        
        /// <remarks/>
        choice,
        
        /// <remarks/>
        @continue,
        
        /// <remarks/>
        invoke,
        
        /// <remarks/>
        iterate,
        
        /// <remarks/>
        parallel,
        
        /// <remarks/>
        sequence,
        
        /// <remarks/>
        skip,
        
        /// <remarks/>
        start,
        
        /// <remarks/>
        wait,
    }
}
