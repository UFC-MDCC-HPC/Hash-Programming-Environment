using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 

namespace DGAC.database
{

    [Serializable()]
    public class PermutationDAO
    {

        public void insert(Permutation ac)
        {

            String sql =
                "INSERT INTO permutation (id_abstract, id_inner, id_interface_slice, id_split_replica, id_enumerator, id_abstract_enumerator, id_interface)" +
                " VALUES (" + ac.Id_abstract + ",'" 
                            + ac.Id_inner + "','"
                            + ac.Id_interface_slice + "'," 
                            + ac.Id_split_replica + ",'"
                            + ac.Id_enumerator + "'," 
                            + ac.Id_abstract_enumerator + ",'" 
                            + ac.Id_interface + "')";

            Connector.performSQLUpdate(sql);

        }

        // ADDED BY HERON
        public Permutation retrieve(int id_abstract, string id_inner, string id_interface_slice, int id_split_replica, string id_enumerator)
        {
            Permutation s = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, id_split_replica, id_enumerator, id_abstract_enumerator, id_interface " +
                "FROM permutation " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "' AND " + 
                "id_interface_slice like '" + id_interface_slice + "' AND " + 
                "id_split_replica = " + id_split_replica + " AND " +
                "id_enumerator like '" + id_interface_slice + "'"; 
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                s = new Permutation();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_split_replica = (int)reader["id_split_replica"];
                s.Id_abstract_enumerator = (int)reader["id_abstract_enumerator"];
                s.Id_interface = (string)reader["id_interface"];
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


        
        
        
    }//class

}//namespace
