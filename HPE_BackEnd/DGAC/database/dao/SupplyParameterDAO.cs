using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic;
using System.Diagnostics; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class SupplyParameterDAO{

    public void insert(SupplyParameter ac)
    {
			Console.WriteLine("SupplyParameter.cs: TRY INSERT 1: " + (ac==null));

        String sql1 =
            "INSERT INTO supplyparameter (id_parameter, id_functor_app, id_abstract)" +
            "VALUES ('" + ac.Id_parameter + "'," + ac.Id_functor_app + "," + ac.Id_abstract + ")";

        String sql2 = null;


        if (ac is SupplyParameterComponent)
        {
   			Console.WriteLine("SupplyParameter.cs: TRY INSERT 2: ");
            SupplyParameterComponent acc = (SupplyParameterComponent)ac;
            sql2 =
            "INSERT INTO supplyparametercomponent (id_parameter, id_functor_app, id_functor_app_actual)" +
            " VALUES ('" + acc.Id_parameter + "'," + acc.Id_functor_app + "," + acc.Id_functor_app_actual + ")";
        }
        else if (ac is SupplyParameterParameter)
        {
   			Console.WriteLine("SupplyParameter.cs: TRY INSERT 3: ");
            SupplyParameterParameter acp = (SupplyParameterParameter) ac;
            sql2 =
            "INSERT INTO supplyparameterparameter (id_parameter, id_functor_app, id_parameter_actual, freeVariable)" +
            " VALUES ('" + acp.Id_parameter + "'," + acp.Id_functor_app + ",'" + acp.Id_argument + "'," + (acp.FreeVariable ? 1 : 0) + ")";
        }

   		Console.WriteLine("SupplyParameter.cs: TRY INSERT 4: " + sql1);
   		Console.WriteLine("SupplyParameter.cs: TRY INSERT 5: " + sql2);

        Connector.performSQLUpdate(sql1);
        Connector.performSQLUpdate(sql2);
    }

    IDictionary<int, SupplyParameter> cache_c_pars_2 = new Dictionary<int, SupplyParameter>();

    private int makeKey(int id_functor_app, string id_parameter)
    {
        return (id_functor_app.GetHashCode() + id_parameter.GetHashCode());
    }

	public SupplyParameter retrieve(string id_parameter, int id_functor_app){
	
	   SupplyParameter spc = null;

       int key = makeKey(id_functor_app, id_parameter);

       if (cache_c_pars_2.TryGetValue(key, out spc)) return spc;     

	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       bool achou = false;
       string sql =
           "SELECT id_parameter, id_functor_app, id_functor_app_actual " +
           "FROM supplyparametercomponent " +
           "WHERE id_parameter like '" + id_parameter + "' AND id_functor_app=" + id_functor_app;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       if(reader.Read()) {
           achou = true;
           SupplyParameterComponent spc_ = new SupplyParameterComponent();
       	    spc_.Id_parameter = (string)reader["id_parameter"];
       	    spc_.Id_functor_app = (int)reader["id_functor_app"];
       	    spc_.Id_functor_app_actual = (int)reader["id_functor_app_actual"];
            spc = spc_;
            cache_c_pars_2.Add(key, spc_);
       }


       if (!achou)
       {

           reader.Close();
           dbcmd.Dispose();

           sql =
               "SELECT id_parameter, id_functor_app, id_parameter_actual, freeVariable " +
               "FROM supplyparameterparameter " +
               "WHERE id_parameter like '" + id_parameter + "' AND id_functor_app=" + id_functor_app;
           dbcmd.CommandText = sql;
           reader = dbcmd.ExecuteReader();
           if (reader.Read())
           {
               achou = true;
               SupplyParameterParameter spc_ = new SupplyParameterParameter();
               spc_.Id_parameter = (string)reader["id_parameter"];
               spc_.Id_functor_app = (int)reader["id_functor_app"];
               spc_.Id_argument = (string)reader["id_parameter_actual"];
               spc_.FreeVariable= ((int)reader["freeVariable"])==0 ? false : true;
               spc = spc_;
               cache_c_pars_2.Add(key, spc_);
           }

      }

      reader.Close();
      dbcmd.Dispose();
      
      sql =
          "SELECT id_parameter, id_functor_app, id_abstract " +
          "FROM supplyparameter " +
          "WHERE id_parameter like '" + id_parameter + "' AND id_functor_app=" + id_functor_app;
      dbcmd.CommandText = sql;
      reader = dbcmd.ExecuteReader();
      if (reader.Read())
      {
          spc.Id_abstract = (int)reader["id_abstract"];
      }

       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
			
			
	   if (spc==null) 
	   {
	  	  Console.WriteLine("SupplyParameterDAO.cs: PARAMETER NOT FOUND "+ id_parameter + "," + id_functor_app);
	   }
			
       return spc;
       
	}//list

    IDictionary<int, IList<SupplyParameter>> cache_c_pars = new Dictionary<int, IList<SupplyParameter>>();

    public IList<SupplyParameter> list(int id_functor_app){

		//	Console.WriteLine ("SupplyParameterDAO: list ENTER " + id_functor_app);

		IList<SupplyParameter> list = null;
        list = new List<SupplyParameter>();
 
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       IList<string> parameters = new List<string>();

       string sql =
           "SELECT id_parameter, id_functor_app, id_abstract " +
           "FROM supplyparameter " +
           "WHERE id_functor_app=" + id_functor_app;
       dbcmd.CommandText = sql;
			//Console.WriteLine ("SupplyParameterDAO: SQL = " + sql);

       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
           string id_parameter = (string)reader["id_parameter"];;
		  // Console.WriteLine ("SupplyParameterDAO: reading parameter " + id_parameter);
           parameters.Add(id_parameter);
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;

       foreach (string id_parameter in parameters)
       {
		  // Console.WriteLine ("SupplyParameterDAO: fetching parameter " + id_parameter + " / " + id_functor_app);
           SupplyParameter sp = retrieve(id_parameter, id_functor_app);
           list.Add(sp);
       }

			//Console.WriteLine ("SupplyParameterDAO: list EXIT count=" + list.Count);

       return list;
       
	}//list
	
	public IList<SupplyParameter> list2(int id_functor_app){

			IList<SupplyParameter> list = null;
			if (cache_c_pars.TryGetValue(id_functor_app, out list)) return list;
			list = new List<SupplyParameter>();
			cache_c_pars.Add(id_functor_app, list);

			IDbConnection dbcon = Connector.DBcon;
			IDbCommand dbcmd = dbcon.CreateCommand();
			IList<string> parameters = new List<string>();

			string sql =
				"SELECT sp.id_parameter, sp.id_functor_app, sp.id_abstract " +
					"FROM supplyparameter as sp, abstractcomponentfunctorparameter as acfp " +
					"WHERE sp.id_abstract = acfp.id_abstract AND sp.id_parameter = acfp.id_parameter AND " +
					"sp.id_functor_app=" + id_functor_app;
			dbcmd.CommandText = sql;
			IDataReader reader = dbcmd.ExecuteReader();
			while(reader.Read()) {
				string id_parameter = (string)reader["id_parameter"];;
				parameters.Add(id_parameter);
			}//while
			// clean up
			reader.Close();
			reader = null;
			dbcmd.Dispose();
			dbcmd = null;

			foreach (string id_parameter in parameters)
			{
				SupplyParameter sp = retrieve(id_parameter, id_functor_app);
				list.Add(sp);
			}

			return list;

		}//list


}//class

}//namespace