using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic;
using System.Diagnostics; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class UnitDAO{

    
    public void insert(Unit ac)
    {
        String sql =
            "INSERT INTO unit (id_unit, id_abstract, id_interface, id_concrete, assembly_string, id_unit_super, class_name, class_nargs, uri_source, `order`)" +
            " VALUES ('" + ac.Id_unit  + "',"+ ac.Id_abstract + ",'" + ac.Id_interface + "'," + ac.Id_concrete + ",'" + ac.Assembly_string +"','"+ ac.Id_unit_super + "','" + ac.Class_name + "',"+ac.Class_nargs+ ",'" + ac.URI_Source +"'," + ac.Order + ")";

   		Trace.WriteLine("Unit.cs: TRY INSERT 1: " + sql);

        Connector.performSQLUpdate(sql);
    }

	public IList<Unit> list(int id_concrete){
	
	   IList<Unit> list = new List<Unit>();
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_unit, id_concrete, id_interface,id_abstract, assembly_string, `order`, id_unit_super, class_name, class_nargs, uri_source " +
           "FROM unit "+
           "WHERE id_concrete="+id_concrete + " " +
           "ORDER BY id_unit";
//		string sql =
//           "SELECT id_unit, id_concrete, id_abstract, id_interface, assembly_string, id_unit_super, unit_replica, class_name " +
//           "FROM unit "+
//           "WHERE id_concrete="+id_concrete;
       dbcmd.CommandText = sql;
			Trace.WriteLine (sql);
			      IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       	   Unit u = new Unit();
       	   u.Id_unit = (string)reader["id_unit"];
       	   u.Id_concrete = (int)reader["id_concrete"];
       	   u.Id_interface = (string)reader["id_interface"];
           u.Id_abstract = (int)reader["id_abstract"];
           u.Assembly_string = (string)reader["assembly_string"];
           u.Id_unit_super = (string)reader["id_unit_super"];
           u.Class_name = (string)reader["class_name"];
           u.Class_nargs = (int)reader["class_nargs"];
           u.URI_Source = (string)reader["uri_source"];
           u.Order = (int)reader["order"];
           list.Add(u);
       }//while
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       return list;
       
	}//list

    // ADDED BY HERON
    public Unit retrieve(int id_concrete, string id_unit)
    {
        Unit u = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_unit, id_concrete, id_interface, id_abstract, `order`, assembly_string, id_unit_super, class_name, class_nargs, uri_source " +
            "FROM unit " +
            "WHERE id_concrete=" + id_concrete + " AND " + 
            "id_unit like '" + id_unit + "'" ;
			
        dbcmd.CommandText = sql;
			Trace.WriteLine (sql);
			      IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            u = new Unit();
            u.Id_unit = (string)reader["id_unit"];
            u.Id_concrete = (int)reader["id_concrete"];
            u.Id_interface = (string)reader["id_interface"];
            u.Id_abstract = (int)reader["id_abstract"];
            u.Assembly_string = (string)reader["assembly_string"];
            u.Id_unit_super = (string)reader["id_unit_super"];
            u.Class_name = (string)reader["class_name"];
            u.Class_nargs = (int)reader["class_nargs"];
            u.URI_Source = (string)reader["uri_source"];
            u.Order = (int)reader["order"];
        }
        else
        {
            // UNIT NOT FOUND
        }

        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return u;

    }//list

    // ADDED BY HERON
    public IList<Unit> retrieveEnumeration(int id_concrete, string id_unit)
    {
        Unit u = null;
        IList<Unit> l = new List<Unit>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_unit, id_concrete, id_interface, id_abstract, `order`, assembly_string, id_unit_super, class_name, class_nargs, uri_source " +
            "FROM unit " +
            "WHERE id_concrete=" + id_concrete + " AND " +
            "id_unit like '" + id_unit +"'";
        dbcmd.CommandText = sql;
			Trace.WriteLine (sql);
			      IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            u = new Unit();
            u.Id_unit = (string)reader["id_unit"];
            u.Id_concrete = (int)reader["id_concrete"];
            u.Id_interface = (string)reader["id_interface"];
            u.Id_abstract = (int)reader["id_abstract"];
            u.Assembly_string = (string)reader["assembly_string"];
            u.Id_unit_super = (string)reader["id_unit_super"];
             u.Class_nargs = (int)reader["class_nargs"];
            u.Class_name = (string)reader["class_name"];
            u.URI_Source = (string)reader["uri_source"];
            u.Order = (int)reader["order"];
            l.Add(u);
        }

        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;

        return l;

    }//list


    internal void setPublicKey(string cuid, string id_unit, string publicKey)
    {
		IList<Component> cs = br.ufc.pargo.hpe.backend.DGAC.BackEnd.cdao.listByUID(cuid);
			
		foreach (Component c in cs)
		{			
	        IList<Unit> us = this.retrieveEnumeration(c.Id_concrete, id_unit);
	        
	        foreach (Unit u in us) {
	            String s = ", PublicKey=";
	
	            if (u.Assembly_string.IndexOf(s) < 0)
	            {
	                u.Assembly_string += ", PublicKey=" + publicKey;
	            }
	            else
	            {
	                int index = u.Assembly_string.IndexOf(s);
	                u.Assembly_string = u.Assembly_string.Substring(0, index) + s + publicKey;
	            }
	
	            this.updatePublicKey(u);
	        }
		}
    }

    private void updatePublicKey(Unit u)
    {
        String sql = "UPDATE unit SET assembly_string = '" + u.Assembly_string + "'" +
                     " WHERE id_concrete=" + u.Id_concrete + " AND " +
                     " id_unit like '" + u.Id_unit + "'";

        Connector.performSQLUpdate(sql);
    }

    internal Unit retrieve(int Id_concrete, int order)
    {
        Unit u = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_unit, id_concrete, id_interface, id_abstract, assembly_string, id_unit_super, `order`, class_name, class_nargs, uri_source" +
            "FROM unit " +
            "WHERE id_concrete=" + Id_concrete + " AND " +
            "`order` = " + order ;
			
        dbcmd.CommandText = sql;
			Trace.WriteLine (sql);
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            u = new Unit();
            u.Id_unit = (string)reader["id_unit"];
            u.Id_concrete = (int)reader["id_concrete"];
            u.Id_interface = (string)reader["id_interface"];
            u.Id_abstract = (int)reader["id_abstract"];
            u.Assembly_string = (string)reader["assembly_string"];
            u.Id_unit_super = (string)reader["id_unit_super"];
            u.Class_name = (string)reader["class_name"];
            u.Class_nargs = (int)reader["class_nargs"];
            u.URI_Source = (string)reader["uri_source"];
            u.Order = (int)reader["order"];
        }
        else
        {
            // UNIT NOT FOUND
        }

        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return u;
    }
}//class

}//namespace
