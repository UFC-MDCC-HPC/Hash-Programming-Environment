using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections;
using System.Collections.Generic;
using System.Diagnostics; 


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable()]
public class InterfaceDAO{


    public void insert(Interface ac)
    {
        String sql =
            "INSERT INTO interface (id_interface, " +
 								   "facet, " + 
                                   "id_abstract, " +
                                   "assembly_string, " +
                                   "id_interface_super, " +
                                    "class_name, " +
                                   "class_nargs, " +
                                   "uri_source, " +
                                   "is_parallel, " +
                                   "`order`)" +
            " VALUES ('" + ac.Id_interface + "'," 
						 + ac.Facet + ", "
					     + ac.Id_abstract + ",'" 
					     + ac.Assembly_string + "','" 
					     + ac.Id_interface_super + "','" 
					     + ac.Class_name + "'," 
					     + ac.Class_nargs + ",'" 
					     + ac.URI_Source + "'," 
					     + (ac.Is_parallel ? "1" : "0") + "," 
					     + ac.Order + ")";

   		Console.WriteLine("Interface.cs: TRY INSERT: " + sql);



        Connector.performSQLUpdate(sql);
    }

	
    // UPDATED BY HERON (id_abstract is now a key)
	public Interface retrieve(int id_abstract, string id_interface){
	   
	   Interface i = null;
	   IDbConnection dbcon = Connector.DBcon;
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_interface, facet, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order`, is_parallel " +
           "FROM interface "+
           "WHERE id_interface like '" + id_interface + "' AND " + 
				"id_abstract=" + id_abstract;
			
       dbcmd.CommandText = sql;
			Console.WriteLine (sql);
			      IDataReader reader = dbcmd.ExecuteReader();
       if (reader.Read())
       {
           i = new Interface();
           i.Id_interface = (string)reader["id_interface"];
	       //i.Unit_replica = (int)reader["unit_replica"];
		   i.Facet = (int)reader["facet"];
           i.Id_abstract = (int)reader["id_abstract"];
           i.Assembly_string = (string)reader["assembly_string"];
           i.Id_interface_super = (string)reader["id_interface_super"];
	      // i.Unit_replica_super = (int)reader["unit_replica_super"];
	       i.Is_parallel = ((int)reader["is_parallel"]) != 0;
           if (reader["id_interface_super_top"].ToString().Equals(""))
           {
               i.Id_interface_super_top = null;
			  // i.Unit_replica_super_top = -1;
           }
           else
           {
               i.Id_interface_super_top = (string)reader["id_interface_super_top"];
	       //    i.Unit_replica_super_top = (int)reader["unit_replica"];					
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
			
	   if (i == null)
				Console.Error.WriteLine("InterfaceDAO.cs: Interface not found ! id_abstract=" + id_abstract + ", id_interface=" + id_interface);
			
       return i;
	}

	// UPDATED BY HERON (id_abstract is now a key)
    public IList<Interface> list(int id_abstract)
    {

        IList<Interface> iList = new List<Interface>();
        IDbConnection dbcon = Connector.DBcon;
        IDbCommand dbcmd = dbcon.CreateCommand();
        string sql =
            "SELECT id_interface, facet, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order`, is_parallel " +
            "FROM interface " +
            "WHERE id_abstract=" + id_abstract + " ORDER BY `order`";
			Console.WriteLine ("InterfaceDAO - list :" + sql);
        dbcmd.CommandText = sql;
			Console.WriteLine (sql);
        IDataReader reader = dbcmd.ExecuteReader();


        while (reader.Read())
        {
            Interface i = new Interface();
            i.Id_interface = (string)reader["id_interface"];
			//i.Unit_replica = (int)reader["unit_replica"];
			i.Facet = (int)reader["facet"];
            i.Id_abstract = (int)reader["id_abstract"];
            i.Assembly_string = (string)reader["assembly_string"];
	        i.Is_parallel = ((int)reader["is_parallel"]) != 0;
            if (reader["id_interface_super_top"].ToString().Equals(""))
            {
                i.Id_interface_super_top = null;
            } 
			else 
			{
                i.Id_interface_super_top = (string)reader["id_interface_super_top"];
            }

            i.Id_interface_super = (string)reader["id_interface_super"];
			//i.Unit_replica_super = (int)reader["unit_replica_super"];
            
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
            "SELECT id_interface, facet, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order`, is_parallel " +
            "FROM interface " +
            "WHERE id_abstract=" + id_abstract + " and id_interface ='" + id_interface + "' ORDER BY `order`";
        dbcmd.CommandText = sql;
			Console.WriteLine (sql);
        IDataReader reader = dbcmd.ExecuteReader();
        while (reader.Read())
        {
            Interface i = new Interface();
            i.Id_interface = (string)reader["id_interface"];
		//	i.Unit_replica = (int)reader["unit_replica"];
			i.Facet = (int)reader["facet"];
            i.Id_abstract = (int)reader["id_abstract"];
            i.Assembly_string = (string)reader["assembly_string"];
	        i.Is_parallel = ((int)reader["is_parallel"]) != 0;
            if (reader["id_interface_super_top"].ToString().Equals(""))
            {
                i.Id_interface_super_top = null;
			//	i.Unit_replica_super_top = -1;
            } 
			else {
                i.Id_interface_super_top = (string)reader["id_interface_super_top"];
		//	    i.Unit_replica_super_top = (int)reader["unit_replica_super_top"];
            }

            i.Id_interface_super = (string)reader["id_interface_super"];
			//i.Unit_replica_super = (int)reader["unit_replica_super"];
            
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
            "UPDATE interface SET id_interface_super_top = '" + id_interface_super_top + "' " +
            " WHERE id_abstract=" + id_abstract + " AND id_interface like '" + id_interface + "'";

			Console.WriteLine ("setInterfaceSuperTop: " + sql);
 
        Connector.performSQLUpdate(sql);
    }

    internal Interface[] retrieveByMatching(int id_abstract_1, int id_abstract_2, string id_interface)
    {
        Interface i = retrieve(id_abstract_2, id_interface);
		string[] id_interface_super_top_2 = Interface.splitIDs(i.Id_interface_super_top);
		//int[] unit_replica_super_top_2 = i.Unit_replica_super_top;

		IList<Interface> result_list = new List<Interface> ();

        IList<Interface> iList = list(id_abstract_1);
        foreach (Interface iSuperCandidate in iList)
        {
			string[] id_interface_super_top_1 = Interface.splitIDs(iSuperCandidate.Id_interface_super_top);
			//int[] unit_replica_super_top_1 = iSuperCandidate.Unit_replica_super_top;
			
			// CHECK WHETHER this candidate to unit 1 is transitively inherited from a subset of the units from which the unit 2 was derived.
			bool found=false;
			foreach (string x in id_interface_super_top_1) 
			{
				found = false;
				foreach (string y in id_interface_super_top_2) 
				{
						if (x.Equals(y)) 
						{
							found = true;
							break;
						}
				}
				if (!found)
					break;
			}
			if (found)
				result_list.Add (iSuperCandidate);	
        }

		Interface[] result_array = new Interface[result_list.Count];
		result_list.CopyTo (result_array, 0);

		return result_array;
    }

    internal void setPublicKey(int id_abstract, string id_interface, string publicKey)
    {
        Interface i = this.retrieve(id_abstract, id_interface);

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
            "SELECT id_interface, facet, id_abstract, assembly_string, id_interface_super, id_interface_super_top, class_name, class_nargs, uri_source, `order`, is_parallel " +
            "FROM interface " +
            "WHERE class_name like '" + library_path + "'";
        dbcmd.CommandText = sql;
			Console.WriteLine (sql);
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read())
        {
            i = new Interface();
            i.Id_interface = (string)reader["id_interface"];
		//	i.Unit_replica = (int)reader["unit_replica"];
			i.Facet = (int)reader["facet"];
            i.Id_abstract = (int)reader["id_abstract"];
            i.Assembly_string = (string)reader["assembly_string"];
            i.Id_interface_super = (string)reader["id_interface_super"];
		//	i.Unit_replica_super = (int)reader["unit_replica_super"];
	        i.Is_parallel = ((int)reader["is_parallel"]) != 0;
            if (reader["id_interface_super_top"].ToString().Equals(""))
            {
                i.Id_interface_super_top = null;
			//	i.Unit_replica_super_top = -1;
            }
            else
            {
                i.Id_interface_super_top = (string)reader["id_interface_super_top"];
		//	    i.Unit_replica_super_top = (int)reader["unit_replica_super_top"];
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
			Console.WriteLine ("i.Id_interface_top = " + i.Id_interface_super_top + " = " + id_interface + " ?");
			string[] interface_ids_tops = Interface.splitIDs(i.Id_interface_super_top);

			foreach (string interface_id_top in interface_ids_tops) 
			{
				if (interface_id_top.Equals (id_interface)) 
				{
					return i;
				}
			}
        }

        return null;
    }

    internal Interface retrieveSuper(int id_abstract, string id_interface)
    {

			Console.WriteLine ("retrieveSuper - BEGIN 1 " + id_abstract + "/" + id_interface);
        bool loop;
        AbstractComponentFunctor acf = DGAC.BackEnd.acfdao.retrieve(id_abstract);

        IList<Interface> iList = BackEnd.idao.list(id_abstract);
			Console.WriteLine ("retrieveSuper - BEGIN 2 " + iList.Count);
        foreach (Interface i in iList)
        {
			IList<Tuple<AbstractComponentFunctor, Interface>> queue = new List<Tuple<AbstractComponentFunctor, Interface>> ();
			queue.Add (new Tuple<AbstractComponentFunctor, Interface> (acf,i));
			while (queue.Count > 0)
            {
				AbstractComponentFunctor acfCurr = queue[0].Item1;
				Interface iCurr = queue[0].Item2;
				queue.RemoveAt(0);
					Console.WriteLine ("retrieveSuper - DEQUEUE - id_abstract=" + acfCurr.Id_abstract + " / id_interface=" + iCurr.Id_interface);
                if (iCurr.Id_interface.Equals(id_interface))
                {
					Console.WriteLine ("retrieveSuper: found id_abstract=" + acfCurr.Id_abstract + " / id_interface=" + iCurr.Id_interface);
		            return i;
                }
                else if (loop = acfCurr.Id_functor_app_supertype > 0)
                {
                    AbstractComponentFunctorApplication acfaSuper = DGAC.BackEnd.acfadao.retrieve(acfCurr.Id_functor_app_supertype);
                    acfCurr = DGAC.BackEnd.acfdao.retrieve(acfaSuper.Id_abstract);
					string[] id_interface_super_list = Interface.splitIDs(iCurr.Id_interface_super);
					foreach (string id_interface_super in id_interface_super_list) 
					{
						Console.WriteLine ("retrieveSuper: id_abstract=" + acfCurr.Id_abstract + " / id_interface=" +iCurr.Id_interface);
						iCurr = DGAC.BackEnd.idao.retrieve (acfaSuper.Id_abstract, id_interface_super);
						queue.Add (new Tuple<AbstractComponentFunctor, Interface> (acfCurr,iCurr));
					}
                }
            }
        }

			Console.WriteLine ("retrieveSuper - END NULL");
        return null;
    }

	public int count_facets (int id_abstract)
	{
			Interface i = null;
			IDbConnection dbcon = Connector.DBcon;
			IDbCommand dbcmd = dbcon.CreateCommand();
			string sql =
				"SELECT DISTINCT facet FROM interface where id_abstract=" + id_abstract + " and facet>=0 group by facet";
			dbcmd.CommandText = sql;

			IDataReader reader = dbcmd.ExecuteReader();
			int count = 0;
			while (reader.Read())	count++;

			// clean up
			reader.Close();
			reader = null;
			dbcmd.Dispose();
			dbcmd = null;

			return count;
	}


}//class

}//namespace
