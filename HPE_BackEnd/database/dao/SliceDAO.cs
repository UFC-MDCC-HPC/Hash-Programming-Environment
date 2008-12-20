﻿using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 

namespace DGAC.database
{

    [Serializable()]
    public class SliceDAO
    {

        public void insert(Slice ac)
        {

            String sql =
                "INSERT INTO hashmodel.slice (id_abstract, id_interface, id_interface_slice, id_inner, id_split_replica, transitive)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_interface + "','"+ ac.Id_interface_slice + "','" + ac.Id_inner + "'," + ac.Id_split_replica + "," + (ac.Transitive ? -1 : 0) + ")";

            Connector.performSQLUpdate(sql);

        }

        public IList<Slice> list(int id_abstract, string id_interface)
        {

            IList<Slice> list = new List<Slice>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_interface, id_interface_slice, id_inner, id_split_replica, transitive " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " and " + "id_interface like '" + id_interface + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                Slice s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_interface = (string)reader["id_interface"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_split_replica = (int)reader["id_split_replica"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;

                list.Add(s);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;

        }//list

        // ADDED BY HERON
        public Slice retrieve(int id_abstract, string id_inner, string id_interface_slice, int id_split_replica)
        {
            Slice s = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_interface, id_interface_slice, id_inner, id_split_replica, transitive " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "' AND " + 
                "id_interface_slice like '" + id_interface_slice + "' AND " + 
                "id_split_replica = " + id_split_replica;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_interface = (string)reader["id_interface"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_split_replica = (int)reader["id_split_replica"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
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
            return s;

        }//list

        // ADDED BY HERON
        public Slice retrieve2(int id_abstract, string id_inner, string id_interface_slice, string id_interface)
        {
            Slice s = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_interface, id_interface_slice, id_inner, id_split_replica, transitive " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_interface_slice like '" + id_interface_slice + "' AND " +
                "id_interface like '" + id_interface + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_interface = (string)reader["id_interface"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_split_replica = (int)reader["id_split_replica"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
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
            return s;

        }//list

        
        
        
        public IList<Slice> list2(int id_abstract, string id_inner)
        {

            IList<Slice> list = new List<Slice>();
            IDbConnection dbcon = Connector.getConnection();
            dbcon.Open();
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, id_interface, id_split_replica, transitive " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " and id_inner like '" + id_inner + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                Slice s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_interface = (string)reader["id_interface"];
                s.Id_split_replica = (int)reader["id_split_replica"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
                list.Add(s);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            dbcon.Close();
            dbcon = null;
            return list;

        }//list

        internal IList<Slice> listSlicesOfInner(int id_abstract, string id_inner, string id_interface_slice)
        {
            IList<Slice> list = new List<Slice>();
            IDbConnection dbcon = Connector.getConnection();
            dbcon.Open();
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, id_interface, id_split_replica, transitive " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " and id_inner like '" + id_inner + "'" + " and id_interface_slice like '" + id_interface_slice + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                Slice s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_interface = (string)reader["id_interface"];
                s.Id_split_replica = (int)reader["id_split_replica"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
                list.Add(s);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            dbcon.Close();
            dbcon = null;
            return list;
        }
    }//class

}//namespace
