/*=============================================================
(c) all rights reserved
================================================================*/

using gov.cca;
using br.ufc.pargo.hpe.basic;
using System;

namespace br.ufc.pargo.hpe.ports
{

    public interface InitializePort : Port
    {
        void on_initialize();
      //  void initialize_slices();
      //  void post_initialize_slices();
        void after_initialize();
    }

}
