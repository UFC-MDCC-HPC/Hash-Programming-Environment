using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections; 


namespace DGAC.database{

[Serializable()]
public class ComponentDAO{

        


    /* HERON */
    public int insert(Component ac)
    {
        int nextKey = Connector.nextKey("id_concrete","hashmodel.component");

        String sql =
            "INSERT INTO hashmodel.component (id_concrete, id_concrete_supertype, id_functor_app, library_path, hash_component_UID)" +
            " VALUES (" + nextKey + "," + ac.Id_concrete_supertype + "," + ac.Id_functor_app + ",'"+ ac.Library_path + "','"+ ac.Hash_component_UID +  "')";

        Connector.performSQLUpdate(sql);

        return nextKey;
    }
    




	public Component retrieveByFunctorApp(int id_functor_app){
	   
	   Component c = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
      string sql =
           "SELECT id_concrete, id_concrete_supertype, library_path, id_functor_app, hash_component_UID " +
           "FROM component " +
           "WHERE id_functor_app="+id_functor_app +" AND hash_component_uid not like '%delete%'";
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		c = new Component();
       		c.Id_concrete = (int)reader["id_concrete"];
       		c.Id_concrete_supertype = (int)reader["id_concrete_supertype"];
       		c.Library_path = (string)reader["library_path"];
       		c.Id_functor_app = (int)reader["id_functor_app"];
            c.Hash_component_UID = (string)reader["hash_component_UID"];
        }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return c;
	}

    public Component retrieve_uid(string hash_component_uid)
    {

        Component c = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT id_concrete, id_concrete_supertype, library_path, id_functor_app, hash_component_UID " +
             "FROM component " +
             "WHERE hash_component_UID like '" + hash_component_uid + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            c = new Component();
            c.Id_concrete = (int)reader["id_concrete"];
            c.Id_concrete_supertype = (int)reader["id_concrete_supertype"];
            c.Library_path = (string)reader["library_path"];
            c.Id_functor_app = (int)reader["id_functor_app"];
            c.Hash_component_UID = (string) reader["hash_component_UID"];
        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return c;
    }

    public Component retrieve_libraryPath(string library_path)
    {

        Component c = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT id_concrete, id_concrete_supertype, library_path, id_functor_app, hash_component_UID " +
             "FROM component " +
             "WHERE library_path like '" + library_path + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            c = new Component();
            c.Id_concrete = (int)reader["id_concrete"];
            c.Id_concrete_supertype = (int)reader["id_concrete_supertype"];
            c.Library_path = (string)reader["library_path"];
            c.Id_functor_app = (int)reader["id_functor_app"];
            c.Hash_component_UID = (string)reader["hash_component_UID"];
        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return c;
    }
    
    
    public Component retrieve(int id_concrete)
    {
	   
	   Component c = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
      string sql =
           "SELECT id_concrete, id_concrete_supertype, library_path, id_functor_app, hash_component_UID " +
           "FROM component " +
           "WHERE id_concrete="+id_concrete;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		c = new Component();
       		c.Id_concrete = (int)reader["id_concrete"];
       		c.Id_concrete_supertype = (int)reader["id_concrete_supertype"];
       		c.Library_path = (string)reader["library_path"];
       		c.Id_functor_app = (int)reader["id_functor_app"];
       		c.Hash_component_UID = (string)reader["hash_component_UID"];
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return c;
	}


    internal Component retrieveThatImplements(int id_abstract)
    {
        Component c = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT C.*, A.id_abstract " +
             "FROM component C, abstractcomponentfunctorapplication A " +
             "WHERE A.id_abstract=" + id_abstract + " AND " + 
                  " C.id_functor_app = A.id_functor_app";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            c = new Component();
            c.Id_concrete = (int)reader["id_concrete"];
            c.Id_concrete_supertype = (int)reader["id_concrete_supertype"];
            c.Library_path = (string)reader["library_path"];
            c.Id_functor_app = (int)reader["id_functor_app"];
            c.Hash_component_UID = (string)reader["hash_component_UID"];
        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return c;
    }
}//class

}//namespace