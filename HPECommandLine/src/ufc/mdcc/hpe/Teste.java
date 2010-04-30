package ufc.mdcc.hpe;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeFilter;
import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.dom.DocumentImpl;
import org.apache.xerces.dom.NodeIteratorImpl;


public class Teste
{
  public static void main(String args[])
  {
  
    try
    {
      //create an object of the Document implementation class
      DOMParser parser = new DOMParser();
      parser.parse("src/hpe_cmd.xml");
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
  public static void printElements(NodeIteratorImpl iter)
  {
    Node n;
    List<Node> list = new ArrayList<Node>();
    n = iter.nextNode();
    list.add(n);
    while(list.size()!=0){
    	Node nodeRef = list.remove(0);
    	if(nodeRef.getChildNodes().getLength()==1)
    		System.out.println(nodeRef.getNodeName()+" "+nodeRef.getTextContent());
    	else
    		System.out.println(nodeRef.getNodeName());
    	for(int i=0;i<nodeRef.getChildNodes().getLength();i++){
    		if(!nodeRef.getChildNodes().item(i).getNodeName().equals("#text"))
    			list.add(nodeRef.getChildNodes().item(i));
    	}
    }
     
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
