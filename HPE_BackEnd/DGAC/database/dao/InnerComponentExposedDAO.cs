﻿using System;
using System.IO;
using System.Data;
using System.Data.OleDb;
using MySql.Data.MySqlClient;
using System.Runtime.Serialization;
using System.Collections.Generic;


namespace br.ufc.lia.hpe.backend.DGAC.database
{

    [Serializable()]
    public class InnerComponentExposedDAO
    {

        public void insert(InnerComponentExposed ac)
        {
            String sql =
                "INSERT INTO innercomponentexposed (id_abstract, id_inner_rename, id_inner_owner, id_inner)" +
                " VALUES (" + ac.Id_abstract + ",'" + ac.Id_inner_rename + "','" + ac.Id_inner_owner + "','" + ac.Id_inner + "')";

            Connector.performSQLUpdate(sql);
        }

        public IList<InnerComponentExposed> listExposedInnerOfOwner(int id_abstract, string id_inner_owner)
        {

            IList<InnerComponentExposed> list = new List<InnerComponentExposed>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner_rename, id_inner_owner, id_inner " +
                "FROM innercomponentexposed " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner_owner like '" + id_inner_owner + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                InnerComponentExposed ic = new InnerComponentExposed();
                ic.Id_abstract = (int)reader["id_abstract"];
                ic.Id_inner_rename = (string)reader["id_inner_rename"];
                ic.Id_inner_owner = (string)reader["id_inner_owner"];
                ic.Id_inner = (string)reader["id_inner"];
                list.Add(ic);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;

        }//list

        public IList<InnerComponentExposed> listOwnerOfExposedInner(int id_abstract, string id_inner_rename)
        {

            IList<InnerComponentExposed> list = new List<InnerComponentExposed>();
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner_rename, id_inner_owner, id_inner " +
                "FROM innercomponentexposed  " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                "id_inner_rename like '" + id_inner_rename + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            while (reader.Read())
            {
                InnerComponentExposed ic = new InnerComponentExposed();
                ic.Id_abstract = (int)reader["id_abstract"];
                ic.Id_inner_rename = (string)reader["id_inner_rename"];
                ic.Id_inner_owner = (string)reader["id_inner_owner"];
                ic.Id_inner = (string)reader["id_inner"];
                list.Add(ic);
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;
            return list;

        }//list



        internal InnerComponentExposed retrieve(int id_abstract, string id_inner_container, string id_inner_rename)
        {
            InnerComponentExposed ice = null ;
            IDbConnection dbcon = Connector.DBcon;
            IDbCommand dbcmd = dbcon.CreateCommand();
            string sql =
                "SELECT id_abstract, id_inner_rename, id_inner_owner, id_inner " +
                "FROM innercomponentexposed " +
                "WHERE id_abstract=" + id_abstract + " AND " +
                      "id_inner_rename like '" + id_inner_rename + "' AND " +
                      "id_inner_owner like '" + id_inner_container + "'";
            dbcmd.CommandText = sql;
            IDataReader reader = dbcmd.ExecuteReader();
            if (reader.Read())
            {
                ice = new InnerComponentExposed();
                ice.Id_abstract = (int)reader["id_abstract"];
                ice.Id_inner_rename = (string)reader["id_inner_rename"];
                ice.Id_inner_owner = (string)reader["id_inner_owner"];
                ice.Id_inner = (string)reader["id_inner"];
            }//while
            // clean up
            reader.Close();
            reader = null;
            dbcmd.Dispose();
            dbcmd = null;

            return ice;
        }
    }//class

}//namespace