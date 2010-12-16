using System;
using System.Collections.Generic;
using System.Text;

namespace br.ufc.pargo.hpe.backend.DGAC.database
{
    [Serializable()]
    public class EnumerationInterface
    {
        private int id_abstract;

        public int Id_abstract
        {
            get { return id_abstract; }
            set { id_abstract = value; }
        }

        private string id_enumerator;

        public string Id_enumerator
        {
            get { return id_enumerator; }
            set { id_enumerator = value; }
        }

        private string id_interface;

        public string Id_interface
        {
            get { return id_interface; }
            set { id_interface = value; }
        }


    }
}
