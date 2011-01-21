using br.ufc.pargo.hpe.kinds;
using System;

namespace common.data.ProblemDefinition { 

public class Constants 
{

  public static double tx1, tx2, tx3, ty1, ty2, ty3, tz1, tz2, tz3,
		  dx1, dx2, dx3, dx4, dx5, dy1, dy2, dy3, dy4,
		  dy5, dz1, dz2, dz3, dz4, dz5, dssp, dt,
		  dxmax, dymax, dzmax, xxcon1, xxcon2,
		  xxcon3, xxcon4, xxcon5, dx1tx1, dx2tx1, dx3tx1,
		  dx4tx1, dx5tx1, yycon1, yycon2, yycon3, yycon4,
		  yycon5, dy1ty1, dy2ty1, dy3ty1, dy4ty1, dy5ty1,
		  zzcon1, zzcon2, zzcon3, zzcon4, zzcon5, dz1tz1,
		  dz2tz1, dz3tz1, dz4tz1, dz5tz1, dnxm1, dnym1,
		  dnzm1, c1c2, c1c5, c3c4, c1345, conz1, c1, c2,
		  c3, c4, c5, c4dssp, c5dssp, dtdssp, dttx1, bt,
		  dttx2, dtty1, dtty2, dttz1, dttz2, c2dttx1,
		  c2dtty1, c2dttz1, comz1, comz4, comz5, comz6,
		  c3c4tx3, c3c4ty3, c3c4tz3, c2iv, con43, con16;

		
   public static double[,] ce ={{2.0d,1.0d,2.0d,2.0d,5.0d},
		                     {0.0d,0.0d,2.0d,2.0d,4.0d},
		                     {0.0d,0.0d,0.0d,0.0d,3.0d},
		                     {4.0d,0.0d,0.0d,0.0d,2.0d},
		                     {5.0d,1.0d,0.0d,0.0d,0.1d},
		                     {3.0d,2.0d,2.0d,2.0d,0.4d},
		                     {0.5d,3.0d,3.0d,3.0d,0.3d},
		                     {0.02d,0.01d,0.04d,0.03d,0.05d},
		                     {0.01d,0.03d,0.03d,0.05d,0.04d},
		                     {0.03d,0.02d,0.05d,0.04d,0.03d},
		                     {0.5d,0.4d,0.3,0.2d,0.1d},
		                     {0.4d,0.3d,0.5,0.1d,0.3d},
		                     {0.3d,0.5d,0.4,0.3d,0.2d}};

		
  public void set_constants(int ndid, int[] grid_points)
  {			
			
	ce[0,0] = 2.0d * (1.0d + ((double)ndid) * 0.01d);
	//    ce[0]=2.0;

	c1 = 1.4d;
	c2 = 0.4d;
	c3 = 0.1d;
	c4 = 1.0d;
	c5 = 1.4d;

	bt = Math.Sqrt(0.5d);

	dnxm1 = 1.0d / (grid_points[0] - 1);
	dnym1 = 1.0d / (grid_points[1] - 1);
	dnzm1 = 1.0d / (grid_points[2] - 1);

	c1c2 = c1 * c2;
	c1c5 = c1 * c5;
	c3c4 = c3 * c4;
	c1345 = c1c5 * c3c4;

	conz1 = (1.0d - c1c5);

	tx1 = 1.0d / (dnxm1 * dnxm1);
	tx2 = 1.0d / (2.0d * dnxm1);
	tx3 = 1.0d / dnxm1;

	ty1 = 1.0d / (dnym1 * dnym1);
	ty2 = 1.0d / (2.0d * dnym1);
	ty3 = 1.0d / dnym1;

	tz1 = 1.0d / (dnzm1 * dnzm1);
	tz2 = 1.0d / (2.0d * dnzm1);
	tz3 = 1.0d / dnzm1;

	dx1 = 0.75d;
	dx2 = 0.75d;
	dx3 = 0.75d;
	dx4 = 0.75d;
	dx5 = 0.75d;

	dy1 = 0.75d;
	dy2 = 0.75d;
	dy3 = 0.75d;
	dy4 = 0.75d;
	dy5 = 0.75d;

	dz1 = 1.0d;
	dz2 = 1.0d;
	dz3 = 1.0d;
	dz4 = 1.0d;
	dz5 = 1.0d;

	dxmax = dmax1(dx3, dx4);
	dymax = dmax1(dy2, dy4);
	dzmax = dmax1(dz2, dz3);

	dssp = 0.25d * dmax1(dx1, dmax1(dy1, dz1));

	c4dssp = 4.0d * dssp;
	c5dssp = 5.0d * dssp;

	dttx1 = dt * tx1;
	dttx2 = dt * tx2;
	dtty1 = dt * ty1;
	dtty2 = dt * ty2;
	dttz1 = dt * tz1;
	dttz2 = dt * tz2;

	c2dttx1 = 2.0d * dttx1;
	c2dtty1 = 2.0d * dtty1;
	c2dttz1 = 2.0d * dttz1;

	dtdssp = dt * dssp;

	comz1 = dtdssp;
	comz4 = 4.0d * dtdssp;
	comz5 = 5.0d * dtdssp;
	comz6 = 6.0d * dtdssp;

	c3c4tx3 = c3c4 * tx3;
	c3c4ty3 = c3c4 * ty3;
	c3c4tz3 = c3c4 * tz3;

	dx1tx1 = dx1 * tx1;
	dx2tx1 = dx2 * tx1;
	dx3tx1 = dx3 * tx1;
	dx4tx1 = dx4 * tx1;
	dx5tx1 = dx5 * tx1;

	dy1ty1 = dy1 * ty1;
	dy2ty1 = dy2 * ty1;
	dy3ty1 = dy3 * ty1;
	dy4ty1 = dy4 * ty1;
	dy5ty1 = dy5 * ty1;

	dz1tz1 = dz1 * tz1;
	dz2tz1 = dz2 * tz1;
	dz3tz1 = dz3 * tz1;
	dz4tz1 = dz4 * tz1;
	dz5tz1 = dz5 * tz1;

	c2iv = 2.5d;
	con43 = 4.0d / 3.0d;
	con16 = 1.0d / 6.0d;

	xxcon1 = c3c4tx3 * con43 * tx3;
	xxcon2 = c3c4tx3 * tx3;
	xxcon3 = c3c4tx3 * conz1 * tx3;
	xxcon4 = c3c4tx3 * con16 * tx3;
	xxcon5 = c3c4tx3 * c1c5 * tx3;

	yycon1 = c3c4ty3 * con43 * ty3;
	yycon2 = c3c4ty3 * ty3;
	yycon3 = c3c4ty3 * conz1 * ty3;
	yycon4 = c3c4ty3 * con16 * ty3;
	yycon5 = c3c4ty3 * c1c5 * ty3;

	zzcon1 = c3c4tz3 * con43 * tz3;
	zzcon2 = c3c4tz3 * tz3;
	zzcon3 = c3c4tz3 * conz1 * tz3;
	zzcon4 = c3c4tz3 * con16 * tz3;
	zzcon5 = c3c4tz3 * c1c5 * tz3;
  }
		
  public double dmax1(double a, double b)
  {
		if (a < b) return b; else return a;
  }

  public double dmax1(double a, double b, double c, double d)
  {
		return dmax1(dmax1(a, b), dmax1(c, d));
  }		
	
}
	
	
public interface IProblemDefinition : BaseIProblemDefinition
{
		
  int NCells { get; }
		
  double [,,,,] Field_u       { get; }	
  double [,,,,] Field_rhs     { get; }	
  double [,,,,] Field_lhs     { get; }	
  double [,,,,] Field_forcing { get; }	
		
  double [,,,,] Field_us      { get; }	
  double [,,,,] Field_vs      { get; }	
  double [,,,,] Field_ws      { get; }	
  double [,,,,] Field_qs      { get; }	
  double [,,,,] Field_ainv    { get; }	
  double [,,,,] Field_rho     { get; }	
  double [,,,,] Field_speed   { get; }	
  double [,,,,] Field_square  { get; }	

  void initialize_problem_data(char clss);
		
  void initialize(); // computes initial u
  void lhsinit();    // computes initial lhs
  void exact_rhs();  // computes forcing
  // void exact_solution(double xi, double eta, double zeta, double[] dtemp, int offset); // auxiliar ...

} // end main interface 

} // end namespace 
