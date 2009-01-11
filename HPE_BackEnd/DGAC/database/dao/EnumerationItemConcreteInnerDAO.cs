using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 


namespace DGAC.database
{
    [Serializable()]
    public class EnumerationItemConcreteInnerDAO
    {
        public void insert(EnumerationItemConcreteInner ac)
        {
            String sql =
                "INSERT INTO hashmodel.enumeration_item_concrete_inner (id_concrete, id_inner, id_enumerator, value, id_index)" +
                " VALUES ("
                + ac.Id_concrete + ",'"
                + ac.Id_inner + "','"
                + ac.Id_enumerator + "',"
                + ac.Value + ","
                + ac.Id_index + ")";

            Connector.performSQLUpdate(sql);
        }

        internal void removeOpenEnumerations(int id_concrete, string id_inner, string id_enumerator)
        {
            // NOTE: THE INNER COMPONENT and its units slices MUST BE ALSO REMOVED !!!!!!!

            String sql1 =
                "DELETE FROM hashmodel.enumeration_item_concrete_inner WHERE " +
                "id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_enumerator like '" + id_enumerator + "' AND " +
                "value = -1";

            String sql3 =
                "SELECT DISTINCT id_index FROM hashmodel.enumeration_item_concrete_inner WHERE " +
                "id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_enumerator like '" + id_enumerator + "' AND " +
                "value = -1";

            String sql2 =
                "DELETE FROM hashmodel.innerconcrete WHERE " +
                "id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_index in (" + sql3 + ")";

            String sql4 =
                "DELETE FROM hashmodel.unitslice WHERE " +
                "id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_index_inner in (" + sql3 + ")";

            Connector.performSQLUpdate(sql4);
            Connector.performSQLUpdate(sql2);
            Connector.performSQLUpdate(sql1);
        }

        internal void listOpenEnumerations(int id_concrete, string id_inner, string id_enumerator, out IList<EnumerationItemConcreteInner> list)
        {
            list = new List<EnumerationItemConcreteInner>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_inner, id_index, id_enumerator " +
                "FROM hashmodel.enumeration_item_concrete_inner " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " + 
                "id_enumerator like '" + id_enumerator + "' AND " +
                "value = -1";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationItemConcreteInner u = new EnumerationItemConcreteInner();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_index = (int)reader["id_index"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Value = -1;

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            
        }

        internal EnumerationItemConcreteInner retrieve(int id_concrete, string id_inner, int id_index_inner, string id_enumerator)
        {
            EnumerationItemConcreteInner u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_inner, id_index, id_enumerator, value " +
                "FROM hashmodel.enumeration_item_concrete_inner " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_index=" + id_index_inner + " AND "+
                "id_enumerator like '" + id_enumerator + "'"/*+ "' AND " +
                "value >= 0"*/;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new EnumerationItemConcreteInner();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_index = (int)reader["id_index"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Value = (int)reader["value"];
            }
            else
            {
                // UNIT NOT FOUND
            }



            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return u;
        }

        internal IList<EnumerationItemConcreteInner> list(int id_concrete, string id_inner, int id_index)
        {
            IList<EnumerationItemConcreteInner> list = new List<EnumerationItemConcreteInner>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_inner, id_index, id_enumerator, value " +
                "FROM hashmodel.enumeration_item_concrete_inner " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_index=" + id_index;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationItemConcreteInner u = new EnumerationItemConcreteInner();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_index = (int)reader["id_index"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Value = (int)reader["value"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }
    }
}
