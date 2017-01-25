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
public class InterfaceParameterDAO{


    public void insert(InterfaceParameter ac)
    {
        String sql =
            "INSERT INTO interfaceparameters (id_interface, id_abstract, varid, parid, id_interface_parameter, id_unit_parameter, par_order)" +
            " VALUES ('" + ac.Id_interface + "'," + ac.Id_abstract + ",'" + ac.VarId + "','" + ac.ParId + "','" + ac.Id_interface_parameter + "','" + ac.Id_unit_parameter + "'," + ac.ParOrder + ")";

   		Console.WriteLine("InterfaceParameter.cs: TRY INSERT: " + sql);


        Connector.performSQLUpdate(sql);
    }

	
    // UPDATED BY HERON (id_abstract is now a key)
	public InterfaceParameter retrieve(int id_abstract, string id_interface, string parid){
	   
	   InterfaceParameter i = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_interface, id_abstract, varid, parid, id_interface_parameter, id_unit_parameter, par_order " +
           "FROM interfaceparameters "+
           "WHERE id_interface like '" + id_interface + "' AND " + 
           "id_abstract=" + id_abstract + " AND " + 
           "parid like '" + parid+ "'";
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       if (reader.Read())
       {
           i = new InterfaceParameter();
           i.Id_interface = (string)reader["id_interface"];
           i.Id_abstract = (int)reader["id_abstract"];
           i.ParId = (string)reader["parid"];
           i.VarId = (string)reader["varid"];
           i.Id_interface_parameter = (string)reader["id_interface_parameter"];
           i.Id_unit_parameter =(string)reader["id_unit_parameter"];
           i.ParOrder = (int)reader["par_order"];
           // i.ExternalReferences = 
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

	public InterfaceParameter retrieveByOrder(int id_abstract, string id_interface, int pos){
	   
	   InterfaceParameter i = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_interface, id_abstract, varid, parid, id_interface_parameter, id_unit_parameter, par_order " +
           "FROM interfaceparameters "+
           "WHERE id_interface like '" + id_interface + "' AND " + 
           "id_abstract=" + id_abstract + " AND " + 
           "par_order = " + pos ;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       if (reader.Read())
       {
           i = new InterfaceParameter();
           i.Id_interface = (string)reader["id_interface"];
           i.Id_abstract = (int)reader["id_abstract"];
           i.ParId = (string)reader["parid"];
           i.VarId = (string)reader["varid"];
           i.Id_interface_parameter = (string)reader["id_interface_parameter"];
           i.Id_unit_parameter =(string)reader["id_unit_parameter"];
           i.ParOrder = (int)reader["par_order"];
           // i.ExternalReferences = 
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
    public IList<InterfaceParameter> list(int id_abstract, string id_interface)
    {
        InterfaceParameter i = null;
        IList<InterfaceParameter> iList = new List<InterfaceParameter>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_interface, id_abstract, varid, parid, id_interface_parameter, id_unit_parameter, par_order " +
           "FROM interfaceparameters "+
           "WHERE id_interface like '" + id_interface + "' AND " + 
           "id_abstract=" + id_abstract + 
		   " ORDER BY par_order";
        dbcmd.CommandText = sql;
		Console.WriteLine (sql);
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
           i = new InterfaceParameter();
           i.Id_interface = (string)reader["id_interface"];
           i.Id_abstract = (int)reader["id_abstract"];
           i.ParId = (string)reader["parid"];
           i.VarId = (string)reader["varid"];
           i.Id_interface_parameter = (string)reader["id_interface_parameter"];
           i.Id_unit_parameter =(string)reader["id_unit_parameter"];
           i.ParOrder = (int)reader["par_order"];
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