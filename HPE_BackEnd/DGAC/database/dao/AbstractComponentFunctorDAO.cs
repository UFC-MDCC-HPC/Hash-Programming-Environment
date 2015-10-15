using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic;
using System.Diagnostics; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class AbstractComponentFunctorDAO{

    public int insert(AbstractComponentFunctor ac)
    {

        int nextKey = ac.Id_abstract;
        if (nextKey <= 0)
            nextKey = Connector.nextKey("id_abstract", "abstractcomponentfunctor");

        String sql =
            "INSERT INTO abstractcomponentfunctor (id_abstract, id_functor_app_supertype, library_path, hash_component_UID, kind)" +
            " VALUES (" + nextKey + ","
            + ac.Id_functor_app_supertype + "," 
            + (ac.Library_path == null ? "null" : ("'" + ac.Library_path + "'")) + ","
            + (ac.Hash_component_UID == null ? "null" : ("'" + ac.Hash_component_UID + "'")) + ",'" + ac.Kind + "')";

     	Trace.WriteLine("AbstractComponentFunctor.cs: TRY INSERT: " + sql);

        Connector.performSQLUpdate(sql);

        if (cache_acf.ContainsKey(ac.Id_abstract))
        {
            cache_acf.Remove(ac.Id_abstract);
            cache_acf.Add(ac.Id_abstract, ac);
        }

        return nextKey;
    }

    IDictionary<int, AbstractComponentFunctor> cache_acf = new Dictionary<int,AbstractComponentFunctor>();
				
	public AbstractComponentFunctor retrieve(int id_abstract){

        AbstractComponentFunctor acf = null;
        if (cache_acf.TryGetValue(id_abstract, out acf)) return acf;        
        
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
      string sql =
           "SELECT id_abstract, id_functor_app_supertype, library_path, hash_component_UID, kind " +
           "FROM abstractcomponentfunctor " +
           "WHERE id_abstract="+id_abstract;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       if (reader.Read())
       {
           acf = new AbstractComponentFunctor();
           acf.Hash_component_UID = (string)reader["hash_component_UID"]; /* LINE ADDED BY HERON (new field in abstractcomponentfunctor) */
           acf.Id_abstract = (int)reader["id_abstract"];
           acf.Id_functor_app_supertype = (int)reader["id_functor_app_supertype"];
           acf.Library_path = (string)reader["library_path"];
           acf.Kind = (string)reader["kind"];
           cache_acf.Add(acf.Id_abstract, acf);
       }//if
       else
       {
           // Abstract Component Functor NOT FOUND !
       }
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
			
	   if (acf == null)
				Console.Error.WriteLine("AbstractComponentFunctorDAO.cs: abstract component functor not found ! id_abstract=" + id_abstract);
			
       return acf;
	}


    /*ADDED BY HERON */
    public AbstractComponentFunctor retrieveByUID(string hash_component_UID)
    {

        AbstractComponentFunctor acf = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT hash_component_UID, id_abstract, id_functor_app_supertype, library_path, kind " +
             "FROM abstractcomponentfunctor " +
             "WHERE hash_component_UID like '" + hash_component_UID + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
			Console.WriteLine ("RETRIEVE BY UID 3" + hash_component_UID);
        if (reader.Read())
        {
            acf = new AbstractComponentFunctor();
            acf.Hash_component_UID = (string)reader["hash_component_UID"];
            acf.Id_abstract = (int)reader["id_abstract"];
            acf.Id_functor_app_supertype = (int)reader["id_functor_app_supertype"];
            acf.Library_path = (string)reader["library_path"];
            acf.Kind = (string)reader["kind"];
            if (!cache_acf.ContainsKey(acf.Id_abstract)) cache_acf.Add(acf.Id_abstract, acf);
        }
        else
        {
            // NOT FOUND !
        }
			Console.WriteLine ("RETRIEVE BY UID 4" + hash_component_UID);
        if (reader.Read())
        {
            throw new Exception("More than one line FOUND for field hash_component_UID (AbastractComponentFunctorDAO)");
        }

        
        //while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return acf;
    }


    internal IList<string> getIdUnitsOrdered(int id_abstract)
    {
        List<string> list = new List<string>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT DISTINCT id_interface " +
            "FROM interface " +
            "WHERE id_abstract=" + id_abstract + " "+ 
            "ORDER BY `order`";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            list.Add((string)reader["id_interface"]);
        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return list;
     
    }

	internal AbstractComponentFunctor retrieve_libraryPath(string package, string name)
	{
		return retrieve_libraryPath (package + "." + name);
	}

    internal AbstractComponentFunctor retrieve_libraryPath(string library_path)
    {
        AbstractComponentFunctor acf = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT hash_component_UID, id_abstract, id_functor_app_supertype, library_path, kind " +
             "FROM abstractcomponentfunctor " +
             "WHERE library_path like '" + library_path + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            acf = new AbstractComponentFunctor();
            acf.Hash_component_UID = (string)reader["hash_component_UID"];
            acf.Id_abstract = (int)reader["id_abstract"];
            acf.Id_functor_app_supertype = (int)reader["id_functor_app_supertype"];
            acf.Library_path = (string)reader["library_path"];
            acf.Kind = (string)reader["kind"];
            if (!cache_acf.ContainsKey(acf.Id_abstract)) cache_acf.Add(acf.Id_abstract, acf);
        }


        //while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return acf;
    }

    internal IList<AbstractComponentFunctor> list()
    {
        IList<AbstractComponentFunctor> acfaList = new List<AbstractComponentFunctor>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT id_abstract, id_functor_app_supertype, library_path, hash_component_UID, kind " +
             "FROM abstractcomponentfunctor";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            AbstractComponentFunctor acf = new AbstractComponentFunctor();
            acf.Hash_component_UID = (string)reader["hash_component_UID"]; /* LINE ADDED BY HERON (new field in abstractcomponentfunctor) */
            acf.Id_abstract = (int)reader["id_abstract"];
            acf.Id_functor_app_supertype = (int)reader["id_functor_app_supertype"];
            acf.Library_path = (string)reader["library_path"];
            acf.Kind = (string)reader["kind"];
            acfaList.Add(acf);
            if (!cache_acf.ContainsKey(acf.Id_abstract)) cache_acf.Add(acf.Id_abstract, acf);
        }//if

        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return acfaList;
    }
}//class

}//namespace