using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    [Serializable()]
    public class EnumerationItem
    {
        private int id_index;

        public int Id_index
        {
            get { return id_index; }
            set { id_index = value; }
        }

        private string id_enumerator;

        public string Id_enumerator
        {
            get { return id_enumerator; }
            set { id_enumerator = value; }
        }

        private int value;

        public int Value
        {
            get { return this.value; }
            set { this.value = value; }
        }



    }
}
