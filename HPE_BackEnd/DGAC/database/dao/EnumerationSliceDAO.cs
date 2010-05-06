using System;
using System.IO;
using System.Data;
using System.Data.OleDb;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic;


namespace DGAC.database
{

    [Serializable()]
    public class EnumerationSliceDAO
    {
        public void insert(EnumerationSlice ac)
        {

            String sql =
                "INSERT INTO enumeration_slice (id_abstract, id_enumerator,id_interface_slice, id_inner, id_split_replica)" +
                " VALUES ("
                + ac.Id_abstract + ",'"
                + ac.Id_enumerator + "','"
                + ac.Id_interface_slice + "','"
                + ac.Id_inner +  "'," 
                + ac.Id_split_replica + 
                ")";

            Connector.performSQLUpdate(sql);

        }

        public IList<EnumerationSlice> listByEnumerator(int id_abstract, string id_enumerator)
        {
            List<EnumerationSlice> list = new List<EnumerationSlice>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_interface_slice, id_inner, id_split_replica " +
                "FROM enumeration_slice " +
                "WHERE id_abstract=" + id_abstract + " AND " + 
                "id_enumerator like '" + id_enumerator + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationSlice u = new EnumerationSlice();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_interface_slice = (string)reader["id_interface_slice"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_split_replica = (int)reader["id_split_replica"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }

        public IList<EnumerationSlice> list(int id_abstract, string id_inner, string unit_slice, int split_replica)
        {
            List<EnumerationSlice> list = new List<EnumerationSlice>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_interface_slice, id_inner, id_split_replica " +
                "FROM enumeration_slice " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "' AND " + 
                "id_interface_slice like '" +  unit_slice + "' AND " + 
                "id_split_replica = " + split_replica;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationSlice u = new EnumerationSlice();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_interface_slice = (string)reader["id_interface_slice"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_split_replica = (int)reader["id_split_replica"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }

        public EnumerationSlice retrieve(int id_abstract, string id_inner, string interface_slice, string id_enumerator)
        {
            EnumerationSlice u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_interface_slice, id_split_replica, id_inner " +
                "FROM enumeration_slice " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "' AND " + 
                "id_interface_slice like '" + interface_slice + "' AND " +
               // "id_split_replica = " + id_split_replica + " AND " +
                "id_enumerator like '" + id_enumerator + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new EnumerationSlice();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_interface_slice = (string)reader["id_interface_slice"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_split_replica = (int)reader["id_split_replica"];
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return u;
        }

        // ASSUMPTION: There is only one enumerator with a given variable linked to a given unit.

        internal EnumerationSlice retrieveByVar(int id_abstract, string id_inner, string interface_slice, string varId)
        {
            EnumerationSlice u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT ES.* " +
                "FROM enumeration_slice as ES, enumerator as E " +
                "WHERE ES.id_abstract=" + id_abstract + " AND " +
                "ES.id_inner like '" + id_inner + "' AND " +
                "ES.id_interface_slice like '" + interface_slice + "' AND " +
                "E.variable like '" + varId + "' AND " + 
                "E.id_enumerator = ES.id_enumerator AND E.id_abstract = ES.id_abstract";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new EnumerationSlice();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_interface_slice = (string)reader["id_interface_slice"];
                u.Id_inner = (string)reader["id_inner"];
                u.Id_split_replica = (int)reader["id_split_replica"];
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
