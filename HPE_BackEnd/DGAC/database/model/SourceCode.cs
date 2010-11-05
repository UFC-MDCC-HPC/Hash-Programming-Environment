using System;
using System.Collections.Generic;
using System.Text;
using br.ufc.lia.hpe.backend.DGAC.utils;
using System.IO;

namespace br.ufc.lia.hpe.backend.DGAC.database
{
    public class SourceCode
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

        private int order;

        public int Order
        {
            get { return order; }
            set { order = value; }
        }

        private IList<string> externalReferences = null;

        public IList<string> ExternalReferences
        {
            get
            {
                SourceCodeReferenceDAO scrdao = new SourceCodeReferenceDAO();
                if (externalReferences == null)
                {
                    externalReferences = scrdao.listRefs(this);
                }
                return resolveExternalReferences();
            }
        }


        private IList<string> resolveExternalReferences()
        {
            IList<string> returnExternalReferences = new List<string>();

            IDictionary<string, ReferenceType> refList = FileUtil.loadExternalReferences();

            foreach (string extRef in this.externalReferences)
            {
                ReferenceType pathRef;
                string path;
                if (refList.TryGetValue(extRef, out pathRef))
                    path = pathRef.path;
                else
                {
                    path = Constants.UNIT_PACKAGE_PATH + Path.DirectorySeparatorChar + extRef;
                    Console.Error.WriteLine("External reference " + extRef + " not found. Using default " + path + ".");
                }
                returnExternalReferences.Add(path + Path.DirectorySeparatorChar + extRef + ".dll");
            }
            return returnExternalReferences;
        }

    }
}
