/*=============================================================
(c) all rights reserved
================================================================*/

using gov.cca;
using br.ufc.pargo.hpe.basic;
using System;

namespace br.ufc.pargo.hpe.ports
{

    public interface ReconfigurationAdvicePort : Port
    {
        void changePort(string portName);
    }

}
