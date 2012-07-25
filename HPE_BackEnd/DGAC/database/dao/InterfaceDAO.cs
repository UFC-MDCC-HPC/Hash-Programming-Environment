using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections;
using System.Collections.Generic; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class InterfaceDAO{


    public void insert(Interface ac)
    {
        String sql =
            "INSERT INTO interface (id_interface, " +
                                   "partition_index, " +
                                   "id_abstract, " +
                                   "assembly_string, " +
                                   "id_interface_super, " +
                                   "partition_index_super, " +
                                   "id_interface_super_top, " +
                                   "partition_index_super_top, " +
                                   "class_name, " +
                                   "class_nargs, " +
                                   "uri_source, " +
                                   "`order`)" +
            " VALUES ('" + ac.Id_interface + "'," 
					     + ac.Partition_index + ", " 
					     + ac.Id_abstract + ",'" 
					     + ac.Assembly_string + "','" 
					     + ac.Id_interface_super + "'," 
					     + ac.Partition_index_super + ",'"
					     + ac.Id_interface_super_top + "'," 
					     + ac.Partition_index_super_top + ",'" 
					     + ac.Class_name + "'," 
					     + ac.Class_nargs + ",'" 
					     + ac.URI_Source + "'," 
					     + ac.Order + ")";

        Connector.performSQLUpdate(sql);
    }

	
    // UPDATED BY HERON (id_abstract is now a key)
	public Interface retrieve(int id_abstract, string id_interface, int partition_index){
	   
	   Interface i = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_interface, partition_index, id_abstract, assembly_string, id_interface_super, partition_index_super, id_interface_super_top, partition_index_super_top, class_name, class_nargs, uri_source, `order` " +
           "FROM interface "+
           "WHERE id_interface like '" + id_interface + "' AND " + 
           "id_abstract=" + id_abstract + " AND partition_index = " + partition_index;
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       if (reader.Read())
       {
           i = new Interface();
           i.Id_interface = (string)reader["id_interface"];
	       i.Partition_index = (int)reader["partition_index"];
           i.Id_abstract = (int)reader["id_abstract"];
           i.Assembly_string = (string)reader["assembly_string"];
           i.Id_interface_super = (string)reader["id_interface_super"];
	       i.Partition_index_super = (int)reader["partition_index_super"];
           if (reader["id_interface_super_top"].ToString().Equals(""))
           {
               i.Id_interface_super_top = null;
			   i.Partition_index_super_top = -1;
           }
           else
           {
               i.Id_interface_super_top = (string)reader["id_interface_super_top"];
	           i.Partition_index_super_top = (int)reader["partition_index"];					
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
            "SELECT id_interface, partition_index, partition_index_super, partition_index_super_top, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order` " +
            "FROM interface " +
            "WHERE id_abstract=" + id_abstract + " ORDER BY `order`";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            Interface i = new Interface();
            i.Id_interface = (string)reader["id_interface"];
			i.Partition_index = (int)reader["partition_index"];
            i.Id_abstract = (int)reader["id_abstract"];
            i.Assembly_string = (string)reader["assembly_string"];
            if (reader["id_interface_super_top"].ToString().Equals(""))
            {
                i.Id_interface_super_top = null;
				i.Partition_index_super_top = -1;
            } 
			else 
			{
                i.Id_interface_super_top = (string)reader["id_interface_super_top"];
			    i.Partition_index_super_top = (int)reader["partition_index_super_top"];
            }

            i.Id_interface_super = (string)reader["id_interface_super"];
			i.Partition_index_super = (int)reader["partition_index_super"];
            
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

    public IList<Interface> listByInterface(int id_abstract, string id_interface)
    {

        IList<Interface> iList = new List<Interface>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_interface, partition_index, partition_index_super, partition_index_super_top, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order` " +
            "FROM interface " +
            "WHERE id_abstract=" + id_abstract + " and id_interface ='" + id_interface + "' ORDER BY `order`";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            Interface i = new Interface();
            i.Id_interface = (string)reader["id_interface"];
			i.Partition_index = (int)reader["partition_index"];
            i.Id_abstract = (int)reader["id_abstract"];
            i.Assembly_string = (string)reader["assembly_string"];
            if (reader["id_interface_super_top"].ToString().Equals(""))
            {
                i.Id_interface_super_top = null;
				i.Partition_index_super_top = -1;
            } 
			else {
                i.Id_interface_super_top = (string)reader["id_interface_super_top"];
			    i.Partition_index_super_top = (int)reader["partition_index_super_top"];
            }

            i.Id_interface_super = (string)reader["id_interface_super"];
			i.Partition_index_super = (int)reader["partition_index_super"];
            
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

    internal void setInterfaceSuperTop(int id_abstract, string id_interface, int partition_index, string id_interface_super_top, int partition_index_super_top)
    {
        String sql =
            "UPDATE interface SET id_interface_super_top = '" + id_interface_super_top + "', partition_index_super_top = " + partition_index_super_top +
            " WHERE id_abstract=" + id_abstract + " AND id_interface like '" + id_interface + "' AND partition_index = " + partition_index;

        Connector.performSQLUpdate(sql);
    }

    internal Interface retrieveByMatching(int id_abstract_1, int id_abstract_2, string id_interface, int partition_index)
    {
        Interface i = retrieve(id_abstract_2,id_interface, partition_index);
        string id_interface_super_top_2 = i.Id_interface_super_top;
		int partition_index_super_top_2 = i.Partition_index_super_top;

        IList<Interface> iList = list(id_abstract_1);
        foreach (Interface iSuperCandidate in iList)
        {
            string id_interface_super_top_1 = iSuperCandidate.Id_interface_super_top;
			int partition_index_super_top_1 = iSuperCandidate.Partition_index_super_top;
            if (id_interface_super_top_1.Equals(id_interface_super_top_2) &&
				    partition_index_super_top_1 == partition_index_super_top_2)
            {
                return iSuperCandidate;
            }
        }
        
        return null;
    }

    internal void setPublicKey(int id_abstract, string id_interface, int partition_index, string publicKey)
    {
        Interface i = this.retrieve(id_abstract, id_interface, partition_index);

        String s = ", PublicKey=";

        if (i.Assembly_string.IndexOf(s) < 0)
        {
            i.Assembly_string += s + publicKey;
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
        String sql = "UPDATE interface SET assembly_string = '" + i.Assembly_string + "' " +
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
            "SELECT id_interface, partition_index, partition_index_super, partition_index_super_top, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order` " +
            "FROM interface " +
            "WHERE class_name like '" + library_path + "'";
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            i = new Interface();
            i.Id_interface = (string)reader["id_interface"];
			i.Partition_index = (int)reader["partition_index"];
            i.Id_abstract = (int)reader["id_abstract"];
            i.Assembly_string = (string)reader["assembly_string"];
            i.Id_interface_super = (string)reader["id_interface_super"];
			i.Partition_index_super = (int)reader["partition_index_super"];
            if (reader["id_interface_super_top"].ToString().Equals(""))
            {
                i.Id_interface_super_top = null;
				i.Partition_index_super_top = -1;
            }
            else
            {
                i.Id_interface_super_top = (string)reader["id_interface_super_top"];
			    i.Partition_index_super_top = (int)reader["partition_index_super_top"];
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

    internal Interface retrieveTop(int id_abstract, string id_interface)
    {
        IList<Interface> iList = BackEnd.idao.list(id_abstract);
        foreach (Interface i in iList)
        {
            if (i.Id_interface_super_top.Equals(id_interface))
            {
                return i;
            }
        }

        return null;
    }

    internal Interface retrieveSuper(int id_abstract, string id_interface)
    {
        bool loop;
        AbstractComponentFunctor acf = DGAC.BackEnd.acfdao.retrieve(id_abstract);

        IList<Interface> iList = BackEnd.idao.list(id_abstract);
        foreach (Interface i in iList)
        {
            Interface iCurr = i;
            AbstractComponentFunctor acfCurr = acf;
            do
            {
                if (iCurr.Id_interface.Equals(id_interface))
                {
                    return i;
                }
                else if (loop = acfCurr.Id_functor_app_supertype > 0)
                {
                    AbstractComponentFunctorApplication acfaSuper = DGAC.BackEnd.acfadao.retrieve(acfCurr.Id_functor_app_supertype);
                    acfCurr = DGAC.BackEnd.acfdao.retrieve(acfaSuper.Id_abstract);
                    iCurr = DGAC.BackEnd.idao.retrieve(acfaSuper.Id_abstract, iCurr.Id_interface_super, iCurr.Partition_index_super);
                }
            }
            while (loop);
        }

        return null;
    }
}//class

}//namespace
