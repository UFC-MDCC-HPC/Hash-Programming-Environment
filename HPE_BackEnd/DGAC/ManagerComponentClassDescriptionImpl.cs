using System;
using System.Xml.Serialization;

namespace gov
{
    namespace cca
    {
		[Serializable]
        public abstract class ManagerComponentClassDescription : ComponentClassDescription
        {
           // public abstract string ComponentClassName { get; set; }
        }
		
		[Serializable]
        public class ManagerComponentClassDescriptionImpl : ManagerComponentClassDescription
        {

            #region attributes

            private string cname;                         // Qualified name of the owner component

            #endregion

            #region constructors

            public ManagerComponentClassDescriptionImpl()
            {
            }

            public ManagerComponentClassDescriptionImpl(string cname)
            {
               this.cname = cname;
            }

            #endregion
            
            #region properties (for serialization purposes)

            /* The name of the concrete component */
			
            public string ComponentClassName { get { return cname; } set { this.cname = value; } }

            #endregion

            #region ComponentClassDescription members

            public override string getComponentClassName()
            {
                return cname;
            }

            #endregion
            
        }
    }
}
