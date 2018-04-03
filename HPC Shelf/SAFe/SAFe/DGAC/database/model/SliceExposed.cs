using System;
using System.IO;
using System.Runtime.Serialization;


namespace br.ufc.pargo.hpe.backend.DGAC.database
{

    [Serializable()]
    public class SliceExposed
    {

        private int id_abstract;
        private string id_inner;
        private string id_interface_slice;
        private string id_inner_original;
        private string id_interface_slice_original;
        private string id_interface_slice_owner;
         private string id_inner_owner;
 
        public string Id_inner_owner
        {
            get { return id_inner_owner; }
            set { id_inner_owner = value; }
        }

        public string Id_interface_slice_owner
        {
            get { return id_interface_slice_owner; }
            set { id_interface_slice_owner = value; }
        }

        public int Id_abstract
        {
            get { return id_abstract; }
            set { id_abstract = value; }
        }

        public string Id_inner
        {
            get { return id_inner; }
            set { id_inner = value; }
        }

        public string Id_interface_slice
        {
            get { return id_interface_slice; }
            set { id_interface_slice = value; }
        }

        public string Id_inner_original
        {
            get { return id_inner_original; }
            set { id_inner_original = value; }
        }

        public string Id_interface_slice_original
        {
            get { return id_interface_slice_original; }
            set { id_interface_slice_original = value; }
        }



    }//class

}//namespace