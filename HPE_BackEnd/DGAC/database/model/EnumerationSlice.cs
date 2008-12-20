using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    [Serializable()]
    class EnumerationSlice
    {
        private int id_abstract;

        public int Id_abstract
        {
            get { return id_abstract; }
            set { id_abstract = value; }
        }

        private string id_inner;

        public string Id_inner
        {
            get { return id_inner; }
            set { id_inner = value; }
        }
        
        private string id_interface_slice;

        public string Id_interface_slice
        {
            get { return id_interface_slice; }
            set { id_interface_slice = value; }
        }

        private int id_split_replica;

        public int Id_split_replica
        {
            get { return id_split_replica; }
            set { id_split_replica = value; }
        }


        private string id_enumerator;

        public string Id_enumerator
        {
            get { return id_enumerator; }
            set { id_enumerator = value; }
        }


    }
}
