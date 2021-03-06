﻿using System;
using System.Collections.Generic;
using System.Text;
using br.ufc.pargo.hpe.backend.DGAC.database;
using System.Data;
using System.Diagnostics;


namespace br.ufc.pargo.hpe.backend.DGAC.database
{
    public class SourceCodeDAO
    {
        public void insert(SourceCode ac)
        {
			String contents = ac.Contents.Replace ("'", "\\'");

            String sql =
                "INSERT INTO sourcecode (type_owner, id_owner_container, id_owner, contents, file_type, file_name, file_order)" +
                " VALUES ('" + ac.Type_owner + "'," + ac.Id_owner_container + ",'" + ac.Id_owner + "','" +  contents + "','" + ac.File_type + "','" + ac.File_name +"'," + ac.Order + ")";

            Connector.performSQLUpdate(sql);
        }

        public IList<SourceCode> list(char type_owner, int id_owner_container, string id_owner)
        {
            SourceCodeReferenceDAO scrdao = new SourceCodeReferenceDAO();
            IList<SourceCode> list = new List<SourceCode>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT type_owner, id_owner_container, id_owner, contents, file_type, file_name, file_order " +
                "FROM sourcecode " +
                "WHERE type_owner like '" + type_owner + "' AND id_owner_container=" + id_owner_container + " AND id_owner like '" + id_owner + "'" +
                "ORDER BY file_type, file_order";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                SourceCode sc = new SourceCode();
                sc.Type_owner = ((string)reader["type_owner"])[0];
                sc.Id_owner_container = (int)reader["id_owner_container"];
                sc.Id_owner = (string)reader["id_owner"];
                sc.Contents = ((string)reader["contents"]).Replace("\'","'");
                sc.File_name = (string)reader["file_name"];
                sc.File_type = (string)reader["file_type"];               
                sc.Order = (int)reader["file_order"];

                list.Add(sc);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;

        }//list

		public IList<SourceCode> listByFileType(char type_owner, int id_owner_container, string id_owner, string source_type)
		{
			SourceCodeReferenceDAO scrdao = new SourceCodeReferenceDAO();
			IList<SourceCode> list = new List<SourceCode>();
			IDbConnection dbcon = Connector.DBcon;
			IDbCommand dbcmd = dbcon.CreateCommand();
			string sql =
				"SELECT type_owner, id_owner_container, id_owner, contents, file_type, file_name, file_order " +
				"FROM sourcecode " +
				"WHERE type_owner like '" + type_owner + "' AND id_owner_container=" + id_owner_container + " AND id_owner like '" + id_owner + "' AND file_type like '" + source_type + "'" +
				"ORDER BY file_type, file_order";
			dbcmd.CommandText = sql;
			IDataReader reader = dbcmd.ExecuteReader();
			while (reader.Read())
			{
				SourceCode sc = new SourceCode();
				sc.Type_owner = ((string)reader["type_owner"])[0];
				sc.Id_owner_container = (int)reader["id_owner_container"];
				sc.Id_owner = (string)reader["id_owner"];
				sc.Contents = ((string)reader["contents"]).Replace("\'","'");
				sc.File_name = (string)reader["file_name"];
				sc.File_type = (string)reader["file_type"];               
				sc.Order = (int)reader["file_order"];

				list.Add(sc);
			}//while
			// clean up
			reader.Close();
			reader = null;
			dbcmd.Dispose();
			dbcmd = null;
			return list;

		}//list


        internal void update(SourceCode ss)
        {
			String contents = ss.Contents.Replace ("'", "\\'");
			Console.WriteLine (contents);

           String sql =
                "UPDATE sourcecode SET contents='" + contents + "' WHERE type_owner like '" + ss.Type_owner + "'"
                                                     +    " and id_owner like '" + ss.Id_owner + "'" 
                                                     +    " and file_name like '" + ss.File_name + "'" 
                                                     +    " and id_owner_container = " + ss.Id_owner_container;
                
                
            Connector.performSQLUpdate(sql);
        }
    }
}
