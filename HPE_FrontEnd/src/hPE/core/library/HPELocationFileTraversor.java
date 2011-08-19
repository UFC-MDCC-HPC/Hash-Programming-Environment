package hPE.core.library;

import hPE.frontend.backend.locations.Location;
import hPE.frontend.core.locations.LocationManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeFilter;

@Deprecated
/*
 * * Usar o Location Manager.
 */
public class HPELocationFileTraversor {

	private String locationPath;

	protected class AllElements implements NodeFilter {
		public short acceptNode(Node n) {
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

	public List<URI> fetchLocations() {

		List<URI> locations = new ArrayList<URI>();
		Collection<Location> coreLibraries = LocationManager.getInstance()
				.getCoreLocations().values();

		for (Location l : coreLibraries) {
			locations.add(URI.createURI(l.getUri()));
		}

		// try {
		// DOMParser parser = new DOMParser();
		// String path = (new Path(locationPath)).toOSString();
		// parser.parse(path);
		// DocumentImpl document = (DocumentImpl) parser.getDocument();
		//
		// // get the root of the XML document
		// Node root = document.getLastChild();
		//
		// // instantiate the filter object
		// AllElements allelements = new AllElements();
		//
		// // create an object of the TreeWalker implementation class
		// TreeWalkerImpl tw = (TreeWalkerImpl) document.createTreeWalker(
		// root, NodeFilter.SHOW_ALL, (NodeFilter) allelements, true);
		//
		// // print the elements of the TreeWalker implementation class
		// traverse(tw, locations);
		//
		// } catch (org.xml.sax.SAXParseException spe) {
		// } catch (org.xml.sax.SAXNotRecognizedException ex) {
		// } catch (org.xml.sax.SAXNotSupportedException ex) {
		// } catch (org.xml.sax.SAXException se) {
		// if (se.getException() != null)
		// se.getException().printStackTrace(System.err);
		// else
		// se.printStackTrace(System.err);
		// } catch (Exception e) {
		// e.printStackTrace(System.err);
		// }

		return locations;
	}

	@Deprecated
	/*
	 * * return null.
	 */
	private String lookForLocationPath() {

		// return HPEProperties.getInstance().getValue("core_locations");
		return null;
	}
}