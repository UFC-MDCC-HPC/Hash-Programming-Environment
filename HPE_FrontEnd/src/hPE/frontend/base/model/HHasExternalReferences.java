package hPE.frontend.base.model;

import hPE.frontend.base.dialogs.AddReferencesDialog.Reference;

import java.util.List;
import java.util.Set;

public interface HHasExternalReferences {

	public abstract void addExternalReferences(List<String> selectedReferences);
	public abstract void removeExternalReferences(List<String> selectedReferences);

	public abstract Set<String> getExternalReferences();

}