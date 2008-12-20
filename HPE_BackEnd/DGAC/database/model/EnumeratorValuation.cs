using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    [Serializable()]
    class EnumeratorValuation
    {
        private int id_concrete;

        public int Id_concrete
        {
            get { return id_concrete; }
            set { id_concrete = value; }
        }


        private string id_enumerator;

        public string Id_enumerator
        {
            get { return id_enumerator; }
            set { id_enumerator = value; }
        }

        private int range_inf;

        public int Range_inf
        {
            get { return range_inf; }
            set { range_inf = value; }
        }

        private int range_sup;

        public int Range_sup
        {
            get { return range_sup; }
            set { range_sup = value; }
        }
        

    }
}
