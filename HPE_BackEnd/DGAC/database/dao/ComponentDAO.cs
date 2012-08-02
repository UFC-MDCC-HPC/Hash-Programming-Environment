using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections;
using System.Collections.Generic; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class ComponentDAO{

        


    /* HERON */
    public int insert(Component ac)
    {
        int nextKey = Connector.nextKey("id_concrete","component");

        String sql =
            "INSERT INTO component (id_concrete, id_concrete_supertype, id_functor_app, library_path, hash_component_UID)" +
            " VALUES (" + nextKey + "," + ac.Id_concrete_supertype + "," + ac.Id_functor_app + ",'"+ ac.Library_path + "','"+ ac.Hash_component_UID +  "')";

        Connector.performSQLUpdate(sql);

        return nextKey;
    }


    IDictionary<int, Component> cache_c_functor_app = new Dictionary<int, Component>();

	public Component retrieveByFunctorApp(int id_functor_app){
	   
	   Component c = null;
       if (cache_c_functor_app.TryGetValue(id_functor_app, out c)) return c;        

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
            cache_c_functor_app.Add(id_functor_app, c);
        }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return c;
	}

    IDictionary<string, Component> cache_c_uid = new Dictionary<string, Component>();

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

    IDictionary<string, Component> cache_c_lp = new Dictionary<string, Component>();

    public Component retrieve_libraryPath(string library_path)
    {

        Component c = null;

        if (cache_c_lp.TryGetValue(library_path, out c)) return c;        
       
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
            if (cache_c_lp.ContainsKey(library_path))
                cache_c_lp.Remove(library_path);
            cache_c_lp.Add(library_path, c);
        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return c;
    }

    IDictionary<int, Component> cache_c_id = new Dictionary<int, Component>();

    public Component retrieve(int id_concrete)
    {
	   
	   Component c = null;

       if (cache_c_id.TryGetValue(id_concrete, out c)) return c;
       
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
            cache_c_id.Add(id_concrete, c);
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return c;
	}

    IDictionary<int, IList<Component>> cache_c_impl = new Dictionary<int, IList<Component>>();

    internal IList<Component> retrieveThatImplements(int id_abstract)
    {
        IList<Component> cList = null;

        if (cache_c_impl.TryGetValue(id_abstract, out cList)) return cList;

        cList = new List<Component>();

        cache_c_impl.Add(id_abstract, cList);

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
            Component c = new Component();
            c.Id_concrete = (int)reader["id_concrete"];
            c.Id_concrete_supertype = (int)reader["id_concrete_supertype"];
            c.Library_path = (string)reader["library_path"];
            c.Id_functor_app = (int)reader["id_functor_app"];
            c.Hash_component_UID = (string)reader["hash_component_UID"];
			cList.Add(c);
        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return cList;
    }

    internal IList<Component> list()
    {
        IList<Component> cList = new List<Component>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT id_concrete, id_concrete_supertype, library_path, id_functor_app, hash_component_UID " +
             "FROM component";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            Component c = new Component();
            c.Id_concrete = (int)reader["id_concrete"];
            c.Id_concrete_supertype = (int)reader["id_concrete_supertype"];
            c.Library_path = (string)reader["library_path"];
            c.Id_functor_app = (int)reader["id_functor_app"];
            c.Hash_component_UID = (string)reader["hash_component_UID"];
            cList.Add(c);
        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return cList;
    }

    public IList<Component> listByUID(string cuid)
    {
        IList<Component> cList = new List<Component>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
             "SELECT id_concrete, id_concrete_supertype, library_path, id_functor_app, hash_component_UID " +
             "FROM component WHERE hash_component_UID = '" + cuid + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            Component c = new Component();
            c.Id_concrete = (int)reader["id_concrete"];
            c.Id_concrete_supertype = (int)reader["id_concrete_supertype"];
            c.Library_path = (string)reader["library_path"];
            c.Id_functor_app = (int)reader["id_functor_app"];
            c.Hash_component_UID = (string)reader["hash_component_UID"];
            cList.Add(c);
        }//while
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return cList;
    }
		

}//class

}//namespace
