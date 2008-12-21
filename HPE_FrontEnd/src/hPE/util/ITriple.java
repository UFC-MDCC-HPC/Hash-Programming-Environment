package hPE.util;

public interface ITriple<E1 extends Object, 
                         E2 extends Object, 
                         E3 extends Object>      {

	public abstract E1 fst();

	public abstract E2 snd();
	
	public abstract E3 trd();
	
}
