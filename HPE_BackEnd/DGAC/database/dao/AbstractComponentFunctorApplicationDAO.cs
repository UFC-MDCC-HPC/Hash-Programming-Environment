using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 


namespace DGAC.database{

[Serializable()]
public class AbstractComponentFunctorApplicationDAO{


    public int insert(AbstractComponentFunctorApplication ac)
    {
        int nextKey = ac.Id_functor_app;
        if (nextKey >= 0)
            nextKey = Connector.nextKey("id_functor_app", "hashmodel.abstractcomponentfunctorapplication");

        String sql =
            "INSERT INTO hashmodel.abstractcomponentfunctorapplication (id_functor_app, id_abstract)" +
            "VALUES (" + nextKey + "," + ac.Id_abstract + ")";

        Connector.performSQLUpdate(sql);

        return nextKey;
    }


    public AbstractComponentFunctorApplication retrieve(int id_functor_app)
    {
	   
	   AbstractComponentFunctorApplication acfa = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
      string sql =
           "SELECT id_abstract, id_functor_app " +
           "FROM abstractcomponentfunctorapplication " +
           "WHERE id_functor_app="+id_functor_app;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		acfa = new AbstractComponentFunctorApplication();
       		acfa.Id_functor_app = (int)reader["id_functor_app"];
       		acfa.Id_abstract = (int)reader["id_abstract"];
       		
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return acfa;
	}
	
	public IList<AbstractComponentFunctorApplication> list(){
		  IList<AbstractComponentFunctorApplication> list = new List<AbstractComponentFunctorApplication>();
		  AbstractComponentFunctorApplication acfa = null;
		  IDbConnection dbcon = Connector.DBcon;
	      IDbCommand dbcmd = dbcon.CreateCommand();
	      string sql =
	           "SELECT id_abstract, id_functor_app " +
	           "FROM abstractcomponentfunctorapplication ";
	            
	       dbcmd.CommandText = sql;
	       IDataReader reader = dbcmd.ExecuteReader();
	       while(reader.Read()) {
	       		acfa = new AbstractComponentFunctorApplication();
	       		acfa.Id_functor_app = (int)reader["id_functor_app"];
	       		acfa.Id_abstract = (int)reader["id_abstract"];
	       		list.Add(acfa);
	       }//while
	       // clean up
	       reader.Close();
	       reader = null;
	       dbcmd.Dispose();
	       dbcmd = null;
	       return list;
	}
	
	public IList<AbstractComponentFunctorApplication> listByIdAbstract(int id_abstract){
		  IList<AbstractComponentFunctorApplication> list = new List<AbstractComponentFunctorApplication>();
		  AbstractComponentFunctorApplication acfa = null;
		  IDbConnection dbcon = Connector.DBcon;
	      IDbCommand dbcmd = dbcon.CreateCommand();
	      string sql =
	           "SELECT acfa.id_abstract, acfa.id_functor_app " +
	           "FROM component as c, abstractcomponentfunctorapplication as acfa " + 
			   "WHERE c.id_functor_app = acfa.id_functor_app AND " + 
					 "acfa.id_abstract = " + id_abstract;
	            
	       dbcmd.CommandText = sql;
	       IDataReader reader = dbcmd.ExecuteReader();
	       while(reader.Read()) {
	       		acfa = new AbstractComponentFunctorApplication();
	       		acfa.Id_functor_app = (int)reader["id_functor_app"];
	       		acfa.Id_abstract = (int)reader["id_abstract"];
	       		list.Add(acfa);
	       }//while
	       // clean up
	       reader.Close();
	       reader = null;
	       dbcmd.Dispose();
	       dbcmd = null;
	       return list;
	}
	 

}//class

}//namespace