using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic;

namespace br.ufc.pargo.hpe.backend.DGAC.database
{

    [Serializable()]
    public class SliceExposedDAO
    {

        public void insert(SliceExposed ac)
        {
            String sql =
                "INSERT INTO sliceexposed (id_abstract, id_interface_slice, id_interface_slice_owner, id_inner, id_inner_owner,  partition_index,  partition_index_owner, id_inner_original, id_interface_slice_original)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_interface_slice + "','" + ac.Id_interface_slice_owner + "','" + ac.Id_inner + "','" + ac.Id_inner_owner + "'," + ac.Partition_index + "," + ac.Partition_index_owner + ",'" + ac.Id_inner_original + "','" + ac.Id_interface_slice_original + "')";

			Console.WriteLine("SliceExposedDAO.cs: TRY INSERT PUBLIC SLICE : " + sql);
			
            Connector.performSQLUpdate(sql);
        }


        internal IList<SliceExposed> listExposedSlicesByContainer(int id_abstract, string id_inner_owner, string id_interface_slice_owner, int partition_index_owner)
        {

            IList<SliceExposed> list = new List<SliceExposed>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner, id_inner_owner, id_interface_slice, id_interface_slice_owner, partition_index, partition_index_owner, id_inner_original, id_interface_slice_original " +
                "FROM sliceexposed " +
                "WHERE id_abstract=" + id_abstract + " and " + 
                      "id_inner_owner like '" + id_inner_owner + "' and " +
                      "id_interface_slice_owner like '" + id_interface_slice_owner + "' and " + 
                      "partition_index_owner = " + partition_index_owner;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                SliceExposed s = new SliceExposed();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_inner_owner = (string)reader["id_inner_owner"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_interface_slice_owner = (string)reader["id_interface_slice_owner"];
                s.Partition_index = (int)reader["partition_index"];
                s.Partition_index_owner = (int)reader["partition_index_owner"];
                s.Id_inner_original = (string)reader["id_inner_original"];
                s.Id_interface_slice_original = (string)reader["id_interface_slice_original"];
                list.Add(s);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;

        }

        internal string retrieveIdInnerOwner(int id_abstract, string id_inner, string id_unit)
        {
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT DISTINCT id_abstract, id_inner, id_interface_slice, id_inner_owner "  +
                "FROM sliceexposed " +
                "WHERE id_abstract=" + id_abstract + " and " +
                      "id_inner like '" + id_inner + "' and " +
                      "id_interface_slice like '" + id_unit + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            string id_inner_owner = null;
            if (reader.Read())            
                id_inner_owner = (string)reader["id_inner_owner"];
             //while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return id_inner_owner;
        }

        internal IList<SliceExposed> listContainers(int id_abstract, string id_inner, string id_interface_slice, int partition_index) 
        {
            IList<SliceExposed> ll = new List<SliceExposed>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            SliceExposed se = null;
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, partition_index, partition_index_owner, id_inner_owner, id_interface_slice_owner, id_inner_original, id_interface_slice_original " +
                "FROM sliceexposed " +
                "WHERE id_inner like '" + id_inner + "' and " +
                      "id_interface_slice like '" + id_interface_slice + "' and " +
                      "id_abstract = " + id_abstract + " and " +
                      "partition_index = " + partition_index;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                se = new SliceExposed();
                se.Id_inner = (string)reader["id_inner"];
                se.Id_abstract = (int)reader["id_abstract"];
                se.Id_interface_slice = (string)reader["id_interface_slice"];
                se.Partition_index = (int)reader["partition_index"];
                se.Id_inner_owner = (string)reader["id_inner_owner"];
                se.Id_interface_slice_owner = (string)reader["id_interface_slice_owner"];
                se.Partition_index_owner = (int)reader["partition_index_owner"];
                se.Id_inner_original = (string)reader["id_inner_original"];
                se.Id_interface_slice_original = (string)reader["id_interface_slice_original"];
                ll.Add(se);
            }
            //if
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return ll;
        }

        

        internal SliceExposed retrieveContainer(string id_inner, string id_interface_slice, int id_abstract, int partition_index, string id_inner_owner)
        {
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            SliceExposed se = null;
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, partition_index, partition_index_owner, id_inner_owner, id_interface_slice_owner, id_inner_original, id_interface_slice_original " +
                "FROM sliceexposed " +
                "WHERE id_inner like '" + id_inner + "' and " +
                      "id_interface_slice like '" + id_interface_slice + "' and " +
                      "id_abstract = " + id_abstract + " and " +
                      "partition_index = " + partition_index + " and " +
                      "id_inner_owner = " + id_inner_owner;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                se = new SliceExposed();
                se.Id_inner = (string)reader["id_inner"];
                se.Id_abstract = (int)reader["id_abstract"];
                se.Id_interface_slice = (string)reader["id_interface_slice"];
                se.Partition_index = (int)reader["partition_index"];
                se.Id_inner_owner = (string)reader["id_inner_owner"];
                se.Id_interface_slice_owner = (string)reader["id_interface_slice_owner"];
                se.Partition_index_owner = (int)reader["partition_index_owner"];
                se.Id_inner_original = (string)reader["id_inner_original"];
                se.Id_interface_slice_original = (string)reader["id_interface_slice_original"];
            }
            //if
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return se;
        }

        internal SliceExposed retrieveContainerByOriginal(
            string id_inner_original, 
            string id_interface_slice_original, 
            int id_abstract_start, 
            string id_interface_owner,
            string id_inner_owner)
        {
			int id_abstract = id_abstract_start;
	            SliceExposed se = null;
			
			while (id_abstract > 0) 
			{
	            IDbConnection dbcon = Connector.DBcon;
	            IDbCommand dbcmd = dbcon.CreateCommand();
	            string sql =
	                "SELECT id_abstract, id_inner, id_interface_slice, partition_index, partition_index_owner, id_inner_owner, id_interface_slice_owner, id_inner_original, id_interface_slice_original " +
	                "FROM sliceexposed " +
	                "WHERE id_inner_original like '" + id_inner_original + "' and " +
	                      "id_interface_slice_original like '" + id_interface_slice_original + "' and " +
	                      "id_abstract = " + id_abstract + " and " +
	                      "id_interface_slice_owner like '" + id_interface_owner + "' and " +
	                      "id_inner_owner like '" + id_inner_owner + "'";
	            dbcmd.CommandText = sql;
	            IDataReader reader = dbcmd.ExecuteReader();
	            if (reader.Read())
	            {
	                se = new SliceExposed();
	                se.Id_inner = (string)reader["id_inner"];
	                se.Id_abstract = (int)reader["id_abstract"];
	                se.Id_interface_slice = (string)reader["id_interface_slice"];
	                se.Partition_index = (int)reader["partition_index"];
	                se.Id_inner_owner = (string)reader["id_inner_owner"];
	                se.Id_interface_slice_owner = (string)reader["id_interface_slice_owner"];
	                se.Partition_index_owner = (int)reader["partition_index_owner"];
	                se.Id_inner_original = (string)reader["id_inner_original"];
	                se.Id_interface_slice_original = (string)reader["id_interface_slice_original"];
	            }
	            //if
	            // clean up
	            reader.Close();
	            reader = null;
	            dbcmd.Dispose();
	            dbcmd = null;
				
				if (se == null) 
				{
	                AbstractComponentFunctor acf = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfdao.retrieve(id_abstract);
					if (acf.Id_functor_app_supertype > 0)
					{
					   AbstractComponentFunctorApplication acfa = br.ufc.pargo.hpe.backend.DGAC.BackEnd.acfadao.retrieve(acf.Id_functor_app_supertype);
					   id_abstract = acfa.Id_abstract;
					}
					else 
						id_abstract = -1;
				}
				else 
				   id_abstract = -1;
			}

            return se;
        }

        internal SliceExposed retrieve2(string id_inner, string id_interface_slice, int id_abstract, string id_interface_container, string id_inner_container)
        {
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            SliceExposed se = null;
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, partition_index, partition_index_owner, id_inner_owner, id_interface_slice_owner, id_inner_original, id_interface_slice_original " +
                "FROM sliceexposed " +
                "WHERE id_inner like '" + id_inner + "' and " +
                      "id_interface_slice like '" + id_interface_slice + "' and " +
                      "id_abstract = " + id_abstract + " and " +
                      "id_interface_slice_owner like '" + id_interface_container + "' and " +
					  "id_inner_owner like '" + id_inner_container + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                se = new SliceExposed();
                se.Id_inner = (string)reader["id_inner"];
                se.Id_abstract = (int)reader["id_abstract"];
                se.Id_interface_slice = (string)reader["id_interface_slice"];
                se.Partition_index = (int)reader["partition_index"];
                se.Id_inner_owner = (string)reader["id_inner_owner"];
                se.Id_interface_slice_owner = (string)reader["id_interface_slice_owner"];
                se.Partition_index_owner = (int)reader["partition_index_owner"];
                se.Id_inner_original = (string)reader["id_inner_original"];
                se.Id_interface_slice_original = (string)reader["id_interface_slice_original"];

            }
            //if
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return se;
        }

    }//class

}//namespace
