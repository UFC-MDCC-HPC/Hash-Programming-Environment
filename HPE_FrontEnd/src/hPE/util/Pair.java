package hPE.util;

import java.io.Serializable;


public class Pair<E1 extends Object, E2 extends Object> implements IPair<E1,E2>, Serializable {

	static final long serialVersionUID = -5132963503507457316L;
	
	E1 fst;
	E2 snd;
	
	public Pair(E1 fst, E2 snd) {
		super();
		this.fst = fst;
		this.snd = snd;
	}
	
	/* (non-Javadoc)
	 * @see hPE.util.IPair#fst()
	 */
	public E1 fst() {
		return fst;
	}

	/* (non-Javadoc)
	 * @see hPE.util.IPair#snd()
	 */
	public E2 snd() {
		return snd;
	}
	
	public String toString() {
		return fst.toString();
	}
	
	public boolean equals(Pair<E1,E2> p) {
		return fst.equals(p.fst) && snd.equals(p.snd); 
		
	}
	
}
