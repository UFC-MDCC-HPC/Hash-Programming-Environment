package ufc.mdcc.hpe.xml;


import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeFilter;
import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.dom.DocumentImpl;
import org.apache.xerces.dom.NodeIteratorImpl;

import ufc.mdcc.hpe.cmd.HpeCmd;
import ufc.mdcc.hpe.cmd.HpeCmdController;
import ufc.mdcc.hpe.util.HpeTreeNode;


public class XMLDOMReader
{
  private HpeCmdController hpeCmdController =null ;
  private String fileName = "src/hpe_cmd.xml";
  
  public XMLDOMReader(){
	  
	  try
	    {
	      
	      //create an object of the Document implementation class
	      DOMParser parser = new DOMParser();
	      parser.parse(fileName);
	      DocumentImpl document = (DocumentImpl)parser.getDocument();
	      
	      //get the root of the XML document
	      Node root = document.getLastChild();

	      //instantiate a filter
	      AllElements allelements = new AllElements();
			
	      //create an object of the NodeIterator implementation class
	      NodeIteratorImpl iterator =
			(NodeIteratorImpl)document.createNodeIterator(root,
	            NodeFilter.SHOW_ELEMENT, (NodeFilter)allelements, true);

	      
	      //recursively print all elements of the XML document
	      printElements(iterator);

	    }
	    catch (Exception e)
	    {
	      System.out.println("error: " + e);
	      e.printStackTrace();
	      System.exit(0);
	    }
	  
  }

  //recursive function that prints all elements of the XML document
  public void printElements(NodeIteratorImpl iter)
  {
	HpeCmd hpeCmd = null;
	HpeTreeNode parent = null;
	HpeTreeNode hpeTreeNode = null;
    List<Node> list = new ArrayList<Node>();
    List<HpeTreeNode> listHpe = new ArrayList<HpeTreeNode>();
    Node n;
    n = iter.nextNode();
    list.add(n);
    
    
	//alimentando a arvore a partir do XML
    while(list.size()!=0){
		Node nodeRef = list.remove(0);
		
		if(hpeCmdController == null){
			hpeCmd = new HpeCmd();
			hpeCmd.setName(nodeRef.getNodeName());
			hpeTreeNode = new HpeTreeNode(hpeCmd);
			listHpe.add(hpeTreeNode);
			hpeCmdController = new HpeCmdController(hpeTreeNode);
		}
		
		parent =  listHpe.remove(0);
		
		for(int i=0;i<nodeRef.getChildNodes().getLength();i++){
    		Node son = nodeRef.getChildNodes().item(i);
    		if(!son.getNodeName().equals("#text")){
    			
    			hpeCmd = new HpeCmd();
    	    	hpeCmd.setName(son.getNodeName());
    	    	if(son.getChildNodes().getLength()==1)
    	    		hpeCmd.setValue(son.getTextContent());
    	    	hpeTreeNode = new HpeTreeNode(hpeCmd);
    			list.add(son);
    			listHpe.add(hpeTreeNode);
    			
    			hpeCmdController.insertNode(hpeTreeNode, parent);
    			
    		}
    			
    	}
    	 
    
    }
	
	//hpeCmdController.printTree();
	
  }
  
  public HpeCmdController getHpeCmdController() {
		return hpeCmdController;
  }

}

//filters elements in the XML document; Returns all the Element nodes
class AllElements implements NodeFilter
{
  public short acceptNode (Node n)
  {
    if (n.getNodeType() == Node.ELEMENT_NODE)
      return FILTER_ACCEPT;
    return FILTER_SKIP;
  }
}


