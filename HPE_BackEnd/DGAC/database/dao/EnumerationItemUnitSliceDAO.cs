using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 

namespace DGAC.database
{
    [Serializable()]
    public class EnumerationItemUnitSliceDAO
    {
        public void insert(EnumerationItemUnitSlice ac)
        {
            String sql =
                "INSERT INTO hashmodel.enumeration_item_unit_slice (id_concrete, id_inner, id_index_inner, id_interface_slice, split_replica, id_enumerator, value, id_index)" +
                " VALUES ("
                + ac.Id_concrete + ",'"
                + ac.Id_inner + "',"
                + ac.Index_inner + ",'"
                + ac.Id_interface_slice + "',"
                + ac.Split_replica + ",'"
                + ac.Id_enumerator + "',"
                + ac.Value + ","
                + ac.Id_index + ")";

            Connector.performSQLUpdate(sql);
        }


        internal void listOpenEnumerations(int id_concrete, string id_inner, string id_unit_slice, int split_replica, string id_enumerator, out IList<EnumerationItemUnitSlice> list)
        {
            list = new List<EnumerationItemUnitSlice>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_inner, id_index_inner, id_interface_slice, split_replica, id_index, id_enumerator " +
                "FROM hashmodel.enumeration_item_unit_slice " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_interface_slice like '" + id_unit_slice + "' AND " +
                "split_replica=" + split_replica + " AND " +
                "id_enumerator like '" + id_enumerator + "' AND " +
                "value = -1";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationItemUnitSlice u = new EnumerationItemUnitSlice();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_inner = (string)reader["id_inner"];
                u.Index_inner = (int)reader["id_index_inner"];
                u.Id_interface_slice = (string)reader["id_interface_slice"];
                u.Split_replica = (int)reader["split_replica"];
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

        internal void removeOpenEnumerations(int id_concrete, string id_inner, string id_unit_slice, int split_replica, string id_enumerator)
        {
            String sql1 =
                "DELETE FROM hashmodel.enumeration_item_unit_slice WHERE " +
                "id_concrete = " + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_interface_slice like '" + id_unit_slice + "' AND " + 
                "split_replica=" + split_replica + " AND " +
                "id_enumerator like '" + id_enumerator + "' AND " + 
                "value = -1";

            String sql3 =
                "SELECT DISTINCT id_index FROM hashmodel.enumeration_item_unit_slice WHERE " +
                "id_concrete = " + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_interface_slice like '" + id_unit_slice + "' AND " +
                "split_replica=" + split_replica + " AND " +
                "id_enumerator like '" + id_enumerator + "' AND " +
                "value = -1";

            String sql2 =
                "DELETE FROM hashmodel.unitslice WHERE " +
                "id_concrete = " + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_interface_slice like '" + id_unit_slice + "' AND " +
                "split_replica=" + split_replica + " AND " +
                "id_index in (" + sql3 + ")";

            Connector.performSQLUpdate(sql2);
            Connector.performSQLUpdate(sql1);
        }



        internal EnumerationItemUnitSlice retrieve(int id_concrete, string id_inner, int id_index_inner, string id_unit_slice, int split_replica, int id_index, string id_enumerator)
        {
            EnumerationItemUnitSlice u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_inner, id_index_inner, id_interface_slice, split_replica, id_index, id_enumerator, value " +
                "FROM hashmodel.enumeration_item_unit_slice " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_index_inner=" + id_index_inner + " AND " +
                "id_interface_slice like '" + id_unit_slice + "' AND " +
                "split_replica=" + split_replica + " AND " +
                "id_index=" + id_index + " AND " +
                "id_enumerator like '" + id_enumerator + "'"/*+ "' AND " + 
                "value >= 0"*/;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new EnumerationItemUnitSlice();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_inner = (string)reader["id_inner"];
                u.Index_inner = (int)reader["id_index_inner"];
                u.Id_interface_slice = (string)reader["id_interface_slice"];
                u.Split_replica = (int)reader["split_replica"];
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

        internal IList<EnumerationItemUnitSlice> list(int id_concrete, string id_inner, string id_unit_slice, int split_replica, int id_index)
        {
            IList<EnumerationItemUnitSlice> list = new List<EnumerationItemUnitSlice>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_inner, id_index_inner, id_interface_slice, split_replica, id_index, id_enumerator, value " +
                "FROM hashmodel.enumeration_item_unit_slice " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_interface_slice like '" + id_unit_slice + "' AND " +
                "split_replica=" + split_replica + " AND " +
                "id_index = " + id_index;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationItemUnitSlice u = new EnumerationItemUnitSlice();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_inner = (string)reader["id_inner"];
                u.Index_inner = (int)reader["id_index_inner"];
                u.Id_interface_slice = (string)reader["id_interface_slice"];
                u.Split_replica = (int)reader["split_replica"];
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
