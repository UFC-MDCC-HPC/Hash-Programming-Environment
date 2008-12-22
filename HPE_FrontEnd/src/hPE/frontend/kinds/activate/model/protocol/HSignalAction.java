package hPE.frontend.kinds.activate.model.protocol;

import java.io.Serializable;

import hPE.frontend.base.interfaces.IActionPrimitiveSignal;
import hPE.frontend.base.interfaces.ISemaphore;

public class HSignalAction extends hPE.frontend.kinds.activate.model.protocol.HPrimitiveAction  implements Serializable, IActionPrimitiveSignal {

	static final long serialVersionUID = 1;

	/**
	 * @uml.property   name="semaphore"
	 * @uml.associationEnd   readOnly="true" multiplicity="(1 1)" inverse="signal_actions:hPE.kinds.computation.model.protocol.HSemaphore"
	 */
	private HSemaphore semaphore = null ;

	/** 
	 * Getter of the property <tt>semaphore</tt>
	 * @return  Returns the semaphore.
	 * @uml.property  name="semaphore"
	 */
	public ISemaphore getSemaphore() {
		return semaphore;
	}

	
	/**
	 */
	public HSignalAction(HSemaphore semaphore, String label) {
		super(label);
		this.semaphore = semaphore;
	}

	public HSignalAction(HSemaphore semaphore, String label, HProtocol protocol) {
		super(label, protocol);
		this.semaphore = semaphore;
	}

	/**
	 */
	public HSignalAction(HSemaphore semaphore, String label, HCombinatorAction action_combinator) {
		super(label, action_combinator);
		this.semaphore = semaphore;
	}

}
