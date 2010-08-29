using System;
using System.Collections.Generic;
using System.Text;

namespace br.ufc.hpe.backend.DGAC.database
{
    [Serializable()]
    public class DeploymentDAO
    {
        /* HERON */
        public int insert(Deployment ac)
        {
            int nextKey = Connector.nextKey("id_deployment", "deployment");

            String sql =
                "INSERT INTO deployment (id_deployment, id_concrete_deployed)" +
                "VALUES (" + nextKey + "," + ac.Id_concrete_deployed + ")";

            Connector.performSQLUpdate(sql);

            return nextKey;
        }
    }
}
