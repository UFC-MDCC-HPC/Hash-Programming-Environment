using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections;
using System.Collections.Generic; 


namespace DGAC.database{

[Serializable()]
public class InterfaceDAO{


    public void insert(Interface ac)
    {
        String sql =
            "INSERT INTO hashmodel.interface (id_interface, id_abstract, assembly_string, id_interface_super, class_name, class_nargs, uri_source, `order`)" +
            " VALUES ('" + ac.Id_interface + "'," + ac.Id_abstract + ",'" + ac.Assembly_string + "','" + ac.Id_interface_super + "','" + ac.Class_name + "'," + ac.Class_nargs + ",'" + ac.URI_Source + "'," + ac.Order + ")";

        Connector.performSQLUpdate(sql);
    }

	
    // UPDATED BY HERON (id_abstract is now a key)
	public Interface retrieve(int id_abstract, string id_interface){
	   
	   Interface i = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_interface, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order` " +
           "FROM interface "+
           "WHERE id_interface like '" + id_interface + "' AND " + 
           "id_abstract=" + id_abstract;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       if (reader.Read())
       {
           i = new Interface();
           i.Id_interface = (string)reader["id_interface"];
           i.Id_abstract = (int)reader["id_abstract"];
           i.Assembly_string = (string)reader["assembly_string"];
           i.Id_interface_super = (string)reader["id_interface_super"];
           if (reader["id_interface_super_top"].ToString().Equals(""))
           {
               i.Id_interface_super_top = null;
           }
           else
           {
               i.Id_interface_super_top = (string)reader["id_interface_super_top"];
           }
           i.Class_name = (string)reader["class_name"];
           i.Class_nargs = (int)reader["class_nargs"];
           i.URI_Source = (string)reader["uri_source"];
           i.Order = (int)reader["order"];
           // i.ExternalReferences = 
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
       return i;
	}

    // UPDATED BY HERON (id_abstract is now a key)
    public IList<Interface> list(int id_abstract)
    {

        IList<Interface> iList = new List<Interface>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_interface, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order` " +
            "FROM interface " +
            "WHERE id_abstract=" + id_abstract + " ORDER BY `order`";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            Interface i = new Interface();
            i.Id_interface = (string)reader["id_interface"];
            i.Id_abstract = (int)reader["id_abstract"];
            i.Assembly_string = (string)reader["assembly_string"];
            if (reader["id_interface_super_top"].ToString().Equals(""))
            {
                i.Id_interface_super_top = null;
            } else {
                i.Id_interface_super_top = (string)reader["id_interface_super_top"];
            }

            i.Id_interface_super = (string)reader["id_interface_super"];
            
            i.Class_name = (string)reader["class_name"];
            i.Class_nargs = (int)reader["class_nargs"];
            i.URI_Source = (string)reader["uri_source"];
            i.Order = (int)reader["order"];
            iList.Add(i);
        }

        // clean up
        reader.Close();
        reader = null;
        dbcmd.Dispose();
        dbcmd = null;
        return iList;
    }


    internal void setInterfaceSuperTop(int id_abstract, string id_interface, string id_interface_super_top)
    {
        String sql =
            "UPDATE hashmodel.interface SET id_interface_super_top = '" + id_interface_super_top + "'" +
            " WHERE id_abstract=" + id_abstract + " AND id_interface like '" + id_interface + "'";

        Connector.performSQLUpdate(sql);
    }

    internal Interface retrieveByMatching(int id_abstract_1, int id_abstract_2, string id_interface)
    {
        Interface i = retrieve(id_abstract_2,id_interface);
        string id_interface_super_top_2 = i.Id_interface_super_top;

        IList<Interface> iList = list(id_abstract_1);
        foreach (Interface iSuperCandidate in iList)
        {
            string id_interface_super_top_1 = iSuperCandidate.Id_interface_super_top;
            if (id_interface_super_top_1.Equals(id_interface_super_top_2))
            {
                return iSuperCandidate;
            }
        }
        
        return null;
    }

    internal void setPublicKey(int id_abstract, string id_interface, string publicKey)
    {
        Interface i = this.retrieve(id_abstract,id_interface);

        String s = ", PublicKey=";

        if (i.Assembly_string.IndexOf(s) < 0)
        {
            i.Assembly_string += ", PublicKey=" + publicKey;
        }
        else
        {
            int index =  i.Assembly_string.IndexOf(s);
            i.Assembly_string = i.Assembly_string.Substring(0, index) + s + publicKey;
        }

        

        this.updatePublicKey(i);

    }

    private void updatePublicKey(Interface i)
    {
        String sql = "UPDATE hashmodel.interface SET assembly_string = '" + i.Assembly_string + "' " +
                     " WHERE id_abstract=" + i.Id_abstract + " AND " +
                     "id_interface like '" + i.Id_interface + "'";

        Connector.performSQLUpdate(sql);
    }


    internal Interface retrieve_libraryPath(string library_path)
    {
        Interface i = null;
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_interface, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order` " +
            "FROM interface " +
            "WHERE class_name like '" + library_path + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            i = new Interface();
            i.Id_interface = (string)reader["id_interface"];
            i.Id_abstract = (int)reader["id_abstract"];
            i.Assembly_string = (string)reader["assembly_string"];
            i.Id_interface_super = (string)reader["id_interface_super"];
            if (reader["id_interface_super_top"].ToString().Equals(""))
            {
                i.Id_interface_super_top = null;
            }
            else
            {
                i.Id_interface_super_top = (string)reader["id_interface_super_top"];
            }
            i.Class_name = (string)reader["class_name"];
            i.Class_nargs = (int)reader["class_nargs"];
            i.URI_Source = (string)reader["uri_source"];
            i.Order = (int)reader["order"];
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
        return i;
    }
}//class

}//namespace