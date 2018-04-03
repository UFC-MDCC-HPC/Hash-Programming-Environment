using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class InterfaceActionDAO
{


    public void insert(InterfaceAction ac)
    {
        String sql =
            "INSERT INTO interfaceaction (id_interface, " +
            							 "id_abstract, " +
            							 "partition_index, " +
            							 "id_action, " +
            							 "protocol, " +
            							 "is_condition)" +
            " VALUES ('" + ac.Id_interface + "'," 
					     + ac.Id_abstract + "," 
					     + ac.PartitionIndex + ",'" 
					     + ac.Id_action + "','" 
					     + ac.Protocol + "'," 
					     + (ac.IsCondition ? "1" : "0") + ")";

   		Console.WriteLine("InterfaceAction.cs: TRY INSERT: " + sql);

        Connector.performSQLUpdate(sql);
    }

	
    // UPDATED BY HERON (id_abstract is now a key)
	public InterfaceAction retrieve(int id_abstract, string id_interface, string id_action){
	   
	   InterfaceAction i = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_interface, " +
           		  "id_abstract, " +
           		  "partition_index, " +
           		  "id_action, " +
           		  "protocol, " +
           		  "is_condition " +
           "FROM interfaceaction "+
           "WHERE id_interface like '" + id_interface + "' AND " + 
           "id_abstract=" + id_abstract + " AND " + 
           "id_action like '" + id_action+ "'";
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       if (reader.Read())
       {
           i = new InterfaceAction();
           i.Id_interface = (string)reader["id_interface"];
           i.Id_abstract = (int)reader["id_abstract"];
           i.Id_action = (string)reader["id_action"];
           i.Protocol = (string)reader["protocol"];
           i.IsCondition = ((int)reader["is_condition"] == 0 ? false : true);
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
       return i;
	}


	// UPDATED BY HERON (id_abstract is now a key)
    public IList<InterfaceAction> list(int id_abstract, string id_interface)
    {
        InterfaceAction i = null;
        IList<InterfaceAction> iList = new List<InterfaceAction>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_interface, " +
           		  "id_abstract, " +
           		  "partition_index, " +
           		  "id_action, " +
           		  "protocol, " +
           		  "is_condition " +
           "FROM interfaceaction "+
           "WHERE id_interface like '" + id_interface + "' AND " + 
           "id_abstract=" + id_abstract;
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
           i = new InterfaceAction();
           i.Id_interface = (string)reader["id_interface"];
           i.Id_abstract = (int)reader["id_abstract"];
           i.Id_action = (string)reader["id_action"];
           i.Protocol = (string)reader["protocol"];
           i.IsCondition = ((int)reader["is_condition"])==0 ? false : true;
           iList.Add(i);
        }

        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return iList;
    }


}//class

}//namespace