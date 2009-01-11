using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    class SourceCode
    {
        private char type_owner;

        public char Type_owner
        {
          get { return type_owner; }
          set { type_owner = value; }
        }
        private int id_owner_container;

        public int Id_owner_container
        {
          get { return id_owner_container; }
          set { id_owner_container = value; }
        }
        private string id_owner;

        public string Id_owner
        {
          get { return id_owner; }
          set { id_owner = value; }
        }
        private string contents;

        public string Contents
        {
          get { return contents; }
          set { contents = value; }
        }
        private string file_name;

        public string File_name
        {
          get { return file_name; }
          set { file_name = value; }
        }
        private string file_type;

        public string File_type
        {
          get { return file_type; }
          set { file_type = value; }
        }

    }
}
