using br.ufc.pargo.hpe.kinds;
using linearsystems.library.basic.Library;
using System;

namespace linearsystems.library.HYPRE { 

public interface IHYPRE : BaseIHYPRE, ILibrary
{


} // end main interface 

public struct HYPRE_Solver {
    public IntPtr p;
}

public struct HYPRE_IJMatrix {
    public IntPtr p;
}

public struct HYPRE_IJVector {
    public IntPtr p;
}

public struct HYPRE_ParCSR_matrix {
    public IntPtr p;
}

public struct HYPRE_ParCRS_vector {
    public IntPtr p;
}


} // end namespace 
