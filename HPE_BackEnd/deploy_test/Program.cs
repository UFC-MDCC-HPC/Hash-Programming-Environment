using System;
using System.Collections.Generic;
using System.Text;
using DGAC.database;
using HPE_DGAC_LoadDB;
using System.IO;
using DGAC.utils;

namespace Back_End_Test
{
    class Program
    {

        static DGAC.BackEnd dgac = null;

        static void Main(string[] args)
        {
           
            string s = "h:\\runtime-workspace";

            string[] files1 = {  s + "\\jefferson.data\\Data.hpe",  
                                 s + "\\jefferson.data\\Number.hpe", 
                                 s + "\\jefferson.data\\Double.hpe", 
                                 s + "\\jefferson.datA\\Array1D.hpe", 
                                 s + "\\jefferson.data\\Array2D.hpe", 
                                 s + "\\jefferson.architecture\\Node.hpe", 
                                 s + "\\jefferson.architecture\\ANodeWindows.hpe", 
                                 s + "\\jefferson.architecture\\ANodeLinux.hpe", 
                                 s + "\\jefferson.architecture\\Cluster.hpe", 
                                 s + "\\jefferson.architecture\\ACastanhao.hpe", 
                                 s + "\\jefferson.environment\\Environment.hpe", 
                                 s + "\\jefferson.environment\\MPIBasic.hpe", 
                                 s + "\\jefferson.environment\\MPI.hpe", 
                                 s + "\\jefferson.qualifier\\PartitionStrategy.hpe",
                                 s + "\\jefferson.qualifier\\EqualPartition.hpe", 
                                 s + "\\jefferson.qualifier\\EqualPartitionByRows.hpe", 
                                 s + "\\jefferson.qualifier\\PlaceInRoot.hpe",
                                 s + "\\jefferson.qualifier\\Replicate.hpe", 
                                 s + "\\jefferson.data\\ParallelData.hpe", 
                                 s + "\\jefferson.computation\\VecVecProduct.hpe", 
                                 s + "\\jefferson.computation\\MatVecProduct.hpe" , 
                                 s + "\\jefferson.synchronizer\\RedistributeData.hpe", 
                                 s + "\\jefferson.computation\\AppExample.hpe" , 
                                 s + "\\jefferson.application\\AppExampleMain.hpe" 
                                   };
                

            string[] files2 = { s + "\\jefferson.data\\Impl\\DoubleImpl.hpe", 
                                 s + "\\jefferson.data\\Impl\\Array1DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.data\\Impl\\Array2DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.data\\Impl\\ParallelArray1DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.data\\Impl\\ParallelArray2DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.data\\Impl\\ReduceSumDoubleImpl.hpe", 
                                 s + "\\jefferson.data\\Impl\\ReplicatedArray1DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.architecture\\Impl\\ANodeWindowsImpl.hpe", 
                                 s + "\\jefferson.architecture\\Impl\\ANodeLinuxImpl.hpe", 
                                 s + "\\jefferson.architecture\\Impl\\CastanhaoImpl.hpe", 
                                 s + "\\jefferson.environment\\Impl\\MPIBasicImpl.hpe",  
                                 s + "\\jefferson.environment\\Impl\\MPIImpl.hpe", 
                                 s + "\\jefferson.computation\\Impl\\VecVecProductImpl.hpe",  
                                 s + "\\jefferson.computation\\Impl\\MatVecProductImpl.hpe" , 
                                 s + "\\jefferson.synchronizer\\Impl\\RedistributeArray1DUsingMPI.hpe", 
                                 s + "\\jefferson.computation\\Impl\\AppExampleImpl.hpe"  , 
                                 s + "\\jefferson.application\\Impl\\AppExampleMainImpl.hpe"
                                   };

            dgac = new DGAC.BackEnd();
            
            
             foreach (string ss in files1)
             {
                 runFile1(ss);
             }

             foreach (string ss in files2)
             {
                 runFile2(ss);
             }
              

            
          //  byte[] data = dgac.readEnvironmentTest();
        }

        static void runFile1(string filename)
        {

            // A FileStream is needed to read the XML document.
            FileStream fs = new FileStream(filename, FileMode.Open);            

            byte[] data = new byte[fs.Length];

            fs.Read(data,0,(int)fs.Length);
            
            deployAbstractComponent(data);

            fs.Close();

		    return;
	    }

        static void runFile2(string filename)
        {

            // A FileStream is needed to read the XML document.
            FileStream fs = new FileStream(filename, FileMode.Open);

            byte[] data = new byte[fs.Length];

            fs.Read(data, 0, (int)fs.Length);

            deployHashComponent(data);

            fs.Close();

            return;
        }


        public static String deployAbstractComponent(byte[] data)
        {
            string filename = "newConfig";
            string path = Constants.PATH_TEMP_WORKER + filename + ".xml";
            if (data != null)
            {
                FileUtil.saveByteArrayIntoFile(data, path);
                ComponentType c = LoaderApp.DeserializeObject(path);
                dgac.registerAbstractComponent(c);
            }

            return "ok";
        }


        public static String deployHashComponent(byte[] data)
        {
            string filename = "newConfig";
            string path = Constants.PATH_TEMP_WORKER + filename + ".xml";
            if (data != null)
            {
                FileUtil.saveByteArrayIntoFile(data, path);
                ComponentType c = LoaderApp.DeserializeObject(path);
                dgac.registerConcreteComponent(c);
            }

            return "ok";
        }
	
    }
}
