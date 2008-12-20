using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 


namespace DGAC.database
{
    [Serializable()]
    public class UnitSliceDAO
    {
        public int getNextFreshIndex(int id_concrete, string id_inner, int id_index_inner, string id_unit_slice, int split_replica)
        {
            int key = -1;

            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                 "SELECT MAX(id_index) AS fresh_index " +
                 "FROM hashmodel.unitslice " +
                 "WHERE id_concrete=" + id_concrete + " AND " +
                 "id_inner like '" + id_inner + "' AND " +
                 "id_index_inner = " + id_index_inner + " AND " +
                 "id_interface_slice like '" + id_unit_slice + "' AND " +
                 "split_replica = " + split_replica +
                 " GROUP BY id_concrete, id_inner, id_index_inner, id_interface_slice, split_replica";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();

            if (reader.Read())
            {
                key = (int)reader["fresh_index"];
            }

            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return key+1;
        }
        
        
        public void insert(UnitSlice ac)
        {
            String sql =
                "INSERT INTO hashmodel.unitslice (id_concrete, id_unit, id_index_unit, id_inner, id_index_inner, id_interface_slice, split_replica, id_index)" +
                " VALUES ("
                + ac.Id_concrete + ",'"
                + ac.Id_unit + "',"
                + ac.Id_index_unit + ",'"
                + ac.Id_inner + "',"
                + ac.Id_index_inner + ",'"
                + ac.Id_unit_slice + "',"
                + ac.Split_replica + ","
                + ac.Id_index + ")";

            Connector.performSQLUpdate(sql);
        }

        internal UnitSlice retrieve(int id_concrete, string id_inner, int id_index_inner, string id_unit_slice, int split_replica, int id_index)
        {
            UnitSlice u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_inner, id_index_inner, id_interface_slice, split_replica, id_index, id_unit, id_index_unit " +
                "FROM hashmodel.unitslice " +
                "WHERE " +
                "id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_index_inner=" + id_index_inner + " AND " + 
                "id_interface_slice like '" + id_unit_slice + "' AND " + 
                "split_replica=" + split_replica + " AND " +
                "id_index=" + id_index;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new UnitSlice();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_index_inner = (int)reader["id_index_inner"];
                u.Id_unit_slice = (string)reader["id_interface_slice"];
                u.Split_replica = (int)reader["split_replica"];
                u.Id_index = (int)reader["id_index"];
                u.Id_unit = (string)reader["id_unit"];
                u.Id_index_unit = (int)reader["id_index_unit"];
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

        internal IList<UnitSlice> list(int id_concrete, string id_inner, int id_index_inner)
        {
            IList<UnitSlice> list = new List<UnitSlice>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_inner, id_index_inner, id_interface_slice, split_replica, id_index, id_unit, id_index_unit " +
                "FROM hashmodel.unitslice " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_index_inner=" + id_index_inner ;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                UnitSlice u = new UnitSlice();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_index_inner = (int)reader["id_index_inner"];
                u.Id_unit_slice = (string)reader["id_interface_slice"];
                u.Split_replica = (int)reader["split_replica"];
                u.Id_index = (int)reader["id_index"];
                u.Id_unit = (string)reader["id_unit"];
                u.Id_index_unit = (int)reader["id_index_unit"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }


		internal IList<UnitSlice> listByUnit(int id_concrete, string id_unit, int id_index)
        {
            IList<UnitSlice> list = new List<UnitSlice>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_inner, id_index_inner, id_interface_slice, split_replica, id_index, id_unit, id_index_unit " +
                "FROM hashmodel.unitslice " +
                "WHERE id_concrete=" + id_concrete + " AND " +
                "id_unit like '" + id_unit + "' AND " +
                "id_index_unit=" + id_index;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                UnitSlice u = new UnitSlice();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_index_inner = (int)reader["id_index_inner"];
                u.Id_unit_slice = (string)reader["id_interface_slice"];
                u.Split_replica = (int)reader["split_replica"];
                u.Id_index = (int)reader["id_index"];
                u.Id_unit = (string)reader["id_unit"];
                u.Id_index_unit = (int)reader["id_index_unit"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }

		
       internal UnitSlice retrieve(int id_concrete, string id_unit, int id_index_unit, string id_inner, int id_index_inner)
       {
           UnitSlice u = null;
           IDbConnection dbcon = Connector.DBcon;
           IDbCommand dbcmd = dbcon.CreateCommand();
           string sql =
               "SELECT id_concrete, id_inner, id_index_inner,id_interface_slice, split_replica, id_index, id_unit, id_index_unit "+
               "FROM hashmodel.unitslice WHERE " +
               "id_concrete=" + id_concrete + " AND " +
               "id_unit like '" + id_unit + "' AND " +
               "id_index_unit=" + id_index_unit + " AND " +
               "id_inner=" + id_inner + " AND " +
               "id_index_inner=" + id_index_inner;
           dbcmd.CommandText = sql;
           IDataReader reader = dbcmd.ExecuteReader();
           if (reader.Read())
           {
               u = new UnitSlice();
               u.Id_concrete = (int)reader["id_concrete"];
               u.Id_inner = (string)reader["id_inner"];
               u.Id_index_inner = (int)reader["id_index_inner"];
               u.Id_unit_slice = (string)reader["id_interface_slice"];
               u.Split_replica = (int)reader["split_replica"];
               u.Id_index = (int)reader["id_index"];
               u.Id_unit = (string)reader["id_unit"];
               u.Id_index_unit = (int)reader["id_index_unit"];
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
		
        internal void consolidateIdUnit(UnitSlice ac)
        {
            String sql =
                "UPDATE hashmodel.unitslice" +
                " SET id_index_unit=" + ac.Id_index_unit+ 
                " WHERE " +
                "id_concrete=" + ac.Id_concrete + " AND " +
                "id_inner like '" + ac.Id_inner + "' AND " +
                "id_index_inner=" + ac.Id_index_inner + " AND " + 
                "id_interface_slice like '" + ac.Id_unit_slice + "' AND " +
                "split_replica=" + ac.Split_replica + " AND " +
                "id_index=" + ac.Id_index;

            Connector.performSQLUpdate(sql);
        }
    }
}
