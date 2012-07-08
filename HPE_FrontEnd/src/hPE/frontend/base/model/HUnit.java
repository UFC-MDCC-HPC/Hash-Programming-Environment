package hPE.frontend.base.model;

import hPE.frontend.base.commands.BindingCreateCommand;
import hPE.frontend.base.commands.LiftUnitCommand;
import hPE.frontend.base.exceptions.HPEAbortException;
import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;


public abstract class HUnit extends HPrimUnit 
                            implements IHUnit {

	static final long serialVersionUID = 1;

	
	/** 
	 * @uml.property name="unit_slice_abstractions"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="unit:hPE.model.HUnitSliceAbstraction"
	 */
	private List<HUnitSlice> unitSlices = null;

	/* (non-Javadoc)
	 * @see hPE.model.IHUnit#getSlices()
	 */
	public List<HUnitSlice> getSlices() {
		if (unitSlices == null) {
			unitSlices = new ArrayList<HUnitSlice>();
		}
		return unitSlices;
	}
	
	public List<HUnitSlice> getPorts() 
	{
		HUnit this_ = this;
		
		List<HUnitSlice> ports = new ArrayList<HUnitSlice>();
		HComponent c0 = (HComponent) this_.getConfiguration();
		
		{
			HComponent c0x = (HComponent) (c0.getSupplier() == null ? c0 : c0.getSupplier());
			
			if (c0x != c0) {
			   int index = c0.getUnits().indexOf(this);
			   this_ = (HUnit) c0x.getUnits().get(index);
			}
			 
			 List<HUnit> units = new ArrayList<HUnit>();
			
	  	     for (HUnitSlice us : this_.getSlices()) 
	  	     {  	    	 
	  	    	 HUnit u = (HUnit) us.getBinding().getEntry();
	  	    	 
	  	    	 HComponent c = (HComponent) u.getConfiguration();
	  	    	 
	  	    	 HComponent cTop = (HComponent) c.getTopConfiguration();
	  	    	HComponent c_  = cTop.getInnerComponentByName(c.getRef());
	  	    	 
	  	    	 //HComponent c_ = cTop.getExposedComponentByName(c.getRef());
	  	    	 
	  	    	 
	  	    	 // if ()	  	    	 
	  	    	 {	  	    		
		  	    	 if (c_ != null && (c.isPublic() || c.IsExposedFalsifiedContextTop())) 
		  	    	 {
		  	    		 ports.add(us);
		  	    		 units.add(u);
		  	    	 }
		  	    	 
		  	    	 for (HUnitSlice us_ : u.getPorts()) 
		  	    	 {
		  	    		 HUnit u_ = (HUnit)us_.getBinding().getEntry();
		  	    		 if (!units.contains(u_)) 
		  	    		 {
		  	    			 ports.add(us_);
		  	    		     units.add(u_);
		  	    		 }
		  	    	 }  	    	 
	  	    	 }
	  	     }
		}
		return ports; 
    } 
	

	/* (non-Javadoc)
	 * @see hPE.model.IHUnit#addUnitItem(hPE.model.HUnitSlice)
	 */
	public void addUnitSlice(HUnitSlice unit_slice_abstraction) {
		this.getSlices().add(unit_slice_abstraction);
		getListeners().firePropertyChange(ADD_UNIT_ITEM,null,unit_slice_abstraction);
	}
	
	public abstract HUnitSlice newSlice(IHUnit the_source, Point where) throws HPEAbortException; /* {
		return new HUnitSlice(this, the_source, where);
	}*/


    
    /**
	 * @uml.property   name="unit_slices"
	 * @uml.associationEnd   readOnly="true" multiplicity="(0 -1)" ordering="true" inverse="slice_of:hPE.model.HUnit"
	 */
/*	private List unit_slices; */

	/** 
	 * Getter of the property <tt>unit_slices</tt>
	 * @return  Returns the unit_slices.
	 * @uml.property  name="unit_slices"
	 */

	public HUnit(String name, HComponent configuration, HInterface which_interface) {
		super(name, configuration, which_interface);
	}

	
	public HUnit(String name, HComponent configuration) {
		super(name,configuration);		
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHUnit#createInterface(org.eclipse.draw2d.geometry.Point)
	 */
	public HInterface createInterface(Point location) throws HPEAbortException {
		return createInterfaceFromSlices(location);
	}
	
	
    protected abstract HInterface newInterface(HComponent c, HInterfaceSig s, IHPrimUnit unit, Point l) throws HPEAbortException ; /*{
		return new HInterface(c,s,unit,l);	
    	
    } */
    
    public void updatePorts() throws HPEAbortException {
    	Map<HUnitSlice,List<HPort>> newPorts = this.calculatePorts();
    	HInterface i =(HInterface) this.getInterface();
//    	if (i!=null) {
	    	HInterfaceSig is = i.getSignature();
	    	is.updatePorts(newPorts);
//   	}
    }
    

    public Map<HUnitSlice,List<HPort>> calculatePorts() throws HPEAbortException {
    	
	    Map<HUnitSlice,List<HPort>> ports = new HashMap<HUnitSlice,List<HPort>>();
	
	    Map<HUnitSlice,List<HUnitSlice>> lll = this.getExposedSlices();

	    Map<IHUnit,HPort> ll = new HashMap<IHUnit,HPort>();
	    
	    for (Entry<HUnitSlice,List<HUnitSlice>> e : lll.entrySet()) {
	    	HUnitSlice k = e.getKey(); 
	    	List<HUnitSlice> ss = e.getValue();
	    	List<HPort> ps = new ArrayList<HPort>();
	    	for (HUnitSlice s : ss) {
	    		HPort p = null;	 
	    		//checkFusionConsistency(s);
	    		if (ll.containsKey(s.getBinding().getEntry())) {
	    			p = ll.get(s.getBinding().getEntry());
	    		} else {
	    			p = new HPort();
	    			ll.put(s.getBinding().getEntry(), p);
	    		}
	    		p.addInterfaceSlice(null, (HInterfaceSlice)s.getInterfaceSlice());
	    		if (!ps.contains(p)) ps.add(p);
	    	}
            ports.put(k, ps);	    	
	    }
	    
	    return ports;
    }
    
    private void checkFusionConsistency(HUnitSlice s) throws HPEAbortException {
    	HBinding bb = s.getBinding();
    	int k = bb.getCloneId();
    	List<HBinding> bs = bb.getEntry().getBindings();
    	if (bs.size() > 1) {    		
    		
    		HPrimUnit lut = null;
    		HComponent lutC = null; 
    		for (HBinding b : bs) {
    			if (b.getCloneId() == k) {
	    			IBindingTarget bt = b.getPort();
	    			HUnitSlice uslice = (HUnitSlice) bt;
	    			
	    			Map<HPrimUnit, Integer> path = this.whatIsThePath(uslice);
	    			
	    			HPrimUnit ut = uslice.getUnit().getTopUnit(path);
	    			HComponent utC = (HComponent)ut.getConfiguration();
				    if (lut==null && lutC ==null) { 
				    	lut = ut;
				    	lutC = utC;
				    }
				    else if (!((ut == lut || 
				    		   (ut != lut && utC.isDirectSonOfTheTopConfiguration() && lutC.isDirectSonOfTheTopConfiguration()) ||
				    		   (ut != lut && (utC.isTopConfiguration() && lutC.isDirectSonOfTheTopConfiguration())) ||
				    		   (ut != lut && (utC.isDirectSonOfTheTopConfiguration() && lutC.isTopConfiguration()))))) 
				    	throw new HPEAbortException("Fusion Inconsistency !");
    			}
    		}
    	}    	
    }
    
	public Map<HPrimUnit, Integer> whatIsThePath(HUnitSlice uslice) {

		HashMap<HPrimUnit,Integer> path = null;
				
		for (HUnitSlice s : this.getSlices()) {
			if (s == uslice) 
				return path;
			else {
				HBinding b = s.getBinding();
				IHUnit u = b.getEntry();
				
				Map<HPrimUnit,Integer> path_s = u.whatIsThePath(uslice);
				if (path_s != null) {
					if (path == null) path = new HashMap<HPrimUnit,Integer>();
					path.putAll(path_s);
				}
			}
		}
		
		return path;
	}

    public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getInterfaceName() {
		if (this.getInterface() == null)
		  return interfaceName; 
		else 
			return this.getInterface().getName2();
	}

	private String interfaceName = null;
    
    

	protected HInterface createInterfaceFromSlices(Point location) throws HPEAbortException {

		    Map<HUnitSlice,List<HPort>> ports = this.calculatePorts();
	    
	    	HInterfaceSig isig = new HInterfaceSig(this,ports);
		    
			HInterface which_interface = newInterface((HComponent)this.getConfiguration(), isig, this, location); 
			//which_interface.addCompliantUnit(this);
			
			if (this.getInterfaceName() != null) {
				which_interface.setName(this.getInterfaceName());
			}
			
			// HInterface();
			Rectangle b = which_interface.getBounds();
			b.setBounds(this.getBounds());
			b.setLocation(location);
			which_interface.setBounds(b);
		    which_interface.setEditable(true);

			HLinkToInterface link_interface = new HLinkToInterface(this);
			link_interface.setWhich_interface(which_interface);
			this.setLinkToInterface(link_interface);
			
			this.hideInterface();
			this.showInterface();
			
  		    getListeners().firePropertyChange(PROPERTY_BOUNDS,null,this.getBounds());
  		    
  		    return which_interface;			
 		
	}

	
	/* (non-Javadoc)
	 * @see hPE.model.IHUnit#attachToInterface(hPE.model.HInterface)
	 */
	public void attachToInterface(HInterface i) {
		
		if (i instanceof HInterface) {
		
			HInterface which_interface = (HInterface) i;
			which_interface.addCompliantUnit(this);
			
			ArrayList unit_slices = (ArrayList) ((ArrayList) this.getSlices());
			ArrayList interface_slices = (ArrayList) ((ArrayList) which_interface.getSlices()); 
			
			sortByPosition(unit_slices);
			sortByPosition(interface_slices);	
			
			Iterator us = unit_slices.iterator();
			Iterator is = interface_slices.iterator();
			while (us.hasNext() && is.hasNext()) {			
				HUnitSlice uslice = (HUnitSlice) us.next();
				HInterfaceSlice islice = (HInterfaceSlice) is.next();
				
				if (uslice.matchesTo(islice)) {
					uslice.setInterfaceSlice(islice);
					islice.addCompliantUnitSlice(uslice);	
				} else {
		        	JOptionPane.showMessageDialog(null,
		        		    "Interfaces Does Not Match - ".concat(uslice.getInterface().getName(false,true)).concat(" vs ").concat(islice.getInterface().getName2()),
		        		    "Error",
		        		    JOptionPane.ERROR_MESSAGE);
				}
			}
	
		    super.attachToInterface(i);
		}
		else {
			System.out.println("ERROR: A composite unit cannot be attached to a primitive interface.");
			// ERROR 
		}
	}
	
	
	/* (non-Javadoc)
	 * @see hPE.model.IHUnit#detachFromInterface()
	 */
	public void detachFromInterface() {		
		
		ArrayList<HUnitSlice> unit_slices = (ArrayList<HUnitSlice>) ((ArrayList<HUnitSlice>) this.getSlices());
		
		for (HUnitSlice uslice : unit_slices) {
  		    uslice.unsetSlice_abstraction();  		    
		}

		super.detachFromInterface();
	}
	
	/* (non-Javadoc)
	 * @see hPE.model.IHUnit#matchForAttachment(hPE.model.HInterface)
	 */
	public boolean matchForAttachment(HHasExternalReferences i) {
		
		if (i instanceof HInterface) {
			
			HInterface which_interface = (HInterface) i;
		
			ArrayList unit_slices = (ArrayList) ((ArrayList) this.getSlices());
			ArrayList interface_slices = (ArrayList) ((ArrayList) which_interface.getSlices()); 
			
			if (unit_slices.size() != interface_slices.size()) return false;
			
			sortByPosition(unit_slices);
			sortByPosition(interface_slices);	
			
			Iterator us = unit_slices.iterator();
			Iterator is = interface_slices.iterator();
			while (us.hasNext() && is.hasNext()) {			
				HUnitSlice uslice = (HUnitSlice) us.next();
				HInterfaceSlice islice = (HInterfaceSlice) is.next();
				String y1 = uslice.getInterface().toString();
				String v2 = islice.getInterface().toString();
				if (!uslice.matchesTo(islice)) 
					return false;
			}
	
		    return true;
		    
		} else
		    return false;
	}
	

	/* (non-Javadoc)
	 * @see hPE.model.IHUnit#removeUnitItem(hPE.model.HUnitSlice)
	 */
	public void removeUnitSlice(HUnitSlice port) {
		this.getSlices().remove(port);
		port.getLinkToInterface().removeMe();
		HInterfaceSlice s = (HInterfaceSlice) port.getInterfaceSlice();
		if (s != null) {
			s.getInterfaceSig().removeSlice(s);
		}
		getListeners().firePropertyChange(ADD_UNIT_ITEM,null,port);
	}
	
	public List<HUnitSlice> getUnitSlices() {
		List<HUnitSlice> l = new ArrayList<HUnitSlice>();
		for (HBinding b : this.getBindings()) {
			if (b.getPort() instanceof HUnitSlice) {
				l.add((HUnitSlice)b.getPort());
			}
		}
		return l;
		
	}
	
	private void sortByPosition(ArrayList slices) {
 		
	      QuickSort(slices, 0, slices.size() - 1);	
	      
	}
	

	private void QuickSort(List a, int lo0, int hi0) 
	   {
	      int lo = lo0;
	      int hi = hi0;
	      Object mid;

	      if ( hi0 > lo0)
	      {

	         /* Arbitrarily establishing partition element as the midpoint of
	          * the array.
	          */
	         mid = a.get((lo0+hi0)/2);

	         // loop through the array until indices cross
	         while( lo <= hi )
	         {
	            /* find the first element that is greater than or equal to 
	             * the partition element starting from the left Index.
	             */
	            while( ( lo < hi0 ) && (greaterThan((IHVisualElement) mid, (IHVisualElement) a.get(lo))))
	               ++lo;

	            /* find an element that is smaller than or equal to 
	             * the partition element starting from the right Index.
	             */
	            while( ( hi > lo0 ) && (greaterThan((IHVisualElement) a.get(hi), (IHVisualElement) mid)))
	               --hi;

	            // if the indexes have not crossed, swap
	            if( lo <= hi ) 
	            {
	               swap(a, lo, hi);

	               ++lo;
	               --hi;
	            }
	         }

	         /* If the right index has not reached the left side of array
	          * must now sort the left partition.
	          */
	         if( lo0 < hi )
	            QuickSort( a, lo0, hi );

	         /* If the left index has not reached the right side of array
	          * must now sort the right partition.
	          */
	         if( lo < hi0 )
	            QuickSort( a, lo, hi0 );

	      }
	   }

	   private void swap(List a, int i, int j)
	   {
	      Object T;
	      T = a.get(i);
	      a.set(i,a.get(j));
	      a.set(j,T);
	   }

	   
	   private boolean greaterThan(IHVisualElement s1, IHVisualElement s2) {
		   
		   return (s1.getBounds().x > s2.getBounds().x) || (s1.getBounds().x == s2.getBounds().x && s1.getBounds().y > s2.getBounds().y);
		   
	   }
	   
	   /* (non-Javadoc)
	 * @see hPE.model.IHUnit#remove()
	 */
	public void remove() {
		   
		    super.remove();
		    
		    for (HUnitSlice item : this.getSlices()) {
		    	item.remove();
		    }
		    
			getListeners().firePropertyChange(REMOVE_UNIT, null, getName2()); //$NON-NLS-2$//$NON-NLS-1$  

	   }
	
		// OPEN SLICES
		
		List inner_slices = new ArrayList();		
		
		/* (non-Javadoc)
		 * @see hPE.model.IHUnit#lock()
		 */
		public void lock() {
			inner_slices = null;
		}
		
		/* (non-Javadoc)
		 * @see hPE.model.IHUnit#unlock()
		 */
		public void unlock() {
			inner_slices = new ArrayList();
		}
		
		/* (non-Javadoc)
		 * @see hPE.model.IHUnit#getInnerEntries()
		 */
		public List getInnerEntries() {
		    return inner_slices;	
		} 
	   
		/* (non-Javadoc)
		 * @see hPE.model.IHUnit#fetchCorrespondingUnit()
		 */
		public IUnit fetchCorrespondingUnit() {
			   return this;	
		}
		
	
	    
  public static void supersede (IHPrimUnit u_,  IHPrimUnit new_u_) {
	    
    	HInterface i = (HInterface) u_.getInterface();
    	HInterface new_i = (HInterface) new_u_.getInterface();
    	    	    	
    	if (i != null) {
    		try {
				((HUnit)new_u_).updatePorts();
			} catch (HPEAbortException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   	       adjustTheNewInterface(new_i, i);
    	}
    	    	
    	IHUnit u = (IHUnit) u_.getActualUnit();
    	IHUnit new_u = (HUnit)new_u_.getActualUnit();  	
    	
    	new_u_.setHidden(u.getHidden());	    	
    	new_u_.setSupersededName(u_.getName2());
    	
    	HComponent cTop = (HComponent) new_u.getConfiguration().getTopConfiguration();
    	
    	int n = u.getStubs().size();
    	for (int j=0; j<n; j++) {
    		HUnitStub s = u.getStubs().get(j);
    		IHUnit sNext = j < n-1 ? u.getStubs().get(j+1) : u;
    		
    		HComponent c1 = (HComponent)     s.getConfiguration();
    		HComponent c2 = (HComponent) new_u.getConfiguration();
    		List<HComponent> cc = HComponent.commonParent(c1,c2);
    		
    		HComponent ccc = (HComponent) sNext.getConfiguration();
    		
    		if (!cc.isEmpty() && cc.contains(ccc)) {
    		   c1.unlinkUnit(s);	    		   
    		   if (ccc != cTop) {
    		      c2.newStubFor((HUnit)new_u,false, false, ccc);
    		   }
    		   else {
    			   LiftUnitCommand lift = new LiftUnitCommand(new_u);
    			   if (lift.canExecute()) 
    				   lift.execute();
    			   else {
    				   System.err.println("ERROR (supersede lifting ...)");
    			   }
    		   }
    		}
    	}

	    
    	u.killMe();
    	
    	for (HBinding b : u.getBindings()) {
    	
	    	if (b != null && b.getEntry() != new_u.getActualUnit() && !(b.getPort() instanceof HUnitStub)) {
	    		
	    		// A UNIT SLICE HAS BEEN REACHED. OTHERWISE, THE UNIT HAS NOT BEEN EXPOSED YET (create binding).
	    		
		    	b.setEntry(new_u);
		    	new_u.addBinding(b);
		    	u.unsetBinding();                                // unset binding		    	
		    	
		    	IBindingTarget bt = (IBindingTarget) b.getPort();
		    	
		    	if (bt instanceof HUnitSlice) {
		    	
		    		HUnitSlice uSlice = (HUnitSlice) bt;
		    		
		    	    boolean v = uSlice.visibleInterface();
			    	  
		    	    HInterfaceSlice iSlice = ((HInterfaceSlice)uSlice.getInterfaceSlice());
		    	    if (iSlice != null) {
			    	    iSlice.setInterface(new_i); // Updating interface of interface slice		    	  
			    	    if (iSlice.IsDefaultName() && new_u.getBinding() != null) { 
			    	    	HUnitSlice uslice = (HUnitSlice) new_u.getBinding().getPort();
			    	    	if (uslice.getInterfaceSlice() != null) {
			    	    	  iSlice.setName(uslice.getInterfaceSlice().getName());
			    	    	}
			    	    }
		    	    } else {
		    	    	System.out.print(uSlice.getName());
		    	    }
		    	    
		    	    uSlice.hideInterface();
		    	    uSlice.setInterface(new_i); // Updating interface of unit slice
		            if (v) { 
		        	    uSlice.showInterface();
		            }
		    	    
		    	}
	    	}
    	}

    	for (HUnitSlice us : u.getSlices()) {
    		HBinding b = us.getBinding();
    		IHUnit uEntry = b.getEntry();
    		uEntry.removeBinding(b);
    	}
    	
    	
    	new_u.setBounds(u.getBounds().getCopy());
    		    		    	
    	for (HLinkToInterface l : new_i.getLinksToTheInterface()) {
			IHasInterface h = l.getLinked();
			h.notifyColorChange();
		}
    	
	    	
	    	
	    }
	    
	    private static void adjustTheNewInterface(HInterface new_i, HInterface i) {
	    	
	    	Map<String, Boolean> m = new HashMap<String, Boolean>();
	    	
	    	for (HInterfaceSlice is : i.getSlices()) {
	    		m.put(is.getName(), is.isInherited()); 
	    	}
	    	
	    	for (HInterfaceSlice is : new_i.getSlices()) {
	    	   if (m.containsKey(is.getName())) {
	    		   is.setInherited(m.get(is.getName()));
	    		   if (is.getMyPort() != null)
	    			   is.getMyPort().setInherited(true);
	    	   }	    	   
	    	}	    	
	    	
	    // FOI RETIRADO, mas n�o sei o efeito.
	    checkPortNames(new_i,i);
	
        }

		private static void checkPortNames(HInterface new_i, HInterface i) {
			Map<String, String> m = new HashMap<String,String>();
			for (HPort port : i.getPorts()) {
				m.put(port.getDefaultName(), port.getName());
			}
			for (HPort port : new_i.getPorts()) {
				if (m.containsKey(port.getDefaultName())) 
					port.setName(m.get(port.getDefaultName()));				
			}
			
			
		}

		private List<HUnitStub> stubs = new ArrayList<HUnitStub>(); //legacy
	    
	    private Map<HUnitStub, HComponent> stubsEnc = new HashMap<HUnitStub,HComponent>();
	    
	    public HComponent getStubEnc(HUnitStub stub) {
	    	if (stubsEnc == null) stubsEnc = new HashMap<HUnitStub,HComponent>();
	    	return stubsEnc.get(stub);
        }
	    
	    public void setStubEnc(HUnitStub stub, HComponent enc) {
	    	if (stubsEnc == null) stubsEnc = new HashMap<HUnitStub,HComponent>();
	    	stubsEnc.put(stub, enc);	    	
	    }
	    
	    public List<HUnitStub> getStubs() {
	    	if (stubs == null) stubs = new ArrayList<HUnitStub>();
	    	return stubs;
	    }
	    
	    public boolean hasStubs() {
	    	return !stubs.isEmpty();
	    }
	    
	    public void addStub(HUnitStub stub) {
	    	stubs.add(stub);	  
	    }
	    
	    public void removeStub(HUnitStub stub) {
	    	stubs.remove(stub);
	    }
	    
	    public HUnitStub getMostRecentStub() {
	    	return stubs.get(stubs.size()-1);
	    }
	    
	    private Rectangle savedBounds;
	    
	    public void saveBounds() {
	    	this.savedBounds = this.getBounds();
	    }
	    
	    public void loadSavedBounds() {
	    	this.setBounds(this.savedBounds);
	    }
	    
	//    public HUnitStub createStub() {
	 //   	return new HUnitStub(this);
	  //  }
	    
	    public HUnitStub createStub(HComponent enc) {
	    	return new HUnitStub(this,enc);
	    }
	    
	    public void hideSlices() {
	    	
	    	for (HUnitSlice s : this.getSlices()) {
	    		s.setHiddenSlice(true);
	    	}
	    	
	    }
	    
	    public void showSlices() {
	    	
	    	for (HUnitSlice s : this.getSlices()) {
	    		s.setHiddenSlice(false);
	    	}
	    	
	    }
	    
	    
	    public HPrimUnit createReplica(int shift) {
	    	HUnit u = (HUnit) super.createReplica(shift);
	    	u.stubs = new ArrayList<HUnitStub>(u.stubs);
	    	u.unitSlices = new ArrayList<HUnitSlice>();
	    	for (HUnitSlice s : this.getSlices()) {
	    		HBinding b = s.getBinding();
	    		Point where = s.getBounds().getLocation();
	    		IHUnit src = b.getEntry();
	    		IHUnit trg = u;
	    		BindingCreateCommand bcc = new BindingCreateCommand(src);
	    		bcc.setUnit(trg);
	    		bcc.setWhere(where);
	    		bcc.execute();
	    		HUnitSlice uSlice = (HUnitSlice) bcc.getBindingTarget();
	    		uSlice.getBinding().setCloneId(shift);
	    		if (s.getInterfaceSlice() != null) {
	    			uSlice.setInterfaceSlice(s.getInterfaceSlice());
	    		}
	    	}
	    	List<HBinding> bsR = new ArrayList<HBinding>();
	    	for (HBinding b : this.getBindings()) {
	    		if (b.getCloneId() == shift) {
	    			b.setCloneId(-1);
	    			bsR.add(b);
	    			b.setEntry(u);
	    			u.addBinding(b);
	    		}
	    	}
	    	this.getBindings().removeAll(bsR);
	    	
	    	return u;	    	
	    }
	    
	    public IHUnit getActualUnit() {
	    	return (IHUnit) super.getActualUnit();
	    }
	    



		public HUnitSlice lookForUnitSlice(String ref) {
	
			for (HUnitSlice s : this.getSlices()) {
				String name = s.getName();
				if (name.equals(ref)) 
					return s;				
			}
			
 			return null;
		}
	    
		public HUnitSlice lookForUnitSlice(String cRef, String sRef) {
			
			for (HUnitSlice s : this.getSlices()) {
				if (s.getBinding() != null) {
					IHUnit u = s.getBinding().getEntry();
					String cRef_ = u.getConfiguration().getRef();
					String sRef_ = u.getName2();
					if (cRef_.equals(cRef) && sRef_.equals(sRef)) 
						return s;				
				}
			}
			
 			return null;
		}
		
		public boolean isExposed() {
			
			HComponent c = null;
			
		    c = (HComponent)this.getConfiguration();
		    HComponent cc = (HComponent) c.getTopConfiguration();
		    
		    HComponent ccc = !c.getTopParentConfigurations().isEmpty() ? c.getTopParentConfigurations().get(0) : null;
			return ccc != null && (c.isPublic() || (!c.isPublic() && c.IsExposedFalsifiedContextTop()) || (!c.isPublic() && c.IsExposedFalsifiedContext(ccc) && ccc.isAbstractConfiguration() && cc.getWhoItImplements() == ccc));
			
			// (!c.isSuperType() && (c.isPublic() || (!c.isPublic() && c.IsExposedFalsifiedContextTop())))
			
			
		}
		
/*		public Map<HUnitSlice,List<HUnitSlice>> getExposedSlices() {
			
			Map<HUnitSlice,List<HUnitSlice>> l = new HashMap<HUnitSlice,List<HUnitSlice>>();
			
			List<HUnitSlice> sliceList = this.getSlices();
			Stack<HUnitSlice> stackSlices = new Stack<HUnitSlice>();
			stackSlices.addAll(sliceList);
			
			while (!stackSlices.isEmpty()) {
			//for (HUnitSlice s : sliceList) {
				HUnitSlice s = stackSlices.pop();
				IHUnit u = (IHUnit)s.getBinding().getEntry();
				if (u.isExposed()) {
					if (l.containsKey(s)) {
						List<HUnitSlice> _l = l.get(s);
						if (!_l.contains(s)) 
							_l.add(s);
					} else {
						List<HUnitSlice> _l = new ArrayList<HUnitSlice>();
						if (!_l.contains(s)) 
							_l.add(s);
						l.put(s, _l);
					}					
				}
				 
				Map<HUnitSlice,List<HUnitSlice>> exposedSlicesOf_u = u.getExposedSlices();
				for (Entry<HUnitSlice,List<HUnitSlice>> e : exposedSlicesOf_u.entrySet()) {
					//stackSlices.push(e.getKey());
					List<HUnitSlice> _l = e.getValue();
					if (l.containsKey(s)) {
						List<HUnitSlice> _ll = l.get(s);
						for (HUnitSlice _l_item : _l)
						   if (!_ll.contains(_l_item)) 
							   _ll.add(_l_item);
					} else {
						List<HUnitSlice> _ll = new ArrayList<HUnitSlice>();
						for (HUnitSlice _l_item : _l)
							   if (!_ll.contains(_l_item)) 
								   _ll.add(_l_item);
						l.put(s, _ll);
					}					
				}
			}
			
			return l;			
		}
*/
		
        public Map<HUnitSlice,List<HUnitSlice>> getExposedSlices() {
            
            Map<HUnitSlice,List<HUnitSlice>> l = new HashMap<HUnitSlice,List<HUnitSlice>>();
            
            for (HUnitSlice s : this.getSlices()) {
            	
            	    /* LOOK FOR SUPPLYING IF IT EXISTS ... */
                    IHUnit u = (IHUnit)s.getBinding().getEntry();
                    HComponent cu = (HComponent) u.getConfiguration();                    
                    HComponent cu_ = (HComponent) (cu.getSupplier() == null ? cu : cu.getSupplier());
                    IHUnit ux = cu_.getUnits().get(cu.getUnits().indexOf(u));
                    if (ux==null) {
                       System.err.print("unexpected behavior inside HUnit (getExposedSlices) - CHECK !");
                       ux = u;
                    }
                    
                    if (ux.isExposed()) 
                    {
                            if (l.containsKey(s)) {
                                    List<HUnitSlice> _l = l.get(s);
                                    if (!_l.contains(s)) _l.add(s);
                            } else {
                                    List<HUnitSlice> _l = new ArrayList<HUnitSlice>();
                                    if (!_l.contains(s)) _l.add(s);
                                    l.put(s, _l);
                            }
                    }
                    
                    if (ux == u) 
                    {
	                    for (Entry<HUnitSlice,List<HUnitSlice>> e : u.getExposedSlices().entrySet()) 
	                    {
                            List<HUnitSlice> _l = e.getValue();
                            if (l.containsKey(s)) 
                            {
                                List<HUnitSlice> _ll = l.get(s);
                                _ll.addAll(_l);
                            } else 
                            {
                                List<HUnitSlice> _ll = new ArrayList<HUnitSlice>();
                                _ll.addAll(_l);
                                l.put(s, _ll);
                            }                                       
	                    }
                    } 
                    else 
                    {
                    	HComponent c = (HComponent) u.getConfiguration();
                    	HComponent cx = (HComponent) ux.getConfiguration();
	                    for (Entry<HUnitSlice,List<HUnitSlice>> e : ux.getExposedSlices().entrySet()) 
	                    {
                            List<HUnitSlice> _l = e.getValue();
                            if (l.containsKey(s)) 
                            {
                                List<HUnitSlice> _ll = l.get(s);
                                for (HUnitSlice item  : _l) 
                                {
                                	HComponent cx_ = (HComponent) item.getBinding().getEntry().getConfiguration();
            						String n1 = cx_.getSavedName().get(cx);
            						HComponent cx_prime = c.getInnerComponent(n1);
            						if (cx_prime == null || cx_prime.isPublic())
            							_ll.add(item);
                                }
                            } else 
                            {
                                List<HUnitSlice> _ll = new ArrayList<HUnitSlice>();
                                for (HUnitSlice item  : _l) 
                                {
                                	HComponent cx_ = (HComponent) item.getBinding().getEntry().getConfiguration();
            						String n1 = cx_.getSavedName().get(cx);
            						HComponent cx_prime = c.getInnerComponent(n1);
            						if (cx_prime == null || cx_prime.isPublic())
            							_ll.add(item);
                                }
                                l.put(s, _ll);
                            }                                       
	                    }
                    }
                    
                    
            }
            
            return l;                       
    }
		
    private boolean is_multiple = true;
        
	@Override
	public boolean isMultiple() {		
		return is_multiple;
	}

	@Override
	public void setMultiple(boolean is_multiple) {
		this.is_multiple = is_multiple;
		getListeners().firePropertyChange(CHANGE_MULTIPLE,null,this.getBounds());	
	}
		


}
