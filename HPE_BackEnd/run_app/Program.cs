using System;
using System.Collections.Generic;
using System.Text;
using br.ufc.pargo.hpe.backend.DGAC.database;
using HPE_DGAC_LoadDB;
using System.IO;
using br.ufc.pargo.hpe.backend.DGAC.utils;

namespace Back_End_Test
{
    class Program
    {

        static br.ufc.pargo.hpe.backend.DGAC.BackEnd dgac = null;

        static void Main(string[] args)
        {
           
            dgac = new br.ufc.pargo.hpe.backend.DGAC.BackEnd();
            
            
          //  byte[] data = dgac.readEnvironmentTest();
        }

	
    }
}
