using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 

namespace br.ufc.pargo.hpe.backend.DGAC.database
{

    [Serializable()]
    public class SliceDAO
    {

        public void insert(Slice ac)
        {

            String sql =
                "INSERT INTO slice (id_abstract, id_interface, id_interface_slice, id_inner, partition_index, transitive, property_name)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_interface + "','" + ac.Id_interface_slice + "','" + ac.Id_inner + "'," + ac.Partition_index + "," + (ac.Transitive ? -1 : 0) + ",'" + ac.PortName + "')";

            Connector.performSQLUpdate(sql);

        }


        // ADDED BY HERON
        public Slice retrieve(int id_abstract, string id_inner, string id_interface_slice, int partition_index)
        {
            Slice s = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_interface, id_interface_slice, id_inner, partition_index, transitive, property_name " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "' AND " + 
                "id_interface_slice like '" + id_interface_slice + "' AND " + 
                "partition_index = " + partition_index;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_interface = (string)reader["id_interface"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_inner = (string)reader["id_inner"];
                s.Partition_index = (int)reader["partition_index"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
                s.PortName = (string)reader["property_name"];
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
            return s;

        }//list

        // ADDED BY HERON
        public Slice retrieve2(int id_abstract, string id_inner, string id_interface_slice, string id_interface)
        {
            Slice s = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_interface, id_interface_slice, id_inner, partition_index, transitive, property_name " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner like '" + id_inner + "' AND " +
                "id_interface_slice like '" + id_interface_slice + "' AND " +
                "id_interface like '" + id_interface + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_interface = (string)reader["id_interface"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_inner = (string)reader["id_inner"];
                s.Partition_index = (int)reader["partition_index"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
                s.PortName = (string)reader["property_name"];
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
            return s;

        }//list

        
        
        
        public IList<Slice> listByInner(int id_abstract, string id_inner)
        {

            IList<Slice> list = new List<Slice>();
            IDbConnection dbcon = Connector.getConnection();
            dbcon.Open();
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, id_interface, partition_index, transitive, property_name " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " and id_inner like '" + id_inner + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                Slice s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_interface = (string)reader["id_interface"];
                s.Partition_index = (int)reader["partition_index"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
                s.PortName = (string)reader["property_name"];
                list.Add(s);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            dbcon.Close();
            dbcon = null;
            return list;

        }//list2

        public IList<Slice> listByInterface(int id_abstract, string id_interface)
        {

            IList<Slice> list = new List<Slice>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_interface, id_interface_slice, id_inner, partition_index, transitive, property_name " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " and " + "id_interface like '" + id_interface + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                Slice s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_interface = (string)reader["id_interface"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_inner = (string)reader["id_inner"];
                s.Partition_index = (int)reader["partition_index"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
                s.PortName = (string)reader["property_name"];
                list.Add(s);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;

        }//list

        public IList<Slice> listByInnerInInterface(int id_abstract, string id_inner, string id_interface)
        {

            IList<Slice> list = new List<Slice>();
            IDbConnection dbcon = Connector.getConnection();
            dbcon.Open();
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, id_interface, partition_index, transitive, property_name " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + 
                 " and id_inner like '" + id_inner + "'" +
                 " and id_interface like '" + id_interface + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                Slice s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_interface = (string)reader["id_interface"];
                s.Partition_index = (int)reader["partition_index"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
                s.PortName = (string)reader["property_name"];
                list.Add(s);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            dbcon.Close();
            dbcon = null;
            return list;

        }//list3

        internal IList<Slice> listSlicesOfInner(int id_abstract, string id_inner, string id_interface_slice)
        {
            IList<Slice> list = new List<Slice>();
            IDbConnection dbcon = Connector.getConnection();
            dbcon.Open();
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner, id_interface_slice, id_interface, partition_index, transitive, property_name " +
                "FROM slice " +
                "WHERE id_abstract=" + id_abstract + " and id_inner like '" + id_inner + "'" + " and id_interface_slice like '" + id_interface_slice + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                Slice s = new Slice();
                s.Id_abstract = (int)reader["id_abstract"];
                s.Id_inner = (string)reader["id_inner"];
                s.Id_interface_slice = (string)reader["id_interface_slice"];
                s.Id_interface = (string)reader["id_interface"];
                s.Partition_index = (int)reader["partition_index"];
                s.Transitive = ((int)reader["transitive"]) == 0 ? false : true;
                s.PortName = (string)reader["property_name"];
                list.Add(s);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            dbcon.Close();
            dbcon = null;
            return list;
        }
    }//class

}//namespace
