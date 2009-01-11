using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    [Serializable()]
    public class EnumerationItemUnitSlice : EnumerationItem
    {
        private int id_concrete;

        public int Id_concrete
        {
            get { return id_concrete; }
            set { id_concrete = value; }
        }

        private string id_interface_slice;

        public string Id_interface_slice
        {
            get { return id_interface_slice; }
            set { id_interface_slice = value; }
        }

        private string id_inner;

        public string Id_inner
        {
            get { return id_inner; }
            set { id_inner = value; }
        }

        private int index_inner;

        public int Index_inner
        {
            get { return index_inner; }
            set { index_inner = value; }
        }

        private int split_replica;

        public int Split_replica
        {
            get { return split_replica; }
            set { split_replica = value; }
        }


    }
}

