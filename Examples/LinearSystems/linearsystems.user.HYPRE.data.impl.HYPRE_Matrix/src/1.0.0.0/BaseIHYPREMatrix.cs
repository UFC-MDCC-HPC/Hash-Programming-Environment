/* Automatically Generated Code */

using System;
using br.ufc.pargo.hpe.backend.DGAC;
using br.ufc.pargo.hpe.basic;
using br.ufc.pargo.hpe.kinds;
using linearsystems.user.qualifier.SparseMatrix;
using linearsystems.library.HYPRE;
using linearsystems.user.qualifier.DoublePrecisionFPNumber;
using linearsystems.user.data.MatrixCSR;
using environment.messagepassing.MPICommunicator;
using linearsystems.library.HYPRE.domain.LSSDomainHYPRE;

namespace linearsystems.user.HYPRE.data.impl.HYPRE_Matrix { 

public abstract class BaseIHYPREMatrix<LIB, MPT, NUM, COM>: DataStructure, BaseIMatrixCSR<LIB, MPT, NUM, COM, ILSSDomainHYPRE<LIB, COM>>
where LIB:IHYPRE
where MPT:ISparseMatrix<LIB>
where NUM:IDoublePrecisionFPNumber
where COM:IMPICommunicator
{

protected MPT matrix_property = default(MPT);

protected MPT Matrix_property {
	set {
		this.matrix_property = value;
	}
}

		
protected NUM element_type = default(NUM);

protected NUM Element_type {
	set {
		this.element_type = value;
	}
}

protected ILSSDomainHYPRE<LIB, COM> lssdomain = null;

protected ILSSDomainHYPRE<LIB, COM> Lssdomain {
	set {
		this.lssdomain = value;
	}
}

protected COM comm = default(COM);

public COM Comm {
	set {
		this.comm = value;
		lssdomain.Comm = value;
	}
}
		

public BaseIHYPREMatrix() { 

} 

public static string UID = "0024000004800000940000000602000000240000525341310004000011000000e1aa2800e662464069c8a73761afc7dcf649f55926211adecb7ece83cad8695f1800d6d7aed9591e9b65b3d23158f4564c872dc2147bba1c7aff30c719adb9786bddeaa26fde51130202a41edf17f23a9fd50223d8fe1dbc6429d4b0991ff01b5f5fbf6988e058d25f6459ca605b901481e4a257578f75c4e49aa693433c97a2";

override public void createSlices() {
	base.createSlices();
	this.Element_type = (NUM) BackEnd.createSlice(this, UID,"numeric_type","element_type",new Type[] {});
	this.Matrix_property = (MPT) BackEnd.createSlice(this, UID,"matrix_property","matrix_property",new Type[] {typeof(LIB)});
	this.Lssdomain = (ILSSDomainHYPRE<LIB, COM>) BackEnd.createSlice(this, UID,"domain","lssdomain", null);
			
} 


}

}
