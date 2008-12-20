using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections;
using System.Collections.Generic; 


namespace DGAC.database{

[Serializable()]
public class SupplyParameterParameterDAO{

    public void insert(SupplyParameterParameter ac)
    {
        String sql =
            "INSERT INTO hashmodel.supplyparameterparameter (id_parameter, id_functor_app, id_parameter_actual, freeVariable)" +
            " VALUES ('" + ac.Id_parameter + "'," + ac.Id_functor_app + ",'" + ac.Id_parameter_actual + "'," + ac.FreeVariable + ")";

        Connector.performSQLUpdate(sql);
    }

	public SupplyParameterParameter retrieve(string id_parameter, int id_functor_app){
	
	   SupplyParameterParameter spc = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_parameter, id_functor_app, id_parameter_actual, freevariable " +
           "FROM supplyparameterparameter " +
           "WHERE id_parameter like '" + id_parameter + "' AND id_functor_app="+id_functor_app;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		spc = new SupplyParameterParameter();
       	    spc.Id_parameter = (string)reader["id_parameter"];
       	    spc.Id_functor_app = (int)reader["id_functor_app"];
       	    spc.Id_parameter_actual = (string)reader["id_parameter_actual"];
            spc.FreeVariable = ((int)reader["freeVariable"])==0 ? false : true;
             
             
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return spc;
       
	}//list


    public void remove(SupplyParameterParameter spp)
    {
        String sql =
            "DELETE FROM hashmodel.supplyparameterparameter" +
            " WHERE id_functor_app like '" + spp.Id_functor_app + "' AND id_parameter like '" + spp.Id_parameter + "'" ;

        Connector.performSQLUpdate(sql);
    }


    internal IList<SupplyParameterParameter> listFreeVariables(AbstractComponentFunctor absC)
    {
        IList<SupplyParameterParameter> spp_List = new List<SupplyParameterParameter>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT ss.id_abstract, s.id_parameter, s.id_functor_app, s.id_parameter_actual, s.freevariable " +
            "FROM supplyparameterparameter s, supplyparameter ss, innercomponent i " +
            "WHERE  s.id_functor_app = i.id_functor_app AND " +
                    "s.id_functor_app = ss.id_functor_app AND " + 
                    "s.id_parameter = ss.id_parameter AND " +
                    "i.id_abstract_owner = " + absC.Id_abstract + " AND " +
                    "s.freeVariable = 1";
                    
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            SupplyParameterParameter spc = new SupplyParameterParameter();
            spc.Id_abstract = (int)reader["id_abstract"];
            spc.Id_parameter = (string)reader["id_parameter"];
            spc.Id_functor_app = (int)reader["id_functor_app"];
            spc.Id_parameter_actual = (string)reader["id_parameter_actual"];
            spc.FreeVariable = ((int)reader["freeVariable"]) == 0 ? false : true;
            spp_List.Add(spc);

        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return spp_List;
    }
}//class

}//namespace