using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    [Serializable()]
    public class EnumerationItemUnit : EnumerationItem
    {
        private int id_concrete;

        public int Id_concrete
        {
            get { return id_concrete; }
            set { id_concrete = value; }
        }

        private string id_unit;

        public string Id_unit
        {
            get { return id_unit; }
            set { id_unit = value; }
        }

    }
}
