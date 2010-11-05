using System;
using System.Collections.Generic;
using System.Text;

namespace br.ufc.lia.hpe.backend.DGAC.database
{
    [Serializable()]
    public class InnerConcreteComponent
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

        private int id_index;

        public int Id_index
        {
            get { return id_index; }
            set { id_index = value; }
        }

        private int id_concrete_actual;

        public int Id_concrete_actual
        {
            get { return id_concrete_actual; }
            set { id_concrete_actual = value; }
        }


    }
}
