using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.library.PETSc.facet.PETScVector;
using linearsystems.library.PETSc.facet.PETScSetup;
using linearsystems.library.PETSc.facet.PETScMatrix;
using linearsystems.library.PETSc.facet.PETScPreConditioner;
using linearsystems.library.PETSc.facet.PETScSolver;
using linearsystems.library.basic.domain.LSSDomain;

namespace linearsystems.library.PETSc.domain.impl.LSSDomainPETSc { 

public class LSSDomainPETSc<V, S, M, P, R> : BaseLSSDomainPETSc<V, S, M, P, R>, ILSSDomain<V, S, M, P, R>
where V:IPETScVector
where S:IPETScSetup
where M:IPETScMatrix
where P:IPETScPreConditioner
where R:IPETScSolver
{

public LSSDomainPETSc() { 

} 


}

}
