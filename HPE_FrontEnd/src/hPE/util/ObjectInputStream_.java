package hPE.util;

import hPE.frontend.base.model.HComponent;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ObjectInputStream_ extends ObjectInputStream {

	public ObjectInputStream_() throws IOException, SecurityException {
		// TODO Auto-generated constructor stub
	}

	private HComponent c = null;
	private NullObject nc = null;

	public ObjectInputStream_(InputStream arg0, HComponent c, NullObject nullObj) throws IOException {
		super(arg0);
		this.c = c;
		this.nc = nullObj;
		this.enableResolveObject(true);
	}

	public Object resolveObject(Object obj) throws IOException {

	    	if (obj instanceof NullObject) {
	    	   return this.c;
	    	} else     	
	    	   return super.resolveObject(obj);
	}
			
	
}
