using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class SupplyParameterComponentDAO{


    public void insert(SupplyParameterComponent acc)
    {
        string sql =
        "INSERT INTO supplyparametercomponent (id_parameter, id_functor_app, id_functor_app_actual)" +
        " VALUES ('" + acc.Id_parameter + "'," + acc.Id_functor_app + "," + acc.Id_functor_app_actual + ")";

        Connector.performSQLUpdate(sql);
    }

    public SupplyParameterComponent retrieve(string id_parameter, int id_functor_app)
    
{
	
	   SupplyParameterComponent spc = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_parameter, id_functor_app, id_functor_app_actual " +
           "FROM supplyparametercomponent " +
           "WHERE id_parameter like '" + id_parameter + "' AND id_functor_app="+id_functor_app;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		spc = new SupplyParameterComponent();
       	    spc.Id_parameter = (string)reader["id_parameter"];
       	    spc.Id_functor_app = (int)reader["id_functor_app"];
       	    spc.Id_functor_app_actual = (int)reader["id_functor_app_actual"];
             
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       
	   if (spc==null) 
	   {
	  	  Console.WriteLine("SupplyParameterComponentDAO.cs: Parameter NOT FOUND " + id_parameter + "," + id_functor_app);
	   }
			
       return spc;
	}//list

    private IDictionary<int, IList<SupplyParameterComponent>> cache_c_pars = new Dictionary<int, IList<SupplyParameterComponent>>();

    public IList<SupplyParameterComponent> list(int id_functor_app)
    {
        IList<SupplyParameterComponent> list = null;
        if (cache_c_pars.TryGetValue(id_functor_app, out list)) return list;
        list = new List<SupplyParameterComponent>();
        cache_c_pars.Add(id_functor_app, list);

        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_parameter, id_functor_app, id_functor_app_actual " +
            "FROM supplyparametercomponent " +
            "WHERE id_functor_app=" + id_functor_app;
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            SupplyParameterComponent sp = new SupplyParameterComponent();
            sp.Id_parameter = (string)reader["id_parameter"];
            sp.Id_functor_app = (int)reader["id_functor_app"];
            sp.Id_functor_app_actual = (int)reader["id_functor_app_actual"];
            list.Add(sp);
        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return list;

    }//list

}//class

}//namespace