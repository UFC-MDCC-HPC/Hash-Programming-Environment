using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using data.Function.TestingFunction;
using NINTLIB;

namespace data.impl.Function.TestingFunction { 

public class ITestingFunctionImpl : BaseITestingFunctionImpl, ITestingFunction
{

	public ITestingFunctionImpl() { 
	
	} 
	
	public object createNew() {
	   return new ITestingFunctionImpl();
	}
	
   public NINTLIB.IntegratingFunction F {get { return f;} }
	
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f01 {get {return NINTLIB.IntegratingFunctions.p01_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f02 {get {return NINTLIB.IntegratingFunctions.p02_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f03 {get {return NINTLIB.IntegratingFunctions.p03_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f04 {get {return NINTLIB.IntegratingFunctions.p04_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f05 {get {return NINTLIB.IntegratingFunctions.p05_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f06 {get {return NINTLIB.IntegratingFunctions.p06_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f07 {get {return NINTLIB.IntegratingFunctions.p07_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f08 {get {return NINTLIB.IntegratingFunctions.p08_f;}}
//   public NINTLIB.MultiPointsIntegratingFunction nintlib_f09 {get {return NINTLIB.IntegratingFunctions.p09_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f10 {get {return NINTLIB.IntegratingFunctions.p10_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f11 {get {return NINTLIB.IntegratingFunctions.p11_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f12 {get {return NINTLIB.IntegratingFunctions.p12_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f13 {get {return NINTLIB.IntegratingFunctions.p13_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f14 {get {return NINTLIB.IntegratingFunctions.p14_f;}}
/*   public NINTLIB.MultiPointsIntegratingFunction nintlib_f15 {get {return NINTLIB.IntegratingFunctions.p15_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f16 {get {return NINTLIB.IntegratingFunctions.p16_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f17 {get {return NINTLIB.IntegratingFunctions.p17_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f18 {get {return NINTLIB.IntegratingFunctions.p18_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f19 {get {return NINTLIB.IntegratingFunctions.p19_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f20 {get {return NINTLIB.IntegratingFunctions.p20_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f21 {get {return NINTLIB.IntegratingFunctions.p21_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f22 {get {return NINTLIB.IntegratingFunctions.p22_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f23 {get {return NINTLIB.IntegratingFunctions.p23_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f24 {get {return NINTLIB.IntegratingFunctions.p24_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f25 {get {return NINTLIB.IntegratingFunctions.p25_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f26 {get {return NINTLIB.IntegratingFunctions.p26_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f27 {get {return NINTLIB.IntegratingFunctions.p27_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f28 {get {return NINTLIB.IntegratingFunctions.p28_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f29 {get {return NINTLIB.IntegratingFunctions.p29_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f30 {get {return NINTLIB.IntegratingFunctions.p30_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f31 {get {return NINTLIB.IntegratingFunctions.p31_f;}}
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f32 {get {return NINTLIB.IntegratingFunctions.p32_f;}}*/
   public NINTLIB.MultiPointsIntegratingFunction nintlib_f33 {get {return NINTLIB.IntegratingFunctions.p33_f;}}

    //private static NINTLIB.MultiPointsIntegratingFunction f_ = NINTLIB.IntegratingFunctions.p33_f;

	public double f(double[] x)
	{
	     double[,] x_ = new double[1, x.Length];
	
	     int i = 0;
	     foreach (double e in x)
	           x_[0, i++] = e;
	
	     return nintlib_f33(x_)[0];
	}

}

}
