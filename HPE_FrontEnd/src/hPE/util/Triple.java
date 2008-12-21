package hPE.util;

import java.io.Serializable;

public class Triple<E1 extends Object, 
                    E2 extends Object, 
                    E3 extends Object> implements Serializable {

	E1 fst;
	E2 snd;
	E3 trd;
	
	public Triple(E1 fst, E2 snd, E3 trd) {
		super();
		this.fst = fst;
		this.snd = snd;
		this.trd = trd;
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
	
	public E3 trd() {
		return trd;
	}
	
	public String toString() {
		return fst.toString();
	}

}
