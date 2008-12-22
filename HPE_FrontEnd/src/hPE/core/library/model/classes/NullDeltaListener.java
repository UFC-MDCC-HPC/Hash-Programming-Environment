package hPE.core.library.model.classes;

import hPE.core.library.model.interfaces.IDeltaListener;

public class NullDeltaListener implements IDeltaListener {
	
	protected static NullDeltaListener soleInstance = new NullDeltaListener();
	
	public static NullDeltaListener getSoleInstance() {
		return soleInstance;
	}
	
	/*
	 * @see IDeltaListener#add(DeltaEvent)
	 */
	public void add(DeltaEvent event) {}

	/*
	 * @see IDeltaListener#remove(DeltaEvent)
	 */
	public void remove(DeltaEvent event) {}

}
