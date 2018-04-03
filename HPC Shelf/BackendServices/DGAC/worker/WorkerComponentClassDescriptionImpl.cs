using System;

namespace gov
{
    namespace cca
    {

        public abstract class WorkerComponentClassDescription : ComponentClassDescription
        {
            public abstract int GenericArgumentCount { get; }
            public abstract string AssemblyString { get; }
            public abstract string ComponentName { get; }
            public abstract string UnitName { get; }
        }

        public class WorkerComponentClassDescriptionImpl : WorkerComponentClassDescription
        {
            public WorkerComponentClassDescriptionImpl(string cname, string uname, string className, int nargs, string assembly_string)
            {
                this.uname = uname;
                this.cname = cname;
                this.className = className;
                this.nargs = nargs;
                this.assembly_string = assembly_string;
            }

            private string uname;
            private string cname;                         // Qualified name of the owner component
            private string className = null;              // Class name of the unit
            private int nargs;
            private string assembly_string = null;

            public override string getComponentClassName()
            {
                return className;
            }

            public override int GenericArgumentCount { get { return nargs; } }

            public override string AssemblyString { get { return assembly_string; } }

            public override string ComponentName { get { return cname;  } }

            public override string UnitName { get { return uname; } }

        }
    }
}
