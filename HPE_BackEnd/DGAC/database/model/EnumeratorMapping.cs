using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    class EnumeratorMapping
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

        private string id_enumerator_inner;

        public string Id_enumerator_inner
        {
            get { return id_enumerator_inner; }
            set { id_enumerator_inner = value; }
        }

        private string id_enumerator_container;

        public string Id_enumerator_container
        {
            get { return id_enumerator_container; }
            set { id_enumerator_container = value; }
        }

    }
}
