using System;
using System.Collections.Generic;
using System.Text;

namespace DGAC.database
{
    [Serializable()]
    public class DeploymentDAO
    {
        /* HERON */
        public int insert(Deployment ac)
        {
            int nextKey = Connector.nextKey("id_deployment", "hashmodel.deployment");

            String sql =
                "INSERT INTO hashmodel.deployment (id_deployment, id_concrete_deployed)" +
                "VALUES (" + nextKey + "," + ac.Id_concrete_deployed + ")";

            Connector.performSQLUpdate(sql);

            return nextKey;
        }
    }
}
