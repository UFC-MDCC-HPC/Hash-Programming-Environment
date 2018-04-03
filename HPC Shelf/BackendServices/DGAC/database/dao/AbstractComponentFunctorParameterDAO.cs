using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics;
using br.ufc.pargo.hpe.backend.DGAC.utils;

namespace br.ufc.pargo.hpe.backend.DGAC.database
{

    [Serializable()]
    public class AbstractComponentFunctorParameterDAO
    {

        public void insert(AbstractComponentFunctorParameter ac)
        {
            String sql =
                "INSERT INTO abstractcomponentfunctorparameter (id_parameter, id_abstract, bounds_of, variance)" +
                " VALUES ('" + ac.Id_parameter + "'," + ac.Id_abstract + "," + ac.Bounds_of + ",'" + ac.Variance + "')";

     		Console.WriteLine("AbstractComponentFunctorParameter.cs: TRY INSERT: " + sql);

            Connector.performSQLUpdate(sql);

        }


        IDictionary<int, IList<AbstractComponentFunctorParameter>> cache_c_pars = new Dictionary<int, IList<AbstractComponentFunctorParameter>>();

	public IList<AbstractComponentFunctorParameter> list(int id_abstract)
    {
        IList<AbstractComponentFunctorParameter> list = null;
        
        if (cache_c_pars.TryGetValue(id_abstract, out list)) return list;

        list = new List<AbstractComponentFunctorParameter>();

        cache_c_pars.Add(id_abstract, list);

	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_abstract, id_parameter, bounds_of, variance " +
           "FROM abstractcomponentfunctorparameter " +
           "WHERE id_abstract="+id_abstract;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		AbstractComponentFunctorParameter acfp = new AbstractComponentFunctorParameter();
			acfp.Bounds_of = (int)reader["bounds_of"];
			acfp.Id_abstract = (int)reader["id_abstract"];
			acfp.Id_parameter = (string)reader["id_parameter"] ;
			acfp.Variance =  Constants.varianceValueInv[(string)reader["variance"]];
            list.Add(acfp);
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return list;
       
	}//lis

    IDictionary<int, AbstractComponentFunctorParameter> cache_c_pars_2 = new Dictionary<int, AbstractComponentFunctorParameter>();

    private int makeKey(int id_abstract, string id_parameter)
    {
        return (id_abstract.GetHashCode() + id_parameter.GetHashCode());
    }

    internal AbstractComponentFunctorParameter retrieve(int id_abstract, string id_parameter)
    {
        AbstractComponentFunctorParameter acfp = null;

        int key = makeKey(id_abstract, id_parameter);
        if (cache_c_pars_2.TryGetValue(key, out acfp))
        {
                return acfp;
        }
        
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_abstract, id_parameter, bounds_of, variance " +
            "FROM abstractcomponentfunctorparameter " +
            "WHERE id_abstract=" + id_abstract + " AND id_parameter like '" + id_parameter + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            acfp = new AbstractComponentFunctorParameter();
            acfp.Bounds_of = (int)reader["bounds_of"];
            acfp.Id_abstract = (int)reader["id_abstract"];
            acfp.Id_parameter = (string)reader["id_parameter"];
			acfp.Variance =  Constants.varianceValueInv[(string)reader["variance"]];
            cache_c_pars_2.Add(key, acfp);
        }//if

        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
			
	   if (acfp==null) 
	   {
	  	  Console.WriteLine("AbstractComponentFunctorParameterDAO.cs: PARAMETER NOT FOUND "+ id_abstract + "," + id_parameter);
	   }
			
        return acfp;
    }
}//class

}//namespace