using System;
using System.Collections.Generic;
using System.Text;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.Data;
using System.Diagnostics;


namespace br.ufc.pargo.hpe.backend.DGAC.database
{
    public class SourceCodeReferenceDAO
    {
        public void insert(SourceCodeReference ac)
        {
            String sql =
                "INSERT INTO sourcecode_references (type_owner, id_owner_container, id_owner, file_name, reference)" +
                " VALUES ('" + ac.Type_owner + "'," + ac.Id_owner_container + ",'" + ac.Id_owner + "','" + ac.File_name + "','" + ac.Reference + "')";

            Connector.performSQLUpdate(sql);
        }

        public IList<string> listRefs(SourceCode scr)
        {
            IList<string> extRefs = new List<string>();

            foreach (SourceCodeReference extRef in list(scr.Type_owner, scr.Id_owner_container, scr.Id_owner, scr.File_name))
            {
				Console.WriteLine("SOURCE CODE EXTERNAL REFERENCE " + extRef.Reference);
                extRefs.Add(extRef.Reference);
            }

            return extRefs;
        }

        public IList<SourceCodeReference> list(SourceCode scr)
        {
            return list(scr.Type_owner, scr.Id_owner_container,scr.Id_owner,scr.File_name);
        }


        public IList<SourceCodeReference> list(char type_owner, int id_owner_container, string id_owner, string filename)
        {
            IList<SourceCodeReference> list = new List<SourceCodeReference>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT type_owner, id_owner_container, id_owner, file_name, reference " +
                "FROM sourcecode_references " +
                "WHERE type_owner like '" + type_owner + "' AND id_owner_container=" + id_owner_container + " AND id_owner like '" + id_owner + "' AND file_name like '" + filename + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                SourceCodeReference sc = new SourceCodeReference();
                sc.Type_owner = ((string)reader["type_owner"])[0];
                sc.Id_owner_container = (int)reader["id_owner_container"];
                sc.Id_owner = (string)reader["id_owner"];
                sc.File_name = (string)reader["file_name"];
                sc.Reference = (string)reader["reference"];
                list.Add(sc);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;

        }//list

        public SourceCodeReference retrieve(SourceCodeReference scr)
        {
            return retrieve(scr.Type_owner, scr.Id_owner_container, scr.Id_owner, scr.File_name, scr.Reference);
        }

        public SourceCodeReference retrieve(char type_owner, int id_owner_container, string id_owner, string filename, string reference)
        {
            SourceCodeReference sc = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT type_owner, id_owner_container, id_owner, file_name, reference " +
                "FROM sourcecode_references " +
                "WHERE type_owner like '" + type_owner + 
                     "' AND id_owner_container=" + id_owner_container + 
                     " AND id_owner like '" + id_owner + 
                     "' AND file_name like '" + filename + 
                     "' AND reference like '" + reference + "'";

            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                sc = new SourceCodeReference();
                sc.Type_owner = ((string)reader["type_owner"])[0];
                sc.Id_owner_container = (int)reader["id_owner_container"];
                sc.Id_owner = (string)reader["id_owner"];
                sc.File_name = (string)reader["file_name"];
                sc.Reference = (string)reader["reference"];                
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return sc;

        }//retrieve

        internal void update(SourceCodeReference ss)
        {
            String sql =
                "UPDATE sourcecode_references SET reference = '" + ss.Reference + "' WHERE type_owner like '" + ss.Type_owner + "'"
                                       + " and id_owner like '" + ss.Id_owner + "'"
                                       + " and file_name like '" + ss.File_name + "'"
                                       + " and id_owner_container = " + ss.Id_owner_container ;
 
                
                
            Connector.performSQLUpdate(sql);
        }
    }
}
