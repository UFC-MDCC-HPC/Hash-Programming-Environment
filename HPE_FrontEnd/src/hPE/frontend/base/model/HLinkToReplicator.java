package hPE.frontend.base.model;

import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class HLinkToReplicator implements Serializable, IPropertyChangeListener {

	private IPointsToReplicator replicated_element;
	static final long serialVersionUID = 1;
	
	private PropertyChangeSupport listeners = null;
	
	private PropertyChangeSupport getListeners() {
		if (listeners == null) listeners = new PropertyChangeSupport(this);
		return listeners;
	}
	
	private boolean permanent = false;
	
	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
	
	public boolean isPermanent() {
		return this.permanent;
	}
	
	public final static String PROPERTY_INVISIBLE = "PROPERTY_INVISIBLE";
	
	private boolean invisible = false;
	
	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
		getListeners().firePropertyChange(PROPERTY_INVISIBLE,null,which_replicator);
	}
	
	public boolean isInvisible() {
		return this.invisible;
	}
	
	
	public IPointsToReplicator getReplicated() {
		return replicated_element;
	}
	
	public HLinkToReplicator(IPointsToReplicator the_replicated, HReplicator the_replicator) {
		super();
		
		this.setWhich_replicator(the_replicator);
		this.replicated_element = the_replicated;
		the_replicator.addLink(this);
		
		listeners = new PropertyChangeSupport(this);
	}

	/**
	 * @uml.property   name="which_replicator"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="replicated_elements:hPE.base.model.HReplicator"
	 */
	private HReplicator which_replicator = null;

	/**
	 * Getter of the property <tt>which_replicator</tt>
	 * @return  Returns the which_replicator.
	 * @uml.property  name="which_replicator"
	 */
	public HReplicator getReplicator() {
		return this.which_replicator.getTopJoined();
	}

	public HReplicator getTheReplicator() {
		return this.which_replicator;
	}
	
	/**
	 
	 * Setter of the property <tt>which_replicator</tt>
	 * @param which_replicator  The which_replicator to set.
	 * @uml.property  name="which_replicator"
	 */
	protected void setWhich_replicator(HReplicator which_replicator) {
		this.which_replicator = which_replicator;
	}
	
	

	/**
	 */
	public boolean isReplicatorFactorDetermined() {
		return this.getReplicator().getFactor() != 0;
	}

	/**
	 */
	public int getReplicationFactor() {
	     return this.getReplicator().getFactor();
	}
	
	public void unlinkFromReplicator() {
 		 this.which_replicator.removeLink(this);
	}

	public boolean isExternalLink(HComponent theComponent) {
		
		IPointsToReplicator p = this.getReplicated();
		
		return p.getConfiguration() != null && (!theComponent.getAllInnerConfigurations().contains(p.getConfiguration()));
		
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		getListeners().addPropertyChangeListener(listener);
	}

	/* (non-Javadoc)
	 * @see hPE.model.IHPrimUnit#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		getListeners().removePropertyChangeListener(listener);
	}

	public void setReplicated(IPointsToReplicator r) {
		this.replicated_element.removeLinkToReplicator(this);
		this.replicated_element = r;
		r.addLinkToReplicator(this);
	}

	public void liftReplicator() {
		
		HUnitSlice s = (HUnitSlice) this.getReplicated();
		HReplicator r = this.getReplicator();
		HUnit sContainer = (HUnit) s.getUnit(); 
		
		List<HUnitSlice> urs = new ArrayList<HUnitSlice>(); 
		
		// look for unit slices that points to the replicator.
		for (HUnitSlice s_ : sContainer.getSlices()) {
			if (s_.isReplicatedByVarId(r.getVarId())) {
				urs.add(s_);
			}			
		}
		
	    try {				
	    	List<HReplicator> reps = new ArrayList<HReplicator>();
			HUnitSlice s_;
			for (int i=0;i<urs.size();i++) {
				s_ = urs.get(i);
				HReplicator r_  = s_.getReplicatorByVarId(r.getVarId());
				s_.unSetReplicator(r_);
				reps.add(r_);
			}
			for (int i=0;i<reps.size();i++) {
			   //if (!sContainer.isReplicatedBy(reps.get(i))) 
				   sContainer.setReplicator(reps.get(i),true);
			}
			
		} catch (HPEUnmatchingEnumeratorsException e) {
			HUnitSlice s_;
			for (int i=0;i<urs.size();i++) {
				s_ = urs.get(i);
				try { s_.setReplicator(r); } catch (HPEUnmatchingEnumeratorsException e2) {}
			}
		    JOptionPane.showMessageDialog(null, e.getMessage(),"Aborting Operation !", JOptionPane.ERROR_MESSAGE);			   
		}
		
	}

	private HEnumeratorComponent permutationComponent = null;
	

	public void setPermutation(HEnumeratorComponent c) {
		permutationComponent = c;
		getListeners().firePropertyChange(PROPERTY_INVISIBLE,null,which_replicator);
	}
	
	public void unsetPermutation() {
		permutationComponent = null;
		getListeners().firePropertyChange(PROPERTY_INVISIBLE,null,which_replicator);
	}

	public HEnumeratorComponent getPermutation() {
		return permutationComponent;
	}
	
}
