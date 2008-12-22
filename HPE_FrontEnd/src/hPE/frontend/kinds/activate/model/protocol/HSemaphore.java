package hPE.frontend.kinds.activate.model.protocol;

import java.io.Serializable;

import hPE.frontend.base.interfaces.IProtocol;
import hPE.frontend.base.interfaces.ISemaphore;

public class HSemaphore  implements Serializable, ISemaphore {

	static final long serialVersionUID = 1;

	/**
	 * @uml.property   name="protocol"
	 * @uml.associationEnd   readOnly="true" inverse="semaphores:hPE.model.computation.protocol.HProtocol"
	 */
	private HProtocol protocol;

	/** 
	 * Getter of the property <tt>protocol</tt>
	 * @return  Returns the protocol.
	 * @uml.property  name="protocol"
	 */
	public IProtocol getProtocol() {
		return protocol;
	}


	
	/**
	 * Getter of the property <tt>name</tt>
	 * @return   Returns the name.
	 * @uml.property   name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @uml.property  name="name" readOnly="true"
	 */
	private String name = "";

	/**
	 */
	public HSemaphore(String name, HProtocol protocol) {
		super();
		this.name = name;
		this.protocol = protocol;
		protocol.addSemaphore(this);
		
	}

	
}
