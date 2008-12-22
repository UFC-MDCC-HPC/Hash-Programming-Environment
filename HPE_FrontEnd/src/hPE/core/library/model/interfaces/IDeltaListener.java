package hPE.core.library.model.interfaces;

import hPE.core.library.model.classes.DeltaEvent;

public interface IDeltaListener {
	public void add(DeltaEvent event);
	public void remove(DeltaEvent event);
}
