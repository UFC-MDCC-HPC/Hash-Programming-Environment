package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEInvalidNameException;


public interface HNamed {

	/**
	 */
	public abstract String getName2();

	/**
	 */
	public abstract void setName(String name) throws HPEInvalidNameException;

	public boolean isNewNameValid(String name);
}
