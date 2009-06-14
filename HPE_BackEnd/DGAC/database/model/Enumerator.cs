using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    [Serializable()]
    class Enumerator
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

        private bool from_split;

        public bool From_split
        {
            get { return from_split; }
            set { from_split = value; }
        }

        private string variable;

        public string Variable
        {
            get { return variable; }
            set { variable = value; }
        }

        private int valuation;

        public int Valuation
        {
            get { return valuation; }
            set { valuation = value; }
        }
       

    }
}
