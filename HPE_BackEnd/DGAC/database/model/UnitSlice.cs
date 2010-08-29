using System;
using System.Collections.Generic;
using System.Text;

namespace br.ufc.hpe.backend.DGAC.database
{
    [Serializable()]
    public class UnitSlice
    {

        private int id_concrete;

        public int Id_concrete
        {
            get { return id_concrete; }
            set { id_concrete = value; }
        }

        private string id_inner;

        public string Id_inner
        {
            get { return id_inner; }
            set { id_inner = value; }
        }

        private int id_index_inner;

        public int Id_index_inner
        {
            get { return id_index_inner; }
            set { id_index_inner = value; }
        }

        private string id_unit_slice;

        public string Id_unit_slice
        {
            get { return id_unit_slice; }
            set { id_unit_slice = value; }
        }

        private string id_unit;

        public string Id_unit
        {
            get { return id_unit; }
            set { id_unit = value; }
        }

        private int id_index_unit;

        public int Id_index_unit
        {
            get { return id_index_unit; }
            set { id_index_unit = value; }
        }

        private int id_index;

        public int Id_index
        {
            get { return id_index; }
            set { id_index = value; }
        }

        private int split_replica;

        public int Split_replica
        {
            get { return split_replica; }
            set { split_replica = value; }
        }

    }
}
