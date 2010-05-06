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
    class EnumeratorValuationDAO
    {

        public void insert(EnumeratorValuation ac)
        {
            String sql =
                "INSERT INTO enumerator_valuation (id_concrete, id_enumerator, range_inf, range_sup)" +
                " VALUES (" + ac.Id_concrete + ",'" + ac.Id_enumerator + "'," + ac.Range_inf + "," + ac.Range_sup + ")";

            Connector.performSQLUpdate(sql);
        }


        public IList<EnumeratorValuation> list(int id_concrete)
        {
            List<EnumeratorValuation> list = new List<EnumeratorValuation>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_enumerator, range_inf, range_sup " +
                "FROM enumeratorvaluation " +
                "WHERE id_concrete=" + id_concrete;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumeratorValuation u = new EnumeratorValuation();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Range_inf = (int)reader["range_inf"];
                u.Range_sup = (int)reader["range_sup"];

                list.Add(u);
            }//while

            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }

        public EnumeratorValuation retrieve(int id_concrete, string id_enumerator)
        {
            EnumeratorValuation u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_concrete, id_enumerator, range_inf, range_sup " +
                "FROM enumeratorvaluation " +
                "WHERE id_concrete=" + id_concrete + 
                  "AND id_enumerator like '" + id_enumerator + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new EnumeratorValuation();
                u.Id_concrete = (int)reader["id_concrete"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Range_inf = (int)reader["range_inf"];
                u.Range_sup = (int)reader["range_sup"];
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
