using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections; 


namespace br.ufc.hpe.backend.DGAC.database{

[Serializable()]
public class UnitDeploymentDAO{

    public void insert(UnitDeployment ac)
    {
        String sql =
            "INSERT INTO unitdeployment (id_deployment, id_unit, id_node)" +
            "VALUES (" + ac.Id_deployment + "," + ac.Id_unit + "," + ac.Id_node + ")";

        Connector.performSQLUpdate(sql);
    }

	public ArrayList list(){
	
	   ArrayList list = new ArrayList();
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_unit, id_deployment, id_node " +
           "FROM UnitDeployment";
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		UnitDeployment u = new UnitDeployment();
       	    u.Id_deployment = (int)reader["id_deployment"];
       	    u.Id_unit = (int)reader["id_unit"];
       	    u.Id_node = (int)reader["id_node"];
            
            list.Add(u);
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return list;
       
	}//list
	
	public UnitDeployment retrieve(int id){
	   
	   UnitDeployment u = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_unit, id_deployment, id_node " +
           "FROM UnitDeployment " +
           "WHERE id_unit="+id;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		u = new UnitDeployment();
       	    u.Id_deployment = (int)reader["id_deployment"];
       	    u.Id_unit = (int)reader["id_unit"];
       	    u.Id_node = (int)reader["id_node"];
            
           
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return u;
	}

}//class

}//namespace