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
    public class EnumerationInnerDAO
    {
        public void insert(EnumerationInner ac)
        {

            String sql =
                "INSERT INTO enumeration_inner (id_abstract, id_enumerator, id_inner)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_enumerator + "','" + ac.Id_inner + "')";

            Connector.performSQLUpdate(sql);
        }

        public IList<EnumerationInner> list(int id_abstract, string id_enumerator)
        {
            List<EnumerationInner> list = new List<EnumerationInner>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_inner " +
                "FROM enumeration_inner " +
                "WHERE id_abstract=" + id_abstract + " AND " + 
                "id_enumerator like '" + id_enumerator + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationInner u = new EnumerationInner();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_inner = (string)reader["id_inner"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }

        public IList<EnumerationInner> listByInner(int id_abstract, string id_inner)
        {
            List<EnumerationInner> list = new List<EnumerationInner>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_inner " +
                "FROM enumeration_inner " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationInner u = new EnumerationInner();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_inner = (string)reader["id_inner"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }

        internal EnumerationInner retrieve(int id_abstract, string id_inner, string id_enumerator)
        {
            EnumerationInner u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_inner " +
                "FROM enumeration_inner " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_enumerator like '" + id_enumerator + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new EnumerationInner();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_inner = (string)reader["id_inner"];

            }//if
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return u;
        }
    }

}
