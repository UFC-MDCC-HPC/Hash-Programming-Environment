using System;
using System.Collections.Generic;
using System.Text;
using DGAC.database;
using System.Data;


namespace DGAC.database
{
    class SourceCodeDAO
    {
        public void insert(SourceCode ac)
        {
            String sql =
                "INSERT INTO hashmodel.sourcecode (type_owner, id_owner_container, id_owner, contents, file_type, file_name)" +
                " VALUES ('" + ac.Type_owner + "'," + ac.Id_owner_container + ",'" + ac.Id_owner + "','" + ac.Contents + "','" + ac.File_type + "','" + ac.File_name + "')";

            Connector.performSQLUpdate(sql);
        }

        public IList<SourceCode> list(char type_owner, int id_owner_container, string id_owner)
        {
            IList<SourceCode> list = new List<SourceCode>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT type_owner, id_owner_container, id_owner, contents, file_type, file_name " +
                "FROM sourcecode " +
                "WHERE type_owner like '" + type_owner + "' AND id_owner_container=" + id_owner_container + " AND id_owner like '" + id_owner + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                SourceCode sc = new SourceCode();
                sc.Type_owner = ((string)reader["type_owner"])[0];
                sc.Id_owner_container = (int)reader["id_owner_container"];
                sc.Id_owner = (string)reader["id_owner"];
                sc.Contents = (string)reader["contents"];
                sc.File_name = (string)reader["file_name"];
                sc.File_type = (string)reader["file_type"];

                list.Add(sc);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;

        }//list

    }
}
