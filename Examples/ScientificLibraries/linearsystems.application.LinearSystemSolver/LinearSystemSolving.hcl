package linearsystems.application.LinearSystemSolver;

using linearsystems.library.facet.Solving;
using linearsystems.application.MatrixType;
using linearsystems.application.SolutionMethod;
using linearsystems.application.MatrixFormat;
using linearsystems.application.MatrixPreConditioner;
using linearsystems.application.Accelerator;
using linearsystems.application.Matrix;
using linearsystems.application.Vector;
using linearsystems.qualifier.Library;

/* The user selects a solver by setting up the context parameters. For some combination of actual context parameters,
there would be a implementation of LinearSystemSolver for some L (free variable). Thus, the implementation must determine the 
library to use for a given context, and not the programmer.
*/



computation LinearSystemSolver ["solution method" = SM:SolutionMethod,
                                "matrix type" = MT:MatrixType, 
                                "matrix format" = MF:MatrixFormat[MT],
                                "pre-conditioner" = PC:MatrixPreConditioner[MT, MF],
                                "accelerator" = AC:Accelerator[SM, MT, MF]] 
                                    (a, x, v, accelerator, preconditioner, library)
{
  enumerator n : Enumerator;

  // NOTE: the implementation of the facet is the implementation of the domain component.
  
  facet solving : Solving[@L]; 
  
  /* In the implementation, it can type solving with a valid subtype of Solving[@L], for some L, such as PETScSolving <: Solving[PETSc],
     in such way it can access the specific interface of PETSc for the facet Solving. If it applies the type Solving[PETSc], the system
     will look for an implementation that exposes only the default interface.
  */
  
  data a : Matrix["matrix type" = MT, "matrix format" = MF] (n*);
  data x : Vector (n*);
  data v : Vector (n*);
  computation accelerator : AC (n*);
  computation preconditioner : PC (n*, matrix = a);
  qualifier library : Library;
    
  unit solve 
  {
      slice i from n.index ;
      slice solving from solving.u;
      slice setup from setup.u;
      slice a from a.u;
      slice x from x.u;
      slice v from v.u;
      slice accelerator from accelerator.u;
      slice preconditioner from preconditioner.u;
  } 
} 