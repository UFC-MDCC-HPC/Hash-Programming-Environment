using System;
using System.Data;
using MySql.Data.MySqlClient;
using br.ufc.pargo.hpe.backend.DGAC.utils;


namespace br.ufc.pargo.hpe.backend.DGAC.database{

[Serializable]
public class Connector {
 
 	 
	 public static IDbConnection getConnection(){
	 	string connectionString = Constants.connectionString;
        // Console.WriteLine(connectionString); 
         IDbConnection dbcon;
       dbcon = new MySqlConnection(connectionString);
       return dbcon;
	 }
	 
    private static IDbConnection dbcon = null;
    private static IDbTransaction dbtrans = null;

    public static IDbConnection DBcon
    {
			get { return dbcon; }
    }

    public static void beginTransaction() 
    {
        //Console.Error.WriteLine("begin transaction");
        dbtrans = dbcon.BeginTransaction();
    }

    public static void commitTransaction()
    {
        //Console.Error.WriteLine("commit transaction");
        dbtrans.Commit();
    }

    public static void rollBackTransaction()
    {
        //Console.Error.WriteLine("rollback transaction");
        dbtrans.Rollback();
    }

    public static void endTransaction()
    {
      //  Console.Error.WriteLine("end transaction");
        dbtrans = null;
    }

    private static int r = 0;
    private static String slock = "";

    public static void openConnection()
    {      
        //lock (slock) {
	        if (r==0) {
	           dbcon = Connector.getConnection();
	           dbcon.Open();
	        }
	        r++;
        //}
    }

    public static void closeConnection()
    {       
        //lock(slock) {  
	        r--;
	        if (r == 0 && dbcon != null) {
	           dbcon.Close();
	           dbcon = null;
	        }
        //}
    }
    

    public static int nextKey(String keyField, String tableName)
    {
        int lastKey = 0;

       // IDbConnection dbcon = Connector.getConnection();
        // dbcon.Open();
        IDbCommand dbcmd = dbcon.CreateCommand();

        string sql =
             "SELECT MAX(" + keyField + ") as lastKey " +
             "FROM " + tableName;
        
        dbcmd.CommandText = sql;
        IDataReader reader = dbcmd.ExecuteReader();
        if (reader.Read() && !(reader["lastKey"] is System.DBNull))
        {
            lastKey = (int)reader["lastKey"];
        }

        reader.Close();
        reader = null;
        dbcmd.Dispose();
       // dbcon.Close();
       // dbcon = null;

        return lastKey + 1;    
    }

    /* HERON */
    public static void performSQLUpdate(String sql)
    {

        //IDbConnection dbcon = Connector.getConnection();
        //dbcon.Open();
        IDbCommand dbcmd = dbcon.CreateCommand();

        dbcmd.CommandText = sql;
        dbcmd.ExecuteNonQuery();

        dbcmd.Dispose();
        dbcmd = null;
        //dbcon.Close();
        //dbcon = null;

    }		
	 /*public void test(){
	   IDbConnection dbcon = this.getConnection();
	   dbcon.Open();
       IDbCommand dbcmd = dbcon.CreateCommand();
       string sql =
           "SELECT id_unit, id_concrete, name " +
           "FROM Unit";
       dbcmd.CommandText = sql;
       IDataReader reader = dbcmd.ExecuteReader();
       while(reader.Read()) {
       	    int id_unit = (int)reader["id_unit"];
       	    int id_concrete = (int)reader["id_concrete"];
       	    string name = (string)reader["name"];
            Console.WriteLine("id_unit: " + id_unit + " id_concrete: " + id_concrete + " name: " + name);
       }
       // clean up
       reader.Close();
       reader = null;
       dbcmd.Dispose();
       dbcmd = null;
       dbcon.Close();
       dbcon = null;
	 	
	 }*/
	
}//class

}//namespace
