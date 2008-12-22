package hPE.frontend.kinds.activate.model.protocol;

import java.io.Serializable;

import hPE.frontend.base.interfaces.IActionPrimitiveWait;
import hPE.frontend.base.interfaces.ISemaphore;

public class HWaitAction extends hPE.frontend.kinds.activate.model.protocol.HPrimitiveAction  implements Serializable, IActionPrimitiveWait {

	static final long serialVersionUID = 1;

	/**
	 * @uml.property   name="semaphore"
	 * @uml.associationEnd   readOnly="true" multiplicity="(1 1)" inverse="wait_actions:hPE.model.computation.protocol.HSemaphore"
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
	public HWaitAction(HSemaphore semaphore, String label, HProtocol protocol) {
		super(label, protocol);
		this.semaphore = semaphore;
	}

	public HWaitAction(HSemaphore semaphore, String label) {
		super(label);
		this.semaphore = semaphore;
	}
	
	/**
	 */
	public HWaitAction(HSemaphore semaphore, String label, HCombinatorAction action_combinator) {
		super(label, action_combinator);
		this.semaphore = semaphore;
	}

}
