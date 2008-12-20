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
    class EnumeratorSplitDAO
    {

        public void insert(EnumeratorSplit ac)
        {
            String sql =
                "INSERT INTO hashmodel.enumeratorsplit (id_abstract, id_enumerator, id_split, id_enumerator_split, id_total_split)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_enumerator + "'," + ac.Id_split + ",'" + ac.Id_enumerator_split + "'," + ac.Id_total_split + ")";

            Connector.performSQLUpdate(sql);
        }

        public IList<EnumeratorSplit> list(int id_abstract, string id_enumerator, int id_split)
        {
            List<EnumeratorSplit> list = new List<EnumeratorSplit>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_split, id_enumerator_split, id_total_split " +
                "FROM hashmodel.enumeratorsplit " +
                "WHERE id_abstract=" + id_abstract + 
                 " AND id_enumerator='" + id_enumerator + "'" + 
                 " AND id_split=" + id_split + 
                 " ORDER BY id_abstract, id_enumerator, id_split";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumeratorSplit u = new EnumeratorSplit();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_split = (int)reader["id_split"];
                u.Id_enumerator_split = (string)reader["id_enumerator_split"];
                u.Id_total_split = (int)reader["id_total_split"];


                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }

        public EnumeratorSplit retrieve1(int id_abstract, /*int id_split,*/ string id_enumerator_split)
        {
            EnumeratorSplit u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_split, id_enumerator_split, id_total_split " +
                "FROM hashmodel.enumeratorsplit " +
                "WHERE id_abstract=" + id_abstract +
                 " AND id_enumerator_split='" + id_enumerator_split + "'" /* +
                 " AND id_split=" + id_split */;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new EnumeratorSplit();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_split = (int)reader["id_split"];
                u.Id_enumerator_split = (string)reader["id_enumerator_split"];
                u.Id_total_split = (int)reader["id_total_split"];

            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return u;
        }

        public IList<EnumeratorSplit> listall(int id_abstract, string id_enumerator)
        {
            List<EnumeratorSplit> list = new List<EnumeratorSplit>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_split, id_enumerator_split, id_total_split " +
                "FROM hashmodel.enumeratorsplit " +
                "WHERE id_abstract=" + id_abstract +
                 " AND id_enumerator='" + id_enumerator + "'" +
                 " ORDER BY id_abstract, id_enumerator, id_split";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumeratorSplit u = new EnumeratorSplit();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_split = (int)reader["id_split"];
                u.Id_enumerator_split = (string)reader["id_enumerator_split"];
                u.Id_total_split = (int)reader["id_total_split"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }
        
        public IList<EnumeratorSplit> listSplits(int id_abstract, string id_enumerator)
        {
            List<EnumeratorSplit> list = new List<EnumeratorSplit>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT DISTINCT id_abstract, id_enumerator, id_enumerator_split, id_split, id_total_split " +
                "FROM hashmodel.enumeratorsplit " +
                "WHERE id_abstract=" + id_abstract +
                 " AND id_enumerator like '" + id_enumerator + "' " +
                "ORDER BY id_split";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumeratorSplit u = new EnumeratorSplit();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_split = (int)reader["id_split"];
//                u.Id_enumerator_split = null;
                u.Id_enumerator_split = (string)reader["id_enumerator_split"];
                u.Id_total_split = (int)reader["id_total_split"];
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
