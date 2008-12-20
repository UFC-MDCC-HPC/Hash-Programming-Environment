using System;
using System.IO;
using System.Data;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic; 

namespace DGAC.database
{
    [Serializable()]
    public class InnerConcreteComponentDAO
    {

        public int getNextFreshIndex(int id_concrete, string id_inner) {

            int key = -1;

            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                 "SELECT MAX(id_index) AS fresh_index " +
                 "FROM hashmodel.innerconcrete " +
                 "WHERE id_concrete=" + id_concrete + " AND " +
                 "id_inner like '" + id_inner + "' " +
                 "GROUP BY id_concrete, id_inner";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();

            if (reader.Read()) {
                key = (int)reader["fresh_index"];
            }

            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return key+1;
        }

        public void insert(InnerConcreteComponent ac)
        {
            String sql =
                "INSERT INTO hashmodel.innerconcrete (id_concrete, id_inner, id_index, id_concrete_actual)" +
                " VALUES (" + ac.Id_concrete + ",'" + ac.Id_inner + "'," + ac.Id_index + "," + ac.Id_concrete_actual + ")";

            Connector.performSQLUpdate(sql);
        }
		
		public void update(int id_concrete, string id_inner, int id_concrete_actual)
        {
            String sql =
                "UPDATE hashmodel.innerconcrete" +
				" SET id_concrete_actual="+id_concrete_actual+
                " WHERE id_concrete=" +id_concrete+ " AND id_inner='"+id_inner+"'";

            Connector.performSQLUpdate(sql);
        }
		

        public InnerConcreteComponent retrieve(int id_concrete, string id_inner, int id_index)
        {
            InnerConcreteComponent c = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                 "SELECT id_concrete, id_inner, id_index, id_concrete_actual " +
                 "FROM hashmodel.innerconcrete " +
                 "WHERE id_concrete=" + id_concrete + " AND " + 
                 "id_inner like '" + id_inner + "' AND " + 
                 "id_index=" + id_index;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                c = new InnerConcreteComponent();
                c.Id_concrete = (int)reader["id_concrete"];
                c.Id_inner = (string)reader["id_inner"];
                c.Id_index = (int)reader["id_index"];
                c.Id_concrete_actual = (int)reader["id_concrete_actual"];
            }//if
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return c;
        }

        public IList<InnerConcreteComponent> retrieveEnumeration(int id_concrete, string id_inner)
        {
            InnerConcreteComponent c = null;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            IList<InnerConcreteComponent> l = new List<InnerConcreteComponent>();
            string sql =
                 "SELECT id_concrete, id_inner, id_index, id_concrete_actual " +
                 "FROM hashmodel.innerconcrete " +
                 "WHERE id_concrete=" + id_concrete + " AND " +
                 "id_inner like '" + id_inner;
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                c = new InnerConcreteComponent();
                c.Id_concrete = (int)reader["id_concrete"];
                c.Id_inner = (string)reader["id_inner"];
                c.Id_index = (int)reader["id_index"];
                c.Id_concrete_actual = (int) reader["id_concrete_actual"];

                l.Add(c);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return l;
        }
    }
}
