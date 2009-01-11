using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic;

namespace DGAC.database
{

    [Serializable()]
    public class SliceExposedDAO
    {

        public void insert(SliceExposed ac)
        {

            String sql =
                "INSERT INTO hashmodel.sliceexposed (id_abstract, id_interface_slice, id_interface_slice_owner, id_inner, id_inner_owner,  id_split_replica,  id_split_replica_owner)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_interface_slice + "','" + ac.Id_interface_slice_owner + "','" + ac.Id_inner + "','" + ac.Id_inner_owner + "'," + ac.Id_split_replica + "," + ac.Id_split_replica_owner + ")";

            Connector.performSQLUpdate(sql);

        }


        internal IList<SliceExposed> listExposedSlicesByContainer(int id_abstract, string id_inner_owner, string id_interface_slice_owner, int id_split_replica_owner)
        {

            IList<SliceExposed> list = new List<SliceExposed>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner, id_inner_owner, id_interface_slice, id_interface_slice_owner, id_split_replica, id_split_replica_owner " +
                "FROM hashmodel.sliceexposed " +
                "WHERE id_abstract=" + id_abstract + " and " + 
                      "id_inner_owner like '" + id_inner_owner + "' and " +
                      "id_interface_slice_owner like '" + id_interface_slice_owner + "' and " + 
                      "id_split_replica_owner = " + id_split_replica_owner;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                SliceExposed s = new SliceExposed();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_inner_owner = (string)reader["id_inner_owner"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_interface_slice_owner = (string)reader["id_interface_slice_owner"];
                s.Id_split_replica = (int)reader["id_split_replica"];
                s.Id_split_replica_owner = (int)reader["id_split_replica_owner"];
                list.Add(s);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;

        }

        internal string retrieveIdInnerOwner(int id_abstract, string id_inner, string id_unit)
        {
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT DISTINCT id_abstract, id_inner, id_interface_slice, id_inner_owner "  +
                "FROM hashmodel.sliceexposed " +
                "WHERE id_abstract=" + id_abstract + " and " +
                      "id_inner like '" + id_inner + "' and " +
                      "id_interface_slice like '" + id_unit + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            string id_inner_owner = null;
            if (reader.Read())            
                id_inner_owner = (string)reader["id_inner_owner"];
             //while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return id_inner_owner;
        }

        internal IList<SliceExposed> listContainers(string id_inner, string id_interface_slice, int id_abstract, int id_split_replica) 
        {
            IList<SliceExposed> ll = new List<SliceExposed>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            SliceExposed se = null;
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, id_split_replica, id_split_replica_owner, id_inner_owner, id_interface_slice_owner " +
                "FROM hashmodel.sliceexposed " +
                "WHERE id_inner like '" + id_inner + "' and " +
                      "id_interface_slice like '" + id_interface_slice + "' and " +
                      "id_abstract = " + id_abstract + " and " +
                      "id_split_replica = " + id_split_replica;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                se = new SliceExposed();
                se.Id_inner = (string)reader["id_inner"];
                se.Id_abstract = (int)reader["id_abstract"];
                se.Id_interface_slice = (string)reader["id_interface_slice"];
                se.Id_split_replica = (int)reader["id_split_replica"];
                se.Id_inner_owner = (string)reader["id_inner_owner"];
                se.Id_interface_slice_owner = (string)reader["id_interface_slice_owner"];
                se.Id_split_replica_owner = (int)reader["id_split_replica_owner"];
                ll.Add(se);
            }
            //if
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return ll;
        }

        internal SliceExposed retrieve2(string id_inner, string id_interface_slice, int id_abstract, string id_interface_container)
        {
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            SliceExposed se = null;
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, id_split_replica, id_split_replica_owner, id_inner_owner, id_interface_slice_owner " +
                "FROM hashmodel.sliceexposed " +
                "WHERE id_inner like '" + id_inner + "' and " +
                      "id_interface_slice like '" + id_interface_slice + "' and " +
                      "id_abstract = " + id_abstract + " and " +
                      "id_interface_slice_owner like '" + id_interface_container + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                se = new SliceExposed();
                se.Id_inner = (string)reader["id_inner"];
                se.Id_abstract = (int)reader["id_abstract"];
                se.Id_interface_slice = (string)reader["id_interface_slice"];
                se.Id_split_replica = (int)reader["id_split_replica"];
                se.Id_inner_owner = (string)reader["id_inner_owner"];
                se.Id_interface_slice_owner = (string)reader["id_interface_slice_owner"];
                se.Id_split_replica_owner = (int)reader["id_split_replica_owner"];
            }
            //if
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return se;
        }
    }//class

}//namespace
