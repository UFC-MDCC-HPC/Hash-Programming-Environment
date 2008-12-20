using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 

namespace DGAC.database
{
    [Serializable()]
    public class EnumerationItemUnitDAO
    {
        public void insert(EnumerationItemUnit ac)
        {
            String sql =
                "INSERT INTO hashmodel.enumeration_item_unit (id_concrete, id_unit, id_enumerator, value, id_index)" +
                " VALUES ("
                + ac.Id_concrete + ",'"
                + ac.Id_unit + "','"
                + ac.Id_enumerator + "',"
                + ac.Value + ","
                + ac.Id_index + ")";

            Connector.performSQLUpdate(sql);
        }

        internal void listOpenEnumerations(int id_concrete, string id_unit, string id_enumerator, out IList<EnumerationItemUnit> list)
        {
            list = new List<EnumerationItemUnit>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_unit, id_index, id_enumerator " +
                "FROM hashmodel.enumeration_item_unit " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_unit like '" + id_unit + "' AND " +
                "id_enumerator like '" + id_enumerator + "' AND " +
                "value = -1";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationItemUnit u = new EnumerationItemUnit();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_unit = (string)reader["id_unit"];
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

        internal void removeOpenEnumerations(int id_concrete, string id_unit, string id_enumerator)
        {
            String sql1 =
                "DELETE FROM hashmodel.enumeration_item_unit " +
                "WHERE " + 
                "id_concrete=" + id_concrete + " AND " +
                "id_unit like '" + id_unit + "' AND " +
                "id_enumerator like '" + id_enumerator + "' AND " +
                "value = -1";

            String sql3 =
                "SELECT DISTINCT id_index FROM hashmodel.enumeration_item_unit WHERE " +
                "id_concrete=" + id_concrete + " AND " +
                "id_unit like '" + id_unit + "' AND " +
                "id_enumerator like '" + id_enumerator + "' AND " +
                "value = -1";

            String sql2 =
                "DELETE FROM hashmodel.unit WHERE " +
                "id_concrete=" + id_concrete + " AND " +
                "id_unit like '" + id_unit + "' AND " +
                "id_index in (" + sql3 + ")";

            Connector.performSQLUpdate(sql2);
            Connector.performSQLUpdate(sql1);

        }

        internal IList<EnumerationItemUnit> list(int id_concrete, string id_unit, int id_index)
        {
            IList<EnumerationItemUnit> list = new List<EnumerationItemUnit>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_unit, id_index, id_enumerator, value " +
                "FROM hashmodel.enumeration_item_unit " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_unit like '" + id_unit + "' AND " + 
                "id_index=" + id_index;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationItemUnit u = new EnumerationItemUnit();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_unit = (string)reader["id_unit"];
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
