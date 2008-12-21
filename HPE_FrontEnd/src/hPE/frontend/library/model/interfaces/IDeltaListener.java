package hPE.frontend.library.model.interfaces;

import hPE.frontend.library.model.classes.DeltaEvent;

public interface IDeltaListener {
	public void add(DeltaEvent event);
	public void remove(DeltaEvent event);
}
