using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 


namespace DGAC.database{

[Serializable()]
public class AbstractComponentFunctorDAO{

    public int insert(AbstractComponentFunctor ac)
    {

        int nextKey = ac.Id_abstract;
        if (nextKey >= 0)
            nextKey = Connector.nextKey("id_abstract", "hashmodel.abstractcomponentfunctor");

        String sql =
            "INSERT INTO hashmodel.abstractcomponentfunctor (id_abstract, id_functor_app_supertype, library_path, hash_component_UID, kind)" +
            " VALUES (" + nextKey + ","
            + ac.Id_functor_app_supertype + "," 
            + (ac.Library_path == null ? "null" : ("'" + ac.Library_path + "'")) + "," 
            + (ac.Hash_component_UID == null ? "null" : ("'" + ac.Hash_component_UID + "'")) + ",'" + ac.Kind + "')";

        Connector.performSQLUpdate(sql);

        return nextKey;
    }

	public AbstractComponentFunctor retrieve(int id_abstract){
	   
	   AbstractComponentFunctor acfa = null;
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
           acfa = new AbstractComponentFunctor();
           acfa.Hash_component_UID = (string)reader["hash_component_UID"]; /* LINE ADDED BY HERON (new field in abstractcomponentfunctor) */
           acfa.Id_abstract = (int)reader["id_abstract"];
           acfa.Id_functor_app_supertype = (int)reader["id_functor_app_supertype"];
           acfa.Library_path = (string)reader["library_path"];
           acfa.Kind = (string)reader["kind"];
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
       return acfa;
	}


    /*ADDED BY HERON */
    public AbstractComponentFunctor retrieveByUID(string hash_component_UID)
    {

        AbstractComponentFunctor acfa = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT hash_component_UID, id_abstract, id_functor_app_supertype, library_path, kind " +
             "FROM abstractcomponentfunctor " +
             "WHERE hash_component_UID like '" + hash_component_UID + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            acfa = new AbstractComponentFunctor();
            acfa.Hash_component_UID = (string)reader["hash_component_UID"];
            acfa.Id_abstract = (int)reader["id_abstract"];
            acfa.Id_functor_app_supertype = (int)reader["id_functor_app_supertype"];
            acfa.Library_path = (string)reader["library_path"];
            acfa.Kind = (string)reader["kind"];
        }
        else
        {
            // NOT FOUND !
        }
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
        return acfa;
    }


    internal IList<string> getIdUnitsOrdered(int id_abstract)
    {
        List<string> list = new List<string>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT DISTINCT id_interface " +
            "FROM hashmodel.interface " +
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

    internal AbstractComponentFunctor retrieve_libraryPath(string library_path)
    {
        AbstractComponentFunctor acfa = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT hash_component_UID, id_abstract, id_functor_app_supertype, library_path, kind " +
             "FROM abstractcomponentfunctor " +
             "WHERE library_path like '" + library_path + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            acfa = new AbstractComponentFunctor();
            acfa.Hash_component_UID = (string)reader["hash_component_UID"];
            acfa.Id_abstract = (int)reader["id_abstract"];
            acfa.Id_functor_app_supertype = (int)reader["id_functor_app_supertype"];
            acfa.Library_path = (string)reader["library_path"];
            acfa.Kind = (string)reader["kind"];
        }
        else
        {
            // NOT FOUND !
        }
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
        return acfa;
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
            AbstractComponentFunctor acfa = new AbstractComponentFunctor();
            acfa.Hash_component_UID = (string)reader["hash_component_UID"]; /* LINE ADDED BY HERON (new field in abstractcomponentfunctor) */
            acfa.Id_abstract = (int)reader["id_abstract"];
            acfa.Id_functor_app_supertype = (int)reader["id_functor_app_supertype"];
            acfa.Library_path = (string)reader["library_path"];
            acfa.Kind = (string)reader["kind"];
            acfaList.Add(acfa);
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