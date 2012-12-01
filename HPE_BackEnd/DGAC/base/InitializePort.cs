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
        void initialize();
      //  void initialize_slices();
      //  void post_initialize_slices();
        void post_initialize();
    }

}
