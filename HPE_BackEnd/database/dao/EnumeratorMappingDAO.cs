using System;
using System.Collections.Generic;
using System.Text;
using System.Data;

namespace DGAC.database
{
    [Serializable()]
    class EnumeratorMappingDAO
    {
        public void insert(EnumeratorMapping ac)
        {
            String sql =
                "INSERT INTO hashmodel.enumerator_mapping (id_abstract, id_inner, id_enumerator_inner, id_enumerator_container)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_inner + "','" + ac.Id_enumerator_inner + "','" + ac.Id_enumerator_container + "')";

            Connector.performSQLUpdate(sql);
        }

        public EnumeratorMapping retrieve(int id_abstract, string id_inner, string id_enumerator_container) 
        {
            EnumeratorMapping u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner, id_enumerator_inner, id_enumerator_container " +
                "FROM hashmodel.enumerator_mapping " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_enumerator_container like '" + id_enumerator_container + "'";

            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new EnumeratorMapping();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_enumerator_inner = (string)reader["id_enumerator_inner"];
                u.Id_enumerator_container = (string)reader["id_enumerator_container"];
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return u;

        }
    }
}
