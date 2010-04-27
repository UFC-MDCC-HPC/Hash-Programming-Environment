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

    IDictionary<int, AbstractComponentFunctorApplication> cache_acfa = new Dictionary<int, AbstractComponentFunctorApplication>();


    public AbstractComponentFunctorApplication retrieve(int id_functor_app)
    {

        AbstractComponentFunctorApplication acfa = null;
        if (cache_acfa.TryGetValue(id_functor_app, out acfa)) return acfa;        

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
            cache_acfa.Add(acfa.Id_functor_app, acfa);
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
                if (!cache_acfa.ContainsKey(acfa.Id_functor_app)) cache_acfa.Add(acfa.Id_functor_app, acfa);
	       }//while
	       // clean up
	       reader.Close();
	       reader = null;
	       dbcmd.Dispose();
	       dbcmd = null;
	       return list;
	}

    IDictionary<int, IList<AbstractComponentFunctorApplication>> cache_acfa_list_byabstract = new Dictionary<int, IList<AbstractComponentFunctorApplication>>();
	
	public IList<AbstractComponentFunctorApplication> listByIdAbstract(int id_abstract){
		  
          IList<AbstractComponentFunctorApplication> list = null;
          if (cache_acfa_list_byabstract.TryGetValue(id_abstract, out list)) return list;
          list = new List<AbstractComponentFunctorApplication>();
          cache_acfa_list_byabstract.Add(id_abstract, list);

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
                if (!cache_acfa.ContainsKey(acfa.Id_functor_app)) cache_acfa.Add(acfa.Id_functor_app, acfa);
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