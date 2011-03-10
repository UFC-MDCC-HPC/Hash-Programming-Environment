package hPE.frontend.base.model;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import javax.swing.JOptionPane;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Color;
import org.eclipse.draw2d.ColorConstants;


import hPE.frontend.base.exceptions.HPEInvalidNameException;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IReplicator;
import hPE.frontend.kinds.enumerator.model.HEnumeratorComponent;


public class HReplicator  extends HVisualElement implements Serializable, HNamed, IReplicator {
	
	static final long serialVersionUID = 1;

	private PropertyChangeSupport listeners;
	
	public final static String PROPERTY_BOUNDS = "replicator_bounds";
	public final static String CHANGE_LINK = "change_link";
	public final static String EDIT_VARID = "edit_varid";
	
	public final static int default_width = 20; 
	public final static int default_heigth = 20; 
	
	private void init_replicator(HComponent configuration, Point where) {
		
		listeners = new PropertyChangeSupport(this);		
		this.setConfiguration(configuration);
		
		this.setBounds(new Rectangle(where,new Dimension(default_width,default_heigth)));
		
		HComponent c = configuration;
		
		List<HComponent> stack = new ArrayList<HComponent>();
		stack.add(c);
		
		while (stack.size()>0) {
	        c = stack.get(0);		
	        stack.remove(0);
	        c.newReplicator(this);
			for (HComponent s : c.getDirectParentConfigurations()) {
			      stack.add(0, s);
			}
		}
		
				
	}
	
	private String ref = null;
	
	public void setRef(String ref) {
		this.ref = ref.trim();
	}
	
	public String getRef() {
		if (ref == null) 
			ref = this.toString() + System.currentTimeMillis(); 
		return ref.trim();
	}
	
	public HReplicator(HComponent configuration, Point where) {
		super();
		init_replicator(configuration,where);
	}

	public HReplicator(HComponent configuration, HReplicatorSplit split, Point where) {
		super();
		this.parentSplit = split;
		init_replicator(configuration,where);
	}
	
	/**
	 * @uml.property   name="factor"
	 */
	private int factor = -1;

	/** 
	 * Getter of the property <tt>factor</tt>
	 * @return  Returns the factor.
	 * @uml.property  name="factor"
	 */
	public int getFactor() {
		return factor;
	}

	Rectangle savedBounds = null;
	
	/**
	 * Setter of the property <tt>factor</tt>
	 * @param factor  The factor to set.
	 * @uml.property  name="factor"
	 */
	public void setFactor(int factor) {
		if (factor <= 0) {
			JOptionPane.showMessageDialog(null, "Invalid Value (<=0) !","Invalid Enumerator Cardinality", JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.factor = factor;
		if (this.factor == 1) {
			this.savedBounds = this.getBounds().getCopy();
			this.setBounds(this.getBounds().setSize(10,10));
			this.setColor(ColorConstants.gray);
		} else {
			if (savedBounds != null)
				this.setBounds(savedBounds);
			else 
				this.setBounds(this.getBounds().setSize(default_heigth,default_width));
			this.setColor(ColorConstants.cyan);
		}
		
		for (HReplicator r : ((HComponent)this.getConfiguration().getTopConfiguration()).gettReplicators()) {
			if (r != this && r.getVarId().equals(this.getName2()) && r.getFactor() != factor && !r.getVarId().equals("*")) {
				r.setFactor(factor);
			}
		}
		
		listeners.firePropertyChange(EDIT_VARID, null, varid);
	}

	public void setUndeterminedFactor() {
		this.factor = -1;
		listeners.firePropertyChange(EDIT_VARID, null, varid);
		Iterator<HReplicator> rs = ((HComponent)this.getConfiguration()).gettReplicators().iterator();
		while (rs.hasNext()) {
			HReplicator r = rs.next();
			if (r != this && r.getVarId().equals(this.getName2()) && r.isDetermined()) {
				r.setUndeterminedFactor();
			}
		}
	}
	
	public boolean isDetermined() {
		return this.factor > 0;
	}

	/**
	 * @uml.property   name="configuration"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="replicators:hPE.base.model.HComponent"
	 */
	private List<HComponent> configuration = new ArrayList<HComponent>();

	/**
	 * Getter of the property <tt>configuration</tt>
	 * @return  Returns the configuration.
	 * @uml.property  name="configuration"
	 */ 
	public HComponent getConfiguration() {
		return configuration.get(0);
	}

	public HComponent getConfigurationWhereCreated() {
		return configuration.get(configuration.size() - 1);
	}

	public List<HComponent> getConfigurations() {
		return configuration;
	}
	
	/**
	 * Setter of the property <tt>configuration</tt>
	 * @param configuration  The configuration to set.
	 * @uml.property  name="configuration"
	 */
	public void setConfiguration(HComponent configuration) {		
		this.configuration.add(0, configuration);
	}

	/**
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.addPropertyChangeListener(listener);
	}

	/**
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
	}

	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		if (this != this.getTopJoined()) 
			this.getTopJoined().setBounds(bounds);
		
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
	}

	/**
	 * @uml.property  name="varid"
	 */
	private String varid = UNDEFINED_VAR;


	/**
	 * Getter of the property <tt>varid</tt>
	 * @return  Returns the varid.
	 * @uml.property  name="varid"
	 */
	public String getVarId() {
		return varid;
	}

	public void setVaridForced(String varid) {
		   this.varid = varid;
		   List<List<HReplicator>> rss = this.getAllMyJoined();
		   for (List<HReplicator> rs : rss) {
			   for (HReplicator r : rs) {
				   r.setVaridForced(varid);
			   }
		   }
		   listeners.firePropertyChange(EDIT_VARID, null, varid);		
	}
	
	/**
	 * Setter of the property <tt>varid</tt>
	 * @param varid  The varid to set.
	 * @uml.property  name="varid"
	 */public void setVarid(String varid) throws HPEInvalidNameException {
		 
		if (!this.isNewNameValid(varid)) 
			throw new HPEInvalidNameException("Enumerators with the same id must have the same cardinality !");  
		else { 
		   this.varid = varid;
		   
		   List<List<HReplicator>> rss = this.getAllMyJoined();
		   for (List<HReplicator> rs : rss) {
			   for (HReplicator r : rs) {
				   r.setVarid(varid);
			   }
		   }
		   
		   listeners.firePropertyChange(EDIT_VARID, null, varid);
		}
	}

	/**
	 * @uml.property  name="color"
	 */
	private MyColor color = new MyColor(ColorConstants.cyan);

	/**
	 * Getter of the property <tt>color</tt>
	 * @return  Returns the color.
	 * @uml.property  name="color"
	 */
	public Color getColor() {
		return color.getColor();
	}

	/**
	 * Setter of the property <tt>color</tt>
	 * @param color  The color to set.
	 * @uml.property  name="color"
	 */
	public void setColor(Color color) {
		this.color.setColor(color);
	}

	/**
	 * @uml.property  name="linksToMe"
	 */
	private Collection<HLinkToReplicator> linksToMe = new ArrayList<HLinkToReplicator>();

	/**
	 * Getter of the property <tt>linksToMe</tt>
	 * @return  Returns the linksToMe.
	 * @uml.property  name="linksToMe"
	 */
	public Collection<HLinkToReplicator> getLinksToMe() {
		
		List<IPointsToReplicator> rList = new ArrayList<IPointsToReplicator>();
		
		List<HLinkToReplicator> linksToMe = new ArrayList<HLinkToReplicator>();
		
		for (HLinkToReplicator link : this.linksToMe) {
			linksToMe.add(link);	
			rList.add(link.getReplicated());
		}
		
		
	
		for (List<HReplicator> rs : this.getAllMyJoined()) {
		    for (HReplicator r : rs) {
		    	for (HLinkToReplicator lr : r.getLinksToMe()) {
		    		if (/*!rList.contains(lr.getReplicated()) && */ !linksToMe.contains(lr)) {
		    			linksToMe.add(lr);
		    			rList.add(lr.getReplicated());
		    		}
		    	}
			}
		}
	
		return linksToMe;
	}

	public Collection<HLinkToReplicator> getDirectLinksToMe() {
	
		
		List<HLinkToReplicator> linksToMe = new ArrayList<HLinkToReplicator>();
		linksToMe.addAll(this.linksToMe);
		
		return linksToMe;
	}
	
	public void fireEventUpdateConnections() {
		listeners.firePropertyChange(CHANGE_LINK,null,varid);
	}
	
	/**
	 */
	public void addLink(HLinkToReplicator link) {
		this.linksToMe.add(link);
		fireEventUpdateConnections();
	}
	
	public void removeLink(HLinkToReplicator link) {
		this.linksToMe.remove(link);
		fireEventUpdateConnections();
	}
	
	public List<String> getOrigin() 
	{
		List<HComponent> cOfrs = new ArrayList<HComponent>(this.getConfigurations()); // ;
		cOfrs.remove(0);
		List<String> cRefs = new ArrayList<String>();
		HComponent cOfr_ = null;
		for (HComponent cOfr : cOfrs) {
			String ref = cOfr_ != null && cOfr.getSavedName().containsKey(cOfr_) ? cOfr.getSavedName().get(cOfr_) : cOfr.getRef();
			cRefs.add(ref);
			cOfr_ = cOfr;
		}
		return cRefs;
	}
	
	
	
	public String getName2() { 
		return this.getVarId(); 
		
	}
	
	public void setName(String name) throws HPEInvalidNameException{ 
		this.setVarid(name);
	}
	
	public void remove()
	{
		 for (HComponent c : this.getConfigurations()) 
			 c.unlinkReplicator(this);
		 
         ArrayList<HLinkToReplicator> l = new ArrayList<HLinkToReplicator>(this.getLinksToMe());

         for (HLinkToReplicator hr : l) 
        	 hr.getReplicated().unSetReplicator(this);
         
         for (HReplicatorSplit s : this.getSplits()) 
        	 for (HReplicator r : s.getReplicators()) 
        		 r.remove();
    	 
	}
	
	public Collection replicatedItems() {
	   List rs = new ArrayList();
	   for (HLinkToReplicator lr : this.linksToMe) {
           IReplicatedElement l = (IReplicatedElement) lr.getReplicated();
           rs.add(l);
       }
       return rs;
	}
		
	
	private List splits = new ArrayList();
	
	private HReplicatorSplit parentSplit = null;
	
	public HReplicatorSplit getParentSplit() {
		HReplicatorSplit split = this.parentSplit;
		for (HReplicator r : this.getMyJoined()) {
			if (split != null && r.getParentSplit() != split) {
				System.err.println("Fused replicators with different parent splits ... in getParentSplit of HReplicator");
			} else {
				split = r.getParentSplit();
			}
		}
		return split;
	}
	
	public HLinkToReplicator getParentSplitLink() {
		for (HLinkToReplicator l : this.getLinksToMe()) {
			if (l.getReplicated() == this.getParentSplit()) 
				return l;
		}
		return null;
	}
	
	public List<HLinkToReplicator> getSplitPath() {
		List<HLinkToReplicator> lrs = new ArrayList<HLinkToReplicator>();
		HReplicator r = this;
		while (r.getParentSplit() != null) {
			lrs.add(0,r.getParentSplitLink());
			r = r.getParentSplit().getOwnerReplicator();
		}
		
		return lrs;
	}
	
	public HReplicator getTopReplicator() {
		
		HReplicator r = this;
		HReplicatorSplit s = r.getParentSplit();
		while (s!=null) {
			r = s.getOwnerReplicator();
			s = r.getParentSplit();
		}
		
		return r;
	}
	
	
	public List<HReplicatorSplit> getSplits() {		
		
		return splits;
	}

	public final static String SPLIT = "split_replicator";
	
	public HReplicatorSplit split(int n, String splitter, List<HLinkToReplicator> links, HComponent context, HReplicatorSplit splitMainMain) {		
		
		HReplicatorSplit splitMain = new HReplicatorSplit(this,n,splitter,links,context, splitMainMain); 
		splits.add(splitMain);
		
		Collection<HReplicator> rs1 = splitMain.getReplicators();
		
		for (HReplicator s : this.getMyJoined()) {
			List<HLinkToReplicator> links_ = new ArrayList<HLinkToReplicator>();
			for (HLinkToReplicator l : links) {
				if (l.getReplicated().isReplicatedBy(s)) 
					links_.add(l);
			}
			if (!links_.isEmpty()) {
				s.split(n, splitter, links_, context, splitMain);
			}
		}
		
		listeners.firePropertyChange(SPLIT,null,varid);

		return splitMain;
	}
	

	public HReplicatorSplit split(int n, String splitter, HLinkToReplicator link, HComponent context, HReplicatorSplit splitMain) {		
		
		List<HLinkToReplicator> links = new ArrayList<HLinkToReplicator>();
		links.add(link);
		return split(n,splitter,links,context, splitMain);		
		
	}
	
	public void addSplit(HReplicatorSplit s) {
		splits.add(s);
		listeners.firePropertyChange(SPLIT,null,varid);
	}
	
	public void removeSplits() {

		Iterator ss = ((List)((ArrayList)this.getSplits()).clone()).iterator();
		while (ss.hasNext()) {
			HReplicatorSplit s = (HReplicatorSplit) ss.next();
			Iterator rs = ((List)((ArrayList)s.getReplicators()).clone()).iterator();
			boolean l = true;
			while (rs.hasNext() && l) {
				HReplicator r = (HReplicator) rs.next();
                if (r.hasLinks()) l = false;				
			}
			if (l) {
				Iterator rs2 = ((List)((ArrayList)s.getReplicators()).clone()).iterator();
				while (rs2.hasNext()) {
					HReplicator r = (HReplicator) rs2.next();
					r.remove();
				}
				this.removeSplit(s);
			} else {
				Iterator rs2 = ((List)((ArrayList)s.getReplicators()).clone()).iterator();
				while (rs2.hasNext()) {
					HReplicator r = (HReplicator) rs2.next();
					r.removeSplits();
				}
				
			}
			
		}
			
	}
	
	
	public void removeSplit(HReplicatorSplit s) {
		this.getSplits().remove(s);
		listeners.firePropertyChange(SPLIT,null,varid);        
	}
	
	public int numberOfLinks() {
		
		int i = 0;
		for (HLinkToReplicator l : this.getLinksToMe()) {
			if (!(l.getReplicated() instanceof HReplicatorSplit)) i++;
		}
		
		return i;
	}
	
	public boolean isSplitReplicator() {
		
		return this.numberOfLinks() < this.getLinksToMe().size();
		
	}
	
	public boolean hasLinks() {
	
		if (this.numberOfLinks() == 0) {
			if (this.getSplits().size() > 0) {
				for (HReplicatorSplit s : this.getSplits()) {
					for (HReplicator r : s.getReplicators()) {
						if (r.hasLinks()) return true;
					}
				}
				return false;
			} else return false;
		} /* else {
			Iterator ls = this.getLinksToMe().iterator();
			HReplicator ownerR = null;
		while (ls.hasNext()) {
				HLinkToReplicator l = (HLinkToReplicator) ls.next();
				
				if (!(l.getReplicated() instanceof HReplicatorSplit)) return true;
				   else ownerR = ((HReplicatorSplit) l.getReplicated()).getOwnerReplicator();				
			}
			
			if (!ownerR.hasLinks()) {
				Iterator ls2 = ((ArrayList)((ArrayList)this.getLinksToMe()).clone()).iterator();
				while (ls2.hasNext()) {
					HLinkToReplicator l = (HLinkToReplicator) ls2.next();
					l.unlinkFromReplicator();
				}
				return false;
			} else {
				return true;
			}
		}	*/
		return true;
	}

	private boolean hidden = false;
	
	public boolean getHidden() {
		return hidden || 
	    	    (!((HComponent) this.getConfiguration()).showUnitaryReplicators() 
		           && this.allSplitUnitaries());
	}
	
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
		listeners.firePropertyChange(HReplicator.PROPERTY_JOINED, null, varid);
		if (this.isJoined()) this.getJoined().setHidden(this.getJoined().getHidden());
	}
	
	public boolean pointsToSomeUnitOf(HComponent c) {
	    	
		for (HLinkToReplicator l : this.getLinksToMe()) {
			IPointsToReplicator p = l.getReplicated();
			if (p instanceof IHUnit) {
				IHUnit u = (IHUnit) p;
				if (c.getAllUnits().contains(u) && !u.getHidden()) 
					return true;
			}
		}
		
		for (HReplicatorSplit s : this.getSplits()) 
			for (HLinkToReplicator ll : s.getLinksToReplicators())
				if (ll.getReplicator().pointsToSomeUnitOf(c)) 
					return true;
		
		return false;
	}
	
    
    private List<HReplicator> myJoined = new ArrayList<HReplicator>();
    
	public final static String PROPERTY_JOINED = "PROPERTY_JOINED";

	public static final String UNDEFINED_VAR = "*";
	
	private Stack<List<HReplicator>> currentMyJoined  = null /* = new Stack() */; 
	
	private Map<HComponent,List<List<HReplicator>>> fusionContexts = new HashMap<HComponent,List<List<HReplicator>>>(); 
	
	public Stack<List<HReplicator>> getAllMyJoined() {
		if (currentMyJoined == null) { 
			currentMyJoined = new Stack<List<HReplicator>>();
			currentMyJoined.push(new ArrayList<HReplicator>());
		}
		return currentMyJoined;
	}
	
	public List<HReplicator> getMyJoined() {
		// if (this.myJoined == null) this.myJoined = new ArrayList();
		
		return getAllMyJoined().peek();
	}
		
	public List<List<HReplicator>> getFusionsInContext(HComponent c) {
		
		if (this.fusionContexts == null)
			return _getFusionsInContext(c);
		
		return this.fusionContexts.get(c);
		
/*		Stack<List<HReplicator>> gg = new Stack<List<HReplicator>>();
		
		List<List<HReplicator>> ll = this.currentMyJoined;
		for (List<HReplicator> l : ll) {
			if (this.fusionContexts.containsKey(l)) {
				HComponent cc = this.fusionContexts.get(l);
				if (c == cc) 
					gg.add(l);
			} 
		}
		
		
		return gg;*/
	}
	
	public Stack<List<HReplicator>> _getFusionsInContext(HComponent c) {

		Stack<List<HReplicator>> gg = new Stack<List<HReplicator>>();
		
		List<List<HReplicator>> ss = this.getAllMyJoined();
		for (List<HReplicator> rrs : ss) {
			boolean context = false;
			for (HReplicator r_ : rrs) {
				context = true;
				HComponent cOfr = (HComponent) r_.getConfiguration();
				if (!cOfr.isDirectSonOfTheTopConfiguration() && !cOfr.isTopConfiguration()) {
					context = false;
					break;
				}
			}
			if (context) 
				gg.add(rrs);
		}
		
		return gg;
	}
	
	public void newCurrentMyJoined(HComponent context) {
    	List<HReplicator> l = new ArrayList<HReplicator>();
    	this.getAllMyJoined().push(l);    	
		List<List<HReplicator>> ls = this.fusionContexts.containsKey(context) ? this.fusionContexts.get(context) : new ArrayList<List<HReplicator>>();
		ls.add(l);
		this.fusionContexts.put(context, ls);
	}
	
	private void deleteCurrentMyJoined() {
    	List<HReplicator> l = this.getAllMyJoined().pop();
    	this.fusionContexts.remove(l);
	}
	
    public void join(HReplicator r) {
    	this.getMyJoined().add(r);
    	r.setJoined(this);
		this.fireEventFusion();
		
		for (HReplicatorSplit split : r.getSplits()) {
			for (HReplicator rsplit : split.getReplicators()) {
				rsplit.fireEventUpdateConnections();
			}
		}
    }
    
    public void fireEventFusion() {
    	listeners.firePropertyChange(PROPERTY_JOINED,null,varid);
    }
    
    public void unjoin() {
    	
    	List<HReplicator> l = getMyJoined(); 
    	
    	for (HReplicator r : (List<HReplicator>)((ArrayList<HReplicator>)(((ArrayList<HReplicator>)l).clone()))) {
	    	l.remove(r);
	    	r.setJoined(null);
    	}
    	this.deleteCurrentMyJoined();
		listeners.firePropertyChange(PROPERTY_JOINED,null,varid);
    }
    
    private HReplicator joined = null;
    
    public void setJoined(HReplicator r) {
    	this.joined = r;
    	//this.fireEventFusion();
    }
    
    public HReplicator getJoined() {
    	return this.joined;
    }
    
    public HReplicator getTopJoined() {
    	HReplicator r = this;
    	while (r.isJoined()) {
    		r = r.getJoined();
    	}
    	return r;
    }
    
    public boolean isJoined() {
    	return this.getJoined() != null;
    }
    
    public enum ReplicatorOrigin {
    	USER_CREATION,
    	RECURSION_CREATION;
    }
    
    private ReplicatorOrigin origin = ReplicatorOrigin.USER_CREATION;
    
    private HComponent rec = null;
    
    public void setReplicatorOrigin(ReplicatorOrigin origin) {
    	this.origin = origin;
    }
    
    public ReplicatorOrigin getReplicatorOrigin() {
    	return this.origin;
    } 
    
	public Collection<HLinkToReplicator> getEnumeratedElementsByIndex(int i) {
	
		if (this.getSplits().size() > 0) {
		   HReplicatorSplit s = (HReplicatorSplit) this.getSplits().get(0);
		   Map<Integer,HLinkToReplicator> m = s.getSplitEnumeration();
		   Integer k = new Integer(i);
		   if (m.containsKey(k)) {
			   HLinkToReplicator l = m.get(k);
			   HReplicator r = l.getReplicator();
			   return r.getEnumeratedElementsByIndex(i);		   
		   } else {
			   return null;
		   }
		} else {
		  return this.getLinksToMe(); 
		}
		
	}

	public boolean isNewNameValid(String name) {
		
		for (HReplicator r : ((HComponent)this.getConfiguration()).gettReplicators()) {
			if (r != this && r.getVarId().equals(name) && r.getFactor() != this.getFactor()) {
				return false;
			}
		}
		
		return true;
	}

	public boolean isNewFactorValid(int factor) {
		
		Iterator<HReplicator> rs = ((HComponent)this.getConfiguration()).gettReplicators().iterator();
		while (rs.hasNext()) {
			HReplicator r = rs.next();
			if (r != this && r.getVarId().equals(this.getName2()) && r.isDetermined() && r.getFactor() != factor) {
				return false;
			}
		}
		
		return true;
	}
    
	public boolean isUnitaryAndNotShow() {
		HComponent c = (HComponent) this.getConfiguration().getTopConfiguration();
		return this.getFactor() == 1 && !c.showUnitaryReplicators();
	}
	
	public Map<String,Integer> getSynonyms(Integer i) {

		  Map<String,Integer> m = new HashMap<String,Integer>();
		  
		  HReplicator r = this;
		  
		  while (r.getParentSplit() != null) {
			  HReplicatorSplit s = r.getParentSplit(); 
		      HLinkToReplicator l = r.getParentSplitLink();
		      r = s.getOwnerReplicator();
		      Integer j = s.getOwnerReplicatorIndexFor(l,i);
		      m.put(r.getVarId(),j);
		      i = j;
		  }
		
		  return m;		
	}
	
	public HLinkToReplicator getLinkForItem(IPointsToReplicator p) {
		
		for (HLinkToReplicator l : this.getLinksToMe()) {
			if (l.getReplicated() == p) 
				return l;
		}
		
		return null;
	}

	public void setRec(HComponent rec) {
		this.rec = rec;
	}

	public HComponent getRec() {
		return rec;
	}
	
	
	public List<HReplicator> getFusionsClosureInCurrentContext() {
	   return this.getFusionsClosureInContext((HComponent)this.getConfiguration().getTopConfiguration());
	}

	public List<HReplicator> getFusionsClosureInContext(HComponent topC) {
		
		List<HReplicator> replicators = new ArrayList<HReplicator>();
		
		List<List<HReplicator>> rss =  this.getFusionsInContext(topC);
		
		if (rss != null) {
			for (List<HReplicator> rs : rss) {
				for (HReplicator r : rs) {
					replicators.add(r);
					List<HReplicator> rs_ = r.getFusionsClosureInContext(topC);
					replicators.addAll(rs_);
				}
			}	
		}
		
		
		return replicators;
	}
	
	public boolean allSplitUnitaries() {
		
		
		for (HReplicatorSplit split : this.getSplits()) {
			for (HReplicator r : split.getReplicators()) {
				if (r.getFactor() != 1) 
					return false;
			}
		}
		
		return this.getSplits().size() > 0;
	}

	public HComponent getConfigurationTop() {
		if (configuration.size() > 1) {
		   // It is an enumerator from an inner component. 
		   return this.configuration.get(1);
		} 
		else {
			// It is an enumerator from the top configuration
			return this.configuration.get(0);
		}
	}
	
}
