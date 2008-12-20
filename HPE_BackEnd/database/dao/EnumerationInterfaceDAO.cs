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
    class EnumerationInterfaceDAO
    {
        public void insert(EnumerationInterface ac)
        {
            String sql =
                "INSERT INTO hashmodel.enumeration_interface (id_abstract, id_enumerator, id_interface)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_enumerator + "','"+ ac.Id_interface + "')";

            Connector.performSQLUpdate(sql);
        }

        public IList<EnumerationInterface> list(int id_abstract, string id_enumerator)
        {
            List<EnumerationInterface> list = new List<EnumerationInterface>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_interface " +
                "FROM hashmodel.enumeration_interface " +
                "WHERE id_abstract=" + id_abstract + " AND " + 
                "id_enumerator like '" + id_enumerator + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationInterface u = new EnumerationInterface();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_interface = (string)reader["id_interface"];

                list.Add(u);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;
        }

        public EnumerationInterface retrieve(int id_abstract, string id_interface, string id_enumerator)
        {
            EnumerationInterface u = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_interface " +
                "FROM hashmodel.enumeration_interface " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_interface like '" + id_interface + "' AND " +             
                "id_enumerator like '" + id_enumerator + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                u = new EnumerationInterface();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_interface = (string)reader["id_interface"];
            }//if
            
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return u;
        }

        public IList<EnumerationInterface> listByInterface(int id_abstract, string id_interface)
        {
            List<EnumerationInterface> list = new List<EnumerationInterface>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_enumerator, id_interface " +
                "FROM hashmodel.enumeration_interface " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_interface like '" + id_interface + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                EnumerationInterface u = new EnumerationInterface();
                u.Id_abstract = (int)reader["id_abstract"];
                u.Id_enumerator = (string)reader["id_enumerator"];
                u.Id_interface = (string)reader["id_interface"];

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
