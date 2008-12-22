
package hPE.frontend.base.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import hPE.frontend.base.exceptions.HPEUnmatchingEnumeratorsException;
import hPE.frontend.base.interfaces.IConfiguration;
import hPE.frontend.base.interfaces.IInterface;
import hPE.frontend.base.interfaces.IReplicator;

import org.eclipse.draw2d.geometry.Rectangle;

public class HReplicatorSplit extends HVisualElement implements IPointsToReplicator,Serializable {

	static final long serialVersionUID = 1;
	
	private HReplicator ownerReplicator;
	private String splitter;
	private HComponent context = null;
	private int n;
	
	private List<HLinkToReplicator> splitLinks = null;
	
	public List<HLinkToReplicator> getSplitLinks() {
		return this.splitLinks;
	}
	
	public int getN() {
		return n;
	}
	
	public HReplicatorSplit(HReplicator ownerReplicator, int n, String splitter, List<HLinkToReplicator> links, HComponent context, HReplicatorSplit splitMain) {
		super();
		listeners = new PropertyChangeSupport(this);		
		this.ownerReplicator = ownerReplicator;
		this.splitter = splitter;
		this.context = context;
		this.splitLinks = links;
		this.n = n;
		this.setBounds(new Rectangle(0,0,10,10));
		if (splitMain == null) 
			createReplicators(n,links);
		else
			linkToReplicators(splitMain);
	}
	
	private void linkToReplicators(HReplicatorSplit splitMain) {

		for (HReplicator r : splitMain.getReplicators()) {
			this.setReplicator(r,true);
		}
		
	}

	public HReplicatorSplit(String splitter, List<HLinkToReplicator> links, HComponent context) {
		super();
		listeners = new PropertyChangeSupport(this);		
		this.splitter = splitter;
		this.context = context;
		this.splitLinks = links;
		this.n = n;
		this.setBounds(new Rectangle(0,0,10,10));
        setReplicators(links);		
	}
	
	public HComponent getContext() {
		return this.context;
	}
	
    private void setReplicators (List<HLinkToReplicator> links) {
    	IInterface i = null;
    	Rectangle b = null;
    	
    	for (HLinkToReplicator l : links) {
    		HReplicator r = l.getReplicator();
    		IHPrimUnit u = (IHPrimUnit) l.getReplicated();

    		// TODO: getBinding para getBindings ???
			HBinding binding = (HBinding) u.getBinding();
    		
    		if (u.isEntry() && u.getBinding() != null && binding.getPort() instanceof HPrimUnitStub) 
    			u = (IHPrimUnit) binding.getPort();
    		if (i==null) { 
    			i = u.getInterface();
    			b = u.getBounds();
    			this.ownerReplicator = new HReplicator((HComponent)u.getConfiguration(),this,r.getBounds().getCopy().translate(-20,-20).getLocation());		
    			this.getOwnerReplicator().addSplit(this);    		
    		}
    		else if (i==u.getInterface()) {
        		u.setBounds(b);        		
    		} else {
    			System.out.println("ERROR ! Trying to join units of different interfaces.");
    		}
    		this.setReplicator(r,true);
    		
    	}
    }
	
	public IConfiguration getConfiguration() {
		return this.ownerReplicator.getConfiguration();
	}
	
	public HReplicator getOwnerReplicator() {
		return ownerReplicator;
	}
	
	public String getSplitter() {
		return splitter;
	}

	//private Map<HLinkToReplicator, List<IHPrimUnit>> replicasMemory = new HashMap<HLinkToReplicator,List<IHPrimUnit>>();
	
	private void createReplicators(int n, List<HLinkToReplicator> links) {
		       
		for (int i=0;i<n;i++) {		
			int width = this.getOwnerReplicator().getBounds().width; 
			HReplicator r = new HReplicator((HComponent)this.getOwnerReplicator().getConfiguration().getTopConfiguration(),this,this.getOwnerReplicator().getBounds().getBottomLeft().getCopy().translate(i*(width+1),0));
            this.setReplicator(r,true);	
            
            for (HLinkToReplicator l : links) {
				IHPrimUnit u = (IHPrimUnit) l.getReplicated();
			    u.setCloneBySplit(this);
				this.addPrimarySplitElement(u);
				u = u.createReplica(i);
				
				try {
					u.setReplicator(r);
    		    } catch (HPEUnmatchingEnumeratorsException e) {
 			        System.err.println("Unexpected Exception !" + e.getMessage());
 		        }
			} 
		}
	}
	
	private List<IHPrimUnit> splitElements = new ArrayList<IHPrimUnit>();
	
	protected void addPrimarySplitElement(IHPrimUnit u) {
		if (!splitElements.contains(u)) splitElements.add(u);
	}
	
	public List<IHPrimUnit> getPrimarySplitElements() {
		return this.splitElements;
	}
	
	
	private PropertyChangeSupport listeners;
	
	public final static String PROPERTY_BOUNDS = "split_location";

	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		listeners.firePropertyChange(PROPERTY_BOUNDS,null,bounds);
	}

	
	/**
	 * @uml.property   name="linkToReplicator"
	 * @uml.associationEnd   multiplicity="(0 -1)" inverse="hComponent:hPE.base.model.HLinkToReplicator"
	 */
	private Collection<HLinkToReplicator> linksToReplicators  = new ArrayList<HLinkToReplicator>();

	/** 
	 * Getter of the property <tt>linkToReplicator</tt>
	 * @return  Returns the linkToReplicator.
	 * @uml.property  name="linkToReplicator"
	 */
	public List<HLinkToReplicator> getLinksToVisibleReplicators() {
		return (List<HLinkToReplicator>) linksToReplicators;
	}

	public List<HLinkToReplicator> getLinksToReplicators() {
		return (List<HLinkToReplicator>) linksToReplicators;
	}

	/**
	 */
	public List<HReplicator> getReplicators() {
		List<HReplicator> replicators = new ArrayList<HReplicator>();
		if (this.getLinksToReplicators().size() > 0) {
			for (HLinkToReplicator rl : this.getLinksToReplicators()) {
		    	HReplicator r = rl.getReplicator();
		    	replicators.add(r);
		    }
		}			
		return replicators;
	}

	public List<HReplicator> getTheReplicators() {
		List<HReplicator> replicators = new ArrayList<HReplicator>();
		if (this.getLinksToReplicators().size() > 0) {
			for (HLinkToReplicator rl : this.getLinksToReplicators()) {
		    	HReplicator r = rl.getTheReplicator();
		    	replicators.add(r);
		    }
		}			
		return replicators;
	}
	
	public final static String NEW_REPLICATOR = "NEW_REPLICATOR";
	
	public void setReplicator (HReplicator the_replicator, boolean permanent) {
		HLinkToReplicator linkToReplicator = new HLinkToReplicator(this,the_replicator);
		this.linksToReplicators.add(linkToReplicator);
		linkToReplicator.setPermanent(true);
		listeners.firePropertyChange(NEW_REPLICATOR,null,getBounds());
	}

	/**
	 */
	public void setReplicator(HReplicator the_replicator) {
		HLinkToReplicator linkToReplicator = new HLinkToReplicator(this,the_replicator);
		this.linksToReplicators.add(linkToReplicator);
		listeners.firePropertyChange(NEW_REPLICATOR,null,getBounds());
	}

	public void unSetReplicator(HReplicator which_replicator) {
		
		HLinkToReplicator link = findLink(which_replicator);
	    link.unlinkFromReplicator();
	    this.linksToReplicators.remove(link);
	
    }
	
	private HLinkToReplicator findLink(HReplicator which_replicator) {
		HLinkToReplicator link = null;
		Iterator ls = ((List) ((ArrayList) this.linksToReplicators).clone()).iterator();
		while (ls.hasNext()) {
			link = (HLinkToReplicator) ls.next();
			if (link.getReplicator() == which_replicator) return link;   		
		}
		return null;
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

	private Map<HLinkToReplicator,Map<Integer,Integer>> es = null;
	private Map<Integer,HLinkToReplicator> esRev = null;
	
	private void buildDefaultSplitEnumeration() {
		
		es = new HashMap<HLinkToReplicator,Map<Integer,Integer>>();
		esRev = new HashMap<Integer,HLinkToReplicator>();
		
		int f = this.getOwnerReplicator().getFactor();
		HReplicatorSplit parentSplit = this.getOwnerReplicator().getParentSplit();
		
		Integer[] es2 = {};
		if (parentSplit != null) { 
			es2 = (Integer[]) parentSplit.getSplitEnumeration().keySet().toArray();
		}
		
		Iterator<HLinkToReplicator> links = this.getLinksToVisibleReplicators().iterator();
		//int n = links.size();
		int n = 0;
		int k = 0;
		while (links.hasNext()) {
			HLinkToReplicator link = links.next();
			HReplicator r =link.getReplicator();
			int f2 = r.getFactor();
			for (int i=0; i<f2;i++) {
				int j = parentSplit == null ? i+k : es2[i+k];
				esRev.put(new Integer(j),link);
				
				Map<Integer,Integer> mes;
				if (es.containsKey(link)) {
					 mes = es.get(link);
				} else {
					 mes = new HashMap<Integer,Integer>();
					 es.put(link,mes);
				}
				mes.put(i,j);
				//es.put(link,j);
				
			}
			n++;
			k+=f2;
		}

	}
	
	public Map<HLinkToReplicator,Map<Integer,Integer>> getSplitEnumerationRev() {
		
		if (es == null && esRev == null) {
			this.buildDefaultSplitEnumeration();
		}
		return es;
	}
	
	public Map<Integer,HLinkToReplicator> getSplitEnumeration() {
		
		if (es == null && esRev == null) {
			this.buildDefaultSplitEnumeration();
		}
		return esRev;
	}
	
	public HReplicator getReplicatorByVarId(String v) {
		HLinkToReplicator link = null;
		Iterator ls = ((List) ((ArrayList) this.linksToReplicators).clone()).iterator();
		while (ls.hasNext()) {
			link = (HLinkToReplicator) ls.next();
			if (link.getReplicator().getName2().equals(v)) return link.getReplicator();   		
		}
		return null;
	}
	
	public Integer getOwnerReplicatorIndexFor(HLinkToReplicator l1, Integer n1) {
		
		Integer n2 = this.getSplitEnumerationRev().get(l1).get(n1);
		
		return n2;
	}

	@Override
	public boolean isReplicatedBy(IReplicator r) {
		// TODO Auto-generated method stub
		return (findLink((HReplicator)r) != null);
	}

	@Override
	public void addLinkToReplicator(HLinkToReplicator linkToReplicator) {
    	this.linksToReplicators.add(linkToReplicator);
		
	}

	@Override
	public void removeLinkToReplicator(HLinkToReplicator linkToReplicator) {
    	this.linksToReplicators.remove(linkToReplicator);
	}
	
}
