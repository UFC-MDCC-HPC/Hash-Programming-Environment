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
    class EnumeratorDAO
    {

        public void insert(Enumerator ac)
        {
            String sql =
                "INSERT INTO hashmodel.enumerator (id_abstract, id_enumerator, split_from, variable)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_enumerator + "'," + ac.From_split + ",'" + ac.Variable + "')";

            Connector.performSQLUpdate(sql);
        }


        public IList<Enumerator> list(int id_abstract)
        {
            List<Enumerator> list = new List<Enumerator>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, variable, split_from " +
                "FROM hashmodel.enumerator " +
                "WHERE id_abstract=" + id_abstract;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                Enumerator u = new Enumerator();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.From_split = ((int)reader["split_from"])==0 ? false : true;
                u.Variable = (string)reader["variable"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }

        public Enumerator retrieveByVariable(int id_abstract, string variable)
        {
            Enumerator u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, variable, split_from " +
                "FROM hashmodel.enumerator " +
                "WHERE id_abstract=" + id_abstract + " AND " + 
                "variable like '" + variable + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new Enumerator();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.From_split = ((int)reader["split_from"]) == 0 ? false : true;
                u.Variable = (string)reader["variable"];

            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return u;
        }

        public Enumerator retrieve(int id_abstract, string id_enumerator)
        {
            Enumerator u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, variable, split_from " +
                "FROM hashmodel.enumerator " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_enumerator like '" + id_enumerator + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new Enumerator();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.From_split = ((int)reader["split_from"]) == 0 ? false : true;
                u.Variable = (string)reader["variable"];

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
