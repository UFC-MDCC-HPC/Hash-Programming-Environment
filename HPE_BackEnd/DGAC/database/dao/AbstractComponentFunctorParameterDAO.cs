using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections;
using System.Collections.Generic;

namespace DGAC.database
{

    [Serializable()]
    public class AbstractComponentFunctorParameterDAO
    {

        public void insert(AbstractComponentFunctorParameter ac)
        {
            String sql =
                "INSERT INTO hashmodel.abstractcomponentfunctorparameter (id_parameter, id_abstract, bounds_of)" +
                " VALUES ('" + ac.Id_parameter + "'," + ac.Id_abstract + "," + ac.Bounds_of + ")";

            Connector.performSQLUpdate(sql);
        }
		
	public IList<AbstractComponentFunctorParameter> list(int id_abstract)
    {
	
	   IList<AbstractComponentFunctorParameter> list = new List<AbstractComponentFunctorParameter>();
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_abstract, id_parameter, bounds_of " +
           "FROM hashmodel.abstractcomponentfunctorparameter " +
           "WHERE id_abstract="+id_abstract;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		AbstractComponentFunctorParameter acfp = new AbstractComponentFunctorParameter();
			acfp.Bounds_of = (int)reader["bounds_of"];
			acfp.Id_abstract = (int)reader["id_abstract"];
			acfp.Id_parameter = (string)reader["id_parameter"] ;
       		 
            list.Add(acfp);
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return list;
       
	}//lis


    internal AbstractComponentFunctorParameter retrieve(int id_abstract, string id_parameter)
    {
        AbstractComponentFunctorParameter acfp = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_abstract, id_parameter, bounds_of " +
            "FROM hashmodel.abstractcomponentfunctorparameter " +
            "WHERE id_abstract=" + id_abstract + " AND id_parameter like '" + id_parameter + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            acfp = new AbstractComponentFunctorParameter();
            acfp.Bounds_of = (int)reader["bounds_of"];
            acfp.Id_abstract = (int)reader["id_abstract"];
            acfp.Id_parameter = (string)reader["id_parameter"];
        }//if

        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return acfp;
    }
}//class

}//namespace