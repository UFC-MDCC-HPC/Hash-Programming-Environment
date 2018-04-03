
using System;
using System.Collections.Generic;
using System.Diagnostics;

namespace gov
{
    namespace cca
    {
        [Serializable]
        public abstract class ManagerComponentID : ComponentID
        {
            public abstract string InstanceName { get; set; }
			public abstract string ClassName { get; set; }
            public abstract IList<string>[] WorkerUnitNames { get; set; }
			public abstract int Version {get; set;}

           // public abstract WorkerComponentID WorkerComponentID { get; }
			public abstract WorkerComponentID WorkerComponentID { get; set; }
            public abstract int Id_functor_app { get; }
			public abstract string PortName {get; set;}
            public abstract int Kind { get; }
        }


        [Serializable]
        public class ManagerComponentIDImpl : ManagerComponentID
        {
            #region attributes

            private IList<string>[] unit_ids = null;
            private int[] indexes = null;
            private string instanceNamePrim = null;
            private string classNamePrim = null;
			private int version;
			private string portName;

            #endregion

            #region constructors

            //public ManagerComponentIDImpl()
            //{
            //}
			
			// For registering a Host Program
            public ManagerComponentIDImpl(string instanceName, string className)
            {
                this.instanceNamePrim = instanceName;
				this.classNamePrim = className;
            }
			
			// For registering a #-component
            public ManagerComponentIDImpl(string instanceName, string className, IList<string>[] unit_ids, int id_functor_app, int kind, string portName)
            {
                this.instanceNamePrim = instanceName;
				this.classNamePrim = className;
                this.unit_ids = unit_ids;
                this.id_functor_app = id_functor_app;
                this.kind = kind;
				this.portName = portName;	
            }

            #endregion

            #region properties (for serialization purposes)

            public override string InstanceName
            {
                get { return instanceNamePrim; }
                set { this.instanceNamePrim = value; }
            }

            public override int Version
            {
                get { return version; }
                set { this.version = value; }
            }
			
            public override string ClassName
            {
                get { return classNamePrim; }
                set { this.classNamePrim = value; }
            }

            public override string PortName
            {
                get { return portName; }
                set { this.portName = value; }
            }

 
            public override IList<string>[] WorkerUnitNames
            {
                get { return unit_ids; }
                set { this.unit_ids = value; }
            }
				
            #endregion 

            #region ComponentID members

            public override string getInstanceName()
            {
                return instanceNamePrim;
            }

            public override string getSerialization()
            {
                return this.ToString(); /* TODO: return a XML */
            }

            #endregion

			WorkerComponentID wcid = null;
			

            public override WorkerComponentID WorkerComponentID
			{
				get {
					return wcid;
				}
				set {
					this.wcid = value;
				}
            }

            public override string ToString()
            {
                return instanceNamePrim;
            }

            private int id_functor_app;

            public override int Id_functor_app
            {
                get { return id_functor_app; }
            }

            private int kind;

            public override int Kind
            {
                get { return kind; }
            }
        }

    }
}
