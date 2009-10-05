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

            string[] files1 = {  s + "\\jefferson.data.Data\\Data.hpe",  
                                 s + "\\jefferson.data.Number\\Number.hpe", 
                                 s + "\\jefferson.data.Double\\Double.hpe", 
                                 s + "\\jefferson.data.Array1D\\Array1D.hpe", 
                                 s + "\\jefferson.data.Array2D\\Array2D.hpe", 
                                 s + "\\jefferson.architecture.Node\\Node.hpe", 
                                 s + "\\jefferson.architecture.ANodeWindows\\ANodeWindows.hpe", 
                                 s + "\\jefferson.architecture.ANodeLinux\\ANodeLinux.hpe", 
                                 s + "\\jefferson.architecture.Cluster\\Cluster.hpe", 
                                 s + "\\jefferson.architecture.ACastanhao\\ACastanhao.hpe", 
                                 s + "\\jefferson.environment.Environment\\Environment.hpe", 
                                 s + "\\jefferson.environment.MPIBasic\\MPIBasic.hpe", 
                                 s + "\\jefferson.environment.MPI\\MPI.hpe", 
                                 s + "\\jefferson.qualifier.PartitionStrategy\\PartitionStrategy.hpe",
                                 s + "\\jefferson.qualifier.EqualPartition\\EqualPartition.hpe", 
                                 s + "\\jefferson.qualifier.EqualPartitionByRows\\EqualPartitionByRows.hpe", 
                                 s + "\\jefferson.qualifier.PlaceInRoot\\PlaceInRoot.hpe",
                                 s + "\\jefferson.qualifier.Replicate\\Replicate.hpe", 
                                 s + "\\jefferson.data.ParallelData\\ParallelData.hpe", 
                                 s + "\\jefferson.computation.VecVecProduct\\VecVecProduct.hpe", 
                                 s + "\\jefferson.computation.MatVecProduct\\MatVecProduct.hpe" , 
                                 s + "\\jefferson.synchronizer.RedistributeData\\RedistributeData.hpe", 
                                 s + "\\jefferson.computation.AppExample\\AppExample.hpe" , 
                                 s + "\\jefferson.application.AppExampleMain\\AppExampleMain.hpe" 
                                   };
                

            string[] files2 = {  s + "\\jefferson.data.impl.DoubleImpl\\DoubleImpl.hpe", 
                                 s + "\\jefferson.qualifier.impl.EqualPartitionImpl\\EqualPartitionImpl.hpe", 
                                 s + "\\jefferson.qualifier.impl.EqualPartitionByRowsImpl\\EqualPartitionByRowsImpl.hpe", 
                                 s + "\\jefferson.qualifier.impl.PlaceInRootImpl\\PlaceInRootImpl.hpe",
                                 s + "\\jefferson.qualifier.impl.ReplicateImpl\\ReplicateImpl.hpe", 
                                 s + "\\jefferson.data.impl.Array1DOfDoubleImpl\\Array1DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.data.impl.Array2DOfDoubleImpl\\Array2DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.data.impl.ParallelArray1DOfDoubleImpl\\ParallelArray1DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.data.impl.ParallelArray2DOfDoubleImpl\\ParallelArray2DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.data.impl.ReduceSumDoubleImpl\\ReduceSumDoubleImpl.hpe", 
                                 s + "\\jefferson.data.impl.ReplicatedArray1DOfDoubleImpl\\ReplicatedArray1DOfDoubleImpl.hpe", 
                                 s + "\\jefferson.architecture.impl.ANodeWindowsImpl\\ANodeWindowsImpl.hpe", 
                                 s + "\\jefferson.architecture.impl.ANodeLinuxImpl\\ANodeLinuxImpl.hpe", 
                                 s + "\\jefferson.architecture.impl.CastanhaoImpl\\CastanhaoImpl.hpe", 
                                 s + "\\jefferson.environment.impl.MPIBasicImpl\\MPIBasicImpl.hpe",  
                                 s + "\\jefferson.environment.impl.MPIImpl\\MPIImpl.hpe", 
                                 s + "\\jefferson.computation.impl.VecVecProductImpl\\VecVecProductImpl.hpe",  
                                 s + "\\jefferson.computation.impl.MatVecProductImpl\\MatVecProductImpl.hpe" , 
                                 s + "\\jefferson.synchronizer.impl.RedistributeArray1DUsingMPI\\RedistributeArray1DUsingMPI.hpe", 
                                 s + "\\jefferson.computation.impl.AppExampleImpl\\AppExampleImpl.hpe"  , 
                                 s + "\\jefferson.application.impl.AppExampleMainImpl\\AppExampleMainImpl.hpe"
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
                dgac.registerAbstractComponent(c,null,null,null);
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
                dgac.registerConcreteComponent(c,null,null,null);
            }

            return "ok";
        }
	
    }
}
