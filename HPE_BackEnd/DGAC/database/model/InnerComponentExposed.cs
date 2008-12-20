using System;
using System.IO;
using System.Runtime.Serialization;


namespace DGAC.database
{

    [Serializable()]
    public class InnerComponentExposed
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

        private string id_inner_rename;

        public string Id_inner_rename
        {
            get { return id_inner_rename; }
            set { id_inner_rename = value; }
        }

        private string id_inner_owner;

        public string Id_inner_owner
        {
            get { return id_inner_owner; }
            set { id_inner_owner = value; }
        }

    }//class

}//namespace
