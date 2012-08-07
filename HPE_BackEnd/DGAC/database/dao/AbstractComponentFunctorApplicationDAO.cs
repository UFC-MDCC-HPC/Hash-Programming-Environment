using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class AbstractComponentFunctorApplicationDAO{


    public int insert(AbstractComponentFunctorApplication ac)
    {
        int nextKey = ac.Id_functor_app;
        if (nextKey >= 0)
            nextKey = Connector.nextKey("id_functor_app", "abstractcomponentfunctorapplication");

        String sql =
            "INSERT INTO abstractcomponentfunctorapplication (id_functor_app, id_abstract, id_functor_app_next)" +
            "VALUES (" + nextKey + "," + ac.Id_abstract + "," +  ac.Id_functor_app_next + ")";

        Connector.performSQLUpdate(sql);

        if (cache_acfa.ContainsKey(ac.Id_functor_app))
        {
            cache_acfa.Remove(ac.Id_functor_app);
            cache_acfa.Add(ac.Id_functor_app, ac);
        }

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
           "SELECT id_abstract, id_functor_app, id_functor_app_next " +
           "FROM abstractcomponentfunctorapplication " +
           "WHERE id_functor_app="+id_functor_app;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		acfa = new AbstractComponentFunctorApplication();
       		acfa.Id_functor_app = (int)reader["id_functor_app"];
       		acfa.Id_abstract = (int)reader["id_abstract"];
       		acfa.Id_functor_app_next = (int)reader["id_functor_app_next"];
            cache_acfa.Add(acfa.Id_functor_app, acfa);
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
			
	   if (acfa==null) 
	   {
	  	  Console.WriteLine("AbstractComponentFunctorApplicationDAO.cs: ACFA NOT FOUND "+ id_functor_app);
	   }
			
       return acfa;
	}
	
    public AbstractComponentFunctorApplication retrieve_next(int id_functor_app_next)
    {
        AbstractComponentFunctorApplication acfa = null;

	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
      string sql =
           "SELECT id_abstract, id_functor_app, id_functor_app_next " +
           "FROM abstractcomponentfunctorapplication " +
           "WHERE id_functor_app_next="+id_functor_app_next;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		acfa = new AbstractComponentFunctorApplication();
       		acfa.Id_functor_app = (int)reader["id_functor_app"];
       		acfa.Id_abstract = (int)reader["id_abstract"];
       		acfa.Id_functor_app_next = (int)reader["id_functor_app_next"];
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
			
//	   if (acfa==null) 
//	   {
//	  	  Console.WriteLine("AbstractComponentFunctorApplicationDAO.cs: ACFA \"NEXT\" NOT FOUND "+ id_functor_app_next);
//	   }
			
       return acfa;
	}

	public IList<AbstractComponentFunctorApplication> list(){
		  IList<AbstractComponentFunctorApplication> list = new List<AbstractComponentFunctorApplication>();
		  AbstractComponentFunctorApplication acfa = null;
		  IDbConnection dbcon = Connector.DBcon;
	      IDbCommand dbcmd = dbcon.CreateCommand();
	      string sql =
	           "SELECT id_abstract, id_functor_app, id_functor_app_next " +
	           "FROM abstractcomponentfunctorapplication ";
	            
	       dbcmd.CommandText = sql;
	       IDataReader reader = dbcmd.ExecuteReader();
	       while(reader.Read()) {
	       		acfa = new AbstractComponentFunctorApplication();
	       		acfa.Id_functor_app = (int)reader["id_functor_app"];
	       		acfa.Id_abstract = (int)reader["id_abstract"];
       		    acfa.Id_functor_app_next = (int)reader["id_functor_app_next"];
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
	           "SELECT acfa.id_abstract, acfa.id_functor_app, acfa.id_functor_app_next " +
	           "FROM component as c, abstractcomponentfunctorapplication as acfa " + 
			   "WHERE c.id_functor_app = acfa.id_functor_app AND " + 
					 "acfa.id_abstract = " + id_abstract;
	            
	       dbcmd.CommandText = sql;
	       IDataReader reader = dbcmd.ExecuteReader();
	       while(reader.Read()) {
	       		acfa = new AbstractComponentFunctorApplication();
	       		acfa.Id_functor_app = (int)reader["id_functor_app"];
	       		acfa.Id_abstract = (int)reader["id_abstract"];
       		    acfa.Id_functor_app_next = (int)reader["id_functor_app_next"];
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
	 
	public void updateIdFunctorAppNext(AbstractComponentFunctorApplication acfa, int id_functor_app_next) 
	{
        String sql = "UPDATE abstractcomponentfunctorapplication SET id_functor_app_next = " + id_functor_app_next + " " +
                     " WHERE id_functor_app=" + acfa.Id_functor_app + "";

        Connector.performSQLUpdate(sql);
	}

}//class

}//namespace