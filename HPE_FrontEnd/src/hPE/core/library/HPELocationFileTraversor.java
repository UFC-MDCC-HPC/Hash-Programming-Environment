package hPE.core.library;


import com.sun.org.apache.xerces.internal.parsers.DOMParser;  
import com.sun.org.apache.xerces.internal.dom.TreeWalkerImpl;
import com.sun.org.apache.xerces.internal.dom.DocumentImpl;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeFilter;

import hPE.HPEProperties;

import java.util.List;
import java.util.ArrayList;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public class HPELocationFileTraversor {

	
	private String locationPath;

	protected class AllElements implements NodeFilter
	{
		  public short acceptNode (Node n)
		  {
		    if (n.getNodeType() == Node.ELEMENT_NODE)
		      return FILTER_ACCEPT;
		    else if (n.getNodeType() == Node.ATTRIBUTE_NODE)
		    	return FILTER_ACCEPT;
		    return FILTER_SKIP;
		  }
		}
	
	public HPELocationFileTraversor() {
		this.locationPath = lookForLocationPath();		
	}
	
    public List fetchLocations() {
    	
    	List locations = new ArrayList();
    	
        try {
            DOMParser parser = new DOMParser();
         //   locationPath = "f:\\runtime-workspace";
            String path = (new Path(locationPath)).toOSString(); 
            parser.parse(path);
            DocumentImpl document = (DocumentImpl) parser.getDocument();
//            traverse(document.getLastChild());
            
            //get the root of the XML document
            Node root = document.getLastChild();

            //instantiate the filter object
            AllElements allelements = new AllElements();

            //create an object of the TreeWalker implementation class
            TreeWalkerImpl tw =
               (TreeWalkerImpl)document.createTreeWalker(root,
                  NodeFilter.SHOW_ALL, (NodeFilter)allelements, true);

            //print the elements of the TreeWalker implementation class
            traverse(tw,locations);
            
            
            
        } catch (org.xml.sax.SAXParseException spe) {
        } catch (org.xml.sax.SAXNotRecognizedException ex ){
        } catch (org.xml.sax.SAXNotSupportedException ex ){
        } catch (org.xml.sax.SAXException se) {
            if (se.getException() != null)
                se.getException().printStackTrace(System.err);
            else
                se.printStackTrace(System.err);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    	
        return locations;
    	
    	
    }
        
    private String lookForLocationPath() {
        
		return HPEProperties.getInstance().getValue("core_locations");
    	
    }
    
    //traverses the tree structure representation
    public static void traverse(TreeWalkerImpl tw, List locations)
    {
      Node n = tw.getCurrentNode();
      System.out.println(n.getNodeName());
	  if (n.getNodeName().equals("locations")) { 
	      for (Node child=tw.firstChild();child!=null;child=tw.nextSibling())
	      {
	    		  traverse(tw,locations);
	      }
	  }
	  else if (n.getNodeName().equals("site")) {
		  NamedNodeMap attrs = n.getAttributes();
		  String address = attrs.getNamedItem("address").getNodeValue();
		  URI uri = URI.createURI(address);
		  locations.add(uri);
		  if (address.equals("workspace")) {
			  String project = attrs.getNamedItem("project").getNodeValue();
			  locations.add(project);
		  }
	  }
	  
	 
	  
	   
		  

      tw.setCurrentNode(n);
    }
    
	
}
