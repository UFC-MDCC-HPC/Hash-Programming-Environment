package ufc.mdcc.hpe.main;

import java.util.StringTokenizer;

import ufc.mdcc.hpe.xml.XMLDOMReader;

public class CmdAnalyser {

	public static void main(String[] args) {
		
		XMLDOMReader xmldomReader = new XMLDOMReader();
		xmldomReader.getHpeCmdController().printTree();
	}
	
	/**
	 * 
	 * @param cmd In command
	 * @return In command as a String array of sub commands
	 */
	public String[] tokenizeCmd(String cmd){
		String[] tokens = null;
		
		StringTokenizer stringTokenizer = new StringTokenizer(cmd," ");
		tokens = new String[stringTokenizer.countTokens()];
		int i = 0;
		while(stringTokenizer.hasMoreTokens()){
			tokens[i++] = stringTokenizer.nextToken();
		}
		
		return tokens; 
	}
	
	//public 
}
