// ------------------------------------------------------------------------------
//  <autogenerated>
//      This code was generated by a tool.
//      Mono Runtime Version: 4.0.30319.17020
// 
//      Changes to this file may cause incorrect behavior and will be lost if 
//      the code is regenerated.
//  </autogenerated>
// ------------------------------------------------------------------------------

namespace TestService.Platform {
    using System.Diagnostics;
    using System;
    using System.Xml.Serialization;
    using System.ComponentModel;
    using System.Web.Services.Protocols;
    using System.Web.Services;
    
    
    /// CodeRemarks
    [System.CodeDom.Compiler.GeneratedCodeAttribute("MonoDevelop", "2.6.0.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="PlatformSoap", Namespace="http://tempuri.org/")]
    public partial class Platform : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        /// CodeRemarks
        public Platform() {
            this.Url = "http://127.0.0.1:8082/Platform.asmx";
        }
        
        public Platform(string url) {
            this.Url = url;
        }
        
        /// CodeRemarks
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/getNumberOfNodes", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public int getNumberOfNodes() {
            object[] results = this.Invoke("getNumberOfNodes", new object[0]);
            return ((int)(results[0]));
        }
        
        /// CodeRemarks
        public System.IAsyncResult BegingetNumberOfNodes(System.AsyncCallback callback, object asyncState) {
            return this.BeginInvoke("getNumberOfNodes", new object[0], callback, asyncState);
        }
        
        /// CodeRemarks
        public int EndgetNumberOfNodes(System.IAsyncResult asyncResult) {
            object[] results = this.EndInvoke(asyncResult);
            return ((int)(results[0]));
        }
        
        /// CodeRemarks
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/deploy", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public string deploy(string config_contents) {
            object[] results = this.Invoke("deploy", new object[] {
                        config_contents});
            return ((string)(results[0]));
        }
        
        /// CodeRemarks
        public System.IAsyncResult Begindeploy(string config_contents, System.AsyncCallback callback, object asyncState) {
            return this.BeginInvoke("deploy", new object[] {
                        config_contents}, callback, asyncState);
        }
        
        /// CodeRemarks
        public string Enddeploy(System.IAsyncResult asyncResult) {
            object[] results = this.EndInvoke(asyncResult);
            return ((string)(results[0]));
        }
        
        /// CodeRemarks
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("http://tempuri.org/instantiate", RequestNamespace="http://tempuri.org/", ResponseNamespace="http://tempuri.org/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        public string instantiate(string component_ref, int facet_instance, int[] facet, string[] facet_address) {
            object[] results = this.Invoke("instantiate", new object[] {
                        component_ref,
                        facet_instance,
                        facet,
                        facet_address});
            return ((string)(results[0]));
        }
        
        /// CodeRemarks
        public System.IAsyncResult Begininstantiate(string component_ref, int facet_instance, int[] facet, string[] facet_address, System.AsyncCallback callback, object asyncState) {
            return this.BeginInvoke("instantiate", new object[] {
                        component_ref,
                        facet_instance,
                        facet,
                        facet_address}, callback, asyncState);
        }
        
        /// CodeRemarks
        public string Endinstantiate(System.IAsyncResult asyncResult) {
            object[] results = this.EndInvoke(asyncResult);
            return ((string)(results[0]));
        }
    }
}
