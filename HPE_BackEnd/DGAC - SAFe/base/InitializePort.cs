/*=============================================================
(c) all rights reserved
================================================================*/

using gov.cca;
using br.ufc.pargo.hpe.basic;
using System;
using System.ServiceModel;

namespace br.ufc.pargo.hpe.ports
{
    public interface InitializePort : Port
    {
        void on_initialize();

     	void after_initialize();
    }

}
