package hPE.util;

import hPE.frontend.base.model.HComponent;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStream_ extends ObjectOutputStream {

	public ObjectOutputStream_() throws IOException, SecurityException {
	}

	private HComponent c = null;
	private NullObject nc = null;
	
	public ObjectOutputStream_(OutputStream arg0, HComponent c, NullObject nullObj) throws IOException {
		super(arg0);
		this.enableReplaceObject(true);
		this.c = c;
		this.nc = nullObj;
	}

    public Object replaceObject(Object obj) throws IOException {

    	if (obj == c) {
    	   //System.err.println(c.getName2());
    	   return this.nc;
    	} else     	
    	   return super.replaceObject(obj);
    }
	
    
    
}
