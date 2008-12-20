using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    public abstract class HashComponent
    {
        private string hash_component_UID;

        public string Hash_component_UID
        {
            get { return hash_component_UID; }
            set { hash_component_UID = value; }
        }
    }
}
