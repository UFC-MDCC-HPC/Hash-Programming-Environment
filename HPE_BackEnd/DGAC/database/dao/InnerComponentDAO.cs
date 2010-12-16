using System;
using System.IO;
using System.Data;
using System.Data.OleDb;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class InnerComponentDAO{

    public void insert(InnerComponent ac)
    {
        String sql =
            "INSERT INTO innercomponent (id_abstract_owner, id_functor_app, id_inner, id_abstract_inner, parameter_top, transitive)" +
            " VALUES (" + ac.Id_abstract_owner + "," + ac.Id_functor_app + ",'" + ac.Id_inner + "'," + ac.Id_abstract_inner + ",'"+ ac.Parameter_top + "'," + (ac.Transitive ? -1 : 0) + ")";

        Connector.performSQLUpdate(sql);
    }

    public InnerComponent retrieve(int id_abstract, string id_inner)
    {
        InnerComponent ic = null;

        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_abstract_owner, id_inner, id_functor_app, id_abstract_inner, parameter_top, transitive " +
            "FROM innercomponent " +
            "WHERE id_abstract_owner=" + id_abstract + " AND " +
                  "id_inner like '" + id_inner + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            ic = new InnerComponent();

            ic.Id_abstract_owner = (int)reader["id_abstract_owner"];
            ic.Id_inner = (string)reader["id_inner"];
            ic.Id_functor_app = (int)reader["id_functor_app"];
            ic.Id_abstract_inner = (int)reader["id_abstract_inner"];
            ic.Parameter_top = (string)reader["parameter_top"];
            ic.Transitive = ((int)reader["transitive"])==0 ? false : true;
            
        }//if
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return ic;

    }//retrieve


    public IList<InnerComponent> list(int id_abstract)
    {
	
	   IList<InnerComponent> list = new List<InnerComponent>();
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_abstract_owner, id_inner, id_functor_app, id_abstract_inner, parameter_top, transitive " +
           "FROM innercomponent " +
           "WHERE id_abstract_owner="+id_abstract;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       		InnerComponent ic = new InnerComponent();
       		ic.Id_abstract_owner = (int)reader["id_abstract_owner"];
       		ic.Id_inner = (string)reader["id_inner"];
       		ic.Id_functor_app = (int)reader["id_functor_app"];
       		ic.Id_abstract_inner = (int)reader["id_abstract_inner"];
            ic.Parameter_top = (string)reader["parameter_top"];
            ic.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
            list.Add(ic);
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return list;
       
	}//list
	
	 
	/*public void insert(AbstractComponent ac){
	   
	   
	    
	   IDbConnection dbcon = Connector.getConnection();
	   dbcon.Open();
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "INSERT INTO AbstractComponent (id_abstract_component, id_abstract_supertype, name)" + 
           "VALUES ("+ac.Id_abstract_component+","+ac.Id_abstract_supertype+",'"+ac.Name+"')";
       dbcmd.CommandText = sql;
       
       dbcmd.ExecuteNonQuery();
       
 
       dbcmd.Dispose();
       dbcmd = null;
       dbcon.Close();
       dbcon = null;
       
	}*/


    internal InnerComponent retrieve2(int id_abstract, int id_functor_app)
    {
        InnerComponent ic = null;

        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_abstract_owner, id_inner, id_functor_app, id_abstract_inner, parameter_top, transitive " +
            "FROM innercomponent " +
            "WHERE id_abstract_owner=" + id_abstract + " AND " +
                  "id_functor_app like '" + id_functor_app + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            ic = new InnerComponent();

            ic.Id_abstract_owner = (int)reader["id_abstract_owner"];
            ic.Id_inner = (string)reader["id_inner"];
            ic.Id_functor_app = (int)reader["id_functor_app"];
            ic.Id_abstract_inner = (int)reader["id_abstract_inner"];
            ic.Parameter_top = (string)reader["parameter_top"];
            ic.Transitive = ((int)reader["transitive"]) == 0 ? false : true;

        }//if
        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return ic;
    }
}//class

}//namespace